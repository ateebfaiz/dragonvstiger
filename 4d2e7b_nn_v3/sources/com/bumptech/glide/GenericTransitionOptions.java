package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int i10) {
        return (GenericTransitionOptions) new GenericTransitionOptions().transition(i10);
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return (GenericTransitionOptions) new GenericTransitionOptions().dontTransition();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GenericTransitionOptions) || !super.equals(obj)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(@NonNull ViewPropertyTransition.Animator animator) {
        return (GenericTransitionOptions) new GenericTransitionOptions().transition(animator);
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        return (GenericTransitionOptions) new GenericTransitionOptions().transition(transitionFactory);
    }
}
