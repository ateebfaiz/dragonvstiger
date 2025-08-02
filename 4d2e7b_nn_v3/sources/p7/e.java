package p7;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.f;

public class e extends com.facebook.react.uimanager.e {
    public e(f fVar) {
        super(fVar);
    }

    public void a(View view, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing")) {
            ((f) this.f3579a).setNativeRefreshing(view, readableArray.getBoolean(0));
        }
    }

    public void b(View view, String str, Object obj) {
        float f10;
        boolean z10 = true;
        boolean z11 = false;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1354842768:
                if (str.equals("colors")) {
                    c10 = 1;
                    break;
                }
                break;
            case -885150488:
                if (str.equals("progressBackgroundColor")) {
                    c10 = 2;
                    break;
                }
                break;
            case -416037467:
                if (str.equals("progressViewOffset")) {
                    c10 = 3;
                    break;
                }
                break;
            case -321826009:
                if (str.equals("refreshing")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                f fVar = (f) this.f3579a;
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                fVar.setEnabled(view, z10);
                return;
            case 1:
                ((f) this.f3579a).setColors(view, (ReadableArray) obj);
                return;
            case 2:
                ((f) this.f3579a).setProgressBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 3:
                f fVar2 = (f) this.f3579a;
                if (obj == null) {
                    f10 = 0.0f;
                } else {
                    f10 = ((Double) obj).floatValue();
                }
                fVar2.setProgressViewOffset(view, f10);
                return;
            case 4:
                f fVar3 = (f) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                fVar3.setRefreshing(view, z11);
                return;
            case 5:
                ((f) this.f3579a).setSize(view, (String) obj);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
