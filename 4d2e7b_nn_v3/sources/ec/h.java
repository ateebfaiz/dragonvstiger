package ec;

public abstract class h implements Runnable {
    public long submissionTime;
    public i taskContext;

    public h(long j10, i iVar) {
        this.submissionTime = j10;
        this.taskContext = iVar;
    }

    public h() {
        this(0, l.f212g);
    }
}
