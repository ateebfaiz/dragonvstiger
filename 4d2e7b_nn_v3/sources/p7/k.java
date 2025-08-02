package p7;

import android.view.View;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.e;
import com.google.firebase.analytics.FirebaseAnalytics;

public class k extends e {
    public k(BaseViewManager baseViewManager) {
        super(baseViewManager);
    }

    public void b(View view, String str, Object obj) {
        int i10;
        str.hashCode();
        if (!str.equals(FirebaseAnalytics.Param.INDEX)) {
            super.b(view, str, obj);
            return;
        }
        l lVar = (l) ((BaseViewManager) this.f3579a);
        if (obj == null) {
            i10 = 0;
        } else {
            i10 = ((Double) obj).intValue();
        }
        lVar.setIndex(view, i10);
    }
}
