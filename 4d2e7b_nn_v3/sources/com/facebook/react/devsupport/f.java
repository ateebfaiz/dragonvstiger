package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import d7.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class f implements x6.a, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3074e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f3075a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f3076b;

    /* renamed from: c  reason: collision with root package name */
    private final d f3077c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3078d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a();
    }

    public f(Context context, b bVar) {
        m.f(context, "applicationContext");
        this.f3075a = bVar;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        m.e(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.f3076b = defaultSharedPreferences;
        this.f3077c = new d(context);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public boolean a() {
        return this.f3076b.getBoolean("inspector_debug", false);
    }

    public void b(boolean z10) {
        this.f3076b.edit().putBoolean("hot_module_replacement", z10).apply();
    }

    public void c(boolean z10) {
        this.f3076b.edit().putBoolean("inspector_debug", z10).apply();
    }

    public boolean d() {
        return this.f3076b.getBoolean("js_minify_debug", false);
    }

    public void e(boolean z10) {
        this.f3076b.edit().putBoolean("fps_debug", z10).apply();
    }

    public void f(boolean z10) {
        this.f3076b.edit().putBoolean("remote_js_debug", z10).apply();
    }

    public boolean g() {
        return this.f3076b.getBoolean("fps_debug", false);
    }

    public boolean h() {
        return this.f3076b.getBoolean("js_dev_mode_debug", true);
    }

    public boolean i() {
        return this.f3076b.getBoolean("hot_module_replacement", true);
    }

    public d j() {
        return this.f3077c;
    }

    public boolean k() {
        return this.f3078d;
    }

    public void l(boolean z10) {
        this.f3076b.edit().putBoolean("js_dev_mode_debug", z10).apply();
    }

    public boolean m() {
        return this.f3076b.getBoolean("remote_js_debug", false);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m.f(sharedPreferences, "sharedPreferences");
        if (this.f3075a == null) {
            return;
        }
        if (m.b("fps_debug", str) || m.b("js_dev_mode_debug", str) || m.b("start_sampling_profiler_on_init", str) || m.b("js_minify_debug", str)) {
            this.f3075a.a();
        }
    }
}
