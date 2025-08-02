package ec;

import kotlinx.coroutines.f0;

public final class k extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f205a;

    public k(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f205a = runnable;
    }

    public void run() {
        try {
            this.f205a.run();
        } finally {
            this.taskContext.a();
        }
    }

    public String toString() {
        return "Task[" + f0.a(this.f205a) + '@' + f0.b(this.f205a) + ", " + this.submissionTime + ", " + this.taskContext + ']';
    }
}
