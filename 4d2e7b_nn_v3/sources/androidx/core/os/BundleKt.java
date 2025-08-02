package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Pair;
import kotlin.jvm.internal.m;

public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... pairArr) {
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = (String) pair.a();
            Object b10 = pair.b();
            if (b10 == null) {
                bundle.putString(str, (String) null);
            } else if (b10 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) b10).booleanValue());
            } else if (b10 instanceof Byte) {
                bundle.putByte(str, ((Number) b10).byteValue());
            } else if (b10 instanceof Character) {
                bundle.putChar(str, ((Character) b10).charValue());
            } else if (b10 instanceof Double) {
                bundle.putDouble(str, ((Number) b10).doubleValue());
            } else if (b10 instanceof Float) {
                bundle.putFloat(str, ((Number) b10).floatValue());
            } else if (b10 instanceof Integer) {
                bundle.putInt(str, ((Number) b10).intValue());
            } else if (b10 instanceof Long) {
                bundle.putLong(str, ((Number) b10).longValue());
            } else if (b10 instanceof Short) {
                bundle.putShort(str, ((Number) b10).shortValue());
            } else if (b10 instanceof Bundle) {
                bundle.putBundle(str, (Bundle) b10);
            } else if (b10 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) b10);
            } else if (b10 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) b10);
            } else if (b10 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) b10);
            } else if (b10 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) b10);
            } else if (b10 instanceof char[]) {
                bundle.putCharArray(str, (char[]) b10);
            } else if (b10 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) b10);
            } else if (b10 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) b10);
            } else if (b10 instanceof int[]) {
                bundle.putIntArray(str, (int[]) b10);
            } else if (b10 instanceof long[]) {
                bundle.putLongArray(str, (long[]) b10);
            } else if (b10 instanceof short[]) {
                bundle.putShortArray(str, (short[]) b10);
            } else if (b10 instanceof Object[]) {
                Class<?> componentType = b10.getClass().getComponentType();
                m.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    m.d(b10, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
                    bundle.putParcelableArray(str, (Parcelable[]) b10);
                } else if (String.class.isAssignableFrom(componentType)) {
                    m.d(b10, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    bundle.putStringArray(str, (String[]) b10);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    m.d(b10, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
                    bundle.putCharSequenceArray(str, (CharSequence[]) b10);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(str, (Serializable) b10);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                }
            } else if (b10 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) b10);
            } else if (b10 instanceof IBinder) {
                bundle.putBinder(str, (IBinder) b10);
            } else if (b10 instanceof Size) {
                a.a(bundle, str, (Size) b10);
            } else if (b10 instanceof SizeF) {
                a.b(bundle, str, (SizeF) b10);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b10.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return bundle;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
