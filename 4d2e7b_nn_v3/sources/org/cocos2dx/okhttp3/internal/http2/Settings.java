package org.cocos2dx.okhttp3.internal.http2;

import java.util.Arrays;

public final class Settings {
    static final int COUNT = 10;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    static final int ENABLE_PUSH = 2;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: package-private */
    public void clear() {
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: package-private */
    public int get(int i10) {
        return this.values[i10];
    }

    /* access modifiers changed from: package-private */
    public boolean getEnablePush(boolean z10) {
        int i10;
        if ((this.set & 4) != 0) {
            i10 = this.values[2];
        } else if (z10) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        if (i10 == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int getInitialWindowSize() {
        if ((this.set & 128) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int getMaxConcurrentStreams(int i10) {
        if ((this.set & 16) != 0) {
            return this.values[4];
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public int getMaxFrameSize(int i10) {
        if ((this.set & 32) != 0) {
            return this.values[5];
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public int getMaxHeaderListSize(int i10) {
        if ((this.set & 64) != 0) {
            return this.values[6];
        }
        return i10;
    }

    /* access modifiers changed from: package-private */
    public boolean isSet(int i10) {
        if (((1 << i10) & this.set) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void merge(Settings settings) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (settings.isSet(i10)) {
                set(i10, settings.get(i10));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Settings set(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.values;
            if (i10 < iArr.length) {
                this.set = (1 << i10) | this.set;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return Integer.bitCount(this.set);
    }
}
