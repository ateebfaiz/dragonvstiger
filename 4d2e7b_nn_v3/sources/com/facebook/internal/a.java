package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;
import q5.c;
import q5.f0;
import q5.p0;

public final class a extends WebDialog {
    private static final String O0;
    public static final C0256a P0 = new C0256a((DefaultConstructorMarker) null);
    private boolean N0;

    /* renamed from: com.facebook.internal.a$a  reason: collision with other inner class name */
    public static final class C0256a {
        private C0256a() {
        }

        public final a a(Context context, String str, String str2) {
            m.f(context, "context");
            m.f(str, ImagesContract.URL);
            m.f(str2, "expectedRedirectUrl");
            WebDialog.Z.b(context);
            return new a(context, str, str2, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ C0256a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f20369a;

        b(a aVar) {
            this.f20369a = aVar;
        }

        public final void run() {
            if (!v5.a.d(this)) {
                try {
                    a.super.cancel();
                } catch (Throwable th) {
                    v5.a.b(th, this);
                }
            }
        }
    }

    static {
        String name = a.class.getName();
        m.e(name, "FacebookWebFallbackDialog::class.java.name");
        O0 = name;
    }

    public /* synthetic */ a(Context context, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2);
    }

    public void cancel() {
        WebView n10 = n();
        if (!p() || o() || n10 == null || !n10.isShown()) {
            super.cancel();
        } else if (!this.N0) {
            this.N0 = true;
            n10.loadUrl("javascript:" + "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();");
            new Handler(Looper.getMainLooper()).postDelayed(new b(this), (long) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
    }

    public Bundle r(String str) {
        Uri parse = Uri.parse(str);
        m.e(parse, "responseUri");
        Bundle l02 = p0.l0(parse.getQuery());
        String string = l02.getString("bridge_args");
        l02.remove("bridge_args");
        if (!p0.Y(string)) {
            try {
                l02.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", c.a(new JSONObject(string)));
            } catch (JSONException e10) {
                p0.g0(O0, "Unable to parse bridge_args JSON", e10);
            }
        }
        String string2 = l02.getString("method_results");
        l02.remove("method_results");
        if (!p0.Y(string2)) {
            try {
                l02.putBundle("com.facebook.platform.protocol.RESULT_ARGS", c.a(new JSONObject(string2)));
            } catch (JSONException e11) {
                p0.g0(O0, "Unable to parse bridge_args JSON", e11);
            }
        }
        l02.remove("version");
        l02.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", f0.z());
        return l02;
    }

    private a(Context context, String str, String str2) {
        super(context, str);
        v(str2);
    }
}
