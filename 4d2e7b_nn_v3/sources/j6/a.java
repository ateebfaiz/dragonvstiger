package j6;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.defaults.b;

public final /* synthetic */ class a implements UIManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f12394a;

    public /* synthetic */ a(b bVar) {
        this.f12394a = bVar;
    }

    public final UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
        return b.y(this.f12394a, reactApplicationContext);
    }
}
