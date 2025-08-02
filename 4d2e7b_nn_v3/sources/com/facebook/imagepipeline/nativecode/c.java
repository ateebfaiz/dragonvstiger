package com.facebook.imagepipeline.nativecode;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.m;
import m5.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f19999a = new c();

    private c() {
    }

    public static final d a(int i10, boolean z10, boolean z11) {
        Class<NativeJpegTranscoderFactory> cls = NativeJpegTranscoderFactory.class;
        try {
            Class cls2 = Boolean.TYPE;
            NativeJpegTranscoderFactory newInstance = cls.getConstructor(new Class[]{Integer.TYPE, cls2, cls2}).newInstance(new Object[]{Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(z11)});
            m.d(newInstance, "null cannot be cast to non-null type com.facebook.imagepipeline.transcoder.ImageTranscoderFactory");
            return newInstance;
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e10);
        } catch (SecurityException e11) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e13);
        } catch (IllegalAccessException e14) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e14);
        } catch (IllegalArgumentException e15) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e15);
        } catch (ClassNotFoundException e16) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e16);
        }
    }
}
