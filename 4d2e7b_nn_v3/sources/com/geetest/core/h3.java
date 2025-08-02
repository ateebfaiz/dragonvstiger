package com.geetest.core;

import java.security.PrivilegedAction;

public class h3 implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6009a;

    public h3(String str) {
        this.f6009a = str;
    }

    public Object run() {
        return System.getProperty(this.f6009a);
    }
}
