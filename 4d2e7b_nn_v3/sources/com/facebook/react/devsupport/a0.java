package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.a;
import com.facebook.react.devsupport.g;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.p;
import com.google.android.games.paddleboat.GameControllerManager;
import e6.i;
import e6.j;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import k6.e;

public abstract class a0 implements k6.e {
    private int A = 0;
    /* access modifiers changed from: private */
    public final k6.b B;
    private List C;
    /* access modifiers changed from: private */
    public final Map D;
    private final j E;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f2998a;

    /* renamed from: b  reason: collision with root package name */
    private final e6.g f2999b;

    /* renamed from: c  reason: collision with root package name */
    private final BroadcastReceiver f3000c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final g f3001d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashMap f3002e = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final x0 f3003f;

    /* renamed from: g  reason: collision with root package name */
    private final String f3004g;

    /* renamed from: h  reason: collision with root package name */
    private final File f3005h;

    /* renamed from: i  reason: collision with root package name */
    private final File f3006i;

    /* renamed from: j  reason: collision with root package name */
    private final DefaultJSExceptionHandler f3007j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final k6.c f3008k;

    /* renamed from: l  reason: collision with root package name */
    private final k6.h f3009l;

    /* renamed from: m  reason: collision with root package name */
    private i f3010m;

    /* renamed from: n  reason: collision with root package name */
    private AlertDialog f3011n;

    /* renamed from: o  reason: collision with root package name */
    private c f3012o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3013p = false;

    /* renamed from: q  reason: collision with root package name */
    private int f3014q = 0;

    /* renamed from: r  reason: collision with root package name */
    private ReactContext f3015r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final x6.a f3016s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f3017t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f3018u = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3019v = false;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f3020w;

    /* renamed from: x  reason: collision with root package name */
    private String f3021x;

    /* renamed from: y  reason: collision with root package name */
    private k6.j[] f3022y;

    /* renamed from: z  reason: collision with root package name */
    private k6.f f3023z;

    class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (a0.o0(context).equals(intent.getAction())) {
                if (intent.getBooleanExtra("jsproxy", false)) {
                    a0.this.f3016s.f(true);
                    a0.this.f3001d.x();
                } else {
                    a0.this.f3016s.f(false);
                }
                a0.this.r();
            }
        }
    }

    class b implements k6.d {
        b() {
        }

        public void a() {
            if (!a0.this.f3016s.h() && a0.this.f3016s.i()) {
                Toast.makeText(a0.this.f2998a, a0.this.f2998a.getString(p.f20887h), 1).show();
                a0.this.f3016s.b(false);
            }
            a0.this.r();
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f3026a;

        c(EditText editText) {
            this.f3026a = editText;
        }

        public void onClick(DialogInterface dialogInterface, int i10) {
            a0.this.f3016s.j().c(this.f3026a.getText().toString());
            a0.this.r();
        }
    }

    class d implements k6.d {
        d() {
        }

        public void a() {
            a0.this.f3016s.c(!a0.this.f3016s.a());
            a0.this.f3003f.h();
        }
    }

    class e extends ArrayAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set f3029a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, int i10, String[] strArr, Set set) {
            super(context, i10, strArr);
            this.f3029a = set;
        }

        public boolean areAllItemsEnabled() {
            return false;
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            view2.setEnabled(isEnabled(i10));
            return view2;
        }

        public boolean isEnabled(int i10) {
            return !this.f3029a.contains(getItem(i10));
        }
    }

    class f implements JSCHeapCapture.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d7.h f3031a;

        f(d7.h hVar) {
            this.f3031a = hVar;
        }

        public void a(File file) {
            this.f3031a.a(file.toString());
        }

        public void b(JSCHeapCapture.b bVar) {
            this.f3031a.b(bVar.toString());
        }
    }

    class g implements k6.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.c f3033a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k6.a f3034b;

        g(a.c cVar, k6.a aVar) {
            this.f3033a = cVar;
            this.f3034b = aVar;
        }

        public void a(String str, Integer num, Integer num2) {
            a0.this.f3008k.c(str, num, num2);
            if (a0.this.B != null) {
                a0.this.B.a(str, num, num2);
            }
        }

        public void onFailure(Exception exc) {
            a0.this.r0();
            if (a0.this.B != null) {
                a0.this.B.onFailure(exc);
            }
            z2.a.k("ReactNative", "Unable to download JS bundle", exc);
            a0.this.N0(exc);
            this.f3034b.a(exc);
        }

        public void onSuccess() {
            a0.this.r0();
            if (a0.this.B != null) {
                a0.this.B.onSuccess();
            }
            ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, this.f3033a.c());
            this.f3034b.onSuccess();
        }
    }

    class h implements g.h {
        h() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(d7.h hVar) {
            a0.this.q0(hVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k() {
            a0.this.B();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l() {
            a0.this.r();
        }

        public void a() {
            a0.this.f3020w = true;
        }

        public void b(d7.h hVar) {
            UiThreadUtil.runOnUiThread(new b0(this, hVar));
        }

        public void c() {
            UiThreadUtil.runOnUiThread(new d0(this));
        }

        public void d() {
            if (!InspectorFlags.getFuseboxEnabled()) {
                a0.this.f3001d.n();
            }
            UiThreadUtil.runOnUiThread(new c0(this));
        }

        public void e() {
            a0.this.f3020w = false;
        }

        public Map f() {
            return a0.this.D;
        }
    }

    public a0(Context context, x0 x0Var, String str, boolean z10, k6.i iVar, k6.b bVar, int i10, Map map, j jVar, k6.c cVar, k6.h hVar) {
        this.f3003f = x0Var;
        this.f2998a = context;
        this.f3004g = str;
        f fVar = new f(context, new l(this));
        this.f3016s = fVar;
        this.f3001d = new g(fVar, context, fVar.j());
        this.B = bVar;
        this.f2999b = new e6.g(new m(this), i10);
        this.D = map;
        this.f3000c = new a();
        String p02 = p0();
        this.f3005h = new File(context.getFilesDir(), p02 + "ReactNativeDevBundle.js");
        this.f3006i = context.getDir(p02.toLowerCase(Locale.ROOT) + "_dev_js_split_bundles", 0);
        this.f3007j = new DefaultJSExceptionHandler();
        t(z10);
        this.f3008k = cVar == null ? new d(x0Var) : cVar;
        this.E = jVar;
        this.f3009l = hVar == null ? new v0(new n(this)) : hVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0() {
        Activity j10 = this.f3003f.j();
        if (j10 == null || j10.isFinishing()) {
            z2.a.j("ReactNative", "Unable to launch change bundle location because react activity is not available");
            return;
        }
        EditText editText = new EditText(j10);
        editText.setHint("localhost:8081");
        new AlertDialog.Builder(j10).setTitle(this.f2998a.getString(p.f20881b)).setView(editText).setPositiveButton(17039370, new c(editText)).create().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0() {
        boolean z10 = !this.f3016s.i();
        this.f3016s.b(z10);
        ReactContext reactContext = this.f3015r;
        if (reactContext != null) {
            Class cls = HMRClient.class;
            if (z10) {
                ((HMRClient) reactContext.getJSModule(cls)).enable();
            } else {
                ((HMRClient) reactContext.getJSModule(cls)).disable();
            }
        }
        if (z10 && !this.f3016s.h()) {
            Context context = this.f2998a;
            Toast.makeText(context, context.getString(p.f20888i), 1).show();
            this.f3016s.l(true);
            r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0() {
        if (!this.f3016s.g()) {
            Activity j10 = this.f3003f.j();
            if (j10 == null) {
                z2.a.j("ReactNative", "Unable to get reference to react activity");
            } else {
                c.h(j10);
            }
        }
        x6.a aVar = this.f3016s;
        aVar.e(!aVar.g());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0() {
        Intent intent = new Intent(this.f2998a, DevSettingsActivity.class);
        intent.setFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        this.f2998a.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(k6.d[] dVarArr, DialogInterface dialogInterface, int i10) {
        dVarArr[i10].a();
        this.f3011n = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(DialogInterface dialogInterface) {
        this.f3011n = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(String str, k6.j[] jVarArr, int i10, k6.f fVar) {
        S0(str, jVarArr, i10, fVar);
        if (this.f3010m == null) {
            i c10 = c(NativeRedBoxSpec.NAME);
            if (c10 != null) {
                this.f3010m = c10;
            } else {
                this.f3010m = new a1(this);
            }
            this.f3010m.d(NativeRedBoxSpec.NAME);
        }
        if (!this.f3010m.isShowing()) {
            this.f3010m.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0() {
        x6.a aVar = this.f3016s;
        aVar.c(!aVar.a());
        this.f3003f.h();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I0(int i10, String str, ReadableArray readableArray) {
        i iVar = this.f3010m;
        if ((iVar == null || iVar.isShowing()) && i10 == this.A) {
            S0(str, d1.b(readableArray), i10, k6.f.JS);
            this.f3010m.show();
        }
    }

    private void J0(Exception exc) {
        String str;
        if (exc.getMessage() == null) {
            str = "Exception in native call from JS";
        } else {
            str = exc.getMessage();
        }
        StringBuilder sb2 = new StringBuilder(str);
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            sb2.append("\n\n");
            sb2.append(cause.getMessage());
        }
        if (exc instanceof JavascriptException) {
            z2.a.k("ReactNative", "Exception in native call from JS", exc);
            Q0(exc.getMessage().toString(), new k6.j[0], -1, k6.f.JS);
            return;
        }
        R0(sb2.toString(), exc);
    }

    /* access modifiers changed from: private */
    public void K0() {
        UiThreadUtil.assertOnUiThread();
        if (this.f3019v) {
            c cVar = this.f3012o;
            if (cVar != null) {
                cVar.i(this.f3016s.g());
            }
            if (!this.f3018u) {
                this.f2999b.e((SensorManager) this.f2998a.getSystemService("sensor"));
                this.f3018u = true;
            }
            if (!this.f3017t) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(o0(this.f2998a));
                i0(this.f2998a, this.f3000c, intentFilter, true);
                this.f3017t = true;
            }
            if (this.f3013p) {
                this.f3008k.b("Reloading...");
            }
            this.f3001d.A(getClass().getSimpleName(), new h());
            return;
        }
        c cVar2 = this.f3012o;
        if (cVar2 != null) {
            cVar2.i(false);
        }
        if (this.f3018u) {
            this.f2999b.f();
            this.f3018u = false;
        }
        if (this.f3017t) {
            this.f2998a.unregisterReceiver(this.f3000c);
            this.f3017t = false;
        }
        p();
        s0();
        this.f3008k.a();
        this.f3001d.i();
    }

    /* access modifiers changed from: private */
    public void N0(Exception exc) {
        UiThreadUtil.runOnUiThread(new h(this, exc));
    }

    private void O0(ReactContext reactContext) {
        int defaultPort;
        if (this.f3015r != reactContext) {
            this.f3015r = reactContext;
            c cVar = this.f3012o;
            if (cVar != null) {
                cVar.i(false);
            }
            if (reactContext != null) {
                this.f3012o = new c(reactContext);
            }
            if (this.f3015r != null) {
                try {
                    URL url = new URL(v());
                    String substring = url.getPath().substring(1);
                    String host = url.getHost();
                    if (url.getPort() != -1) {
                        defaultPort = url.getPort();
                    } else {
                        defaultPort = url.getDefaultPort();
                    }
                    ((HMRClient) this.f3015r.getJSModule(HMRClient.class)).setup(com.alibaba.pdns.f.f17924q, substring, host, defaultPort, this.f3016s.i());
                } catch (MalformedURLException e10) {
                    R0(e10.getMessage(), e10);
                }
            }
            M0();
        }
    }

    private void P0(String str) {
        int i10;
        if (this.f2998a != null) {
            try {
                URL url = new URL(str);
                if (url.getPort() != -1) {
                    i10 = url.getPort();
                } else {
                    i10 = url.getDefaultPort();
                }
                k6.c cVar = this.f3008k;
                Context context = this.f2998a;
                int i11 = p.f20891l;
                cVar.b(context.getString(i11, new Object[]{url.getHost() + ":" + i10}));
                this.f3013p = true;
            } catch (MalformedURLException e10) {
                z2.a.j("ReactNative", "Bundle url format is invalid. \n\n" + e10.toString());
            }
        }
    }

    private void Q0(String str, k6.j[] jVarArr, int i10, k6.f fVar) {
        UiThreadUtil.runOnUiThread(new s(this, str, jVarArr, i10, fVar));
    }

    private void S0(String str, k6.j[] jVarArr, int i10, k6.f fVar) {
        this.f3021x = str;
        this.f3022y = jVarArr;
        this.A = i10;
        this.f3023z = fVar;
    }

    private void i0(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z10) {
        int i10;
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(broadcastReceiver, intentFilter);
            return;
        }
        if (z10) {
            i10 = 2;
        } else {
            i10 = 4;
        }
        Intent unused = context.registerReceiver(broadcastReceiver, intentFilter, i10);
    }

    private String m0() {
        try {
            return n0().k().toString();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static String o0(Context context) {
        return context.getPackageName() + ".RELOAD_APP_ACTION";
    }

    /* access modifiers changed from: private */
    public void q0(d7.h hVar) {
        JSCHeapCapture jSCHeapCapture;
        ReactContext reactContext = this.f3015r;
        if (reactContext != null && (jSCHeapCapture = (JSCHeapCapture) reactContext.getNativeModule(JSCHeapCapture.class)) != null) {
            jSCHeapCapture.captureHeap(this.f2998a.getCacheDir().getPath(), new f(hVar));
        }
    }

    private void s0() {
        AlertDialog alertDialog = this.f3011n;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f3011n = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(k6.g gVar) {
        this.f3001d.w(gVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Context u0() {
        Activity j10 = this.f3003f.j();
        if (j10 == null || j10.isFinishing()) {
            return null;
        }
        return j10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(Exception exc) {
        if (exc instanceof e6.c) {
            R0(((e6.c) exc).getMessage(), exc);
        } else {
            R0(this.f2998a.getString(p.f20896q), exc);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(boolean z10) {
        this.f3016s.e(z10);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(boolean z10) {
        this.f3016s.b(z10);
        r();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0(boolean z10) {
        this.f3016s.f(z10);
        r();
    }

    public k6.j[] A() {
        return this.f3022y;
    }

    public void B() {
        String str;
        String str2;
        int i10;
        if (this.f3011n == null && this.f3019v && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            HashSet hashSet = new HashSet();
            linkedHashMap.put(this.f2998a.getString(p.f20895p), new b());
            if (this.f3016s.m()) {
                this.f3016s.f(false);
                r();
            }
            if (this.f3016s.k() && !this.f3016s.m()) {
                boolean z10 = this.f3020w;
                Context context = this.f2998a;
                if (z10) {
                    i10 = p.f20882c;
                } else {
                    i10 = p.f20883d;
                }
                String string = context.getString(i10);
                if (!z10) {
                    hashSet.add(string);
                }
                linkedHashMap.put(string, new v(this));
            }
            linkedHashMap.put(this.f2998a.getString(p.f20881b), new w(this));
            linkedHashMap.put(this.f2998a.getString(p.f20890k), new d());
            if (this.f3016s.i()) {
                str = this.f2998a.getString(p.f20889j);
            } else {
                str = this.f2998a.getString(p.f20886g);
            }
            linkedHashMap.put(str, new x(this));
            if (this.f3016s.g()) {
                str2 = this.f2998a.getString(p.f20894o);
            } else {
                str2 = this.f2998a.getString(p.f20893n);
            }
            linkedHashMap.put(str2, new y(this));
            linkedHashMap.put(this.f2998a.getString(p.f20897r), new z(this));
            if (this.f3002e.size() > 0) {
                linkedHashMap.putAll(this.f3002e);
            }
            k6.d[] dVarArr = (k6.d[]) linkedHashMap.values().toArray(new k6.d[0]);
            Activity j10 = this.f3003f.j();
            if (j10 == null || j10.isFinishing()) {
                z2.a.j("ReactNative", "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            LinearLayout linearLayout = new LinearLayout(j10);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(j10);
            textView.setText(j10.getString(p.f20884e, new Object[]{p0()}));
            textView.setPadding(0, 50, 0, 0);
            textView.setGravity(17);
            textView.setTextSize(16.0f);
            textView.setTypeface(textView.getTypeface(), 1);
            linearLayout.addView(textView);
            String m02 = m0();
            if (m02 != null) {
                TextView textView2 = new TextView(j10);
                textView2.setText(j10.getString(p.f20885f, new Object[]{m02}));
                textView2.setPadding(0, 20, 0, 0);
                textView2.setGravity(17);
                textView2.setTextSize(14.0f);
                linearLayout.addView(textView2);
            }
            AlertDialog create = new AlertDialog.Builder(j10).setCustomTitle(linearLayout).setAdapter(new e(j10, 17367043, (String[]) linkedHashMap.keySet().toArray(new String[0]), hashSet), new i(this, dVarArr)).setOnCancelListener(new j(this)).create();
            this.f3011n = create;
            create.show();
            ReactContext reactContext = this.f3015r;
            if (reactContext != null) {
                ((RCTNativeAppEventEmitter) reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit("RCTDevMenuShown", (Object) null);
            }
        }
    }

    public void C(String str, k6.d dVar) {
        this.f3002e.put(str, dVar);
    }

    public void D(ReactContext reactContext) {
        if (reactContext == this.f3015r) {
            O0((ReactContext) null);
        }
    }

    /* renamed from: E */
    public void z0() {
        this.f3001d.y(this.f3015r, this.f2998a.getString(p.f20892m));
    }

    public void F(String str, ReadableArray readableArray, int i10) {
        UiThreadUtil.runOnUiThread(new t(this, i10, str, readableArray));
    }

    public void L0(String str, k6.a aVar) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        P0(str);
        a.c cVar = new a.c();
        this.f3001d.o(new g(cVar, aVar), this.f3005h, str, cVar);
    }

    public void M0() {
        if (UiThreadUtil.isOnUiThread()) {
            K0();
        } else {
            UiThreadUtil.runOnUiThread(new r(this));
        }
    }

    public void R0(String str, Throwable th) {
        z2.a.k("ReactNative", "Exception in native call", th);
        Q0(str, d1.a(th), -1, k6.f.NATIVE);
    }

    public View a(String str) {
        return this.f3003f.a(str);
    }

    public void b(boolean z10) {
        if (this.f3019v) {
            UiThreadUtil.runOnUiThread(new p(this, z10));
        }
    }

    public i c(String str) {
        j jVar = this.E;
        if (jVar == null) {
            return null;
        }
        return jVar.c(str);
    }

    public void d(View view) {
        this.f3003f.d(view);
    }

    public void e(boolean z10) {
        if (this.f3019v) {
            UiThreadUtil.runOnUiThread(new k(this, z10));
        }
    }

    public void f(boolean z10) {
        if (this.f3019v) {
            UiThreadUtil.runOnUiThread(new u(this, z10));
        }
    }

    public void g() {
        this.f3009l.g();
    }

    public void h() {
        if (this.f3019v) {
            UiThreadUtil.runOnUiThread(new q(this));
        }
    }

    public void handleException(Exception exc) {
        if (this.f3019v) {
            J0(exc);
        } else {
            this.f3007j.handleException(exc);
        }
    }

    public void i(String str, e.a aVar) {
        this.f3009l.i(str, aVar);
    }

    public Activity j() {
        return this.f3003f.j();
    }

    public k6.c j0() {
        return this.f3008k;
    }

    public String k() {
        return this.f3005h.getAbsolutePath();
    }

    public g k0() {
        return this.f3001d;
    }

    public String l() {
        return this.f3021x;
    }

    public String l0() {
        return this.f3004g;
    }

    public void m() {
        this.f3001d.h();
    }

    public boolean n() {
        return this.f3019v;
    }

    public x0 n0() {
        return this.f3003f;
    }

    public void o(k6.g gVar) {
        new o(this, gVar).run();
    }

    public void p() {
        i iVar = this.f3010m;
        if (iVar != null) {
            iVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public abstract String p0();

    public void q(ReactContext reactContext) {
        O0(reactContext);
    }

    /* access modifiers changed from: protected */
    public void r0() {
        this.f3008k.a();
        this.f3013p = false;
    }

    public Pair s(Pair pair) {
        List list = this.C;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                c.d.a(it.next());
                throw null;
            }
        }
        return pair;
    }

    public void t(boolean z10) {
        this.f3019v = z10;
        M0();
    }

    public k6.f u() {
        return this.f3023z;
    }

    public String v() {
        String str = this.f3004g;
        if (str == null) {
            return "";
        }
        return this.f3001d.v((String) p5.a.c(str));
    }

    public x6.a w() {
        return this.f3016s;
    }

    public k6.i x() {
        return null;
    }

    public void y() {
        if (this.f3019v) {
            this.f3001d.z();
        }
    }

    public boolean z() {
        if (this.f3019v && this.f3005h.exists()) {
            try {
                String packageName = this.f2998a.getPackageName();
                if (this.f3005h.lastModified() > this.f2998a.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, "/data/local/tmp/exopackage/%s//secondary-dex", new Object[]{packageName}));
                    if (!file.exists() || this.f3005h.lastModified() > file.lastModified()) {
                        return true;
                    }
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                z2.a.j("ReactNative", "DevSupport is unable to get current app info");
            }
        }
        return false;
    }
}
