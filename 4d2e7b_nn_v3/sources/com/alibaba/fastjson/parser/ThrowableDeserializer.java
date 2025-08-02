package com.alibaba.fastjson.parser;

public class ThrowableDeserializer extends JavaBeanDeserializer {
    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls, cls);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.alibaba.fastjson.parser.deserializer.ObjectDeserializer] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        if (r7.isAssignableFrom(r2) != false) goto L_0x0034;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016a A[Catch:{ Exception -> 0x0111 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r18, java.lang.reflect.Type r19, java.lang.Object r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = 2
            r4 = 0
            com.alibaba.fastjson.parser.JSONLexer r6 = r0.lexer
            int r7 = r6.token
            r8 = 0
            r9 = 8
            if (r7 != r9) goto L_0x0015
            r6.nextToken()
            return r8
        L_0x0015:
            int r10 = r0.resolveStatus
            java.lang.String r11 = "syntax error"
            if (r10 != r3) goto L_0x001e
            r0.resolveStatus = r4
            goto L_0x0022
        L_0x001e:
            r10 = 12
            if (r7 != r10) goto L_0x01c1
        L_0x0022:
            java.lang.Class<java.lang.Throwable> r7 = java.lang.Throwable.class
            if (r2 == 0) goto L_0x0033
            boolean r10 = r2 instanceof java.lang.Class
            if (r10 == 0) goto L_0x0033
            java.lang.Class r2 = (java.lang.Class) r2
            boolean r10 = r7.isAssignableFrom(r2)
            if (r10 == 0) goto L_0x0033
            goto L_0x0034
        L_0x0033:
            r2 = r8
        L_0x0034:
            r10 = r8
            r12 = r10
            r13 = r12
            r14 = r13
        L_0x0038:
            com.alibaba.fastjson.parser.SymbolTable r15 = r0.symbolTable
            java.lang.String r15 = r6.scanSymbol(r15)
            r3 = 13
            r5 = 16
            if (r15 != 0) goto L_0x0052
            int r8 = r6.token
            if (r8 != r3) goto L_0x004d
            r6.nextToken(r5)
            goto L_0x00d3
        L_0x004d:
            if (r8 != r5) goto L_0x0052
        L_0x004f:
            r3 = 2
            r8 = 0
            goto L_0x0038
        L_0x0052:
            r8 = 58
            r6.nextTokenWithChar(r8)
            java.lang.String r8 = "@type"
            boolean r8 = r8.equals(r15)
            r3 = 4
            if (r8 == 0) goto L_0x007a
            int r2 = r6.token
            if (r2 != r3) goto L_0x0074
            java.lang.String r2 = r6.stringVal()
            com.alibaba.fastjson.parser.ParserConfig r3 = r0.config
            java.lang.ClassLoader r3 = r3.defaultClassLoader
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.loadClass(r2, r3, r4)
            r6.nextToken(r5)
            goto L_0x00ca
        L_0x0074:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r11)
            throw r0
        L_0x007a:
            java.lang.String r8 = "message"
            boolean r8 = r8.equals(r15)
            if (r8 == 0) goto L_0x0099
            int r8 = r6.token
            if (r8 != r9) goto L_0x0088
            r3 = 0
            goto L_0x008e
        L_0x0088:
            if (r8 != r3) goto L_0x0093
            java.lang.String r3 = r6.stringVal()
        L_0x008e:
            r6.nextToken()
            r13 = r3
            goto L_0x00ca
        L_0x0093:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r11)
            throw r0
        L_0x0099:
            java.lang.String r3 = "cause"
            boolean r8 = r3.equals(r15)
            if (r8 == 0) goto L_0x00aa
            r8 = 0
            java.lang.Object r3 = r1.deserialze(r0, r8, r3)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r12 = r3
            goto L_0x00ca
        L_0x00aa:
            java.lang.String r3 = "stackTrace"
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x00bc
            java.lang.Class<java.lang.StackTraceElement[]> r3 = java.lang.StackTraceElement[].class
            java.lang.Object r3 = r0.parseObject(r3)
            java.lang.StackTraceElement[] r3 = (java.lang.StackTraceElement[]) r3
            r14 = r3
            goto L_0x00ca
        L_0x00bc:
            if (r10 != 0) goto L_0x00c3
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
        L_0x00c3:
            java.lang.Object r3 = r18.parse()
            r10.put(r15, r3)
        L_0x00ca:
            int r3 = r6.token
            r8 = 13
            if (r3 != r8) goto L_0x01be
            r6.nextToken(r5)
        L_0x00d3:
            if (r2 != 0) goto L_0x00dd
            java.lang.Exception r3 = new java.lang.Exception
            r3.<init>(r13, r12)
            r8 = 0
            goto L_0x016f
        L_0x00dd:
            java.lang.reflect.Constructor[] r3 = r2.getConstructors()     // Catch:{ Exception -> 0x0111 }
            int r5 = r3.length     // Catch:{ Exception -> 0x0111 }
            r11 = r4
            r6 = 0
            r8 = 0
            r9 = 0
        L_0x00e6:
            if (r11 >= r5) goto L_0x0137
            r15 = r3[r11]     // Catch:{ Exception -> 0x0111 }
            java.lang.Class[] r4 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0111 }
            if (r4 != 0) goto L_0x00f8
            r19 = r3
            r16 = r5
            r9 = r15
        L_0x00f6:
            r3 = 1
            goto L_0x0130
        L_0x00f8:
            java.lang.Class[] r4 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0111 }
            r19 = r3
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r16 = r5
            r5 = 1
            if (r4 != r5) goto L_0x0114
            java.lang.Class[] r4 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            r5 = 0
            r4 = r4[r5]     // Catch:{ Exception -> 0x0111 }
            if (r4 != r3) goto L_0x0114
            r6 = r15
            goto L_0x00f6
        L_0x0111:
            r0 = move-exception
            goto L_0x01b6
        L_0x0114:
            java.lang.Class[] r4 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            int r4 = r4.length     // Catch:{ Exception -> 0x0111 }
            r5 = 2
            if (r4 != r5) goto L_0x00f6
            java.lang.Class[] r4 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            r5 = 0
            r4 = r4[r5]     // Catch:{ Exception -> 0x0111 }
            if (r4 != r3) goto L_0x00f6
            java.lang.Class[] r3 = r15.getParameterTypes()     // Catch:{ Exception -> 0x0111 }
            r4 = 1
            r3 = r3[r4]     // Catch:{ Exception -> 0x0111 }
            if (r3 != r7) goto L_0x00f6
            r8 = r15
            goto L_0x00f6
        L_0x0130:
            int r11 = r11 + r3
            r3 = r19
            r5 = r16
            r4 = 0
            goto L_0x00e6
        L_0x0137:
            if (r8 == 0) goto L_0x014c
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0111 }
            r4 = 0
            r3[r4] = r13     // Catch:{ Exception -> 0x0111 }
            r4 = 1
            r3[r4] = r12     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r3 = r8.newInstance(r3)     // Catch:{ Exception -> 0x0111 }
            r8 = r3
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ Exception -> 0x0111 }
        L_0x0149:
            r3 = r8
            r8 = 0
            goto L_0x0168
        L_0x014c:
            if (r6 == 0) goto L_0x015c
            r4 = 1
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0111 }
            r5 = 0
            r3[r5] = r13     // Catch:{ Exception -> 0x0111 }
            java.lang.Object r3 = r6.newInstance(r3)     // Catch:{ Exception -> 0x0111 }
            r8 = r3
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ Exception -> 0x0111 }
            goto L_0x0149
        L_0x015c:
            if (r9 == 0) goto L_0x0166
            r8 = 0
            java.lang.Object r3 = r9.newInstance(r8)     // Catch:{ Exception -> 0x0111 }
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ Exception -> 0x0111 }
            goto L_0x0168
        L_0x0166:
            r8 = 0
            r3 = r8
        L_0x0168:
            if (r3 != 0) goto L_0x016f
            java.lang.Exception r3 = new java.lang.Exception     // Catch:{ Exception -> 0x0111 }
            r3.<init>(r13, r12)     // Catch:{ Exception -> 0x0111 }
        L_0x016f:
            if (r14 == 0) goto L_0x0174
            r3.setStackTrace(r14)
        L_0x0174:
            if (r10 == 0) goto L_0x01b5
            if (r2 == 0) goto L_0x018b
            java.lang.Class<?> r4 = r1.clazz
            if (r2 != r4) goto L_0x017e
            r8 = r1
            goto L_0x018b
        L_0x017e:
            com.alibaba.fastjson.parser.ParserConfig r0 = r0.config
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r2)
            boolean r2 = r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer
            if (r2 == 0) goto L_0x018b
            r8 = r0
            com.alibaba.fastjson.parser.JavaBeanDeserializer r8 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r8
        L_0x018b:
            if (r8 == 0) goto L_0x01b5
            java.util.Set r0 = r10.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0195:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01b5
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r4 = r8.getFieldDeserializer(r4)
            if (r4 == 0) goto L_0x0195
            r4.setValue((java.lang.Object) r3, (java.lang.Object) r2)
            goto L_0x0195
        L_0x01b5:
            return r3
        L_0x01b6:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)
            throw r2
        L_0x01be:
            r5 = r4
            goto L_0x004f
        L_0x01c1:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.ThrowableDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object):java.lang.Object");
    }
}
