package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.m;

public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application2) {
        m.f(application2, "application");
        this.application = application2;
    }

    public <T extends Application> T getApplication() {
        T t10 = this.application;
        m.d(t10, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t10;
    }
}
