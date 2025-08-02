package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import java.util.ArrayList;
import java.util.List;

class k extends FragmentTransitionImpl {

    class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f15791a;

        a(Rect rect) {
            this.f15791a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f15791a;
        }
    }

    class b implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f15793a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f15794b;

        b(View view, ArrayList arrayList) {
            this.f15793a = view;
            this.f15794b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f15793a.setVisibility(8);
            int size = this.f15794b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f15794b.get(i10)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            transition.removeListener(this);
            transition.addListener(this);
        }
    }

    class c implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f15796a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f15797b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f15798c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f15799d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f15800e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f15801f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f15796a = obj;
            this.f15797b = arrayList;
            this.f15798c = obj2;
            this.f15799d = arrayList2;
            this.f15800e = obj3;
            this.f15801f = arrayList3;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f15796a;
            if (obj != null) {
                k.this.replaceTargets(obj, this.f15797b, (ArrayList) null);
            }
            Object obj2 = this.f15798c;
            if (obj2 != null) {
                k.this.replaceTargets(obj2, this.f15799d, (ArrayList) null);
            }
            Object obj3 = this.f15800e;
            if (obj3 != null) {
                k.this.replaceTargets(obj3, this.f15801f, (ArrayList) null);
            }
        }
    }

    class d implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f15803a;

        d(Runnable runnable) {
            this.f15803a = runnable;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            this.f15803a.run();
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    class e extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f15805a;

        e(Rect rect) {
            this.f15805a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f15805a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f15805a;
        }
    }

    k() {
    }

    private static boolean a(Transition transition) {
        if (!FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) {
            return true;
        }
        return false;
    }

    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void addTargets(Object obj, ArrayList arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i10 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i10 < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i10), arrayList);
                    i10++;
                }
            } else if (!a(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                while (i10 < size) {
                    transition.addTarget((View) arrayList.get(i10));
                    i10++;
                }
            }
        }
    }

    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void replaceTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        List<View> targets;
        int i10;
        Transition transition = (Transition) obj;
        int i11 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i11 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i11), arrayList, arrayList2);
                i11++;
            }
        } else if (!a(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            if (arrayList2 == null) {
                i10 = 0;
            } else {
                i10 = arrayList2.size();
            }
            while (i11 < i10) {
                transition.addTarget((View) arrayList2.get(i11));
                i11++;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                transition.removeTarget((View) arrayList.get(size));
            }
        }
    }

    public void scheduleHideFragmentView(Object obj, View view, ArrayList arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    public void setListenerForTransitionEnd(Fragment fragment, Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        ((Transition) obj).addListener(new d(runnable));
    }

    public void setSharedElementTargets(Object obj, View view, ArrayList arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, (View) arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public void swapSharedElementTargets(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new e(rect));
        }
    }
}
