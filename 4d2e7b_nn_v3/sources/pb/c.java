package pb;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final a f1802b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Class f1803a;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(Enum[] enumArr) {
        m.f(enumArr, "entries");
        Class<?> componentType = enumArr.getClass().getComponentType();
        m.c(componentType);
        this.f1803a = componentType;
    }

    private final Object readResolve() {
        Object[] enumConstants = this.f1803a.getEnumConstants();
        m.e(enumConstants, "getEnumConstants(...)");
        return a.a((Enum[]) enumConstants);
    }
}
