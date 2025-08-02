package com.geetest.core;

public enum h6 {
    CM("CM"),
    CT("CT"),
    CU("CU"),
    UNKNOWN("Unknown");
    
    private final String type;

    /* access modifiers changed from: public */
    h6(String str) {
        this.type = str;
    }

    public static h6 fromString(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 2154:
                if (str.equals("CM")) {
                    c10 = 0;
                    break;
                }
                break;
            case 2161:
                if (str.equals("CT")) {
                    c10 = 1;
                    break;
                }
                break;
            case 2162:
                if (str.equals("CU")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return CM;
            case 1:
                return CT;
            case 2:
                return CU;
            default:
                return UNKNOWN;
        }
    }

    public String getType() {
        return this.type;
    }
}
