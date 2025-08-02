package com.onesignal;

import org.json.JSONObject;

class j3 {

    /* renamed from: a  reason: collision with root package name */
    String f10708a;

    /* renamed from: b  reason: collision with root package name */
    public a f10709b;

    /* renamed from: c  reason: collision with root package name */
    public String f10710c;

    /* renamed from: d  reason: collision with root package name */
    public b f10711d;

    /* renamed from: e  reason: collision with root package name */
    public Object f10712e;

    public enum a {
        TIME_SINCE_LAST_IN_APP("min_time_since"),
        SESSION_TIME("session_time"),
        CUSTOM("custom"),
        UNKNOWN("unknown");
        

        /* renamed from: a  reason: collision with root package name */
        private String f10718a;

        private a(String str) {
            this.f10718a = str;
        }

        public static a b(String str) {
            for (a aVar : values()) {
                if (aVar.f10718a.equalsIgnoreCase(str)) {
                    return aVar;
                }
            }
            return UNKNOWN;
        }

        public String toString() {
            return this.f10718a;
        }
    }

    public enum b {
        GREATER_THAN("greater"),
        LESS_THAN("less"),
        EQUAL_TO("equal"),
        NOT_EQUAL_TO("not_equal"),
        LESS_THAN_OR_EQUAL_TO("less_or_equal"),
        GREATER_THAN_OR_EQUAL_TO("greater_or_equal"),
        EXISTS("exists"),
        NOT_EXISTS("not_exists"),
        CONTAINS("in");
        

        /* renamed from: a  reason: collision with root package name */
        private String f10729a;

        private b(String str) {
            this.f10729a = str;
        }

        public static b c(String str) {
            for (b bVar : values()) {
                if (bVar.f10729a.equalsIgnoreCase(str)) {
                    return bVar;
                }
            }
            return EQUAL_TO;
        }

        public boolean b() {
            if (this == EQUAL_TO || this == NOT_EQUAL_TO) {
                return true;
            }
            return false;
        }

        public String toString() {
            return this.f10729a;
        }
    }

    j3(JSONObject jSONObject) {
        this.f10708a = jSONObject.getString("id");
        this.f10709b = a.b(jSONObject.getString("kind"));
        this.f10710c = jSONObject.optString("property", (String) null);
        this.f10711d = b.c(jSONObject.getString("operator"));
        this.f10712e = jSONObject.opt("value");
    }

    public String toString() {
        return "OSTrigger{triggerId='" + this.f10708a + '\'' + ", kind=" + this.f10709b + ", property='" + this.f10710c + '\'' + ", operatorType=" + this.f10711d + ", value=" + this.f10712e + '}';
    }
}
