package com.sensorsdata.analytics.android.sdk.visual.model;

import com.sensorsdata.analytics.android.sdk.visual.model.NodeInfo;
import java.util.List;

public class SnapInfo {
    public String activityName;
    public String activityTitle;
    public List<NodeInfo.AlertInfo> alertInfos;
    public int elementLevel = -1;
    public String flutterLibVersion;
    public List<NodeInfo.AlertInfo> flutter_alertInfos;
    public boolean hasFragment;
    public boolean isFlutter = false;
    public boolean isWebView = false;
    public String screenName;
    public String webLibVersion;
    public float webViewScale;
    public String webViewUrl;
}
