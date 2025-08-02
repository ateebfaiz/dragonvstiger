package com.sensorsdata.analytics.android.sdk.visual;

import android.text.TextUtils;
import android.util.LruCache;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.autotrack.core.beans.AutoTrackConstants;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.Dispatcher;
import com.sensorsdata.analytics.android.sdk.visual.constant.VisualConstants;
import com.sensorsdata.analytics.android.sdk.visual.model.CommonNode;
import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractNodesManager {
    protected static final String CALL_TYPE_PAGE_INFO = "page_info";
    protected static final String CALL_TYPE_VISUALIZED_TRACK = "visualized_track";
    protected static final int LRU_CACHE_MAX_SIZE = 10;
    private static final String TAG = "SA.Visual.AbstractNodesManager";
    protected static LruCache<String, NodeInfo> sNodesCache;
    protected static LruCache<String, NodeInfo> sPageInfoCache;
    protected boolean mHasAlertInfo;
    private boolean mHasWebView;
    protected String mLastThirdNodeMsg = null;

    static class NodeRect {
        public float left;
        public float top;

        public NodeRect(float f10, float f11) {
            this.top = f10;
            this.left = f11;
        }
    }

    private void findWebNodes(JSONArray jSONArray, List<CommonNode> list, Map<String, NodeRect> map) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                        CommonNode parseExtraNodesInfo = parseExtraNodesInfo(optJSONObject);
                        parseExtraNodesInfo.setId(optJSONObject.optString("id"));
                        parseExtraNodesInfo.set$element_content(optJSONObject.optString(AutoTrackConstants.ELEMENT_CONTENT));
                        parseExtraNodesInfo.setTop((float) optJSONObject.optDouble("top"));
                        parseExtraNodesInfo.setLeft((float) optJSONObject.optDouble("left"));
                        parseExtraNodesInfo.setScrollX((float) optJSONObject.optDouble("scrollX"));
                        parseExtraNodesInfo.setScrollY((float) optJSONObject.optDouble("scrollY"));
                        parseExtraNodesInfo.setWidth((float) optJSONObject.optDouble(Snapshot.WIDTH));
                        parseExtraNodesInfo.setHeight((float) optJSONObject.optDouble(Snapshot.HEIGHT));
                        parseExtraNodesInfo.setLevel(optJSONObject.optInt(FirebaseAnalytics.Param.LEVEL));
                        parseExtraNodesInfo.set$element_path(optJSONObject.optString(VisualConstants.ELEMENT_PATH));
                        parseExtraNodesInfo.set$element_position(optJSONObject.optString(VisualConstants.ELEMENT_POSITION));
                        parseExtraNodesInfo.setEnable_click(optJSONObject.optBoolean("enable_click", true));
                        parseExtraNodesInfo.setIs_list_view(optJSONObject.optBoolean("is_list_view"));
                        JSONArray optJSONArray = optJSONObject.optJSONArray("subelements");
                        ArrayList arrayList = new ArrayList();
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                String optString = optJSONArray.optString(i11);
                                if (!TextUtils.isEmpty(optString)) {
                                    arrayList.add(optString);
                                    if (!map.containsKey(optString)) {
                                        map.put(optString, new NodeRect(parseExtraNodesInfo.getTop(), parseExtraNodesInfo.getLeft()));
                                    }
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            parseExtraNodesInfo.setSubelements(arrayList);
                        }
                        list.add(parseExtraNodesInfo);
                    }
                }
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
    }

    private void modifyWebNodes(List<? extends CommonNode> list, Map<String, NodeRect> map) {
        float f10;
        if (list != null && list.size() != 0) {
            synchronized (this) {
                try {
                    for (CommonNode commonNode : list) {
                        commonNode.setOriginLeft(commonNode.getLeft());
                        commonNode.setOriginTop(commonNode.getTop());
                        if (!map.containsKey(commonNode.getId())) {
                            commonNode.setRootView(true);
                            float f11 = 0.0f;
                            if (!Float.isNaN(commonNode.getScrollY())) {
                                f10 = commonNode.getScrollY();
                            } else {
                                f10 = 0.0f;
                            }
                            if (!Float.isNaN(commonNode.getScrollX())) {
                                f11 = commonNode.getScrollX();
                            }
                            commonNode.setTop(commonNode.getTop() + f10);
                            commonNode.setLeft(commonNode.getLeft() + f11);
                        } else {
                            NodeRect nodeRect = map.get(commonNode.getId());
                            if (nodeRect != null) {
                                commonNode.setTop(commonNode.getTop() - nodeRect.top);
                                commonNode.setLeft(commonNode.getLeft() - nodeRect.left);
                            }
                        }
                    }
                } finally {
                }
            }
        }
    }

    private List<NodeInfo.AlertInfo> parseAlertResult(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            int i10 = 0;
            while (i10 < optJSONArray.length()) {
                try {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i10);
                    if (jSONObject != null) {
                        arrayList2.add(new NodeInfo.AlertInfo(jSONObject.optString("title"), jSONObject.optString("message"), jSONObject.optString("link_text"), jSONObject.optString("link_url")));
                    }
                    i10++;
                } catch (JSONException e10) {
                    e = e10;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                } catch (Exception e11) {
                    e = e11;
                    arrayList = arrayList2;
                    SALog.printStackTrace(e);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e12) {
            e = e12;
            SALog.printStackTrace(e);
            return arrayList;
        } catch (Exception e13) {
            e = e13;
            SALog.printStackTrace(e);
            return arrayList;
        }
    }

    private List<CommonNode> parseResult(String str) {
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            try {
                jSONArray = jSONObject.optJSONArray("extra_elements");
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
            if (optJSONArray != null) {
                findWebNodes(optJSONArray, arrayList, hashMap);
            }
            if (jSONArray != null) {
                findWebNodes(jSONArray, arrayList, hashMap);
            }
            modifyWebNodes(arrayList, hashMap);
            try {
                Collections.sort(arrayList, new Comparator<CommonNode>() {
                    public int compare(CommonNode commonNode, CommonNode commonNode2) {
                        return commonNode.getLevel() - commonNode2.getLevel();
                    }
                });
            } catch (Exception e11) {
                SALog.printStackTrace(e11);
            }
        } catch (JSONException e12) {
            SALog.printStackTrace(e12);
        } catch (Exception e13) {
            SALog.printStackTrace(e13);
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mLastThirdNodeMsg = null;
        this.mHasAlertInfo = false;
    }

    /* access modifiers changed from: package-private */
    public String getLastThirdMsg() {
        return this.mLastThirdNodeMsg;
    }

    public NodeInfo getNodes(String str) {
        if (!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sNodesCache == null) {
            sNodesCache = new LruCache<>(10);
        }
        return sNodesCache.get(str);
    }

    public NodeInfo getPageInfo(String str) {
        if (!VisualizedAutoTrackService.getInstance().isServiceRunning() && !HeatMapService.getInstance().isServiceRunning()) {
            return null;
        }
        if (sPageInfoCache == null) {
            sPageInfoCache = new LruCache<>(10);
        }
        return sPageInfoCache.get(str);
    }

    public void handlerFailure(String str, String str2) {
        try {
            Dispatcher.getInstance().removeCallbacksAndMessages();
            if ((VisualizedAutoTrackService.getInstance().isServiceRunning() || HeatMapService.getInstance().isServiceRunning()) && !TextUtils.isEmpty(str2)) {
                SALog.i(TAG, "handlerFailure url " + str + ",msg: " + str2);
                this.mHasAlertInfo = true;
                this.mLastThirdNodeMsg = String.valueOf(System.currentTimeMillis());
                List<NodeInfo.AlertInfo> parseAlertResult = parseAlertResult(str2);
                if (parseAlertResult != null && parseAlertResult.size() > 0) {
                    if (sNodesCache == null) {
                        sNodesCache = new LruCache<>(10);
                    }
                    handlerVisualizedFailure(str, parseAlertResult);
                }
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065 A[Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handlerMessage(java.lang.String r6) {
        /*
            r5 = this;
            com.sensorsdata.analytics.android.sdk.util.Dispatcher r0 = com.sensorsdata.analytics.android.sdk.util.Dispatcher.getInstance()
            r0.removeCallbacksAndMessages()
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService r0 = com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService r0 = com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance()
            boolean r0 = r0.isServiceRunning()
            if (r0 != 0) goto L_0x001c
            return
        L_0x001c:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0023
            return
        L_0x0023:
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r5.mLastThirdNodeMsg = r0
            r0 = 0
            r5.mHasAlertInfo = r0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            r1.<init>(r6)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            java.lang.String r2 = "callType"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            int r2 = r1.hashCode()     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            r3 = 817885468(0x30bff11c, float:1.3965606E-9)
            r4 = 1
            if (r2 == r3) goto L_0x0059
            r0 = 883555422(0x34a9fc5e, float:3.1662324E-7)
            if (r2 == r0) goto L_0x004b
            goto L_0x0062
        L_0x004b:
            java.lang.String r0 = "page_info"
            boolean r0 = r1.equals(r0)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            if (r0 == 0) goto L_0x0062
            r0 = r4
            goto L_0x0063
        L_0x0055:
            r6 = move-exception
            goto L_0x0089
        L_0x0057:
            r6 = move-exception
            goto L_0x008d
        L_0x0059:
            java.lang.String r2 = "visualized_track"
            boolean r1 = r1.equals(r2)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r0 = -1
        L_0x0063:
            if (r0 == 0) goto L_0x006c
            if (r0 == r4) goto L_0x0068
            goto L_0x0090
        L_0x0068:
            r5.handlerVisualizedPageInfo(r6)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            goto L_0x0090
        L_0x006c:
            java.util.List r6 = r5.parseResult(r6)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            if (r6 == 0) goto L_0x0090
            int r0 = r6.size()     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            if (r0 <= 0) goto L_0x0090
            android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo> r0 = sNodesCache     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            if (r0 != 0) goto L_0x0085
            android.util.LruCache r0 = new android.util.LruCache     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            r1 = 10
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            sNodesCache = r0     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
        L_0x0085:
            r5.handlerVisualizedTrack(r6)     // Catch:{ JSONException -> 0x0057, Exception -> 0x0055 }
            goto L_0x0090
        L_0x0089:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)
            goto L_0x0090
        L_0x008d:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r6)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.visual.AbstractNodesManager.handlerMessage(java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public abstract void handlerVisualizedFailure(String str, List<NodeInfo.AlertInfo> list);

    /* access modifiers changed from: protected */
    public abstract void handlerVisualizedPageInfo(String str);

    /* access modifiers changed from: protected */
    public abstract void handlerVisualizedTrack(List<? extends CommonNode> list);

    /* access modifiers changed from: package-private */
    public boolean hasAlertInfo() {
        return this.mHasAlertInfo;
    }

    /* access modifiers changed from: package-private */
    public boolean hasThirdView() {
        return this.mHasWebView;
    }

    /* access modifiers changed from: protected */
    public abstract CommonNode parseExtraNodesInfo(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public void setHasThirdView(boolean z10) {
        this.mHasWebView = z10;
    }
}
