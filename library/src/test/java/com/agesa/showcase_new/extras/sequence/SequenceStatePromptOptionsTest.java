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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import com.agesa.showcase_new.UnitTestUtils;
import com.agesa.showcase_new.extras.PromptOptions;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP_MR1)
public class SequenceStatePromptOptionsTest
{
    @Test
    public void testConstructor()
    {
        final PromptOptions promptOptions = UnitTestUtils.createPromptOptions()
                .setTarget(32, 43)
                .setPrimaryText("Test");
        final SequenceStatePromptOptions sequenceStatePromptOptions = new SequenceStatePromptOptions(promptOptions);
        assertNotNull(sequenceStatePromptOptions.getPrompt());
        assertNotNull(sequenceStatePromptOptions.getPrompt());
    }
}
