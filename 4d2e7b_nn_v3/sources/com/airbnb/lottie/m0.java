package com.airbnb.lottie;

import android.os.Build;
import java.util.HashSet;
import y0.f;

class m0 {

    /* renamed from: a  reason: collision with root package name */
    private final HashSet f17720a = new HashSet();

    m0() {
    }

    public boolean a(l0 l0Var, boolean z10) {
        if (!z10) {
            return this.f17720a.remove(l0Var);
        }
        if (Build.VERSION.SDK_INT >= l0Var.f17718a) {
            return this.f17720a.add(l0Var);
        }
        f.c(String.format("%s is not supported pre SDK %d", new Object[]{l0Var.name(), Integer.valueOf(l0Var.f17718a)}));
        return false;
    }

    public boolean b(l0 l0Var) {
        return this.f17720a.contains(l0Var);
    }
}
