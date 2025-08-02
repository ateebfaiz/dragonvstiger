package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = true;
    private static int POOL_SIZE = 1000;
    static final boolean SIMPLIFY_SYNONYMS = false;
    private static final boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE;
    public boolean graphOptimizer;
    private boolean[] mAlreadyTestedCandidates;
    final Cache mCache;
    private a mGoal;
    private int mMaxColumns;
    private int mMaxRows;
    int mNumColumns;
    int mNumRows;
    private SolverVariable[] mPoolVariables;
    private int mPoolVariablesCount;
    ArrayRow[] mRows;
    private a mTempGoal;
    private HashMap<String, SolverVariable> mVariables;
    int mVariablesID;
    public boolean newgraphOptimizer;

    interface a {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(a aVar);
    }

    class b extends ArrayRow {
        public b(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.mVariablesID = 0;
        this.mVariables = null;
        this.TABLE_SIZE = 32;
        this.mMaxColumns = 32;
        this.mRows = null;
        this.graphOptimizer = false;
        this.newgraphOptimizer = false;
        this.mAlreadyTestedCandidates = new boolean[32];
        this.mNumColumns = 1;
        this.mNumRows = 0;
        this.mMaxRows = 32;
        this.mPoolVariables = new SolverVariable[POOL_SIZE];
        this.mPoolVariablesCount = 0;
        this.mRows = new ArrayRow[32];
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new b(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable solverVariable = (SolverVariable) this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, str);
            solverVariable.setType(type, str);
        } else {
            solverVariable.reset();
            solverVariable.setType(type, str);
        }
        int i10 = this.mPoolVariablesCount;
        int i11 = POOL_SIZE;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            POOL_SIZE = i12;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i12);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i13 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i13 + 1;
        solverVariableArr[i13] = solverVariable;
        return solverVariable;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRow) {
        if (OPTIMIZED_ENGINE) {
            ArrayRow arrayRow2 = this.mRows[this.mNumRows];
            if (arrayRow2 != null) {
                this.mCache.optimizedArrayRowPool.release(arrayRow2);
            }
        } else {
            ArrayRow arrayRow3 = this.mRows[this.mNumRows];
            if (arrayRow3 != null) {
                this.mCache.arrayRowPool.release(arrayRow3);
            }
        }
        ArrayRow[] arrayRowArr = this.mRows;
        int i10 = this.mNumRows;
        arrayRowArr[i10] = arrayRow;
        SolverVariable solverVariable = arrayRow.variable;
        solverVariable.definitionId = i10;
        this.mNumRows = i10 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    private void addSingleError(ArrayRow arrayRow, int i10) {
        addSingleError(arrayRow, i10, 0);
    }

    private void computeValues() {
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            arrayRow.variable.computedValue = arrayRow.constantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f10);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, (String) null);
        acquireSolverVariable.setName(str);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        acquireSolverVariable.f14684id = i10;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            str = (str + this.mRows[i10]) + "\n";
        }
        System.out.println(str + this.mGoal + "\n");
    }

    private void displaySolverVariables() {
        System.out.println("Display Rows (" + this.mNumRows + "x" + this.mNumColumns + ")\n");
    }

    private int enforceBFS(a aVar) throws Exception {
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            ArrayRow arrayRow = this.mRows[i10];
            if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f10 = 0.0f;
                if (arrayRow.constantValue < 0.0f) {
                    boolean z10 = false;
                    int i11 = 0;
                    while (!z10) {
                        Metrics metrics = sMetrics;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i11++;
                        float f11 = Float.MAX_VALUE;
                        int i12 = -1;
                        int i13 = -1;
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            int i16 = 1;
                            if (i14 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i14];
                            if (arrayRow2.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.isSimpleDefinition && arrayRow2.constantValue < f10) {
                                while (i16 < this.mNumColumns) {
                                    SolverVariable solverVariable = this.mCache.mIndexedVariables[i16];
                                    float f12 = arrayRow2.variables.get(solverVariable);
                                    if (f12 > f10) {
                                        for (int i17 = 0; i17 < 9; i17++) {
                                            float f13 = solverVariable.strengthVector[i17] / f12;
                                            if ((f13 < f11 && i17 == i15) || i17 > i15) {
                                                i15 = i17;
                                                f11 = f13;
                                                i12 = i14;
                                                i13 = i16;
                                            }
                                        }
                                    }
                                    i16++;
                                    f10 = 0.0f;
                                }
                            }
                            i14++;
                            f10 = 0.0f;
                        }
                        if (i12 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i12];
                            arrayRow3.variable.definitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots++;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i13]);
                            SolverVariable solverVariable2 = arrayRow3.variable;
                            solverVariable2.definitionId = i12;
                            solverVariable2.updateReferencesWithNewDefinition(arrayRow3);
                        } else {
                            z10 = true;
                        }
                        if (i11 > this.mNumColumns / 2) {
                            z10 = true;
                        }
                        f10 = 0.0f;
                    }
                    return i11;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i10) {
        int i11 = i10 * 4;
        int i12 = i11 / 1024;
        int i13 = i12 / 1024;
        if (i13 > 0) {
            return "" + i13 + " Mb";
        } else if (i12 > 0) {
            return "" + i12 + " Kb";
        } else {
            return "" + i11 + " bytes";
        }
    }

    private String getDisplayStrength(int i10) {
        if (i10 == 1) {
            return "LOW";
        }
        if (i10 == 2) {
            return "MEDIUM";
        }
        if (i10 == 3) {
            return "HIGH";
        }
        if (i10 == 4) {
            return "HIGHEST";
        }
        if (i10 == 5) {
            return "EQUALITY";
        }
        if (i10 == 8) {
            return "FIXED";
        }
        if (i10 == 6) {
            return "BARRIER";
        }
        return "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i10 = this.TABLE_SIZE * 2;
        this.TABLE_SIZE = i10;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i10);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        int i11 = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[i11];
        this.mMaxColumns = i11;
        this.mMaxRows = i11;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, (long) i11);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int optimize(a aVar, boolean z10) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i10 = 0; i10 < this.mNumColumns; i10++) {
            this.mAlreadyTestedCandidates[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i11++;
            if (i11 >= this.mNumColumns * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.mAlreadyTestedCandidates[aVar.getKey().f14684id] = true;
            }
            SolverVariable pivotCandidate = aVar.getPivotCandidate(this, this.mAlreadyTestedCandidates);
            if (pivotCandidate != null) {
                boolean[] zArr = this.mAlreadyTestedCandidates;
                int i12 = pivotCandidate.f14684id;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (pivotCandidate != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.mNumRows; i14++) {
                    ArrayRow arrayRow = this.mRows[i14];
                    if (arrayRow.variable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.isSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                        float f11 = arrayRow.variables.get(pivotCandidate);
                        if (f11 < 0.0f) {
                            float f12 = (-arrayRow.constantValue) / f11;
                            if (f12 < f10) {
                                i13 = i14;
                                f10 = f12;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    ArrayRow arrayRow2 = this.mRows[i13];
                    arrayRow2.variable.definitionId = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.pivot(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.variable;
                    solverVariable.definitionId = i13;
                    solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    private void releaseRows() {
        int i10 = 0;
        if (OPTIMIZED_ENGINE) {
            while (true) {
                ArrayRow[] arrayRowArr = this.mRows;
                if (i10 < arrayRowArr.length) {
                    ArrayRow arrayRow = arrayRowArr[i10];
                    if (arrayRow != null) {
                        this.mCache.optimizedArrayRowPool.release(arrayRow);
                    }
                    this.mRows[i10] = null;
                    i10++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                ArrayRow[] arrayRowArr2 = this.mRows;
                if (i10 < arrayRowArr2.length) {
                    ArrayRow arrayRow2 = arrayRowArr2[i10];
                    if (arrayRow2 != null) {
                        this.mCache.arrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i10] = null;
                    i10++;
                } else {
                    return;
                }
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintWidget constraintWidget3 = constraintWidget;
        ConstraintWidget constraintWidget4 = constraintWidget2;
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget3.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget3.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget3.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget3.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget4.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget4.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget4.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget4.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d10 = (double) f10;
        SolverVariable solverVariable = createObjectVariable7;
        double d11 = (double) i10;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d10) * d11));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, solverVariable, (float) (Math.cos(d10) * d11));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        int i13 = i12;
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i13 != 8) {
            createRow.addError(this, i13);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable pickPivot;
        if (arrayRow != null) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.constraints++;
                if (arrayRow.isSimpleDefinition) {
                    metrics.simpleconstraints++;
                }
            }
            boolean z10 = true;
            if (this.mNumRows + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                increaseTableSize();
            }
            boolean z11 = false;
            if (!arrayRow.isSimpleDefinition) {
                arrayRow.updateFromSystem(this);
                if (!arrayRow.isEmpty()) {
                    arrayRow.ensurePositiveConstant();
                    if (arrayRow.chooseSubject(this)) {
                        SolverVariable createExtraVariable = createExtraVariable();
                        arrayRow.variable = createExtraVariable;
                        addRow(arrayRow);
                        this.mTempGoal.initFromRow(arrayRow);
                        optimize(this.mTempGoal, true);
                        if (createExtraVariable.definitionId == -1) {
                            if (arrayRow.variable == createExtraVariable && (pickPivot = arrayRow.pickPivot(createExtraVariable)) != null) {
                                Metrics metrics2 = sMetrics;
                                if (metrics2 != null) {
                                    metrics2.pivots++;
                                }
                                arrayRow.pivot(pickPivot);
                            }
                            if (!arrayRow.isSimpleDefinition) {
                                arrayRow.variable.updateReferencesWithNewDefinition(arrayRow);
                            }
                            this.mNumRows--;
                        }
                    } else {
                        z10 = false;
                    }
                    if (arrayRow.hasKeyVariable()) {
                        z11 = z10;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z11) {
                addRow(arrayRow);
            }
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (i11 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + ((float) i10));
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i10);
        if (i11 != 8) {
            createRow.addError(this, i11);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i10);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i10);
        if (i11 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i11);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i10);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i10);
        if (i11 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * -1.0f), i11);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            createRow.addError(this, i10);
        }
        addConstraint(createRow);
    }

    /* access modifiers changed from: package-private */
    public final void cleanupRows() {
        int i10;
        int i11 = 0;
        while (i11 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            if (arrayRow.isSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.variable;
                solverVariable.computedValue = arrayRow.constantValue;
                solverVariable.removeFromRow(arrayRow);
                int i12 = i11;
                while (true) {
                    i10 = this.mNumRows;
                    if (i12 >= i10 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i13 = i12 + 1;
                    arrayRowArr[i12] = arrayRowArr[i13];
                    i12 = i13;
                }
                this.mRows[i10 - 1] = null;
                this.mNumRows = i10 - 1;
                i11--;
            }
            i11++;
        }
    }

    public SolverVariable createErrorVariable(int i10, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i11 = this.mVariablesID + 1;
        this.mVariablesID = i11;
        this.mNumColumns++;
        acquireSolverVariable.f14684id = i11;
        acquireSolverVariable.strength = i10;
        this.mCache.mIndexedVariables[i11] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        acquireSolverVariable.f14684id = i10;
        this.mCache.mIndexedVariables[i10] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i10 = solverVariable.f14684id;
            if (i10 == -1 || i10 > this.mVariablesID || this.mCache.mIndexedVariables[i10] == null) {
                if (i10 != -1) {
                    solverVariable.reset();
                }
                int i11 = this.mVariablesID + 1;
                this.mVariablesID = i11;
                this.mNumColumns++;
                solverVariable.f14684id = i11;
                solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
                this.mCache.mIndexedVariables[i11] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = (ArrayRow) this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new b(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = (ArrayRow) this.mCache.arrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, (String) null);
        int i10 = this.mVariablesID + 1;
        this.mVariablesID = i10;
        this.mNumColumns++;
        acquireSolverVariable.f14684id = i10;
        this.mCache.mIndexedVariables[i10] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i10 = 0; i10 < this.mVariablesID; i10++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i10];
            if (solverVariable != null && solverVariable.isFinalValue) {
                str = str + " $[" + i10 + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String str2 = str + "\n\n #  ";
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            str2 = (str2 + this.mRows[i11].toReadableString()) + "\n #  ";
        }
        if (this.mGoal != null) {
            str2 = str2 + "Goal: " + this.mGoal + "\n";
        }
        System.out.println(str2);
    }

    /* access modifiers changed from: package-private */
    public void displaySystemInformations() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.TABLE_SIZE; i11++) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow != null) {
                i10 += arrayRow.sizeInBytes();
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.mNumRows; i13++) {
            ArrayRow arrayRow2 = this.mRows[i13];
            if (arrayRow2 != null) {
                i12 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Linear System -> Table size: ");
        sb2.append(this.TABLE_SIZE);
        sb2.append(" (");
        int i14 = this.TABLE_SIZE;
        sb2.append(getDisplaySize(i14 * i14));
        sb2.append(") -- row sizes: ");
        sb2.append(getDisplaySize(i10));
        sb2.append(", actual size: ");
        sb2.append(getDisplaySize(i12));
        sb2.append(" rows: ");
        sb2.append(this.mNumRows);
        sb2.append(DomExceptionUtils.SEPARATOR);
        sb2.append(this.mMaxRows);
        sb2.append(" cols: ");
        sb2.append(this.mNumColumns);
        sb2.append(DomExceptionUtils.SEPARATOR);
        sb2.append(this.mMaxColumns);
        sb2.append(" ");
        sb2.append(0);
        sb2.append(" occupied cells, ");
        sb2.append(getDisplaySize(0));
        printStream.println(sb2.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            if (this.mRows[i10].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.mRows[i10].toReadableString()) + "\n";
            }
        }
        System.out.println(str + this.mGoal + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    /* access modifiers changed from: package-private */
    public a getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow != null) {
                i10 += arrayRow.sizeInBytes();
            }
        }
        return i10;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ArrayRow getRow(int i10) {
        return this.mRows[i10];
    }

    /* access modifiers changed from: package-private */
    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    /* access modifiers changed from: package-private */
    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        if (solverVariable == null) {
            return createVariable(str, type);
        }
        return solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.graphOptimizer || this.newgraphOptimizer) {
            if (metrics != null) {
                metrics.graphOptimizer++;
            }
            for (int i10 = 0; i10 < this.mNumRows; i10++) {
                if (!this.mRows[i10].isSimpleDefinition) {
                    minimizeGoal(this.mGoal);
                    return;
                }
            }
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.fullySolved++;
            }
            computeValues();
            return;
        }
        minimizeGoal(this.mGoal);
    }

    /* access modifiers changed from: package-private */
    public void minimizeGoal(a aVar) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long) this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, (long) this.mNumRows);
        }
        enforceBFS(aVar);
        optimize(aVar, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i10;
        if (arrayRow.isSimpleDefinition && (solverVariable = arrayRow.variable) != null) {
            int i11 = solverVariable.definitionId;
            if (i11 != -1) {
                while (true) {
                    i10 = this.mNumRows;
                    if (i11 >= i10 - 1) {
                        break;
                    }
                    ArrayRow[] arrayRowArr = this.mRows;
                    int i12 = i11 + 1;
                    arrayRowArr[i11] = arrayRowArr[i12];
                    i11 = i12;
                }
                this.mNumRows = i10 - 1;
            }
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        }
    }

    public void reset() {
        Cache cache;
        int i10 = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i10++;
        }
        cache.solverVariablePool.a(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            this.mRows[i11].used = false;
        }
        releaseRows();
        this.mNumRows = 0;
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new b(this.mCache);
        } else {
            this.mTempGoal = new ArrayRow(this.mCache);
        }
    }

    /* access modifiers changed from: package-private */
    public void addSingleError(ArrayRow arrayRow, int i10, int i11) {
        arrayRow.addSingleError(createErrorVariable(i11, (String) null), i10);
    }

    public void addEquality(SolverVariable solverVariable, int i10) {
        int i11 = solverVariable.definitionId;
        if (i11 == -1) {
            solverVariable.setFinalValue(this, (float) i10);
        } else if (i11 != -1) {
            ArrayRow arrayRow = this.mRows[i11];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = (float) i10;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = (float) i10;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i10);
                addConstraint(createRow);
            }
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowDefinition(solverVariable, i10);
            addConstraint(createRow2);
        }
    }
}
