package com.bugsnag.android;

final class m2 {

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f18853a = new StringBuilder();

    public final void a(String str, Object obj) {
        StringBuilder sb2 = this.f18853a;
        sb2.append(str + '=' + obj);
        this.f18853a.append("\n");
    }

    public String toString() {
        return this.f18853a.toString();
    }
}
