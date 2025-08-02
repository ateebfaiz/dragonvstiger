package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import e6.f;
import java.util.Map;

@s6.a(name = "DialogManagerAndroid")
public class DialogModule extends NativeDialogManagerAndroidSpec implements LifecycleEventListener {
    static final String ACTION_BUTTON_CLICKED = "buttonClicked";
    static final String ACTION_DISMISSED = "dismissed";
    static final Map<String, Object> CONSTANTS = f.h(ACTION_BUTTON_CLICKED, ACTION_BUTTON_CLICKED, ACTION_DISMISSED, ACTION_DISMISSED, KEY_BUTTON_POSITIVE, -1, KEY_BUTTON_NEGATIVE, -2, KEY_BUTTON_NEUTRAL, -3);
    static final String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
    static final String KEY_BUTTON_NEGATIVE = "buttonNegative";
    static final String KEY_BUTTON_NEUTRAL = "buttonNeutral";
    static final String KEY_BUTTON_POSITIVE = "buttonPositive";
    static final String KEY_CANCELABLE = "cancelable";
    static final String KEY_ITEMS = "items";
    static final String KEY_MESSAGE = "message";
    static final String KEY_TITLE = "title";
    /* access modifiers changed from: private */
    public boolean mIsInForeground;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3277a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f3278b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f3279c;

        a(c cVar, Bundle bundle, Callback callback) {
            this.f3277a = cVar;
            this.f3278b = bundle;
            this.f3279c = callback;
        }

        public void run() {
            this.f3277a.b(this.f3278b, this.f3279c);
        }
    }

    class b implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        private final Callback f3281a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f3282b = false;

        public b(Callback callback) {
            this.f3281a = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            if (!this.f3282b && DialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                this.f3281a.invoke(DialogModule.ACTION_BUTTON_CLICKED, Integer.valueOf(i10));
                this.f3282b = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.f3282b && DialogModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                this.f3281a.invoke(DialogModule.ACTION_DISMISSED);
                this.f3282b = true;
            }
        }
    }

    private class c {

        /* renamed from: a  reason: collision with root package name */
        private final FragmentManager f3284a;

        /* renamed from: b  reason: collision with root package name */
        private Object f3285b;

        public c(FragmentManager fragmentManager) {
            this.f3284a = fragmentManager;
        }

        private void a() {
            a aVar;
            if (DialogModule.this.mIsInForeground && (aVar = (a) this.f3284a.findFragmentByTag(DialogModule.FRAGMENT_TAG)) != null && aVar.isResumed()) {
                aVar.dismiss();
            }
        }

        public void b(Bundle bundle, Callback callback) {
            b bVar;
            UiThreadUtil.assertOnUiThread();
            a();
            if (callback != null) {
                bVar = new b(callback);
            } else {
                bVar = null;
            }
            a aVar = new a(bVar, bundle);
            if (!DialogModule.this.mIsInForeground || this.f3284a.isStateSaved()) {
                this.f3285b = aVar;
                return;
            }
            if (bundle.containsKey(DialogModule.KEY_CANCELABLE)) {
                aVar.setCancelable(bundle.getBoolean(DialogModule.KEY_CANCELABLE));
            }
            aVar.show(this.f3284a, DialogModule.FRAGMENT_TAG);
        }

        public void c() {
            UiThreadUtil.assertOnUiThread();
            SoftAssertions.assertCondition(DialogModule.this.mIsInForeground, "showPendingAlert() called in background");
            if (this.f3285b != null) {
                a();
                ((a) this.f3285b).show(this.f3284a, DialogModule.FRAGMENT_TAG);
                this.f3285b = null;
            }
        }
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Nullable
    private c getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof FragmentActivity)) {
            return null;
        }
        return new c(((FragmentActivity) currentActivity).getSupportFragmentManager());
    }

    public Map<String, Object> getTypedExportedConstants() {
        return CONSTANTS;
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
        this.mIsInForeground = false;
    }

    public void onHostResume() {
        this.mIsInForeground = true;
        c fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper != null) {
            fragmentManagerHelper.c();
        } else {
            z2.a.C(DialogModule.class, "onHostResume called but no FragmentManager found");
        }
    }

    public void showAlert(ReadableMap readableMap, Callback callback, Callback callback2) {
        c fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            callback.invoke("Tried to show an alert while not attached to an Activity");
            return;
        }
        Bundle bundle = new Bundle();
        if (readableMap.hasKey(KEY_TITLE)) {
            bundle.putString(KEY_TITLE, readableMap.getString(KEY_TITLE));
        }
        if (readableMap.hasKey(KEY_MESSAGE)) {
            bundle.putString(KEY_MESSAGE, readableMap.getString(KEY_MESSAGE));
        }
        if (readableMap.hasKey(KEY_BUTTON_POSITIVE)) {
            bundle.putString("button_positive", readableMap.getString(KEY_BUTTON_POSITIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEGATIVE)) {
            bundle.putString("button_negative", readableMap.getString(KEY_BUTTON_NEGATIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEUTRAL)) {
            bundle.putString("button_neutral", readableMap.getString(KEY_BUTTON_NEUTRAL));
        }
        if (readableMap.hasKey("items")) {
            ReadableArray array = readableMap.getArray("items");
            CharSequence[] charSequenceArr = new CharSequence[array.size()];
            for (int i10 = 0; i10 < array.size(); i10++) {
                charSequenceArr[i10] = array.getString(i10);
            }
            bundle.putCharSequenceArray("items", charSequenceArr);
        }
        if (readableMap.hasKey(KEY_CANCELABLE)) {
            bundle.putBoolean(KEY_CANCELABLE, readableMap.getBoolean(KEY_CANCELABLE));
        }
        UiThreadUtil.runOnUiThread(new a(fragmentManagerHelper, bundle, callback2));
    }
}
