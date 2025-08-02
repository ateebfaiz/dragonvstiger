package com.google.android.games.paddleboat;

import android.hardware.input.InputManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class GameControllerThread extends Thread implements InputManager.InputDeviceListener {
    private static final String TAG = "GameControllerThread";
    private boolean activeInputDeviceListener = false;
    private GameControllerManager mGameControllerManager;
    private Handler mHandler;

    public void onInputDeviceAdded(int i10) {
        Log.d(TAG, "onInputDeviceAdded id: " + i10);
        this.mGameControllerManager.onInputDeviceAdded(i10);
    }

    public void onInputDeviceChanged(int i10) {
        Log.d(TAG, "onInputDeviceChanged id: " + i10);
        this.mGameControllerManager.onInputDeviceChanged(i10);
    }

    public void onInputDeviceRemoved(int i10) {
        Log.d(TAG, "onInputDeviceRemoved id: " + i10);
        this.mGameControllerManager.onInputDeviceRemoved(i10);
    }

    public void onStart() {
        if (!this.activeInputDeviceListener) {
            Log.d(TAG, "registerInputDeviceListener");
            this.mGameControllerManager.getAppInputManager().registerInputDeviceListener(this, this.mHandler);
            this.activeInputDeviceListener = true;
        }
    }

    public void onStop() {
        if (this.activeInputDeviceListener) {
            Log.d(TAG, "unregisterInputDeviceListener");
            this.mGameControllerManager.getAppInputManager().unregisterInputDeviceListener(this);
            this.activeInputDeviceListener = false;
        }
    }

    public void run() {
        Looper.prepare();
        this.mHandler = new Handler(Looper.myLooper());
        onStart();
        Looper.loop();
    }

    public void setGameControllerManager(GameControllerManager gameControllerManager) {
        this.mGameControllerManager = gameControllerManager;
    }
}
