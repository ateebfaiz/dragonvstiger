package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiTextViewHelper {
    private final b mHelper;

    private static class a extends b {

        /* renamed from: a  reason: collision with root package name */
        private final TextView f15480a;

        /* renamed from: b  reason: collision with root package name */
        private final b f15481b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f15482c = true;

        a(TextView textView) {
            this.f15480a = textView;
            this.f15481b = new b(textView);
        }

        private InputFilter[] g(InputFilter[] inputFilterArr) {
            for (b bVar : inputFilterArr) {
                if (bVar == this.f15481b) {
                    return inputFilterArr;
                }
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            System.arraycopy(inputFilterArr, 0, inputFilterArr2, 0, r0);
            inputFilterArr2[r0] = this.f15481b;
            return inputFilterArr2;
        }

        private SparseArray h(InputFilter[] inputFilterArr) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof b) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            return sparseArray;
        }

        private InputFilter[] i(InputFilter[] inputFilterArr) {
            SparseArray h10 = h(inputFilterArr);
            if (h10.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length - h10.size())];
            int i10 = 0;
            for (int i11 = 0; i11 < length; i11++) {
                if (h10.indexOfKey(i11) < 0) {
                    inputFilterArr2[i10] = inputFilterArr[i11];
                    i10++;
                }
            }
            return inputFilterArr2;
        }

        private TransformationMethod k(TransformationMethod transformationMethod) {
            if (transformationMethod instanceof d) {
                return ((d) transformationMethod).a();
            }
            return transformationMethod;
        }

        private void l() {
            this.f15480a.setFilters(a(this.f15480a.getFilters()));
        }

        private TransformationMethod m(TransformationMethod transformationMethod) {
            if (!(transformationMethod instanceof d) && !(transformationMethod instanceof PasswordTransformationMethod)) {
                return new d(transformationMethod);
            }
            return transformationMethod;
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (!this.f15482c) {
                return i(inputFilterArr);
            }
            return g(inputFilterArr);
        }

        public boolean b() {
            return this.f15482c;
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            if (z10) {
                e();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            this.f15482c = z10;
            e();
            l();
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f15480a.setTransformationMethod(f(this.f15480a.getTransformationMethod()));
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod f(TransformationMethod transformationMethod) {
            if (this.f15482c) {
                return m(transformationMethod);
            }
            return k(transformationMethod);
        }

        /* access modifiers changed from: package-private */
        public void j(boolean z10) {
            this.f15482c = z10;
        }
    }

    static class b {
        b() {
        }

        /* access modifiers changed from: package-private */
        public abstract InputFilter[] a(InputFilter[] inputFilterArr);

        public abstract boolean b();

        /* access modifiers changed from: package-private */
        public abstract void c(boolean z10);

        /* access modifiers changed from: package-private */
        public abstract void d(boolean z10);

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public abstract TransformationMethod f(TransformationMethod transformationMethod);
    }

    private static class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final a f15483a;

        c(TextView textView) {
            this.f15483a = new a(textView);
        }

        private boolean g() {
            return !EmojiCompat.isConfigured();
        }

        /* access modifiers changed from: package-private */
        public InputFilter[] a(InputFilter[] inputFilterArr) {
            if (g()) {
                return inputFilterArr;
            }
            return this.f15483a.a(inputFilterArr);
        }

        public boolean b() {
            return this.f15483a.b();
        }

        /* access modifiers changed from: package-private */
        public void c(boolean z10) {
            if (!g()) {
                this.f15483a.c(z10);
            }
        }

        /* access modifiers changed from: package-private */
        public void d(boolean z10) {
            if (g()) {
                this.f15483a.j(z10);
            } else {
                this.f15483a.d(z10);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (!g()) {
                this.f15483a.e();
            }
        }

        /* access modifiers changed from: package-private */
        public TransformationMethod f(TransformationMethod transformationMethod) {
            if (g()) {
                return transformationMethod;
            }
            return this.f15483a.f(transformationMethod);
        }
    }

    public EmojiTextViewHelper(@NonNull TextView textView) {
        this(textView, true);
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return this.mHelper.a(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.mHelper.b();
    }

    public void setAllCaps(boolean z10) {
        this.mHelper.c(z10);
    }

    public void setEnabled(boolean z10) {
        this.mHelper.d(z10);
    }

    public void updateTransformationMethod() {
        this.mHelper.e();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.mHelper.f(transformationMethod);
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z10) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (!z10) {
            this.mHelper = new c(textView);
        } else {
            this.mHelper = new a(textView);
        }
    }
}
