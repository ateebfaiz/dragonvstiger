package d1;

import android.content.Context;
import c1.a;
import c1.s;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class c extends a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f21015c;

    public c(Context context, a aVar) {
        super(aVar, (s) null, 2, (DefaultConstructorMarker) null);
        this.f21015c = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    public final Context a() {
        return this.f21015c;
    }
}
