package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.view.View;
import com.sensorsdata.analytics.android.sdk.util.Pathfinder;
import java.util.List;

public abstract class ViewVisitor implements Pathfinder.Accumulator {
    private static final String TAG = "SA.ViewVisitor";
    private final List<Pathfinder.PathElement> mPath;
    private final Pathfinder mPathfinder = new Pathfinder();

    protected ViewVisitor(List<Pathfinder.PathElement> list) {
        this.mPath = list;
    }

    public abstract void cleanup();

    /* access modifiers changed from: protected */
    public abstract String name();

    public void visit(View view) {
        this.mPathfinder.findTargetsInRoot(view, this.mPath, this);
    }
}
