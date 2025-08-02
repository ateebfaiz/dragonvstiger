package com.geetest.core;

import java.security.PrivilegedAction;
import java.security.Security;

public class g3 implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f5983a;

    public g3(String str) {
        this.f5983a = str;
    }

    public Object run() {
        return Security.getProperty(this.f5983a);
    }
}
