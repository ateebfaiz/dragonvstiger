package com.onesignal;

import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class m1 {

    /* renamed from: a  reason: collision with root package name */
    private String f10773a;

    /* renamed from: b  reason: collision with root package name */
    private String f10774b;

    /* renamed from: c  reason: collision with root package name */
    private a f10775c;

    /* renamed from: d  reason: collision with root package name */
    private String f10776d;

    /* renamed from: e  reason: collision with root package name */
    private String f10777e;

    /* renamed from: f  reason: collision with root package name */
    private List f10778f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private List f10779g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private a2 f10780h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10781i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10782j;

    public enum a {
        IN_APP_WEBVIEW("webview"),
        BROWSER("browser"),
        REPLACE_CONTENT("replacement");
        

        /* renamed from: a  reason: collision with root package name */
        private String f10787a;

        private a(String str) {
            this.f10787a = str;
        }

        public static a b(String str) {
            for (a aVar : values()) {
                if (aVar.f10787a.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return null;
        }

        public String toString() {
            return this.f10787a;
        }
    }

    m1(JSONObject jSONObject) {
        this.f10773a = jSONObject.optString("id", (String) null);
        this.f10774b = jSONObject.optString("name", (String) null);
        this.f10776d = jSONObject.optString(ImagesContract.URL, (String) null);
        this.f10777e = jSONObject.optString("pageId", (String) null);
        a b10 = a.b(jSONObject.optString("url_target", (String) null));
        this.f10775c = b10;
        if (b10 == null) {
            this.f10775c = a.IN_APP_WEBVIEW;
        }
        this.f10782j = jSONObject.optBoolean("close", true);
        if (jSONObject.has("outcomes")) {
            h(jSONObject);
        }
        if (jSONObject.has("tags")) {
            this.f10780h = new a2(jSONObject.getJSONObject("tags"));
        }
        if (jSONObject.has("prompts")) {
            i(jSONObject);
        }
    }

    private void h(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("outcomes");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            this.f10778f.add(new s1((JSONObject) jSONArray.get(i10)));
        }
    }

    private void i(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("prompts");
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String string = jSONArray.getString(i10);
            string.hashCode();
            if (string.equals(Constants.PUSH)) {
                this.f10779g.add(new x1());
            } else if (string.equals(FirebaseAnalytics.Param.LOCATION)) {
                this.f10779g.add(new r1());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.f10773a;
    }

    public String b() {
        return this.f10776d;
    }

    public List c() {
        return this.f10778f;
    }

    public List d() {
        return this.f10779g;
    }

    public a2 e() {
        return this.f10780h;
    }

    public a f() {
        return this.f10775c;
    }

    public boolean g() {
        return this.f10781i;
    }

    /* access modifiers changed from: package-private */
    public void j(boolean z10) {
        this.f10781i = z10;
    }
}
