package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.k2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class k4 implements k2.a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18815d = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f18816a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18817b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18818c;

    public static final class a {
        private a() {
        }

        public k4 a(JsonReader jsonReader) {
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                String nextString = jsonReader.nextString();
                if (nextName != null) {
                    int hashCode = nextName.hashCode();
                    if (hashCode != 3355) {
                        if (hashCode != 3373707) {
                            if (hashCode == 96619420 && nextName.equals("email")) {
                                str2 = nextString;
                            }
                        } else if (nextName.equals("name")) {
                            str3 = nextString;
                        }
                    } else if (nextName.equals("id")) {
                        str = nextString;
                    }
                }
            }
            k4 k4Var = new k4(str, str2, str3);
            jsonReader.endObject();
            return k4Var;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k4(String str, String str2, String str3) {
        this.f18816a = str;
        this.f18817b = str2;
        this.f18818c = str3;
    }

    public final String a() {
        return this.f18817b;
    }

    public final String b() {
        return this.f18816a;
    }

    public final String c() {
        return this.f18818c;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        if (!m.b(k4.class, cls)) {
            return false;
        }
        if (obj != null) {
            k4 k4Var = (k4) obj;
            if (m.b(this.f18816a, k4Var.f18816a) && m.b(this.f18817b, k4Var.f18817b) && m.b(this.f18818c, k4Var.f18818c)) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.bugsnag.android.User");
    }

    public int hashCode() {
        int i10;
        int i11;
        String str = this.f18816a;
        int i12 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int i13 = i10 * 31;
        String str2 = this.f18817b;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i14 = (i13 + i11) * 31;
        String str3 = this.f18818c;
        if (str3 != null) {
            i12 = str3.hashCode();
        }
        return i14 + i12;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("id").K(this.f18816a);
        k2Var.v("email").K(this.f18817b);
        k2Var.v("name").K(this.f18818c);
        k2Var.n();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k4(String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3);
    }
}
