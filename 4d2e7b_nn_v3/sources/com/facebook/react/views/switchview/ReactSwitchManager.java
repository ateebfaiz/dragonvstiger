package com.facebook.react.views.switchview;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.v;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import com.facebook.yoga.q;
import p7.g;
import p7.h;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> implements h {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new a();
    public static final String REACT_CLASS = "AndroidSwitch";
    private final c2 mDelegate = new g(this);

    class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            ReactContext reactContext = (ReactContext) compoundButton.getContext();
            int id2 = compoundButton.getId();
            k1.c(reactContext, id2).c(new a(k1.e(reactContext), id2, z10));
        }
    }

    static class b extends v implements n {
        private int A;
        private int B;
        private boolean C;

        private void w1() {
            X0(this);
        }

        public long U(q qVar, float f10, o oVar, float f11, o oVar2) {
            if (!this.C) {
                ReactSwitch reactSwitch = new ReactSwitch(F());
                reactSwitch.setShowText(false);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
                this.A = reactSwitch.getMeasuredWidth();
                this.B = reactSwitch.getMeasuredHeight();
                this.C = true;
            }
            return p.b(this.A, this.B);
        }

        private b() {
            w1();
        }
    }

    private static void setValueInternal(ReactSwitch reactSwitch, boolean z10) {
        reactSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        reactSwitch.setOn(z10);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class getShadowNodeClass() {
        return b.class;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f10, o oVar, float f11, o oVar2, @Nullable float[] fArr) {
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
        return p.a(g0.b((float) reactSwitch.getMeasuredWidth()), g0.b((float) reactSwitch.getMeasuredHeight()));
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(e1 e1Var, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    public v createShadowNodeInstance() {
        return new b();
    }

    /* access modifiers changed from: protected */
    public ReactSwitch createViewInstance(e1 e1Var) {
        ReactSwitch reactSwitch = new ReactSwitch(e1Var);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    public void receiveCommand(@NonNull ReactSwitch reactSwitch, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeValue")) {
            boolean z10 = false;
            if (readableArray != null && readableArray.getBoolean(0)) {
                z10 = true;
            }
            setValueInternal(reactSwitch, z10);
        }
    }

    @h7.a(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSwitch reactSwitch, boolean z10) {
        reactSwitch.setEnabled(!z10);
    }

    @h7.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwitch reactSwitch, boolean z10) {
        reactSwitch.setEnabled(z10);
    }

    public void setNativeValue(ReactSwitch reactSwitch, boolean z10) {
        setValueInternal(reactSwitch, z10);
    }

    @h7.a(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z10) {
        setValueInternal(reactSwitch, z10);
    }

    @h7.a(customType = "Color", name = "thumbColor")
    public void setThumbColor(ReactSwitch reactSwitch, @Nullable Integer num) {
        reactSwitch.setThumbColor(num);
    }

    @h7.a(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, @Nullable Integer num) {
        setThumbColor(reactSwitch, num);
    }

    @h7.a(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(ReactSwitch reactSwitch, @Nullable Integer num) {
        reactSwitch.setTrackColorForFalse(num);
    }

    @h7.a(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(ReactSwitch reactSwitch, @Nullable Integer num) {
        reactSwitch.setTrackColorForTrue(num);
    }

    @h7.a(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, @Nullable Integer num) {
        reactSwitch.setTrackColor(num);
    }

    @h7.a(name = "value")
    public void setValue(ReactSwitch reactSwitch, boolean z10) {
        setValueInternal(reactSwitch, z10);
    }
}
