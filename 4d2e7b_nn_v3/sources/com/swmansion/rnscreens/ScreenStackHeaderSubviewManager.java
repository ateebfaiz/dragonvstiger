package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.x;
import p7.y;

@s6.a(name = "RNSScreenStackHeaderSubview")
public final class ScreenStackHeaderSubviewManager extends ViewGroupManager<ScreenStackHeaderSubview> implements y {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";
    private final c2 delegate = new x(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderSubview createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new ScreenStackHeaderSubview(e1Var);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r3.setType(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        return;
     */
    @h7.a(name = "type")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setType(com.swmansion.rnscreens.ScreenStackHeaderSubview r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r3, r0)
            if (r4 == 0) goto L_0x0049
            int r0 = r4.hashCode()
            switch(r0) {
                case -1364013995: goto L_0x003b;
                case 3015911: goto L_0x0030;
                case 3317767: goto L_0x0025;
                case 108511772: goto L_0x001a;
                case 1778179403: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0049
        L_0x000f:
            java.lang.String r0 = "searchBar"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$a r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.SEARCH_BAR
            goto L_0x0045
        L_0x001a:
            java.lang.String r0 = "right"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$a r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.RIGHT
            goto L_0x0045
        L_0x0025:
            java.lang.String r0 = "left"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$a r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.LEFT
            goto L_0x0045
        L_0x0030:
            java.lang.String r0 = "back"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$a r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.BACK
            goto L_0x0045
        L_0x003b:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0049
            com.swmansion.rnscreens.ScreenStackHeaderSubview$a r4 = com.swmansion.rnscreens.ScreenStackHeaderSubview.a.CENTER
        L_0x0045:
            r3.setType(r4)
            return
        L_0x0049:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r3 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown type "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenStackHeaderSubviewManager.setType(com.swmansion.rnscreens.ScreenStackHeaderSubview, java.lang.String):void");
    }
}
