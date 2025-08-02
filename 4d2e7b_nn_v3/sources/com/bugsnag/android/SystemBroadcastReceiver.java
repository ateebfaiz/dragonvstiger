package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import io.jsonwebtoken.JwtParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class SystemBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18600d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final z f18601a;

    /* renamed from: b  reason: collision with root package name */
    private final s2 f18602b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f18603c = b();

    public static final class a {
        private a() {
        }

        public final boolean a(String str) {
            return j.F(str, "android.", false, 2, (Object) null);
        }

        public final void b(Context context, SystemBroadcastReceiver systemBroadcastReceiver, s2 s2Var) {
            if (!systemBroadcastReceiver.c().isEmpty()) {
                IntentFilter intentFilter = new IntentFilter();
                for (String addAction : systemBroadcastReceiver.c().keySet()) {
                    intentFilter.addAction(addAction);
                }
                l0.e(context, systemBroadcastReceiver, intentFilter, s2Var);
            }
        }

        public final String c(String str) {
            if (a(str)) {
                return j.J0(str, JwtParser.SEPARATOR_CHAR, (String) null, 2, (Object) null);
            }
            return str;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SystemBroadcastReceiver(z zVar, s2 s2Var) {
        this.f18601a = zVar;
        this.f18602b = s2Var;
    }

    private final void a(Intent intent, Map map, String str) {
        Set<String> keySet;
        Bundle extras = intent.getExtras();
        if (extras != null && (keySet = extras.keySet()) != null) {
            for (String str2 : keySet) {
                Object obj = extras.get(str2);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (f18600d.a(str2)) {
                        map.put("Extra", str + ": " + obj2);
                    } else {
                        map.put(str2, obj2);
                    }
                }
            }
        }
    }

    private final Map b() {
        HashMap hashMap = new HashMap();
        c1.j m10 = this.f18601a.m();
        BreadcrumbType breadcrumbType = BreadcrumbType.USER;
        if (!m10.J(breadcrumbType)) {
            hashMap.put("android.appwidget.action.APPWIDGET_DELETED", breadcrumbType);
            hashMap.put("android.appwidget.action.APPWIDGET_DISABLED", breadcrumbType);
            hashMap.put("android.appwidget.action.APPWIDGET_ENABLED", breadcrumbType);
            hashMap.put("android.intent.action.CAMERA_BUTTON", breadcrumbType);
            hashMap.put("android.intent.action.CLOSE_SYSTEM_DIALOGS", breadcrumbType);
            hashMap.put("android.intent.action.DOCK_EVENT", breadcrumbType);
        }
        BreadcrumbType breadcrumbType2 = BreadcrumbType.STATE;
        if (!m10.J(breadcrumbType2)) {
            hashMap.put("android.appwidget.action.APPWIDGET_HOST_RESTORED", breadcrumbType2);
            hashMap.put("android.appwidget.action.APPWIDGET_RESTORED", breadcrumbType2);
            hashMap.put("android.appwidget.action.APPWIDGET_UPDATE", breadcrumbType2);
            hashMap.put("android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", breadcrumbType2);
            hashMap.put("android.intent.action.ACTION_POWER_CONNECTED", breadcrumbType2);
            hashMap.put("android.intent.action.ACTION_POWER_DISCONNECTED", breadcrumbType2);
            hashMap.put("android.intent.action.ACTION_SHUTDOWN", breadcrumbType2);
            hashMap.put("android.intent.action.AIRPLANE_MODE", breadcrumbType2);
            hashMap.put("android.intent.action.BATTERY_LOW", breadcrumbType2);
            hashMap.put("android.intent.action.BATTERY_OKAY", breadcrumbType2);
            hashMap.put("android.intent.action.BOOT_COMPLETED", breadcrumbType2);
            hashMap.put("android.intent.action.CONFIGURATION_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.CONTENT_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.DATE_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.DEVICE_STORAGE_LOW", breadcrumbType2);
            hashMap.put("android.intent.action.DEVICE_STORAGE_OK", breadcrumbType2);
            hashMap.put("android.intent.action.INPUT_METHOD_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.LOCALE_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.REBOOT", breadcrumbType2);
            hashMap.put("android.intent.action.SCREEN_OFF", breadcrumbType2);
            hashMap.put("android.intent.action.SCREEN_ON", breadcrumbType2);
            hashMap.put("android.intent.action.TIMEZONE_CHANGED", breadcrumbType2);
            hashMap.put("android.intent.action.TIME_SET", breadcrumbType2);
            hashMap.put("android.os.action.DEVICE_IDLE_MODE_CHANGED", breadcrumbType2);
            hashMap.put("android.os.action.POWER_SAVE_MODE_CHANGED", breadcrumbType2);
        }
        BreadcrumbType breadcrumbType3 = BreadcrumbType.NAVIGATION;
        if (!m10.J(breadcrumbType3)) {
            hashMap.put("android.intent.action.DREAMING_STARTED", breadcrumbType3);
            hashMap.put("android.intent.action.DREAMING_STOPPED", breadcrumbType3);
        }
        return hashMap;
    }

    public static final void d(Context context, SystemBroadcastReceiver systemBroadcastReceiver, s2 s2Var) {
        f18600d.b(context, systemBroadcastReceiver, s2Var);
    }

    public final Map c() {
        return this.f18603c;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            HashMap hashMap = new HashMap();
            String action = intent.getAction();
            if (action != null) {
                String c10 = f18600d.c(action);
                hashMap.put("Intent Action", action);
                a(intent, hashMap, c10);
                BreadcrumbType breadcrumbType = (BreadcrumbType) this.f18603c.get(action);
                if (breadcrumbType == null) {
                    breadcrumbType = BreadcrumbType.STATE;
                }
                this.f18601a.B(c10, hashMap, breadcrumbType);
            }
        } catch (Exception e10) {
            this.f18602b.g(m.n("Failed to leave breadcrumb in SystemBroadcastReceiver: ", e10.getMessage()));
        }
    }
}
