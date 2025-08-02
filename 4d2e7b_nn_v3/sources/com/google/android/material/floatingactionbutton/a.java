package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

class a {

    /* renamed from: a  reason: collision with root package name */
    private Animator f8231a;

    a() {
    }

    public void a() {
        Animator animator = this.f8231a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f8231a = null;
    }

    public void c(Animator animator) {
        a();
        this.f8231a = animator;
    }
}
