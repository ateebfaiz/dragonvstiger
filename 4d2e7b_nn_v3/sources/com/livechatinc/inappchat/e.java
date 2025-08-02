package com.livechatinc.inappchat;

import android.util.Log;
import android.webkit.JavascriptInterface;
import c.d;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import p9.a;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final ChatWindowViewImpl f10141a;

    public e(ChatWindowViewImpl chatWindowViewImpl) {
        this.f10141a = chatWindowViewImpl;
    }

    private void a(String str, String str2) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -451356817:
                if (str.equals("uiReady")) {
                    c10 = 0;
                    break;
                }
                break;
            case 1549654599:
                if (str.equals("newMessage")) {
                    c10 = 1;
                    break;
                }
                break;
            case 1871841354:
                if (str.equals("hideChatWindow")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                this.f10141a.I();
                return;
            case 1:
                ChatWindowViewImpl chatWindowViewImpl = this.f10141a;
                d.a(new GsonBuilder().create().fromJson(str2, a.class));
                chatWindowViewImpl.H((a) null);
                return;
            case 2:
                this.f10141a.G();
                return;
            default:
                return;
        }
    }

    @JavascriptInterface
    public void postMessage(String str) {
        Log.i("Interface", "postMessage: " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("messageType")) {
                a(jSONObject.getString("messageType"), str);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
