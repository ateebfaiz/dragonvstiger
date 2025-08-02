package com.facebook.react.views.progressbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import java.util.WeakHashMap;
import p7.c;
import p7.d;
import s6.a;

@a(name = "AndroidProgressBar")
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, a> implements d {
    static final String DEFAULT_STYLE = "Normal";
    static final String PROP_ANIMATING = "animating";
    static final String PROP_ATTR = "typeAttr";
    static final String PROP_INDETERMINATE = "indeterminate";
    static final String PROP_PROGRESS = "progress";
    static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "AndroidProgressBar";
    private static Object sProgressBarCtorLock = new Object();
    private final c2 mDelegate = new c(this);
    private final WeakHashMap<Integer, Pair<Integer, Integer>> mMeasuredStyles = new WeakHashMap<>();

    public static ProgressBar createProgressBar(Context context, int i10) {
        ProgressBar progressBar;
        synchronized (sProgressBarCtorLock) {
            progressBar = new ProgressBar(context, (AttributeSet) null, i10);
        }
        return progressBar;
    }

    static int getStyleFromString(@Nullable String str) {
        if (str == null) {
            z2.a.G("ReactNative", "ProgressBar needs to have a style, null received");
            return 16842871;
        } else if (str.equals("Horizontal")) {
            return 16842872;
        } else {
            if (str.equals("Small")) {
                return 16842873;
            }
            if (str.equals("Large")) {
                return 16842874;
            }
            if (str.equals("Inverse")) {
                return 16843399;
            }
            if (str.equals("SmallInverse")) {
                return 16843400;
            }
            if (str.equals("LargeInverse")) {
                return 16843401;
            }
            if (str.equals(DEFAULT_STYLE)) {
                return 16842871;
            }
            z2.a.G("ReactNative", "Unknown ProgressBar style: " + str);
            return 16842871;
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public Class<a> getShadowNodeClass() {
        return a.class;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f10, o oVar, float f11, o oVar2, @Nullable float[] fArr) {
        int styleFromString = getStyleFromString(readableMap2.getString(PROP_STYLE));
        Integer valueOf = Integer.valueOf(styleFromString);
        Pair pair = this.mMeasuredStyles.get(valueOf);
        if (pair == null) {
            ProgressBar createProgressBar = createProgressBar(context, styleFromString);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            createProgressBar.measure(makeMeasureSpec, makeMeasureSpec);
            pair = Pair.create(Integer.valueOf(createProgressBar.getMeasuredWidth()), Integer.valueOf(createProgressBar.getMeasuredHeight()));
            this.mMeasuredStyles.put(valueOf, pair);
        }
        return p.a(g0.b((float) ((Integer) pair.first).intValue()), g0.b((float) ((Integer) pair.second).intValue()));
    }

    @h7.a(name = "typeAttr")
    public void setTypeAttr(ProgressBarContainerView progressBarContainerView, @Nullable String str) {
    }

    public void updateExtraData(ProgressBarContainerView progressBarContainerView, Object obj) {
    }

    public a createShadowNodeInstance() {
        return new a();
    }

    /* access modifiers changed from: protected */
    public ProgressBarContainerView createViewInstance(e1 e1Var) {
        return new ProgressBarContainerView(e1Var);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ProgressBarContainerView progressBarContainerView) {
        progressBarContainerView.a();
    }

    @h7.a(name = "animating")
    public void setAnimating(ProgressBarContainerView progressBarContainerView, boolean z10) {
        progressBarContainerView.b(z10);
    }

    @h7.a(customType = "Color", name = "color")
    public void setColor(ProgressBarContainerView progressBarContainerView, @Nullable Integer num) {
        progressBarContainerView.d(num);
    }

    @h7.a(name = "indeterminate")
    public void setIndeterminate(ProgressBarContainerView progressBarContainerView, boolean z10) {
        progressBarContainerView.e(z10);
    }

    @h7.a(name = "progress")
    public void setProgress(ProgressBarContainerView progressBarContainerView, double d10) {
        progressBarContainerView.f(d10);
    }

    @h7.a(name = "styleAttr")
    public void setStyleAttr(ProgressBarContainerView progressBarContainerView, @Nullable String str) {
        progressBarContainerView.g(str);
    }

    public void setTestID(ProgressBarContainerView progressBarContainerView, @Nullable String str) {
        super.setTestId(progressBarContainerView, str);
    }
}
