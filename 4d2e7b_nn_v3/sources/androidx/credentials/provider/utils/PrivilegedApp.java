package androidx.credentials.provider.utils;

import android.os.Build;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PrivilegedApp {
    private static final String ANDROID_TYPE_KEY = "android";
    private static final String APPS_KEY = "apps";
    private static final String APP_INFO_KEY = "info";
    private static final String BUILD_KEY = "build";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FINGERPRINT_KEY = "cert_fingerprint_sha256";
    private static final String PACKAGE_NAME_KEY = "package_name";
    private static final String SIGNATURES_KEY = "signatures";
    private static final String TYPE_KEY = "type";
    private static final String USER_BUILD_TYPE = "userdebug";
    private static final String USER_DEBUG_KEY = "userdebug";
    private final Set<String> fingerprints;
    private final String packageName;

    public static final class Companion {
        private Companion() {
        }

        public final PrivilegedApp createFromJSONObject(JSONObject jSONObject, boolean z10) {
            m.f(jSONObject, "appInfoJsonObject");
            JSONArray jSONArray = jSONObject.getJSONArray(PrivilegedApp.SIGNATURES_KEY);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!z10 || !m.b("userdebug", jSONArray.getJSONObject(i10).optString(PrivilegedApp.BUILD_KEY)) || m.b("userdebug", Build.TYPE)) {
                    String string = jSONArray.getJSONObject(i10).getString(PrivilegedApp.FINGERPRINT_KEY);
                    m.e(string, "signaturesJson.getJSONOb…etString(FINGERPRINT_KEY)");
                    linkedHashSet.add(string);
                }
            }
            String string2 = jSONObject.getString(PrivilegedApp.PACKAGE_NAME_KEY);
            m.e(string2, "appInfoJsonObject.getString(PACKAGE_NAME_KEY)");
            return new PrivilegedApp(string2, linkedHashSet);
        }

        public final List<PrivilegedApp> extractPrivilegedApps$credentials_release(JSONObject jSONObject) {
            m.f(jSONObject, "jsonObject");
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(PrivilegedApp.APPS_KEY);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                if (m.b(jSONObject2.getString(PrivilegedApp.TYPE_KEY), "android")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(PrivilegedApp.APP_INFO_KEY);
                    m.e(jSONObject3, "appJsonObject.getJSONObject(APP_INFO_KEY)");
                    arrayList.add(createFromJSONObject(jSONObject3, true));
                }
            }
            return arrayList;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PrivilegedApp(String str, Set<String> set) {
        m.f(str, "packageName");
        m.f(set, "fingerprints");
        this.packageName = str;
        this.fingerprints = set;
    }

    public static /* synthetic */ PrivilegedApp copy$default(PrivilegedApp privilegedApp, String str, Set<String> set, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = privilegedApp.packageName;
        }
        if ((i10 & 2) != 0) {
            set = privilegedApp.fingerprints;
        }
        return privilegedApp.copy(str, set);
    }

    public static final PrivilegedApp createFromJSONObject(JSONObject jSONObject, boolean z10) {
        return Companion.createFromJSONObject(jSONObject, z10);
    }

    public static final List<PrivilegedApp> extractPrivilegedApps$credentials_release(JSONObject jSONObject) {
        return Companion.extractPrivilegedApps$credentials_release(jSONObject);
    }

    public final String component1() {
        return this.packageName;
    }

    public final Set<String> component2() {
        return this.fingerprints;
    }

    public final PrivilegedApp copy(String str, Set<String> set) {
        m.f(str, "packageName");
        m.f(set, "fingerprints");
        return new PrivilegedApp(str, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrivilegedApp)) {
            return false;
        }
        PrivilegedApp privilegedApp = (PrivilegedApp) obj;
        return m.b(this.packageName, privilegedApp.packageName) && m.b(this.fingerprints, privilegedApp.fingerprints);
    }

    public final Set<String> getFingerprints() {
        return this.fingerprints;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.fingerprints.hashCode();
    }

    public String toString() {
        return "PrivilegedApp(packageName=" + this.packageName + ", fingerprints=" + this.fingerprints + ')';
    }
}
