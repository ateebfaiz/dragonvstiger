package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class s0 extends e {
    public s0(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        str.hashCode();
        String str2 = null;
        float f10 = 0.0f;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1221029593:
                if (str.equals(Snapshot.HEIGHT)) {
                    c10 = 0;
                    break;
                }
                break;
            case -934426595:
                if (str.equals(DbParams.KEY_CHANNEL_RESULT)) {
                    c10 = 1;
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c10 = 2;
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c10 = 3;
                    break;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    c10 = 4;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Snapshot.WIDTH)) {
                    c10 = 5;
                    break;
                }
                break;
            case 1530721536:
                if (str.equals("edgeMode")) {
                    c10 = 6;
                    break;
                }
                break;
            case 1837475450:
                if (str.equals("stdDeviationX")) {
                    c10 = 7;
                    break;
                }
                break;
            case 1837475451:
                if (str.equals("stdDeviationY")) {
                    c10 = 8;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((t0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 1:
                t0 t0Var = (t0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                t0Var.setResult(view, str2);
                return;
            case 2:
                ((t0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 3:
                ((t0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 4:
                t0 t0Var2 = (t0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                t0Var2.setIn1(view, str2);
                return;
            case 5:
                ((t0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            case 6:
                ((t0) this.f3579a).setEdgeMode(view, (String) obj);
                return;
            case 7:
                t0 t0Var3 = (t0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                t0Var3.setStdDeviationX(view, f10);
                return;
            case 8:
                t0 t0Var4 = (t0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                t0Var4.setStdDeviationY(view, f10);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
