package x8;

import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import u8.c;
import u8.d;
import y8.i;

public final class e extends d implements d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Class cls, Object[] objArr, Object obj, boolean z10, Method method, i iVar, c cVar) {
        super(cls, objArr, obj, z10, method, iVar, cVar);
        m.f(cls, "targetClass");
        m.f(method, "targetMethod");
        m.f(cVar, "aopMethod");
    }
}
