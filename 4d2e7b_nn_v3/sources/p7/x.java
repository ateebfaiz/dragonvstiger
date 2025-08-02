package p7;

import android.view.View;
import com.facebook.react.uimanager.e;
import com.facebook.react.uimanager.f;

public class x extends e {
    public x(f fVar) {
        super(fVar);
    }

    public void b(View view, String str, Object obj) {
        str.hashCode();
        if (!str.equals("type")) {
            super.b(view, str, obj);
        } else {
            ((y) this.f3579a).setType(view, (String) obj);
        }
    }
}
