package z8;

import android.content.Context;
import com.geetest.core.e6;
import com.geetest.core.g6;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g6 f13460a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13461b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e6 f13462c;

    public /* synthetic */ h(g6 g6Var, Context context, e6 e6Var) {
        this.f13460a = g6Var;
        this.f13461b = context;
        this.f13462c = e6Var;
    }

    public final void run() {
        this.f13460a.c(this.f13461b, this.f13462c);
    }
}
