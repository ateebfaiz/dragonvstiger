package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.bitmapsRemaining += intValue.intValue();
        }
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        if (this.bitmapsRemaining == 0) {
            return true;
        }
        return false;
    }

    public PreFillType remove() {
        int i10;
        PreFillType preFillType = this.keyList.get(this.keyIndex);
        Integer num = this.bitmapsPerType.get(preFillType);
        if (num.intValue() == 1) {
            this.bitmapsPerType.remove(preFillType);
            this.keyList.remove(this.keyIndex);
        } else {
            this.bitmapsPerType.put(preFillType, Integer.valueOf(num.intValue() - 1));
        }
        this.bitmapsRemaining--;
        if (this.keyList.isEmpty()) {
            i10 = 0;
        } else {
            i10 = (this.keyIndex + 1) % this.keyList.size();
        }
        this.keyIndex = i10;
        return preFillType;
    }
}
