package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.n;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.sequences.Sequence;

public final class ViewGroupKt {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15175a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final Iterator invoke(View view) {
            ViewGroup viewGroup;
            Sequence<View> children;
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup == null || (children = ViewGroupKt.getChildren(viewGroup)) == null) {
                return null;
            }
            return children.iterator();
        }
    }

    public static final boolean contains(ViewGroup viewGroup, View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            function1.invoke(viewGroup.getChildAt(i10));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            function2.invoke(Integer.valueOf(i10), viewGroup.getChildAt(i10));
        }
    }

    public static final View get(ViewGroup viewGroup, int i10) {
        View childAt = viewGroup.getChildAt(i10);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Size: " + viewGroup.getChildCount());
    }

    public static final Sequence<View> getChildren(ViewGroup viewGroup) {
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final Sequence<View> getDescendants(ViewGroup viewGroup) {
        return new ViewGroupKt$special$$inlined$Sequence$1(viewGroup);
    }

    public static final IntRange getIndices(ViewGroup viewGroup) {
        return l.l(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10) {
        marginLayoutParams.setMargins(i10, i10, i10, i10);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.leftMargin;
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.rightMargin;
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i10, i11, i12, i13);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i10, @Px int i11, @Px int i12, @Px int i13) {
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = marginLayoutParams.getMarginStart();
        }
        if ((i14 & 2) != 0) {
            i11 = marginLayoutParams.topMargin;
        }
        if ((i14 & 4) != 0) {
            i12 = marginLayoutParams.getMarginEnd();
        }
        if ((i14 & 8) != 0) {
            i13 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i10);
        marginLayoutParams.topMargin = i11;
        marginLayoutParams.setMarginEnd(i12);
        marginLayoutParams.bottomMargin = i13;
    }
}
