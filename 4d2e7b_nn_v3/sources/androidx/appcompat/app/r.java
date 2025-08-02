package androidx.appcompat.app;

import androidx.appcompat.app.s;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s.a f13974a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f13975b;

    public /* synthetic */ r(s.a aVar, Runnable runnable) {
        this.f13974a = aVar;
        this.f13975b = runnable;
    }

    public final void run() {
        this.f13974a.b(this.f13975b);
    }
}
