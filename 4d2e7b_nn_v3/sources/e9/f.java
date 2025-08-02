package e9;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

final class f extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f12001a;

    /* renamed from: b  reason: collision with root package name */
    private Application f12002b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f12003c;

    private static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final f f12004a = new f();
    }

    static f b() {
        return b.f12004a;
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        if (iVar != null) {
            if (this.f12001a == null) {
                this.f12001a = new ArrayList();
            }
            if (!this.f12001a.contains(iVar)) {
                this.f12001a.add(iVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(Application application) {
        Uri uriFor;
        this.f12002b = application;
        if (application != null && application.getContentResolver() != null && !this.f12003c.booleanValue() && (uriFor = Settings.System.getUriFor("navigationbar_is_min")) != null) {
            this.f12002b.getContentResolver().registerContentObserver(uriFor, true, this);
            this.f12003c = Boolean.TRUE;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(i iVar) {
        ArrayList arrayList;
        if (iVar != null && (arrayList = this.f12001a) != null) {
            arrayList.remove(iVar);
        }
    }

    public void onChange(boolean z10) {
        ArrayList arrayList;
        super.onChange(z10);
        Application application = this.f12002b;
        if (application != null && application.getContentResolver() != null && (arrayList = this.f12001a) != null && !arrayList.isEmpty()) {
            int i10 = Settings.System.getInt(this.f12002b.getContentResolver(), "navigationbar_is_min", 0);
            Iterator it = this.f12001a.iterator();
            while (it.hasNext()) {
                i iVar = (i) it.next();
                boolean z11 = true;
                if (i10 == 1) {
                    z11 = false;
                }
                iVar.a(z11);
            }
        }
    }

    private f() {
        super(new Handler(Looper.getMainLooper()));
        this.f12003c = Boolean.FALSE;
    }
}
