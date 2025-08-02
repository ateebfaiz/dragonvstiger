package com.onesignal;

import android.os.PersistableBundle;

class p implements m {

    /* renamed from: a  reason: collision with root package name */
    private PersistableBundle f10958a = new PersistableBundle();

    p() {
    }

    public boolean a(String str, boolean z10) {
        return this.f10958a.getBoolean(str, z10);
    }

    public void b(String str, Long l10) {
        this.f10958a.putLong(str, l10.longValue());
    }

    public boolean c(String str) {
        return this.f10958a.containsKey(str);
    }

    /* renamed from: d */
    public PersistableBundle getBundle() {
        return this.f10958a;
    }

    public Integer getInt(String str) {
        return Integer.valueOf(this.f10958a.getInt(str));
    }

    public Long getLong(String str) {
        return Long.valueOf(this.f10958a.getLong(str));
    }

    public String getString(String str) {
        return this.f10958a.getString(str);
    }

    public void putString(String str, String str2) {
        this.f10958a.putString(str, str2);
    }
}
