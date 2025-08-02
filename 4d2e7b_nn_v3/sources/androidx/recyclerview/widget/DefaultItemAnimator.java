package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private static TimeInterpolator sDefaultInterpolator;
    ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();
    ArrayList<ArrayList<i>> mChangesList = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    ArrayList<ArrayList<j>> mMovesList = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    private ArrayList<i> mPendingChanges = new ArrayList<>();
    private ArrayList<j> mPendingMoves = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f16127a;

        a(ArrayList arrayList) {
            this.f16127a = arrayList;
        }

        public void run() {
            Iterator it = this.f16127a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                DefaultItemAnimator.this.animateMoveImpl(jVar.f16161a, jVar.f16162b, jVar.f16163c, jVar.f16164d, jVar.f16165e);
            }
            this.f16127a.clear();
            DefaultItemAnimator.this.mMovesList.remove(this.f16127a);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f16129a;

        b(ArrayList arrayList) {
            this.f16129a = arrayList;
        }

        public void run() {
            Iterator it = this.f16129a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateChangeImpl((i) it.next());
            }
            this.f16129a.clear();
            DefaultItemAnimator.this.mChangesList.remove(this.f16129a);
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f16131a;

        c(ArrayList arrayList) {
            this.f16131a = arrayList;
        }

        public void run() {
            Iterator it = this.f16131a.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it.next());
            }
            this.f16131a.clear();
            DefaultItemAnimator.this.mAdditionsList.remove(this.f16131a);
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f16133a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f16134b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16135c;

        d(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f16133a = viewHolder;
            this.f16134b = viewPropertyAnimator;
            this.f16135c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16134b.setListener((Animator.AnimatorListener) null);
            this.f16135c.setAlpha(1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.f16133a);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.f16133a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.f16133a);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f16137a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f16138b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f16139c;

        e(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f16137a = viewHolder;
            this.f16138b = view;
            this.f16139c = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            this.f16138b.setAlpha(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            this.f16139c.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchAddFinished(this.f16137a);
            DefaultItemAnimator.this.mAddAnimations.remove(this.f16137a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchAddStarting(this.f16137a);
        }
    }

    class f extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView.ViewHolder f16141a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16142b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16143c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f16144d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f16145e;

        f(RecyclerView.ViewHolder viewHolder, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f16141a = viewHolder;
            this.f16142b = i10;
            this.f16143c = view;
            this.f16144d = i11;
            this.f16145e = viewPropertyAnimator;
        }

        public void onAnimationCancel(Animator animator) {
            if (this.f16142b != 0) {
                this.f16143c.setTranslationX(0.0f);
            }
            if (this.f16144d != 0) {
                this.f16143c.setTranslationY(0.0f);
            }
        }

        public void onAnimationEnd(Animator animator) {
            this.f16145e.setListener((Animator.AnimatorListener) null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.f16141a);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.f16141a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.f16141a);
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16147a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f16148b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16149c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f16147a = iVar;
            this.f16148b = viewPropertyAnimator;
            this.f16149c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16148b.setListener((Animator.AnimatorListener) null);
            this.f16149c.setAlpha(1.0f);
            this.f16149c.setTranslationX(0.0f);
            this.f16149c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f16147a.f16155a, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f16147a.f16155a);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f16147a.f16155a, true);
        }
    }

    class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f16151a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f16152b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f16153c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f16151a = iVar;
            this.f16152b = viewPropertyAnimator;
            this.f16153c = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f16152b.setListener((Animator.AnimatorListener) null);
            this.f16153c.setAlpha(1.0f);
            this.f16153c.setTranslationX(0.0f);
            this.f16153c.setTranslationY(0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.f16151a.f16156b, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.f16151a.f16156b);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(Animator animator) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.f16151a.f16156b, false);
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f16161a;

        /* renamed from: b  reason: collision with root package name */
        public int f16162b;

        /* renamed from: c  reason: collision with root package name */
        public int f16163c;

        /* renamed from: d  reason: collision with root package name */
        public int f16164d;

        /* renamed from: e  reason: collision with root package name */
        public int f16165e;

        j(RecyclerView.ViewHolder viewHolder, int i10, int i11, int i12, int i13) {
            this.f16161a = viewHolder;
            this.f16162b = i10;
            this.f16163c = i11;
            this.f16164d = i12;
            this.f16165e = i13;
        }
    }

    private void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mRemoveAnimations.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new d(viewHolder, animate, view)).start();
    }

    private void endChangeAnimation(List<i> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (endChangeAnimationIfNecessary(iVar, viewHolder) && iVar.f16155a == null && iVar.f16156b == null) {
                list.remove(iVar);
            }
        }
    }

    private void endChangeAnimationIfNecessary(i iVar) {
        RecyclerView.ViewHolder viewHolder = iVar.f16155a;
        if (viewHolder != null) {
            endChangeAnimationIfNecessary(iVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f16156b;
        if (viewHolder2 != null) {
            endChangeAnimationIfNecessary(iVar, viewHolder2);
        }
    }

    private void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (sDefaultInterpolator == null) {
            sDefaultInterpolator = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(sDefaultInterpolator);
        endAnimation(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        viewHolder.itemView.setAlpha(0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.mAddAnimations.add(viewHolder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(viewHolder, view, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i10, int i11, int i12, int i13) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i10, i11, i12, i13);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        resetAnimation(viewHolder);
        int i14 = (int) (((float) (i12 - i10)) - translationX);
        int i15 = (int) (((float) (i13 - i11)) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX((float) (-i14));
            viewHolder2.itemView.setTranslationY((float) (-i15));
            viewHolder2.itemView.setAlpha(0.0f);
        }
        this.mPendingChanges.add(new i(viewHolder, viewHolder2, i10, i11, i12, i13));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateChangeImpl(i iVar) {
        View view;
        RecyclerView.ViewHolder viewHolder = iVar.f16155a;
        View view2 = null;
        if (viewHolder == null) {
            view = null;
        } else {
            view = viewHolder.itemView;
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.f16156b;
        if (viewHolder2 != null) {
            view2 = viewHolder2.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.mChangeAnimations.add(iVar.f16155a);
            duration.translationX((float) (iVar.f16159e - iVar.f16157c));
            duration.translationY((float) (iVar.f16160f - iVar.f16158d));
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.mChangeAnimations.add(iVar.f16156b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i10, int i11, int i12, int i13) {
        View view = viewHolder.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(viewHolder);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX((float) (-i14));
        }
        if (i15 != 0) {
            view.setTranslationY((float) (-i15));
        }
        this.mPendingMoves.add(new j(viewHolder, translationX, translationY, i12, i13));
        return true;
    }

    /* access modifiers changed from: package-private */
    public void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int i10, int i11, int i12, int i13) {
        View view = viewHolder.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.mMoveAnimations.add(viewHolder);
        animate.setDuration(getMoveDuration()).setListener(new f(viewHolder, i14, view, i15, animate)).start();
    }

    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (!list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.mPendingMoves.get(size).f16161a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.mChangesList.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size2);
            }
        }
        for (int size3 = this.mMovesList.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.mMovesList.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((j) arrayList2.get(size4)).f16161a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.mMovesList.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.mAdditionsList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.mAdditionsList.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.mAdditionsList.remove(size5);
                }
            }
        }
        this.mRemoveAnimations.remove(viewHolder);
        this.mAddAnimations.remove(viewHolder);
        this.mChangeAnimations.remove(viewHolder);
        this.mMoveAnimations.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    public void endAnimations() {
        int size = this.mPendingMoves.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.mPendingMoves.get(size);
            View view = jVar.f16161a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.f16161a);
            this.mPendingMoves.remove(size);
        }
        for (int size2 = this.mPendingRemovals.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.mPendingRemovals.get(size2));
            this.mPendingRemovals.remove(size2);
        }
        int size3 = this.mPendingAdditions.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.mPendingAdditions.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size3);
        }
        for (int size4 = this.mPendingChanges.size() - 1; size4 >= 0; size4--) {
            endChangeAnimationIfNecessary(this.mPendingChanges.get(size4));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            for (int size5 = this.mMovesList.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.mMovesList.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f16161a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.f16161a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.mAdditionsList.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.mAdditionsList.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.mAdditionsList.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.mChangesList.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.mChangesList.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    endChangeAnimationIfNecessary((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.mChangesList.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        if (!this.mPendingAdditions.isEmpty() || !this.mPendingChanges.isEmpty() || !this.mPendingMoves.isEmpty() || !this.mPendingRemovals.isEmpty() || !this.mMoveAnimations.isEmpty() || !this.mRemoveAnimations.isEmpty() || !this.mAddAnimations.isEmpty() || !this.mChangeAnimations.isEmpty() || !this.mMovesList.isEmpty() || !this.mAdditionsList.isEmpty() || !this.mChangesList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void runPendingAnimations() {
        long j10;
        long j11;
        boolean z10 = !this.mPendingRemovals.isEmpty();
        boolean z11 = !this.mPendingMoves.isEmpty();
        boolean z12 = !this.mPendingChanges.isEmpty();
        boolean z13 = !this.mPendingAdditions.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.ViewHolder> it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.mPendingRemovals.clear();
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    ViewCompat.postOnAnimationDelayed(((j) arrayList.get(0)).f16161a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList2);
                this.mPendingChanges.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    ViewCompat.postOnAnimationDelayed(((i) arrayList2.get(0)).f16155a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList3);
                this.mPendingAdditions.clear();
                c cVar = new c(arrayList3);
                if (z10 || z11 || z12) {
                    long j12 = 0;
                    if (z10) {
                        j10 = getRemoveDuration();
                    } else {
                        j10 = 0;
                    }
                    if (z11) {
                        j11 = getMoveDuration();
                    } else {
                        j11 = 0;
                    }
                    if (z12) {
                        j12 = getChangeDuration();
                    }
                    ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) arrayList3.get(0)).itemView, cVar, j10 + Math.max(j11, j12));
                    return;
                }
                cVar.run();
            }
        }
    }

    private static class i {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f16155a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ViewHolder f16156b;

        /* renamed from: c  reason: collision with root package name */
        public int f16157c;

        /* renamed from: d  reason: collision with root package name */
        public int f16158d;

        /* renamed from: e  reason: collision with root package name */
        public int f16159e;

        /* renamed from: f  reason: collision with root package name */
        public int f16160f;

        private i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f16155a = viewHolder;
            this.f16156b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f16155a + ", newHolder=" + this.f16156b + ", fromX=" + this.f16157c + ", fromY=" + this.f16158d + ", toX=" + this.f16159e + ", toY=" + this.f16160f + '}';
        }

        i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i10, int i11, int i12, int i13) {
            this(viewHolder, viewHolder2);
            this.f16157c = i10;
            this.f16158d = i11;
            this.f16159e = i12;
            this.f16160f = i13;
        }
    }

    private boolean endChangeAnimationIfNecessary(i iVar, RecyclerView.ViewHolder viewHolder) {
        boolean z10 = false;
        if (iVar.f16156b == viewHolder) {
            iVar.f16156b = null;
        } else if (iVar.f16155a != viewHolder) {
            return false;
        } else {
            iVar.f16155a = null;
            z10 = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z10);
        return true;
    }
}
