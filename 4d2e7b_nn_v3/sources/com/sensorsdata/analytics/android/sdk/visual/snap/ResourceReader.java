package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import com.alibaba.pdns.f;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public abstract class ResourceReader implements ResourceIds {
    private static final String TAG = "SA.ResourceReader";
    private final Context mContext;
    private final Map<String, Integer> mIdNameToId = new HashMap();
    private final SparseArray<String> mIdToIdName = new SparseArray<>();

    public static class Drawables extends ResourceReader {
        private final String mResourcePackageName;

        protected Drawables(String str, Context context) {
            super(context);
            this.mResourcePackageName = str;
            initialize();
        }

        /* access modifiers changed from: protected */
        public String getLocalClassName(Context context) {
            return this.mResourcePackageName + ".R$drawable";
        }

        /* access modifiers changed from: protected */
        public Class<?> getSystemClass() {
            return R.drawable.class;
        }
    }

    public static class Ids extends ResourceReader {
        private final String mResourcePackageName;

        public Ids(String str, Context context) {
            super(context);
            this.mResourcePackageName = str;
            initialize();
        }

        /* access modifiers changed from: protected */
        public String getLocalClassName(Context context) {
            return this.mResourcePackageName + ".R$id";
        }

        /* access modifiers changed from: protected */
        public Class<?> getSystemClass() {
            return R.id.class;
        }
    }

    protected ResourceReader(Context context) {
        this.mContext = context;
    }

    private static void readClassIds(Class<?> cls, String str, Map<String, Integer> map) {
        try {
            for (Field field : cls.getFields()) {
                if (Modifier.isStatic(field.getModifiers()) && field.getType() == Integer.TYPE) {
                    String name = field.getName();
                    int i10 = field.getInt((Object) null);
                    if (str != null) {
                        name = str + ":" + name;
                    }
                    map.put(name, Integer.valueOf(i10));
                }
            }
        } catch (IllegalAccessException e10) {
            SALog.i(TAG, "Can't read built-in id names from " + cls.getName(), (Throwable) e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String getLocalClassName(Context context);

    /* access modifiers changed from: protected */
    public abstract Class<?> getSystemClass();

    public int idFromName(String str) {
        return this.mIdNameToId.get(str).intValue();
    }

    /* access modifiers changed from: protected */
    public void initialize() {
        this.mIdNameToId.clear();
        this.mIdToIdName.clear();
        readClassIds(getSystemClass(), f.f17924q, this.mIdNameToId);
        String localClassName = getLocalClassName(this.mContext);
        try {
            readClassIds(Class.forName(localClassName), (String) null, this.mIdNameToId);
        } catch (ClassNotFoundException unused) {
            SALog.i(TAG, "Can't load names for Android view ids from '" + localClassName + "', ids by name will not be available in the events editor.");
            SALog.i(TAG, "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the SensorsData library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.sensorsdata.analytics.android.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        for (Map.Entry next : this.mIdNameToId.entrySet()) {
            this.mIdToIdName.put(((Integer) next.getValue()).intValue(), next.getKey());
        }
    }

    public boolean knownIdName(String str) {
        return this.mIdNameToId.containsKey(str);
    }

    public String nameForId(int i10) {
        return this.mIdToIdName.get(i10);
    }
}
