package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialDescriptor {

    /* renamed from: id  reason: collision with root package name */
    private final byte[] f15347id;
    private final List<String> transports;
    private final String type;

    public PublicKeyCredentialDescriptor(String str, byte[] bArr, List<String> list) {
        m.f(str, "type");
        m.f(bArr, "id");
        m.f(list, "transports");
        this.type = str;
        this.f15347id = bArr;
        this.transports = list;
    }

    public static /* synthetic */ PublicKeyCredentialDescriptor copy$default(PublicKeyCredentialDescriptor publicKeyCredentialDescriptor, String str, byte[] bArr, List<String> list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = publicKeyCredentialDescriptor.type;
        }
        if ((i10 & 2) != 0) {
            bArr = publicKeyCredentialDescriptor.f15347id;
        }
        if ((i10 & 4) != 0) {
            list = publicKeyCredentialDescriptor.transports;
        }
        return publicKeyCredentialDescriptor.copy(str, bArr, list);
    }

    public final String component1() {
        return this.type;
    }

    public final byte[] component2() {
        return this.f15347id;
    }

    public final List<String> component3() {
        return this.transports;
    }

    public final PublicKeyCredentialDescriptor copy(String str, byte[] bArr, List<String> list) {
        m.f(str, "type");
        m.f(bArr, "id");
        m.f(list, "transports");
        return new PublicKeyCredentialDescriptor(str, bArr, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        return m.b(this.type, publicKeyCredentialDescriptor.type) && m.b(this.f15347id, publicKeyCredentialDescriptor.f15347id) && m.b(this.transports, publicKeyCredentialDescriptor.transports);
    }

    public final byte[] getId() {
        return this.f15347id;
    }

    public final List<String> getTransports() {
        return this.transports;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + Arrays.hashCode(this.f15347id)) * 31) + this.transports.hashCode();
    }

    public String toString() {
        return "PublicKeyCredentialDescriptor(type=" + this.type + ", id=" + Arrays.toString(this.f15347id) + ", transports=" + this.transports + ')';
    }
}
