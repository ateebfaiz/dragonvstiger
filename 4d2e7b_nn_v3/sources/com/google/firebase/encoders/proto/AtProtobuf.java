package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;

public final class AtProtobuf {
    private Protobuf.IntEncoding intEncoding = Protobuf.IntEncoding.DEFAULT;
    private int tag;

    private static final class a implements Protobuf {

        /* renamed from: b  reason: collision with root package name */
        private final int f9091b;

        /* renamed from: c  reason: collision with root package name */
        private final Protobuf.IntEncoding f9092c;

        a(int i10, Protobuf.IntEncoding intEncoding) {
            this.f9091b = i10;
            this.f9092c = intEncoding;
        }

        public Class annotationType() {
            return Protobuf.class;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            if (this.f9091b != protobuf.tag() || !this.f9092c.equals(protobuf.intEncoding())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (14552422 ^ this.f9091b) + (this.f9092c.hashCode() ^ 2041407134);
        }

        public Protobuf.IntEncoding intEncoding() {
            return this.f9092c;
        }

        public int tag() {
            return this.f9091b;
        }

        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.f9091b + "intEncoding=" + this.f9092c + ')';
        }
    }

    public static AtProtobuf builder() {
        return new AtProtobuf();
    }

    public Protobuf build() {
        return new a(this.tag, this.intEncoding);
    }

    public AtProtobuf intEncoding(Protobuf.IntEncoding intEncoding2) {
        this.intEncoding = intEncoding2;
        return this;
    }

    public AtProtobuf tag(int i10) {
        this.tag = i10;
        return this;
    }
}
