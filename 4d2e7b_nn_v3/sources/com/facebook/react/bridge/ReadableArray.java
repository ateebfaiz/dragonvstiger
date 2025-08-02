package com.facebook.react.bridge;

import java.util.ArrayList;

public interface ReadableArray {
    ReadableArray getArray(int i10);

    boolean getBoolean(int i10);

    double getDouble(int i10);

    Dynamic getDynamic(int i10);

    int getInt(int i10);

    long getLong(int i10);

    ReadableMap getMap(int i10);

    String getString(int i10);

    ReadableType getType(int i10);

    boolean isNull(int i10);

    int size();

    ArrayList<Object> toArrayList();
}
