package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"ViewConstructor"})
class FeFloodView extends FilterPrimitiveView {

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f9592e = Pattern.compile("[0-9.-]+");

    /* renamed from: c  reason: collision with root package name */
    public ReadableArray f9593c;

    /* renamed from: d  reason: collision with root package name */
    public float f9594d = 1.0f;

    public FeFloodView(ReactContext reactContext) {
        super(reactContext);
    }

    private void setupPaint(Paint paint, float f10, ReadableArray readableArray) {
        double d10;
        int i10;
        if (readableArray.getInt(0) == 0) {
            if (readableArray.size() == 2) {
                if (readableArray.getType(1) == ReadableType.Map) {
                    i10 = ColorPropConverter.getColor(readableArray.getMap(1), getContext()).intValue();
                } else {
                    i10 = readableArray.getInt(1);
                }
                paint.setColor((Math.round(((float) (i10 >>> 24)) * f10) << 24) | (i10 & ViewCompat.MEASURED_SIZE_MASK));
                return;
            }
            if (readableArray.size() > 4) {
                d10 = readableArray.getDouble(4) * ((double) f10) * 255.0d;
            } else {
                d10 = (double) (f10 * 255.0f);
            }
            paint.setARGB((int) d10, (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
        }
    }

    public Bitmap p(HashMap hashMap, Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setFlags(129);
        paint.setStyle(Paint.Style.FILL);
        setupPaint(paint, this.f9594d, this.f9593c);
        canvas.drawPaint(paint);
        return createBitmap;
    }

    public void x(Dynamic dynamic) {
        int i10 = 0;
        if (dynamic == null || dynamic.isNull()) {
            this.f9593c = null;
            invalidate();
        } else if (dynamic.getType().equals(ReadableType.Map)) {
            y(dynamic.asMap());
        } else {
            ReadableType type = dynamic.getType();
            if (type.equals(ReadableType.Number)) {
                this.f9593c = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
            } else if (type.equals(ReadableType.Array)) {
                this.f9593c = dynamic.asArray();
            } else {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                javaOnlyArray.pushInt(0);
                Matcher matcher = f9592e.matcher(dynamic.asString());
                while (matcher.find()) {
                    double parseDouble = Double.parseDouble(matcher.group());
                    int i11 = i10 + 1;
                    if (i10 < 3) {
                        parseDouble /= 255.0d;
                    }
                    javaOnlyArray.pushDouble(parseDouble);
                    i10 = i11;
                }
                this.f9593c = javaOnlyArray;
            }
            invalidate();
        }
    }

    public void y(ReadableMap readableMap) {
        if (readableMap == null) {
            this.f9593c = null;
            invalidate();
            return;
        }
        int i10 = readableMap.getInt("type");
        if (i10 == 0) {
            ReadableType type = readableMap.getType("payload");
            if (type.equals(ReadableType.Number)) {
                this.f9593c = JavaOnlyArray.of(0, Integer.valueOf(readableMap.getInt("payload")));
            } else if (type.equals(ReadableType.Map)) {
                this.f9593c = JavaOnlyArray.of(0, readableMap.getMap("payload"));
            }
        } else if (i10 == 1) {
            this.f9593c = JavaOnlyArray.of(1, readableMap.getString("brushRef"));
        } else {
            this.f9593c = JavaOnlyArray.of(Integer.valueOf(i10));
        }
        invalidate();
    }

    public void z(float f10) {
        this.f9594d = f10;
        invalidate();
    }
}
