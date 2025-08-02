package com.geetest.core;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class i implements Comparable<i> {

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f6014a;

    /* renamed from: b  reason: collision with root package name */
    public final List<byte[]> f6015b;

    public static class b implements Comparator<byte[]> {
        public b() {
        }

        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int compare = Integer.compare(bArr.length, bArr2.length);
            if (compare != 0) {
                return compare;
            }
            for (int i10 = 0; i10 < bArr.length; i10++) {
                compare = Byte.compare(bArr[i10], bArr2[i10]);
                if (compare != 0) {
                    return compare;
                }
            }
            return compare;
        }
    }

    public i(v vVar) throws CertificateParsingException {
        if (vVar instanceof s0) {
            s0 s0Var = (s0) vVar;
            List<l> a10 = a(s0Var.a(0));
            this.f6014a = a10;
            Collections.sort(a10);
            List<byte[]> b10 = b(s0Var.a(1));
            this.f6015b = b10;
            Collections.sort(b10, new b());
            return;
        }
        throw new CertificateParsingException("Expected sequence for AttestationApplicationId, found " + vVar.getClass().getName());
    }

    /* renamed from: a */
    public int compareTo(i iVar) {
        int compare = Integer.compare(this.f6014a.size(), iVar.f6014a.size());
        if (compare != 0) {
            return compare;
        }
        for (int i10 = 0; i10 < this.f6014a.size(); i10++) {
            int a10 = this.f6014a.get(i10).compareTo(iVar.f6014a.get(i10));
            if (a10 != 0) {
                return a10;
            }
        }
        int compare2 = Integer.compare(this.f6015b.size(), iVar.f6015b.size());
        if (compare2 != 0) {
            return compare2;
        }
        for (int i11 = 0; i11 < this.f6015b.size(); i11++) {
            byte[] bArr = this.f6015b.get(i11);
            byte[] bArr2 = iVar.f6015b.get(i11);
            int compare3 = Integer.compare(bArr.length, bArr2.length);
            if (compare3 == 0) {
                int i12 = 0;
                while (i12 < bArr.length && (compare3 = Byte.compare(bArr[i12], bArr2[i12])) == 0) {
                    i12++;
                }
            }
            compare2 = compare3;
            if (compare2 != 0) {
                return compare2;
            }
        }
        return compare2;
    }

    public final List<byte[]> b(v vVar) throws CertificateParsingException {
        if (vVar instanceof w0) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = ((w0) vVar).iterator();
            while (true) {
                f3 f3Var = (f3) it;
                if (!f3Var.hasNext()) {
                    return arrayList;
                }
                arrayList.add(c.b((v) f3Var.next()));
            }
        } else {
            throw new CertificateParsingException("Expected set for Signature digests, found " + vVar.getClass().getName());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof i) || compareTo((i) obj) != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int size = this.f6014a.size();
        int i10 = 1;
        for (l append : this.f6014a) {
            sb2.append("Package info ");
            sb2.append(i10);
            sb2.append(DomExceptionUtils.SEPARATOR);
            sb2.append(size);
            sb2.append(":\n");
            sb2.append(append);
            i10++;
        }
        sb2.append(10);
        int size2 = this.f6015b.size();
        int i11 = 1;
        for (byte[] next : this.f6015b) {
            sb2.append("Signature digest ");
            int i12 = i11 + 1;
            sb2.append(i11);
            sb2.append(DomExceptionUtils.SEPARATOR);
            sb2.append(size2);
            sb2.append(":\n");
            int length = next.length;
            for (int i13 = 0; i13 < length; i13++) {
                sb2.append(String.format("%02X ", new Object[]{Byte.valueOf(next[i13])}));
            }
            sb2.append(10);
            i11 = i12;
        }
        return sb2.toString();
    }

    public final List<l> a(v vVar) throws CertificateParsingException {
        if (vVar instanceof w0) {
            ArrayList arrayList = new ArrayList();
            Iterator<v> it = ((w0) vVar).iterator();
            while (true) {
                f3 f3Var = (f3) it;
                if (!f3Var.hasNext()) {
                    return arrayList;
                }
                arrayList.add(new l((v) f3Var.next()));
            }
        } else {
            throw new CertificateParsingException("Expected set for AttestationApplicationsInfos, found " + vVar.getClass().getName());
        }
    }
}
