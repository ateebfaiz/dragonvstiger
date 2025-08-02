package com.facebook.react.bridge;

public interface UIManagerListener {
    void didDispatchMountItems(UIManager uIManager);

    void didMountItems(UIManager uIManager);

    void didScheduleMountItems(UIManager uIManager);

    void willDispatchViewUpdates(UIManager uIManager);

    void willMountItems(UIManager uIManager);
}
