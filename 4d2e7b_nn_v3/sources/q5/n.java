package q5;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.o;
import com.google.android.games.paddleboat.GameControllerManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;
import q5.q;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f23372a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static final n f23373b = new n();

    public interface a {
        void a(boolean z10);
    }

    public enum b {
        Unknown(-1),
        Core(0),
        AppEvents(65536),
        CodelessEvents(65792),
        RestrictiveDataFiltering(66048),
        AAM(66304),
        PrivacyProtection(66560),
        SuggestedEvents(66561),
        IntelligentIntegrity(66562),
        ModelRequest(66563),
        EventDeactivation(66816),
        OnDeviceEventProcessing(67072),
        OnDevicePostInstallEventProcessing(67073),
        IapLogging(67328),
        IapLoggingLib2(67329),
        Instrument(131072),
        CrashReport(131328),
        CrashShield(131329),
        ThreadCheck(131330),
        ErrorReport(131584),
        AnrReport(131840),
        Monitoring(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE),
        ServiceUpdateCompliance(196864),
        Login(16777216),
        ChromeCustomTabsPrefetching(16842752),
        IgnoreAppSwitchToLoggedOut(16908288),
        BypassAppSwitch(16973824),
        Share(GameControllerManager.DEVICEFLAG_LIGHT_RGB),
        Places(50331648);
        

        /* renamed from: d1  reason: collision with root package name */
        public static final a f23380d1 = null;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f23388a;

        public static final class a {
            private a() {
            }

            public final b a(int i10) {
                for (b bVar : b.values()) {
                    if (bVar.f23388a == i10) {
                        return bVar;
                    }
                }
                return b.Unknown;
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            f23380d1 = new a((DefaultConstructorMarker) null);
        }

        private b(int i10) {
            this.f23388a = i10;
        }

        public final b b() {
            int i10 = this.f23388a;
            if ((i10 & 255) > 0) {
                return f23380d1.a(i10 & InputDeviceCompat.SOURCE_ANY);
            }
            if ((65280 & i10) > 0) {
                return f23380d1.a(i10 & SupportMenu.CATEGORY_MASK);
            }
            if ((16711680 & i10) > 0) {
                return f23380d1.a(i10 & ViewCompat.MEASURED_STATE_MASK);
            }
            return f23380d1.a(0);
        }

        public final String c() {
            return "FBSDKFeature" + this;
        }

        public String toString() {
            switch (o.f23391a[ordinal()]) {
                case 1:
                    return "CoreKit";
                case 2:
                    return "AppEvents";
                case 3:
                    return "CodelessEvents";
                case 4:
                    return "RestrictiveDataFiltering";
                case 5:
                    return "Instrument";
                case 6:
                    return "CrashReport";
                case 7:
                    return "CrashShield";
                case 8:
                    return "ThreadCheck";
                case 9:
                    return "ErrorReport";
                case 10:
                    return "AnrReport";
                case 11:
                    return "AAM";
                case 12:
                    return "PrivacyProtection";
                case 13:
                    return "SuggestedEvents";
                case 14:
                    return "IntelligentIntegrity";
                case 15:
                    return "ModelRequest";
                case 16:
                    return "EventDeactivation";
                case 17:
                    return "OnDeviceEventProcessing";
                case 18:
                    return "OnDevicePostInstallEventProcessing";
                case 19:
                    return "IAPLogging";
                case 20:
                    return "IAPLoggingLib2";
                case 21:
                    return "Monitoring";
                case 22:
                    return "ServiceUpdateCompliance";
                case 23:
                    return "LoginKit";
                case 24:
                    return "ChromeCustomTabsPrefetching";
                case 25:
                    return "IgnoreAppSwitchToLoggedOut";
                case 26:
                    return "BypassAppSwitch";
                case 27:
                    return "ShareKit";
                case MotionEventCompat.AXIS_RELATIVE_Y:
                    return "PlacesKit";
                default:
                    return "unknown";
            }
        }
    }

    public static final class c implements q.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f23389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f23390b;

        c(a aVar, b bVar) {
            this.f23389a = aVar;
            this.f23390b = bVar;
        }

        public void a() {
            this.f23389a.a(n.g(this.f23390b));
        }
    }

    private n() {
    }

    public static final void a(b bVar, a aVar) {
        m.f(bVar, "feature");
        m.f(aVar, "callback");
        q.j(new c(aVar, bVar));
    }

    private final boolean b(b bVar) {
        switch (p.f23392a[bVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                return false;
            default:
                return true;
        }
    }

    public static final void c(b bVar) {
        m.f(bVar, "feature");
        o.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(bVar.c(), o.w()).apply();
    }

    public static final b d(String str) {
        m.f(str, "className");
        f23373b.f();
        for (Map.Entry entry : f23372a.entrySet()) {
            b bVar = (b) entry.getKey();
            String[] strArr = (String[]) entry.getValue();
            int length = strArr.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    if (j.F(str, strArr[i10], false, 2, (Object) null)) {
                        return bVar;
                    }
                    i10++;
                }
            }
        }
        return b.Unknown;
    }

    private final boolean e(b bVar) {
        return q.f(bVar.c(), o.g(), b(bVar));
    }

    private final synchronized void f() {
        Map map = f23372a;
        if (map.isEmpty()) {
            map.put(b.AAM, new String[]{"com.facebook.appevents.aam."});
            map.put(b.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
            map.put(b.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
            map.put(b.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
            map.put(b.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
            map.put(b.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
            map.put(b.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
            map.put(b.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
            map.put(b.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
            map.put(b.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
            map.put(b.IapLogging, new String[]{"com.facebook.appevents.iap."});
            map.put(b.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
        }
    }

    public static final boolean g(b bVar) {
        m.f(bVar, "feature");
        if (b.Unknown == bVar) {
            return false;
        }
        if (b.Core == bVar) {
            return true;
        }
        String string = o.f().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).getString(bVar.c(), (String) null);
        if (string != null && m.b(string, o.w())) {
            return false;
        }
        b b10 = bVar.b();
        if (b10 == bVar) {
            return f23373b.e(bVar);
        }
        if (!g(b10) || !f23373b.e(bVar)) {
            return false;
        }
        return true;
    }
}
