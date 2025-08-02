package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;

public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        private HeartBeat(int i10) {
            this.code = i10;
        }

        public int getCode() {
            return this.code;
        }
    }

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);
}
