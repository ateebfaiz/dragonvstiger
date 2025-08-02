package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.io.PrintStream;
import java.util.Arrays;

public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE = 16;
    private final int NONE = -1;
    private int SIZE = 16;
    int head = -1;
    int[] keys = new int[16];
    protected final Cache mCache;
    int mCount = 0;
    private final ArrayRow mRow;
    int[] next = new int[16];
    int[] nextKeys = new int[16];
    int[] previous = new int[16];
    float[] values = new float[16];
    int[] variables = new int[16];

    SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f14684id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.nextKeys;
                int i13 = iArr[i12];
                if (i13 == -1) {
                    break;
                }
                i12 = i13;
            }
            iArr[i12] = i10;
        }
        this.nextKeys[i10] = -1;
    }

    private void addVariable(int i10, SolverVariable solverVariable, float f10) {
        this.variables[i10] = solverVariable.f14684id;
        this.values[i10] = f10;
        this.previous[i10] = -1;
        this.next[i10] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i10 = 0; i10 < this.HASH_SIZE; i10++) {
            if (this.keys[i10] != -1) {
                String str = hashCode() + " hash [" + i10 + "] => ";
                int i11 = this.keys[i10];
                boolean z10 = false;
                while (!z10) {
                    str = str + " " + this.variables[i11];
                    int i12 = this.nextKeys[i11];
                    if (i12 != -1) {
                        i11 = i12;
                    } else {
                        z10 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i10 = 0; i10 < this.SIZE; i10++) {
            if (this.variables[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i10 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i10);
        this.values = Arrays.copyOf(this.values, i10);
        this.previous = Arrays.copyOf(this.previous, i10);
        this.next = Arrays.copyOf(this.next, i10);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i10);
        for (int i11 = this.SIZE; i11 < i10; i11++) {
            this.variables[i11] = -1;
            this.nextKeys[i11] = -1;
        }
        this.SIZE = i10;
    }

    private void insertVariable(int i10, SolverVariable solverVariable, float f10) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f10);
        if (i10 != -1) {
            this.previous[findEmptySlot] = i10;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i10];
            iArr[i10] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int i11 = this.next[findEmptySlot];
        if (i11 != -1) {
            this.previous[i11] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void removeFromHashMap(androidx.constraintlayout.solver.SolverVariable r6) {
        /*
            r5 = this;
            int r6 = r6.f14684id
            int r0 = r5.HASH_SIZE
            int r0 = r6 % r0
            int[] r1 = r5.keys
            r2 = r1[r0]
            r3 = -1
            if (r2 != r3) goto L_0x000e
            return
        L_0x000e:
            int[] r4 = r5.variables
            r4 = r4[r2]
            if (r4 != r6) goto L_0x001d
            int[] r6 = r5.nextKeys
            r4 = r6[r2]
            r1[r0] = r4
            r6[r2] = r3
            goto L_0x0039
        L_0x001d:
            int[] r0 = r5.nextKeys
            r1 = r0[r2]
            if (r1 == r3) goto L_0x002b
            int[] r4 = r5.variables
            r4 = r4[r1]
            if (r4 == r6) goto L_0x002b
            r2 = r1
            goto L_0x001d
        L_0x002b:
            if (r1 == r3) goto L_0x0039
            int[] r4 = r5.variables
            r4 = r4[r1]
            if (r4 != r6) goto L_0x0039
            r6 = r0[r1]
            r0[r2] = r6
            r0[r1] = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.SolverVariableValues.removeFromHashMap(androidx.constraintlayout.solver.SolverVariable):void");
    }

    public void add(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = epsilon;
        if (f10 <= (-f11) || f10 >= f11) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f10);
                return;
            }
            float[] fArr = this.values;
            float f12 = fArr[indexOf] + f10;
            fArr[indexOf] = f12;
            float f13 = epsilon;
            if (f12 > (-f13) && f12 < f13) {
                fArr[indexOf] = 0.0f;
                remove(solverVariable, z10);
            }
        }
    }

    public void clear() {
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i12 = 0; i12 < this.SIZE; i12++) {
            this.variables[i12] = -1;
            this.nextKeys[i12] = -1;
        }
        for (int i13 = 0; i13 < this.HASH_SIZE; i13++) {
            this.keys[i13] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    public boolean contains(SolverVariable solverVariable) {
        if (indexOf(solverVariable) != -1) {
            return true;
        }
        return false;
    }

    public void display() {
        int i10 = this.mCount;
        System.out.print("{ ");
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i11) + " ");
            }
        }
        System.out.println(" }");
    }

    public void divideByAmount(float f10) {
        int i10 = this.mCount;
        int i11 = this.head;
        int i12 = 0;
        while (i12 < i10) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.next[i11];
            if (i11 != -1) {
                i12++;
            } else {
                return;
            }
        }
    }

    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.mCount;
    }

    public SolverVariable getVariable(int i10) {
        int i11 = this.mCount;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i12]];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    public float getVariableValue(int i10) {
        int i11 = this.mCount;
        int i12 = this.head;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.values[i12];
            }
            i12 = this.next[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0031 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int indexOf(androidx.constraintlayout.solver.SolverVariable r4) {
        /*
            r3 = this;
            int r0 = r3.mCount
            r1 = -1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r4 = r4.f14684id
            int r0 = r3.HASH_SIZE
            int r0 = r4 % r0
            int[] r2 = r3.keys
            r0 = r2[r0]
            if (r0 != r1) goto L_0x0013
            return r1
        L_0x0013:
            int[] r2 = r3.variables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x001a
            return r0
        L_0x001a:
            int[] r2 = r3.nextKeys
            r0 = r2[r0]
            if (r0 == r1) goto L_0x0027
            int[] r2 = r3.variables
            r2 = r2[r0]
            if (r2 == r4) goto L_0x0027
            goto L_0x001a
        L_0x0027:
            if (r0 != r1) goto L_0x002a
            return r1
        L_0x002a:
            int[] r2 = r3.variables
            r2 = r2[r0]
            if (r2 != r4) goto L_0x0031
            return r0
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.SolverVariableValues.indexOf(androidx.constraintlayout.solver.SolverVariable):int");
    }

    public void invert() {
        int i10 = this.mCount;
        int i11 = this.head;
        int i12 = 0;
        while (i12 < i10) {
            float[] fArr = this.values;
            fArr[i11] = fArr[i11] * -1.0f;
            i11 = this.next[i11];
            if (i11 != -1) {
                i12++;
            } else {
                return;
            }
        }
    }

    public void put(SolverVariable solverVariable, float f10) {
        float f11 = epsilon;
        if (f10 <= (-f11) || f10 >= f11) {
            if (this.mCount == 0) {
                addVariable(0, solverVariable, f10);
                addToHashMap(solverVariable, 0);
                this.head = 0;
                return;
            }
            int indexOf = indexOf(solverVariable);
            if (indexOf != -1) {
                this.values[indexOf] = f10;
                return;
            }
            if (this.mCount + 1 >= this.SIZE) {
                increaseSize();
            }
            int i10 = this.mCount;
            int i11 = this.head;
            int i12 = -1;
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = this.variables[i11];
                int i15 = solverVariable.f14684id;
                if (i14 == i15) {
                    this.values[i11] = f10;
                    return;
                }
                if (i14 < i15) {
                    i12 = i11;
                }
                i11 = this.next[i11];
                if (i11 == -1) {
                    break;
                }
            }
            insertVariable(i12, solverVariable, f10);
            return;
        }
        remove(solverVariable, true);
    }

    public float remove(SolverVariable solverVariable, boolean z10) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f10 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        int i10 = iArr[indexOf];
        if (i10 != -1) {
            int[] iArr2 = this.next;
            iArr2[i10] = iArr2[indexOf];
        }
        int i11 = this.next[indexOf];
        if (i11 != -1) {
            iArr[i11] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z10) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f10;
    }

    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i10 = this.mCount;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable variable = getVariable(i11);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i11) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.previous[indexOf] != -1) {
                    str = str5 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]];
                } else {
                    str = str5 + DevicePublicKeyStringDef.NONE;
                }
                String str6 = str + ", n: ";
                if (this.next[indexOf] != -1) {
                    str2 = str6 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]];
                } else {
                    str2 = str6 + DevicePublicKeyStringDef.NONE;
                }
                str3 = str2 + "]";
            }
        }
        return str3 + " }";
    }

    public float use(ArrayRow arrayRow, boolean z10) {
        float f10 = get(arrayRow.variable);
        remove(arrayRow.variable, z10);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i10 = 0;
        int i11 = 0;
        while (i10 < currentSize) {
            int i12 = solverVariableValues.variables[i11];
            if (i12 != -1) {
                add(this.mCache.mIndexedVariables[i12], solverVariableValues.values[i11] * f10, z10);
                i10++;
            }
            i11++;
        }
        return f10;
    }
}
