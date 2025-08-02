package com.google.androidgamesdk;

public class GameSdkDeviceInfoJni {
    private static Throwable initializationExceptionOrError;

    static {
        try {
            System.loadLibrary("game_sdk_device_info_jni");
        } catch (Exception e10) {
            initializationExceptionOrError = e10;
        } catch (Error e11) {
            initializationExceptionOrError = e11;
        }
    }

    public static Throwable getInitializationExceptionOrError() {
        return initializationExceptionOrError;
    }

    private static native byte[] getProtoSerialized();

    public static byte[] tryGetProtoSerialized() {
        if (initializationExceptionOrError != null) {
            return null;
        }
        return getProtoSerialized();
    }
}
