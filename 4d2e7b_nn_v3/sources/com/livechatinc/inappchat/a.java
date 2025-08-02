package com.livechatinc.inappchat;

import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f10125a;

    /* renamed from: b  reason: collision with root package name */
    public final String f10126b;

    /* renamed from: c  reason: collision with root package name */
    public final String f10127c;

    /* renamed from: d  reason: collision with root package name */
    public final String f10128d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap f10129e;

    /* renamed from: com.livechatinc.inappchat.a$a  reason: collision with other inner class name */
    public static class C0116a {

        /* renamed from: a  reason: collision with root package name */
        private String f10130a;

        /* renamed from: b  reason: collision with root package name */
        private String f10131b;

        /* renamed from: c  reason: collision with root package name */
        private String f10132c;

        /* renamed from: d  reason: collision with root package name */
        private String f10133d;

        /* renamed from: e  reason: collision with root package name */
        private HashMap f10134e;

        public a a() {
            if (!TextUtils.isEmpty(this.f10130a)) {
                return new a(this.f10130a, this.f10131b, this.f10132c, this.f10133d, this.f10134e);
            }
            throw new IllegalStateException("Licence Number cannot be null");
        }

        public C0116a b(HashMap hashMap) {
            this.f10134e = hashMap;
            return this;
        }

        public C0116a c(String str) {
            this.f10131b = str;
            return this;
        }

        public C0116a d(String str) {
            this.f10130a = str;
            return this;
        }

        public C0116a e(String str) {
            this.f10133d = str;
            return this;
        }

        public C0116a f(String str) {
            this.f10132c = str;
            return this;
        }
    }

    public a(String str, String str2, String str3, String str4, HashMap hashMap) {
        this.f10125a = str;
        this.f10126b = str2;
        this.f10127c = str3;
        this.f10128d = str4;
        this.f10129e = hashMap;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : b().entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return bundle;
    }

    public Map b() {
        HashMap hashMap = new HashMap();
        hashMap.put("KEY_LICENCE_NUMBER", this.f10125a);
        String str = this.f10126b;
        if (str == null) {
            str = "0";
        }
        hashMap.put("KEY_GROUP_ID", str);
        if (!TextUtils.isEmpty(this.f10127c)) {
            hashMap.put("KEY_VISITOR_NAME", this.f10127c);
        }
        if (!TextUtils.isEmpty(this.f10128d)) {
            hashMap.put("KEY_VISITOR_EMAIL", this.f10128d);
        }
        HashMap hashMap2 = this.f10129e;
        if (hashMap2 != null) {
            for (String str2 : hashMap2.keySet()) {
                hashMap.put("#LCcustomParam_" + str2, this.f10129e.get(str2));
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f10125a.equals(aVar.f10125a)) {
            return false;
        }
        String str = this.f10126b;
        if (str == null ? aVar.f10126b != null : !str.equals(aVar.f10126b)) {
            return false;
        }
        String str2 = this.f10127c;
        if (str2 == null ? aVar.f10127c != null : !str2.equals(aVar.f10127c)) {
            return false;
        }
        String str3 = this.f10128d;
        if (str3 == null ? aVar.f10128d != null : !str3.equals(aVar.f10128d)) {
            return false;
        }
        HashMap hashMap = this.f10129e;
        HashMap hashMap2 = aVar.f10129e;
        if (hashMap != null) {
            return hashMap.equals(hashMap2);
        }
        if (hashMap2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int hashCode = this.f10125a.hashCode() * 31;
        String str = this.f10126b;
        int i13 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int i14 = (hashCode + i10) * 31;
        String str2 = this.f10127c;
        if (str2 != null) {
            i11 = str2.hashCode();
        } else {
            i11 = 0;
        }
        int i15 = (i14 + i11) * 31;
        String str3 = this.f10128d;
        if (str3 != null) {
            i12 = str3.hashCode();
        } else {
            i12 = 0;
        }
        int i16 = (i15 + i12) * 31;
        HashMap hashMap = this.f10129e;
        if (hashMap != null) {
            i13 = hashMap.hashCode();
        }
        return i16 + i13;
    }

    public String toString() {
        return "licenceNumber='" + this.f10125a + "'\ngroupId='" + this.f10126b + "'\nvisitorName='" + this.f10127c + "'\nvisitorEmail='" + this.f10128d + "'\ncustomVariables=" + this.f10129e;
    }
}
