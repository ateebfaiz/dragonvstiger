package com.facebook.react.views.scroll;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.p;
import com.facebook.react.uimanager.v0;
import com.facebook.react.views.scroll.a;
import com.facebook.react.views.scroll.c;
import com.facebook.yoga.e;
import h7.b;
import java.util.ArrayList;
import java.util.List;
import s6.a;

@a(name = "AndroidHorizontalScrollView")
public class ReactHorizontalScrollViewManager extends ViewGroupManager<ReactHorizontalScrollView> implements c.a {
    public static final String REACT_CLASS = "AndroidHorizontalScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    @Nullable
    private u7.a mFpsListener;

    public ReactHorizontalScrollViewManager() {
        this((u7.a) null);
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactHorizontalScrollView reactHorizontalScrollView, int i10, Integer num) {
        float f10;
        float f11 = Float.NaN;
        if (num == null) {
            f10 = Float.NaN;
        } else {
            f10 = (float) (num.intValue() & ViewCompat.MEASURED_SIZE_MASK);
        }
        if (num != null) {
            f11 = (float) (num.intValue() >>> 24);
        }
        reactHorizontalScrollView.G(SPACING_TYPES[i10], f10, f11);
    }

    @b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactHorizontalScrollView reactHorizontalScrollView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        if (i10 == 0) {
            reactHorizontalScrollView.setBorderRadius(f10);
        } else {
            reactHorizontalScrollView.H(f10, i10 - 1);
        }
    }

    @h7.a(name = "borderStyle")
    public void setBorderStyle(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setBorderStyle(str);
    }

    @b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactHorizontalScrollView reactHorizontalScrollView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        reactHorizontalScrollView.I(SPACING_TYPES[i10], f10);
    }

    @h7.a(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactHorizontalScrollView reactHorizontalScrollView, int i10) {
        reactHorizontalScrollView.setEndFillColor(i10);
    }

    @h7.a(name = "contentOffset")
    public void setContentOffset(ReactHorizontalScrollView reactHorizontalScrollView, ReadableMap readableMap) {
        double d10;
        if (readableMap != null) {
            double d11 = 0.0d;
            if (readableMap.hasKey("x")) {
                d10 = readableMap.getDouble("x");
            } else {
                d10 = 0.0d;
            }
            if (readableMap.hasKey("y")) {
                d11 = readableMap.getDouble("y");
            }
            reactHorizontalScrollView.scrollTo((int) g0.c(d10), (int) g0.c(d11));
            return;
        }
        reactHorizontalScrollView.scrollTo(0, 0);
    }

    @h7.a(name = "decelerationRate")
    public void setDecelerationRate(ReactHorizontalScrollView reactHorizontalScrollView, float f10) {
        reactHorizontalScrollView.setDecelerationRate(f10);
    }

    @h7.a(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setDisableIntervalMomentum(z10);
    }

    @h7.a(name = "enableSyncOnScroll")
    public void setEnableSyncOnScroll(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setEnableSyncOnScroll(z10);
    }

    @h7.a(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactHorizontalScrollView reactHorizontalScrollView, int i10) {
        if (i10 > 0) {
            reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            reactHorizontalScrollView.setFadingEdgeLength(i10);
            return;
        }
        reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(false);
        reactHorizontalScrollView.setFadingEdgeLength(0);
    }

    @h7.a(name = "horizontal")
    public void setHorizontal(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
    }

    @h7.a(name = "maintainVisibleContentPosition")
    public void setMaintainVisibleContentPosition(ReactHorizontalScrollView reactHorizontalScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            reactHorizontalScrollView.setMaintainVisibleContentPosition(a.b.a(readableMap));
        } else {
            reactHorizontalScrollView.setMaintainVisibleContentPosition((a.b) null);
        }
    }

    @h7.a(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        ViewCompat.setNestedScrollingEnabled(reactHorizontalScrollView, z10);
    }

    @h7.a(name = "overScrollMode")
    public void setOverScrollMode(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setOverScrollMode(d.l(str));
    }

    @h7.a(name = "overflow")
    public void setOverflow(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setOverflow(str);
    }

    @h7.a(name = "pagingEnabled")
    public void setPagingEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setPagingEnabled(z10);
    }

    @h7.a(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setScrollbarFadingEnabled(!z10);
    }

    @h7.a(name = "pointerEvents")
    public void setPointerEvents(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setPointerEvents(h0.d(str));
    }

    @h7.a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setRemoveClippedSubviews(z10);
    }

    @h7.a(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setScrollEnabled(z10);
    }

    @h7.a(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactHorizontalScrollView reactHorizontalScrollView, int i10) {
        reactHorizontalScrollView.setScrollEventThrottle(i10);
    }

    @h7.a(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setScrollPerfTag(str);
    }

    @h7.a(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setSendMomentumEvents(z10);
    }

    @h7.a(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setHorizontalScrollBarEnabled(z10);
    }

    @h7.a(name = "snapToAlignment")
    public void setSnapToAlignment(ReactHorizontalScrollView reactHorizontalScrollView, String str) {
        reactHorizontalScrollView.setSnapToAlignment(d.m(str));
    }

    @h7.a(name = "snapToEnd")
    public void setSnapToEnd(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setSnapToEnd(z10);
    }

    @h7.a(name = "snapToInterval")
    public void setSnapToInterval(ReactHorizontalScrollView reactHorizontalScrollView, float f10) {
        reactHorizontalScrollView.setSnapInterval((int) (f10 * g0.a()));
    }

    @h7.a(name = "snapToOffsets")
    public void setSnapToOffsets(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactHorizontalScrollView.setSnapOffsets((List<Integer>) null);
            return;
        }
        float a10 = g0.a();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i10) * ((double) a10))));
        }
        reactHorizontalScrollView.setSnapOffsets(arrayList);
    }

    @h7.a(name = "snapToStart")
    public void setSnapToStart(ReactHorizontalScrollView reactHorizontalScrollView, boolean z10) {
        reactHorizontalScrollView.setSnapToStart(z10);
    }

    public ReactHorizontalScrollViewManager(@Nullable u7.a aVar) {
    }

    public ReactHorizontalScrollView createViewInstance(e1 e1Var) {
        return new ReactHorizontalScrollView(e1Var, (u7.a) null);
    }

    public void flashScrollIndicators(ReactHorizontalScrollView reactHorizontalScrollView) {
        reactHorizontalScrollView.r();
    }

    public void scrollTo(ReactHorizontalScrollView reactHorizontalScrollView, c.b bVar) {
        reactHorizontalScrollView.k();
        if (bVar.f4137c) {
            reactHorizontalScrollView.c(bVar.f4135a, bVar.f4136b);
        } else {
            reactHorizontalScrollView.scrollTo(bVar.f4135a, bVar.f4136b);
        }
    }

    public void scrollToEnd(ReactHorizontalScrollView reactHorizontalScrollView, c.C0058c cVar) {
        View childAt = reactHorizontalScrollView.getChildAt(0);
        if (childAt != null) {
            int width = childAt.getWidth() + reactHorizontalScrollView.getPaddingRight();
            reactHorizontalScrollView.k();
            if (cVar.f4138a) {
                reactHorizontalScrollView.c(width, reactHorizontalScrollView.getScrollY());
            } else {
                reactHorizontalScrollView.scrollTo(width, reactHorizontalScrollView.getScrollY());
            }
        } else {
            throw new RetryableMountingLayerException("scrollToEnd called on HorizontalScrollView without child");
        }
    }

    @Nullable
    public Object updateState(ReactHorizontalScrollView reactHorizontalScrollView, v0 v0Var, d1 d1Var) {
        reactHorizontalScrollView.setStateWrapper(d1Var);
        return null;
    }

    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, int i10, @Nullable ReadableArray readableArray) {
        c.b(this, reactHorizontalScrollView, i10, readableArray);
    }

    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, String str, @Nullable ReadableArray readableArray) {
        c.c(this, reactHorizontalScrollView, str, readableArray);
    }
}
