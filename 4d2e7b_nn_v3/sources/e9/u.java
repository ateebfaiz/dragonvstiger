package e9;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public final class u extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private j f12053b;

    public h o(Object obj) {
        if (this.f12053b == null) {
            this.f12053b = new j(obj);
        }
        return this.f12053b.b();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        j jVar = this.f12053b;
        if (jVar != null) {
            jVar.c(getResources().getConfiguration());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.f12053b;
        if (jVar != null) {
            jVar.d(configuration);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        j jVar = this.f12053b;
        if (jVar != null) {
            jVar.e();
            this.f12053b = null;
        }
    }

    public void onResume() {
        super.onResume();
        j jVar = this.f12053b;
        if (jVar != null) {
            jVar.f();
        }
    }
}
