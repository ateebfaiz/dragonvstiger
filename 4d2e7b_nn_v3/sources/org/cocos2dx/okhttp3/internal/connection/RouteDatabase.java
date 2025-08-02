package org.cocos2dx.okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import org.cocos2dx.okhttp3.Route;

public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public synchronized void connected(Route route) {
        this.failedRoutes.remove(route);
    }

    public synchronized void failed(Route route) {
        this.failedRoutes.add(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.failedRoutes.contains(route);
    }
}
