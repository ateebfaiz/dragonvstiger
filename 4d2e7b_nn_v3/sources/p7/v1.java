package p7;

import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;

public interface v1 {
    void setClipPath(View view, String str);

    void setClipRule(View view, int i10);

    void setColor(View view, Integer num);

    void setDisplay(View view, String str);

    void setFill(View view, Dynamic dynamic);

    void setFillOpacity(View view, float f10);

    void setFillRule(View view, int i10);

    void setFilter(View view, String str);

    void setHeight(View view, Dynamic dynamic);

    void setMarkerEnd(View view, String str);

    void setMarkerMid(View view, String str);

    void setMarkerStart(View view, String str);

    void setMask(View view, String str);

    void setMatrix(View view, ReadableArray readableArray);

    void setName(View view, String str);

    void setPointerEvents(View view, String str);

    void setPropList(View view, ReadableArray readableArray);

    void setResponsible(View view, boolean z10);

    void setRx(View view, Dynamic dynamic);

    void setRy(View view, Dynamic dynamic);

    void setStroke(View view, Dynamic dynamic);

    void setStrokeDasharray(View view, Dynamic dynamic);

    void setStrokeDashoffset(View view, float f10);

    void setStrokeLinecap(View view, int i10);

    void setStrokeLinejoin(View view, int i10);

    void setStrokeMiterlimit(View view, float f10);

    void setStrokeOpacity(View view, float f10);

    void setStrokeWidth(View view, Dynamic dynamic);

    void setVectorEffect(View view, int i10);

    void setWidth(View view, Dynamic dynamic);

    void setX(View view, Dynamic dynamic);

    void setY(View view, Dynamic dynamic);
}
