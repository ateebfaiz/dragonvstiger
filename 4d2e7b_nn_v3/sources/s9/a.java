package s9;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.Serializable;

public class a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f12985c = new a(DevicePublicKeyStringDef.NONE, m.REQUIRED);

    /* renamed from: a  reason: collision with root package name */
    private final String f12986a;

    /* renamed from: b  reason: collision with root package name */
    private final m f12987b;

    public a(String str, m mVar) {
        if (str != null) {
            this.f12986a = str;
            this.f12987b = mVar;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    public static a b(String str) {
        if (str == null) {
            return null;
        }
        return new a(str);
    }

    public final String a() {
        return this.f12986a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a) || !toString().equals(obj.toString())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f12986a.hashCode();
    }

    public final String toString() {
        return this.f12986a;
    }

    public a(String str) {
        this(str, (m) null);
    }
}
