package e9;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

final class k extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f12035a;

    /* renamed from: b  reason: collision with root package name */
    private Application f12036b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f12037c;

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final k f12038a = new k();
    }

    static k a() {
        return b.f12038a;
    }

    /* access modifiers changed from: package-private */
    public void b(Application application) {
        Uri uri;
        this.f12036b = application;
        if (application != null && application.getContentResolver() != null && !this.f12037c.booleanValue()) {
            if (o.l()) {
                uri = Settings.Global.getUriFor("force_fsg_nav_bar");
            } else if (!o.f()) {
                uri = null;
            } else if (!o.i()) {
                uri = Settings.Global.getUriFor("navigationbar_is_min");
            } else {
                uri = Settings.System.getUriFor("navigationbar_is_min");
            }
            if (uri != null) {
                this.f12036b.getContentResolver().registerContentObserver(uri, true, this);
                this.f12037c = Boolean.TRUE;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(p pVar) {
        ArrayList arrayList;
        if (pVar != null && (arrayList = this.f12035a) != null) {
            arrayList.remove(pVar);
        }
    }

    public void onChange(boolean z10) {
        ArrayList arrayList;
        int i10;
        super.onChange(z10);
        Application application = this.f12036b;
        if (application != null && application.getContentResolver() != null && (arrayList = this.f12035a) != null && !arrayList.isEmpty()) {
            if (o.l()) {
                i10 = Settings.Global.getInt(this.f12036b.getContentResolver(), "force_fsg_nav_bar", 0);
            } else if (!o.f()) {
                i10 = 0;
            } else if (!o.i()) {
                i10 = Settings.Global.getInt(this.f12036b.getContentResolver(), "navigationbar_is_min", 0);
            } else {
                i10 = Settings.System.getInt(this.f12036b.getContentResolver(), "navigationbar_is_min", 0);
            }
            Iterator it = this.f12035a.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                boolean z11 = true;
                if (i10 == 1) {
                    z11 = false;
                }
                pVar.a(z11);
            }
        }
    }

    private k() {
        super(new Handler(Looper.getMainLooper()));
        this.f12037c = Boolean.FALSE;
    }
}
