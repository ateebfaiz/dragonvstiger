package com.geetest.core;

import androidx.core.view.MotionEventCompat;

public enum s4 {
    FALSE(20),
    TRUE(21),
    NULL(22),
    UNDEFINED(23),
    RESERVED(0),
    UNALLOCATED(0);
    
    private final int value;

    /* access modifiers changed from: public */
    s4(int i10) {
        this.value = i10;
    }

    public static s4 ofByte(int i10) {
        switch (i10 & 31) {
            case 20:
                return FALSE;
            case 21:
                return TRUE;
            case 22:
                return NULL;
            case 23:
                return UNDEFINED;
            case 24:
            case 25:
            case 26:
            case 27:
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
            case 29:
            case 30:
            case 31:
                return RESERVED;
            default:
                return UNALLOCATED;
        }
    }

    public int getValue() {
        return this.value;
    }
}
