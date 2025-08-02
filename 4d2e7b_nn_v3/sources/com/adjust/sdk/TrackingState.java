package com.adjust.sdk;

public enum TrackingState {
    OPTED_OUT(1);
    
    private int value;

    private TrackingState(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
