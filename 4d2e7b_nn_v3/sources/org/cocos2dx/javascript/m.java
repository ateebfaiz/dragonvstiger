package org.cocos2dx.javascript;

import com.cocos.lib.JsbBridgeWrapper;
import org.cocos2dx.javascript.PlatformUtils;

public final /* synthetic */ class m implements JsbBridgeWrapper.OnScriptEventListener {
    public final void onScriptEvent(String str) {
        PlatformUtils.mActivity.runOnUiThread(new PlatformUtils.v(str));
    }
}
