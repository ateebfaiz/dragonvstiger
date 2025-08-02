package com.facebook.react.uimanager;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f3817a = new n();

    private n() {
    }

    public static final boolean a(float f10, float f11) {
        if (Float.isNaN(f10) || Float.isNaN(f11)) {
            if (!Float.isNaN(f10) || !Float.isNaN(f11)) {
                return false;
            }
        } else if (Math.abs(f11 - f10) >= 1.0E-5f) {
            return false;
        }
        return true;
    }
}
