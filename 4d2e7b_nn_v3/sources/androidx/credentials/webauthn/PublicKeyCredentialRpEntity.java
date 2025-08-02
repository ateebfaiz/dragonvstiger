package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialRpEntity {

    /* renamed from: id  reason: collision with root package name */
    private final String f15348id;
    private final String name;

    public PublicKeyCredentialRpEntity(String str, String str2) {
        m.f(str, "name");
        m.f(str2, "id");
        this.name = str;
        this.f15348id = str2;
    }

    public static /* synthetic */ PublicKeyCredentialRpEntity copy$default(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = publicKeyCredentialRpEntity.name;
        }
        if ((i10 & 2) != 0) {
            str2 = publicKeyCredentialRpEntity.f15348id;
        }
        return publicKeyCredentialRpEntity.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.f15348id;
    }

    public final PublicKeyCredentialRpEntity copy(String str, String str2) {
        m.f(str, "name");
        m.f(str2, "id");
        return new PublicKeyCredentialRpEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        return m.b(this.name, publicKeyCredentialRpEntity.name) && m.b(this.f15348id, publicKeyCredentialRpEntity.f15348id);
    }

    public final String getId() {
        return this.f15348id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.f15348id.hashCode();
    }

    public String toString() {
        return "PublicKeyCredentialRpEntity(name=" + this.name + ", id=" + this.f15348id + ')';
    }
}
