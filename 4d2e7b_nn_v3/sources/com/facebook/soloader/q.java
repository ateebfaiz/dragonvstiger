package com.facebook.soloader;

import a8.b;

public class q implements b {
    public boolean a(String str, int i10) {
        int i11;
        if ((i10 & 1) != 0) {
            i11 = 16;
        } else {
            i11 = 0;
        }
        return SoLoader.u(str, i11);
    }
}
