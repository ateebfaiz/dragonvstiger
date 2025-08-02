package d1;

import android.app.ActivityManager;
import android.os.storage.StorageManager;
import c1.a;
import c1.s;
import com.bugsnag.android.l0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class f extends a {

    /* renamed from: c  reason: collision with root package name */
    private final StorageManager f21020c;

    /* renamed from: d  reason: collision with root package name */
    private final ActivityManager f21021d;

    public f(c cVar, a aVar) {
        super(aVar, (s) null, 2, (DefaultConstructorMarker) null);
        this.f21020c = l0.d(cVar.a());
        this.f21021d = l0.a(cVar.a());
    }

    public final ActivityManager a() {
        return this.f21021d;
    }

    public final StorageManager b() {
        return this.f21020c;
    }
}
