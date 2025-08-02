package v0;

public enum c {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");
    

    /* renamed from: a  reason: collision with root package name */
    public final String f24382a;

    private c(String str) {
        this.f24382a = str;
    }

    public String b() {
        return ".temp" + this.f24382a;
    }

    public String toString() {
        return this.f24382a;
    }
}
