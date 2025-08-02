package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    private IntegerCodec() {
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        T t10;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Class<Long> cls = Long.class;
        if (i10 == 2) {
            if (type == Long.TYPE || type == cls) {
                t10 = Long.valueOf(jSONLexer.longValue());
            } else {
                try {
                    t10 = Integer.valueOf(jSONLexer.intValue());
                } catch (NumberFormatException e10) {
                    throw new JSONException("int value overflow, field : " + obj, e10);
                }
            }
            jSONLexer.nextToken(16);
            return t10;
        } else if (i10 == 3) {
            BigDecimal decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == Long.TYPE || type == cls) {
                return Long.valueOf(decimalValue.longValue());
            }
            return Integer.valueOf(decimalValue.intValue());
        } else {
            Object parse = defaultJSONParser.parse();
            try {
                if (type != Long.TYPE) {
                    if (type != cls) {
                        return TypeUtils.castToInt(parse);
                    }
                }
                return TypeUtils.castToLong(parse);
            } catch (Exception e11) {
                throw new JSONException("cast error, field : " + obj + ", value " + parse, e11);
            }
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        Number number = (Number) obj;
        if (number != null) {
            if (obj instanceof Long) {
                serializeWriter.writeLong(number.longValue());
            } else {
                serializeWriter.writeInt(number.intValue());
            }
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                Class<?> cls = number.getClass();
                if (cls == Byte.class) {
                    serializeWriter.write(66);
                } else if (cls == Short.class) {
                    serializeWriter.write(83);
                } else {
                    Class<Long> cls2 = Long.class;
                    if (cls == cls2) {
                        long longValue = number.longValue();
                        if (longValue <= 2147483647L && longValue >= -2147483648L && type != cls2) {
                            serializeWriter.write(76);
                        }
                    }
                }
            }
        } else if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
            serializeWriter.write(48);
        } else {
            serializeWriter.writeNull();
        }
    }
}
