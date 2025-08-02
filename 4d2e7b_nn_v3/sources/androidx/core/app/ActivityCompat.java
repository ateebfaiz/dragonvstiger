package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.content.LocusIdCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    public interface OnRequestPermissionsResultCallback {
        void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr);
    }

    public interface PermissionCompatDelegate {
        boolean onActivityResult(@NonNull Activity activity, @IntRange(from = 0) int i10, int i11, @Nullable Intent intent);

        boolean requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i10);
    }

    static class a {
        @DoNotInline
        static void a(Activity activity) {
            activity.finishAfterTransition();
        }

        @DoNotInline
        static void b(Activity activity) {
            activity.postponeEnterTransition();
        }

        @DoNotInline
        static void c(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setEnterSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void d(Activity activity, SharedElementCallback sharedElementCallback) {
            activity.setExitSharedElementCallback(sharedElementCallback);
        }

        @DoNotInline
        static void e(Activity activity) {
            activity.startPostponedEnterTransition();
        }
    }

    static class b {
        @DoNotInline
        static Uri a(Activity activity) {
            return activity.getReferrer();
        }
    }

    static class c {
        /* access modifiers changed from: package-private */
        @DoNotInline
        public static void a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        @DoNotInline
        static void b(Activity activity, String[] strArr, int i10) {
            activity.requestPermissions(strArr, i10);
        }

        @DoNotInline
        static boolean c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class d {
        @DoNotInline
        static <T> T a(Activity activity, int i10) {
            return activity.requireViewById(i10);
        }
    }

    static class e {
        @DoNotInline
        static Display a(ContextWrapper contextWrapper) {
            return contextWrapper.getDisplay();
        }

        @DoNotInline
        static void b(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
            LocusId locusId;
            if (locusIdCompat == null) {
                locusId = null;
            } else {
                locusId = locusIdCompat.toLocusId();
            }
            activity.setLocusContext(locusId, bundle);
        }
    }

    static class f {
        @DoNotInline
        static boolean a(@NonNull Activity activity) {
            return activity.isLaunchedFromBubble();
        }

        @DoNotInline
        @SuppressLint({"BanUncheckedReflection"})
        static boolean b(Activity activity, String str) {
            try {
                PackageManager packageManager = activity.getApplication().getPackageManager();
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", new Class[]{String.class}).invoke(packageManager, new Object[]{str})).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    static class g {
        @DoNotInline
        static boolean a(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    static class h extends SharedElementCallback {

        /* renamed from: a  reason: collision with root package name */
        private final SharedElementCallback f14792a;

        h(SharedElementCallback sharedElementCallback) {
            this.f14792a = sharedElementCallback;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f14792a.onCaptureSharedElementSnapshot(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f14792a.onCreateSnapshotView(context, parcelable);
        }

        public void onMapSharedElements(List list, Map map) {
            this.f14792a.onMapSharedElements(list, map);
        }

        public void onRejectSharedElements(List list) {
            this.f14792a.onRejectSharedElements(list);
        }

        public void onSharedElementEnd(List list, List list2, List list3) {
            this.f14792a.onSharedElementEnd(list, list2, list3);
        }

        public void onSharedElementStart(List list, List list2, List list3) {
            this.f14792a.onSharedElementStart(list, list2, list3);
        }

        public void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            this.f14792a.onSharedElementsArrived(list, list2, new b(onSharedElementsReadyListener));
        }
    }

    protected ActivityCompat() {
    }

    public static void finishAffinity(@NonNull Activity activity) {
        activity.finishAffinity();
    }

    public static void finishAfterTransition(@NonNull Activity activity) {
        a.a(activity);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static PermissionCompatDelegate getPermissionCompatDelegate() {
        return sDelegate;
    }

    @Nullable
    public static Uri getReferrer(@NonNull Activity activity) {
        return b.a(activity);
    }

    @Deprecated
    public static boolean invalidateOptionsMenu(Activity activity) {
        activity.invalidateOptionsMenu();
        return true;
    }

    public static boolean isLaunchedFromBubble(@NonNull Activity activity) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            return f.a(activity);
        }
        if (i10 == 30) {
            if (e.a(activity) == null || e.a(activity).getDisplayId() == 0) {
                return false;
            }
            return true;
        } else if (i10 != 29) {
            return false;
        } else {
            if (activity.getWindowManager().getDefaultDisplay() == null || activity.getWindowManager().getDefaultDisplay().getDisplayId() == 0) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$recreate$0(Activity activity) {
        if (!activity.isFinishing() && !c.i(activity)) {
            activity.recreate();
        }
    }

    public static void postponeEnterTransition(@NonNull Activity activity) {
        a.b(activity);
    }

    public static void recreate(@NonNull Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
        } else {
            new Handler(activity.getMainLooper()).post(new a(activity));
        }
    }

    @Nullable
    public static DragAndDropPermissionsCompat requestDragAndDropPermissions(@NonNull Activity activity, @NonNull DragEvent dragEvent) {
        return DragAndDropPermissionsCompat.request(activity, dragEvent);
    }

    public static void requestPermissions(@NonNull Activity activity, @NonNull String[] strArr, @IntRange(from = 0) int i10) {
        String[] strArr2;
        PermissionCompatDelegate permissionCompatDelegate = sDelegate;
        if (permissionCompatDelegate == null || !permissionCompatDelegate.requestPermissions(activity, strArr, i10)) {
            HashSet hashSet = new HashSet();
            int i11 = 0;
            while (i11 < strArr.length) {
                if (!TextUtils.isEmpty(strArr[i11])) {
                    if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i11], "android.permission.POST_NOTIFICATIONS")) {
                        hashSet.add(Integer.valueOf(i11));
                    }
                    i11++;
                } else {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            int size = hashSet.size();
            if (size > 0) {
                strArr2 = new String[(strArr.length - size)];
            } else {
                strArr2 = strArr;
            }
            if (size > 0) {
                if (size != strArr.length) {
                    int i12 = 0;
                    for (int i13 = 0; i13 < strArr.length; i13++) {
                        if (!hashSet.contains(Integer.valueOf(i13))) {
                            strArr2[i12] = strArr[i13];
                            i12++;
                        }
                    }
                } else {
                    return;
                }
            }
            if (activity instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i10);
            }
            c.b(activity, strArr, i10);
        }
    }

    @NonNull
    public static <T extends View> T requireViewById(@NonNull Activity activity, @IdRes int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) d.a(activity, i10);
        }
        T findViewById = activity.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void setEnterSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        h hVar;
        if (sharedElementCallback != null) {
            hVar = new h(sharedElementCallback);
        } else {
            hVar = null;
        }
        a.c(activity, hVar);
    }

    public static void setExitSharedElementCallback(@NonNull Activity activity, @Nullable SharedElementCallback sharedElementCallback) {
        h hVar;
        if (sharedElementCallback != null) {
            hVar = new h(sharedElementCallback);
        } else {
            hVar = null;
        }
        a.d(activity, hVar);
    }

    public static void setLocusContext(@NonNull Activity activity, @Nullable LocusIdCompat locusIdCompat, @Nullable Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 30) {
            e.b(activity, locusIdCompat, bundle);
        }
    }

    public static void setPermissionCompatDelegate(@Nullable PermissionCompatDelegate permissionCompatDelegate) {
        sDelegate = permissionCompatDelegate;
    }

    public static boolean shouldShowRequestPermissionRationale(@NonNull Activity activity, @NonNull String str) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i10 >= 32) {
            return g.a(activity, str);
        }
        if (i10 == 31) {
            return f.b(activity, str);
        }
        return c.c(activity, str);
    }

    public static void startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i10, @Nullable Bundle bundle) {
        activity.startActivityForResult(intent, i10, bundle);
    }

    public static void startIntentSenderForResult(@NonNull Activity activity, @NonNull IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        activity.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    public static void startPostponedEnterTransition(@NonNull Activity activity) {
        a.e(activity);
    }
}
