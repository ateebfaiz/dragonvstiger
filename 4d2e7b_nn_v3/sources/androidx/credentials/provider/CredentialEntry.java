package androidx.credentials.provider;

import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class CredentialEntry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BeginGetCredentialOption beginGetCredentialOption;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        @RequiresApi(28)
        public final CredentialEntry createFrom$credentials_release(Slice slice) {
            String str;
            m.f(slice, "slice");
            try {
                SliceSpec a10 = slice.getSpec();
                if (a10 != null) {
                    str = a10.getType();
                } else {
                    str = null;
                }
                if (m.b(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    PasswordCredentialEntry fromSlice = PasswordCredentialEntry.Companion.fromSlice(slice);
                    m.c(fromSlice);
                    return fromSlice;
                } else if (m.b(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    PublicKeyCredentialEntry fromSlice2 = PublicKeyCredentialEntry.Companion.fromSlice(slice);
                    m.c(fromSlice2);
                    return fromSlice2;
                } else {
                    CustomCredentialEntry fromSlice3 = CustomCredentialEntry.Companion.fromSlice(slice);
                    m.c(fromSlice3);
                    return fromSlice3;
                }
            } catch (Exception unused) {
                return CustomCredentialEntry.Companion.fromSlice(slice);
            }
        }

        @RequiresApi(28)
        public final Slice toSlice$credentials_release(CredentialEntry credentialEntry) {
            m.f(credentialEntry, "entry");
            if (credentialEntry instanceof PasswordCredentialEntry) {
                return PasswordCredentialEntry.Companion.toSlice((PasswordCredentialEntry) credentialEntry);
            }
            if (credentialEntry instanceof PublicKeyCredentialEntry) {
                return PublicKeyCredentialEntry.Companion.toSlice((PublicKeyCredentialEntry) credentialEntry);
            }
            if (credentialEntry instanceof CustomCredentialEntry) {
                return CustomCredentialEntry.Companion.toSlice((CustomCredentialEntry) credentialEntry);
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CredentialEntry(String str, BeginGetCredentialOption beginGetCredentialOption2) {
        m.f(str, "type");
        m.f(beginGetCredentialOption2, "beginGetCredentialOption");
        this.type = str;
        this.beginGetCredentialOption = beginGetCredentialOption2;
    }

    @RequiresApi(28)
    public static final CredentialEntry createFrom$credentials_release(Slice slice) {
        return Companion.createFrom$credentials_release(slice);
    }

    @RequiresApi(28)
    public static final Slice toSlice$credentials_release(CredentialEntry credentialEntry) {
        return Companion.toSlice$credentials_release(credentialEntry);
    }

    public final BeginGetCredentialOption getBeginGetCredentialOption() {
        return this.beginGetCredentialOption;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getType() {
        return this.type;
    }
}
