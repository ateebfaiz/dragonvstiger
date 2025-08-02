package p7;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.e;

public class i extends e {
    public i(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    public void b(View view, String str, Object obj) {
        str.hashCode();
        boolean z10 = false;
        double d10 = 0.0d;
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1742339391:
                if (str.equals("disableAutoLayout")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1735873685:
                if (str.equals("enableInstrumentation")) {
                    c10 = 1;
                    break;
                }
                break;
            case -866440768:
                if (str.equals("scrollOffset")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1387629604:
                if (str.equals("horizontal")) {
                    c10 = 3;
                    break;
                }
                break;
            case 1705877054:
                if (str.equals("renderAheadOffset")) {
                    c10 = 4;
                    break;
                }
                break;
            case 1862514705:
                if (str.equals("windowSize")) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                j jVar = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                jVar.setDisableAutoLayout(view, z10);
                return;
            case 1:
                j jVar2 = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                jVar2.setEnableInstrumentation(view, z10);
                return;
            case 2:
                j jVar3 = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    d10 = ((Double) obj).doubleValue();
                }
                jVar3.setScrollOffset(view, d10);
                return;
            case 3:
                j jVar4 = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    z10 = ((Boolean) obj).booleanValue();
                }
                jVar4.setHorizontal(view, z10);
                return;
            case 4:
                j jVar5 = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    d10 = ((Double) obj).doubleValue();
                }
                jVar5.setRenderAheadOffset(view, d10);
                return;
            case 5:
                j jVar6 = (j) ((BaseViewManager) this.f3579a);
                if (obj != null) {
                    d10 = ((Double) obj).doubleValue();
                }
                jVar6.setWindowSize(view, d10);
                return;
            default:
                super.b(view, str, obj);
                return;
        }
    }
}
