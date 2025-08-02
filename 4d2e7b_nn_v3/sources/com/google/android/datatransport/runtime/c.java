package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.TransportContext;
import java.util.Arrays;

final class c extends TransportContext {

    /* renamed from: a  reason: collision with root package name */
    private final String f6465a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f6466b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f6467c;

    static final class b extends TransportContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6468a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f6469b;

        /* renamed from: c  reason: collision with root package name */
        private Priority f6470c;

        b() {
        }

        public TransportContext build() {
            String str = "";
            if (this.f6468a == null) {
                str = str + " backendName";
            }
            if (this.f6470c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new c(this.f6468a, this.f6469b, this.f6470c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public TransportContext.Builder setBackendName(String str) {
            if (str != null) {
                this.f6468a = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public TransportContext.Builder setExtras(byte[] bArr) {
            this.f6469b = bArr;
            return this;
        }

        public TransportContext.Builder setPriority(Priority priority) {
            if (priority != null) {
                this.f6470c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TransportContext)) {
            return false;
        }
        TransportContext transportContext = (TransportContext) obj;
        if (this.f6465a.equals(transportContext.getBackendName())) {
            byte[] bArr2 = this.f6466b;
            if (transportContext instanceof c) {
                bArr = ((c) transportContext).f6466b;
            } else {
                bArr = transportContext.getExtras();
            }
            if (Arrays.equals(bArr2, bArr) && this.f6467c.equals(transportContext.getPriority())) {
                return true;
            }
        }
        return false;
    }

    public String getBackendName() {
        return this.f6465a;
    }

    public byte[] getExtras() {
        return this.f6466b;
    }

    public Priority getPriority() {
        return this.f6467c;
    }

    public int hashCode() {
        return ((((this.f6465a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f6466b)) * 1000003) ^ this.f6467c.hashCode();
    }

    private c(String str, byte[] bArr, Priority priority) {
        this.f6465a = str;
        this.f6466b = bArr;
        this.f6467c = priority;
    }
}
