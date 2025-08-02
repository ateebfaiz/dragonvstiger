package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class a extends AndroidClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f6341a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6342b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6343c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6344d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6345e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6346f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6347g;

    /* renamed from: h  reason: collision with root package name */
    private final String f6348h;

    /* renamed from: i  reason: collision with root package name */
    private final String f6349i;

    /* renamed from: j  reason: collision with root package name */
    private final String f6350j;

    /* renamed from: k  reason: collision with root package name */
    private final String f6351k;

    /* renamed from: l  reason: collision with root package name */
    private final String f6352l;

    static final class b extends AndroidClientInfo.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f6353a;

        /* renamed from: b  reason: collision with root package name */
        private String f6354b;

        /* renamed from: c  reason: collision with root package name */
        private String f6355c;

        /* renamed from: d  reason: collision with root package name */
        private String f6356d;

        /* renamed from: e  reason: collision with root package name */
        private String f6357e;

        /* renamed from: f  reason: collision with root package name */
        private String f6358f;

        /* renamed from: g  reason: collision with root package name */
        private String f6359g;

        /* renamed from: h  reason: collision with root package name */
        private String f6360h;

        /* renamed from: i  reason: collision with root package name */
        private String f6361i;

        /* renamed from: j  reason: collision with root package name */
        private String f6362j;

        /* renamed from: k  reason: collision with root package name */
        private String f6363k;

        /* renamed from: l  reason: collision with root package name */
        private String f6364l;

        b() {
        }

        public AndroidClientInfo build() {
            return new a(this.f6353a, this.f6354b, this.f6355c, this.f6356d, this.f6357e, this.f6358f, this.f6359g, this.f6360h, this.f6361i, this.f6362j, this.f6363k, this.f6364l);
        }

        public AndroidClientInfo.Builder setApplicationBuild(String str) {
            this.f6364l = str;
            return this;
        }

        public AndroidClientInfo.Builder setCountry(String str) {
            this.f6362j = str;
            return this;
        }

        public AndroidClientInfo.Builder setDevice(String str) {
            this.f6356d = str;
            return this;
        }

        public AndroidClientInfo.Builder setFingerprint(String str) {
            this.f6360h = str;
            return this;
        }

        public AndroidClientInfo.Builder setHardware(String str) {
            this.f6355c = str;
            return this;
        }

        public AndroidClientInfo.Builder setLocale(String str) {
            this.f6361i = str;
            return this;
        }

        public AndroidClientInfo.Builder setManufacturer(String str) {
            this.f6359g = str;
            return this;
        }

        public AndroidClientInfo.Builder setMccMnc(String str) {
            this.f6363k = str;
            return this;
        }

        public AndroidClientInfo.Builder setModel(String str) {
            this.f6354b = str;
            return this;
        }

        public AndroidClientInfo.Builder setOsBuild(String str) {
            this.f6358f = str;
            return this;
        }

        public AndroidClientInfo.Builder setProduct(String str) {
            this.f6357e = str;
            return this;
        }

        public AndroidClientInfo.Builder setSdkVersion(Integer num) {
            this.f6353a = num;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.f6341a;
        if (num != null ? num.equals(androidClientInfo.getSdkVersion()) : androidClientInfo.getSdkVersion() == null) {
            String str = this.f6342b;
            if (str != null ? str.equals(androidClientInfo.getModel()) : androidClientInfo.getModel() == null) {
                String str2 = this.f6343c;
                if (str2 != null ? str2.equals(androidClientInfo.getHardware()) : androidClientInfo.getHardware() == null) {
                    String str3 = this.f6344d;
                    if (str3 != null ? str3.equals(androidClientInfo.getDevice()) : androidClientInfo.getDevice() == null) {
                        String str4 = this.f6345e;
                        if (str4 != null ? str4.equals(androidClientInfo.getProduct()) : androidClientInfo.getProduct() == null) {
                            String str5 = this.f6346f;
                            if (str5 != null ? str5.equals(androidClientInfo.getOsBuild()) : androidClientInfo.getOsBuild() == null) {
                                String str6 = this.f6347g;
                                if (str6 != null ? str6.equals(androidClientInfo.getManufacturer()) : androidClientInfo.getManufacturer() == null) {
                                    String str7 = this.f6348h;
                                    if (str7 != null ? str7.equals(androidClientInfo.getFingerprint()) : androidClientInfo.getFingerprint() == null) {
                                        String str8 = this.f6349i;
                                        if (str8 != null ? str8.equals(androidClientInfo.getLocale()) : androidClientInfo.getLocale() == null) {
                                            String str9 = this.f6350j;
                                            if (str9 != null ? str9.equals(androidClientInfo.getCountry()) : androidClientInfo.getCountry() == null) {
                                                String str10 = this.f6351k;
                                                if (str10 != null ? str10.equals(androidClientInfo.getMccMnc()) : androidClientInfo.getMccMnc() == null) {
                                                    String str11 = this.f6352l;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getApplicationBuild() {
        return this.f6352l;
    }

    public String getCountry() {
        return this.f6350j;
    }

    public String getDevice() {
        return this.f6344d;
    }

    public String getFingerprint() {
        return this.f6348h;
    }

    public String getHardware() {
        return this.f6343c;
    }

    public String getLocale() {
        return this.f6349i;
    }

    public String getManufacturer() {
        return this.f6347g;
    }

    public String getMccMnc() {
        return this.f6351k;
    }

    public String getModel() {
        return this.f6342b;
    }

    public String getOsBuild() {
        return this.f6346f;
    }

    public String getProduct() {
        return this.f6345e;
    }

    public Integer getSdkVersion() {
        return this.f6341a;
    }

    public int hashCode() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Integer num = this.f6341a;
        int i21 = 0;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        int i22 = (i10 ^ 1000003) * 1000003;
        String str = this.f6342b;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int i23 = (i22 ^ i11) * 1000003;
        String str2 = this.f6343c;
        if (str2 == null) {
            i12 = 0;
        } else {
            i12 = str2.hashCode();
        }
        int i24 = (i23 ^ i12) * 1000003;
        String str3 = this.f6344d;
        if (str3 == null) {
            i13 = 0;
        } else {
            i13 = str3.hashCode();
        }
        int i25 = (i24 ^ i13) * 1000003;
        String str4 = this.f6345e;
        if (str4 == null) {
            i14 = 0;
        } else {
            i14 = str4.hashCode();
        }
        int i26 = (i25 ^ i14) * 1000003;
        String str5 = this.f6346f;
        if (str5 == null) {
            i15 = 0;
        } else {
            i15 = str5.hashCode();
        }
        int i27 = (i26 ^ i15) * 1000003;
        String str6 = this.f6347g;
        if (str6 == null) {
            i16 = 0;
        } else {
            i16 = str6.hashCode();
        }
        int i28 = (i27 ^ i16) * 1000003;
        String str7 = this.f6348h;
        if (str7 == null) {
            i17 = 0;
        } else {
            i17 = str7.hashCode();
        }
        int i29 = (i28 ^ i17) * 1000003;
        String str8 = this.f6349i;
        if (str8 == null) {
            i18 = 0;
        } else {
            i18 = str8.hashCode();
        }
        int i30 = (i29 ^ i18) * 1000003;
        String str9 = this.f6350j;
        if (str9 == null) {
            i19 = 0;
        } else {
            i19 = str9.hashCode();
        }
        int i31 = (i30 ^ i19) * 1000003;
        String str10 = this.f6351k;
        if (str10 == null) {
            i20 = 0;
        } else {
            i20 = str10.hashCode();
        }
        int i32 = (i31 ^ i20) * 1000003;
        String str11 = this.f6352l;
        if (str11 != null) {
            i21 = str11.hashCode();
        }
        return i32 ^ i21;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f6341a + ", model=" + this.f6342b + ", hardware=" + this.f6343c + ", device=" + this.f6344d + ", product=" + this.f6345e + ", osBuild=" + this.f6346f + ", manufacturer=" + this.f6347g + ", fingerprint=" + this.f6348h + ", locale=" + this.f6349i + ", country=" + this.f6350j + ", mccMnc=" + this.f6351k + ", applicationBuild=" + this.f6352l + "}";
    }

    private a(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f6341a = num;
        this.f6342b = str;
        this.f6343c = str2;
        this.f6344d = str3;
        this.f6345e = str4;
        this.f6346f = str5;
        this.f6347g = str6;
        this.f6348h = str7;
        this.f6349i = str8;
        this.f6350j = str9;
        this.f6351k = str10;
        this.f6352l = str11;
    }
}
