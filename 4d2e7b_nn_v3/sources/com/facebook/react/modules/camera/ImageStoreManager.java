package com.facebook.react.modules.camera;

import android.net.Uri;
import android.util.Base64OutputStream;
import com.facebook.fbreact.specs.NativeImageStoreAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "ImageStoreManager")
public final class ImageStoreManager extends NativeImageStoreAndroidSpec {
    private static final int BUFFER_SIZE = 8192;
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String NAME = "ImageStoreManager";

    public static final class a {
        private a() {
        }

        /* access modifiers changed from: private */
        public final void b(Closeable closeable) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }

        /* JADX INFO: finally extract failed */
        public final String c(InputStream inputStream) {
            m.f(inputStream, "inputStream");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > -1) {
                        base64OutputStream.write(bArr, 0, read);
                    } else {
                        b(base64OutputStream);
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        m.e(byteArrayOutputStream2, "toString(...)");
                        return byteArrayOutputStream2;
                    }
                } catch (Throwable th) {
                    b(base64OutputStream);
                    throw th;
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageStoreManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        m.f(reactApplicationContext, "reactContext");
    }

    /* access modifiers changed from: private */
    public static final void getBase64ForTag$lambda$0(ImageStoreManager imageStoreManager, String str, Callback callback, Callback callback2) {
        InputStream openInputStream;
        a aVar;
        m.f(imageStoreManager, "this$0");
        m.f(str, "$uri");
        m.f(callback, "$success");
        m.f(callback2, "$error");
        try {
            openInputStream = imageStoreManager.getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
            m.d(openInputStream, "null cannot be cast to non-null type java.io.InputStream");
            try {
                aVar = Companion;
                callback.invoke(aVar.c(openInputStream));
            } catch (IOException e10) {
                callback2.invoke(e10.getMessage());
                aVar = Companion;
            }
            aVar.b(openInputStream);
        } catch (FileNotFoundException e11) {
            callback2.invoke(e11.getMessage());
        } catch (Throwable th) {
            Companion.b(openInputStream);
            throw th;
        }
    }

    public void getBase64ForTag(String str, Callback callback, Callback callback2) {
        m.f(str, "uri");
        m.f(callback, FirebaseAnalytics.Param.SUCCESS);
        m.f(callback2, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
        Executors.newSingleThreadExecutor().execute(new v6.a(this, str, callback, callback2));
    }
}
