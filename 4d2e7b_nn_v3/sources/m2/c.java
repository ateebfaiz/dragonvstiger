package m2;

import m2.d;

public abstract /* synthetic */ class c {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f22503a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f22504b;

    static {
        int[] iArr = new int[d.a.values().length];
        f22503a = iArr;
        d.a aVar = d.a.MTML_INTEGRITY_DETECT;
        iArr[aVar.ordinal()] = 1;
        d.a aVar2 = d.a.MTML_APP_EVENT_PREDICTION;
        iArr[aVar2.ordinal()] = 2;
        int[] iArr2 = new int[d.a.values().length];
        f22504b = iArr2;
        iArr2[aVar.ordinal()] = 1;
        iArr2[aVar2.ordinal()] = 2;
    }
}
