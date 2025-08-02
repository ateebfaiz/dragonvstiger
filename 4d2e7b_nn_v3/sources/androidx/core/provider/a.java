package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.FontsContractCompat;
import androidx.core.provider.f;

class a {

    /* renamed from: a  reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f15066a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f15067b;

    /* renamed from: androidx.core.provider.a$a  reason: collision with other inner class name */
    class C0189a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FontsContractCompat.FontRequestCallback f15068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Typeface f15069b;

        C0189a(FontsContractCompat.FontRequestCallback fontRequestCallback, Typeface typeface) {
            this.f15068a = fontRequestCallback;
            this.f15069b = typeface;
        }

        public void run() {
            this.f15068a.onTypefaceRetrieved(this.f15069b);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FontsContractCompat.FontRequestCallback f15071a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f15072b;

        b(FontsContractCompat.FontRequestCallback fontRequestCallback, int i10) {
            this.f15071a = fontRequestCallback;
            this.f15072b = i10;
        }

        public void run() {
            this.f15071a.onTypefaceRequestFailed(this.f15072b);
        }
    }

    a(FontsContractCompat.FontRequestCallback fontRequestCallback, Handler handler) {
        this.f15066a = fontRequestCallback;
        this.f15067b = handler;
    }

    private void a(int i10) {
        this.f15067b.post(new b(this.f15066a, i10));
    }

    private void c(Typeface typeface) {
        this.f15067b.post(new C0189a(this.f15066a, typeface));
    }

    /* access modifiers changed from: package-private */
    public void b(f.e eVar) {
        if (eVar.a()) {
            c(eVar.f15091a);
        } else {
            a(eVar.f15092b);
        }
    }

    a(FontsContractCompat.FontRequestCallback fontRequestCallback) {
        this.f15066a = fontRequestCallback;
        this.f15067b = b.a();
    }
}
