package p7;

import android.view.View;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;

public class c extends e {
    public c(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        double d10;
        String str2;
        boolean z10 = true;
        boolean z11 = false;
        str.hashCode();
        String str3 = null;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1001078227:
                if (str.equals(NotificationCompat.CATEGORY_PROGRESS)) {
                    c10 = 0;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    c10 = 1;
                    break;
                }
                break;
            case -676876213:
                if (str.equals("typeAttr")) {
                    c10 = 2;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c10 = 3;
                    break;
                }
                break;
            case 633138363:
                if (str.equals("indeterminate")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1118509918:
                if (str.equals("animating")) {
                    c10 = 5;
                    break;
                }
                break;
            case 1804741442:
                if (str.equals("styleAttr")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                d dVar = (d) this.f3579a;
                if (obj == null) {
                    d10 = 0.0d;
                } else {
                    d10 = ((Double) obj).doubleValue();
                }
                dVar.setProgress(view, d10);
                return;
            case 1:
                d dVar2 = (d) this.f3579a;
                if (obj == null) {
                    str2 = "";
                } else {
                    str2 = (String) obj;
                }
                dVar2.setTestID(view, str2);
                return;
            case 2:
                d dVar3 = (d) this.f3579a;
                if (obj != null) {
                    str3 = (String) obj;
                }
                dVar3.setTypeAttr(view, str3);
                return;
            case 3:
                ((d) this.f3579a).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 4:
                d dVar4 = (d) this.f3579a;
                if (obj != null) {
                    z11 = ((Boolean) obj).booleanValue();
                }
                dVar4.setIndeterminate(view, z11);
                return;
            case 5:
                d dVar5 = (d) this.f3579a;
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                dVar5.setAnimating(view, z10);
                return;
            case 6:
                d dVar6 = (d) this.f3579a;
                if (obj != null) {
                    str3 = (String) obj;
                }
                dVar6.setStyleAttr(view, str3);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
