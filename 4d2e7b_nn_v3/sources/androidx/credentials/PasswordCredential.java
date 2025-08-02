package androidx.credentials;

import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.credentials.internal.FrameworkClassParsingException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class PasswordCredential extends Credential {
    public static final String BUNDLE_KEY_ID = "androidx.credentials.BUNDLE_KEY_ID";
    public static final String BUNDLE_KEY_PASSWORD = "androidx.credentials.BUNDLE_KEY_PASSWORD";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_PASSWORD_CREDENTIAL = "android.credentials.TYPE_PASSWORD_CREDENTIAL";

    /* renamed from: id  reason: collision with root package name */
    private final String f15318id;
    private final String password;

    public static final class Companion {
        private Companion() {
        }

        public final PasswordCredential createFrom$credentials_release(Bundle bundle) {
            m.f(bundle, "data");
            try {
                String string = bundle.getString("androidx.credentials.BUNDLE_KEY_ID");
                String string2 = bundle.getString("androidx.credentials.BUNDLE_KEY_PASSWORD");
                m.c(string);
                m.c(string2);
                return new PasswordCredential(string, string2, bundle, (DefaultConstructorMarker) null);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }

        public final Bundle toBundle$credentials_release(String str, String str2) {
            m.f(str, "id");
            m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_ID", str);
            bundle.putString("androidx.credentials.BUNDLE_KEY_PASSWORD", str2);
            return bundle;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PasswordCredential(String str, String str2, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bundle);
    }

    public static final PasswordCredential createFrom$credentials_release(Bundle bundle) {
        return Companion.createFrom$credentials_release(bundle);
    }

    public static final Bundle toBundle$credentials_release(String str, String str2) {
        return Companion.toBundle$credentials_release(str, str2);
    }

    public final String getId() {
        return this.f15318id;
    }

    public final String getPassword() {
        return this.password;
    }

    private PasswordCredential(String str, String str2, Bundle bundle) {
        super(TYPE_PASSWORD_CREDENTIAL, bundle);
        this.f15318id = str;
        this.password = str2;
        if (str2.length() <= 0) {
            throw new IllegalArgumentException("password should not be empty".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PasswordCredential(String str, String str2) {
        this(str, str2, Companion.toBundle$credentials_release(str, str2));
        m.f(str, "id");
        m.f(str2, HintConstants.AUTOFILL_HINT_PASSWORD);
    }
}
