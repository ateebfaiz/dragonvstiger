package com.facebook.yoga;

import com.facebook.soloader.SoLoader;
import d8.a;

@a
public class YogaNative {
    static {
        SoLoader.t("yoga");
    }

    static native void jni_YGConfigFreeJNI(long j10);

    static native int jni_YGConfigGetErrataJNI(long j10);

    static native long jni_YGConfigNewJNI();

    static native void jni_YGConfigSetErrataJNI(long j10, int i10);

    static native void jni_YGConfigSetExperimentalFeatureEnabledJNI(long j10, int i10, boolean z10);

    static native void jni_YGConfigSetLoggerJNI(long j10, YogaLogger yogaLogger);

    static native void jni_YGConfigSetPointScaleFactorJNI(long j10, float f10);

    static native void jni_YGConfigSetUseWebDefaultsJNI(long j10, boolean z10);

    static native void jni_YGNodeCalculateLayoutJNI(long j10, float f10, float f11, long[] jArr, YogaNodeJNIBase[] yogaNodeJNIBaseArr);

    static native long jni_YGNodeCloneJNI(long j10);

    static native void jni_YGNodeCopyStyleJNI(long j10, long j11);

    static native void jni_YGNodeFinalizeJNI(long j10);

    static native void jni_YGNodeInsertChildJNI(long j10, long j11, int i10);

    static native boolean jni_YGNodeIsDirtyJNI(long j10);

    static native boolean jni_YGNodeIsReferenceBaselineJNI(long j10);

    static native void jni_YGNodeMarkDirtyJNI(long j10);

    static native long jni_YGNodeNewJNI();

    static native long jni_YGNodeNewWithConfigJNI(long j10);

    static native void jni_YGNodeRemoveAllChildrenJNI(long j10);

    static native void jni_YGNodeRemoveChildJNI(long j10, long j11);

    static native void jni_YGNodeResetJNI(long j10);

    static native void jni_YGNodeSetAlwaysFormsContainingBlockJNI(long j10, boolean z10);

    static native void jni_YGNodeSetHasBaselineFuncJNI(long j10, boolean z10);

    static native void jni_YGNodeSetHasMeasureFuncJNI(long j10, boolean z10);

    static native void jni_YGNodeSetIsReferenceBaselineJNI(long j10, boolean z10);

    static native void jni_YGNodeSetStyleInputsJNI(long j10, float[] fArr, int i10);

    static native int jni_YGNodeStyleGetAlignContentJNI(long j10);

    static native int jni_YGNodeStyleGetAlignItemsJNI(long j10);

    static native int jni_YGNodeStyleGetAlignSelfJNI(long j10);

    static native float jni_YGNodeStyleGetAspectRatioJNI(long j10);

    static native float jni_YGNodeStyleGetBorderJNI(long j10, int i10);

    static native int jni_YGNodeStyleGetDirectionJNI(long j10);

    static native int jni_YGNodeStyleGetDisplayJNI(long j10);

    static native long jni_YGNodeStyleGetFlexBasisJNI(long j10);

    static native int jni_YGNodeStyleGetFlexDirectionJNI(long j10);

    static native float jni_YGNodeStyleGetFlexGrowJNI(long j10);

    static native float jni_YGNodeStyleGetFlexJNI(long j10);

    static native float jni_YGNodeStyleGetFlexShrinkJNI(long j10);

    static native int jni_YGNodeStyleGetFlexWrapJNI(long j10);

    static native float jni_YGNodeStyleGetGapJNI(long j10, int i10);

    static native long jni_YGNodeStyleGetHeightJNI(long j10);

    static native int jni_YGNodeStyleGetJustifyContentJNI(long j10);

    static native long jni_YGNodeStyleGetMarginJNI(long j10, int i10);

    static native long jni_YGNodeStyleGetMaxHeightJNI(long j10);

    static native long jni_YGNodeStyleGetMaxWidthJNI(long j10);

    static native long jni_YGNodeStyleGetMinHeightJNI(long j10);

    static native long jni_YGNodeStyleGetMinWidthJNI(long j10);

    static native int jni_YGNodeStyleGetOverflowJNI(long j10);

    static native long jni_YGNodeStyleGetPaddingJNI(long j10, int i10);

    static native long jni_YGNodeStyleGetPositionJNI(long j10, int i10);

    static native int jni_YGNodeStyleGetPositionTypeJNI(long j10);

    static native long jni_YGNodeStyleGetWidthJNI(long j10);

    static native void jni_YGNodeStyleSetAlignContentJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetAlignItemsJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetAlignSelfJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetAspectRatioJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetBorderJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetDirectionJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetDisplayJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetFlexBasisAutoJNI(long j10);

    static native void jni_YGNodeStyleSetFlexBasisJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetFlexBasisPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetFlexDirectionJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetFlexGrowJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetFlexJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetFlexShrinkJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetFlexWrapJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetGapJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetGapPercentJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetHeightAutoJNI(long j10);

    static native void jni_YGNodeStyleSetHeightJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetHeightPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetJustifyContentJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetMarginAutoJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetMarginJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetMarginPercentJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetMaxHeightJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMaxHeightPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMaxWidthJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMaxWidthPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMinHeightJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMinHeightPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMinWidthJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetMinWidthPercentJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetOverflowJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetPaddingJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetPaddingPercentJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetPositionJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetPositionPercentJNI(long j10, int i10, float f10);

    static native void jni_YGNodeStyleSetPositionTypeJNI(long j10, int i10);

    static native void jni_YGNodeStyleSetWidthAutoJNI(long j10);

    static native void jni_YGNodeStyleSetWidthJNI(long j10, float f10);

    static native void jni_YGNodeStyleSetWidthPercentJNI(long j10, float f10);

    static native void jni_YGNodeSwapChildJNI(long j10, long j11, int i10);
}
