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

import android.app.Activity;
import android.content.res.TypedArray;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import android.view.View;
import android.view.ViewGroup;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestResourceFinder extends ActivityResourceFinder
{
    private ViewGroup mParentView;
    private TypedArray mStyledAttributes;

    public TestResourceFinder(@NonNull final Activity activity)
    {
        super(activity);
        mParentView = mock(ViewGroup.class);
        mStyledAttributes = mock(TypedArray.class);
        addFindByView(android.R.id.content, activity.findViewById(android.R.id.content));
    }

    public void addFindByView(@IdRes int id, View view)
    {
        when(mParentView.findViewById(id)).thenReturn(view);
    }

    @NonNull
    @Override
    public ViewGroup getPromptParentView()
    {
        return mParentView;
    }

    @NonNull
    @Override
    public TypedArray obtainStyledAttributes(@StyleRes int resId, @StyleableRes int[] attrs)
    {
        return mStyledAttributes;
    }

    @Nullable
    @Override
    public View findViewById(@IdRes int id)
    {
        return mParentView.findViewById(id);
    }
}
