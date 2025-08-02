package com.alibaba.pdns.r;

import com.alibaba.pdns.u.a;

class b implements Runnable {
    b() {
    }

    public void run() {
        d.h();
        while (true) {
            try {
                a.a("clean thread run ");
                Thread.sleep(d.f18228b.longValue());
            } catch (InterruptedException e10) {
                if (a.f18279a) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
