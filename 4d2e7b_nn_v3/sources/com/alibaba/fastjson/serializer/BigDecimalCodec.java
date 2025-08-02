package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;

public class BigDecimalCodec implements ObjectSerializer, ObjectDeserializer {
    public static final BigDecimalCodec instance = new BigDecimalCodec();

    private BigDecimalCodec() {
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        Class<BigInteger> cls = BigInteger.class;
        if (i10 == 2) {
            if (type == cls) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return new BigInteger(numberString, 10);
            }
            T decimalValue = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            return decimalValue;
        } else if (i10 == 3) {
            T decimalValue2 = jSONLexer.decimalValue();
            jSONLexer.nextToken(16);
            if (type == cls) {
                return decimalValue2.toBigInteger();
            }
            return decimalValue2;
        } else {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            if (type == cls) {
                return TypeUtils.castToBigInteger(parse);
            }
            return TypeUtils.castToBigDecimal(parse);
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
            } else {
                serializeWriter.writeNull();
            }
        } else if (obj instanceof BigInteger) {
            serializeWriter.write(((BigInteger) obj).toString());
        } else {
            BigDecimal bigDecimal = (BigDecimal) obj;
            serializeWriter.write(bigDecimal.toString());
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && type != BigDecimal.class && bigDecimal.scale() == 0) {
                serializeWriter.write(46);
            }
        }
    }
}
