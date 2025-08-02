package com.facebook.react.views.scroll;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.facebook.react.bridge.AssertionException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.m;
import com.facebook.react.uimanager.i0;

class b extends AccessibilityDelegateCompat {

    /* renamed from: a  reason: collision with root package name */
    private final String f4134a = b.class.getSimpleName();

    b() {
    }

    private void a(View view, AccessibilityEvent accessibilityEvent) {
        boolean z10;
        View childAt;
        ReadableMap readableMap;
        ReadableMap readableMap2 = (ReadableMap) view.getTag(m.f20845b);
        if (readableMap2 != null) {
            accessibilityEvent.setItemCount(readableMap2.getInt("itemCount"));
            if (view instanceof ViewGroup) {
                View childAt2 = ((ViewGroup) view).getChildAt(0);
                if (childAt2 instanceof ViewGroup) {
                    Integer num = null;
                    int i10 = 0;
                    Integer num2 = null;
                    while (true) {
                        ViewGroup viewGroup = (ViewGroup) childAt2;
                        if (i10 < viewGroup.getChildCount()) {
                            View childAt3 = viewGroup.getChildAt(i10);
                            if (view instanceof ReactScrollView) {
                                z10 = ((ReactScrollView) view).x(childAt3);
                            } else if (view instanceof ReactHorizontalScrollView) {
                                z10 = ((ReactHorizontalScrollView) view).A(childAt3);
                            } else {
                                return;
                            }
                            ReadableMap readableMap3 = (ReadableMap) childAt3.getTag(m.f20846c);
                            if (childAt3 instanceof ViewGroup) {
                                ViewGroup viewGroup2 = (ViewGroup) childAt3;
                                if (viewGroup2.getChildCount() > 0 && readableMap3 == null && (childAt = viewGroup2.getChildAt(0)) != null && (readableMap = (ReadableMap) childAt.getTag(m.f20846c)) != null) {
                                    readableMap3 = readableMap;
                                }
                                if (z10 && readableMap3 != null) {
                                    if (num == null) {
                                        num = Integer.valueOf(readableMap3.getInt("itemIndex"));
                                    }
                                    num2 = Integer.valueOf(readableMap3.getInt("itemIndex"));
                                }
                                if (!(num == null || num2 == null)) {
                                    accessibilityEvent.setFromIndex(num.intValue());
                                    accessibilityEvent.setToIndex(num2.intValue());
                                }
                                i10++;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    private void b(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        i0.e d10 = i0.e.d(view);
        if (d10 != null) {
            i0.p(accessibilityNodeInfoCompat, d10, view.getContext());
        }
        ReadableMap readableMap = (ReadableMap) view.getTag(m.f20845b);
        if (readableMap != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(readableMap.getInt("rowCount"), readableMap.getInt("columnCount"), readableMap.getBoolean("hierarchical")));
        }
        if (view instanceof ReactScrollView) {
            accessibilityNodeInfoCompat.setScrollable(((ReactScrollView) view).getScrollEnabled());
        } else if (view instanceof ReactHorizontalScrollView) {
            accessibilityNodeInfoCompat.setScrollable(((ReactHorizontalScrollView) view).getScrollEnabled());
        }
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof ReactScrollView) || (view instanceof ReactHorizontalScrollView)) {
            a(view, accessibilityEvent);
            return;
        }
        String str = this.f4134a;
        ReactSoftExceptionLogger.logSoftException(str, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: " + view.getClass().getSimpleName()));
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        if ((view instanceof ReactScrollView) || (view instanceof ReactHorizontalScrollView)) {
            b(view, accessibilityNodeInfoCompat);
            return;
        }
        String str = this.f4134a;
        ReactSoftExceptionLogger.logSoftException(str, new AssertionException("ReactScrollViewAccessibilityDelegate should only be used with ReactScrollView or ReactHorizontalScrollView, not with class: " + view.getClass().getSimpleName()));
    }
}
