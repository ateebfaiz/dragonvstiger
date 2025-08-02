package t4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import r4.b;
import r4.e;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final r4.a f24149a;

    /* renamed from: b  reason: collision with root package name */
    private final b f24150b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f24151c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24152d;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24153a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                t4.d$c[] r0 = t4.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24153a = r0
                t4.d$c r1 = t4.d.c.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24153a     // Catch:{ NoSuchFieldError -> 0x001d }
                t4.d$c r1 = t4.d.c.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24153a     // Catch:{ NoSuchFieldError -> 0x0028 }
                t4.d$c r1 = t4.d.c.ABORT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24153a     // Catch:{ NoSuchFieldError -> 0x0033 }
                t4.d$c r1 = t4.d.c.SKIP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t4.d.a.<clinit>():void");
        }
    }

    public interface b {
        void a(int i10, Bitmap bitmap);

        c3.a b(int i10);
    }

    private enum c {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    public d(r4.a aVar, boolean z10, b bVar) {
        this.f24149a = aVar;
        this.f24150b = bVar;
        this.f24152d = z10;
        Paint paint = new Paint();
        this.f24151c = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    private void a(Canvas canvas, r4.b bVar) {
        int i10 = bVar.f23668b;
        int i11 = bVar.f23669c;
        canvas.drawRect((float) i10, (float) i11, (float) (i10 + bVar.f23670d), (float) (i11 + bVar.f23671e), this.f24151c);
    }

    private c b(int i10) {
        r4.b a10 = this.f24149a.a(i10);
        b.C0328b bVar = a10.f23673g;
        if (bVar == b.C0328b.DISPOSE_DO_NOT) {
            return c.REQUIRED;
        }
        if (bVar == b.C0328b.DISPOSE_TO_BACKGROUND) {
            if (c(a10)) {
                return c.NOT_REQUIRED;
            }
            return c.REQUIRED;
        } else if (bVar == b.C0328b.DISPOSE_TO_PREVIOUS) {
            return c.SKIP;
        } else {
            return c.ABORT;
        }
    }

    private boolean c(r4.b bVar) {
        if (bVar.f23668b == 0 && bVar.f23669c == 0 && bVar.f23670d == this.f24149a.h() && bVar.f23671e == this.f24149a.f()) {
            return true;
        }
        return false;
    }

    private boolean d(int i10) {
        if (i10 == 0) {
            return true;
        }
        r4.b a10 = this.f24149a.a(i10);
        r4.b a11 = this.f24149a.a(i10 - 1);
        if (a10.f23672f == b.a.NO_BLEND && c(a10)) {
            return true;
        }
        if (a11.f23673g != b.C0328b.DISPOSE_TO_BACKGROUND || !c(a11)) {
            return false;
        }
        return true;
    }

    private void e(Bitmap bitmap) {
        e i10 = this.f24149a.i();
        if (i10 != null) {
            i10.c();
        }
    }

    private int f(int i10, Canvas canvas) {
        while (i10 >= 0) {
            int i11 = a.f24153a[b(i10).ordinal()];
            if (i11 == 1) {
                r4.b a10 = this.f24149a.a(i10);
                c3.a b10 = this.f24150b.b(i10);
                if (b10 != null) {
                    try {
                        canvas.drawBitmap((Bitmap) b10.p(), 0.0f, 0.0f, (Paint) null);
                        if (a10.f23673g == b.C0328b.DISPOSE_TO_BACKGROUND) {
                            a(canvas, a10);
                        }
                        return i10 + 1;
                    } finally {
                        if (!this.f24152d) {
                            b10.close();
                        }
                    }
                } else if (d(i10)) {
                    return i10;
                }
            } else if (i11 == 2) {
                return i10 + 1;
            } else {
                if (i11 == 3) {
                    return i10;
                }
            }
            i10--;
        }
        return 0;
    }

    public void g(int i10, Bitmap bitmap) {
        this.f24149a.g(i10, new Canvas(bitmap));
    }

    public void h(int i10, Bitmap bitmap) {
        int i11;
        if (this.f24152d) {
            g(i10, bitmap);
            return;
        }
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (!d(i10)) {
            i11 = f(i10 - 1, canvas);
        } else {
            i11 = i10;
        }
        while (i11 < i10) {
            r4.b a10 = this.f24149a.a(i11);
            b.C0328b bVar = a10.f23673g;
            if (bVar != b.C0328b.DISPOSE_TO_PREVIOUS) {
                if (a10.f23672f == b.a.NO_BLEND) {
                    a(canvas, a10);
                }
                this.f24149a.c(i11, canvas);
                this.f24150b.a(i11, bitmap);
                if (bVar == b.C0328b.DISPOSE_TO_BACKGROUND) {
                    a(canvas, a10);
                }
            }
            i11++;
        }
        r4.b a11 = this.f24149a.a(i10);
        if (a11.f23672f == b.a.NO_BLEND) {
            a(canvas, a11);
        }
        this.f24149a.c(i10, canvas);
        e(bitmap);
    }
}
