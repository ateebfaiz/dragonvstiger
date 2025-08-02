package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.1";
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    b mMeasurer = new b(this);
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    private int mOptimizationLevel = Optimizer.OPTIMIZATION_STANDARD;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14758a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14758a = r0
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14758a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14758a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14758a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.<clinit>():void");
        }
    }

    class b implements BasicMeasure.Measurer {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f14759a;

        /* renamed from: b  reason: collision with root package name */
        int f14760b;

        /* renamed from: c  reason: collision with root package name */
        int f14761c;

        /* renamed from: d  reason: collision with root package name */
        int f14762d;

        /* renamed from: e  reason: collision with root package name */
        int f14763e;

        /* renamed from: f  reason: collision with root package name */
        int f14764f;

        /* renamed from: g  reason: collision with root package name */
        int f14765g;

        public b(ConstraintLayout constraintLayout) {
            this.f14759a = constraintLayout;
        }

        public void a(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f14760b = i12;
            this.f14761c = i13;
            this.f14762d = i14;
            this.f14763e = i15;
            this.f14764f = i10;
            this.f14765g = i11;
        }

        public final void didMeasures() {
            int childCount = this.f14759a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = this.f14759a.getChildAt(i10);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).updatePostMeasure(this.f14759a);
                }
            }
            int size = this.f14759a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((ConstraintHelper) this.f14759a.mConstraintHelpers.get(i11)).updatePostMeasure(this.f14759a);
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: int[]} */
        /* JADX WARNING: type inference failed for: r16v1 */
        /* JADX WARNING: type inference failed for: r16v2 */
        /* JADX WARNING: type inference failed for: r16v3 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x0171 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x018e  */
        /* JADX WARNING: Removed duplicated region for block: B:112:0x0198  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x01a9  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x01b4  */
        /* JADX WARNING: Removed duplicated region for block: B:118:0x01c0  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:122:0x01d7  */
        /* JADX WARNING: Removed duplicated region for block: B:123:0x01dc  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:129:0x01e9  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01ee  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01f3  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x01fb A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:142:0x0212 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x021e  */
        /* JADX WARNING: Removed duplicated region for block: B:149:0x0224  */
        /* JADX WARNING: Removed duplicated region for block: B:152:0x023a  */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x023c  */
        /* JADX WARNING: Removed duplicated region for block: B:158:0x0247  */
        /* JADX WARNING: Removed duplicated region for block: B:159:0x024a  */
        /* JADX WARNING: Removed duplicated region for block: B:162:0x0251  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0253  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0123  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0132  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0134  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0137  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x0143  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x014d  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x014f  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0159  */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x015b  */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0164  */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0166  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void measure(androidx.constraintlayout.solver.widgets.ConstraintWidget r20, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure.Measure r21) {
            /*
                r19 = this;
                r0 = r19
                r1 = r20
                r2 = r21
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r20.getVisibility()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001f
                boolean r3 = r20.isInPlaceholder()
                if (r3 != 0) goto L_0x001f
                r2.measuredWidth = r5
                r2.measuredHeight = r5
                r2.measuredBaseline = r5
                return
            L_0x001f:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.horizontalBehavior
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.verticalBehavior
                int r6 = r2.horizontalDimension
                int r7 = r2.verticalDimension
                int r8 = r0.f14760b
                int r9 = r0.f14761c
                int r8 = r8 + r9
                int r9 = r0.f14762d
                java.lang.Object r10 = r20.getCompanionWidget()
                android.view.View r10 = (android.view.View) r10
                int[] r11 = androidx.constraintlayout.widget.ConstraintLayout.a.f14758a
                int r12 = r3.ordinal()
                r12 = r11[r12]
                r13 = 4
                r15 = 3
                r5 = 2
                r14 = 1
                if (r12 == r14) goto L_0x00a7
                if (r12 == r5) goto L_0x009b
                if (r12 == r15) goto L_0x008a
                if (r12 == r13) goto L_0x004c
                r6 = 0
            L_0x0049:
                r9 = 0
                goto L_0x00b3
            L_0x004c:
                int r6 = r0.f14764f
                r12 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                int r9 = r1.mMatchConstraintDefaultWidth
                if (r9 != r14) goto L_0x0059
                r9 = r14
                goto L_0x005a
            L_0x0059:
                r9 = 0
            L_0x005a:
                int[] r12 = r1.wrapMeasure
                r16 = 0
                r12[r5] = r16
                boolean r13 = r2.useCurrentDimensions
                if (r13 == 0) goto L_0x0088
                if (r9 == 0) goto L_0x0072
                r13 = r12[r15]
                if (r13 == 0) goto L_0x0072
                r12 = r12[r16]
                int r13 = r20.getWidth()
                if (r12 != r13) goto L_0x0076
            L_0x0072:
                boolean r12 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r12 == 0) goto L_0x0078
            L_0x0076:
                r12 = r14
                goto L_0x0079
            L_0x0078:
                r12 = 0
            L_0x0079:
                if (r9 == 0) goto L_0x007d
                if (r12 == 0) goto L_0x0088
            L_0x007d:
                int r6 = r20.getWidth()
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
                goto L_0x0049
            L_0x0088:
                r9 = r14
                goto L_0x00b3
            L_0x008a:
                int r6 = r0.f14764f
                int r12 = r20.getHorizontalMargin()
                int r9 = r9 + r12
                r12 = -1
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                int[] r9 = r1.wrapMeasure
                r9[r5] = r12
                goto L_0x0049
            L_0x009b:
                int r6 = r0.f14764f
                r12 = -2
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r12)
                int[] r9 = r1.wrapMeasure
                r9[r5] = r12
                goto L_0x0088
            L_0x00a7:
                r9 = 1073741824(0x40000000, float:2.0)
                int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
                int[] r9 = r1.wrapMeasure
                r9[r5] = r6
                r6 = r12
                goto L_0x0049
            L_0x00b3:
                int r12 = r4.ordinal()
                r11 = r11[r12]
                if (r11 == r14) goto L_0x0123
                if (r11 == r5) goto L_0x0117
                if (r11 == r15) goto L_0x0106
                r7 = 4
                if (r11 == r7) goto L_0x00c6
                r7 = 0
                r11 = 0
                goto L_0x012e
            L_0x00c6:
                int r7 = r0.f14765g
                r11 = -2
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r11)
                int r8 = r1.mMatchConstraintDefaultHeight
                if (r8 != r14) goto L_0x00d3
                r8 = r14
                goto L_0x00d4
            L_0x00d3:
                r8 = 0
            L_0x00d4:
                int[] r11 = r1.wrapMeasure
                r12 = 0
                r11[r15] = r12
                boolean r12 = r2.useCurrentDimensions
                if (r12 == 0) goto L_0x0103
                if (r8 == 0) goto L_0x00eb
                r12 = r11[r5]
                if (r12 == 0) goto L_0x00eb
                r11 = r11[r14]
                int r12 = r20.getHeight()
                if (r11 != r12) goto L_0x00ef
            L_0x00eb:
                boolean r11 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r11 == 0) goto L_0x00f1
            L_0x00ef:
                r11 = r14
                goto L_0x00f2
            L_0x00f1:
                r11 = 0
            L_0x00f2:
                if (r8 == 0) goto L_0x00f6
                if (r11 == 0) goto L_0x0103
            L_0x00f6:
                int r7 = r20.getHeight()
                r8 = 1073741824(0x40000000, float:2.0)
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
            L_0x0100:
                r11 = r7
            L_0x0101:
                r7 = 0
                goto L_0x012e
            L_0x0103:
                r11 = r7
                r7 = r14
                goto L_0x012e
            L_0x0106:
                int r7 = r0.f14765g
                int r11 = r20.getVerticalMargin()
                int r8 = r8 + r11
                r11 = -1
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r11)
                int[] r8 = r1.wrapMeasure
                r8[r15] = r11
                goto L_0x0100
            L_0x0117:
                int r7 = r0.f14765g
                r11 = -2
                int r7 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r11)
                int[] r8 = r1.wrapMeasure
                r8[r15] = r11
                goto L_0x0103
            L_0x0123:
                r8 = 1073741824(0x40000000, float:2.0)
                int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r8)
                int[] r8 = r1.wrapMeasure
                r8[r15] = r7
                goto L_0x0101
            L_0x012e:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r8) goto L_0x0134
                r12 = r14
                goto L_0x0135
            L_0x0134:
                r12 = 0
            L_0x0135:
                if (r4 != r8) goto L_0x0139
                r8 = r14
                goto L_0x013a
            L_0x0139:
                r8 = 0
            L_0x013a:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r4 == r13) goto L_0x0145
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r4 != r15) goto L_0x0143
                goto L_0x0145
            L_0x0143:
                r4 = 0
                goto L_0x0146
            L_0x0145:
                r4 = r14
            L_0x0146:
                if (r3 == r13) goto L_0x014f
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r13 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r13) goto L_0x014d
                goto L_0x014f
            L_0x014d:
                r3 = 0
                goto L_0x0150
            L_0x014f:
                r3 = r14
            L_0x0150:
                r13 = 0
                if (r12 == 0) goto L_0x015b
                float r15 = r1.mDimensionRatio
                int r15 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
                if (r15 <= 0) goto L_0x015b
                r15 = r14
                goto L_0x015c
            L_0x015b:
                r15 = 0
            L_0x015c:
                if (r8 == 0) goto L_0x0166
                float r14 = r1.mDimensionRatio
                int r13 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
                if (r13 <= 0) goto L_0x0166
                r13 = 1
                goto L_0x0167
            L_0x0166:
                r13 = 0
            L_0x0167:
                android.view.ViewGroup$LayoutParams r14 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r14 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r14
                boolean r5 = r2.useCurrentDimensions
                if (r5 != 0) goto L_0x0186
                if (r12 == 0) goto L_0x0186
                int r5 = r1.mMatchConstraintDefaultWidth
                if (r5 != 0) goto L_0x0186
                if (r8 == 0) goto L_0x0186
                int r5 = r1.mMatchConstraintDefaultHeight
                if (r5 == 0) goto L_0x017e
                goto L_0x0186
            L_0x017e:
                r0 = 0
                r3 = 0
                r4 = 0
                r5 = -1
                r16 = 0
                goto L_0x0238
            L_0x0186:
                boolean r5 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r5 == 0) goto L_0x0198
                boolean r5 = r1 instanceof androidx.constraintlayout.solver.widgets.VirtualLayout
                if (r5 == 0) goto L_0x0198
                r5 = r1
                androidx.constraintlayout.solver.widgets.VirtualLayout r5 = (androidx.constraintlayout.solver.widgets.VirtualLayout) r5
                r8 = r10
                androidx.constraintlayout.widget.VirtualLayout r8 = (androidx.constraintlayout.widget.VirtualLayout) r8
                r8.onMeasure(r5, r6, r11)
                goto L_0x019b
            L_0x0198:
                r10.measure(r6, r11)
            L_0x019b:
                int r5 = r10.getMeasuredWidth()
                int r8 = r10.getMeasuredHeight()
                int r12 = r10.getBaseline()
                if (r9 == 0) goto L_0x01b4
                int[] r9 = r1.wrapMeasure
                r16 = 0
                r9[r16] = r5
                r18 = 2
                r9[r18] = r8
                goto L_0x01be
            L_0x01b4:
                r16 = 0
                r18 = 2
                int[] r9 = r1.wrapMeasure
                r9[r16] = r16
                r9[r18] = r16
            L_0x01be:
                if (r7 == 0) goto L_0x01ca
                int[] r7 = r1.wrapMeasure
                r9 = 1
                r7[r9] = r8
                r17 = 3
                r7[r17] = r5
                goto L_0x01d3
            L_0x01ca:
                r9 = 1
                r17 = 3
                int[] r7 = r1.wrapMeasure
                r7[r9] = r16
                r7[r17] = r16
            L_0x01d3:
                int r7 = r1.mMatchConstraintMinWidth
                if (r7 <= 0) goto L_0x01dc
                int r7 = java.lang.Math.max(r7, r5)
                goto L_0x01dd
            L_0x01dc:
                r7 = r5
            L_0x01dd:
                int r9 = r1.mMatchConstraintMaxWidth
                if (r9 <= 0) goto L_0x01e5
                int r7 = java.lang.Math.min(r9, r7)
            L_0x01e5:
                int r9 = r1.mMatchConstraintMinHeight
                if (r9 <= 0) goto L_0x01ee
                int r9 = java.lang.Math.max(r9, r8)
                goto L_0x01ef
            L_0x01ee:
                r9 = r8
            L_0x01ef:
                int r0 = r1.mMatchConstraintMaxHeight
                if (r0 <= 0) goto L_0x01f7
                int r9 = java.lang.Math.min(r0, r9)
            L_0x01f7:
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r15 == 0) goto L_0x0205
                if (r4 == 0) goto L_0x0205
                float r3 = r1.mDimensionRatio
                float r4 = (float) r9
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r0 = (int) r4
                r7 = r0
                goto L_0x0210
            L_0x0205:
                if (r13 == 0) goto L_0x0210
                if (r3 == 0) goto L_0x0210
                float r3 = r1.mDimensionRatio
                float r4 = (float) r7
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r0 = (int) r4
                r9 = r0
            L_0x0210:
                if (r5 != r7) goto L_0x021a
                if (r8 == r9) goto L_0x0215
                goto L_0x021a
            L_0x0215:
                r0 = r7
                r3 = r9
                r4 = r12
            L_0x0218:
                r5 = -1
                goto L_0x0238
            L_0x021a:
                r0 = 1073741824(0x40000000, float:2.0)
                if (r5 == r7) goto L_0x0222
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r0)
            L_0x0222:
                if (r8 == r9) goto L_0x0228
                int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r0)
            L_0x0228:
                r10.measure(r6, r11)
                int r0 = r10.getMeasuredWidth()
                int r3 = r10.getMeasuredHeight()
                int r4 = r10.getBaseline()
                goto L_0x0218
            L_0x0238:
                if (r4 == r5) goto L_0x023c
                r5 = 1
                goto L_0x023e
            L_0x023c:
                r5 = r16
            L_0x023e:
                int r6 = r2.horizontalDimension
                if (r0 != r6) goto L_0x024a
                int r6 = r2.verticalDimension
                if (r3 == r6) goto L_0x0247
                goto L_0x024a
            L_0x0247:
                r6 = r16
                goto L_0x024b
            L_0x024a:
                r6 = 1
            L_0x024b:
                r2.measuredNeedsSolverPass = r6
                boolean r6 = r14.needsBaseline
                if (r6 == 0) goto L_0x0253
                r9 = 1
                goto L_0x0254
            L_0x0253:
                r9 = r5
            L_0x0254:
                if (r9 == 0) goto L_0x0262
                r5 = -1
                if (r4 == r5) goto L_0x0262
                int r1 = r20.getBaselineDistance()
                if (r1 == r4) goto L_0x0262
                r1 = 1
                r2.measuredNeedsSolverPass = r1
            L_0x0262:
                r2.measuredWidth = r0
                r2.measuredHeight = r3
                r2.measuredHasBaseline = r9
                r2.measuredBaseline = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.measure(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure):void");
        }
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int max2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    private final ConstraintWidget getTargetWidget(int i10) {
        if (i10 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i10);
        if (view == null && (view = findViewById(i10)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    private void init(AttributeSet attributeSet, int i10, int i11) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i10, i11);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = obtainStyledAttributes.getIndex(i12);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i10));
            if (viewWidget != null) {
                viewWidget.reset();
            }
        }
        if (isInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).setDebugName(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.applyToInternal(this, true);
        }
        this.mLayoutWidget.removeAllChildren();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                this.mConstraintHelpers.get(i13).updatePreLayout(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt3 = getChildAt(i14);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).updatePreLayout(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt4 = getChildAt(i15);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt5 = getChildAt(i16);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.add(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            } else if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            setChildrenConstraints();
        }
        return z10;
    }

    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void applyConstraintsFromLayoutParams(boolean z10, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int i10;
        float f10;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        View view2 = view;
        ConstraintWidget constraintWidget6 = constraintWidget;
        LayoutParams layoutParams2 = layoutParams;
        SparseArray<ConstraintWidget> sparseArray2 = sparseArray;
        layoutParams.validate();
        layoutParams2.helped = false;
        constraintWidget6.setVisibility(view.getVisibility());
        if (layoutParams2.isInPlaceholder) {
            constraintWidget6.setInPlaceholder(true);
            constraintWidget6.setVisibility(8);
        }
        constraintWidget6.setCompanionWidget(view2);
        if (view2 instanceof ConstraintHelper) {
            ((ConstraintHelper) view2).resolveRtl(constraintWidget6, this.mLayoutWidget.isRtl());
        }
        if (layoutParams2.isGuideline) {
            Guideline guideline = (Guideline) constraintWidget6;
            int i11 = layoutParams2.resolvedGuideBegin;
            int i12 = layoutParams2.resolvedGuideEnd;
            float f11 = layoutParams2.resolvedGuidePercent;
            if (f11 != -1.0f) {
                guideline.setGuidePercent(f11);
            } else if (i11 != -1) {
                guideline.setGuideBegin(i11);
            } else if (i12 != -1) {
                guideline.setGuideEnd(i12);
            }
        } else {
            int i13 = layoutParams2.resolvedLeftToLeft;
            int i14 = layoutParams2.resolvedLeftToRight;
            int i15 = layoutParams2.resolvedRightToLeft;
            int i16 = layoutParams2.resolvedRightToRight;
            int i17 = layoutParams2.resolveGoneLeftMargin;
            int i18 = layoutParams2.resolveGoneRightMargin;
            float f12 = layoutParams2.resolvedHorizontalBias;
            int i19 = layoutParams2.circleConstraint;
            if (i19 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray2.get(i19);
                if (constraintWidget7 != null) {
                    constraintWidget6.connectCircularConstraint(constraintWidget7, layoutParams2.circleAngle, layoutParams2.circleRadius);
                }
            } else {
                if (i13 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray2.get(i13);
                    if (constraintWidget8 != null) {
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        f10 = f12;
                        constraintWidget.immediateConnect(type, constraintWidget8, type, layoutParams2.leftMargin, i17);
                    } else {
                        f10 = f12;
                    }
                } else {
                    f10 = f12;
                    if (!(i14 == -1 || (constraintWidget5 = sparseArray2.get(i14)) == null)) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, layoutParams2.leftMargin, i17);
                    }
                }
                if (i15 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray2.get(i15);
                    if (constraintWidget9 != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget9, ConstraintAnchor.Type.LEFT, layoutParams2.rightMargin, i18);
                    }
                } else if (!(i16 == -1 || (constraintWidget4 = sparseArray2.get(i16)) == null)) {
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.immediateConnect(type2, constraintWidget4, type2, layoutParams2.rightMargin, i18);
                }
                int i20 = layoutParams2.topToTop;
                if (i20 != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray2.get(i20);
                    if (constraintWidget10 != null) {
                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                        constraintWidget.immediateConnect(type3, constraintWidget10, type3, layoutParams2.topMargin, layoutParams2.goneTopMargin);
                    }
                } else {
                    int i21 = layoutParams2.topToBottom;
                    if (!(i21 == -1 || (constraintWidget3 = sparseArray2.get(i21)) == null)) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, layoutParams2.topMargin, layoutParams2.goneTopMargin);
                    }
                }
                int i22 = layoutParams2.bottomToTop;
                if (i22 != -1) {
                    ConstraintWidget constraintWidget11 = sparseArray2.get(i22);
                    if (constraintWidget11 != null) {
                        constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget11, ConstraintAnchor.Type.TOP, layoutParams2.bottomMargin, layoutParams2.goneBottomMargin);
                    }
                } else {
                    int i23 = layoutParams2.bottomToBottom;
                    if (!(i23 == -1 || (constraintWidget2 = sparseArray2.get(i23)) == null)) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                        constraintWidget.immediateConnect(type4, constraintWidget2, type4, layoutParams2.bottomMargin, layoutParams2.goneBottomMargin);
                    }
                }
                int i24 = layoutParams2.baselineToBaseline;
                if (i24 != -1) {
                    View view3 = this.mChildrenByIds.get(i24);
                    ConstraintWidget constraintWidget12 = sparseArray2.get(layoutParams2.baselineToBaseline);
                    if (!(constraintWidget12 == null || view3 == null || !(view3.getLayoutParams() instanceof LayoutParams))) {
                        LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                        layoutParams2.needsBaseline = true;
                        layoutParams3.needsBaseline = true;
                        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BASELINE;
                        constraintWidget6.getAnchor(type5).connect(constraintWidget12.getAnchor(type5), 0, -1, true);
                        constraintWidget6.setHasBaseline(true);
                        layoutParams3.widget.setHasBaseline(true);
                        constraintWidget6.getAnchor(ConstraintAnchor.Type.TOP).reset();
                        constraintWidget6.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
                    }
                }
                float f13 = f10;
                if (f13 >= 0.0f) {
                    constraintWidget6.setHorizontalBiasPercent(f13);
                }
                float f14 = layoutParams2.verticalBias;
                if (f14 >= 0.0f) {
                    constraintWidget6.setVerticalBiasPercent(f14);
                }
            }
            if (z10 && !((i10 = layoutParams2.editorAbsoluteX) == -1 && layoutParams2.editorAbsoluteY == -1)) {
                constraintWidget6.setOrigin(i10, layoutParams2.editorAbsoluteY);
            }
            if (layoutParams2.horizontalDimensionFixed) {
                constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.setWidth(layoutParams2.width);
                if (layoutParams2.width == -2) {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.width == -1) {
                if (layoutParams2.constrainedWidth) {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = layoutParams2.leftMargin;
                constraintWidget6.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = layoutParams2.rightMargin;
            } else {
                constraintWidget6.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.setWidth(0);
            }
            if (layoutParams2.verticalDimensionFixed) {
                constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.setHeight(layoutParams2.height);
                if (layoutParams2.height == -2) {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.height == -1) {
                if (layoutParams2.constrainedHeight) {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.getAnchor(ConstraintAnchor.Type.TOP).mMargin = layoutParams2.topMargin;
                constraintWidget6.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = layoutParams2.bottomMargin;
            } else {
                constraintWidget6.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.setHeight(0);
            }
            constraintWidget6.setDimensionRatio(layoutParams2.dimensionRatio);
            constraintWidget6.setHorizontalWeight(layoutParams2.horizontalWeight);
            constraintWidget6.setVerticalWeight(layoutParams2.verticalWeight);
            constraintWidget6.setHorizontalChainStyle(layoutParams2.horizontalChainStyle);
            constraintWidget6.setVerticalChainStyle(layoutParams2.verticalChainStyle);
            constraintWidget6.setHorizontalMatchStyle(layoutParams2.matchConstraintDefaultWidth, layoutParams2.matchConstraintMinWidth, layoutParams2.matchConstraintMaxWidth, layoutParams2.matchConstraintPercentWidth);
            constraintWidget6.setVerticalMatchStyle(layoutParams2.matchConstraintDefaultHeight, layoutParams2.matchConstraintMinHeight, layoutParams2.matchConstraintMaxHeight, layoutParams2.matchConstraintPercentHeight);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                this.mConstraintHelpers.get(i10).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i13 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f10 = (float) i12;
                        float f11 = (float) i13;
                        float f12 = (float) (i12 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f13 = f11;
                        float f14 = f11;
                        float f15 = f12;
                        float f16 = f10;
                        Paint paint2 = paint;
                        canvas2.drawLine(f10, f13, f15, f14, paint);
                        float parseInt4 = (float) (i13 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f17 = f12;
                        float f18 = parseInt4;
                        canvas2.drawLine(f17, f14, f15, f18, paint);
                        float f19 = parseInt4;
                        float f20 = f16;
                        canvas2.drawLine(f17, f19, f20, f18, paint);
                        float f21 = f16;
                        canvas2.drawLine(f21, f19, f20, f14, paint);
                        paint.setColor(-16711936);
                        float f22 = f12;
                        Paint paint3 = paint;
                        canvas2.drawLine(f21, f14, f22, parseInt4, paint);
                        canvas2.drawLine(f21, parseInt4, f22, f14, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int i10) {
        return this.mChildrenByIds.get(i10);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).widget;
    }

    /* access modifiers changed from: protected */
    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) == 0 || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i10) {
        if (i10 != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i10);
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.widget;
            if ((childAt.getVisibility() != 8 || layoutParams.isGuideline || layoutParams.isHelper || layoutParams.isVirtualGroup || isInEditMode) && !layoutParams.isInPlaceholder) {
                int x10 = constraintWidget.getX();
                int y10 = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x10;
                int height = constraintWidget.getHeight() + y10;
                childAt.layout(x10, y10, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x10, y10, width, height);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                this.mConstraintHelpers.get(i15).updatePostLayout(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        this.mOnMeasureWidthMeasureSpec = i10;
        this.mOnMeasureHeightMeasureSpec = i11;
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i10, i11);
        resolveMeasuredDimension(i10, i11, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.widget = guideline;
            layoutParams.isGuideline = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).isHelper = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i10);
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    /* access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        b bVar = this.mMeasurer;
        int i14 = bVar.f14763e;
        int resolveSizeAndState = View.resolveSizeAndState(i12 + bVar.f14762d, i10, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0);
        int i15 = resolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int i16 = resolveSizeAndState2 & ViewCompat.MEASURED_SIZE_MASK;
        int min = Math.min(this.mMaxWidth, i15);
        int min2 = Math.min(this.mMaxHeight, i16);
        if (z10) {
            min |= 16777216;
        }
        if (z11) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* access modifiers changed from: protected */
    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i14 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.a(i11, i12, max, max2, paddingWidth, i14);
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            i13 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i13 = max4;
        } else {
            i13 = max3;
        }
        int i15 = size - paddingWidth;
        int i16 = size2 - i14;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i15, mode2, i16);
        constraintWidgetContainer.measure(i10, mode, i15, mode2, i16, this.mLastMeasureWidth, this.mLastMeasureHeight, i13, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(DomExceptionUtils.SEPARATOR);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.mDesignIds.put(str, num);
        }
    }

    public void setId(int i10) {
        this.mChildrenByIds.remove(getId());
        super.setId(i10);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 != this.mMaxHeight) {
            this.mMaxHeight = i10;
            requestLayout();
        }
    }

    public void setMaxWidth(int i10) {
        if (i10 != this.mMaxWidth) {
            this.mMaxWidth = i10;
            requestLayout();
        }
    }

    public void setMinHeight(int i10) {
        if (i10 != this.mMinHeight) {
            this.mMinHeight = i10;
            requestLayout();
        }
    }

    public void setMinWidth(int i10) {
        if (i10 != this.mMinWidth) {
            this.mMinWidth = i10;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.mOptimizationLevel = i10;
        this.mLayoutWidget.setOptimizationLevel(i10);
    }

    /* access modifiers changed from: protected */
    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i10, int i11, int i12, int i13) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        b bVar = this.mMeasurer;
        int i14 = bVar.f14763e;
        int i15 = bVar.f14762d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i10 != Integer.MIN_VALUE) {
            if (i10 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i11 = Math.max(0, this.mMinWidth);
                }
            } else if (i10 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i11 = Math.min(this.mMaxWidth - i15, i11);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i11 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i11 = Math.max(0, this.mMinWidth);
            }
        }
        if (i12 != Integer.MIN_VALUE) {
            if (i12 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i13 = Math.max(0, this.mMinHeight);
                }
            } else if (i12 == 1073741824) {
                i13 = Math.min(this.mMaxHeight - i14, i13);
            }
            i13 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i13 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i11 == constraintWidgetContainer.getWidth() && i13 == constraintWidgetContainer.getHeight())) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.mMaxWidth - i15);
        constraintWidgetContainer.setMaxHeight(this.mMaxHeight - i14);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i11);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i13);
        constraintWidgetContainer.setMinWidth(this.mMinWidth - i15);
        constraintWidgetContainer.setMinHeight(this.mMinHeight - i14);
    }

    public void setState(int i10, int i11, int i12) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i10, (float) i11, (float) i12);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(attributeSet, i10, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        init(attributeSet, i10, i11);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int END = 7;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public int baselineToBaseline = -1;
        public int bottomToBottom = -1;
        public int bottomToTop = -1;
        public float circleAngle = 0.0f;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public boolean constrainedHeight = false;
        public boolean constrainedWidth = false;
        public String constraintTag = null;
        public String dimensionRatio = null;
        int dimensionRatioSide = 1;
        float dimensionRatioValue = 0.0f;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int endToEnd = -1;
        public int endToStart = -1;
        public int goneBottomMargin = -1;
        public int goneEndMargin = -1;
        public int goneLeftMargin = -1;
        public int goneRightMargin = -1;
        public int goneStartMargin = -1;
        public int goneTopMargin = -1;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean helped = false;
        public float horizontalBias = 0.5f;
        public int horizontalChainStyle = 0;
        boolean horizontalDimensionFixed = true;
        public float horizontalWeight = -1.0f;
        boolean isGuideline = false;
        boolean isHelper = false;
        boolean isInPlaceholder = false;
        boolean isVirtualGroup = false;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int matchConstraintDefaultHeight = 0;
        public int matchConstraintDefaultWidth = 0;
        public int matchConstraintMaxHeight = 0;
        public int matchConstraintMaxWidth = 0;
        public int matchConstraintMinHeight = 0;
        public int matchConstraintMinWidth = 0;
        public float matchConstraintPercentHeight = 1.0f;
        public float matchConstraintPercentWidth = 1.0f;
        boolean needsBaseline = false;
        public int orientation = -1;
        int resolveGoneLeftMargin = -1;
        int resolveGoneRightMargin = -1;
        int resolvedGuideBegin;
        int resolvedGuideEnd;
        float resolvedGuidePercent;
        float resolvedHorizontalBias = 0.5f;
        int resolvedLeftToLeft = -1;
        int resolvedLeftToRight = -1;
        int resolvedRightToLeft = -1;
        int resolvedRightToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int topToBottom = -1;
        public int topToTop = -1;
        public float verticalBias = 0.5f;
        public int verticalChainStyle = 0;
        boolean verticalDimensionFixed = true;
        public float verticalWeight = -1.0f;
        ConstraintWidget widget = new ConstraintWidget();

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f14757a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f14757a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = layoutParams.guideBegin;
            this.guideEnd = layoutParams.guideEnd;
            this.guidePercent = layoutParams.guidePercent;
            this.leftToLeft = layoutParams.leftToLeft;
            this.leftToRight = layoutParams.leftToRight;
            this.rightToLeft = layoutParams.rightToLeft;
            this.rightToRight = layoutParams.rightToRight;
            this.topToTop = layoutParams.topToTop;
            this.topToBottom = layoutParams.topToBottom;
            this.bottomToTop = layoutParams.bottomToTop;
            this.bottomToBottom = layoutParams.bottomToBottom;
            this.baselineToBaseline = layoutParams.baselineToBaseline;
            this.circleConstraint = layoutParams.circleConstraint;
            this.circleRadius = layoutParams.circleRadius;
            this.circleAngle = layoutParams.circleAngle;
            this.startToEnd = layoutParams.startToEnd;
            this.startToStart = layoutParams.startToStart;
            this.endToStart = layoutParams.endToStart;
            this.endToEnd = layoutParams.endToEnd;
            this.goneLeftMargin = layoutParams.goneLeftMargin;
            this.goneTopMargin = layoutParams.goneTopMargin;
            this.goneRightMargin = layoutParams.goneRightMargin;
            this.goneBottomMargin = layoutParams.goneBottomMargin;
            this.goneStartMargin = layoutParams.goneStartMargin;
            this.goneEndMargin = layoutParams.goneEndMargin;
            this.horizontalBias = layoutParams.horizontalBias;
            this.verticalBias = layoutParams.verticalBias;
            this.dimensionRatio = layoutParams.dimensionRatio;
            this.dimensionRatioValue = layoutParams.dimensionRatioValue;
            this.dimensionRatioSide = layoutParams.dimensionRatioSide;
            this.horizontalWeight = layoutParams.horizontalWeight;
            this.verticalWeight = layoutParams.verticalWeight;
            this.horizontalChainStyle = layoutParams.horizontalChainStyle;
            this.verticalChainStyle = layoutParams.verticalChainStyle;
            this.constrainedWidth = layoutParams.constrainedWidth;
            this.constrainedHeight = layoutParams.constrainedHeight;
            this.matchConstraintDefaultWidth = layoutParams.matchConstraintDefaultWidth;
            this.matchConstraintDefaultHeight = layoutParams.matchConstraintDefaultHeight;
            this.matchConstraintMinWidth = layoutParams.matchConstraintMinWidth;
            this.matchConstraintMaxWidth = layoutParams.matchConstraintMaxWidth;
            this.matchConstraintMinHeight = layoutParams.matchConstraintMinHeight;
            this.matchConstraintMaxHeight = layoutParams.matchConstraintMaxHeight;
            this.matchConstraintPercentWidth = layoutParams.matchConstraintPercentWidth;
            this.matchConstraintPercentHeight = layoutParams.matchConstraintPercentHeight;
            this.editorAbsoluteX = layoutParams.editorAbsoluteX;
            this.editorAbsoluteY = layoutParams.editorAbsoluteY;
            this.orientation = layoutParams.orientation;
            this.horizontalDimensionFixed = layoutParams.horizontalDimensionFixed;
            this.verticalDimensionFixed = layoutParams.verticalDimensionFixed;
            this.needsBaseline = layoutParams.needsBaseline;
            this.isGuideline = layoutParams.isGuideline;
            this.resolvedLeftToLeft = layoutParams.resolvedLeftToLeft;
            this.resolvedLeftToRight = layoutParams.resolvedLeftToRight;
            this.resolvedRightToLeft = layoutParams.resolvedRightToLeft;
            this.resolvedRightToRight = layoutParams.resolvedRightToRight;
            this.resolveGoneLeftMargin = layoutParams.resolveGoneLeftMargin;
            this.resolveGoneRightMargin = layoutParams.resolveGoneRightMargin;
            this.resolvedHorizontalBias = layoutParams.resolvedHorizontalBias;
            this.constraintTag = layoutParams.constraintTag;
            this.widget = layoutParams.widget;
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.widget;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.widget;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007c  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r10) {
            /*
                r9 = this;
                int r0 = r9.leftMargin
                int r1 = r9.rightMargin
                super.resolveLayoutDirection(r10)
                int r10 = r9.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r10) goto L_0x0011
                r10 = r3
                goto L_0x0012
            L_0x0011:
                r10 = r2
            L_0x0012:
                r4 = -1
                r9.resolvedRightToLeft = r4
                r9.resolvedRightToRight = r4
                r9.resolvedLeftToLeft = r4
                r9.resolvedLeftToRight = r4
                int r5 = r9.goneLeftMargin
                r9.resolveGoneLeftMargin = r5
                int r5 = r9.goneRightMargin
                r9.resolveGoneRightMargin = r5
                float r5 = r9.horizontalBias
                r9.resolvedHorizontalBias = r5
                int r6 = r9.guideBegin
                r9.resolvedGuideBegin = r6
                int r7 = r9.guideEnd
                r9.resolvedGuideEnd = r7
                float r8 = r9.guidePercent
                r9.resolvedGuidePercent = r8
                if (r10 == 0) goto L_0x008e
                int r10 = r9.startToEnd
                if (r10 == r4) goto L_0x003d
                r9.resolvedRightToLeft = r10
            L_0x003b:
                r2 = r3
                goto L_0x0044
            L_0x003d:
                int r10 = r9.startToStart
                if (r10 == r4) goto L_0x0044
                r9.resolvedRightToRight = r10
                goto L_0x003b
            L_0x0044:
                int r10 = r9.endToStart
                if (r10 == r4) goto L_0x004b
                r9.resolvedLeftToRight = r10
                r2 = r3
            L_0x004b:
                int r10 = r9.endToEnd
                if (r10 == r4) goto L_0x0052
                r9.resolvedLeftToLeft = r10
                r2 = r3
            L_0x0052:
                int r10 = r9.goneStartMargin
                if (r10 == r4) goto L_0x0058
                r9.resolveGoneRightMargin = r10
            L_0x0058:
                int r10 = r9.goneEndMargin
                if (r10 == r4) goto L_0x005e
                r9.resolveGoneLeftMargin = r10
            L_0x005e:
                r10 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0066
                float r2 = r10 - r5
                r9.resolvedHorizontalBias = r2
            L_0x0066:
                boolean r2 = r9.isGuideline
                if (r2 == 0) goto L_0x00b2
                int r2 = r9.orientation
                if (r2 != r3) goto L_0x00b2
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x007c
                float r10 = r10 - r8
                r9.resolvedGuidePercent = r10
                r9.resolvedGuideBegin = r4
                r9.resolvedGuideEnd = r4
                goto L_0x00b2
            L_0x007c:
                if (r6 == r4) goto L_0x0085
                r9.resolvedGuideEnd = r6
                r9.resolvedGuideBegin = r4
                r9.resolvedGuidePercent = r2
                goto L_0x00b2
            L_0x0085:
                if (r7 == r4) goto L_0x00b2
                r9.resolvedGuideBegin = r7
                r9.resolvedGuideEnd = r4
                r9.resolvedGuidePercent = r2
                goto L_0x00b2
            L_0x008e:
                int r10 = r9.startToEnd
                if (r10 == r4) goto L_0x0094
                r9.resolvedLeftToRight = r10
            L_0x0094:
                int r10 = r9.startToStart
                if (r10 == r4) goto L_0x009a
                r9.resolvedLeftToLeft = r10
            L_0x009a:
                int r10 = r9.endToStart
                if (r10 == r4) goto L_0x00a0
                r9.resolvedRightToLeft = r10
            L_0x00a0:
                int r10 = r9.endToEnd
                if (r10 == r4) goto L_0x00a6
                r9.resolvedRightToRight = r10
            L_0x00a6:
                int r10 = r9.goneStartMargin
                if (r10 == r4) goto L_0x00ac
                r9.resolveGoneLeftMargin = r10
            L_0x00ac:
                int r10 = r9.goneEndMargin
                if (r10 == r4) goto L_0x00b2
                r9.resolveGoneRightMargin = r10
            L_0x00b2:
                int r10 = r9.endToStart
                if (r10 != r4) goto L_0x00fc
                int r10 = r9.endToEnd
                if (r10 != r4) goto L_0x00fc
                int r10 = r9.startToStart
                if (r10 != r4) goto L_0x00fc
                int r10 = r9.startToEnd
                if (r10 != r4) goto L_0x00fc
                int r10 = r9.rightToLeft
                if (r10 == r4) goto L_0x00d1
                r9.resolvedRightToLeft = r10
                int r10 = r9.rightMargin
                if (r10 > 0) goto L_0x00df
                if (r1 <= 0) goto L_0x00df
                r9.rightMargin = r1
                goto L_0x00df
            L_0x00d1:
                int r10 = r9.rightToRight
                if (r10 == r4) goto L_0x00df
                r9.resolvedRightToRight = r10
                int r10 = r9.rightMargin
                if (r10 > 0) goto L_0x00df
                if (r1 <= 0) goto L_0x00df
                r9.rightMargin = r1
            L_0x00df:
                int r10 = r9.leftToLeft
                if (r10 == r4) goto L_0x00ee
                r9.resolvedLeftToLeft = r10
                int r10 = r9.leftMargin
                if (r10 > 0) goto L_0x00fc
                if (r0 <= 0) goto L_0x00fc
                r9.leftMargin = r0
                goto L_0x00fc
            L_0x00ee:
                int r10 = r9.leftToRight
                if (r10 == r4) goto L_0x00fc
                r9.resolvedLeftToRight = r10
                int r10 = r9.leftMargin
                if (r10 > 0) goto L_0x00fc
                if (r0 <= 0) goto L_0x00fc
                r9.leftMargin = r0
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public void setWidgetDebugName(String str) {
            this.widget.setDebugName(str);
        }

        public void validate() {
            this.isGuideline = false;
            this.horizontalDimensionFixed = true;
            this.verticalDimensionFixed = true;
            int i10 = this.width;
            if (i10 == -2 && this.constrainedWidth) {
                this.horizontalDimensionFixed = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i11 = this.height;
            if (i11 == -2 && this.constrainedHeight) {
                this.verticalDimensionFixed = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.horizontalDimensionFixed = false;
                if (i10 == 0 && this.matchConstraintDefaultWidth == 1) {
                    this.width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.verticalDimensionFixed = false;
                if (i11 == 0 && this.matchConstraintDefaultHeight == 1) {
                    this.height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.isGuideline = true;
                this.horizontalDimensionFixed = true;
                this.verticalDimensionFixed = true;
                if (!(this.widget instanceof Guideline)) {
                    this.widget = new Guideline();
                }
                ((Guideline) this.widget).setOrientation(this.orientation);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i10;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = a.f14757a.get(index);
                switch (i12) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f10 = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f10;
                        if (f10 >= 0.0f) {
                            break;
                        } else {
                            this.circleAngle = (360.0f - f10) % 360.0f;
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i13;
                        if (i13 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i14;
                        if (i14 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinWidth = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            }
                        }
                    case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                        this.matchConstraintPercentWidth = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMinHeight = -2;
                                break;
                            }
                        }
                    case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) != -2) {
                                break;
                            } else {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            }
                        }
                    case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                        this.matchConstraintPercentHeight = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i12) {
                            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                                String string = obtainStyledAttributes.getString(index);
                                this.dimensionRatio = string;
                                this.dimensionRatioValue = Float.NaN;
                                this.dimensionRatioSide = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.dimensionRatio.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i10 = 0;
                                    } else {
                                        String substring = this.dimensionRatio.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                                            this.dimensionRatioSide = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.dimensionRatioSide = 1;
                                        }
                                        i10 = indexOf + 1;
                                    }
                                    int indexOf2 = this.dimensionRatio.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.dimensionRatio.substring(i10, indexOf2);
                                        String substring3 = this.dimensionRatio.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.dimensionRatioSide != 1) {
                                                        this.dimensionRatioValue = Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    } else {
                                                        this.dimensionRatioValue = Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.dimensionRatio.substring(i10);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            this.dimensionRatioValue = Float.parseFloat(substring4);
                                            break;
                                        }
                                    }
                                }
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
