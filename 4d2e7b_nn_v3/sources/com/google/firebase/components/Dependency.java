package com.google.firebase.components;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

public final class Dependency {
    private final Qualified<?> anInterface;
    private final int injection;
    private final int type;

    private Dependency(Class<?> cls, int i10, int i11) {
        this(Qualified.unqualified(cls), i10, i11);
    }

    public static Dependency deferred(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    private static String describeInjection(int i10) {
        if (i10 == 0) {
            return DevicePublicKeyStringDef.DIRECT;
        }
        if (i10 == 1) {
            return "provider";
        }
        if (i10 == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i10);
    }

    @Deprecated
    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (this.anInterface.equals(dependency.anInterface) && this.type == dependency.type && this.injection == dependency.injection) {
            return true;
        }
        return false;
    }

    public Qualified<?> getInterface() {
        return this.anInterface;
    }

    public int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public boolean isDeferred() {
        if (this.injection == 2) {
            return true;
        }
        return false;
    }

    public boolean isDirectInjection() {
        if (this.injection == 0) {
            return true;
        }
        return false;
    }

    public boolean isRequired() {
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public boolean isSet() {
        if (this.type == 2) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("Dependency{anInterface=");
        sb2.append(this.anInterface);
        sb2.append(", type=");
        int i10 = this.type;
        if (i10 == 1) {
            str = "required";
        } else if (i10 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb2.append(str);
        sb2.append(", injection=");
        sb2.append(describeInjection(this.injection));
        sb2.append("}");
        return sb2.toString();
    }

    private Dependency(Qualified<?> qualified, int i10, int i11) {
        this.anInterface = (Qualified) Preconditions.checkNotNull(qualified, "Null dependency anInterface.");
        this.type = i10;
        this.injection = i11;
    }

    public static Dependency deferred(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 2);
    }

    public static Dependency optionalProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 0, 1);
    }

    public static Dependency required(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency requiredProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 1, 1);
    }

    public static Dependency setOf(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 0);
    }

    public static Dependency setOfProvider(Qualified<?> qualified) {
        return new Dependency(qualified, 2, 1);
    }
}
