package g5;

import java.util.Map;
import kotlin.jvm.internal.m;

public abstract class a implements e {
    public void b(String str, String str2) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
    }

    public void c(String str, String str2, Map map) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
    }

    public void d(String str, String str2, boolean z10) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
    }

    public boolean e(String str) {
        m.f(str, "requestId");
        return false;
    }

    public void f(String str, String str2, String str3) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
        m.f(str3, "eventName");
    }

    public void g(String str, String str2, Map map) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
    }

    public void h(String str, String str2, Throwable th, Map map) {
        m.f(str, "requestId");
        m.f(str2, "producerName");
        m.f(th, "t");
    }
}
