package kb;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public final /* synthetic */ class b implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Promise f12568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12569b;

    public /* synthetic */ b(Promise promise, String str) {
        this.f12568a = promise;
        this.f12569b = str;
    }

    public final void invoke(Object[] objArr) {
        d.n(this.f12568a, this.f12569b, objArr);
    }
}
