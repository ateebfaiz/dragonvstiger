package com.facebook.react.views.swiperefresh;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.adjust.sdk.Constants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.c2;
import com.facebook.react.uimanager.e1;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.p;
import java.util.HashMap;
import java.util.Map;
import p7.e;
import p7.f;

@s6.a(name = "AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> implements f {
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";
    private final c2 mDelegate = new e(this);

    class a implements SwipeRefreshLayout.OnRefreshListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e1 f4186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactSwipeRefreshLayout f4187b;

        a(e1 e1Var, ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
            this.f4186a = e1Var;
            this.f4187b = reactSwipeRefreshLayout;
        }

        public void onRefresh() {
            com.facebook.react.uimanager.events.e c10 = k1.c(this.f4186a, this.f4187b.getId());
            if (c10 != null) {
                c10.c(new a(k1.f(this.f4187b), this.f4187b.getId()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public c2 getDelegate() {
        return this.mDelegate;
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(e6.f.a().b("topRefresh", e6.f.d("registrationName", "onRefresh")).a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return e6.f.d("SIZE", e6.f.e("DEFAULT", 1, "LARGE", 0));
    }

    public String getName() {
        return REACT_CLASS;
    }

    public /* bridge */ /* synthetic */ void removeAllViews(View view) {
        p.a(this, view);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(e1 e1Var, ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        reactSwipeRefreshLayout.setOnRefreshListener(new a(e1Var, reactSwipeRefreshLayout));
    }

    /* access modifiers changed from: protected */
    public ReactSwipeRefreshLayout createViewInstance(e1 e1Var) {
        return new ReactSwipeRefreshLayout(e1Var);
    }

    public void receiveCommand(@NonNull ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str, @Nullable ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing") && readableArray != null) {
            setRefreshing(reactSwipeRefreshLayout, readableArray.getBoolean(0));
        }
    }

    @h7.a(customType = "ColorArray", name = "colors")
    public void setColors(ReactSwipeRefreshLayout reactSwipeRefreshLayout, @Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            for (int i10 = 0; i10 < readableArray.size(); i10++) {
                if (readableArray.getType(i10) == ReadableType.Map) {
                    iArr[i10] = ColorPropConverter.getColor(readableArray.getMap(i10), reactSwipeRefreshLayout.getContext()).intValue();
                } else {
                    iArr[i10] = readableArray.getInt(i10);
                }
            }
            reactSwipeRefreshLayout.setColorSchemeColors(iArr);
            return;
        }
        reactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
    }

    @h7.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z10) {
        reactSwipeRefreshLayout.setEnabled(z10);
    }

    public void setNativeRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z10) {
        setRefreshing(reactSwipeRefreshLayout, z10);
    }

    @h7.a(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Integer num) {
        reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(num == null ? 0 : num.intValue());
    }

    @h7.a(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(ReactSwipeRefreshLayout reactSwipeRefreshLayout, float f10) {
        reactSwipeRefreshLayout.setProgressViewOffset(f10);
    }

    @h7.a(name = "refreshing")
    public void setRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z10) {
        reactSwipeRefreshLayout.setRefreshing(z10);
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i10) {
        reactSwipeRefreshLayout.setSize(i10);
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str) {
        if (str == null || str.equals("default")) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (str.equals(Constants.LARGE)) {
            reactSwipeRefreshLayout.setSize(0);
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large', received: " + str);
        }
    }

    @h7.a(name = "size")
    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (dynamic.getType() == ReadableType.Number) {
            reactSwipeRefreshLayout.setSize(dynamic.asInt());
        } else if (dynamic.getType() == ReadableType.String) {
            setSize(reactSwipeRefreshLayout, dynamic.asString());
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large'");
        }
    }
}
