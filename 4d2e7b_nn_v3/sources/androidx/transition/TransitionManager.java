package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition = new AutoTransition();
    static ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap<>();
    private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap<>();

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        Transition f16646a;

        /* renamed from: b  reason: collision with root package name */
        ViewGroup f16647b;

        /* renamed from: androidx.transition.TransitionManager$a$a  reason: collision with other inner class name */
        class C0216a extends TransitionListenerAdapter {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ArrayMap f16648a;

            C0216a(ArrayMap arrayMap) {
                this.f16648a = arrayMap;
            }

            public void onTransitionEnd(Transition transition) {
                ((ArrayList) this.f16648a.get(a.this.f16647b)).remove(transition);
                transition.removeListener(this);
            }
        }

        a(Transition transition, ViewGroup viewGroup) {
            this.f16646a = transition;
            this.f16647b = viewGroup;
        }

        private void a() {
            this.f16647b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f16647b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!TransitionManager.sPendingTransitions.remove(this.f16647b)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<Transition>> runningTransitions = TransitionManager.getRunningTransitions();
            ArrayList arrayList = runningTransitions.get(this.f16647b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                runningTransitions.put(this.f16647b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f16646a);
            this.f16646a.addListener(new C0216a(runningTransitions));
            this.f16646a.captureValues(this.f16647b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f16647b);
                }
            }
            this.f16646a.playTransition(this.f16647b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.sPendingTransitions.remove(this.f16647b);
            ArrayList arrayList = TransitionManager.getRunningTransitions().get(this.f16647b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f16647b);
                }
            }
            this.f16646a.clearValues(true);
        }
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, (Transition) null);
    }

    private static void changeScene(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (!sPendingTransitions.contains(sceneRoot)) {
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (transition == null) {
                if (currentScene != null) {
                    currentScene.exit();
                }
                scene.enter();
                return;
            }
            sPendingTransitions.add(sceneRoot);
            Transition clone = transition.clone();
            clone.setSceneRoot(sceneRoot);
            if (currentScene != null && currentScene.isCreatedFromLayoutResource()) {
                clone.setCanRemoveViews(true);
            }
            sceneChangeSetup(sceneRoot, clone);
            scene.enter();
            sceneChangeRunTransition(sceneRoot, clone);
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        sPendingTransitions.remove(viewGroup);
        ArrayList arrayList = getRunningTransitions().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).forceToEnd(viewGroup);
            }
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference weakReference = sRunningTransitions.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        sRunningTransitions.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    private Transition getTransition(Scene scene) {
        Scene currentScene;
        ArrayMap arrayMap;
        Transition transition;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot != null && (currentScene = Scene.getCurrentScene(sceneRoot)) != null && (arrayMap = this.mScenePairTransitions.get(scene)) != null && (transition = (Transition) arrayMap.get(currentScene)) != null) {
            return transition;
        }
        Transition transition2 = this.mSceneTransitions.get(scene);
        if (transition2 != null) {
            return transition2;
        }
        return sDefaultTransition;
    }

    public static void go(@NonNull Scene scene) {
        changeScene(scene, sDefaultTransition);
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            a aVar = new a(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = getRunningTransitions().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        Scene currentScene = Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void transitionTo(@NonNull Scene scene) {
        changeScene(scene, getTransition(scene));
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!sPendingTransitions.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            sPendingTransitions.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition clone = transition.clone();
            sceneChangeSetup(viewGroup, clone);
            Scene.setCurrentScene(viewGroup, (Scene) null);
            sceneChangeRunTransition(viewGroup, clone);
        }
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        changeScene(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap arrayMap = this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mScenePairTransitions.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }
}
