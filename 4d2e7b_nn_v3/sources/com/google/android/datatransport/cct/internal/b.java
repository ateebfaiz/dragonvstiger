package com.google.android.datatransport.cct.internal;

import java.util.List;

final class b extends BatchedLogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List f6365a;

    b(List list) {
        if (list != null) {
            this.f6365a = list;
            return;
        }
        throw new NullPointerException("Null logRequests");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f6365a.equals(((BatchedLogRequest) obj).getLogRequests());
        }
        return false;
    }

    public List getLogRequests() {
        return this.f6365a;
    }

    public int hashCode() {
        return this.f6365a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f6365a + "}";
    }
}
