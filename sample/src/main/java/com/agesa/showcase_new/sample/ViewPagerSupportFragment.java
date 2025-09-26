/*
 * Copyright (C) 2016-2019 Samuel Wall
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

package com.agesa.showcase_new.sample;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.agesa.showcase_new.MaterialTapTargetPrompt;

public class ViewPagerSupportFragment extends Fragment
{
    @NonNull
    private DialogFragment dialogFragment;

    static ViewPagerSupportFragment newInstance(@NonNull DialogFragment dialogFragment)
    {
        ViewPagerSupportFragment fragment = new ViewPagerSupportFragment();
        fragment.dialogFragment = dialogFragment;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        view.findViewById(R.id.button)
            .setOnClickListener(v -> showPrompt());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        showPrompt();
    }

    private void showPrompt()
    {
        new MaterialTapTargetPrompt.Builder(dialogFragment)
                .setTarget(R.id.button)
                .setAnimationInterpolator(new FastOutSlowInInterpolator())
                .setPrimaryText("Clipped to dialog bounds")
                .setSecondaryText("The prompt does not draw outside the dialog")
                .setClipToView(null)
                .show();
    }
}
