package com.fasterxml.jackson.databind.introspect;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public final class l implements Iterable {

    /* renamed from: a  reason: collision with root package name */
    protected Map f5380a;

    public l() {
    }

    public Iterator iterator() {
        Map map = this.f5380a;
        if (map == null) {
            return Collections.emptyIterator();
        }
        return map.values().iterator();
    }

    public l(Map map) {
        this.f5380a = map;
    }
}
