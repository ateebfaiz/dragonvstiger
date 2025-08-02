package com.onesignal;

import android.os.Bundle;

class n implements m {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f10804a = new Bundle();

    n() {
    }

    public boolean a(String str, boolean z10) {
        return this.f10804a.getBoolean(str, z10);
    }

    public void b(String str, Long l10) {
        this.f10804a.putLong(str, l10.longValue());
    }

    public boolean c(String str) {
        return this.f10804a.containsKey(str);
    }

    /* renamed from: d */
    public Bundle getBundle() {
        return this.f10804a;
    }

    public Integer getInt(String str) {
        return Integer.valueOf(this.f10804a.getInt(str));
    }

    public Long getLong(String str) {
        return Long.valueOf(this.f10804a.getLong(str));
    }

    public String getString(String str) {
        return this.f10804a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f10804a.putString(str, str2);
    }
}
