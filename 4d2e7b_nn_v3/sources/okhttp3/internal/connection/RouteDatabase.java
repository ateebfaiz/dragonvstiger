package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.m;
import okhttp3.Route;

public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        m.f(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        m.f(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        m.f(route, "route");
        return this.failedRoutes.contains(route);
    }
}
