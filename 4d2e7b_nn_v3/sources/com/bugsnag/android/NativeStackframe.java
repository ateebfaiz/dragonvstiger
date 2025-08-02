package com.bugsnag.android;

import c1.p;
import com.bugsnag.android.k2;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;

public final class NativeStackframe implements k2.a {
    private String codeIdentifier;
    private String file;
    private Long frameAddress;
    private Boolean isPC;
    private Number lineNumber;
    private Long loadAddress;
    private String method;
    private Long symbolAddress;
    private ErrorType type;

    public NativeStackframe(String str, String str2, Number number, Long l10, Long l11, Long l12, Boolean bool, ErrorType errorType, String str3) {
        this.method = str;
        this.file = str2;
        this.lineNumber = number;
        this.frameAddress = l10;
        this.symbolAddress = l11;
        this.loadAddress = l12;
        this.isPC = bool;
        this.type = errorType;
        this.codeIdentifier = str3;
    }

    public final String getCodeIdentifier() {
        return this.codeIdentifier;
    }

    public final String getFile() {
        return this.file;
    }

    public final Long getFrameAddress() {
        return this.frameAddress;
    }

    public final Number getLineNumber() {
        return this.lineNumber;
    }

    public final Long getLoadAddress() {
        return this.loadAddress;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Long getSymbolAddress() {
        return this.symbolAddress;
    }

    public final ErrorType getType() {
        return this.type;
    }

    public final Boolean isPC() {
        return this.isPC;
    }

    public final void setCodeIdentifier(String str) {
        this.codeIdentifier = str;
    }

    public final void setFile(String str) {
        this.file = str;
    }

    public final void setFrameAddress(Long l10) {
        this.frameAddress = l10;
    }

    public final void setLineNumber(Number number) {
        this.lineNumber = number;
    }

    public final void setLoadAddress(Long l10) {
        this.loadAddress = l10;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final void setPC(Boolean bool) {
        this.isPC = bool;
    }

    public final void setSymbolAddress(Long l10) {
        this.symbolAddress = l10;
    }

    public final void setType(ErrorType errorType) {
        this.type = errorType;
    }

    public void toStream(k2 k2Var) throws IOException {
        k2Var.j();
        k2Var.v(FirebaseAnalytics.Param.METHOD).K(this.method);
        k2Var.v("file").K(this.file);
        k2Var.v("lineNumber").J(this.lineNumber);
        if (this.frameAddress != null) {
            k2Var.v("frameAddress").K(p.f17266a.h(getFrameAddress()));
        }
        if (this.symbolAddress != null) {
            k2Var.v("symbolAddress").K(p.f17266a.h(getSymbolAddress()));
        }
        if (this.loadAddress != null) {
            k2Var.v("loadAddress").K(p.f17266a.h(getLoadAddress()));
        }
        k2Var.v("codeIdentifier").K(this.codeIdentifier);
        k2Var.v("isPC").I(this.isPC);
        ErrorType errorType = this.type;
        if (errorType != null) {
            k2Var.v("type").K(errorType.getDesc$bugsnag_android_core_release());
        }
        k2Var.n();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NativeStackframe(java.lang.String r14, java.lang.String r15, java.lang.Number r16, java.lang.Long r17, java.lang.Long r18, java.lang.Long r19, java.lang.Boolean r20, com.bugsnag.android.ErrorType r21, java.lang.String r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r11 = r2
            goto L_0x000b
        L_0x0009:
            r11 = r21
        L_0x000b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0011
            r12 = r2
            goto L_0x0013
        L_0x0011:
            r12 = r22
        L_0x0013:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.NativeStackframe.<init>(java.lang.String, java.lang.String, java.lang.Number, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Boolean, com.bugsnag.android.ErrorType, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
