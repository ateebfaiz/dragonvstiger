package com.google.firebase.platforminfo;

final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private final String f9325a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9326b;

    a(String str, String str2) {
        if (str != null) {
            this.f9325a = str;
            if (str2 != null) {
                this.f9326b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    public String b() {
        return this.f9325a;
    }

    public String c() {
        return this.f9326b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.f9325a.equals(cVar.b()) || !this.f9326b.equals(cVar.c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f9325a.hashCode() ^ 1000003) * 1000003) ^ this.f9326b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f9325a + ", version=" + this.f9326b + "}";
    }
}
