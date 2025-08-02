package e9;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import java.util.Map;

class s implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private String f12044a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f12045b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f12046c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f12047d;

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final s f12048a = new s();
    }

    private static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    private r c(FragmentManager fragmentManager, String str) {
        return d(fragmentManager, str, false);
    }

    private r d(FragmentManager fragmentManager, String str, boolean z10) {
        r rVar = (r) fragmentManager.findFragmentByTag(str);
        if (rVar == null && (rVar = (r) this.f12046c.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            rVar = new r();
            this.f12046c.put(fragmentManager, rVar);
            fragmentManager.beginTransaction().add(rVar, str).commitAllowingStateLoss();
            this.f12045b.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return rVar;
        }
        fragmentManager.beginTransaction().remove(rVar).commitAllowingStateLoss();
        return null;
    }

    static s e() {
        return b.f12048a;
    }

    private u f(androidx.fragment.app.FragmentManager fragmentManager, String str) {
        return g(fragmentManager, str, false);
    }

    private u g(androidx.fragment.app.FragmentManager fragmentManager, String str, boolean z10) {
        u uVar = (u) fragmentManager.findFragmentByTag(str);
        if (uVar == null && (uVar = (u) this.f12047d.get(fragmentManager)) == null) {
            if (z10) {
                return null;
            }
            uVar = new u();
            this.f12047d.put(fragmentManager, uVar);
            fragmentManager.beginTransaction().add((Fragment) uVar, str).commitAllowingStateLoss();
            this.f12045b.obtainMessage(2, fragmentManager).sendToTarget();
        }
        if (!z10) {
            return uVar;
        }
        fragmentManager.beginTransaction().remove(uVar).commitAllowingStateLoss();
        return null;
    }

    public h b(Activity activity) {
        a(activity, "activity is null");
        String str = this.f12044a + System.identityHashCode(activity);
        if (activity instanceof FragmentActivity) {
            return f(((FragmentActivity) activity).getSupportFragmentManager(), str).o(activity);
        }
        return c(activity.getFragmentManager(), str).a(activity);
    }

    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            this.f12046c.remove((FragmentManager) message.obj);
            return true;
        } else if (i10 != 2) {
            return false;
        } else {
            this.f12047d.remove((androidx.fragment.app.FragmentManager) message.obj);
            return true;
        }
    }

    private s() {
        this.f12044a = h.class.getName();
        this.f12046c = new HashMap();
        this.f12047d = new HashMap();
        this.f12045b = new Handler(Looper.getMainLooper(), this);
    }
}
