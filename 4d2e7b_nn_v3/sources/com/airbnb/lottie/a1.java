package com.airbnb.lottie;

import java.util.HashMap;
import java.util.Map;

public class a1 {

    /* renamed from: a  reason: collision with root package name */
    private final Map f17624a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f17625b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f17626c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17627d = true;

    public a1(LottieAnimationView lottieAnimationView) {
        this.f17625b = lottieAnimationView;
        this.f17626c = null;
    }

    private void d() {
        LottieAnimationView lottieAnimationView = this.f17625b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        k0 k0Var = this.f17626c;
        if (k0Var != null) {
            k0Var.invalidateSelf();
        }
    }

    public String a(String str) {
        return str;
    }

    public String b(String str, String str2) {
        return a(str2);
    }

    public final String c(String str, String str2) {
        if (this.f17627d && this.f17624a.containsKey(str2)) {
            return (String) this.f17624a.get(str2);
        }
        String b10 = b(str, str2);
        if (this.f17627d) {
            this.f17624a.put(str2, b10);
        }
        return b10;
    }

    public void e(String str, String str2) {
        this.f17624a.put(str, str2);
        d();
    }
}
