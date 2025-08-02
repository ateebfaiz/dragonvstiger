package z8;

import android.content.SharedPreferences;
import com.geetest.core.d;

public final /* synthetic */ class b implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13447a;

    public /* synthetic */ b(String str) {
        this.f13447a = str;
    }

    public final void a(SharedPreferences.Editor editor) {
        editor.putString("gt_ggwid_obj", this.f13447a);
    }
}
