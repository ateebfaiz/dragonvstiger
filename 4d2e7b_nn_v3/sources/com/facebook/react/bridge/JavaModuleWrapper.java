package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import c8.b;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@a
class JavaModuleWrapper {
    private final ArrayList<MethodDescriptor> mDescs = new ArrayList<>();
    private final JSInstance mJSInstance;
    private final ArrayList<NativeMethod> mMethods = new ArrayList<>();
    private final ModuleHolder mModuleHolder;

    @a
    public static class MethodDescriptor {
        @a
        Method method;
        @a
        String name;
        @a
        String signature;
        @a
        String type;
    }

    interface NativeMethod {
        String getType();

        void invoke(JSInstance jSInstance, ReadableArray readableArray);
    }

    public JavaModuleWrapper(JSInstance jSInstance, ModuleHolder moduleHolder) {
        this.mJSInstance = jSInstance;
        this.mModuleHolder = moduleHolder;
    }

    @a
    private void findMethods() {
        c8.a.c(0, "findMethods");
        Class<?> cls = this.mModuleHolder.getModule().getClass();
        Class<? super Object> superclass = cls.getSuperclass();
        if (TurboModule.class.isAssignableFrom(superclass)) {
            cls = superclass;
        }
        for (Method method : cls.getDeclaredMethods()) {
            ReactMethod reactMethod = (ReactMethod) method.getAnnotation(ReactMethod.class);
            if (reactMethod != null) {
                String name = method.getName();
                MethodDescriptor methodDescriptor = new MethodDescriptor();
                JavaMethodWrapper javaMethodWrapper = new JavaMethodWrapper(this, method, reactMethod.isBlockingSynchronousMethod());
                methodDescriptor.name = name;
                String type = javaMethodWrapper.getType();
                methodDescriptor.type = type;
                if (BaseJavaModule.METHOD_TYPE_SYNC.equals(type)) {
                    methodDescriptor.signature = javaMethodWrapper.getSignature();
                    methodDescriptor.method = method;
                }
                this.mMethods.add(javaMethodWrapper);
                this.mDescs.add(methodDescriptor);
            }
        }
        c8.a.g(0);
    }

    @Nullable
    @a
    public NativeMap getConstants() {
        String name = getName();
        b.a(0, "JavaModuleWrapper.getConstants").b("moduleName", name).c();
        ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, name);
        BaseJavaModule module = getModule();
        c8.a.c(0, "module.getConstants");
        Map<String, Object> constants = module.getConstants();
        c8.a.g(0);
        c8.a.c(0, "create WritableNativeMap");
        ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, name);
        try {
            return Arguments.makeNativeMap(constants);
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END, name);
            c8.a.g(0);
            ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END, name);
            b.b(0).c();
        }
    }

    @a
    public List<MethodDescriptor> getMethodDescriptors() {
        if (this.mDescs.isEmpty()) {
            findMethods();
        }
        return this.mDescs;
    }

    @a
    public BaseJavaModule getModule() {
        return (BaseJavaModule) this.mModuleHolder.getModule();
    }

    @a
    public String getName() {
        return this.mModuleHolder.getName();
    }

    @a
    public void invoke(int i10, ReadableNativeArray readableNativeArray) {
        if (i10 < this.mMethods.size()) {
            this.mMethods.get(i10).invoke(this.mJSInstance, readableNativeArray);
        }
    }
}
