package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;
    int currentSize = 0;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    protected final Cache mCache;
    private boolean mDidFillOnce = false;
    private int mHead = -1;
    private int mLast = -1;
    private final ArrayRow mRow;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    public void add(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = epsilon;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.mHead;
            if (i10 == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f10;
                this.mArrayIndices[0] = solverVariable.f14684id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (!this.mDidFillOnce) {
                    int i11 = this.mLast + 1;
                    this.mLast = i11;
                    int[] iArr = this.mArrayIndices;
                    if (i11 >= iArr.length) {
                        this.mDidFillOnce = true;
                        this.mLast = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = 0;
            int i13 = -1;
            while (i10 != -1 && i12 < this.currentSize) {
                int i14 = this.mArrayIndices[i10];
                int i15 = solverVariable.f14684id;
                if (i14 == i15) {
                    float[] fArr = this.mArrayValues;
                    float f12 = fArr[i10] + f10;
                    float f13 = epsilon;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i10];
                        } else {
                            int[] iArr2 = this.mArrayNextIndices;
                            iArr2[i13] = iArr2[i10];
                        }
                        if (z10) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i10;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (i14 < i15) {
                    i13 = i10;
                }
                i10 = this.mArrayNextIndices[i10];
                i12++;
            }
            int i16 = this.mLast;
            int i17 = i16 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i16 >= iArr4.length && this.currentSize < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i18 >= iArr5.length) {
                        break;
                    } else if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.ROW_SIZE * 2;
                this.ROW_SIZE = i19;
                this.mDidFillOnce = false;
                this.mLast = i16 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i19);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i16] = solverVariable.f14684id;
            this.mArrayValues[i16] = f10;
            if (i13 != -1) {
                int[] iArr7 = this.mArrayNextIndices;
                iArr7[i16] = iArr7[i13];
                iArr7[i13] = i16;
            } else {
                this.mArrayNextIndices[i16] = this.mHead;
                this.mHead = i16;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i20 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i20 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    public final void clear() {
        int i10 = this.mHead;
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i10]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    public boolean contains(SolverVariable solverVariable) {
        int i10 = this.mHead;
        if (i10 == -1) {
            return false;
        }
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayIndices[i10] == solverVariable.f14684id) {
                return true;
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return false;
    }

    public void display() {
        int i10 = this.currentSize;
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
        int i10 = this.mHead;
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
    }

    public final float get(SolverVariable solverVariable) {
        int i10 = this.mHead;
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayIndices[i10] == solverVariable.f14684id) {
                return this.mArrayValues[i10];
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return 0.0f;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i10) {
        return this.mArrayIndices[i10];
    }

    public final int getNextIndice(int i10) {
        return this.mArrayNextIndices[i10];
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i10 = this.mHead;
        int i11 = 0;
        SolverVariable solverVariable2 = null;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayValues[i10] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i10]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return solverVariable2;
    }

    public final float getValue(int i10) {
        return this.mArrayValues[i10];
    }

    public SolverVariable getVariable(int i10) {
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.currentSize) {
            if (i12 == i10) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i11]];
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return null;
    }

    public float getVariableValue(int i10) {
        int i11 = this.mHead;
        int i12 = 0;
        while (i11 != -1 && i12 < this.currentSize) {
            if (i12 == i10) {
                return this.mArrayValues[i11];
            }
            i11 = this.mArrayNextIndices[i11];
            i12++;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean hasAtLeastOnePositiveVariable() {
        int i10 = this.mHead;
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayValues[i10] > 0.0f) {
                return true;
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return false;
    }

    public int indexOf(SolverVariable solverVariable) {
        int i10 = this.mHead;
        if (i10 == -1) {
            return -1;
        }
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayIndices[i10] == solverVariable.f14684id) {
                return i10;
            }
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return -1;
    }

    public void invert() {
        int i10 = this.mHead;
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            float[] fArr = this.mArrayValues;
            fArr[i10] = fArr[i10] * -1.0f;
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
    }

    public final void put(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i10 = this.mHead;
        if (i10 == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f10;
            this.mArrayIndices[0] = solverVariable.f14684id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                int i11 = this.mLast + 1;
                this.mLast = i11;
                int[] iArr = this.mArrayIndices;
                if (i11 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = 0;
        int i13 = -1;
        while (i10 != -1 && i12 < this.currentSize) {
            int i14 = this.mArrayIndices[i10];
            int i15 = solverVariable.f14684id;
            if (i14 == i15) {
                this.mArrayValues[i10] = f10;
                return;
            }
            if (i14 < i15) {
                i13 = i10;
            }
            i10 = this.mArrayNextIndices[i10];
            i12++;
        }
        int i16 = this.mLast;
        int i17 = i16 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i16] != -1) {
                i16 = iArr2.length;
            }
        } else {
            i16 = i17;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i16 >= iArr3.length && this.currentSize < iArr3.length) {
            int i18 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i18 >= iArr4.length) {
                    break;
                } else if (iArr4[i18] == -1) {
                    i16 = i18;
                    break;
                } else {
                    i18++;
                }
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i16 >= iArr5.length) {
            i16 = iArr5.length;
            int i19 = this.ROW_SIZE * 2;
            this.ROW_SIZE = i19;
            this.mDidFillOnce = false;
            this.mLast = i16 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i19);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i16] = solverVariable.f14684id;
        this.mArrayValues[i16] = f10;
        if (i13 != -1) {
            int[] iArr6 = this.mArrayNextIndices;
            iArr6[i16] = iArr6[i13];
            iArr6[i13] = i16;
        } else {
            this.mArrayNextIndices[i16] = this.mHead;
            this.mHead = i16;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i20 = this.currentSize + 1;
        this.currentSize = i20;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i20 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z10) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i10 = this.mHead;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.currentSize) {
            if (this.mArrayIndices[i10] == solverVariable.f14684id) {
                if (i10 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i10];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i10] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i10;
                }
                return this.mArrayValues[i10];
            }
            i11++;
            i12 = i10;
            i10 = this.mArrayNextIndices[i10];
        }
        return 0.0f;
    }

    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i10 = this.mHead;
        String str = "";
        int i11 = 0;
        while (i10 != -1 && i11 < this.currentSize) {
            str = ((str + " -> ") + this.mArrayValues[i10] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i10]];
            i10 = this.mArrayNextIndices[i10];
            i11++;
        }
        return str;
    }

    public float use(ArrayRow arrayRow, boolean z10) {
        float f10 = get(arrayRow.variable);
        remove(arrayRow.variable, z10);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize2 = arrayRowVariables.getCurrentSize();
        for (int i10 = 0; i10 < currentSize2; i10++) {
            SolverVariable variable = arrayRowVariables.getVariable(i10);
            add(variable, arrayRowVariables.get(variable) * f10, z10);
        }
        return f10;
    }
}
