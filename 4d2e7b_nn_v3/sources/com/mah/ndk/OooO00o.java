package com.mah.ndk;

import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import b.c;
import c.b;
import c.e;
import c.g;
import com.google.android.games.paddleboat.GameControllerManager;
import java.io.IOException;
import java.io.InputStream;

public final class OooO00o {

    public static final class OooOO0 extends g {
        public static final OooOO0 o0000Ooo;
        public String OooO;
        public int OooO0Oo;
        public OooOO0O OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public int f10161OooO0o0;
        public String OooO0oO;
        public String OooO0oo;
        public String OooOO0;
        public String OooOO0O;
        public String OooOO0o;
        public int[] OooOOO;
        public boolean OooOOO0;
        public int OooOOOO;
        public String[] OooOOOo;
        public String[] OooOOo;
        public int OooOOo0;
        public int OooOOoo;

        /* renamed from: OooOo  reason: collision with root package name */
        public String[] f10162OooOo;
        public int OooOo0;
        public int[] OooOo00;
        public OooO0O0[] OooOo0O;
        public int OooOo0o;
        public C0367OooO0oO[] OooOoO;

        /* renamed from: OooOoO0  reason: collision with root package name */
        public int f10163OooOoO0;
        public int OooOoOO;
        public int OooOoo;
        public String[] OooOoo0;
        public boolean[] OooOooO;
        public int OooOooo;
        public C0365OooO0Oo[] Oooo;
        public int Oooo0;
        public OooO[] Oooo000;
        public int Oooo00O;
        public int[] Oooo00o;
        public C0366OooO0o0[] Oooo0O0;
        public int Oooo0OO;
        public int Oooo0o;
        public boolean[] Oooo0o0;
        public C0369OooOO0o[] Oooo0oO;
        public int Oooo0oo;
        public String[] OoooO;
        public C0117OooO00o[] OoooO0;
        public int OoooO00;
        public int OoooO0O;
        public int OoooOO0;
        public String OoooOOO;
        public String OoooOOo;
        public String OoooOo0;
        public String OoooOoO;
        public String OoooOoo;
        public int Ooooo00;
        public boolean Ooooo0o;
        public boolean OooooO0;
        public int OooooOO;
        public String OooooOo;
        public String[] Oooooo;
        public String Oooooo0;
        public int OoooooO;
        public int Ooooooo;
        public String[] o00000;
        public boolean o000000;
        public boolean o000000O;
        public boolean o000000o;
        public String[] o00000O;
        public int o00000O0;
        public int o00000OO;
        public int[] o00000Oo;
        public int o00000o0;
        public boolean o000OOo;
        public C0368OooO0oo o000oOoO;
        public int o00O0O;
        public boolean o00Oo0;
        public boolean o00Ooo;
        public boolean o00o0O;
        public boolean o00oO0O;
        public boolean o00oO0o;
        public String o00ooo;
        public boolean o0O0O00;
        public boolean o0OO00O;
        public boolean o0OOO0o;
        public boolean o0Oo0oo;
        public int o0OoOo0;
        public int o0ooOO0;
        public String o0ooOOo;
        public String o0ooOoO;
        public int oo000o;
        public String oo0o0Oo;
        public double ooOO;

        static {
            OooOO0 oooOO0 = new OooOO0(true);
            o0000Ooo = oooOO0;
            OooO00o.OooO00o();
            oooOO0.OooO0o = OooOO0O.OooOO0;
            oooOO0.o000oOoO = C0368OooO0oo.OooO0Oo;
        }

        public OooOO0() {
            super("mahx.sdk.Setting");
            this.OooO0oO = "";
            this.OooO0oo = "";
            this.OooO = "";
            this.OooOO0 = "";
            this.OooOO0O = "";
            this.OooOO0o = "";
            this.OooOOO0 = false;
            this.OooOOO = new int[0];
            this.OooOOOo = new String[0];
            this.OooOOo = new String[0];
            this.OooOo00 = new int[0];
            this.OooOo0O = new OooO0O0[0];
            this.f10162OooOo = new String[0];
            this.OooOoO = new C0367OooO0oO[0];
            this.OooOoo0 = new String[0];
            this.OooOooO = new boolean[0];
            this.Oooo000 = new OooO[0];
            this.Oooo00o = new int[0];
            this.Oooo0O0 = new C0366OooO0o0[0];
            this.Oooo0o0 = new boolean[0];
            this.Oooo0oO = new C0369OooOO0o[0];
            this.Oooo = new C0365OooO0Oo[0];
            this.OoooO0 = new C0117OooO00o[0];
            this.OoooO = new String[0];
            this.OoooOOO = "";
            this.OoooOOo = "";
            this.OoooOo0 = "";
            this.OoooOoO = "";
            this.OoooOoo = "";
            this.Ooooo00 = -1;
            this.Ooooo0o = false;
            this.OooooO0 = false;
            this.OooooOO = 100;
            this.OooooOo = "";
            this.Oooooo0 = "";
            this.Oooooo = new String[0];
            this.Ooooooo = 0;
            this.o0OoOo0 = 3;
            this.ooOO = 1.6d;
            this.o00O0O = 120;
            this.o00Oo0 = false;
            this.o00Ooo = true;
            this.o00o0O = true;
            this.o00ooo = "";
            this.oo000o = 0;
            this.o00oO0o = false;
            this.o00oO0O = false;
            this.o0ooOO0 = 60;
            this.o0ooOOo = "";
            this.o0ooOoO = "";
            this.o0OOO0o = false;
            this.o0Oo0oo = false;
            this.o0OO00O = true;
            this.oo0o0Oo = "";
            this.o0O0O00 = false;
            this.o000OOo = true;
            this.o000000 = false;
            this.o000000O = true;
            this.o000000o = true;
            this.o00000 = new String[0];
            this.o00000O = new String[0];
            this.o00000Oo = new int[0];
            this.OooO0o = OooOO0O.OooOO0;
            this.o000oOoO = C0368OooO0oo.OooO0Oo;
        }

        public static OooOO0 OooO0O0(InputStream inputStream) throws IOException {
            b bVar = new b(inputStream);
            OooOO0 oooOO0 = new OooOO0();
            oooOO0.OooO00o(bVar);
            return oooOO0;
        }

        public static OooOO0 o0000OO0() {
            return o0000Ooo;
        }

        public void OooO(String str) {
            OooO00o();
            this.OooO0Oo |= 4;
            this.OooO0oo = str;
        }

        public void OooO00o(OooOO0O oooOO0O) {
            OooO00o();
            oooOO0O.getClass();
            this.OooO0Oo |= 1;
            this.OooO0o = oooOO0O;
        }

        public void OooO0OO(int i10, int i11) {
            OooO00o();
            this.OooOOO[i10] = i11;
        }

        public void OooO0Oo(boolean z10) {
            OooO00o();
            this.OooO0Oo |= 128;
            this.OooOOO0 = z10;
        }

        public C0365OooO0Oo OooO0o(int i10) {
            return this.Oooo[i10];
        }

        public void OooO0o0(int i10, String str) {
            OooO00o();
            this.OooOOOo[i10] = str;
        }

        public C0366OooO0o0 OooO0oO(int i10) {
            return this.Oooo0O0[i10];
        }

        public int OooO0oo(int i10) {
            return this.Oooo00o[i10];
        }

        public String OooOO0(int i10) {
            return this.f10162OooOo[i10];
        }

        public void OooOO0O() {
            OooO00o();
            this.OooO0Oo &= -5;
            this.OooO0oo = "";
        }

        public String OooOO0o(int i10) {
            return this.OooOOo[i10];
        }

        public void OooOOO(String str) {
            OooO00o();
            this.OooO0Oo |= 16;
            this.OooOO0 = str;
        }

        public void OooOOO0(String str) {
            OooO00o();
            this.OooO0Oo |= 8;
            this.OooO = str;
        }

        public void OooOOOO(String str) {
            OooO00o();
            this.OooO0Oo |= 2;
            this.OooO0oO = str;
        }

        public OooO0O0 OooOOOo(int i10) {
            return this.OooOo0O[i10];
        }

        public OooO OooOOo(int i10) {
            return this.Oooo000[i10];
        }

        public String OooOOo0(int i10) {
            return this.OooOOOo[i10];
        }

        public boolean OooOOoo(int i10) {
            return this.OooOooO[i10];
        }

        public void OooOo(String str) {
            OooO00o();
            this.OooO0Oo |= 64;
            this.OooOO0o = str;
        }

        public void OooOo0() {
            OooO00o();
            while (true) {
                int i10 = this.f10163OooOoO0;
                if (i10 > 0) {
                    String[] strArr = this.f10162OooOo;
                    this.f10163OooOoO0 = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public int OooOo00(int i10) {
            return this.OooOOO[i10];
        }

        public void OooOo0O(String str) {
            OooO00o();
            this.OooO0Oo |= 32;
            this.OooOO0O = str;
        }

        public void OooOo0o() {
            OooO00o();
            while (true) {
                int i10 = this.OooOOoo;
                if (i10 > 0) {
                    String[] strArr = this.OooOOo;
                    this.OooOOoo = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public void OooOoO() {
            OooO00o();
            while (true) {
                int i10 = this.OooOo0;
                if (i10 > 0) {
                    int[] iArr = this.OooOo00;
                    this.OooOo0 = i10 - 1;
                    iArr[i10] = 0;
                } else {
                    return;
                }
            }
        }

        public void OooOoO0() {
            OooO00o();
            while (true) {
                int i10 = this.OoooO0O;
                if (i10 > 0) {
                    C0117OooO00o[] oooO00oArr = this.OoooO0;
                    this.OoooO0O = i10 - 1;
                    oooO00oArr[i10] = C0117OooO00o.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOoOO() {
            OooO00o();
            while (true) {
                int i10 = this.OooOo0o;
                if (i10 > 0) {
                    OooO0O0[] oooO0O0Arr = this.OooOo0O;
                    this.OooOo0o = i10 - 1;
                    oooO0O0Arr[i10] = OooO0O0.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOoo() {
            OooO00o();
            while (true) {
                int i10 = this.Oooo00O;
                if (i10 > 0) {
                    OooO[] oooOArr = this.Oooo000;
                    this.Oooo00O = i10 - 1;
                    oooOArr[i10] = OooO.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOoo0() {
            OooO00o();
            while (true) {
                int i10 = this.OooOOo0;
                if (i10 > 0) {
                    String[] strArr = this.OooOOOo;
                    this.OooOOo0 = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public void OooOooO() {
            OooO00o();
            while (true) {
                int i10 = this.OooOooo;
                if (i10 > 0) {
                    boolean[] zArr = this.OooOooO;
                    this.OooOooo = i10 - 1;
                    zArr[i10] = false;
                } else {
                    return;
                }
            }
        }

        public void OooOooo() {
            OooO00o();
            while (true) {
                int i10 = this.OooOOOO;
                if (i10 > 0) {
                    int[] iArr = this.OooOOO;
                    this.OooOOOO = i10 - 1;
                    iArr[i10] = 0;
                } else {
                    return;
                }
            }
        }

        public void Oooo(int i10) {
            C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
            if (i10 >= oooOO0oArr.length) {
                C0369OooOO0o[] oooOO0oArr2 = new C0369OooOO0o[i10];
                System.arraycopy(oooOO0oArr, 0, oooOO0oArr2, 0, this.Oooo0oo);
                this.Oooo0oO = oooOO0oArr2;
            }
        }

        public void Oooo0() {
            OooO00o();
            this.OooO0Oo &= -17;
            this.OooOO0 = "";
        }

        public void Oooo000(int i10) {
            C0367OooO0oO[] oooO0oOArr = this.OooOoO;
            if (i10 >= oooO0oOArr.length) {
                C0367OooO0oO[] oooO0oOArr2 = new C0367OooO0oO[i10];
                System.arraycopy(oooO0oOArr, 0, oooO0oOArr2, 0, this.OooOoOO);
                this.OooOoO = oooO0oOArr2;
            }
        }

        public void Oooo00O() {
            OooO00o();
            this.OooO0Oo &= -129;
            this.OooOOO0 = false;
        }

        public void Oooo00o() {
            OooO00o();
            this.OooO0Oo &= -9;
            this.OooO = "";
        }

        public void Oooo0O0(int i10) {
            int[] iArr = this.OooOo00;
            if (i10 >= iArr.length) {
                int[] iArr2 = new int[i10];
                System.arraycopy(iArr, 0, iArr2, 0, this.OooOo0);
                this.OooOo00 = iArr2;
            }
        }

        public void Oooo0OO() {
            OooO00o();
            this.OooO0Oo &= -3;
            this.OooO0oO = "";
        }

        public void Oooo0o(int i10) {
            OooO[] oooOArr = this.Oooo000;
            if (i10 >= oooOArr.length) {
                OooO[] oooOArr2 = new OooO[i10];
                System.arraycopy(oooOArr, 0, oooOArr2, 0, this.Oooo00O);
                this.Oooo000 = oooOArr2;
            }
        }

        public void Oooo0o0(int i10) {
            String[] strArr = this.OooOOOo;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.OooOOo0);
                this.OooOOOo = strArr2;
            }
        }

        public void Oooo0oO(int i10) {
            boolean[] zArr = this.OooOooO;
            if (i10 >= zArr.length) {
                boolean[] zArr2 = new boolean[i10];
                System.arraycopy(zArr, 0, zArr2, 0, this.OooOooo);
                this.OooOooO = zArr2;
            }
        }

        public void Oooo0oo(int i10) {
            int[] iArr = this.OooOOO;
            if (i10 >= iArr.length) {
                int[] iArr2 = new int[i10];
                System.arraycopy(iArr, 0, iArr2, 0, this.OooOOOO);
                this.OooOOO = iArr2;
            }
        }

        public void OoooO() {
            OooO00o();
            this.f10161OooO0o0 &= -8193;
            this.o00ooo = "";
        }

        public void OoooO0() {
            OooO00o();
            this.f10161OooO0o0 &= -33554433;
            this.o000OOo = true;
        }

        public void OoooO00(int i10) {
            String[] strArr = this.Oooooo;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.OoooooO);
                this.Oooooo = strArr2;
            }
        }

        public void OoooO0O() {
            OooO00o();
            this.f10161OooO0o0 &= -4194305;
            this.o0OO00O = true;
        }

        public void OoooOO0() {
            OooO00o();
            this.f10161OooO0o0 &= -16385;
            this.oo000o = 0;
        }

        public void OoooOOO() {
            OooO00o();
            this.OooO0Oo &= -67108865;
            this.OoooOOO = "";
        }

        public void OoooOOo() {
            OooO00o();
            this.f10161OooO0o0 &= -129;
            this.o0OoOo0 = 3;
        }

        public void OoooOo0(int i10) {
            OooO00o();
            this.OooO0Oo |= Integer.MIN_VALUE;
            this.Ooooo00 = i10;
        }

        public void OoooOoO(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 4;
            this.OooooOO = i10;
        }

        public void OoooOoo(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 131072;
            this.o0ooOO0 = i10;
        }

        public void Ooooo00() {
            OooO00o();
            this.OooO0Oo &= -2;
            this.OooO0o = OooOO0O.OooOO0;
        }

        public void Ooooo0o() {
            OooO00o();
            this.OooO0Oo &= -1073741825;
            this.OoooOoo = "";
        }

        public void OooooO0() {
            OooO00o();
            this.OooO0Oo &= Integer.MAX_VALUE;
            this.Ooooo00 = -1;
        }

        public void OooooOO() {
            OooO00o();
            this.f10161OooO0o0 &= -9;
            this.OooooOo = "";
        }

        public void OooooOo() {
            OooO00o();
            this.f10161OooO0o0 &= -524289;
            this.o0ooOoO = "";
        }

        public void Oooooo() {
            OooO00o();
            this.f10161OooO0o0 &= -65537;
            this.o00oO0O = false;
        }

        public void Oooooo0() {
            OooO00o();
            this.OooO0Oo &= -33554433;
            this.o000oOoO = C0368OooO0oo.OooO0Oo;
        }

        public void OoooooO() {
            OooO00o();
            this.f10161OooO0o0 &= -2;
            this.Ooooo0o = false;
        }

        public void Ooooooo() {
            OooO00o();
            this.f10161OooO0o0 &= -4097;
            this.o00o0O = true;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OooOO0)) {
                return false;
            }
            OooOO0 oooOO0 = (OooOO0) obj;
            if (this.OooO0o != oooOO0.OooO0o || !this.OooO0oO.equals(oooOO0.OooO0oO) || !this.OooO0oo.equals(oooOO0.OooO0oo) || !this.OooO.equals(oooOO0.OooO) || !this.OooOO0.equals(oooOO0.OooOO0) || !this.OooOO0O.equals(oooOO0.OooOO0O) || !this.OooOO0o.equals(oooOO0.OooOO0o) || this.OooOOO0 != oooOO0.OooOOO0 || this.OooOOO.length != oooOO0.OooOOO.length) {
                return false;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.OooOOO;
                if (i10 < iArr.length) {
                    if (iArr[i10] != oooOO0.OooOOO[i10]) {
                        return false;
                    }
                    i10++;
                } else if (this.OooOOOo.length != oooOO0.OooOOOo.length) {
                    return false;
                } else {
                    int i11 = 0;
                    while (true) {
                        String[] strArr = this.OooOOOo;
                        if (i11 < strArr.length) {
                            if (!strArr[i11].equals(oooOO0.OooOOOo[i11])) {
                                return false;
                            }
                            i11++;
                        } else if (this.OooOOo.length != oooOO0.OooOOo.length) {
                            return false;
                        } else {
                            int i12 = 0;
                            while (true) {
                                String[] strArr2 = this.OooOOo;
                                if (i12 < strArr2.length) {
                                    if (!strArr2[i12].equals(oooOO0.OooOOo[i12])) {
                                        return false;
                                    }
                                    i12++;
                                } else if (this.OooOo00.length != oooOO0.OooOo00.length) {
                                    return false;
                                } else {
                                    int i13 = 0;
                                    while (true) {
                                        int[] iArr2 = this.OooOo00;
                                        if (i13 < iArr2.length) {
                                            if (iArr2[i13] != oooOO0.OooOo00[i13]) {
                                                return false;
                                            }
                                            i13++;
                                        } else if (this.OooOo0O.length != oooOO0.OooOo0O.length) {
                                            return false;
                                        } else {
                                            int i14 = 0;
                                            while (true) {
                                                OooO0O0[] oooO0O0Arr = this.OooOo0O;
                                                if (i14 < oooO0O0Arr.length) {
                                                    if (oooO0O0Arr[i14] != oooOO0.OooOo0O[i14]) {
                                                        return false;
                                                    }
                                                    i14++;
                                                } else if (this.f10162OooOo.length != oooOO0.f10162OooOo.length) {
                                                    return false;
                                                } else {
                                                    int i15 = 0;
                                                    while (true) {
                                                        String[] strArr3 = this.f10162OooOo;
                                                        if (i15 < strArr3.length) {
                                                            if (!strArr3[i15].equals(oooOO0.f10162OooOo[i15])) {
                                                                return false;
                                                            }
                                                            i15++;
                                                        } else if (this.OooOoO.length != oooOO0.OooOoO.length) {
                                                            return false;
                                                        } else {
                                                            int i16 = 0;
                                                            while (true) {
                                                                C0367OooO0oO[] oooO0oOArr = this.OooOoO;
                                                                if (i16 < oooO0oOArr.length) {
                                                                    if (oooO0oOArr[i16] != oooOO0.OooOoO[i16]) {
                                                                        return false;
                                                                    }
                                                                    i16++;
                                                                } else if (this.OooOoo0.length != oooOO0.OooOoo0.length) {
                                                                    return false;
                                                                } else {
                                                                    int i17 = 0;
                                                                    while (true) {
                                                                        String[] strArr4 = this.OooOoo0;
                                                                        if (i17 < strArr4.length) {
                                                                            if (!strArr4[i17].equals(oooOO0.OooOoo0[i17])) {
                                                                                return false;
                                                                            }
                                                                            i17++;
                                                                        } else if (this.OooOooO.length != oooOO0.OooOooO.length) {
                                                                            return false;
                                                                        } else {
                                                                            int i18 = 0;
                                                                            while (true) {
                                                                                boolean[] zArr = this.OooOooO;
                                                                                if (i18 < zArr.length) {
                                                                                    if (zArr[i18] != oooOO0.OooOooO[i18]) {
                                                                                        return false;
                                                                                    }
                                                                                    i18++;
                                                                                } else if (this.Oooo000.length != oooOO0.Oooo000.length) {
                                                                                    return false;
                                                                                } else {
                                                                                    int i19 = 0;
                                                                                    while (true) {
                                                                                        OooO[] oooOArr = this.Oooo000;
                                                                                        if (i19 < oooOArr.length) {
                                                                                            if (oooOArr[i19] != oooOO0.Oooo000[i19]) {
                                                                                                return false;
                                                                                            }
                                                                                            i19++;
                                                                                        } else if (this.Oooo00o.length != oooOO0.Oooo00o.length) {
                                                                                            return false;
                                                                                        } else {
                                                                                            int i20 = 0;
                                                                                            while (true) {
                                                                                                int[] iArr3 = this.Oooo00o;
                                                                                                if (i20 < iArr3.length) {
                                                                                                    if (iArr3[i20] != oooOO0.Oooo00o[i20]) {
                                                                                                        return false;
                                                                                                    }
                                                                                                    i20++;
                                                                                                } else if (this.Oooo0O0.length != oooOO0.Oooo0O0.length) {
                                                                                                    return false;
                                                                                                } else {
                                                                                                    int i21 = 0;
                                                                                                    while (true) {
                                                                                                        C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
                                                                                                        if (i21 < oooO0o0Arr.length) {
                                                                                                            if (oooO0o0Arr[i21] != oooOO0.Oooo0O0[i21]) {
                                                                                                                return false;
                                                                                                            }
                                                                                                            i21++;
                                                                                                        } else if (this.Oooo0o0.length != oooOO0.Oooo0o0.length) {
                                                                                                            return false;
                                                                                                        } else {
                                                                                                            int i22 = 0;
                                                                                                            while (true) {
                                                                                                                boolean[] zArr2 = this.Oooo0o0;
                                                                                                                if (i22 < zArr2.length) {
                                                                                                                    if (zArr2[i22] != oooOO0.Oooo0o0[i22]) {
                                                                                                                        return false;
                                                                                                                    }
                                                                                                                    i22++;
                                                                                                                } else if (this.Oooo0oO.length != oooOO0.Oooo0oO.length) {
                                                                                                                    return false;
                                                                                                                } else {
                                                                                                                    int i23 = 0;
                                                                                                                    while (true) {
                                                                                                                        C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
                                                                                                                        if (i23 < oooOO0oArr.length) {
                                                                                                                            if (oooOO0oArr[i23] != oooOO0.Oooo0oO[i23]) {
                                                                                                                                return false;
                                                                                                                            }
                                                                                                                            i23++;
                                                                                                                        } else if (this.Oooo.length != oooOO0.Oooo.length) {
                                                                                                                            return false;
                                                                                                                        } else {
                                                                                                                            int i24 = 0;
                                                                                                                            while (true) {
                                                                                                                                C0365OooO0Oo[] oooO0OoArr = this.Oooo;
                                                                                                                                if (i24 < oooO0OoArr.length) {
                                                                                                                                    if (oooO0OoArr[i24] != oooOO0.Oooo[i24]) {
                                                                                                                                        return false;
                                                                                                                                    }
                                                                                                                                    i24++;
                                                                                                                                } else if (this.OoooO0.length != oooOO0.OoooO0.length) {
                                                                                                                                    return false;
                                                                                                                                } else {
                                                                                                                                    int i25 = 0;
                                                                                                                                    while (true) {
                                                                                                                                        C0117OooO00o[] oooO00oArr = this.OoooO0;
                                                                                                                                        if (i25 < oooO00oArr.length) {
                                                                                                                                            if (oooO00oArr[i25] != oooOO0.OoooO0[i25]) {
                                                                                                                                                return false;
                                                                                                                                            }
                                                                                                                                            i25++;
                                                                                                                                        } else if (this.OoooO.length != oooOO0.OoooO.length) {
                                                                                                                                            return false;
                                                                                                                                        } else {
                                                                                                                                            int i26 = 0;
                                                                                                                                            while (true) {
                                                                                                                                                String[] strArr5 = this.OoooO;
                                                                                                                                                if (i26 < strArr5.length) {
                                                                                                                                                    if (!strArr5[i26].equals(oooOO0.OoooO[i26])) {
                                                                                                                                                        return false;
                                                                                                                                                    }
                                                                                                                                                    i26++;
                                                                                                                                                } else if (this.o000oOoO != oooOO0.o000oOoO || !this.OoooOOO.equals(oooOO0.OoooOOO) || !this.OoooOOo.equals(oooOO0.OoooOOo) || !this.OoooOo0.equals(oooOO0.OoooOo0) || !this.OoooOoO.equals(oooOO0.OoooOoO) || !this.OoooOoo.equals(oooOO0.OoooOoo) || this.Ooooo00 != oooOO0.Ooooo00 || this.Ooooo0o != oooOO0.Ooooo0o || this.OooooO0 != oooOO0.OooooO0 || this.OooooOO != oooOO0.OooooOO || !this.OooooOo.equals(oooOO0.OooooOo) || !this.Oooooo0.equals(oooOO0.Oooooo0) || this.Oooooo.length != oooOO0.Oooooo.length) {
                                                                                                                                                    return false;
                                                                                                                                                } else {
                                                                                                                                                    int i27 = 0;
                                                                                                                                                    while (true) {
                                                                                                                                                        String[] strArr6 = this.Oooooo;
                                                                                                                                                        if (i27 < strArr6.length) {
                                                                                                                                                            if (!strArr6[i27].equals(oooOO0.Oooooo[i27])) {
                                                                                                                                                                return false;
                                                                                                                                                            }
                                                                                                                                                            i27++;
                                                                                                                                                        } else if (this.Ooooooo != oooOO0.Ooooooo || this.o0OoOo0 != oooOO0.o0OoOo0 || this.ooOO != oooOO0.ooOO || this.o00O0O != oooOO0.o00O0O || this.o00Oo0 != oooOO0.o00Oo0 || this.o00Ooo != oooOO0.o00Ooo || this.o00o0O != oooOO0.o00o0O || !this.o00ooo.equals(oooOO0.o00ooo) || this.oo000o != oooOO0.oo000o || this.o00oO0o != oooOO0.o00oO0o || this.o00oO0O != oooOO0.o00oO0O || this.o0ooOO0 != oooOO0.o0ooOO0 || !this.o0ooOOo.equals(oooOO0.o0ooOOo) || !this.o0ooOoO.equals(oooOO0.o0ooOoO) || this.o0OOO0o != oooOO0.o0OOO0o || this.o0Oo0oo != oooOO0.o0Oo0oo || this.o0OO00O != oooOO0.o0OO00O || !this.oo0o0Oo.equals(oooOO0.oo0o0Oo) || this.o0O0O00 != oooOO0.o0O0O00 || this.o000OOo != oooOO0.o000OOo || this.o000000 != oooOO0.o000000 || this.o000000O != oooOO0.o000000O || this.o000000o != oooOO0.o000000o || this.o00000.length != oooOO0.o00000.length) {
                                                                                                                                                            return false;
                                                                                                                                                        } else {
                                                                                                                                                            int i28 = 0;
                                                                                                                                                            while (true) {
                                                                                                                                                                String[] strArr7 = this.o00000;
                                                                                                                                                                if (i28 < strArr7.length) {
                                                                                                                                                                    if (!strArr7[i28].equals(oooOO0.o00000[i28])) {
                                                                                                                                                                        return false;
                                                                                                                                                                    }
                                                                                                                                                                    i28++;
                                                                                                                                                                } else if (this.o00000O.length != oooOO0.o00000O.length) {
                                                                                                                                                                    return false;
                                                                                                                                                                } else {
                                                                                                                                                                    int i29 = 0;
                                                                                                                                                                    while (true) {
                                                                                                                                                                        String[] strArr8 = this.o00000O;
                                                                                                                                                                        if (i29 < strArr8.length) {
                                                                                                                                                                            if (!strArr8[i29].equals(oooOO0.o00000O[i29])) {
                                                                                                                                                                                return false;
                                                                                                                                                                            }
                                                                                                                                                                            i29++;
                                                                                                                                                                        } else if (this.o00000Oo.length != oooOO0.o00000Oo.length) {
                                                                                                                                                                            return false;
                                                                                                                                                                        } else {
                                                                                                                                                                            int i30 = 0;
                                                                                                                                                                            while (true) {
                                                                                                                                                                                int[] iArr4 = this.o00000Oo;
                                                                                                                                                                                if (i30 >= iArr4.length) {
                                                                                                                                                                                    return true;
                                                                                                                                                                                }
                                                                                                                                                                                if (iArr4[i30] != oooOO0.o00000Oo[i30]) {
                                                                                                                                                                                    return false;
                                                                                                                                                                                }
                                                                                                                                                                                i30++;
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
                            }
                        }
                    }
                }
            }
        }

        public int hashCode() {
            int i10;
            int hashCode = OooOO0.class.getName().hashCode() * 41;
            if (o000oo0O()) {
                hashCode += this.OooO0o.OooO00o * 37;
            }
            if (o000Oooo()) {
                hashCode = c.a(this.OooO0oO, 31, hashCode);
            }
            if (o000Oo00()) {
                hashCode = c.a(this.OooO0oo, 31, hashCode);
            }
            if (o000Ooo0()) {
                hashCode = c.a(this.OooO, 31, hashCode);
            }
            if (o000OooO()) {
                hashCode = c.a(this.OooOO0, 31, hashCode);
            }
            if (o000oooo()) {
                hashCode = c.a(this.OooOO0O, 31, hashCode);
            }
            if (o00O000()) {
                hashCode = c.a(this.OooOO0o, 31, hashCode);
            }
            if (o000OoOo()) {
                hashCode += (this.OooOOO0 ? 1 : 0) * true;
            }
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int[] iArr = this.OooOOO;
                if (i12 >= iArr.length) {
                    break;
                }
                hashCode += iArr[i12] * 19;
                i12++;
            }
            int i13 = 0;
            while (true) {
                String[] strArr = this.OooOOOo;
                if (i13 >= strArr.length) {
                    break;
                }
                hashCode = c.a(strArr[i13], 19, hashCode);
                i13++;
            }
            int i14 = 0;
            while (true) {
                String[] strArr2 = this.OooOOo;
                if (i14 >= strArr2.length) {
                    break;
                }
                hashCode = c.a(strArr2[i14], 19, hashCode);
                i14++;
            }
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.OooOo00;
                if (i15 >= iArr2.length) {
                    break;
                }
                hashCode += iArr2[i15] * 19;
                i15++;
            }
            int i16 = 0;
            while (true) {
                OooO0O0[] oooO0O0Arr = this.OooOo0O;
                if (i16 >= oooO0O0Arr.length) {
                    break;
                }
                hashCode += oooO0O0Arr[i16].OooO00o * 13;
                i16++;
            }
            int i17 = 0;
            while (true) {
                String[] strArr3 = this.f10162OooOo;
                if (i17 >= strArr3.length) {
                    break;
                }
                hashCode = c.a(strArr3[i17], 19, hashCode);
                i17++;
            }
            int i18 = 0;
            while (true) {
                C0367OooO0oO[] oooO0oOArr = this.OooOoO;
                if (i18 >= oooO0oOArr.length) {
                    break;
                }
                hashCode += oooO0oOArr[i18].OooO00o * 13;
                i18++;
            }
            int i19 = 0;
            while (true) {
                String[] strArr4 = this.OooOoo0;
                if (i19 >= strArr4.length) {
                    break;
                }
                hashCode = c.a(strArr4[i19], 19, hashCode);
                i19++;
            }
            int i20 = 0;
            while (true) {
                boolean[] zArr = this.OooOooO;
                int i21 = 17;
                if (i20 >= zArr.length) {
                    break;
                }
                if (zArr[i20]) {
                    i21 = 19;
                }
                hashCode += i21;
                i20++;
            }
            int i22 = 0;
            while (true) {
                OooO[] oooOArr = this.Oooo000;
                if (i22 >= oooOArr.length) {
                    break;
                }
                hashCode += oooOArr[i22].OooO00o * 13;
                i22++;
            }
            int i23 = 0;
            while (true) {
                int[] iArr3 = this.Oooo00o;
                if (i23 >= iArr3.length) {
                    break;
                }
                hashCode += iArr3[i23] * 19;
                i23++;
            }
            int i24 = 0;
            while (true) {
                C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
                if (i24 >= oooO0o0Arr.length) {
                    break;
                }
                hashCode += oooO0o0Arr[i24].OooO00o * 13;
                i24++;
            }
            int i25 = 0;
            while (true) {
                boolean[] zArr2 = this.Oooo0o0;
                if (i25 >= zArr2.length) {
                    break;
                }
                if (zArr2[i25]) {
                    i10 = 19;
                } else {
                    i10 = 17;
                }
                hashCode += i10;
                i25++;
            }
            int i26 = 0;
            while (true) {
                C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
                if (i26 >= oooOO0oArr.length) {
                    break;
                }
                hashCode += oooOO0oArr[i26].OooO00o * 13;
                i26++;
            }
            int i27 = 0;
            while (true) {
                C0365OooO0Oo[] oooO0OoArr = this.Oooo;
                if (i27 >= oooO0OoArr.length) {
                    break;
                }
                hashCode += oooO0OoArr[i27].OooO00o * 13;
                i27++;
            }
            int i28 = 0;
            while (true) {
                C0117OooO00o[] oooO00oArr = this.OoooO0;
                if (i28 >= oooO00oArr.length) {
                    break;
                }
                hashCode += oooO00oArr[i28].OooO00o * 13;
                i28++;
            }
            int i29 = 0;
            while (true) {
                String[] strArr5 = this.OoooO;
                if (i29 >= strArr5.length) {
                    break;
                }
                hashCode = c.a(strArr5[i29], 19, hashCode);
                i29++;
            }
            if (o000ooOO()) {
                hashCode += this.o000oOoO.OooO00o * 37;
            }
            if (o000o0oO()) {
                hashCode = c.a(this.OoooOOO, 31, hashCode);
            }
            if (o000Oo0o()) {
                hashCode = c.a(this.OoooOOo, 31, hashCode);
            }
            if (o000Oo()) {
                hashCode = c.a(this.OoooOo0, 31, hashCode);
            }
            if (o000OoOO()) {
                hashCode = c.a(this.OoooOoO, 31, hashCode);
            }
            if (o000oo0o()) {
                hashCode = c.a(this.OoooOoo, 31, hashCode);
            }
            if (o000oo()) {
                hashCode += this.Ooooo00 * 33;
            }
            if (o000ooo()) {
                hashCode += (this.Ooooo0o ? 1 : 0) * true;
            }
            if (o00()) {
                hashCode += (this.OooooO0 ? 1 : 0) * true;
            }
            if (o00O0000()) {
                hashCode += this.OooooOO * 33;
            }
            if (o000ooO0()) {
                hashCode = c.a(this.OooooOo, 31, hashCode);
            }
            if (o0O0ooO()) {
                hashCode = c.a(this.Oooooo0, 31, hashCode);
            }
            int i30 = 0;
            while (true) {
                String[] strArr6 = this.Oooooo;
                if (i30 >= strArr6.length) {
                    break;
                }
                hashCode = c.a(strArr6[i30], 19, hashCode);
                i30++;
            }
            if (o000o0o()) {
                hashCode += this.Ooooooo * 33;
            }
            if (o000o0oo()) {
                hashCode += this.o0OoOo0 * 33;
            }
            if (o000oo00()) {
                hashCode = (int) ((this.ooOO * 33.0d) + ((double) hashCode));
            }
            if (o000oOoo()) {
                hashCode += this.o00O0O * 33;
            }
            if (o00O000o()) {
                hashCode += (this.o00Oo0 ? 1 : 0) * true;
            }
            if (o000o00o()) {
                hashCode += (this.o00Ooo ? 1 : 0) * true;
            }
            if (o000oooO()) {
                hashCode += (this.o00o0O ? 1 : 0) * true;
            }
            if (o000o0Oo()) {
                hashCode = c.a(this.o00ooo, 31, hashCode);
            }
            if (o000o0o0()) {
                hashCode += this.oo000o * 33;
            }
            if (o00O00O()) {
                hashCode += (this.o00oO0o ? 1 : 0) * true;
            }
            if (o000ooo0()) {
                hashCode += (this.o00oO0O ? 1 : 0) * true;
            }
            if (o00oOoo()) {
                hashCode += this.o0ooOO0 * 33;
            }
            if (o00O00()) {
                hashCode = c.a(this.o0ooOOo, 31, hashCode);
            }
            if (o000ooO()) {
                hashCode = c.a(this.o0ooOoO, 31, hashCode);
            }
            if (o000Oo0O()) {
                hashCode += (this.o0OOO0o ? 1 : 0) * true;
            }
            if (o000o00()) {
                hashCode += (this.o0Oo0oo ? 1 : 0) * true;
            }
            if (o000o0OO()) {
                hashCode += (this.o0OO00O ? 1 : 0) * true;
            }
            if (o000oo0()) {
                hashCode = c.a(this.oo0o0Oo, 31, hashCode);
            }
            if (o000o00O()) {
                hashCode += (this.o0O0O00 ? 1 : 0) * true;
            }
            if (o000o0O()) {
                hashCode += (this.o000OOo ? 1 : 0) * true;
            }
            if (o000o0O0()) {
                hashCode += (this.o000000 ? 1 : 0) * true;
            }
            if (oooo00o()) {
                hashCode += (this.o000000O ? 1 : 0) * true;
            }
            if (o000o000()) {
                hashCode += (this.o000000o ? 1 : 0) * true;
            }
            int i31 = 0;
            while (true) {
                String[] strArr7 = this.o00000;
                if (i31 >= strArr7.length) {
                    break;
                }
                hashCode = c.a(strArr7[i31], 19, hashCode);
                i31++;
            }
            int i32 = 0;
            while (true) {
                String[] strArr8 = this.o00000O;
                if (i32 >= strArr8.length) {
                    break;
                }
                hashCode = c.a(strArr8[i32], 19, hashCode);
                i32++;
            }
            while (true) {
                int[] iArr4 = this.o00000Oo;
                if (i11 >= iArr4.length) {
                    return hashCode;
                }
                hashCode += iArr4[i11] * 19;
                i11++;
            }
        }

        public boolean o00() {
            if ((this.f10161OooO0o0 & 2) != 0) {
                return true;
            }
            return false;
        }

        public double o000() {
            return this.ooOO;
        }

        public int o0000() {
            return this.OooOooo;
        }

        public int o00000() {
            return this.f10163OooOoO0;
        }

        public int o000000() {
            return this.Oooo0OO;
        }

        public int o000000O() {
            return this.Oooo0;
        }

        public int o000000o() {
            return this.Oooo0o;
        }

        public int o00000O() {
            return this.OooOOoo;
        }

        public int o00000O0() {
            return this.OooOoOO;
        }

        public int o00000OO() {
            return this.OoooOO0;
        }

        public int o00000Oo() {
            return this.OoooO0O;
        }

        public int o00000o0() {
            return this.OooOo0;
        }

        public int o00000oO() {
            return this.OooOOo0;
        }

        public int o00000oo() {
            return this.Oooo00O;
        }

        public String o0000O() {
            return this.OooO0oO;
        }

        public String o0000O0() {
            return this.OooO;
        }

        public int o0000O00() {
            return this.OooOOOO;
        }

        public String o0000O0O() {
            return this.OooOO0;
        }

        public OooOO0 o0000OO() {
            return o0000Ooo;
        }

        public boolean o0000OOO() {
            return this.o000000o;
        }

        public boolean o0000OOo() {
            return this.o0Oo0oo;
        }

        public boolean o0000Oo() {
            return this.o00Ooo;
        }

        public boolean o0000Oo0() {
            return this.o0O0O00;
        }

        public boolean o0000OoO() {
            return this.o000000O;
        }

        public int o0000Ooo() {
            return this.OooOo0o;
        }

        public String o0000o() {
            return this.o00ooo;
        }

        public boolean o0000o0() {
            return this.o000000;
        }

        public boolean o0000o0O() {
            return this.o000OOo;
        }

        public boolean o0000o0o() {
            return this.o0OO00O;
        }

        public boolean o0000oO() {
            return this.OooOOO0;
        }

        public int o0000oO0() {
            return this.oo000o;
        }

        public int o0000oOO() {
            return this.Ooooooo;
        }

        public String o0000oOo() {
            return this.OoooOOO;
        }

        public int o0000oo() {
            return this.Oooo0oo;
        }

        public int o0000oo0() {
            return this.o0OoOo0;
        }

        public int o0000ooO() {
            return this.o00O0O;
        }

        public String o000O() {
            return this.OooOO0o;
        }

        public boolean o000O0() {
            return this.Ooooo0o;
        }

        public C0368OooO0oo o000O00() {
            return this.o000oOoO;
        }

        public String o000O000() {
            return this.oo0o0Oo;
        }

        public boolean o000O00O() {
            return this.o00oO0O;
        }

        public String o000O0O() {
            return this.OooooOo;
        }

        public boolean o000O0O0() {
            return this.OooooO0;
        }

        public boolean o000O0Oo() {
            return this.o00o0O;
        }

        public String o000O0o() {
            return this.OoooOoo;
        }

        public int o000O0o0() {
            return this.OooooOO;
        }

        public String o000O0oO() {
            return this.Oooooo0;
        }

        public int o000O0oo() {
            return this.o0ooOO0;
        }

        public int o000OO() {
            return this.OoooooO;
        }

        public int o000OO00() {
            return this.o00000O0;
        }

        public String o000OO0O() {
            return this.OooOO0O;
        }

        public int o000OO0o() {
            return this.o00000o0;
        }

        public boolean o000OOO() {
            return this.o00Oo0;
        }

        public int o000OOo() {
            return this.OoooO00;
        }

        public String o000OOo0() {
            return this.o0ooOOo;
        }

        public boolean o000OOoO() {
            return this.o00oO0o;
        }

        public boolean o000Oo() {
            if ((this.OooO0Oo & GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR) != 0) {
                return true;
            }
            return false;
        }

        public String o000Oo0() {
            return this.o0ooOoO;
        }

        public boolean o000Oo00() {
            if ((this.OooO0Oo & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000Oo0O() {
            if ((this.f10161OooO0o0 & 1048576) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000Oo0o() {
            if ((this.OooO0Oo & GameControllerManager.DEVICEFLAG_VIBRATION) != 0) {
                return true;
            }
            return false;
        }

        public OooOO0O o000OoO() {
            return this.OooO0o;
        }

        public boolean o000OoOO() {
            if ((this.OooO0Oo & 536870912) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000OoOo() {
            if ((this.OooO0Oo & 128) != 0) {
                return true;
            }
            return false;
        }

        public int o000Ooo() {
            return this.Ooooo00;
        }

        public boolean o000Ooo0() {
            if ((this.OooO0Oo & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000OooO() {
            if ((this.OooO0Oo & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000Oooo() {
            if ((this.OooO0Oo & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o00() {
            if ((this.f10161OooO0o0 & 2097152) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o000() {
            if ((this.f10161OooO0o0 & GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o00O() {
            if ((this.f10161OooO0o0 & 16777216) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o00o() {
            if ((this.f10161OooO0o0 & 2048) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0O() {
            if ((this.f10161OooO0o0 & GameControllerManager.DEVICEFLAG_LIGHT_RGB) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0O0() {
            if ((this.f10161OooO0o0 & 67108864) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0OO() {
            if ((this.f10161OooO0o0 & 4194304) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0Oo() {
            if ((this.f10161OooO0o0 & 8192) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0o() {
            if ((this.f10161OooO0o0 & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0o0() {
            if ((this.f10161OooO0o0 & 16384) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0oO() {
            if ((this.OooO0Oo & 67108864) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000o0oo() {
            if ((this.f10161OooO0o0 & 128) != 0) {
                return true;
            }
            return false;
        }

        public void o000oOoO() {
            OooO00o();
            this.f10161OooO0o0 &= -65;
            this.Ooooooo = 0;
        }

        public boolean o000oOoo() {
            if ((this.f10161OooO0o0 & 512) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oo() {
            if ((this.OooO0Oo & Integer.MIN_VALUE) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oo0() {
            if ((this.f10161OooO0o0 & 8388608) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oo00() {
            if ((this.f10161OooO0o0 & 256) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oo0O() {
            if ((this.OooO0Oo & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oo0o() {
            if ((this.OooO0Oo & 1073741824) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000ooO() {
            if ((this.f10161OooO0o0 & 524288) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000ooO0() {
            if ((this.f10161OooO0o0 & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000ooOO() {
            if ((this.OooO0Oo & GameControllerManager.DEVICEFLAG_LIGHT_RGB) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000ooo() {
            if ((this.f10161OooO0o0 & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000ooo0() {
            if ((this.f10161OooO0o0 & 65536) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oooO() {
            if ((this.f10161OooO0o0 & 4096) != 0) {
                return true;
            }
            return false;
        }

        public boolean o000oooo() {
            if ((this.OooO0Oo & 32) != 0) {
                return true;
            }
            return false;
        }

        public void o00O0() {
            OooO00o();
            int i10 = this.OooOoOO;
            if (i10 > 0) {
                C0367OooO0oO[] oooO0oOArr = this.OooOoO;
                this.OooOoOO = i10 - 1;
                oooO0oOArr[i10] = C0367OooO0oO.OooO0Oo;
            }
        }

        public boolean o00O00() {
            if ((this.f10161OooO0o0 & 262144) != 0) {
                return true;
            }
            return false;
        }

        public boolean o00O000() {
            if ((this.OooO0Oo & 64) != 0) {
                return true;
            }
            return false;
        }

        public boolean o00O0000() {
            if ((this.f10161OooO0o0 & 4) != 0) {
                return true;
            }
            return false;
        }

        public boolean o00O000o() {
            if ((this.f10161OooO0o0 & 1024) != 0) {
                return true;
            }
            return false;
        }

        public boolean o00O00O() {
            if ((this.f10161OooO0o0 & 32768) != 0) {
                return true;
            }
            return false;
        }

        public void o00O00OO() {
            OooO00o();
            int i10 = this.OooOoo;
            if (i10 > 0) {
                String[] strArr = this.OooOoo0;
                this.OooOoo = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void o00O00Oo() {
            OooO00o();
            int i10 = this.OoooO00;
            if (i10 > 0) {
                C0365OooO0Oo[] oooO0OoArr = this.Oooo;
                this.OoooO00 = i10 - 1;
                oooO0OoArr[i10] = C0365OooO0Oo.OooO0Oo;
            }
        }

        public void o00O00o() {
            OooO00o();
            int i10 = this.Oooo0;
            if (i10 > 0) {
                int[] iArr = this.Oooo00o;
                this.Oooo0 = i10 - 1;
                iArr[i10] = 0;
            }
        }

        public void o00O00o0() {
            OooO00o();
            int i10 = this.Oooo0OO;
            if (i10 > 0) {
                C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
                this.Oooo0OO = i10 - 1;
                oooO0o0Arr[i10] = C0366OooO0o0.OooO0Oo;
            }
        }

        public void o00O00oO() {
            OooO00o();
            int i10 = this.Oooo0o;
            if (i10 > 0) {
                boolean[] zArr = this.Oooo0o0;
                this.Oooo0o = i10 - 1;
                zArr[i10] = false;
            }
        }

        public void o00O0O() {
            OooO00o();
            this.f10161OooO0o0 &= -5;
            this.OooooOO = 100;
        }

        public void o00O0O0() {
            OooO00o();
            int i10 = this.OoooOO0;
            if (i10 > 0) {
                String[] strArr = this.OoooO;
                this.OoooOO0 = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void o00O0O00() {
            OooO00o();
            int i10 = this.OooOOoo;
            if (i10 > 0) {
                String[] strArr = this.OooOOo;
                this.OooOOoo = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void o00O0O0O() {
            OooO00o();
            int i10 = this.OoooO0O;
            if (i10 > 0) {
                C0117OooO00o[] oooO00oArr = this.OoooO0;
                this.OoooO0O = i10 - 1;
                oooO00oArr[i10] = C0117OooO00o.OooO0Oo;
            }
        }

        public void o00O0O0o() {
            OooO00o();
            int i10 = this.OooOo0;
            if (i10 > 0) {
                int[] iArr = this.OooOo00;
                this.OooOo0 = i10 - 1;
                iArr[i10] = 0;
            }
        }

        public void o00O0OO() {
            OooO00o();
            int i10 = this.Oooo00O;
            if (i10 > 0) {
                OooO[] oooOArr = this.Oooo000;
                this.Oooo00O = i10 - 1;
                oooOArr[i10] = OooO.OooO0Oo;
            }
        }

        public void o00O0OO0() {
            OooO00o();
            int i10 = this.OooOo0o;
            if (i10 > 0) {
                OooO0O0[] oooO0O0Arr = this.OooOo0O;
                this.OooOo0o = i10 - 1;
                oooO0O0Arr[i10] = OooO0O0.OooO0Oo;
            }
        }

        public void o00O0OOO() {
            OooO00o();
            int i10 = this.OooOooo;
            if (i10 > 0) {
                boolean[] zArr = this.OooOooO;
                this.OooOooo = i10 - 1;
                zArr[i10] = false;
            }
        }

        public void o00O0OOo() {
            OooO00o();
            int i10 = this.OooOOOO;
            if (i10 > 0) {
                int[] iArr = this.OooOOO;
                this.OooOOOO = i10 - 1;
                iArr[i10] = 0;
            }
        }

        public void o00O0Oo() {
            OooO00o();
            int i10 = this.o00000O0;
            if (i10 > 0) {
                String[] strArr = this.o00000;
                this.o00000O0 = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void o00O0Oo0() {
            OooO00o();
            int i10 = this.Oooo0oo;
            if (i10 > 0) {
                C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
                this.Oooo0oo = i10 - 1;
                oooOO0oArr[i10] = C0369OooOO0o.OooO0Oo;
            }
        }

        public void o00O0OoO() {
            OooO00o();
            int i10 = this.o00000OO;
            if (i10 > 0) {
                String[] strArr = this.o00000O;
                this.o00000OO = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void o00O0Ooo() {
            OooO00o();
            int i10 = this.o00000o0;
            if (i10 > 0) {
                int[] iArr = this.o00000Oo;
                this.o00000o0 = i10 - 1;
                iArr[i10] = 0;
            }
        }

        public void o00Oo0() {
            OooO00o();
            this.f10161OooO0o0 &= -17;
            this.Oooooo0 = "";
        }

        public void o00Ooo() {
            OooO00o();
            this.f10161OooO0o0 &= -131073;
            this.o0ooOO0 = 60;
        }

        public void o00o0O() {
            OooO00o();
            this.OooO0Oo &= -65;
            this.OooOO0o = "";
        }

        public void o00oO0O() {
            OooO00o();
            this.f10161OooO0o0 &= -1025;
            this.o00Oo0 = false;
        }

        public void o00oO0o() {
            OooO00o();
            while (true) {
                int i10 = this.o00000o0;
                if (i10 > 0) {
                    int[] iArr = this.o00000Oo;
                    this.o00000o0 = i10 - 1;
                    iArr[i10] = 0;
                } else {
                    return;
                }
            }
        }

        public boolean o00oOoo() {
            if ((this.f10161OooO0o0 & 131072) != 0) {
                return true;
            }
            return false;
        }

        public void o00ooo() {
            OooO00o();
            while (true) {
                int i10 = this.o00000O0;
                if (i10 > 0) {
                    String[] strArr = this.o00000;
                    this.o00000O0 = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public int o0O0O00() {
            return this.OooOoo;
        }

        public boolean o0O0ooO() {
            if ((this.f10161OooO0o0 & 16) != 0) {
                return true;
            }
            return false;
        }

        public String o0OO00O() {
            return this.OoooOo0;
        }

        public boolean o0OOO0o() {
            return this.o0OOO0o;
        }

        public String o0Oo0oo() {
            return this.OoooOOo;
        }

        public int o0OoO0o() {
            return this.o00000OO;
        }

        public void o0OoOo0() {
            OooO00o();
            this.OooO0Oo &= -33;
            this.OooOO0O = "";
        }

        public void o0ooOO0() {
            OooO00o();
            this.f10161OooO0o0 &= -262145;
            this.o0ooOOo = "";
        }

        public void o0ooOOo() {
            OooO00o();
            this.f10161OooO0o0 &= -32769;
            this.o00oO0o = false;
        }

        public String o0ooOoO() {
            return this.OooO0oo;
        }

        public final void oOO00O() {
            this.OooO0o = OooOO0O.OooOO0;
            this.o000oOoO = C0368OooO0oo.OooO0Oo;
        }

        public void oo000o() {
            OooO00o();
            while (true) {
                int i10 = this.o00000OO;
                if (i10 > 0) {
                    String[] strArr = this.o00000O;
                    this.o00000OO = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public void oo00o() {
            OooO00o();
            int i10 = this.f10163OooOoO0;
            if (i10 > 0) {
                String[] strArr = this.f10162OooOo;
                this.f10163OooOoO0 = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void oo0o0O0() {
            OooO00o();
            int i10 = this.OooOOo0;
            if (i10 > 0) {
                String[] strArr = this.OooOOOo;
                this.OooOOo0 = i10 - 1;
                strArr[i10] = "";
            }
        }

        public String oo0o0Oo() {
            return this.OoooOoO;
        }

        public void oo0oOO0() {
            OooO00o();
            int i10 = this.OoooooO;
            if (i10 > 0) {
                String[] strArr = this.Oooooo;
                this.OoooooO = i10 - 1;
                strArr[i10] = "";
            }
        }

        public void ooOO() {
            OooO00o();
            this.f10161OooO0o0 &= -3;
            this.OooooO0 = false;
        }

        public boolean oooo00o() {
            if ((this.f10161OooO0o0 & GameControllerManager.DEVICEFLAG_VIBRATION) != 0) {
                return true;
            }
            return false;
        }

        public void OooO0o(int i10, int i11) {
            OooO00o();
            C0365OooO0Oo[] oooO0OoArr = this.Oooo;
            C0365OooO0Oo oooO0Oo = oooO0OoArr[i10];
            oooO0OoArr[i10] = oooO0OoArr[i11];
            oooO0OoArr[i11] = oooO0Oo;
        }

        public void OooO0oO(int i10, int i11) {
            OooO00o();
            C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
            C0366OooO0o0 oooO0o0 = oooO0o0Arr[i10];
            oooO0o0Arr[i10] = oooO0o0Arr[i11];
            oooO0o0Arr[i11] = oooO0o0;
        }

        public void OooO0oo(int i10, int i11) {
            OooO00o();
            int[] iArr = this.Oooo00o;
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
        }

        public void OooOO0(int i10, int i11) {
            OooO00o();
            String[] strArr = this.f10162OooOo;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOO0o(int i10, int i11) {
            OooO00o();
            String[] strArr = this.OooOOo;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOOOo(int i10, int i11) {
            OooO00o();
            OooO0O0[] oooO0O0Arr = this.OooOo0O;
            OooO0O0 oooO0O0 = oooO0O0Arr[i10];
            oooO0O0Arr[i10] = oooO0O0Arr[i11];
            oooO0O0Arr[i11] = oooO0O0;
        }

        public void OooOOo(int i10, int i11) {
            OooO00o();
            OooO[] oooOArr = this.Oooo000;
            OooO oooO = oooOArr[i10];
            oooOArr[i10] = oooOArr[i11];
            oooOArr[i11] = oooO;
        }

        public void OooOOo0(int i10, int i11) {
            OooO00o();
            String[] strArr = this.OooOOOo;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOOoo(int i10, int i11) {
            OooO00o();
            boolean[] zArr = this.OooOooO;
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i11];
            zArr[i11] = z10;
        }

        public void OooOo00(int i10, int i11) {
            OooO00o();
            int[] iArr = this.OooOOO;
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
        }

        public void OooO0OO(int i10) {
            OooO00o();
            Oooo0oo(this.OooOOOO + 1);
            int[] iArr = this.OooOOO;
            int i11 = this.OooOOOO;
            this.OooOOOO = i11 + 1;
            iArr[i11] = i10;
        }

        public void OooO0o0(String str) {
            OooO00o();
            Oooo0o0(this.OooOOo0 + 1);
            String[] strArr = this.OooOOOo;
            int i10 = this.OooOOo0;
            this.OooOOo0 = i10 + 1;
            strArr[i10] = str;
        }

        public boolean OooO(int i10) {
            return this.Oooo0o0[i10];
        }

        public void OooO0O0(int i10, int i11) {
            OooO00o();
            this.OooOo00[i10] = i11;
        }

        public void OooO0Oo(int i10, String str) {
            OooO00o();
            this.OoooO[i10] = str;
        }

        public C0367OooO0oO OooOO0O(int i10) {
            return this.OooOoO[i10];
        }

        public C0117OooO00o OooOOO(int i10) {
            return this.OoooO0[i10];
        }

        public String OooOOO0(int i10) {
            return this.OoooO[i10];
        }

        public int OooOOOO(int i10) {
            return this.OooOo00[i10];
        }

        public void OooOo() {
            OooO00o();
            while (true) {
                int i10 = this.OoooOO0;
                if (i10 > 0) {
                    String[] strArr = this.OoooO;
                    this.OoooOO0 = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public C0369OooOO0o OooOo0(int i10) {
            return this.Oooo0oO[i10];
        }

        public void OooOo0O() {
            OooO00o();
            while (true) {
                int i10 = this.OooOoOO;
                if (i10 > 0) {
                    C0367OooO0oO[] oooO0oOArr = this.OooOoO;
                    this.OooOoOO = i10 - 1;
                    oooO0oOArr[i10] = C0367OooO0oO.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOo0o(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 16;
            this.Oooooo0 = str;
        }

        public void OooOoO(int i10) {
            String[] strArr = this.OooOoo0;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.OooOoo);
                this.OooOoo0 = strArr2;
            }
        }

        public void OooOoO0(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 262144;
            this.o0ooOOo = str;
        }

        public void OooOoOO(int i10) {
            C0365OooO0Oo[] oooO0OoArr = this.Oooo;
            if (i10 >= oooO0OoArr.length) {
                C0365OooO0Oo[] oooO0OoArr2 = new C0365OooO0Oo[i10];
                System.arraycopy(oooO0OoArr, 0, oooO0OoArr2, 0, this.OoooO00);
                this.Oooo = oooO0OoArr2;
            }
        }

        public void OooOoo(int i10) {
            int[] iArr = this.Oooo00o;
            if (i10 >= iArr.length) {
                int[] iArr2 = new int[i10];
                System.arraycopy(iArr, 0, iArr2, 0, this.Oooo0);
                this.Oooo00o = iArr2;
            }
        }

        public void OooOoo0(int i10) {
            C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
            if (i10 >= oooO0o0Arr.length) {
                C0366OooO0o0[] oooO0o0Arr2 = new C0366OooO0o0[i10];
                System.arraycopy(oooO0o0Arr, 0, oooO0o0Arr2, 0, this.Oooo0OO);
                this.Oooo0O0 = oooO0o0Arr2;
            }
        }

        public void OooOooO(int i10) {
            boolean[] zArr = this.Oooo0o0;
            if (i10 >= zArr.length) {
                boolean[] zArr2 = new boolean[i10];
                System.arraycopy(zArr, 0, zArr2, 0, this.Oooo0o);
                this.Oooo0o0 = zArr2;
            }
        }

        public void OooOooo(int i10) {
            String[] strArr = this.f10162OooOo;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.f10163OooOoO0);
                this.f10162OooOo = strArr2;
            }
        }

        public void Oooo0(int i10) {
            C0117OooO00o[] oooO00oArr = this.OoooO0;
            if (i10 >= oooO00oArr.length) {
                C0117OooO00o[] oooO00oArr2 = new C0117OooO00o[i10];
                System.arraycopy(oooO00oArr, 0, oooO00oArr2, 0, this.OoooO0O);
                this.OoooO0 = oooO00oArr2;
            }
        }

        public void Oooo00O(int i10) {
            String[] strArr = this.OooOOo;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.OooOOoo);
                this.OooOOo = strArr2;
            }
        }

        public void Oooo00o(int i10) {
            String[] strArr = this.OoooO;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.OoooOO0);
                this.OoooO = strArr2;
            }
        }

        public void Oooo0OO(int i10) {
            OooO0O0[] oooO0O0Arr = this.OooOo0O;
            if (i10 >= oooO0O0Arr.length) {
                OooO0O0[] oooO0O0Arr2 = new OooO0O0[i10];
                System.arraycopy(oooO0O0Arr, 0, oooO0O0Arr2, 0, this.OooOo0o);
                this.OooOo0O = oooO0O0Arr2;
            }
        }

        public void OoooO(int i10) {
            int[] iArr = this.o00000Oo;
            if (i10 >= iArr.length) {
                int[] iArr2 = new int[i10];
                System.arraycopy(iArr, 0, iArr2, 0, this.o00000o0);
                this.o00000Oo = iArr2;
            }
        }

        public void OoooO0(int i10) {
            String[] strArr = this.o00000;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.o00000O0);
                this.o00000 = strArr2;
            }
        }

        public void OoooO0O(int i10) {
            String[] strArr = this.o00000O;
            if (i10 >= strArr.length) {
                String[] strArr2 = new String[i10];
                System.arraycopy(strArr, 0, strArr2, 0, this.o00000OO);
                this.o00000O = strArr2;
            }
        }

        public void OoooOO0(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 16384;
            this.oo000o = i10;
        }

        public void OoooOOO(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 128;
            this.o0OoOo0 = i10;
        }

        public void OoooOOo(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 512;
            this.o00O0O = i10;
        }

        public void OoooOo0() {
            OooO00o();
            this.f10161OooO0o0 &= -513;
            this.o00O0O = 120;
        }

        public void OoooOoO() {
            OooO00o();
            this.f10161OooO0o0 &= -257;
            this.ooOO = 1.6d;
        }

        public void OoooOoo() {
            OooO00o();
            this.f10161OooO0o0 &= -8388609;
            this.oo0o0Oo = "";
        }

        public void o000oOoO(int i10) {
            OooO00o();
            this.f10161OooO0o0 |= 64;
            this.Ooooooo = i10;
        }

        public void OooO(int i10, int i11) {
            OooO00o();
            boolean[] zArr = this.Oooo0o0;
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i11];
            zArr[i11] = z10;
        }

        public void OooO00o(int i10, OooO0O0 oooO0O0) {
            OooO00o();
            this.OooOo0O[i10] = oooO0O0;
        }

        public void OooOO0O(int i10, int i11) {
            OooO00o();
            C0367OooO0oO[] oooO0oOArr = this.OooOoO;
            C0367OooO0oO oooO0oO = oooO0oOArr[i10];
            oooO0oOArr[i10] = oooO0oOArr[i11];
            oooO0oOArr[i11] = oooO0oO;
        }

        public void OooOOO(int i10, int i11) {
            OooO00o();
            C0117OooO00o[] oooO00oArr = this.OoooO0;
            C0117OooO00o oooO00o = oooO00oArr[i10];
            oooO00oArr[i10] = oooO00oArr[i11];
            oooO00oArr[i11] = oooO00o;
        }

        public void OooOOO0(int i10, int i11) {
            OooO00o();
            String[] strArr = this.OoooO;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOOOO(int i10, int i11) {
            OooO00o();
            int[] iArr = this.OooOo00;
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
        }

        public void OooOo0(int i10, int i11) {
            OooO00o();
            C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
            C0369OooOO0o oooOO0o = oooOO0oArr[i10];
            oooOO0oArr[i10] = oooOO0oArr[i11];
            oooOO0oArr[i11] = oooOO0o;
        }

        public void Oooo() {
            OooO00o();
            this.f10161OooO0o0 &= -134217729;
            this.o000000O = true;
        }

        public void Oooo000() {
            OooO00o();
            while (true) {
                int i10 = this.Oooo0oo;
                if (i10 > 0) {
                    C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
                    this.Oooo0oo = i10 - 1;
                    oooOO0oArr[i10] = C0369OooOO0o.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void Oooo0O0() {
            OooO00o();
            while (true) {
                int i10 = this.OoooooO;
                if (i10 > 0) {
                    String[] strArr = this.Oooooo;
                    this.OoooooO = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public void Oooo0o() {
            OooO00o();
            this.f10161OooO0o0 &= -2097153;
            this.o0Oo0oo = false;
        }

        public void Oooo0o0() {
            OooO00o();
            this.f10161OooO0o0 &= -268435457;
            this.o000000o = true;
        }

        public void Oooo0oO() {
            OooO00o();
            this.f10161OooO0o0 &= -16777217;
            this.o0O0O00 = false;
        }

        public void Oooo0oo() {
            OooO00o();
            this.f10161OooO0o0 &= -2049;
            this.o00Ooo = true;
        }

        public void OoooO00() {
            OooO00o();
            this.f10161OooO0o0 &= -67108865;
            this.o000000 = false;
        }

        public void OooO0O0(int i10) {
            OooO00o();
            Oooo0O0(this.OooOo0 + 1);
            int[] iArr = this.OooOo00;
            int i11 = this.OooOo0;
            this.OooOo0 = i11 + 1;
            iArr[i11] = i10;
        }

        public void OooO0OO(int i10, String str) {
            OooO00o();
            this.OooOOo[i10] = str;
        }

        public void OooO0Oo(String str) {
            OooO00o();
            Oooo00o(this.OoooOO0 + 1);
            String[] strArr = this.OoooO;
            int i10 = this.OoooOO0;
            this.OoooOO0 = i10 + 1;
            strArr[i10] = str;
        }

        public void OooO0o(int i10, String str) {
            OooO00o();
            this.Oooooo[i10] = str;
        }

        public String OooO0o0(int i10) {
            return this.OooOoo0[i10];
        }

        public void OooO0oO(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 16777216;
            this.o0O0O00 = z10;
        }

        public void OooO0oo(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 2048;
            this.o00Ooo = z10;
        }

        public void OooOO0(String str) {
            OooO00o();
            this.OooO0Oo |= GameControllerManager.DEVICEFLAG_VIBRATION;
            this.OoooOOo = str;
        }

        public void OooOO0o(String str) {
            OooO00o();
            this.OooO0Oo |= 536870912;
            this.OoooOoO = str;
        }

        public void OooOOOo() {
            OooO00o();
            while (true) {
                int i10 = this.OooOoo;
                if (i10 > 0) {
                    String[] strArr = this.OooOoo0;
                    this.OooOoo = i10 - 1;
                    strArr[i10] = "";
                } else {
                    return;
                }
            }
        }

        public void OooOOo() {
            OooO00o();
            while (true) {
                int i10 = this.Oooo0OO;
                if (i10 > 0) {
                    C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
                    this.Oooo0OO = i10 - 1;
                    oooO0o0Arr[i10] = C0366OooO0o0.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOOo0() {
            OooO00o();
            while (true) {
                int i10 = this.OoooO00;
                if (i10 > 0) {
                    C0365OooO0Oo[] oooO0OoArr = this.Oooo;
                    this.OoooO00 = i10 - 1;
                    oooO0OoArr[i10] = C0365OooO0Oo.OooO0Oo;
                } else {
                    return;
                }
            }
        }

        public void OooOOoo() {
            OooO00o();
            while (true) {
                int i10 = this.Oooo0;
                if (i10 > 0) {
                    int[] iArr = this.Oooo00o;
                    this.Oooo0 = i10 - 1;
                    iArr[i10] = 0;
                } else {
                    return;
                }
            }
        }

        public void OooOo00() {
            OooO00o();
            while (true) {
                int i10 = this.Oooo0o;
                if (i10 > 0) {
                    boolean[] zArr = this.Oooo0o0;
                    this.Oooo0o = i10 - 1;
                    zArr[i10] = false;
                } else {
                    return;
                }
            }
        }

        public void OooO00o(OooO0O0 oooO0O0) {
            OooO00o();
            Oooo0OO(this.OooOo0o + 1);
            OooO0O0[] oooO0O0Arr = this.OooOo0O;
            int i10 = this.OooOo0o;
            this.OooOo0o = i10 + 1;
            oooO0O0Arr[i10] = oooO0O0;
        }

        public void OooO0o0(int i10, int i11) {
            OooO00o();
            String[] strArr = this.OooOoo0;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public String OooOo(int i10) {
            return this.o00000O[i10];
        }

        public String OooOo0O(int i10) {
            return this.Oooooo[i10];
        }

        public String OooOo0o(int i10) {
            return this.o00000[i10];
        }

        public int OooOoO0(int i10) {
            return this.o00000Oo[i10];
        }

        public void OooO0OO(String str) {
            OooO00o();
            Oooo00O(this.OooOOoo + 1);
            String[] strArr = this.OooOOo;
            int i10 = this.OooOOoo;
            this.OooOOoo = i10 + 1;
            strArr[i10] = str;
        }

        public void OooO0o(String str) {
            OooO00o();
            OoooO00(this.OoooooO + 1);
            String[] strArr = this.Oooooo;
            int i10 = this.OoooooO;
            this.OoooooO = i10 + 1;
            strArr[i10] = str;
        }

        public void OooOo(int i10, int i11) {
            OooO00o();
            String[] strArr = this.o00000O;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOo0O(int i10, int i11) {
            OooO00o();
            String[] strArr = this.Oooooo;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOo0o(int i10, int i11) {
            OooO00o();
            String[] strArr = this.o00000;
            String str = strArr[i10];
            strArr[i10] = strArr[i11];
            strArr[i11] = str;
        }

        public void OooOoO0(int i10, int i11) {
            OooO00o();
            int[] iArr = this.o00000Oo;
            int i12 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i12;
        }

        public void OooO(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= GameControllerManager.DEVICEFLAG_VIBRATION;
            this.o000000O = z10;
        }

        public void OooO0O0(int i10, String str) {
            OooO00o();
            this.f10162OooOo[i10] = str;
        }

        public void OooO0Oo(int i10, int i11) {
            OooO00o();
            this.o00000Oo[i10] = i11;
        }

        public void OooO0oO(int i10, String str) {
            OooO00o();
            this.o00000[i10] = str;
        }

        public void OooO0oo(int i10, String str) {
            OooO00o();
            this.o00000O[i10] = str;
        }

        public void OooOO0(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 67108864;
            this.o000000 = z10;
        }

        public void OooOO0O(String str) {
            OooO00o();
            this.OooO0Oo |= GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR;
            this.OoooOo0 = str;
        }

        public void OooOO0o() {
            OooO00o();
            this.f10161OooO0o0 &= -1048577;
            this.o0OOO0o = false;
        }

        public void OooOOO() {
            OooO00o();
            this.OooO0Oo &= -268435457;
            this.OoooOo0 = "";
        }

        public void OooOOO0() {
            OooO00o();
            this.OooO0Oo &= -134217729;
            this.OoooOOo = "";
        }

        public void OooOOOO() {
            OooO00o();
            this.OooO0Oo &= -536870913;
            this.OoooOoO = "";
        }

        public void OooOOOo(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 2;
            this.OooooO0 = z10;
        }

        public void OooOOo(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 32768;
            this.o00oO0o = z10;
        }

        public void OooOOo0(String str) {
            OooO00o();
            this.OooO0Oo |= 67108864;
            this.OoooOOO = str;
        }

        public void OooOOoo(String str) {
            OooO00o();
            this.OooO0Oo |= 1073741824;
            this.OoooOoo = str;
        }

        public void OooOo0(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 524288;
            this.o0ooOoO = str;
        }

        public void OooOo00(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 8;
            this.OooooOo = str;
        }

        public void OooO00o(int i10, C0367OooO0oO oooO0oO) {
            OooO00o();
            this.OooOoO[i10] = oooO0oO;
        }

        public void OooO0O0(String str) {
            OooO00o();
            OooOooo(this.f10163OooOoO0 + 1);
            String[] strArr = this.f10162OooOo;
            int i10 = this.f10163OooOoO0;
            this.f10163OooOoO0 = i10 + 1;
            strArr[i10] = str;
        }

        public void OooO0OO(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 1048576;
            this.o0OOO0o = z10;
        }

        public void OooO0Oo(int i10) {
            OooO00o();
            OoooO(this.o00000o0 + 1);
            int[] iArr = this.o00000Oo;
            int i11 = this.o00000o0;
            this.o00000o0 = i11 + 1;
            iArr[i11] = i10;
        }

        public void OooO0o(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 2097152;
            this.o0Oo0oo = z10;
        }

        public void OooO0o0(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR;
            this.o000000o = z10;
        }

        public void OooO0oO(String str) {
            OooO00o();
            OoooO0(this.o00000O0 + 1);
            String[] strArr = this.o00000;
            int i10 = this.o00000O0;
            this.o00000O0 = i10 + 1;
            strArr[i10] = str;
        }

        public void OooO0oo(String str) {
            OooO00o();
            OoooO0O(this.o00000OO + 1);
            String[] strArr = this.o00000O;
            int i10 = this.o00000OO;
            this.o00000OO = i10 + 1;
            strArr[i10] = str;
        }

        public g OooO() {
            return new OooOO0();
        }

        public void OooO00o(C0367OooO0oO oooO0oO) {
            OooO00o();
            Oooo000(this.OooOoOO + 1);
            C0367OooO0oO[] oooO0oOArr = this.OooOoO;
            int i10 = this.OooOoOO;
            this.OooOoOO = i10 + 1;
            oooO0oOArr[i10] = oooO0oO;
        }

        public void OooOO0O(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= GameControllerManager.DEVICEFLAG_LIGHT_RGB;
            this.o000OOo = z10;
        }

        public void OooOO0o(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 4194304;
            this.o0OO00O = z10;
        }

        public void OooOOO(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 1;
            this.Ooooo0o = z10;
        }

        public void OooOOO0(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 65536;
            this.o00oO0O = z10;
        }

        public void OooOOOO(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 4096;
            this.o00o0O = z10;
        }

        public void OooOOOo(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 8192;
            this.o00ooo = str;
        }

        public void OooOOo(String str) {
            OooO00o();
            this.f10161OooO0o0 |= 8388608;
            this.oo0o0Oo = str;
        }

        public void OooOOo0(boolean z10) {
            OooO00o();
            this.f10161OooO0o0 |= 1024;
            this.o00Oo0 = z10;
        }

        public void OooO0O0(int i10, boolean z10) {
            OooO00o();
            this.OooOooO[i10] = z10;
        }

        public int OooO0o() {
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
            int i21;
            int i22;
            int i23;
            int i24;
            int i25;
            int i26;
            int i27;
            int i28 = 0;
            int b10 = o000oo0O() ? c.c.b(1, this.OooO0o.OooO00o) : 0;
            if (o000Oooo()) {
                b10 += c.c.d(this.OooO0oO) + c.c.q(2);
            }
            if (o000Oo00()) {
                b10 += c.c.d(this.OooO0oo) + c.c.q(3);
            }
            if (o000Ooo0()) {
                b10 += c.c.d(this.OooO) + c.c.q(4);
            }
            if (o000OooO()) {
                b10 += c.c.d(this.OooOO0) + c.c.q(5);
            }
            if (o000oooo()) {
                b10 += c.c.d(this.OooOO0O) + c.c.q(6);
            }
            if (o00O000()) {
                b10 += c.c.d(this.OooOO0o) + c.c.q(7);
            }
            if (o000OoOo()) {
                b10 += c.c.c(8, this.OooOOO0);
            }
            int i29 = 0;
            int i30 = 0;
            while (true) {
                i10 = this.OooOOOO;
                if (i29 >= i10) {
                    break;
                }
                i30 += c.c.o(this.OooOOO[i29]);
                i29++;
            }
            int i31 = (i10 * 2) + b10 + i30;
            int i32 = 0;
            int i33 = 0;
            while (true) {
                i11 = this.OooOOo0;
                if (i32 >= i11) {
                    break;
                }
                i33 += c.c.d(this.OooOOOo[i32]);
                i32++;
            }
            int i34 = (i11 * 2) + i31 + i33;
            int i35 = 0;
            int i36 = 0;
            while (true) {
                i12 = this.OooOOoo;
                if (i35 >= i12) {
                    break;
                }
                i36 += c.c.d(this.OooOOo[i35]);
                i35++;
            }
            int i37 = (i12 * 2) + i34 + i36;
            int i38 = 0;
            int i39 = 0;
            while (true) {
                i13 = this.OooOo0;
                int i40 = 10;
                if (i38 >= i13) {
                    break;
                }
                int i41 = this.OooOo00[i38];
                if (i41 >= 0) {
                    i40 = c.c.o(i41);
                }
                i39 += i40;
                i38++;
            }
            int i42 = (i13 * 2) + i37 + i39;
            int i43 = 0;
            int i44 = 0;
            while (true) {
                i14 = this.OooOo0o;
                if (i43 >= i14) {
                    break;
                }
                i44 += c.c.o(this.OooOo0O[i43].OooO00o);
                i43++;
            }
            int i45 = (i14 * 2) + i42 + i44;
            int i46 = 0;
            int i47 = 0;
            while (true) {
                i15 = this.f10163OooOoO0;
                if (i46 >= i15) {
                    break;
                }
                i47 += c.c.d(this.f10162OooOo[i46]);
                i46++;
            }
            int i48 = (i15 * 2) + i45 + i47;
            int i49 = 0;
            int i50 = 0;
            while (true) {
                i16 = this.OooOoOO;
                if (i49 >= i16) {
                    break;
                }
                i50 += c.c.o(this.OooOoO[i49].OooO00o);
                i49++;
            }
            int i51 = (i16 * 2) + i48 + i50;
            int i52 = 0;
            int i53 = 0;
            while (true) {
                i17 = this.OooOoo;
                if (i52 >= i17) {
                    break;
                }
                i53 += c.c.d(this.OooOoo0[i52]);
                i52++;
            }
            int i54 = this.OooOooo;
            int i55 = (i54 * 2) + (i17 * 2) + i51 + i53 + i54;
            int i56 = 0;
            int i57 = 0;
            while (true) {
                i18 = this.Oooo00O;
                if (i56 >= i18) {
                    break;
                }
                i57 += c.c.o(this.Oooo000[i56].OooO00o);
                i56++;
            }
            int i58 = (i18 * 2) + i55 + i57;
            int i59 = 0;
            int i60 = 0;
            while (true) {
                i19 = this.Oooo0;
                if (i59 >= i19) {
                    break;
                }
                int i61 = this.Oooo00o[i59];
                i60 += i61 >= 0 ? c.c.o(i61) : 10;
                i59++;
            }
            int i62 = (i19 * 2) + i58 + i60;
            int i63 = 0;
            int i64 = 0;
            while (true) {
                i20 = this.Oooo0OO;
                if (i63 >= i20) {
                    break;
                }
                i64 += c.c.o(this.Oooo0O0[i63].OooO00o);
                i63++;
            }
            int i65 = this.Oooo0o;
            int i66 = (i65 * 2) + (i20 * 2) + i62 + i64 + i65;
            int i67 = 0;
            int i68 = 0;
            while (true) {
                i21 = this.Oooo0oo;
                if (i67 >= i21) {
                    break;
                }
                i68 += c.c.o(this.Oooo0oO[i67].OooO00o);
                i67++;
            }
            int i69 = (i21 * 2) + i66 + i68;
            int i70 = 0;
            int i71 = 0;
            while (true) {
                i22 = this.OoooO00;
                if (i70 >= i22) {
                    break;
                }
                i71 += c.c.o(this.Oooo[i70].OooO00o);
                i70++;
            }
            int i72 = (i22 * 2) + i69 + i71;
            int i73 = 0;
            int i74 = 0;
            while (true) {
                i23 = this.OoooO0O;
                if (i73 >= i23) {
                    break;
                }
                i74 += c.c.o(this.OoooO0[i73].OooO00o);
                i73++;
            }
            int i75 = (i23 * 2) + i72 + i74;
            int i76 = 0;
            int i77 = 0;
            while (true) {
                i24 = this.OoooOO0;
                if (i76 >= i24) {
                    break;
                }
                i77 += c.c.d(this.OoooO[i76]);
                i76++;
            }
            int i78 = (i24 * 2) + i75 + i77;
            if (o000ooOO()) {
                i78 += c.c.b(41, this.o000oOoO.OooO00o);
            }
            if (o000o0oO()) {
                i78 += c.c.d(this.OoooOOO) + c.c.q(42);
            }
            if (o000Oo0o()) {
                i78 += c.c.d(this.OoooOOo) + c.c.q(43);
            }
            if (o000Oo()) {
                i78 += c.c.d(this.OoooOo0) + c.c.q(44);
            }
            if (o000OoOO()) {
                i78 += c.c.d(this.OoooOoO) + c.c.q(45);
            }
            if (o000oo0o()) {
                i78 += c.c.d(this.OoooOoo) + c.c.q(46);
            }
            if (o000oo()) {
                i78 += c.c.m(47, this.Ooooo00);
            }
            if (o000ooo()) {
                i78 += c.c.c(48, this.Ooooo0o);
            }
            if (o00()) {
                i78 += c.c.c(52, this.OooooO0);
            }
            if (o00O0000()) {
                i78 += c.c.m(53, this.OooooOO);
            }
            if (o000ooO0()) {
                i78 += c.c.d(this.OooooOo) + c.c.q(55);
            }
            if (o0O0ooO()) {
                i78 += c.c.d(this.Oooooo0) + c.c.q(56);
            }
            int i79 = 0;
            int i80 = 0;
            while (true) {
                i25 = this.OoooooO;
                if (i79 >= i25) {
                    break;
                }
                i80 += c.c.d(this.Oooooo[i79]);
                i79++;
            }
            int i81 = (i25 * 2) + i78 + i80;
            if (o000o0o()) {
                i81 += c.c.m(58, this.Ooooooo);
            }
            if (o000o0oo()) {
                i81 += c.c.m(59, this.o0OoOo0);
            }
            if (o000oo00()) {
                i81 += c.c.a(60, this.ooOO);
            }
            if (o000oOoo()) {
                i81 += c.c.m(61, this.o00O0O);
            }
            if (o00O000o()) {
                i81 += c.c.c(62, this.o00Oo0);
            }
            if (o000o00o()) {
                i81 += c.c.c(63, this.o00Ooo);
            }
            if (o000oooO()) {
                i81 += c.c.c(64, this.o00o0O);
            }
            if (o000o0Oo()) {
                i81 += c.c.d(this.o00ooo) + c.c.q(65);
            }
            if (o000o0o0()) {
                i81 += c.c.m(66, this.oo000o);
            }
            if (o00O00O()) {
                i81 += c.c.c(67, this.o00oO0o);
            }
            if (o000ooo0()) {
                i81 += c.c.c(68, this.o00oO0O);
            }
            if (o00oOoo()) {
                i81 += c.c.m(69, this.o0ooOO0);
            }
            if (o00O00()) {
                i81 += c.c.d(this.o0ooOOo) + c.c.q(70);
            }
            if (o000ooO()) {
                i81 += c.c.d(this.o0ooOoO) + c.c.q(71);
            }
            if (o000Oo0O()) {
                i81 += c.c.c(72, this.o0OOO0o);
            }
            if (o000o00()) {
                i81 += c.c.c(73, this.o0Oo0oo);
            }
            if (o000o0OO()) {
                i81 += c.c.c(74, this.o0OO00O);
            }
            if (o000oo0()) {
                i81 += c.c.d(this.oo0o0Oo) + c.c.q(75);
            }
            if (o000o00O()) {
                i81 += c.c.c(76, this.o0O0O00);
            }
            if (o000o0O()) {
                i81 += c.c.c(77, this.o000OOo);
            }
            if (o000o0O0()) {
                i81 += c.c.c(78, this.o000000);
            }
            if (oooo00o()) {
                i81 += c.c.c(79, this.o000000O);
            }
            if (o000o000()) {
                i81 += c.c.c(80, this.o000000o);
            }
            int i82 = 0;
            int i83 = 0;
            while (true) {
                i26 = this.o00000O0;
                if (i82 >= i26) {
                    break;
                }
                i83 += c.c.d(this.o00000[i82]);
                i82++;
            }
            int i84 = (i26 * 2) + i81 + i83;
            int i85 = 0;
            int i86 = 0;
            while (true) {
                i27 = this.o00000OO;
                if (i85 >= i27) {
                    break;
                }
                i86 += c.c.d(this.o00000O[i85]);
                i85++;
            }
            int i87 = (i27 * 2) + i84 + i86;
            int i88 = 0;
            while (true) {
                int i89 = this.o00000o0;
                if (i28 < i89) {
                    int i90 = this.o00000Oo[i28];
                    i88 += i90 >= 0 ? c.c.o(i90) : 10;
                    i28++;
                } else {
                    return (i89 * 2) + i87 + i88;
                }
            }
        }

        public final boolean OooO0oo() {
            if (o000ooOO() && o000o0oO() && o000Oo0o() && o000Oo() && o000OoOO() && oooo00o()) {
                return true;
            }
            return false;
        }

        public void OooO00o(int i10, String str) {
            OooO00o();
            this.OooOoo0[i10] = str;
        }

        public void OooO0O0(boolean z10) {
            OooO00o();
            Oooo0oO(this.OooOooo + 1);
            boolean[] zArr = this.OooOooO;
            int i10 = this.OooOooo;
            this.OooOooo = i10 + 1;
            zArr[i10] = z10;
        }

        public void OooO00o(String str) {
            OooO00o();
            OooOoO(this.OooOoo + 1);
            String[] strArr = this.OooOoo0;
            int i10 = this.OooOoo;
            this.OooOoo = i10 + 1;
            strArr[i10] = str;
        }

        public void OooO0O0(c.c cVar) throws IOException {
            if (o000oo0O()) {
                cVar.p(1, this.OooO0o.OooO00o);
            }
            if (o000Oooo()) {
                String str = this.OooO0oO;
                cVar.t(2, 2);
                cVar.k(str);
            }
            if (o000Oo00()) {
                String str2 = this.OooO0oo;
                cVar.t(3, 2);
                cVar.k(str2);
            }
            if (o000Ooo0()) {
                String str3 = this.OooO;
                cVar.t(4, 2);
                cVar.k(str3);
            }
            if (o000OooO()) {
                String str4 = this.OooOO0;
                cVar.t(5, 2);
                cVar.k(str4);
            }
            if (o000oooo()) {
                String str5 = this.OooOO0O;
                cVar.t(6, 2);
                cVar.k(str5);
            }
            if (o00O000()) {
                String str6 = this.OooOO0o;
                cVar.t(7, 2);
                cVar.k(str6);
            }
            if (o000OoOo()) {
                cVar.j(8, this.OooOOO0);
            }
            for (int i10 = 0; i10 < this.OooOOOO; i10++) {
                cVar.v(21, this.OooOOO[i10]);
            }
            for (int i11 = 0; i11 < this.OooOOo0; i11++) {
                String str7 = this.OooOOOo[i11];
                cVar.t(22, 2);
                cVar.k(str7);
            }
            for (int i12 = 0; i12 < this.OooOOoo; i12++) {
                String str8 = this.OooOOo[i12];
                cVar.t(23, 2);
                cVar.k(str8);
            }
            for (int i13 = 0; i13 < this.OooOo0; i13++) {
                int i14 = this.OooOo00[i13];
                cVar.t(24, 0);
                cVar.u(i14);
            }
            for (int i15 = 0; i15 < this.OooOo0o; i15++) {
                cVar.p(25, this.OooOo0O[i15].OooO00o);
            }
            for (int i16 = 0; i16 < this.f10163OooOoO0; i16++) {
                String str9 = this.f10162OooOo[i16];
                cVar.t(26, 2);
                cVar.k(str9);
            }
            for (int i17 = 0; i17 < this.OooOoOO; i17++) {
                cVar.p(27, this.OooOoO[i17].OooO00o);
            }
            for (int i18 = 0; i18 < this.OooOoo; i18++) {
                String str10 = this.OooOoo0[i18];
                cVar.t(28, 2);
                cVar.k(str10);
            }
            for (int i19 = 0; i19 < this.OooOooo; i19++) {
                cVar.j(29, this.OooOooO[i19]);
            }
            for (int i20 = 0; i20 < this.Oooo00O; i20++) {
                cVar.p(30, this.Oooo000[i20].OooO00o);
            }
            for (int i21 = 0; i21 < this.Oooo0; i21++) {
                int i22 = this.Oooo00o[i21];
                cVar.t(31, 0);
                cVar.u(i22);
            }
            for (int i23 = 0; i23 < this.Oooo0OO; i23++) {
                cVar.p(32, this.Oooo0O0[i23].OooO00o);
            }
            for (int i24 = 0; i24 < this.Oooo0o; i24++) {
                cVar.j(33, this.Oooo0o0[i24]);
            }
            for (int i25 = 0; i25 < this.Oooo0oo; i25++) {
                cVar.p(34, this.Oooo0oO[i25].OooO00o);
            }
            for (int i26 = 0; i26 < this.OoooO00; i26++) {
                cVar.p(35, this.Oooo[i26].OooO00o);
            }
            for (int i27 = 0; i27 < this.OoooO0O; i27++) {
                cVar.p(36, this.OoooO0[i27].OooO00o);
            }
            for (int i28 = 0; i28 < this.OoooOO0; i28++) {
                String str11 = this.OoooO[i28];
                cVar.t(37, 2);
                cVar.k(str11);
            }
            if (o000ooOO()) {
                cVar.p(41, this.o000oOoO.OooO00o);
            }
            if (o000o0oO()) {
                String str12 = this.OoooOOO;
                cVar.t(42, 2);
                cVar.k(str12);
            }
            if (o000Oo0o()) {
                String str13 = this.OoooOOo;
                cVar.t(43, 2);
                cVar.k(str13);
            }
            if (o000Oo()) {
                String str14 = this.OoooOo0;
                cVar.t(44, 2);
                cVar.k(str14);
            }
            if (o000OoOO()) {
                String str15 = this.OoooOoO;
                cVar.t(45, 2);
                cVar.k(str15);
            }
            if (o000oo0o()) {
                String str16 = this.OoooOoo;
                cVar.t(46, 2);
                cVar.k(str16);
            }
            if (o000oo()) {
                int i29 = this.Ooooo00;
                cVar.t(47, 0);
                cVar.u(i29);
            }
            if (o000ooo()) {
                cVar.j(48, this.Ooooo0o);
            }
            if (o00()) {
                cVar.j(52, this.OooooO0);
            }
            if (o00O0000()) {
                int i30 = this.OooooOO;
                cVar.t(53, 0);
                cVar.u(i30);
            }
            if (o000ooO0()) {
                String str17 = this.OooooOo;
                cVar.t(55, 2);
                cVar.k(str17);
            }
            if (o0O0ooO()) {
                String str18 = this.Oooooo0;
                cVar.t(56, 2);
                cVar.k(str18);
            }
            for (int i31 = 0; i31 < this.OoooooO; i31++) {
                String str19 = this.Oooooo[i31];
                cVar.t(57, 2);
                cVar.k(str19);
            }
            if (o000o0o()) {
                int i32 = this.Ooooooo;
                cVar.t(58, 0);
                cVar.u(i32);
            }
            if (o000o0oo()) {
                int i33 = this.o0OoOo0;
                cVar.t(59, 0);
                cVar.u(i33);
            }
            if (o000oo00()) {
                cVar.i(60, this.ooOO);
            }
            if (o000oOoo()) {
                int i34 = this.o00O0O;
                cVar.t(61, 0);
                cVar.u(i34);
            }
            if (o00O000o()) {
                cVar.j(62, this.o00Oo0);
            }
            if (o000o00o()) {
                cVar.j(63, this.o00Ooo);
            }
            if (o000oooO()) {
                cVar.j(64, this.o00o0O);
            }
            if (o000o0Oo()) {
                String str20 = this.o00ooo;
                cVar.t(65, 2);
                cVar.k(str20);
            }
            if (o000o0o0()) {
                int i35 = this.oo000o;
                cVar.t(66, 0);
                cVar.u(i35);
            }
            if (o00O00O()) {
                cVar.j(67, this.o00oO0o);
            }
            if (o000ooo0()) {
                cVar.j(68, this.o00oO0O);
            }
            if (o00oOoo()) {
                int i36 = this.o0ooOO0;
                cVar.t(69, 0);
                cVar.u(i36);
            }
            if (o00O00()) {
                String str21 = this.o0ooOOo;
                cVar.t(70, 2);
                cVar.k(str21);
            }
            if (o000ooO()) {
                String str22 = this.o0ooOoO;
                cVar.t(71, 2);
                cVar.k(str22);
            }
            if (o000Oo0O()) {
                cVar.j(72, this.o0OOO0o);
            }
            if (o000o00()) {
                cVar.j(73, this.o0Oo0oo);
            }
            if (o000o0OO()) {
                cVar.j(74, this.o0OO00O);
            }
            if (o000oo0()) {
                String str23 = this.oo0o0Oo;
                cVar.t(75, 2);
                cVar.k(str23);
            }
            if (o000o00O()) {
                cVar.j(76, this.o0O0O00);
            }
            if (o000o0O()) {
                cVar.j(77, this.o000OOo);
            }
            if (o000o0O0()) {
                cVar.j(78, this.o000000);
            }
            if (oooo00o()) {
                cVar.j(79, this.o000000O);
            }
            if (o000o000()) {
                cVar.j(80, this.o000000o);
            }
            for (int i37 = 0; i37 < this.o00000O0; i37++) {
                String str24 = this.o00000[i37];
                cVar.t(81, 2);
                cVar.k(str24);
            }
            for (int i38 = 0; i38 < this.o00000OO; i38++) {
                String str25 = this.o00000O[i38];
                cVar.t(82, 2);
                cVar.k(str25);
            }
            for (int i39 = 0; i39 < this.o00000o0; i39++) {
                int i40 = this.o00000Oo[i39];
                cVar.t(83, 0);
                cVar.u(i40);
            }
        }

        public void OooO00o(int i10, OooO oooO) {
            OooO00o();
            this.Oooo000[i10] = oooO;
        }

        public void OooO00o(OooO oooO) {
            OooO00o();
            Oooo0o(this.Oooo00O + 1);
            OooO[] oooOArr = this.Oooo000;
            int i10 = this.Oooo00O;
            this.Oooo00O = i10 + 1;
            oooOArr[i10] = oooO;
        }

        public void OooO00o(int i10, int i11) {
            OooO00o();
            this.Oooo00o[i10] = i11;
        }

        public void OooO00o(int i10) {
            OooO00o();
            OooOoo(this.Oooo0 + 1);
            int[] iArr = this.Oooo00o;
            int i11 = this.Oooo0;
            this.Oooo0 = i11 + 1;
            iArr[i11] = i10;
        }

        public void OooO00o(int i10, C0366OooO0o0 oooO0o0) {
            OooO00o();
            this.Oooo0O0[i10] = oooO0o0;
        }

        public void OooO00o(C0366OooO0o0 oooO0o0) {
            OooO00o();
            OooOoo0(this.Oooo0OO + 1);
            C0366OooO0o0[] oooO0o0Arr = this.Oooo0O0;
            int i10 = this.Oooo0OO;
            this.Oooo0OO = i10 + 1;
            oooO0o0Arr[i10] = oooO0o0;
        }

        public void OooO00o(int i10, boolean z10) {
            OooO00o();
            this.Oooo0o0[i10] = z10;
        }

        public void OooO00o(boolean z10) {
            OooO00o();
            OooOooO(this.Oooo0o + 1);
            boolean[] zArr = this.Oooo0o0;
            int i10 = this.Oooo0o;
            this.Oooo0o = i10 + 1;
            zArr[i10] = z10;
        }

        public void OooO00o(int i10, C0369OooOO0o oooOO0o) {
            OooO00o();
            this.Oooo0oO[i10] = oooOO0o;
        }

        public void OooO00o(C0369OooOO0o oooOO0o) {
            OooO00o();
            Oooo(this.Oooo0oo + 1);
            C0369OooOO0o[] oooOO0oArr = this.Oooo0oO;
            int i10 = this.Oooo0oo;
            this.Oooo0oo = i10 + 1;
            oooOO0oArr[i10] = oooOO0o;
        }

        public void OooO00o(int i10, C0365OooO0Oo oooO0Oo) {
            OooO00o();
            this.Oooo[i10] = oooO0Oo;
        }

        public void OooO00o(C0365OooO0Oo oooO0Oo) {
            OooO00o();
            OooOoOO(this.OoooO00 + 1);
            C0365OooO0Oo[] oooO0OoArr = this.Oooo;
            int i10 = this.OoooO00;
            this.OoooO00 = i10 + 1;
            oooO0OoArr[i10] = oooO0Oo;
        }

        public void OooO00o(int i10, C0117OooO00o oooO00o) {
            OooO00o();
            this.OoooO0[i10] = oooO00o;
        }

        public void OooO00o(C0117OooO00o oooO00o) {
            OooO00o();
            Oooo0(this.OoooO0O + 1);
            C0117OooO00o[] oooO00oArr = this.OoooO0;
            int i10 = this.OoooO0O;
            this.OoooO0O = i10 + 1;
            oooO00oArr[i10] = oooO00o;
        }

        public void OooO00o(C0368OooO0oo oooO0oo) {
            OooO00o();
            oooO0oo.getClass();
            this.OooO0Oo |= GameControllerManager.DEVICEFLAG_LIGHT_RGB;
            this.o000oOoO = oooO0oo;
        }

        public void OooO00o(double d10) {
            OooO00o();
            this.f10161OooO0o0 |= 256;
            this.ooOO = d10;
        }

        public void OooO00o(b bVar) throws IOException {
            OooO00o();
            while (true) {
                int p10 = bVar.p();
                switch (p10) {
                    case 0:
                        return;
                    case 8:
                        OooOO0O OooO0O0 = OooOO0O.OooO0O0(bVar.n());
                        if (OooO0O0 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O0);
                            break;
                        }
                    case 18:
                        OooOOOO(bVar.o());
                        break;
                    case 26:
                        OooO(bVar.o());
                        break;
                    case 34:
                        OooOOO0(bVar.o());
                        break;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        OooOOO(bVar.o());
                        break;
                    case 50:
                        OooOo0O(bVar.o());
                        break;
                    case 58:
                        OooOo(bVar.o());
                        break;
                    case 64:
                        OooO0Oo(bVar.h());
                        break;
                    case 168:
                        OooO0OO(bVar.n());
                        break;
                    case 170:
                        int n10 = bVar.n();
                        Oooo0oo(n10);
                        int g10 = bVar.g(n10);
                        while (bVar.b() > 0) {
                            OooO0OO(bVar.n());
                        }
                        bVar.f17197h = g10;
                        bVar.q();
                        break;
                    case 178:
                        OooO0o0(bVar.o());
                        break;
                    case 186:
                        OooO0OO(bVar.o());
                        break;
                    case 192:
                        OooO0O0(bVar.n());
                        break;
                    case 194:
                        int n11 = bVar.n();
                        Oooo0O0(n11);
                        int g11 = bVar.g(n11);
                        while (bVar.b() > 0) {
                            OooO0O0(bVar.n());
                        }
                        bVar.f17197h = g11;
                        bVar.q();
                        break;
                    case 200:
                        OooO0O0 OooO0O02 = OooO0O0.OooO0O0(bVar.n());
                        if (OooO0O02 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O02);
                            break;
                        }
                    case 202:
                        int g12 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            OooO0O0 OooO0O03 = OooO0O0.OooO0O0(bVar.n());
                            if (OooO0O03 != null) {
                                OooO00o(OooO0O03);
                            }
                        }
                        bVar.f17197h = g12;
                        bVar.q();
                        break;
                    case 210:
                        OooO0O0(bVar.o());
                        break;
                    case 216:
                        C0367OooO0oO OooO0O04 = C0367OooO0oO.OooO0O0(bVar.n());
                        if (OooO0O04 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O04);
                            break;
                        }
                    case 218:
                        int g13 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            C0367OooO0oO OooO0O05 = C0367OooO0oO.OooO0O0(bVar.n());
                            if (OooO0O05 != null) {
                                OooO00o(OooO0O05);
                            }
                        }
                        bVar.f17197h = g13;
                        bVar.q();
                        break;
                    case 226:
                        OooO00o(bVar.o());
                        break;
                    case 232:
                        OooO0O0(bVar.h());
                        break;
                    case 234:
                        int n12 = bVar.n();
                        Oooo0oO(n12);
                        int g14 = bVar.g(n12);
                        while (bVar.b() > 0) {
                            OooO0O0(bVar.h());
                        }
                        bVar.f17197h = g14;
                        bVar.q();
                        break;
                    case 240:
                        OooO OooO0O06 = OooO.OooO0O0(bVar.n());
                        if (OooO0O06 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O06);
                            break;
                        }
                    case 242:
                        int g15 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            OooO OooO0O07 = OooO.OooO0O0(bVar.n());
                            if (OooO0O07 != null) {
                                OooO00o(OooO0O07);
                            }
                        }
                        bVar.f17197h = g15;
                        bVar.q();
                        break;
                    case 248:
                        OooO00o(bVar.n());
                        break;
                    case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /*250*/:
                        int n13 = bVar.n();
                        OooOoo(n13);
                        int g16 = bVar.g(n13);
                        while (bVar.b() > 0) {
                            OooO00o(bVar.n());
                        }
                        bVar.f17197h = g16;
                        bVar.q();
                        break;
                    case 256:
                        C0366OooO0o0 OooO0O08 = C0366OooO0o0.OooO0O0(bVar.n());
                        if (OooO0O08 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O08);
                            break;
                        }
                    case 258:
                        int g17 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            C0366OooO0o0 OooO0O09 = C0366OooO0o0.OooO0O0(bVar.n());
                            if (OooO0O09 != null) {
                                OooO00o(OooO0O09);
                            }
                        }
                        bVar.f17197h = g17;
                        bVar.q();
                        break;
                    case 264:
                        OooO00o(bVar.h());
                        break;
                    case 266:
                        int n14 = bVar.n();
                        OooOooO(n14);
                        int g18 = bVar.g(n14);
                        while (bVar.b() > 0) {
                            OooO00o(bVar.h());
                        }
                        bVar.f17197h = g18;
                        bVar.q();
                        break;
                    case 272:
                        C0369OooOO0o OooO0O010 = C0369OooOO0o.OooO0O0(bVar.n());
                        if (OooO0O010 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O010);
                            break;
                        }
                    case 274:
                        int g19 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            C0369OooOO0o OooO0O011 = C0369OooOO0o.OooO0O0(bVar.n());
                            if (OooO0O011 != null) {
                                OooO00o(OooO0O011);
                            }
                        }
                        bVar.f17197h = g19;
                        bVar.q();
                        break;
                    case 280:
                        C0365OooO0Oo OooO0O012 = C0365OooO0Oo.OooO0O0(bVar.n());
                        if (OooO0O012 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O012);
                            break;
                        }
                    case 282:
                        int g20 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            C0365OooO0Oo OooO0O013 = C0365OooO0Oo.OooO0O0(bVar.n());
                            if (OooO0O013 != null) {
                                OooO00o(OooO0O013);
                            }
                        }
                        bVar.f17197h = g20;
                        bVar.q();
                        break;
                    case 288:
                        C0117OooO00o OooO0O014 = C0117OooO00o.OooO0O0(bVar.n());
                        if (OooO0O014 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O014);
                            break;
                        }
                    case 290:
                        int g21 = bVar.g(bVar.n());
                        while (bVar.b() > 0) {
                            C0117OooO00o OooO0O015 = C0117OooO00o.OooO0O0(bVar.n());
                            if (OooO0O015 != null) {
                                OooO00o(OooO0O015);
                            }
                        }
                        bVar.f17197h = g21;
                        bVar.q();
                        break;
                    case 298:
                        OooO0Oo(bVar.o());
                        break;
                    case 328:
                        C0368OooO0oo OooO0O016 = C0368OooO0oo.OooO0O0(bVar.n());
                        if (OooO0O016 == null) {
                            break;
                        } else {
                            OooO00o(OooO0O016);
                            break;
                        }
                    case 338:
                        OooOOo0(bVar.o());
                        break;
                    case 346:
                        OooOO0(bVar.o());
                        break;
                    case 354:
                        OooOO0O(bVar.o());
                        break;
                    case 362:
                        OooOO0o(bVar.o());
                        break;
                    case 370:
                        OooOOoo(bVar.o());
                        break;
                    case 376:
                        OoooOo0(bVar.n());
                        break;
                    case 384:
                        OooOOO(bVar.h());
                        break;
                    case 416:
                        OooOOOo(bVar.h());
                        break;
                    case 424:
                        OoooOoO(bVar.n());
                        break;
                    case 442:
                        OooOo00(bVar.o());
                        break;
                    case 450:
                        OooOo0o(bVar.o());
                        break;
                    case 458:
                        OooO0o(bVar.o());
                        break;
                    case 464:
                        o000oOoO(bVar.n());
                        break;
                    case 472:
                        OoooOOO(bVar.n());
                        break;
                    case 481:
                        OooO00o(Double.longBitsToDouble(bVar.m()));
                        break;
                    case 488:
                        OoooOOo(bVar.n());
                        break;
                    case 496:
                        OooOOo0(bVar.h());
                        break;
                    case 504:
                        OooO0oo(bVar.h());
                        break;
                    case 512:
                        OooOOOO(bVar.h());
                        break;
                    case 522:
                        OooOOOo(bVar.o());
                        break;
                    case 528:
                        OoooOO0(bVar.n());
                        break;
                    case 536:
                        OooOOo(bVar.h());
                        break;
                    case 544:
                        OooOOO0(bVar.h());
                        break;
                    case 552:
                        OoooOoo(bVar.n());
                        break;
                    case 562:
                        OooOoO0(bVar.o());
                        break;
                    case 570:
                        OooOo0(bVar.o());
                        break;
                    case 576:
                        OooO0OO(bVar.h());
                        break;
                    case 584:
                        OooO0o(bVar.h());
                        break;
                    case 592:
                        OooOO0o(bVar.h());
                        break;
                    case 602:
                        OooOOo(bVar.o());
                        break;
                    case 608:
                        OooO0oO(bVar.h());
                        break;
                    case 616:
                        OooOO0O(bVar.h());
                        break;
                    case 624:
                        OooOO0(bVar.h());
                        break;
                    case 632:
                        OooO(bVar.h());
                        break;
                    case 640:
                        OooO0o0(bVar.h());
                        break;
                    case 650:
                        OooO0oO(bVar.o());
                        break;
                    case 658:
                        OooO0oo(bVar.o());
                        break;
                    case 664:
                        OooO0Oo(bVar.n());
                        break;
                    case 666:
                        int n15 = bVar.n();
                        OoooO(n15);
                        int g22 = bVar.g(n15);
                        while (bVar.b() > 0) {
                            OooO0Oo(bVar.n());
                        }
                        bVar.f17197h = g22;
                        bVar.q();
                        break;
                    default:
                        if (bVar.j(p10)) {
                            break;
                        } else {
                            return;
                        }
                }
            }
        }

        public OooOO0(boolean z10) {
            super(true);
            this.OooO0oO = "";
            this.OooO0oo = "";
            this.OooO = "";
            this.OooOO0 = "";
            this.OooOO0O = "";
            this.OooOO0o = "";
            this.OooOOO0 = false;
            this.OooOOO = new int[0];
            this.OooOOOo = new String[0];
            this.OooOOo = new String[0];
            this.OooOo00 = new int[0];
            this.OooOo0O = new OooO0O0[0];
            this.f10162OooOo = new String[0];
            this.OooOoO = new C0367OooO0oO[0];
            this.OooOoo0 = new String[0];
            this.OooOooO = new boolean[0];
            this.Oooo000 = new OooO[0];
            this.Oooo00o = new int[0];
            this.Oooo0O0 = new C0366OooO0o0[0];
            this.Oooo0o0 = new boolean[0];
            this.Oooo0oO = new C0369OooOO0o[0];
            this.Oooo = new C0365OooO0Oo[0];
            this.OoooO0 = new C0117OooO00o[0];
            this.OoooO = new String[0];
            this.OoooOOO = "";
            this.OoooOOo = "";
            this.OoooOo0 = "";
            this.OoooOoO = "";
            this.OoooOoo = "";
            this.Ooooo00 = -1;
            this.Ooooo0o = false;
            this.OooooO0 = false;
            this.OooooOO = 100;
            this.OooooOo = "";
            this.Oooooo0 = "";
            this.Oooooo = new String[0];
            this.Ooooooo = 0;
            this.o0OoOo0 = 3;
            this.ooOO = 1.6d;
            this.o00O0O = 120;
            this.o00Oo0 = false;
            this.o00Ooo = true;
            this.o00o0O = true;
            this.o00ooo = "";
            this.oo000o = 0;
            this.o00oO0o = false;
            this.o00oO0O = false;
            this.o0ooOO0 = 60;
            this.o0ooOOo = "";
            this.o0ooOoO = "";
            this.o0OOO0o = false;
            this.o0Oo0oo = false;
            this.o0OO00O = true;
            this.oo0o0Oo = "";
            this.o0O0O00 = false;
            this.o000OOo = true;
            this.o000000 = false;
            this.o000000O = true;
            this.o000000o = true;
            this.o00000 = new String[0];
            this.o00000O = new String[0];
            this.o00000Oo = new int[0];
        }

        public static OooOO0 OooO0O0(b bVar) throws IOException {
            OooOO0 oooOO0 = new OooOO0();
            oooOO0.OooO00o(bVar);
            return oooOO0;
        }
    }

    public static void OooO00o() {
    }

    public static final class OooO extends e {
        public static OooO[] OooO = null;
        public static final int OooO0OO = 0;
        public static final OooO OooO0Oo;
        public static final OooO OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10152OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final OooO OooO0oo;

        static {
            OooO oooO = new OooO(0, "MATCH_TYPE_HOST");
            OooO0Oo = oooO;
            OooO oooO2 = new OooO(1, "MATCH_TYPE_PATH");
            OooO0o = oooO2;
            OooO oooO3 = new OooO(2, "MATCH_TYPE_PARAMETER");
            OooO0oo = oooO3;
            OooO = new OooO[]{oooO, oooO2, oooO3};
        }

        public OooO(int i10, String str) {
            super(i10, str);
        }

        public static OooO OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static OooO[] OooO0O0() {
            return OooO;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooO00o  reason: collision with other inner class name */
    public static final class C0117OooO00o extends e {
        public static C0117OooO00o[] OooO = null;
        public static final int OooO0OO = 1;
        public static final C0117OooO00o OooO0Oo;
        public static final C0117OooO00o OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10153OooO0o0 = 2;
        public static final int OooO0oO = 3;
        public static final C0117OooO00o OooO0oo;

        static {
            C0117OooO00o oooO00o = new C0117OooO00o(1, "BACKEND_METHOD_GET");
            OooO0Oo = oooO00o;
            C0117OooO00o oooO00o2 = new C0117OooO00o(2, "BACKEND_METHOD_POST");
            OooO0o = oooO00o2;
            C0117OooO00o oooO00o3 = new C0117OooO00o(3, "BACKEND_METHOD_ALL");
            OooO0oo = oooO00o3;
            OooO = new C0117OooO00o[]{oooO00o, oooO00o2, oooO00o3};
        }

        public C0117OooO00o(int i10, String str) {
            super(i10, str);
        }

        public static C0117OooO00o OooO0O0(int i10) {
            if (i10 == 1) {
                return OooO0Oo;
            }
            if (i10 == 2) {
                return OooO0o;
            }
            if (i10 == 3) {
                return OooO0oo;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0117OooO00o[] OooO0O0() {
            return OooO;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooO0Oo  reason: case insensitive filesystem */
    public static final class C0365OooO0Oo extends e {
        public static C0365OooO0Oo[] OooO = null;
        public static final int OooO0OO = 0;
        public static final C0365OooO0Oo OooO0Oo;
        public static final C0365OooO0Oo OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10156OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final C0365OooO0Oo OooO0oo;

        static {
            C0365OooO0Oo oooO0Oo = new C0365OooO0Oo(0, "NONE");
            OooO0Oo = oooO0Oo;
            C0365OooO0Oo oooO0Oo2 = new C0365OooO0Oo(1, "NORMAL");
            OooO0o = oooO0Oo2;
            C0365OooO0Oo oooO0Oo3 = new C0365OooO0Oo(2, "URL_FILTERD");
            OooO0oo = oooO0Oo3;
            OooO = new C0365OooO0Oo[]{oooO0Oo, oooO0Oo2, oooO0Oo3};
        }

        public C0365OooO0Oo(int i10, String str) {
            super(i10, str);
        }

        public static C0365OooO0Oo OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0365OooO0Oo[] OooO0O0() {
            return OooO;
        }
    }

    public static final class OooO0o extends e {
        public static OooO0o[] OooO = null;
        public static final int OooO0OO = 0;
        public static final OooO0o OooO0Oo;
        public static final OooO0o OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10157OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final OooO0o OooO0oo;

        static {
            OooO0o oooO0o = new OooO0o(0, "QUERY_A_4A");
            OooO0Oo = oooO0o;
            OooO0o oooO0o2 = new OooO0o(1, "QUERY_A");
            OooO0o = oooO0o2;
            OooO0o oooO0o3 = new OooO0o(2, "QUERY_4A");
            OooO0oo = oooO0o3;
            OooO = new OooO0o[]{oooO0o, oooO0o2, oooO0o3};
        }

        public OooO0o(int i10, String str) {
            super(i10, str);
        }

        public static OooO0o OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static OooO0o[] OooO0O0() {
            return OooO;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooOO0o  reason: case insensitive filesystem */
    public static final class C0369OooOO0o extends e {
        public static C0369OooOO0o[] OooO = null;
        public static final int OooO0OO = 0;
        public static final C0369OooOO0o OooO0Oo;
        public static final C0369OooOO0o OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10165OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final C0369OooOO0o OooO0oo;

        static {
            C0369OooOO0o oooOO0o = new C0369OooOO0o(0, "WEBP_NONE");
            OooO0Oo = oooOO0o;
            C0369OooOO0o oooOO0o2 = new C0369OooOO0o(1, "WEBP_NOALPHA");
            OooO0o = oooOO0o2;
            C0369OooOO0o oooOO0o3 = new C0369OooOO0o(2, "WEBP_ALL");
            OooO0oo = oooOO0o3;
            OooO = new C0369OooOO0o[]{oooOO0o, oooOO0o2, oooOO0o3};
        }

        public C0369OooOO0o(int i10, String str) {
            super(i10, str);
        }

        public static C0369OooOO0o OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0369OooOO0o[] OooO0O0() {
            return OooO;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooO0oO  reason: case insensitive filesystem */
    public static final class C0367OooO0oO extends e {
        public static final int OooO = 3;
        public static final int OooO0OO = 0;
        public static final C0367OooO0oO OooO0Oo;
        public static final C0367OooO0oO OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10159OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final C0367OooO0oO OooO0oo;
        public static final C0367OooO0oO OooOO0;
        public static C0367OooO0oO[] OooOO0O;

        static {
            C0367OooO0oO oooO0oO = new C0367OooO0oO(0, "APP_PROTO_NONE");
            OooO0Oo = oooO0oO;
            C0367OooO0oO oooO0oO2 = new C0367OooO0oO(1, "APP_PROTO_HTTPS");
            OooO0o = oooO0oO2;
            C0367OooO0oO oooO0oO3 = new C0367OooO0oO(2, "APP_PROTO_TCP");
            OooO0oo = oooO0oO3;
            C0367OooO0oO oooO0oO4 = new C0367OooO0oO(3, "APP_PROTO_HTTPS_TCP");
            OooOO0 = oooO0oO4;
            OooOO0O = new C0367OooO0oO[]{oooO0oO, oooO0oO2, oooO0oO3, oooO0oO4};
        }

        public C0367OooO0oO(int i10, String str) {
            super(i10, str);
        }

        public static C0367OooO0oO OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            if (i10 == 3) {
                return OooOO0;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0367OooO0oO[] OooO0O0() {
            return OooOO0O;
        }
    }

    public static final class OooO0OO extends e {
        public static final int OooO = 100;
        public static final int OooO0OO = 0;
        public static final OooO0OO OooO0Oo;
        public static final OooO0OO OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10155OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final OooO0OO OooO0oo;
        public static final OooO0OO OooOO0;
        public static final int OooOO0O = 199;
        public static final OooO0OO OooOO0o;
        public static OooO0OO[] OooOOO0;

        static {
            OooO0OO oooO0OO = new OooO0OO(0, "BACKEND_NORMAL");
            OooO0Oo = oooO0OO;
            OooO0OO oooO0OO2 = new OooO0OO(1, "BACKEND_NET_DETECT_AUTO");
            OooO0o = oooO0OO2;
            OooO0OO oooO0OO3 = new OooO0OO(2, "BACKEND_NET_DETECT_MANUAL");
            OooO0oo = oooO0OO3;
            OooO0OO oooO0OO4 = new OooO0OO(100, "BACKEND_THIRD_PARTY_TEST");
            OooOO0 = oooO0OO4;
            OooO0OO oooO0OO5 = new OooO0OO(OooOO0O, "BACKEND_THIRD_PARTY_TEST_MAX");
            OooOO0o = oooO0OO5;
            OooOOO0 = new OooO0OO[]{oooO0OO, oooO0OO2, oooO0OO3, oooO0OO4, oooO0OO5};
        }

        public OooO0OO(int i10, String str) {
            super(i10, str);
        }

        public static OooO0OO OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            if (i10 == 100) {
                return OooOO0;
            }
            if (i10 == 199) {
                return OooOO0o;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static OooO0OO[] OooO0O0() {
            return OooOOO0;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooO0o0  reason: case insensitive filesystem */
    public static final class C0366OooO0o0 extends e {
        public static final int OooO = 3;
        public static final int OooO0OO = 0;
        public static final C0366OooO0o0 OooO0Oo;
        public static final C0366OooO0o0 OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10158OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final C0366OooO0o0 OooO0oo;
        public static final C0366OooO0o0 OooOO0;
        public static final int OooOO0O = 4;
        public static final C0366OooO0o0 OooOO0o;
        public static C0366OooO0o0[] OooOOO0;

        static {
            C0366OooO0o0 oooO0o0 = new C0366OooO0o0(0, "COMPRESS_NONE");
            OooO0Oo = oooO0o0;
            C0366OooO0o0 oooO0o02 = new C0366OooO0o0(1, "COMPRESS_LOW");
            OooO0o = oooO0o02;
            C0366OooO0o0 oooO0o03 = new C0366OooO0o0(2, "COMPRESS_MEDIUM");
            OooO0oo = oooO0o03;
            C0366OooO0o0 oooO0o04 = new C0366OooO0o0(3, "COMPRESS_HIGH");
            OooOO0 = oooO0o04;
            C0366OooO0o0 oooO0o05 = new C0366OooO0o0(4, "COMPRESS_LOSSLESS");
            OooOO0o = oooO0o05;
            OooOOO0 = new C0366OooO0o0[]{oooO0o0, oooO0o02, oooO0o03, oooO0o04, oooO0o05};
        }

        public C0366OooO0o0(int i10, String str) {
            super(i10, str);
        }

        public static C0366OooO0o0 OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            if (i10 == 3) {
                return OooOO0;
            }
            if (i10 == 4) {
                return OooOO0o;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0366OooO0o0[] OooO0O0() {
            return OooOOO0;
        }
    }

    public static final class OooOO0O extends e {
        public static final int OooO = 3;
        public static final int OooO0OO = 0;
        public static final OooOO0O OooO0Oo;
        public static final OooOO0O OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10164OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final OooOO0O OooO0oo;
        public static final OooOO0O OooOO0;
        public static final int OooOO0O = 4;
        public static final OooOO0O OooOO0o;
        public static OooOO0O[] OooOOO0;

        static {
            OooOO0O oooOO0O = new OooOO0O(0, "INFO");
            OooO0Oo = oooOO0O;
            OooOO0O oooOO0O2 = new OooOO0O(1, "NOTICE");
            OooO0o = oooOO0O2;
            OooOO0O oooOO0O3 = new OooOO0O(2, "WARN");
            OooO0oo = oooOO0O3;
            OooOO0O oooOO0O4 = new OooOO0O(3, "ERROR");
            OooOO0 = oooOO0O4;
            OooOO0O oooOO0O5 = new OooOO0O(4, "FATAL");
            OooOO0o = oooOO0O5;
            OooOOO0 = new OooOO0O[]{oooOO0O, oooOO0O2, oooOO0O3, oooOO0O4, oooOO0O5};
        }

        public OooOO0O(int i10, String str) {
            super(i10, str);
        }

        public static OooOO0O OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            if (i10 == 3) {
                return OooOO0;
            }
            if (i10 == 4) {
                return OooOO0o;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static OooOO0O[] OooO0O0() {
            return OooOOO0;
        }
    }

    public static final class OooO0O0 extends e {
        public static final int OooO = 17;
        public static final int OooO0OO = 0;
        public static final OooO0O0 OooO0Oo;
        public static final OooO0O0 OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10154OooO0o0 = 4;
        public static final int OooO0oO = 9;
        public static final OooO0O0 OooO0oo;
        public static final OooO0O0 OooOO0;
        public static final int OooOO0O = 21;
        public static final OooO0O0 OooOO0o;
        public static final OooO0O0 OooOOO;
        public static final int OooOOO0 = 22;
        public static OooO0O0[] OooOOOO;

        static {
            OooO0O0 oooO0O0 = new OooO0O0(0, "PROTOCOL_BYPASS");
            OooO0Oo = oooO0O0;
            OooO0O0 oooO0O02 = new OooO0O0(4, "PROTOCOL_TLS_HTTP2_TCP");
            OooO0o = oooO0O02;
            OooO0O0 oooO0O03 = new OooO0O0(9, "PROTOCOL_REJECT");
            OooO0oo = oooO0O03;
            OooO0O0 oooO0O04 = new OooO0O0(17, "PROTOCOL_CLEAR_HTTP2_QUIC");
            OooOO0 = oooO0O04;
            OooO0O0 oooO0O05 = new OooO0O0(21, "PROTOCOL_TLS_HTTP1_WEBSOCKET");
            OooOO0o = oooO0O05;
            OooO0O0 oooO0O06 = new OooO0O0(22, "PROTOCOL_CLEAR_HTTP1_WEBSOCKET_QUIC");
            OooOOO = oooO0O06;
            OooOOOO = new OooO0O0[]{oooO0O0, oooO0O02, oooO0O03, oooO0O04, oooO0O05, oooO0O06};
        }

        public OooO0O0(int i10, String str) {
            super(i10, str);
        }

        public static OooO0O0 OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 4) {
                return OooO0o;
            }
            if (i10 == 9) {
                return OooO0oo;
            }
            if (i10 == 17) {
                return OooOO0;
            }
            if (i10 == 21) {
                return OooOO0o;
            }
            if (i10 == 22) {
                return OooOOO;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static OooO0O0[] OooO0O0() {
            return OooOOOO;
        }
    }

    /* renamed from: com.mah.ndk.OooO00o$OooO0oo  reason: case insensitive filesystem */
    public static final class C0368OooO0oo extends e {
        public static final int OooO = 3;
        public static final int OooO0OO = 0;
        public static final C0368OooO0oo OooO0Oo;
        public static final C0368OooO0oo OooO0o;

        /* renamed from: OooO0o0  reason: collision with root package name */
        public static final int f10160OooO0o0 = 1;
        public static final int OooO0oO = 2;
        public static final C0368OooO0oo OooO0oo;
        public static final C0368OooO0oo OooOO0;
        public static final int OooOO0O = 4;
        public static final C0368OooO0oo OooOO0o;
        public static final C0368OooO0oo OooOOO;
        public static final int OooOOO0 = 5;
        public static C0368OooO0oo[] OooOOOO;

        static {
            C0368OooO0oo oooO0oo = new C0368OooO0oo(0, "NotReachable");
            OooO0Oo = oooO0oo;
            C0368OooO0oo oooO0oo2 = new C0368OooO0oo(1, "ReachableViaWiFi");
            OooO0o = oooO0oo2;
            C0368OooO0oo oooO0oo3 = new C0368OooO0oo(2, "ReachableVia2G");
            OooO0oo = oooO0oo3;
            C0368OooO0oo oooO0oo4 = new C0368OooO0oo(3, "ReachableVia3G");
            OooOO0 = oooO0oo4;
            C0368OooO0oo oooO0oo5 = new C0368OooO0oo(4, "ReachableVia4G");
            OooOO0o = oooO0oo5;
            C0368OooO0oo oooO0oo6 = new C0368OooO0oo(5, "ReachableVia5G");
            OooOOO = oooO0oo6;
            OooOOOO = new C0368OooO0oo[]{oooO0oo, oooO0oo2, oooO0oo3, oooO0oo4, oooO0oo5, oooO0oo6};
        }

        public C0368OooO0oo(int i10, String str) {
            super(i10, str);
        }

        public static C0368OooO0oo OooO0O0(int i10) {
            if (i10 == 0) {
                return OooO0Oo;
            }
            if (i10 == 1) {
                return OooO0o;
            }
            if (i10 == 2) {
                return OooO0oo;
            }
            if (i10 == 3) {
                return OooOO0;
            }
            if (i10 == 4) {
                return OooOO0o;
            }
            if (i10 == 5) {
                return OooOOO;
            }
            throw new IllegalArgumentException(Integer.toString(i10));
        }

        public e OooO00o(int i10) {
            return OooO0O0(i10);
        }

        public static C0368OooO0oo[] OooO0O0() {
            return OooOOOO;
        }
    }
}
