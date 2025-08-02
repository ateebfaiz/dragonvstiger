package com.alibaba.pdns.t;

import java.util.concurrent.Executor;

public interface b extends Executor {
    void a(Runnable runnable);

    void a(Runnable runnable, long j10);
}
