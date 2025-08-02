package com.bugsnag.android;

import android.util.JsonReader;
import com.bugsnag.android.k2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class d1 implements k2.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f18697b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f18698a;

    public static final class a {
        private a() {
        }

        public d1 a(JsonReader jsonReader) {
            String str;
            jsonReader.beginObject();
            if (!jsonReader.hasNext() || !m.b("id", jsonReader.nextName())) {
                str = null;
            } else {
                str = jsonReader.nextString();
            }
            return new d1(str);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d1(String str) {
        this.f18698a = str;
    }

    public final String a() {
        return this.f18698a;
    }

    public void toStream(k2 k2Var) {
        k2Var.j();
        k2Var.v("id");
        k2Var.K(a());
        k2Var.n();
    }
}
