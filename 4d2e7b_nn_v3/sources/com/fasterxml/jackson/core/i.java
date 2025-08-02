package com.fasterxml.jackson.core;

public abstract class i extends c {
    protected i(String str, g gVar, Throwable th) {
        super(str, th);
    }

    public g a() {
        return null;
    }

    public String b() {
        return super.getMessage();
    }

    /* access modifiers changed from: protected */
    public String d() {
        return null;
    }

    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        a();
        String d10 = d();
        if (d10 == null) {
            return message;
        }
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append(message);
        if (d10 != null) {
            sb2.append(d10);
        }
        return sb2.toString();
    }

    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    protected i(String str) {
        super(str);
    }

    protected i(String str, g gVar) {
        this(str, gVar, (Throwable) null);
    }
}
