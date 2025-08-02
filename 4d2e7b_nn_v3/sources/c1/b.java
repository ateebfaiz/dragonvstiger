package c1;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f17213a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f17214b;

    public /* synthetic */ b(String str, s sVar) {
        this.f17213a = str;
        this.f17214b = sVar;
    }

    public final Thread newThread(Runnable runnable) {
        return c.c(this.f17213a, this.f17214b, runnable);
    }
}
