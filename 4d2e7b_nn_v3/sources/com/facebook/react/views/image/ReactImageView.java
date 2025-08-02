package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import com.facebook.react.uimanager.n;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import e5.l;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import k5.c;
import t3.d;
import t7.b;
import w3.k;
import w3.p;
import x3.e;
import y2.j;
import y4.f;

public class ReactImageView extends GenericDraweeView {

    /* renamed from: i1  reason: collision with root package name */
    private static float[] f3990i1 = new float[4];
    /* access modifiers changed from: private */

    /* renamed from: j1  reason: collision with root package name */
    public static final Matrix f3991j1 = new Matrix();
    private Drawable C;
    private Drawable N0;
    private k O0;
    private int P0 = 0;
    private int Q0;
    private int R0;
    private float S0;
    private float T0 = Float.NaN;
    private float[] U0;
    /* access modifiers changed from: private */
    public p.b V0 = d.b();
    /* access modifiers changed from: private */
    public Shader.TileMode W0 = d.a();
    private boolean X0;
    private final t3.b Y0;
    private b Z0;

    /* renamed from: a1  reason: collision with root package name */
    private j5.a f3992a1;

    /* renamed from: b1  reason: collision with root package name */
    private g f3993b1;

    /* renamed from: c1  reason: collision with root package name */
    private d f3994c1;

    /* renamed from: d1  reason: collision with root package name */
    private Object f3995d1;

    /* renamed from: e1  reason: collision with root package name */
    private int f3996e1 = -1;

    /* renamed from: f1  reason: collision with root package name */
    private boolean f3997f1;

    /* renamed from: g1  reason: collision with root package name */
    private ReadableMap f3998g1;

    /* renamed from: h  reason: collision with root package name */
    private c f3999h = c.AUTO;

    /* renamed from: h1  reason: collision with root package name */
    private float f4000h1 = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    private final List f4001i = new LinkedList();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public t7.a f4002j;

    /* renamed from: w  reason: collision with root package name */
    private t7.a f4003w;

    class a extends g {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ e f4004f;

        a(e eVar) {
            this.f4004f = eVar;
        }

        public void i(String str, Throwable th) {
            this.f4004f.c(b.a(k1.f(ReactImageView.this), ReactImageView.this.getId(), th));
        }

        public void o(String str, Object obj) {
            this.f4004f.c(b.e(k1.f(ReactImageView.this), ReactImageView.this.getId()));
        }

        public void w(int i10, int i11) {
            this.f4004f.c(b.f(k1.f(ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.f4002j.d(), i10, i11));
        }

        /* renamed from: x */
        public void f(String str, l lVar, Animatable animatable) {
            if (lVar != null) {
                this.f4004f.c(b.d(k1.f(ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.f4002j.d(), lVar.getWidth(), lVar.getHeight()));
                this.f4004f.c(b.c(k1.f(ReactImageView.this), ReactImageView.this.getId()));
            }
        }
    }

    private class b extends k5.a {
        public c3.a a(Bitmap bitmap, w4.d dVar) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.V0.a(ReactImageView.f3991j1, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, ReactImageView.this.W0, ReactImageView.this.W0);
            bitmapShader.setLocalMatrix(ReactImageView.f3991j1);
            paint.setShader(bitmapShader);
            c3.a a10 = dVar.a(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas((Bitmap) a10.p()).drawRect(rect, paint);
                return a10.b();
            } finally {
                c3.a.m(a10);
            }
        }

        private b() {
        }
    }

    public ReactImageView(Context context, t3.b bVar, a aVar, Object obj) {
        super(context, l(context));
        this.Y0 = bVar;
        this.f3995d1 = obj;
        setLegacyVisibilityHandlingEnabled(true);
    }

    @Nullable
    private f getResizeOptions() {
        int round = Math.round(((float) getWidth()) * this.f4000h1);
        int round2 = Math.round(((float) getHeight()) * this.f4000h1);
        if (round <= 0 || round2 <= 0) {
            return null;
        }
        return new f(round, round2);
    }

    private static x3.a l(Context context) {
        x3.e a10 = x3.e.a(0.0f);
        a10.t(true);
        return new x3.b(context.getResources()).J(a10).a();
    }

    private void m(float[] fArr) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (!com.facebook.yoga.e.a(this.T0)) {
            f10 = this.T0;
        } else {
            f10 = 0.0f;
        }
        float[] fArr2 = this.U0;
        if (fArr2 == null || com.facebook.yoga.e.a(fArr2[0])) {
            f11 = f10;
        } else {
            f11 = this.U0[0];
        }
        fArr[0] = f11;
        float[] fArr3 = this.U0;
        if (fArr3 == null || com.facebook.yoga.e.a(fArr3[1])) {
            f12 = f10;
        } else {
            f12 = this.U0[1];
        }
        fArr[1] = f12;
        float[] fArr4 = this.U0;
        if (fArr4 == null || com.facebook.yoga.e.a(fArr4[2])) {
            f13 = f10;
        } else {
            f13 = this.U0[2];
        }
        fArr[2] = f13;
        float[] fArr5 = this.U0;
        if (fArr5 != null && !com.facebook.yoga.e.a(fArr5[3])) {
            f10 = this.U0[3];
        }
        fArr[3] = f10;
    }

    private boolean n() {
        if (this.f4001i.size() > 1) {
            return true;
        }
        return false;
    }

    private boolean o() {
        if (this.W0 != Shader.TileMode.CLAMP) {
            return true;
        }
        return false;
    }

    private void r() {
        this.f4002j = null;
        if (this.f4001i.isEmpty()) {
            this.f4001i.add(t7.a.e(getContext()));
        } else if (n()) {
            b.a a10 = t7.b.a(getWidth(), getHeight(), this.f4001i);
            this.f4002j = a10.f13067a;
            this.f4003w = a10.f13068b;
            return;
        }
        this.f4002j = (t7.a) this.f4001i.get(0);
    }

    private boolean s(t7.a aVar) {
        c cVar = this.f3999h;
        if (cVar == c.AUTO) {
            if (g3.f.l(aVar.f()) || g3.f.m(aVar.f())) {
                return true;
            }
            return false;
        } else if (cVar == c.RESIZE) {
            return true;
        } else {
            return false;
        }
    }

    private void t(String str) {
    }

    @Nullable
    public t7.a getImageSource() {
        return this.f4002j;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        boolean z10;
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 > 0 && i11 > 0) {
            if (this.X0 || n() || o()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.X0 = z10;
            p();
        }
    }

    public void p() {
        f fVar;
        if (this.X0) {
            if (!n() || (getWidth() > 0 && getHeight() > 0)) {
                r();
                t7.a aVar = this.f4002j;
                if (aVar != null) {
                    boolean s10 = s(aVar);
                    if (s10 && (getWidth() <= 0 || getHeight() <= 0)) {
                        return;
                    }
                    if (!o() || (getWidth() > 0 && getHeight() > 0)) {
                        x3.a aVar2 = (x3.a) getHierarchy();
                        aVar2.v(this.V0);
                        Drawable drawable = this.C;
                        if (drawable != null) {
                            aVar2.z(drawable, this.V0);
                        }
                        Drawable drawable2 = this.N0;
                        if (drawable2 != null) {
                            aVar2.z(drawable2, p.b.f24588g);
                        }
                        m(f3990i1);
                        x3.e q10 = aVar2.q();
                        float[] fArr = f3990i1;
                        q10.p(fArr[0], fArr[1], fArr[2], fArr[3]);
                        k kVar = this.O0;
                        if (kVar != null) {
                            kVar.b(this.Q0, this.S0);
                            this.O0.s(q10.d());
                            aVar2.w(this.O0);
                        }
                        q10.m(this.Q0, this.S0);
                        int i10 = this.R0;
                        if (i10 != 0) {
                            q10.r(i10);
                        } else {
                            q10.v(e.a.BITMAP_ONLY);
                        }
                        aVar2.C(q10);
                        int i11 = this.f3996e1;
                        if (i11 < 0) {
                            if (this.f4002j.g()) {
                                i11 = 0;
                            } else {
                                i11 = 300;
                            }
                        }
                        aVar2.y(i11);
                        LinkedList linkedList = new LinkedList();
                        j5.a aVar3 = this.f3992a1;
                        if (aVar3 != null) {
                            linkedList.add(aVar3);
                        }
                        b bVar = this.Z0;
                        if (bVar != null) {
                            linkedList.add(bVar);
                        }
                        k5.d c10 = e.c(linkedList);
                        if (s10) {
                            fVar = getResizeOptions();
                        } else {
                            fVar = null;
                        }
                        z6.a z10 = z6.a.z(c.w(this.f4002j.f()).H(c10).L(fVar).x(true).I(this.f3997f1), this.f3998g1);
                        this.Y0.z();
                        this.Y0.A(true).B(this.f3995d1).a(getController()).D(z10);
                        t7.a aVar4 = this.f4003w;
                        if (aVar4 != null) {
                            this.Y0.E(c.w(aVar4.f()).H(c10).L(fVar).x(true).I(this.f3997f1).a());
                        }
                        g gVar = this.f3993b1;
                        if (gVar == null || this.f3994c1 == null) {
                            d dVar = this.f3994c1;
                            if (dVar != null) {
                                this.Y0.C(dVar);
                            } else if (gVar != null) {
                                this.Y0.C(gVar);
                            }
                        } else {
                            t3.f fVar2 = new t3.f();
                            fVar2.b(this.f3993b1);
                            fVar2.b(this.f3994c1);
                            this.Y0.C(fVar2);
                        }
                        g gVar2 = this.f3993b1;
                        if (gVar2 != null) {
                            aVar2.B(gVar2);
                        }
                        setController(this.Y0.build());
                        this.X0 = false;
                        this.Y0.z();
                    }
                }
            }
        }
    }

    public void q(float f10, int i10) {
        if (this.U0 == null) {
            float[] fArr = new float[4];
            this.U0 = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!n.a(this.U0[i10], f10)) {
            this.U0[i10] = f10;
            this.X0 = true;
        }
    }

    public void setBackgroundColor(int i10) {
        if (this.P0 != i10) {
            this.P0 = i10;
            this.O0 = new k(i10);
            this.X0 = true;
        }
    }

    public void setBlurRadius(float f10) {
        int d10 = ((int) g0.d(f10)) / 2;
        if (d10 == 0) {
            this.f3992a1 = null;
        } else {
            this.f3992a1 = new j5.a(2, d10);
        }
        this.X0 = true;
    }

    public void setBorderColor(int i10) {
        if (this.Q0 != i10) {
            this.Q0 = i10;
            this.X0 = true;
        }
    }

    public void setBorderRadius(float f10) {
        if (!n.a(this.T0, f10)) {
            this.T0 = f10;
            this.X0 = true;
        }
    }

    public void setBorderWidth(float f10) {
        float d10 = g0.d(f10);
        if (!n.a(this.S0, d10)) {
            this.S0 = d10;
            this.X0 = true;
        }
    }

    public void setControllerListener(d dVar) {
        this.f3994c1 = dVar;
        this.X0 = true;
        p();
    }

    public void setDefaultSource(@Nullable String str) {
        Drawable e10 = t7.c.d().e(getContext(), str);
        if (!j.a(this.C, e10)) {
            this.C = e10;
            this.X0 = true;
        }
    }

    public void setFadeDuration(int i10) {
        this.f3996e1 = i10;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.f3998g1 = readableMap;
    }

    public void setLoadingIndicatorSource(@Nullable String str) {
        w3.b bVar;
        Drawable e10 = t7.c.d().e(getContext(), str);
        if (e10 != null) {
            bVar = new w3.b(e10, 1000);
        } else {
            bVar = null;
        }
        if (!j.a(this.N0, bVar)) {
            this.N0 = bVar;
            this.X0 = true;
        }
    }

    public void setOverlayColor(int i10) {
        if (this.R0 != i10) {
            this.R0 = i10;
            this.X0 = true;
        }
    }

    public void setProgressiveRenderingEnabled(boolean z10) {
        this.f3997f1 = z10;
    }

    public void setResizeMethod(c cVar) {
        if (this.f3999h != cVar) {
            this.f3999h = cVar;
            this.X0 = true;
        }
    }

    public void setResizeMultiplier(float f10) {
        if (Math.abs(this.f4000h1 - f10) > 1.0E-4f) {
            this.f4000h1 = f10;
            this.X0 = true;
        }
    }

    public void setScaleType(p.b bVar) {
        if (this.V0 != bVar) {
            this.V0 = bVar;
            this.X0 = true;
        }
    }

    public void setShouldNotifyLoadEvents(boolean z10) {
        boolean z11;
        if (this.f3993b1 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 != z11) {
            if (!z10) {
                this.f3993b1 = null;
            } else {
                this.f3993b1 = new a(k1.c((ReactContext) getContext(), getId()));
            }
            this.X0 = true;
        }
    }

    public void setSource(@Nullable ReadableArray readableArray) {
        LinkedList<t7.a> linkedList = new LinkedList<>();
        if (readableArray == null || readableArray.size() == 0) {
            linkedList.add(t7.a.e(getContext()));
        } else {
            if (readableArray.size() == 1) {
                ReadableMap map = readableArray.getMap(0);
                t7.a aVar = new t7.a(getContext(), map.getString("uri"));
                if (Uri.EMPTY.equals(aVar.f())) {
                    t(map.getString("uri"));
                    aVar = t7.a.e(getContext());
                }
                linkedList.add(aVar);
            } else {
                for (int i10 = 0; i10 < readableArray.size(); i10++) {
                    ReadableMap map2 = readableArray.getMap(i10);
                    t7.a aVar2 = new t7.a(getContext(), map2.getString("uri"), map2.getDouble(Snapshot.WIDTH), map2.getDouble(Snapshot.HEIGHT));
                    if (Uri.EMPTY.equals(aVar2.f())) {
                        t(map2.getString("uri"));
                        aVar2 = t7.a.e(getContext());
                    }
                    linkedList.add(aVar2);
                }
            }
        }
        if (!this.f4001i.equals(linkedList)) {
            this.f4001i.clear();
            for (t7.a add : linkedList) {
                this.f4001i.add(add);
            }
            this.X0 = true;
        }
    }

    public void setTileMode(Shader.TileMode tileMode) {
        if (this.W0 != tileMode) {
            this.W0 = tileMode;
            if (o()) {
                this.Z0 = new b();
            } else {
                this.Z0 = null;
            }
            this.X0 = true;
        }
    }
}
