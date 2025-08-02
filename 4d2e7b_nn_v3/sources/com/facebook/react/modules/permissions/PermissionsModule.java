package com.facebook.react.modules.permissions;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.facebook.fbreact.specs.NativePermissionsAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import w6.g;
import w6.h;

@s6.a(name = "PermissionsAndroid")
public class PermissionsModule extends NativePermissionsAndroidSpec implements h {
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    private final String DENIED = "denied";
    private final String GRANTED = "granted";
    private final String NEVER_ASK_AGAIN = "never_ask_again";
    private final SparseArray<Callback> mCallbacks = new SparseArray<>();
    private int mRequestCode = 0;

    class a implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Promise f3342a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f3343b;

        a(Promise promise, String str) {
            this.f3342a = promise;
            this.f3343b = str;
        }

        public void invoke(Object... objArr) {
            int[] iArr = objArr[0];
            if (iArr.length > 0 && iArr[0] == 0) {
                this.f3342a.resolve("granted");
            } else if (objArr[1].shouldShowRequestPermissionRationale(this.f3343b)) {
                this.f3342a.resolve("denied");
            } else {
                this.f3342a.resolve("never_ask_again");
            }
        }
    }

    class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f3345a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableMap f3346b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f3347c;

        b(ArrayList arrayList, WritableMap writableMap, Promise promise) {
            this.f3345a = arrayList;
            this.f3346b = writableMap;
            this.f3347c = promise;
        }

        public void invoke(Object... objArr) {
            int[] iArr = objArr[0];
            g gVar = objArr[1];
            for (int i10 = 0; i10 < this.f3345a.size(); i10++) {
                String str = (String) this.f3345a.get(i10);
                if (iArr.length > 0 && iArr[i10] == 0) {
                    this.f3346b.putString(str, "granted");
                } else if (gVar.shouldShowRequestPermissionRationale(str)) {
                    this.f3346b.putString(str, "denied");
                } else {
                    this.f3346b.putString(str, "never_ask_again");
                }
            }
            this.f3347c.resolve(this.f3346b);
        }
    }

    public PermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private g getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof g) {
            return (g) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }

    public void checkPermission(String str, Promise promise) {
        boolean z10;
        if (getReactApplicationContext().getBaseContext().checkSelfPermission(str) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        promise.resolve(Boolean.valueOf(z10));
    }

    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        try {
            Callback callback = this.mCallbacks.get(i10);
            if (callback != null) {
                callback.invoke(iArr, getPermissionAwareActivity());
                this.mCallbacks.remove(i10);
            } else {
                z2.a.I("PermissionsModule", "Unable to find callback with requestCode %d", Integer.valueOf(i10));
            }
            if (this.mCallbacks.size() == 0) {
                return true;
            }
            return false;
        } catch (IllegalStateException e10) {
            z2.a.m("PermissionsModule", e10, "Unexpected invocation of `onRequestPermissionsResult` with invalid current activity", new Object[0]);
            return false;
        }
    }

    public void requestMultiplePermissions(ReadableArray readableArray, Promise promise) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int i10 = 0;
        for (int i11 = 0; i11 < readableArray.size(); i11++) {
            String string = readableArray.getString(i11);
            if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, "granted");
                i10++;
            } else {
                arrayList.add(string);
            }
        }
        if (readableArray.size() == i10) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            g permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new b(arrayList, writableNativeMap, promise));
            permissionAwareActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e10) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e10);
        }
    }

    public void requestPermission(String str, Promise promise) {
        if (getReactApplicationContext().getBaseContext().checkSelfPermission(str) == 0) {
            promise.resolve("granted");
            return;
        }
        try {
            g permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new a(promise, str));
            permissionAwareActivity.requestPermissions(new String[]{str}, this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e10) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e10);
        }
    }

    public void shouldShowRequestPermissionRationale(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e10) {
            promise.reject(ERROR_INVALID_ACTIVITY, (Throwable) e10);
        }
    }
}
