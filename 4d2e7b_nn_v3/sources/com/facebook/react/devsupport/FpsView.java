package com.facebook.react.devsupport;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.debug.f;
import com.facebook.react.o;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class FpsView extends FrameLayout {

    /* renamed from: d  reason: collision with root package name */
    public static final a f2958d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final TextView f2959a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final f f2960b;

    /* renamed from: c  reason: collision with root package name */
    private final b f2961c = new b();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2962a;

        /* renamed from: b  reason: collision with root package name */
        private int f2963b;

        /* renamed from: c  reason: collision with root package name */
        private int f2964c;

        public b() {
        }

        public final void a() {
            this.f2962a = false;
            FpsView.this.post(this);
        }

        public final void b() {
            this.f2962a = true;
        }

        public void run() {
            if (!this.f2962a) {
                this.f2963b += FpsView.this.f2960b.d() - FpsView.this.f2960b.g();
                this.f2964c += FpsView.this.f2960b.c();
                FpsView fpsView = FpsView.this;
                fpsView.c(fpsView.f2960b.e(), FpsView.this.f2960b.f(), this.f2963b, this.f2964c);
                FpsView.this.f2960b.j();
                FpsView.this.postDelayed(this, 500);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FpsView(ReactContext reactContext) {
        super(reactContext);
        m.c(reactContext);
        View.inflate(reactContext, o.f20873b, this);
        View findViewById = findViewById(com.facebook.react.m.f20855l);
        m.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.f2959a = (TextView) findViewById;
        this.f2960b = new f(reactContext);
        c(0.0d, 0.0d, 0, 0);
    }

    /* access modifiers changed from: private */
    public final void c(double d10, double d11, int i10, int i11) {
        b0 b0Var = b0.f709a;
        String format = String.format(Locale.US, "UI: %.1f fps\n%d dropped so far\n%d stutters (4+) so far\nJS: %.1f fps", Arrays.copyOf(new Object[]{Double.valueOf(d10), Integer.valueOf(i10), Integer.valueOf(i11), Double.valueOf(d11)}, 4));
        m.e(format, "format(...)");
        this.f2959a.setText(format);
        z2.a.b("ReactNative", format);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2960b.j();
        f.l(this.f2960b, 0.0d, 1, (Object) null);
        this.f2961c.a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2960b.n();
        this.f2961c.b();
    }
}
