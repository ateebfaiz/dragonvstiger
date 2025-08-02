package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<a> mChainList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ConstraintWidget[] mDisplayedWidgets;
    /* access modifiers changed from: private */
    public int mDisplayedWidgetsCount = 0;
    /* access modifiers changed from: private */
    public float mFirstHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mFirstVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mFirstVerticalStyle = -1;
    /* access modifiers changed from: private */
    public int mHorizontalAlign = 2;
    /* access modifiers changed from: private */
    public float mHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mHorizontalGap = 0;
    /* access modifiers changed from: private */
    public int mHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastHorizontalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastHorizontalStyle = -1;
    /* access modifiers changed from: private */
    public float mLastVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    /* access modifiers changed from: private */
    public int mVerticalAlign = 2;
    /* access modifiers changed from: private */
    public float mVerticalBias = 0.5f;
    /* access modifiers changed from: private */
    public int mVerticalGap = 0;
    /* access modifiers changed from: private */
    public int mVerticalStyle = -1;
    private int mWrapMode = 0;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        private int f14698a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ConstraintWidget f14699b = null;

        /* renamed from: c  reason: collision with root package name */
        int f14700c = 0;

        /* renamed from: d  reason: collision with root package name */
        private ConstraintAnchor f14701d;

        /* renamed from: e  reason: collision with root package name */
        private ConstraintAnchor f14702e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintAnchor f14703f;

        /* renamed from: g  reason: collision with root package name */
        private ConstraintAnchor f14704g;

        /* renamed from: h  reason: collision with root package name */
        private int f14705h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f14706i = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f14707j = 0;

        /* renamed from: k  reason: collision with root package name */
        private int f14708k = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f14709l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f14710m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f14711n = 0;

        /* renamed from: o  reason: collision with root package name */
        private int f14712o = 0;

        /* renamed from: p  reason: collision with root package name */
        private int f14713p = 0;

        /* renamed from: q  reason: collision with root package name */
        private int f14714q = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f14698a = i10;
            this.f14701d = constraintAnchor;
            this.f14702e = constraintAnchor2;
            this.f14703f = constraintAnchor3;
            this.f14704g = constraintAnchor4;
            this.f14705h = Flow.this.getPaddingLeft();
            this.f14706i = Flow.this.getPaddingTop();
            this.f14707j = Flow.this.getPaddingRight();
            this.f14708k = Flow.this.getPaddingBottom();
            this.f14714q = i11;
        }

        private void h() {
            this.f14709l = 0;
            this.f14710m = 0;
            this.f14699b = null;
            this.f14700c = 0;
            int i10 = this.f14712o;
            int i11 = 0;
            while (i11 < i10 && this.f14711n + i11 < Flow.this.mDisplayedWidgetsCount) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.f14711n + i11];
                if (this.f14698a == 0) {
                    int width = constraintWidget.getWidth();
                    int access$000 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        access$000 = 0;
                    }
                    this.f14709l += width + access$000;
                    int access$300 = Flow.this.getWidgetHeight(constraintWidget, this.f14714q);
                    if (this.f14699b == null || this.f14700c < access$300) {
                        this.f14699b = constraintWidget;
                        this.f14700c = access$300;
                        this.f14710m = access$300;
                    }
                } else {
                    int access$200 = Flow.this.getWidgetWidth(constraintWidget, this.f14714q);
                    int access$3002 = Flow.this.getWidgetHeight(constraintWidget, this.f14714q);
                    int access$100 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        access$100 = 0;
                    }
                    this.f14710m += access$3002 + access$100;
                    if (this.f14699b == null || this.f14700c < access$200) {
                        this.f14699b = constraintWidget;
                        this.f14700c = access$200;
                        this.f14709l = access$200;
                    }
                }
                i11++;
            }
        }

        public void b(ConstraintWidget constraintWidget) {
            int i10 = 0;
            if (this.f14698a == 0) {
                int access$200 = Flow.this.getWidgetWidth(constraintWidget, this.f14714q);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f14713p++;
                    access$200 = 0;
                }
                int access$000 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i10 = access$000;
                }
                this.f14709l += access$200 + i10;
                int access$300 = Flow.this.getWidgetHeight(constraintWidget, this.f14714q);
                if (this.f14699b == null || this.f14700c < access$300) {
                    this.f14699b = constraintWidget;
                    this.f14700c = access$300;
                    this.f14710m = access$300;
                }
            } else {
                int access$2002 = Flow.this.getWidgetWidth(constraintWidget, this.f14714q);
                int access$3002 = Flow.this.getWidgetHeight(constraintWidget, this.f14714q);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f14713p++;
                    access$3002 = 0;
                }
                int access$100 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i10 = access$100;
                }
                this.f14710m += access$3002 + i10;
                if (this.f14699b == null || this.f14700c < access$2002) {
                    this.f14699b = constraintWidget;
                    this.f14700c = access$2002;
                    this.f14709l = access$2002;
                }
            }
            this.f14712o++;
        }

        public void c() {
            this.f14700c = 0;
            this.f14699b = null;
            this.f14709l = 0;
            this.f14710m = 0;
            this.f14711n = 0;
            this.f14712o = 0;
            this.f14713p = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f14712o
                r2 = 0
                r3 = r2
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.f14711n
                int r4 = r4 + r3
                androidx.constraintlayout.solver.widgets.Flow r5 = androidx.constraintlayout.solver.widgets.Flow.this
                int r5 = r5.mDisplayedWidgetsCount
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.solver.widgets.Flow r4 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r4.mDisplayedWidgets
                int r5 = r0.f14711n
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.resetAnchors()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x035b
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.f14699b
                if (r3 != 0) goto L_0x002f
                goto L_0x035b
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = r2
            L_0x0036:
                r5 = -1
                r6 = r2
                r7 = r5
                r8 = r7
            L_0x003a:
                if (r6 >= r1) goto L_0x0067
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.f14711n
                int r10 = r10 + r9
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x004f
                goto L_0x0067
            L_0x004f:
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.f14711n
                int r11 = r11 + r9
                r9 = r10[r11]
                int r9 = r9.getVisibility()
                if (r9 != 0) goto L_0x0064
                if (r7 != r5) goto L_0x0063
                r7 = r6
            L_0x0063:
                r8 = r6
            L_0x0064:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0067:
                int r6 = r0.f14698a
                r9 = 0
                if (r6 != 0) goto L_0x01eb
                androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r0.f14699b
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mVerticalStyle
                r6.setVerticalChainStyle(r10)
                int r10 = r0.f14706i
                if (r18 <= 0) goto L_0x0082
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mVerticalGap
                int r10 = r10 + r11
            L_0x0082:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f14702e
                r11.connect(r12, r10)
                if (r19 == 0) goto L_0x0094
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r6.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14704g
                int r12 = r0.f14708k
                r10.connect(r11, r12)
            L_0x0094:
                if (r18 <= 0) goto L_0x00a1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f14702e
                androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mTop
                r10.connect(r11, r2)
            L_0x00a1:
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mVerticalAlign
                r11 = 3
                if (r10 != r11) goto L_0x00db
                boolean r10 = r6.hasBaseline()
                if (r10 != 0) goto L_0x00db
                r10 = r2
            L_0x00b1:
                if (r10 >= r1) goto L_0x00db
                if (r17 == 0) goto L_0x00b9
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00ba
            L_0x00b9:
                r12 = r10
            L_0x00ba:
                int r13 = r0.f14711n
                int r13 = r13 + r12
                androidx.constraintlayout.solver.widgets.Flow r14 = androidx.constraintlayout.solver.widgets.Flow.this
                int r14 = r14.mDisplayedWidgetsCount
                if (r13 < r14) goto L_0x00c6
                goto L_0x00db
            L_0x00c6:
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r13.mDisplayedWidgets
                int r14 = r0.f14711n
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.hasBaseline()
                if (r13 == 0) goto L_0x00d8
                goto L_0x00dc
            L_0x00d8:
                int r10 = r10 + 1
                goto L_0x00b1
            L_0x00db:
                r12 = r6
            L_0x00dc:
                r10 = r2
            L_0x00dd:
                if (r10 >= r1) goto L_0x035b
                if (r17 == 0) goto L_0x00e5
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e6
            L_0x00e5:
                r13 = r10
            L_0x00e6:
                int r14 = r0.f14711n
                int r14 = r14 + r13
                androidx.constraintlayout.solver.widgets.Flow r15 = androidx.constraintlayout.solver.widgets.Flow.this
                int r15 = r15.mDisplayedWidgetsCount
                if (r14 < r15) goto L_0x00f3
                goto L_0x035b
            L_0x00f3:
                androidx.constraintlayout.solver.widgets.Flow r14 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r14 = r14.mDisplayedWidgets
                int r15 = r0.f14711n
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r10 != 0) goto L_0x0109
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r14.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14701d
                int r3 = r0.f14705h
                r14.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r15, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (int) r3)
            L_0x0109:
                if (r13 != 0) goto L_0x014c
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mHorizontalBias
                int r13 = r0.f14711n
                if (r13 != 0) goto L_0x0130
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mFirstHorizontalStyle
                if (r13 == r5) goto L_0x0130
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mFirstHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mFirstHorizontalBias
                goto L_0x0146
            L_0x0130:
                if (r19 == 0) goto L_0x0146
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mLastHorizontalStyle
                if (r13 == r5) goto L_0x0146
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mLastHorizontalStyle
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                float r11 = r11.mLastHorizontalBias
            L_0x0146:
                r14.setHorizontalChainStyle(r3)
                r14.setHorizontalBiasPercent(r11)
            L_0x014c:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x0159
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14703f
                int r13 = r0.f14707j
                r14.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (int) r13)
            L_0x0159:
                if (r9 == 0) goto L_0x0184
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mRight
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mHorizontalGap
                r3.connect(r11, r13)
                if (r10 != r7) goto L_0x0171
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mLeft
                int r11 = r0.f14705h
                r3.setGoneMargin(r11)
            L_0x0171:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r9.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r14.mLeft
                r3.connect(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x0184
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r9.mRight
                int r9 = r0.f14707j
                r3.setGoneMargin(r9)
            L_0x0184:
                if (r14 == r6) goto L_0x01e4
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                r9 = 3
                if (r3 != r9) goto L_0x01a5
                boolean r3 = r12.hasBaseline()
                if (r3 == 0) goto L_0x01a5
                if (r14 == r12) goto L_0x01a5
                boolean r3 = r14.hasBaseline()
                if (r3 == 0) goto L_0x01a5
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBaseline
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r12.mBaseline
                r3.connect(r11, r2)
                goto L_0x01e5
            L_0x01a5:
                androidx.constraintlayout.solver.widgets.Flow r3 = androidx.constraintlayout.solver.widgets.Flow.this
                int r3 = r3.mVerticalAlign
                if (r3 == 0) goto L_0x01dc
                r11 = 1
                if (r3 == r11) goto L_0x01d4
                if (r4 == 0) goto L_0x01c5
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14702e
                int r13 = r0.f14706i
                r3.connect(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14704g
                int r13 = r0.f14708k
                r3.connect(r11, r13)
                goto L_0x01e5
            L_0x01c5:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x01e5
            L_0x01d4:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mBottom
                r3.connect(r11, r2)
                goto L_0x01e5
            L_0x01dc:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.mTop
                r3.connect(r11, r2)
                goto L_0x01e5
            L_0x01e4:
                r9 = 3
            L_0x01e5:
                int r10 = r10 + 1
                r11 = r9
                r9 = r14
                goto L_0x00dd
            L_0x01eb:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.f14699b
                androidx.constraintlayout.solver.widgets.Flow r6 = androidx.constraintlayout.solver.widgets.Flow.this
                int r6 = r6.mHorizontalStyle
                r3.setHorizontalChainStyle(r6)
                int r6 = r0.f14705h
                if (r18 <= 0) goto L_0x0201
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                int r10 = r10.mHorizontalGap
                int r6 = r6 + r10
            L_0x0201:
                if (r17 == 0) goto L_0x0223
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14703f
                r10.connect(r11, r6)
                if (r19 == 0) goto L_0x0215
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f14701d
                int r11 = r0.f14707j
                r6.connect(r10, r11)
            L_0x0215:
                if (r18 <= 0) goto L_0x0242
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r0.f14703f
                androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mRight
                r6.connect(r10, r2)
                goto L_0x0242
            L_0x0223:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14701d
                r10.connect(r11, r6)
                if (r19 == 0) goto L_0x0235
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f14703f
                int r11 = r0.f14707j
                r6.connect(r10, r11)
            L_0x0235:
                if (r18 <= 0) goto L_0x0242
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r0.f14701d
                androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.mOwner
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.mLeft
                r6.connect(r10, r2)
            L_0x0242:
                r6 = r2
            L_0x0243:
                if (r6 >= r1) goto L_0x035b
                int r10 = r0.f14711n
                int r10 = r10 + r6
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mDisplayedWidgetsCount
                if (r10 < r11) goto L_0x0252
                goto L_0x035b
            L_0x0252:
                androidx.constraintlayout.solver.widgets.Flow r10 = androidx.constraintlayout.solver.widgets.Flow.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.mDisplayedWidgets
                int r11 = r0.f14711n
                int r11 = r11 + r6
                r10 = r10[r11]
                if (r6 != 0) goto L_0x02a9
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f14702e
                int r13 = r0.f14706i
                r10.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r12, (int) r13)
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mVerticalBias
                int r13 = r0.f14711n
                if (r13 != 0) goto L_0x028d
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mFirstVerticalStyle
                if (r13 == r5) goto L_0x028d
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mFirstVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mFirstVerticalBias
                goto L_0x02a3
            L_0x028d:
                if (r19 == 0) goto L_0x02a3
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mLastVerticalStyle
                if (r13 == r5) goto L_0x02a3
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mLastVerticalStyle
                androidx.constraintlayout.solver.widgets.Flow r12 = androidx.constraintlayout.solver.widgets.Flow.this
                float r12 = r12.mLastVerticalBias
            L_0x02a3:
                r10.setVerticalChainStyle(r11)
                r10.setVerticalBiasPercent(r12)
            L_0x02a9:
                int r11 = r1 + -1
                if (r6 != r11) goto L_0x02b6
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f14704g
                int r13 = r0.f14708k
                r10.connect((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r12, (int) r13)
            L_0x02b6:
                if (r9 == 0) goto L_0x02e1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r9.mBottom
                androidx.constraintlayout.solver.widgets.Flow r13 = androidx.constraintlayout.solver.widgets.Flow.this
                int r13 = r13.mVerticalGap
                r11.connect(r12, r13)
                if (r6 != r7) goto L_0x02ce
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.mTop
                int r12 = r0.f14706i
                r11.setGoneMargin(r12)
            L_0x02ce:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.mBottom
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r10.mTop
                r11.connect(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r6 != r12) goto L_0x02e1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.mBottom
                int r11 = r0.f14708k
                r9.setGoneMargin(r11)
            L_0x02e1:
                if (r10 == r3) goto L_0x0312
                r9 = 2
                if (r17 == 0) goto L_0x0314
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x030b
                r12 = 1
                if (r11 == r12) goto L_0x0303
                if (r11 == r9) goto L_0x02f4
                goto L_0x0312
            L_0x02f4:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0312
            L_0x0303:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                goto L_0x0312
            L_0x030b:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
            L_0x0312:
                r12 = 1
                goto L_0x0356
            L_0x0314:
                androidx.constraintlayout.solver.widgets.Flow r11 = androidx.constraintlayout.solver.widgets.Flow.this
                int r11 = r11.mHorizontalAlign
                if (r11 == 0) goto L_0x034e
                r12 = 1
                if (r11 == r12) goto L_0x0346
                if (r11 == r9) goto L_0x0322
                goto L_0x0356
            L_0x0322:
                if (r4 == 0) goto L_0x0337
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14701d
                int r13 = r0.f14705h
                r9.connect(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f14703f
                int r13 = r0.f14707j
                r9.connect(r11, r13)
                goto L_0x0356
            L_0x0337:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0356
            L_0x0346:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mRight
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mRight
                r9.connect(r11, r2)
                goto L_0x0356
            L_0x034e:
                r12 = 1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r10.mLeft
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.mLeft
                r9.connect(r11, r2)
            L_0x0356:
                int r6 = r6 + 1
                r9 = r10
                goto L_0x0243
            L_0x035b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.a.d(boolean, int, boolean):void");
        }

        public int e() {
            if (this.f14698a == 1) {
                return this.f14710m - Flow.this.mVerticalGap;
            }
            return this.f14710m;
        }

        public int f() {
            if (this.f14698a == 0) {
                return this.f14709l - Flow.this.mHorizontalGap;
            }
            return this.f14709l;
        }

        public void g(int i10) {
            int i11 = this.f14713p;
            if (i11 != 0) {
                int i12 = this.f14712o;
                int i13 = i10 / i11;
                int i14 = 0;
                while (i14 < i12 && this.f14711n + i14 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.f14711n + i14];
                    if (this.f14698a == 0) {
                        if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                        }
                    } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                        Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                    }
                    i14++;
                }
                h();
            }
        }

        public void i(int i10) {
            this.f14711n = i10;
        }

        public void j(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f14698a = i10;
            this.f14701d = constraintAnchor;
            this.f14702e = constraintAnchor2;
            this.f14703f = constraintAnchor3;
            this.f14704g = constraintAnchor4;
            this.f14705h = i11;
            this.f14706i = i12;
            this.f14707j = i13;
            this.f14708k = i14;
            this.f14714q = i15;
        }
    }

    private void createAlignedConstraints(boolean z10) {
        ConstraintWidget constraintWidget;
        int i10;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i11 = 0; i11 < this.mDisplayedWidgetsCount; i11++) {
                this.mDisplayedWidgets[i11].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            for (int i14 = 0; i14 < i12; i14++) {
                if (z10) {
                    i10 = (i12 - i14) - 1;
                } else {
                    i10 = i14;
                }
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i10];
                if (!(constraintWidget3 == null || constraintWidget3.getVisibility() == 8)) {
                    if (i14 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                    }
                    if (i14 == i12 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i14 > 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
            }
            for (int i15 = 0; i15 < i13; i15++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i15];
                if (!(constraintWidget4 == null || constraintWidget4.getVisibility() == 8)) {
                    if (i15 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i15 == i13 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i15 > 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i16 = 0; i16 < i12; i16++) {
                for (int i17 = 0; i17 < i13; i17++) {
                    int i18 = (i17 * i12) + i16;
                    if (this.mOrientation == 1) {
                        i18 = (i16 * i13) + i17;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                    if (!(i18 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i18]) == null || constraintWidget.getVisibility() == 8)) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i16];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i17];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.mMatchConstraintPercentHeight * ((float) i10));
                if (i12 != constraintWidget.getHeight()) {
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            } else if (i11 == 1) {
                return constraintWidget.getHeight();
            } else {
                if (i11 == 3) {
                    return (int) ((((float) constraintWidget.getWidth()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    /* access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.mMatchConstraintPercentWidth * ((float) i10));
                if (i12 != constraintWidget.getWidth()) {
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i12;
            } else if (i11 == 1) {
                return constraintWidget.getWidth();
            } else {
                if (i11 == 3) {
                    return (int) ((((float) constraintWidget.getHeight()) * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x011d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e  */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            r10 = this;
            r0 = 0
            if (r13 != 0) goto L_0x0026
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0023
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x000a:
            if (r2 >= r12) goto L_0x0023
            if (r2 <= 0) goto L_0x0011
            int r4 = r10.mHorizontalGap
            int r3 = r3 + r4
        L_0x0011:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0016
            goto L_0x0020
        L_0x0016:
            int r4 = r10.getWidgetWidth(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r1 + 1
        L_0x0020:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0023:
            r2 = r1
            r1 = r0
            goto L_0x0047
        L_0x0026:
            int r1 = r10.mMaxElementsWrap
            if (r1 > 0) goto L_0x0046
            r1 = r0
            r2 = r1
            r3 = r2
        L_0x002d:
            if (r2 >= r12) goto L_0x0046
            if (r2 <= 0) goto L_0x0034
            int r4 = r10.mVerticalGap
            int r3 = r3 + r4
        L_0x0034:
            r4 = r11[r2]
            if (r4 != 0) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            int r4 = r10.getWidgetHeight(r4, r14)
            int r3 = r3 + r4
            if (r3 <= r14) goto L_0x0041
            goto L_0x0046
        L_0x0041:
            int r1 = r1 + 1
        L_0x0043:
            int r2 = r2 + 1
            goto L_0x002d
        L_0x0046:
            r2 = r0
        L_0x0047:
            int[] r3 = r10.mAlignedDimensions
            if (r3 != 0) goto L_0x0050
            r3 = 2
            int[] r3 = new int[r3]
            r10.mAlignedDimensions = r3
        L_0x0050:
            r3 = 1
            if (r1 != 0) goto L_0x0055
            if (r13 == r3) goto L_0x0059
        L_0x0055:
            if (r2 != 0) goto L_0x005b
            if (r13 != 0) goto L_0x005b
        L_0x0059:
            r4 = r3
            goto L_0x005c
        L_0x005b:
            r4 = r0
        L_0x005c:
            if (r4 != 0) goto L_0x011d
            if (r13 != 0) goto L_0x006a
            float r1 = (float) r12
            float r5 = (float) r2
            float r1 = r1 / r5
            double r5 = (double) r1
            double r5 = java.lang.Math.ceil(r5)
            int r1 = (int) r5
            goto L_0x0073
        L_0x006a:
            float r2 = (float) r12
            float r5 = (float) r1
            float r2 = r2 / r5
            double r5 = (double) r2
            double r5 = java.lang.Math.ceil(r5)
            int r2 = (int) r5
        L_0x0073:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInCols
            r6 = 0
            if (r5 == 0) goto L_0x0080
            int r7 = r5.length
            if (r7 >= r2) goto L_0x007c
            goto L_0x0080
        L_0x007c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0084
        L_0x0080:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r2]
            r10.mAlignedBiggestElementsInCols = r5
        L_0x0084:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = r10.mAlignedBiggestElementsInRows
            if (r5 == 0) goto L_0x0090
            int r7 = r5.length
            if (r7 >= r1) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            java.util.Arrays.fill(r5, r6)
            goto L_0x0094
        L_0x0090:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r5 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r1]
            r10.mAlignedBiggestElementsInRows = r5
        L_0x0094:
            r5 = r0
        L_0x0095:
            if (r5 >= r2) goto L_0x00d9
            r6 = r0
        L_0x0098:
            if (r6 >= r1) goto L_0x00d6
            int r7 = r6 * r2
            int r7 = r7 + r5
            if (r13 != r3) goto L_0x00a2
            int r7 = r5 * r1
            int r7 = r7 + r6
        L_0x00a2:
            int r8 = r11.length
            if (r7 < r8) goto L_0x00a6
            goto L_0x00d3
        L_0x00a6:
            r7 = r11[r7]
            if (r7 != 0) goto L_0x00ab
            goto L_0x00d3
        L_0x00ab:
            int r8 = r10.getWidgetWidth(r7, r14)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInCols
            r9 = r9[r5]
            if (r9 == 0) goto L_0x00bb
            int r9 = r9.getWidth()
            if (r9 >= r8) goto L_0x00bf
        L_0x00bb:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInCols
            r8[r5] = r7
        L_0x00bf:
            int r8 = r10.getWidgetHeight(r7, r14)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r9 = r10.mAlignedBiggestElementsInRows
            r9 = r9[r6]
            if (r9 == 0) goto L_0x00cf
            int r9 = r9.getHeight()
            if (r9 >= r8) goto L_0x00d3
        L_0x00cf:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8[r6] = r7
        L_0x00d3:
            int r6 = r6 + 1
            goto L_0x0098
        L_0x00d6:
            int r5 = r5 + 1
            goto L_0x0095
        L_0x00d9:
            r5 = r0
            r6 = r5
        L_0x00db:
            if (r5 >= r2) goto L_0x00f0
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r7 = r10.mAlignedBiggestElementsInCols
            r7 = r7[r5]
            if (r7 == 0) goto L_0x00ed
            if (r5 <= 0) goto L_0x00e8
            int r8 = r10.mHorizontalGap
            int r6 = r6 + r8
        L_0x00e8:
            int r7 = r10.getWidgetWidth(r7, r14)
            int r6 = r6 + r7
        L_0x00ed:
            int r5 = r5 + 1
            goto L_0x00db
        L_0x00f0:
            r5 = r0
            r7 = r5
        L_0x00f2:
            if (r5 >= r1) goto L_0x0107
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r8 = r10.mAlignedBiggestElementsInRows
            r8 = r8[r5]
            if (r8 == 0) goto L_0x0104
            if (r5 <= 0) goto L_0x00ff
            int r9 = r10.mVerticalGap
            int r7 = r7 + r9
        L_0x00ff:
            int r8 = r10.getWidgetHeight(r8, r14)
            int r7 = r7 + r8
        L_0x0104:
            int r5 = r5 + 1
            goto L_0x00f2
        L_0x0107:
            r15[r0] = r6
            r15[r3] = r7
            if (r13 != 0) goto L_0x0115
            if (r6 <= r14) goto L_0x0059
            if (r2 <= r3) goto L_0x0059
            int r2 = r2 + -1
            goto L_0x005c
        L_0x0115:
            if (r7 <= r14) goto L_0x0059
            if (r1 <= r3) goto L_0x0059
            int r1 = r1 + -1
            goto L_0x005c
        L_0x011d:
            int[] r11 = r10.mAlignedDimensions
            r11[r0] = r2
            r11[r3] = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        ConstraintAnchor constraintAnchor;
        int i14;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor2;
        int i17;
        int i18;
        int i19 = i10;
        int i20 = i12;
        if (i19 != 0) {
            this.mChainList.clear();
            a aVar = new a(i11, this.mLeft, this.mTop, this.mRight, this.mBottom, i12);
            this.mChainList.add(aVar);
            if (i11 == 0) {
                i13 = 0;
                int i21 = 0;
                int i22 = 0;
                while (i22 < i19) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i22];
                    int widgetWidth = getWidgetWidth(constraintWidget, i20);
                    if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i23 = i13;
                    boolean z10 = (i21 == i20 || (this.mHorizontalGap + i21) + widgetWidth > i20) && aVar.f14699b != null;
                    if (!z10 && i22 > 0 && (i18 = this.mMaxElementsWrap) > 0 && i22 % i18 == 0) {
                        z10 = true;
                    }
                    if (z10) {
                        aVar = new a(i11, this.mLeft, this.mTop, this.mRight, this.mBottom, i12);
                        aVar.i(i22);
                        this.mChainList.add(aVar);
                    } else if (i22 > 0) {
                        i21 += this.mHorizontalGap + widgetWidth;
                        aVar.b(constraintWidget);
                        i22++;
                        i13 = i23;
                    }
                    i21 = widgetWidth;
                    aVar.b(constraintWidget);
                    i22++;
                    i13 = i23;
                }
            } else {
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                while (i26 < i19) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i26];
                    int widgetHeight = getWidgetHeight(constraintWidget2, i20);
                    if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i27 = i13;
                    boolean z11 = (i25 == i20 || (this.mVerticalGap + i25) + widgetHeight > i20) && aVar.f14699b != null;
                    if (!z11 && i26 > 0 && (i17 = this.mMaxElementsWrap) > 0 && i26 % i17 == 0) {
                        z11 = true;
                    }
                    if (z11) {
                        aVar = new a(i11, this.mLeft, this.mTop, this.mRight, this.mBottom, i12);
                        aVar.i(i26);
                        this.mChainList.add(aVar);
                    } else if (i26 > 0) {
                        i25 += this.mVerticalGap + widgetHeight;
                        aVar.b(constraintWidget2);
                        i26++;
                        i24 = i27;
                    }
                    i25 = widgetHeight;
                    aVar.b(constraintWidget2);
                    i26++;
                    i24 = i27;
                }
            }
            int size = this.mChainList.size();
            ConstraintAnchor constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            ConstraintAnchor constraintAnchor5 = this.mRight;
            ConstraintAnchor constraintAnchor6 = this.mBottom;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z12 = horizontalDimensionBehaviour == dimensionBehaviour || getVerticalDimensionBehaviour() == dimensionBehaviour;
            if (i13 > 0 && z12) {
                for (int i28 = 0; i28 < size; i28++) {
                    a aVar2 = this.mChainList.get(i28);
                    if (i11 == 0) {
                        aVar2.g(i20 - aVar2.f());
                    } else {
                        aVar2.g(i20 - aVar2.e());
                    }
                }
            }
            int i29 = paddingTop;
            int i30 = paddingRight;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = paddingLeft;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i35 = paddingBottom;
            while (i33 < size) {
                a aVar3 = this.mChainList.get(i33);
                if (i11 == 0) {
                    if (i33 < size - 1) {
                        constraintAnchor2 = this.mChainList.get(i33 + 1).f14699b.mTop;
                        i16 = 0;
                    } else {
                        constraintAnchor2 = this.mBottom;
                        i16 = getPaddingBottom();
                    }
                    ConstraintAnchor constraintAnchor9 = aVar3.f14699b.mBottom;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i36 = i31;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i37 = i32;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i14 = i33;
                    aVar3.j(i11, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i34, i29, i30, i16, i12);
                    int max = Math.max(i37, aVar3.f());
                    i31 = i36 + aVar3.e();
                    if (i14 > 0) {
                        i31 += this.mVerticalGap;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i32 = max;
                    i29 = 0;
                    constraintAnchor7 = constraintAnchor9;
                    constraintAnchor = constraintAnchor14;
                    int i38 = i16;
                    constraintAnchor6 = constraintAnchor2;
                    i35 = i38;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i39 = i31;
                    int i40 = i32;
                    i14 = i33;
                    if (i14 < size - 1) {
                        constraintAnchor = this.mChainList.get(i14 + 1).f14699b.mLeft;
                        i15 = 0;
                    } else {
                        constraintAnchor = this.mRight;
                        i15 = getPaddingRight();
                    }
                    ConstraintAnchor constraintAnchor16 = aVar3.f14699b.mRight;
                    aVar3.j(i11, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i34, i29, i15, i35, i12);
                    i32 = i40 + aVar3.f();
                    int max2 = Math.max(i39, aVar3.e());
                    if (i14 > 0) {
                        i32 += this.mHorizontalGap;
                    }
                    i31 = max2;
                    i34 = 0;
                    i30 = i15;
                    constraintAnchor8 = constraintAnchor16;
                }
                i33 = i14 + 1;
                int i41 = i12;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i32;
            iArr[1] = i31;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        int i13 = i10;
        if (i13 != 0) {
            if (this.mChainList.size() == 0) {
                aVar = new a(i11, this.mLeft, this.mTop, this.mRight, this.mBottom, i12);
                this.mChainList.add(aVar);
            } else {
                a aVar2 = this.mChainList.get(0);
                aVar2.c();
                aVar = aVar2;
                aVar.j(i11, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i12);
            }
            for (int i14 = 0; i14 < i13; i14++) {
                aVar.b(constraintWidgetArr[i14]);
            }
            iArr[0] = aVar.f();
            iArr[1] = aVar.e();
        }
    }

    public void addToSolver(LinearSystem linearSystem) {
        boolean z10;
        boolean z11;
        super.addToSolver(linearSystem);
        if (getParent() != null) {
            z10 = ((ConstraintWidgetContainer) getParent()).isRtl();
        } else {
            z10 = false;
        }
        int i10 = this.mWrapMode;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.mChainList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    a aVar = this.mChainList.get(i11);
                    if (i11 == size - 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    aVar.d(z10, i11, z11);
                }
            } else if (i10 == 2) {
                createAlignedConstraints(z10);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).d(z10, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v3 */
    /* JADX WARNING: type inference failed for: r11v6 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: type inference failed for: r11v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void measure(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.mWidgetsCount
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.measureChildren()
            if (r0 != 0) goto L_0x001c
            r6.setMeasure(r11, r11)
            r6.needsCallbackFromSolver(r11)
            return
        L_0x001c:
            int r12 = r18.getPaddingLeft()
            int r13 = r18.getPaddingRight()
            int r14 = r18.getPaddingTop()
            int r15 = r18.getPaddingBottom()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.mOrientation
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004c
            int r2 = r6.mHorizontalStyle
            if (r2 != r1) goto L_0x0045
            r6.mHorizontalStyle = r11
        L_0x0045:
            int r2 = r6.mVerticalStyle
            if (r2 != r1) goto L_0x0058
            r6.mVerticalStyle = r11
            goto L_0x0058
        L_0x004c:
            int r2 = r6.mHorizontalStyle
            if (r2 != r1) goto L_0x0052
            r6.mHorizontalStyle = r11
        L_0x0052:
            int r2 = r6.mVerticalStyle
            if (r2 != r1) goto L_0x0058
            r6.mVerticalStyle = r11
        L_0x0058:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r6.mWidgets
            r2 = r11
            r3 = r2
        L_0x005c:
            int r11 = r6.mWidgetsCount
            r0 = 8
            if (r2 >= r11) goto L_0x0072
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11 = r6.mWidgets
            r11 = r11[r2]
            int r11 = r11.getVisibility()
            if (r11 != r0) goto L_0x006e
            int r3 = r3 + 1
        L_0x006e:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005c
        L_0x0072:
            if (r3 <= 0) goto L_0x0091
            int r11 = r11 - r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r11]
            r2 = 0
            r3 = 0
        L_0x0079:
            int r11 = r6.mWidgetsCount
            if (r2 >= r11) goto L_0x008f
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11 = r6.mWidgets
            r11 = r11[r2]
            int r4 = r11.getVisibility()
            if (r4 == r0) goto L_0x008b
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008b:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x0079
        L_0x008f:
            r2 = r3
            goto L_0x0092
        L_0x0091:
            r2 = r11
        L_0x0092:
            r6.mDisplayedWidgets = r1
            r6.mDisplayedWidgetsCount = r2
            int r0 = r6.mWrapMode
            if (r0 == 0) goto L_0x00bf
            r4 = 1
            if (r0 == r4) goto L_0x00b2
            r3 = 2
            if (r0 == r3) goto L_0x00a5
            r11 = r4
            r17 = r5
        L_0x00a3:
            r0 = 0
            goto L_0x00cc
        L_0x00a5:
            int r3 = r6.mOrientation
            r0 = r18
            r11 = r4
            r4 = r16
            r17 = r5
            r0.measureAligned(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00b2:
            r11 = r4
            r17 = r5
            int r3 = r6.mOrientation
            r0 = r18
            r4 = r16
            r0.measureChainWrap(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00bf:
            r17 = r5
            r11 = 1
            int r3 = r6.mOrientation
            r0 = r18
            r4 = r16
            r0.measureNoWrap(r1, r2, r3, r4, r5)
            goto L_0x00a3
        L_0x00cc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00dc
            r1 = r8
            goto L_0x00e7
        L_0x00dc:
            if (r7 != r3) goto L_0x00e3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00e7
        L_0x00e3:
            if (r7 != 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r1 = r0
        L_0x00e7:
            if (r9 != r4) goto L_0x00eb
            r2 = r10
            goto L_0x00f6
        L_0x00eb:
            if (r9 != r3) goto L_0x00f2
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x00f6
        L_0x00f2:
            if (r9 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r2 = r0
        L_0x00f6:
            r6.setMeasure(r1, r2)
            r6.setWidth(r1)
            r6.setHeight(r2)
            int r1 = r6.mWidgetsCount
            if (r1 <= 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r11 = r0
        L_0x0105:
            r6.needsCallbackFromSolver(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measure(int, int, int, int):void");
    }

    public void setFirstHorizontalBias(float f10) {
        this.mFirstHorizontalBias = f10;
    }

    public void setFirstHorizontalStyle(int i10) {
        this.mFirstHorizontalStyle = i10;
    }

    public void setFirstVerticalBias(float f10) {
        this.mFirstVerticalBias = f10;
    }

    public void setFirstVerticalStyle(int i10) {
        this.mFirstVerticalStyle = i10;
    }

    public void setHorizontalAlign(int i10) {
        this.mHorizontalAlign = i10;
    }

    public void setHorizontalBias(float f10) {
        this.mHorizontalBias = f10;
    }

    public void setHorizontalGap(int i10) {
        this.mHorizontalGap = i10;
    }

    public void setHorizontalStyle(int i10) {
        this.mHorizontalStyle = i10;
    }

    public void setLastHorizontalBias(float f10) {
        this.mLastHorizontalBias = f10;
    }

    public void setLastHorizontalStyle(int i10) {
        this.mLastHorizontalStyle = i10;
    }

    public void setLastVerticalBias(float f10) {
        this.mLastVerticalBias = f10;
    }

    public void setLastVerticalStyle(int i10) {
        this.mLastVerticalStyle = i10;
    }

    public void setMaxElementsWrap(int i10) {
        this.mMaxElementsWrap = i10;
    }

    public void setOrientation(int i10) {
        this.mOrientation = i10;
    }

    public void setVerticalAlign(int i10) {
        this.mVerticalAlign = i10;
    }

    public void setVerticalBias(float f10) {
        this.mVerticalBias = f10;
    }

    public void setVerticalGap(int i10) {
        this.mVerticalGap = i10;
    }

    public void setVerticalStyle(int i10) {
        this.mVerticalStyle = i10;
    }

    public void setWrapMode(int i10) {
        this.mWrapMode = i10;
    }
}
