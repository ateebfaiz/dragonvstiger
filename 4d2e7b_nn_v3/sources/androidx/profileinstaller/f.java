package androidx.profileinstaller;

enum f {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    

    /* renamed from: a  reason: collision with root package name */
    private final long f16092a;

    private f(long j10) {
        this.f16092a = j10;
    }

    public long b() {
        return this.f16092a;
    }
}
