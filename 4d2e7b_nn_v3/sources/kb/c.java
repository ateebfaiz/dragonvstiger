package kb;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;

public final /* synthetic */ class c implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f12570a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Promise f12571b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WritableMap f12572c;

    public /* synthetic */ c(ArrayList arrayList, Promise promise, WritableMap writableMap) {
        this.f12570a = arrayList;
        this.f12571b = promise;
        this.f12572c = writableMap;
    }

    public final void invoke(Object[] objArr) {
        d.q(this.f12570a, this.f12571b, this.f12572c, objArr);
    }
}
