package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class q0 extends e {
    public q0(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        float f10;
        String str2;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1960777211:
                if (str.equals("floodColor")) {
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
            case -1033006547:
                if (str.equals("floodOpacity")) {
                    c10 = 2;
                    break;
                }
                break;
            case -934426595:
                if (str.equals(DbParams.KEY_CHANNEL_RESULT)) {
                    c10 = 3;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c10 = 4;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
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
                ((r0) this.f3579a).setFloodColor(view, new DynamicFromObject(obj));
                return;
            case 1:
                ((r0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 2:
                r0 r0Var = (r0) this.f3579a;
                if (obj == null) {
                    f10 = 1.0f;
                } else {
                    f10 = ((Double) obj).floatValue();
                }
                r0Var.setFloodOpacity(view, f10);
                return;
            case 3:
                r0 r0Var2 = (r0) this.f3579a;
                if (obj == null) {
                    str2 = null;
                } else {
                    str2 = (String) obj;
                }
                r0Var2.setResult(view, str2);
                return;
            case 4:
                ((r0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 5:
                ((r0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 6:
                ((r0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
