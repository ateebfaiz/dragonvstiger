package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Integer.compare(((View) obj2).getId(), ((View) obj).getId());
    }
}
