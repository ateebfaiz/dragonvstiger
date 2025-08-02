package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

final class c implements ObjectEncoderContext {

    /* renamed from: f  reason: collision with root package name */
    private static final Charset f9094f = Charset.forName("UTF-8");

    /* renamed from: g  reason: collision with root package name */
    private static final FieldDescriptor f9095g = FieldDescriptor.builder("key").withProperty(AtProtobuf.builder().tag(1).build()).build();

    /* renamed from: h  reason: collision with root package name */
    private static final FieldDescriptor f9096h = FieldDescriptor.builder("value").withProperty(AtProtobuf.builder().tag(2).build()).build();

    /* renamed from: i  reason: collision with root package name */
    private static final ObjectEncoder f9097i = new b();

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f9098a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f9099b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f9100c;

    /* renamed from: d  reason: collision with root package name */
    private final ObjectEncoder f9101d;

    /* renamed from: e  reason: collision with root package name */
    private final e f9102e = new e(this);

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9103a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.firebase.encoders.proto.Protobuf$IntEncoding[] r0 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9103a = r0
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.SIGNED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9103a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.firebase.encoders.proto.Protobuf$IntEncoding r1 = com.google.firebase.encoders.proto.Protobuf.IntEncoding.FIXED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.encoders.proto.c.a.<clinit>():void");
        }
    }

    c(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.f9098a = outputStream;
        this.f9099b = map;
        this.f9100c = map2;
        this.f9101d = objectEncoder;
    }

    private static ByteBuffer k(int i10) {
        return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
    }

    private long l(ObjectEncoder objectEncoder, Object obj) {
        OutputStream outputStream;
        a aVar = new a();
        try {
            outputStream = this.f9098a;
            this.f9098a = aVar;
            objectEncoder.encode(obj, this);
            this.f9098a = outputStream;
            long a10 = aVar.a();
            aVar.close();
            return a10;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private c m(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z10) {
        long l10 = l(objectEncoder, obj);
        if (z10 && l10 == 0) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 2);
        t(l10);
        objectEncoder.encode(obj, this);
        return this;
    }

    private c n(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z10) {
        this.f9102e.b(fieldDescriptor, z10);
        valueEncoder.encode(obj, this.f9102e);
        return this;
    }

    private static Protobuf p(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int q(FieldDescriptor fieldDescriptor) {
        Protobuf protobuf = (Protobuf) fieldDescriptor.getProperty(Protobuf.class);
        if (protobuf != null) {
            return protobuf.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void r(Map.Entry entry, ObjectEncoderContext objectEncoderContext) {
        objectEncoderContext.add(f9095g, entry.getKey());
        objectEncoderContext.add(f9096h, entry.getValue());
    }

    private void s(int i10) {
        while (((long) (i10 & -128)) != 0) {
            this.f9098a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f9098a.write(i10 & 127);
    }

    private void t(long j10) {
        while ((-128 & j10) != 0) {
            this.f9098a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f9098a.write(((int) j10) & 127);
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext b(FieldDescriptor fieldDescriptor, double d10, boolean z10) {
        if (z10 && d10 == 0.0d) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 1);
        this.f9098a.write(k(8).putDouble(d10).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext c(FieldDescriptor fieldDescriptor, float f10, boolean z10) {
        if (z10 && f10 == 0.0f) {
            return this;
        }
        s((q(fieldDescriptor) << 3) | 5);
        this.f9098a.write(k(4).putFloat(f10).array());
        return this;
    }

    /* access modifiers changed from: package-private */
    public ObjectEncoderContext d(FieldDescriptor fieldDescriptor, Object obj, boolean z10) {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            s((q(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f9094f);
            s(bytes.length);
            this.f9098a.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object d10 : (Collection) obj) {
                d(fieldDescriptor, d10, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry m10 : ((Map) obj).entrySet()) {
                m(f9097i, fieldDescriptor, m10, false);
            }
            return this;
        } else if (obj instanceof Double) {
            return b(fieldDescriptor, ((Double) obj).doubleValue(), z10);
        } else {
            if (obj instanceof Float) {
                return c(fieldDescriptor, ((Float) obj).floatValue(), z10);
            }
            if (obj instanceof Number) {
                return h(fieldDescriptor, ((Number) obj).longValue(), z10);
            }
            if (obj instanceof Boolean) {
                return j(fieldDescriptor, ((Boolean) obj).booleanValue(), z10);
            }
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (z10 && bArr.length == 0) {
                    return this;
                }
                s((q(fieldDescriptor) << 3) | 2);
                s(bArr.length);
                this.f9098a.write(bArr);
                return this;
            }
            ObjectEncoder objectEncoder = (ObjectEncoder) this.f9099b.get(obj.getClass());
            if (objectEncoder != null) {
                return m(objectEncoder, fieldDescriptor, obj, z10);
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.f9100c.get(obj.getClass());
            if (valueEncoder != null) {
                return n(valueEncoder, fieldDescriptor, obj, z10);
            }
            if (obj instanceof ProtoEnum) {
                return add(fieldDescriptor, ((ProtoEnum) obj).getNumber());
            }
            if (obj instanceof Enum) {
                return add(fieldDescriptor, ((Enum) obj).ordinal());
            }
            return m(this.f9101d, fieldDescriptor, obj, z10);
        }
    }

    /* renamed from: e */
    public c add(FieldDescriptor fieldDescriptor, int i10) {
        return f(fieldDescriptor, i10, true);
    }

    /* access modifiers changed from: package-private */
    public c f(FieldDescriptor fieldDescriptor, int i10, boolean z10) {
        if (z10 && i10 == 0) {
            return this;
        }
        Protobuf p10 = p(fieldDescriptor);
        int i11 = a.f9103a[p10.intEncoding().ordinal()];
        if (i11 == 1) {
            s(p10.tag() << 3);
            s(i10);
        } else if (i11 == 2) {
            s(p10.tag() << 3);
            s((i10 << 1) ^ (i10 >> 31));
        } else if (i11 == 3) {
            s((p10.tag() << 3) | 5);
            this.f9098a.write(k(4).putInt(i10).array());
        }
        return this;
    }

    /* renamed from: g */
    public c add(FieldDescriptor fieldDescriptor, long j10) {
        return h(fieldDescriptor, j10, true);
    }

    /* access modifiers changed from: package-private */
    public c h(FieldDescriptor fieldDescriptor, long j10, boolean z10) {
        if (z10 && j10 == 0) {
            return this;
        }
        Protobuf p10 = p(fieldDescriptor);
        int i10 = a.f9103a[p10.intEncoding().ordinal()];
        if (i10 == 1) {
            s(p10.tag() << 3);
            t(j10);
        } else if (i10 == 2) {
            s(p10.tag() << 3);
            t((j10 >> 63) ^ (j10 << 1));
        } else if (i10 == 3) {
            s((p10.tag() << 3) | 1);
            this.f9098a.write(k(8).putLong(j10).array());
        }
        return this;
    }

    /* renamed from: i */
    public c add(FieldDescriptor fieldDescriptor, boolean z10) {
        return j(fieldDescriptor, z10, true);
    }

    public ObjectEncoderContext inline(Object obj) {
        return o(obj);
    }

    /* access modifiers changed from: package-private */
    public c j(FieldDescriptor fieldDescriptor, boolean z10, boolean z11) {
        return f(fieldDescriptor, z10 ? 1 : 0, z11);
    }

    public ObjectEncoderContext nested(String str) {
        return nested(FieldDescriptor.of(str));
    }

    /* access modifiers changed from: package-private */
    public c o(Object obj) {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.f9099b.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }

    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    public ObjectEncoderContext add(String str, Object obj) {
        return add(FieldDescriptor.of(str), obj);
    }

    public ObjectEncoderContext add(String str, double d10) {
        return add(FieldDescriptor.of(str), d10);
    }

    public ObjectEncoderContext add(String str, int i10) {
        return add(FieldDescriptor.of(str), i10);
    }

    public ObjectEncoderContext add(String str, long j10) {
        return add(FieldDescriptor.of(str), j10);
    }

    public ObjectEncoderContext add(String str, boolean z10) {
        return add(FieldDescriptor.of(str), z10);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return d(fieldDescriptor, obj, true);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d10) {
        return b(fieldDescriptor, d10, true);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f10) {
        return c(fieldDescriptor, f10, true);
    }
}
