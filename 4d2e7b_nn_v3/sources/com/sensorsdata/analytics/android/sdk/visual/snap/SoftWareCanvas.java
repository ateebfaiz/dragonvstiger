package com.sensorsdata.analytics.android.sdk.visual.snap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.util.WeakSet;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;

public class SoftWareCanvas extends Canvas {
    private static final String TAG = "SA.SoftWareCanvas";
    private WeakSet<Bitmap> bitmapWeakSet = new WeakSet<>();
    private Bitmap mBitmap;

    public SoftWareCanvas(Bitmap bitmap) {
        super(bitmap);
        this.mBitmap = bitmap;
    }

    private Bitmap drawOnSFCanvas(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 26 || bitmap.getConfig() != Bitmap.Config.HARDWARE) {
            return bitmap;
        }
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
        this.bitmapWeakSet.add(copy);
        return copy;
    }

    private Paint replaceBitmapShader(Paint paint) {
        Class<BitmapShader> cls = BitmapShader.class;
        if (paint == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && (paint.getShader() instanceof BitmapShader)) {
            Paint paint2 = new Paint(paint);
            BitmapShader bitmapShader = (BitmapShader) paint2.getShader();
            try {
                Field field = cls.getField("mBitmap");
                field.setAccessible(true);
                if (((Bitmap) field.get(bitmapShader)).getConfig() == Bitmap.Config.HARDWARE) {
                    Field declaredField = cls.getDeclaredField("mTileX");
                    Field declaredField2 = cls.getDeclaredField("mTileY");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    Bitmap copy = ((Bitmap) field.get(bitmapShader)).copy(Bitmap.Config.ARGB_8888, false);
                    this.bitmapWeakSet.add(copy);
                    Class cls2 = Integer.TYPE;
                    Constructor<BitmapShader> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Bitmap.class, cls2, cls2});
                    declaredConstructor.setAccessible(true);
                    BitmapShader newInstance = declaredConstructor.newInstance(new Object[]{copy, declaredField.get(bitmapShader), declaredField2.get(bitmapShader)});
                    Matrix matrix = new Matrix();
                    paint.getShader().getLocalMatrix(matrix);
                    newInstance.setLocalMatrix(matrix);
                    paint2.setShader(newInstance);
                    return paint2;
                }
            } catch (Exception unused) {
            }
        }
        return paint;
    }

    public void destroy() {
        Iterator<Bitmap> it = this.bitmapWeakSet.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.bitmapWeakSet.clear();
    }

    public void drawArc(RectF rectF, float f10, float f11, boolean z10, Paint paint) {
        try {
            super.drawArc(rectF, f10, f11, z10, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawBitmap(Bitmap bitmap, float f10, float f11, Paint paint) {
        Bitmap drawOnSFCanvas = drawOnSFCanvas(bitmap);
        if (drawOnSFCanvas.getDensity() != this.mBitmap.getDensity()) {
            int i10 = (int) f10;
            int i11 = (int) f11;
            Rect rect = new Rect(i10, i11, drawOnSFCanvas.getWidth() + i10, drawOnSFCanvas.getHeight() + i11);
            super.drawBitmap(drawOnSFCanvas, rect, rect, replaceBitmapShader(paint));
            return;
        }
        super.drawBitmap(drawOnSFCanvas, f10, f11, replaceBitmapShader(paint));
    }

    public void drawBitmapMesh(Bitmap bitmap, int i10, int i11, float[] fArr, int i12, int[] iArr, int i13, Paint paint) {
        super.drawBitmapMesh(drawOnSFCanvas(bitmap), i10, i11, fArr, i12, iArr, i13, replaceBitmapShader(paint));
    }

    public void drawCircle(float f10, float f11, float f12, Paint paint) {
        try {
            super.drawCircle(f10, f11, f12, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawLine(float f10, float f11, float f12, float f13, Paint paint) {
        try {
            super.drawLine(f10, f11, f12, f13, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawLines(float[] fArr, int i10, int i11, Paint paint) {
        try {
            super.drawLines(fArr, i10, i11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawOval(RectF rectF, Paint paint) {
        try {
            super.drawOval(rectF, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPaint(Paint paint) {
        try {
            super.drawPaint(replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPath(Path path, Paint paint) {
        try {
            super.drawPath(path, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPoint(float f10, float f11, Paint paint) {
        try {
            super.drawPoint(f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPoints(float[] fArr, int i10, int i11, Paint paint) {
        try {
            super.drawPoints(fArr, i10, i11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPosText(char[] cArr, int i10, int i11, float[] fArr, Paint paint) {
        try {
            super.drawPosText(cArr, i10, i11, fArr, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawRect(RectF rectF, Paint paint) {
        try {
            super.drawRect(rectF, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawRoundRect(RectF rectF, float f10, float f11, Paint paint) {
        try {
            super.drawRoundRect(rectF, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawText(char[] cArr, int i10, int i11, float f10, float f11, Paint paint) {
        try {
            super.drawText(cArr, i10, i11, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawTextOnPath(char[] cArr, int i10, int i11, Path path, float f10, float f11, Paint paint) {
        try {
            super.drawTextOnPath(cArr, i10, i11, path, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public int saveLayer(RectF rectF, Paint paint, int i10) {
        return super.saveLayer(rectF, replaceBitmapShader(paint), i10);
    }

    public void setBitmap(Bitmap bitmap) {
        super.setBitmap(drawOnSFCanvas(bitmap));
    }

    public void drawLines(float[] fArr, Paint paint) {
        try {
            super.drawLines(fArr, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawOval(float f10, float f11, float f12, float f13, Paint paint) {
        try {
            super.drawOval(f10, f11, f12, f13, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPoints(float[] fArr, Paint paint) {
        try {
            super.drawPoints(fArr, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawPosText(String str, float[] fArr, Paint paint) {
        try {
            super.drawPosText(str, fArr, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawRect(Rect rect, Paint paint) {
        try {
            super.drawRect(rect, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawRoundRect(float f10, float f11, float f12, float f13, float f14, float f15, Paint paint) {
        try {
            super.drawRoundRect(f10, f11, f12, f13, f14, f15, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawText(String str, float f10, float f11, Paint paint) {
        try {
            super.drawText(str, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawTextOnPath(String str, Path path, float f10, float f11, Paint paint) {
        try {
            super.drawTextOnPath(str, path, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public int saveLayer(RectF rectF, Paint paint) {
        return super.saveLayer(rectF, replaceBitmapShader(paint));
    }

    public void drawRect(float f10, float f11, float f12, float f13, Paint paint) {
        try {
            super.drawRect(f10, f11, f12, f13, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawText(String str, int i10, int i11, float f10, float f11, Paint paint) {
        try {
            super.drawText(str, i10, i11, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public int saveLayer(float f10, float f11, float f12, float f13, Paint paint, int i10) {
        return super.saveLayer(f10, f11, f12, f13, replaceBitmapShader(paint), i10);
    }

    public void drawText(CharSequence charSequence, int i10, int i11, float f10, float f11, Paint paint) {
        try {
            super.drawText(charSequence, i10, i11, f10, f11, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public int saveLayer(float f10, float f11, float f12, float f13, Paint paint) {
        return super.saveLayer(f10, f11, f12, f13, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rectF, replaceBitmapShader(paint));
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        super.drawBitmap(drawOnSFCanvas(bitmap), rect, rect2, replaceBitmapShader(paint));
    }

    public void drawBitmap(int[] iArr, int i10, int i11, float f10, float f11, int i12, int i13, boolean z10, Paint paint) {
        try {
            super.drawBitmap(iArr, i10, i11, f10, f11, i12, i13, z10, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawBitmap(int[] iArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10, Paint paint) {
        try {
            super.drawBitmap(iArr, i10, i11, i12, i13, i14, i15, z10, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        try {
            super.drawBitmap(drawOnSFCanvas(bitmap), matrix, replaceBitmapShader(paint));
        } catch (Exception unused) {
        }
    }
}
