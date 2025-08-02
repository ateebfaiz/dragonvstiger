package com.facebook.react.animated;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.s;
import i7.a;
import java.util.HashMap;
import java.util.Map;

class r extends b {

    /* renamed from: e  reason: collision with root package name */
    private int f2849e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final p f2850f;

    /* renamed from: g  reason: collision with root package name */
    private final Map f2851g;

    /* renamed from: h  reason: collision with root package name */
    private final JavaOnlyMap f2852h;

    /* renamed from: i  reason: collision with root package name */
    private UIManager f2853i;

    r(ReadableMap readableMap, p pVar) {
        ReadableMap map = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.f2851g = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.f2851g.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.f2852h = new JavaOnlyMap();
        this.f2850f = pVar;
    }

    public String e() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PropsAnimatedNode[");
        sb2.append(this.f2778d);
        sb2.append("] connectedViewTag: ");
        sb2.append(this.f2849e);
        sb2.append(" mPropNodeMapping: ");
        Map map = this.f2851g;
        String str2 = "null";
        if (map != null) {
            str = map.toString();
        } else {
            str = str2;
        }
        sb2.append(str);
        sb2.append(" mPropMap: ");
        JavaOnlyMap javaOnlyMap = this.f2852h;
        if (javaOnlyMap != null) {
            str2 = javaOnlyMap.toString();
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public void i(int i10, UIManager uIManager) {
        if (this.f2849e == -1) {
            this.f2849e = i10;
            this.f2853i = uIManager;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node " + this.f2778d + " is already attached to a view: " + this.f2849e);
    }

    public void j(int i10) {
        int i11 = this.f2849e;
        if (i11 == i10 || i11 == -1) {
            this.f2849e = -1;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node: " + i10 + " but is connected to view " + this.f2849e);
    }

    public View k() {
        try {
            return this.f2853i.resolveView(this.f2849e);
        } catch (s unused) {
            return null;
        }
    }

    public void l() {
        int i10 = this.f2849e;
        if (i10 != -1 && a.a(i10) != 2) {
            ReadableMapKeySetIterator keySetIterator = this.f2852h.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                this.f2852h.putNull(keySetIterator.nextKey());
            }
            this.f2853i.synchronouslyUpdateViewOnUIThread(this.f2849e, this.f2852h);
        }
    }

    public final void m() {
        if (this.f2849e != -1) {
            for (Map.Entry entry : this.f2851g.entrySet()) {
                b k10 = this.f2850f.k(((Integer) entry.getValue()).intValue());
                if (k10 == null) {
                    throw new IllegalArgumentException("Mapped property node does not exist");
                } else if (k10 instanceof u) {
                    ((u) k10).i(this.f2852h);
                } else if (k10 instanceof b0) {
                    b0 b0Var = (b0) k10;
                    Object k11 = b0Var.k();
                    if (k11 instanceof Integer) {
                        this.f2852h.putInt((String) entry.getKey(), ((Integer) k11).intValue());
                    } else if (k11 instanceof String) {
                        this.f2852h.putString((String) entry.getKey(), (String) k11);
                    } else {
                        this.f2852h.putDouble((String) entry.getKey(), b0Var.l());
                    }
                } else if (k10 instanceof f) {
                    this.f2852h.putInt((String) entry.getKey(), ((f) k10).i());
                } else if (k10 instanceof q) {
                    ((q) k10).i((String) entry.getKey(), this.f2852h);
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used in property node " + k10.getClass());
                }
            }
            this.f2853i.synchronouslyUpdateViewOnUIThread(this.f2849e, this.f2852h);
        }
    }
}
