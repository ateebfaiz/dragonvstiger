package z8;

import android.content.SharedPreferences;
import com.geetest.core.d;

public final /* synthetic */ class c implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13448a;

    public /* synthetic */ c(String str) {
        this.f13448a = str;
    }

    public final void a(SharedPreferences.Editor editor) {
        editor.putString("gt_ggwid_obj", this.f13448a);
    }
}
