package androidx.customview.poolingcontainer;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.jvm.internal.m;

public final class PoolingContainer {
    private static final int IsPoolingContainerTag = R.id.is_pooling_container_tag;
    private static final int PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;

    @SuppressLint({"ExecutorRegistration"})
    public static final void addPoolingContainerListener(View view, PoolingContainerListener poolingContainerListener) {
        m.f(view, "<this>");
        m.f(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPoolingContainerListenerHolder(view).a(poolingContainerListener);
    }

    public static final void callPoolingContainerOnRelease(View view) {
        m.f(view, "<this>");
        for (View poolingContainerListenerHolder : ViewKt.getAllViews(view)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).b();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup viewGroup) {
        m.f(viewGroup, "<this>");
        for (View poolingContainerListenerHolder : ViewGroupKt.getChildren(viewGroup)) {
            getPoolingContainerListenerHolder(poolingContainerListenerHolder).b();
        }
    }

    private static final a getPoolingContainerListenerHolder(View view) {
        int i10 = PoolingContainerListenerHolderTag;
        a aVar = (a) view.getTag(i10);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        view.setTag(i10, aVar2);
        return aVar2;
    }

    public static final boolean isPoolingContainer(View view) {
        Boolean bool;
        m.f(view, "<this>");
        Object tag = view.getTag(IsPoolingContainerTag);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean isWithinPoolingContainer(View view) {
        m.f(view, "<this>");
        for (ViewParent viewParent : ViewKt.getAncestors(view)) {
            if ((viewParent instanceof View) && isPoolingContainer((View) viewParent)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ExecutorRegistration"})
    public static final void removePoolingContainerListener(View view, PoolingContainerListener poolingContainerListener) {
        m.f(view, "<this>");
        m.f(poolingContainerListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPoolingContainerListenerHolder(view).c(poolingContainerListener);
    }

    public static final void setPoolingContainer(View view, boolean z10) {
        m.f(view, "<this>");
        view.setTag(IsPoolingContainerTag, Boolean.valueOf(z10));
    }
}
