package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class MapDeserializer implements ObjectDeserializer {
    public static MapDeserializer instance = new MapDeserializer();

    MapDeserializer() {
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r10 = r9.config.getDeserializer(r2);
        r0.nextToken(16);
        r9.resolveStatus = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00de, code lost:
        if (r1 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e2, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e4, code lost:
        r9.popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e7, code lost:
        r10 = (java.util.Map) r10.deserialze(r9, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ed, code lost:
        r9.setContext(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f0, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.reflect.Type r11, java.lang.Object r12) {
        /*
            com.alibaba.fastjson.parser.JSONLexer r0 = r9.lexer
            int r1 = r0.token
            r2 = 12
            if (r1 != r2) goto L_0x0150
            com.alibaba.fastjson.parser.ParseContext r1 = r9.contex
        L_0x000a:
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            char r2 = r0.ch     // Catch:{ all -> 0x001c }
        L_0x000f:
            r3 = 44
            if (r2 != r3) goto L_0x001f
            r0.next()     // Catch:{ all -> 0x001c }
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            char r2 = r0.ch     // Catch:{ all -> 0x001c }
            goto L_0x000f
        L_0x001c:
            r10 = move-exception
            goto L_0x014c
        L_0x001f:
            r3 = 0
            java.lang.String r4 = "syntax error, "
            r5 = 58
            r6 = 34
            r7 = 16
            if (r2 != r6) goto L_0x0051
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x001c }
            java.lang.String r2 = r0.scanSymbol(r2, r6)     // Catch:{ all -> 0x001c }
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            char r8 = r0.ch     // Catch:{ all -> 0x001c }
            if (r8 != r5) goto L_0x0038
            goto L_0x0099
        L_0x0038:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r11.<init>()     // Catch:{ all -> 0x001c }
            r11.append(r4)     // Catch:{ all -> 0x001c }
            java.lang.String r12 = r0.info()     // Catch:{ all -> 0x001c }
            r11.append(r12)     // Catch:{ all -> 0x001c }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x001c }
            r10.<init>(r11)     // Catch:{ all -> 0x001c }
            throw r10     // Catch:{ all -> 0x001c }
        L_0x0051:
            r8 = 125(0x7d, float:1.75E-43)
            if (r2 != r8) goto L_0x0061
            r0.next()     // Catch:{ all -> 0x001c }
            r0.sp = r3     // Catch:{ all -> 0x001c }
            r0.nextToken(r7)     // Catch:{ all -> 0x001c }
            r9.setContext(r1)
            return r10
        L_0x0061:
            r8 = 39
            if (r2 != r8) goto L_0x008c
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x001c }
            java.lang.String r2 = r0.scanSymbol(r2, r8)     // Catch:{ all -> 0x001c }
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            char r8 = r0.ch     // Catch:{ all -> 0x001c }
            if (r8 != r5) goto L_0x0073
            goto L_0x0099
        L_0x0073:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r11.<init>()     // Catch:{ all -> 0x001c }
            r11.append(r4)     // Catch:{ all -> 0x001c }
            java.lang.String r12 = r0.info()     // Catch:{ all -> 0x001c }
            r11.append(r12)     // Catch:{ all -> 0x001c }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x001c }
            r10.<init>(r11)     // Catch:{ all -> 0x001c }
            throw r10     // Catch:{ all -> 0x001c }
        L_0x008c:
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x001c }
            java.lang.String r2 = r0.scanSymbolUnQuoted(r2)     // Catch:{ all -> 0x001c }
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            char r4 = r0.ch     // Catch:{ all -> 0x001c }
            if (r4 != r5) goto L_0x012b
        L_0x0099:
            r0.next()     // Catch:{ all -> 0x001c }
            r0.skipWhitespace()     // Catch:{ all -> 0x001c }
            r0.sp = r3     // Catch:{ all -> 0x001c }
            java.lang.String r3 = "@type"
            r4 = 13
            r5 = 0
            if (r2 != r3) goto L_0x00f1
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x001c }
            boolean r3 = r0.isEnabled(r3)     // Catch:{ all -> 0x001c }
            if (r3 != 0) goto L_0x00f1
            com.alibaba.fastjson.parser.SymbolTable r2 = r9.symbolTable     // Catch:{ all -> 0x001c }
            java.lang.String r2 = r0.scanSymbol(r2, r6)     // Catch:{ all -> 0x001c }
            com.alibaba.fastjson.parser.ParserConfig r3 = r9.config     // Catch:{ all -> 0x001c }
            int r6 = r0.features     // Catch:{ all -> 0x001c }
            java.lang.Class r2 = r3.checkAutoType(r2, r5, r6)     // Catch:{ all -> 0x001c }
            java.lang.Class r3 = r10.getClass()     // Catch:{ all -> 0x001c }
            if (r2 != r3) goto L_0x00d2
            r0.nextToken(r7)     // Catch:{ all -> 0x001c }
            int r2 = r0.token     // Catch:{ all -> 0x001c }
            if (r2 != r4) goto L_0x000a
            r0.nextToken(r7)     // Catch:{ all -> 0x001c }
            r9.setContext(r1)
            return r10
        L_0x00d2:
            com.alibaba.fastjson.parser.ParserConfig r10 = r9.config     // Catch:{ all -> 0x001c }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r10 = r10.getDeserializer(r2)     // Catch:{ all -> 0x001c }
            r0.nextToken(r7)     // Catch:{ all -> 0x001c }
            r11 = 2
            r9.resolveStatus = r11     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x00e7
            boolean r11 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x001c }
            if (r11 != 0) goto L_0x00e7
            r9.popContext()     // Catch:{ all -> 0x001c }
        L_0x00e7:
            java.lang.Object r10 = r10.deserialze(r9, r2, r12)     // Catch:{ all -> 0x001c }
            java.util.Map r10 = (java.util.Map) r10     // Catch:{ all -> 0x001c }
            r9.setContext(r1)
            return r10
        L_0x00f1:
            r0.nextToken()     // Catch:{ all -> 0x001c }
            r9.setContext(r1)     // Catch:{ all -> 0x001c }
            int r3 = r0.token     // Catch:{ all -> 0x001c }
            r6 = 8
            if (r3 != r6) goto L_0x0101
            r0.nextToken()     // Catch:{ all -> 0x001c }
            goto L_0x0105
        L_0x0101:
            java.lang.Object r5 = r9.parseObject((java.lang.reflect.Type) r11, (java.lang.Object) r2)     // Catch:{ all -> 0x001c }
        L_0x0105:
            r10.put(r2, r5)     // Catch:{ all -> 0x001c }
            int r3 = r9.resolveStatus     // Catch:{ all -> 0x001c }
            r6 = 1
            if (r3 != r6) goto L_0x0110
            r9.checkMapResolve(r10, r2)     // Catch:{ all -> 0x001c }
        L_0x0110:
            r9.setContext(r1, r5, r2)     // Catch:{ all -> 0x001c }
            int r2 = r0.token     // Catch:{ all -> 0x001c }
            r3 = 20
            if (r2 == r3) goto L_0x0127
            r3 = 15
            if (r2 != r3) goto L_0x011e
            goto L_0x0127
        L_0x011e:
            if (r2 != r4) goto L_0x000a
            r0.nextToken()     // Catch:{ all -> 0x001c }
            r9.setContext(r1)
            return r10
        L_0x0127:
            r9.setContext(r1)
            return r10
        L_0x012b:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r11.<init>()     // Catch:{ all -> 0x001c }
            java.lang.String r12 = "expect ':' at "
            r11.append(r12)     // Catch:{ all -> 0x001c }
            int r12 = r0.pos     // Catch:{ all -> 0x001c }
            r11.append(r12)     // Catch:{ all -> 0x001c }
            java.lang.String r12 = ", actual "
            r11.append(r12)     // Catch:{ all -> 0x001c }
            r11.append(r4)     // Catch:{ all -> 0x001c }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x001c }
            r10.<init>(r11)     // Catch:{ all -> 0x001c }
            throw r10     // Catch:{ all -> 0x001c }
        L_0x014c:
            r9.setContext(r1)
            throw r10
        L_0x0150:
            com.alibaba.fastjson.JSONException r9 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "syntax error, expect {, actual "
            r10.append(r11)
            int r11 = r0.token
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    /* access modifiers changed from: protected */
    public Map<?, ?> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type == JSONObject.class) {
            return new JSONObject();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return createMap(rawType);
        }
        Class cls = (Class) type;
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e10) {
                throw new JSONException("unsupport type " + type, e10);
            }
        } else {
            throw new JSONException("unsupport type " + type);
        }
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (type == JSONObject.class && defaultJSONParser.fieldTypeResolver == null) {
            return defaultJSONParser.parseObject();
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken(16);
            return null;
        }
        Map<?, ?> createMap = createMap(type);
        ParseContext parseContext = defaultJSONParser.contex;
        try {
            defaultJSONParser.setContext(parseContext, createMap, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    return parseMap(defaultJSONParser, createMap, type3, obj);
                }
                T parseMap = parseMap(defaultJSONParser, createMap, type2, type3, obj);
                defaultJSONParser.setContext(parseContext);
                return parseMap;
            }
            T parseObject = defaultJSONParser.parseObject((Map) createMap, obj);
            defaultJSONParser.setContext(parseContext);
            return parseObject;
        } finally {
            defaultJSONParser.setContext(parseContext);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        r4.nextTokenWithChar(':');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        if (r4.token != 4) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        r0 = r4.stringVal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        if ("..".equals(r0) == false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r12 = r8.parent.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008e, code lost:
        if ("$".equals(r0) == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        r2 = r0.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0093, code lost:
        if (r2 == null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0095, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        r12 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009a, code lost:
        r1.addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r8, r0));
        r1.resolveStatus = 1;
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        r4.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        if (r4.token != 13) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b1, code lost:
        r1.setContext(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00bc, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d7, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r9));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object parseMap(com.alibaba.fastjson.parser.DefaultJSONParser r16, java.util.Map<java.lang.Object, java.lang.Object> r17, java.lang.reflect.Type r18, java.lang.reflect.Type r19, java.lang.Object r20) {
        /*
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            com.alibaba.fastjson.parser.JSONLexer r4 = r1.lexer
            int r5 = r4.token
            r6 = 12
            r7 = 16
            if (r5 == r6) goto L_0x0030
            if (r5 != r7) goto L_0x0015
            goto L_0x0030
        L_0x0015:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, expect {, actual "
            r1.append(r2)
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r5)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0030:
            com.alibaba.fastjson.parser.ParserConfig r5 = r1.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r5 = r5.getDeserializer(r2)
            com.alibaba.fastjson.parser.ParserConfig r6 = r1.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r6 = r6.getDeserializer(r3)
            r4.nextToken()
            com.alibaba.fastjson.parser.ParseContext r8 = r1.contex
        L_0x0041:
            int r9 = r4.token     // Catch:{ all -> 0x004e }
            r10 = 13
            if (r9 != r10) goto L_0x0051
            r4.nextToken(r7)     // Catch:{ all -> 0x004e }
            r1.setContext(r8)
            return r0
        L_0x004e:
            r0 = move-exception
            goto L_0x014b
        L_0x0051:
            r11 = 58
            r13 = 1
            r14 = 4
            if (r9 != r14) goto L_0x00d8
            int r15 = r4.sp     // Catch:{ all -> 0x004e }
            if (r15 != r14) goto L_0x00d8
            java.lang.String r15 = r4.text     // Catch:{ all -> 0x004e }
            java.lang.String r12 = "$ref"
            int r7 = r4.np     // Catch:{ all -> 0x004e }
            int r7 = r7 + r13
            boolean r7 = r15.startsWith(r12, r7)     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x00d8
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x004e }
            boolean r7 = r4.isEnabled(r7)     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x00d8
            r4.nextTokenWithChar(r11)     // Catch:{ all -> 0x004e }
            int r0 = r4.token     // Catch:{ all -> 0x004e }
            if (r0 != r14) goto L_0x00bd
            java.lang.String r0 = r4.stringVal()     // Catch:{ all -> 0x004e }
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0088
            com.alibaba.fastjson.parser.ParseContext r0 = r8.parent     // Catch:{ all -> 0x004e }
            java.lang.Object r12 = r0.object     // Catch:{ all -> 0x004e }
            goto L_0x00a5
        L_0x0088:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x009a
            r0 = r8
        L_0x0091:
            com.alibaba.fastjson.parser.ParseContext r2 = r0.parent     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0097
            r0 = r2
            goto L_0x0091
        L_0x0097:
            java.lang.Object r12 = r0.object     // Catch:{ all -> 0x004e }
            goto L_0x00a5
        L_0x009a:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x004e }
            r2.<init>(r8, r0)     // Catch:{ all -> 0x004e }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x004e }
            r1.resolveStatus = r13     // Catch:{ all -> 0x004e }
            r12 = 0
        L_0x00a5:
            r4.nextToken(r10)     // Catch:{ all -> 0x004e }
            int r0 = r4.token     // Catch:{ all -> 0x004e }
            if (r0 != r10) goto L_0x00b5
            r0 = 16
            r4.nextToken(r0)     // Catch:{ all -> 0x004e }
            r1.setContext(r8)
            return r12
        L_0x00b5:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "illegal ref"
            r0.<init>(r2)     // Catch:{ all -> 0x004e }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x00bd:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r2.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x004e }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r9)     // Catch:{ all -> 0x004e }
            r2.append(r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004e }
            r0.<init>(r2)     // Catch:{ all -> 0x004e }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x00d8:
            int r7 = r17.size()     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x010a
            if (r9 != r14) goto L_0x010a
            java.lang.String r7 = "@type"
            java.lang.String r9 = r4.stringVal()     // Catch:{ all -> 0x004e }
            boolean r7 = r7.equals(r9)     // Catch:{ all -> 0x004e }
            if (r7 == 0) goto L_0x010a
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x004e }
            boolean r7 = r4.isEnabled(r7)     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x010a
            r4.nextTokenWithChar(r11)     // Catch:{ all -> 0x004e }
            r7 = 16
            r4.nextToken(r7)     // Catch:{ all -> 0x004e }
            int r7 = r4.token     // Catch:{ all -> 0x004e }
            if (r7 != r10) goto L_0x0107
            r4.nextToken()     // Catch:{ all -> 0x004e }
            r1.setContext(r8)
            return r0
        L_0x0107:
            r4.nextToken()     // Catch:{ all -> 0x004e }
        L_0x010a:
            r7 = 0
            java.lang.Object r7 = r5.deserialze(r1, r2, r7)     // Catch:{ all -> 0x004e }
            int r9 = r4.token     // Catch:{ all -> 0x004e }
            r10 = 17
            if (r9 != r10) goto L_0x0132
            r4.nextToken()     // Catch:{ all -> 0x004e }
            java.lang.Object r9 = r6.deserialze(r1, r3, r7)     // Catch:{ all -> 0x004e }
            int r10 = r1.resolveStatus     // Catch:{ all -> 0x004e }
            if (r10 != r13) goto L_0x0123
            r1.checkMapResolve(r0, r7)     // Catch:{ all -> 0x004e }
        L_0x0123:
            r0.put(r7, r9)     // Catch:{ all -> 0x004e }
            int r7 = r4.token     // Catch:{ all -> 0x004e }
            r9 = 16
            if (r7 != r9) goto L_0x012f
            r4.nextToken()     // Catch:{ all -> 0x004e }
        L_0x012f:
            r7 = r9
            goto L_0x0041
        L_0x0132:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x004e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r2.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "syntax error, expect :, actual "
            r2.append(r3)     // Catch:{ all -> 0x004e }
            int r3 = r4.token     // Catch:{ all -> 0x004e }
            r2.append(r3)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004e }
            r0.<init>(r2)     // Catch:{ all -> 0x004e }
            throw r0     // Catch:{ all -> 0x004e }
        L_0x014b:
            r1.setContext(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.MapDeserializer.parseMap(com.alibaba.fastjson.parser.DefaultJSONParser, java.util.Map, java.lang.reflect.Type, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
