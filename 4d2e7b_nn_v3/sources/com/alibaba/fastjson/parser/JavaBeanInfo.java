package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class JavaBeanInfo {
    final Constructor<?> creatorConstructor;
    public final String[] creatorConstructorParameters;
    final Constructor<?> defaultConstructor;
    final int defaultConstructorParameterSize;
    final Method factoryMethod;
    final FieldInfo[] fields;
    final JSONType jsonType;
    boolean ordered = false;
    public final int parserFeatures;
    final FieldInfo[] sortedFields;
    final boolean supportBeanToArray;
    public final String typeKey;
    public final String typeName;

    JavaBeanInfo(Class<?> cls, Constructor<?> constructor, Constructor<?> constructor2, Method method, FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2, JSONType jSONType, String[] strArr) {
        int i10;
        boolean z10;
        int i11 = 0;
        this.defaultConstructor = constructor;
        this.creatorConstructor = constructor2;
        this.factoryMethod = method;
        this.fields = fieldInfoArr;
        this.jsonType = jSONType;
        String str = null;
        if (strArr == null || strArr.length != fieldInfoArr.length) {
            this.creatorConstructorParameters = strArr;
        } else {
            this.creatorConstructorParameters = null;
        }
        if (jSONType != null) {
            String typeName2 = jSONType.typeName();
            this.typeName = typeName2.length() <= 0 ? cls.getName() : typeName2;
            String typeKey2 = jSONType.typeKey();
            this.typeKey = typeKey2.length() > 0 ? typeKey2 : str;
            i10 = 0;
            for (Feature feature : jSONType.parseFeatures()) {
                i10 |= feature.mask;
            }
        } else {
            this.typeName = cls.getName();
            this.typeKey = null;
            i10 = 0;
        }
        this.parserFeatures = i10;
        if (jSONType != null) {
            z10 = false;
            for (Feature feature2 : jSONType.parseFeatures()) {
                if (feature2 == Feature.SupportArrayToBean) {
                    z10 = true;
                }
            }
        } else {
            z10 = false;
        }
        this.supportBeanToArray = z10;
        FieldInfo[] computeSortedFields = computeSortedFields(fieldInfoArr, fieldInfoArr2);
        this.sortedFields = !Arrays.equals(fieldInfoArr, computeSortedFields) ? computeSortedFields : fieldInfoArr;
        if (constructor != null) {
            i11 = constructor.getParameterTypes().length;
        } else if (method != null) {
            i11 = method.getParameterTypes().length;
        }
        this.defaultConstructorParameterSize = i11;
    }

    static boolean addField(List<FieldInfo> list, FieldInfo fieldInfo, boolean z10) {
        if (!z10) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                FieldInfo fieldInfo2 = list.get(i10);
                if (fieldInfo2.name.equals(fieldInfo.name) && (!fieldInfo2.getOnly || fieldInfo.getOnly)) {
                    return false;
                }
            }
        }
        list.add(fieldInfo);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: com.alibaba.fastjson.annotation.JSONType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v7, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v8, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v9, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v10, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v11, resolved type: com.alibaba.fastjson.annotation.JSONField} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: com.alibaba.fastjson.annotation.JSONType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: com.alibaba.fastjson.annotation.JSONType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: com.alibaba.fastjson.annotation.JSONType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: java.lang.Class<com.alibaba.fastjson.annotation.JSONField>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v36, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v37, resolved type: java.lang.Class<? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: java.lang.Class<? super ? super java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v102, resolved type: java.lang.annotation.Annotation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v103, resolved type: java.lang.annotation.Annotation} */
    /* JADX WARNING: type inference failed for: r0v51, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: type inference failed for: r0v67, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: type inference failed for: r0v80, types: [java.lang.reflect.Type[]] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0537  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0657  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.fastjson.parser.JavaBeanInfo build(java.lang.Class<?> r48, int r49, java.lang.reflect.Type r50, boolean r51, boolean r52, boolean r53, boolean r54, com.alibaba.fastjson.PropertyNamingStrategy r55) {
        /*
            r11 = r48
            r12 = r49
            r13 = r51
            r14 = r55
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            java.lang.reflect.Constructor[] r0 = r48.getDeclaredConstructors()
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.isKotlin(r48)
            r2 = r12 & 1024(0x400, float:1.435E-42)
            r8 = 1
            r7 = 0
            r6 = 0
            if (r2 != 0) goto L_0x0059
            int r3 = r0.length
            if (r3 == r8) goto L_0x0026
            if (r1 != 0) goto L_0x0059
        L_0x0026:
            java.lang.reflect.Constructor r3 = r11.getDeclaredConstructor(r6)     // Catch:{ Exception -> 0x002b }
            goto L_0x002c
        L_0x002b:
            r3 = r6
        L_0x002c:
            if (r3 != 0) goto L_0x0057
            boolean r4 = r48.isMemberClass()
            if (r4 == 0) goto L_0x0057
            r4 = r12 & 8
            if (r4 != 0) goto L_0x0057
            int r4 = r0.length
            r5 = r7
        L_0x003a:
            if (r5 >= r4) goto L_0x0057
            r16 = r0[r5]
            java.lang.Class[] r6 = r16.getParameterTypes()
            int r15 = r6.length
            if (r15 != r8) goto L_0x0054
            r6 = r6[r7]
            java.lang.Class r15 = r48.getDeclaringClass()
            boolean r6 = r6.equals(r15)
            if (r6 == 0) goto L_0x0054
            r15 = r16
            goto L_0x005a
        L_0x0054:
            int r5 = r5 + r8
            r6 = 0
            goto L_0x003a
        L_0x0057:
            r15 = r3
            goto L_0x005a
        L_0x0059:
            r15 = 0
        L_0x005a:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONCreator> r3 = com.alibaba.fastjson.annotation.JSONCreator.class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            if (r13 == 0) goto L_0x0066
            r21 = r6
            r8 = 0
            r14 = 0
            goto L_0x00d0
        L_0x0066:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = r11
            r16 = 0
        L_0x006e:
            if (r5 == 0) goto L_0x00c2
            if (r5 == r6) goto L_0x00c2
            java.lang.reflect.Method[] r7 = r5.getDeclaredMethods()
            int r8 = r7.length
            r21 = r6
            r6 = 0
        L_0x007a:
            if (r6 >= r8) goto L_0x00b7
            r22 = r8
            r8 = r7[r6]
            r23 = r7
            int r7 = r8.getModifiers()
            r24 = r7 & 8
            if (r24 == 0) goto L_0x009e
            boolean r7 = r8.isAnnotationPresent(r3)
            if (r7 == 0) goto L_0x0094
            if (r16 != 0) goto L_0x0096
            r16 = r8
        L_0x0094:
            r7 = 1
            goto L_0x00af
        L_0x0096:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "multi-json creator"
            r0.<init>(r1)
            throw r0
        L_0x009e:
            r24 = r7 & 2
            if (r24 != 0) goto L_0x0094
            r14 = r7 & 256(0x100, float:3.59E-43)
            if (r14 != 0) goto L_0x0094
            r14 = 4
            r7 = r7 & r14
            if (r7 == 0) goto L_0x00ab
            goto L_0x0094
        L_0x00ab:
            r4.add(r8)
            goto L_0x0094
        L_0x00af:
            int r6 = r6 + r7
            r14 = r55
            r8 = r22
            r7 = r23
            goto L_0x007a
        L_0x00b7:
            java.lang.Class r5 = r5.getSuperclass()
            r14 = r55
            r6 = r21
            r7 = 0
            r8 = 1
            goto L_0x006e
        L_0x00c2:
            r21 = r6
            int r5 = r4.size()
            java.lang.reflect.Method[] r5 = new java.lang.reflect.Method[r5]
            r4.toArray(r5)
            r8 = r5
            r14 = r16
        L_0x00d0:
            java.lang.reflect.Field[] r7 = r48.getDeclaredFields()
            boolean r4 = r48.isInterface()
            if (r4 != 0) goto L_0x00df
            if (r2 == 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r2 = 0
            goto L_0x00e0
        L_0x00df:
            r2 = 1
        L_0x00e0:
            java.lang.Class<com.alibaba.fastjson.annotation.JSONType> r6 = com.alibaba.fastjson.annotation.JSONType.class
            java.lang.Class<com.alibaba.fastjson.annotation.JSONField> r5 = com.alibaba.fastjson.annotation.JSONField.class
            r16 = 0
            if (r15 == 0) goto L_0x00fe
            if (r2 == 0) goto L_0x00eb
            goto L_0x00fe
        L_0x00eb:
            r23 = r6
            r28 = r8
            r29 = r9
            r32 = r15
            r34 = r21
            r8 = 0
            r17 = 0
            r22 = 0
            r9 = r5
            r15 = r7
            goto L_0x042a
        L_0x00fe:
            int r4 = r0.length
            r22 = r5
            r5 = 0
        L_0x0102:
            if (r5 >= r4) goto L_0x0117
            r23 = r4
            r4 = r0[r5]
            java.lang.annotation.Annotation r24 = r4.getAnnotation(r3)
            com.alibaba.fastjson.annotation.JSONCreator r24 = (com.alibaba.fastjson.annotation.JSONCreator) r24
            if (r24 == 0) goto L_0x0112
            r5 = r4
            goto L_0x0118
        L_0x0112:
            r4 = 1
            int r5 = r5 + r4
            r4 = r23
            goto L_0x0102
        L_0x0117:
            r5 = 0
        L_0x0118:
            java.lang.String r4 = "illegal json creator"
            if (r5 == 0) goto L_0x020d
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r5, r12)
            java.lang.Class[] r3 = r5.getParameterTypes()
            if (r54 == 0) goto L_0x012c
            java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
            r16 = r0
            goto L_0x012e
        L_0x012c:
            r16 = r3
        L_0x012e:
            java.lang.annotation.Annotation[][] r23 = r5.getParameterAnnotations()
            r2 = 0
        L_0x0133:
            int r0 = r3.length
            if (r2 >= r0) goto L_0x01c5
            r0 = r23[r2]
            int r1 = r0.length
            r24 = r4
            r4 = 0
        L_0x013c:
            if (r4 >= r1) goto L_0x0152
            r25 = r1
            r1 = r0[r4]
            r26 = r0
            boolean r0 = r1 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r0 == 0) goto L_0x014b
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x0153
        L_0x014b:
            r0 = 1
            int r4 = r4 + r0
            r1 = r25
            r0 = r26
            goto L_0x013c
        L_0x0152:
            r1 = 0
        L_0x0153:
            if (r1 == 0) goto L_0x01bd
            r4 = r3[r2]
            r25 = r16[r2]
            java.lang.String r0 = r1.name()
            java.lang.reflect.Field r0 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r7, r9)
            if (r0 == 0) goto L_0x0166
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r0, r12)
        L_0x0166:
            int r26 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r27 = r1.serialzeFeatures()
            int r27 = com.alibaba.fastjson.serializer.SerializerFeature.of(r27)
            r28 = r8
            com.alibaba.fastjson.util.FieldInfo r8 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r1 = r1.name()
            r29 = r0
            r0 = r8
            r30 = r2
            r2 = r48
            r31 = r3
            r3 = r4
            r32 = r15
            r15 = r24
            r4 = r25
            r33 = r22
            r22 = r5
            r5 = r29
            r34 = r21
            r17 = 0
            r21 = r9
            r9 = r6
            r6 = r26
            r35 = r7
            r12 = 0
            r7 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r8, r13)
            r0 = 1
            int r2 = r30 + 1
            r12 = r49
            r6 = r9
            r4 = r15
            r9 = r21
            r5 = r22
            r8 = r28
            r3 = r31
            r15 = r32
            r22 = r33
            r21 = r34
            r7 = r35
            goto L_0x0133
        L_0x01bd:
            r15 = r24
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r15)
            throw r0
        L_0x01c5:
            r35 = r7
            r28 = r8
            r32 = r15
            r34 = r21
            r33 = r22
            r12 = 0
            r17 = 0
            r22 = r5
            r21 = r9
            r9 = r6
            int r0 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r10.toArray(r1)
            com.alibaba.fastjson.util.FieldInfo[] r2 = new com.alibaba.fastjson.util.FieldInfo[r0]
            java.lang.System.arraycopy(r1, r12, r2, r12, r0)
            java.util.Arrays.sort(r2)
            if (r52 == 0) goto L_0x01f0
            java.lang.annotation.Annotation r2 = r11.getAnnotation(r9)
            com.alibaba.fastjson.annotation.JSONType r2 = (com.alibaba.fastjson.annotation.JSONType) r2
        L_0x01f0:
            java.lang.String[] r2 = new java.lang.String[r0]
            r7 = r12
        L_0x01f3:
            if (r7 >= r0) goto L_0x01fe
            r3 = r1[r7]
            java.lang.String r3 = r3.name
            r2[r7] = r3
            r3 = 1
            int r7 = r7 + r3
            goto L_0x01f3
        L_0x01fe:
            r16 = r2
            r23 = r9
            r8 = r12
            r29 = r21
            r9 = r33
            r15 = r35
            r12 = r49
            goto L_0x042a
        L_0x020d:
            r35 = r7
            r28 = r8
            r32 = r15
            r34 = r21
            r33 = r22
            r12 = 0
            r17 = 0
            r15 = r4
            r22 = r5
            r21 = r9
            r9 = r6
            if (r14 == 0) goto L_0x02e3
            r8 = r12
            r12 = r49
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r14, r12)
            java.lang.Class[] r7 = r14.getParameterTypes()
            int r0 = r7.length
            if (r0 <= 0) goto L_0x02d9
            if (r54 == 0) goto L_0x0237
            java.lang.reflect.Type[] r0 = r14.getGenericParameterTypes()
            r12 = r0
            goto L_0x0238
        L_0x0237:
            r12 = r7
        L_0x0238:
            java.lang.annotation.Annotation[][] r18 = r14.getParameterAnnotations()
            r6 = r8
        L_0x023d:
            int r0 = r7.length
            if (r6 >= r0) goto L_0x02a4
            r0 = r18[r6]
            int r1 = r0.length
            r2 = r8
        L_0x0244:
            if (r2 >= r1) goto L_0x0253
            r3 = r0[r2]
            boolean r4 = r3 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r4 == 0) goto L_0x0250
            r0 = r3
            com.alibaba.fastjson.annotation.JSONField r0 = (com.alibaba.fastjson.annotation.JSONField) r0
            goto L_0x0255
        L_0x0250:
            r3 = 1
            int r2 = r2 + r3
            goto L_0x0244
        L_0x0253:
            r0 = r17
        L_0x0255:
            if (r0 == 0) goto L_0x029e
            r3 = r7[r6]
            r4 = r12[r6]
            java.lang.String r1 = r0.name()
            r5 = r21
            r2 = r35
            java.lang.reflect.Field r19 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r1, r2, r5)
            int r21 = r0.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r0.serialzeFeatures()
            int r22 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            com.alibaba.fastjson.util.FieldInfo r1 = new com.alibaba.fastjson.util.FieldInfo
            java.lang.String r23 = r0.name()
            r0 = r1
            r8 = r1
            r1 = r23
            r36 = r2
            r2 = r48
            r37 = r5
            r5 = r19
            r19 = r6
            r6 = r21
            r21 = r7
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r8, r13)
            r0 = 1
            int r6 = r19 + 1
            r7 = r21
            r35 = r36
            r21 = r37
            r8 = 0
            goto L_0x023d
        L_0x029e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r15)
            throw r0
        L_0x02a4:
            int r0 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r5 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r10.toArray(r5)
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r2 = 0
            java.lang.System.arraycopy(r5, r2, r1, r2, r0)
            java.util.Arrays.sort(r1)
            boolean r0 = java.util.Arrays.equals(r5, r1)
            if (r0 == 0) goto L_0x02be
            r6 = r5
            goto L_0x02bf
        L_0x02be:
            r6 = r1
        L_0x02bf:
            if (r52 == 0) goto L_0x02c9
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r9)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
            r7 = r0
            goto L_0x02cb
        L_0x02c9:
            r7 = r17
        L_0x02cb:
            com.alibaba.fastjson.parser.JavaBeanInfo r9 = new com.alibaba.fastjson.parser.JavaBeanInfo
            r2 = 0
            r3 = 0
            r0 = r9
            r1 = r48
            r4 = r14
            r8 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x02d9:
            r23 = r9
            r29 = r21
            r9 = r33
            r15 = r35
            goto L_0x042a
        L_0x02e3:
            r12 = r49
            r37 = r21
            r36 = r35
            if (r2 != 0) goto L_0x0421
            java.lang.String r2 = "default constructor not found. "
            if (r1 == 0) goto L_0x040c
            int r1 = r0.length
            if (r1 <= 0) goto L_0x040c
            java.lang.String[] r8 = com.alibaba.fastjson.util.TypeUtils.getKoltinConstructorParameters(r48)
            if (r8 == 0) goto L_0x03f7
            int r1 = r0.length
            r15 = r22
            r7 = 0
        L_0x02fc:
            if (r7 >= r1) goto L_0x0329
            r2 = r0[r7]
            java.lang.Class[] r3 = r2.getParameterTypes()
            int r4 = r3.length
            if (r4 <= 0) goto L_0x0319
            int r4 = r3.length
            r5 = 1
            int r4 = r4 - r5
            r4 = r3[r4]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = "kotlin.jvm.internal.DefaultConstructorMarker"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0319
            goto L_0x0323
        L_0x0319:
            if (r15 == 0) goto L_0x0325
            java.lang.Class[] r4 = r15.getParameterTypes()
            int r4 = r4.length
            int r3 = r3.length
            if (r4 < r3) goto L_0x0325
        L_0x0323:
            r2 = 1
            goto L_0x0327
        L_0x0325:
            r15 = r2
            goto L_0x0323
        L_0x0327:
            int r7 = r7 + r2
            goto L_0x02fc
        L_0x0329:
            r2 = 1
            r15.setAccessible(r2)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r15, r12)
            java.lang.Class[] r7 = r15.getParameterTypes()
            if (r54 == 0) goto L_0x033d
            java.lang.reflect.Type[] r0 = r15.getGenericParameterTypes()
            r16 = r0
            goto L_0x033f
        L_0x033d:
            r16 = r7
        L_0x033f:
            java.lang.annotation.Annotation[][] r19 = r15.getParameterAnnotations()
            r6 = 0
        L_0x0344:
            int r0 = r7.length
            if (r6 >= r0) goto L_0x03c8
            r0 = r8[r6]
            r1 = r19[r6]
            int r2 = r1.length
            r3 = 0
        L_0x034d:
            if (r3 >= r2) goto L_0x035c
            r4 = r1[r3]
            boolean r5 = r4 instanceof com.alibaba.fastjson.annotation.JSONField
            if (r5 == 0) goto L_0x0359
            r1 = r4
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x035e
        L_0x0359:
            r4 = 1
            int r3 = r3 + r4
            goto L_0x034d
        L_0x035c:
            r1 = r17
        L_0x035e:
            r3 = r7[r6]
            r4 = r16[r6]
            r21 = r6
            r2 = r36
            r5 = r37
            java.lang.reflect.Field r6 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r2, r5)
            if (r6 == 0) goto L_0x037b
            if (r1 != 0) goto L_0x037b
            r23 = r9
            r9 = r33
            java.lang.annotation.Annotation r1 = r6.getAnnotation(r9)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x037f
        L_0x037b:
            r23 = r9
            r9 = r33
        L_0x037f:
            if (r1 == 0) goto L_0x039a
            int r22 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r25 = r1.serialzeFeatures()
            int r25 = com.alibaba.fastjson.serializer.SerializerFeature.of(r25)
            java.lang.String r1 = r1.name()
            int r26 = r1.length()
            if (r26 == 0) goto L_0x0398
            r0 = r1
        L_0x0398:
            r1 = r0
            goto L_0x039f
        L_0x039a:
            r1 = r0
            r22 = 0
            r25 = 0
        L_0x039f:
            com.alibaba.fastjson.util.FieldInfo r0 = new com.alibaba.fastjson.util.FieldInfo
            r26 = r0
            r27 = r15
            r15 = r2
            r2 = r48
            r29 = r5
            r5 = r6
            r6 = r22
            r22 = r7
            r7 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            addField(r10, r0, r13)
            r0 = 1
            int r6 = r21 + 1
            r33 = r9
            r36 = r15
            r7 = r22
            r9 = r23
            r15 = r27
            r37 = r29
            goto L_0x0344
        L_0x03c8:
            r23 = r9
            r27 = r15
            r9 = r33
            r15 = r36
            r29 = r37
            int r0 = r10.size()
            com.alibaba.fastjson.util.FieldInfo[] r1 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r10.toArray(r1)
            com.alibaba.fastjson.util.FieldInfo[] r2 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r8 = 0
            java.lang.System.arraycopy(r1, r8, r2, r8, r0)
            java.util.Arrays.sort(r2)
            java.lang.String[] r2 = new java.lang.String[r0]
            r7 = r8
        L_0x03e7:
            if (r7 >= r0) goto L_0x03f2
            r3 = r1[r7]
            java.lang.String r3 = r3.name
            r2[r7] = r3
            r3 = 1
            int r7 = r7 + r3
            goto L_0x03e7
        L_0x03f2:
            r16 = r2
            r22 = r27
            goto L_0x042a
        L_0x03f7:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x040c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0421:
            r23 = r9
            r9 = r33
            r15 = r36
            r29 = r37
            r8 = 0
        L_0x042a:
            r7 = r32
            if (r32 == 0) goto L_0x0431
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r7, r12)
        L_0x0431:
            if (r13 != 0) goto L_0x069f
            r5 = r28
            int r4 = r5.length
            r3 = r8
        L_0x0437:
            if (r3 >= r4) goto L_0x068f
            r2 = r5[r3]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            r6 = 4
            if (r1 >= r6) goto L_0x045d
        L_0x0446:
            r30 = r3
            r25 = r4
            r38 = r5
            r32 = r7
            r42 = r9
            r19 = r14
            r35 = r15
            r40 = r23
            r27 = r29
            r26 = 1
        L_0x045a:
            r14 = r10
            goto L_0x0679
        L_0x045d:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r6 = java.lang.Void.TYPE
            if (r1 == r6) goto L_0x046b
            java.lang.Class r6 = r2.getDeclaringClass()
            if (r1 != r6) goto L_0x0446
        L_0x046b:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            r6 = 1
            if (r1 == r6) goto L_0x0488
        L_0x0473:
            r30 = r3
            r25 = r4
            r38 = r5
            r26 = r6
            r32 = r7
            r42 = r9
            r19 = r14
            r35 = r15
            r40 = r23
            r27 = r29
            goto L_0x045a
        L_0x0488:
            if (r53 == 0) goto L_0x0491
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r9)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            goto L_0x0493
        L_0x0491:
            r1 = r17
        L_0x0493:
            if (r1 != 0) goto L_0x049b
            if (r53 == 0) goto L_0x049b
            com.alibaba.fastjson.annotation.JSONField r1 = com.alibaba.fastjson.util.TypeUtils.getSupperMethodAnnotation(r11, r2)
        L_0x049b:
            r20 = r1
            if (r20 == 0) goto L_0x0519
            boolean r1 = r20.deserialize()
            if (r1 != 0) goto L_0x04a6
            goto L_0x0473
        L_0x04a6:
            int r21 = r20.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r20.serialzeFeatures()
            int r24 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            java.lang.String r1 = r20.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0504
            java.lang.String r1 = r20.name()
            com.alibaba.fastjson.util.FieldInfo r0 = new com.alibaba.fastjson.util.FieldInfo
            r25 = 0
            r26 = 0
            r27 = r0
            r28 = r2
            r30 = r3
            r3 = r25
            r25 = r4
            r4 = r48
            r31 = r5
            r5 = r50
            r19 = r6
            r6 = r21
            r32 = r7
            r7 = r24
            r38 = r31
            r8 = r20
            r41 = r9
            r40 = r23
            r39 = r29
            r9 = r26
            r19 = r14
            r14 = r10
            r10 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            addField(r14, r0, r13)
            r10 = r28
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r10, r12)
        L_0x04fa:
            r35 = r15
            r27 = r39
            r42 = r41
            r26 = 1
            goto L_0x0679
        L_0x0504:
            r30 = r3
            r25 = r4
            r38 = r5
            r32 = r7
            r41 = r9
            r19 = r14
            r40 = r23
            r39 = r29
            r14 = r10
            r10 = r2
            r7 = r21
            goto L_0x052e
        L_0x0519:
            r30 = r3
            r25 = r4
            r38 = r5
            r32 = r7
            r41 = r9
            r19 = r14
            r40 = r23
            r39 = r29
            r14 = r10
            r10 = r2
            r7 = 0
            r24 = 0
        L_0x052e:
            java.lang.String r1 = "set"
            boolean r1 = r0.startsWith(r1)
            if (r1 != 0) goto L_0x0537
            goto L_0x04fa
        L_0x0537:
            r9 = 3
            char r1 = r0.charAt(r9)
            boolean r2 = java.lang.Character.isUpperCase(r1)
            if (r2 == 0) goto L_0x056e
            boolean r1 = com.alibaba.fastjson.util.TypeUtils.compatibleWithJavaBean
            if (r1 == 0) goto L_0x0551
            java.lang.String r0 = r0.substring(r9)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
        L_0x054e:
            r8 = r39
            goto L_0x059b
        L_0x0551:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r2 = r0.charAt(r9)
            char r2 = java.lang.Character.toLowerCase(r2)
            r1.append(r2)
            r2 = 4
            java.lang.String r0 = r0.substring(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x054e
        L_0x056e:
            r2 = 4
            r3 = 95
            if (r1 != r3) goto L_0x0578
            java.lang.String r0 = r0.substring(r2)
            goto L_0x054e
        L_0x0578:
            r3 = 102(0x66, float:1.43E-43)
            if (r1 != r3) goto L_0x0581
            java.lang.String r0 = r0.substring(r9)
            goto L_0x054e
        L_0x0581:
            int r1 = r0.length()
            r3 = 5
            if (r1 < r3) goto L_0x04fa
            char r1 = r0.charAt(r2)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x04fa
            java.lang.String r0 = r0.substring(r9)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.decapitalize(r0)
            goto L_0x054e
        L_0x059b:
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r0, r15, r8)
            if (r1 != 0) goto L_0x05d5
            java.lang.Class[] r2 = r10.getParameterTypes()
            r6 = 0
            r2 = r2[r6]
            java.lang.Class r3 = java.lang.Boolean.TYPE
            if (r2 != r3) goto L_0x05d3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "is"
            r1.append(r2)
            char r2 = r0.charAt(r6)
            char r2 = java.lang.Character.toUpperCase(r2)
            r1.append(r2)
            r5 = 1
            java.lang.String r2 = r0.substring(r5)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.getField(r11, r1, r15, r8)
        L_0x05d1:
            r3 = r1
            goto L_0x05d8
        L_0x05d3:
            r5 = 1
            goto L_0x05d1
        L_0x05d5:
            r5 = 1
            r6 = 0
            goto L_0x05d1
        L_0x05d8:
            if (r3 == 0) goto L_0x0646
            r4 = r41
            if (r53 == 0) goto L_0x05e7
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r4)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r21 = r1
            goto L_0x05e9
        L_0x05e7:
            r21 = r17
        L_0x05e9:
            if (r21 == 0) goto L_0x063d
            int r7 = r21.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r21.serialzeFeatures()
            int r23 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            java.lang.String r1 = r21.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0628
            java.lang.String r1 = r21.name()
            com.alibaba.fastjson.util.FieldInfo r2 = new com.alibaba.fastjson.util.FieldInfo
            r0 = r2
            r35 = r15
            r15 = r2
            r2 = r10
            r10 = r4
            r4 = r48
            r26 = r5
            r5 = r50
            r6 = r7
            r7 = r23
            r27 = r8
            r8 = r20
            r9 = r21
            r42 = r10
            r10 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            addField(r14, r15, r13)
            goto L_0x0679
        L_0x0628:
            r42 = r4
            r26 = r5
            r27 = r8
            r35 = r15
            r15 = r55
            r6 = r7
            if (r20 != 0) goto L_0x063a
            r8 = r21
        L_0x0637:
            r7 = r23
            goto L_0x0655
        L_0x063a:
            r8 = r20
            goto L_0x0637
        L_0x063d:
            r42 = r4
            r26 = r5
            r27 = r8
            r35 = r15
            goto L_0x064e
        L_0x0646:
            r26 = r5
            r27 = r8
            r35 = r15
            r42 = r41
        L_0x064e:
            r15 = r55
            r6 = r7
            r8 = r20
            r7 = r24
        L_0x0655:
            if (r15 == 0) goto L_0x065b
            java.lang.String r0 = r15.translate(r0)
        L_0x065b:
            r1 = r0
            com.alibaba.fastjson.util.FieldInfo r9 = new com.alibaba.fastjson.util.FieldInfo
            r3 = 0
            r20 = 0
            r0 = r9
            r2 = r10
            r4 = r48
            r5 = r50
            r43 = r9
            r9 = r20
            r15 = r10
            r10 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r43
            addField(r14, r0, r13)
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r15, r12)
        L_0x0679:
            int r3 = r30 + 1
            r10 = r14
            r14 = r19
            r4 = r25
            r29 = r27
            r7 = r32
            r15 = r35
            r5 = r38
            r23 = r40
            r9 = r42
            r8 = 0
            goto L_0x0437
        L_0x068f:
            r38 = r5
            r32 = r7
            r42 = r9
            r19 = r14
            r35 = r15
            r40 = r23
        L_0x069b:
            r26 = 1
            r14 = r10
            goto L_0x06ac
        L_0x069f:
            r32 = r7
            r42 = r9
            r19 = r14
            r35 = r15
            r40 = r23
            r38 = r28
            goto L_0x069b
        L_0x06ac:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r35
            int r2 = r1.length
            r0.<init>(r2)
            int r2 = r1.length
            r7 = 0
        L_0x06b6:
            java.lang.Class<java.util.Collection> r15 = java.util.Collection.class
            java.lang.Class<java.util.Map> r10 = java.util.Map.class
            if (r7 >= r2) goto L_0x06e9
            r3 = r1[r7]
            int r4 = r3.getModifiers()
            r5 = r4 & 8
            if (r5 == 0) goto L_0x06c7
            goto L_0x06e6
        L_0x06c7:
            r4 = r4 & 16
            if (r4 == 0) goto L_0x06db
            java.lang.Class r4 = r3.getType()
            boolean r5 = r10.isAssignableFrom(r4)
            if (r5 != 0) goto L_0x06db
            boolean r4 = r15.isAssignableFrom(r4)
            if (r4 == 0) goto L_0x06e6
        L_0x06db:
            int r4 = r3.getModifiers()
            r4 = r4 & 1
            if (r4 == 0) goto L_0x06e6
            r0.add(r3)
        L_0x06e6:
            int r7 = r7 + 1
            goto L_0x06b6
        L_0x06e9:
            java.lang.Class r1 = r48.getSuperclass()
        L_0x06ed:
            if (r1 == 0) goto L_0x072b
            r2 = r34
            if (r1 == r2) goto L_0x072b
            java.lang.reflect.Field[] r3 = r1.getDeclaredFields()
            int r4 = r3.length
            r7 = 0
        L_0x06f9:
            if (r7 >= r4) goto L_0x0724
            r5 = r3[r7]
            int r6 = r5.getModifiers()
            r8 = r6 & 8
            if (r8 == 0) goto L_0x0706
            goto L_0x0721
        L_0x0706:
            r8 = r6 & 16
            if (r8 == 0) goto L_0x071a
            java.lang.Class r8 = r5.getType()
            boolean r9 = r10.isAssignableFrom(r8)
            if (r9 != 0) goto L_0x071a
            boolean r8 = r15.isAssignableFrom(r8)
            if (r8 == 0) goto L_0x0721
        L_0x071a:
            r6 = r6 & 1
            if (r6 == 0) goto L_0x0721
            r0.add(r5)
        L_0x0721:
            int r7 = r7 + 1
            goto L_0x06f9
        L_0x0724:
            java.lang.Class r1 = r1.getSuperclass()
            r34 = r2
            goto L_0x06ed
        L_0x072b:
            java.util.Iterator r20 = r0.iterator()
        L_0x072f:
            boolean r0 = r20.hasNext()
            if (r0 == 0) goto L_0x07c0
            java.lang.Object r0 = r20.next()
            r3 = r0
            java.lang.reflect.Field r3 = (java.lang.reflect.Field) r3
            java.lang.String r0 = r3.getName()
            int r1 = r14.size()
            r7 = 0
            r8 = 0
        L_0x0746:
            if (r7 >= r1) goto L_0x075b
            java.lang.Object r2 = r14.get(r7)
            com.alibaba.fastjson.util.FieldInfo r2 = (com.alibaba.fastjson.util.FieldInfo) r2
            java.lang.String r2 = r2.name
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x0758
            r8 = r26
        L_0x0758:
            int r7 = r7 + 1
            goto L_0x0746
        L_0x075b:
            if (r8 == 0) goto L_0x075e
            goto L_0x072f
        L_0x075e:
            r9 = r42
            if (r53 == 0) goto L_0x076b
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r9)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r21 = r1
            goto L_0x076d
        L_0x076b:
            r21 = r17
        L_0x076d:
            if (r21 == 0) goto L_0x078e
            int r1 = r21.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r2 = r21.serialzeFeatures()
            int r2 = com.alibaba.fastjson.serializer.SerializerFeature.of(r2)
            java.lang.String r4 = r21.name()
            int r4 = r4.length()
            if (r4 == 0) goto L_0x0789
            java.lang.String r0 = r21.name()
        L_0x0789:
            r8 = r55
            r6 = r1
            r7 = r2
            goto L_0x0792
        L_0x078e:
            r8 = r55
            r6 = 0
            r7 = 0
        L_0x0792:
            if (r8 == 0) goto L_0x0798
            java.lang.String r0 = r8.translate(r0)
        L_0x0798:
            r1 = r0
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r11, r3, r12)
            com.alibaba.fastjson.util.FieldInfo r5 = new com.alibaba.fastjson.util.FieldInfo
            r2 = 0
            r23 = 0
            r0 = r5
            r4 = r48
            r44 = r5
            r5 = r50
            r8 = r23
            r45 = r9
            r9 = r21
            r11 = r10
            r10 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r44
            addField(r14, r0, r13)
            r10 = r11
            r42 = r45
            r11 = r48
            goto L_0x072f
        L_0x07c0:
            r11 = r10
            r45 = r42
            if (r13 != 0) goto L_0x08ab
            r10 = r38
            int r9 = r10.length
            r8 = 0
        L_0x07c9:
            if (r8 >= r9) goto L_0x08ab
            r7 = r10[r8]
            java.lang.String r0 = r7.getName()
            int r1 = r0.length()
            r2 = 4
            if (r1 >= r2) goto L_0x07e9
            r27 = 3
            r1 = r48
            r23 = r2
        L_0x07de:
            r18 = r8
            r20 = r9
            r21 = r10
            r0 = r11
            r25 = r45
            goto L_0x08a0
        L_0x07e9:
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0891
            r6 = 3
            char r1 = r0.charAt(r6)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x0803
            java.lang.Class[] r1 = r7.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x080a
        L_0x0803:
            r23 = 4
            r1 = r48
            r27 = r6
            goto L_0x07de
        L_0x080a:
            java.lang.Class r1 = r7.getReturnType()
            boolean r2 = r15.isAssignableFrom(r1)
            if (r2 != 0) goto L_0x081a
            boolean r1 = r11.isAssignableFrom(r1)
            if (r1 == 0) goto L_0x0803
        L_0x081a:
            r5 = r45
            if (r53 == 0) goto L_0x0827
            java.lang.annotation.Annotation r1 = r7.getAnnotation(r5)
            com.alibaba.fastjson.annotation.JSONField r1 = (com.alibaba.fastjson.annotation.JSONField) r1
            r20 = r1
            goto L_0x0829
        L_0x0827:
            r20 = r17
        L_0x0829:
            if (r20 == 0) goto L_0x0837
            java.lang.String r1 = r20.name()
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0837
            r4 = 4
            goto L_0x0854
        L_0x0837:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r2 = r0.charAt(r6)
            char r2 = java.lang.Character.toLowerCase(r2)
            r1.append(r2)
            r4 = 4
            java.lang.String r0 = r0.substring(r4)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r0
        L_0x0854:
            com.alibaba.fastjson.util.FieldInfo r3 = new com.alibaba.fastjson.util.FieldInfo
            r18 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r0 = r3
            r2 = r7
            r46 = r3
            r3 = r23
            r23 = r4
            r4 = r48
            r25 = r5
            r5 = r50
            r27 = r6
            r6 = r24
            r47 = r7
            r7 = r18
            r18 = r8
            r8 = r20
            r20 = r9
            r9 = r21
            r21 = r10
            r10 = r54
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = r46
            addField(r14, r0, r13)
            r1 = r48
            r0 = r11
            r2 = r47
            com.alibaba.fastjson.util.TypeUtils.setAccessible(r1, r2, r12)
            goto L_0x08a0
        L_0x0891:
            r18 = r8
            r20 = r9
            r21 = r10
            r0 = r11
            r25 = r45
            r23 = 4
            r27 = 3
            r1 = r48
        L_0x08a0:
            int r8 = r18 + 1
            r11 = r0
            r9 = r20
            r10 = r21
            r45 = r25
            goto L_0x07c9
        L_0x08ab:
            r1 = r48
            int r0 = r14.size()
            com.alibaba.fastjson.util.FieldInfo[] r5 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r14.toArray(r5)
            com.alibaba.fastjson.util.FieldInfo[] r6 = new com.alibaba.fastjson.util.FieldInfo[r0]
            r2 = 0
            java.lang.System.arraycopy(r5, r2, r6, r2, r0)
            java.util.Arrays.sort(r6)
            if (r52 == 0) goto L_0x08cb
            r0 = r40
            java.lang.annotation.Annotation r0 = r1.getAnnotation(r0)
            com.alibaba.fastjson.annotation.JSONType r0 = (com.alibaba.fastjson.annotation.JSONType) r0
            r7 = r0
            goto L_0x08cd
        L_0x08cb:
            r7 = r17
        L_0x08cd:
            com.alibaba.fastjson.parser.JavaBeanInfo r9 = new com.alibaba.fastjson.parser.JavaBeanInfo
            r0 = r9
            r1 = r48
            r2 = r32
            r3 = r22
            r4 = r19
            r8 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanInfo.build(java.lang.Class, int, java.lang.reflect.Type, boolean, boolean, boolean, boolean, com.alibaba.fastjson.PropertyNamingStrategy):com.alibaba.fastjson.parser.JavaBeanInfo");
    }

    private FieldInfo[] computeSortedFields(FieldInfo[] fieldInfoArr, FieldInfo[] fieldInfoArr2) {
        String[] orders;
        JSONType jSONType = this.jsonType;
        if (!(jSONType == null || (orders = jSONType.orders()) == null || orders.length == 0)) {
            int i10 = 0;
            while (i10 < orders.length) {
                int i11 = 0;
                while (i11 < fieldInfoArr2.length) {
                    if (fieldInfoArr2[i11].name.equals(orders[i10])) {
                        i10++;
                    } else {
                        i11++;
                    }
                }
                return fieldInfoArr2;
            }
            if (orders.length == fieldInfoArr.length) {
                for (int i12 = 0; i12 < orders.length; i12++) {
                    if (!fieldInfoArr2[i12].name.equals(orders[i12])) {
                        FieldInfo[] fieldInfoArr3 = new FieldInfo[fieldInfoArr2.length];
                        for (int i13 = 0; i13 < orders.length; i13++) {
                            int i14 = 0;
                            while (true) {
                                if (i14 >= fieldInfoArr2.length) {
                                    break;
                                } else if (fieldInfoArr2[i14].name.equals(orders[i13])) {
                                    fieldInfoArr3[i13] = fieldInfoArr2[i14];
                                    break;
                                } else {
                                    i14++;
                                }
                            }
                        }
                        this.ordered = true;
                        return fieldInfoArr3;
                    }
                }
                return fieldInfoArr2;
            }
            int length = fieldInfoArr2.length;
            FieldInfo[] fieldInfoArr4 = new FieldInfo[length];
            for (int i15 = 0; i15 < orders.length; i15++) {
                int i16 = 0;
                while (true) {
                    if (i16 >= fieldInfoArr2.length) {
                        break;
                    } else if (fieldInfoArr2[i16].name.equals(orders[i15])) {
                        fieldInfoArr4[i15] = fieldInfoArr2[i16];
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            int length2 = orders.length;
            for (int i17 = 0; i17 < fieldInfoArr2.length; i17++) {
                int i18 = 0;
                while (true) {
                    if (i18 >= length || i18 >= length2) {
                        fieldInfoArr4[length2] = fieldInfoArr2[i17];
                        length2++;
                    } else if (fieldInfoArr4[i17].equals(fieldInfoArr2[i18])) {
                        break;
                    } else {
                        i18++;
                    }
                }
            }
            this.ordered = true;
        }
        return fieldInfoArr2;
    }
}
