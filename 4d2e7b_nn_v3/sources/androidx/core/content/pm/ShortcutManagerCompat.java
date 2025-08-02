package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ShortcutManagerCompat {
    @VisibleForTesting
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    @VisibleForTesting
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IntentSender f14887a;

        a(IntentSender intentSender) {
            this.f14887a = intentSender;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                this.f14887a.sendIntent(context, 0, (Intent) null, (IntentSender.OnFinished) null, (Handler) null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    private static class b {
        static String a(List list) {
            Iterator it = list.iterator();
            int i10 = -1;
            String str = null;
            while (it.hasNext()) {
                ShortcutInfo shortcutInfo = (ShortcutInfo) it.next();
                if (shortcutInfo.getRank() > i10) {
                    String id2 = shortcutInfo.getId();
                    str = id2;
                    i10 = shortcutInfo.getRank();
                }
            }
            return str;
        }
    }

    private ShortcutManagerCompat() {
    }

    public static boolean addDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            convertUriIconsToBitmapIcons(context, removeShortcutsExcludedFromSurface);
        }
        if (i10 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!w0.a(context.getSystemService(l0.a())).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutAdded : getShortcutInfoListeners(context)) {
            onShortcutAdded.onShortcutAdded(list);
        }
        return true;
    }

    @VisibleForTesting
    static boolean convertUriIconToBitmapIcon(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat iconCompat;
        IconCompat iconCompat2 = shortcutInfoCompat.mIcon;
        if (iconCompat2 == null) {
            return false;
        }
        int i10 = iconCompat2.mType;
        if (i10 != 6 && i10 != 4) {
            return true;
        }
        InputStream uriInputStream = iconCompat2.getUriInputStream(context);
        if (uriInputStream == null || (decodeStream = BitmapFactory.decodeStream(uriInputStream)) == null) {
            return false;
        }
        if (i10 == 6) {
            iconCompat = IconCompat.createWithAdaptiveBitmap(decodeStream);
        } else {
            iconCompat = IconCompat.createWithBitmap(decodeStream);
        }
        shortcutInfoCompat.mIcon = iconCompat;
        return true;
    }

    @VisibleForTesting
    static void convertUriIconsToBitmapIcons(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
            if (!convertUriIconToBitmapIcon(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    @NonNull
    public static Intent createShortcutResultIntent(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 26) {
            intent = w0.a(context.getSystemService(l0.a())).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo());
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        return shortcutInfoCompat.addToIntent(intent);
    }

    public static void disableShortcuts(@NonNull Context context, @NonNull List<String> list, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 25) {
            w0.a(context.getSystemService(l0.a())).disableShortcuts(list, charSequence);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    public static void enableShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(list.size());
            for (ShortcutInfoCompat shortcutInfoCompat : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfoCompat.mId);
            }
            w0.a(context.getSystemService(l0.a())).enableShortcuts(arrayList);
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutAdded : getShortcutInfoListeners(context)) {
            onShortcutAdded.onShortcutAdded(list);
        }
    }

    @NonNull
    public static List<ShortcutInfoCompat> getDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            List<Object> a10 = w0.a(context.getSystemService(l0.a())).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(a10.size());
            for (Object a11 : a10) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, e.a(a11)).build());
            }
            return arrayList;
        }
        try {
            return getShortcutInfoSaverInstance(context).getShortcuts();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private static int getIconDimensionInternal(@NonNull Context context, boolean z10) {
        boolean z11;
        int i10;
        float f10;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || activityManager.isLowRamDevice()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i10 = DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP;
        } else {
            i10 = DEFAULT_MAX_ICON_DIMENSION_DP;
        }
        int max = Math.max(1, i10);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z10) {
            f10 = displayMetrics.xdpi;
        } else {
            f10 = displayMetrics.ydpi;
        }
        return (int) (((float) max) * (f10 / 160.0f));
    }

    public static int getIconMaxHeight(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return w0.a(context.getSystemService(l0.a())).getIconMaxHeight();
        }
        return getIconDimensionInternal(context, false);
    }

    public static int getIconMaxWidth(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return w0.a(context.getSystemService(l0.a())).getIconMaxWidth();
        }
        return getIconDimensionInternal(context, true);
    }

    public static int getMaxShortcutCountPerActivity(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return w0.a(context.getSystemService(l0.a())).getMaxShortcutCountPerActivity();
        }
        return 5;
    }

    @VisibleForTesting
    static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    private static String getShortcutInfoCompatWithLowestRank(@NonNull List<ShortcutInfoCompat> list) {
        int i10 = -1;
        String str = null;
        for (ShortcutInfoCompat next : list) {
            if (next.getRank() > i10) {
                String id2 = next.getId();
                str = id2;
                i10 = next.getRank();
            }
        }
        return str;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context context) {
        Bundle bundle;
        String string;
        if (sShortcutInfoChangeListeners == null) {
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (!(activityInfo == null || (bundle = activityInfo.metaData) == null || (string = bundle.getString(SHORTCUT_LISTENER_META_DATA_KEY)) == null)) {
                    try {
                        arrayList.add((ShortcutInfoChangeListener) Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
                    } catch (Exception unused) {
                    }
                }
            }
            if (sShortcutInfoChangeListeners == null) {
                sShortcutInfoChangeListeners = arrayList;
            }
        }
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            try {
                sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            } catch (Exception unused) {
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }

    @NonNull
    public static List<ShortcutInfoCompat> getShortcuts(@NonNull Context context, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            return ShortcutInfoCompat.fromShortcuts(context, w0.a(context.getSystemService(l0.a())).getShortcuts(i10));
        }
        if (i11 >= 25) {
            ShortcutManager a10 = w0.a(context.getSystemService(l0.a()));
            ArrayList arrayList = new ArrayList();
            if ((i10 & 1) != 0) {
                arrayList.addAll(a10.getManifestShortcuts());
            }
            if ((i10 & 2) != 0) {
                arrayList.addAll(a10.getDynamicShortcuts());
            }
            if ((i10 & 4) != 0) {
                arrayList.addAll(a10.getPinnedShortcuts());
            }
            return ShortcutInfoCompat.fromShortcuts(context, arrayList);
        }
        if ((i10 & 2) != 0) {
            try {
                return getShortcutInfoSaverInstance(context).getShortcuts();
            } catch (Exception unused) {
            }
        }
        return Collections.emptyList();
    }

    public static boolean isRateLimitingActive(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 25) {
            return w0.a(context.getSystemService(l0.a())).isRateLimitingActive();
        }
        if (getShortcuts(context, 3).size() == getMaxShortcutCountPerActivity(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRequestPinShortcutSupported(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 < r1) goto L_0x0017
            java.lang.Class r0 = androidx.core.content.pm.l0.a()
            java.lang.Object r4 = r4.getSystemService(r0)
            android.content.pm.ShortcutManager r4 = androidx.core.content.pm.w0.a(r4)
            boolean r4 = r4.isRequestPinShortcutSupported()
            return r4
        L_0x0017:
            java.lang.String r0 = "com.android.launcher.permission.INSTALL_SHORTCUT"
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r4, r0)
            r2 = 0
            if (r1 == 0) goto L_0x0021
            return r2
        L_0x0021:
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r3 = "com.android.launcher.action.INSTALL_SHORTCUT"
            r1.<init>(r3)
            java.util.List r4 = r4.queryBroadcastReceivers(r1, r2)
            java.util.Iterator r4 = r4.iterator()
        L_0x0034:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r4.next()
            android.content.pm.ResolveInfo r1 = (android.content.pm.ResolveInfo) r1
            android.content.pm.ActivityInfo r1 = r1.activityInfo
            java.lang.String r1 = r1.permission
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L_0x0050
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0034
        L_0x0050:
            r4 = 1
            return r4
        L_0x0052:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.isRequestPinShortcutSupported(android.content.Context):boolean");
    }

    public static boolean pushDynamicShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(shortcutInfoCompat);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 > 32 || !shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            int maxShortcutCountPerActivity = getMaxShortcutCountPerActivity(context);
            if (maxShortcutCountPerActivity == 0) {
                return false;
            }
            if (i10 <= 29) {
                convertUriIconToBitmapIcon(context, shortcutInfoCompat);
            }
            if (i10 >= 30) {
                w0.a(context.getSystemService(l0.a())).pushDynamicShortcut(shortcutInfoCompat.toShortcutInfo());
            } else if (i10 >= 25) {
                ShortcutManager a10 = w0.a(context.getSystemService(l0.a()));
                if (a10.isRateLimitingActive()) {
                    return false;
                }
                List a11 = a10.getDynamicShortcuts();
                if (a11.size() >= maxShortcutCountPerActivity) {
                    a10.removeDynamicShortcuts(Arrays.asList(new String[]{b.a(a11)}));
                }
                boolean unused = a10.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{shortcutInfoCompat.toShortcutInfo()}));
            }
            ShortcutInfoCompatSaver<?> shortcutInfoSaverInstance = getShortcutInfoSaverInstance(context);
            try {
                List<ShortcutInfoCompat> shortcuts = shortcutInfoSaverInstance.getShortcuts();
                if (shortcuts.size() >= maxShortcutCountPerActivity) {
                    shortcutInfoSaverInstance.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(shortcuts)}));
                }
                shortcutInfoSaverInstance.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{shortcutInfoCompat}));
                for (ShortcutInfoChangeListener onShortcutAdded : getShortcutInfoListeners(context)) {
                    onShortcutAdded.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                return true;
            } catch (Exception unused2) {
                for (ShortcutInfoChangeListener onShortcutAdded2 : getShortcutInfoListeners(context)) {
                    onShortcutAdded2.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                return false;
            } catch (Throwable th) {
                for (ShortcutInfoChangeListener onShortcutAdded3 : getShortcutInfoListeners(context)) {
                    onShortcutAdded3.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
                }
                reportShortcutUsed(context, shortcutInfoCompat.getId());
                throw th;
            }
        } else {
            for (ShortcutInfoChangeListener onShortcutAdded4 : getShortcutInfoListeners(context)) {
                onShortcutAdded4.onShortcutAdded(Collections.singletonList(shortcutInfoCompat));
            }
            return true;
        }
    }

    public static void removeAllDynamicShortcuts(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            w0.a(context.getSystemService(l0.a())).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        for (ShortcutInfoChangeListener onAllShortcutsRemoved : getShortcutInfoListeners(context)) {
            onAllShortcutsRemoved.onAllShortcutsRemoved();
        }
    }

    public static void removeDynamicShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            w0.a(context.getSystemService(l0.a())).removeDynamicShortcuts(list);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    public static void removeLongLivedShortcuts(@NonNull Context context, @NonNull List<String> list) {
        if (Build.VERSION.SDK_INT < 30) {
            removeDynamicShortcuts(context, list);
            return;
        }
        w0.a(context.getSystemService(l0.a())).removeLongLivedShortcuts(list);
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
        for (ShortcutInfoChangeListener onShortcutRemoved : getShortcutInfoListeners(context)) {
            onShortcutRemoved.onShortcutRemoved(list);
        }
    }

    @NonNull
    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(@NonNull List<ShortcutInfoCompat> list, int i10) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 32) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (ShortcutInfoCompat next : list) {
            if (next.isExcludedFromSurfaces(i10)) {
                arrayList.remove(next);
            }
        }
        return arrayList;
    }

    public static void reportShortcutUsed(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(str);
        if (Build.VERSION.SDK_INT >= 25) {
            w0.a(context.getSystemService(l0.a())).reportShortcutUsed(str);
        }
        for (ShortcutInfoChangeListener onShortcutUsageReported : getShortcutInfoListeners(context)) {
            onShortcutUsageReported.onShortcutUsageReported(Collections.singletonList(str));
        }
    }

    public static boolean requestPinShortcut(@NonNull Context context, @NonNull ShortcutInfoCompat shortcutInfoCompat, @Nullable IntentSender intentSender) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 32 && shortcutInfoCompat.isExcludedFromSurfaces(1)) {
            return false;
        }
        if (i10 >= 26) {
            return w0.a(context.getSystemService(l0.a())).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }
        Intent addToIntent = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (intentSender == null) {
            context.sendBroadcast(addToIntent);
            return true;
        }
        context.sendOrderedBroadcast(addToIntent, (String) null, new a(intentSender), (Handler) null, -1, (String) null, (Bundle) null);
        return true;
    }

    public static boolean setDynamicShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(list);
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList(removeShortcutsExcludedFromSurface.size());
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!w0.a(context.getSystemService(l0.a())).setDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener next : getShortcutInfoListeners(context)) {
            next.onAllShortcutsRemoved();
            next.onShortcutAdded(list);
        }
        return true;
    }

    @VisibleForTesting
    static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> list) {
        sShortcutInfoChangeListeners = list;
    }

    @VisibleForTesting
    static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> shortcutInfoCompatSaver) {
        sShortcutInfoCompatSaver = shortcutInfoCompatSaver;
    }

    public static boolean updateShortcuts(@NonNull Context context, @NonNull List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface = removeShortcutsExcludedFromSurface(list, 1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 29) {
            convertUriIconsToBitmapIcons(context, removeShortcutsExcludedFromSurface);
        }
        if (i10 >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfo : removeShortcutsExcludedFromSurface) {
                arrayList.add(shortcutInfo.toShortcutInfo());
            }
            if (!w0.a(context.getSystemService(l0.a())).updateShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(removeShortcutsExcludedFromSurface);
        for (ShortcutInfoChangeListener onShortcutUpdated : getShortcutInfoListeners(context)) {
            onShortcutUpdated.onShortcutUpdated(list);
        }
        return true;
    }
}
