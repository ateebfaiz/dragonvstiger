package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

abstract class a {
    static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i10) {
        int i11;
        ChainHead[] chainHeadArr;
        int i12;
        if (i10 == 0) {
            i12 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i11 = 0;
        } else {
            i12 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i11 = 2;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            ChainHead chainHead = chainHeadArr[i13];
            chainHead.define();
            b(constraintWidgetContainer, linearSystem, i10, i11, chainHead);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX WARNING: type inference failed for: r5v10, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r7 == 2) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r7 == 2) goto L_0x002f;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0249 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02a5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0478  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x04b6 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x04ce  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x04eb  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x04ef A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x038f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:314:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            r0 = r37
            r9 = r38
            r1 = r41
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.mFirst
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.mLast
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.mFirstVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.mLastVisibleWidget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.mHead
            float r3 = r1.mTotalWeight
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.mListDimensionBehaviors
            r4 = r4[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r14 = 1
            if (r4 != r5) goto L_0x001d
            r4 = r14
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            r5 = 2
            if (r39 != 0) goto L_0x0038
            int r7 = r2.mHorizontalChainStyle
            if (r7 != 0) goto L_0x0027
            r8 = r14
            goto L_0x0028
        L_0x0027:
            r8 = 0
        L_0x0028:
            if (r7 != r14) goto L_0x002c
            r15 = r14
            goto L_0x002d
        L_0x002c:
            r15 = 0
        L_0x002d:
            if (r7 != r5) goto L_0x0031
        L_0x002f:
            r5 = r14
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            r16 = r15
            r7 = 0
            r15 = r8
            r8 = r10
            goto L_0x0047
        L_0x0038:
            int r7 = r2.mVerticalChainStyle
            if (r7 != 0) goto L_0x003e
            r8 = r14
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            if (r7 != r14) goto L_0x0043
            r15 = r14
            goto L_0x0044
        L_0x0043:
            r15 = 0
        L_0x0044:
            if (r7 != r5) goto L_0x0031
            goto L_0x002f
        L_0x0047:
            r20 = 0
            if (r7 != 0) goto L_0x0123
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r8.mListAnchors
            r6 = r6[r40]
            if (r5 == 0) goto L_0x0054
            r18 = 1
            goto L_0x0056
        L_0x0054:
            r18 = 4
        L_0x0056:
            int r22 = r6.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r14 = r8.mListDimensionBehaviors
            r14 = r14[r39]
            r24 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r14 != r3) goto L_0x006e
            int[] r14 = r8.mResolvedMatchConstraintDefault
            r14 = r14[r39]
            if (r14 != 0) goto L_0x006e
            r25 = r7
            r14 = 1
            goto L_0x0071
        L_0x006e:
            r25 = r7
            r14 = 0
        L_0x0071:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r6.mTarget
            if (r7 == 0) goto L_0x007d
            if (r8 == r10) goto L_0x007d
            int r7 = r7.getMargin()
            int r22 = r22 + r7
        L_0x007d:
            r7 = r22
            if (r5 == 0) goto L_0x008a
            if (r8 == r10) goto L_0x008a
            if (r8 == r12) goto L_0x008a
            r22 = r15
            r18 = 5
            goto L_0x008c
        L_0x008a:
            r22 = r15
        L_0x008c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r6.mTarget
            if (r15 == 0) goto L_0x00be
            if (r8 != r12) goto L_0x009f
            r26 = r2
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r27 = r10
            r10 = 6
            r9.addGreaterThan(r2, r15, r7, r10)
            goto L_0x00ac
        L_0x009f:
            r26 = r2
            r27 = r10
            androidx.constraintlayout.solver.SolverVariable r2 = r6.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r10 = r15.mSolverVariable
            r15 = 8
            r9.addGreaterThan(r2, r10, r7, r15)
        L_0x00ac:
            if (r14 == 0) goto L_0x00b2
            if (r5 != 0) goto L_0x00b2
            r2 = 5
            goto L_0x00b4
        L_0x00b2:
            r2 = r18
        L_0x00b4:
            androidx.constraintlayout.solver.SolverVariable r10 = r6.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r9.addEquality(r10, r6, r7, r2)
            goto L_0x00c2
        L_0x00be:
            r26 = r2
            r27 = r10
        L_0x00c2:
            if (r4 == 0) goto L_0x00f6
            int r2 = r8.getVisibility()
            r6 = 8
            if (r2 == r6) goto L_0x00e4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r8.mListDimensionBehaviors
            r2 = r2[r39]
            if (r2 != r3) goto L_0x00e4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r40 + 1
            r3 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r2 = r2[r40]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            r6 = 0
            r7 = 5
            r9.addGreaterThan(r3, r2, r6, r7)
            goto L_0x00e5
        L_0x00e4:
            r6 = 0
        L_0x00e5:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            r7 = 8
            r9.addGreaterThan(r2, r3, r6, r7)
        L_0x00f6:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0111
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.mOwner
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x0111
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.mOwner
            if (r3 == r8) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r20 = r2
        L_0x0111:
            if (r20 == 0) goto L_0x0118
            r8 = r20
            r7 = r25
            goto L_0x0119
        L_0x0118:
            r7 = 1
        L_0x0119:
            r15 = r22
            r3 = r24
            r2 = r26
            r10 = r27
            goto L_0x0047
        L_0x0123:
            r26 = r2
            r24 = r3
            r27 = r10
            r22 = r15
            if (r13 == 0) goto L_0x0189
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0189
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r39]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x015f
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r39]
            if (r6 != 0) goto L_0x015f
            if (r5 != 0) goto L_0x015f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x015f
            androidx.constraintlayout.solver.SolverVariable r7 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r10 = 5
            r9.addEquality(r7, r6, r8, r10)
            goto L_0x0175
        L_0x015f:
            r10 = 5
            if (r5 == 0) goto L_0x0175
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x0175
            androidx.constraintlayout.solver.SolverVariable r7 = r2.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            int r8 = r2.getMargin()
            int r8 = -r8
            r14 = 4
            r9.addEquality(r7, r6, r8, r14)
        L_0x0175:
            androidx.constraintlayout.solver.SolverVariable r6 = r2.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            androidx.constraintlayout.solver.SolverVariable r3 = r3.mSolverVariable
            int r2 = r2.getMargin()
            int r2 = -r2
            r7 = 6
            r9.addLowerThan(r6, r3, r2, r7)
            goto L_0x018a
        L_0x0189:
            r10 = 5
        L_0x018a:
            if (r4 == 0) goto L_0x01a3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r2 = r40 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r2 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r2.mSolverVariable
            int r2 = r2.getMargin()
            r4 = 8
            r9.addGreaterThan(r0, r3, r2, r4)
        L_0x01a3:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x0247
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x0247
            boolean r3 = r1.mHasUndefinedWeights
            if (r3 == 0) goto L_0x01ba
            boolean r3 = r1.mHasComplexMatchWeights
            if (r3 != 0) goto L_0x01ba
            int r3 = r1.mWidgetsMatchCount
            float r3 = (float) r3
            goto L_0x01bc
        L_0x01ba:
            r3 = r24
        L_0x01bc:
            r4 = 0
            r29 = r4
            r7 = r20
            r6 = 0
        L_0x01c2:
            if (r6 >= r2) goto L_0x0247
            java.lang.Object r8 = r0.get(r6)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r8
            float[] r14 = r8.mWeight
            r14 = r14[r39]
            int r15 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r15 >= 0) goto L_0x01ec
            boolean r14 = r1.mHasComplexMatchWeights
            if (r14 == 0) goto L_0x01e8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r8.mListAnchors
            int r14 = r40 + 1
            r14 = r8[r14]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r8 = r8[r40]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r10 = 4
            r15 = 0
            r9.addEquality(r14, r8, r15, r10)
            goto L_0x0203
        L_0x01e8:
            r10 = 4
            r14 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01ed
        L_0x01ec:
            r10 = 4
        L_0x01ed:
            int r15 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r15 != 0) goto L_0x0206
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r8.mListAnchors
            int r14 = r40 + 1
            r14 = r8[r14]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.mSolverVariable
            r8 = r8[r40]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            r4 = 8
            r15 = 0
            r9.addEquality(r14, r8, r15, r4)
        L_0x0203:
            r17 = r0
            goto L_0x023f
        L_0x0206:
            r15 = 0
            if (r7 == 0) goto L_0x023a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r7.mListAnchors
            r7 = r4[r40]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
            int r17 = r40 + 1
            r4 = r4[r17]
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r10 = r8.mListAnchors
            r15 = r10[r40]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.mSolverVariable
            r10 = r10[r17]
            androidx.constraintlayout.solver.SolverVariable r10 = r10.mSolverVariable
            r17 = r0
            androidx.constraintlayout.solver.ArrayRow r0 = r38.createRow()
            r28 = r0
            r30 = r3
            r31 = r14
            r32 = r7
            r33 = r4
            r34 = r15
            r35 = r10
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r9.addConstraint(r0)
            goto L_0x023c
        L_0x023a:
            r17 = r0
        L_0x023c:
            r7 = r8
            r29 = r14
        L_0x023f:
            int r6 = r6 + 1
            r0 = r17
            r4 = 0
            r10 = 5
            goto L_0x01c2
        L_0x0247:
            if (r12 == 0) goto L_0x0250
            if (r12 == r13) goto L_0x024d
            if (r5 == 0) goto L_0x0250
        L_0x024d:
            r10 = r27
            goto L_0x0253
        L_0x0250:
            r10 = r27
            goto L_0x02a3
        L_0x0253:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.mListAnchors
            int r2 = r40 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x0265
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r3 = r0
            goto L_0x0267
        L_0x0265:
            r3 = r20
        L_0x0267:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.mTarget
            if (r0 == 0) goto L_0x026f
            androidx.constraintlayout.solver.SolverVariable r0 = r0.mSolverVariable
            r5 = r0
            goto L_0x0271
        L_0x026f:
            r5 = r20
        L_0x0271:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r2]
            if (r3 == 0) goto L_0x04b4
            if (r5 == 0) goto L_0x04b4
            if (r39 != 0) goto L_0x0285
            r2 = r26
            float r2 = r2.mHorizontalBiasPercent
        L_0x0283:
            r4 = r2
            goto L_0x028a
        L_0x0285:
            r2 = r26
            float r2 = r2.mVerticalBiasPercent
            goto L_0x0283
        L_0x028a:
            int r6 = r0.getMargin()
            int r7 = r1.getMargin()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r1.mSolverVariable
            r10 = 7
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04b4
        L_0x02a3:
            if (r22 == 0) goto L_0x0393
            if (r12 == 0) goto L_0x0393
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02b2
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x02b2
            r23 = 1
            goto L_0x02b4
        L_0x02b2:
            r23 = 0
        L_0x02b4:
            r14 = r12
            r15 = r14
        L_0x02b6:
            if (r14 == 0) goto L_0x04b4
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
            r8 = r0
        L_0x02bd:
            if (r8 == 0) goto L_0x02cc
            int r0 = r8.getVisibility()
            r6 = 8
            if (r0 != r6) goto L_0x02ce
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.mNextChainWidget
            r8 = r0[r39]
            goto L_0x02bd
        L_0x02cc:
            r6 = 8
        L_0x02ce:
            if (r8 != 0) goto L_0x02d9
            if (r14 != r13) goto L_0x02d3
            goto L_0x02d9
        L_0x02d3:
            r17 = r8
            r19 = 5
            goto L_0x0386
        L_0x02d9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x02e6
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x02e8
        L_0x02e6:
            r2 = r20
        L_0x02e8:
            if (r15 == r14) goto L_0x02f3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0304
        L_0x02f3:
            if (r14 != r12) goto L_0x0304
            if (r15 != r14) goto L_0x0304
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0302
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x0304
        L_0x0302:
            r2 = r20
        L_0x0304:
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            int r3 = r3.getMargin()
            if (r8 == 0) goto L_0x0326
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r7 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.mSolverVariable
            r36 = r7
            r7 = r6
            r6 = r36
            goto L_0x0339
        L_0x0326:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x0331
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0333
        L_0x0331:
            r6 = r20
        L_0x0333:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.mListAnchors
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.mSolverVariable
        L_0x0339:
            if (r5 == 0) goto L_0x0340
            int r5 = r5.getMargin()
            int r3 = r3 + r5
        L_0x0340:
            if (r15 == 0) goto L_0x034b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            int r0 = r0 + r5
        L_0x034b:
            if (r1 == 0) goto L_0x02d3
            if (r2 == 0) goto L_0x02d3
            if (r6 == 0) goto L_0x02d3
            if (r7 == 0) goto L_0x02d3
            if (r14 != r12) goto L_0x035d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            int r0 = r0.getMargin()
        L_0x035d:
            r5 = r0
            if (r14 != r13) goto L_0x036b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r4]
            int r0 = r0.getMargin()
            r17 = r0
            goto L_0x036d
        L_0x036b:
            r17 = r3
        L_0x036d:
            if (r23 == 0) goto L_0x0372
            r18 = 8
            goto L_0x0374
        L_0x0372:
            r18 = 5
        L_0x0374:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r3 = r5
            r5 = r6
            r19 = 5
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0386:
            int r0 = r14.getVisibility()
            r8 = 8
            if (r0 == r8) goto L_0x038f
            r15 = r14
        L_0x038f:
            r14 = r17
            goto L_0x02b6
        L_0x0393:
            r8 = 8
            if (r16 == 0) goto L_0x04b4
            if (r12 == 0) goto L_0x04b4
            int r0 = r1.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x03a4
            int r1 = r1.mWidgetsCount
            if (r1 != r0) goto L_0x03a4
            r23 = 1
            goto L_0x03a6
        L_0x03a4:
            r23 = 0
        L_0x03a6:
            r14 = r12
            r15 = r14
        L_0x03a8:
            if (r14 == 0) goto L_0x045f
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
        L_0x03ae:
            if (r0 == 0) goto L_0x03bb
            int r1 = r0.getVisibility()
            if (r1 != r8) goto L_0x03bb
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r39]
            goto L_0x03ae
        L_0x03bb:
            if (r14 == r12) goto L_0x044c
            if (r14 == r13) goto L_0x044c
            if (r0 == 0) goto L_0x044c
            if (r0 != r13) goto L_0x03c6
            r7 = r20
            goto L_0x03c7
        L_0x03c6:
            r7 = r0
        L_0x03c7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.mTarget
            if (r2 == 0) goto L_0x03d3
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
        L_0x03d3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.mListAnchors
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r3]
            int r4 = r4.getMargin()
            if (r7 == 0) goto L_0x03f9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.mTarget
            if (r8 == 0) goto L_0x03f6
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
            goto L_0x040a
        L_0x03f6:
            r8 = r20
            goto L_0x040a
        L_0x03f9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.mListAnchors
            r5 = r5[r40]
            if (r5 == 0) goto L_0x0402
            androidx.constraintlayout.solver.SolverVariable r6 = r5.mSolverVariable
            goto L_0x0404
        L_0x0402:
            r6 = r20
        L_0x0404:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r3]
            androidx.constraintlayout.solver.SolverVariable r8 = r8.mSolverVariable
        L_0x040a:
            if (r5 == 0) goto L_0x0411
            int r5 = r5.getMargin()
            int r4 = r4 + r5
        L_0x0411:
            r17 = r4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.mListAnchors
            r3 = r4[r3]
            int r3 = r3.getMargin()
            int r3 = r3 + r0
            if (r23 == 0) goto L_0x0421
            r19 = 8
            goto L_0x0423
        L_0x0421:
            r19 = 4
        L_0x0423:
            if (r1 == 0) goto L_0x0441
            if (r2 == 0) goto L_0x0441
            if (r6 == 0) goto L_0x0441
            if (r8 == 0) goto L_0x0441
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r5 = r6
            r18 = 4
            r6 = r8
            r21 = r7
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r19
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0449
        L_0x0441:
            r21 = r7
            r17 = r15
            r15 = 8
            r18 = 4
        L_0x0449:
            r0 = r21
            goto L_0x0451
        L_0x044c:
            r17 = r15
            r18 = 4
            r15 = r8
        L_0x0451:
            int r1 = r14.getVisibility()
            if (r1 == r15) goto L_0x0458
            goto L_0x045a
        L_0x0458:
            r14 = r17
        L_0x045a:
            r8 = r15
            r15 = r14
            r14 = r0
            goto L_0x03a8
        L_0x045f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            int r3 = r40 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.mTarget
            r15 = 5
            if (r1 == 0) goto L_0x04a4
            if (r12 == r13) goto L_0x0486
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            int r0 = r0.getMargin()
            r9.addEquality(r2, r1, r0, r15)
            goto L_0x04a4
        L_0x0486:
            if (r14 == 0) goto L_0x04a4
            androidx.constraintlayout.solver.SolverVariable r2 = r0.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r3 = r1.mSolverVariable
            int r4 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r5 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r6 = r14.mSolverVariable
            int r7 = r10.getMargin()
            r8 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r8
            r8 = r15
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x04a4:
            if (r14 == 0) goto L_0x04b4
            if (r12 == r13) goto L_0x04b4
            androidx.constraintlayout.solver.SolverVariable r0 = r10.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r1 = r14.mSolverVariable
            int r2 = r10.getMargin()
            int r2 = -r2
            r9.addEquality(r0, r1, r2, r15)
        L_0x04b4:
            if (r22 != 0) goto L_0x04b8
            if (r16 == 0) goto L_0x050e
        L_0x04b8:
            if (r12 == 0) goto L_0x050e
            if (r12 == r13) goto L_0x050e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r1 = r0[r40]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r3 = 1
            int r3 = r40 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.mTarget
            if (r4 == 0) goto L_0x04ce
            androidx.constraintlayout.solver.SolverVariable r4 = r4.mSolverVariable
            goto L_0x04d0
        L_0x04ce:
            r4 = r20
        L_0x04d0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x04d7
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            goto L_0x04d9
        L_0x04d7:
            r5 = r20
        L_0x04d9:
            if (r11 == r13) goto L_0x04e9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x04e7
            androidx.constraintlayout.solver.SolverVariable r5 = r5.mSolverVariable
            r20 = r5
        L_0x04e7:
            r5 = r20
        L_0x04e9:
            if (r12 != r13) goto L_0x04ed
            r2 = r0[r3]
        L_0x04ed:
            if (r4 == 0) goto L_0x050e
            if (r5 == 0) goto L_0x050e
            int r6 = r1.getMargin()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.mListAnchors
            r0 = r0[r3]
            int r7 = r0.getMargin()
            androidx.constraintlayout.solver.SolverVariable r1 = r1.mSolverVariable
            androidx.constraintlayout.solver.SolverVariable r8 = r2.mSolverVariable
            r10 = 5
            r11 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r2 = r4
            r3 = r6
            r4 = r11
            r6 = r8
            r8 = r10
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x050e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.a.b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
