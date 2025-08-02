package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

abstract class h extends LinearLayoutManager {

    class a extends LinearSmoothScroller {
        a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    h(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i10) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i10);
        startSmoothScroll(aVar);
    }
}
