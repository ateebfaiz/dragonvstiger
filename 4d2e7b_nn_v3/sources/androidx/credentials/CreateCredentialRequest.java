package androidx.credentials;

import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.internal.FrameworkClassParsingException;
import com.google.firebase.messaging.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public abstract class CreateCredentialRequest {
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED = "androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS = "androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Bundle candidateQueryData;
    private final Bundle credentialData;
    private final DisplayInfo displayInfo;
    private final boolean isAutoSelectAllowed;
    private final boolean isSystemProviderRequired;
    private final String origin;
    private final boolean preferImmediatelyAvailableCredentials;
    private final String type;

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ CreateCredentialRequest createFrom$default(Companion companion, String str, Bundle bundle, Bundle bundle2, boolean z10, String str2, int i10, Object obj) {
            if ((i10 & 16) != 0) {
                str2 = null;
            }
            return companion.createFrom(str, bundle, bundle2, z10, str2);
        }

        @RequiresApi(23)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CreateCredentialRequest createFrom(String str, Bundle bundle, Bundle bundle2, boolean z10, String str2) {
            m.f(str, "type");
            m.f(bundle, "credentialData");
            m.f(bundle2, "candidateQueryData");
            try {
                if (m.b(str, PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    return CreatePasswordRequest.Companion.createFrom$credentials_release(bundle, str2, bundle2);
                }
                if (m.b(str, PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                    String string = bundle.getString(PublicKeyCredential.BUNDLE_KEY_SUBTYPE);
                    if (string != null && string.hashCode() == 589054771 && string.equals(CreatePublicKeyCredentialRequest.BUNDLE_VALUE_SUBTYPE_CREATE_PUBLIC_KEY_CREDENTIAL_REQUEST)) {
                        return CreatePublicKeyCredentialRequest.Companion.createFrom$credentials_release(bundle, str2, bundle2);
                    }
                    throw new FrameworkClassParsingException();
                }
                throw new FrameworkClassParsingException();
            } catch (FrameworkClassParsingException unused) {
                DisplayInfo parseFromCredentialDataBundle = DisplayInfo.Companion.parseFromCredentialDataBundle(bundle);
                if (parseFromCredentialDataBundle == null) {
                    return null;
                }
                return new CreateCustomCredentialRequest(str, bundle, bundle2, z10, parseFromCredentialDataBundle, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", false), str2, bundle.getBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", false));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class DisplayInfo {
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final String BUNDLE_KEY_CREDENTIAL_TYPE_ICON = "androidx.credentials.BUNDLE_KEY_CREDENTIAL_TYPE_ICON";
        public static final String BUNDLE_KEY_DEFAULT_PROVIDER = "androidx.credentials.BUNDLE_KEY_DEFAULT_PROVIDER";
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final String BUNDLE_KEY_REQUEST_DISPLAY_INFO = "androidx.credentials.BUNDLE_KEY_REQUEST_DISPLAY_INFO";
        public static final String BUNDLE_KEY_USER_DISPLAY_NAME = "androidx.credentials.BUNDLE_KEY_USER_DISPLAY_NAME";
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final String BUNDLE_KEY_USER_ID = "androidx.credentials.BUNDLE_KEY_USER_ID";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final Icon credentialTypeIcon;
        private final String preferDefaultProvider;
        private final CharSequence userDisplayName;
        private final CharSequence userId;

        public static final class Companion {
            private Companion() {
            }

            @RequiresApi(23)
            @RestrictTo({RestrictTo.Scope.LIBRARY})
            public final DisplayInfo parseFromCredentialDataBundle(Bundle bundle) {
                m.f(bundle, Constants.MessagePayloadKeys.FROM);
                try {
                    Bundle bundle2 = bundle.getBundle(DisplayInfo.BUNDLE_KEY_REQUEST_DISPLAY_INFO);
                    m.c(bundle2);
                    CharSequence charSequence = bundle2.getCharSequence(DisplayInfo.BUNDLE_KEY_USER_ID);
                    String string = bundle2.getString(DisplayInfo.BUNDLE_KEY_DEFAULT_PROVIDER);
                    m.c(charSequence);
                    return new DisplayInfo(charSequence, bundle2.getCharSequence(DisplayInfo.BUNDLE_KEY_USER_DISPLAY_NAME), (Icon) bundle2.getParcelable(DisplayInfo.BUNDLE_KEY_CREDENTIAL_TYPE_ICON), string);
                } catch (Exception unused) {
                    return null;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DisplayInfo(CharSequence charSequence) {
            this(charSequence, (CharSequence) null, 2, (DefaultConstructorMarker) null);
            m.f(charSequence, "userId");
        }

        @RequiresApi(23)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final DisplayInfo parseFromCredentialDataBundle(Bundle bundle) {
            return Companion.parseFromCredentialDataBundle(bundle);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Icon getCredentialTypeIcon() {
            return this.credentialTypeIcon;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final String getPreferDefaultProvider() {
            return this.preferDefaultProvider;
        }

        public final CharSequence getUserDisplayName() {
            return this.userDisplayName;
        }

        public final CharSequence getUserId() {
            return this.userId;
        }

        @RequiresApi(23)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(BUNDLE_KEY_USER_ID, this.userId);
            if (!TextUtils.isEmpty(this.userDisplayName)) {
                bundle.putCharSequence(BUNDLE_KEY_USER_DISPLAY_NAME, this.userDisplayName);
            }
            if (!TextUtils.isEmpty(this.preferDefaultProvider)) {
                bundle.putString(BUNDLE_KEY_DEFAULT_PROVIDER, this.preferDefaultProvider);
            }
            return bundle;
        }

        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2, Icon icon, String str) {
            m.f(charSequence, "userId");
            this.userId = charSequence;
            this.userDisplayName = charSequence2;
            this.credentialTypeIcon = icon;
            this.preferDefaultProvider = str;
            if (charSequence.length() <= 0) {
                throw new IllegalArgumentException("userId should not be empty".toString());
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DisplayInfo(CharSequence charSequence, CharSequence charSequence2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i10 & 2) != 0 ? null : charSequence2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2) {
            this(charSequence, charSequence2, (Icon) null, (String) null);
            m.f(charSequence, "userId");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DisplayInfo(CharSequence charSequence, CharSequence charSequence2, String str) {
            this(charSequence, charSequence2, (Icon) null, str);
            m.f(charSequence, "userId");
        }
    }

    public CreateCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z10, boolean z11, DisplayInfo displayInfo2, String str2, boolean z12) {
        m.f(str, "type");
        m.f(bundle, "credentialData");
        m.f(bundle2, "candidateQueryData");
        m.f(displayInfo2, "displayInfo");
        this.type = str;
        this.credentialData = bundle;
        this.candidateQueryData = bundle2;
        this.isSystemProviderRequired = z10;
        this.isAutoSelectAllowed = z11;
        this.displayInfo = displayInfo2;
        this.origin = str2;
        this.preferImmediatelyAvailableCredentials = z12;
        bundle.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
        bundle.putBoolean("androidx.credentials.BUNDLE_KEY_PREFER_IMMEDIATELY_AVAILABLE_CREDENTIALS", z12);
        bundle2.putBoolean("androidx.credentials.BUNDLE_KEY_IS_AUTO_SELECT_ALLOWED", z11);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CreateCredentialRequest createFrom(String str, Bundle bundle, Bundle bundle2, boolean z10, String str2) {
        return Companion.createFrom(str, bundle, bundle2, z10, str2);
    }

    public final Bundle getCandidateQueryData() {
        return this.candidateQueryData;
    }

    public final Bundle getCredentialData() {
        return this.credentialData;
    }

    public final DisplayInfo getDisplayInfo() {
        return this.displayInfo;
    }

    public final String getOrigin() {
        return this.origin;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean isAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public final boolean isSystemProviderRequired() {
        return this.isSystemProviderRequired;
    }

    public final boolean preferImmediatelyAvailableCredentials() {
        return this.preferImmediatelyAvailableCredentials;
    }
}
