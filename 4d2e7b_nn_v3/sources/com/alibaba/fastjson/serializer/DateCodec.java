package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    private DateCodec() {
    }

    /* access modifiers changed from: protected */
    public <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, String str) {
        DateFormat dateFormat;
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str2 = (String) obj2;
            if (str2.length() == 0) {
                return null;
            }
            JSONLexer jSONLexer = new JSONLexer(str2);
            try {
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    T t10 = jSONLexer.calendar;
                    if (type == Calendar.class) {
                        return t10;
                    }
                    T time = t10.getTime();
                    jSONLexer.close();
                    return time;
                }
                jSONLexer.close();
                if ("0000-00-00".equals(str2) || "0000-00-00T00:00:00".equalsIgnoreCase(str2) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str2)) {
                    return null;
                }
                if (str != null) {
                    dateFormat = new SimpleDateFormat(str);
                } else {
                    dateFormat = defaultJSONParser.getDateFormat();
                }
                try {
                    return dateFormat.parse(str2);
                } catch (ParseException unused) {
                    return new Date(Long.parseLong(str2));
                }
            } finally {
                jSONLexer.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return deserialze(defaultJSONParser, type, obj, (String) null);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        Date date;
        char[] cArr;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.out;
        if (obj3 == null) {
            serializeWriter.writeNull();
        } else if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
            if (obj3 instanceof Calendar) {
                date = ((Calendar) obj3).getTime();
            } else {
                date = (Date) obj3;
            }
            if ((serializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
                DateFormat dateFormat = jSONSerializer.getDateFormat();
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer2.locale);
                    dateFormat.setTimeZone(jSONSerializer2.timeZone);
                }
                serializeWriter.writeString(dateFormat.format(date));
                return;
            }
            long time = date.getTime();
            int i10 = serializeWriter.features;
            if ((SerializerFeature.UseISO8601DateFormat.mask & i10) != 0) {
                SerializerFeature serializerFeature = SerializerFeature.UseSingleQuotes;
                if ((i10 & serializerFeature.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
                Calendar instance2 = Calendar.getInstance(jSONSerializer2.timeZone, jSONSerializer2.locale);
                instance2.setTimeInMillis(time);
                int i11 = instance2.get(1);
                int i12 = instance2.get(2) + 1;
                int i13 = instance2.get(5);
                int i14 = instance2.get(11);
                int i15 = instance2.get(12);
                int i16 = instance2.get(13);
                int i17 = instance2.get(14);
                if (i17 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    SerializeWriter.getChars((long) i17, 23, cArr);
                    SerializeWriter.getChars((long) i16, 19, cArr);
                    SerializeWriter.getChars((long) i15, 16, cArr);
                    SerializeWriter.getChars((long) i14, 13, cArr);
                    SerializeWriter.getChars((long) i13, 10, cArr);
                    SerializeWriter.getChars((long) i12, 7, cArr);
                    SerializeWriter.getChars((long) i11, 4, cArr);
                } else if (i16 == 0 && i15 == 0 && i14 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    SerializeWriter.getChars((long) i13, 10, cArr);
                    SerializeWriter.getChars((long) i12, 7, cArr);
                    SerializeWriter.getChars((long) i11, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    SerializeWriter.getChars((long) i16, 19, cArr);
                    SerializeWriter.getChars((long) i15, 16, cArr);
                    SerializeWriter.getChars((long) i14, 13, cArr);
                    SerializeWriter.getChars((long) i13, 10, cArr);
                    SerializeWriter.getChars((long) i12, 7, cArr);
                    SerializeWriter.getChars((long) i11, 4, cArr);
                }
                serializeWriter.write(cArr);
                if ((serializeWriter.features & serializerFeature.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
            } else {
                serializeWriter.writeLong(time);
            }
        } else if (obj.getClass() == Date.class) {
            serializeWriter.write("new Date(");
            serializeWriter.writeLong(((Date) obj3).getTime());
            serializeWriter.write(41);
        } else {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer2.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeLong(((Date) obj3).getTime());
            serializeWriter.write(125);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x0117 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0118  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r12, java.lang.reflect.Type r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r11 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r12.lexer
            int r1 = r0.token()
            java.lang.Class<java.util.Calendar> r2 = java.util.Calendar.class
            r3 = 0
            r4 = 16
            r5 = 2
            if (r1 != r5) goto L_0x001c
            long r5 = r0.longValue()
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            r0.nextToken(r4)
        L_0x0019:
            r8 = r1
            goto L_0x0108
        L_0x001c:
            r6 = 4
            if (r1 != r6) goto L_0x004b
            java.lang.String r1 = r0.stringVal()
            r0.nextToken(r4)
            int r4 = r0.features
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
            int r5 = r5.mask
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0019
            com.alibaba.fastjson.parser.JSONLexer r4 = new com.alibaba.fastjson.parser.JSONLexer
            r4.<init>(r1)
            r5 = 1
            boolean r5 = r4.scanISO8601DateIfMatch(r5)
            if (r5 == 0) goto L_0x0047
            java.util.Calendar r1 = r4.calendar
            if (r13 != r2) goto L_0x0043
            r4.close()
            return r1
        L_0x0043:
            java.util.Date r1 = r1.getTime()
        L_0x0047:
            r4.close()
            goto L_0x0019
        L_0x004b:
            r7 = 8
            if (r1 != r7) goto L_0x0055
            r0.nextToken()
            r8 = r3
            goto L_0x0108
        L_0x0055:
            r7 = 12
            r8 = 13
            r9 = 17
            java.lang.String r10 = "syntax error"
            if (r1 != r7) goto L_0x00cb
            r0.nextToken()
            int r1 = r0.token()
            if (r1 != r6) goto L_0x00c5
            java.lang.String r1 = r0.stringVal()
            java.lang.String r7 = "@type"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x008f
            r0.nextToken()
            r12.accept(r9)
            java.lang.String r1 = r0.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r7 = r12.config
            int r9 = r0.features
            java.lang.Class r1 = r7.checkAutoType(r1, r3, r9)
            if (r1 == 0) goto L_0x0089
            r13 = r1
        L_0x0089:
            r12.accept(r6)
            r12.accept(r4)
        L_0x008f:
            r1 = 58
            r0.nextTokenWithChar(r1)
            int r1 = r0.token()
            if (r1 != r5) goto L_0x00aa
            long r4 = r0.longValue()
            r0.nextToken()
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r12.accept(r8)
            goto L_0x0019
        L_0x00aa:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "syntax error : "
            r13.append(r14)
            java.lang.String r14 = com.alibaba.fastjson.parser.JSONToken.name(r1)
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x00c5:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r10)
            throw r12
        L_0x00cb:
            int r1 = r12.resolveStatus
            if (r1 != r5) goto L_0x0102
            r1 = 0
            r12.resolveStatus = r1
            r12.accept(r4)
            int r1 = r0.token()
            if (r1 != r6) goto L_0x00fc
            java.lang.String r1 = "val"
            java.lang.String r4 = r0.stringVal()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00f6
            r0.nextToken()
            r12.accept(r9)
            java.lang.Object r1 = r12.parse()
            r12.accept(r8)
            goto L_0x0019
        L_0x00f6:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r10)
            throw r12
        L_0x00fc:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r10)
            throw r12
        L_0x0102:
            java.lang.Object r1 = r12.parse()
            goto L_0x0019
        L_0x0108:
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r9 = r15
            java.lang.Object r12 = r4.cast(r5, r6, r7, r8, r9)
            if (r13 != r2) goto L_0x0129
            boolean r13 = r12 instanceof java.util.Calendar
            if (r13 == 0) goto L_0x0118
            return r12
        L_0x0118:
            java.util.Date r12 = (java.util.Date) r12
            if (r12 != 0) goto L_0x011d
            return r3
        L_0x011d:
            java.util.TimeZone r13 = r0.timeZone
            java.util.Locale r14 = r0.locale
            java.util.Calendar r13 = java.util.Calendar.getInstance(r13, r14)
            r13.setTime(r12)
            return r13
        L_0x0129:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.DateCodec.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.String):java.lang.Object");
    }
}
