package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList<>();

    public ChainRun(ConstraintWidget constraintWidget, int i10) {
        super(constraintWidget);
        this.orientation = i10;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        int i10;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            }
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i11 = this.orientation;
            if (i11 == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i11 == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl() && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        if (this.orientation == 0) {
            i10 = this.widget.getHorizontalChainStyle();
        } else {
            i10 = this.widget.getVerticalChainStyle();
        }
        this.chainStyle = i10;
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i10 = 0; i10 < this.widgets.size(); i10++) {
            WidgetRun widgetRun = this.widgets.get(i10);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = this.widgets.get(0).widget;
            ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
            if (this.orientation == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
                DependencyNode target = getTarget(constraintAnchor, 0);
                int margin = constraintAnchor.getMargin();
                ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
                if (firstVisibleWidget != null) {
                    margin = firstVisibleWidget.mLeft.getMargin();
                }
                if (target != null) {
                    addTarget(this.start, target, margin);
                }
                DependencyNode target2 = getTarget(constraintAnchor2, 0);
                int margin2 = constraintAnchor2.getMargin();
                ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
                if (lastVisibleWidget != null) {
                    margin2 = lastVisibleWidget.mRight.getMargin();
                }
                if (target2 != null) {
                    addTarget(this.end, target2, -margin2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
                DependencyNode target3 = getTarget(constraintAnchor3, 1);
                int margin3 = constraintAnchor3.getMargin();
                ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
                if (firstVisibleWidget2 != null) {
                    margin3 = firstVisibleWidget2.mTop.getMargin();
                }
                if (target3 != null) {
                    addTarget(this.start, target3, margin3);
                }
                DependencyNode target4 = getTarget(constraintAnchor4, 1);
                int margin4 = constraintAnchor4.getMargin();
                ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
                if (lastVisibleWidget2 != null) {
                    margin4 = lastVisibleWidget2.mBottom.getMargin();
                }
                if (target4 != null) {
                    addTarget(this.end, target4, -margin4);
                }
            }
            this.start.updateDelegate = this;
            this.end.updateDelegate = this;
        }
    }

    public void applyToWidget() {
        for (int i10 = 0; i10 < this.widgets.size(); i10++) {
            this.widgets.get(i10).applyToWidget();
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public long getWrapDimension() {
        int size = this.widgets.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            WidgetRun widgetRun = this.widgets.get(i10);
            j10 = j10 + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return j10;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.widgets.get(i10).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChainRun ");
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb2.append(str);
        String sb3 = sb2.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            sb3 = ((sb3 + "<") + it.next()) + "> ";
        }
        return sb3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ad, code lost:
        if (r1 != r7) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01d3, code lost:
        if (r1 != r7) goto L_0x01d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.solver.widgets.analyzer.Dependency r26) {
        /*
            r25 = this;
            r0 = r25
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.start
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x043d
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.end
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0010
            goto L_0x043d
        L_0x0010:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.widget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.getParent()
            if (r1 == 0) goto L_0x0023
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
            if (r3 == 0) goto L_0x0023
            androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r1 = (androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer) r1
            boolean r1 = r1.isRtl()
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r0.end
            int r3 = r3.value
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r0.start
            int r4 = r4.value
            int r3 = r3 - r4
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r0.widgets
            int r4 = r4.size()
            r5 = 0
        L_0x0034:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004c
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r8 = r0.widgets
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r8.widget
            int r8 = r8.getVisibility()
            if (r8 != r7) goto L_0x004d
            int r5 = r5 + 1
            goto L_0x0034
        L_0x004c:
            r5 = r6
        L_0x004d:
            int r8 = r4 + -1
            r9 = r8
        L_0x0050:
            if (r9 < 0) goto L_0x0066
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.widgets
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.widget
            int r10 = r10.getVisibility()
            if (r10 != r7) goto L_0x0065
            int r9 = r9 + -1
            goto L_0x0050
        L_0x0065:
            r6 = r9
        L_0x0066:
            r9 = 0
        L_0x0067:
            r11 = 2
            if (r9 >= r11) goto L_0x010b
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0071:
            if (r13 >= r4) goto L_0x00fd
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r2 = r0.widgets
            java.lang.Object r2 = r2.get(r13)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r2.widget
            int r11 = r11.getVisibility()
            if (r11 != r7) goto L_0x0085
            goto L_0x00f6
        L_0x0085:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0090
            if (r13 < r5) goto L_0x0090
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r11 = r2.start
            int r11 = r11.margin
            int r14 = r14 + r11
        L_0x0090:
            androidx.constraintlayout.solver.widgets.analyzer.b r11 = r2.dimension
            int r7 = r11.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = r2.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r10 == r12) goto L_0x009c
            r10 = 1
            goto L_0x009d
        L_0x009c:
            r10 = 0
        L_0x009d:
            if (r10 == 0) goto L_0x00bf
            int r11 = r0.orientation
            if (r11 != 0) goto L_0x00ae
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r2.widget
            androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun r12 = r12.horizontalRun
            androidx.constraintlayout.solver.widgets.analyzer.b r12 = r12.dimension
            boolean r12 = r12.resolved
            if (r12 != 0) goto L_0x00ae
            return
        L_0x00ae:
            r12 = 1
            if (r11 != r12) goto L_0x00bc
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r2.widget
            androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun r11 = r11.verticalRun
            androidx.constraintlayout.solver.widgets.analyzer.b r11 = r11.dimension
            boolean r11 = r11.resolved
            if (r11 != 0) goto L_0x00bc
            return
        L_0x00bc:
            r19 = r7
            goto L_0x00d5
        L_0x00bf:
            r19 = r7
            r12 = 1
            int r7 = r2.matchConstraintsType
            if (r7 != r12) goto L_0x00ce
            if (r9 != 0) goto L_0x00ce
            int r7 = r11.f14736a
            int r15 = r15 + 1
        L_0x00cc:
            r10 = 1
            goto L_0x00d7
        L_0x00ce:
            boolean r7 = r11.resolved
            if (r7 == 0) goto L_0x00d5
            r7 = r19
            goto L_0x00cc
        L_0x00d5:
            r7 = r19
        L_0x00d7:
            if (r10 != 0) goto L_0x00eb
            int r15 = r15 + 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.widget
            float[] r7 = r7.mWeight
            int r10 = r0.orientation
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00ec
            float r17 = r17 + r7
            goto L_0x00ec
        L_0x00eb:
            int r14 = r14 + r7
        L_0x00ec:
            if (r13 >= r8) goto L_0x00f6
            if (r13 >= r6) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.margin
            int r2 = -r2
            int r14 = r14 + r2
        L_0x00f6:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x0071
        L_0x00fd:
            if (r14 < r3) goto L_0x0108
            if (r15 != 0) goto L_0x0102
            goto L_0x0108
        L_0x0102:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0067
        L_0x0108:
            r2 = r16
            goto L_0x0110
        L_0x010b:
            r2 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x0110:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.start
            int r7 = r7.value
            if (r1 == 0) goto L_0x011a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.end
            int r7 = r7.value
        L_0x011a:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r3) goto L_0x0131
            r10 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x012a
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 + r10
            goto L_0x0131
        L_0x012a:
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            int r7 = r7 - r10
        L_0x0131:
            if (r15 <= 0) goto L_0x023b
            int r10 = r3 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r12 = 0
            r13 = 0
        L_0x013d:
            if (r12 >= r4) goto L_0x01ef
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r9 = r9.get(r12)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r9
            r19 = r11
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r9.widget
            int r11 = r11.getVisibility()
            r20 = r14
            r14 = 8
            if (r11 != r14) goto L_0x015f
        L_0x0155:
            r23 = r1
            r24 = r2
            r21 = r7
            r22 = r10
            goto L_0x01dd
        L_0x015f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r14) goto L_0x0155
            androidx.constraintlayout.solver.widgets.analyzer.b r11 = r9.dimension
            boolean r14 = r11.resolved
            if (r14 != 0) goto L_0x0155
            r14 = 0
            int r18 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r18 <= 0) goto L_0x0182
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r9.widget
            float[] r14 = r14.mWeight
            r21 = r7
            int r7 = r0.orientation
            r7 = r14[r7]
            float r7 = r7 * r10
            float r7 = r7 / r17
            r14 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 + r14
            int r7 = (int) r7
            goto L_0x0186
        L_0x0182:
            r21 = r7
            r7 = r19
        L_0x0186:
            int r14 = r0.orientation
            if (r14 != 0) goto L_0x01b0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r14 = r9.widget
            r22 = r10
            int r10 = r14.mMatchConstraintMaxWidth
            int r14 = r14.mMatchConstraintMinWidth
            r23 = r1
            int r1 = r9.matchConstraintsType
            r24 = r2
            r2 = 1
            if (r1 != r2) goto L_0x01a2
            int r1 = r11.f14736a
            int r1 = java.lang.Math.min(r7, r1)
            goto L_0x01a3
        L_0x01a2:
            r1 = r7
        L_0x01a3:
            int r1 = java.lang.Math.max(r14, r1)
            if (r10 <= 0) goto L_0x01ad
            int r1 = java.lang.Math.min(r10, r1)
        L_0x01ad:
            if (r1 == r7) goto L_0x01d8
            goto L_0x01d5
        L_0x01b0:
            r23 = r1
            r24 = r2
            r22 = r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r9.widget
            int r2 = r1.mMatchConstraintMaxHeight
            int r1 = r1.mMatchConstraintMinHeight
            int r10 = r9.matchConstraintsType
            r14 = 1
            if (r10 != r14) goto L_0x01c8
            int r10 = r11.f14736a
            int r10 = java.lang.Math.min(r7, r10)
            goto L_0x01c9
        L_0x01c8:
            r10 = r7
        L_0x01c9:
            int r1 = java.lang.Math.max(r1, r10)
            if (r2 <= 0) goto L_0x01d3
            int r1 = java.lang.Math.min(r2, r1)
        L_0x01d3:
            if (r1 == r7) goto L_0x01d8
        L_0x01d5:
            int r13 = r13 + 1
            r7 = r1
        L_0x01d8:
            androidx.constraintlayout.solver.widgets.analyzer.b r1 = r9.dimension
            r1.resolve(r7)
        L_0x01dd:
            int r12 = r12 + 1
            r11 = r19
            r14 = r20
            r7 = r21
            r10 = r22
            r1 = r23
            r2 = r24
            r9 = 1056964608(0x3f000000, float:0.5)
            goto L_0x013d
        L_0x01ef:
            r23 = r1
            r24 = r2
            r21 = r7
            r20 = r14
            if (r13 <= 0) goto L_0x022c
            int r15 = r15 - r13
            r1 = 0
            r14 = 0
        L_0x01fc:
            if (r1 >= r4) goto L_0x022e
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r2 = r0.widgets
            java.lang.Object r2 = r2.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.widget
            int r7 = r7.getVisibility()
            r9 = 8
            if (r7 != r9) goto L_0x0211
            goto L_0x0229
        L_0x0211:
            if (r1 <= 0) goto L_0x021a
            if (r1 < r5) goto L_0x021a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r2.start
            int r7 = r7.margin
            int r14 = r14 + r7
        L_0x021a:
            androidx.constraintlayout.solver.widgets.analyzer.b r7 = r2.dimension
            int r7 = r7.value
            int r14 = r14 + r7
            if (r1 >= r8) goto L_0x0229
            if (r1 >= r6) goto L_0x0229
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.end
            int r2 = r2.margin
            int r2 = -r2
            int r14 = r14 + r2
        L_0x0229:
            int r1 = r1 + 1
            goto L_0x01fc
        L_0x022c:
            r14 = r20
        L_0x022e:
            int r1 = r0.chainStyle
            r2 = 2
            if (r1 != r2) goto L_0x0239
            if (r13 != 0) goto L_0x0239
            r1 = 0
            r0.chainStyle = r1
            goto L_0x0245
        L_0x0239:
            r1 = 0
            goto L_0x0245
        L_0x023b:
            r23 = r1
            r24 = r2
            r21 = r7
            r20 = r14
            r1 = 0
            r2 = 2
        L_0x0245:
            if (r14 <= r3) goto L_0x0249
            r0.chainStyle = r2
        L_0x0249:
            if (r24 <= 0) goto L_0x0251
            if (r15 != 0) goto L_0x0251
            if (r5 != r6) goto L_0x0251
            r0.chainStyle = r2
        L_0x0251:
            int r2 = r0.chainStyle
            r7 = 1
            if (r2 != r7) goto L_0x02f6
            r9 = r24
            if (r9 <= r7) goto L_0x025f
            int r3 = r3 - r14
            int r2 = r9 + -1
            int r3 = r3 / r2
            goto L_0x0266
        L_0x025f:
            if (r9 != r7) goto L_0x0265
            int r3 = r3 - r14
            r2 = 2
            int r3 = r3 / r2
            goto L_0x0266
        L_0x0265:
            r3 = r1
        L_0x0266:
            if (r15 <= 0) goto L_0x0269
            r3 = r1
        L_0x0269:
            r2 = r1
            r7 = r21
        L_0x026c:
            if (r2 >= r4) goto L_0x043d
            if (r23 == 0) goto L_0x0275
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x0276
        L_0x0275:
            r1 = r2
        L_0x0276:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r1.widget
            int r9 = r9.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x0293
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            goto L_0x02f2
        L_0x0293:
            if (r2 <= 0) goto L_0x029a
            if (r23 == 0) goto L_0x0299
            int r7 = r7 - r3
            goto L_0x029a
        L_0x0299:
            int r7 = r7 + r3
        L_0x029a:
            if (r2 <= 0) goto L_0x02ab
            if (r2 < r5) goto L_0x02ab
            if (r23 == 0) goto L_0x02a6
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 - r9
            goto L_0x02ab
        L_0x02a6:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 + r9
        L_0x02ab:
            if (r23 == 0) goto L_0x02b3
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
            goto L_0x02b8
        L_0x02b3:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
        L_0x02b8:
            androidx.constraintlayout.solver.widgets.analyzer.b r9 = r1.dimension
            int r10 = r9.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02c9
            int r11 = r1.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x02c9
            int r10 = r9.f14736a
        L_0x02c9:
            if (r23 == 0) goto L_0x02cd
            int r7 = r7 - r10
            goto L_0x02ce
        L_0x02cd:
            int r7 = r7 + r10
        L_0x02ce:
            if (r23 == 0) goto L_0x02d7
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
        L_0x02d5:
            r9 = 1
            goto L_0x02dd
        L_0x02d7:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
            goto L_0x02d5
        L_0x02dd:
            r1.resolved = r9
            if (r2 >= r8) goto L_0x02f2
            if (r2 >= r6) goto L_0x02f2
            if (r23 == 0) goto L_0x02ec
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x02f2
        L_0x02ec:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x02f2:
            int r2 = r2 + 1
            goto L_0x026c
        L_0x02f6:
            r9 = r24
            if (r2 != 0) goto L_0x038d
            int r3 = r3 - r14
            r2 = 1
            int r7 = r9 + 1
            int r3 = r3 / r7
            if (r15 <= 0) goto L_0x0302
            r3 = r1
        L_0x0302:
            r2 = r1
            r7 = r21
        L_0x0305:
            if (r2 >= r4) goto L_0x043d
            if (r23 == 0) goto L_0x030e
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x030f
        L_0x030e:
            r1 = r2
        L_0x030f:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.widgets
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r1.widget
            int r9 = r9.getVisibility()
            r10 = 8
            if (r9 != r10) goto L_0x032c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            goto L_0x0389
        L_0x032c:
            if (r23 == 0) goto L_0x0330
            int r7 = r7 - r3
            goto L_0x0331
        L_0x0330:
            int r7 = r7 + r3
        L_0x0331:
            if (r2 <= 0) goto L_0x0342
            if (r2 < r5) goto L_0x0342
            if (r23 == 0) goto L_0x033d
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 - r9
            goto L_0x0342
        L_0x033d:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            int r9 = r9.margin
            int r7 = r7 + r9
        L_0x0342:
            if (r23 == 0) goto L_0x034a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
            goto L_0x034f
        L_0x034a:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
        L_0x034f:
            androidx.constraintlayout.solver.widgets.analyzer.b r9 = r1.dimension
            int r10 = r9.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x0364
            int r11 = r1.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x0364
            int r9 = r9.f14736a
            int r10 = java.lang.Math.min(r10, r9)
        L_0x0364:
            if (r23 == 0) goto L_0x0368
            int r7 = r7 - r10
            goto L_0x0369
        L_0x0368:
            int r7 = r7 + r10
        L_0x0369:
            if (r23 == 0) goto L_0x0371
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.start
            r9.resolve(r7)
            goto L_0x0376
        L_0x0371:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r1.end
            r9.resolve(r7)
        L_0x0376:
            if (r2 >= r8) goto L_0x0389
            if (r2 >= r6) goto L_0x0389
            if (r23 == 0) goto L_0x0383
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x0389
        L_0x0383:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x0389:
            int r2 = r2 + 1
            goto L_0x0305
        L_0x038d:
            r7 = 2
            if (r2 != r7) goto L_0x043d
            int r2 = r0.orientation
            if (r2 != 0) goto L_0x039b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.widget
            float r2 = r2.getHorizontalBiasPercent()
            goto L_0x03a1
        L_0x039b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.widget
            float r2 = r2.getVerticalBiasPercent()
        L_0x03a1:
            if (r23 == 0) goto L_0x03a7
            r7 = 1065353216(0x3f800000, float:1.0)
            float r2 = r7 - r2
        L_0x03a7:
            int r3 = r3 - r14
            float r3 = (float) r3
            float r3 = r3 * r2
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r2
            int r2 = (int) r3
            if (r2 < 0) goto L_0x03b2
            if (r15 <= 0) goto L_0x03b3
        L_0x03b2:
            r2 = r1
        L_0x03b3:
            if (r23 == 0) goto L_0x03b8
            int r7 = r21 - r2
            goto L_0x03ba
        L_0x03b8:
            int r7 = r21 + r2
        L_0x03ba:
            r2 = r1
        L_0x03bb:
            if (r2 >= r4) goto L_0x043d
            if (r23 == 0) goto L_0x03c4
            int r1 = r2 + 1
            int r1 = r4 - r1
            goto L_0x03c5
        L_0x03c4:
            r1 = r2
        L_0x03c5:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r3 = r0.widgets
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r1.widget
            int r3 = r3.getVisibility()
            r9 = 8
            if (r3 != r9) goto L_0x03e3
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            r1.resolve(r7)
            r12 = 1
            goto L_0x0439
        L_0x03e3:
            if (r2 <= 0) goto L_0x03f4
            if (r2 < r5) goto L_0x03f4
            if (r23 == 0) goto L_0x03ef
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            int r3 = r3.margin
            int r7 = r7 - r3
            goto L_0x03f4
        L_0x03ef:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            int r3 = r3.margin
            int r7 = r7 + r3
        L_0x03f4:
            if (r23 == 0) goto L_0x03fc
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.end
            r3.resolve(r7)
            goto L_0x0401
        L_0x03fc:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
        L_0x0401:
            androidx.constraintlayout.solver.widgets.analyzer.b r3 = r1.dimension
            int r10 = r3.value
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r1.dimensionBehavior
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x0413
            int r11 = r1.matchConstraintsType
            r12 = 1
            if (r11 != r12) goto L_0x0414
            int r10 = r3.f14736a
            goto L_0x0414
        L_0x0413:
            r12 = 1
        L_0x0414:
            if (r23 == 0) goto L_0x0418
            int r7 = r7 - r10
            goto L_0x0419
        L_0x0418:
            int r7 = r7 + r10
        L_0x0419:
            if (r23 == 0) goto L_0x0421
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.start
            r3.resolve(r7)
            goto L_0x0426
        L_0x0421:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r1.end
            r3.resolve(r7)
        L_0x0426:
            if (r2 >= r8) goto L_0x0439
            if (r2 >= r6) goto L_0x0439
            if (r23 == 0) goto L_0x0433
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 - r1
            goto L_0x0439
        L_0x0433:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r1.end
            int r1 = r1.margin
            int r1 = -r1
            int r7 = r7 + r1
        L_0x0439:
            int r2 = r2 + 1
            goto L_0x03bb
        L_0x043d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.ChainRun.update(androidx.constraintlayout.solver.widgets.analyzer.Dependency):void");
    }
}
