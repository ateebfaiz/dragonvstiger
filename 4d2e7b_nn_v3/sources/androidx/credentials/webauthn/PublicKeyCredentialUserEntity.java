package androidx.credentials.webauthn;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import kotlin.jvm.internal.m;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class PublicKeyCredentialUserEntity {
    private final String displayName;

    /* renamed from: id  reason: collision with root package name */
    private final byte[] f15349id;
    private final String name;

    public PublicKeyCredentialUserEntity(String str, byte[] bArr, String str2) {
        m.f(str, "name");
        m.f(bArr, "id");
        m.f(str2, "displayName");
        this.name = str;
        this.f15349id = bArr;
        this.displayName = str2;
    }

    public static /* synthetic */ PublicKeyCredentialUserEntity copy$default(PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, String str, byte[] bArr, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = publicKeyCredentialUserEntity.name;
        }
        if ((i10 & 2) != 0) {
            bArr = publicKeyCredentialUserEntity.f15349id;
        }
        if ((i10 & 4) != 0) {
            str2 = publicKeyCredentialUserEntity.displayName;
        }
        return publicKeyCredentialUserEntity.copy(str, bArr, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final byte[] component2() {
        return this.f15349id;
    }

    public final String component3() {
        return this.displayName;
    }

    public final PublicKeyCredentialUserEntity copy(String str, byte[] bArr, String str2) {
        m.f(str, "name");
        m.f(bArr, "id");
        m.f(str2, "displayName");
        return new PublicKeyCredentialUserEntity(str, bArr, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        return m.b(this.name, publicKeyCredentialUserEntity.name) && m.b(this.f15349id, publicKeyCredentialUserEntity.f15349id) && m.b(this.displayName, publicKeyCredentialUserEntity.displayName);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final byte[] getId() {
        return this.f15349id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Arrays.hashCode(this.f15349id)) * 31) + this.displayName.hashCode();
    }

    public String toString() {
        return "PublicKeyCredentialUserEntity(name=" + this.name + ", id=" + Arrays.toString(this.f15349id) + ", displayName=" + this.displayName + ')';
    }
}
