package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

interface f {
    void a();

    void b();

    int c();

    void d();

    MotionSpec e();

    boolean f();

    void g(Animator.AnimatorListener animatorListener);

    void h(Animator.AnimatorListener animatorListener);

    void i(MotionSpec motionSpec);

    AnimatorSet j();

    List k();

    void l(ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
