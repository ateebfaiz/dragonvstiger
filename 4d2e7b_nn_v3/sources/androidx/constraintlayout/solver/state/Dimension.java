package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public class Dimension {
    public static final Object FIXED_DIMENSION = new Object();
    public static final Object PARENT_DIMENSION = new Object();
    public static final Object PERCENT_DIMENSION = new Object();
    public static final Object SPREAD_DIMENSION = new Object();
    public static final Object WRAP_DIMENSION = new Object();
    private final int WRAP_CONTENT;
    Object mInitialValue;
    boolean mIsSuggested;
    int mMax;
    int mMin;
    float mPercent;
    float mRatio;
    int mValue;

    public enum Type {
        FIXED,
        WRAP,
        MATCH_PARENT,
        MATCH_CONSTRAINT
    }

    private Dimension() {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mInitialValue = WRAP_DIMENSION;
        this.mIsSuggested = false;
    }

    public static Dimension Fixed(int i10) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(i10);
        return dimension;
    }

    public static Dimension Parent() {
        return new Dimension(PARENT_DIMENSION);
    }

    public static Dimension Percent(Object obj, float f10) {
        Dimension dimension = new Dimension(PERCENT_DIMENSION);
        dimension.percent(obj, f10);
        return dimension;
    }

    public static Dimension Spread() {
        return new Dimension(SPREAD_DIMENSION);
    }

    public static Dimension Suggested(int i10) {
        Dimension dimension = new Dimension();
        dimension.suggested(i10);
        return dimension;
    }

    public static Dimension Wrap() {
        return new Dimension(WRAP_DIMENSION);
    }

    public void apply(State state, ConstraintWidget constraintWidget, int i10) {
        int i11 = 2;
        if (i10 == 0) {
            if (this.mIsSuggested) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                Object obj = this.mInitialValue;
                if (obj == WRAP_DIMENSION) {
                    i11 = 1;
                } else if (obj != PERCENT_DIMENSION) {
                    i11 = 0;
                }
                constraintWidget.setHorizontalMatchStyle(i11, this.mMin, this.mMax, this.mPercent);
                return;
            }
            int i12 = this.mMin;
            if (i12 > 0) {
                constraintWidget.setMinWidth(i12);
            }
            int i13 = this.mMax;
            if (i13 < Integer.MAX_VALUE) {
                constraintWidget.setMaxWidth(i13);
            }
            Object obj2 = this.mInitialValue;
            if (obj2 == WRAP_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj2 == PARENT_DIMENSION) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj2 == null) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setWidth(this.mValue);
            }
        } else if (this.mIsSuggested) {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            Object obj3 = this.mInitialValue;
            if (obj3 == WRAP_DIMENSION) {
                i11 = 1;
            } else if (obj3 != PERCENT_DIMENSION) {
                i11 = 0;
            }
            constraintWidget.setVerticalMatchStyle(i11, this.mMin, this.mMax, this.mPercent);
        } else {
            int i14 = this.mMin;
            if (i14 > 0) {
                constraintWidget.setMinHeight(i14);
            }
            int i15 = this.mMax;
            if (i15 < Integer.MAX_VALUE) {
                constraintWidget.setMaxHeight(i15);
            }
            Object obj4 = this.mInitialValue;
            if (obj4 == WRAP_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            } else if (obj4 == PARENT_DIMENSION) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
            } else if (obj4 == null) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget.setHeight(this.mValue);
            }
        }
    }

    public Dimension fixed(Object obj) {
        this.mInitialValue = obj;
        if (obj instanceof Integer) {
            this.mValue = ((Integer) obj).intValue();
            this.mInitialValue = null;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public float getRatio() {
        return this.mRatio;
    }

    /* access modifiers changed from: package-private */
    public int getValue() {
        return this.mValue;
    }

    public Dimension max(int i10) {
        if (this.mMax >= 0) {
            this.mMax = i10;
        }
        return this;
    }

    public Dimension min(int i10) {
        if (i10 >= 0) {
            this.mMin = i10;
        }
        return this;
    }

    public Dimension percent(Object obj, float f10) {
        this.mPercent = f10;
        return this;
    }

    public Dimension ratio(float f10) {
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setRatio(float f10) {
        this.mRatio = f10;
    }

    /* access modifiers changed from: package-private */
    public void setValue(int i10) {
        this.mIsSuggested = false;
        this.mInitialValue = null;
        this.mValue = i10;
    }

    public Dimension suggested(int i10) {
        this.mIsSuggested = true;
        return this;
    }

    public Dimension min(Object obj) {
        if (obj == WRAP_DIMENSION) {
            this.mMin = -2;
        }
        return this;
    }

    public Dimension suggested(Object obj) {
        this.mInitialValue = obj;
        this.mIsSuggested = true;
        return this;
    }

    public static Dimension Fixed(Object obj) {
        Dimension dimension = new Dimension(FIXED_DIMENSION);
        dimension.fixed(obj);
        return dimension;
    }

    public static Dimension Suggested(Object obj) {
        Dimension dimension = new Dimension();
        dimension.suggested(obj);
        return dimension;
    }

    public Dimension max(Object obj) {
        Object obj2 = WRAP_DIMENSION;
        if (obj == obj2 && this.mIsSuggested) {
            this.mInitialValue = obj2;
            this.mMax = Integer.MAX_VALUE;
        }
        return this;
    }

    public Dimension fixed(int i10) {
        this.mInitialValue = null;
        this.mValue = i10;
        return this;
    }

    private Dimension(Object obj) {
        this.WRAP_CONTENT = -2;
        this.mMin = 0;
        this.mMax = Integer.MAX_VALUE;
        this.mPercent = 1.0f;
        this.mValue = 0;
        this.mRatio = 1.0f;
        this.mIsSuggested = false;
        this.mInitialValue = obj;
    }
}
