package h2;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import kotlin.text.h;
import v5.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f21881a = new d();

    private d() {
    }

    private final boolean a(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            String d10 = new h("\\s").d(f.k(textView), "");
            int length = d10.length();
            if (length < 12) {
                return false;
            }
            if (length > 19) {
                return false;
            }
            int i10 = 0;
            boolean z10 = false;
            for (int i11 = length - 1; i11 >= 0; i11--) {
                char charAt = d10.charAt(i11);
                if (!Character.isDigit(charAt)) {
                    return false;
                }
                int d11 = kotlin.text.a.d(charAt);
                if (z10 && (d11 = d11 * 2) > 9) {
                    d11 = (d11 % 10) + 1;
                }
                i10 += d11;
                z10 = !z10;
            }
            if (i10 % 10 == 0) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final boolean b(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 32) {
                return true;
            }
            String k10 = f.k(textView);
            if (k10 == null) {
                return false;
            }
            if (k10.length() == 0) {
                return false;
            }
            return Patterns.EMAIL_ADDRESS.matcher(k10).matches();
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final boolean c(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 128) {
                return true;
            }
            return textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final boolean d(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 96) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final boolean e(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 3) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    private final boolean f(TextView textView) {
        if (a.d(this)) {
            return false;
        }
        try {
            if (textView.getInputType() == 112) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a.b(th, this);
            return false;
        }
    }

    public static final boolean g(View view) {
        Class<d> cls = d.class;
        if (a.d(cls)) {
            return false;
        }
        try {
            if (!(view instanceof TextView)) {
                return false;
            }
            d dVar = f21881a;
            if (dVar.c((TextView) view) || dVar.a((TextView) view) || dVar.d((TextView) view) || dVar.f((TextView) view) || dVar.e((TextView) view) || dVar.b((TextView) view)) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            a.b(th, cls);
            return false;
        }
    }
}
