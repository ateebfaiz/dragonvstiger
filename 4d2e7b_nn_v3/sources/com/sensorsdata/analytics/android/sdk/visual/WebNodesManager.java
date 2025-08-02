package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.util.LruCache;
import com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants;
import com.sensorsdata.analytics.android.sdk.visual.model.CommonNode;
import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNode;
import com.sensorsdata.analytics.android.sdk.visual.model.WebNodeInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebNodesManager extends AbstractNodesManager {
    private static final String TAG = "SA.Visual.WebNodesManager";
    private String mWebViewUrl;

    private WebNodeInfo parsePageInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            return WebNodeInfo.createPageInfo(jSONObject.optString("$title"), jSONObject.optString("$url"));
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void handlerVisualizedFailure(String str, List<NodeInfo.AlertInfo> list) {
        AbstractNodesManager.sNodesCache.put(str, WebNodeInfo.createAlertInfo(list));
    }

    /* access modifiers changed from: protected */
    public void handlerVisualizedPageInfo(String str) {
        WebNodeInfo parsePageInfo = parsePageInfo(str);
        if (parsePageInfo != null) {
            this.mWebViewUrl = parsePageInfo.getUrl();
            if (AbstractNodesManager.sPageInfoCache == null) {
                AbstractNodesManager.sPageInfoCache = new LruCache<>(10);
            }
            String url = parsePageInfo.getUrl();
            if (!TextUtils.isEmpty(url)) {
                AbstractNodesManager.sPageInfoCache.put(url, parsePageInfo);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void handlerVisualizedTrack(List<? extends CommonNode> list) {
        if (!TextUtils.isEmpty(this.mWebViewUrl)) {
            AbstractNodesManager.sNodesCache.put(this.mWebViewUrl, WebNodeInfo.createNodesInfo(list));
        }
    }

    /* access modifiers changed from: protected */
    public CommonNode parseExtraNodesInfo(JSONObject jSONObject) {
        WebNode webNode = new WebNode();
        webNode.set$element_selector(jSONObject.optString(VisualConstants.ELEMENT_SELECTOR));
        webNode.setTagName(jSONObject.optString("tagName"));
        webNode.set$url(jSONObject.optString("$url"));
        webNode.setzIndex(jSONObject.optInt("zIndex"));
        webNode.set$title(jSONObject.optString("$title"));
        webNode.setList_selector(jSONObject.optString("list_selector"));
        webNode.setScale((float) jSONObject.optDouble("scale"));
        webNode.setVisibility(jSONObject.optBoolean("visibility"));
        webNode.setLib_version(jSONObject.optString("lib_version"));
        return webNode;
    }
}
