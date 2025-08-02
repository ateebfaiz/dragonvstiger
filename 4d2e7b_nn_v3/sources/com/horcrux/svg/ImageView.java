package com.horcrux.svg;

import a5.b;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.horcrux.svg.events.SvgLoadEvent;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import e5.d;
import i3.c;
import java.util.concurrent.atomic.AtomicBoolean;
import w2.i;
import z4.k;

@SuppressLint({"ViewConstructor"})
class ImageView extends RenderableView {

    /* renamed from: a  reason: collision with root package name */
    private SVGLength f9620a;

    /* renamed from: b  reason: collision with root package name */
    private SVGLength f9621b;

    /* renamed from: c  reason: collision with root package name */
    private SVGLength f9622c;

    /* renamed from: d  reason: collision with root package name */
    private SVGLength f9623d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f9624e;

    /* renamed from: f  reason: collision with root package name */
    private int f9625f;

    /* renamed from: g  reason: collision with root package name */
    private int f9626g;

    /* renamed from: h  reason: collision with root package name */
    private String f9627h;

    /* renamed from: i  reason: collision with root package name */
    private int f9628i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final AtomicBoolean f9629j = new AtomicBoolean(false);

    class a extends b {
        a() {
        }

        public void e(c cVar) {
            ImageView.this.f9629j.set(false);
            z2.a.J("ReactNative", cVar.c(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
        }

        public void g(Bitmap bitmap) {
            ImageView imageView = ImageView.this;
            e c10 = k1.c(imageView.mContext, imageView.getId());
            int f10 = k1.f(ImageView.this);
            int id2 = ImageView.this.getId();
            ImageView imageView2 = ImageView.this;
            c10.c(new SvgLoadEvent(f10, id2, imageView2.mContext, imageView2.f9624e, (float) bitmap.getWidth(), (float) bitmap.getHeight()));
            ImageView.this.f9629j.set(false);
            SvgView svgView = ImageView.this.getSvgView();
            if (svgView != null) {
                svgView.invalidate();
            }
        }
    }

    public ImageView(ReactContext reactContext) {
        super(reactContext);
    }

    private void r(Canvas canvas, Paint paint, Bitmap bitmap, float f10) {
        if (this.f9625f == 0 || this.f9626g == 0) {
            this.f9625f = bitmap.getWidth();
            this.f9626g = bitmap.getHeight();
        }
        RectF s10 = s();
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.f9625f, (float) this.f9626g);
        m0.a(rectF, s10, this.f9627h, this.f9628i).mapRect(rectF);
        canvas.clipPath(getPath(canvas, paint));
        Path clipPath = getClipPath(canvas, paint);
        if (clipPath != null) {
            canvas.clipPath(clipPath);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f10 * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        this.mCTM.mapRect(rectF);
        setClientRect(rectF);
    }

    private RectF s() {
        double relativeOnWidth = relativeOnWidth(this.f9620a);
        double relativeOnHeight = relativeOnHeight(this.f9621b);
        double relativeOnWidth2 = relativeOnWidth(this.f9622c);
        double relativeOnHeight2 = relativeOnHeight(this.f9623d);
        if (relativeOnWidth2 == 0.0d) {
            relativeOnWidth2 = (double) (((float) this.f9625f) * this.mScale);
        }
        if (relativeOnHeight2 == 0.0d) {
            relativeOnHeight2 = (double) (((float) this.f9626g) * this.mScale);
        }
        return new RectF((float) relativeOnWidth, (float) relativeOnHeight, (float) (relativeOnWidth + relativeOnWidth2), (float) (relativeOnHeight + relativeOnHeight2));
    }

    private void t(k kVar, k5.b bVar) {
        this.f9629j.set(true);
        kVar.g(bVar, this.mContext).e(new a(), i.g());
    }

    private void z(k kVar, k5.b bVar, Canvas canvas, Paint paint, float f10) {
        c3.a aVar;
        c k10 = kVar.k(bVar, this.mContext);
        try {
            aVar = (c3.a) k10.getResult();
            if (aVar == null) {
                k10.close();
                return;
            }
            e5.e eVar = (e5.e) aVar.p();
            if (!(eVar instanceof d)) {
                c3.a.m(aVar);
                k10.close();
                return;
            }
            Bitmap x10 = ((d) eVar).x();
            if (x10 == null) {
                c3.a.m(aVar);
                k10.close();
                return;
            }
            r(canvas, paint, x10, f10);
            c3.a.m(aVar);
            k10.close();
        } catch (Exception e10) {
            throw new IllegalStateException(e10);
        } catch (Exception e11) {
            throw new IllegalStateException(e11);
        } catch (Throwable th) {
            k10.close();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f10) {
        if (!this.f9629j.get()) {
            k a10 = p3.c.a();
            k5.b a11 = k5.b.a(new t7.a(this.mContext, this.f9624e).f());
            if (a10.q(a11)) {
                z(a10, a11, canvas, paint, f10 * this.mOpacity);
                return;
            }
            t(a10, a11);
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        this.mPath = path;
        path.addRect(s(), Path.Direction.CW);
        return this.mPath;
    }

    public void setAlign(String str) {
        this.f9627h = str;
        invalidate();
    }

    public void setMeetOrSlice(int i10) {
        this.f9628i = i10;
        invalidate();
    }

    public void u(Dynamic dynamic) {
        this.f9623d = SVGLength.b(dynamic);
        invalidate();
    }

    public void v(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString("uri");
            this.f9624e = string;
            if (string != null && !string.isEmpty()) {
                if (!readableMap.hasKey(Snapshot.WIDTH) || !readableMap.hasKey(Snapshot.HEIGHT)) {
                    this.f9625f = 0;
                    this.f9626g = 0;
                } else {
                    this.f9625f = readableMap.getInt(Snapshot.WIDTH);
                    this.f9626g = readableMap.getInt(Snapshot.HEIGHT);
                }
                if (Uri.parse(this.f9624e).getScheme() == null) {
                    t7.c.d().g(this.mContext, this.f9624e);
                }
            }
        }
    }

    public void w(Dynamic dynamic) {
        this.f9622c = SVGLength.b(dynamic);
        invalidate();
    }

    public void x(Dynamic dynamic) {
        this.f9620a = SVGLength.b(dynamic);
        invalidate();
    }

    public void y(Dynamic dynamic) {
        this.f9621b = SVGLength.b(dynamic);
        invalidate();
    }
}
