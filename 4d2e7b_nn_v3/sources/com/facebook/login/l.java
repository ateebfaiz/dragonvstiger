package com.facebook.login;

import kotlin.text.j;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f20548a = new l();

    private l() {
    }

    public static final boolean a(String str) {
        boolean z10 = false;
        if (str == null || str.length() == 0) {
            return false;
        }
        if (j.U(str, ' ', 0, false, 6, (Object) null) >= 0) {
            z10 = true;
        }
        return !z10;
    }
}
