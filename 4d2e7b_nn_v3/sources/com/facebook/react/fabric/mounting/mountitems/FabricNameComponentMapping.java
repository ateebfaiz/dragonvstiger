package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.m;
import kotlin.t;

public final class FabricNameComponentMapping {
    public static final FabricNameComponentMapping INSTANCE = new FabricNameComponentMapping();
    private static final Map<String, String> componentNames = i0.i(t.a("View", ReactViewManager.REACT_CLASS), t.a("Image", ReactImageManager.REACT_CLASS), t.a("ScrollView", ReactScrollViewManager.REACT_CLASS), t.a("Slider", "RCTSlider"), t.a("ModalHostView", ReactModalHostManager.REACT_CLASS), t.a("Paragraph", ReactTextViewManager.REACT_CLASS), t.a("Text", "RCText"), t.a("RawText", ReactRawTextManager.REACT_CLASS), t.a("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS), t.a("ShimmeringView", "RKShimmeringView"), t.a("TemplateView", "RCTTemplateView"), t.a("AxialGradientView", "RCTAxialGradientView"), t.a("Video", "RCTVideo"), t.a("Map", "RCTMap"), t.a("WebView", "RCTWebView"), t.a("Keyframes", "RCTKeyframes"), t.a("ImpressionTrackingView", "RCTImpressionTrackingView"));

    private FabricNameComponentMapping() {
    }

    public static final String getFabricComponentName(String str) {
        m.f(str, "componentName");
        String str2 = componentNames.get(str);
        if (str2 == null) {
            return str;
        }
        return str2;
    }
}
