package com.google.android.games.paddleboat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.BatteryState;
import android.hardware.SensorManager;
import android.hardware.input.InputManager;
import android.hardware.lights.Light;
import android.hardware.lights.LightsManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.util.Log;
import android.view.InputDevice;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameControllerManager {
    public static final int DEVICEFLAG_ACCELEROMETER = 4194304;
    public static final int DEVICEFLAG_BATTERY = 67108864;
    public static final int DEVICEFLAG_GYROSCOPE = 8388608;
    public static final int DEVICEFLAG_LIGHT_PLAYER = 16777216;
    public static final int DEVICEFLAG_LIGHT_RGB = 33554432;
    public static final int DEVICEFLAG_VIBRATION = 134217728;
    public static final int DEVICEFLAG_VIBRATION_DUAL_MOTOR = 268435456;
    public static final int DEVICEFLAG_VIRTUAL_MOUSE = 1073741824;
    private static final String FINGERPRINT_DEVICE_NAME = "uinput-fpc";
    private static final int GAMECONTROLLER_SOURCE_MASK = 16778769;
    public static final int LIGHT_TYPE_PLAYER = 0;
    public static final int LIGHT_TYPE_RGB = 1;
    public static final int MAX_GAMECONTROLLERS = 8;
    public static final int MAX_MICE = 2;
    public static final int MOTION_ACCELEROMETER = 0;
    public static final int MOTION_GYROSCOPE = 1;
    private static final int MOUSE_SOURCE_MASK = 8194;
    private static final String TAG = "GameControllerManager";
    public static final int VIBRATION_EFFECT_MIN_API = 26;
    private static final int VIBRATOR_MANAGER_MIN_API = 31;
    private GameControllerThread gameControllerThread;
    private final ArrayList<GameControllerInfo> gameControllers;
    private final InputManager inputManager;
    private final ArrayList<Integer> mouseDeviceIds;
    private boolean nativeReady;
    private final ArrayList<Integer> pendingControllerDeviceIds;
    private final ArrayList<Integer> pendingMouseDeviceIds;
    private final boolean printControllerInfo;
    private boolean reportMotionEvents;

    public GameControllerManager(Context context, boolean z10) {
        if (z10) {
            Log.d(TAG, "device Info:\n  BRAND: " + Build.BRAND + "\n DEVICE: " + Build.DEVICE + "\n  MANUF: " + Build.MANUFACTURER + "\n  MODEL: " + Build.MODEL + "\nPRODUCT: " + Build.PRODUCT + "\n    API: " + Build.VERSION.SDK_INT);
        }
        this.nativeReady = false;
        this.reportMotionEvents = false;
        this.inputManager = (InputManager) context.getSystemService("input");
        this.printControllerInfo = z10;
        this.mouseDeviceIds = new ArrayList<>(8);
        this.pendingControllerDeviceIds = new ArrayList<>(8);
        this.pendingMouseDeviceIds = new ArrayList<>(8);
        this.gameControllers = new ArrayList<>(8);
        scanDevices();
    }

    private String generateSourceString(int i10) {
        String str = "Source Classes: ";
        if ((i10 & 1) != 0) {
            str = str + "BUTTON ";
        }
        if ((i10 & 16) != 0) {
            str = str + "JOYSTICK ";
        }
        if ((i10 & 2) != 0) {
            str = str + "POINTER ";
        }
        if ((i10 & 8) != 0) {
            str = str + "POSITION ";
        }
        if ((i10 & 4) != 0) {
            str = str + "TRACKBALL ";
        }
        String str2 = str + "\nSources: ";
        if ((49152 & i10) != 0) {
            str2 = str2 + "BLUETOOTH_STYLUS ";
        }
        if ((i10 & 512) != 0) {
            str2 = str2 + "DPAD ";
        }
        if ((33554432 & i10) != 0) {
            str2 = str2 + "HDMI ";
        }
        if ((16777216 & i10) != 0) {
            str2 = str2 + "JOYSTICK ";
        }
        if ((i10 & 256) != 0) {
            str2 = str2 + "KEYBOARD ";
        }
        if ((i10 & 8192) != 0) {
            str2 = str2 + "MOUSE ";
        }
        if ((131072 & i10) != 0) {
            str2 = str2 + "MOUSE_RELATIVE ";
        }
        if ((4194304 & i10) != 0) {
            str2 = str2 + "ROTARY_ENCODER ";
        }
        if ((i10 & 16384) != 0) {
            str2 = str2 + "STYLUS ";
        }
        if ((1048576 & i10) != 0) {
            str2 = str2 + "TOUCHPAD ";
        }
        if ((i10 & 4096) != 0) {
            str2 = str2 + "TOUCHSCREEN ";
        }
        if ((2097152 & i10) != 0) {
            str2 = str2 + "TOUCH_NAVIGATION ";
        }
        if ((i10 & 65536) == 0) {
            return str2;
        }
        return str2 + "TRACKBALL ";
    }

    private String getAxisString(int i10) {
        switch (i10) {
            case 0:
                return "AXIS_X";
            case 1:
                return "AXIS_Y";
            case 2:
                return "AXIS_PRESSURE";
            case 3:
                return "AXIS_SIZE";
            case 4:
                return "AXIS_TOUCH_MAJOR";
            case 5:
                return "AXIS_TOUCH_MINOR";
            case 6:
                return "AXIS_TOOL_MAJOR";
            case 7:
                return "AXIS_TOOL_MINOR";
            case 8:
                return "AXIS_ORIENTATION";
            case 9:
                return "AXIS_VSCROLL";
            case 10:
                return "AXIS_HSCROLL";
            case 11:
                return "AXIS_Z";
            case 12:
                return "AXIS_RX";
            case 13:
                return "AXIS_RY";
            case 14:
                return "AXIS_RZ";
            case 15:
                return "AXIS_HAT_X";
            case 16:
                return "AXIS_HAT_Y";
            case 17:
                return "AXIS_LTRIGGER";
            case 18:
                return "AXIS_RTRIGGER";
            case 19:
                return "AXIS_THROTTLE";
            case 20:
                return "AXIS_RUDDER";
            case 21:
                return "AXIS_WHEEL";
            case 22:
                return "AXIS_GAS";
            case 23:
                return "AXIS_BRAKE";
            case 24:
                return "AXIS_DISTANCE";
            case 25:
                return "AXIS_TILT";
            case 26:
                return "AXIS_SCROLL";
            case 27:
                return "AXIS_RELATIVE_X";
            case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                return "AXIS_RELATIVE_Y";
            case 32:
                return "AXIS_GENERIC_1";
            case MotionEventCompat.AXIS_GENERIC_2 /*33*/:
                return "AXIS_GENERIC_2";
            case 34:
                return "AXIS_GENERIC_3";
            case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                return "AXIS_GENERIC_4";
            case 36:
                return "AXIS_GENERIC_5";
            case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                return "AXIS_GENERIC_6";
            case MotionEventCompat.AXIS_GENERIC_7 /*38*/:
                return "AXIS_GENERIC_7";
            case MotionEventCompat.AXIS_GENERIC_8 /*39*/:
                return "AXIS_GENERIC_8";
            case MotionEventCompat.AXIS_GENERIC_9 /*40*/:
                return "AXIS_GENERIC_9";
            case MotionEventCompat.AXIS_GENERIC_10 /*41*/:
                return "AXIS_GENERIC_10";
            case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                return "AXIS_GENERIC_11";
            case MotionEventCompat.AXIS_GENERIC_12 /*43*/:
                return "AXIS_GENERIC_12";
            case MotionEventCompat.AXIS_GENERIC_13 /*44*/:
                return "AXIS_GENERIC_13";
            case MotionEventCompat.AXIS_GENERIC_14 /*45*/:
                return "AXIS_GENERIC_14";
            case MotionEventCompat.AXIS_GENERIC_15 /*46*/:
                return "AXIS_GENERIC_15";
            case MotionEventCompat.AXIS_GENERIC_16 /*47*/:
                return "AXIS_GENERIC_16";
            default:
                return "AXIS_NONE";
        }
    }

    public static int getControllerFlagsForDevice(InputDevice inputDevice) {
        int i10;
        int i11;
        if (isDeviceOfSource(inputDevice.getId(), 8194)) {
            i10 = 1073741824;
        } else {
            i10 = 0;
        }
        int vibratorCount = getVibratorCount(inputDevice);
        if (vibratorCount > 0) {
            int i12 = 134217728 | i10;
            if (vibratorCount > 1) {
                i10 |= 402653184;
            } else {
                i10 = i12;
            }
        }
        if (Build.VERSION.SDK_INT < VIBRATOR_MANAGER_MIN_API) {
            return i10;
        }
        SensorManager a10 = inputDevice.getSensorManager();
        if (a10 != null) {
            if (a10.getSensorList(1).size() > 0) {
                i10 |= 4194304;
            }
            if (a10.getSensorList(4).size() > 0) {
                i10 |= 8388608;
            }
        }
        LightsManager a11 = inputDevice.getLightsManager();
        if (a11 != null) {
            for (Object a12 : a11.getLights()) {
                Light a13 = r.a(a12);
                if (a13.getType() == 10002) {
                    i11 = 16777216;
                } else if (a13.hasRgbControl()) {
                    i11 = DEVICEFLAG_LIGHT_RGB;
                }
                i10 |= i11;
            }
        }
        BatteryState a14 = inputDevice.getBatteryState();
        if (a14 == null || !a14.isPresent()) {
            return i10;
        }
        return i10 | 67108864;
    }

    public static int getVibratorCount(InputDevice inputDevice) {
        Vibrator vibrator;
        int length;
        if (inputDevice == null) {
            return 0;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= VIBRATOR_MANAGER_MIN_API) {
            VibratorManager a10 = inputDevice.getVibratorManager();
            if (a10 == null || (length = a10.getVibratorIds().length) <= 0) {
                return 0;
            }
            return length;
        } else if (i10 < 26 || (vibrator = inputDevice.getVibrator()) == null || !vibrator.hasVibrator()) {
            return 0;
        } else {
            return 1;
        }
    }

    private static boolean isDeviceOfSource(int i10, int i11) {
        InputDevice device = InputDevice.getDevice(i10);
        int sources = device.getSources();
        int i12 = i11 & InputDeviceCompat.SOURCE_ANY;
        if (device.isVirtual() || (i12 & sources) == 0 || device.getMotionRanges().size() <= 0) {
            return false;
        }
        return true;
    }

    private void logControllerInfo(int i10) {
        InputDevice device = InputDevice.getDevice(i10);
        device.getControllerNumber();
        String descriptor = device.getDescriptor();
        String name = device.getName();
        int productId = device.getProductId();
        int sources = device.getSources();
        int vendorId = device.getVendorId();
        boolean hasVibrator = device.getVibrator().hasVibrator();
        boolean isVirtual = device.isVirtual();
        Log.d(TAG, "logControllerInfo\nfor deviceId: " + i10 + "\nname: " + name + "\ndescriptor: " + descriptor + "\nvendorId: " + vendorId + "\nproductId " + productId + "\nhasVibrator: " + hasVibrator + "\nisVirtual: " + isVirtual + "\n" + generateSourceString(sources));
        List<InputDevice.MotionRange> motionRanges = device.getMotionRanges();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Motion Range count: ");
        sb2.append(motionRanges.size());
        Log.d(TAG, sb2.toString());
        for (InputDevice.MotionRange logMotionRange : motionRanges) {
            logMotionRange(logMotionRange);
        }
    }

    private void logMotionRange(InputDevice.MotionRange motionRange) {
        String axisString = getAxisString(motionRange.getAxis());
        String generateSourceString = generateSourceString(motionRange.getSource());
        float flat = motionRange.getFlat();
        float fuzz = motionRange.getFuzz();
        float max = motionRange.getMax();
        float min = motionRange.getMin();
        float range = motionRange.getRange();
        float resolution = motionRange.getResolution();
        Log.d(TAG, "MotionRange:\n" + axisString + "\n" + generateSourceString + "\n   Axis Min   : " + min + "\n   Axis Max   : " + max + "\n   Axis Range : " + range + "\n   Axis Flat  : " + flat + "\n   Axis Fuzz  : " + fuzz + "\n   Axis Res   : " + resolution);
    }

    private void notifyNativeConnection(GameControllerInfo gameControllerInfo) {
        onControllerConnected(gameControllerInfo.GetGameControllerDeviceInfoArray(), gameControllerInfo.GetGameControllerAxisMinArray(), gameControllerInfo.GetGameControllerAxisMaxArray(), gameControllerInfo.GetGameControllerAxisFlatArray(), gameControllerInfo.GetGameControllerAxisFuzzArray());
    }

    @SuppressLint({"NewApi"})
    private void updateVibrator(Vibrator vibrator, int i10, int i11) {
        if (vibrator == null) {
            return;
        }
        if (i10 == 0) {
            vibrator.cancel();
        } else if (i11 > 0) {
            vibrator.vibrate(VibrationEffect.createOneShot((long) i11, i10));
        }
    }

    /* access modifiers changed from: package-private */
    public void checkForControllerRemovals(int[] iArr) {
        if (!this.nativeReady) {
            int i10 = 0;
            while (i10 < this.pendingControllerDeviceIds.size()) {
                int length = iArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        this.pendingControllerDeviceIds.remove(i10);
                        i10--;
                        break;
                    }
                    if (this.pendingControllerDeviceIds.get(i10).intValue() == iArr[i11]) {
                        break;
                    }
                    i11++;
                }
                i10++;
            }
        }
        for (int i12 = 0; i12 < this.gameControllers.size(); i12++) {
            int length2 = iArr.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    onInputDeviceRemoved(this.gameControllers.get(i12).GetGameControllerDeviceId());
                    break;
                }
                if (this.gameControllers.get(i12).GetGameControllerDeviceId() == iArr[i13]) {
                    break;
                }
                i13++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkForMouseRemovals(int[] iArr) {
        if (!this.nativeReady) {
            int i10 = 0;
            while (i10 < this.pendingMouseDeviceIds.size()) {
                int length = iArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        this.pendingMouseDeviceIds.remove(i10);
                        i10--;
                        break;
                    }
                    if (this.pendingMouseDeviceIds.get(i10).intValue() == iArr[i11]) {
                        break;
                    }
                    i11++;
                }
                i10++;
            }
        }
        for (int i12 = 0; i12 < this.mouseDeviceIds.size(); i12++) {
            int intValue = this.mouseDeviceIds.get(i12).intValue();
            int length2 = iArr.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length2) {
                    onInputDeviceRemoved(intValue);
                    break;
                } else if (intValue == iArr[i13]) {
                    break;
                } else {
                    i13++;
                }
            }
        }
    }

    public int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public InputManager getAppInputManager() {
        return this.inputManager;
    }

    public float getBatteryLevel(int i10) {
        InputDevice inputDevice;
        BatteryState a10;
        if (Build.VERSION.SDK_INT < VIBRATOR_MANAGER_MIN_API || (inputDevice = this.inputManager.getInputDevice(i10)) == null || (a10 = inputDevice.getBatteryState()) == null || !a10.isPresent()) {
            return 1.0f;
        }
        return a10.getCapacity();
    }

    public int getBatteryStatus(int i10) {
        InputDevice inputDevice;
        BatteryState a10;
        if (Build.VERSION.SDK_INT < VIBRATOR_MANAGER_MIN_API || (inputDevice = this.inputManager.getInputDevice(i10)) == null || (a10 = inputDevice.getBatteryState()) == null || !a10.isPresent()) {
            return 1;
        }
        return a10.getStatus();
    }

    public String getDeviceNameById(int i10) {
        InputDevice inputDevice = this.inputManager.getInputDevice(i10);
        if (inputDevice != null) {
            return inputDevice.getName();
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public boolean getIsGameController(int i10) {
        InputDevice device;
        if (!isDeviceOfSource(i10, GAMECONTROLLER_SOURCE_MASK) || (device = InputDevice.getDevice(i10)) == null || device.getName().equalsIgnoreCase(FINGERPRINT_DEVICE_NAME)) {
            return false;
        }
        return true;
    }

    public boolean getPrintControllerInfo() {
        return this.printControllerInfo;
    }

    public native void onControllerConnected(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public native void onControllerDisconnected(int i10);

    /* access modifiers changed from: package-private */
    public GameControllerInfo onGameControllerAdded(int i10) {
        if (this.gameControllers.size() >= 8) {
            return null;
        }
        if (this.printControllerInfo) {
            Log.d(TAG, "onGameControllerDeviceAdded");
            logControllerInfo(i10);
        }
        InputDevice device = InputDevice.getDevice(i10);
        GameControllerInfo gameControllerInfo = new GameControllerInfo(device);
        gameControllerInfo.SetListener(new GameControllerListener(this, device, gameControllerInfo.GetGameControllerFlags(), this.reportMotionEvents));
        this.gameControllers.add(gameControllerInfo);
        notifyNativeConnection(gameControllerInfo);
        return gameControllerInfo;
    }

    /* access modifiers changed from: package-private */
    public void onGameControllerDeviceRemoved(int i10) {
        int i11 = 0;
        while (true) {
            if (i11 >= this.pendingControllerDeviceIds.size()) {
                break;
            } else if (this.pendingControllerDeviceIds.get(i11).intValue() == i10) {
                this.pendingControllerDeviceIds.remove(i11);
                break;
            } else {
                i11++;
            }
        }
        for (int i12 = 0; i12 < this.gameControllers.size(); i12++) {
            GameControllerInfo gameControllerInfo = this.gameControllers.get(i12);
            if (gameControllerInfo.GetGameControllerDeviceId() == i10) {
                if (this.nativeReady) {
                    onControllerDisconnected(i10);
                }
                gameControllerInfo.GetListener().shutdownListener();
                gameControllerInfo.SetListener((GameControllerListener) null);
                this.gameControllers.remove(i12);
                return;
            }
        }
    }

    public void onInputDeviceAdded(int i10) {
        boolean isGameController = getIsGameController(i10);
        if (isDeviceOfSource(i10, 8194) && !isGameController) {
            processMouseAddition(i10);
        } else if (isGameController) {
            processControllerAddition(i10);
        }
    }

    public void onInputDeviceChanged(int i10) {
        int i11;
        boolean z10;
        boolean z11;
        if (getIsGameController(i10)) {
            Iterator<Integer> it = this.pendingControllerDeviceIds.iterator();
            while (true) {
                i11 = 0;
                z10 = true;
                if (it.hasNext()) {
                    if (it.next().intValue() == i10) {
                        z11 = true;
                        break;
                    }
                } else {
                    z11 = false;
                    break;
                }
            }
            if (!z11) {
                while (true) {
                    if (i11 >= this.gameControllers.size()) {
                        break;
                    }
                    GameControllerInfo gameControllerInfo = this.gameControllers.get(i11);
                    if (gameControllerInfo.GetGameControllerDeviceId() == i10) {
                        gameControllerInfo.GetListener().resetListener(this.inputManager.getInputDevice(i10), gameControllerInfo.GetGameControllerFlags());
                        break;
                    }
                    i11++;
                }
            }
            z10 = z11;
            if (!z10) {
                processControllerAddition(i10);
            }
        }
    }

    public void onInputDeviceRemoved(int i10) {
        onMouseDeviceRemoved(i10);
        onGameControllerDeviceRemoved(i10);
    }

    public native void onMotionData(int i10, int i11, long j10, float f10, float f11, float f12);

    /* access modifiers changed from: package-private */
    public void onMouseAdded(int i10) {
        if (this.mouseDeviceIds.size() < 2) {
            if (this.printControllerInfo) {
                Log.d(TAG, "onMouseDeviceAdded id: " + i10 + " name: " + InputDevice.getDevice(i10).getName());
                logControllerInfo(i10);
            }
            this.mouseDeviceIds.add(Integer.valueOf(i10));
            onMouseConnected(i10);
        }
    }

    public native void onMouseConnected(int i10);

    /* access modifiers changed from: package-private */
    public boolean onMouseDeviceRemoved(int i10) {
        boolean z10;
        int i11 = 0;
        while (true) {
            if (i11 >= this.pendingMouseDeviceIds.size()) {
                z10 = false;
                break;
            } else if (this.pendingMouseDeviceIds.get(i11).intValue() == i10) {
                this.pendingMouseDeviceIds.remove(i11);
                z10 = true;
                break;
            } else {
                i11++;
            }
        }
        for (int i12 = 0; i12 < this.mouseDeviceIds.size(); i12++) {
            if (this.mouseDeviceIds.get(i12).intValue() == i10) {
                if (this.nativeReady) {
                    onMouseDisconnected(i10);
                }
                this.mouseDeviceIds.remove(i12);
                return true;
            }
        }
        return z10;
    }

    public native void onMouseDisconnected(int i10);

    public void onStart() {
        if (this.gameControllerThread != null) {
            scanDevices();
            this.gameControllerThread.onStart();
            return;
        }
        GameControllerThread gameControllerThread2 = new GameControllerThread();
        this.gameControllerThread = gameControllerThread2;
        gameControllerThread2.setGameControllerManager(this);
        this.gameControllerThread.start();
    }

    public void onStop() {
        GameControllerThread gameControllerThread2 = this.gameControllerThread;
        if (gameControllerThread2 != null) {
            gameControllerThread2.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public void processControllerAddition(int i10) {
        int i11 = 0;
        if (!this.nativeReady) {
            while (i11 < this.pendingControllerDeviceIds.size()) {
                if (this.pendingControllerDeviceIds.get(i11).intValue() != i10) {
                    i11++;
                } else {
                    return;
                }
            }
            this.pendingControllerDeviceIds.add(Integer.valueOf(i10));
            return;
        }
        while (i11 < this.gameControllers.size()) {
            if (this.gameControllers.get(i11).GetGameControllerDeviceId() != i10) {
                i11++;
            } else {
                return;
            }
        }
        onGameControllerAdded(i10);
    }

    /* access modifiers changed from: package-private */
    public void processMouseAddition(int i10) {
        int i11 = 0;
        if (!this.nativeReady) {
            while (i11 < this.pendingMouseDeviceIds.size()) {
                if (this.pendingMouseDeviceIds.get(i11).intValue() != i10) {
                    i11++;
                } else {
                    return;
                }
            }
            this.pendingMouseDeviceIds.add(Integer.valueOf(i10));
            return;
        }
        while (i11 < this.mouseDeviceIds.size()) {
            if (this.mouseDeviceIds.get(i11).intValue() != i10) {
                i11++;
            } else {
                return;
            }
        }
        onMouseAdded(i10);
    }

    /* access modifiers changed from: package-private */
    public void scanDevices() {
        int[] inputDeviceIds = this.inputManager.getInputDeviceIds();
        for (int i10 : inputDeviceIds) {
            boolean isGameController = getIsGameController(i10);
            if (isDeviceOfSource(i10, 8194) && !isGameController) {
                processMouseAddition(i10);
            } else if (isGameController) {
                processControllerAddition(i10);
            }
        }
        checkForControllerRemovals(inputDeviceIds);
        checkForMouseRemovals(inputDeviceIds);
    }

    public void setLight(int i10, int i11, int i12) {
        for (int i13 = 0; i13 < this.gameControllers.size(); i13++) {
            GameControllerInfo gameControllerInfo = this.gameControllers.get(i13);
            if (gameControllerInfo.GetGameControllerDeviceId() == i10) {
                gameControllerInfo.GetListener().setLight(i11, i12);
                return;
            }
        }
    }

    public void setNativeReady() {
        this.nativeReady = true;
        Log.d(TAG, "setNativeReady");
        Iterator<Integer> it = this.pendingControllerDeviceIds.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (onGameControllerAdded(intValue) != null && this.printControllerInfo) {
                Log.d(TAG, "setNativeReady notifyNativeConnection for deviceId: " + intValue);
            }
        }
        this.pendingControllerDeviceIds.clear();
        Iterator<Integer> it2 = this.pendingMouseDeviceIds.iterator();
        while (it2.hasNext()) {
            onMouseAdded(it2.next().intValue());
        }
    }

    public void setReportMotionEvents() {
        this.reportMotionEvents = true;
        Iterator<GameControllerInfo> it = this.gameControllers.iterator();
        while (it.hasNext()) {
            it.next().GetListener().setReportMotionEvents();
        }
    }

    public void setVibration(int i10, int i11, int i12, int i13, int i14) {
        InputDevice inputDevice = this.inputManager.getInputDevice(i10);
        if (inputDevice != null) {
            int i15 = Build.VERSION.SDK_INT;
            if (i15 >= VIBRATOR_MANAGER_MIN_API) {
                setVibrationMultiChannel(inputDevice, i11, i12, i13, i14);
            } else if (i15 >= 26) {
                updateVibrator(inputDevice.getVibrator(), i11, i12);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setVibrationMultiChannel(InputDevice inputDevice, int i10, int i11, int i12, int i13) {
        VibratorManager a10;
        if (Build.VERSION.SDK_INT >= VIBRATOR_MANAGER_MIN_API && (a10 = inputDevice.getVibratorManager()) != null) {
            int[] a11 = a10.getVibratorIds();
            int length = a11.length;
            Log.d(TAG, "Vibrator Count: " + length);
            if (length > 0) {
                updateVibrator(a10.getVibrator(a11[0]), i10, i11);
                if (length > 1) {
                    updateVibrator(a10.getVibrator(a11[1]), i12, i13);
                }
            }
        }
    }
}
