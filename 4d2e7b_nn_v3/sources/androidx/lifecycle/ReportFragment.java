package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ReportFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private ActivityInitializationListener processListener;

    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void get$annotations(Activity activity) {
        }

        public final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
            m.f(activity, "activity");
            m.f(event, NotificationCompat.CATEGORY_EVENT);
            if (activity instanceof LifecycleRegistryOwner) {
                ((LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
                }
            }
        }

        public final ReportFragment get(Activity activity) {
            m.f(activity, "<this>");
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG);
            m.d(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            return (ReportFragment) findFragmentByTag;
        }

        public final void injectIfNeededIn(Activity activity) {
            m.f(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                LifecycleCallbacks.Companion.registerIn(activity);
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag(ReportFragment.REPORT_FRAGMENT_TAG) == null) {
                fragmentManager.beginTransaction().add(new ReportFragment(), ReportFragment.REPORT_FRAGMENT_TAG).commit();
                fragmentManager.executePendingTransactions();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @RequiresApi(29)
    public static final class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public static final class Companion {
            private Companion() {
            }

            public final void registerIn(Activity activity) {
                m.f(activity, "activity");
                j.a(activity, new LifecycleCallbacks());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final void registerIn(Activity activity) {
            Companion.registerIn(activity);
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            m.f(activity, "activity");
            ReportFragment.Companion.dispatch$lifecycle_runtime_release(activity, Lifecycle.Event.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.f(activity, "activity");
            m.f(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            m.f(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            m.f(activity, "activity");
        }
    }

    private final void dispatch(Lifecycle.Event event) {
        if (Build.VERSION.SDK_INT < 29) {
            Companion companion = Companion;
            Activity activity = getActivity();
            m.e(activity, "activity");
            companion.dispatch$lifecycle_runtime_release(activity, event);
        }
    }

    public static final void dispatch$lifecycle_runtime_release(Activity activity, Lifecycle.Event event) {
        Companion.dispatch$lifecycle_runtime_release(activity, event);
    }

    private final void dispatchCreate(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private final void dispatchResume(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    private final void dispatchStart(ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    public static final ReportFragment get(Activity activity) {
        return Companion.get(activity);
    }

    public static final void injectIfNeededIn(Activity activity) {
        Companion.injectIfNeededIn(activity);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatchCreate(this.processListener);
        dispatch(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        dispatch(Lifecycle.Event.ON_DESTROY);
        this.processListener = null;
    }

    public void onPause() {
        super.onPause();
        dispatch(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        dispatchResume(this.processListener);
        dispatch(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        dispatchStart(this.processListener);
        dispatch(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        super.onStop();
        dispatch(Lifecycle.Event.ON_STOP);
    }

    public final void setProcessListener(ActivityInitializationListener activityInitializationListener) {
        this.processListener = activityInitializationListener;
    }
}
