package ub;

import com.adjust.sdk.Constants;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.m;
import zb.c;

public abstract class a {
    public static final Class a(c cVar) {
        m.f(cVar, "<this>");
        Class c10 = ((d) cVar).c();
        m.d(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return c10;
    }

    public static final Class b(c cVar) {
        m.f(cVar, "<this>");
        Class c10 = ((d) cVar).c();
        if (!c10.isPrimitive()) {
            m.d(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return c10;
        }
        String name = c10.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    c10 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    c10 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    c10 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    c10 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals(Constants.LONG)) {
                    c10 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    c10 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    c10 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    c10 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    c10 = Short.class;
                    break;
                }
                break;
        }
        m.d(c10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return c10;
    }
}
