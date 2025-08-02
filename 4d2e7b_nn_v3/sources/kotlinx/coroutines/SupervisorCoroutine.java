package kotlinx.coroutines;

import kotlinx.coroutines.internal.ScopeCoroutine;

final class SupervisorCoroutine<T> extends ScopeCoroutine<T> {
    public boolean Q(Throwable th) {
        return false;
    }
}
