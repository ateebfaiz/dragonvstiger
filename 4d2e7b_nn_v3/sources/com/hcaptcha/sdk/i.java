package com.hcaptcha.sdk;

public class i extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final h f9540a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9541b;

    public i(h hVar, String str) {
        if (hVar != null) {
            this.f9540a = hVar;
            this.f9541b = str;
            return;
        }
        throw new NullPointerException("hCaptchaError is marked non-null but is null");
    }

    public boolean a(Object obj) {
        return obj instanceof i;
    }

    public h b() {
        return this.f9540a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!iVar.a(this) || !super.equals(obj)) {
            return false;
        }
        h b10 = b();
        h b11 = iVar.b();
        if (b10 != null ? !b10.equals(b11) : b11 != null) {
            return false;
        }
        String message = getMessage();
        String message2 = iVar.getMessage();
        if (message != null ? message.equals(message2) : message2 == null) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        String str = this.f9541b;
        if (str == null) {
            return this.f9540a.d();
        }
        return str;
    }

    public int hashCode() {
        int i10;
        int hashCode = super.hashCode();
        h b10 = b();
        int i11 = hashCode * 59;
        int i12 = 43;
        if (b10 == null) {
            i10 = 43;
        } else {
            i10 = b10.hashCode();
        }
        int i13 = i11 + i10;
        String message = getMessage();
        int i14 = i13 * 59;
        if (message != null) {
            i12 = message.hashCode();
        }
        return i14 + i12;
    }

    public String toString() {
        return "HCaptchaException(hCaptchaError=" + b() + ", message=" + getMessage() + ")";
    }

    public i(h hVar) {
        this(hVar, (String) null);
    }
}
