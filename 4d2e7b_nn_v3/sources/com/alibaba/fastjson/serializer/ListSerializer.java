package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.IdentityHashMap;
import java.util.List;
import okhttp3.HttpUrl;

public final class ListSerializer implements ObjectSerializer {
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        boolean z10;
        Type type2;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        Object obj4 = obj2;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        int i10 = 1;
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            type2 = TypeUtils.getCollectionItemType(type);
        } else {
            type2 = null;
        }
        if (obj3 != null) {
            List list = (List) obj3;
            int size = list.size();
            if (size == 0) {
                serializeWriter.append((CharSequence) HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
            SerialContext serialContext = jSONSerializer2.context;
            if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                jSONSerializer2.context = new SerialContext(serialContext, obj3, obj4, 0);
                if (jSONSerializer2.references == null) {
                    jSONSerializer2.references = new IdentityHashMap<>();
                }
                jSONSerializer2.references.put(obj3, jSONSerializer2.context);
            }
            try {
                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                    serializeWriter.write(91);
                    jSONSerializer.incrementIndent();
                    for (int i11 = 0; i11 < size; i11++) {
                        Object obj5 = list.get(i11);
                        if (i11 != 0) {
                            serializeWriter.write(44);
                        }
                        jSONSerializer.println();
                        if (obj5 != null) {
                            IdentityHashMap<Object, SerialContext> identityHashMap = jSONSerializer2.references;
                            if (identityHashMap == null || !identityHashMap.containsKey(obj5)) {
                                ObjectSerializer objectSerializer = jSONSerializer2.config.get(obj5.getClass());
                                jSONSerializer2.context = new SerialContext(serialContext, obj3, obj4, 0);
                                objectSerializer.write(jSONSerializer2, obj5, Integer.valueOf(i11), type2);
                            } else {
                                jSONSerializer2.writeReference(obj5);
                            }
                        } else {
                            jSONSerializer2.out.writeNull();
                        }
                    }
                    jSONSerializer.decrementIdent();
                    jSONSerializer.println();
                    serializeWriter.write(93);
                    jSONSerializer2.context = serialContext;
                    return;
                }
                int i12 = serializeWriter.count + 1;
                if (i12 > serializeWriter.buf.length) {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i12);
                    } else {
                        serializeWriter.flush();
                        i12 = 1;
                    }
                }
                serializeWriter.buf[serializeWriter.count] = '[';
                serializeWriter.count = i12;
                for (int i13 = 0; i13 < list.size(); i13++) {
                    Object obj6 = list.get(i13);
                    if (i13 != 0) {
                        int i14 = serializeWriter.count + 1;
                        if (i14 > serializeWriter.buf.length) {
                            if (serializeWriter.writer == null) {
                                serializeWriter.expandCapacity(i14);
                            } else {
                                serializeWriter.flush();
                                i14 = 1;
                            }
                        }
                        serializeWriter.buf[serializeWriter.count] = ',';
                        serializeWriter.count = i14;
                    }
                    if (obj6 == null) {
                        serializeWriter.append((CharSequence) "null");
                    } else {
                        Class<?> cls = obj6.getClass();
                        if (cls == Integer.class) {
                            serializeWriter.writeInt(((Integer) obj6).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj6).longValue();
                            if (z10) {
                                serializeWriter.writeLong(longValue);
                                serializeWriter.write(76);
                            } else {
                                serializeWriter.writeLong(longValue);
                            }
                        } else if (cls == String.class) {
                            String str = (String) obj6;
                            if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                serializeWriter.writeStringWithSingleQuote(str);
                            } else {
                                serializeWriter.writeStringWithDoubleQuote(str, 0, true);
                            }
                        } else {
                            if ((serializeWriter.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
                                jSONSerializer2.context = new SerialContext(serialContext, obj3, obj4, 0);
                            }
                            IdentityHashMap<Object, SerialContext> identityHashMap2 = jSONSerializer2.references;
                            if (identityHashMap2 == null || !identityHashMap2.containsKey(obj6)) {
                                jSONSerializer2.config.get(obj6.getClass()).write(jSONSerializer2, obj6, Integer.valueOf(i13), type2);
                            } else {
                                jSONSerializer2.writeReference(obj6);
                            }
                        }
                    }
                }
                int i15 = serializeWriter.count + 1;
                if (i15 > serializeWriter.buf.length) {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i15);
                    } else {
                        serializeWriter.flush();
                        serializeWriter.buf[serializeWriter.count] = ']';
                        serializeWriter.count = i10;
                        jSONSerializer2.context = serialContext;
                    }
                }
                i10 = i15;
                serializeWriter.buf[serializeWriter.count] = ']';
                serializeWriter.count = i10;
                jSONSerializer2.context = serialContext;
            } catch (Throwable th) {
                jSONSerializer2.context = serialContext;
                throw th;
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
            serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            serializeWriter.writeNull();
        }
    }
}
