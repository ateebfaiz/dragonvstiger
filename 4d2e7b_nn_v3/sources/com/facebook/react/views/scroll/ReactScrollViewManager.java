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
import e6.f;
import h7.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s6.a;

@a(name = "RCTScrollView")
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView> implements c.a {
    public static final String REACT_CLASS = "RCTScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};
    @Nullable
    private u7.a mFpsListener;

    public ReactScrollViewManager() {
        this((u7.a) null);
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        return f.a().b(f.b(f.SCROLL), f.d("registrationName", "onScroll")).b(f.b(f.BEGIN_DRAG), f.d("registrationName", "onScrollBeginDrag")).b(f.b(f.END_DRAG), f.d("registrationName", "onScrollEndDrag")).b(f.b(f.MOMENTUM_BEGIN), f.d("registrationName", "onMomentumScrollBegin")).b(f.b(f.MOMENTUM_END), f.d("registrationName", "onMomentumScrollEnd")).a();
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return c.a();
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(createExportedCustomDirectEventTypeConstants());
        return exportedCustomDirectEventTypeConstants;
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    @b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactScrollView reactScrollView, int i10, Integer num) {
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
        reactScrollView.C(SPACING_TYPES[i10], f10, f11);
    }

    @b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius"})
    public void setBorderRadius(ReactScrollView reactScrollView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        if (i10 == 0) {
            reactScrollView.setBorderRadius(f10);
        } else {
            reactScrollView.D(f10, i10 - 1);
        }
    }

    @h7.a(name = "borderStyle")
    public void setBorderStyle(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setBorderStyle(str);
    }

    @b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactScrollView reactScrollView, int i10, float f10) {
        if (!e.a(f10)) {
            f10 = g0.d(f10);
        }
        reactScrollView.E(SPACING_TYPES[i10], f10);
    }

    @h7.a(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactScrollView reactScrollView, int i10) {
        reactScrollView.setEndFillColor(i10);
    }

    @h7.a(customType = "Point", name = "contentOffset")
    public void setContentOffset(ReactScrollView reactScrollView, ReadableMap readableMap) {
        reactScrollView.setContentOffset(readableMap);
    }

    @h7.a(name = "decelerationRate")
    public void setDecelerationRate(ReactScrollView reactScrollView, float f10) {
        reactScrollView.setDecelerationRate(f10);
    }

    @h7.a(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setDisableIntervalMomentum(z10);
    }

    @h7.a(name = "enableSyncOnScroll")
    public void setEnableSyncOnScroll(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setEnableSyncOnScroll(z10);
    }

    @h7.a(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactScrollView reactScrollView, int i10) {
        if (i10 > 0) {
            reactScrollView.setVerticalFadingEdgeEnabled(true);
            reactScrollView.setFadingEdgeLength(i10);
            return;
        }
        reactScrollView.setVerticalFadingEdgeEnabled(false);
        reactScrollView.setFadingEdgeLength(0);
    }

    @h7.a(name = "horizontal")
    public void setHorizontal(ReactScrollView reactScrollView, boolean z10) {
    }

    @h7.a(name = "isInvertedVirtualizedList")
    public void setIsInvertedVirtualizedList(ReactScrollView reactScrollView, boolean z10) {
        if (z10) {
            reactScrollView.setVerticalScrollbarPosition(1);
        } else {
            reactScrollView.setVerticalScrollbarPosition(0);
        }
    }

    @h7.a(name = "maintainVisibleContentPosition")
    public void setMaintainVisibleContentPosition(ReactScrollView reactScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            reactScrollView.setMaintainVisibleContentPosition(a.b.a(readableMap));
        } else {
            reactScrollView.setMaintainVisibleContentPosition((a.b) null);
        }
    }

    @h7.a(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactScrollView reactScrollView, boolean z10) {
        ViewCompat.setNestedScrollingEnabled(reactScrollView, z10);
    }

    @h7.a(name = "overScrollMode")
    public void setOverScrollMode(ReactScrollView reactScrollView, String str) {
        reactScrollView.setOverScrollMode(d.l(str));
    }

    @h7.a(name = "overflow")
    public void setOverflow(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setOverflow(str);
    }

    @h7.a(name = "pagingEnabled")
    public void setPagingEnabled(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setPagingEnabled(z10);
    }

    @h7.a(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setScrollbarFadingEnabled(!z10);
    }

    @h7.a(name = "pointerEvents")
    public void setPointerEvents(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setPointerEvents(h0.d(str));
    }

    @h7.a(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setRemoveClippedSubviews(z10);
    }

    @h7.a(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setScrollEnabled(z10);
        reactScrollView.setFocusable(z10);
    }

    @h7.a(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactScrollView reactScrollView, int i10) {
        reactScrollView.setScrollEventThrottle(i10);
    }

    @h7.a(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setScrollPerfTag(str);
    }

    @h7.a(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setSendMomentumEvents(z10);
    }

    @h7.a(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setVerticalScrollBarEnabled(z10);
    }

    @h7.a(name = "snapToAlignment")
    public void setSnapToAlignment(ReactScrollView reactScrollView, String str) {
        reactScrollView.setSnapToAlignment(d.m(str));
    }

    @h7.a(name = "snapToEnd")
    public void setSnapToEnd(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setSnapToEnd(z10);
    }

    @h7.a(name = "snapToInterval")
    public void setSnapToInterval(ReactScrollView reactScrollView, float f10) {
        reactScrollView.setSnapInterval((int) (f10 * g0.a()));
    }

    @h7.a(name = "snapToOffsets")
    public void setSnapToOffsets(ReactScrollView reactScrollView, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactScrollView.setSnapOffsets((List<Integer>) null);
            return;
        }
        float a10 = g0.a();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i10) * ((double) a10))));
        }
        reactScrollView.setSnapOffsets(arrayList);
    }

    @h7.a(name = "snapToStart")
    public void setSnapToStart(ReactScrollView reactScrollView, boolean z10) {
        reactScrollView.setSnapToStart(z10);
    }

    public ReactScrollViewManager(@Nullable u7.a aVar) {
    }

    public ReactScrollView createViewInstance(e1 e1Var) {
        return new ReactScrollView(e1Var, (u7.a) null);
    }

    public void flashScrollIndicators(ReactScrollView reactScrollView) {
        reactScrollView.p();
    }

    public void scrollTo(ReactScrollView reactScrollView, c.b bVar) {
        reactScrollView.k();
        if (bVar.f4137c) {
            reactScrollView.c(bVar.f4135a, bVar.f4136b);
        } else {
            reactScrollView.scrollTo(bVar.f4135a, bVar.f4136b);
        }
    }

    public void scrollToEnd(ReactScrollView reactScrollView, c.C0058c cVar) {
        View childAt = reactScrollView.getChildAt(0);
        if (childAt != null) {
            int height = childAt.getHeight() + reactScrollView.getPaddingBottom();
            reactScrollView.k();
            if (cVar.f4138a) {
                reactScrollView.c(reactScrollView.getScrollX(), height);
            } else {
                reactScrollView.scrollTo(reactScrollView.getScrollX(), height);
            }
        } else {
            throw new RetryableMountingLayerException("scrollToEnd called on ScrollView without child");
        }
    }

    @Nullable
    public Object updateState(ReactScrollView reactScrollView, v0 v0Var, d1 d1Var) {
        reactScrollView.setStateWrapper(d1Var);
        return null;
    }

    public void receiveCommand(ReactScrollView reactScrollView, int i10, @Nullable ReadableArray readableArray) {
        c.b(this, reactScrollView, i10, readableArray);
    }

    public void receiveCommand(ReactScrollView reactScrollView, String str, @Nullable ReadableArray readableArray) {
        c.c(this, reactScrollView, str, readableArray);
    }
}
