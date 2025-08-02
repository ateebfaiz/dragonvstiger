package androidx.constraintlayout.solver;

public class Cache {
    a arrayRowPool = new b(256);
    SolverVariable[] mIndexedVariables = new SolverVariable[32];
    a optimizedArrayRowPool = new b(256);
    a solverVariablePool = new b(256);
}
