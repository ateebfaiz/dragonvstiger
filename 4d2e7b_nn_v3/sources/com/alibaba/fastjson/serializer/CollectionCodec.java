package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import okhttp3.HttpUrl;

public class CollectionCodec implements ObjectSerializer, ObjectDeserializer {
    public static final CollectionCodec instance = new CollectionCodec();

    private CollectionCodec() {
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t10;
        Type type2;
        if (defaultJSONParser.lexer.token() == 8) {
            defaultJSONParser.lexer.nextToken(16);
            return null;
        } else if (type == JSONArray.class) {
            T jSONArray = new JSONArray();
            defaultJSONParser.parseArray((Collection) jSONArray);
            return jSONArray;
        } else {
            Type type3 = type;
            while (!(type3 instanceof Class)) {
                if (type3 instanceof ParameterizedType) {
                    type3 = ((ParameterizedType) type3).getRawType();
                } else {
                    throw new JSONException("TODO");
                }
            }
            Class<Collection> cls = (Class) type3;
            if (cls == AbstractCollection.class || cls == Collection.class) {
                t10 = new ArrayList();
            } else if (cls.isAssignableFrom(HashSet.class)) {
                t10 = new HashSet();
            } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
                t10 = new LinkedHashSet();
            } else if (cls.isAssignableFrom(TreeSet.class)) {
                t10 = new TreeSet();
            } else if (cls.isAssignableFrom(ArrayList.class)) {
                t10 = new ArrayList();
            } else if (cls.isAssignableFrom(EnumSet.class)) {
                if (type instanceof ParameterizedType) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                } else {
                    type2 = Object.class;
                }
                t10 = EnumSet.noneOf((Class) type2);
            } else {
                try {
                    t10 = (Collection) cls.newInstance();
                } catch (Exception unused) {
                    throw new JSONException("create instane error, class " + cls.getName());
                }
            }
            defaultJSONParser.parseArray(TypeUtils.getCollectionItemType(type), t10, obj);
            return t10;
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        Type type2;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj != null) {
            int i10 = serializeWriter.features;
            SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
            if ((i10 & serializerFeature.mask) != 0) {
                type2 = TypeUtils.getCollectionItemType(type);
            } else {
                type2 = null;
            }
            Collection collection = (Collection) obj;
            SerialContext serialContext = jSONSerializer.context;
            int i11 = 0;
            jSONSerializer.setContext(serialContext, obj, obj2, 0);
            if ((serializeWriter.features & serializerFeature.mask) != 0) {
                if (HashSet.class == collection.getClass()) {
                    serializeWriter.append((CharSequence) "Set");
                } else if (TreeSet.class == collection.getClass()) {
                    serializeWriter.append((CharSequence) "TreeSet");
                }
            }
            try {
                serializeWriter.write(91);
                for (Object next : collection) {
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        serializeWriter.write(44);
                    }
                    if (next == null) {
                        serializeWriter.writeNull();
                    } else {
                        Class<?> cls = next.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) next).intValue());
                        } else if (cls == Long.class) {
                            serializeWriter.writeLong(((Long) next).longValue());
                            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                                serializeWriter.write(76);
                            }
                        } else {
                            jSONSerializer.config.get(cls).write(jSONSerializer, next, Integer.valueOf(i11), type2);
                        }
                    }
                    i11 = i12;
                }
                serializeWriter.write(93);
                jSONSerializer.context = serialContext;
            } catch (Throwable th) {
                jSONSerializer.context = serialContext;
                throw th;
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
            serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            serializeWriter.writeNull();
        }
    }
}
