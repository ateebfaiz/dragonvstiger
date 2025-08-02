package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ConstraintReference implements Reference {
    private Object key;
    Object mBaselineToBaseline = null;
    Object mBottomToBottom = null;
    Object mBottomToTop = null;
    private ConstraintWidget mConstraintWidget;
    Object mEndToEnd = null;
    Object mEndToStart = null;
    float mHorizontalBias = 0.5f;
    int mHorizontalChainStyle = 0;
    Dimension mHorizontalDimension;
    State.Constraint mLast = null;
    Object mLeftToLeft = null;
    Object mLeftToRight = null;
    int mMarginBottom = 0;
    int mMarginBottomGone = 0;
    int mMarginEnd = 0;
    int mMarginEndGone = 0;
    int mMarginLeft = 0;
    int mMarginLeftGone = 0;
    int mMarginRight = 0;
    int mMarginRightGone = 0;
    int mMarginStart = 0;
    int mMarginStartGone = 0;
    int mMarginTop = 0;
    int mMarginTopGone = 0;
    Object mRightToLeft = null;
    Object mRightToRight = null;
    Object mStartToEnd = null;
    Object mStartToStart = null;
    final State mState;
    Object mTopToBottom = null;
    Object mTopToTop = null;
    float mVerticalBias = 0.5f;
    int mVerticalChainStyle = 0;
    Dimension mVerticalDimension;
    private Object mView;

    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14688a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|32) */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.state.State$Constraint[] r0 = androidx.constraintlayout.solver.state.State.Constraint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14688a = r0
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.LEFT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.RIGHT_TO_RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.START_TO_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.START_TO_END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.END_TO_START     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.END_TO_END     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_TOP     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.TOP_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_TOP     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.BOTTOM_TO_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.BASELINE_TO_BASELINE     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.CENTER_HORIZONTALLY     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f14688a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.constraintlayout.solver.state.State$Constraint r1 = androidx.constraintlayout.solver.state.State.Constraint.CENTER_VERTICALLY     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.state.ConstraintReference.a.<clinit>():void");
        }
    }

    class b extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f14689a;

        public b(ArrayList arrayList) {
            this.f14689a = arrayList;
        }

        public String toString() {
            return "IncorrectConstraintException: " + this.f14689a.toString();
        }
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = Dimension.Fixed(obj);
        this.mVerticalDimension = Dimension.Fixed(obj);
        this.mState = state;
    }

    private void applyConnection(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget target = getTarget(obj);
        if (target != null) {
            int[] iArr = a.f14688a;
            int i10 = iArr[constraint.ordinal()];
            switch (iArr[constraint.ordinal()]) {
                case 1:
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type).connect(target.getAnchor(type), this.mMarginLeft, this.mMarginLeftGone, false);
                    return;
                case 2:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
                    return;
                case 3:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
                    return;
                case 4:
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type2).connect(target.getAnchor(type2), this.mMarginRight, this.mMarginRightGone, false);
                    return;
                case 5:
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                    constraintWidget.getAnchor(type3).connect(target.getAnchor(type3), this.mMarginStart, this.mMarginStartGone, false);
                    return;
                case 6:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(target.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
                    return;
                case 7:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(target.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
                    return;
                case 8:
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.getAnchor(type4).connect(target.getAnchor(type4), this.mMarginEnd, this.mMarginEndGone, false);
                    return;
                case 9:
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                    constraintWidget.getAnchor(type5).connect(target.getAnchor(type5), this.mMarginTop, this.mMarginTopGone, false);
                    return;
                case 10:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(target.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
                    return;
                case 11:
                    constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(target.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
                    return;
                case 12:
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.getAnchor(type6).connect(target.getAnchor(type6), this.mMarginBottom, this.mMarginBottomGone, false);
                    return;
                case 13:
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                    constraintWidget.immediateConnect(type7, target, type7, 0, 0);
                    return;
                default:
                    return;
            }
        }
    }

    private void dereference() {
        this.mLeftToLeft = get(this.mLeftToLeft);
        this.mLeftToRight = get(this.mLeftToRight);
        this.mRightToLeft = get(this.mRightToLeft);
        this.mRightToRight = get(this.mRightToRight);
        this.mStartToStart = get(this.mStartToStart);
        this.mStartToEnd = get(this.mStartToEnd);
        this.mEndToStart = get(this.mEndToStart);
        this.mEndToEnd = get(this.mEndToEnd);
        this.mTopToTop = get(this.mTopToTop);
        this.mTopToBottom = get(this.mTopToBottom);
        this.mBottomToTop = get(this.mBottomToTop);
        this.mBottomToBottom = get(this.mBottomToBottom);
        this.mBaselineToBaseline = get(this.mBaselineToBaseline);
    }

    private Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof ConstraintReference)) {
            return this.mState.reference(obj);
        }
        return obj;
    }

    private ConstraintWidget getTarget(Object obj) {
        if (obj instanceof Reference) {
            return ((Reference) obj).getConstraintWidget();
        }
        return null;
    }

    public void apply() {
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            this.mHorizontalDimension.apply(this.mState, constraintWidget, 0);
            this.mVerticalDimension.apply(this.mState, this.mConstraintWidget, 1);
            dereference();
            applyConnection(this.mConstraintWidget, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
            applyConnection(this.mConstraintWidget, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
            applyConnection(this.mConstraintWidget, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
            applyConnection(this.mConstraintWidget, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
            applyConnection(this.mConstraintWidget, this.mStartToStart, State.Constraint.START_TO_START);
            applyConnection(this.mConstraintWidget, this.mStartToEnd, State.Constraint.START_TO_END);
            applyConnection(this.mConstraintWidget, this.mEndToStart, State.Constraint.END_TO_START);
            applyConnection(this.mConstraintWidget, this.mEndToEnd, State.Constraint.END_TO_END);
            applyConnection(this.mConstraintWidget, this.mTopToTop, State.Constraint.TOP_TO_TOP);
            applyConnection(this.mConstraintWidget, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
            applyConnection(this.mConstraintWidget, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
            applyConnection(this.mConstraintWidget, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
            applyConnection(this.mConstraintWidget, this.mBaselineToBaseline, State.Constraint.BASELINE_TO_BASELINE);
            int i10 = this.mHorizontalChainStyle;
            if (i10 != 0) {
                this.mConstraintWidget.setHorizontalChainStyle(i10);
            }
            int i11 = this.mVerticalChainStyle;
            if (i11 != 0) {
                this.mConstraintWidget.setVerticalChainStyle(i11);
            }
            this.mConstraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
            this.mConstraintWidget.setVerticalBiasPercent(this.mVerticalBias);
        }
    }

    public ConstraintReference baseline() {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.mLast = State.Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = obj;
        return this;
    }

    public ConstraintReference bias(float f10) {
        State.Constraint constraint = this.mLast;
        if (constraint == null) {
            return this;
        }
        switch (a.f14688a[constraint.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 14:
                this.mHorizontalBias = f10;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
            case 15:
                this.mVerticalBias = f10;
                break;
        }
        return this;
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop != null) {
            this.mLast = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.mLast = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object obj2 = get(obj);
        this.mStartToStart = obj2;
        this.mEndToEnd = obj2;
        this.mLast = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object obj2 = get(obj);
        this.mTopToTop = obj2;
        this.mBottomToBottom = obj2;
        this.mLast = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (a.f14688a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                case 3:
                case 4:
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                case 5:
                case 6:
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                case 7:
                case 8:
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                case 9:
                case 10:
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                case 11:
                case 12:
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.mMarginBottom = 0;
                    this.mMarginBottomGone = 0;
                    break;
                case 13:
                    this.mBaselineToBaseline = null;
                    break;
            }
        } else {
            this.mLeftToLeft = null;
            this.mLeftToRight = null;
            this.mMarginLeft = 0;
            this.mRightToLeft = null;
            this.mRightToRight = null;
            this.mMarginRight = 0;
            this.mStartToStart = null;
            this.mStartToEnd = null;
            this.mMarginStart = 0;
            this.mEndToStart = null;
            this.mEndToEnd = null;
            this.mMarginEnd = 0;
            this.mTopToTop = null;
            this.mTopToBottom = null;
            this.mMarginTop = 0;
            this.mBottomToTop = null;
            this.mBottomToBottom = null;
            this.mMarginBottom = 0;
            this.mBaselineToBaseline = null;
            this.mHorizontalBias = 0.5f;
            this.mVerticalBias = 0.5f;
            this.mMarginLeftGone = 0;
            this.mMarginRightGone = 0;
            this.mMarginStartGone = 0;
            this.mMarginEndGone = 0;
            this.mMarginTopGone = 0;
            this.mMarginBottomGone = 0;
        }
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().getValue(), getHeight().getValue());
    }

    public ConstraintReference end() {
        if (this.mEndToStart != null) {
            this.mLast = State.Constraint.END_TO_START;
        } else {
            this.mLast = State.Constraint.END_TO_END;
        }
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.mLast = State.Constraint.END_TO_END;
        this.mEndToEnd = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.mLast = State.Constraint.END_TO_START;
        this.mEndToStart = obj;
        return this;
    }

    public ConstraintWidget getConstraintWidget() {
        if (this.mConstraintWidget == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.mConstraintWidget = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.mView);
        }
        return this.mConstraintWidget;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public Object getKey() {
        return this.key;
    }

    public int getVerticalChainStyle(int i10) {
        return this.mVerticalChainStyle;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f10) {
        this.mHorizontalBias = f10;
        return this;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft != null) {
            this.mLast = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.mLast = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.mLast = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = obj;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.mState.convertDimension(obj));
    }

    public ConstraintReference marginGone(int i10) {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (a.f14688a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeftGone = i10;
                    break;
                case 3:
                case 4:
                    this.mMarginRightGone = i10;
                    break;
                case 5:
                case 6:
                    this.mMarginStartGone = i10;
                    break;
                case 7:
                case 8:
                    this.mMarginEndGone = i10;
                    break;
                case 9:
                case 10:
                    this.mMarginTopGone = i10;
                    break;
                case 11:
                case 12:
                    this.mMarginBottomGone = i10;
                    break;
            }
        } else {
            this.mMarginLeftGone = i10;
            this.mMarginRightGone = i10;
            this.mMarginStartGone = i10;
            this.mMarginEndGone = i10;
            this.mMarginTopGone = i10;
            this.mMarginBottomGone = i10;
        }
        return this;
    }

    public ConstraintReference right() {
        if (this.mRightToLeft != null) {
            this.mLast = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.mLast = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = obj;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget != null) {
            this.mConstraintWidget = constraintWidget;
            constraintWidget.setCompanionWidget(this.mView);
        }
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.mVerticalDimension = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i10) {
        this.mHorizontalChainStyle = i10;
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    public void setVerticalChainStyle(int i10) {
        this.mVerticalChainStyle = i10;
    }

    public void setView(Object obj) {
        this.mView = obj;
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.mHorizontalDimension = dimension;
        return this;
    }

    public ConstraintReference start() {
        if (this.mStartToStart != null) {
            this.mLast = State.Constraint.START_TO_START;
        } else {
            this.mLast = State.Constraint.START_TO_END;
        }
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.mLast = State.Constraint.START_TO_END;
        this.mStartToEnd = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.mLast = State.Constraint.START_TO_START;
        this.mStartToStart = obj;
        return this;
    }

    public ConstraintReference top() {
        if (this.mTopToTop != null) {
            this.mLast = State.Constraint.TOP_TO_TOP;
        } else {
            this.mLast = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.mLast = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.mLast = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = obj;
        return this;
    }

    public void validate() throws b {
        ArrayList arrayList = new ArrayList();
        if (!(this.mLeftToLeft == null || this.mLeftToRight == null)) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (!(this.mRightToLeft == null || this.mRightToRight == null)) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (!(this.mStartToStart == null || this.mStartToEnd == null)) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (!(this.mEndToStart == null || this.mEndToEnd == null)) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if (!((this.mLeftToLeft == null && this.mLeftToRight == null && this.mRightToLeft == null && this.mRightToRight == null) || (this.mStartToStart == null && this.mStartToEnd == null && this.mEndToStart == null && this.mEndToEnd == null))) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() > 0) {
            throw new b(arrayList);
        }
    }

    public ConstraintReference verticalBias(float f10) {
        this.mVerticalBias = f10;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }

    public ConstraintReference margin(int i10) {
        State.Constraint constraint = this.mLast;
        if (constraint != null) {
            switch (a.f14688a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeft = i10;
                    break;
                case 3:
                case 4:
                    this.mMarginRight = i10;
                    break;
                case 5:
                case 6:
                    this.mMarginStart = i10;
                    break;
                case 7:
                case 8:
                    this.mMarginEnd = i10;
                    break;
                case 9:
                case 10:
                    this.mMarginTop = i10;
                    break;
                case 11:
                case 12:
                    this.mMarginBottom = i10;
                    break;
            }
        } else {
            this.mMarginLeft = i10;
            this.mMarginRight = i10;
            this.mMarginStart = i10;
            this.mMarginEnd = i10;
            this.mMarginTop = i10;
            this.mMarginBottom = i10;
        }
        return this;
    }
}
