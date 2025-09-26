/*
 * Copyright (C) 2016-2018 Samuel Wall
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.agesa.showcase_new.extras.sequence;

import android.os.Build;
import android.os.Looper;

import androidx.annotation.NonNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.TimeUnit;

import com.agesa.showcase_new.BaseTestStateProgress;
import com.agesa.showcase_new.MaterialTapTargetPrompt;
import com.agesa.showcase_new.MaterialTapTargetPromptUnitTest;
import com.agesa.showcase_new.UnitTestUtils;
import com.agesa.showcase_new.extras.PromptOptions;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP_MR1)
public class SequenceItemShowForTest extends BaseTestStateProgress
{
    @Test
    public void testShowFor()
    {
        expectedStateProgress = 5;
        final PromptOptions promptOptions = UnitTestUtils.createPromptOptions()
                .setTarget(10, 10)
                .setPrimaryText("Primary text")
                .setPromptStateChangeListener(new MaterialTapTargetPrompt.PromptStateChangeListener()
                {
                    @Override
                    public void onPromptStateChanged(@NonNull final MaterialTapTargetPrompt prompt, final int state)
                    {
                        if (actualStateProgress == 0)
                        {
                            assertEquals(MaterialTapTargetPrompt.STATE_REVEALING, state);
                            assertEquals(MaterialTapTargetPrompt.STATE_REVEALING, prompt.getState());
                        }
                        else if (actualStateProgress == 1)
                        {
                            assertEquals(MaterialTapTargetPrompt.STATE_REVEALED, state);
                            assertEquals(MaterialTapTargetPrompt.STATE_REVEALED, prompt.getState());
                            UnitTestUtils.runPromptMainLooperTimeOut(prompt);
                        }
                        else if (actualStateProgress == 2)
                        {
                            assertEquals(MaterialTapTargetPrompt.STATE_SHOW_FOR_TIMEOUT, state);
                            assertEquals(MaterialTapTargetPrompt.STATE_SHOW_FOR_TIMEOUT, prompt.getState());
                        }
                        else if (actualStateProgress == 3)
                        {
                            assertEquals(MaterialTapTargetPrompt.STATE_DISMISSING, state);
                            assertEquals(MaterialTapTargetPrompt.STATE_DISMISSING, prompt.getState());
                            UnitTestUtils.endCurrentAnimation(prompt);
                        }
                        else if (actualStateProgress == 4)
                        {
                            assertEquals(MaterialTapTargetPrompt.STATE_DISMISSED, state);
                            assertEquals(MaterialTapTargetPrompt.STATE_DISMISSED, prompt.getState());
                        }
                        else
                        {
                            fail(String.format("Incorrect state progress %s for state %s",
                                    actualStateProgress, state));
                        }
                        actualStateProgress++;
                    }
                });
        final SequenceItem sequenceItem = new SequenceItemShowFor(new SequenceStatePromptOptions(promptOptions), 1000);
        sequenceItem.show();
        assertEquals(1, actualStateProgress);
        shadowOf(Looper.getMainLooper()).idleFor(1, TimeUnit.SECONDS);
    }
}
