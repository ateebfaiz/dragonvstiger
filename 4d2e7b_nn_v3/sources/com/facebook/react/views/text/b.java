package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public abstract class b {
    public static WritableArray a(CharSequence charSequence, Layout layout, TextPaint textPaint, Context context) {
        float f10;
        CharSequence charSequence2 = charSequence;
        Layout layout2 = layout;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WritableArray createArray = Arguments.createArray();
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(textPaint2.getTextSize() * 100.0f);
        Rect rect = new Rect();
        int i10 = 0;
        int i11 = 1;
        textPaint2.getTextBounds(ExifInterface.GPS_DIRECTION_TRUE, 0, 1, rect);
        double height = (double) ((((float) rect.height()) / 100.0f) / displayMetrics.density);
        Rect rect2 = new Rect();
        textPaint2.getTextBounds("x", 0, 1, rect2);
        double height2 = (double) ((((float) rect2.height()) / 100.0f) / displayMetrics.density);
        while (i10 < layout.getLineCount()) {
            if (charSequence.length() <= 0 || charSequence2.charAt(layout2.getLineEnd(i10) - i11) != 10) {
                f10 = layout2.getLineWidth(i10);
            } else {
                f10 = layout2.getLineMax(i10);
            }
            Rect rect3 = new Rect();
            layout2.getLineBounds(i10, rect3);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("x", (double) (layout2.getLineLeft(i10) / displayMetrics.density));
            createMap.putDouble("y", (double) (((float) rect3.top) / displayMetrics.density));
            createMap.putDouble(Snapshot.WIDTH, (double) (f10 / displayMetrics.density));
            createMap.putDouble(Snapshot.HEIGHT, (double) (((float) rect3.height()) / displayMetrics.density));
            createMap.putDouble("descender", (double) (((float) layout2.getLineDescent(i10)) / displayMetrics.density));
            createMap.putDouble("ascender", (double) (((float) (-layout2.getLineAscent(i10))) / displayMetrics.density));
            createMap.putDouble("baseline", (double) (((float) layout2.getLineBaseline(i10)) / displayMetrics.density));
            createMap.putDouble("capHeight", height);
            createMap.putDouble("xHeight", height2);
            createMap.putString("text", charSequence2.subSequence(layout2.getLineStart(i10), layout2.getLineEnd(i10)).toString());
            createArray.pushMap(createMap);
            i10++;
            i11 = 1;
        }
        return createArray;
    }
}
