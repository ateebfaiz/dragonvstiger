package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

final class b extends SendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f6437a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6438b;

    /* renamed from: c  reason: collision with root package name */
    private final Event f6439c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer f6440d;

    /* renamed from: e  reason: collision with root package name */
    private final Encoding f6441e;

    /* renamed from: com.google.android.datatransport.runtime.b$b  reason: collision with other inner class name */
    static final class C0088b extends SendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private TransportContext f6442a;

        /* renamed from: b  reason: collision with root package name */
        private String f6443b;

        /* renamed from: c  reason: collision with root package name */
        private Event f6444c;

        /* renamed from: d  reason: collision with root package name */
        private Transformer f6445d;

        /* renamed from: e  reason: collision with root package name */
        private Encoding f6446e;

        C0088b() {
        }

        public SendRequest build() {
            String str = "";
            if (this.f6442a == null) {
                str = str + " transportContext";
            }
            if (this.f6443b == null) {
                str = str + " transportName";
            }
            if (this.f6444c == null) {
                str = str + " event";
            }
            if (this.f6445d == null) {
                str = str + " transformer";
            }
            if (this.f6446e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new b(this.f6442a, this.f6443b, this.f6444c, this.f6445d, this.f6446e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setEncoding(Encoding encoding) {
            if (encoding != null) {
                this.f6446e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setEvent(Event event) {
            if (event != null) {
                this.f6444c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        /* access modifiers changed from: package-private */
        public SendRequest.Builder setTransformer(Transformer transformer) {
            if (transformer != null) {
                this.f6445d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        public SendRequest.Builder setTransportContext(TransportContext transportContext) {
            if (transportContext != null) {
                this.f6442a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        public SendRequest.Builder setTransportName(String str) {
            if (str != null) {
                this.f6443b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    public Encoding b() {
        return this.f6441e;
    }

    /* access modifiers changed from: package-private */
    public Event c() {
        return this.f6439c;
    }

    /* access modifiers changed from: package-private */
    public Transformer e() {
        return this.f6440d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (!this.f6437a.equals(sendRequest.f()) || !this.f6438b.equals(sendRequest.g()) || !this.f6439c.equals(sendRequest.c()) || !this.f6440d.equals(sendRequest.e()) || !this.f6441e.equals(sendRequest.b())) {
            return false;
        }
        return true;
    }

    public TransportContext f() {
        return this.f6437a;
    }

    public String g() {
        return this.f6438b;
    }

    public int hashCode() {
        return ((((((((this.f6437a.hashCode() ^ 1000003) * 1000003) ^ this.f6438b.hashCode()) * 1000003) ^ this.f6439c.hashCode()) * 1000003) ^ this.f6440d.hashCode()) * 1000003) ^ this.f6441e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f6437a + ", transportName=" + this.f6438b + ", event=" + this.f6439c + ", transformer=" + this.f6440d + ", encoding=" + this.f6441e + "}";
    }

    private b(TransportContext transportContext, String str, Event event, Transformer transformer, Encoding encoding) {
        this.f6437a = transportContext;
        this.f6438b = str;
        this.f6439c = event;
        this.f6440d = transformer;
        this.f6441e = encoding;
    }
}
