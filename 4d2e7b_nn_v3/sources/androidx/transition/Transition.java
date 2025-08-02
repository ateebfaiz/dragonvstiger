package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<ArrayMap<Animator, d>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    long mDuration = -1;
    private s mEndValues = new s();
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private s mStartValues = new s();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList<>();

    public static abstract class EpicenterCallback {
        public abstract Rect onGetEpicenter(@NonNull Transition transition);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    public interface TransitionListener {
        void onTransitionCancel(@NonNull Transition transition);

        void onTransitionEnd(@NonNull Transition transition);

        void onTransitionPause(@NonNull Transition transition);

        void onTransitionResume(@NonNull Transition transition);

        void onTransitionStart(@NonNull Transition transition);
    }

    static class a extends PathMotion {
        a() {
        }

        public Path getPath(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayMap f16638a;

        b(ArrayMap arrayMap) {
            this.f16638a = arrayMap;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16638a.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        View f16641a;

        /* renamed from: b  reason: collision with root package name */
        String f16642b;

        /* renamed from: c  reason: collision with root package name */
        TransitionValues f16643c;

        /* renamed from: d  reason: collision with root package name */
        q0 f16644d;

        /* renamed from: e  reason: collision with root package name */
        Transition f16645e;

        d(View view, String str, Transition transition, q0 q0Var, TransitionValues transitionValues) {
            this.f16641a = view;
            this.f16642b = str;
            this.f16643c = transitionValues;
            this.f16644d = q0Var;
            this.f16645e = transition;
        }
    }

    private static class e {
        static ArrayList a(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        static ArrayList b(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(obj);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public Transition() {
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i10 = 0; i10 < arrayMap.size(); i10++) {
            TransitionValues valueAt = arrayMap.valueAt(i10);
            if (isValidTarget(valueAt.view)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i11 = 0; i11 < arrayMap2.size(); i11++) {
            TransitionValues valueAt2 = arrayMap2.valueAt(i11);
            if (isValidTarget(valueAt2.view)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(s sVar, View view, TransitionValues transitionValues) {
        sVar.f16712a.put(view, transitionValues);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (sVar.f16713b.indexOfKey(id2) >= 0) {
                sVar.f16713b.put(id2, (Object) null);
            } else {
                sVar.f16713b.put(id2, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (sVar.f16715d.containsKey(transitionName)) {
                sVar.f16715d.put(transitionName, null);
            } else {
                sVar.f16715d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (sVar.f16714c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = (View) sVar.f16714c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        sVar.f16714c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                sVar.f16714c.put(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i10) {
        int i11 = iArr[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            if (iArr[i12] == i11) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z10) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i10 = 0;
                        while (i10 < size) {
                            if (!this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                                i10++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z10) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.mTargetedTransitions.add(this);
                        capturePropagationValues(transitionValues);
                        if (z10) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i11 = 0;
                                    while (i11 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i11).isInstance(view)) {
                                            i11++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                    captureHierarchy(viewGroup.getChildAt(i12), z10);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i10, boolean z10) {
        if (i10 <= 0) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, Integer.valueOf(i10));
        }
        return e.b(arrayList, Integer.valueOf(i10));
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t10, boolean z10) {
        if (t10 == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, t10);
        }
        return e.b(arrayList, t10);
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z10) {
        if (cls == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, cls);
        }
        return e.b(arrayList, cls);
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z10) {
        if (view == null) {
            return arrayList;
        }
        if (z10) {
            return e.a(arrayList, view);
        }
        return e.b(arrayList, view);
    }

    private static ArrayMap<Animator, d> getRunningAnimators() {
        ArrayMap<Animator, d> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, d> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int i10) {
        return i10 >= 1 && i10 <= 4;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && isValidTarget(remove.view)) {
                this.mStartValuesList.add(arrayMap.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = longSparseArray.valueAt(i10);
            if (valueAt != null && isValidTarget(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i10))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = arrayMap3.valueAt(i10);
            if (valueAt != null && isValidTarget(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i10))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(s sVar, s sVar2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) sVar.f16712a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) sVar2.f16712a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i10 < iArr.length) {
                int i11 = iArr[i10];
                if (i11 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i11 == 2) {
                    matchNames(arrayMap, arrayMap2, sVar.f16715d, sVar2.f16715d);
                } else if (i11 == 3) {
                    matchIds(arrayMap, arrayMap2, sVar.f16713b, sVar2.f16713b);
                } else if (i11 == 4) {
                    matchItemIds(arrayMap, arrayMap2, sVar.f16714c, sVar2.f16714c);
                }
                i10++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i10] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i10] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                i10--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i10++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, d> arrayMap) {
        if (animator != null) {
            animator.addListener(new b(arrayMap));
            animate(animator);
        }
    }

    @NonNull
    public Transition addListener(@NonNull TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull View view) {
        this.mTargets.add(view);
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                ((TransitionListener) arrayList2.get(i10)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(@NonNull TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] propagationProperties;
        if (this.mPropagation != null && !transitionValues.values.isEmpty() && (propagationProperties = this.mPropagation.getPropagationProperties()) != null) {
            for (String containsKey : propagationProperties) {
                if (!transitionValues.values.containsKey(containsKey)) {
                    this.mPropagation.captureValues(transitionValues);
                    return;
                }
            }
        }
    }

    public abstract void captureStartValues(@NonNull TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public void captureValues(ViewGroup viewGroup, boolean z10) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z10);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i10).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z10) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.mTargetedTransitions.add(this);
                    capturePropagationValues(transitionValues);
                    if (z10) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                View view = this.mTargets.get(i11);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z10) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues2);
                if (z10) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z10);
        }
        if (!z10 && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(this.mStartValues.f16715d.remove(this.mNameOverrides.keyAt(i12)));
            }
            for (int i13 = 0; i13 < size; i13++) {
                View view2 = (View) arrayList3.get(i13);
                if (view2 != null) {
                    this.mStartValues.f16715d.put(this.mNameOverrides.valueAt(i13), view2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearValues(boolean z10) {
        if (z10) {
            this.mStartValues.f16712a.clear();
            this.mStartValues.f16713b.clear();
            this.mStartValues.f16714c.clear();
            return;
        }
        this.mEndValues.f16712a.clear();
        this.mEndValues.f16713b.clear();
        this.mEndValues.f16714c.clear();
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void createAnimators(ViewGroup viewGroup, s sVar, s sVar2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i10;
        Animator createAnimator;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j10 = LocationRequestCompat.PASSIVE_INTERVAL;
        int i11 = 0;
        while (i11 < size) {
            TransitionValues transitionValues3 = arrayList.get(i11);
            TransitionValues transitionValues4 = arrayList2.get(i11);
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null) && ((transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) && (createAnimator = createAnimator(viewGroup2, transitionValues3, transitionValues4)) != null)) {
                if (transitionValues4 != null) {
                    view = transitionValues4.view;
                    String[] transitionProperties = getTransitionProperties();
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        transitionValues2 = new TransitionValues(view);
                        Animator animator3 = createAnimator;
                        i10 = size;
                        TransitionValues transitionValues5 = (TransitionValues) sVar2.f16712a.get(view);
                        if (transitionValues5 != null) {
                            int i12 = 0;
                            while (i12 < transitionProperties.length) {
                                Map<String, Object> map = transitionValues2.values;
                                String str = transitionProperties[i12];
                                map.put(str, transitionValues5.values.get(str));
                                i12++;
                                ArrayList<TransitionValues> arrayList3 = arrayList2;
                                transitionProperties = transitionProperties;
                            }
                        }
                        int size2 = runningAnimators.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= size2) {
                                animator2 = animator3;
                                break;
                            }
                            d dVar = runningAnimators.get(runningAnimators.keyAt(i13));
                            if (dVar.f16643c != null && dVar.f16641a == view && dVar.f16642b.equals(getName()) && dVar.f16643c.equals(transitionValues2)) {
                                animator2 = null;
                                break;
                            }
                            i13++;
                        }
                    } else {
                        i10 = size;
                        animator2 = createAnimator;
                        transitionValues2 = null;
                    }
                    animator = animator2;
                    transitionValues = transitionValues2;
                } else {
                    i10 = size;
                    view = transitionValues3.view;
                    animator = createAnimator;
                    transitionValues = null;
                }
                if (animator != null) {
                    TransitionPropagation transitionPropagation = this.mPropagation;
                    if (transitionPropagation != null) {
                        long startDelay = transitionPropagation.getStartDelay(viewGroup2, this, transitionValues3, transitionValues4);
                        sparseIntArray.put(this.mAnimators.size(), (int) startDelay);
                        j10 = Math.min(startDelay, j10);
                    }
                    runningAnimators.put(animator, new d(view, getName(), this, b0.d(viewGroup), transitionValues));
                    this.mAnimators.add(animator);
                    j10 = j10;
                }
            } else {
                i10 = size;
            }
            i11++;
            size = i10;
        }
        if (sparseIntArray.size() != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i14));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i14)) - j10) + animator4.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void end() {
        int i10 = this.mNumInstances - 1;
        this.mNumInstances = i10;
        if (i10 == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((TransitionListener) arrayList2.get(i11)).onTransitionEnd(this);
                }
            }
            for (int i12 = 0; i12 < this.mStartValues.f16714c.size(); i12++) {
                View view = (View) this.mStartValues.f16714c.valueAt(i12);
                if (view != null) {
                    ViewCompat.setHasTransientState(view, false);
                }
            }
            for (int i13 = 0; i13 < this.mEndValues.f16714c.size(); i13++) {
                View view2 = (View) this.mEndValues.f16714c.valueAt(i13);
                if (view2 != null) {
                    ViewCompat.setHasTransientState(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    @NonNull
    public Transition excludeChildren(@NonNull View view, boolean z10) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z10) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z10);
        return this;
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            q0 d10 = b0.d(viewGroup);
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) runningAnimators);
            runningAnimators.clear();
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = (d) arrayMap.valueAt(i10);
                if (!(dVar.f16641a == null || d10 == null || !d10.equals(dVar.f16644d))) {
                    ((Animator) arrayMap.keyAt(i10)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    @Nullable
    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.onGetEpicenter(this);
    }

    @Nullable
    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    @Nullable
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* access modifiers changed from: package-private */
    public TransitionValues getMatchedTransitionValues(View view, boolean z10) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z10);
        }
        if (z10) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i10);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == view) {
                break;
            }
            i10++;
        }
        if (i10 < 0) {
            return null;
        }
        if (z10) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(i10);
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    @Nullable
    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    @NonNull
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    @Nullable
    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    @Nullable
    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    @NonNull
    public List<View> getTargets() {
        return this.mTargets;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return null;
    }

    @Nullable
    public TransitionValues getTransitionValues(@NonNull View view, boolean z10) {
        s sVar;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z10);
        }
        if (z10) {
            sVar = this.mStartValues;
        } else {
            sVar = this.mEndValues;
        }
        return (TransitionValues) sVar.f16712a.get(view);
    }

    public boolean isTransitionRequired(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i10 = 0;
            while (i10 < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i10])) {
                    i10++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.values.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.mTargetTypeExcludes.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName(view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id2)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i11 = 0; i11 < this.mTargetTypes.size(); i11++) {
                if (this.mTargetTypes.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            q0 d10 = b0.d(view);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d valueAt = runningAnimators.valueAt(i10);
                if (valueAt.f16641a != null && d10.equals(valueAt.f16644d)) {
                    a.b(runningAnimators.keyAt(i10));
                }
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    ((TransitionListener) arrayList2.get(i11)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: androidx.transition.TransitionValues} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void playTransition(android.view.ViewGroup r11) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.mStartValuesList = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.mEndValuesList = r0
            androidx.transition.s r0 = r10.mStartValues
            androidx.transition.s r1 = r10.mEndValues
            r10.matchStartAndEnd(r0, r1)
            androidx.collection.ArrayMap r0 = getRunningAnimators()
            int r1 = r0.size()
            androidx.transition.q0 r2 = androidx.transition.b0.d(r11)
            r3 = 1
            int r1 = r1 - r3
        L_0x0023:
            if (r1 < 0) goto L_0x007f
            java.lang.Object r4 = r0.keyAt(r1)
            android.animation.Animator r4 = (android.animation.Animator) r4
            if (r4 == 0) goto L_0x007c
            java.lang.Object r5 = r0.get(r4)
            androidx.transition.Transition$d r5 = (androidx.transition.Transition.d) r5
            if (r5 == 0) goto L_0x007c
            android.view.View r6 = r5.f16641a
            if (r6 == 0) goto L_0x007c
            androidx.transition.q0 r6 = r5.f16644d
            boolean r6 = r2.equals(r6)
            if (r6 == 0) goto L_0x007c
            androidx.transition.TransitionValues r6 = r5.f16643c
            android.view.View r7 = r5.f16641a
            androidx.transition.TransitionValues r8 = r10.getTransitionValues(r7, r3)
            androidx.transition.TransitionValues r9 = r10.getMatchedTransitionValues(r7, r3)
            if (r8 != 0) goto L_0x005c
            if (r9 != 0) goto L_0x005c
            androidx.transition.s r9 = r10.mEndValues
            androidx.collection.ArrayMap r9 = r9.f16712a
            java.lang.Object r7 = r9.get(r7)
            r9 = r7
            androidx.transition.TransitionValues r9 = (androidx.transition.TransitionValues) r9
        L_0x005c:
            if (r8 != 0) goto L_0x0060
            if (r9 == 0) goto L_0x007c
        L_0x0060:
            androidx.transition.Transition r5 = r5.f16645e
            boolean r5 = r5.isTransitionRequired(r6, r9)
            if (r5 == 0) goto L_0x007c
            boolean r5 = r4.isRunning()
            if (r5 != 0) goto L_0x0079
            boolean r5 = r4.isStarted()
            if (r5 == 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            r0.remove(r4)
            goto L_0x007c
        L_0x0079:
            r4.cancel()
        L_0x007c:
            int r1 = r1 + -1
            goto L_0x0023
        L_0x007f:
            androidx.transition.s r6 = r10.mStartValues
            androidx.transition.s r7 = r10.mEndValues
            java.util.ArrayList<androidx.transition.TransitionValues> r8 = r10.mStartValuesList
            java.util.ArrayList<androidx.transition.TransitionValues> r9 = r10.mEndValuesList
            r4 = r10
            r5 = r11
            r4.createAnimators(r5, r6, r7, r8, r9)
            r10.runAnimators()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Transition.playTransition(android.view.ViewGroup):void");
    }

    @NonNull
    public Transition removeListener(@NonNull TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull View view) {
        this.mTargets.remove(view);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                q0 d10 = b0.d(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    d valueAt = runningAnimators.valueAt(i10);
                    if (valueAt.f16641a != null && d10.equals(valueAt.f16644d)) {
                        a.c(runningAnimators.keyAt(i10));
                    }
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((TransitionListener) arrayList2.get(i11)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void runAnimators() {
        start();
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z10) {
        this.mCanRemoveViews = z10;
    }

    @NonNull
    public Transition setDuration(long j10) {
        this.mDuration = j10;
        return this;
    }

    public void setEpicenterCallback(@Nullable EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    @NonNull
    public Transition setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i10 = 0;
        while (i10 < iArr.length) {
            if (!isValidMatch(iArr[i10])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i10)) {
                i10++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(@Nullable TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    /* access modifiers changed from: package-private */
    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    @NonNull
    public Transition setStartDelay(long j10) {
        this.mStartDelay = j10;
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((TransitionListener) arrayList2.get(i10)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    @NonNull
    public Transition addTarget(@IdRes int i10) {
        if (i10 != 0) {
            this.mTargetIds.add(Integer.valueOf(i10));
        }
        return this;
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new s();
            transition.mEndValues = new s();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @NonNull
    public Transition excludeChildren(@IdRes int i10, boolean z10) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i10, z10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@IdRes int i10, boolean z10) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i10, z10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@IdRes int i10) {
        if (i10 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i10));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i10 = 0; i10 < this.mTargetIds.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i10);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i11 = 0; i11 < this.mTargets.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i11);
            }
        }
        return str3 + ")";
    }

    @NonNull
    public Transition addTarget(@NonNull String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    @NonNull
    public Transition excludeChildren(@NonNull Class<?> cls, boolean z10) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z10);
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z10) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z10) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z10);
        return this;
    }

    @NonNull
    public Transition removeTarget(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition addTarget(@NonNull Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16694c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long namedInt = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (namedInt >= 0) {
            setDuration(namedInt);
        }
        long namedInt2 = (long) TypedArrayUtils.getNamedInt(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (namedInt2 > 0) {
            setStartDelay(namedInt2);
        }
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (namedResourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, namedResourceId));
        }
        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (namedString != null) {
            setMatchOrder(parseMatchOrder(namedString));
        }
        obtainStyledAttributes.recycle();
    }
}
