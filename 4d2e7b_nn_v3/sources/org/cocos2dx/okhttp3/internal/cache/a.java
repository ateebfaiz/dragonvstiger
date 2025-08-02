package org.cocos2dx.okhttp3.internal.cache;

import java.io.IOException;
import org.cocos2dx.okio.Buffer;
import org.cocos2dx.okio.ForwardingSink;
import org.cocos2dx.okio.Sink;

abstract class a extends ForwardingSink {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1583a;

    a(Sink sink) {
        super(sink);
    }

    /* access modifiers changed from: protected */
    public abstract void a(IOException iOException);

    public void close() {
        if (!this.f1583a) {
            try {
                super.close();
            } catch (IOException e10) {
                this.f1583a = true;
                a(e10);
            }
        }
    }

    public void flush() {
        if (!this.f1583a) {
            try {
                super.flush();
            } catch (IOException e10) {
                this.f1583a = true;
                a(e10);
            }
        }
    }

    public void write(Buffer buffer, long j10) {
        if (this.f1583a) {
            buffer.skip(j10);
            return;
        }
        try {
            super.write(buffer, j10);
        } catch (IOException e10) {
            this.f1583a = true;
            a(e10);
        }
    }
}
