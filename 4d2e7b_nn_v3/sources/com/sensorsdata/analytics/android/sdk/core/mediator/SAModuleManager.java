package com.sensorsdata.analytics.android.sdk.core.mediator;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.core.mediator.protocol.SAModuleProtocol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SAModuleManager {
    private static final String TAG = "SA.ModuleManager";
    private static volatile SAModuleManager mSingleton;
    private final Map<String, SAModuleProtocol> mServiceMap = new HashMap();

    private SAModuleManager() {
    }

    public static SAModuleManager getInstance() {
        if (mSingleton == null) {
            synchronized (SAModuleManager.class) {
                try {
                    if (mSingleton == null) {
                        mSingleton = new SAModuleManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mSingleton;
    }

    private SAModuleProtocol getService(String str) {
        try {
            if (!getInstance().hasModuleByName(str)) {
                return null;
            }
            return this.mServiceMap.get(str);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    private List<SAModuleProtocol> loadModule(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                arrayList.add((SAModuleProtocol) Class.forName(next).newInstance());
                SALog.i(TAG, "loadModule name: " + next);
            } catch (Throwable th) {
                SALog.i(TAG, "loadModule name: " + next + " error \n" + th);
            }
        }
        return arrayList;
    }

    public boolean hasModuleByName(String str) {
        SAModuleProtocol sAModuleProtocol;
        if (!TextUtils.isEmpty(str) && this.mServiceMap.containsKey(str) && (sAModuleProtocol = this.mServiceMap.get(str)) != null) {
            return sAModuleProtocol.isEnable();
        }
        return false;
    }

    public void installService(SAContextManager sAContextManager) {
        try {
            List<SAModuleProtocol> loadModule = loadModule(new ArrayList<String>() {
                {
                    add("com.sensorsdata.analytics.android.autotrack.core.SensorsAutoTrackAPI");
                    add("com.sensorsdata.analytics.android.webview.impl.SensorsWebViewAPI");
                    add("com.sensorsdata.analytics.android.sdk.encrypt.impl.SAEncryptProtocolImpl");
                    add("com.sensorsdata.analytics.android.sdk.push.core.PushProtocolImp");
                    add("com.sensorsdata.analytics.android.sdk.visual.impl.SAVisualProtocolAPI");
                    add("com.sensorsdata.analytics.android.sdk.exposure.SAExposureProtocolImpl");
                    add("com.sensorsdata.analytics.android.sdk.advert.impl.SensorsAdvertProtocolAPI");
                }
            });
            Collections.sort(loadModule, new Comparator<SAModuleProtocol>() {
                public int compare(SAModuleProtocol sAModuleProtocol, SAModuleProtocol sAModuleProtocol2) {
                    return sAModuleProtocol2.getPriority() - sAModuleProtocol.getPriority();
                }
            });
            for (SAModuleProtocol next : loadModule) {
                try {
                    next.install(sAContextManager);
                    this.mServiceMap.put(next.getModuleName(), next);
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }

    public <T> T invokeModuleFunction(String str, String str2, Object... objArr) {
        try {
            SAModuleProtocol service = getService(str);
            if (service != null) {
                return service.invokeModuleFunction(str2, objArr);
            }
            return null;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public void setModuleState(boolean z10) {
        for (SAModuleProtocol moduleState : this.mServiceMap.values()) {
            moduleState.setModuleState(z10);
        }
    }

    public void setModuleStateByName(String str, boolean z10) {
        SAModuleProtocol sAModuleProtocol;
        if (this.mServiceMap.containsKey(str) && (sAModuleProtocol = this.mServiceMap.get(str)) != null && z10 != sAModuleProtocol.isEnable()) {
            sAModuleProtocol.setModuleState(z10);
        }
    }
}
