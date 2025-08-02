package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class m0 extends e {
    public m0(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        str.hashCode();
        String str2 = null;
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
            case -823812830:
                if (str.equals("values")) {
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
            case 104364:
                if (str.equals("in1")) {
                    c10 = 5;
                    break;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
                    c10 = 6;
                    break;
                }
                break;
            case 113126854:
                if (str.equals(Snapshot.WIDTH)) {
                    c10 = 7;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                ((n0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 1:
                n0 n0Var = (n0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                n0Var.setResult(view, str2);
                return;
            case 2:
                ((n0) this.f3579a).setValues(view, (ReadableArray) obj);
                return;
            case 3:
                ((n0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 4:
                ((n0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 5:
                n0 n0Var2 = (n0) this.f3579a;
                if (obj != null) {
                    str2 = (String) obj;
                }
                n0Var2.setIn1(view, str2);
                return;
            case 6:
                ((n0) this.f3579a).setType(view, (String) obj);
                return;
            case 7:
                ((n0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
