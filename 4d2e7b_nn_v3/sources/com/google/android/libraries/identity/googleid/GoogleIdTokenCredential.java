package com.google.android.libraries.identity.googleid;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.credentials.CustomCredential;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class GoogleIdTokenCredential extends CustomCredential {
    public static final String BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_GOOGLE_ID_TOKEN_SUBTYPE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TYPE_GOOGLE_ID_TOKEN_CREDENTIAL = "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL";
    public static final String TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL = "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_SIWG_CREDENTIAL";
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final Uri zzf;
    private final String zzg;

    public static final class Builder {
        private String zza = "";
        private String zzb = "";
        private String zzc;
        private String zzd;
        private String zze;
        private Uri zzf;
        private String zzg;

        public final GoogleIdTokenCredential build() {
            return new GoogleIdTokenCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
        }

        public final Builder setDisplayName(String str) {
            this.zzc = str;
            return this;
        }

        public final Builder setFamilyName(String str) {
            this.zzd = str;
            return this;
        }

        public final Builder setGivenName(String str) {
            this.zze = str;
            return this;
        }

        public final Builder setId(@NonNull String str) {
            m.f(str, "id");
            this.zza = str;
            return this;
        }

        public final Builder setIdToken(@NonNull String str) {
            m.f(str, "idToken");
            this.zzb = str;
            return this;
        }

        public final Builder setPhoneNumber(String str) {
            this.zzg = str;
            return this;
        }

        public final Builder setProfilePictureUri(Uri uri) {
            this.zzf = uri;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public final GoogleIdTokenCredential createFrom(@NonNull Bundle bundle) {
            Uri uri;
            m.f(bundle, "data");
            try {
                String string = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID");
                String string2 = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN");
                String string3 = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME");
                String string4 = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME");
                String string5 = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME");
                if (Build.VERSION.SDK_INT >= 33) {
                    uri = (Uri) bundle.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI", Uri.class);
                } else {
                    uri = (Uri) bundle.getParcelable("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI");
                }
                Uri uri2 = uri;
                String string6 = bundle.getString("com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER");
                m.c(string);
                m.c(string2);
                return new GoogleIdTokenCredential(string, string2, string3, string4, string5, uri2, string6);
            } catch (Exception e10) {
                throw new GoogleIdTokenParsingException(e10);
            }
        }

        public /* synthetic */ Companion(@NonNull DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleIdTokenCredential(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, android.net.Uri r8, java.lang.String r9) {
        /*
            r2 = this;
            java.lang.String r0 = "id"
            kotlin.jvm.internal.m.f(r3, r0)
            java.lang.String r1 = "idToken"
            kotlin.jvm.internal.m.f(r4, r1)
            kotlin.jvm.internal.m.f(r3, r0)
            kotlin.jvm.internal.m.f(r4, r1)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID"
            r0.putString(r1, r3)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_ID_TOKEN"
            r0.putString(r1, r4)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_DISPLAY_NAME"
            r0.putString(r1, r5)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_FAMILY_NAME"
            r0.putString(r1, r6)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_GIVEN_NAME"
            r0.putString(r1, r7)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_PHONE_NUMBER"
            r0.putString(r1, r9)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.BUNDLE_KEY_PROFILE_PICTURE_URI"
            r0.putParcelable(r1, r8)
            java.lang.String r1 = "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL"
            r2.<init>(r1, r0)
            r2.zza = r3
            r2.zzb = r4
            r2.zzc = r5
            r2.zzd = r6
            r2.zze = r7
            r2.zzf = r8
            r2.zzg = r9
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0060
            int r3 = r4.length()
            if (r3 <= 0) goto L_0x0058
            return
        L_0x0058:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "idToken should not be empty"
            r3.<init>(r4)
            throw r3
        L_0x0060:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "id should not be empty"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, android.net.Uri, java.lang.String):void");
    }

    public static final GoogleIdTokenCredential createFrom(@NonNull Bundle bundle) {
        return Companion.createFrom(bundle);
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzc;
    }

    @Nullable
    public final String getFamilyName() {
        return this.zzd;
    }

    @Nullable
    public final String getGivenName() {
        return this.zze;
    }

    public final String getId() {
        return this.zza;
    }

    public final String getIdToken() {
        return this.zzb;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Nullable
    public final Uri getProfilePictureUri() {
        return this.zzf;
    }
}
