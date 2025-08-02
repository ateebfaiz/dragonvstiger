package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {
    protected int mCount;
    protected Helper mHelperWidget;
    protected int[] mIds = new int[32];
    private HashMap<Integer, String> mMap = new HashMap<>();
    protected String mReferenceIds;
    protected boolean mUseViewMeasure = false;
    private View[] mViews = null;
    protected Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        this.myContext = context;
        init((AttributeSet) null);
    }

    private void addID(String str) {
        if (str != null && str.length() != 0 && this.myContext != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int findId = findId(trim);
            if (findId != 0) {
                this.mMap.put(Integer.valueOf(findId), trim);
                addRscID(findId);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void addRscID(int i10) {
        if (i10 != getId()) {
            int i11 = this.mCount + 1;
            int[] iArr = this.mIds;
            if (i11 > iArr.length) {
                this.mIds = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.mIds;
            int i12 = this.mCount;
            iArr2[i12] = i10;
            this.mCount = i12 + 1;
        }
    }

    private int[] convertReferenceString(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i10 = 0;
        for (String trim : split) {
            int findId = findId(trim.trim());
            if (findId != 0) {
                iArr[i10] = findId;
                i10++;
            }
        }
        if (i10 != split.length) {
            return Arrays.copyOf(iArr, i10);
        }
        return iArr;
    }

    private int findId(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i10 = ((Integer) designInformation).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = findId(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i10 == 0 ? this.myContext.getResources().getIdentifier(str, "id", this.myContext.getPackageName()) : i10;
    }

    public void addView(View view) {
        if (view != this) {
            if (view.getId() == -1) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
            } else if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
            } else {
                this.mReferenceIds = null;
                addRscID(view.getId());
                requestLayout();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i10 = 0; i10 < this.mCount; i10++) {
            View viewById = constraintLayout.getViewById(this.mIds[i10]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.mIds, this.mCount);
    }

    /* access modifiers changed from: protected */
    public View[] getViews(ConstraintLayout constraintLayout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.mCount) {
            this.mViews = new View[this.mCount];
        }
        for (int i10 = 0; i10 < this.mCount; i10++) {
            this.mViews[i10] = constraintLayout.getViewById(this.mIds[i10]);
        }
        return this.mViews;
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                }
            }
        }
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintSet.Layout layout = constraint.layout;
        int[] iArr = layout.mReferenceIds;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.mReferenceIdString;
            if (str != null && str.length() > 0) {
                ConstraintSet.Layout layout2 = constraint.layout;
                layout2.mReferenceIds = convertReferenceString(this, layout2.mReferenceIdString);
            }
        }
        helperWidget.removeAllIds();
        if (constraint.layout.mReferenceIds != null) {
            int i10 = 0;
            while (true) {
                int[] iArr2 = constraint.layout.mReferenceIds;
                if (i10 < iArr2.length) {
                    ConstraintWidget constraintWidget = sparseArray.get(iArr2[i10]);
                    if (constraintWidget != null) {
                        helperWidget.add(constraintWidget);
                    }
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceIds;
        if (str != null) {
            setIds(str);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        if (this.mUseViewMeasure) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void removeView(View view) {
        int i10;
        int id2 = view.getId();
        if (id2 != -1) {
            this.mReferenceIds = null;
            int i11 = 0;
            while (true) {
                if (i11 >= this.mCount) {
                    break;
                } else if (this.mIds[i11] == id2) {
                    while (true) {
                        i10 = this.mCount;
                        if (i11 >= i10 - 1) {
                            break;
                        }
                        int[] iArr = this.mIds;
                        int i12 = i11 + 1;
                        iArr[i11] = iArr[i12];
                        i11 = i12;
                    }
                    this.mIds[i10 - 1] = 0;
                    this.mCount = i10 - 1;
                } else {
                    i11++;
                }
            }
            requestLayout();
        }
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z10) {
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.mReferenceIds = str;
        if (str != null) {
            int i10 = 0;
            this.mCount = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    addID(str.substring(i10));
                    return;
                } else {
                    addID(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int addRscID : iArr) {
            addRscID(addRscID);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.mMap.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updatePreLayout(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.mReferenceIds
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.solver.widgets.Helper r0 = r5.mHelperWidget
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.removeAllIds()
            r0 = 0
        L_0x0014:
            int r1 = r5.mCount
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.mIds
            r1 = r1[r0]
            android.view.View r2 = r6.getViewById(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.mMap
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.findId(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.mIds
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.mMap
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.getViewById(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.solver.widgets.Helper r1 = r5.mHelperWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r6.getViewWidget(r2)
            r1.add(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.solver.widgets.Helper r0 = r5.mHelperWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r6 = r6.mLayoutWidget
            r0.updateConstraints(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.updatePreLayout(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void validateParams() {
        if (this.mHelperWidget != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).widget = (ConstraintWidget) this.mHelperWidget;
            }
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myContext = context;
        init(attributeSet);
    }

    /* access modifiers changed from: protected */
    public void applyLayoutFeatures() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            applyLayoutFeatures((ConstraintLayout) parent);
        }
    }

    private int findId(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.myContext.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.myContext = context;
        init(attributeSet);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i10 = 0; i10 < this.mCount; i10++) {
            helper.add(sparseArray.get(this.mIds[i10]));
        }
    }
}
