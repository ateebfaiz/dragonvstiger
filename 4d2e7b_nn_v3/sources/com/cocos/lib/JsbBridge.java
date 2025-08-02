package com.cocos.lib;

public class JsbBridge {
    private static ICallback callback;

    public interface ICallback {
        void onScript(String str, String str2);
    }

    private static void callByScript(String str, String str2) {
        ICallback iCallback = callback;
        if (iCallback != null) {
            iCallback.onScript(str, str2);
        }
    }

    private static native void nativeSendToScript(String str, String str2);

    public static void sendToScript(String str, String str2) {
        nativeSendToScript(str, str2);
    }

    public static void setCallback(ICallback iCallback) {
        callback = iCallback;
    }

    public static void sendToScript(String str) {
        nativeSendToScript(str, (String) null);
    }
}
