package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

final class p0 {

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f9272d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a  reason: collision with root package name */
    private final String f9273a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9274b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9275c;

    private p0(String str, String str2) {
        this.f9273a = d(str2, str);
        this.f9274b = str;
        this.f9275c = str + "!" + str2;
    }

    static p0 a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("!", -1);
        if (split.length != 2) {
            return null;
        }
        return new p0(split[0], split[1]);
    }

    private static String d(String str, String str2) {
        if (str != null && str.startsWith("/topics/")) {
            Log.w(Constants.TAG, String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str != null && f9272d.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, "[a-zA-Z0-9-_.~%]{1,900}"}));
    }

    public static p0 f(String str) {
        return new p0("S", str);
    }

    public static p0 g(String str) {
        return new p0("U", str);
    }

    public String b() {
        return this.f9274b;
    }

    public String c() {
        return this.f9273a;
    }

    public String e() {
        return this.f9275c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p0)) {
            return false;
        }
        p0 p0Var = (p0) obj;
        if (!this.f9273a.equals(p0Var.f9273a) || !this.f9274b.equals(p0Var.f9274b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f9274b, this.f9273a);
    }
}
