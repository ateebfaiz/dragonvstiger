package com.facebook.yoga;

import d8.a;
import java.util.ArrayList;
import java.util.List;

@a
public abstract class YogaNodeJNIBase extends q implements Cloneable {
    private static final byte BORDER = 4;
    private static final byte HAS_NEW_LAYOUT = 16;
    private static final byte LAYOUT_BORDER_START_INDEX = 14;
    private static final byte LAYOUT_DIRECTION_INDEX = 5;
    private static final byte LAYOUT_EDGE_SET_FLAG_INDEX = 0;
    private static final byte LAYOUT_HEIGHT_INDEX = 2;
    private static final byte LAYOUT_LEFT_INDEX = 3;
    private static final byte LAYOUT_MARGIN_START_INDEX = 6;
    private static final byte LAYOUT_PADDING_START_INDEX = 10;
    private static final byte LAYOUT_TOP_INDEX = 4;
    private static final byte LAYOUT_WIDTH_INDEX = 1;
    private static final byte MARGIN = 1;
    private static final byte PADDING = 2;
    @a
    private float[] arr;
    private b mBaselineFunction;
    private List<YogaNodeJNIBase> mChildren;
    private Object mData;
    private boolean mHasNewLayout;
    @a
    private int mLayoutDirection;
    private n mMeasureFunction;
    protected long mNativePointer;
    private YogaNodeJNIBase mOwner;

    /* renamed from: com.facebook.yoga.YogaNodeJNIBase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaEdge;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.yoga.h[] r0 = com.facebook.yoga.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$yoga$YogaEdge = r0
                com.facebook.yoga.h r1 = com.facebook.yoga.h.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.yoga.h r1 = com.facebook.yoga.h.TOP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.yoga.h r1 = com.facebook.yoga.h.RIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.yoga.h r1 = com.facebook.yoga.h.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.yoga.h r1 = com.facebook.yoga.h.START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$yoga$YogaEdge     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.yoga.h r1 = com.facebook.yoga.h.END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.yoga.YogaNodeJNIBase.AnonymousClass1.<clinit>():void");
        }
    }

    private YogaNodeJNIBase(long j10) {
        this.arr = null;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        if (j10 != 0) {
            this.mNativePointer = j10;
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private void clearChildren() {
        this.mChildren = null;
        YogaNative.jni_YGNodeRemoveAllChildrenJNI(this.mNativePointer);
    }

    private void freeze(q qVar) {
        getData();
    }

    @a
    private final long replaceChild(YogaNodeJNIBase yogaNodeJNIBase, int i10) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            list.remove(i10);
            this.mChildren.add(i10, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            return yogaNodeJNIBase.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }

    private static YogaValue valueFromLong(long j10) {
        return new YogaValue(Float.intBitsToFloat((int) j10), (int) (j10 >> 32));
    }

    public void addChildAt(q qVar, int i10) {
        if (qVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) qVar;
            if (yogaNodeJNIBase.mOwner == null) {
                if (this.mChildren == null) {
                    this.mChildren = new ArrayList(4);
                }
                this.mChildren.add(i10, yogaNodeJNIBase);
                yogaNodeJNIBase.mOwner = this;
                YogaNative.jni_YGNodeInsertChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i10);
                return;
            }
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
    }

    @a
    public final float baseline(float f10, float f11) {
        return this.mBaselineFunction.a(this, f10, f11);
    }

    public void calculateLayout(float f10, float f11) {
        freeze((q) null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) arrayList.get(i10);
            List<YogaNodeJNIBase> list = yogaNodeJNIBase.mChildren;
            if (list != null) {
                for (YogaNodeJNIBase next : list) {
                    next.freeze(yogaNodeJNIBase);
                    arrayList.add(next);
                }
            }
        }
        YogaNodeJNIBase[] yogaNodeJNIBaseArr = (YogaNodeJNIBase[]) arrayList.toArray(new YogaNodeJNIBase[arrayList.size()]);
        long[] jArr = new long[yogaNodeJNIBaseArr.length];
        for (int i11 = 0; i11 < yogaNodeJNIBaseArr.length; i11++) {
            jArr[i11] = yogaNodeJNIBaseArr[i11].mNativePointer;
        }
        YogaNative.jni_YGNodeCalculateLayoutJNI(this.mNativePointer, f10, f11, jArr, yogaNodeJNIBaseArr);
    }

    public void copyStyle(q qVar) {
        if (qVar instanceof YogaNodeJNIBase) {
            YogaNative.jni_YGNodeCopyStyleJNI(this.mNativePointer, ((YogaNodeJNIBase) qVar).mNativePointer);
        }
    }

    public void dirty() {
        YogaNative.jni_YGNodeMarkDirtyJNI(this.mNativePointer);
    }

    public a getAlignContent() {
        return a.b(YogaNative.jni_YGNodeStyleGetAlignContentJNI(this.mNativePointer));
    }

    public a getAlignItems() {
        return a.b(YogaNative.jni_YGNodeStyleGetAlignItemsJNI(this.mNativePointer));
    }

    public a getAlignSelf() {
        return a.b(YogaNative.jni_YGNodeStyleGetAlignSelfJNI(this.mNativePointer));
    }

    public float getAspectRatio() {
        return YogaNative.jni_YGNodeStyleGetAspectRatioJNI(this.mNativePointer);
    }

    public float getBorder(h hVar) {
        return YogaNative.jni_YGNodeStyleGetBorderJNI(this.mNativePointer, hVar.c());
    }

    public int getChildCount() {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getData() {
        return this.mData;
    }

    public g getDisplay() {
        return g.b(YogaNative.jni_YGNodeStyleGetDisplayJNI(this.mNativePointer));
    }

    public float getFlex() {
        return YogaNative.jni_YGNodeStyleGetFlexJNI(this.mNativePointer);
    }

    public YogaValue getFlexBasis() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetFlexBasisJNI(this.mNativePointer));
    }

    public k getFlexDirection() {
        return k.b(YogaNative.jni_YGNodeStyleGetFlexDirectionJNI(this.mNativePointer));
    }

    public float getFlexGrow() {
        return YogaNative.jni_YGNodeStyleGetFlexGrowJNI(this.mNativePointer);
    }

    public float getFlexShrink() {
        return YogaNative.jni_YGNodeStyleGetFlexShrinkJNI(this.mNativePointer);
    }

    public float getGap(l lVar) {
        return YogaNative.jni_YGNodeStyleGetGapJNI(this.mNativePointer, lVar.b());
    }

    public YogaValue getHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetHeightJNI(this.mNativePointer));
    }

    public m getJustifyContent() {
        return m.b(YogaNative.jni_YGNodeStyleGetJustifyContentJNI(this.mNativePointer));
    }

    public float getLayoutBorder(h hVar) {
        int i10;
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        int i11 = 0;
        float f10 = fArr[0];
        if ((((int) f10) & 4) != 4) {
            return 0.0f;
        }
        if ((((int) f10) & 1) == 1) {
            i10 = 0;
        } else {
            i10 = 4;
        }
        int i12 = 14 - i10;
        if ((((int) f10) & 2) != 2) {
            i11 = 4;
        }
        int i13 = i12 - i11;
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[hVar.ordinal()]) {
            case 1:
                return this.arr[i13];
            case 2:
                return this.arr[i13 + 1];
            case 3:
                return this.arr[i13 + 2];
            case 4:
                return this.arr[i13 + 3];
            case 5:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[i13 + 2];
                }
                return this.arr[i13];
            case 6:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[i13];
                }
                return this.arr[i13 + 2];
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public f getLayoutDirection() {
        int i10;
        float[] fArr = this.arr;
        if (fArr != null) {
            i10 = (int) fArr[5];
        } else {
            i10 = this.mLayoutDirection;
        }
        return f.b(i10);
    }

    public float getLayoutHeight() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[2];
        }
        return 0.0f;
    }

    public float getLayoutMargin(h hVar) {
        float[] fArr = this.arr;
        if (fArr == null || (((int) fArr[0]) & 1) != 1) {
            return 0.0f;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[hVar.ordinal()]) {
            case 1:
                return this.arr[6];
            case 2:
                return this.arr[7];
            case 3:
                return this.arr[8];
            case 4:
                return this.arr[9];
            case 5:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[8];
                }
                return this.arr[6];
            case 6:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[6];
                }
                return this.arr[8];
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(h hVar) {
        float[] fArr = this.arr;
        if (fArr == null) {
            return 0.0f;
        }
        int i10 = 0;
        float f10 = fArr[0];
        if ((((int) f10) & 2) != 2) {
            return 0.0f;
        }
        if ((((int) f10) & 1) != 1) {
            i10 = 4;
        }
        int i11 = 10 - i10;
        switch (AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaEdge[hVar.ordinal()]) {
            case 1:
                return this.arr[i11];
            case 2:
                return this.arr[11 - i10];
            case 3:
                return this.arr[12 - i10];
            case 4:
                return this.arr[13 - i10];
            case 5:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[12 - i10];
                }
                return this.arr[i11];
            case 6:
                if (getLayoutDirection() == f.RTL) {
                    return this.arr[i11];
                }
                return this.arr[12 - i10];
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutWidth() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[1];
        }
        return 0.0f;
    }

    public float getLayoutX() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[3];
        }
        return 0.0f;
    }

    public float getLayoutY() {
        float[] fArr = this.arr;
        if (fArr != null) {
            return fArr[4];
        }
        return 0.0f;
    }

    public YogaValue getMargin(h hVar) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMarginJNI(this.mNativePointer, hVar.c()));
    }

    public YogaValue getMaxHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxHeightJNI(this.mNativePointer));
    }

    public YogaValue getMaxWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMaxWidthJNI(this.mNativePointer));
    }

    public YogaValue getMinHeight() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinHeightJNI(this.mNativePointer));
    }

    public YogaValue getMinWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetMinWidthJNI(this.mNativePointer));
    }

    public s getOverflow() {
        return s.b(YogaNative.jni_YGNodeStyleGetOverflowJNI(this.mNativePointer));
    }

    public YogaValue getPadding(h hVar) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPaddingJNI(this.mNativePointer, hVar.c()));
    }

    public YogaValue getPosition(h hVar) {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetPositionJNI(this.mNativePointer, hVar.c()));
    }

    public t getPositionType() {
        return t.b(YogaNative.jni_YGNodeStyleGetPositionTypeJNI(this.mNativePointer));
    }

    public f getStyleDirection() {
        return f.b(YogaNative.jni_YGNodeStyleGetDirectionJNI(this.mNativePointer));
    }

    public YogaValue getWidth() {
        return valueFromLong(YogaNative.jni_YGNodeStyleGetWidthJNI(this.mNativePointer));
    }

    public v getWrap() {
        return v.b(YogaNative.jni_YGNodeStyleGetFlexWrapJNI(this.mNativePointer));
    }

    public boolean hasNewLayout() {
        float[] fArr = this.arr;
        if (fArr == null) {
            return this.mHasNewLayout;
        }
        if ((((int) fArr[0]) & 16) == 16) {
            return true;
        }
        return false;
    }

    public int indexOf(q qVar) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list == null) {
            return -1;
        }
        return list.indexOf(qVar);
    }

    public boolean isBaselineDefined() {
        if (this.mBaselineFunction != null) {
            return true;
        }
        return false;
    }

    public boolean isDirty() {
        return YogaNative.jni_YGNodeIsDirtyJNI(this.mNativePointer);
    }

    public boolean isMeasureDefined() {
        if (this.mMeasureFunction != null) {
            return true;
        }
        return false;
    }

    public boolean isReferenceBaseline() {
        return YogaNative.jni_YGNodeIsReferenceBaselineJNI(this.mNativePointer);
    }

    public void markLayoutSeen() {
        float[] fArr = this.arr;
        if (fArr != null) {
            fArr[0] = (float) (((int) fArr[0]) & -17);
        }
        this.mHasNewLayout = false;
    }

    @a
    public final long measure(float f10, int i10, float f11, int i11) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.U(this, f10, o.b(i10), f11, o.b(i11));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public void reset() {
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.arr = null;
        this.mHasNewLayout = true;
        this.mLayoutDirection = 0;
        YogaNative.jni_YGNodeResetJNI(this.mNativePointer);
    }

    public void setAlignContent(a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignContentJNI(this.mNativePointer, aVar.c());
    }

    public void setAlignItems(a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignItemsJNI(this.mNativePointer, aVar.c());
    }

    public void setAlignSelf(a aVar) {
        YogaNative.jni_YGNodeStyleSetAlignSelfJNI(this.mNativePointer, aVar.c());
    }

    public void setAlwaysFormsContainingBlock(boolean z10) {
        YogaNative.jni_YGNodeSetAlwaysFormsContainingBlockJNI(this.mNativePointer, z10);
    }

    public void setAspectRatio(float f10) {
        YogaNative.jni_YGNodeStyleSetAspectRatioJNI(this.mNativePointer, f10);
    }

    public void setBaselineFunction(b bVar) {
        boolean z10;
        this.mBaselineFunction = bVar;
        long j10 = this.mNativePointer;
        if (bVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        YogaNative.jni_YGNodeSetHasBaselineFuncJNI(j10, z10);
    }

    public void setBorder(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetBorderJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setDirection(f fVar) {
        YogaNative.jni_YGNodeStyleSetDirectionJNI(this.mNativePointer, fVar.c());
    }

    public void setDisplay(g gVar) {
        YogaNative.jni_YGNodeStyleSetDisplayJNI(this.mNativePointer, gVar.c());
    }

    public void setFlex(float f10) {
        YogaNative.jni_YGNodeStyleSetFlexJNI(this.mNativePointer, f10);
    }

    public void setFlexBasis(float f10) {
        YogaNative.jni_YGNodeStyleSetFlexBasisJNI(this.mNativePointer, f10);
    }

    public void setFlexBasisAuto() {
        YogaNative.jni_YGNodeStyleSetFlexBasisAutoJNI(this.mNativePointer);
    }

    public void setFlexBasisPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetFlexBasisPercentJNI(this.mNativePointer, f10);
    }

    public void setFlexDirection(k kVar) {
        YogaNative.jni_YGNodeStyleSetFlexDirectionJNI(this.mNativePointer, kVar.c());
    }

    public void setFlexGrow(float f10) {
        YogaNative.jni_YGNodeStyleSetFlexGrowJNI(this.mNativePointer, f10);
    }

    public void setFlexShrink(float f10) {
        YogaNative.jni_YGNodeStyleSetFlexShrinkJNI(this.mNativePointer, f10);
    }

    public void setGap(l lVar, float f10) {
        YogaNative.jni_YGNodeStyleSetGapJNI(this.mNativePointer, lVar.b(), f10);
    }

    public void setGapPercent(l lVar, float f10) {
        YogaNative.jni_YGNodeStyleSetGapPercentJNI(this.mNativePointer, lVar.b(), f10);
    }

    public void setHeight(float f10) {
        YogaNative.jni_YGNodeStyleSetHeightJNI(this.mNativePointer, f10);
    }

    public void setHeightAuto() {
        YogaNative.jni_YGNodeStyleSetHeightAutoJNI(this.mNativePointer);
    }

    public void setHeightPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetHeightPercentJNI(this.mNativePointer, f10);
    }

    public void setIsReferenceBaseline(boolean z10) {
        YogaNative.jni_YGNodeSetIsReferenceBaselineJNI(this.mNativePointer, z10);
    }

    public void setJustifyContent(m mVar) {
        YogaNative.jni_YGNodeStyleSetJustifyContentJNI(this.mNativePointer, mVar.c());
    }

    public void setMargin(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetMarginJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setMarginAuto(h hVar) {
        YogaNative.jni_YGNodeStyleSetMarginAutoJNI(this.mNativePointer, hVar.c());
    }

    public void setMarginPercent(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetMarginPercentJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setMaxHeight(float f10) {
        YogaNative.jni_YGNodeStyleSetMaxHeightJNI(this.mNativePointer, f10);
    }

    public void setMaxHeightPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetMaxHeightPercentJNI(this.mNativePointer, f10);
    }

    public void setMaxWidth(float f10) {
        YogaNative.jni_YGNodeStyleSetMaxWidthJNI(this.mNativePointer, f10);
    }

    public void setMaxWidthPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetMaxWidthPercentJNI(this.mNativePointer, f10);
    }

    public void setMeasureFunction(n nVar) {
        boolean z10;
        this.mMeasureFunction = nVar;
        long j10 = this.mNativePointer;
        if (nVar != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        YogaNative.jni_YGNodeSetHasMeasureFuncJNI(j10, z10);
    }

    public void setMinHeight(float f10) {
        YogaNative.jni_YGNodeStyleSetMinHeightJNI(this.mNativePointer, f10);
    }

    public void setMinHeightPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetMinHeightPercentJNI(this.mNativePointer, f10);
    }

    public void setMinWidth(float f10) {
        YogaNative.jni_YGNodeStyleSetMinWidthJNI(this.mNativePointer, f10);
    }

    public void setMinWidthPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetMinWidthPercentJNI(this.mNativePointer, f10);
    }

    public void setOverflow(s sVar) {
        YogaNative.jni_YGNodeStyleSetOverflowJNI(this.mNativePointer, sVar.c());
    }

    public void setPadding(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetPaddingJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setPaddingPercent(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetPaddingPercentJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setPosition(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetPositionJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setPositionPercent(h hVar, float f10) {
        YogaNative.jni_YGNodeStyleSetPositionPercentJNI(this.mNativePointer, hVar.c(), f10);
    }

    public void setPositionType(t tVar) {
        YogaNative.jni_YGNodeStyleSetPositionTypeJNI(this.mNativePointer, tVar.c());
    }

    public void setWidth(float f10) {
        YogaNative.jni_YGNodeStyleSetWidthJNI(this.mNativePointer, f10);
    }

    public void setWidthAuto() {
        YogaNative.jni_YGNodeStyleSetWidthAutoJNI(this.mNativePointer);
    }

    public void setWidthPercent(float f10) {
        YogaNative.jni_YGNodeStyleSetWidthPercentJNI(this.mNativePointer, f10);
    }

    public void setWrap(v vVar) {
        YogaNative.jni_YGNodeStyleSetFlexWrapJNI(this.mNativePointer, vVar.c());
    }

    public void swapChildAt(q qVar, int i10) {
        if (qVar instanceof YogaNodeJNIBase) {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) qVar;
            this.mChildren.remove(i10);
            this.mChildren.add(i10, yogaNodeJNIBase);
            yogaNodeJNIBase.mOwner = this;
            YogaNative.jni_YGNodeSwapChildJNI(this.mNativePointer, yogaNodeJNIBase.mNativePointer, i10);
        }
    }

    public YogaNodeJNIBase cloneWithChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            if (yogaNodeJNIBase.mChildren != null) {
                yogaNodeJNIBase.mChildren = new ArrayList(yogaNodeJNIBase.mChildren);
            }
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            for (int i10 = 0; i10 < yogaNodeJNIBase.getChildCount(); i10++) {
                yogaNodeJNIBase.swapChildAt(yogaNodeJNIBase.getChildAt(i10).cloneWithChildren(), i10);
            }
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public YogaNodeJNIBase cloneWithoutChildren() {
        try {
            YogaNodeJNIBase yogaNodeJNIBase = (YogaNodeJNIBase) super.clone();
            long jni_YGNodeCloneJNI = YogaNative.jni_YGNodeCloneJNI(this.mNativePointer);
            yogaNodeJNIBase.mOwner = null;
            yogaNodeJNIBase.mNativePointer = jni_YGNodeCloneJNI;
            yogaNodeJNIBase.clearChildren();
            return yogaNodeJNIBase;
        } catch (CloneNotSupportedException e10) {
            throw new RuntimeException(e10);
        }
    }

    public YogaNodeJNIBase getChildAt(int i10) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            return list.get(i10);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    public YogaNodeJNIBase getOwner() {
        return this.mOwner;
    }

    @Deprecated
    public YogaNodeJNIBase getParent() {
        return getOwner();
    }

    public YogaNodeJNIBase removeChildAt(int i10) {
        List<YogaNodeJNIBase> list = this.mChildren;
        if (list != null) {
            YogaNodeJNIBase remove = list.remove(i10);
            remove.mOwner = null;
            YogaNative.jni_YGNodeRemoveChildJNI(this.mNativePointer, remove.mNativePointer);
            return remove;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    YogaNodeJNIBase() {
        this(YogaNative.jni_YGNodeNewJNI());
    }

    YogaNodeJNIBase(c cVar) {
        this(YogaNative.jni_YGNodeNewWithConfigJNI(((YogaConfigJNIBase) cVar).mNativePointer));
    }
}
