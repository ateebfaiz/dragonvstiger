package l2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class j {

    /* renamed from: c  reason: collision with root package name */
    public static final a f22445c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f22446a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22447b;

    public static final class a {
        private a() {
        }

        public final void a() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
            edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
            edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
            edit.apply();
        }

        public final j b() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(o.f());
            if (!defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
                return null;
            }
            return new j(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", (String) null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false), (DefaultConstructorMarker) null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ j(String str, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z10);
    }

    public final void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(o.f()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f22446a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f22447b);
        edit.apply();
    }

    public String toString() {
        String str;
        if (this.f22447b) {
            str = "Applink";
        } else {
            str = "Unclassified";
        }
        if (this.f22446a == null) {
            return str;
        }
        return str + '(' + this.f22446a + ')';
    }

    private j(String str, boolean z10) {
        this.f22446a = str;
        this.f22447b = z10;
    }
}
