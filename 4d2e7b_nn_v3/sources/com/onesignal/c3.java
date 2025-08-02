package com.onesignal;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.onesignal.a;
import com.onesignal.o3;
import java.lang.ref.WeakReference;
import java.util.List;

class c3 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f10452b = "com.onesignal.c3";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final c f10453a;

    class a extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FragmentManager f10454a;

        a(FragmentManager fragmentManager) {
            this.f10454a = fragmentManager;
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
            super.onFragmentDetached(fragmentManager, fragment);
            if (fragment instanceof DialogFragment) {
                this.f10454a.unregisterFragmentLifecycleCallbacks(this);
                c3.this.f10453a.c();
            }
        }
    }

    interface b {
        void a(String str, a.c cVar);
    }

    interface c {
        void c();
    }

    c3(c cVar) {
        this.f10453a = cVar;
    }

    /* access modifiers changed from: package-private */
    public boolean b(Context context) {
        if (!(context instanceof AppCompatActivity)) {
            return false;
        }
        FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
        supportFragmentManager.registerFragmentLifecycleCallbacks(new a(supportFragmentManager), true);
        List<Fragment> fragments = supportFragmentManager.getFragments();
        int size = fragments.size();
        if (size <= 0) {
            return false;
        }
        Fragment fragment = fragments.get(size - 1);
        if (!fragment.isVisible() || !(fragment instanceof DialogFragment)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        if (o3.Q() == null) {
            o3.d1(o3.v.WARN, "OSSystemConditionObserver curActivity null");
            return false;
        }
        try {
            if (b(o3.Q())) {
                o3.d1(o3.v.WARN, "OSSystemConditionObserver dialog fragment detected");
                return false;
            }
        } catch (NoClassDefFoundError e10) {
            o3.v vVar = o3.v.INFO;
            o3.d1(vVar, "AppCompatActivity is not used in this app, skipping 'isDialogFragmentShowing' check: " + e10);
        }
        a b10 = b.b();
        boolean j10 = m3.j(new WeakReference(o3.Q()));
        if (j10 && b10 != null) {
            b10.d(f10452b, this.f10453a);
            o3.d1(o3.v.WARN, "OSSystemConditionObserver keyboard up detected");
        }
        return !j10;
    }
}
