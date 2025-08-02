package com.facebook.react.fabric;

import androidx.annotation.NonNull;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.view.ReactViewManager;
import java.util.HashMap;
import java.util.Map;

public class FabricComponents {
    @NonNull
    private static final Map<String, String> sComponentNames;

    static {
        HashMap hashMap = new HashMap();
        sComponentNames = hashMap;
        hashMap.put("View", ReactViewManager.REACT_CLASS);
        hashMap.put("Image", ReactImageManager.REACT_CLASS);
        hashMap.put("ScrollView", ReactScrollViewManager.REACT_CLASS);
        hashMap.put("Slider", "RCTSlider");
        hashMap.put("ModalHostView", ReactModalHostManager.REACT_CLASS);
        hashMap.put("Paragraph", ReactTextViewManager.REACT_CLASS);
        hashMap.put("Text", "RCText");
        hashMap.put("RawText", ReactRawTextManager.REACT_CLASS);
        hashMap.put("ActivityIndicatorView", ReactProgressBarViewManager.REACT_CLASS);
        hashMap.put("ShimmeringView", "RKShimmeringView");
        hashMap.put("TemplateView", "RCTTemplateView");
        hashMap.put("AxialGradientView", "RCTAxialGradientView");
        hashMap.put("Video", "RCTVideo");
        hashMap.put("Map", "RCTMap");
        hashMap.put("WebView", "RCTWebView");
        hashMap.put("Keyframes", "RCTKeyframes");
        hashMap.put("ImpressionTrackingView", "RCTImpressionTrackingView");
    }

    public static String getFabricComponentName(String str) {
        String str2 = sComponentNames.get(str);
        if (str2 != null) {
            return str2;
        }
        return str;
    }
}
