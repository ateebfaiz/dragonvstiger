package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

final class d implements ObjectEncoderContext, ValueEncoderContext {

    /* renamed from: a  reason: collision with root package name */
    private d f9084a = null;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9085b = true;

    /* renamed from: c  reason: collision with root package name */
    private final JsonWriter f9086c;

    /* renamed from: d  reason: collision with root package name */
    private final Map f9087d;

    /* renamed from: e  reason: collision with root package name */
    private final Map f9088e;

    /* renamed from: f  reason: collision with root package name */
    private final ObjectEncoder f9089f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f9090g;

    d(Writer writer, Map map, Map map2, ObjectEncoder objectEncoder, boolean z10) {
        this.f9086c = new JsonWriter(writer);
        this.f9087d = map;
        this.f9088e = map2;
        this.f9089f = objectEncoder;
        this.f9090g = z10;
    }

    private boolean n(Object obj) {
        if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
            return true;
        }
        return false;
    }

    private d q(String str, Object obj) {
        s();
        this.f9086c.name(str);
        if (obj != null) {
            return e(obj, false);
        }
        this.f9086c.nullValue();
        return this;
    }

    private d r(String str, Object obj) {
        if (obj == null) {
            return this;
        }
        s();
        this.f9086c.name(str);
        return e(obj, false);
    }

    private void s() {
        if (this.f9085b) {
            d dVar = this.f9084a;
            if (dVar != null) {
                dVar.s();
                this.f9084a.f9085b = false;
                this.f9084a = null;
                this.f9086c.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    /* renamed from: a */
    public d add(double d10) {
        s();
        this.f9086c.value(d10);
        return this;
    }

    /* renamed from: b */
    public d add(float f10) {
        s();
        this.f9086c.value((double) f10);
        return this;
    }

    /* renamed from: c */
    public d add(int i10) {
        s();
        this.f9086c.value((long) i10);
        return this;
    }

    /* renamed from: d */
    public d add(long j10) {
        s();
        this.f9086c.value(j10);
        return this;
    }

    /* access modifiers changed from: package-private */
    public d e(Object obj, boolean z10) {
        Class<?> cls;
        int i10 = 0;
        if (z10 && n(obj)) {
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            throw new EncodingException(String.format("%s cannot be encoded inline", new Object[]{cls}));
        } else if (obj == null) {
            this.f9086c.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.f9086c.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                return add((byte[]) obj);
            }
            this.f9086c.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i10 < length) {
                    this.f9086c.value((long) iArr[i10]);
                    i10++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i10 < length2) {
                    add(jArr[i10]);
                    i10++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i10 < length3) {
                    this.f9086c.value(dArr[i10]);
                    i10++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i10 < length4) {
                    this.f9086c.value(zArr[i10]);
                    i10++;
                }
            } else if (obj instanceof Number[]) {
                for (Number e10 : (Number[]) obj) {
                    e(e10, false);
                }
            } else {
                for (Object e11 : (Object[]) obj) {
                    e(e11, false);
                }
            }
            this.f9086c.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.f9086c.beginArray();
            for (Object e12 : (Collection) obj) {
                e(e12, false);
            }
            this.f9086c.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.f9086c.beginObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e13) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e13);
                }
            }
            this.f9086c.endObject();
            return this;
        } else {
            ObjectEncoder objectEncoder = (ObjectEncoder) this.f9087d.get(obj.getClass());
            if (objectEncoder != null) {
                return p(objectEncoder, obj, z10);
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.f9088e.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            } else if (!(obj instanceof Enum)) {
                return p(this.f9089f, obj, z10);
            } else {
                add(((Enum) obj).name());
                return this;
            }
        }
    }

    /* renamed from: f */
    public d add(String str) {
        s();
        this.f9086c.value(str);
        return this;
    }

    /* renamed from: g */
    public d add(String str, double d10) {
        s();
        this.f9086c.name(str);
        return add(d10);
    }

    /* renamed from: h */
    public d add(String str, int i10) {
        s();
        this.f9086c.name(str);
        return add(i10);
    }

    /* renamed from: i */
    public d add(String str, long j10) {
        s();
        this.f9086c.name(str);
        return add(j10);
    }

    public ObjectEncoderContext inline(Object obj) {
        return e(obj, true);
    }

    /* renamed from: j */
    public d add(String str, Object obj) {
        if (this.f9090g) {
            return r(str, obj);
        }
        return q(str, obj);
    }

    /* renamed from: k */
    public d add(String str, boolean z10) {
        s();
        this.f9086c.name(str);
        return add(z10);
    }

    /* renamed from: l */
    public d add(boolean z10) {
        s();
        this.f9086c.value(z10);
        return this;
    }

    /* renamed from: m */
    public d add(byte[] bArr) {
        s();
        if (bArr == null) {
            this.f9086c.nullValue();
        } else {
            this.f9086c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    public ObjectEncoderContext nested(String str) {
        s();
        this.f9084a = new d(this);
        this.f9086c.name(str);
        this.f9086c.beginObject();
        return this.f9084a;
    }

    /* access modifiers changed from: package-private */
    public void o() {
        s();
        this.f9086c.flush();
    }

    /* access modifiers changed from: package-private */
    public d p(ObjectEncoder objectEncoder, Object obj, boolean z10) {
        if (!z10) {
            this.f9086c.beginObject();
        }
        objectEncoder.encode(obj, this);
        if (!z10) {
            this.f9086c.endObject();
        }
        return this;
    }

    public ObjectEncoderContext nested(FieldDescriptor fieldDescriptor) {
        return nested(fieldDescriptor.getName());
    }

    private d(d dVar) {
        this.f9086c = dVar.f9086c;
        this.f9087d = dVar.f9087d;
        this.f9088e = dVar.f9088e;
        this.f9089f = dVar.f9089f;
        this.f9090g = dVar.f9090g;
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        return add(fieldDescriptor.getName(), obj);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, float f10) {
        return add(fieldDescriptor.getName(), (double) f10);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, double d10) {
        return add(fieldDescriptor.getName(), d10);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i10) {
        return add(fieldDescriptor.getName(), i10);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j10) {
        return add(fieldDescriptor.getName(), j10);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z10) {
        return add(fieldDescriptor.getName(), z10);
    }
}
