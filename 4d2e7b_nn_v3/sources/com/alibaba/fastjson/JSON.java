package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ParseProcess;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JavaBeanSerializer;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.util.TypeUtils;
import com.alibaba.pdns.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

public abstract class JSON implements JSONStreamAware, JSONAware {
    public static int DEFAULT_GENERATE_FEATURE = (((SerializerFeature.QuoteFieldNames.mask | SerializerFeature.SkipTransientField.mask) | SerializerFeature.WriteEnumUsingToString.mask) | SerializerFeature.SortField.mask);
    public static int DEFAULT_PARSER_FEATURE = ((Feature.UseBigDecimal.mask | Feature.SortFeidFastMatch.mask) | Feature.IgnoreNotMatch.mask);
    public static final String DEFAULT_TYPE_KEY = "@type";
    public static String DEFFAULT_DATE_FORMAT = o.f18139c;
    public static final String VERSION = "1.1.70";
    public static Locale defaultLocale = Locale.getDefault();
    public static TimeZone defaultTimeZone = TimeZone.getDefault();

    public static final Object parse(String str) {
        return parse(str, DEFAULT_PARSER_FEATURE);
    }

    public static final JSONArray parseArray(String str) {
        return parseArray(str, new Feature[0]);
    }

    public static final JSONObject parseObject(String str, Feature... featureArr) {
        Object parse = parse(str, featureArr);
        if (parse instanceof JSONObject) {
            return (JSONObject) parse;
        }
        JSONObject jSONObject = (JSONObject) toJSON(parse);
        boolean z10 = (DEFAULT_PARSER_FEATURE & Feature.SupportAutoType.mask) != 0;
        if (!z10) {
            for (Feature feature : featureArr) {
                if (feature == Feature.SupportAutoType) {
                    z10 = true;
                }
            }
        }
        if (z10) {
            jSONObject.put(DEFAULT_TYPE_KEY, (Object) parse.getClass().getName());
        }
        return jSONObject;
    }

    public static final Object toJSON(Object obj) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static final byte[] toJSONBytes(Object obj, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
            return serializeWriter.toBytes("UTF-8");
        } finally {
            serializeWriter.close();
        }
    }

    public static final String toJSONString(Object obj) {
        return toJSONString(obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, (String) null, DEFAULT_GENERATE_FEATURE, new SerializerFeature[0]);
    }

    public static final String toJSONStringWithDateFormat(Object obj, String str, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, str, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final String toJSONStringZ(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, (String) null, 0, serializerFeatureArr);
    }

    public static final <T> T toJavaObject(JSON json, Class<T> cls) {
        return TypeUtils.cast((Object) json, cls, ParserConfig.global);
    }

    public static final void writeJSONStringTo(Object obj, Writer writer, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter(writer, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write(obj);
        } finally {
            serializeWriter.close();
        }
    }

    public String toString() {
        return toJSONString();
    }

    public void writeJSONString(Appendable appendable) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write((Object) this);
            appendable.append(serializeWriter.toString());
            serializeWriter.close();
        } catch (IOException e10) {
            throw new JSONException(e10.getMessage(), e10);
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final Object parse(String str, int i10) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global, i10);
        Object parse = defaultJSONParser.parse((Object) null);
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static final JSONArray parseArray(String str, Feature... featureArr) {
        JSONArray jSONArray = null;
        if (str == null) {
            return null;
        }
        int i10 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global, i10);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i11 = jSONLexer.token();
        if (i11 == 8) {
            jSONLexer.nextToken();
        } else if (i11 != 20) {
            jSONArray = new JSONArray();
            defaultJSONParser.parseArray((Collection) jSONArray);
            defaultJSONParser.handleResovleTask(jSONArray);
        }
        defaultJSONParser.close();
        return jSONArray;
    }

    @Deprecated
    public static final Object toJSON(Object obj, ParserConfig parserConfig) {
        return toJSON(obj, SerializeConfig.globalInstance);
    }

    public static final String toJSONString(Object obj, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public <T> T toJavaObject(Class<T> cls) {
        return TypeUtils.cast((Object) this, cls, ParserConfig.getGlobalInstance());
    }

    public static Object toJSON(Object obj, SerializeConfig serializeConfig) {
        Map map;
        if (obj == null) {
            return null;
        }
        if (obj instanceof JSON) {
            return (JSON) obj;
        }
        if (obj instanceof Map) {
            Map map2 = (Map) obj;
            int size = map2.size();
            if (map2 instanceof LinkedHashMap) {
                map = new LinkedHashMap(size);
            } else if (map2 instanceof TreeMap) {
                map = new TreeMap();
            } else {
                map = new HashMap(size);
            }
            JSONObject jSONObject = new JSONObject((Map<String, Object>) map);
            for (Map.Entry entry : map2.entrySet()) {
                jSONObject.put(TypeUtils.castToString(entry.getKey()), toJSON(entry.getValue()));
            }
            return jSONObject;
        } else if (obj instanceof Collection) {
            Collection<Object> collection = (Collection) obj;
            JSONArray jSONArray = new JSONArray(collection.size());
            for (Object json : collection) {
                jSONArray.add(toJSON(json));
            }
            return jSONArray;
        } else {
            Class<?> cls = obj.getClass();
            if (cls.isEnum()) {
                return ((Enum) obj).name();
            }
            if (cls.isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray(length);
                for (int i10 = 0; i10 < length; i10++) {
                    jSONArray2.add(toJSON(Array.get(obj, i10)));
                }
                return jSONArray2;
            } else if (ParserConfig.isPrimitive(cls)) {
                return obj;
            } else {
                ObjectSerializer objectSerializer = serializeConfig.get(cls);
                if (!(objectSerializer instanceof JavaBeanSerializer)) {
                    return null;
                }
                JavaBeanSerializer javaBeanSerializer = (JavaBeanSerializer) objectSerializer;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    for (Map.Entry next : javaBeanSerializer.getFieldValuesMap(obj).entrySet()) {
                        jSONObject2.put((String) next.getKey(), toJSON(next.getValue()));
                    }
                    return jSONObject2;
                } catch (Exception e10) {
                    throw new JSONException("toJSON error", e10);
                }
            }
        }
    }

    public static final String toJSONString(Object obj, int i10, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, (SerializeFilter[]) null, (String) null, i10, serializerFeatureArr);
    }

    public static final String toJSONString(Object obj, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, new SerializeFilter[]{serializeFilter}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final String toJSONString(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, SerializeConfig.globalInstance, serializeFilterArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final Object parse(byte[] bArr, Feature... featureArr) {
        try {
            return parseObject(new String(bArr, "UTF-8"), featureArr);
        } catch (UnsupportedEncodingException e10) {
            throw new JSONException("UTF-8 not support", e10);
        }
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, (SerializeFilter[]) null, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
        try {
            new JSONSerializer(serializeWriter, serializeConfig).write(obj);
            return serializeWriter.toBytes("UTF-8");
        } finally {
            serializeWriter.close();
        }
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter serializeFilter, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, new SerializeFilter[]{serializeFilter}, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final Object parse(String str, Feature... featureArr) {
        int i10 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        return parse(str, i10);
    }

    public static final String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONString(obj, serializeConfig, serializeFilterArr, (String) null, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final JSONObject parseObject(String str) {
        Object parse = parse(str);
        if ((parse instanceof JSONObject) || parse == null) {
            return (JSONObject) parse;
        }
        JSONObject jSONObject = (JSONObject) toJSON(parse);
        if ((DEFAULT_PARSER_FEATURE & Feature.SupportAutoType.mask) != 0) {
            jSONObject.put(DEFAULT_TYPE_KEY, (Object) parse.getClass().getName());
        }
        return jSONObject;
    }

    public static final String toJSONString(Object obj, boolean z10) {
        if (!z10) {
            return toJSONString(obj);
        }
        return toJSONString(obj, SerializerFeature.PrettyFormat);
    }

    public String toJSONString() {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
        try {
            new JSONSerializer(serializeWriter, SerializeConfig.globalInstance).write((Object) this);
            return serializeWriter.toString();
        } finally {
            serializeWriter.close();
        }
    }

    public static Object parse(String str, ParserConfig parserConfig) {
        return parse(str, parserConfig, DEFAULT_PARSER_FEATURE);
    }

    public static Object parse(String str, ParserConfig parserConfig, Feature... featureArr) {
        int i10 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        return parse(str, parserConfig, i10);
    }

    public static final <T> List<T> parseArray(String str, Class<T> cls) {
        ArrayList arrayList = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global);
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken();
        } else if (i10 != 20 || !jSONLexer.isBlankInput()) {
            arrayList = new ArrayList();
            defaultJSONParser.parseArray((Class<?>) cls, (Collection) arrayList);
            defaultJSONParser.handleResovleTask(arrayList);
        }
        defaultJSONParser.close();
        return arrayList;
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, int i10, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, serializeConfig, new SerializeFilter[0], i10, serializerFeatureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeFilter[] serializeFilterArr, SerializerFeature... serializerFeatureArr) {
        return toJSONBytes(obj, SerializeConfig.globalInstance, serializeFilterArr, DEFAULT_GENERATE_FEATURE, serializerFeatureArr);
    }

    public static final <T> T parseObject(String str, TypeReference<T> typeReference, Feature... featureArr) {
        return parseObject(str, typeReference.type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static byte[] toJSONBytes(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, int i10, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i10, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            if (serializeFilterArr != null) {
                for (PropertyPreFilter propertyPreFilter : serializeFilterArr) {
                    if (propertyPreFilter != null) {
                        if (propertyPreFilter instanceof PropertyPreFilter) {
                            jSONSerializer.getPropertyPreFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof NameFilter) {
                            jSONSerializer.getNameFilters().add((NameFilter) propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof ValueFilter) {
                            jSONSerializer.getValueFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof PropertyFilter) {
                            jSONSerializer.getPropertyFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof BeforeFilter) {
                            jSONSerializer.getBeforeFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof AfterFilter) {
                            jSONSerializer.getAfterFilters().add((AfterFilter) propertyPreFilter);
                        }
                    }
                }
            }
            jSONSerializer.write(obj);
            byte[] bytes = serializeWriter.toBytes("UTF-8");
            serializeWriter.close();
            return bytes;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final <T> T parseObject(String str, Class<T> cls, Feature... featureArr) {
        return parseObject(str, cls, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static Object parse(String str, ParserConfig parserConfig, int i10) {
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i10);
        Object parse = defaultJSONParser.parse();
        defaultJSONParser.handleResovleTask(parse);
        defaultJSONParser.close();
        return parse;
    }

    public static final <T> T parseObject(String str, Class<T> cls, ParseProcess parseProcess, Feature... featureArr) {
        return parseObject(str, cls, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static String toJSONString(Object obj, SerializeConfig serializeConfig, SerializeFilter[] serializeFilterArr, String str, int i10, SerializerFeature... serializerFeatureArr) {
        SerializeWriter serializeWriter = new SerializeWriter((Writer) null, i10, serializerFeatureArr);
        try {
            JSONSerializer jSONSerializer = new JSONSerializer(serializeWriter, serializeConfig);
            for (SerializerFeature config : serializerFeatureArr) {
                jSONSerializer.config(config, true);
            }
            if (!(str == null || str.length() == 0)) {
                jSONSerializer.setDateFormat(str);
                jSONSerializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            }
            if (serializeFilterArr != null) {
                for (PropertyPreFilter propertyPreFilter : serializeFilterArr) {
                    if (propertyPreFilter != null) {
                        if (propertyPreFilter instanceof PropertyPreFilter) {
                            jSONSerializer.getPropertyPreFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof NameFilter) {
                            jSONSerializer.getNameFilters().add((NameFilter) propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof ValueFilter) {
                            jSONSerializer.getValueFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof PropertyFilter) {
                            jSONSerializer.getPropertyFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof BeforeFilter) {
                            jSONSerializer.getBeforeFilters().add(propertyPreFilter);
                        }
                        if (propertyPreFilter instanceof AfterFilter) {
                            jSONSerializer.getAfterFilters().add((AfterFilter) propertyPreFilter);
                        }
                    }
                }
            }
            jSONSerializer.write(obj);
            String serializeWriter2 = serializeWriter.toString();
            serializeWriter.close();
            return serializeWriter2;
        } catch (Throwable th) {
            serializeWriter.close();
            throw th;
        }
    }

    public static final <T> T parseObject(String str, Type type, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.global, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(String str, Type type, ParseProcess parseProcess, Feature... featureArr) {
        return parseObject(str, type, ParserConfig.global, parseProcess, DEFAULT_PARSER_FEATURE, featureArr);
    }

    public static final <T> T parseObject(String str, Type type, int i10, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global, i10);
        T parseObject = defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static final List<Object> parseArray(String str, Type[] typeArr) {
        List<Object> list = null;
        if (str == null) {
            return null;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, ParserConfig.global);
        Object[] parseArray = defaultJSONParser.parseArray(typeArr);
        if (parseArray != null) {
            list = Arrays.asList(parseArray);
        }
        defaultJSONParser.handleResovleTask(list);
        defaultJSONParser.close();
        return list;
    }

    public static final <T> T parseObject(String str, Type type, ParserConfig parserConfig, int i10, Feature... featureArr) {
        return parseObject(str, type, parserConfig, (ParseProcess) null, i10, featureArr);
    }

    public static final <T> T parseObject(String str, Type type, ParserConfig parserConfig, ParseProcess parseProcess, int i10, Feature... featureArr) {
        if (str == null) {
            return null;
        }
        for (Feature feature : featureArr) {
            i10 |= feature.mask;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(str, parserConfig, i10);
        if (parseProcess instanceof ExtraTypeProvider) {
            defaultJSONParser.getExtraTypeProviders().add((ExtraTypeProvider) parseProcess);
        }
        if (parseProcess instanceof ExtraProcessor) {
            defaultJSONParser.getExtraProcessors().add((ExtraProcessor) parseProcess);
        }
        if (parseProcess instanceof FieldTypeResolver) {
            defaultJSONParser.fieldTypeResolver = (FieldTypeResolver) parseProcess;
        }
        T parseObject = defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static final <T> T parseObject(byte[] bArr, Type type, Feature... featureArr) {
        try {
            return parseObject(new String(bArr, "UTF-8"), type, featureArr);
        } catch (UnsupportedEncodingException unused) {
            throw new JSONException("UTF-8 not support");
        }
    }

    public static final <T> T parseObject(char[] cArr, int i10, Type type, Feature... featureArr) {
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        int i11 = DEFAULT_PARSER_FEATURE;
        for (Feature feature : featureArr) {
            i11 |= feature.mask;
        }
        DefaultJSONParser defaultJSONParser = new DefaultJSONParser(cArr, i10, ParserConfig.global, i11);
        T parseObject = defaultJSONParser.parseObject(type);
        defaultJSONParser.handleResovleTask(parseObject);
        defaultJSONParser.close();
        return parseObject;
    }

    public static final <T> T parseObject(String str, Class<T> cls) {
        return parseObject(str, cls, new Feature[0]);
    }
}
