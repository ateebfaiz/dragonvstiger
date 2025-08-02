package x3;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import w3.g;
import w3.s;
import w3.t;

public class d extends g implements s {

    /* renamed from: e  reason: collision with root package name */
    Drawable f24742e = null;

    /* renamed from: f  reason: collision with root package name */
    private t f24743f;

    public d(Drawable drawable) {
        super(drawable);
    }

    public void draw(Canvas canvas) {
        if (isVisible()) {
            t tVar = this.f24743f;
            if (tVar != null) {
                tVar.onDraw();
            }
            super.draw(canvas);
            Drawable drawable = this.f24742e;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.f24742e.draw(canvas);
            }
        }
    }

    public int getIntrinsicHeight() {
        return -1;
    }

    public int getIntrinsicWidth() {
        return -1;
    }

    public void n(t tVar) {
        this.f24743f = tVar;
    }

    public boolean setVisible(boolean z10, boolean z11) {
        t tVar = this.f24743f;
        if (tVar != null) {
            tVar.b(z10);
        }
        return super.setVisible(z10, z11);
    }

    public void w(Drawable drawable) {
        this.f24742e = drawable;
        invalidateSelf();
    }
}
