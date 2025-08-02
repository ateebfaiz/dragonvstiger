package d9;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f11893a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f11894b;

    public /* synthetic */ a(String str, Component component) {
        this.f11893a = str;
        this.f11894b = component;
    }

    public final Object create(ComponentContainer componentContainer) {
        return ComponentMonitor.lambda$processRegistrar$0(this.f11893a, this.f11894b, componentContainer);
    }
}
