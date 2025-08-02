package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE = 128;
    b accessor = new b(this);
    private SolverVariable[] arrayGoals = new SolverVariable[128];
    Cache mCache;
    private int numGoals = 0;
    private SolverVariable[] sortArray = new SolverVariable[128];

    class a implements Comparator {
        a() {
        }

        /* renamed from: a */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f14684id - solverVariable2.f14684id;
        }
    }

    class b implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f14681a;

        /* renamed from: b  reason: collision with root package name */
        PriorityGoalRow f14682b;

        public b(PriorityGoalRow priorityGoalRow) {
            this.f14682b = priorityGoalRow;
        }

        public boolean a(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (this.f14681a.inGoal) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr = this.f14681a.goalStrengthVector;
                    float f11 = fArr[i10] + (solverVariable.goalStrengthVector[i10] * f10);
                    fArr[i10] = f11;
                    if (Math.abs(f11) < 1.0E-4f) {
                        this.f14681a.goalStrengthVector[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    PriorityGoalRow.this.removeGoal(this.f14681a);
                }
                return false;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float f12 = solverVariable.goalStrengthVector[i11];
                if (f12 != 0.0f) {
                    float f13 = f12 * f10;
                    if (Math.abs(f13) < 1.0E-4f) {
                        f13 = 0.0f;
                    }
                    this.f14681a.goalStrengthVector[i11] = f13;
                } else {
                    this.f14681a.goalStrengthVector[i11] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f14681a = solverVariable;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f14681a.goalStrengthVector[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public int compareTo(Object obj) {
            return this.f14681a.f14684id - ((SolverVariable) obj).f14684id;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.goalStrengthVector[i10];
                float f11 = this.f14681a.goalStrengthVector[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f14681a.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f14681a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f14681a.goalStrengthVector[i10] + " ";
                }
            }
            return str + "] " + this.f14681a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i10;
        int i11 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.arrayGoals = solverVariableArr2;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i12 = this.numGoals;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.numGoals = i13;
        if (i13 > 1 && solverVariableArr3[i12].f14684id > solverVariable.f14684id) {
            int i14 = 0;
            while (true) {
                i10 = this.numGoals;
                if (i14 >= i10) {
                    break;
                }
                this.sortArray[i14] = this.arrayGoals[i14];
                i14++;
            }
            Arrays.sort(this.sortArray, 0, i10, new a());
            for (int i15 = 0; i15 < this.numGoals; i15++) {
                this.arrayGoals[i15] = this.sortArray[i15];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.numGoals) {
            if (this.arrayGoals[i10] == solverVariable) {
                while (true) {
                    int i11 = this.numGoals;
                    if (i10 < i11 - 1) {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i12 = i10 + 1;
                        solverVariableArr[i10] = solverVariableArr[i12];
                        i10 = i12;
                    } else {
                        this.numGoals = i11 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                }
            } else {
                i10++;
            }
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.accessor.b(solverVariable);
        this.accessor.e();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.numGoals; i11++) {
            SolverVariable solverVariable = this.arrayGoals[i11];
            if (!zArr[solverVariable.f14684id]) {
                this.accessor.b(solverVariable);
                if (i10 == -1) {
                    if (!this.accessor.c()) {
                    }
                } else if (!this.accessor.d(this.arrayGoals[i10])) {
                }
                i10 = i11;
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.arrayGoals[i10];
    }

    public String toString() {
        String str = "" + " goal -> (" + this.constantValue + ") : ";
        for (int i10 = 0; i10 < this.numGoals; i10++) {
            this.accessor.b(this.arrayGoals[i10]);
            str = str + this.accessor + " ";
        }
        return str;
    }

    public void updateFromRow(ArrayRow arrayRow, boolean z10) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable != null) {
            ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
            int currentSize = arrayRowVariables.getCurrentSize();
            for (int i10 = 0; i10 < currentSize; i10++) {
                SolverVariable variable = arrayRowVariables.getVariable(i10);
                float variableValue = arrayRowVariables.getVariableValue(i10);
                this.accessor.b(variable);
                if (this.accessor.a(solverVariable, variableValue)) {
                    addToGoal(variable);
                }
                this.constantValue += arrayRow.constantValue * variableValue;
            }
            removeGoal(solverVariable);
        }
    }
}
