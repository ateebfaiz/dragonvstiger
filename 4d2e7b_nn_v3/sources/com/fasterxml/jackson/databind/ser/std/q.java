package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.k;
import com.fasterxml.jackson.databind.b0;
import i8.b;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import q8.g;

public class q extends g0 {
    public q() {
        super(InetSocketAddress.class);
    }

    /* renamed from: x */
    public void f(InetSocketAddress inetSocketAddress, f fVar, b0 b0Var) {
        String str;
        String substring;
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            str = inetSocketAddress.getHostName();
        } else {
            str = address.toString().trim();
        }
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                if (address instanceof Inet6Address) {
                    substring = "[" + str.substring(1) + "]";
                } else {
                    substring = str.substring(1);
                }
                str = substring;
            } else {
                str = str.substring(0, indexOf);
            }
        }
        fVar.s0(str + ":" + inetSocketAddress.getPort());
    }

    /* renamed from: y */
    public void h(InetSocketAddress inetSocketAddress, f fVar, b0 b0Var, g gVar) {
        b g10 = gVar.g(fVar, gVar.f(inetSocketAddress, InetSocketAddress.class, k.VALUE_STRING));
        f(inetSocketAddress, fVar, b0Var);
        gVar.h(fVar, g10);
    }
}
