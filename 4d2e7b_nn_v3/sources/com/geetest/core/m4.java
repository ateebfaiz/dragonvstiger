package com.geetest.core;

public enum m4 {
    UNSIGNED_INTEGER(0),
    NEGATIVE_INTEGER(1),
    BYTE_STRING(2),
    UNICODE_STRING(3),
    ARRAY(4),
    MAP(5),
    TAG(6),
    SPECIAL(7);
    
    private final int value;

    /* access modifiers changed from: public */
    m4(int i10) {
        this.value = i10;
    }

    public static m4 ofByte(int i10) throws q3 {
        switch (i10 >> 5) {
            case 0:
                return UNSIGNED_INTEGER;
            case 1:
                return NEGATIVE_INTEGER;
            case 2:
                return BYTE_STRING;
            case 3:
                return UNICODE_STRING;
            case 4:
                return ARRAY;
            case 5:
                return MAP;
            case 6:
                return TAG;
            case 7:
                return SPECIAL;
            default:
                throw new q3("Not implemented major type " + i10);
        }
    }

    public int getValue() {
        return this.value;
    }
}
