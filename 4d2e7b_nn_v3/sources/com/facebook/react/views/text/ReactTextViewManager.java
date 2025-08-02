package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.m;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.r;
import com.facebook.react.uimanager.v0;
import com.facebook.yoga.o;
import e6.f;
import java.util.HashMap;
import java.util.Map;
import s6.a;
import w7.d;
import w7.i;

@a(name = "RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, h> implements r {
    public static final String REACT_CLASS = "RCTText";
    private static final String TAG = "ReactTextViewManager";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_HASH = 2;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    @Nullable
    protected m mReactTextViewManagerCallback;

    public ReactTextViewManager() {
        this((m) null);
    }

    private Object getReactTextUpdate(ReactTextView reactTextView, v0 v0Var, com.facebook.react.common.mapbuffer.a aVar) {
        String str;
        int i10 = 0;
        com.facebook.react.common.mapbuffer.a h10 = aVar.h(0);
        com.facebook.react.common.mapbuffer.a h11 = aVar.h(1);
        Spannable f10 = r.f(reactTextView.getContext(), h10, (m) null);
        reactTextView.setSpanned(f10);
        try {
            reactTextView.setMinimumFontSize((float) h11.getDouble(6));
            int h12 = p.h(h11.getString(2));
            if (Build.VERSION.SDK_INT >= 26) {
                i10 = reactTextView.getJustificationMode();
            }
            return new i(f10, -1, false, r.h(h10, f10, reactTextView.getGravityHorizontal()), h12, p.d(v0Var, i10));
        } catch (IllegalArgumentException e10) {
            if (h11 != null) {
                str = h11.toString();
            } else {
                str = "<empty>";
            }
            z2.a.l(TAG, "Paragraph Attributes: %s", str);
            throw e10;
        }
    }

    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(f.e("topTextLayout", f.d("registrationName", "onTextLayout"), "topInlineViewLayout", f.d("registrationName", "onInlineViewLayout")));
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<h> getShadowNodeClass() {
        return h.class;
    }

    public long measure(Context context, com.facebook.react.common.mapbuffer.a aVar, com.facebook.react.common.mapbuffer.a aVar2, @Nullable com.facebook.react.common.mapbuffer.a aVar3, float f10, o oVar, float f11, o oVar2, @Nullable float[] fArr) {
        return r.k(context, aVar, aVar2, f10, oVar, f11, oVar2, (m) null, fArr);
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @h7.a(name = "overflow")
    public void setOverflow(ReactTextView reactTextView, @Nullable String str) {
        reactTextView.setOverflow(str);
    }

    public ReactTextViewManager(@Nullable m mVar) {
        setupViewRecycling();
    }

    public h createShadowNodeInstance() {
        return new h((m) null);
    }

    public ReactTextView createViewInstance(e1 e1Var) {
        return new ReactTextView(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction(reactTextView);
        reactTextView.h();
    }

    /* access modifiers changed from: protected */
    public ReactTextView prepareToRecycleView(@NonNull e1 e1Var, ReactTextView reactTextView) {
        super.prepareToRecycleView(e1Var, reactTextView);
        reactTextView.d();
        setSelectionColor(reactTextView, (Integer) null);
        return reactTextView;
    }

    public void setPadding(ReactTextView reactTextView, int i10, int i11, int i12, int i13) {
        reactTextView.setPadding(i10, i11, i12, i13);
    }

    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        i iVar = (i) obj;
        Spannable i10 = iVar.i();
        if (iVar.b()) {
            i.g(i10, reactTextView);
        }
        reactTextView.setText(iVar);
        d[] dVarArr = (d[]) i10.getSpans(0, iVar.i().length(), d.class);
        if (dVarArr.length > 0) {
            reactTextView.setTag(m.f20849f, new i0.d(dVarArr, i10));
            i0.m(reactTextView, reactTextView.isFocusable(), reactTextView.getImportantForAccessibility());
        }
    }

    public Object updateState(ReactTextView reactTextView, v0 v0Var, d1 d1Var) {
        ReadableMapBuffer stateDataMapBuffer = d1Var.getStateDataMapBuffer();
        if (stateDataMapBuffer != null) {
            return getReactTextUpdate(reactTextView, v0Var, stateDataMapBuffer);
        }
        return null;
    }

    public h createShadowNodeInstance(@Nullable m mVar) {
        return new h(mVar);
    }
}
