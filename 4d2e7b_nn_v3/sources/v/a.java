package v;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final int f24350a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24351b;

    /* renamed from: c  reason: collision with root package name */
    public final Map f24352c;

    public a(int i10, String str, Map map) {
        this.f24350a = i10;
        this.f24351b = str;
        this.f24352c = map;
    }

    public static String b(List list) {
        Collections.sort(list);
        return TextUtils.join(";", list);
    }

    public static String c(C0344a aVar) {
        if (aVar != null) {
            return aVar.d();
        }
        return "";
    }

    public String a(String str) {
        C0344a aVar = (C0344a) this.f24352c.get(str);
        if (aVar != null) {
            return aVar.f24355c;
        }
        return "";
    }

    public a d() {
        return new a(this.f24350a, this.f24351b, new HashMap(this.f24352c));
    }

    public String e(String str) {
        return c((C0344a) this.f24352c.get(str));
    }

    public Map f() {
        return this.f24352c;
    }

    /* renamed from: v.a$a  reason: collision with other inner class name */
    public static class C0344a {

        /* renamed from: a  reason: collision with root package name */
        public final String f24353a;

        /* renamed from: b  reason: collision with root package name */
        public final List f24354b;

        /* renamed from: c  reason: collision with root package name */
        public final String f24355c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f24356d;

        public C0344a(C0345a aVar) {
            this.f24356d = aVar.f24357a;
            this.f24353a = aVar.f24358b;
            List list = aVar.f24359c;
            this.f24354b = list == null ? new ArrayList() : list;
            this.f24355c = aVar.f24360d;
        }

        public static C0344a b(boolean z10, String str) {
            C0345a aVar = new C0345a(z10);
            aVar.f24358b = str;
            return new C0344a(aVar);
        }

        public static C0344a c(boolean z10, String str, String str2) {
            C0345a aVar = new C0345a(z10);
            aVar.f24358b = str;
            aVar.f24360d = str2;
            return new C0344a(aVar);
        }

        public List a() {
            return new ArrayList(this.f24354b);
        }

        public String d() {
            return TextUtils.join(";", this.f24354b);
        }

        public C0345a e() {
            return new C0345a(this);
        }

        /* renamed from: v.a$a$a  reason: collision with other inner class name */
        public static class C0345a {

            /* renamed from: a  reason: collision with root package name */
            public final boolean f24357a;

            /* renamed from: b  reason: collision with root package name */
            public String f24358b;

            /* renamed from: c  reason: collision with root package name */
            public List f24359c;

            /* renamed from: d  reason: collision with root package name */
            public String f24360d;

            public C0345a(boolean z10) {
                this.f24357a = z10;
                this.f24358b = "";
                this.f24360d = "";
                this.f24359c = null;
            }

            public C0345a a(List list) {
                this.f24359c = list;
                return this;
            }

            public C0344a b() {
                return new C0344a(this);
            }

            public C0345a c(String str) {
                this.f24360d = str;
                return this;
            }

            public C0345a(C0344a aVar) {
                this.f24357a = aVar.f24356d;
                this.f24358b = aVar.f24353a;
                this.f24360d = aVar.f24355c;
                this.f24359c = aVar.f24354b;
            }
        }
    }
}
