package com.google.android.material.slider;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface BaseOnSliderTouchListener<S> {
    void onStartTrackingTouch(@NonNull S s10);

    void onStopTrackingTouch(@NonNull S s10);
}
