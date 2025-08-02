package androidx.credentials;

public interface CredentialManagerCallback<R, E> {
    void onError(E e10);

    void onResult(R r10);
}
