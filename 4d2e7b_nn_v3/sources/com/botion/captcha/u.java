package com.botion.captcha;

import kotlin.jvm.internal.m;

public enum u {
    FLOWING("-10"),
    SUCCESS("-11"),
    END("-12"),
    FAIL("-13"),
    CANCEL("-14"),
    NONE("-15");
    
    private String type;

    public enum a {
        FLOWING("-16"),
        SUCCESS("-17"),
        FAIL("-18"),
        NONE("-19");
        
        private String type;

        private a(String str) {
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

    private u(String str) {
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
