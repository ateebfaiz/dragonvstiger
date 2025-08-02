package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.m0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d implements m0 {
    public List createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PickerModule(reactApplicationContext));
        return arrayList;
    }

    public List createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
