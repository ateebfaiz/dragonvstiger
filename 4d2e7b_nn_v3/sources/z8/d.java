package z8;

import android.content.SharedPreferences;

public final /* synthetic */ class d implements com.geetest.core.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13449a;

    public /* synthetic */ d(String str) {
        this.f13449a = str;
    }

    public final void a(SharedPreferences.Editor editor) {
        editor.putString("gt_ggwid_obj", this.f13449a);
    }
}
