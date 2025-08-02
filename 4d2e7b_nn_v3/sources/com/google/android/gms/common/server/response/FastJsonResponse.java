package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
public abstract class FastJsonResponse {

    @ShowFirstParty
    public interface FieldConverter<I, O> {
        int zaa();

        int zab();

        @Nullable
        O zac(@NonNull I i10);

        @NonNull
        I zad(@NonNull O o10);
    }

    @NonNull
    protected static final <O, I> I zaD(@NonNull Field<I, O> field, @Nullable Object obj) {
        if (field.zak != null) {
            return field.zaf(obj);
        }
        return obj;
    }

    private final <I, O> void zaE(Field<I, O> field, @Nullable I i10) {
        String str = field.zae;
        O zae = field.zae(i10);
        int i11 = field.zac;
        switch (i11) {
            case 0:
                if (zae != null) {
                    setIntegerInternal(field, str, ((Integer) zae).intValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 1:
                zaf(field, str, (BigInteger) zae);
                return;
            case 2:
                if (zae != null) {
                    setLongInternal(field, str, ((Long) zae).longValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 4:
                if (zae != null) {
                    zan(field, str, ((Double) zae).doubleValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 5:
                zab(field, str, (BigDecimal) zae);
                return;
            case 6:
                if (zae != null) {
                    setBooleanInternal(field, str, ((Boolean) zae).booleanValue());
                    return;
                } else {
                    zaG(str);
                    return;
                }
            case 7:
                setStringInternal(field, str, (String) zae);
                return;
            case 8:
            case 9:
                if (zae != null) {
                    setDecodedBytesInternal(field, str, (byte[]) zae);
                    return;
                } else {
                    zaG(str);
                    return;
                }
            default:
                StringBuilder sb2 = new StringBuilder(44);
                sb2.append("Unsupported type for conversion: ");
                sb2.append(i11);
                throw new IllegalStateException(sb2.toString());
        }
    }

    private static final void zaF(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.zaa;
        if (i10 == 11) {
            Class<? extends FastJsonResponse> cls = field.zag;
            Preconditions.checkNotNull(cls);
            sb2.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else if (i10 == 7) {
            sb2.append("\"");
            sb2.append(JsonUtils.escapeString((String) obj));
            sb2.append("\"");
        } else {
            sb2.append(obj);
        }
    }

    private static final <O> void zaG(String str) {
        if (Log.isLoggable("FastJsonResponse", 6)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 58);
            sb2.append("Output field (");
            sb2.append(str);
            sb2.append(") has a null value, but expected a primitive");
            Log.e("FastJsonResponse", sb2.toString());
        }
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(@NonNull Field field, @NonNull String str, @Nullable ArrayList<T> arrayList) {
        throw new UnsupportedOperationException("Concrete type array not supported");
    }

    @KeepForSdk
    public <T extends FastJsonResponse> void addConcreteTypeInternal(@NonNull Field field, @NonNull String str, @NonNull T t10) {
        throw new UnsupportedOperationException("Concrete type not supported");
    }

    @NonNull
    @KeepForSdk
    public abstract Map<String, Field<?, ?>> getFieldMappings();

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public Object getFieldValue(@NonNull Field field) {
        boolean z10;
        String str = field.zae;
        if (field.zag == null) {
            return getValueObject(str);
        }
        if (getValueObject(str) == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        Preconditions.checkState(z10, "Concrete field shouldn't be value object: %s", field.zae);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 4);
            sb2.append("get");
            sb2.append(upperCase);
            sb2.append(substring);
            return getClass().getMethod(sb2.toString(), (Class[]) null).invoke(this, (Object[]) null);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public abstract Object getValueObject(@NonNull String str);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean isFieldSet(@NonNull Field field) {
        if (field.zac != 11) {
            return isPrimitiveFieldSet(field.zae);
        }
        if (field.zad) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public abstract boolean isPrimitiveFieldSet(@NonNull String str);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setBooleanInternal(@NonNull Field<?, ?> field, @NonNull String str, boolean z10) {
        throw new UnsupportedOperationException("Boolean not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setDecodedBytesInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable byte[] bArr) {
        throw new UnsupportedOperationException("byte[] not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setIntegerInternal(@NonNull Field<?, ?> field, @NonNull String str, int i10) {
        throw new UnsupportedOperationException("Integer not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setLongInternal(@NonNull Field<?, ?> field, @NonNull String str, long j10) {
        throw new UnsupportedOperationException("Long not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setStringInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable String str2) {
        throw new UnsupportedOperationException("String not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setStringMapInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable Map<String, String> map) {
        throw new UnsupportedOperationException("String map not supported");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void setStringsInternal(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<String> arrayList) {
        throw new UnsupportedOperationException("String list not supported");
    }

    @NonNull
    @KeepForSdk
    public String toString() {
        Map<String, Field<?, ?>> fieldMappings = getFieldMappings();
        StringBuilder sb2 = new StringBuilder(100);
        for (String next : fieldMappings.keySet()) {
            Field field = fieldMappings.get(next);
            if (isFieldSet(field)) {
                Object zaD = zaD(field, getFieldValue(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(next);
                sb2.append("\":");
                if (zaD != null) {
                    switch (field.zac) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(Base64Utils.encode((byte[]) zaD));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(Base64Utils.encodeUrlSafe((byte[]) zaD));
                            sb2.append("\"");
                            break;
                        case 10:
                            MapUtils.writeStringMapToJson(sb2, (HashMap) zaD);
                            break;
                        default:
                            if (!field.zab) {
                                zaF(sb2, field, zaD);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) zaD;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        zaF(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                                break;
                            }
                    }
                } else {
                    sb2.append("null");
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }

    public final <O> void zaA(@NonNull Field<String, O> field, @Nullable String str) {
        if (field.zak != null) {
            zaE(field, str);
        } else {
            setStringInternal(field, field.zae, str);
        }
    }

    public final <O> void zaB(@NonNull Field<Map<String, String>, O> field, @Nullable Map<String, String> map) {
        if (field.zak != null) {
            zaE(field, map);
        } else {
            setStringMapInternal(field, field.zae, map);
        }
    }

    public final <O> void zaC(@NonNull Field<ArrayList<String>, O> field, @Nullable ArrayList<String> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            setStringsInternal(field, field.zae, arrayList);
        }
    }

    public final <O> void zaa(@NonNull Field<BigDecimal, O> field, @Nullable BigDecimal bigDecimal) {
        if (field.zak != null) {
            zaE(field, bigDecimal);
        } else {
            zab(field, field.zae, bigDecimal);
        }
    }

    /* access modifiers changed from: protected */
    public void zab(@NonNull Field<?, ?> field, @NonNull String str, @Nullable BigDecimal bigDecimal) {
        throw new UnsupportedOperationException("BigDecimal not supported");
    }

    public final <O> void zac(@NonNull Field<ArrayList<BigDecimal>, O> field, @Nullable ArrayList<BigDecimal> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zad(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zad(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigDecimal> arrayList) {
        throw new UnsupportedOperationException("BigDecimal list not supported");
    }

    public final <O> void zae(@NonNull Field<BigInteger, O> field, @Nullable BigInteger bigInteger) {
        if (field.zak != null) {
            zaE(field, bigInteger);
        } else {
            zaf(field, field.zae, bigInteger);
        }
    }

    /* access modifiers changed from: protected */
    public void zaf(@NonNull Field<?, ?> field, @NonNull String str, @Nullable BigInteger bigInteger) {
        throw new UnsupportedOperationException("BigInteger not supported");
    }

    public final <O> void zag(@NonNull Field<ArrayList<BigInteger>, O> field, @Nullable ArrayList<BigInteger> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zah(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zah(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<BigInteger> arrayList) {
        throw new UnsupportedOperationException("BigInteger list not supported");
    }

    public final <O> void zai(@NonNull Field<Boolean, O> field, boolean z10) {
        if (field.zak != null) {
            zaE(field, Boolean.valueOf(z10));
        } else {
            setBooleanInternal(field, field.zae, z10);
        }
    }

    public final <O> void zaj(@NonNull Field<ArrayList<Boolean>, O> field, @Nullable ArrayList<Boolean> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zak(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zak(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Boolean> arrayList) {
        throw new UnsupportedOperationException("Boolean list not supported");
    }

    public final <O> void zal(@NonNull Field<byte[], O> field, @Nullable byte[] bArr) {
        if (field.zak != null) {
            zaE(field, bArr);
        } else {
            setDecodedBytesInternal(field, field.zae, bArr);
        }
    }

    public final <O> void zam(@NonNull Field<Double, O> field, double d10) {
        if (field.zak != null) {
            zaE(field, Double.valueOf(d10));
        } else {
            zan(field, field.zae, d10);
        }
    }

    /* access modifiers changed from: protected */
    public void zan(@NonNull Field<?, ?> field, @NonNull String str, double d10) {
        throw new UnsupportedOperationException("Double not supported");
    }

    public final <O> void zao(@NonNull Field<ArrayList<Double>, O> field, @Nullable ArrayList<Double> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zap(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zap(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Double> arrayList) {
        throw new UnsupportedOperationException("Double list not supported");
    }

    public final <O> void zaq(@NonNull Field<Float, O> field, float f10) {
        if (field.zak != null) {
            zaE(field, Float.valueOf(f10));
        } else {
            zar(field, field.zae, f10);
        }
    }

    /* access modifiers changed from: protected */
    public void zar(@NonNull Field<?, ?> field, @NonNull String str, float f10) {
        throw new UnsupportedOperationException("Float not supported");
    }

    public final <O> void zas(@NonNull Field<ArrayList<Float>, O> field, @Nullable ArrayList<Float> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zat(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zat(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Float> arrayList) {
        throw new UnsupportedOperationException("Float list not supported");
    }

    public final <O> void zau(@NonNull Field<Integer, O> field, int i10) {
        if (field.zak != null) {
            zaE(field, Integer.valueOf(i10));
        } else {
            setIntegerInternal(field, field.zae, i10);
        }
    }

    public final <O> void zav(@NonNull Field<ArrayList<Integer>, O> field, @Nullable ArrayList<Integer> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaw(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zaw(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Integer> arrayList) {
        throw new UnsupportedOperationException("Integer list not supported");
    }

    public final <O> void zax(@NonNull Field<Long, O> field, long j10) {
        if (field.zak != null) {
            zaE(field, Long.valueOf(j10));
        } else {
            setLongInternal(field, field.zae, j10);
        }
    }

    public final <O> void zay(@NonNull Field<ArrayList<Long>, O> field, @Nullable ArrayList<Long> arrayList) {
        if (field.zak != null) {
            zaE(field, arrayList);
        } else {
            zaz(field, field.zae, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void zaz(@NonNull Field<?, ?> field, @NonNull String str, @Nullable ArrayList<Long> arrayList) {
        throw new UnsupportedOperationException("Long list not supported");
    }

    @ShowFirstParty
    @SafeParcelable.Class(creator = "FieldCreator")
    @VisibleForTesting
    @KeepForSdk
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final zaj CREATOR = new zaj();
        @SafeParcelable.Field(getter = "getTypeIn", id = 2)
        protected final int zaa;
        @SafeParcelable.Field(getter = "isTypeInArray", id = 3)
        protected final boolean zab;
        @SafeParcelable.Field(getter = "getTypeOut", id = 4)
        protected final int zac;
        @SafeParcelable.Field(getter = "isTypeOutArray", id = 5)
        protected final boolean zad;
        @SafeParcelable.Field(getter = "getOutputFieldName", id = 6)
        @NonNull
        protected final String zae;
        @SafeParcelable.Field(getter = "getSafeParcelableFieldId", id = 7)
        protected final int zaf;
        @Nullable
        protected final Class<? extends FastJsonResponse> zag;
        @SafeParcelable.Field(getter = "getConcreteTypeName", id = 8)
        @Nullable
        protected final String zah;
        @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
        private final int zai;
        private zan zaj;
        /* access modifiers changed from: private */
        @SafeParcelable.Field(getter = "getWrappedConverter", id = 9, type = "com.google.android.gms.common.server.converter.ConverterWrapper")
        @Nullable
        public FieldConverter<I, O> zak;

        @SafeParcelable.Constructor
        Field(@SafeParcelable.Param(id = 1) int i10, @SafeParcelable.Param(id = 2) int i11, @SafeParcelable.Param(id = 3) boolean z10, @SafeParcelable.Param(id = 4) int i12, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) String str, @SafeParcelable.Param(id = 7) int i13, @SafeParcelable.Param(id = 8) @Nullable String str2, @SafeParcelable.Param(id = 9) @Nullable zaa zaa2) {
            this.zai = i10;
            this.zaa = i11;
            this.zab = z10;
            this.zac = i12;
            this.zad = z11;
            this.zae = str;
            this.zaf = i13;
            if (str2 == null) {
                this.zag = null;
                this.zah = null;
            } else {
                this.zag = SafeParcelResponse.class;
                this.zah = str2;
            }
            if (zaa2 == null) {
                this.zak = null;
            } else {
                this.zak = zaa2.zab();
            }
        }

        @NonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<byte[], byte[]> forBase64(@NonNull String str, int i10) {
            return new Field(8, false, 8, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Boolean, Boolean> forBoolean(@NonNull String str, int i10) {
            return new Field(6, false, 6, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<T, T> forConcreteType(@NonNull String str, int i10, @NonNull Class<T> cls) {
            return new Field(11, false, 11, false, str, i10, cls, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(@NonNull String str, int i10, @NonNull Class<T> cls) {
            return new Field(11, true, 11, true, str, i10, cls, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Double, Double> forDouble(@NonNull String str, int i10) {
            return new Field(4, false, 4, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Float, Float> forFloat(@NonNull String str, int i10) {
            return new Field(3, false, 3, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        @VisibleForTesting
        public static Field<Integer, Integer> forInteger(@NonNull String str, int i10) {
            return new Field(0, false, 0, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<Long, Long> forLong(@NonNull String str, int i10) {
            return new Field(2, false, 2, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<String, String> forString(@NonNull String str, int i10) {
            return new Field(7, false, 7, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<HashMap<String, String>, HashMap<String, String>> forStringMap(@NonNull String str, int i10) {
            return new Field(10, false, 10, false, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field<ArrayList<String>, ArrayList<String>> forStrings(@NonNull String str, int i10) {
            return new Field(7, true, 7, true, str, i10, (Class<? extends FastJsonResponse>) null, (FieldConverter) null);
        }

        @NonNull
        @KeepForSdk
        public static Field withConverter(@NonNull String str, int i10, @NonNull FieldConverter<?, ?> fieldConverter, boolean z10) {
            fieldConverter.zaa();
            fieldConverter.zab();
            return new Field(7, z10, 0, false, str, i10, (Class<? extends FastJsonResponse>) null, fieldConverter);
        }

        @KeepForSdk
        public int getSafeParcelableFieldId() {
            return this.zaf;
        }

        @NonNull
        public final String toString() {
            Objects.ToStringHelper add = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zai)).add("typeIn", Integer.valueOf(this.zaa)).add("typeInArray", Boolean.valueOf(this.zab)).add("typeOut", Integer.valueOf(this.zac)).add("typeOutArray", Boolean.valueOf(this.zad)).add("outputFieldName", this.zae).add("safeParcelFieldId", Integer.valueOf(this.zaf)).add("concreteTypeName", zag());
            Class<? extends FastJsonResponse> cls = this.zag;
            if (cls != null) {
                add.add("concreteType.class", cls.getCanonicalName());
            }
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter != null) {
                add.add("converterName", fieldConverter.getClass().getCanonicalName());
            }
            return add.toString();
        }

        public final void writeToParcel(@NonNull Parcel parcel, int i10) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zai);
            SafeParcelWriter.writeInt(parcel, 2, this.zaa);
            SafeParcelWriter.writeBoolean(parcel, 3, this.zab);
            SafeParcelWriter.writeInt(parcel, 4, this.zac);
            SafeParcelWriter.writeBoolean(parcel, 5, this.zad);
            SafeParcelWriter.writeString(parcel, 6, this.zae, false);
            SafeParcelWriter.writeInt(parcel, 7, getSafeParcelableFieldId());
            SafeParcelWriter.writeString(parcel, 8, zag(), false);
            SafeParcelWriter.writeParcelable(parcel, 9, zaa(), i10, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public final zaa zaa() {
            FieldConverter<I, O> fieldConverter = this.zak;
            if (fieldConverter == null) {
                return null;
            }
            return zaa.zaa(fieldConverter);
        }

        @NonNull
        public final Field<I, O> zab() {
            return new Field(this.zai, this.zaa, this.zab, this.zac, this.zad, this.zae, this.zaf, this.zah, zaa());
        }

        @NonNull
        public final FastJsonResponse zad() throws InstantiationException, IllegalAccessException {
            Preconditions.checkNotNull(this.zag);
            Class<? extends FastJsonResponse> cls = this.zag;
            if (cls != SafeParcelResponse.class) {
                return (FastJsonResponse) cls.newInstance();
            }
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
            return new SafeParcelResponse(this.zaj, this.zah);
        }

        @NonNull
        public final O zae(@Nullable I i10) {
            Preconditions.checkNotNull(this.zak);
            return Preconditions.checkNotNull(this.zak.zac(i10));
        }

        @NonNull
        public final I zaf(@NonNull O o10) {
            Preconditions.checkNotNull(this.zak);
            return this.zak.zad(o10);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public final String zag() {
            String str = this.zah;
            if (str == null) {
                return null;
            }
            return str;
        }

        @NonNull
        public final Map<String, Field<?, ?>> zah() {
            Preconditions.checkNotNull(this.zah);
            Preconditions.checkNotNull(this.zaj);
            return (Map) Preconditions.checkNotNull(this.zaj.zab(this.zah));
        }

        public final void zai(zan zan) {
            this.zaj = zan;
        }

        public final boolean zaj() {
            return this.zak != null;
        }

        protected Field(int i10, boolean z10, int i11, boolean z11, @NonNull String str, int i12, @Nullable Class<? extends FastJsonResponse> cls, @Nullable FieldConverter<I, O> fieldConverter) {
            this.zai = 1;
            this.zaa = i10;
            this.zab = z10;
            this.zac = i11;
            this.zad = z11;
            this.zae = str;
            this.zaf = i12;
            this.zag = cls;
            if (cls == null) {
                this.zah = null;
            } else {
                this.zah = cls.getCanonicalName();
            }
            this.zak = fieldConverter;
        }
    }
}
