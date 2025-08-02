package com.swmansion.reanimated.layoutReanimation;

import java.util.HashMap;

public interface NativeMethodsHolder {
    void cancelAnimation(int i10);

    void checkDuplicateSharedTag(int i10, int i11);

    void clearAnimationConfig(int i10);

    int findPrecedingViewTagForTransition(int i10);

    int[] getSharedGroup(int i10);

    boolean hasAnimation(int i10, int i11);

    boolean isLayoutAnimationEnabled();

    boolean shouldAnimateExiting(int i10, boolean z10);

    void startAnimation(int i10, int i11, HashMap<String, Object> hashMap);
}
