package c9;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class a implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return TransportRuntime.initialize((Context) componentContainer.get(Context.class));
    }
}
