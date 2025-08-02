package org.cocos2dx.javascript.sdk;

import com.adjust.sdk.Adjust;
import org.cocos2dx.javascript.PlatformUtils;

public final /* synthetic */ class b implements PlatformUtils.IAction {
    public final void invoke() {
        Adjust.onPause();
    }
}
