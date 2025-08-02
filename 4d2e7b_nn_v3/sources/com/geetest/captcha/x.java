package com.geetest.captcha;

import kotlin.jvm.internal.m;

public enum x {
    FLOWING("-10"),
    SUCCESS("-11"),
    END("-12"),
    FAIL("-13"),
    CANCEL("-14"),
    NONE("-15");
    
    public String type;

    public enum a {
        FLOWING("-16"),
        SUCCESS("-17"),
        FAIL("-18"),
        NONE("-19");
        
        public String type;

        /* access modifiers changed from: public */
        a(String str) {
            this.type = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            m.f(str, "<set-?>");
            this.type = str;
        }
    }

    /* access modifiers changed from: public */
    x(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        m.f(str, "<set-?>");
        this.type = str;
    }
}
