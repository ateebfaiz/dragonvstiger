package com.alibaba.pdns.pools;

public interface Callback {

    public static class CancelledException extends RuntimeException {
        public CancelledException(String str) {
            super(str);
        }
    }

    public interface a {
        boolean a();

        void b();
    }

    public interface b<ItemType> extends Callback {
        void a();

        void a(ItemType itemtype);

        void a(ItemType itemtype, CancelledException cancelledException);

        void a(ItemType itemtype, Throwable th, boolean z10);

        void b(ItemType itemtype);
    }
}
