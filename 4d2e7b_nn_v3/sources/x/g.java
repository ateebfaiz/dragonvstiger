package x;

public enum g {
    BYPASS_NONE(0, "None", false),
    BYPASS_SDK_DISABLED(1, "Sdk disabled", true),
    BYPASS_PROXY_EXIT(2, "Mahx exited", true),
    BYPASS_AUTH_FAILED(4, "Auth failed", true),
    BYPASS_NDK_CRASHED(8, "Ndk crashed", true),
    BYPASS_STOP(16, "Sdk stopped", true);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f24662a;

    /* renamed from: b  reason: collision with root package name */
    public final String f24663b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f24664c;

    /* access modifiers changed from: public */
    g(int i10, String str, boolean z10) {
        this.f24662a = i10;
        this.f24663b = str;
        this.f24664c = z10;
    }
}
