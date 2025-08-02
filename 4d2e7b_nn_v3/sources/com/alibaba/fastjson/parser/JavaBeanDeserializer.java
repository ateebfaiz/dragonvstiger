package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        char c10;
        boolean z10;
        char c11;
        char c12;
        char c13;
        char c14;
        Enum enumR;
        char c15;
        char c16;
        char c17;
        char c18;
        char c19;
        char c20;
        String str;
        char c21;
        char c22;
        char c23;
        char c24;
        char c25;
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        T createInstance = createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i10 = 0;
        while (i10 < length) {
            if (i10 == length - 1) {
                z10 = true;
            } else {
                z10 = true;
            }
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i10];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(createInstance, scanLongValue);
                    } else {
                        fieldDeserializer.setValue((Object) createInstance, (Object) new Integer(scanLongValue));
                    }
                    char c26 = jSONLexer.ch;
                    if (c26 == ',') {
                        int i11 = jSONLexer.bp + 1;
                        jSONLexer.bp = i11;
                        if (i11 >= jSONLexer.len) {
                            c25 = JSONLexer.EOI;
                        } else {
                            c25 = jSONLexer.text.charAt(i11);
                        }
                        jSONLexer.ch = c25;
                        jSONLexer.token = 16;
                    } else if (c26 == ']') {
                        int i12 = jSONLexer.bp + 1;
                        jSONLexer.bp = i12;
                        if (i12 >= jSONLexer.len) {
                            c24 = JSONLexer.EOI;
                        } else {
                            c24 = jSONLexer.text.charAt(i12);
                        }
                        jSONLexer.ch = c24;
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c27 = jSONLexer.ch;
                    if (c27 == '\"') {
                        str = jSONLexer.scanStringValue('\"');
                    } else if (c27 != 'n' || !jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                        throw new JSONException("not match string. feild : " + obj);
                    } else {
                        int i13 = jSONLexer.bp + 4;
                        jSONLexer.bp = i13;
                        if (i13 >= jSONLexer.len) {
                            c23 = JSONLexer.EOI;
                        } else {
                            c23 = jSONLexer.text.charAt(i13);
                        }
                        jSONLexer.ch = c23;
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(createInstance, str);
                    } else {
                        fieldDeserializer.setValue((Object) createInstance, (Object) str);
                    }
                    char c28 = jSONLexer.ch;
                    if (c28 == ',') {
                        int i14 = jSONLexer.bp + 1;
                        jSONLexer.bp = i14;
                        if (i14 >= jSONLexer.len) {
                            c22 = JSONLexer.EOI;
                        } else {
                            c22 = jSONLexer.text.charAt(i14);
                        }
                        jSONLexer.ch = c22;
                        jSONLexer.token = 16;
                    } else if (c28 == ']') {
                        int i15 = jSONLexer.bp + 1;
                        jSONLexer.bp = i15;
                        if (i15 >= jSONLexer.len) {
                            c21 = JSONLexer.EOI;
                        } else {
                            c21 = jSONLexer.text.charAt(i15);
                        }
                        jSONLexer.ch = c21;
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    Object obj3 = obj;
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(createInstance, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue((Object) createInstance, (Object) new Long(scanLongValue2));
                        }
                        char c29 = jSONLexer.ch;
                        if (c29 == ',') {
                            int i16 = jSONLexer.bp + 1;
                            jSONLexer.bp = i16;
                            if (i16 >= jSONLexer.len) {
                                c20 = JSONLexer.EOI;
                            } else {
                                c20 = jSONLexer.text.charAt(i16);
                            }
                            jSONLexer.ch = c20;
                            jSONLexer.token = 16;
                        } else if (c29 == ']') {
                            int i17 = jSONLexer.bp + 1;
                            jSONLexer.bp = i17;
                            if (i17 >= jSONLexer.len) {
                                c19 = JSONLexer.EOI;
                            } else {
                                c19 = jSONLexer.text.charAt(i17);
                            }
                            jSONLexer.ch = c19;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(createInstance, scanBoolean);
                        } else {
                            fieldDeserializer.setValue((Object) createInstance, (Object) Boolean.valueOf(scanBoolean));
                        }
                        char c30 = jSONLexer.ch;
                        if (c30 == ',') {
                            int i18 = jSONLexer.bp + 1;
                            jSONLexer.bp = i18;
                            if (i18 >= jSONLexer.len) {
                                c18 = JSONLexer.EOI;
                            } else {
                                c18 = jSONLexer.text.charAt(i18);
                            }
                            jSONLexer.ch = c18;
                            jSONLexer.token = 16;
                        } else if (c30 == ']') {
                            int i19 = jSONLexer.bp + 1;
                            jSONLexer.bp = i19;
                            if (i19 >= jSONLexer.len) {
                                c17 = JSONLexer.EOI;
                            } else {
                                c17 = jSONLexer.text.charAt(i19);
                            }
                            jSONLexer.ch = c17;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c31 = jSONLexer.ch;
                        if (c31 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser2.symbolTable);
                            if (scanSymbol == null) {
                                enumR = null;
                            } else {
                                enumR = Enum.valueOf(cls, scanSymbol);
                            }
                        } else if (c31 < '0' || c31 > '9') {
                            throw new JSONException("illegal enum." + jSONLexer.info());
                        } else {
                            enumR = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser2.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue((Object) createInstance, (Object) enumR);
                        char c32 = jSONLexer.ch;
                        if (c32 == ',') {
                            int i20 = jSONLexer.bp + 1;
                            jSONLexer.bp = i20;
                            if (i20 >= jSONLexer.len) {
                                c16 = JSONLexer.EOI;
                            } else {
                                c16 = jSONLexer.text.charAt(i20);
                            }
                            jSONLexer.ch = c16;
                            jSONLexer.token = 16;
                        } else if (c32 == ']') {
                            int i21 = jSONLexer.bp + 1;
                            jSONLexer.bp = i21;
                            if (i21 >= jSONLexer.len) {
                                c15 = JSONLexer.EOI;
                            } else {
                                c15 = jSONLexer.text.charAt(i21);
                            }
                            jSONLexer.ch = c15;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.ch == '1') {
                        fieldDeserializer.setValue((Object) createInstance, (Object) new Date(jSONLexer.scanLongValue()));
                        char c33 = jSONLexer.ch;
                        if (c33 == ',') {
                            int i22 = jSONLexer.bp + 1;
                            jSONLexer.bp = i22;
                            if (i22 >= jSONLexer.len) {
                                c14 = JSONLexer.EOI;
                            } else {
                                c14 = jSONLexer.text.charAt(i22);
                            }
                            jSONLexer.ch = c14;
                            jSONLexer.token = 16;
                        } else if (c33 == ']') {
                            int i23 = jSONLexer.bp + 1;
                            jSONLexer.bp = i23;
                            if (i23 >= jSONLexer.len) {
                                c13 = JSONLexer.EOI;
                            } else {
                                c13 = jSONLexer.text.charAt(i23);
                            }
                            jSONLexer.ch = c13;
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c34 = jSONLexer.ch;
                        if (c34 == '[') {
                            int i24 = jSONLexer.bp + 1;
                            jSONLexer.bp = i24;
                            if (i24 >= jSONLexer.len) {
                                c12 = JSONLexer.EOI;
                            } else {
                                c12 = jSONLexer.text.charAt(i24);
                            }
                            jSONLexer.ch = c12;
                            jSONLexer.token = 14;
                        } else if (c34 == '{') {
                            int i25 = jSONLexer.bp + 1;
                            jSONLexer.bp = i25;
                            if (i25 >= jSONLexer.len) {
                                c11 = JSONLexer.EOI;
                            } else {
                                c11 = jSONLexer.text.charAt(i25);
                            }
                            jSONLexer.ch = c11;
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser2, createInstance, fieldInfo.fieldType, (Map<String, Object>) null);
                        if (z10) {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (!z10) {
                            continue;
                        } else if (jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i10++;
                }
                Object obj4 = obj;
                i10++;
            } catch (IllegalAccessException e10) {
                throw new JSONException("set " + fieldInfo.name + Constants.IPC_BUNDLE_KEY_SEND_ERROR, e10);
            }
        }
        if (jSONLexer.ch == ',') {
            int i26 = jSONLexer.bp + 1;
            jSONLexer.bp = i26;
            if (i26 >= jSONLexer.len) {
                c10 = JSONLexer.EOI;
            } else {
                c10 = jSONLexer.text.charAt(i26);
            }
            jSONLexer.ch = c10;
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return createInstance;
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        boolean z10;
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        String str2 = str;
        Object obj2 = obj;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str2);
        if (fieldDeserializer == null) {
            long fnv_64_lower = TypeUtils.fnv_64_lower(str);
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i10 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i10 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i10] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i10].fieldInfo.name);
                    i10++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
            if (binarySearch < 0) {
                z10 = str2.startsWith("is");
                if (z10) {
                    binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str2.substring(2)));
                }
            } else {
                z10 = false;
            }
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    int i11 = 0;
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i11 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i11].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i11;
                        }
                        i11++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i12 = this.smartMatchHashArrayMapping[binarySearch];
                if (i12 != -1) {
                    fieldDeserializer = this.sortedFieldDeserializers[i12];
                    Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
                    if (!(!z10 || cls == Boolean.TYPE || cls == Boolean.class)) {
                        fieldDeserializer = null;
                    }
                }
            }
        }
        int i13 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && !((defaultJSONParser2.lexer.features & i13) == 0 && (i13 & this.beanInfo.parserFeatures) == 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                Class cls2 = this.clazz;
                while (cls2 != null && cls2 != Object.class) {
                    for (Field field : cls2.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                    cls2 = cls2.getSuperclass();
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj3 = this.extraFieldDeserializers.get(str2);
            if (obj3 != null) {
                if (obj3 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj3;
                } else {
                    Field field2 = (Field) obj3;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser2.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str2, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser2, obj2, str2);
            return false;
        }
        jSONLexer.nextTokenWithChar(':');
        fieldDeserializer.parseField(defaultJSONParser2, obj2, type, map);
        return true;
    }

    /* access modifiers changed from: protected */
    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        Object obj;
        if (!(type instanceof Class) || !this.clazz.isInterface()) {
            JavaBeanInfo javaBeanInfo = this.beanInfo;
            Constructor<?> constructor = javaBeanInfo.defaultConstructor;
            if (constructor == null && javaBeanInfo.factoryMethod == null) {
                return null;
            }
            Method method = javaBeanInfo.factoryMethod;
            if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
                return null;
            }
            try {
                if (javaBeanInfo.defaultConstructorParameterSize != 0) {
                    obj = constructor.newInstance(new Object[]{defaultJSONParser.contex.object});
                } else if (constructor != null) {
                    obj = constructor.newInstance((Object[]) null);
                } else {
                    obj = method.invoke((Object) null, (Object[]) null);
                }
                if (!(defaultJSONParser == null || (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) == 0)) {
                    for (FieldInfo fieldInfo : this.beanInfo.fields) {
                        if (fieldInfo.fieldClass == String.class) {
                            fieldInfo.set(obj, "");
                        }
                    }
                }
                return obj;
            } catch (Exception e10) {
                throw new JSONException("create instance error, class " + this.clazz.getName(), e10);
            }
        } else {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, (Object) null);
    }

    /* access modifiers changed from: protected */
    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (this.beanInfo.ordered) {
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i10 >= fieldDeserializerArr.length) {
                    return null;
                }
                FieldDeserializer fieldDeserializer = fieldDeserializerArr[i10];
                if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                    return fieldDeserializer;
                }
                i10++;
            }
        } else {
            int length = this.sortedFieldDeserializers.length - 1;
            while (i10 <= length) {
                int i11 = (i10 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i11].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i10 = i11 + 1;
                } else if (compareTo <= 0) {
                    return this.sortedFieldDeserializers[i11];
                } else {
                    length = i11 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public FieldDeserializer getFieldDeserializerByHash(long j10) {
        int i10 = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i10 >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i10];
            if (fieldDeserializer.fieldInfo.nameHashCode == j10) {
                return fieldDeserializer;
            }
            i10++;
        }
    }

    /* access modifiers changed from: protected */
    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class deserializer : jSONType.seeAlso()) {
            ObjectDeserializer deserializer2 = parserConfig.getDeserializer(deserializer);
            if (deserializer2 instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer2;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object obj2;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) != 0) {
            jSONLexer.nextTokenWithChar(':');
            List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
            Type type = null;
            if (list != null) {
                for (ExtraTypeProvider extraType : list) {
                    type = extraType.getExtraType(obj, str);
                }
            }
            if (type == null) {
                obj2 = defaultJSONParser.parse();
            } else {
                obj2 = defaultJSONParser.parseObject(type);
            }
            if (obj instanceof ExtraProcessable) {
                ((ExtraProcessable) obj).processExtra(str, obj2);
                return;
            }
            List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
            if (list2 != null) {
                for (ExtraProcessor processExtra : list2) {
                    processExtra.processExtra(obj, str, obj2);
                }
                return;
            }
            return;
        }
        throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i10 = 0; i10 < length; i10++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i10];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i10] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.fieldDeserializers[i11] = getFieldDeserializer(javaBeanInfo.fields[i11].name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0308, code lost:
        if (r1 == 16) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:?, code lost:
        r10.nextTokenWithChar(':');
        r0 = r10.token;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x031c, code lost:
        if (r0 != 4) goto L_0x03b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x031e, code lost:
        r0 = r10.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0328, code lost:
        if ("@".equals(r0) == false) goto L_0x0330;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x032c, code lost:
        r1 = r14.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0336, code lost:
        if ("..".equals(r0) == false) goto L_0x034c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        r1 = r14.parent;
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x033c, code lost:
        if (r2 == null) goto L_0x0340;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x033e, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0340, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0352, code lost:
        if ("$".equals(r0) == false) goto L_0x036c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0354, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:?, code lost:
        r2 = r1.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0357, code lost:
        if (r2 == null) goto L_0x035b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0359, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x035b, code lost:
        r2 = r1.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x035d, code lost:
        if (r2 == null) goto L_0x0360;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x0360, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r1, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:?, code lost:
        r8.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r14, r0));
        r8.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x0377, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:?, code lost:
        r10.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x037f, code lost:
        if (r10.token != 13) goto L_0x039c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0381, code lost:
        r10.nextToken(16);
        r8.setContext(r14, r1, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0389, code lost:
        if (r29 == null) goto L_0x038f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:267:0x038b, code lost:
        r29.object = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x038f, code lost:
        r8.setContext(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x0392, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x0393, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0394, code lost:
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0396, code lost:
        r9 = r38;
        r3 = r1;
        r12 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x039c, code lost:
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x03a5, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x03a6, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x03b3, code lost:
        r2 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x03cf, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x03d0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x03dc, code lost:
        if (r2.equals(r4) == false) goto L_0x03de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0439, code lost:
        r5 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:?, code lost:
        r4 = r5.getSeeAlso(r8.config, r5.beanInfo, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x0441, code lost:
        if (r4 != null) goto L_0x0475;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:?, code lost:
        r4 = r8.config.checkAutoType(r3, r5.clazz, r10.features);
        r0 = com.alibaba.fastjson.util.TypeUtils.getClass(r40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0451, code lost:
        if (r0 == null) goto L_0x0469;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x0453, code lost:
        if (r4 == null) goto L_0x0461;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:327:0x0459, code lost:
        if (r0.isAssignableFrom(r4) == false) goto L_0x0461;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:329:0x045c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x045d, code lost:
        r12 = r1;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0468, code lost:
        throw new com.alibaba.fastjson.JSONException("type not match");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:334:0x046f, code lost:
        r36 = r4;
        r4 = r8.config.getDeserializer(r4);
        r0 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:335:0x0475, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x0478, code lost:
        if ((r4 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L_0x048b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:?, code lost:
        r4 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r4;
        r0 = r4.deserialze(r8, r0, r9, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:341:0x0481, code lost:
        if (r2 == null) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x0483, code lost:
        r4.getFieldDeserializer(r2).setValue((java.lang.Object) r0, (java.lang.Object) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:?, code lost:
        r0 = r4.deserialze(r8, r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x048f, code lost:
        if (r1 == null) goto L_0x0495;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0491, code lost:
        r1.object = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0495, code lost:
        r8.setContext(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0498, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0499, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:482:0x0679, code lost:
        r22 = r8;
        r0 = r19;
        r5 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:560:0x07a4, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, unexpect token " + com.alibaba.fastjson.parser.JSONToken.name(r10.token));
     */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:363:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0512 A[Catch:{ all -> 0x0507, all -> 0x04f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:462:0x0627  */
    /* JADX WARNING: Removed duplicated region for block: B:478:0x066b A[Catch:{ all -> 0x064f }] */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x0672 A[Catch:{ all -> 0x064f }] */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x0766  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x07ba  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r39, java.lang.reflect.Type r40, java.lang.Object r41, java.lang.Object r42) {
        /*
            r38 = this;
            r7 = r38
            r8 = r39
            r0 = r40
            r9 = r41
            java.lang.Class<com.alibaba.fastjson.JSON> r1 = com.alibaba.fastjson.JSON.class
            if (r0 == r1) goto L_0x0010
            java.lang.Class<com.alibaba.fastjson.JSONObject> r1 = com.alibaba.fastjson.JSONObject.class
            if (r0 != r1) goto L_0x0014
        L_0x0010:
            r9 = r7
            r4 = r8
            goto L_0x07c0
        L_0x0014:
            com.alibaba.fastjson.parser.JSONLexer r10 = r8.lexer
            int r1 = r10.token
            r2 = 8
            r11 = 16
            r12 = 0
            if (r1 != r2) goto L_0x0023
            r10.nextToken(r11)
            return r12
        L_0x0023:
            boolean r13 = r10.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r2 = r8.contex
            if (r42 == 0) goto L_0x002d
            if (r2 == 0) goto L_0x002d
            com.alibaba.fastjson.parser.ParseContext r2 = r2.parent
        L_0x002d:
            r14 = r2
            r15 = 13
            if (r1 != r15) goto L_0x0049
            r10.nextToken(r11)     // Catch:{ all -> 0x003c }
            if (r42 != 0) goto L_0x0043
            java.lang.Object r0 = r38.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r39, (java.lang.reflect.Type) r40)     // Catch:{ all -> 0x003c }
            goto L_0x0045
        L_0x003c:
            r0 = move-exception
            r3 = r42
        L_0x003f:
            r9 = r7
        L_0x0040:
            r4 = r8
            goto L_0x07b8
        L_0x0043:
            r0 = r42
        L_0x0045:
            r8.setContext(r14)
            return r0
        L_0x0049:
            r2 = 14
            if (r1 != r2) goto L_0x0064
            com.alibaba.fastjson.parser.JavaBeanInfo r2 = r7.beanInfo     // Catch:{ all -> 0x003c }
            boolean r2 = r2.supportBeanToArray     // Catch:{ all -> 0x003c }
            if (r2 != 0) goto L_0x005c
            int r2 = r10.features     // Catch:{ all -> 0x003c }
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.SupportArrayToBean     // Catch:{ all -> 0x003c }
            int r3 = r3.mask     // Catch:{ all -> 0x003c }
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0064
        L_0x005c:
            java.lang.Object r0 = r38.deserialzeArrayMapping(r39, r40, r41, r42)     // Catch:{ all -> 0x003c }
            r8.setContext(r14)
            return r0
        L_0x0064:
            r2 = 12
            r6 = 4
            if (r1 == r2) goto L_0x00af
            if (r1 == r11) goto L_0x00af
            boolean r0 = r10.isBlankInput()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0075
            r8.setContext(r14)
            return r12
        L_0x0075:
            if (r1 != r6) goto L_0x0088
            java.lang.String r0 = r10.stringVal()     // Catch:{ all -> 0x003c }
            int r0 = r0.length()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x0088
            r10.nextToken()     // Catch:{ all -> 0x003c }
            r8.setContext(r14)
            return r12
        L_0x0088:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ all -> 0x003c }
            r0.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r1 = "syntax error, expect {, actual "
            r0.append(r1)     // Catch:{ all -> 0x003c }
            java.lang.String r1 = r10.info()     // Catch:{ all -> 0x003c }
            r0.append(r1)     // Catch:{ all -> 0x003c }
            boolean r1 = r9 instanceof java.lang.String     // Catch:{ all -> 0x003c }
            if (r1 == 0) goto L_0x00a5
            java.lang.String r1 = ", fieldName "
            r0.append(r1)     // Catch:{ all -> 0x003c }
            r0.append(r9)     // Catch:{ all -> 0x003c }
        L_0x00a5:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x003c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x003c }
            r1.<init>(r0)     // Catch:{ all -> 0x003c }
            throw r1     // Catch:{ all -> 0x003c }
        L_0x00af:
            int r1 = r8.resolveStatus     // Catch:{ all -> 0x07b2 }
            r2 = 2
            r5 = 0
            if (r1 != r2) goto L_0x00b7
            r8.resolveStatus = r5     // Catch:{ all -> 0x003c }
        L_0x00b7:
            com.alibaba.fastjson.parser.JavaBeanInfo r1 = r7.beanInfo     // Catch:{ all -> 0x07b2 }
            java.lang.String r4 = r1.typeKey     // Catch:{ all -> 0x07b2 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r1 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x07b2 }
            int r3 = r1.length     // Catch:{ all -> 0x07b2 }
            r16 = 0
            r1 = r42
            r2 = r5
            r5 = r12
            r19 = r5
            r18 = r13
            r12 = r16
        L_0x00ca:
            int r20 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r20 == 0) goto L_0x00e8
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r12 = r7.getFieldDeserializerByHash(r12)     // Catch:{ all -> 0x00d9 }
            if (r12 == 0) goto L_0x00de
            com.alibaba.fastjson.util.FieldInfo r13 = r12.fieldInfo     // Catch:{ all -> 0x00d9 }
            java.lang.Class<?> r6 = r13.fieldClass     // Catch:{ all -> 0x00d9 }
            goto L_0x00e0
        L_0x00d9:
            r0 = move-exception
            r3 = r1
            r12 = r5
            goto L_0x003f
        L_0x00de:
            r6 = 0
            r13 = 0
        L_0x00e0:
            r22 = r6
            r6 = r12
            r21 = r13
            r12 = r16
            goto L_0x00ed
        L_0x00e8:
            r6 = 0
            r21 = 0
            r22 = 0
        L_0x00ed:
            if (r6 != 0) goto L_0x0105
            if (r2 >= r3) goto L_0x0103
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r7.sortedFieldDeserializers     // Catch:{ all -> 0x00d9 }
            r6 = r6[r2]     // Catch:{ all -> 0x00d9 }
            com.alibaba.fastjson.util.FieldInfo r11 = r6.fieldInfo     // Catch:{ all -> 0x00d9 }
            java.lang.Class<?> r15 = r11.fieldClass     // Catch:{ all -> 0x00d9 }
            int r2 = r2 + 1
            r21 = r3
            r36 = r11
            r11 = r2
            r2 = r36
            goto L_0x010c
        L_0x0103:
            int r2 = r2 + 1
        L_0x0105:
            r11 = r2
            r2 = r21
            r15 = r22
            r21 = r3
        L_0x010c:
            java.lang.Class<java.lang.Double> r3 = java.lang.Double.class
            r42 = r11
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            r23 = r12
            java.lang.Class<java.lang.Long> r12 = java.lang.Long.class
            java.lang.Class<java.lang.Integer> r13 = java.lang.Integer.class
            r22 = r1
            r25 = 0
            r26 = 0
            if (r6 == 0) goto L_0x02e4
            r28 = r4
            r29 = r5
            long r4 = r2.nameHashCode     // Catch:{ all -> 0x016b }
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x016b }
            r7 = -2
            if (r15 == r1) goto L_0x02c6
            if (r15 != r13) goto L_0x012f
            goto L_0x02c6
        L_0x012f:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x016b }
            if (r15 == r1) goto L_0x029c
            if (r15 != r12) goto L_0x0137
            goto L_0x029c
        L_0x0137:
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            if (r15 != r1) goto L_0x017d
            java.lang.String r1 = r10.scanFieldString(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x0154
        L_0x0143:
            r30 = r2
            r31 = r25
            r4 = 0
            r5 = 1
            r7 = 1
        L_0x014a:
            r36 = r26
            r27 = r1
            r25 = r16
            r1 = r36
            goto L_0x02e9
        L_0x0154:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
        L_0x0158:
            r2 = r42
            r3 = r21
            r1 = r22
            r4 = r28
            r5 = r29
            r6 = 4
            r11 = 16
            r15 = 13
            r7 = r38
            goto L_0x00ca
        L_0x016b:
            r0 = move-exception
            r9 = r38
            r4 = r8
            r3 = r22
        L_0x0171:
            r12 = r29
            goto L_0x07b8
        L_0x0175:
            r30 = r2
            r31 = r25
            r4 = 0
            r5 = 0
            r7 = 0
            goto L_0x014a
        L_0x017d:
            java.lang.Class<java.util.Date> r1 = java.util.Date.class
            if (r15 != r1) goto L_0x018f
            java.util.Date r1 = r10.scanFieldDate(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x018a
            goto L_0x0143
        L_0x018a:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x018f:
            java.lang.Class r1 = java.lang.Boolean.TYPE     // Catch:{ all -> 0x016b }
            if (r15 == r1) goto L_0x0288
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            if (r15 != r1) goto L_0x0199
            goto L_0x0288
        L_0x0199:
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x016b }
            if (r15 == r1) goto L_0x0279
            if (r15 != r11) goto L_0x01a1
            goto L_0x0279
        L_0x01a1:
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x016b }
            if (r15 == r1) goto L_0x0258
            if (r15 != r3) goto L_0x01a9
            goto L_0x0258
        L_0x01a9:
            boolean r1 = r2.isEnum     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x01d7
            com.alibaba.fastjson.parser.ParserConfig r1 = r8.config     // Catch:{ all -> 0x016b }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r1 = r1.getDeserializer(r15)     // Catch:{ all -> 0x016b }
            boolean r1 = r1 instanceof com.alibaba.fastjson.parser.EnumDeserializer     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x01d7
            long r4 = r10.scanFieldSymbol(r4)     // Catch:{ all -> 0x016b }
            int r1 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r1 <= 0) goto L_0x01c6
            java.lang.Enum r1 = r6.getEnumByHashCode(r4)     // Catch:{ all -> 0x016b }
            r4 = 1
            r5 = 1
            goto L_0x01ce
        L_0x01c6:
            if (r1 != r7) goto L_0x01cb
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x01cb:
            r1 = 0
            r4 = 0
            r5 = 0
        L_0x01ce:
            r30 = r2
            r7 = r5
            r31 = r25
            r5 = r4
            r4 = 0
            goto L_0x014a
        L_0x01d7:
            java.lang.Class<int[]> r1 = int[].class
            if (r15 != r1) goto L_0x01eb
            int[] r1 = r10.scanFieldIntArray(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x01e5
            goto L_0x0143
        L_0x01e5:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x01eb:
            java.lang.Class<float[]> r1 = float[].class
            if (r15 != r1) goto L_0x01ff
            float[] r1 = r10.scanFieldFloatArray(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x01f9
            goto L_0x0143
        L_0x01f9:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x01ff:
            java.lang.Class<double[]> r1 = double[].class
            if (r15 != r1) goto L_0x0213
            double[] r1 = r10.scanFieldDoubleArray(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x020d
            goto L_0x0143
        L_0x020d:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x0213:
            java.lang.Class<float[][]> r1 = float[][].class
            if (r15 != r1) goto L_0x0227
            float[][] r1 = r10.scanFieldFloatArray2(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x0221
            goto L_0x0143
        L_0x0221:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x0227:
            java.lang.Class<double[][]> r1 = double[][].class
            if (r15 != r1) goto L_0x023b
            double[][] r1 = r10.scanFieldDoubleArray2(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x0235
            goto L_0x0143
        L_0x0235:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x023b:
            long r4 = r2.nameHashCode     // Catch:{ all -> 0x016b }
            boolean r1 = r10.matchField(r4)     // Catch:{ all -> 0x016b }
            if (r1 == 0) goto L_0x0252
            r30 = r2
            r31 = r25
            r1 = r26
            r4 = 0
            r5 = 1
        L_0x024b:
            r7 = 0
        L_0x024c:
            r27 = 0
            r25 = r16
            goto L_0x02e9
        L_0x0252:
            r2 = r28
            r1 = r29
            goto L_0x0424
        L_0x0258:
            double r26 = r10.scanFieldDouble(r4)     // Catch:{ all -> 0x016b }
            int r1 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r1 <= 0) goto L_0x026a
        L_0x0260:
            r30 = r2
            r31 = r25
            r1 = r26
            r4 = 0
        L_0x0267:
            r5 = 1
            r7 = 1
            goto L_0x024c
        L_0x026a:
            if (r1 != r7) goto L_0x0270
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x0270:
            r30 = r2
            r31 = r25
            r1 = r26
            r4 = 0
        L_0x0277:
            r5 = 0
            goto L_0x024b
        L_0x0279:
            float r25 = r10.scanFieldFloat(r4)     // Catch:{ all -> 0x016b }
            int r1 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r1 <= 0) goto L_0x0282
            goto L_0x0260
        L_0x0282:
            if (r1 != r7) goto L_0x0270
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x0288:
            boolean r1 = r10.scanFieldBoolean(r4)     // Catch:{ all -> 0x016b }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x0296
            goto L_0x0143
        L_0x0296:
            if (r4 != r7) goto L_0x0175
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x029c:
            long r4 = r10.scanFieldLong(r4)     // Catch:{ all -> 0x016b }
            int r1 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r1 <= 0) goto L_0x02b2
            r30 = r2
            r31 = r25
            r1 = r26
            r7 = 1
            r27 = 0
            r25 = r4
            r4 = 0
            r5 = 1
            goto L_0x02e9
        L_0x02b2:
            if (r1 != r7) goto L_0x02b8
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x02b8:
            r30 = r2
            r31 = r25
            r1 = r26
            r7 = 0
            r27 = 0
            r25 = r4
            r4 = 0
            r5 = 0
            goto L_0x02e9
        L_0x02c6:
            int r1 = r10.scanFieldInt(r4)     // Catch:{ all -> 0x016b }
            int r4 = r10.matchStat     // Catch:{ all -> 0x016b }
            if (r4 <= 0) goto L_0x02d6
            r4 = r1
            r30 = r2
            r31 = r25
            r1 = r26
            goto L_0x0267
        L_0x02d6:
            if (r4 != r7) goto L_0x02dc
            long r12 = r10.fieldHash     // Catch:{ all -> 0x016b }
            goto L_0x0158
        L_0x02dc:
            r4 = r1
            r30 = r2
            r31 = r25
            r1 = r26
            goto L_0x0277
        L_0x02e4:
            r28 = r4
            r29 = r5
            goto L_0x0270
        L_0x02e9:
            if (r5 != 0) goto L_0x04ca
            r32 = r4
            com.alibaba.fastjson.parser.SymbolTable r4 = r8.symbolTable     // Catch:{ all -> 0x04c2 }
            java.lang.String r4 = r10.scanSymbol(r4)     // Catch:{ all -> 0x04c2 }
            if (r4 != 0) goto L_0x030c
            r33 = r1
            int r1 = r10.token     // Catch:{ all -> 0x016b }
            r2 = 13
            if (r1 != r2) goto L_0x0306
            r2 = 16
            r10.nextToken(r2)     // Catch:{ all -> 0x016b }
            r1 = r29
            goto L_0x041c
        L_0x0306:
            r2 = 16
            if (r1 != r2) goto L_0x030e
            goto L_0x0252
        L_0x030c:
            r33 = r1
        L_0x030e:
            java.lang.String r1 = "$ref"
            r2 = 58
            if (r1 != r4) goto L_0x03d2
            if (r14 == 0) goto L_0x03d2
            r10.nextTokenWithChar(r2)     // Catch:{ all -> 0x03a8 }
            int r0 = r10.token     // Catch:{ all -> 0x03a8 }
            r1 = 4
            if (r0 != r1) goto L_0x03b3
            java.lang.String r0 = r10.stringVal()     // Catch:{ all -> 0x03a8 }
            java.lang.String r1 = "@"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x03a8 }
            if (r1 == 0) goto L_0x0330
            java.lang.Object r0 = r14.object     // Catch:{ all -> 0x016b }
            r1 = r0
        L_0x032d:
            r0 = 13
            goto L_0x037a
        L_0x0330:
            java.lang.String r1 = ".."
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x03a8 }
            if (r1 == 0) goto L_0x034c
            com.alibaba.fastjson.parser.ParseContext r1 = r14.parent     // Catch:{ all -> 0x016b }
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x0340
        L_0x033e:
            r1 = r2
            goto L_0x032d
        L_0x0340:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x016b }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x016b }
            r8.addResolveTask(r2)     // Catch:{ all -> 0x016b }
            r0 = 1
            r8.resolveStatus = r0     // Catch:{ all -> 0x016b }
            goto L_0x0377
        L_0x034c:
            java.lang.String r1 = "$"
            boolean r1 = r1.equals(r0)     // Catch:{ all -> 0x03a8 }
            if (r1 == 0) goto L_0x036c
            r1 = r14
        L_0x0355:
            com.alibaba.fastjson.parser.ParseContext r2 = r1.parent     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x035b
            r1 = r2
            goto L_0x0355
        L_0x035b:
            java.lang.Object r2 = r1.object     // Catch:{ all -> 0x016b }
            if (r2 == 0) goto L_0x0360
            goto L_0x033e
        L_0x0360:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x016b }
            r2.<init>(r1, r0)     // Catch:{ all -> 0x016b }
            r8.addResolveTask(r2)     // Catch:{ all -> 0x016b }
            r0 = 1
            r8.resolveStatus = r0     // Catch:{ all -> 0x016b }
            goto L_0x0377
        L_0x036c:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r1 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x03a8 }
            r1.<init>(r14, r0)     // Catch:{ all -> 0x03a8 }
            r8.addResolveTask(r1)     // Catch:{ all -> 0x03a8 }
            r1 = 1
            r8.resolveStatus = r1     // Catch:{ all -> 0x03a8 }
        L_0x0377:
            r1 = r22
            goto L_0x032d
        L_0x037a:
            r10.nextToken(r0)     // Catch:{ all -> 0x0393 }
            int r2 = r10.token     // Catch:{ all -> 0x0393 }
            if (r2 != r0) goto L_0x039c
            r0 = 16
            r10.nextToken(r0)     // Catch:{ all -> 0x0393 }
            r8.setContext(r14, r1, r9)     // Catch:{ all -> 0x0393 }
            if (r29 == 0) goto L_0x038f
            r2 = r29
            r2.object = r1
        L_0x038f:
            r8.setContext(r14)
            return r1
        L_0x0393:
            r0 = move-exception
            r2 = r29
        L_0x0396:
            r9 = r38
            r3 = r1
            r12 = r2
            goto L_0x0040
        L_0x039c:
            r2 = r29
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x03a6 }
            java.lang.String r3 = "illegal ref"
            r0.<init>(r3)     // Catch:{ all -> 0x03a6 }
            throw r0     // Catch:{ all -> 0x03a6 }
        L_0x03a6:
            r0 = move-exception
            goto L_0x0396
        L_0x03a8:
            r0 = move-exception
            r2 = r29
        L_0x03ab:
            r9 = r38
            r12 = r2
        L_0x03ae:
            r4 = r8
        L_0x03af:
            r3 = r22
            goto L_0x07b8
        L_0x03b3:
            r2 = r29
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x03d0 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03d0 }
            r3.<init>()     // Catch:{ all -> 0x03d0 }
            java.lang.String r4 = "illegal ref, "
            r3.append(r4)     // Catch:{ all -> 0x03d0 }
            java.lang.String r0 = com.alibaba.fastjson.parser.JSONToken.name(r0)     // Catch:{ all -> 0x03d0 }
            r3.append(r0)     // Catch:{ all -> 0x03d0 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x03d0 }
            r1.<init>(r0)     // Catch:{ all -> 0x03d0 }
            throw r1     // Catch:{ all -> 0x03d0 }
        L_0x03d0:
            r0 = move-exception
            goto L_0x03ab
        L_0x03d2:
            r1 = r29
            if (r28 == 0) goto L_0x03e9
            r2 = r28
            boolean r28 = r2.equals(r4)     // Catch:{ all -> 0x03e4 }
            if (r28 != 0) goto L_0x03e1
        L_0x03de:
            r28 = r3
            goto L_0x03ec
        L_0x03e1:
            r3 = 58
            goto L_0x03f1
        L_0x03e4:
            r0 = move-exception
            r9 = r38
            r12 = r1
            goto L_0x03ae
        L_0x03e9:
            r2 = r28
            goto L_0x03de
        L_0x03ec:
            java.lang.String r3 = "@type"
            if (r3 != r4) goto L_0x04b2
            goto L_0x03e1
        L_0x03f1:
            r10.nextTokenWithChar(r3)     // Catch:{ all -> 0x04a0 }
            int r3 = r10.token     // Catch:{ all -> 0x04a0 }
            r4 = 4
            if (r3 != r4) goto L_0x04a4
            java.lang.String r3 = r10.stringVal()     // Catch:{ all -> 0x04a0 }
            r4 = 16
            r10.nextToken(r4)     // Catch:{ all -> 0x04a0 }
            boolean r4 = r0 instanceof java.lang.Class     // Catch:{ all -> 0x04a0 }
            if (r4 == 0) goto L_0x0437
            r4 = r0
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ all -> 0x03e4 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x03e4 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x03e4 }
            if (r4 == 0) goto L_0x0437
            int r3 = r10.token     // Catch:{ all -> 0x03e4 }
            r4 = 13
            if (r3 != r4) goto L_0x0424
            r10.nextToken()     // Catch:{ all -> 0x03e4 }
        L_0x041c:
            r12 = 0
            r9 = r38
            r5 = r1
            r0 = r19
            goto L_0x067f
        L_0x0424:
            r5 = r1
            r4 = r2
            r3 = r21
            r1 = r22
            r12 = r23
            r6 = 4
            r11 = 16
            r15 = 13
            r7 = r38
        L_0x0433:
            r2 = r42
            goto L_0x00ca
        L_0x0437:
            com.alibaba.fastjson.parser.ParserConfig r4 = r8.config     // Catch:{ all -> 0x04a0 }
            r5 = r38
            com.alibaba.fastjson.parser.JavaBeanInfo r6 = r5.beanInfo     // Catch:{ all -> 0x0499 }
            com.alibaba.fastjson.parser.JavaBeanDeserializer r4 = r5.getSeeAlso(r4, r6, r3)     // Catch:{ all -> 0x0499 }
            if (r4 != 0) goto L_0x0475
            com.alibaba.fastjson.parser.ParserConfig r4 = r8.config     // Catch:{ all -> 0x045c }
            java.lang.Class<?> r6 = r5.clazz     // Catch:{ all -> 0x045c }
            int r7 = r10.features     // Catch:{ all -> 0x045c }
            java.lang.Class r4 = r4.checkAutoType(r3, r6, r7)     // Catch:{ all -> 0x045c }
            java.lang.Class r0 = com.alibaba.fastjson.util.TypeUtils.getClass(r40)     // Catch:{ all -> 0x045c }
            if (r0 == 0) goto L_0x0469
            if (r4 == 0) goto L_0x0461
            boolean r0 = r0.isAssignableFrom(r4)     // Catch:{ all -> 0x045c }
            if (r0 == 0) goto L_0x0461
            goto L_0x0469
        L_0x045c:
            r0 = move-exception
            r12 = r1
            r9 = r5
            goto L_0x03ae
        L_0x0461:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x045c }
            java.lang.String r2 = "type not match"
            r0.<init>(r2)     // Catch:{ all -> 0x045c }
            throw r0     // Catch:{ all -> 0x045c }
        L_0x0469:
            com.alibaba.fastjson.parser.ParserConfig r0 = r8.config     // Catch:{ all -> 0x045c }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r4)     // Catch:{ all -> 0x045c }
            r36 = r4
            r4 = r0
            r0 = r36
            goto L_0x0476
        L_0x0475:
            r0 = 0
        L_0x0476:
            boolean r6 = r4 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ all -> 0x0499 }
            if (r6 == 0) goto L_0x048b
            com.alibaba.fastjson.parser.JavaBeanDeserializer r4 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r4     // Catch:{ all -> 0x045c }
            r6 = 0
            java.lang.Object r0 = r4.deserialze(r8, r0, r9, r6)     // Catch:{ all -> 0x045c }
            if (r2 == 0) goto L_0x048f
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r2 = r4.getFieldDeserializer(r2)     // Catch:{ all -> 0x045c }
            r2.setValue((java.lang.Object) r0, (java.lang.Object) r3)     // Catch:{ all -> 0x045c }
            goto L_0x048f
        L_0x048b:
            java.lang.Object r0 = r4.deserialze(r8, r0, r9)     // Catch:{ all -> 0x0499 }
        L_0x048f:
            if (r1 == 0) goto L_0x0495
            r3 = r22
            r1.object = r3
        L_0x0495:
            r8.setContext(r14)
            return r0
        L_0x0499:
            r0 = move-exception
        L_0x049a:
            r3 = r22
        L_0x049c:
            r12 = r1
            r9 = r5
            goto L_0x0040
        L_0x04a0:
            r0 = move-exception
            r5 = r38
            goto L_0x049a
        L_0x04a4:
            r5 = r38
            r3 = r22
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x04b0 }
            java.lang.String r2 = "syntax error"
            r0.<init>(r2)     // Catch:{ all -> 0x04b0 }
            throw r0     // Catch:{ all -> 0x04b0 }
        L_0x04b0:
            r0 = move-exception
            goto L_0x049c
        L_0x04b2:
            r3 = r22
            r22 = r4
            r4 = r38
            goto L_0x04da
        L_0x04b9:
            r0 = move-exception
            r4 = r38
            r3 = r22
        L_0x04be:
            r12 = r1
            r9 = r4
            goto L_0x0040
        L_0x04c2:
            r0 = move-exception
            r4 = r38
            r3 = r22
            r1 = r29
            goto L_0x04be
        L_0x04ca:
            r33 = r1
            r32 = r4
            r2 = r28
            r1 = r29
            r4 = r38
            r28 = r3
            r3 = r22
            r22 = 0
        L_0x04da:
            if (r3 != 0) goto L_0x050b
            if (r19 != 0) goto L_0x050b
            java.lang.Object r3 = r38.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r39, (java.lang.reflect.Type) r40)     // Catch:{ all -> 0x0507 }
            if (r3 != 0) goto L_0x04f8
            r29 = r1
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x04f3 }
            r35 = r2
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r2 = r4.fieldDeserializers     // Catch:{ all -> 0x04f3 }
            int r2 = r2.length     // Catch:{ all -> 0x04f3 }
            r1.<init>(r2)     // Catch:{ all -> 0x04f3 }
            r19 = r1
            goto L_0x04fc
        L_0x04f3:
            r0 = move-exception
        L_0x04f4:
            r9 = r4
            r4 = r8
            goto L_0x0171
        L_0x04f8:
            r29 = r1
            r35 = r2
        L_0x04fc:
            if (r18 != 0) goto L_0x0504
            com.alibaba.fastjson.parser.ParseContext r1 = r8.setContext(r14, r3, r9)     // Catch:{ all -> 0x04f3 }
            r29 = r1
        L_0x0504:
            r2 = r19
            goto L_0x0510
        L_0x0507:
            r0 = move-exception
            r29 = r1
            goto L_0x04f4
        L_0x050b:
            r29 = r1
            r35 = r2
            goto L_0x0504
        L_0x0510:
            if (r5 == 0) goto L_0x0627
            if (r7 != 0) goto L_0x0524
            r6.parseField(r8, r3, r0, r2)     // Catch:{ all -> 0x04f3 }
            r19 = r2
            r8 = r3
            r9 = r4
            r7 = r21
            r11 = r35
            r0 = 1
            r12 = 0
            r13 = 4
            goto L_0x0665
        L_0x0524:
            if (r3 != 0) goto L_0x056a
            java.lang.Class r1 = java.lang.Integer.TYPE     // Catch:{ all -> 0x04f3 }
            if (r15 == r1) goto L_0x055e
            if (r15 != r13) goto L_0x052d
            goto L_0x055e
        L_0x052d:
            java.lang.Class r1 = java.lang.Long.TYPE     // Catch:{ all -> 0x04f3 }
            if (r15 == r1) goto L_0x0559
            if (r15 != r12) goto L_0x0534
            goto L_0x0559
        L_0x0534:
            java.lang.Class r1 = java.lang.Float.TYPE     // Catch:{ all -> 0x04f3 }
            if (r15 == r1) goto L_0x0551
            if (r15 != r11) goto L_0x053b
            goto L_0x0551
        L_0x053b:
            java.lang.Class r1 = java.lang.Double.TYPE     // Catch:{ all -> 0x04f3 }
            if (r15 == r1) goto L_0x0549
            r1 = r28
            if (r15 != r1) goto L_0x0544
            goto L_0x0549
        L_0x0544:
            r1 = r27
        L_0x0546:
            r7 = r30
            goto L_0x0563
        L_0x0549:
            java.lang.Double r1 = new java.lang.Double     // Catch:{ all -> 0x04f3 }
            r5 = r33
            r1.<init>(r5)     // Catch:{ all -> 0x04f3 }
            goto L_0x0546
        L_0x0551:
            java.lang.Float r1 = new java.lang.Float     // Catch:{ all -> 0x04f3 }
            r5 = r31
            r1.<init>(r5)     // Catch:{ all -> 0x04f3 }
            goto L_0x0546
        L_0x0559:
            java.lang.Long r1 = java.lang.Long.valueOf(r25)     // Catch:{ all -> 0x04f3 }
            goto L_0x0546
        L_0x055e:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r32)     // Catch:{ all -> 0x04f3 }
            goto L_0x0546
        L_0x0563:
            java.lang.String r5 = r7.name     // Catch:{ all -> 0x04f3 }
            r2.put(r5, r1)     // Catch:{ all -> 0x04f3 }
            goto L_0x0613
        L_0x056a:
            r1 = r28
            r7 = r30
            r5 = r31
            r8 = r33
            if (r27 != 0) goto L_0x060e
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r15 == r0) goto L_0x05df
            if (r15 != r13) goto L_0x057c
            goto L_0x05df
        L_0x057c:
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r15 == r0) goto L_0x05c9
            if (r15 != r12) goto L_0x0583
            goto L_0x05c9
        L_0x0583:
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r15 == r0) goto L_0x05b6
            if (r15 != r11) goto L_0x058a
            goto L_0x05b6
        L_0x058a:
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r15 == r0) goto L_0x05a2
            if (r15 != r1) goto L_0x0591
            goto L_0x05a2
        L_0x0591:
            r1 = r27
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x0598:
            r0 = move-exception
            r9 = r4
            r12 = r29
            r4 = r39
            goto L_0x07b8
        L_0x05a0:
            r0 = move-exception
            goto L_0x05f5
        L_0x05a2:
            boolean r1 = r7.fieldAccess     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r1 == 0) goto L_0x05ad
            if (r15 != r0) goto L_0x05ad
            r6.setValue((java.lang.Object) r3, (double) r8)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05ad:
            java.lang.Double r0 = new java.lang.Double     // Catch:{ IllegalAccessException -> 0x05a0 }
            r0.<init>(r8)     // Catch:{ IllegalAccessException -> 0x05a0 }
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05b6:
            boolean r1 = r7.fieldAccess     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r1 == 0) goto L_0x05c0
            if (r15 != r0) goto L_0x05c0
            r6.setValue((java.lang.Object) r3, (float) r5)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05c0:
            java.lang.Float r0 = new java.lang.Float     // Catch:{ IllegalAccessException -> 0x05a0 }
            r0.<init>(r5)     // Catch:{ IllegalAccessException -> 0x05a0 }
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05c9:
            boolean r1 = r7.fieldAccess     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r1 == 0) goto L_0x05d5
            if (r15 != r0) goto L_0x05d5
            r0 = r25
            r6.setValue((java.lang.Object) r3, (long) r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05d5:
            r0 = r25
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05df:
            boolean r1 = r7.fieldAccess     // Catch:{ IllegalAccessException -> 0x05a0 }
            if (r1 == 0) goto L_0x05eb
            if (r15 != r0) goto L_0x05eb
            r1 = r32
            r6.setValue((java.lang.Object) r3, (int) r1)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05eb:
            r1 = r32
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ IllegalAccessException -> 0x05a0 }
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r0)     // Catch:{ IllegalAccessException -> 0x05a0 }
            goto L_0x0613
        L_0x05f5:
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0598 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0598 }
            r2.<init>()     // Catch:{ all -> 0x0598 }
            java.lang.String r5 = "set property error, "
            r2.append(r5)     // Catch:{ all -> 0x0598 }
            java.lang.String r5 = r7.name     // Catch:{ all -> 0x0598 }
            r2.append(r5)     // Catch:{ all -> 0x0598 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0598 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0598 }
            throw r1     // Catch:{ all -> 0x0598 }
        L_0x060e:
            r1 = r27
            r6.setValue((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ all -> 0x0598 }
        L_0x0613:
            int r0 = r10.matchStat     // Catch:{ all -> 0x0598 }
            r6 = 4
            r19 = r2
            r8 = r3
            r9 = r4
            if (r0 != r6) goto L_0x061f
            r12 = 0
            goto L_0x0679
        L_0x061f:
            r13 = r6
            r7 = r21
            r11 = r35
            r0 = 1
            r12 = 0
            goto L_0x0665
        L_0x0627:
            r0 = 1
            r6 = 4
            r1 = r38
            r19 = r2
            r5 = r35
            r2 = r39
            r8 = r3
            r7 = r21
            r3 = r22
            r9 = r4
            r11 = r5
            r4 = r8
            r12 = 0
            r5 = r40
            r13 = r6
            r6 = r19
            boolean r1 = r1.parseField(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x064f }
            if (r1 != 0) goto L_0x065f
            int r0 = r10.token     // Catch:{ all -> 0x064f }
            r1 = 13
            if (r0 != r1) goto L_0x0655
            r10.nextToken()     // Catch:{ all -> 0x064f }
            goto L_0x0679
        L_0x064f:
            r0 = move-exception
            r4 = r39
        L_0x0652:
            r3 = r8
            goto L_0x0171
        L_0x0655:
            r4 = r39
            r6 = r41
            r3 = r1
            r2 = 16
        L_0x065c:
            r15 = 0
            goto L_0x0777
        L_0x065f:
            int r1 = r10.token     // Catch:{ all -> 0x064f }
            r2 = 17
            if (r1 == r2) goto L_0x07a8
        L_0x0665:
            int r1 = r10.token     // Catch:{ all -> 0x064f }
            r2 = 16
            if (r1 != r2) goto L_0x0672
            r4 = r39
            r6 = r41
            r3 = 13
            goto L_0x065c
        L_0x0672:
            r3 = 13
            if (r1 != r3) goto L_0x076c
            r10.nextToken(r2)     // Catch:{ all -> 0x064f }
        L_0x0679:
            r22 = r8
            r0 = r19
            r5 = r29
        L_0x067f:
            if (r22 != 0) goto L_0x0761
            if (r0 != 0) goto L_0x06a7
            java.lang.Object r1 = r38.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r39, (java.lang.reflect.Type) r40)     // Catch:{ all -> 0x06a1 }
            if (r5 != 0) goto L_0x0697
            r4 = r39
            r6 = r41
            com.alibaba.fastjson.parser.ParseContext r5 = r4.setContext(r14, r1, r6)     // Catch:{ all -> 0x0692 }
            goto L_0x0699
        L_0x0692:
            r0 = move-exception
            r3 = r1
        L_0x0694:
            r12 = r5
            goto L_0x07b8
        L_0x0697:
            r4 = r39
        L_0x0699:
            if (r5 == 0) goto L_0x069d
            r5.object = r1
        L_0x069d:
            r4.setContext(r14)
            return r1
        L_0x06a1:
            r0 = move-exception
            r4 = r39
        L_0x06a4:
            r12 = r5
            goto L_0x03af
        L_0x06a7:
            r4 = r39
            com.alibaba.fastjson.parser.JavaBeanInfo r1 = r9.beanInfo     // Catch:{ all -> 0x06b1 }
            java.lang.String[] r1 = r1.creatorConstructorParameters     // Catch:{ all -> 0x06b1 }
            if (r1 == 0) goto L_0x06b3
            int r2 = r1.length     // Catch:{ all -> 0x06b1 }
            goto L_0x06b6
        L_0x06b1:
            r0 = move-exception
            goto L_0x06a4
        L_0x06b3:
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r2 = r9.fieldDeserializers     // Catch:{ all -> 0x06b1 }
            int r2 = r2.length     // Catch:{ all -> 0x06b1 }
        L_0x06b6:
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x06b1 }
        L_0x06b8:
            if (r12 >= r2) goto L_0x06dc
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer[] r6 = r9.fieldDeserializers     // Catch:{ all -> 0x06b1 }
            r6 = r6[r12]     // Catch:{ all -> 0x06b1 }
            com.alibaba.fastjson.util.FieldInfo r6 = r6.fieldInfo     // Catch:{ all -> 0x06b1 }
            if (r1 == 0) goto L_0x06c9
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x06b1 }
            java.lang.Object r7 = r0.remove(r7)     // Catch:{ all -> 0x06b1 }
            goto L_0x06cf
        L_0x06c9:
            java.lang.String r7 = r6.name     // Catch:{ all -> 0x06b1 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x06b1 }
        L_0x06cf:
            if (r7 != 0) goto L_0x06d7
            java.lang.Class<?> r6 = r6.fieldClass     // Catch:{ all -> 0x06b1 }
            java.lang.Object r7 = com.alibaba.fastjson.util.TypeUtils.defaultValue(r6)     // Catch:{ all -> 0x06b1 }
        L_0x06d7:
            r3[r12] = r7     // Catch:{ all -> 0x06b1 }
            int r12 = r12 + 1
            goto L_0x06b8
        L_0x06dc:
            com.alibaba.fastjson.parser.JavaBeanInfo r2 = r9.beanInfo     // Catch:{ all -> 0x06b1 }
            java.lang.reflect.Constructor<?> r6 = r2.creatorConstructor     // Catch:{ all -> 0x06b1 }
            if (r6 == 0) goto L_0x0734
            java.lang.Object r2 = r6.newInstance(r3)     // Catch:{ Exception -> 0x0713 }
            if (r1 == 0) goto L_0x0764
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0710 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0710 }
        L_0x06f0:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0710 }
            if (r1 == 0) goto L_0x0764
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0710 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0710 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ all -> 0x0710 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0710 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r3 = r9.getFieldDeserializer(r3)     // Catch:{ all -> 0x0710 }
            if (r3 == 0) goto L_0x06f0
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0710 }
            r3.setValue((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ all -> 0x0710 }
            goto L_0x06f0
        L_0x0710:
            r0 = move-exception
            r3 = r2
            goto L_0x0694
        L_0x0713:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x06b1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x06b1 }
            r2.<init>()     // Catch:{ all -> 0x06b1 }
            java.lang.String r3 = "create instance error, "
            r2.append(r3)     // Catch:{ all -> 0x06b1 }
            com.alibaba.fastjson.parser.JavaBeanInfo r3 = r9.beanInfo     // Catch:{ all -> 0x06b1 }
            java.lang.reflect.Constructor<?> r3 = r3.creatorConstructor     // Catch:{ all -> 0x06b1 }
            java.lang.String r3 = r3.toGenericString()     // Catch:{ all -> 0x06b1 }
            r2.append(r3)     // Catch:{ all -> 0x06b1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x06b1 }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x06b1 }
            throw r0     // Catch:{ all -> 0x06b1 }
        L_0x0734:
            java.lang.reflect.Method r0 = r2.factoryMethod     // Catch:{ all -> 0x06b1 }
            if (r0 == 0) goto L_0x073d
            r15 = 0
            java.lang.Object r22 = r0.invoke(r15, r3)     // Catch:{ Exception -> 0x0740 }
        L_0x073d:
            r2 = r22
            goto L_0x0764
        L_0x0740:
            r0 = move-exception
            r1 = r0
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x06b1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x06b1 }
            r2.<init>()     // Catch:{ all -> 0x06b1 }
            java.lang.String r3 = "create factory method error, "
            r2.append(r3)     // Catch:{ all -> 0x06b1 }
            com.alibaba.fastjson.parser.JavaBeanInfo r3 = r9.beanInfo     // Catch:{ all -> 0x06b1 }
            java.lang.reflect.Method r3 = r3.factoryMethod     // Catch:{ all -> 0x06b1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x06b1 }
            r2.append(r3)     // Catch:{ all -> 0x06b1 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x06b1 }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x06b1 }
            throw r0     // Catch:{ all -> 0x06b1 }
        L_0x0761:
            r4 = r39
            goto L_0x073d
        L_0x0764:
            if (r5 == 0) goto L_0x0768
            r5.object = r2
        L_0x0768:
            r4.setContext(r14)
            return r2
        L_0x076c:
            r4 = r39
            r6 = r41
            r15 = 0
            r5 = 18
            if (r1 == r5) goto L_0x0788
            if (r1 == r0) goto L_0x0788
        L_0x0777:
            r0 = r40
            r15 = r3
            r3 = r7
            r1 = r8
            r7 = r9
            r5 = r29
            r8 = r4
            r9 = r6
            r4 = r11
            r6 = r13
            r12 = r23
            r11 = r2
            goto L_0x0433
        L_0x0788:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x07a5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x07a5 }
            r1.<init>()     // Catch:{ all -> 0x07a5 }
            java.lang.String r2 = "syntax error, unexpect token "
            r1.append(r2)     // Catch:{ all -> 0x07a5 }
            int r2 = r10.token     // Catch:{ all -> 0x07a5 }
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)     // Catch:{ all -> 0x07a5 }
            r1.append(r2)     // Catch:{ all -> 0x07a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x07a5 }
            r0.<init>(r1)     // Catch:{ all -> 0x07a5 }
            throw r0     // Catch:{ all -> 0x07a5 }
        L_0x07a5:
            r0 = move-exception
            goto L_0x0652
        L_0x07a8:
            r4 = r39
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x07a5 }
            java.lang.String r1 = "syntax error, unexpect token ':'"
            r0.<init>(r1)     // Catch:{ all -> 0x07a5 }
            throw r0     // Catch:{ all -> 0x07a5 }
        L_0x07b2:
            r0 = move-exception
            r9 = r7
            r4 = r8
            r15 = r12
            r3 = r42
        L_0x07b8:
            if (r12 == 0) goto L_0x07bc
            r12.object = r3
        L_0x07bc:
            r4.setContext(r14)
            throw r0
        L_0x07c0:
            java.lang.Object r0 = r39.parse()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public Object createInstance(Map<String, Object> map, ParserConfig parserConfig) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        if (javaBeanInfo.creatorConstructor == null) {
            Object createInstance = createInstance((DefaultJSONParser) null, (Type) this.clazz);
            for (Map.Entry next : map.entrySet()) {
                FieldDeserializer fieldDeserializer = getFieldDeserializer((String) next.getKey());
                if (fieldDeserializer != null) {
                    Object value = next.getValue();
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Method method = fieldInfo.method;
                    if (method != null) {
                        method.invoke(createInstance, new Object[]{TypeUtils.cast(value, method.getGenericParameterTypes()[0], parserConfig)});
                    } else {
                        Field field = fieldInfo.field;
                        Type type = fieldInfo.fieldType;
                        String str = fieldInfo.format;
                        if (str == null || type != Date.class || !(value instanceof String)) {
                            obj = TypeUtils.cast(value, type, parserConfig);
                        } else {
                            try {
                                obj = new SimpleDateFormat(str).parse((String) value);
                            } catch (ParseException unused) {
                                obj = null;
                            }
                        }
                        field.set(createInstance, obj);
                    }
                }
            }
            return createInstance;
        }
        FieldInfo[] fieldInfoArr = javaBeanInfo.fields;
        int length = fieldInfoArr.length;
        Object[] objArr = new Object[length];
        for (int i10 = 0; i10 < length; i10++) {
            FieldInfo fieldInfo2 = fieldInfoArr[i10];
            Object obj2 = map.get(fieldInfo2.name);
            if (obj2 == null) {
                obj2 = TypeUtils.defaultValue(fieldInfo2.fieldClass);
            }
            objArr[i10] = obj2;
        }
        Constructor<?> constructor = this.beanInfo.creatorConstructor;
        if (constructor == null) {
            return null;
        }
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            throw new JSONException("create instance error, " + this.beanInfo.creatorConstructor.toGenericString(), e10);
        }
    }
}
