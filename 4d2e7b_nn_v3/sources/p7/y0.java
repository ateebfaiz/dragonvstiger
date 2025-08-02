package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class y0 extends e {
    public y0(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        String str2;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1535814968:
                if (str.equals("primitiveUnits")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals(Snapshot.HEIGHT)) {
                    c10 = 1;
                    break;
                }
                break;
            case -899348777:
                if (str.equals("filterUnits")) {
                    c10 = 2;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c10 = 3;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    c10 = 5;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Snapshot.WIDTH)) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((z0) this.f3579a).setPrimitiveUnits(view, (String) obj);
                return;
            case 1:
                ((z0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 2:
                ((z0) this.f3579a).setFilterUnits(view, (String) obj);
                return;
            case 3:
                ((z0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 4:
                ((z0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 5:
                z0 z0Var = (z0) this.f3579a;
                if (obj == null) {
                    str2 = null;
                } else {
                    str2 = (String) obj;
                }
                z0Var.setName(view, str2);
                return;
            case 6:
                ((z0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
