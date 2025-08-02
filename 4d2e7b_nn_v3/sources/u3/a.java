package u3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import v3.b;
import w3.p;

public class a extends Drawable implements b {
    private final Paint C = new Paint(1);
    private int N0;
    private int O0;
    private int P0;
    private int Q0;
    private int R0;
    private long S0;
    private String T0;
    private int U0 = -1;
    private int V0 = 0;
    private final Matrix X = new Matrix();
    private final Rect Y = new Rect();
    private final RectF Z = new RectF();

    /* renamed from: a  reason: collision with root package name */
    private String f24332a;

    /* renamed from: b  reason: collision with root package name */
    private String f24333b;

    /* renamed from: c  reason: collision with root package name */
    private int f24334c;

    /* renamed from: d  reason: collision with root package name */
    private int f24335d;

    /* renamed from: e  reason: collision with root package name */
    private int f24336e;

    /* renamed from: f  reason: collision with root package name */
    private String f24337f;

    /* renamed from: g  reason: collision with root package name */
    private p.b f24338g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f24339h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private int f24340i;

    /* renamed from: j  reason: collision with root package name */
    private int f24341j;

    /* renamed from: w  reason: collision with root package name */
    private int f24342w = 80;

    public a() {
        i();
    }

    private void c(Canvas canvas, String str, Object obj) {
        e(canvas, str, String.valueOf(obj), -1);
    }

    private void d(Canvas canvas, String str, String str2) {
        e(canvas, str, str2, -1);
    }

    private void e(Canvas canvas, String str, String str2, int i10) {
        String str3 = str + ": ";
        float measureText = this.C.measureText(str3);
        float measureText2 = this.C.measureText(str2);
        this.C.setColor(1711276032);
        int i11 = this.Q0;
        int i12 = this.R0;
        canvas.drawRect((float) (i11 - 4), (float) (i12 + 8), ((float) i11) + measureText + measureText2 + 4.0f, (float) (i12 + this.P0 + 8), this.C);
        this.C.setColor(-1);
        canvas.drawText(str3, (float) this.Q0, (float) this.R0, this.C);
        this.C.setColor(i10);
        canvas.drawText(str2, ((float) this.Q0) + measureText, (float) this.R0, this.C);
        this.R0 += this.P0;
    }

    private static String g(String str, Object... objArr) {
        if (objArr == null) {
            return str;
        }
        return String.format(Locale.US, str, objArr);
    }

    private void h(Rect rect, int i10, int i11) {
        int i12;
        int min = Math.min(40, Math.max(10, Math.min(rect.width() / i11, rect.height() / i10)));
        this.C.setTextSize((float) min);
        int i13 = min + 8;
        this.P0 = i13;
        int i14 = this.f24342w;
        if (i14 == 80) {
            this.P0 = i13 * -1;
        }
        this.N0 = rect.left + 10;
        if (i14 == 80) {
            i12 = rect.bottom - 10;
        } else {
            i12 = rect.top + 20;
        }
        this.O0 = i12;
    }

    public void a(long j10) {
        this.S0 = j10;
        invalidateSelf();
    }

    public void b(String str, String str2) {
        this.f24339h.put(str, str2);
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.C.setStyle(Paint.Style.STROKE);
        this.C.setStrokeWidth(2.0f);
        this.C.setColor(-26624);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.C);
        Paint paint = this.C;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.C.setColor(this.V0);
        canvas.drawRect((float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.C);
        this.C.setStyle(style);
        this.C.setStrokeWidth(0.0f);
        this.C.setColor(-1);
        this.Q0 = this.N0;
        this.R0 = this.O0;
        String str = this.f24333b;
        if (str != null) {
            d(canvas, "IDs", g("%s, %s", this.f24332a, str));
        } else {
            d(canvas, "ID", this.f24332a);
        }
        d(canvas, "D", g("%dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height())));
        if (bounds.height() > 0) {
            c(canvas, "DAR", Float.valueOf(((float) bounds.width()) / ((float) bounds.height())));
        }
        e(canvas, "I", g("%dx%d", Integer.valueOf(this.f24334c), Integer.valueOf(this.f24335d)), f(this.f24334c, this.f24335d, this.f24338g));
        int i10 = this.f24335d;
        if (i10 > 0) {
            c(canvas, "IAR", Float.valueOf(((float) this.f24334c) / ((float) i10)));
        }
        d(canvas, "I", g("%d KiB", Integer.valueOf(this.f24336e / 1024)));
        String str2 = this.f24337f;
        if (str2 != null) {
            d(canvas, "i format", str2);
        }
        int i11 = this.f24340i;
        if (i11 > 0) {
            d(canvas, "anim", g("f %d, l %d", Integer.valueOf(i11), Integer.valueOf(this.f24341j)));
        }
        p.b bVar = this.f24338g;
        if (bVar != null) {
            c(canvas, "scale", bVar);
        }
        long j10 = this.S0;
        if (j10 >= 0) {
            d(canvas, "t", g("%d ms", Long.valueOf(j10)));
        }
        String str3 = this.T0;
        if (str3 != null) {
            e(canvas, "origin", str3, this.U0);
        }
        for (Map.Entry entry : this.f24339h.entrySet()) {
            d(canvas, (String) entry.getKey(), (String) entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public int f(int i10, int i11, p.b bVar) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i10 > 0 && i11 > 0) {
            if (bVar != null) {
                Rect rect = this.Y;
                rect.top = 0;
                rect.left = 0;
                rect.right = width;
                rect.bottom = height;
                this.X.reset();
                bVar.a(this.X, this.Y, i10, i11, 0.0f, 0.0f);
                RectF rectF = this.Z;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                rectF.right = (float) i10;
                rectF.bottom = (float) i11;
                this.X.mapRect(rectF);
                width = Math.min(width, (int) this.Z.width());
                height = Math.min(height, (int) this.Z.height());
            }
            float f10 = (float) width;
            float f11 = f10 * 0.1f;
            float f12 = f10 * 0.5f;
            float f13 = (float) height;
            float f14 = 0.1f * f13;
            float f15 = f13 * 0.5f;
            int abs = Math.abs(i10 - width);
            int abs2 = Math.abs(i11 - height);
            float f16 = (float) abs;
            if (f16 < f11 && ((float) abs2) < f14) {
                return -16711936;
            }
            if (f16 >= f12 || ((float) abs2) >= f15) {
                return SupportMenu.CATEGORY_MASK;
            }
            return InputDeviceCompat.SOURCE_ANY;
        }
        return SupportMenu.CATEGORY_MASK;
    }

    public int getOpacity() {
        return -3;
    }

    public void i() {
        this.f24334c = -1;
        this.f24335d = -1;
        this.f24336e = -1;
        this.f24339h = new HashMap();
        this.f24340i = -1;
        this.f24341j = -1;
        this.f24337f = null;
        j((String) null);
        this.S0 = -1;
        this.T0 = null;
        this.U0 = -1;
        invalidateSelf();
    }

    public void j(String str) {
        if (str == null) {
            str = DevicePublicKeyStringDef.NONE;
        }
        this.f24332a = str;
        invalidateSelf();
    }

    public void k(int i10, int i11) {
        this.f24334c = i10;
        this.f24335d = i11;
        invalidateSelf();
    }

    public void l(int i10) {
        this.f24336e = i10;
    }

    public void m(p.b bVar) {
        this.f24338g = bVar;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        h(rect, 9, 8);
    }

    public void setAlpha(int i10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
