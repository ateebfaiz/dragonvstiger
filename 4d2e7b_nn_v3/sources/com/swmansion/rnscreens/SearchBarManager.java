package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.p;
import e6.f;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import p7.a0;
import p7.b0;

@s6.a(name = "RNSSearchBar")
public final class SearchBarManager extends ViewGroupManager<SearchBarView> implements b0 {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSSearchBar";
    private final c2 delegate = new a0(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void logNotAvailable(String str) {
        Log.w("[RNScreens]", str + " prop is not available on Android");
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.delegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return f.i("topSearchBlur", f.d("registrationName", "onSearchBlur"), "topChangeText", f.d("registrationName", "onChangeText"), "topClose", f.d("registrationName", "onClose"), "topSearchFocus", f.d("registrationName", "onSearchFocus"), "topOpen", f.d("registrationName", "onOpen"), "topSearchButtonPress", f.d("registrationName", "onSearchButtonPress"));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @h7.a(name = "autoFocus")
    public final void setAutoFocus(SearchBarView searchBarView, Boolean bool) {
        boolean z10;
        m.f(searchBarView, "view");
        if (bool != null) {
            z10 = bool.booleanValue();
        } else {
            z10 = false;
        }
        searchBarView.setAutoFocus(z10);
    }

    public void blur(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.y();
        }
    }

    public void cancelSearch(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.C();
        }
    }

    public void clearText(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.z();
        }
    }

    /* access modifiers changed from: protected */
    public SearchBarView createViewInstance(e1 e1Var) {
        m.f(e1Var, "context");
        return new SearchBarView(e1Var);
    }

    public void focus(SearchBarView searchBarView) {
        if (searchBarView != null) {
            searchBarView.C();
        }
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(SearchBarView searchBarView) {
        m.f(searchBarView, "view");
        super.onAfterUpdateTransaction(searchBarView);
        searchBarView.I();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r3.equals(com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef.NONE) != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden auto capitalize value passed");
     */
    @h7.a(name = "autoCapitalize")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAutoCapitalize(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case 3387192: goto L_0x0030;
                case 113318569: goto L_0x0025;
                case 490141296: goto L_0x001a;
                case 1245424234: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "characters"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$a r3 = com.swmansion.rnscreens.SearchBarView.a.CHARACTERS
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "sentences"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$a r3 = com.swmansion.rnscreens.SearchBarView.a.SENTENCES
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "words"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$a r3 = com.swmansion.rnscreens.SearchBarView.a.WORDS
            goto L_0x0043
        L_0x0030:
            java.lang.String r0 = "none"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden auto capitalize value passed"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$a r3 = com.swmansion.rnscreens.SearchBarView.a.NONE
        L_0x0043:
            r2.setAutoCapitalize(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setAutoCapitalize(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    @h7.a(customType = "Color", name = "barTintColor")
    public void setBarTintColor(SearchBarView searchBarView, Integer num) {
        m.f(searchBarView, "view");
        searchBarView.setTintColor(num);
    }

    public void setCancelButtonText(SearchBarView searchBarView, String str) {
        logNotAvailable("cancelButtonText");
    }

    @h7.a(name = "disableBackButtonOverride")
    public void setDisableBackButtonOverride(SearchBarView searchBarView, boolean z10) {
        m.f(searchBarView, "view");
        boolean z11 = true;
        if (z10) {
            z11 = false;
        }
        searchBarView.setShouldOverrideBackButton(z11);
    }

    @h7.a(customType = "Color", name = "headerIconColor")
    public void setHeaderIconColor(SearchBarView searchBarView, Integer num) {
        m.f(searchBarView, "view");
        searchBarView.setHeaderIconColor(num);
    }

    public void setHideNavigationBar(SearchBarView searchBarView, boolean z10) {
        logNotAvailable("hideNavigationBar");
    }

    public void setHideWhenScrolling(SearchBarView searchBarView, boolean z10) {
        logNotAvailable("hideWhenScrolling");
    }

    @h7.a(customType = "Color", name = "hintTextColor")
    public void setHintTextColor(SearchBarView searchBarView, Integer num) {
        m.f(searchBarView, "view");
        searchBarView.setHintTextColor(num);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r3.equals("text") != false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        throw new com.facebook.react.bridge.JSApplicationIllegalArgumentException("Forbidden input type value");
     */
    @h7.a(name = "inputType")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInputType(com.swmansion.rnscreens.SearchBarView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.f(r2, r0)
            if (r3 == 0) goto L_0x0041
            int r0 = r3.hashCode()
            switch(r0) {
                case -1034364087: goto L_0x002e;
                case 3556653: goto L_0x0025;
                case 96619420: goto L_0x001a;
                case 106642798: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x0039
        L_0x000f:
            java.lang.String r0 = "phone"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$b r3 = com.swmansion.rnscreens.SearchBarView.b.f11600b
            goto L_0x0043
        L_0x001a:
            java.lang.String r0 = "email"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$b r3 = com.swmansion.rnscreens.SearchBarView.b.f11602d
            goto L_0x0043
        L_0x0025:
            java.lang.String r0 = "text"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            goto L_0x0041
        L_0x002e:
            java.lang.String r0 = "number"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0039
            com.swmansion.rnscreens.SearchBarView$b r3 = com.swmansion.rnscreens.SearchBarView.b.f11601c
            goto L_0x0043
        L_0x0039:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r2 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.String r3 = "Forbidden input type value"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            com.swmansion.rnscreens.SearchBarView$b r3 = com.swmansion.rnscreens.SearchBarView.b.f11599a
        L_0x0043:
            r2.setInputType(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.SearchBarManager.setInputType(com.swmansion.rnscreens.SearchBarView, java.lang.String):void");
    }

    public void setObscureBackground(SearchBarView searchBarView, boolean z10) {
        logNotAvailable("hideNavigationBar");
    }

    @h7.a(name = "placeholder")
    public void setPlaceholder(SearchBarView searchBarView, String str) {
        m.f(searchBarView, "view");
        if (str != null) {
            searchBarView.setPlaceholder(str);
        }
    }

    public void setPlacement(SearchBarView searchBarView, String str) {
        m.f(searchBarView, "view");
        logNotAvailable("setPlacement");
    }

    @h7.a(name = "shouldShowHintSearchIcon")
    public void setShouldShowHintSearchIcon(SearchBarView searchBarView, boolean z10) {
        m.f(searchBarView, "view");
        searchBarView.setShouldShowHintSearchIcon(z10);
    }

    public void setText(SearchBarView searchBarView, String str) {
        if (searchBarView != null) {
            searchBarView.E(str);
        }
    }

    @h7.a(customType = "Color", name = "textColor")
    public void setTextColor(SearchBarView searchBarView, Integer num) {
        m.f(searchBarView, "view");
        searchBarView.setTextColor(num);
    }

    public void setTintColor(SearchBarView searchBarView, Integer num) {
        logNotAvailable("tintColor");
    }

    public void toggleCancelButton(SearchBarView searchBarView, boolean z10) {
        if (searchBarView != null) {
            searchBarView.H(z10);
        }
    }
}
