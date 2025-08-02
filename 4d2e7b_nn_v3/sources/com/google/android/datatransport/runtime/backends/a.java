package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

final class a extends BackendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final Iterable f6447a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6448b;

    static final class b extends BackendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Iterable f6449a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f6450b;

        b() {
        }

        public BackendRequest build() {
            String str = "";
            if (this.f6449a == null) {
                str = str + " events";
            }
            if (str.isEmpty()) {
                return new a(this.f6449a, this.f6450b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public BackendRequest.Builder setEvents(Iterable iterable) {
            if (iterable != null) {
                this.f6449a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        public BackendRequest.Builder setExtras(byte[] bArr) {
            this.f6450b = bArr;
            return this;
        }
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendRequest)) {
            return false;
        }
        BackendRequest backendRequest = (BackendRequest) obj;
        if (this.f6447a.equals(backendRequest.getEvents())) {
            byte[] bArr2 = this.f6448b;
            if (backendRequest instanceof a) {
                bArr = ((a) backendRequest).f6448b;
            } else {
                bArr = backendRequest.getExtras();
            }
            if (Arrays.equals(bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public Iterable getEvents() {
        return this.f6447a;
    }

    public byte[] getExtras() {
        return this.f6448b;
    }

    public int hashCode() {
        return ((this.f6447a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6448b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f6447a + ", extras=" + Arrays.toString(this.f6448b) + "}";
    }

    private a(Iterable iterable, byte[] bArr) {
        this.f6447a = iterable;
        this.f6448b = bArr;
    }
}
