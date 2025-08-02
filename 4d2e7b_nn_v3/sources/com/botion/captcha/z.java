package com.botion.captcha;

public enum z {
    AUTO(0),
    NORMAL(1),
    DARK(2),
    OTHER(3);
    
    private int value;

    private z(int i10) {
        this.value = i10;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i10) {
        this.value = i10;
    }
}
