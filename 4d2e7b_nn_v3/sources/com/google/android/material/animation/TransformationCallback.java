package com.google.android.material.animation;

import android.view.View;

public interface TransformationCallback<T extends View> {
    void onScaleChanged(T t10);

    void onTranslationChanged(T t10);
}
