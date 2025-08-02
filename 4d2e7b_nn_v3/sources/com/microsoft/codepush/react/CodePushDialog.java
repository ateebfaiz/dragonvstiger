package com.microsoft.codepush.react;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class CodePushDialog extends ReactContextBaseJavaModule {

    class a implements LifecycleEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f10170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f10172c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f10173d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Callback f10174e;

        a(String str, String str2, String str3, String str4, Callback callback) {
            this.f10170a = str;
            this.f10171b = str2;
            this.f10172c = str3;
            this.f10173d = str4;
            this.f10174e = callback;
        }

        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public void onHostResume() {
            Activity access$000 = CodePushDialog.this.getCurrentActivity();
            if (access$000 != null) {
                CodePushDialog.this.getReactApplicationContext().removeLifecycleEventListener(this);
                CodePushDialog.this.showDialogInternal(this.f10170a, this.f10171b, this.f10172c, this.f10173d, this.f10174e, access$000);
            }
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callback f10176a;

        b(Callback callback) {
            this.f10176a = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            try {
                dialogInterface.cancel();
                if (i10 == -2) {
                    this.f10176a.invoke(1);
                } else if (i10 == -1) {
                    this.f10176a.invoke(0);
                } else {
                    throw new g("Unknown button ID pressed.");
                }
            } catch (Throwable th) {
                k.i(th);
            }
        }
    }

    public CodePushDialog(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* access modifiers changed from: private */
    public void showDialogInternal(String str, String str2, String str3, String str4, Callback callback, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        b bVar = new b(callback);
        if (str != null) {
            builder.setTitle(str);
        }
        if (str2 != null) {
            builder.setMessage(str2);
        }
        if (str3 != null) {
            builder.setPositiveButton(str3, bVar);
        }
        if (str4 != null) {
            builder.setNegativeButton(str4, bVar);
        }
        builder.create().show();
    }

    public String getName() {
        return "CodePushDialog";
    }

    @ReactMethod
    public void showDialog(String str, String str2, String str3, String str4, Callback callback, Callback callback2) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            getReactApplicationContext().addLifecycleEventListener(new a(str, str2, str3, str4, callback));
        } else {
            showDialogInternal(str, str2, str3, str4, callback, currentActivity);
        }
    }
}
