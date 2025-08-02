package com.onesignal;

import com.onesignal.b4;
import org.json.JSONObject;

class c4 implements p3 {

    class a extends b4.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r3 f10456a;

        a(r3 r3Var) {
            this.f10456a = r3Var;
        }

        public void a(int i10, String str, Throwable th) {
            this.f10456a.a(i10, str, th);
        }

        public void b(String str) {
            this.f10456a.onSuccess(str);
        }
    }

    c4() {
    }

    public void a(String str, JSONObject jSONObject, r3 r3Var) {
        b4.j(str, jSONObject, new a(r3Var));
    }
}
