package com.geetest.core;

import androidx.core.view.MotionEventCompat;

public enum e4 {
    DIRECT(0),
    ONE_BYTE(24),
    TWO_BYTES(25),
    FOUR_BYTES(26),
    EIGHT_BYTES(27),
    RESERVED(28),
    INDEFINITE(31);
    
    private final int value;

    /* access modifiers changed from: public */
    e4(int i10) {
        this.value = i10;
    }

    public static e4 ofByte(int i10) {
        switch (i10 & 31) {
            case 24:
                return ONE_BYTE;
            case 25:
                return TWO_BYTES;
            case 26:
                return FOUR_BYTES;
            case 27:
                return EIGHT_BYTES;
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
            case 29:
            case 30:
                return RESERVED;
            case 31:
                return INDEFINITE;
            default:
                return DIRECT;
        }
    }

    public int getValue() {
        return this.value;
    }
}
