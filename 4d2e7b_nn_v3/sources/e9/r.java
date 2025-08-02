package e9;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;

public final class r extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private j f12043a;

    public h a(Object obj) {
        if (this.f12043a == null) {
            this.f12043a = new j(obj);
        }
        return this.f12043a.b();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j jVar = this.f12043a;
        if (jVar != null) {
            jVar.c(getResources().getConfiguration());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.f12043a;
        if (jVar != null) {
            jVar.d(configuration);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f12043a;
        if (jVar != null) {
            jVar.e();
            this.f12043a = null;
        }
    }

    public void onResume() {
        super.onResume();
        j jVar = this.f12043a;
        if (jVar != null) {
            jVar.f();
        }
    }
}
