package com.th3rdwave.safeareacontext;

import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.v0;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@s6.a(name = "RNCSafeAreaView")
public final class SafeAreaViewManager extends ReactViewManager {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNCSafeAreaView";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return null;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<n> getShadowNodeClass() {
        return n.class;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r2 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        if (r3 == null) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r7 == null) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r0 == null) goto L_0x0020;
     */
    @h7.a(name = "edges")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setEdges(com.th3rdwave.safeareacontext.SafeAreaView r6, com.facebook.react.bridge.ReadableMap r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r6, r0)
            if (r7 == 0) goto L_0x0075
            java.lang.String r0 = "top"
            java.lang.String r0 = r7.getString(r0)
            java.lang.String r1 = "toUpperCase(...)"
            if (r0 == 0) goto L_0x0020
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r2)
            kotlin.jvm.internal.m.e(r0, r1)
            com.th3rdwave.safeareacontext.j r0 = com.th3rdwave.safeareacontext.j.valueOf(r0)
            if (r0 != 0) goto L_0x0022
        L_0x0020:
            com.th3rdwave.safeareacontext.j r0 = com.th3rdwave.safeareacontext.j.OFF
        L_0x0022:
            java.lang.String r2 = "right"
            java.lang.String r2 = r7.getString(r2)
            if (r2 == 0) goto L_0x0039
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toUpperCase(r3)
            kotlin.jvm.internal.m.e(r2, r1)
            com.th3rdwave.safeareacontext.j r2 = com.th3rdwave.safeareacontext.j.valueOf(r2)
            if (r2 != 0) goto L_0x003b
        L_0x0039:
            com.th3rdwave.safeareacontext.j r2 = com.th3rdwave.safeareacontext.j.OFF
        L_0x003b:
            java.lang.String r3 = "bottom"
            java.lang.String r3 = r7.getString(r3)
            if (r3 == 0) goto L_0x0052
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toUpperCase(r4)
            kotlin.jvm.internal.m.e(r3, r1)
            com.th3rdwave.safeareacontext.j r3 = com.th3rdwave.safeareacontext.j.valueOf(r3)
            if (r3 != 0) goto L_0x0054
        L_0x0052:
            com.th3rdwave.safeareacontext.j r3 = com.th3rdwave.safeareacontext.j.OFF
        L_0x0054:
            java.lang.String r4 = "left"
            java.lang.String r7 = r7.getString(r4)
            if (r7 == 0) goto L_0x006b
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r7 = r7.toUpperCase(r4)
            kotlin.jvm.internal.m.e(r7, r1)
            com.th3rdwave.safeareacontext.j r7 = com.th3rdwave.safeareacontext.j.valueOf(r7)
            if (r7 != 0) goto L_0x006d
        L_0x006b:
            com.th3rdwave.safeareacontext.j r7 = com.th3rdwave.safeareacontext.j.OFF
        L_0x006d:
            com.th3rdwave.safeareacontext.k r1 = new com.th3rdwave.safeareacontext.k
            r1.<init>(r0, r2, r3, r7)
            r6.setEdges(r1)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaViewManager.setEdges(com.th3rdwave.safeareacontext.SafeAreaView, com.facebook.react.bridge.ReadableMap):void");
    }

    @h7.a(name = "mode")
    public void setMode(SafeAreaView safeAreaView, String str) {
        m.f(safeAreaView, "view");
        if (m.b(str, "padding")) {
            safeAreaView.setMode(m.PADDING);
        } else if (m.b(str, "margin")) {
            safeAreaView.setMode(m.MARGIN);
        }
    }

    public Object updateState(ReactViewGroup reactViewGroup, v0 v0Var, d1 d1Var) {
        m.f(reactViewGroup, "view");
        ((SafeAreaView) reactViewGroup).setStateWrapper(d1Var);
        return null;
    }

    public n createShadowNodeInstance() {
        return new n();
    }

    public SafeAreaView createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new SafeAreaView(e1Var);
    }
}
