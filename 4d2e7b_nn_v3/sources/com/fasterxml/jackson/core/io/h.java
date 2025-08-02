package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.n;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class h implements n, Serializable {

    /* renamed from: d  reason: collision with root package name */
    private static final d f5165d = d.e();

    /* renamed from: a  reason: collision with root package name */
    protected final String f5166a;

    /* renamed from: b  reason: collision with root package name */
    protected char[] f5167b;

    /* renamed from: c  reason: collision with root package name */
    protected transient String f5168c;

    public h(String str) {
        if (str != null) {
            this.f5166a = str;
            return;
        }
        throw new IllegalStateException("Null String illegal for SerializedString");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.f5168c = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.f5166a);
    }

    public final char[] a() {
        char[] cArr = this.f5167b;
        if (cArr != null) {
            return cArr;
        }
        char[] f10 = f5165d.f(this.f5166a);
        this.f5167b = f10;
        return f10;
    }

    public int b(char[] cArr, int i10) {
        String str = this.f5166a;
        int length = str.length();
        if (i10 + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i10);
        return length;
    }

    public int c(char[] cArr, int i10) {
        char[] cArr2 = this.f5167b;
        if (cArr2 == null) {
            cArr2 = f5165d.f(this.f5166a);
            this.f5167b = cArr2;
        }
        int length = cArr2.length;
        if (i10 + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArr2, 0, cArr, i10, length);
        return length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.f5166a.equals(((h) obj).f5166a);
    }

    public final String getValue() {
        return this.f5166a;
    }

    public final int hashCode() {
        return this.f5166a.hashCode();
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new h(this.f5168c);
    }

    public final String toString() {
        return this.f5166a;
    }
}
