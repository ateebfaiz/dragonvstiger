package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.PropertyNamingStrategy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaBeanSerializer implements ObjectSerializer {
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:318:0x03ec, code lost:
        if (((java.lang.Boolean) r12).booleanValue() == false) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00d8, code lost:
        if (r10.parent != null) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0136 A[Catch:{ Exception -> 0x05f7, all -> 0x05f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0138 A[Catch:{ Exception -> 0x05f7, all -> 0x05f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0140 A[Catch:{ Exception -> 0x05f7, all -> 0x05f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0142 A[Catch:{ Exception -> 0x05f7, all -> 0x05f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0157 A[SYNTHETIC, Splitter:B:119:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x020f A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0253 A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0258 A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x025a A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x03dc A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x03dd A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x04c2 A[Catch:{ Exception -> 0x018a, all -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:425:0x0595  */
    /* JADX WARNING: Removed duplicated region for block: B:437:0x05b7 A[SYNTHETIC, Splitter:B:437:0x05b7] */
    /* JADX WARNING: Removed duplicated region for block: B:444:0x05cf A[SYNTHETIC, Splitter:B:444:0x05cf] */
    /* JADX WARNING: Removed duplicated region for block: B:467:0x0600 A[SYNTHETIC, Splitter:B:467:0x0600] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0102 A[SYNTHETIC, Splitter:B:87:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0125 A[SYNTHETIC, Splitter:B:99:0x0125] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r38, java.lang.Object r39, java.lang.Object r40, java.lang.reflect.Type r41) throws java.io.IOException {
        /*
            r37 = this;
            r1 = r37
            r2 = r38
            r3 = r39
            r4 = r40
            r5 = r41
            com.alibaba.fastjson.serializer.SerializeWriter r6 = r2.out
            if (r3 != 0) goto L_0x0012
            r6.writeNull()
            return
        L_0x0012:
            com.alibaba.fastjson.serializer.SerialContext r7 = r2.context
            if (r7 == 0) goto L_0x001f
            int r7 = r7.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r8 = r8.mask
            r7 = r7 & r8
            if (r7 != 0) goto L_0x002d
        L_0x001f:
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r7 = r2.references
            if (r7 == 0) goto L_0x002d
            boolean r7 = r7.containsKey(r3)
            if (r7 == 0) goto L_0x002d
            r38.writeReference(r39)
            return
        L_0x002d:
            int r7 = r6.features
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.SortField
            int r8 = r8.mask
            r8 = r8 & r7
            if (r8 == 0) goto L_0x0039
            com.alibaba.fastjson.serializer.FieldSerializer[] r8 = r1.sortedGetters
            goto L_0x003b
        L_0x0039:
            com.alibaba.fastjson.serializer.FieldSerializer[] r8 = r1.getters
        L_0x003b:
            com.alibaba.fastjson.serializer.SerialContext r9 = r2.context
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect
            int r10 = r10.mask
            r7 = r7 & r10
            if (r7 != 0) goto L_0x005f
            com.alibaba.fastjson.serializer.SerialContext r7 = new com.alibaba.fastjson.serializer.SerialContext
            int r10 = r1.features
            r7.<init>(r9, r3, r4, r10)
            r2.context = r7
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r7 = r2.references
            if (r7 != 0) goto L_0x0058
            java.util.IdentityHashMap r7 = new java.util.IdentityHashMap
            r7.<init>()
            r2.references = r7
        L_0x0058:
            java.util.IdentityHashMap<java.lang.Object, com.alibaba.fastjson.serializer.SerialContext> r7 = r2.references
            com.alibaba.fastjson.serializer.SerialContext r10 = r2.context
            r7.put(r3, r10)
        L_0x005f:
            int r7 = r1.features
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.BeanToArray
            int r10 = r10.mask
            r7 = r7 & r10
            r11 = 0
            r12 = 1
            if (r7 != 0) goto L_0x0072
            int r7 = r6.features
            r7 = r7 & r10
            if (r7 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r7 = r11
            goto L_0x0073
        L_0x0072:
            r7 = r12
        L_0x0073:
            if (r7 == 0) goto L_0x0078
            r10 = 91
            goto L_0x007a
        L_0x0078:
            r10 = 123(0x7b, float:1.72E-43)
        L_0x007a:
            if (r7 == 0) goto L_0x007f
            r13 = 93
            goto L_0x0081
        L_0x007f:
            r13 = 125(0x7d, float:1.75E-43)
        L_0x0081:
            int r14 = r6.count     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r14 = r14 + r12
            char[] r15 = r6.buf     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r15 = r15.length     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            if (r14 <= r15) goto L_0x009f
            java.io.Writer r15 = r6.writer     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r15 != 0) goto L_0x009b
            r6.expandCapacity(r14)     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            goto L_0x009f
        L_0x0091:
            r0 = move-exception
            r4 = r0
            r3 = r9
            goto L_0x061d
        L_0x0096:
            r0 = move-exception
            r4 = r0
            r3 = r9
            goto L_0x05fa
        L_0x009b:
            r6.flush()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r14 = r12
        L_0x009f:
            char[] r15 = r6.buf     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r12 = r6.count     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r15[r12] = r10     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r6.count = r14     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r10 = r8.length     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            if (r10 <= 0) goto L_0x00b9
            int r10 = r6.features     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00b9
            r38.incrementIndent()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r38.println()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
        L_0x00b9:
            int r10 = r1.features     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r10 = r10 & r12
            r14 = 44
            if (r10 != 0) goto L_0x00da
            int r10 = r6.features     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r12 = r12 & r10
            if (r12 == 0) goto L_0x00fd
            if (r5 != 0) goto L_0x00da
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteRootClassName     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00da
            com.alibaba.fastjson.serializer.SerialContext r10 = r2.context     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r10 == 0) goto L_0x00fd
            com.alibaba.fastjson.serializer.SerialContext r10 = r10.parent     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r10 == 0) goto L_0x00fd
        L_0x00da:
            java.lang.Class r10 = r39.getClass()     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            if (r10 == r5) goto L_0x00fd
            java.lang.String r5 = r1.typeKey     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r5 == 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            com.alibaba.fastjson.serializer.SerializeConfig r5 = r2.config     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            java.lang.String r5 = r5.typeKey     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
        L_0x00e9:
            r6.writeFieldName(r5, r11)     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            java.lang.String r5 = r1.typeName     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r5 != 0) goto L_0x00f8
            java.lang.Class r5 = r39.getClass()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
        L_0x00f8:
            r2.write((java.lang.String) r5)     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r5 = r14
            goto L_0x00fe
        L_0x00fd:
            r5 = r11
        L_0x00fe:
            java.util.List<com.alibaba.fastjson.serializer.BeforeFilter> r10 = r2.beforeFilters     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            if (r10 == 0) goto L_0x0117
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
        L_0x0106:
            boolean r12 = r10.hasNext()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            if (r12 == 0) goto L_0x0117
            java.lang.Object r12 = r10.next()     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            com.alibaba.fastjson.serializer.BeforeFilter r12 = (com.alibaba.fastjson.serializer.BeforeFilter) r12     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            char r5 = r12.writeBefore(r2, r3, r5)     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            goto L_0x0106
        L_0x0117:
            if (r5 != r14) goto L_0x011b
            r5 = 1
            goto L_0x011c
        L_0x011b:
            r5 = r11
        L_0x011c:
            int r10 = r6.features     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.QuoteFieldNames     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r12 = r12 & r10
            if (r12 == 0) goto L_0x012e
            com.alibaba.fastjson.serializer.SerializerFeature r12 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            int r12 = r12.mask     // Catch:{ Exception -> 0x0096, all -> 0x0091 }
            r12 = r12 & r10
            if (r12 != 0) goto L_0x012e
            r12 = 1
            goto L_0x012f
        L_0x012e:
            r12 = r11
        L_0x012f:
            com.alibaba.fastjson.serializer.SerializerFeature r15 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r15 = r15.mask     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r15 = r15 & r10
            if (r15 == 0) goto L_0x0138
            r15 = 1
            goto L_0x0139
        L_0x0138:
            r15 = r11
        L_0x0139:
            com.alibaba.fastjson.serializer.SerializerFeature r14 = com.alibaba.fastjson.serializer.SerializerFeature.NotWriteDefaultValue     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            int r14 = r14.mask     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r10 = r10 & r14
            if (r10 == 0) goto L_0x0142
            r10 = 1
            goto L_0x0143
        L_0x0142:
            r10 = r11
        L_0x0143:
            java.util.List<com.alibaba.fastjson.serializer.PropertyFilter> r14 = r2.propertyFilters     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            java.util.List<com.alibaba.fastjson.serializer.NameFilter> r11 = r2.nameFilters     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r41 = r5
            java.util.List<com.alibaba.fastjson.serializer.ValueFilter> r5 = r2.valueFilters     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            java.util.List<com.alibaba.fastjson.serializer.PropertyPreFilter> r4 = r2.propertyPreFilters     // Catch:{ Exception -> 0x05f7, all -> 0x05f4 }
            r17 = r41
            r18 = r9
            r19 = r13
            r9 = 0
        L_0x0154:
            int r13 = r8.length     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            if (r9 >= r13) goto L_0x058c
            r13 = r8[r9]     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r20 = r8
            com.alibaba.fastjson.util.FieldInfo r8 = r13.fieldInfo     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r41 = r9
            java.lang.Class<?> r9 = r8.fieldClass     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r21 = r15
            java.lang.String r15 = r8.name     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r22 = r12
            int r12 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r23 = r10
            com.alibaba.fastjson.serializer.SerializerFeature r10 = com.alibaba.fastjson.serializer.SerializerFeature.SkipTransientField     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r10 = r10.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r10 = r10 & r12
            if (r10 == 0) goto L_0x0190
            java.lang.reflect.Field r10 = r8.field     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r10 == 0) goto L_0x0190
            boolean r10 = r8.fieldTransient     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r10 == 0) goto L_0x0190
        L_0x017a:
            r29 = r4
        L_0x017c:
            r31 = r5
            r30 = r11
            r32 = r14
            goto L_0x03ee
        L_0x0184:
            r0 = move-exception
            r4 = r0
            r3 = r18
            goto L_0x061d
        L_0x018a:
            r0 = move-exception
            r4 = r0
            r3 = r18
            goto L_0x05fa
        L_0x0190:
            java.lang.String r10 = r1.typeKey     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r10 == 0) goto L_0x019b
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r10 == 0) goto L_0x019b
            goto L_0x017a
        L_0x019b:
            if (r4 == 0) goto L_0x01b5
            java.util.Iterator r10 = r4.iterator()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x01a1:
            boolean r12 = r10.hasNext()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r12 == 0) goto L_0x01b5
            java.lang.Object r12 = r10.next()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.PropertyPreFilter r12 = (com.alibaba.fastjson.serializer.PropertyPreFilter) r12     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            boolean r12 = r12.apply(r2, r3, r15)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r12 != 0) goto L_0x01a1
            r10 = 0
            goto L_0x01b6
        L_0x01b5:
            r10 = 1
        L_0x01b6:
            if (r10 != 0) goto L_0x01b9
            goto L_0x017a
        L_0x01b9:
            boolean r10 = r8.fieldAccess     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r24 = 0
            if (r10 == 0) goto L_0x0208
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r12 = 0
            if (r9 != r10) goto L_0x01d4
            java.lang.reflect.Field r10 = r8.field     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r10 = r10.getInt(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r27 = r24
            r24 = 0
            r26 = 0
            r25 = r10
            r10 = 1
            goto L_0x020d
        L_0x01d4:
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r10) goto L_0x01e8
            java.lang.reflect.Field r10 = r8.field     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            long r24 = r10.getLong(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r27 = r24
            r10 = 1
            r24 = 0
        L_0x01e3:
            r25 = 0
            r26 = 0
            goto L_0x020d
        L_0x01e8:
            java.lang.Class r10 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r10) goto L_0x01fc
            java.lang.reflect.Field r10 = r8.field     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            boolean r10 = r10.getBoolean(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r26 = r10
            r27 = r24
            r10 = 1
            r24 = 0
            r25 = 0
            goto L_0x020d
        L_0x01fc:
            java.lang.reflect.Field r10 = r8.field     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            java.lang.Object r12 = r10.get(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x0202:
            r27 = r24
            r10 = 0
            r24 = 1
            goto L_0x01e3
        L_0x0208:
            java.lang.Object r12 = r13.getPropertyValue(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0202
        L_0x020d:
            if (r14 == 0) goto L_0x0253
            if (r10 == 0) goto L_0x0230
            r29 = r4
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x021e
            java.lang.Integer r12 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x021b:
            r24 = 1
            goto L_0x0232
        L_0x021e:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x0227
            java.lang.Long r12 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x021b
        L_0x0227:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x0232
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x021b
        L_0x0230:
            r29 = r4
        L_0x0232:
            java.util.Iterator r4 = r14.iterator()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x0236:
            boolean r30 = r4.hasNext()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r30 == 0) goto L_0x0251
            java.lang.Object r30 = r4.next()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r31 = r4
            r4 = r30
            com.alibaba.fastjson.serializer.PropertyFilter r4 = (com.alibaba.fastjson.serializer.PropertyFilter) r4     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            boolean r4 = r4.apply(r3, r15, r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r4 != 0) goto L_0x024e
            r4 = 0
            goto L_0x0256
        L_0x024e:
            r4 = r31
            goto L_0x0236
        L_0x0251:
            r4 = 1
            goto L_0x0256
        L_0x0253:
            r29 = r4
            goto L_0x0251
        L_0x0256:
            if (r4 != 0) goto L_0x025a
            goto L_0x017c
        L_0x025a:
            if (r11 == 0) goto L_0x029b
            if (r10 == 0) goto L_0x027d
            if (r24 != 0) goto L_0x027d
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x026b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x0268:
            r24 = 1
            goto L_0x027d
        L_0x026b:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x0274
            java.lang.Long r12 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0268
        L_0x0274:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x027d
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0268
        L_0x027d:
            java.util.Iterator r4 = r11.iterator()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r30 = r11
            r11 = r15
        L_0x0284:
            boolean r31 = r4.hasNext()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r31 == 0) goto L_0x029e
            java.lang.Object r31 = r4.next()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r32 = r4
            r4 = r31
            com.alibaba.fastjson.serializer.NameFilter r4 = (com.alibaba.fastjson.serializer.NameFilter) r4     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            java.lang.String r11 = r4.process(r3, r11, r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r4 = r32
            goto L_0x0284
        L_0x029b:
            r30 = r11
            r11 = r15
        L_0x029e:
            if (r5 == 0) goto L_0x02e2
            if (r10 == 0) goto L_0x02c1
            if (r24 != 0) goto L_0x02c1
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x02af
            java.lang.Integer r12 = java.lang.Integer.valueOf(r25)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x02ac:
            r24 = 1
            goto L_0x02c1
        L_0x02af:
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x02b8
            java.lang.Long r12 = java.lang.Long.valueOf(r27)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x02ac
        L_0x02b8:
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r4) goto L_0x02c1
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r26)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x02ac
        L_0x02c1:
            java.util.Iterator r4 = r5.iterator()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r31 = r5
            r5 = r12
        L_0x02c8:
            boolean r32 = r4.hasNext()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r32 == 0) goto L_0x02df
            java.lang.Object r32 = r4.next()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r33 = r4
            r4 = r32
            com.alibaba.fastjson.serializer.ValueFilter r4 = (com.alibaba.fastjson.serializer.ValueFilter) r4     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            java.lang.Object r5 = r4.process(r3, r15, r5)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r4 = r33
            goto L_0x02c8
        L_0x02df:
            r4 = r12
            r12 = r5
            goto L_0x02e5
        L_0x02e2:
            r31 = r5
            r4 = r12
        L_0x02e5:
            java.lang.String r5 = ""
            r32 = r14
            java.lang.Class<java.lang.String> r14 = java.lang.String.class
            if (r24 == 0) goto L_0x03a9
            if (r12 != 0) goto L_0x03a9
            r33 = r12
            int r12 = r8.serialzeFeatures     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r3 = r1.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 | r12
            int r12 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 | r12
            r34 = r8
            java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
            if (r9 != r8) goto L_0x0320
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullBooleanAsFalse     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r35 = r5
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r5 = r5 | r8
            if (r7 != 0) goto L_0x0315
            r36 = r3 & r5
            if (r36 != 0) goto L_0x0315
            r5 = r5 & r12
            if (r5 != 0) goto L_0x0315
            goto L_0x03ee
        L_0x0315:
            r3 = r3 & r8
            if (r3 != 0) goto L_0x031c
            r3 = r12 & r8
            if (r3 == 0) goto L_0x03af
        L_0x031c:
            java.lang.Boolean r12 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x03b1
        L_0x0320:
            r35 = r5
            if (r9 != r14) goto L_0x0343
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = r8 | r5
            if (r7 != 0) goto L_0x0338
            r36 = r3 & r8
            if (r36 != 0) goto L_0x0338
            r8 = r8 & r12
            if (r8 != 0) goto L_0x0338
            goto L_0x03ee
        L_0x0338:
            r3 = r3 & r5
            if (r3 != 0) goto L_0x033f
            r3 = r12 & r5
            if (r3 == 0) goto L_0x03af
        L_0x033f:
            r12 = r35
            goto L_0x03b1
        L_0x0343:
            java.lang.Class<java.lang.Number> r5 = java.lang.Number.class
            boolean r5 = r5.isAssignableFrom(r9)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 == 0) goto L_0x036f
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullNumberAsZero     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = r8 | r5
            if (r7 != 0) goto L_0x0361
            r12 = r3 & r8
            if (r12 != 0) goto L_0x0361
            int r12 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = r8 & r12
            if (r8 != 0) goto L_0x0361
            goto L_0x03ee
        L_0x0361:
            r3 = r3 & r5
            if (r3 != 0) goto L_0x0369
            int r3 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 & r5
            if (r3 == 0) goto L_0x03af
        L_0x0369:
            r3 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x03b1
        L_0x036f:
            java.lang.Class<java.util.Collection> r5 = java.util.Collection.class
            boolean r5 = r5.isAssignableFrom(r9)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 == 0) goto L_0x039a
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullListAsEmpty     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r8 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = r8 | r5
            if (r7 != 0) goto L_0x038d
            r12 = r3 & r8
            if (r12 != 0) goto L_0x038d
            int r12 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = r8 & r12
            if (r8 != 0) goto L_0x038d
            goto L_0x03ee
        L_0x038d:
            r3 = r3 & r5
            if (r3 != 0) goto L_0x0395
            int r3 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 & r5
            if (r3 == 0) goto L_0x03af
        L_0x0395:
            java.util.List r12 = java.util.Collections.emptyList()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x03b1
        L_0x039a:
            if (r7 != 0) goto L_0x03af
            boolean r3 = r13.writeNull     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 != 0) goto L_0x03af
            com.alibaba.fastjson.serializer.SerializerFeature r3 = com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            boolean r3 = r6.isEnabled(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 != 0) goto L_0x03af
            goto L_0x03ee
        L_0x03a9:
            r35 = r5
            r34 = r8
            r33 = r12
        L_0x03af:
            r12 = r33
        L_0x03b1:
            if (r24 == 0) goto L_0x03f3
            if (r12 == 0) goto L_0x03f3
            if (r23 == 0) goto L_0x03f3
            java.lang.Class r3 = java.lang.Byte.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 == r3) goto L_0x03cf
            java.lang.Class r3 = java.lang.Short.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 == r3) goto L_0x03cf
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 == r3) goto L_0x03cf
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 == r3) goto L_0x03cf
            java.lang.Class r3 = java.lang.Float.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 == r3) goto L_0x03cf
            java.lang.Class r3 = java.lang.Double.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r3) goto L_0x03dd
        L_0x03cf:
            boolean r3 = r12 instanceof java.lang.Number     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 == 0) goto L_0x03dd
            r3 = r12
            java.lang.Number r3 = (java.lang.Number) r3     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            byte r3 = r3.byteValue()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 != 0) goto L_0x03dd
            goto L_0x03ee
        L_0x03dd:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r3) goto L_0x03f3
            boolean r3 = r12 instanceof java.lang.Boolean     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 == 0) goto L_0x03f3
            r3 = r12
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            boolean r3 = r3.booleanValue()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 != 0) goto L_0x03f3
        L_0x03ee:
            r4 = 0
            r16 = 44
            goto L_0x0576
        L_0x03f3:
            if (r17 == 0) goto L_0x0421
            int r3 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r5 = 1
            int r3 = r3 + r5
            char[] r5 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 <= r5) goto L_0x040a
            java.io.Writer r5 = r6.writer     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 != 0) goto L_0x0406
            r6.expandCapacity(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x040a
        L_0x0406:
            r6.flush()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = 1
        L_0x040a:
            char[] r5 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r16 = 44
            r5[r8] = r16     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.count = r3     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r3 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 & r5
            if (r3 == 0) goto L_0x0423
            r38.println()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0423
        L_0x0421:
            r16 = 44
        L_0x0423:
            if (r11 == r15) goto L_0x0431
            if (r7 != 0) goto L_0x042b
            r3 = 1
            r6.writeFieldName(r11, r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x042b:
            r2.write((java.lang.Object) r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x042e:
            r4 = 0
            goto L_0x0574
        L_0x0431:
            if (r4 == r12) goto L_0x043c
            if (r7 != 0) goto L_0x0438
            r13.writePrefix(r2)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x0438:
            r2.write((java.lang.Object) r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x043c:
            if (r7 != 0) goto L_0x047d
            if (r22 == 0) goto L_0x047a
            char[] r3 = r13.name_chars     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r3.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5 + r4
            char[] r8 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 <= r8) goto L_0x046f
            java.io.Writer r8 = r6.writer     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r8 != 0) goto L_0x0453
            r6.expandCapacity(r5)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x046f
        L_0x0453:
            r5 = 0
        L_0x0454:
            char[] r8 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r11 = r8.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r15 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r11 = r11 - r15
            java.lang.System.arraycopy(r3, r5, r8, r15, r11)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            char[] r8 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.count = r8     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.flush()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r4 - r11
            int r5 = r5 + r11
            char[] r8 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r8 = r8.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r4 > r8) goto L_0x0454
            r8 = r5
            r5 = r4
            goto L_0x0470
        L_0x046f:
            r8 = 0
        L_0x0470:
            char[] r11 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r15 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            java.lang.System.arraycopy(r3, r8, r11, r15, r4)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.count = r5     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x047d
        L_0x047a:
            r13.writePrefix(r2)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x047d:
            if (r10 == 0) goto L_0x04f8
            if (r24 != 0) goto L_0x04f8
            java.lang.Class r3 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r3) goto L_0x04cf
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = r25
            if (r10 != r3) goto L_0x0491
            java.lang.String r3 = "-2147483648"
            r6.write((java.lang.String) r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x0491:
            if (r10 >= 0) goto L_0x0495
            int r3 = -r10
            goto L_0x0496
        L_0x0495:
            r3 = r10
        L_0x0496:
            r4 = 0
        L_0x0497:
            int[] r5 = com.alibaba.fastjson.serializer.SerializeWriter.sizeTable     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r5 = r5[r4]     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 > r5) goto L_0x04cc
            int r3 = r4 + 1
            if (r10 >= 0) goto L_0x04a3
            int r3 = r4 + 2
        L_0x04a3:
            int r4 = r6.count     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r4 + r3
            char[] r5 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r4 <= r5) goto L_0x04bf
            java.io.Writer r5 = r6.writer     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 != 0) goto L_0x04b3
            r6.expandCapacity(r4)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x04bf
        L_0x04b3:
            char[] r5 = new char[r3]     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            long r8 = (long) r10     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(r8, r3, r5)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = 0
            r6.write((char[]) r5, (int) r8, (int) r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = 1
            goto L_0x04c0
        L_0x04bf:
            r3 = 0
        L_0x04c0:
            if (r3 != 0) goto L_0x042e
            long r8 = (long) r10     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            char[] r3 = r6.buf     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializeWriter.getChars(r8, r4, r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.count = r4     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x04cc:
            int r4 = r4 + 1
            goto L_0x0497
        L_0x04cf:
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r3) goto L_0x04dc
            com.alibaba.fastjson.serializer.SerializeWriter r3 = r2.out     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r4 = r27
            r3.writeLong(r4)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x04dc:
            java.lang.Class r3 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r9 != r3) goto L_0x042e
            if (r26 == 0) goto L_0x04ed
            com.alibaba.fastjson.serializer.SerializeWriter r3 = r2.out     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            char[] r4 = true_chars     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r4.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = 0
            r3.write((char[]) r4, (int) r8, (int) r5)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x04ed:
            com.alibaba.fastjson.serializer.SerializeWriter r3 = r2.out     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            char[] r4 = false_chars     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r4.length     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r8 = 0
            r3.write((char[]) r4, (int) r8, (int) r5)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x04f8:
            if (r7 != 0) goto L_0x0570
            if (r9 != r14) goto L_0x052c
            int r3 = r13.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r1.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 | r4
            if (r12 != 0) goto L_0x051c
            int r4 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r4 = r4 & r5
            if (r4 != 0) goto L_0x050f
            r3 = r3 & r5
            if (r3 == 0) goto L_0x0512
        L_0x050f:
            r3 = r35
            goto L_0x0517
        L_0x0512:
            r6.writeNull()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x0517:
            r6.writeString(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x051c:
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r21 == 0) goto L_0x0525
            r6.writeStringWithSingleQuote(r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x0525:
            r3 = 0
            r4 = 1
            r6.writeStringWithDoubleQuote(r12, r3, r4)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x052c:
            r3 = r34
            boolean r3 = r3.isEnum     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r3 == 0) goto L_0x056b
            if (r12 == 0) goto L_0x0566
            int r3 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.WriteEnumUsingToString     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x055b
            java.lang.Enum r12 = (java.lang.Enum) r12     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            java.lang.String r3 = r12.toString()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r5 = com.alibaba.fastjson.serializer.SerializerFeature.UseSingleQuotes     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r5 = r5.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r4 = r4 & r5
            if (r4 == 0) goto L_0x054e
            r4 = 1
            goto L_0x054f
        L_0x054e:
            r4 = 0
        L_0x054f:
            if (r4 == 0) goto L_0x0556
            r6.writeStringWithSingleQuote(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x042e
        L_0x0556:
            r4 = 0
            r6.writeStringWithDoubleQuote(r3, r4, r4)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0574
        L_0x055b:
            r4 = 0
            java.lang.Enum r12 = (java.lang.Enum) r12     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r3 = r12.ordinal()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r6.writeInt(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0574
        L_0x0566:
            r4 = 0
            r6.writeNull()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0574
        L_0x056b:
            r4 = 0
            r13.writeValue(r2, r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x0574
        L_0x0570:
            r4 = 0
            r13.writeValue(r2, r12)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x0574:
            r17 = 1
        L_0x0576:
            int r9 = r41 + 1
            r3 = r39
            r8 = r20
            r15 = r21
            r12 = r22
            r10 = r23
            r4 = r29
            r11 = r30
            r5 = r31
            r14 = r32
            goto L_0x0154
        L_0x058c:
            r20 = r8
            r4 = 0
            r16 = 44
            java.util.List<com.alibaba.fastjson.serializer.AfterFilter> r3 = r2.afterFilters     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            if (r3 == 0) goto L_0x05b2
            if (r17 == 0) goto L_0x059a
            r11 = r16
            goto L_0x059b
        L_0x059a:
            r11 = r4
        L_0x059b:
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x059f:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r4 == 0) goto L_0x05b2
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.AfterFilter r4 = (com.alibaba.fastjson.serializer.AfterFilter) r4     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r5 = r39
            char r11 = r4.writeAfter(r2, r5, r11)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x059f
        L_0x05b2:
            r8 = r20
            int r3 = r8.length     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            if (r3 <= 0) goto L_0x05c6
            int r3 = r6.features     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            com.alibaba.fastjson.serializer.SerializerFeature r4 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            int r4 = r4.mask     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r3 = r3 & r4
            if (r3 == 0) goto L_0x05c6
            r38.decrementIdent()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r38.println()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
        L_0x05c6:
            int r3 = r6.count     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            r4 = 1
            int r3 = r3 + r4
            char[] r5 = r6.buf     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            int r5 = r5.length     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            if (r3 <= r5) goto L_0x05dc
            java.io.Writer r5 = r6.writer     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            if (r5 != 0) goto L_0x05d7
            r6.expandCapacity(r3)     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            goto L_0x05dc
        L_0x05d7:
            r6.flush()     // Catch:{ Exception -> 0x018a, all -> 0x0184 }
            r12 = r4
            goto L_0x05dd
        L_0x05dc:
            r12 = r3
        L_0x05dd:
            char[] r3 = r6.buf     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            int r4 = r6.count     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            r3[r4] = r19     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            r6.count = r12     // Catch:{ Exception -> 0x05ef, all -> 0x05ea }
            r3 = r18
            r2.context = r3
            return
        L_0x05ea:
            r0 = move-exception
            r3 = r18
        L_0x05ed:
            r4 = r0
            goto L_0x061d
        L_0x05ef:
            r0 = move-exception
            r3 = r18
        L_0x05f2:
            r4 = r0
            goto L_0x05fa
        L_0x05f4:
            r0 = move-exception
            r3 = r9
            goto L_0x05ed
        L_0x05f7:
            r0 = move-exception
            r3 = r9
            goto L_0x05f2
        L_0x05fa:
            java.lang.String r5 = "write javaBean error, fastjson version 1.1.70"
            r6 = r40
            if (r6 == 0) goto L_0x0617
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0615 }
            r7.<init>()     // Catch:{ all -> 0x0615 }
            r7.append(r5)     // Catch:{ all -> 0x0615 }
            java.lang.String r5 = ", fieldName : "
            r7.append(r5)     // Catch:{ all -> 0x0615 }
            r7.append(r6)     // Catch:{ all -> 0x0615 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0615 }
            goto L_0x0617
        L_0x0615:
            r0 = move-exception
            goto L_0x05ed
        L_0x0617:
            com.alibaba.fastjson.JSONException r6 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0615 }
            r6.<init>(r5, r4)     // Catch:{ all -> 0x0615 }
            throw r6     // Catch:{ all -> 0x0615 }
        L_0x061d:
            r2.context = r3
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), (Map<String, String>) null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, (PropertyNamingStrategy) null);
    }

    /* JADX WARNING: type inference failed for: r16v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaBeanSerializer(java.lang.Class<?> r16, int r17, java.util.Map<java.lang.String, java.lang.String> r18, boolean r19, boolean r20, boolean r21, boolean r22, com.alibaba.fastjson.PropertyNamingStrategy r23) {
        /*
            r15 = this;
            r0 = r15
            r15.<init>()
            r1 = 0
            r0.features = r1
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r2 = com.alibaba.fastjson.annotation.JSONType.class
            r3 = 0
            if (r20 == 0) goto L_0x0016
            r13 = r16
            java.lang.annotation.Annotation r4 = r13.getAnnotation(r2)
            com.alibaba.fastjson.annotation.JSONType r4 = (com.alibaba.fastjson.annotation.JSONType) r4
            r14 = r4
            goto L_0x0019
        L_0x0016:
            r13 = r16
            r14 = r3
        L_0x0019:
            if (r14 == 0) goto L_0x008d
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r14.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            r0.features = r4
            java.lang.String r4 = r14.typeName()
            int r5 = r4.length()
            if (r5 != 0) goto L_0x0032
            r4 = r3
            r6 = r4
            goto L_0x007f
        L_0x0032:
            java.lang.Class r5 = r16.getSuperclass()
            r6 = r3
        L_0x0037:
            if (r5 == 0) goto L_0x0056
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            if (r5 == r7) goto L_0x0056
            java.lang.annotation.Annotation r7 = r5.getAnnotation(r2)
            com.alibaba.fastjson.annotation.JSONType r7 = (com.alibaba.fastjson.annotation.JSONType) r7
            if (r7 != 0) goto L_0x0046
            goto L_0x0056
        L_0x0046:
            java.lang.String r6 = r7.typeKey()
            int r7 = r6.length()
            if (r7 == 0) goto L_0x0051
            goto L_0x0056
        L_0x0051:
            java.lang.Class r5 = r5.getSuperclass()
            goto L_0x0037
        L_0x0056:
            java.lang.Class[] r5 = r16.getInterfaces()
            int r7 = r5.length
            r8 = r1
        L_0x005c:
            if (r8 >= r7) goto L_0x0076
            r9 = r5[r8]
            java.lang.annotation.Annotation r9 = r9.getAnnotation(r2)
            com.alibaba.fastjson.annotation.JSONType r9 = (com.alibaba.fastjson.annotation.JSONType) r9
            if (r9 == 0) goto L_0x0073
            java.lang.String r6 = r9.typeKey()
            int r9 = r6.length()
            if (r9 == 0) goto L_0x0073
            goto L_0x0076
        L_0x0073:
            int r8 = r8 + 1
            goto L_0x005c
        L_0x0076:
            if (r6 == 0) goto L_0x007f
            int r2 = r6.length()
            if (r2 != 0) goto L_0x007f
            r6 = r3
        L_0x007f:
            if (r23 != 0) goto L_0x008a
            com.alibaba.fastjson.PropertyNamingStrategy r2 = r14.naming()
            com.alibaba.fastjson.PropertyNamingStrategy r5 = com.alibaba.fastjson.PropertyNamingStrategy.CamelCase
            if (r2 == r5) goto L_0x008a
            goto L_0x0091
        L_0x008a:
            r2 = r23
            goto L_0x0091
        L_0x008d:
            r2 = r23
            r4 = r3
            r6 = r4
        L_0x0091:
            r0.typeName = r4
            r0.typeKey = r6
            r9 = 0
            r4 = r16
            r5 = r17
            r6 = r19
            r7 = r14
            r8 = r18
            r10 = r21
            r11 = r22
            r12 = r2
            java.util.List r4 = com.alibaba.fastjson.util.TypeUtils.computeGetters(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x00b1:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x00c6
            java.lang.Object r6 = r4.next()
            com.alibaba.fastjson.util.FieldInfo r6 = (com.alibaba.fastjson.util.FieldInfo) r6
            com.alibaba.fastjson.serializer.FieldSerializer r7 = new com.alibaba.fastjson.serializer.FieldSerializer
            r7.<init>(r6)
            r5.add(r7)
            goto L_0x00b1
        L_0x00c6:
            int r4 = r5.size()
            com.alibaba.fastjson.serializer.FieldSerializer[] r4 = new com.alibaba.fastjson.serializer.FieldSerializer[r4]
            java.lang.Object[] r4 = r5.toArray(r4)
            com.alibaba.fastjson.serializer.FieldSerializer[] r4 = (com.alibaba.fastjson.serializer.FieldSerializer[]) r4
            r0.getters = r4
            if (r14 == 0) goto L_0x00da
            java.lang.String[] r3 = r14.orders()
        L_0x00da:
            if (r3 == 0) goto L_0x011f
            int r3 = r3.length
            if (r3 == 0) goto L_0x011f
            r9 = 1
            r4 = r16
            r5 = r17
            r6 = r19
            r7 = r14
            r8 = r18
            r10 = r21
            r11 = r22
            r12 = r2
            java.util.List r1 = com.alibaba.fastjson.util.TypeUtils.computeGetters(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x00fb:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0110
            java.lang.Object r3 = r1.next()
            com.alibaba.fastjson.util.FieldInfo r3 = (com.alibaba.fastjson.util.FieldInfo) r3
            com.alibaba.fastjson.serializer.FieldSerializer r4 = new com.alibaba.fastjson.serializer.FieldSerializer
            r4.<init>(r3)
            r2.add(r4)
            goto L_0x00fb
        L_0x0110:
            int r1 = r2.size()
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = new com.alibaba.fastjson.serializer.FieldSerializer[r1]
            java.lang.Object[] r1 = r2.toArray(r1)
            com.alibaba.fastjson.serializer.FieldSerializer[] r1 = (com.alibaba.fastjson.serializer.FieldSerializer[]) r1
            r0.sortedGetters = r1
            goto L_0x0134
        L_0x011f:
            int r2 = r4.length
            com.alibaba.fastjson.serializer.FieldSerializer[] r2 = new com.alibaba.fastjson.serializer.FieldSerializer[r2]
            int r3 = r4.length
            java.lang.System.arraycopy(r4, r1, r2, r1, r3)
            java.util.Arrays.sort(r2)
            boolean r1 = java.util.Arrays.equals(r2, r4)
            if (r1 == 0) goto L_0x0132
            r0.sortedGetters = r4
            goto L_0x0134
        L_0x0132:
            r0.sortedGetters = r2
        L_0x0134:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.<init>(java.lang.Class, int, java.util.Map, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):void");
    }
}
