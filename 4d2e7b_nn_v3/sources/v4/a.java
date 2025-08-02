package v4;

import android.content.Context;
import kotlin.jvm.internal.m;
import okhttp3.OkHttpClient;
import z4.l;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f24394a = new a();

    private a() {
    }

    public static final l.a a(Context context, OkHttpClient okHttpClient) {
        m.f(context, "context");
        m.f(okHttpClient, "okHttpClient");
        return l.M.i(context).R(new b(okHttpClient));
    }
}
