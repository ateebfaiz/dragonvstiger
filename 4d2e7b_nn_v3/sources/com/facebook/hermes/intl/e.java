package com.facebook.hermes.intl;

import o4.i;

class e {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f19907a;

    /* renamed from: b  reason: collision with root package name */
    int f19908b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f19909c = -1;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        private CharSequence f19910a;

        /* renamed from: b  reason: collision with root package name */
        private int f19911b;

        /* renamed from: c  reason: collision with root package name */
        private int f19912c;

        a(CharSequence charSequence, int i10, int i11) {
            this.f19910a = charSequence;
            this.f19911b = i10;
            this.f19912c = i11;
        }

        public boolean a() {
            return i.h(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean b() {
            return i.i(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean c() {
            return i.j(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean d() {
            return i.k(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean e() {
            return i.l(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean f() {
            return i.m(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean g() {
            return i.n(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean h() {
            return i.o(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean i() {
            return i.p(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean j() {
            return i.q(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean k() {
            return i.r(this.f19910a, this.f19911b, this.f19912c);
        }

        public boolean l() {
            return i.s(this.f19910a, this.f19911b, this.f19912c);
        }

        public String m() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = this.f19911b; i10 <= this.f19912c; i10++) {
                stringBuffer.append(Character.toLowerCase(this.f19910a.charAt(i10)));
            }
            return stringBuffer.toString();
        }

        public String n() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = this.f19911b; i10 <= this.f19912c; i10++) {
                if (i10 == this.f19911b) {
                    stringBuffer.append(Character.toUpperCase(this.f19910a.charAt(i10)));
                } else {
                    stringBuffer.append(Character.toLowerCase(this.f19910a.charAt(i10)));
                }
            }
            return stringBuffer.toString();
        }

        public String o() {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = this.f19911b; i10 <= this.f19912c; i10++) {
                stringBuffer.append(Character.toUpperCase(this.f19910a.charAt(i10)));
            }
            return stringBuffer.toString();
        }

        public String toString() {
            return this.f19910a.subSequence(this.f19911b, this.f19912c + 1).toString();
        }
    }

    public class b extends Exception {
        public b() {
        }
    }

    public e(CharSequence charSequence) {
        this.f19907a = charSequence;
    }

    private static boolean b(char c10) {
        return c10 == '-';
    }

    public boolean a() {
        if (this.f19907a.length() <= 0 || this.f19909c >= this.f19907a.length() - 1) {
            return false;
        }
        return true;
    }

    public a c() {
        if (a()) {
            int i10 = this.f19909c;
            if (i10 >= this.f19908b) {
                if (!b(this.f19907a.charAt(i10 + 1))) {
                    throw new b();
                } else if (this.f19909c + 2 != this.f19907a.length()) {
                    this.f19908b = this.f19909c + 2;
                } else {
                    throw new b();
                }
            }
            this.f19909c = this.f19908b;
            while (this.f19909c < this.f19907a.length() && !b(this.f19907a.charAt(this.f19909c))) {
                this.f19909c++;
            }
            int i11 = this.f19909c;
            int i12 = this.f19908b;
            if (i11 > i12) {
                int i13 = i11 - 1;
                this.f19909c = i13;
                return new a(this.f19907a, i12, i13);
            }
            throw new b();
        }
        throw new b();
    }
}
