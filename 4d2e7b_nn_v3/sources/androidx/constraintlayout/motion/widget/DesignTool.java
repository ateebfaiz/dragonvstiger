package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.PrintStream;
import java.util.HashMap;

public class DesignTool {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes;
    static final HashMap<String, String> allMargins;
    private String mLastEndState = null;
    private int mLastEndStateId = -1;
    private String mLastStartState = null;
    private int mLastStartStateId = -1;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        allAttributes = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        allMargins = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private static void Connect(int i10, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i11, int i12) {
        int i13;
        String str = allAttributes.get(Pair.create(Integer.valueOf(i11), Integer.valueOf(i12)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = allMargins.get(str);
            if (str3 != null) {
                i13 = GetPxFromDp(i10, hashMap.get(str3));
            } else {
                i13 = 0;
            }
            int i14 = i13;
            ConstraintSet constraintSet2 = constraintSet;
            constraintSet2.connect(view.getId(), i11, Integer.parseInt(str2), i12, i14);
        }
    }

    private static int GetPxFromDp(int i10, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) (((float) (Integer.valueOf(str.substring(0, indexOf)).intValue() * i10)) / 160.0f);
    }

    private static void SetAbsolutePositions(int i10, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), GetPxFromDp(i10, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), GetPxFromDp(i10, str2));
        }
    }

    private static void SetBias(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i10) {
        String str;
        if (i10 == 1) {
            str = "layout_constraintVertical_bias";
        } else {
            str = "layout_constraintHorizontal_bias";
        }
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return;
        }
        if (i10 == 0) {
            constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str2));
        } else if (i10 == 1) {
            constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str2));
        }
    }

    private static void SetDimensions(int i10, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i11) {
        String str;
        int i12;
        if (i11 == 1) {
            str = "layout_height";
        } else {
            str = "layout_width";
        }
        String str2 = hashMap.get(str);
        if (str2 != null) {
            if (!str2.equalsIgnoreCase("wrap_content")) {
                i12 = GetPxFromDp(i10, str2);
            } else {
                i12 = -2;
            }
            if (i11 == 0) {
                constraintSet.constrainWidth(view.getId(), i12);
            } else {
                constraintSet.constrainHeight(view.getId(), i12);
            }
        }
    }

    public int designAccess(int i10, String str, Object obj, float[] fArr, int i11, float[] fArr2, int i12) {
        MotionController motionController;
        View view = (View) obj;
        if (i10 != 0) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null || view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            int duration = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration);
            return duration;
        } else if (i10 == 2) {
            int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildKeyFrames(fArr2, (int[]) null);
            return duration2;
        } else if (i10 != 3) {
            return -1;
        } else {
            this.mMotionLayout.mScene.getDuration();
            return motionController.getAttributeValues(str, fArr2, i12);
        }
    }

    public void disableAutoTransition(boolean z10) {
        this.mMotionLayout.disableAutoTransition(z10);
    }

    public void dumpConstraintSet(String str) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        PrintStream printStream = System.out;
        printStream.println(" dumping  " + str + " (" + lookUpConstraintId + ")");
        try {
            this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(fArr, (int[]) null);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i10) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(fArr, i10);
        return i10;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            int duration = motionScene.getDuration() / 16;
            MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
            if (motionController != null) {
                motionController.buildRectangles(fArr, duration);
            }
        }
    }

    public String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public int getKeyFrameInfo(Object obj, int i10, int[] iArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i10, iArr);
    }

    public float getKeyFramePosition(Object obj, int i10, float f10, float f11) {
        return this.mMotionLayout.mFrameArrayList.get((View) obj).getKeyFrameParameter(i10, f10, f11);
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i10, int i11, int i12) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), i10, i11, i12);
    }

    public Object getKeyframeAtLocation(Object obj, float f10, float f11) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f10, f11);
    }

    public Boolean getPositionKeyframe(Object obj, Object obj2, float f10, float f11, String[] strArr, float[] fArr) {
        if (!(obj instanceof a)) {
            return Boolean.FALSE;
        }
        View view = (View) obj2;
        this.mMotionLayout.mFrameArrayList.get(view).positionKeyframe(view, (a) obj, f10, f11, strArr, fArr);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return Boolean.TRUE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public String getState() {
        if (!(this.mLastStartState == null || this.mLastEndState == null)) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if (this.mLastStartState == null || this.mLastEndState == null) {
            return false;
        }
        return true;
    }

    public void setAttributes(int i10, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap hashMap = (HashMap) obj2;
        int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
        if (constraintSet != null) {
            constraintSet.clear(view.getId());
            SetDimensions(i10, constraintSet, view, hashMap, 0);
            SetDimensions(i10, constraintSet, view, hashMap, 1);
            int i11 = i10;
            ConstraintSet constraintSet2 = constraintSet;
            View view2 = view;
            HashMap hashMap2 = hashMap;
            Connect(i11, constraintSet2, view2, hashMap2, 6, 6);
            Connect(i11, constraintSet2, view2, hashMap2, 6, 7);
            Connect(i11, constraintSet2, view2, hashMap2, 7, 7);
            Connect(i11, constraintSet2, view2, hashMap2, 7, 6);
            Connect(i11, constraintSet2, view2, hashMap2, 1, 1);
            Connect(i11, constraintSet2, view2, hashMap2, 1, 2);
            Connect(i11, constraintSet2, view2, hashMap2, 2, 2);
            Connect(i11, constraintSet2, view2, hashMap2, 2, 1);
            Connect(i11, constraintSet2, view2, hashMap2, 3, 3);
            Connect(i11, constraintSet2, view2, hashMap2, 3, 4);
            Connect(i11, constraintSet2, view2, hashMap2, 4, 3);
            Connect(i11, constraintSet2, view2, hashMap2, 4, 4);
            Connect(i11, constraintSet2, view2, hashMap2, 5, 5);
            SetBias(constraintSet, view, hashMap, 0);
            SetBias(constraintSet, view, hashMap, 1);
            SetAbsolutePositions(i10, constraintSet, view, hashMap);
            this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
            this.mMotionLayout.requestLayout();
        }
    }

    public void setKeyFrame(Object obj, int i10, String str, Object obj2) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i10, str, obj2);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = ((float) i10) / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    public boolean setKeyFramePosition(Object obj, int i10, int i11, float f10, float f11) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return false;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        MotionLayout motionLayout2 = this.mMotionLayout;
        int i12 = (int) (motionLayout2.mTransitionPosition * 100.0f);
        if (motionController == null) {
            return false;
        }
        View view = (View) obj;
        if (!motionLayout2.mScene.hasKeyFramePosition(view, i12)) {
            return false;
        }
        float keyFrameParameter = motionController.getKeyFrameParameter(2, f10, f11);
        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f10, f11);
        this.mMotionLayout.mScene.setKeyframe(view, i12, "motion:percentX", Float.valueOf(keyFrameParameter));
        this.mMotionLayout.mScene.setKeyframe(view, i12, "motion:percentY", Float.valueOf(keyFrameParameter2));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.mLastStartState != str) {
            this.mLastStartState = str;
            this.mLastEndState = null;
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null) {
                motionLayout.mScene = this.mSceneCache;
            }
            int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
            this.mLastStartStateId = lookUpConstraintId;
            if (lookUpConstraintId != 0) {
                if (lookUpConstraintId == this.mMotionLayout.getStartState()) {
                    this.mMotionLayout.setProgress(0.0f);
                } else if (lookUpConstraintId == this.mMotionLayout.getEndState()) {
                    this.mMotionLayout.setProgress(1.0f);
                } else {
                    this.mMotionLayout.transitionToState(lookUpConstraintId);
                    this.mMotionLayout.setProgress(1.0f);
                }
            }
            this.mMotionLayout.requestLayout();
        }
    }

    public void setToolPosition(float f10) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        motionLayout.setProgress(f10);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String str, String str2) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
        this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
        this.mLastStartStateId = lookUpConstraintId;
        this.mLastEndStateId = lookUpConstraintId2;
        this.mLastStartState = str;
        this.mLastEndState = str2;
    }

    public void setViewDebug(Object obj, int i10) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i10);
            this.mMotionLayout.invalidate();
        }
    }

    public Object getKeyframe(Object obj, int i10, int i11) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id2 = ((View) obj).getId();
        MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i10, id2, i11);
    }
}
