package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

abstract class e {
    static Executor a() {
        return new f(Executors.newSingleThreadExecutor());
    }
}
