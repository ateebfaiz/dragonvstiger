package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;

abstract class m implements MediaSessionManager.a {

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f16031c = MediaSessionManager.DEBUG;

    /* renamed from: a  reason: collision with root package name */
    Context f16032a;

    /* renamed from: b  reason: collision with root package name */
    ContentResolver f16033b;

    static class a implements MediaSessionManager.b {

        /* renamed from: a  reason: collision with root package name */
        private String f16034a;

        /* renamed from: b  reason: collision with root package name */
        private int f16035b;

        /* renamed from: c  reason: collision with root package name */
        private int f16036c;

        a(String str, int i10, int i11) {
            this.f16034a = str;
            this.f16035b = i10;
            this.f16036c = i11;
        }

        public int a() {
            return this.f16036c;
        }

        public int b() {
            return this.f16035b;
        }

        public String c() {
            return this.f16034a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.equals(this.f16034a, aVar.f16034a) && this.f16035b == aVar.f16035b && this.f16036c == aVar.f16036c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.f16034a, Integer.valueOf(this.f16035b), Integer.valueOf(this.f16036c));
        }
    }

    m(Context context) {
        this.f16032a = context;
        this.f16033b = context.getContentResolver();
    }

    private boolean c(MediaSessionManager.b bVar, String str) {
        if (bVar.b() < 0) {
            if (this.f16032a.getPackageManager().checkPermission(str, bVar.c()) == 0) {
                return true;
            }
            return false;
        } else if (this.f16032a.checkPermission(str, bVar.b(), bVar.a()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean a(MediaSessionManager.b bVar) {
        try {
            if (this.f16032a.getPackageManager().getApplicationInfo(bVar.c(), 0).uid != bVar.a()) {
                if (f16031c) {
                    Log.d("MediaSessionManager", "Package name " + bVar.c() + " doesn't match with the uid " + bVar.a());
                }
                return false;
            } else if (c(bVar, "android.permission.STATUS_BAR_SERVICE") || c(bVar, "android.permission.MEDIA_CONTENT_CONTROL") || bVar.a() == 1000 || b(bVar)) {
                return true;
            } else {
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            if (f16031c) {
                Log.d("MediaSessionManager", "Package " + bVar.c() + " doesn't exist");
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(MediaSessionManager.b bVar) {
        String string = Settings.Secure.getString(this.f16033b, "enabled_notification_listeners");
        if (string != null) {
            String[] split = string.split(":");
            for (String unflattenFromString : split) {
                ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                if (unflattenFromString2 != null && unflattenFromString2.getPackageName().equals(bVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Context getContext() {
        return this.f16032a;
    }
}
