package com.facebook.react.views.drawer;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.p;
import e6.f;
import java.util.HashMap;
import java.util.Map;
import p7.b;
import s7.c;
import s7.d;

@s6.a(name = "AndroidDrawerLayout")
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> implements b {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    private final c2 mDelegate = new p7.a(this);

    public static class a implements DrawerLayout.DrawerListener {

        /* renamed from: a  reason: collision with root package name */
        private final DrawerLayout f3988a;

        /* renamed from: b  reason: collision with root package name */
        private final e f3989b;

        public a(DrawerLayout drawerLayout, e eVar) {
            this.f3988a = drawerLayout;
            this.f3989b = eVar;
        }

        public void onDrawerClosed(View view) {
            this.f3989b.c(new s7.a(k1.f(this.f3988a), this.f3988a.getId()));
        }

        public void onDrawerOpened(View view) {
            this.f3989b.c(new s7.b(k1.f(this.f3988a), this.f3988a.getId()));
        }

        public void onDrawerSlide(View view, float f10) {
            this.f3989b.c(new c(k1.f(this.f3988a), this.f3988a.getId(), f10));
        }

        public void onDrawerStateChanged(int i10) {
            this.f3989b.c(new d(k1.f(this.f3988a), this.f3988a.getId(), i10));
        }
    }

    private void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str.equals("left")) {
            reactDrawerLayout.c(GravityCompat.START);
        } else if (str.equals("right")) {
            reactDrawerLayout.c(GravityCompat.END);
        } else {
            z2.a.G("ReactNative", "drawerPosition must be 'left' or 'right', received" + str);
            reactDrawerLayout.c(GravityCompat.START);
        }
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return f.e("openDrawer", 1, "closeDrawer", 2);
    }

    public c2 getDelegate() {
        return this.mDelegate;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(f.g("topDrawerSlide", f.d("registrationName", "onDrawerSlide"), "topDrawerOpen", f.d("registrationName", "onDrawerOpen"), "topDrawerClose", f.d("registrationName", "onDrawerClose"), "topDrawerStateChanged", f.d("registrationName", "onDrawerStateChanged")));
        return exportedCustomDirectEventTypeConstants;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return f.d("DrawerPosition", f.e("Left", Integer.valueOf(GravityCompat.START), "Right", Integer.valueOf(GravityCompat.END)));
    }

    @NonNull
    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @h7.a(customType = "Color", name = "drawerBackgroundColor")
    public void setDrawerBackgroundColor(ReactDrawerLayout reactDrawerLayout, @Nullable Integer num) {
    }

    @h7.a(name = "keyboardDismissMode")
    public void setKeyboardDismissMode(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
    }

    @h7.a(customType = "Color", name = "statusBarBackgroundColor")
    public void setStatusBarBackgroundColor(ReactDrawerLayout reactDrawerLayout, @Nullable Integer num) {
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(@NonNull e1 e1Var, ReactDrawerLayout reactDrawerLayout) {
        e c10 = k1.c(e1Var, reactDrawerLayout.getId());
        if (c10 != null) {
            reactDrawerLayout.addDrawerListener(new a(reactDrawerLayout, c10));
        }
    }

    public void closeDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.a();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public ReactDrawerLayout createViewInstance(@NonNull e1 e1Var) {
        return new ReactDrawerLayout(e1Var);
    }

    public void openDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.b();
    }

    @h7.a(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            z2.a.G("ReactNative", "Unknown drawerLockMode " + str);
            reactDrawerLayout.setDrawerLockMode(0);
        }
    }

    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, @Nullable String str) {
        if (str == null) {
            reactDrawerLayout.c(GravityCompat.START);
        } else {
            setDrawerPositionInternal(reactDrawerLayout, str);
        }
    }

    @h7.a(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f10) {
        int i10;
        if (Float.isNaN(f10)) {
            i10 = -1;
        } else {
            i10 = Math.round(g0.d(f10));
        }
        reactDrawerLayout.e(i10);
    }

    public void setElevation(@NonNull ReactDrawerLayout reactDrawerLayout, float f10) {
        reactDrawerLayout.setDrawerElevation(g0.d(f10));
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i10) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i10 == 0 || i10 == 1) {
            reactDrawerLayout.addView(view, i10);
            reactDrawerLayout.d();
        } else {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i10 + " instead.");
        }
    }

    public void receiveCommand(@NonNull ReactDrawerLayout reactDrawerLayout, int i10, @Nullable ReadableArray readableArray) {
        if (i10 == 1) {
            reactDrawerLayout.b();
        } else if (i10 == 2) {
            reactDrawerLayout.a();
        }
    }

    @h7.a(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.c(GravityCompat.START);
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.c(asInt);
                return;
            }
            z2.a.G("ReactNative", "Unknown drawerPosition " + asInt);
            reactDrawerLayout.c(GravityCompat.START);
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(reactDrawerLayout, dynamic.asString());
        } else {
            z2.a.G("ReactNative", "drawerPosition must be a string or int");
            reactDrawerLayout.c(GravityCompat.START);
        }
    }

    public void receiveCommand(@NonNull ReactDrawerLayout reactDrawerLayout, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("closeDrawer")) {
            reactDrawerLayout.a();
        } else if (str.equals("openDrawer")) {
            reactDrawerLayout.b();
        }
    }

    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, @Nullable Float f10) {
        reactDrawerLayout.e(f10 == null ? -1 : Math.round(g0.d(f10.floatValue())));
    }
}
