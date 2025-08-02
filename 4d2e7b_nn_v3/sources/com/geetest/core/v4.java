package com.geetest.core;

import androidx.core.view.MotionEventCompat;

public enum v4 {
    SIMPLE_VALUE,
    SIMPLE_VALUE_NEXT_BYTE,
    IEEE_754_HALF_PRECISION_FLOAT,
    IEEE_754_SINGLE_PRECISION_FLOAT,
    IEEE_754_DOUBLE_PRECISION_FLOAT,
    BREAK;

    public static v4 ofByte(int i10) throws q3 {
        switch (i10 & 31) {
            case 24:
                return SIMPLE_VALUE_NEXT_BYTE;
            case 25:
                return IEEE_754_HALF_PRECISION_FLOAT;
            case 26:
                return IEEE_754_SINGLE_PRECISION_FLOAT;
            case 27:
                return IEEE_754_DOUBLE_PRECISION_FLOAT;
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
            case 29:
            case 30:
                throw new q3("Not implemented special type " + i10);
            case 31:
                return BREAK;
            default:
                return SIMPLE_VALUE;
        }
    }
}
