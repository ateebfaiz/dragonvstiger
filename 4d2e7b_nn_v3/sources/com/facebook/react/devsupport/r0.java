package com.facebook.react.devsupport;

import java.io.IOException;
import java.util.Locale;
import k6.g;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f3152a;

    class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f3153a;

        a(g gVar) {
            this.f3153a = gVar;
        }

        public void onFailure(Call call, IOException iOException) {
            z2.a.G("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + iOException.getMessage());
            this.f3153a.a(false);
        }

        public void onResponse(Call call, Response response) {
            if (!response.isSuccessful()) {
                z2.a.j("ReactNative", "Got non-success http code from packager when requesting status: " + response.code());
                this.f3153a.a(false);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                z2.a.j("ReactNative", "Got null body response from packager when requesting status");
                this.f3153a.a(false);
                return;
            }
            String string = body.string();
            if (!"packager-status:running".equals(string)) {
                z2.a.j("ReactNative", "Got unexpected response from packager when requesting status: " + string);
                this.f3153a.a(false);
                return;
            }
            this.f3153a.a(true);
        }
    }

    public r0(OkHttpClient okHttpClient) {
        this.f3152a = okHttpClient;
    }

    private static String a(String str) {
        return String.format(Locale.US, "http://%s/status", new Object[]{str});
    }

    public void b(String str, g gVar) {
        this.f3152a.newCall(new Request.Builder().url(a(str)).build()).enqueue(new a(gVar));
    }
}
