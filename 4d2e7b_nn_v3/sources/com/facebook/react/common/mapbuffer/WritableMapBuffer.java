package com.facebook.react.common.mapbuffer;

import android.util.SparseArray;
import com.facebook.react.common.mapbuffer.a;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

@d6.a
public final class WritableMapBuffer implements a {

    /* renamed from: b  reason: collision with root package name */
    private static final a f2916b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f2917a = new SparseArray();

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final class b implements a.c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2918a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2919b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b f2920c;

        public b(int i10) {
            this.f2918a = i10;
            this.f2919b = WritableMapBuffer.this.f2917a.keyAt(i10);
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(i10);
            m.e(valueAt, "valueAt(...)");
            this.f2920c = WritableMapBuffer.this.d(valueAt, getKey());
        }

        public long a() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof Long) {
                return ((Number) valueAt).longValue();
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + Long.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public double b() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof Double) {
                return ((Number) valueAt).doubleValue();
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + Double.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public String c() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof String) {
                return (String) valueAt;
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + String.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public int d() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof Integer) {
                return ((Number) valueAt).intValue();
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + Integer.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public a e() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof a) {
                return (a) valueAt;
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + a.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public boolean f() {
            int key = getKey();
            Object valueAt = WritableMapBuffer.this.f2917a.valueAt(this.f2918a);
            if (valueAt == null) {
                throw new IllegalArgumentException(("Key not found: " + key).toString());
            } else if (valueAt instanceof Boolean) {
                return ((Boolean) valueAt).booleanValue();
            } else {
                Class<?> cls = valueAt.getClass();
                throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + key + ", found " + cls + " instead.").toString());
            }
        }

        public int getKey() {
            return this.f2919b;
        }

        public a.b getType() {
            return this.f2920c;
        }
    }

    public static final class c implements Iterator, wb.a {

        /* renamed from: a  reason: collision with root package name */
        private int f2922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableMapBuffer f2923b;

        c(WritableMapBuffer writableMapBuffer) {
            this.f2923b = writableMapBuffer;
        }

        /* renamed from: a */
        public a.c next() {
            WritableMapBuffer writableMapBuffer = this.f2923b;
            int i10 = this.f2922a;
            this.f2922a = i10 + 1;
            return new b(i10);
        }

        public boolean hasNext() {
            if (this.f2922a < this.f2923b.f2917a.size()) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    static {
        h6.a.a();
    }

    /* access modifiers changed from: private */
    public final a.b d(Object obj, int i10) {
        if (obj instanceof Boolean) {
            return a.b.BOOL;
        }
        if (obj instanceof Integer) {
            return a.b.INT;
        }
        if (obj instanceof Long) {
            return a.b.LONG;
        }
        if (obj instanceof Double) {
            return a.b.DOUBLE;
        }
        if (obj instanceof String) {
            return a.b.STRING;
        }
        if (obj instanceof a) {
            return a.b.MAP;
        }
        Class<?> cls = obj.getClass();
        throw new IllegalStateException("Key " + i10 + " has value of unknown type: " + cls);
    }

    @d6.a
    private final int[] getKeys() {
        int size = this.f2917a.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 < size; i10++) {
            iArr[i10] = this.f2917a.keyAt(i10);
        }
        return iArr;
    }

    @d6.a
    private final Object[] getValues() {
        int size = this.f2917a.size();
        Object[] objArr = new Object[size];
        for (int i10 = 0; i10 < size; i10++) {
            Object valueAt = this.f2917a.valueAt(i10);
            m.e(valueAt, "valueAt(...)");
            objArr[i10] = valueAt;
        }
        return objArr;
    }

    public boolean b(int i10) {
        if (this.f2917a.get(i10) != null) {
            return true;
        }
        return false;
    }

    public boolean getBoolean(int i10) {
        Object obj = this.f2917a.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i10).toString());
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        } else {
            Class<?> cls = obj.getClass();
            throw new IllegalStateException(("Expected " + Boolean.class + " for key: " + i10 + ", found " + cls + " instead.").toString());
        }
    }

    public int getCount() {
        return this.f2917a.size();
    }

    public double getDouble(int i10) {
        Object obj = this.f2917a.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i10).toString());
        } else if (obj instanceof Double) {
            return ((Number) obj).doubleValue();
        } else {
            Class<?> cls = obj.getClass();
            throw new IllegalStateException(("Expected " + Double.class + " for key: " + i10 + ", found " + cls + " instead.").toString());
        }
    }

    public int getInt(int i10) {
        Object obj = this.f2917a.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i10).toString());
        } else if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        } else {
            Class<?> cls = obj.getClass();
            throw new IllegalStateException(("Expected " + Integer.class + " for key: " + i10 + ", found " + cls + " instead.").toString());
        }
    }

    public String getString(int i10) {
        Object obj = this.f2917a.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i10).toString());
        } else if (obj instanceof String) {
            return (String) obj;
        } else {
            Class<?> cls = obj.getClass();
            throw new IllegalStateException(("Expected " + String.class + " for key: " + i10 + ", found " + cls + " instead.").toString());
        }
    }

    public a h(int i10) {
        Object obj = this.f2917a.get(i10);
        if (obj == null) {
            throw new IllegalArgumentException(("Key not found: " + i10).toString());
        } else if (obj instanceof a) {
            return (a) obj;
        } else {
            Class<?> cls = obj.getClass();
            throw new IllegalStateException(("Expected " + a.class + " for key: " + i10 + ", found " + cls + " instead.").toString());
        }
    }

    public Iterator iterator() {
        return new c(this);
    }
}
