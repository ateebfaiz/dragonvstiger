package androidx.core.app;

public interface OnUserLeaveHintProvider {
    void addOnUserLeaveHintListener(Runnable runnable);

    void removeOnUserLeaveHintListener(Runnable runnable);
}
