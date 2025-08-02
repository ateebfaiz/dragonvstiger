package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class o0 extends e {
    public o0(f fVar) {
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
            case 3366:
                if (str.equals("k1")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3367:
                if (str.equals("k2")) {
                    c10 = 5;
                    break;
                }
                break;
            case 3368:
                if (str.equals("k3")) {
                    c10 = 6;
                    break;
                }
                break;
            case 3369:
                if (str.equals("k4")) {
                    c10 = 7;
                    break;
                }
                break;
            case 104364:
                if (str.equals("in1")) {
                    c10 = 8;
                    break;
                }
                break;
            case 104365:
                if (str.equals("in2")) {
                    c10 = 9;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Snapshot.WIDTH)) {
                    c10 = 10;
                    break;
                }
                break;
            case 1662708749:
                if (str.equals("operator1")) {
                    c10 = 11;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((p0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 1:
                p0 p0Var = (p0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                p0Var.setResult(view, str2);
                return;
            case 2:
                ((p0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 3:
                ((p0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 4:
                p0 p0Var2 = (p0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                p0Var2.setK1(view, f10);
                return;
            case 5:
                p0 p0Var3 = (p0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                p0Var3.setK2(view, f10);
                return;
            case 6:
                p0 p0Var4 = (p0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                p0Var4.setK3(view, f10);
                return;
            case 7:
                p0 p0Var5 = (p0) this.f3579a;
                if (obj != null) {
                    f10 = ((Double) obj).floatValue();
                }
                p0Var5.setK4(view, f10);
                return;
            case 8:
                p0 p0Var6 = (p0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                p0Var6.setIn1(view, str2);
                return;
            case 9:
                p0 p0Var7 = (p0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                p0Var7.setIn2(view, str2);
                return;
            case 10:
                ((p0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            case 11:
                ((p0) this.f3579a).setOperator1(view, (String) obj);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
