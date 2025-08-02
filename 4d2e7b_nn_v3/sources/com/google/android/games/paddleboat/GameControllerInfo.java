package com.google.android.games.paddleboat;

import android.view.InputDevice;

public class GameControllerInfo {
    private static final int AXIS_COUNT_LOW = 31;
    private static final int DEVICEFLAG_VIBRATION = 134217728;
    private static final int DEVICEFLAG_VIBRATION_DUAL_MOTOR = 268435456;
    private static final int DEVICEFLAG_VIRTUAL_MOUSE = 1073741824;
    private static final int DEVICEINFO_ARRAY_SIZE = 7;
    private static final int DEVICEINFO_INDEX_AXISBITS_HIGH = 4;
    private static final int DEVICEINFO_INDEX_AXISBITS_LOW = 3;
    private static final int DEVICEINFO_INDEX_CONTROLLERNUMBER = 5;
    private static final int DEVICEINFO_INDEX_DEVICEFLAGS = 6;
    private static final int DEVICEINFO_INDEX_DEVICEID = 0;
    private static final int DEVICEINFO_INDEX_PRODUCTID = 2;
    private static final int DEVICEINFO_INDEX_VENDORID = 1;
    private static final int MAX_AXIS_COUNT = 48;
    private final float[] mGameControllerAxisFlatArray = new float[MAX_AXIS_COUNT];
    private final float[] mGameControllerAxisFuzzArray = new float[MAX_AXIS_COUNT];
    private final float[] mGameControllerAxisMaxArray = new float[MAX_AXIS_COUNT];
    private final float[] mGameControllerAxisMinArray = new float[MAX_AXIS_COUNT];
    private final int[] mGameControllerDeviceInfoArray = new int[7];
    private final String mGameControllerNameString;
    private GameControllerListener mListener = null;

    GameControllerInfo(InputDevice inputDevice) {
        for (int i10 = 0; i10 < 7; i10++) {
            this.mGameControllerDeviceInfoArray[i10] = 0;
        }
        for (int i11 = 0; i11 < MAX_AXIS_COUNT; i11++) {
            this.mGameControllerAxisMinArray[i11] = 0.0f;
            this.mGameControllerAxisMaxArray[i11] = 0.0f;
            this.mGameControllerAxisFlatArray[i11] = 0.0f;
            this.mGameControllerAxisFuzzArray[i11] = 0.0f;
        }
        this.mGameControllerNameString = inputDevice.getName();
        EnumerateAxis(inputDevice);
        EnumerateInfoArray(inputDevice);
    }

    private void EnumerateAxis(InputDevice inputDevice) {
        for (InputDevice.MotionRange next : inputDevice.getMotionRanges()) {
            int axis = next.getAxis();
            if (axis >= 0 && axis < MAX_AXIS_COUNT) {
                int source = next.getSource();
                if (source == 16777232 || source == 1025) {
                    if (axis <= AXIS_COUNT_LOW) {
                        int[] iArr = this.mGameControllerDeviceInfoArray;
                        iArr[3] = (1 << axis) | iArr[3];
                    } else {
                        int[] iArr2 = this.mGameControllerDeviceInfoArray;
                        iArr2[4] = (1 << (axis - 32)) | iArr2[4];
                    }
                    this.mGameControllerAxisMinArray[axis] = next.getMin();
                    this.mGameControllerAxisMaxArray[axis] = next.getMax();
                    this.mGameControllerAxisFlatArray[axis] = next.getFlat();
                    this.mGameControllerAxisFuzzArray[axis] = next.getFuzz();
                }
            }
        }
    }

    private void EnumerateInfoArray(InputDevice inputDevice) {
        this.mGameControllerDeviceInfoArray[0] = inputDevice.getId();
        this.mGameControllerDeviceInfoArray[1] = inputDevice.getVendorId();
        this.mGameControllerDeviceInfoArray[2] = inputDevice.getProductId();
        this.mGameControllerDeviceInfoArray[5] = inputDevice.getControllerNumber();
        this.mGameControllerDeviceInfoArray[6] = GameControllerManager.getControllerFlagsForDevice(inputDevice);
    }

    public float[] GetGameControllerAxisFlatArray() {
        return this.mGameControllerAxisFlatArray;
    }

    public float[] GetGameControllerAxisFuzzArray() {
        return this.mGameControllerAxisFuzzArray;
    }

    public float[] GetGameControllerAxisMaxArray() {
        return this.mGameControllerAxisMaxArray;
    }

    public float[] GetGameControllerAxisMinArray() {
        return this.mGameControllerAxisMinArray;
    }

    public int GetGameControllerDeviceId() {
        return this.mGameControllerDeviceInfoArray[0];
    }

    public int[] GetGameControllerDeviceInfoArray() {
        return this.mGameControllerDeviceInfoArray;
    }

    public int GetGameControllerFlags() {
        return this.mGameControllerDeviceInfoArray[6];
    }

    public String GetGameControllerNameString() {
        return this.mGameControllerNameString;
    }

    public GameControllerListener GetListener() {
        return this.mListener;
    }

    public void SetListener(GameControllerListener gameControllerListener) {
        this.mListener = gameControllerListener;
    }
}
