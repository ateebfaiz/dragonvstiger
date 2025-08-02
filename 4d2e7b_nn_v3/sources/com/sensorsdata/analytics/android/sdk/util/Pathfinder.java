package com.sensorsdata.analytics.android.sdk.util;

import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Pathfinder {
    private static final String TAG = "SA.PathFinder";
    private final IntStack mIndexStack = new IntStack();

    public interface Accumulator {
        void accumulate(View view);
    }

    private static class IntStack {
        private static final int MAX_INDEX_STACK_SIZE = 256;
        private final int[] mStack = new int[256];
        private int mStackSize = 0;

        public int alloc() {
            int i10 = this.mStackSize;
            this.mStackSize = i10 + 1;
            this.mStack[i10] = 0;
            return i10;
        }

        public void free() {
            int i10 = this.mStackSize - 1;
            this.mStackSize = i10;
            if (i10 < 0) {
                throw new ArrayIndexOutOfBoundsException(this.mStackSize);
            }
        }

        public boolean full() {
            if (this.mStack.length == this.mStackSize) {
                return true;
            }
            return false;
        }

        public void increment(int i10) {
            int[] iArr = this.mStack;
            iArr[i10] = iArr[i10] + 1;
        }

        public int read(int i10) {
            return this.mStack[i10];
        }
    }

    public static class PathElement {
        public static final int SHORTEST_PREFIX = 1;
        public static final int ZERO_LENGTH_PREFIX = 0;
        public final int index;
        public final int prefix;
        public final String viewClassName;
        public final int viewId;

        public PathElement(int i10, String str, int i11, int i12) {
            this.prefix = i10;
            this.viewClassName = str;
            this.index = i11;
            this.viewId = i12;
        }

        public String toString() {
            try {
                JSONObject jSONObject = new JSONObject();
                if (this.prefix == 1) {
                    jSONObject.put("prefix", "shortest");
                }
                String str = this.viewClassName;
                if (str != null) {
                    jSONObject.put("view_class", str);
                }
                int i10 = this.index;
                if (i10 > -1) {
                    jSONObject.put(FirebaseAnalytics.Param.INDEX, i10);
                }
                int i11 = this.viewId;
                if (i11 > -1) {
                    jSONObject.put("id", i11);
                }
                return jSONObject.toString();
            } catch (JSONException e10) {
                throw new RuntimeException("Can't serialize PathElement to String", e10);
            }
        }
    }

    private View findPrefixedMatch(PathElement pathElement, View view, int i10) {
        View findPrefixedMatch;
        int read = this.mIndexStack.read(i10);
        if (matches(pathElement, view)) {
            this.mIndexStack.increment(i10);
            int i11 = pathElement.index;
            if (i11 == -1 || i11 == read) {
                return view;
            }
        }
        if (pathElement.prefix != 1 || !(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            if (childAt != null && (findPrefixedMatch = findPrefixedMatch(pathElement, childAt, i10)) != null) {
                return findPrefixedMatch;
            }
        }
        return null;
    }

    private void findTargetsInMatchedView(View view, List<PathElement> list, Accumulator accumulator) {
        if (list.isEmpty()) {
            accumulator.accumulate(view);
        } else if (this.mIndexStack.full()) {
            SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            PathElement pathElement = list.get(0);
            List<PathElement> subList = list.subList(1, list.size());
            int childCount = viewGroup.getChildCount();
            int alloc = this.mIndexStack.alloc();
            for (int i10 = 0; i10 < childCount; i10++) {
                View findPrefixedMatch = findPrefixedMatch(pathElement, viewGroup.getChildAt(i10), alloc);
                if (findPrefixedMatch != null) {
                    findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
                }
                if (pathElement.index >= 0 && this.mIndexStack.read(alloc) > pathElement.index) {
                    break;
                }
            }
            this.mIndexStack.free();
        }
    }

    public static boolean hasClassName(Object obj, String str) {
        Class cls = obj.getClass();
        String canonicalName = SnapCache.getInstance().getCanonicalName(cls);
        while (canonicalName != null) {
            if (canonicalName.equals(str)) {
                return true;
            }
            if (cls == Object.class) {
                return false;
            }
            cls = cls.getSuperclass();
            canonicalName = SnapCache.getInstance().getCanonicalName(cls);
        }
        return false;
    }

    private boolean matches(PathElement pathElement, View view) {
        String str = pathElement.viewClassName;
        if (str != null && !hasClassName(view, str)) {
            return false;
        }
        if (-1 == pathElement.viewId || view.getId() == pathElement.viewId) {
            return true;
        }
        return false;
    }

    public void findTargetsInRoot(View view, List<PathElement> list, Accumulator accumulator) {
        if (!list.isEmpty()) {
            if (this.mIndexStack.full()) {
                SALog.i(TAG, "Path is too deep, there is no memory to perfrom the finding");
                return;
            }
            List<PathElement> subList = list.subList(1, list.size());
            View findPrefixedMatch = findPrefixedMatch(list.get(0), view, this.mIndexStack.alloc());
            this.mIndexStack.free();
            if (findPrefixedMatch != null) {
                findTargetsInMatchedView(findPrefixedMatch, subList, accumulator);
            }
        }
    }
}
