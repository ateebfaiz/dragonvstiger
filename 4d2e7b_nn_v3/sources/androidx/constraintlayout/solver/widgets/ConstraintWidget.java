package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    boolean mOptimizerMeasurable;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public VerticalWidgetRun verticalRun;
    public int[] wrapMeasure;

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14696a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14697b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14697b = r0
                r1 = 1
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14697b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f14697b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f14697b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f14696a = r4
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f14696a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f14696a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a.<clinit>():void");
        }
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x031b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x03e2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x040a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:286:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:290:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyConstraints(androidx.constraintlayout.solver.LinearSystem r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.solver.SolverVariable r37, androidx.constraintlayout.solver.SolverVariable r38, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.solver.widgets.ConstraintAnchor r41, androidx.constraintlayout.solver.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r53
            r3 = r54
            r4 = r55
            androidx.constraintlayout.solver.SolverVariable r9 = r10.createObjectVariable(r13)
            androidx.constraintlayout.solver.SolverVariable r8 = r10.createObjectVariable(r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r41.getTarget()
            androidx.constraintlayout.solver.SolverVariable r7 = r10.createObjectVariable(r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r42.getTarget()
            androidx.constraintlayout.solver.SolverVariable r6 = r10.createObjectVariable(r5)
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.solver.Metrics r5 = androidx.constraintlayout.solver.LinearSystem.getMetrics()
            long r12 = r5.nonresolvedWidgets
            r16 = 1
            long r12 = r12 + r16
            r5.nonresolvedWidgets = r12
        L_0x0040:
            boolean r12 = r41.isConnected()
            boolean r13 = r42.isConnected()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r0.mCenter
            boolean r16 = r5.isConnected()
            if (r13 == 0) goto L_0x0053
            int r5 = r12 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r12
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r52
        L_0x005f:
            int[] r17 = androidx.constraintlayout.solver.widgets.ConstraintWidget.a.f14697b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007f
        L_0x0078:
            r2 = r18
            if (r2 != r14) goto L_0x007d
            goto L_0x0075
        L_0x007d:
            r18 = 1
        L_0x007f:
            int r14 = r0.mVisibility
            r11 = 8
            if (r14 != r11) goto L_0x0089
            r14 = 0
            r18 = 0
            goto L_0x008b
        L_0x0089:
            r14 = r44
        L_0x008b:
            if (r57 == 0) goto L_0x00ad
            if (r12 != 0) goto L_0x009d
            if (r13 != 0) goto L_0x009d
            if (r16 != 0) goto L_0x009d
            r11 = r43
            r10.addEquality(r9, r11)
        L_0x0098:
            r21 = r6
            r6 = 8
            goto L_0x00b0
        L_0x009d:
            if (r12 == 0) goto L_0x0098
            if (r13 != 0) goto L_0x0098
            int r11 = r41.getMargin()
            r21 = r6
            r6 = 8
            r10.addEquality(r9, r7, r11, r6)
            goto L_0x00b0
        L_0x00ad:
            r21 = r6
            r6 = r11
        L_0x00b0:
            if (r18 != 0) goto L_0x00db
            if (r40 == 0) goto L_0x00c9
            r6 = 0
            r11 = 3
            r10.addEquality(r8, r9, r6, r11)
            r6 = 8
            if (r15 <= 0) goto L_0x00c0
            r10.addGreaterThan(r8, r9, r15, r6)
        L_0x00c0:
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r11) goto L_0x00cc
            r10.addLowerThan(r8, r9, r1, r6)
            goto L_0x00cc
        L_0x00c9:
            r10.addEquality(r8, r9, r14, r6)
        L_0x00cc:
            r22 = r3
            r1 = r4
            r14 = r7
            r15 = r8
        L_0x00d1:
            r23 = r18
            r11 = r21
            r18 = r36
        L_0x00d7:
            r21 = r5
            goto L_0x01bf
        L_0x00db:
            r1 = 2
            if (r5 == r1) goto L_0x0100
            if (r48 != 0) goto L_0x0100
            r1 = 1
            if (r2 == r1) goto L_0x00e5
            if (r2 != 0) goto L_0x0100
        L_0x00e5:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00ef
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00ef:
            r6 = 8
            r10.addEquality(r8, r9, r1, r6)
            r18 = r36
            r22 = r3
            r1 = r4
            r14 = r7
            r15 = r8
            r11 = r21
            r23 = 0
            goto L_0x00d7
        L_0x0100:
            r1 = -2
            if (r3 != r1) goto L_0x0105
            r11 = r14
            goto L_0x0106
        L_0x0105:
            r11 = r3
        L_0x0106:
            if (r4 != r1) goto L_0x010a
            r1 = r14
            goto L_0x010b
        L_0x010a:
            r1 = r4
        L_0x010b:
            if (r14 <= 0) goto L_0x0111
            r3 = 1
            if (r2 == r3) goto L_0x0111
            r14 = 0
        L_0x0111:
            r3 = 8
            if (r11 <= 0) goto L_0x011c
            r10.addGreaterThan(r8, r9, r11, r3)
            int r14 = java.lang.Math.max(r14, r11)
        L_0x011c:
            r4 = 1
            if (r1 <= 0) goto L_0x012b
            if (r34 == 0) goto L_0x0124
            if (r2 != r4) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            r10.addLowerThan(r8, r9, r1, r3)
        L_0x0127:
            int r14 = java.lang.Math.min(r14, r1)
        L_0x012b:
            if (r2 != r4) goto L_0x0149
            if (r34 == 0) goto L_0x0133
            r10.addEquality(r8, r9, r14, r3)
            goto L_0x0144
        L_0x0133:
            if (r49 == 0) goto L_0x013d
            r4 = 5
            r10.addEquality(r8, r9, r14, r4)
            r10.addLowerThan(r8, r9, r14, r3)
            goto L_0x0144
        L_0x013d:
            r4 = 5
            r10.addEquality(r8, r9, r14, r4)
            r10.addLowerThan(r8, r9, r14, r3)
        L_0x0144:
            r14 = r7
            r15 = r8
            r22 = r11
            goto L_0x00d1
        L_0x0149:
            r14 = 2
            if (r2 != r14) goto L_0x01b1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = r41.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x0179
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = r41.getType()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r6) goto L_0x015d
            goto L_0x0179
        L_0x015d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r4)
        L_0x0175:
            r18 = r3
            r6 = r4
            goto L_0x0190
        L_0x0179:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.getAnchor(r4)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.createObjectVariable(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.getAnchor(r6)
            androidx.constraintlayout.solver.SolverVariable r4 = r10.createObjectVariable(r4)
            goto L_0x0175
        L_0x0190:
            androidx.constraintlayout.solver.ArrayRow r3 = r32.createRow()
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r11
            r11 = r21
            r21 = r14
            r14 = r7
            r7 = r18
            r15 = r8
            r8 = r56
            androidx.constraintlayout.solver.ArrayRow r3 = r3.createRowDimensionRatio(r4, r5, r6, r7, r8)
            r10.addConstraint(r3)
            r18 = r36
            r22 = r40
            r23 = 0
            goto L_0x01bf
        L_0x01b1:
            r14 = r7
            r15 = r8
            r40 = r11
            r11 = r21
            r21 = r5
            r22 = r40
            r23 = r18
            r18 = 1
        L_0x01bf:
            if (r57 == 0) goto L_0x03fb
            if (r49 == 0) goto L_0x01d1
            r1 = r37
            r6 = r38
            r4 = r9
            r3 = r10
            r2 = r15
            r7 = r21
            r5 = 8
        L_0x01ce:
            r8 = 2
            goto L_0x0408
        L_0x01d1:
            if (r12 != 0) goto L_0x01db
            if (r13 != 0) goto L_0x01db
            if (r16 != 0) goto L_0x01db
        L_0x01d7:
            r3 = r10
        L_0x01d8:
            r2 = r15
            goto L_0x03e0
        L_0x01db:
            if (r12 == 0) goto L_0x01e0
            if (r13 != 0) goto L_0x01e0
            goto L_0x01d7
        L_0x01e0:
            if (r12 != 0) goto L_0x01f8
            if (r13 == 0) goto L_0x01f8
            int r1 = r42.getMargin()
            int r1 = -r1
            r2 = 8
            r10.addEquality(r15, r11, r1, r2)
            if (r34 == 0) goto L_0x01d7
            r8 = r37
            r1 = 0
            r2 = 5
            r10.addGreaterThan(r9, r8, r1, r2)
            goto L_0x01d7
        L_0x01f8:
            r8 = r37
            r7 = 8
            if (r12 == 0) goto L_0x01d7
            if (r13 == 0) goto L_0x01d7
            r12 = r41
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r12.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r3.mOwner
            r6 = r42
            r3 = 2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r6.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r4.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r31.getParent()
            r16 = 6
            if (r23 == 0) goto L_0x02c8
            if (r2 != 0) goto L_0x024b
            if (r1 != 0) goto L_0x0222
            if (r22 != 0) goto L_0x0222
            r1 = r7
            r3 = r1
            r20 = 0
            r21 = 1
            goto L_0x0228
        L_0x0222:
            r1 = 5
            r3 = 5
            r20 = 1
            r21 = 0
        L_0x0228:
            boolean r7 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 != 0) goto L_0x023e
            boolean r7 = r5 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 == 0) goto L_0x0231
            goto L_0x023e
        L_0x0231:
            r7 = r20
            r24 = r21
            r21 = r1
            r20 = r3
            r1 = r16
            r3 = 0
            goto L_0x02cd
        L_0x023e:
            r7 = r20
            r24 = r21
            r3 = 0
            r20 = 4
            r21 = r1
            r1 = r16
            goto L_0x02cd
        L_0x024b:
            r7 = 1
            if (r2 != r7) goto L_0x025a
            r1 = r16
            r3 = 1
            r7 = 1
            r20 = 4
            r21 = 8
        L_0x0256:
            r24 = 0
            goto L_0x02cd
        L_0x025a:
            r7 = 3
            if (r2 != r7) goto L_0x02bf
            int r7 = r0.mResolvedDimensionRatioSide
            r3 = -1
            if (r7 != r3) goto L_0x0276
            if (r50 == 0) goto L_0x0273
            if (r34 == 0) goto L_0x0271
            r1 = 5
        L_0x0267:
            r3 = 1
            r7 = 1
            r20 = 5
            r21 = 8
        L_0x026d:
            r24 = 1
            goto L_0x02cd
        L_0x0271:
            r1 = 4
            goto L_0x0267
        L_0x0273:
            r1 = 8
            goto L_0x0267
        L_0x0276:
            if (r48 == 0) goto L_0x0290
            r3 = r53
            r7 = 2
            if (r3 == r7) goto L_0x0285
            r1 = 1
            if (r3 != r1) goto L_0x0281
            goto L_0x0285
        L_0x0281:
            r1 = 8
            r3 = 5
            goto L_0x0287
        L_0x0285:
            r1 = 5
            r3 = 4
        L_0x0287:
            r21 = r1
            r20 = r3
            r1 = r16
            r3 = 1
            r7 = 1
            goto L_0x026d
        L_0x0290:
            if (r1 <= 0) goto L_0x029b
            r1 = r16
            r3 = 1
            r7 = 1
            r20 = 5
        L_0x0298:
            r21 = 5
            goto L_0x026d
        L_0x029b:
            if (r1 != 0) goto L_0x02b8
            if (r22 != 0) goto L_0x02b8
            if (r50 != 0) goto L_0x02a8
            r1 = r16
            r3 = 1
            r7 = 1
            r20 = 8
            goto L_0x0298
        L_0x02a8:
            if (r13 == r4) goto L_0x02ae
            if (r5 == r4) goto L_0x02ae
            r1 = 4
            goto L_0x02af
        L_0x02ae:
            r1 = 5
        L_0x02af:
            r21 = r1
            r1 = r16
            r3 = 1
            r7 = 1
            r20 = 4
            goto L_0x026d
        L_0x02b8:
            r1 = r16
            r3 = 1
            r7 = 1
            r20 = 4
            goto L_0x0298
        L_0x02bf:
            r1 = r16
            r3 = 0
            r7 = 0
        L_0x02c3:
            r20 = 4
            r21 = 5
            goto L_0x0256
        L_0x02c8:
            r1 = r16
            r3 = 1
            r7 = 1
            goto L_0x02c3
        L_0x02cd:
            if (r3 == 0) goto L_0x02d8
            if (r14 != r11) goto L_0x02d8
            if (r13 == r4) goto L_0x02d8
            r25 = 0
            r26 = 0
            goto L_0x02dc
        L_0x02d8:
            r25 = r3
            r26 = 1
        L_0x02dc:
            if (r7 == 0) goto L_0x030e
            int r3 = r0.mVisibility
            r7 = 8
            if (r3 != r7) goto L_0x02e7
            r27 = 4
            goto L_0x02e9
        L_0x02e7:
            r27 = r1
        L_0x02e9:
            int r28 = r41.getMargin()
            int r29 = r42.getMargin()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r14
            r33 = r12
            r12 = r4
            r4 = r28
            r28 = r12
            r12 = r5
            r5 = r47
            r6 = r11
            r10 = r7
            r7 = r15
            r8 = r29
            r30 = r9
            r9 = r27
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0317
        L_0x030e:
            r33 = r2
            r28 = r4
            r12 = r5
            r30 = r9
            r10 = 8
        L_0x0317:
            int r1 = r0.mVisibility
            if (r1 != r10) goto L_0x031c
            return
        L_0x031c:
            if (r25 == 0) goto L_0x0348
            if (r34 == 0) goto L_0x032f
            if (r14 == r11) goto L_0x032f
            if (r23 != 0) goto L_0x032f
            boolean r1 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r1 != 0) goto L_0x032c
            boolean r1 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r1 == 0) goto L_0x032f
        L_0x032c:
            r1 = r16
            goto L_0x0331
        L_0x032f:
            r1 = r21
        L_0x0331:
            int r2 = r41.getMargin()
            r3 = r32
            r5 = r10
            r4 = r30
            r3.addGreaterThan(r4, r14, r2, r1)
            int r2 = r42.getMargin()
            int r2 = -r2
            r3.addLowerThan(r15, r11, r2, r1)
            r21 = r1
            goto L_0x034d
        L_0x0348:
            r3 = r32
            r5 = r10
            r4 = r30
        L_0x034d:
            if (r34 == 0) goto L_0x035f
            if (r51 == 0) goto L_0x035f
            boolean r1 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r1 != 0) goto L_0x035f
            boolean r1 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r1 != 0) goto L_0x035f
            r1 = r16
            r2 = r1
            r26 = 1
            goto L_0x0363
        L_0x035f:
            r1 = r20
            r2 = r21
        L_0x0363:
            if (r26 == 0) goto L_0x03b4
            if (r24 == 0) goto L_0x036e
            if (r50 == 0) goto L_0x036b
            if (r35 == 0) goto L_0x036e
        L_0x036b:
            r6 = r28
            goto L_0x0371
        L_0x036e:
            r6 = r28
            goto L_0x0396
        L_0x0371:
            if (r13 == r6) goto L_0x0378
            if (r12 != r6) goto L_0x0376
            goto L_0x0378
        L_0x0376:
            r16 = r1
        L_0x0378:
            boolean r7 = r13 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r7 != 0) goto L_0x0380
            boolean r7 = r12 instanceof androidx.constraintlayout.solver.widgets.Guideline
            if (r7 == 0) goto L_0x0382
        L_0x0380:
            r16 = 5
        L_0x0382:
            boolean r7 = r13 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 != 0) goto L_0x038a
            boolean r7 = r12 instanceof androidx.constraintlayout.solver.widgets.Barrier
            if (r7 == 0) goto L_0x038c
        L_0x038a:
            r16 = 5
        L_0x038c:
            if (r50 == 0) goto L_0x0390
            r7 = 5
            goto L_0x0392
        L_0x0390:
            r7 = r16
        L_0x0392:
            int r1 = java.lang.Math.max(r7, r1)
        L_0x0396:
            if (r34 == 0) goto L_0x03a5
            int r1 = java.lang.Math.min(r2, r1)
            if (r48 == 0) goto L_0x03a5
            if (r50 != 0) goto L_0x03a5
            if (r13 == r6) goto L_0x03a4
            if (r12 != r6) goto L_0x03a5
        L_0x03a4:
            r1 = 4
        L_0x03a5:
            int r2 = r41.getMargin()
            r3.addEquality(r4, r14, r2, r1)
            int r2 = r42.getMargin()
            int r2 = -r2
            r3.addEquality(r15, r11, r2, r1)
        L_0x03b4:
            if (r34 == 0) goto L_0x03c6
            r1 = r37
            if (r1 != r14) goto L_0x03bf
            int r2 = r41.getMargin()
            goto L_0x03c0
        L_0x03bf:
            r2 = 0
        L_0x03c0:
            if (r14 == r1) goto L_0x03c6
            r6 = 5
            r3.addGreaterThan(r4, r1, r2, r6)
        L_0x03c6:
            if (r34 == 0) goto L_0x01d8
            if (r23 == 0) goto L_0x01d8
            r2 = r15
            if (r45 != 0) goto L_0x03e0
            if (r22 != 0) goto L_0x03e0
            if (r23 == 0) goto L_0x03db
            r6 = r33
            r1 = 3
            if (r6 != r1) goto L_0x03db
            r1 = 0
            r3.addGreaterThan(r2, r4, r1, r5)
            goto L_0x03e0
        L_0x03db:
            r1 = 0
            r5 = 5
            r3.addGreaterThan(r2, r4, r1, r5)
        L_0x03e0:
            if (r34 == 0) goto L_0x03fa
            if (r18 == 0) goto L_0x03fa
            r1 = r42
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x03f1
            int r14 = r42.getMargin()
            r6 = r38
            goto L_0x03f4
        L_0x03f1:
            r6 = r38
            r14 = 0
        L_0x03f4:
            if (r11 == r6) goto L_0x03fa
            r1 = 5
            r3.addGreaterThan(r6, r2, r14, r1)
        L_0x03fa:
            return
        L_0x03fb:
            r1 = r37
            r6 = r38
            r4 = r9
            r3 = r10
            r2 = r15
            r5 = 8
            r7 = r21
            goto L_0x01ce
        L_0x0408:
            if (r7 >= r8) goto L_0x0448
            if (r34 == 0) goto L_0x0448
            if (r18 == 0) goto L_0x0448
            r7 = 0
            r3.addGreaterThan(r4, r1, r7, r5)
            if (r33 != 0) goto L_0x041d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 != 0) goto L_0x041b
            goto L_0x041d
        L_0x041b:
            r1 = 0
            goto L_0x041e
        L_0x041d:
            r1 = 1
        L_0x041e:
            if (r33 != 0) goto L_0x0441
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0441
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r4.mOwner
            float r4 = r1.mDimensionRatio
            r7 = 0
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x043f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.mListDimensionBehaviors
            r4 = 0
            r7 = r1[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r4) goto L_0x043f
            r7 = 1
            r1 = r1[r7]
            if (r1 != r4) goto L_0x043f
            r14 = r7
            goto L_0x0442
        L_0x043f:
            r14 = 0
            goto L_0x0442
        L_0x0441:
            r14 = r1
        L_0x0442:
            if (r14 == 0) goto L_0x0448
            r1 = 0
            r3.addGreaterThan(r6, r2, r1, r5)
        L_0x0448:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.applyConstraints(androidx.constraintlayout.solver.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isChainHead(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r3.mListAnchors
            r1 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r4.mTarget
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.isChainHead(int):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean addFirst() {
        if ((this instanceof VirtualLayout) || (this instanceof Guideline)) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: int} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0359  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x03cf  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x048f  */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0497  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:253:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r47) {
        /*
            r46 = this;
            r13 = r46
            r9 = r47
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mLeft
            androidx.constraintlayout.solver.SolverVariable r7 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mRight
            androidx.constraintlayout.solver.SolverVariable r6 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mTop
            androidx.constraintlayout.solver.SolverVariable r4 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r3 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r13.mBaseline
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r0)
            androidx.constraintlayout.solver.Metrics r0 = androidx.constraintlayout.solver.LinearSystem.sMetrics
            r10 = 1
            if (r0 == 0) goto L_0x002d
            long r14 = r0.widgets
            long r14 = r14 + r10
            r0.widgets = r14
        L_0x002d:
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r2 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r5 = r2.start
            boolean r8 = r5.resolved
            r12 = 0
            if (r8 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r2 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r8 = r2.start
            boolean r8 = r8.resolved
            if (r8 == 0) goto L_0x00d1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            boolean r2 = r2.resolved
            if (r2 == 0) goto L_0x00d1
            if (r0 == 0) goto L_0x0051
            long r14 = r0.graphSolved
            long r14 = r14 + r10
            r0.graphSolved = r14
        L_0x0051:
            int r0 = r5.value
            r9.addEquality(r7, r0)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r0 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r6, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.start
            int r0 = r0.value
            r9.addEquality(r4, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r9.addEquality(r3, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r9.addEquality(r1, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x00d0
            if (r0 == 0) goto L_0x008a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r1 = r1[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x008a
            r1 = 1
            goto L_0x008b
        L_0x008a:
            r1 = r12
        L_0x008b:
            if (r0 == 0) goto L_0x0098
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r4 = 1
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r4) goto L_0x0098
            r0 = 1
            goto L_0x0099
        L_0x0098:
            r0 = r12
        L_0x0099:
            if (r1 == 0) goto L_0x00b4
            boolean[] r1 = r13.isTerminalWidget
            boolean r1 = r1[r12]
            if (r1 == 0) goto L_0x00b4
            boolean r1 = r46.isInHorizontalChain()
            if (r1 != 0) goto L_0x00b4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mRight
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r2 = 8
            r9.addGreaterThan(r1, r6, r12, r2)
        L_0x00b4:
            if (r0 == 0) goto L_0x00d0
            boolean[] r0 = r13.isTerminalWidget
            r1 = 1
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x00d0
            boolean r0 = r46.isInVerticalChain()
            if (r0 != 0) goto L_0x00d0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r1 = 8
            r9.addGreaterThan(r0, r3, r12, r1)
        L_0x00d0:
            return
        L_0x00d1:
            if (r0 == 0) goto L_0x00d8
            long r14 = r0.linearSolved
            long r14 = r14 + r10
            r0.linearSolved = r14
        L_0x00d8:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x016d
            if (r0 == 0) goto L_0x00e8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r8) goto L_0x00e8
            r5 = 1
            goto L_0x00e9
        L_0x00e8:
            r5 = r12
        L_0x00e9:
            if (r0 == 0) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.mListDimensionBehaviors
            r8 = 1
            r0 = r0[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r8) goto L_0x00f6
            r0 = 1
            goto L_0x00f7
        L_0x00f6:
            r0 = r12
        L_0x00f7:
            boolean r8 = r13.isChainHead(r12)
            if (r8 == 0) goto L_0x0107
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r8
            r8.addChain(r13, r12)
            r8 = 1
        L_0x0105:
            r10 = 1
            goto L_0x010c
        L_0x0107:
            boolean r8 = r46.isInHorizontalChain()
            goto L_0x0105
        L_0x010c:
            boolean r11 = r13.isChainHead(r10)
            if (r11 == 0) goto L_0x011b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r11 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r11
            r11.addChain(r13, r10)
            r10 = 1
            goto L_0x011f
        L_0x011b:
            boolean r10 = r46.isInVerticalChain()
        L_0x011f:
            if (r8 != 0) goto L_0x0141
            if (r5 == 0) goto L_0x0141
            int r11 = r13.mVisibility
            r2 = 8
            if (r11 == r2) goto L_0x0141
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x0141
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x0141
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mRight
            androidx.constraintlayout.solver.SolverVariable r11 = r9.createObjectVariable(r11)
            r14 = 1
            r9.addGreaterThan(r11, r6, r12, r14)
        L_0x0141:
            if (r10 != 0) goto L_0x0167
            if (r0 == 0) goto L_0x0167
            int r11 = r13.mVisibility
            r2 = 8
            if (r11 == r2) goto L_0x0167
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x0167
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mTarget
            if (r11 != 0) goto L_0x0167
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mBaseline
            if (r11 != 0) goto L_0x0167
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r11.mBottom
            androidx.constraintlayout.solver.SolverVariable r11 = r9.createObjectVariable(r11)
            r14 = 1
            r9.addGreaterThan(r11, r3, r12, r14)
        L_0x0167:
            r15 = r5
            r28 = r8
            r27 = r10
            goto L_0x0173
        L_0x016d:
            r0 = r12
            r15 = r0
            r27 = r15
            r28 = r27
        L_0x0173:
            int r5 = r13.mWidth
            int r8 = r13.mMinWidth
            if (r5 >= r8) goto L_0x017a
            goto L_0x017b
        L_0x017a:
            r8 = r5
        L_0x017b:
            int r10 = r13.mHeight
            int r11 = r13.mMinHeight
            if (r10 >= r11) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r11 = r10
        L_0x0183:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r14 = r13.mListDimensionBehaviors
            r2 = r14[r12]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r19 = r1
            if (r2 == r12) goto L_0x0191
            r1 = 1
        L_0x018e:
            r16 = 1
            goto L_0x0193
        L_0x0191:
            r1 = 0
            goto L_0x018e
        L_0x0193:
            r14 = r14[r16]
            r20 = r3
            r21 = r4
            if (r14 == r12) goto L_0x019d
            r3 = 1
            goto L_0x019e
        L_0x019d:
            r3 = 0
        L_0x019e:
            int r4 = r13.mDimensionRatioSide
            r13.mResolvedDimensionRatioSide = r4
            r22 = r8
            float r8 = r13.mDimensionRatio
            r13.mResolvedDimensionRatio = r8
            r23 = r11
            int r11 = r13.mMatchConstraintDefaultWidth
            r26 = r6
            int r6 = r13.mMatchConstraintDefaultHeight
            r24 = 0
            int r24 = (r8 > r24 ? 1 : (r8 == r24 ? 0 : -1))
            r29 = r7
            if (r24 <= 0) goto L_0x0221
            int r7 = r13.mVisibility
            r9 = 8
            if (r7 == r9) goto L_0x0221
            r9 = 3
            if (r2 != r12) goto L_0x01c4
            if (r11 != 0) goto L_0x01c4
            r11 = r9
        L_0x01c4:
            if (r14 != r12) goto L_0x01c9
            if (r6 != 0) goto L_0x01c9
            r6 = r9
        L_0x01c9:
            if (r2 != r12) goto L_0x01d5
            if (r14 != r12) goto L_0x01d5
            if (r11 != r9) goto L_0x01d5
            if (r6 != r9) goto L_0x01d5
            r13.setupDimensionRatio(r15, r0, r1, r3)
            goto L_0x021a
        L_0x01d5:
            r1 = 4
            if (r2 != r12) goto L_0x01f2
            if (r11 != r9) goto L_0x01f2
            r3 = 0
            r13.mResolvedDimensionRatioSide = r3
            float r2 = (float) r10
            float r8 = r8 * r2
            int r8 = (int) r8
            if (r14 == r12) goto L_0x01ea
            r33 = r1
            r32 = r6
        L_0x01e6:
            r31 = r23
        L_0x01e8:
            r9 = 0
            goto L_0x0228
        L_0x01ea:
            r32 = r6
            r33 = r11
        L_0x01ee:
            r31 = r23
        L_0x01f0:
            r9 = 1
            goto L_0x0228
        L_0x01f2:
            if (r14 != r12) goto L_0x021a
            if (r6 != r9) goto L_0x021a
            r3 = 1
            r13.mResolvedDimensionRatioSide = r3
            r3 = -1
            if (r4 != r3) goto L_0x0201
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r8
            r13.mResolvedDimensionRatio = r3
        L_0x0201:
            float r3 = r13.mResolvedDimensionRatio
            float r4 = (float) r5
            float r3 = r3 * r4
            int r3 = (int) r3
            if (r2 == r12) goto L_0x0211
            r32 = r1
            r31 = r3
            r33 = r11
            r8 = r22
            goto L_0x01e8
        L_0x0211:
            r31 = r3
            r32 = r6
            r33 = r11
            r8 = r22
            goto L_0x01f0
        L_0x021a:
            r32 = r6
            r33 = r11
            r8 = r22
            goto L_0x01ee
        L_0x0221:
            r32 = r6
            r33 = r11
            r8 = r22
            goto L_0x01e6
        L_0x0228:
            int[] r1 = r13.mResolvedMatchConstraintDefault
            r2 = 0
            r1[r2] = r33
            r2 = 1
            r1[r2] = r32
            r13.mResolvedHasRatio = r9
            if (r9 == 0) goto L_0x023e
            int r1 = r13.mResolvedDimensionRatioSide
            r6 = -1
            if (r1 == 0) goto L_0x023b
            if (r1 != r6) goto L_0x023f
        L_0x023b:
            r17 = 1
            goto L_0x0241
        L_0x023e:
            r6 = -1
        L_0x023f:
            r17 = 0
        L_0x0241:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x0251
            boolean r1 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r1 == 0) goto L_0x0251
            r22 = 1
            goto L_0x0253
        L_0x0251:
            r22 = 0
        L_0x0253:
            if (r22 == 0) goto L_0x0258
            r30 = 0
            goto L_0x025a
        L_0x0258:
            r30 = r8
        L_0x025a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mCenter
            boolean r1 = r1.isConnected()
            r2 = 1
            r34 = r1 ^ 1
            boolean[] r1 = r13.mIsInBarrier
            r3 = 0
            boolean r35 = r1[r3]
            boolean r36 = r1[r2]
            int r1 = r13.mHorizontalResolution
            r3 = 2
            r37 = 0
            if (r1 == r3) goto L_0x0359
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r1 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r5 = r1.start
            boolean r8 = r5.resolved
            if (r8 == 0) goto L_0x027f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0288
        L_0x027f:
            r14 = r47
            r11 = r26
            r12 = r29
            r7 = 8
            goto L_0x02d3
        L_0x0288:
            int r1 = r5.value
            r14 = r47
            r12 = r29
            r14.addEquality(r12, r1)
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r1 = r13.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.value
            r11 = r26
            r14.addEquality(r11, r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            if (r1 == 0) goto L_0x02d0
            if (r15 == 0) goto L_0x02d0
            boolean[] r1 = r13.isTerminalWidget
            r5 = 0
            boolean r1 = r1[r5]
            if (r1 == 0) goto L_0x02d0
            boolean r1 = r46.isInHorizontalChain()
            if (r1 != 0) goto L_0x02d0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mRight
            androidx.constraintlayout.solver.SolverVariable r1 = r14.createObjectVariable(r1)
            r7 = 8
            r14.addGreaterThan(r1, r11, r5, r7)
        L_0x02bc:
            r40 = r0
            r44 = r4
            r38 = r9
            r45 = r11
            r29 = r12
            r39 = r15
            r41 = r19
            r42 = r20
            r43 = r21
            goto L_0x036a
        L_0x02d0:
            r7 = 8
            goto L_0x02bc
        L_0x02d3:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            if (r1 == 0) goto L_0x02e0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mRight
            androidx.constraintlayout.solver.SolverVariable r1 = r14.createObjectVariable(r1)
            r26 = r1
            goto L_0x02e2
        L_0x02e0:
            r26 = r37
        L_0x02e2:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r13.mParent
            if (r1 == 0) goto L_0x02ef
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mLeft
            androidx.constraintlayout.solver.SolverVariable r1 = r14.createObjectVariable(r1)
            r29 = r1
            goto L_0x02f1
        L_0x02ef:
            r29 = r37
        L_0x02f1:
            boolean[] r1 = r13.isTerminalWidget
            r16 = 0
            boolean r5 = r1[r16]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r8 = r1[r16]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r13.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mRight
            r18 = r11
            r11 = r1
            int r1 = r13.mX
            r38 = r12
            r2 = r16
            r12 = r1
            int r1 = r13.mMinWidth
            r14 = r1
            int[] r1 = r13.mMaxDimension
            r1 = r1[r2]
            r39 = r15
            r15 = r1
            float r1 = r13.mHorizontalBiasPercent
            r16 = r1
            int r1 = r13.mMatchConstraintMinWidth
            r23 = r1
            int r1 = r13.mMatchConstraintMaxWidth
            r24 = r1
            float r1 = r13.mMatchConstraintPercentWidth
            r25 = r1
            r1 = 1
            r2 = r1
            r40 = r0
            r0 = r46
            r41 = r19
            r1 = r47
            r42 = r20
            r3 = r39
            r44 = r4
            r43 = r21
            r4 = r40
            r45 = r18
            r18 = r6
            r6 = r29
            r29 = r38
            r7 = r26
            r38 = r9
            r9 = r22
            r13 = r30
            r18 = r28
            r19 = r27
            r20 = r35
            r21 = r33
            r22 = r32
            r26 = r34
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x0356:
            r13 = r46
            goto L_0x036a
        L_0x0359:
            r40 = r0
            r44 = r4
            r38 = r9
            r39 = r15
            r41 = r19
            r42 = r20
            r43 = r21
            r45 = r26
            goto L_0x0356
        L_0x036a:
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x03bd
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            boolean r0 = r0.resolved
            if (r0 == 0) goto L_0x03bd
            int r0 = r1.value
            r9 = r47
            r7 = r43
            r9.addEquality(r7, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.end
            int r0 = r0.value
            r6 = r42
            r9.addEquality(r6, r0)
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r0 = r13.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.baseline
            int r0 = r0.value
            r1 = r41
            r9.addEquality(r1, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x03b7
            if (r27 != 0) goto L_0x03b7
            if (r40 == 0) goto L_0x03b7
            boolean[] r2 = r13.isTerminalWidget
            r4 = 1
            boolean r2 = r2[r4]
            if (r2 == 0) goto L_0x03b3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            r2 = 8
            r3 = 0
            r9.addGreaterThan(r0, r6, r3, r2)
            goto L_0x03bb
        L_0x03b3:
            r2 = 8
            r3 = 0
            goto L_0x03bb
        L_0x03b7:
            r2 = 8
            r3 = 0
            r4 = 1
        L_0x03bb:
            r14 = r3
            goto L_0x03ca
        L_0x03bd:
            r9 = r47
            r1 = r41
            r6 = r42
            r7 = r43
            r2 = 8
            r3 = 0
            r4 = 1
            r14 = r4
        L_0x03ca:
            int r0 = r13.mVerticalResolution
            r5 = 2
            if (r0 != r5) goto L_0x03d1
            r12 = r3
            goto L_0x03d2
        L_0x03d1:
            r12 = r14
        L_0x03d2:
            if (r12 == 0) goto L_0x048f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r13.mListDimensionBehaviors
            r0 = r0[r4]
            r5 = r44
            if (r0 != r5) goto L_0x03e3
            boolean r0 = r13 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x03e3
            r17 = r4
            goto L_0x03e5
        L_0x03e3:
            r17 = r3
        L_0x03e5:
            if (r17 == 0) goto L_0x03e9
            r31 = r3
        L_0x03e9:
            if (r38 == 0) goto L_0x03f5
            int r0 = r13.mResolvedDimensionRatioSide
            if (r0 == r4) goto L_0x03f2
            r5 = -1
            if (r0 != r5) goto L_0x03f5
        L_0x03f2:
            r18 = r4
            goto L_0x03f7
        L_0x03f5:
            r18 = r3
        L_0x03f7:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r13.mParent
            if (r0 == 0) goto L_0x0402
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mBottom
            androidx.constraintlayout.solver.SolverVariable r0 = r9.createObjectVariable(r0)
            goto L_0x0404
        L_0x0402:
            r0 = r37
        L_0x0404:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r13.mParent
            if (r5 == 0) goto L_0x0410
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTop
            androidx.constraintlayout.solver.SolverVariable r5 = r9.createObjectVariable(r5)
            r37 = r5
        L_0x0410:
            int r5 = r13.mBaselineDistance
            if (r5 > 0) goto L_0x0418
            int r5 = r13.mVisibility
            if (r5 != r2) goto L_0x0442
        L_0x0418:
            int r5 = r46.getBaselineDistance()
            r9.addEquality(r1, r7, r5, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r13.mBaseline
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x043b
            androidx.constraintlayout.solver.SolverVariable r5 = r9.createObjectVariable(r5)
            r9.addEquality(r1, r5, r3, r2)
            if (r40 == 0) goto L_0x0438
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r13.mBottom
            androidx.constraintlayout.solver.SolverVariable r1 = r9.createObjectVariable(r1)
            r2 = 5
            r9.addGreaterThan(r0, r1, r3, r2)
        L_0x0438:
            r26 = r3
            goto L_0x0444
        L_0x043b:
            int r5 = r13.mVisibility
            if (r5 != r2) goto L_0x0442
            r9.addEquality(r1, r7, r3, r2)
        L_0x0442:
            r26 = r34
        L_0x0444:
            boolean[] r1 = r13.isTerminalWidget
            boolean r5 = r1[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r13.mListDimensionBehaviors
            r8 = r1[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r13.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r13.mBottom
            int r12 = r13.mY
            int r14 = r13.mMinHeight
            int[] r1 = r13.mMaxDimension
            r15 = r1[r4]
            float r1 = r13.mVerticalBiasPercent
            r16 = r1
            int r1 = r13.mMatchConstraintMinHeight
            r23 = r1
            int r1 = r13.mMatchConstraintMaxHeight
            r24 = r1
            float r1 = r13.mMatchConstraintPercentHeight
            r25 = r1
            r2 = 0
            r19 = r0
            r0 = r46
            r1 = r47
            r3 = r40
            r4 = r39
            r30 = r6
            r6 = r37
            r34 = r7
            r7 = r19
            r9 = r17
            r13 = r31
            r17 = r18
            r18 = r27
            r19 = r28
            r20 = r36
            r21 = r32
            r22 = r33
            r0.applyConstraints(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0493
        L_0x048f:
            r30 = r6
            r34 = r7
        L_0x0493:
            r7 = r46
            if (r38 == 0) goto L_0x04bd
            int r0 = r7.mResolvedDimensionRatioSide
            r6 = 8
            r1 = 1
            if (r0 != r1) goto L_0x04ae
            float r5 = r7.mResolvedDimensionRatio
            r0 = r47
            r1 = r30
            r2 = r34
            r3 = r45
            r4 = r29
            r0.addRatio(r1, r2, r3, r4, r5, r6)
            goto L_0x04bd
        L_0x04ae:
            float r5 = r7.mResolvedDimensionRatio
            r0 = r47
            r1 = r45
            r2 = r29
            r3 = r30
            r4 = r34
            r0.addRatio(r1, r2, r3, r4, r5, r6)
        L_0x04bd:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x04e5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.mCenter
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.getTarget()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.getOwner()
            float r1 = r7.mCircleConstraintAngle
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.mCenter
            int r2 = r2.getMargin()
            r3 = r47
            r3.addCenterPoint(r7, r0, r1, r2)
        L_0x04e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public boolean allowedInBarrier() {
        if (this.mVisibility != 8) {
            return true;
        }
        return false;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i10);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i10, 0);
        this.mCircleConstraintAngle = f10;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.mParent == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.mParent);
        }
        this.mParent = constraintWidget2;
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mOptimizerMeasurable = constraintWidget.mOptimizerMeasurable;
        this.mGroupsToSolver = constraintWidget.mGroupsToSolver;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget5 = constraintWidget.mHorizontalNextWidget;
        if (constraintWidget5 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget5);
        }
        this.mHorizontalNextWidget = constraintWidget3;
        ConstraintWidget constraintWidget6 = constraintWidget.mVerticalNextWidget;
        if (constraintWidget6 != null) {
            constraintWidget4 = hashMap.get(constraintWidget6);
        }
        this.mVerticalNextWidget = constraintWidget4;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (a.f14696a[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i10) {
        if (i10 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i10 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i10) {
        if (i10 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i10 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        int i10;
        ConstraintAnchor constraintAnchor = this.mLeft;
        if (constraintAnchor != null) {
            i10 = constraintAnchor.mMargin;
        } else {
            i10 = 0;
        }
        ConstraintAnchor constraintAnchor2 = this.mRight;
        if (constraintAnchor2 != null) {
            return i10 + constraintAnchor2.mMargin;
        }
        return i10;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i10) {
        if (i10 == 0) {
            return getWidth();
        }
        if (i10 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mBottom;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getNextChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mRight
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mBottom
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.getNextChainMember(int):androidx.constraintlayout.solver.widgets.ConstraintWidget");
    }

    public int getOptimizerWrapHeight() {
        int i10;
        int i11 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i11;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            i10 = Math.max(this.mMatchConstraintMinHeight, i11);
        } else {
            i10 = this.mMatchConstraintMinHeight;
            if (i10 > 0) {
                this.mHeight = i10;
            } else {
                i10 = 0;
            }
        }
        int i12 = this.mMatchConstraintMaxHeight;
        if (i12 <= 0 || i12 >= i10) {
            return i10;
        }
        return i12;
    }

    public int getOptimizerWrapWidth() {
        int i10;
        int i11 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i11;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            i10 = Math.max(this.mMatchConstraintMinWidth, i11);
        } else {
            i10 = this.mMatchConstraintMinWidth;
            if (i10 > 0) {
                this.mWidth = i10;
            } else {
                i10 = 0;
            }
        }
        int i12 = this.mMatchConstraintMaxWidth;
        if (i12 <= 0 || i12 >= i10) {
            return i10;
        }
        return i12;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.mTop;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.constraintlayout.solver.widgets.ConstraintWidget getPreviousChainMember(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mLeft
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r2.mTop
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.mTarget
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.mTarget
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.mOwner
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.getPreviousChainMember(int):androidx.constraintlayout.solver.widgets.ConstraintWidget");
    }

    /* access modifiers changed from: package-private */
    public int getRelativePositioning(int i10) {
        if (i10 == 0) {
            return this.mRelX;
        }
        if (i10 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    /* access modifiers changed from: protected */
    public int getRootX() {
        return this.mX + this.mOffsetX;
    }

    /* access modifiers changed from: protected */
    public int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i10) {
        if (i10 == 0) {
            return this.horizontalRun;
        }
        if (i10 == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor2;
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget2 = this;
        ConstraintWidget constraintWidget3 = null;
        while (constraintWidget3 == null && constraintWidget2 != null) {
            ConstraintAnchor anchor = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP);
            if (anchor == null) {
                constraintAnchor = null;
            } else {
                constraintAnchor = anchor.getTarget();
            }
            if (constraintAnchor == null) {
                constraintWidget = null;
            } else {
                constraintWidget = constraintAnchor.getOwner();
            }
            if (constraintWidget == getParent()) {
                return constraintWidget2;
            }
            if (constraintWidget == null) {
                constraintAnchor2 = null;
            } else {
                constraintAnchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            }
            if (constraintAnchor2 == null || constraintAnchor2.getOwner() == constraintWidget2) {
                constraintWidget2 = constraintWidget;
            } else {
                constraintWidget3 = constraintWidget2;
            }
        }
        return constraintWidget3;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i10;
        if (this.mLeft != null) {
            i10 = this.mTop.mMargin;
        } else {
            i10 = 0;
        }
        if (this.mRight != null) {
            return i10 + this.mBottom.mMargin;
        }
        return i10;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mX;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.mY;
        }
        return ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10, int i11) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i10, i11, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isRoot() {
        if (this.mParent == null) {
            return true;
        }
        return false;
    }

    public boolean isSpreadHeight() {
        if (this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isSpreadWidth() {
        if (this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            return true;
        }
        return false;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() == null || !(getParent() instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
            ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
            ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
            if (constraintAnchor == anchor5) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor.reset();
                    anchor2.reset();
                }
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor6) {
                if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                    anchor.reset();
                    anchor2.reset();
                }
                this.mHorizontalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor7) {
                if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                    anchor3.reset();
                    anchor4.reset();
                }
                this.mVerticalBiasPercent = 0.5f;
            } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
                if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                    anchor5.reset();
                }
            } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor5.reset();
            }
            constraintAnchor.reset();
        }
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent == null || !(parent instanceof ConstraintWidgetContainer) || !((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            int size = this.mAnchors.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mAnchors.get(i10).reset();
            }
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i10) {
        boolean z10;
        this.mBaselineDistance = i10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.hasBaseline = z10;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i10) {
        if (i10 >= 0) {
            this.mContainerItemSkip = i10;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.mBaselineDistance > 0) {
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
            createObjectVariable5.setName(str + ".baseline");
        }
    }

    public void setDimension(int i10, int i11) {
        this.mWidth = i10;
        int i12 = this.mMinWidth;
        if (i10 < i12) {
            this.mWidth = i12;
        }
        this.mHeight = i11;
        int i13 = this.mMinHeight;
        if (i11 < i13) {
            this.mHeight = i13;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setDimensionRatio(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0090
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x0090
        L_0x000b:
            int r1 = r9.length()
            r2 = 44
            int r2 = r9.indexOf(r2)
            r3 = 0
            r4 = 1
            r5 = -1
            if (r2 <= 0) goto L_0x0039
            int r6 = r1 + -1
            if (r2 >= r6) goto L_0x0039
            java.lang.String r6 = r9.substring(r3, r2)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002b
            goto L_0x0036
        L_0x002b:
            java.lang.String r3 = "H"
            boolean r3 = r6.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0035
            r3 = r4
            goto L_0x0036
        L_0x0035:
            r3 = r5
        L_0x0036:
            int r2 = r2 + r4
            r5 = r3
            r3 = r2
        L_0x0039:
            r2 = 58
            int r2 = r9.indexOf(r2)
            if (r2 < 0) goto L_0x0077
            int r1 = r1 - r4
            if (r2 >= r1) goto L_0x0077
            java.lang.String r1 = r9.substring(r3, r2)
            int r2 = r2 + r4
            java.lang.String r9 = r9.substring(r2)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0086
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0086
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0086
            if (r5 != r4) goto L_0x0071
            float r9 = r9 / r1
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0071:
            float r1 = r1 / r9
            float r9 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0077:
            java.lang.String r9 = r9.substring(r3)
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x0086
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0086 }
            goto L_0x0087
        L_0x0086:
            r9 = r0
        L_0x0087:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008f
            r8.mDimensionRatio = r9
            r8.mDimensionRatioSide = r5
        L_0x008f:
            return
        L_0x0090:
            r8.mDimensionRatio = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.setDimensionRatio(java.lang.String):void");
    }

    public void setFrame(int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        this.mX = i10;
        this.mY = i11;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i16 < (i15 = this.mWidth)) {
            i16 = i15;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i17 < (i14 = this.mHeight)) {
            i17 = i14;
        }
        this.mWidth = i16;
        this.mHeight = i17;
        int i18 = this.mMinHeight;
        if (i17 < i18) {
            this.mHeight = i18;
        }
        int i19 = this.mMinWidth;
        if (i16 < i19) {
            this.mWidth = i19;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i10) {
        int i11 = a.f14696a[type.ordinal()];
        if (i11 == 1) {
            this.mLeft.mGoneMargin = i10;
        } else if (i11 == 2) {
            this.mTop.mGoneMargin = i10;
        } else if (i11 == 3) {
            this.mRight.mGoneMargin = i10;
        } else if (i11 == 4) {
            this.mBottom.mGoneMargin = i10;
        }
    }

    public void setHasBaseline(boolean z10) {
        this.hasBaseline = z10;
    }

    public void setHeight(int i10) {
        this.mHeight = i10;
        int i11 = this.mMinHeight;
        if (i10 < i11) {
            this.mHeight = i11;
        }
    }

    public void setHeightWrapContent(boolean z10) {
        this.mIsHeightWrapContent = z10;
    }

    public void setHorizontalBiasPercent(float f10) {
        this.mHorizontalBiasPercent = f10;
    }

    public void setHorizontalChainStyle(int i10) {
        this.mHorizontalChainStyle = i10;
    }

    public void setHorizontalDimension(int i10, int i11) {
        this.mX = i10;
        int i12 = i11 - i10;
        this.mWidth = i12;
        int i13 = this.mMinWidth;
        if (i12 < i13) {
            this.mWidth = i13;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i10, int i11, int i12, float f10) {
        this.mMatchConstraintDefaultWidth = i10;
        this.mMatchConstraintMinWidth = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.mMatchConstraintMaxWidth = i12;
        this.mMatchConstraintPercentWidth = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.mMatchConstraintDefaultWidth = 2;
        }
    }

    public void setHorizontalWeight(float f10) {
        this.mWeight[0] = f10;
    }

    /* access modifiers changed from: protected */
    public void setInBarrier(int i10, boolean z10) {
        this.mIsInBarrier[i10] = z10;
    }

    public void setInPlaceholder(boolean z10) {
        this.inPlaceholder = z10;
    }

    public void setInVirtualLayout(boolean z10) {
        this.mInVirtuaLayout = z10;
    }

    public void setLength(int i10, int i11) {
        if (i11 == 0) {
            setWidth(i10);
        } else if (i11 == 1) {
            setHeight(i10);
        }
    }

    public void setMaxHeight(int i10) {
        this.mMaxDimension[1] = i10;
    }

    public void setMaxWidth(int i10) {
        this.mMaxDimension[0] = i10;
    }

    public void setMinHeight(int i10) {
        if (i10 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i10;
        }
    }

    public void setMinWidth(int i10) {
        if (i10 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i10;
        }
    }

    public void setOffset(int i10, int i11) {
        this.mOffsetX = i10;
        this.mOffsetY = i11;
    }

    public void setOrigin(int i10, int i11) {
        this.mX = i10;
        this.mY = i11;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    /* access modifiers changed from: package-private */
    public void setRelativePositioning(int i10, int i11) {
        if (i11 == 0) {
            this.mRelX = i10;
        } else if (i11 == 1) {
            this.mRelY = i10;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f10) {
        this.mVerticalBiasPercent = f10;
    }

    public void setVerticalChainStyle(int i10) {
        this.mVerticalChainStyle = i10;
    }

    public void setVerticalDimension(int i10, int i11) {
        this.mY = i10;
        int i12 = i11 - i10;
        this.mHeight = i12;
        int i13 = this.mMinHeight;
        if (i12 < i13) {
            this.mHeight = i13;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i10, int i11, int i12, float f10) {
        this.mMatchConstraintDefaultHeight = i10;
        this.mMatchConstraintMinHeight = i11;
        if (i12 == Integer.MAX_VALUE) {
            i12 = 0;
        }
        this.mMatchConstraintMaxHeight = i12;
        this.mMatchConstraintPercentHeight = f10;
        if (f10 > 0.0f && f10 < 1.0f && i10 == 0) {
            this.mMatchConstraintDefaultHeight = 2;
        }
    }

    public void setVerticalWeight(float f10) {
        this.mWeight[1] = f10;
    }

    public void setVisibility(int i10) {
        this.mVisibility = i10;
    }

    public void setWidth(int i10) {
        this.mWidth = i10;
        int i11 = this.mMinWidth;
        if (i10 < i11) {
            this.mWidth = i11;
        }
    }

    public void setWidthWrapContent(boolean z10) {
        this.mIsWidthWrapContent = z10;
    }

    public void setX(int i10) {
        this.mX = i10;
    }

    public void setY(int i10) {
        this.mY = i10;
    }

    public void setupDimensionRatio(boolean z10, boolean z11, boolean z12, boolean z13) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z12 && !z13) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z12 && z13) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            int i10 = this.mMatchConstraintMinWidth;
            if (i10 > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (i10 == 0 && this.mMatchConstraintMinHeight > 0) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + " ";
        } else {
            str = str2;
        }
        sb2.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + " ";
        }
        sb2.append(str2);
        sb2.append("(");
        sb2.append(this.mX);
        sb2.append(", ");
        sb2.append(this.mY);
        sb2.append(") - (");
        sb2.append(this.mWidth);
        sb2.append(" x ");
        sb2.append(this.mHeight);
        sb2.append(")");
        return sb2.toString();
    }

    public void updateFromRuns(boolean z10, boolean z11) {
        int i10;
        int i11;
        boolean isResolved = z10 & this.horizontalRun.isResolved();
        boolean isResolved2 = z11 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i12 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i13 = verticalWidgetRun.start.value;
        int i14 = horizontalWidgetRun.end.value;
        int i15 = verticalWidgetRun.end.value;
        int i16 = i15 - i13;
        if (i14 - i12 < 0 || i16 < 0 || i12 == Integer.MIN_VALUE || i12 == Integer.MAX_VALUE || i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE || i14 == Integer.MIN_VALUE || i14 == Integer.MAX_VALUE || i15 == Integer.MIN_VALUE || i15 == Integer.MAX_VALUE) {
            i14 = 0;
            i12 = 0;
            i15 = 0;
            i13 = 0;
        }
        int i17 = i14 - i12;
        int i18 = i15 - i13;
        if (isResolved) {
            this.mX = i12;
        }
        if (isResolved2) {
            this.mY = i13;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (isResolved) {
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED && i17 < (i11 = this.mWidth)) {
                i17 = i11;
            }
            this.mWidth = i17;
            int i19 = this.mMinWidth;
            if (i17 < i19) {
                this.mWidth = i19;
            }
        }
        if (isResolved2) {
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED && i18 < (i10 = this.mHeight)) {
                i18 = i10;
            }
            this.mHeight = i18;
            int i20 = this.mMinHeight;
            if (i18 < i20) {
                this.mHeight = i20;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        DependencyNode dependencyNode = horizontalWidgetRun.start;
        if (dependencyNode.resolved) {
            DependencyNode dependencyNode2 = horizontalWidgetRun.end;
            if (dependencyNode2.resolved) {
                objectVariableValue = dependencyNode.value;
                objectVariableValue3 = dependencyNode2.value;
            }
        }
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        DependencyNode dependencyNode3 = verticalWidgetRun.start;
        if (dependencyNode3.resolved) {
            DependencyNode dependencyNode4 = verticalWidgetRun.end;
            if (dependencyNode4.resolved) {
                objectVariableValue2 = dependencyNode3.value;
                objectVariableValue4 = dependencyNode4.value;
            }
        }
        int i10 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i10 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue = 0;
            objectVariableValue4 = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i10) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z10;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor anchor = getAnchor(type4);
                ConstraintAnchor anchor2 = constraintWidget.getAnchor(type2);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.RIGHT);
                anchor.connect(anchor2, 0);
                anchor3.connect(anchor2, 0);
                getAnchor(type6).connect(anchor2, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor anchor4 = constraintWidget.getAnchor(type2);
                getAnchor(type3).connect(anchor4, 0);
                getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor4, 0);
                getAnchor(type7).connect(anchor4, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                getAnchor(type8).connect(constraintWidget.getAnchor(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                getAnchor(type9).connect(constraintWidget.getAnchor(type9), 0);
                getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                getAnchor(type10).connect(constraintWidget.getAnchor(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0);
                getAnchor(type7).connect(constraintWidget.getAnchor(type2), 0);
            } else {
                ConstraintAnchor anchor5 = getAnchor(type);
                ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
                if (anchor5.isValidConnection(anchor6)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor anchor8 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                        if (anchor7 != null) {
                            anchor7.reset();
                        }
                        if (anchor8 != null) {
                            anchor8.reset();
                        }
                        i10 = 0;
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor anchor9 = getAnchor(type12);
                        if (anchor9 != null) {
                            anchor9.reset();
                        }
                        ConstraintAnchor anchor10 = getAnchor(type5);
                        if (anchor10.getTarget() != anchor6) {
                            anchor10.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor11 = getAnchor(type7);
                        if (anchor11.isConnected()) {
                            opposite.reset();
                            anchor11.reset();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor12 = getAnchor(type5);
                        if (anchor12.getTarget() != anchor6) {
                            anchor12.reset();
                        }
                        ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor13 = getAnchor(type6);
                        if (anchor13.isConnected()) {
                            opposite2.reset();
                            anchor13.reset();
                        }
                    }
                    anchor5.connect(anchor6, i10);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor anchor14 = getAnchor(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor anchor15 = getAnchor(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor anchor16 = getAnchor(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor anchor17 = getAnchor(type16);
            boolean z11 = true;
            if ((anchor14 == null || !anchor14.isConnected()) && (anchor15 == null || !anchor15.isConnected())) {
                connect(type13, constraintWidget, type13, 0);
                connect(type14, constraintWidget, type14, 0);
                z10 = true;
            } else {
                z10 = false;
            }
            if ((anchor16 == null || !anchor16.isConnected()) && (anchor17 == null || !anchor17.isConnected())) {
                connect(type15, constraintWidget, type15, 0);
                connect(type16, constraintWidget, type16, 0);
            } else {
                z11 = false;
            }
            if (z10 && z11) {
                getAnchor(type5).connect(constraintWidget.getAnchor(type5), 0);
            } else if (z10) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0);
            } else if (z11) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                connect(type19, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                connect(type20, constraintWidget, type2, 0);
                connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                getAnchor(type5).connect(constraintWidget.getAnchor(type2), 0);
            }
        }
    }

    public void setFrame(int i10, int i11, int i12) {
        if (i12 == 0) {
            setHorizontalDimension(i10, i11);
        } else if (i12 == 1) {
            setVerticalDimension(i10, i11);
        }
    }

    public void setDimensionRatio(float f10, int i10) {
        this.mDimensionRatio = f10;
        this.mDimensionRatioSide = i10;
    }

    public ConstraintWidget(int i10, int i11, int i12, int i13) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = new HorizontalWidgetRun(this);
        this.verticalRun = new VerticalWidgetRun(this);
        this.isTerminalWidget = new boolean[]{true, true};
        this.wrapMeasure = new int[]{0, 0, 0, 0};
        this.mResolvedHasRatio = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mCenter = constraintAnchor;
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, constraintAnchor};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f10 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f10;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mOptimizerMeasurable = false;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.mX = i10;
        this.mY = i11;
        this.mWidth = i12;
        this.mHeight = i13;
        addAnchors();
    }

    public ConstraintWidget(int i10, int i11) {
        this(0, 0, i10, i11);
    }
}
