package com.onesignal;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.o3;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

class j4 extends i4 {

    /* renamed from: f  reason: collision with root package name */
    private FirebaseApp f10730f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f10731g;

    /* renamed from: h  reason: collision with root package name */
    private final a f10732h;

    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f10733a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f10734b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final String f10735c;

        a() {
            this((String) null, (String) null, (String) null);
        }

        a(String str, String str2, String str3) {
            this.f10733a = str == null ? "onesignal-shared-public" : str;
            this.f10734b = str2 == null ? "1:754795614042:android:c682b8144a8dd52bc1ad63" : str2;
            this.f10735c = str3 == null ? new String(Base64.decode("QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV", 0)) : str3;
        }
    }

    j4(Context context, a aVar) {
        this.f10731g = context;
        if (aVar == null) {
            this.f10732h = new a();
        } else {
            this.f10732h = aVar;
        }
    }

    private String l(String str) {
        try {
            Object invoke = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getMethod("getInstance", new Class[]{FirebaseApp.class}).invoke((Object) null, new Object[]{this.f10730f});
            Class<String> cls = String.class;
            return (String) invoke.getClass().getMethod("getToken", new Class[]{cls, cls}).invoke(invoke, new Object[]{str, FirebaseMessaging.INSTANCE_ID_SCOPE});
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", e10);
        }
    }

    private String m() {
        Task token = ((FirebaseMessaging) this.f10730f.get(FirebaseMessaging.class)).getToken();
        try {
            return (String) Tasks.await(token);
        } catch (ExecutionException unused) {
            throw token.getException();
        }
    }

    private void n(String str) {
        if (this.f10730f == null) {
            this.f10730f = FirebaseApp.initializeApp(this.f10731g, new FirebaseOptions.Builder().setGcmSenderId(str).setApplicationId(this.f10732h.f10734b).setApiKey(this.f10732h.f10735c).setProjectId(this.f10732h.f10733a).build(), "ONESIGNAL_SDK_FCM_APP_NAME");
        }
    }

    /* access modifiers changed from: package-private */
    public String f() {
        return FirebaseMessaging.INSTANCE_ID_SCOPE;
    }

    /* access modifiers changed from: package-private */
    public String g(String str) {
        n(str);
        try {
            return m();
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
            o3.a(o3.v.INFO, "FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken");
            return l(str);
        }
    }
}
