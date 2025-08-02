package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;

public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.c(), pair.d());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(kotlin.Pair<? extends F, ? extends S> pair) {
        return new Pair<>(pair.c(), pair.d());
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> pair) {
        return new kotlin.Pair<>(pair.first, pair.second);
    }
}
