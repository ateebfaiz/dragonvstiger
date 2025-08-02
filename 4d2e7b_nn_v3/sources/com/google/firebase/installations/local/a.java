package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;

final class a extends PersistedInstallationEntry {

    /* renamed from: a  reason: collision with root package name */
    private final String f9141a;

    /* renamed from: b  reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f9142b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9143c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9144d;

    /* renamed from: e  reason: collision with root package name */
    private final long f9145e;

    /* renamed from: f  reason: collision with root package name */
    private final long f9146f;

    /* renamed from: g  reason: collision with root package name */
    private final String f9147g;

    static final class b extends PersistedInstallationEntry.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f9148a;

        /* renamed from: b  reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f9149b;

        /* renamed from: c  reason: collision with root package name */
        private String f9150c;

        /* renamed from: d  reason: collision with root package name */
        private String f9151d;

        /* renamed from: e  reason: collision with root package name */
        private Long f9152e;

        /* renamed from: f  reason: collision with root package name */
        private Long f9153f;

        /* renamed from: g  reason: collision with root package name */
        private String f9154g;

        public PersistedInstallationEntry build() {
            String str = "";
            if (this.f9149b == null) {
                str = str + " registrationStatus";
            }
            if (this.f9152e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f9153f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f9148a, this.f9149b, this.f9150c, this.f9151d, this.f9152e.longValue(), this.f9153f.longValue(), this.f9154g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        public PersistedInstallationEntry.Builder setAuthToken(String str) {
            this.f9150c = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setExpiresInSecs(long j10) {
            this.f9152e = Long.valueOf(j10);
            return this;
        }

        public PersistedInstallationEntry.Builder setFirebaseInstallationId(String str) {
            this.f9148a = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setFisError(String str) {
            this.f9154g = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setRefreshToken(String str) {
            this.f9151d = str;
            return this;
        }

        public PersistedInstallationEntry.Builder setRegistrationStatus(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus != null) {
                this.f9149b = registrationStatus;
                return this;
            }
            throw new NullPointerException("Null registrationStatus");
        }

        public PersistedInstallationEntry.Builder setTokenCreationEpochInSecs(long j10) {
            this.f9153f = Long.valueOf(j10);
            return this;
        }

        b() {
        }

        private b(PersistedInstallationEntry persistedInstallationEntry) {
            this.f9148a = persistedInstallationEntry.getFirebaseInstallationId();
            this.f9149b = persistedInstallationEntry.getRegistrationStatus();
            this.f9150c = persistedInstallationEntry.getAuthToken();
            this.f9151d = persistedInstallationEntry.getRefreshToken();
            this.f9152e = Long.valueOf(persistedInstallationEntry.getExpiresInSecs());
            this.f9153f = Long.valueOf(persistedInstallationEntry.getTokenCreationEpochInSecs());
            this.f9154g = persistedInstallationEntry.getFisError();
        }
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedInstallationEntry)) {
            return false;
        }
        PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
        String str3 = this.f9141a;
        if (str3 != null ? str3.equals(persistedInstallationEntry.getFirebaseInstallationId()) : persistedInstallationEntry.getFirebaseInstallationId() == null) {
            if (this.f9142b.equals(persistedInstallationEntry.getRegistrationStatus()) && ((str = this.f9143c) != null ? str.equals(persistedInstallationEntry.getAuthToken()) : persistedInstallationEntry.getAuthToken() == null) && ((str2 = this.f9144d) != null ? str2.equals(persistedInstallationEntry.getRefreshToken()) : persistedInstallationEntry.getRefreshToken() == null) && this.f9145e == persistedInstallationEntry.getExpiresInSecs() && this.f9146f == persistedInstallationEntry.getTokenCreationEpochInSecs()) {
                String str4 = this.f9147g;
                if (str4 == null) {
                    if (persistedInstallationEntry.getFisError() == null) {
                        return true;
                    }
                } else if (str4.equals(persistedInstallationEntry.getFisError())) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getAuthToken() {
        return this.f9143c;
    }

    public long getExpiresInSecs() {
        return this.f9145e;
    }

    public String getFirebaseInstallationId() {
        return this.f9141a;
    }

    public String getFisError() {
        return this.f9147g;
    }

    public String getRefreshToken() {
        return this.f9144d;
    }

    public PersistedInstallation.RegistrationStatus getRegistrationStatus() {
        return this.f9142b;
    }

    public long getTokenCreationEpochInSecs() {
        return this.f9146f;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        String str = this.f9141a;
        int i13 = 0;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        int hashCode = (((i10 ^ 1000003) * 1000003) ^ this.f9142b.hashCode()) * 1000003;
        String str2 = this.f9143c;
        if (str2 == null) {
            i11 = 0;
        } else {
            i11 = str2.hashCode();
        }
        int i14 = (hashCode ^ i11) * 1000003;
        String str3 = this.f9144d;
        if (str3 == null) {
            i12 = 0;
        } else {
            i12 = str3.hashCode();
        }
        long j10 = this.f9145e;
        long j11 = this.f9146f;
        int i15 = (((((i14 ^ i12) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        String str4 = this.f9147g;
        if (str4 != null) {
            i13 = str4.hashCode();
        }
        return i15 ^ i13;
    }

    public PersistedInstallationEntry.Builder toBuilder() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f9141a + ", registrationStatus=" + this.f9142b + ", authToken=" + this.f9143c + ", refreshToken=" + this.f9144d + ", expiresInSecs=" + this.f9145e + ", tokenCreationEpochInSecs=" + this.f9146f + ", fisError=" + this.f9147g + "}";
    }

    private a(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j10, long j11, String str4) {
        this.f9141a = str;
        this.f9142b = registrationStatus;
        this.f9143c = str2;
        this.f9144d = str3;
        this.f9145e = j10;
        this.f9146f = j11;
        this.f9147g = str4;
    }
}
