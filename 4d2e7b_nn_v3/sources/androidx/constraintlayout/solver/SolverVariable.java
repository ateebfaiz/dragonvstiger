package androidx.constraintlayout.solver;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId = -1;
    float[] goalStrengthVector = new float[9];

    /* renamed from: id  reason: collision with root package name */
    public int f14684id = -1;
    public boolean inGoal;
    HashSet<ArrayRow> inRows = null;
    public boolean isFinalValue = false;
    ArrayRow[] mClientEquations = new ArrayRow[16];
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[9];
    public int usageInRowCount = 0;

    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14685a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.SolverVariable$Type[] r0 = androidx.constraintlayout.solver.SolverVariable.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14685a = r0
                androidx.constraintlayout.solver.SolverVariable$Type r1 = androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14685a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.SolverVariable$Type r1 = androidx.constraintlayout.solver.SolverVariable.Type.CONSTANT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14685a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.SolverVariable$Type r1 = androidx.constraintlayout.solver.SolverVariable.Type.SLACK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14685a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.SolverVariable$Type r1 = androidx.constraintlayout.solver.SolverVariable.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14685a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.SolverVariable$Type r1 = androidx.constraintlayout.solver.SolverVariable.Type.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.SolverVariable.a.<clinit>():void");
        }
    }

    public SolverVariable(String str, Type type) {
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            return str + uniqueErrorId;
        }
        int i10 = a.f14685a[type.ordinal()];
        if (i10 == 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("U");
            int i11 = uniqueUnrestrictedId + 1;
            uniqueUnrestrictedId = i11;
            sb2.append(i11);
            return sb2.toString();
        } else if (i10 == 2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("C");
            int i12 = uniqueConstantId + 1;
            uniqueConstantId = i12;
            sb3.append(i12);
            return sb3.toString();
        } else if (i10 == 3) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("S");
            int i13 = uniqueSlackId + 1;
            uniqueSlackId = i13;
            sb4.append(i13);
            return sb4.toString();
        } else if (i10 == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("e");
            int i14 = uniqueErrorId + 1;
            uniqueErrorId = i14;
            sb5.append(i14);
            return sb5.toString();
        } else if (i10 == 5) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
            int i15 = uniqueId + 1;
            uniqueId = i15;
            sb6.append(i15);
            return sb6.toString();
        } else {
            throw new AssertionError(type.name());
        }
    }

    static void increaseErrorId() {
        uniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i10 = 0;
        while (true) {
            int i11 = this.mClientEquationsCount;
            if (i10 >= i11) {
                ArrayRow[] arrayRowArr = this.mClientEquations;
                if (i11 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i12 = this.mClientEquationsCount;
                arrayRowArr2[i12] = arrayRow;
                this.mClientEquationsCount = i12 + 1;
                return;
            } else if (this.mClientEquations[i10] != arrayRow) {
                i10++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void clearStrengths() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.strengthVector[i10] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        int i11 = 0;
        while (i11 < i10) {
            if (this.mClientEquations[i11] == arrayRow) {
                while (i11 < i10 - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i12 = i11 + 1;
                    arrayRowArr[i11] = arrayRowArr[i12];
                    i11 = i12;
                }
                this.mClientEquationsCount--;
                return;
            }
            i11++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.f14684id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.goalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f10) {
        this.computedValue = f10;
        this.isFinalValue = true;
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    /* access modifiers changed from: package-private */
    public String strengthsToString() {
        String str = this + "[";
        boolean z10 = false;
        boolean z11 = true;
        for (int i10 = 0; i10 < this.strengthVector.length; i10++) {
            String str2 = str + this.strengthVector[i10];
            float[] fArr = this.strengthVector;
            float f10 = fArr[i10];
            if (f10 > 0.0f) {
                z10 = false;
            } else if (f10 < 0.0f) {
                z10 = true;
            }
            if (f10 != 0.0f) {
                z11 = false;
            }
            if (i10 < fArr.length - 1) {
                str = str2 + ", ";
            } else {
                str = str2 + "] ";
            }
        }
        if (z10) {
            str = str + " (-)";
        }
        if (!z11) {
            return str;
        }
        return str + " (*)";
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.f14684id;
    }

    public final void updateReferencesWithNewDefinition(ArrayRow arrayRow) {
        int i10 = this.mClientEquationsCount;
        for (int i11 = 0; i11 < i10; i11++) {
            this.mClientEquations[i11].updateFromRow(arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    public SolverVariable(Type type, String str) {
        this.mType = type;
    }
}
