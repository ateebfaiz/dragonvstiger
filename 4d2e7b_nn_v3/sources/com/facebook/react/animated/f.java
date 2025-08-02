package com.facebook.react.animated;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.view.b;
import java.util.Iterator;
import java.util.List;

class f extends b implements d {

    /* renamed from: e  reason: collision with root package name */
    private final p f2786e;

    /* renamed from: f  reason: collision with root package name */
    private final ReactApplicationContext f2787f;

    /* renamed from: g  reason: collision with root package name */
    private int f2788g;

    /* renamed from: h  reason: collision with root package name */
    private int f2789h;

    /* renamed from: i  reason: collision with root package name */
    private int f2790i;

    /* renamed from: j  reason: collision with root package name */
    private int f2791j;

    /* renamed from: k  reason: collision with root package name */
    private ReadableMap f2792k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2793l;

    public f(ReadableMap readableMap, p pVar, ReactApplicationContext reactApplicationContext) {
        this.f2786e = pVar;
        this.f2787f = reactApplicationContext;
        a(readableMap);
    }

    private Context j() {
        Activity currentActivity = this.f2787f.getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        return k(this);
    }

    private static Context k(b bVar) {
        List list = bVar.f2775a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                b bVar2 = (b) it.next();
                if (!(bVar2 instanceof r)) {
                    return k(bVar2);
                }
                View k10 = ((r) bVar2).k();
                if (k10 != null) {
                    return k10.getContext();
                }
                return null;
            }
        }
        return null;
    }

    private void l() {
        Context j10;
        if (this.f2792k != null && !this.f2793l && (j10 = j()) != null) {
            int intValue = ColorPropConverter.getColor(this.f2792k, j10).intValue();
            ((b0) this.f2786e.k(this.f2788g)).f2779e = (double) Color.red(intValue);
            ((b0) this.f2786e.k(this.f2789h)).f2779e = (double) Color.green(intValue);
            ((b0) this.f2786e.k(this.f2790i)).f2779e = (double) Color.blue(intValue);
            ((b0) this.f2786e.k(this.f2791j)).f2779e = ((double) Color.alpha(intValue)) / 255.0d;
            this.f2793l = true;
        }
    }

    public void a(ReadableMap readableMap) {
        this.f2788g = readableMap.getInt("r");
        this.f2789h = readableMap.getInt("g");
        this.f2790i = readableMap.getInt("b");
        this.f2791j = readableMap.getInt("a");
        this.f2792k = readableMap.getMap("nativeColor");
        this.f2793l = false;
        l();
    }

    public String e() {
        return "ColorAnimatedNode[" + this.f2778d + "]: r: " + this.f2788g + " g: " + this.f2789h + " b: " + this.f2790i + " a: " + this.f2791j;
    }

    public int i() {
        l();
        return b.b(((b0) this.f2786e.k(this.f2788g)).l(), ((b0) this.f2786e.k(this.f2789h)).l(), ((b0) this.f2786e.k(this.f2790i)).l(), ((b0) this.f2786e.k(this.f2791j)).l());
    }
}
