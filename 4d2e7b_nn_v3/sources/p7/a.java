package p7;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;

public class a extends e {
    public a(f fVar) {
        super(fVar);
    }

    public void a(View view, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("closeDrawer")) {
            ((b) this.f3579a).closeDrawer(view);
        } else if (str.equals("openDrawer")) {
            ((b) this.f3579a).openDrawer(view);
        }
    }

    public void b(View view, String str, Object obj) {
        Float f10;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -2082382380:
                if (str.equals("statusBarBackgroundColor")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1233873500:
                if (str.equals("drawerBackgroundColor")) {
                    c10 = 1;
                    break;
                }
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c10 = 2;
                    break;
                }
                break;
            case 268251989:
                if (str.equals("drawerWidth")) {
                    c10 = 3;
                    break;
                }
                break;
            case 695891258:
                if (str.equals("drawerPosition")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1857208703:
                if (str.equals("drawerLockMode")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((b) this.f3579a).setStatusBarBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 1:
                ((b) this.f3579a).setDrawerBackgroundColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                return;
            case 2:
                ((b) this.f3579a).setKeyboardDismissMode(view, (String) obj);
                return;
            case 3:
                b bVar = (b) this.f3579a;
                if (obj == null) {
                    f10 = null;
                } else {
                    f10 = Float.valueOf(((Double) obj).floatValue());
                }
                bVar.setDrawerWidth(view, f10);
                return;
            case 4:
                ((b) this.f3579a).setDrawerPosition(view, (String) obj);
                return;
            case 5:
                ((b) this.f3579a).setDrawerLockMode(view, (String) obj);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
