package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public class ChangeClipBounds extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = {PROPNAME_CLIP};

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f16585a;

        a(View view) {
            this.f16585a = view;
        }

        public void onAnimationEnd(Animator animator) {
            ViewCompat.setClipBounds(this.f16585a, (Rect) null);
        }
    }

    public ChangeClipBounds() {
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() != 8) {
            Rect clipBounds = ViewCompat.getClipBounds(view);
            transitionValues.values.put(PROPNAME_CLIP, clipBounds);
            if (clipBounds == null) {
                transitionValues.values.put(PROPNAME_BOUNDS, new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup r8, androidx.transition.TransitionValues r9, androidx.transition.TransitionValues r10) {
        /*
            r7 = this;
            r8 = 0
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L_0x007f
            if (r10 == 0) goto L_0x007f
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.values
            java.lang.String r3 = "android:clipBounds:clip"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x007f
            java.util.Map<java.lang.String, java.lang.Object> r2 = r10.values
            boolean r2 = r2.containsKey(r3)
            if (r2 != 0) goto L_0x001a
            goto L_0x007f
        L_0x001a:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.values
            java.lang.Object r2 = r2.get(r3)
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            java.util.Map<java.lang.String, java.lang.Object> r4 = r10.values
            java.lang.Object r3 = r4.get(r3)
            android.graphics.Rect r3 = (android.graphics.Rect) r3
            if (r3 != 0) goto L_0x002e
            r4 = r0
            goto L_0x002f
        L_0x002e:
            r4 = r8
        L_0x002f:
            if (r2 != 0) goto L_0x0034
            if (r3 != 0) goto L_0x0034
            return r1
        L_0x0034:
            java.lang.String r5 = "android:clipBounds:bounds"
            if (r2 != 0) goto L_0x0042
            java.util.Map<java.lang.String, java.lang.Object> r9 = r9.values
            java.lang.Object r9 = r9.get(r5)
            r2 = r9
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            goto L_0x004d
        L_0x0042:
            if (r3 != 0) goto L_0x004d
            java.util.Map<java.lang.String, java.lang.Object> r9 = r10.values
            java.lang.Object r9 = r9.get(r5)
            r3 = r9
            android.graphics.Rect r3 = (android.graphics.Rect) r3
        L_0x004d:
            boolean r9 = r2.equals(r3)
            if (r9 == 0) goto L_0x0054
            return r1
        L_0x0054:
            android.view.View r9 = r10.view
            androidx.core.view.ViewCompat.setClipBounds(r9, r2)
            androidx.transition.n r9 = new androidx.transition.n
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r9.<init>(r1)
            android.view.View r1 = r10.view
            android.util.Property r5 = androidx.transition.b0.f16671c
            r6 = 2
            android.graphics.Rect[] r6 = new android.graphics.Rect[r6]
            r6[r8] = r2
            r6[r0] = r3
            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofObject(r1, r5, r9, r6)
            if (r4 == 0) goto L_0x007e
            android.view.View r9 = r10.view
            androidx.transition.ChangeClipBounds$a r10 = new androidx.transition.ChangeClipBounds$a
            r10.<init>(r9)
            r8.addListener(r10)
        L_0x007e:
            return r8
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeClipBounds.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
