package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;
import androidx.fragment.app.j;

abstract class c {

    class a implements CancellationSignal.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f15705a;

        a(Fragment fragment) {
            this.f15705a = fragment;
        }

        public void onCancel() {
            if (this.f15705a.getAnimatingAway() != null) {
                View animatingAway = this.f15705a.getAnimatingAway();
                this.f15705a.setAnimatingAway((View) null);
                animatingAway.clearAnimation();
            }
            this.f15705a.setAnimator((Animator) null);
        }
    }

    class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15706a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Fragment f15707b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j.g f15708c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f15709d;

        class a implements Runnable {
            a() {
            }

            public void run() {
                if (b.this.f15707b.getAnimatingAway() != null) {
                    b.this.f15707b.setAnimatingAway((View) null);
                    b bVar = b.this;
                    bVar.f15708c.a(bVar.f15707b, bVar.f15709d);
                }
            }
        }

        b(ViewGroup viewGroup, Fragment fragment, j.g gVar, CancellationSignal cancellationSignal) {
            this.f15706a = viewGroup;
            this.f15707b = fragment;
            this.f15708c = gVar;
            this.f15709d = cancellationSignal;
        }

        public void onAnimationEnd(Animation animation) {
            this.f15706a.post(new a());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    class C0202c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f15711a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f15712b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Fragment f15713c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ j.g f15714d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CancellationSignal f15715e;

        C0202c(ViewGroup viewGroup, View view, Fragment fragment, j.g gVar, CancellationSignal cancellationSignal) {
            this.f15711a = viewGroup;
            this.f15712b = view;
            this.f15713c = fragment;
            this.f15714d = gVar;
            this.f15715e = cancellationSignal;
        }

        public void onAnimationEnd(Animator animator) {
            this.f15711a.endViewTransition(this.f15712b);
            Animator animator2 = this.f15713c.getAnimator();
            this.f15713c.setAnimator((Animator) null);
            if (animator2 != null && this.f15711a.indexOfChild(this.f15712b) < 0) {
                this.f15714d.a(this.f15713c, this.f15715e);
            }
        }
    }

    static void a(Fragment fragment, d dVar, j.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new a(fragment));
        gVar.b(fragment, cancellationSignal);
        if (dVar.f15716a != null) {
            e eVar = new e(dVar.f15716a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, cancellationSignal));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f15717b;
        fragment.setAnimator(animator);
        animator.addListener(new C0202c(viewGroup, view, fragment, gVar, cancellationSignal));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int b(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z10) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b A[SYNTHETIC, Splitter:B:31:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static androidx.fragment.app.c.d c(android.content.Context r4, androidx.fragment.app.Fragment r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.getNextTransition()
            int r7 = b(r5, r6, r7)
            r1 = 0
            r5.setAnimations(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.mContainer
            r2 = 0
            if (r1 == 0) goto L_0x0020
            int r3 = androidx.fragment.R.id.visible_removing_fragment_view_tag
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L_0x0020
            android.view.ViewGroup r1 = r5.mContainer
            int r3 = androidx.fragment.R.id.visible_removing_fragment_view_tag
            r1.setTag(r3, r2)
        L_0x0020:
            android.view.ViewGroup r1 = r5.mContainer
            if (r1 == 0) goto L_0x002b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L_0x002b
            return r2
        L_0x002b:
            android.view.animation.Animation r1 = r5.onCreateAnimation(r0, r6, r7)
            if (r1 == 0) goto L_0x0037
            androidx.fragment.app.c$d r4 = new androidx.fragment.app.c$d
            r4.<init>((android.view.animation.Animation) r1)
            return r4
        L_0x0037:
            android.animation.Animator r5 = r5.onCreateAnimator(r0, r6, r7)
            if (r5 == 0) goto L_0x0043
            androidx.fragment.app.c$d r4 = new androidx.fragment.app.c$d
            r4.<init>((android.animation.Animator) r5)
            return r4
        L_0x0043:
            if (r7 != 0) goto L_0x004b
            if (r0 == 0) goto L_0x004b
            int r7 = d(r0, r6)
        L_0x004b:
            if (r7 == 0) goto L_0x0087
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x006b
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            if (r6 == 0) goto L_0x0087
            androidx.fragment.app.c$d r0 = new androidx.fragment.app.c$d     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            r0.<init>((android.view.animation.Animation) r6)     // Catch:{ NotFoundException -> 0x0069, RuntimeException -> 0x006b }
            return r0
        L_0x0069:
            r4 = move-exception
            throw r4
        L_0x006b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch:{ RuntimeException -> 0x0077 }
            if (r6 == 0) goto L_0x0087
            androidx.fragment.app.c$d r0 = new androidx.fragment.app.c$d     // Catch:{ RuntimeException -> 0x0077 }
            r0.<init>((android.animation.Animator) r6)     // Catch:{ RuntimeException -> 0x0077 }
            return r0
        L_0x0077:
            r6 = move-exception
            if (r5 != 0) goto L_0x0086
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L_0x0087
            androidx.fragment.app.c$d r5 = new androidx.fragment.app.c$d
            r5.<init>((android.view.animation.Animation) r4)
            return r5
        L_0x0086:
            throw r6
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.c.c(android.content.Context, androidx.fragment.app.Fragment, boolean, boolean):androidx.fragment.app.c$d");
    }

    private static int d(int i10, boolean z10) {
        if (i10 != 4097) {
            if (i10 != 4099) {
                if (i10 != 8194) {
                    return -1;
                }
                if (z10) {
                    return R.animator.fragment_close_enter;
                }
                return R.animator.fragment_close_exit;
            } else if (z10) {
                return R.animator.fragment_fade_enter;
            } else {
                return R.animator.fragment_fade_exit;
            }
        } else if (z10) {
            return R.animator.fragment_open_enter;
        } else {
            return R.animator.fragment_open_exit;
        }
    }

    static class d {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f15716a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f15717b;

        d(Animation animation) {
            this.f15716a = animation;
            this.f15717b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        d(Animator animator) {
            this.f15716a = null;
            this.f15717b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class e extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f15718a;

        /* renamed from: b  reason: collision with root package name */
        private final View f15719b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15720c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f15721d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f15722e = true;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f15718a = viewGroup;
            this.f15719b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public boolean getTransformation(long j10, Transformation transformation) {
            this.f15722e = true;
            if (this.f15720c) {
                return !this.f15721d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f15720c = true;
                OneShotPreDrawListener.add(this.f15718a, this);
            }
            return true;
        }

        public void run() {
            if (this.f15720c || !this.f15722e) {
                this.f15718a.endViewTransition(this.f15719b);
                this.f15721d = true;
                return;
            }
            this.f15722e = false;
            this.f15718a.post(this);
        }

        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f15722e = true;
            if (this.f15720c) {
                return !this.f15721d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f15720c = true;
                OneShotPreDrawListener.add(this.f15718a, this);
            }
            return true;
        }
    }
}
