package s5;

import s5.b;

public abstract /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f23902a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f23903b;

    static {
        int[] iArr = new int[b.c.values().length];
        f23902a = iArr;
        b.c cVar = b.c.Analysis;
        iArr[cVar.ordinal()] = 1;
        b.c cVar2 = b.c.AnrReport;
        iArr[cVar2.ordinal()] = 2;
        b.c cVar3 = b.c.CrashReport;
        iArr[cVar3.ordinal()] = 3;
        b.c cVar4 = b.c.CrashShield;
        iArr[cVar4.ordinal()] = 4;
        b.c cVar5 = b.c.ThreadCheck;
        iArr[cVar5.ordinal()] = 5;
        int[] iArr2 = new int[b.c.values().length];
        f23903b = iArr2;
        iArr2[cVar.ordinal()] = 1;
        iArr2[cVar2.ordinal()] = 2;
        iArr2[cVar3.ordinal()] = 3;
        iArr2[cVar4.ordinal()] = 4;
        iArr2[cVar5.ordinal()] = 5;
    }
}
