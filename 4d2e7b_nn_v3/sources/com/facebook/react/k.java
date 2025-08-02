package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.alpha0010.fs.c;
import com.bugsnag.android.t;
import com.horcrux.svg.SvgPackage;
import com.reactnativecommunity.asyncstorage.i;
import com.shopify.reactnative.flash_list.d;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.h;
import com.th3rdwave.safeareacontext.e;
import f7.a;
import f7.s;
import java.util.ArrayList;
import java.util.Arrays;
import kb.f;
import org.cocos2dx.javascript.R;
import ta.g;
import ua.b;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private Application f20838a;

    /* renamed from: b  reason: collision with root package name */
    private k0 f20839b;

    public k(k0 k0Var) {
        this(k0Var, (a) null);
    }

    private Application a() {
        k0 k0Var = this.f20839b;
        if (k0Var == null) {
            return this.f20838a;
        }
        return k0Var.b();
    }

    private Context b() {
        return a().getApplicationContext();
    }

    private Resources d() {
        return a().getResources();
    }

    public ArrayList c() {
        return new ArrayList(Arrays.asList(new m0[]{new s((a) null), new t(), new i(), new g(), new b(), new d(), new com.airbnb.android.react.lottie.i(), new com.microsoft.codepush.react.a(d().getString(R.string.CodePushDeploymentKey), b(), false), new c(), new za.d(), new com.reactnative.ivpusic.imagepicker.d(), new com.reactnativepagerview.a(), new f(), new ReanimatedPackage(), new e(), new h(), new SvgPackage(), new lb.c(), new com.reactnativecommunity.webview.k()}));
    }

    public k(k0 k0Var, a aVar) {
        this.f20839b = k0Var;
    }
}
