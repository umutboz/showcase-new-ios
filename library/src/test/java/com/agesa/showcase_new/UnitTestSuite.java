/*
 * Copyright (C) 2017 Samuel Wall
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

package com.agesa.showcase_new;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.agesa.showcase_new.extras.AlphaSpanUnitTest;
import com.agesa.showcase_new.extras.PromptOptionsUnitTest;
import com.agesa.showcase_new.extras.PromptTextUnitTest;
import com.agesa.showcase_new.extras.PromptUtilsUnitTest;
import com.agesa.showcase_new.extras.backgrounds.CirclePromptBackgroundUnitTest;
import com.agesa.showcase_new.extras.backgrounds.FullscreenPromptBackgroundUnitTest;
import com.agesa.showcase_new.extras.backgrounds.ImmersiveModeCompatPromptBackgroundUnitTest;
import com.agesa.showcase_new.extras.backgrounds.RectanglePromptBackgroundUnitTest;
import com.agesa.showcase_new.extras.focals.CirclePromptFocalUnitTest;
import com.agesa.showcase_new.extras.focals.RectanglePromptFocalUnitTest;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
    /*AlphaSpanUnitTest.class,
    PromptOptionsUnitTest.class,
    PromptTextUnitTest.class,
    PromptUtilsUnitTest.class,
    CirclePromptBackgroundUnitTest.class,
    RectanglePromptBackgroundUnitTest.class,
    FullscreenPromptBackgroundUnitTest.class,
    ImmersiveModeCompatPromptBackgroundUnitTest.class,
    CirclePromptFocalUnitTest.class,
    RectanglePromptFocalUnitTest.class,
    BuilderUnitTest.class,
    PromptViewUnitTest.class,
    ActivityResourceFinderUnitTest.class,
    DialogResourceFinderUnitTest.class,
    MaterialTapTargetPromptUnitTest.class*/
})
public class UnitTestSuite {}
