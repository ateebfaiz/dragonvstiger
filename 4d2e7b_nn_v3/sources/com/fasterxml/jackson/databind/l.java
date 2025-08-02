package com.fasterxml.jackson.databind;

import c.d;
import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.core.h;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.HttpUrl;

public class l extends f {

    /* renamed from: a  reason: collision with root package name */
    protected LinkedList f5444a;

    /* renamed from: b  reason: collision with root package name */
    protected transient Closeable f5445b;

    public l(Closeable closeable, String str) {
        super(str);
        this.f5445b = closeable;
        if (closeable instanceof h) {
            d.a(closeable);
            throw null;
        }
    }

    public static l i(f fVar, String str) {
        return new l(fVar, str, (Throwable) null);
    }

    public static l j(f fVar, String str, Throwable th) {
        return new l(fVar, str, th);
    }

    public static l k(IOException iOException) {
        return new l((Closeable) null, String.format("Unexpected IOException (of type %s): %s", new Object[]{iOException.getClass().getName(), com.fasterxml.jackson.databind.util.f.m(iOException)}));
    }

    public static l o(Throwable th, a aVar) {
        l lVar;
        Closeable closeable;
        if (th instanceof l) {
            lVar = (l) th;
        } else {
            String m10 = com.fasterxml.jackson.databind.util.f.m(th);
            if (m10 == null || m10.isEmpty()) {
                m10 = "(was " + th.getClass().getName() + ")";
            }
            if (th instanceof c) {
                Object c10 = ((c) th).c();
                if (c10 instanceof Closeable) {
                    closeable = (Closeable) c10;
                    lVar = new l(closeable, m10, th);
                }
            }
            closeable = null;
            lVar = new l(closeable, m10, th);
        }
        lVar.m(aVar);
        return lVar;
    }

    public static l p(Throwable th, Object obj, int i10) {
        return o(th, new a(obj, i10));
    }

    public static l q(Throwable th, Object obj, String str) {
        return o(th, new a(obj, str));
    }

    public Object c() {
        return this.f5445b;
    }

    public void e(Object obj, String str) {
        m(new a(obj, str));
    }

    /* access modifiers changed from: protected */
    public void f(StringBuilder sb2) {
        LinkedList linkedList = this.f5444a;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(((a) it.next()).toString());
                if (it.hasNext()) {
                    sb2.append("->");
                }
            }
        }
    }

    public String getLocalizedMessage() {
        return h();
    }

    public String getMessage() {
        return h();
    }

    /* access modifiers changed from: protected */
    public String h() {
        StringBuilder sb2;
        String message = super.getMessage();
        if (this.f5444a == null) {
            return message;
        }
        if (message == null) {
            sb2 = new StringBuilder();
        } else {
            sb2 = new StringBuilder(message);
        }
        sb2.append(" (through reference chain: ");
        StringBuilder l10 = l(sb2);
        l10.append(')');
        return l10.toString();
    }

    public StringBuilder l(StringBuilder sb2) {
        f(sb2);
        return sb2;
    }

    public void m(a aVar) {
        if (this.f5444a == null) {
            this.f5444a = new LinkedList();
        }
        if (this.f5444a.size() < 1000) {
            this.f5444a.addFirst(aVar);
        }
    }

    public l n(Throwable th) {
        initCause(th);
        return this;
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public static class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        protected transient Object f5446a;

        /* renamed from: b  reason: collision with root package name */
        protected String f5447b;

        /* renamed from: c  reason: collision with root package name */
        protected int f5448c;

        /* renamed from: d  reason: collision with root package name */
        protected String f5449d;

        public a(Object obj, String str) {
            this.f5448c = -1;
            this.f5446a = obj;
            if (str != null) {
                this.f5447b = str;
                return;
            }
            throw new NullPointerException("Cannot pass null fieldName");
        }

        public String a() {
            Class<?> cls;
            if (this.f5449d == null) {
                StringBuilder sb2 = new StringBuilder();
                Object obj = this.f5446a;
                if (obj != null) {
                    if (obj instanceof Class) {
                        cls = (Class) obj;
                    } else {
                        cls = obj.getClass();
                    }
                    int i10 = 0;
                    while (cls.isArray()) {
                        cls = cls.getComponentType();
                        i10++;
                    }
                    sb2.append(cls.getName());
                    while (true) {
                        i10--;
                        if (i10 < 0) {
                            break;
                        }
                        sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    }
                } else {
                    sb2.append("UNKNOWN");
                }
                sb2.append('[');
                if (this.f5447b != null) {
                    sb2.append('\"');
                    sb2.append(this.f5447b);
                    sb2.append('\"');
                } else {
                    int i11 = this.f5448c;
                    if (i11 >= 0) {
                        sb2.append(i11);
                    } else {
                        sb2.append('?');
                    }
                }
                sb2.append(']');
                this.f5449d = sb2.toString();
            }
            return this.f5449d;
        }

        public String toString() {
            return a();
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            a();
            return this;
        }

        public a(Object obj, int i10) {
            this.f5446a = obj;
            this.f5448c = i10;
        }
    }

    public l(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.f5445b = closeable;
        if (th instanceof c) {
            ((c) th).a();
        } else if (closeable instanceof h) {
            d.a(closeable);
            throw null;
        }
    }
}
