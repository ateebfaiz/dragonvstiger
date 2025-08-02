package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {

    class a extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f16615a;

        a(Rect rect) {
            this.f16615a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f16615a;
        }
    }

    class b implements Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f16617a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f16618b;

        b(View view, ArrayList arrayList) {
            this.f16617a = view;
            this.f16618b = arrayList;
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f16617a.setVisibility(8);
            int size = this.f16618b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f16618b.get(i10)).setVisibility(0);
            }
        }

        public void onTransitionPause(Transition transition) {
        }

        public void onTransitionResume(Transition transition) {
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    class c extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f16620a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f16621b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f16622c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f16623d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f16624e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f16625f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f16620a = obj;
            this.f16621b = arrayList;
            this.f16622c = obj2;
            this.f16623d = arrayList2;
            this.f16624e = obj3;
            this.f16625f = arrayList3;
        }

        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public void onTransitionStart(Transition transition) {
            Object obj = this.f16620a;
            if (obj != null) {
                FragmentTransitionSupport.this.replaceTargets(obj, this.f16621b, (ArrayList<View>) null);
            }
            Object obj2 = this.f16622c;
            if (obj2 != null) {
                FragmentTransitionSupport.this.replaceTargets(obj2, this.f16623d, (ArrayList<View>) null);
            }
            Object obj3 = this.f16624e;
            if (obj3 != null) {
                FragmentTransitionSupport.this.replaceTargets(obj3, this.f16625f, (ArrayList<View>) null);
            }
        }
    }

    class d extends Transition.EpicenterCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Rect f16627a;

        d(Rect rect) {
            this.f16627a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f16627a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f16627a;
        }
    }

    private static boolean hasSimpleTarget(Transition transition) {
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

    public void addTargets(Object obj, ArrayList<View> arrayList) {
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
            } else if (!hasSimpleTarget(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                while (i10 < size) {
                    transition.addTarget(arrayList.get(i10));
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

    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
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
        } else if (!hasSimpleTarget(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i10 = 0;
                } else {
                    i10 = arrayList2.size();
                }
                while (i11 < i10) {
                    transition.addTarget(arrayList2.get(i11));
                    i11++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new b(view, arrayList));
    }

    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new a(rect));
        }
    }

    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
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
            ((Transition) obj).setEpicenterCallback(new d(rect));
        }
    }
}
