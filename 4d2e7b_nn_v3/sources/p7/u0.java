package p7;

import android.view.View;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;

public class u0 extends e {
    public u0(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        String str2;
        str.hashCode();
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
            case 104993457:
                if (str.equals("nodes")) {
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
        }
        switch (c10) {
            case 0:
                ((v0) this.f3579a).setHeight(view, new DynamicFromObject(obj));
                return;
            case 1:
                v0 v0Var = (v0) this.f3579a;
                if (obj == null) {
                    str2 = null;
                } else {
                    str2 = (String) obj;
                }
                v0Var.setResult(view, str2);
                return;
            case 2:
                ((v0) this.f3579a).setX(view, new DynamicFromObject(obj));
                return;
            case 3:
                ((v0) this.f3579a).setY(view, new DynamicFromObject(obj));
                return;
            case 4:
                ((v0) this.f3579a).setNodes(view, (ReadableArray) obj);
                return;
            case 5:
                ((v0) this.f3579a).setWidth(view, new DynamicFromObject(obj));
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
