package a;

import com.geetest.core.k;

public enum d {
    WAIT(1),
    SUCCESS(0),
    NDK_INIT_ERROR(-1),
    NDK_RESTART(-2),
    NDK_OTHER_ERROR(-3),
    SDK_PARA_ERROR(-4),
    SDK_RESTART(-5),
    RUN_IN_MAIN_THREAD_ERROR(-6),
    NDK_START_TIMEOUT(-7),
    UNKNOWN_ERROR(-100);
    

    /* renamed from: a  reason: collision with root package name */
    public final int f13574a;

    /* access modifiers changed from: public */
    d(int i10) {
        this.f13574a = i10;
    }

    public static d a(int i10) {
        switch (i10) {
            case k.CODE_SYSTEM_TOO_OLD:
                return NDK_START_TIMEOUT;
            case k.CODE_DEVICEIDS_UNAVAILABLE:
                return RUN_IN_MAIN_THREAD_ERROR;
            case k.CODE_STRONGBOX_UNAVAILABLE:
                return SDK_RESTART;
            case -4:
                return SDK_PARA_ERROR;
            case -3:
                return NDK_OTHER_ERROR;
            case -2:
                return NDK_RESTART;
            case -1:
                return NDK_INIT_ERROR;
            case 0:
                return SUCCESS;
            case 1:
                return WAIT;
            default:
                return UNKNOWN_ERROR;
        }
    }
}
