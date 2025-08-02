package com.geetest.core;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

public class p5 implements c5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f6137a;

    /* renamed from: b  reason: collision with root package name */
    public final KeyguardManager f6138b;

    public p5(Context context) {
        this.f6137a = context;
        this.f6138b = (KeyguardManager) context.getSystemService("keyguard");
    }

    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f6137a == null || (keyguardManager = this.f6138b) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", (Class[]) null).invoke(this.f6138b, (Object[]) null);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(b5 b5Var) {
        if (this.f6137a != null && b5Var != null) {
            KeyguardManager keyguardManager = this.f6138b;
            if (keyguardManager == null) {
                new d5("KeyguardManager not found");
                ((z4) b5Var).f6235b.countDown();
                return;
            }
            try {
                Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", (Class[]) null).invoke(this.f6138b, (Object[]) null);
                if (invoke != null) {
                    ((z4) b5Var).a(invoke.toString());
                    return;
                }
                throw new d5("OAID obtain failed");
            } catch (Exception unused) {
            }
        }
    }
}
