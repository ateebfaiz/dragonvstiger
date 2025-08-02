package com.cocos.lib;

import com.cocos.lib.JsbBridge;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JsbBridgeWrapper {
    private static JsbBridgeWrapper instance;
    private final HashMap<String, ArrayList<OnScriptEventListener>> eventMap = new HashMap<>();

    public interface OnScriptEventListener {
        void onScriptEvent(String str);
    }

    class a implements JsbBridge.ICallback {
        a() {
        }

        public void onScript(String str, String str2) {
            JsbBridgeWrapper.this.triggerEvents(str, str2);
        }
    }

    private JsbBridgeWrapper() {
        JsbBridge.setCallback(new a());
    }

    public static JsbBridgeWrapper getInstance() {
        if (instance == null) {
            instance = new JsbBridgeWrapper();
        }
        return instance;
    }

    /* access modifiers changed from: private */
    public void triggerEvents(String str, String str2) {
        ArrayList arrayList = this.eventMap.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OnScriptEventListener) it.next()).onScriptEvent(str2);
            }
        }
    }

    public void addScriptEventListener(String str, OnScriptEventListener onScriptEventListener) {
        if (this.eventMap.get(str) == null) {
            this.eventMap.put(str, new ArrayList());
        }
        this.eventMap.get(str).add(onScriptEventListener);
    }

    public void dispatchEventToScript(String str, String str2) {
        JsbBridge.sendToScript(str, str2);
    }

    public void removeAllListeners() {
        this.eventMap.clear();
    }

    public void removeAllListenersForEvent(String str) {
        this.eventMap.remove(str);
    }

    public boolean removeScriptEventListener(String str, OnScriptEventListener onScriptEventListener) {
        ArrayList arrayList = this.eventMap.get(str);
        if (arrayList == null) {
            return false;
        }
        arrayList.remove(onScriptEventListener);
        return true;
    }

    public void dispatchEventToScript(String str) {
        JsbBridge.sendToScript(str);
    }
}
