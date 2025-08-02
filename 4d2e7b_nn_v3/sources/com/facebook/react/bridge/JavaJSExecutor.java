package com.facebook.react.bridge;

import d6.a;

@a
public interface JavaJSExecutor {

    public interface Factory {
        JavaJSExecutor create() throws Exception;
    }

    public static class ProxyExecutorException extends Exception {
        public ProxyExecutorException(Throwable th) {
            super(th);
        }
    }

    void close();

    @a
    String executeJSCall(String str, String str2) throws ProxyExecutorException;

    @a
    void loadBundle(String str) throws ProxyExecutorException;

    @a
    void setGlobalVariable(String str, String str2);
}
