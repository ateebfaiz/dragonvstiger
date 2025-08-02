package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SpannableBuilder extends SpannableStringBuilder {
    @NonNull
    private final Class<?> mWatcherClass;
    @NonNull
    private final List<a> mWatchers = new ArrayList();

    private static class a implements TextWatcher, SpanWatcher {

        /* renamed from: a  reason: collision with root package name */
        final Object f15421a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f15422b = new AtomicInteger(0);

        a(Object obj) {
            this.f15421a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f15422b.incrementAndGet();
        }

        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f15421a).afterTextChanged(editable);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f15421a).beforeTextChanged(charSequence, i10, i11, i12);
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f15422b.decrementAndGet();
        }

        public void onSpanAdded(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f15422b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f15421a).onSpanAdded(spannable, obj, i10, i11);
            }
        }

        public void onSpanChanged(Spannable spannable, Object obj, int i10, int i11, int i12, int i13) {
            int i14;
            int i15;
            if (this.f15422b.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT < 28) {
                    if (i10 > i11) {
                        i10 = 0;
                    }
                    if (i12 > i13) {
                        i15 = i10;
                        i14 = 0;
                        ((SpanWatcher) this.f15421a).onSpanChanged(spannable, obj, i15, i11, i14, i13);
                    }
                }
                i15 = i10;
                i14 = i12;
                ((SpanWatcher) this.f15421a).onSpanChanged(spannable, obj, i15, i11, i14, i13);
            }
        }

        public void onSpanRemoved(Spannable spannable, Object obj, int i10, int i11) {
            if (this.f15422b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f15421a).onSpanRemoved(spannable, obj, i10, i11);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            ((TextWatcher) this.f15421a).onTextChanged(charSequence, i10, i11, i12);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls) {
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    private void blockWatchers() {
        for (int i10 = 0; i10 < this.mWatchers.size(); i10++) {
            this.mWatchers.get(i10).a();
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static SpannableBuilder create(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void fireWatchers() {
        for (int i10 = 0; i10 < this.mWatchers.size(); i10++) {
            this.mWatchers.get(i10).onTextChanged(this, 0, length(), length());
        }
    }

    private a getWatcherFor(Object obj) {
        for (int i10 = 0; i10 < this.mWatchers.size(); i10++) {
            a aVar = this.mWatchers.get(i10);
            if (aVar.f15421a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean isWatcher(@Nullable Object obj) {
        return obj != null && isWatcher(obj.getClass());
    }

    private void unblockwatchers() {
        for (int i10 = 0; i10 < this.mWatchers.size(); i10++) {
            this.mWatchers.get(i10).c();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void beginBatchEdit() {
        blockWatchers();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void endBatchEdit() {
        unblockwatchers();
        fireWatchers();
    }

    public int getSpanEnd(@Nullable Object obj) {
        a watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanEnd(obj);
    }

    public int getSpanFlags(@Nullable Object obj) {
        a watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanFlags(obj);
    }

    public int getSpanStart(@Nullable Object obj) {
        a watcherFor;
        if (isWatcher(obj) && (watcherFor = getWatcherFor(obj)) != null) {
            obj = watcherFor;
        }
        return super.getSpanStart(obj);
    }

    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i10, int i11, @NonNull Class<T> cls) {
        if (!isWatcher((Class<?>) cls)) {
            return super.getSpans(i10, i11, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i10, i11, a.class);
        T[] tArr = (Object[]) Array.newInstance(cls, aVarArr.length);
        for (int i12 = 0; i12 < aVarArr.length; i12++) {
            tArr[i12] = aVarArr[i12].f15421a;
        }
        return tArr;
    }

    public int nextSpanTransition(int i10, int i11, @Nullable Class<a> cls) {
        if (cls == null || isWatcher((Class<?>) cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i10, i11, cls);
    }

    public void removeSpan(@Nullable Object obj) {
        a aVar;
        if (isWatcher(obj)) {
            aVar = getWatcherFor(obj);
            if (aVar != null) {
                obj = aVar;
            }
        } else {
            aVar = null;
        }
        super.removeSpan(obj);
        if (aVar != null) {
            this.mWatchers.remove(aVar);
        }
    }

    public void setSpan(@Nullable Object obj, int i10, int i11, int i12) {
        if (isWatcher(obj)) {
            a aVar = new a(obj);
            this.mWatchers.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i10, i11, i12);
    }

    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i10, int i11) {
        return new SpannableBuilder(this.mWatcherClass, this, i10, i11);
    }

    private boolean isWatcher(@NonNull Class<?> cls) {
        return this.mWatcherClass == cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence) {
        blockWatchers();
        super.replace(i10, i11, charSequence);
        unblockwatchers();
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence) {
        super(charSequence);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence, int i12, int i13) {
        blockWatchers();
        super.replace(i10, i11, charSequence, i12, i13);
        unblockwatchers();
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @NonNull
    public SpannableStringBuilder append(char c10) {
        super.append(c10);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    SpannableBuilder(@NonNull Class<?> cls, @NonNull CharSequence charSequence, int i10, int i11) {
        super(charSequence, i10, i11);
        Preconditions.checkNotNull(cls, "watcherClass cannot be null");
        this.mWatcherClass = cls;
    }

    @NonNull
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i10) {
        super.append(charSequence, obj, i10);
        return this;
    }
}
