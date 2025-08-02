package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl {

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f15646a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f15647b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f15648c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f15649d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ArrayList f15650e;

        a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f15646a = i10;
            this.f15647b = arrayList;
            this.f15648c = arrayList2;
            this.f15649d = arrayList3;
            this.f15650e = arrayList4;
        }

        public void run() {
            for (int i10 = 0; i10 < this.f15646a; i10++) {
                ViewCompat.setTransitionName((View) this.f15647b.get(i10), (String) this.f15648c.get(i10));
                ViewCompat.setTransitionName((View) this.f15649d.get(i10), (String) this.f15650e.get(i10));
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f15652a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f15653b;

        b(ArrayList arrayList, Map map) {
            this.f15652a = arrayList;
            this.f15653b = map;
        }

        public void run() {
            int size = this.f15652a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f15652a.get(i10);
                String transitionName = ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view, FragmentTransitionImpl.findKeyForValue(this.f15653b, transitionName));
                }
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f15655a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f15656b;

        c(ArrayList arrayList, Map map) {
            this.f15655a = arrayList;
            this.f15656b = map;
        }

        public void run() {
            int size = this.f15655a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f15655a.get(i10);
                ViewCompat.setTransitionName(view, (String) this.f15656b.get(ViewCompat.getTransitionName(view)));
            }
        }
    }

    protected static void bfsAddViewChildren(List<View> list, View view) {
        int size = list.size();
        if (!containedBeforeIndex(list, view, size)) {
            if (ViewCompat.getTransitionName(view) != null) {
                list.add(view);
            }
            for (int i10 = size; i10 < list.size(); i10++) {
                View view2 = list.get(i10);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i11 = 0; i11 < childCount; i11++) {
                        View childAt = viewGroup.getChildAt(i11);
                        if (!containedBeforeIndex(list, childAt, size) && ViewCompat.getTransitionName(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    private static boolean containedBeforeIndex(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    static String findKeyForValue(Map<String, String> map, String str) {
        for (Map.Entry next : map.entrySet()) {
            if (str.equals(next.getValue())) {
                return (String) next.getKey();
            }
        }
        return null;
    }

    protected static boolean isNullOrEmpty(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        return false;
    }

    public abstract void addTarget(Object obj, View view);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    /* access modifiers changed from: package-private */
    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                captureTransitioningViews(arrayList, viewGroup.getChildAt(i10));
            }
            return;
        }
        arrayList.add(view);
    }

    public abstract Object cloneTransition(Object obj);

    /* access modifiers changed from: package-private */
    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        if (view.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    findNamedViews(map, viewGroup.getChildAt(i10));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void getBoundsOnScreen(View view, Rect rect) {
        if (ViewCompat.isAttachedToWindow(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset((float) view.getLeft(), (float) view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
                view2.getMatrix().mapRect(rectF);
                rectF.offset((float) view2.getLeft(), (float) view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset((float) iArr[0], (float) iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    /* access modifiers changed from: package-private */
    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, (String) null);
        }
        return arrayList2;
    }

    public abstract void removeTarget(Object obj, View view);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    /* access modifiers changed from: package-private */
    public void scheduleNameReset(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(viewGroup, new c(arrayList, map));
    }

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view);

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        runnable.run();
    }

    /* access modifiers changed from: package-private */
    public void setNameOverridesOrdered(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(view, new b(arrayList, map));
    }

    /* access modifiers changed from: package-private */
    public void setNameOverridesReordered(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String transitionName = ViewCompat.getTransitionName(view2);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view2, (String) null);
                String str = map.get(transitionName);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i11))) {
                        ViewCompat.setTransitionName(arrayList2.get(i11), transitionName);
                        break;
                    } else {
                        i11++;
                    }
                }
            }
        }
        OneShotPreDrawListener.add(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);
}
