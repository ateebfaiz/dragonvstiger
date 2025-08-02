package q5;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.m;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f23511a;

    /* renamed from: b  reason: collision with root package name */
    private android.app.Fragment f23512b;

    public u(Fragment fragment) {
        m.f(fragment, "fragment");
        this.f23511a = fragment;
    }

    public final Activity a() {
        Fragment fragment = this.f23511a;
        if (fragment == null) {
            android.app.Fragment fragment2 = this.f23512b;
            if (fragment2 != null) {
                return fragment2.getActivity();
            }
            return null;
        } else if (fragment != null) {
            return fragment.getActivity();
        } else {
            return null;
        }
    }

    public final android.app.Fragment b() {
        return this.f23512b;
    }

    public final Fragment c() {
        return this.f23511a;
    }

    public final void d(Intent intent, int i10) {
        Fragment fragment = this.f23511a;
        if (fragment == null) {
            android.app.Fragment fragment2 = this.f23512b;
            if (fragment2 != null) {
                fragment2.startActivityForResult(intent, i10);
            }
        } else if (fragment != null) {
            fragment.startActivityForResult(intent, i10);
        }
    }

    public u(android.app.Fragment fragment) {
        m.f(fragment, "fragment");
        this.f23512b = fragment;
    }
}
