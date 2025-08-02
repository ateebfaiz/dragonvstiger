package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    public static class ResolveTask {
        /* access modifiers changed from: private */
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        /* access modifiers changed from: private */
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i10) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i10) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(this.lexer.token));
    }

    /* access modifiers changed from: protected */
    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    /* access modifiers changed from: protected */
    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    /* access modifiers changed from: protected */
    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    public void close() {
        try {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } catch (Throwable th) {
            this.lexer.close();
            throw th;
        }
    }

    public void config(Feature feature, boolean z10) {
        this.lexer.config(feature, z10);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    /* access modifiers changed from: protected */
    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i10);
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    ParseContext parseContext = resolveTask.ownerContext;
                    Object obj3 = null;
                    if (parseContext != null) {
                        obj2 = parseContext.object;
                    } else {
                        obj2 = null;
                    }
                    String access$000 = resolveTask.referenceValue;
                    if (access$000.startsWith("$")) {
                        for (int i11 = 0; i11 < this.contextArrayIndex; i11++) {
                            if (access$000.equals(this.contextArray[i11].toString())) {
                                obj3 = this.contextArray[i11].object;
                            }
                        }
                    } else {
                        obj3 = resolveTask.context.object;
                    }
                    fieldDeserializer.setValue(obj2, obj3);
                }
            }
        }
    }

    public Object parse() {
        return parse((Object) null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) (Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class<?>) (Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class<?>) (Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((Type) (ParameterizedType) type2, (Collection) arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0234, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x023b, code lost:
        if (r4.token != 13) goto L_0x02a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x023d, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r2 = r1.config.getDeserializer(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0248, code lost:
        if ((r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x024a, code lost:
        r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2;
        r3 = r2.createInstance(r1, (java.lang.reflect.Type) r7);
        r0 = r20.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025c, code lost:
        if (r0.hasNext() == false) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x025e, code lost:
        r4 = (java.util.Map.Entry) r0.next();
        r5 = r4.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x026a, code lost:
        if ((r5 instanceof java.lang.String) == false) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x026c, code lost:
        r5 = r2.getFieldDeserializer((java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0272, code lost:
        if (r5 == null) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0274, code lost:
        r5.setValue((java.lang.Object) r3, r4.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x027e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x027f, code lost:
        if (r3 != null) goto L_0x029c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0283, code lost:
        if (r7 != java.lang.Cloneable.class) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0285, code lost:
        r3 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0291, code lost:
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0293, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0298, code lost:
        r3 = r7.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x029c, code lost:
        if (r14 != false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x029e, code lost:
        r1.contex = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02a0, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02a9, code lost:
        r1.resolveStatus = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02ae, code lost:
        if (r1.contex == null) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02b2, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02b4, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02bb, code lost:
        if (r20.size() <= 0) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02bd, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r7, r1.config);
        parseObject((java.lang.Object) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x02c6, code lost:
        if (r14 != false) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x02c8, code lost:
        r1.contex = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x02ca, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        r0 = r1.config.getDeserializer(r7).deserialze(r1, r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x02d5, code lost:
        if (r14 != false) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02d7, code lost:
        r1.contex = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x02d9, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x02e9, code lost:
        r4.nextToken(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x02ee, code lost:
        if (r4.token != 4) goto L_0x0381;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x02f0, code lost:
        r0 = r4.stringVal();
        r4.nextToken(13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x02fd, code lost:
        if ("@".equals(r0) == false) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x02ff, code lost:
        r0 = r1.contex;
        r2 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0305, code lost:
        if ((r2 instanceof java.lang.Object[]) != false) goto L_0x031f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0309, code lost:
        if ((r2 instanceof java.util.Collection) == false) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x030c, code lost:
        r0 = r0.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x030e, code lost:
        if (r0 == null) goto L_0x0359;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0310, code lost:
        r6 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0319, code lost:
        if ("..".equals(r0) == false) goto L_0x032d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x031b, code lost:
        r2 = r15.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x031d, code lost:
        if (r2 == null) goto L_0x0321;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x031f, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0321, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r15, r0));
        r1.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0333, code lost:
        if ("$".equals(r0) == false) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0335, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0336, code lost:
        r3 = r2.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0338, code lost:
        if (r3 == null) goto L_0x033c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x033a, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x033c, code lost:
        r3 = r2.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x033e, code lost:
        if (r3 == null) goto L_0x0342;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0340, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0342, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r2, r0));
        r1.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x034e, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r15, r0));
        r1.resolveStatus = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0359, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x035c, code lost:
        if (r4.token != 13) goto L_0x0368;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x035e, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0363, code lost:
        if (r14 != false) goto L_0x0367;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0365, code lost:
        r1.contex = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0367, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0380, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r4.info());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x039d, code lost:
        throw new com.alibaba.fastjson.JSONException("illegal ref, " + com.alibaba.fastjson.parser.JSONToken.name(r4.token));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x0592, code lost:
        if (r3 != '}') goto L_0x0615;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x0594, code lost:
        r3 = r4.bp + 1;
        r4.bp = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x059c, code lost:
        if (r3 < r4.len) goto L_0x05a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x059e, code lost:
        r3 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x05a1, code lost:
        r3 = r4.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x05a7, code lost:
        r4.ch = r3;
        r4.sp = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x05ae, code lost:
        if (r3 != ',') goto L_0x05ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x05b0, code lost:
        r3 = r4.bp + 1;
        r4.bp = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x05b8, code lost:
        if (r3 < r4.len) goto L_0x05bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x05ba, code lost:
        r7 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x05bd, code lost:
        r7 = r4.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x05c3, code lost:
        r4.ch = r7;
        r4.token = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x05cc, code lost:
        if (r3 != '}') goto L_0x05e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x05ce, code lost:
        r3 = r4.bp + 1;
        r4.bp = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x05d6, code lost:
        if (r3 < r4.len) goto L_0x05db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x05d8, code lost:
        r7 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x05db, code lost:
        r7 = r4.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x05e1, code lost:
        r4.ch = r7;
        r4.token = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x05ea, code lost:
        if (r3 != ']') goto L_0x0606;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x05ec, code lost:
        r3 = r4.bp + 1;
        r4.bp = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x05f4, code lost:
        if (r3 < r4.len) goto L_0x05f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:0x05f6, code lost:
        r7 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x05f9, code lost:
        r7 = r4.text.charAt(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x05ff, code lost:
        r4.ch = r7;
        r4.token = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0606, code lost:
        r4.nextToken();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:381:0x0609, code lost:
        if (r14 != false) goto L_0x0610;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x060b, code lost:
        setContext(r1.contex, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0610, code lost:
        if (r14 != false) goto L_0x0614;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0612, code lost:
        r1.contex = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0614, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x062d, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r4.info());
     */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c7 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0202 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0215 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x04cf A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:312:0x04de A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x04e7 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x04eb A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x04f0 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0577 A[Catch:{ Exception -> 0x027c, NumberFormatException -> 0x0165, all -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x04f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0590 A[EDGE_INSN: B:423:0x0590->B:353:0x0590 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseObject(java.util.Map r20, java.lang.Object r21) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r21
            java.lang.String r3 = "parse number key error, "
            com.alibaba.fastjson.parser.JSONLexer r4 = r1.lexer
            int r5 = r4.token
            r6 = 0
            r7 = 8
            if (r5 != r7) goto L_0x0015
            r4.nextToken()
            return r6
        L_0x0015:
            r8 = 12
            r9 = 16
            if (r5 == r8) goto L_0x0045
            if (r5 != r9) goto L_0x001e
            goto L_0x0045
        L_0x001e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "syntax error, expect {, actual "
            r2.append(r3)
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r5)
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            java.lang.String r3 = r4.info()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0045:
            boolean r5 = r0 instanceof com.alibaba.fastjson.JSONObject
            if (r5 == 0) goto L_0x0052
            r5 = r0
            com.alibaba.fastjson.JSONObject r5 = (com.alibaba.fastjson.JSONObject) r5
            java.util.Map r5 = r5.getInnerMap()
            r12 = 1
            goto L_0x0054
        L_0x0052:
            r5 = r0
            r12 = 0
        L_0x0054:
            int r13 = r4.features
            com.alibaba.fastjson.parser.Feature r14 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat
            int r14 = r14.mask
            r13 = r13 & r14
            if (r13 == 0) goto L_0x005f
            r13 = 1
            goto L_0x0060
        L_0x005f:
            r13 = 0
        L_0x0060:
            boolean r14 = r4.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r15 = r1.contex
            r16 = 0
        L_0x0066:
            char r6 = r4.ch     // Catch:{ all -> 0x0076 }
            r7 = 125(0x7d, float:1.75E-43)
            r8 = 34
            if (r6 == r8) goto L_0x0079
            if (r6 == r7) goto L_0x0079
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
            char r6 = r4.ch     // Catch:{ all -> 0x0076 }
            goto L_0x0079
        L_0x0076:
            r0 = move-exception
            goto L_0x06ae
        L_0x0079:
            r9 = 44
            if (r6 != r9) goto L_0x0086
            r4.next()     // Catch:{ all -> 0x0076 }
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
            char r6 = r4.ch     // Catch:{ all -> 0x0076 }
            goto L_0x0079
        L_0x0086:
            java.lang.String r9 = "expect ':' at "
            r10 = 58
            java.lang.String r11 = "syntax error, "
            r7 = 26
            if (r6 != r8) goto L_0x00c4
            com.alibaba.fastjson.parser.SymbolTable r6 = r1.symbolTable     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r4.scanSymbol(r6, r8)     // Catch:{ all -> 0x0076 }
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 == r10) goto L_0x00c1
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 != r10) goto L_0x00a2
            goto L_0x00c1
        L_0x00a2:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r9)     // Catch:{ all -> 0x0076 }
            int r3 = r4.pos     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = ", name "
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            r2.append(r6)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x00c1:
            r8 = 0
            goto L_0x01c3
        L_0x00c4:
            r8 = 125(0x7d, float:1.75E-43)
            if (r6 != r8) goto L_0x00e8
            int r2 = r4.bp     // Catch:{ all -> 0x0076 }
            r3 = 1
            int r2 = r2 + r3
            r4.bp = r2     // Catch:{ all -> 0x0076 }
            int r3 = r4.len     // Catch:{ all -> 0x0076 }
            if (r2 < r3) goto L_0x00d3
            goto L_0x00d9
        L_0x00d3:
            java.lang.String r3 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r3.charAt(r2)     // Catch:{ all -> 0x0076 }
        L_0x00d9:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r2 = 0
            r4.sp = r2     // Catch:{ all -> 0x0076 }
            r2 = 16
            r4.nextToken(r2)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x00e7
            r1.contex = r15
        L_0x00e7:
            return r0
        L_0x00e8:
            r8 = 39
            if (r6 != r8) goto L_0x0115
            com.alibaba.fastjson.parser.SymbolTable r6 = r1.symbolTable     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r4.scanSymbol(r6, r8)     // Catch:{ all -> 0x0076 }
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 == r10) goto L_0x00f9
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
        L_0x00f9:
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 != r10) goto L_0x00fe
            goto L_0x00c1
        L_0x00fe:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r9)     // Catch:{ all -> 0x0076 }
            int r3 = r4.pos     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0115:
            if (r6 == r7) goto L_0x0695
            r8 = 44
            if (r6 == r8) goto L_0x067c
            r8 = 48
            if (r6 < r8) goto L_0x0123
            r8 = 57
            if (r6 <= r8) goto L_0x0126
        L_0x0123:
            r8 = 45
            goto L_0x0128
        L_0x0126:
            r6 = 0
            goto L_0x012b
        L_0x0128:
            if (r6 != r8) goto L_0x017e
            goto L_0x0126
        L_0x012b:
            r4.sp = r6     // Catch:{ all -> 0x0076 }
            r4.scanNumber()     // Catch:{ all -> 0x0076 }
            int r6 = r4.token     // Catch:{ NumberFormatException -> 0x0165 }
            r8 = 2
            if (r6 != r8) goto L_0x013a
            java.lang.Number r6 = r4.integerValue()     // Catch:{ NumberFormatException -> 0x0165 }
            goto L_0x0140
        L_0x013a:
            r6 = 1
            java.lang.Number r8 = r4.decimalValue(r6)     // Catch:{ NumberFormatException -> 0x0165 }
            r6 = r8
        L_0x0140:
            if (r12 == 0) goto L_0x0146
            java.lang.String r6 = r6.toString()     // Catch:{ NumberFormatException -> 0x0165 }
        L_0x0146:
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 != r10) goto L_0x014c
            goto L_0x00c1
        L_0x014c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0165:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x017e:
            r8 = 123(0x7b, float:1.72E-43)
            if (r6 == r8) goto L_0x01bb
            r8 = 91
            if (r6 != r8) goto L_0x0187
            goto L_0x01bb
        L_0x0187:
            com.alibaba.fastjson.parser.SymbolTable r6 = r1.symbolTable     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r4.scanSymbolUnQuoted(r6)     // Catch:{ all -> 0x0076 }
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            if (r8 != r10) goto L_0x019c
            if (r12 == 0) goto L_0x00c1
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0076 }
            goto L_0x00c1
        L_0x019c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r9)     // Catch:{ all -> 0x0076 }
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            r2.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x01bb:
            r4.nextToken()     // Catch:{ all -> 0x0076 }
            java.lang.Object r6 = r19.parse()     // Catch:{ all -> 0x0076 }
            r8 = 1
        L_0x01c3:
            r9 = 13
            if (r8 != 0) goto L_0x0202
            int r8 = r4.bp     // Catch:{ all -> 0x0076 }
            r10 = 1
            int r8 = r8 + r10
            r4.bp = r8     // Catch:{ all -> 0x0076 }
            int r10 = r4.len     // Catch:{ all -> 0x0076 }
            if (r8 < r10) goto L_0x01d3
            r8 = r7
            goto L_0x01d9
        L_0x01d3:
            java.lang.String r10 = r4.text     // Catch:{ all -> 0x0076 }
            char r8 = r10.charAt(r8)     // Catch:{ all -> 0x0076 }
        L_0x01d9:
            r4.ch = r8     // Catch:{ all -> 0x0076 }
        L_0x01db:
            r10 = 32
            if (r8 > r10) goto L_0x01fe
            r10 = 32
            if (r8 == r10) goto L_0x01f6
            r10 = 10
            if (r8 == r10) goto L_0x01f6
            if (r8 == r9) goto L_0x01f6
            r10 = 9
            if (r8 == r10) goto L_0x01f6
            r10 = 12
            if (r8 == r10) goto L_0x01f6
            r10 = 8
            if (r8 != r10) goto L_0x0200
            goto L_0x01f8
        L_0x01f6:
            r10 = 8
        L_0x01f8:
            r4.next()     // Catch:{ all -> 0x0076 }
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            goto L_0x01db
        L_0x01fe:
            r10 = 8
        L_0x0200:
            r7 = 0
            goto L_0x0207
        L_0x0202:
            r10 = 8
            char r8 = r4.ch     // Catch:{ all -> 0x0076 }
            goto L_0x0200
        L_0x0207:
            r4.sp = r7     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "@type"
            if (r6 != r7) goto L_0x02da
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0076 }
            boolean r7 = r4.isEnabled(r7)     // Catch:{ all -> 0x0076 }
            if (r7 != 0) goto L_0x02da
            com.alibaba.fastjson.parser.SymbolTable r6 = r1.symbolTable     // Catch:{ all -> 0x0076 }
            r7 = 34
            java.lang.String r6 = r4.scanSymbol(r6, r7)     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.ParserConfig r7 = r1.config     // Catch:{ all -> 0x0076 }
            int r8 = r4.features     // Catch:{ all -> 0x0076 }
            r11 = 0
            java.lang.Class r7 = r7.checkAutoType(r6, r11, r8)     // Catch:{ all -> 0x0076 }
            if (r7 != 0) goto L_0x0234
            java.lang.String r7 = "@type"
            r0.put(r7, r6)     // Catch:{ all -> 0x0076 }
            r7 = r10
            r8 = 12
            r9 = 16
            goto L_0x0066
        L_0x0234:
            r3 = 16
            r4.nextToken(r3)     // Catch:{ all -> 0x0076 }
            int r5 = r4.token     // Catch:{ all -> 0x0076 }
            if (r5 != r9) goto L_0x02a9
            r4.nextToken(r3)     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ Exception -> 0x027c }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r2 = r2.getDeserializer(r7)     // Catch:{ Exception -> 0x027c }
            boolean r3 = r2 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer     // Catch:{ Exception -> 0x027c }
            if (r3 == 0) goto L_0x027e
            com.alibaba.fastjson.parser.JavaBeanDeserializer r2 = (com.alibaba.fastjson.parser.JavaBeanDeserializer) r2     // Catch:{ Exception -> 0x027c }
            java.lang.Object r3 = r2.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r1, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x027c }
            java.util.Set r0 = r20.entrySet()     // Catch:{ Exception -> 0x027c }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x027c }
        L_0x0258:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x027c }
            if (r4 == 0) goto L_0x027f
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x027c }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x027c }
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x027c }
            boolean r8 = r5 instanceof java.lang.String     // Catch:{ Exception -> 0x027c }
            if (r8 == 0) goto L_0x0258
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x027c }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r5 = r2.getFieldDeserializer(r5)     // Catch:{ Exception -> 0x027c }
            if (r5 == 0) goto L_0x0258
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x027c }
            r5.setValue((java.lang.Object) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x027c }
            goto L_0x0258
        L_0x027c:
            r0 = move-exception
            goto L_0x02a1
        L_0x027e:
            r3 = r11
        L_0x027f:
            if (r3 != 0) goto L_0x029c
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r7 != r0) goto L_0x028b
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x027c }
            r3.<init>()     // Catch:{ Exception -> 0x027c }
            goto L_0x029c
        L_0x028b:
            java.lang.String r0 = "java.util.Collections$EmptyMap"
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x027c }
            if (r0 == 0) goto L_0x0298
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x027c }
            goto L_0x029c
        L_0x0298:
            java.lang.Object r3 = r7.newInstance()     // Catch:{ Exception -> 0x027c }
        L_0x029c:
            if (r14 != 0) goto L_0x02a0
            r1.contex = r15
        L_0x02a0:
            return r3
        L_0x02a1:
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0076 }
            throw r2     // Catch:{ all -> 0x0076 }
        L_0x02a9:
            r3 = 2
            r1.resolveStatus = r3     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.ParseContext r3 = r1.contex     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x02b7
            boolean r3 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x02b7
            r19.popContext()     // Catch:{ all -> 0x0076 }
        L_0x02b7:
            int r3 = r20.size()     // Catch:{ all -> 0x0076 }
            if (r3 <= 0) goto L_0x02cb
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r7, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ all -> 0x0076 }
            r1.parseObject((java.lang.Object) r0)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x02ca
            r1.contex = r15
        L_0x02ca:
            return r0
        L_0x02cb:
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer(r7)     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = r0.deserialze(r1, r7, r2)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x02d9
            r1.contex = r15
        L_0x02d9:
            return r0
        L_0x02da:
            java.lang.String r7 = "$ref"
            r10 = 4
            if (r6 != r7) goto L_0x039e
            if (r15 == 0) goto L_0x039e
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0076 }
            boolean r7 = r4.isEnabled(r7)     // Catch:{ all -> 0x0076 }
            if (r7 != 0) goto L_0x039e
            r4.nextToken(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r4.token     // Catch:{ all -> 0x0076 }
            if (r0 != r10) goto L_0x0381
            java.lang.String r0 = r4.stringVal()     // Catch:{ all -> 0x0076 }
            r4.nextToken(r9)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "@"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0313
            com.alibaba.fastjson.parser.ParseContext r0 = r1.contex     // Catch:{ all -> 0x0076 }
            java.lang.Object r2 = r0.object     // Catch:{ all -> 0x0076 }
            boolean r3 = r2 instanceof java.lang.Object[]     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x031f
            boolean r3 = r2 instanceof java.util.Collection     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x030c
            goto L_0x031f
        L_0x030c:
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0359
            java.lang.Object r6 = r0.object     // Catch:{ all -> 0x0076 }
            goto L_0x035a
        L_0x0313:
            java.lang.String r2 = ".."
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x032d
            java.lang.Object r2 = r15.object     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0321
        L_0x031f:
            r6 = r2
            goto L_0x035a
        L_0x0321:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0076 }
            r2.<init>(r15, r0)     // Catch:{ all -> 0x0076 }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x0076 }
            r0 = 1
            r1.resolveStatus = r0     // Catch:{ all -> 0x0076 }
            goto L_0x0359
        L_0x032d:
            java.lang.String r2 = "$"
            boolean r2 = r2.equals(r0)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x034e
            r2 = r15
        L_0x0336:
            com.alibaba.fastjson.parser.ParseContext r3 = r2.parent     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x033c
            r2 = r3
            goto L_0x0336
        L_0x033c:
            java.lang.Object r3 = r2.object     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0342
            r6 = r3
            goto L_0x035a
        L_0x0342:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r3 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0076 }
            r3.<init>(r2, r0)     // Catch:{ all -> 0x0076 }
            r1.addResolveTask(r3)     // Catch:{ all -> 0x0076 }
            r0 = 1
            r1.resolveStatus = r0     // Catch:{ all -> 0x0076 }
            goto L_0x0359
        L_0x034e:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x0076 }
            r2.<init>(r15, r0)     // Catch:{ all -> 0x0076 }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x0076 }
            r0 = 1
            r1.resolveStatus = r0     // Catch:{ all -> 0x0076 }
        L_0x0359:
            r6 = 0
        L_0x035a:
            int r0 = r4.token     // Catch:{ all -> 0x0076 }
            if (r0 != r9) goto L_0x0368
            r0 = 16
            r4.nextToken(r0)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x0367
            r1.contex = r15
        L_0x0367:
            return r6
        L_0x0368:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0381:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            int r3 = r4.token     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x039e:
            if (r14 != 0) goto L_0x03b0
            if (r16 != 0) goto L_0x03b0
            com.alibaba.fastjson.parser.ParseContext r7 = r1.contex     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.ParseContext r7 = r1.setContext(r7, r0, r2)     // Catch:{ all -> 0x0076 }
            if (r15 != 0) goto L_0x03ab
            r15 = r7
        L_0x03ab:
            r7 = 34
            r16 = 1
            goto L_0x03b2
        L_0x03b0:
            r7 = 34
        L_0x03b2:
            if (r8 != r7) goto L_0x03dc
            java.lang.String r7 = r4.scanStringValue(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x03cf
            com.alibaba.fastjson.parser.JSONLexer r8 = new com.alibaba.fastjson.parser.JSONLexer     // Catch:{ all -> 0x0076 }
            r8.<init>(r7)     // Catch:{ all -> 0x0076 }
            r10 = 1
            boolean r17 = r8.scanISO8601DateIfMatch(r10)     // Catch:{ all -> 0x0076 }
            if (r17 == 0) goto L_0x03cc
            java.util.Calendar r7 = r8.calendar     // Catch:{ all -> 0x0076 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0076 }
        L_0x03cc:
            r8.close()     // Catch:{ all -> 0x0076 }
        L_0x03cf:
            if (r5 == 0) goto L_0x03d5
            r5.put(r6, r7)     // Catch:{ all -> 0x0076 }
            goto L_0x03d8
        L_0x03d5:
            r0.put(r6, r7)     // Catch:{ all -> 0x0076 }
        L_0x03d8:
            r18 = r3
            goto L_0x0564
        L_0x03dc:
            r7 = 48
            if (r8 < r7) goto L_0x03e4
            r7 = 57
            if (r8 <= r7) goto L_0x03e8
        L_0x03e4:
            r7 = 45
            if (r8 != r7) goto L_0x03f0
        L_0x03e8:
            java.lang.Number r7 = r4.scanNumberValue()     // Catch:{ all -> 0x0076 }
            r5.put(r6, r7)     // Catch:{ all -> 0x0076 }
            goto L_0x03d8
        L_0x03f0:
            r7 = 91
            if (r8 != r7) goto L_0x0463
            r7 = 14
            r4.token = r7     // Catch:{ all -> 0x0076 }
            int r7 = r4.bp     // Catch:{ all -> 0x0076 }
            r8 = 1
            int r7 = r7 + r8
            r4.bp = r7     // Catch:{ all -> 0x0076 }
            int r8 = r4.len     // Catch:{ all -> 0x0076 }
            if (r7 < r8) goto L_0x0405
            r7 = 26
            goto L_0x040b
        L_0x0405:
            java.lang.String r8 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r8.charAt(r7)     // Catch:{ all -> 0x0076 }
        L_0x040b:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0076 }
            r7.<init>()     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x041d
            java.lang.Class r8 = r21.getClass()     // Catch:{ all -> 0x0076 }
            java.lang.Class<java.lang.Integer> r10 = java.lang.Integer.class
            if (r8 != r10) goto L_0x041d
            goto L_0x0420
        L_0x041d:
            r1.setContext(r15)     // Catch:{ all -> 0x0076 }
        L_0x0420:
            r1.parseArray((java.util.Collection) r7, (java.lang.Object) r6)     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0076 }
            r8.<init>((java.util.List<java.lang.Object>) r7)     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x042e
            r5.put(r6, r8)     // Catch:{ all -> 0x0076 }
            goto L_0x0431
        L_0x042e:
            r0.put(r6, r8)     // Catch:{ all -> 0x0076 }
        L_0x0431:
            int r6 = r4.token     // Catch:{ all -> 0x0076 }
            if (r6 != r9) goto L_0x043f
            r7 = 16
            r4.nextToken(r7)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x043e
            r1.contex = r15
        L_0x043e:
            return r0
        L_0x043f:
            r7 = 16
            if (r6 != r7) goto L_0x044a
            r18 = r3
            r6 = r7
        L_0x0446:
            r7 = 0
            r8 = 1
            goto L_0x065a
        L_0x044a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0463:
            r7 = 123(0x7b, float:1.72E-43)
            if (r8 != r7) goto L_0x0526
            int r7 = r4.bp     // Catch:{ all -> 0x0076 }
            r8 = 1
            int r7 = r7 + r8
            r4.bp = r7     // Catch:{ all -> 0x0076 }
            int r8 = r4.len     // Catch:{ all -> 0x0076 }
            if (r7 < r8) goto L_0x0474
            r7 = 26
            goto L_0x047a
        L_0x0474:
            java.lang.String r8 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r8.charAt(r7)     // Catch:{ all -> 0x0076 }
        L_0x047a:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r7 = 12
            r4.token = r7     // Catch:{ all -> 0x0076 }
            boolean r8 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x0076 }
            int r10 = r4.features     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0076 }
            int r7 = r7.mask     // Catch:{ all -> 0x0076 }
            r7 = r7 & r10
            if (r7 == 0) goto L_0x0496
            com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0076 }
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0076 }
            r10.<init>()     // Catch:{ all -> 0x0076 }
            r7.<init>((java.util.Map<java.lang.String, java.lang.Object>) r10)     // Catch:{ all -> 0x0076 }
            goto L_0x049b
        L_0x0496:
            com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0076 }
            r7.<init>()     // Catch:{ all -> 0x0076 }
        L_0x049b:
            if (r14 != 0) goto L_0x04a4
            if (r8 != 0) goto L_0x04a4
            com.alibaba.fastjson.parser.ParseContext r10 = r1.setContext(r15, r7, r6)     // Catch:{ all -> 0x0076 }
            goto L_0x04a5
        L_0x04a4:
            r10 = 0
        L_0x04a5:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r9 = r1.fieldTypeResolver     // Catch:{ all -> 0x0076 }
            if (r9 == 0) goto L_0x04c9
            if (r6 == 0) goto L_0x04b2
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x0076 }
            r18 = r3
            goto L_0x04b5
        L_0x04b2:
            r18 = r3
            r9 = 0
        L_0x04b5:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r3 = r1.fieldTypeResolver     // Catch:{ all -> 0x0076 }
            java.lang.reflect.Type r3 = r3.resolve(r0, r9)     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x04cb
            com.alibaba.fastjson.parser.ParserConfig r9 = r1.config     // Catch:{ all -> 0x0076 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r9 = r9.getDeserializer(r3)     // Catch:{ all -> 0x0076 }
            java.lang.Object r3 = r9.deserialze(r1, r3, r6)     // Catch:{ all -> 0x0076 }
            r9 = 1
            goto L_0x04cd
        L_0x04c9:
            r18 = r3
        L_0x04cb:
            r3 = 0
            r9 = 0
        L_0x04cd:
            if (r9 != 0) goto L_0x04d3
            java.lang.Object r3 = r1.parseObject((java.util.Map) r7, (java.lang.Object) r6)     // Catch:{ all -> 0x0076 }
        L_0x04d3:
            if (r10 == 0) goto L_0x04d9
            if (r7 == r3) goto L_0x04d9
            r10.object = r0     // Catch:{ all -> 0x0076 }
        L_0x04d9:
            int r7 = r1.resolveStatus     // Catch:{ all -> 0x0076 }
            r9 = 1
            if (r7 != r9) goto L_0x04e5
            java.lang.String r7 = r6.toString()     // Catch:{ all -> 0x0076 }
            r1.checkMapResolve(r0, r7)     // Catch:{ all -> 0x0076 }
        L_0x04e5:
            if (r5 == 0) goto L_0x04eb
            r5.put(r6, r3)     // Catch:{ all -> 0x0076 }
            goto L_0x04ee
        L_0x04eb:
            r0.put(r6, r3)     // Catch:{ all -> 0x0076 }
        L_0x04ee:
            if (r8 == 0) goto L_0x04f3
            r1.setContext(r15, r3, r6)     // Catch:{ all -> 0x0076 }
        L_0x04f3:
            int r3 = r4.token     // Catch:{ all -> 0x0076 }
            r6 = 13
            if (r3 != r6) goto L_0x0507
            r6 = 16
            r4.nextToken(r6)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x0502
            r1.contex = r15     // Catch:{ all -> 0x0076 }
        L_0x0502:
            if (r14 != 0) goto L_0x0506
            r1.contex = r15
        L_0x0506:
            return r0
        L_0x0507:
            r6 = 16
            if (r3 != r6) goto L_0x050d
            goto L_0x0446
        L_0x050d:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0526:
            r18 = r3
            r3 = 116(0x74, float:1.63E-43)
            if (r8 != r3) goto L_0x0547
            java.lang.String r3 = r4.text     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "true"
            int r8 = r4.bp     // Catch:{ all -> 0x0076 }
            boolean r3 = r3.startsWith(r7, r8)     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0564
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            int r3 = r3 + 3
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            r4.next()     // Catch:{ all -> 0x0076 }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0076 }
            r0.put(r6, r3)     // Catch:{ all -> 0x0076 }
            goto L_0x0564
        L_0x0547:
            r3 = 102(0x66, float:1.43E-43)
            if (r8 != r3) goto L_0x062e
            java.lang.String r3 = r4.text     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "false"
            int r8 = r4.bp     // Catch:{ all -> 0x0076 }
            boolean r3 = r3.startsWith(r7, r8)     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x0564
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            int r3 = r3 + r10
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            r4.next()     // Catch:{ all -> 0x0076 }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0076 }
            r0.put(r6, r3)     // Catch:{ all -> 0x0076 }
        L_0x0564:
            char r3 = r4.ch     // Catch:{ all -> 0x0076 }
            r6 = 44
            if (r3 == r6) goto L_0x0573
            r6 = 125(0x7d, float:1.75E-43)
            if (r3 == r6) goto L_0x0573
            r4.skipWhitespace()     // Catch:{ all -> 0x0076 }
            char r3 = r4.ch     // Catch:{ all -> 0x0076 }
        L_0x0573:
            r6 = 44
            if (r3 != r6) goto L_0x0590
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r6 = 1
            int r3 = r3 + r6
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            int r6 = r4.len     // Catch:{ all -> 0x0076 }
            if (r3 < r6) goto L_0x0584
            r7 = 26
            goto L_0x058a
        L_0x0584:
            java.lang.String r6 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r6.charAt(r3)     // Catch:{ all -> 0x0076 }
        L_0x058a:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r6 = 16
            goto L_0x0446
        L_0x0590:
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x0615
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r5 = 1
            int r3 = r3 + r5
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            int r5 = r4.len     // Catch:{ all -> 0x0076 }
            if (r3 < r5) goto L_0x05a1
            r3 = 26
            goto L_0x05a7
        L_0x05a1:
            java.lang.String r5 = r4.text     // Catch:{ all -> 0x0076 }
            char r3 = r5.charAt(r3)     // Catch:{ all -> 0x0076 }
        L_0x05a7:
            r4.ch = r3     // Catch:{ all -> 0x0076 }
            r7 = 0
            r4.sp = r7     // Catch:{ all -> 0x0076 }
            r5 = 44
            if (r3 != r5) goto L_0x05ca
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r5 = 1
            int r3 = r3 + r5
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            int r5 = r4.len     // Catch:{ all -> 0x0076 }
            if (r3 < r5) goto L_0x05bd
            r7 = 26
            goto L_0x05c3
        L_0x05bd:
            java.lang.String r5 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r5.charAt(r3)     // Catch:{ all -> 0x0076 }
        L_0x05c3:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r3 = 16
            r4.token = r3     // Catch:{ all -> 0x0076 }
            goto L_0x0609
        L_0x05ca:
            r5 = 125(0x7d, float:1.75E-43)
            if (r3 != r5) goto L_0x05e8
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r5 = 1
            int r3 = r3 + r5
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            int r5 = r4.len     // Catch:{ all -> 0x0076 }
            if (r3 < r5) goto L_0x05db
            r7 = 26
            goto L_0x05e1
        L_0x05db:
            java.lang.String r5 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r5.charAt(r3)     // Catch:{ all -> 0x0076 }
        L_0x05e1:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r3 = 13
            r4.token = r3     // Catch:{ all -> 0x0076 }
            goto L_0x0609
        L_0x05e8:
            r5 = 93
            if (r3 != r5) goto L_0x0606
            int r3 = r4.bp     // Catch:{ all -> 0x0076 }
            r8 = 1
            int r3 = r3 + r8
            r4.bp = r3     // Catch:{ all -> 0x0076 }
            int r5 = r4.len     // Catch:{ all -> 0x0076 }
            if (r3 < r5) goto L_0x05f9
            r7 = 26
            goto L_0x05ff
        L_0x05f9:
            java.lang.String r5 = r4.text     // Catch:{ all -> 0x0076 }
            char r7 = r5.charAt(r3)     // Catch:{ all -> 0x0076 }
        L_0x05ff:
            r4.ch = r7     // Catch:{ all -> 0x0076 }
            r3 = 15
            r4.token = r3     // Catch:{ all -> 0x0076 }
            goto L_0x0609
        L_0x0606:
            r4.nextToken()     // Catch:{ all -> 0x0076 }
        L_0x0609:
            if (r14 != 0) goto L_0x0610
            com.alibaba.fastjson.parser.ParseContext r3 = r1.contex     // Catch:{ all -> 0x0076 }
            r1.setContext(r3, r0, r2)     // Catch:{ all -> 0x0076 }
        L_0x0610:
            if (r14 != 0) goto L_0x0614
            r1.contex = r15
        L_0x0614:
            return r0
        L_0x0615:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x062e:
            r7 = 0
            r8 = 1
            r4.nextToken()     // Catch:{ all -> 0x0076 }
            java.lang.Object r3 = r19.parse()     // Catch:{ all -> 0x0076 }
            java.lang.Class r9 = r20.getClass()     // Catch:{ all -> 0x0076 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r10 = com.alibaba.fastjson.JSONObject.class
            if (r9 != r10) goto L_0x0643
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0076 }
        L_0x0643:
            r0.put(r6, r3)     // Catch:{ all -> 0x0076 }
            int r3 = r4.token     // Catch:{ all -> 0x0076 }
            r6 = 13
            if (r3 != r6) goto L_0x0656
            r6 = 16
            r4.nextToken(r6)     // Catch:{ all -> 0x0076 }
            if (r14 != 0) goto L_0x0655
            r1.contex = r15
        L_0x0655:
            return r0
        L_0x0656:
            r6 = 16
            if (r3 != r6) goto L_0x0663
        L_0x065a:
            r9 = r6
            r3 = r18
            r7 = 8
            r8 = 12
            goto L_0x0066
        L_0x0663:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x067c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x0695:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            r2.append(r11)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x0076 }
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            r0.<init>(r2)     // Catch:{ all -> 0x0076 }
            throw r0     // Catch:{ all -> 0x0076 }
        L_0x06ae:
            if (r14 != 0) goto L_0x06b2
            r1.contex = r15
        L_0x06b2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public String parseString() {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            JSONLexer jSONLexer2 = this.lexer;
            char c10 = jSONLexer2.ch;
            char c11 = JSONLexer.EOI;
            if (c10 == ',') {
                int i11 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i11;
                if (i11 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i11);
                }
                jSONLexer2.ch = c11;
                this.lexer.token = 16;
            } else if (c10 == ']') {
                int i12 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i12;
                if (i12 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i12);
                }
                jSONLexer2.ch = c11;
                this.lexer.token = 15;
            } else if (c10 == '}') {
                int i13 = jSONLexer2.bp + 1;
                jSONLexer2.bp = i13;
                if (i13 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i13);
                }
                jSONLexer2.ch = c11;
                this.lexer.token = 13;
            } else {
                jSONLexer2.nextToken();
            }
            return stringVal;
        } else if (i10 == 2) {
            String numberString = jSONLexer.numberString();
            this.lexer.nextToken(16);
            return numberString;
        } else {
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i10 = this.contextArrayIndex;
        parseContextArr[i10 - 1] = null;
        this.contextArrayIndex = i10 - 1;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.disableCircularReferenceDetect) {
            this.contex = parseContext;
        }
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 != 2) {
            boolean z10 = true;
            if (i10 == 3) {
                if ((jSONLexer.features & Feature.UseBigDecimal.mask) == 0) {
                    z10 = false;
                }
                Number decimalValue = jSONLexer.decimalValue(z10);
                this.lexer.nextToken();
                return decimalValue;
            } else if (i10 == 4) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken(16);
                if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                    JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                    try {
                        if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                            return jSONLexer2.calendar.getTime();
                        }
                        jSONLexer2.close();
                    } finally {
                        jSONLexer2.close();
                    }
                }
                return stringVal;
            } else if (i10 == 12) {
                return parseObject((Map) (jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject((Map<String, Object>) new LinkedHashMap()) : new JSONObject(), obj);
            } else if (i10 != 14) {
                switch (i10) {
                    case 6:
                        jSONLexer.nextToken(16);
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken(16);
                        return Boolean.FALSE;
                    case 8:
                        break;
                    case 9:
                        jSONLexer.nextToken(18);
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 18) {
                            jSONLexer3.nextToken(10);
                            accept(10);
                            long longValue = this.lexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error, " + this.lexer.info());
                    default:
                        switch (i10) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("syntax error, " + this.lexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray((Collection) hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray((Collection) treeSet, obj);
                                return treeSet;
                            case 23:
                                break;
                            default:
                                throw new JSONException("syntax error, " + this.lexer.info());
                        }
                }
                jSONLexer.nextToken();
                return null;
            } else {
                JSONArray jSONArray = new JSONArray();
                parseArray((Collection) jSONArray, obj);
                return jSONArray;
            }
        } else {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i10) {
        this(new JSONLexer(str, i10), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    /* access modifiers changed from: protected */
    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i10 = this.contextArrayIndex;
        this.contextArrayIndex = i10 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i10 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i10] = parseContext2;
        return parseContext2;
    }

    public DefaultJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        this(new JSONLexer(cArr, i10, i11), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, (Object) null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    /* JADX INFO: finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        Object obj2;
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 21 || i10 == 22) {
            jSONLexer.nextToken();
        }
        JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token == 14) {
            Class<String> cls = String.class;
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                jSONLexer2.nextToken(2);
            } else if (cls == type) {
                objectDeserializer = StringCodec.instance;
                jSONLexer2.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(12);
            }
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i11 = 0;
            while (true) {
                try {
                    JSONLexer jSONLexer3 = this.lexer;
                    int i12 = jSONLexer3.token;
                    if (i12 == 16) {
                        jSONLexer3.nextToken();
                    } else if (i12 == 15) {
                        this.contex = parseContext;
                        jSONLexer3.nextToken(16);
                        return;
                    } else {
                        Object obj3 = null;
                        if (Integer.TYPE == type) {
                            collection.add(IntegerCodec.instance.deserialze(this, (Type) null, (Object) null));
                        } else if (cls == type) {
                            if (i12 == 4) {
                                obj2 = jSONLexer3.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    obj3 = parse.toString();
                                }
                                obj2 = obj3;
                            }
                            collection.add(obj2);
                        } else {
                            if (i12 == 8) {
                                jSONLexer3.nextToken();
                            } else {
                                obj3 = objectDeserializer.deserialze(this, type, Integer.valueOf(i11));
                            }
                            collection.add(obj3);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                        }
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 16) {
                            jSONLexer4.nextToken();
                        }
                        i11++;
                    }
                } catch (Throwable th) {
                    this.contex = parseContext;
                    throw th;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c10 = jSONLexer.ch;
        char c11 = JSONLexer.EOI;
        if (c10 == '{') {
            int i10 = jSONLexer.bp + 1;
            jSONLexer.bp = i10;
            jSONLexer.ch = i10 < jSONLexer.len ? jSONLexer.text.charAt(i10) : c11;
            jSONLexer.token = 12;
        } else if (c10 == '[') {
            int i11 = jSONLexer.bp + 1;
            jSONLexer.bp = i11;
            jSONLexer.ch = i11 < jSONLexer.len ? jSONLexer.text.charAt(i11) : c11;
            jSONLexer.token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z10;
        Class<?> cls;
        int i10;
        Type[] typeArr2 = typeArr;
        JSONLexer jSONLexer = this.lexer;
        int i11 = jSONLexer.token;
        int i12 = 8;
        if (i11 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i11 == 14) {
            Object[] objArr = new Object[typeArr2.length];
            if (typeArr2.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error, " + this.lexer.info());
            }
            jSONLexer.nextToken(2);
            int i13 = 0;
            while (i13 < typeArr2.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i14 = jSONLexer3.token;
                if (i14 == i12) {
                    jSONLexer3.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr2[i13];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (i14 == 2) {
                            obj = Integer.valueOf(jSONLexer3.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i13 != typeArr2.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z10 = false;
                        } else {
                            Class cls2 = (Class) type;
                            z10 = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z10 || this.lexer.token == 14) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, (Object) null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, (Object) null));
                                    JSONLexer jSONLexer4 = this.lexer;
                                    i10 = jSONLexer4.token;
                                    if (i10 != 16) {
                                        break;
                                    }
                                    jSONLexer4.nextToken(12);
                                }
                                if (i10 != 15) {
                                    throw new JSONException("syntax error, " + this.lexer.info());
                                }
                            }
                            obj = TypeUtils.cast((Object) arrayList, type, this.config);
                        }
                    } else if (i14 == 4) {
                        obj = jSONLexer3.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i13] = obj;
                JSONLexer jSONLexer5 = this.lexer;
                int i15 = jSONLexer5.token;
                if (i15 == 15) {
                    break;
                } else if (i15 == 16) {
                    if (i13 == typeArr2.length - 1) {
                        jSONLexer5.nextToken(15);
                    } else {
                        jSONLexer5.nextToken(2);
                    }
                    i13++;
                    i12 = 8;
                } else {
                    throw new JSONException("syntax error, " + this.lexer.info());
                }
            }
            JSONLexer jSONLexer6 = this.lexer;
            if (jSONLexer6.token == 15) {
                jSONLexer6.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error, " + this.lexer.info());
        } else {
            throw new JSONException("syntax error, " + this.lexer.info());
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d9 A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01ee A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01f7 A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0231 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[Catch:{ all -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ed A[Catch:{ all -> 0x0049 }, LOOP:1: B:61:0x00eb->B:62:0x00ed, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00fa A[Catch:{ all -> 0x0049 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseArray(java.util.Collection r17, java.lang.Object r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer
            int r3 = r2.token
            r4 = 21
            if (r3 == r4) goto L_0x0010
            r4 = 22
            if (r3 != r4) goto L_0x0017
        L_0x0010:
            r2.nextToken()
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer
            int r3 = r2.token
        L_0x0017:
            r2 = 14
            if (r3 != r2) goto L_0x023e
            com.alibaba.fastjson.parser.JSONLexer r3 = r1.lexer
            boolean r3 = r3.disableCircularReferenceDetect
            com.alibaba.fastjson.parser.ParseContext r4 = r1.contex
            if (r3 != 0) goto L_0x0028
            r5 = r18
            r1.setContext(r4, r0, r5)
        L_0x0028:
            com.alibaba.fastjson.parser.JSONLexer r5 = r1.lexer     // Catch:{ all -> 0x0049 }
            char r6 = r5.ch     // Catch:{ all -> 0x0049 }
            r7 = 123(0x7b, float:1.72E-43)
            r8 = 93
            r9 = 4
            r10 = 12
            r13 = 34
            r14 = 16
            r15 = 1
            if (r6 == r13) goto L_0x006c
            if (r6 != r8) goto L_0x004c
            r5.next()     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r0 = r1.lexer     // Catch:{ all -> 0x0049 }
            r0.nextToken(r14)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x0048
            r1.contex = r4
        L_0x0048:
            return
        L_0x0049:
            r0 = move-exception
            goto L_0x0239
        L_0x004c:
            if (r6 != r7) goto L_0x0067
            int r6 = r5.bp     // Catch:{ all -> 0x0049 }
            int r6 = r6 + r15
            r5.bp = r6     // Catch:{ all -> 0x0049 }
            int r11 = r5.len     // Catch:{ all -> 0x0049 }
            if (r6 < r11) goto L_0x005a
            r6 = 26
            goto L_0x0060
        L_0x005a:
            java.lang.String r11 = r5.text     // Catch:{ all -> 0x0049 }
            char r6 = r11.charAt(r6)     // Catch:{ all -> 0x0049 }
        L_0x0060:
            r5.ch = r6     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r5 = r1.lexer     // Catch:{ all -> 0x0049 }
            r5.token = r10     // Catch:{ all -> 0x0049 }
            goto L_0x006a
        L_0x0067:
            r5.nextToken(r10)     // Catch:{ all -> 0x0049 }
        L_0x006a:
            r5 = 0
            goto L_0x007b
        L_0x006c:
            int r6 = r5.features     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0049 }
            int r11 = r11.mask     // Catch:{ all -> 0x0049 }
            r6 = r6 & r11
            if (r6 != 0) goto L_0x0077
            r5 = r15
            goto L_0x007b
        L_0x0077:
            r5.nextToken(r9)     // Catch:{ all -> 0x0049 }
            goto L_0x006a
        L_0x007b:
            r6 = 0
        L_0x007c:
            if (r5 == 0) goto L_0x00e7
            com.alibaba.fastjson.parser.JSONLexer r11 = r1.lexer     // Catch:{ all -> 0x0049 }
            char r7 = r11.ch     // Catch:{ all -> 0x0049 }
            if (r7 != r13) goto L_0x00e7
            java.lang.String r7 = r11.scanStringValue(r13)     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r11 = r1.lexer     // Catch:{ all -> 0x0049 }
            char r12 = r11.ch     // Catch:{ all -> 0x0049 }
            r2 = 44
            if (r12 != r2) goto L_0x00ba
            int r2 = r11.bp     // Catch:{ all -> 0x0049 }
            int r2 = r2 + r15
            r11.bp = r2     // Catch:{ all -> 0x0049 }
            int r12 = r11.len     // Catch:{ all -> 0x0049 }
            if (r2 < r12) goto L_0x009c
            r2 = 26
            goto L_0x00a2
        L_0x009c:
            java.lang.String r12 = r11.text     // Catch:{ all -> 0x0049 }
            char r2 = r12.charAt(r2)     // Catch:{ all -> 0x0049 }
        L_0x00a2:
            r11.ch = r2     // Catch:{ all -> 0x0049 }
            r0.add(r7)     // Catch:{ all -> 0x0049 }
            int r7 = r1.resolveStatus     // Catch:{ all -> 0x0049 }
            if (r7 != r15) goto L_0x00ae
            r16.checkListResolve(r17)     // Catch:{ all -> 0x0049 }
        L_0x00ae:
            if (r2 != r13) goto L_0x00b3
            r11 = 0
            goto L_0x0231
        L_0x00b3:
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken()     // Catch:{ all -> 0x0049 }
            r5 = 0
            goto L_0x00e7
        L_0x00ba:
            if (r12 != r8) goto L_0x00e4
            int r2 = r11.bp     // Catch:{ all -> 0x0049 }
            int r2 = r2 + r15
            r11.bp = r2     // Catch:{ all -> 0x0049 }
            int r5 = r11.len     // Catch:{ all -> 0x0049 }
            if (r2 < r5) goto L_0x00c8
            r2 = 26
            goto L_0x00ce
        L_0x00c8:
            java.lang.String r5 = r11.text     // Catch:{ all -> 0x0049 }
            char r2 = r5.charAt(r2)     // Catch:{ all -> 0x0049 }
        L_0x00ce:
            r11.ch = r2     // Catch:{ all -> 0x0049 }
            r0.add(r7)     // Catch:{ all -> 0x0049 }
            int r2 = r1.resolveStatus     // Catch:{ all -> 0x0049 }
            if (r2 != r15) goto L_0x00da
            r16.checkListResolve(r17)     // Catch:{ all -> 0x0049 }
        L_0x00da:
            com.alibaba.fastjson.parser.JSONLexer r0 = r1.lexer     // Catch:{ all -> 0x0049 }
            r0.nextToken(r14)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x00e3
            r1.contex = r4
        L_0x00e3:
            return
        L_0x00e4:
            r11.nextToken()     // Catch:{ all -> 0x0049 }
        L_0x00e7:
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r2 = r2.token     // Catch:{ all -> 0x0049 }
        L_0x00eb:
            if (r2 != r14) goto L_0x00f7
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken()     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r2 = r2.token     // Catch:{ all -> 0x0049 }
            goto L_0x00eb
        L_0x00f7:
            r7 = 2
            if (r2 == r7) goto L_0x01d9
            r7 = 3
            if (r2 == r7) goto L_0x01bb
            if (r2 == r9) goto L_0x018d
            r7 = 6
            if (r2 == r7) goto L_0x0183
            r7 = 7
            if (r2 == r7) goto L_0x0179
            r7 = 8
            r11 = 0
            if (r2 == r7) goto L_0x0171
            if (r2 == r10) goto L_0x014b
            r7 = 20
            if (r2 == r7) goto L_0x0143
            r7 = 23
            if (r2 == r7) goto L_0x013b
            r7 = 14
            if (r2 == r7) goto L_0x012e
            r11 = 15
            if (r2 == r11) goto L_0x0124
            java.lang.Object r11 = r16.parse()     // Catch:{ all -> 0x0049 }
        L_0x0120:
            r2 = r11
            r11 = 0
            goto L_0x01e7
        L_0x0124:
            com.alibaba.fastjson.parser.JSONLexer r0 = r1.lexer     // Catch:{ all -> 0x0049 }
            r0.nextToken(r14)     // Catch:{ all -> 0x0049 }
            if (r3 != 0) goto L_0x012d
            r1.contex = r4
        L_0x012d:
            return
        L_0x012e:
            com.alibaba.fastjson.JSONArray r11 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0049 }
            r11.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0049 }
            r1.parseArray((java.util.Collection) r11, (java.lang.Object) r2)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x013b:
            r7 = 14
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken(r9)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x0143:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0049 }
            java.lang.String r2 = "unclosed jsonArray"
            r0.<init>(r2)     // Catch:{ all -> 0x0049 }
            throw r0     // Catch:{ all -> 0x0049 }
        L_0x014b:
            r7 = 14
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r2 = r2.features     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0049 }
            int r11 = r11.mask     // Catch:{ all -> 0x0049 }
            r2 = r2 & r11
            if (r2 == 0) goto L_0x0163
            com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0049 }
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap     // Catch:{ all -> 0x0049 }
            r11.<init>()     // Catch:{ all -> 0x0049 }
            r2.<init>((java.util.Map<java.lang.String, java.lang.Object>) r11)     // Catch:{ all -> 0x0049 }
            goto L_0x0168
        L_0x0163:
            com.alibaba.fastjson.JSONObject r2 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0049 }
            r2.<init>()     // Catch:{ all -> 0x0049 }
        L_0x0168:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0049 }
            java.lang.Object r11 = r1.parseObject((java.util.Map) r2, (java.lang.Object) r11)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x0171:
            r7 = 14
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken(r9)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x0179:
            r7 = 14
            java.lang.Boolean r11 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken(r14)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x0183:
            r7 = 14
            java.lang.Boolean r11 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken(r14)     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x018d:
            r7 = 14
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            java.lang.String r11 = r2.stringVal()     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            r2.nextToken(r14)     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r2 = r2.features     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0049 }
            int r12 = r12.mask     // Catch:{ all -> 0x0049 }
            r2 = r2 & r12
            if (r2 == 0) goto L_0x0120
            com.alibaba.fastjson.parser.JSONLexer r2 = new com.alibaba.fastjson.parser.JSONLexer     // Catch:{ all -> 0x0049 }
            r2.<init>(r11)     // Catch:{ all -> 0x0049 }
            boolean r12 = r2.scanISO8601DateIfMatch(r15)     // Catch:{ all -> 0x0049 }
            if (r12 == 0) goto L_0x01b6
            java.util.Calendar r11 = r2.calendar     // Catch:{ all -> 0x0049 }
            java.util.Date r11 = r11.getTime()     // Catch:{ all -> 0x0049 }
        L_0x01b6:
            r2.close()     // Catch:{ all -> 0x0049 }
            goto L_0x0120
        L_0x01bb:
            r7 = 14
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r11 = r2.features     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.Feature r12 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x0049 }
            int r12 = r12.mask     // Catch:{ all -> 0x0049 }
            r11 = r11 & r12
            if (r11 == 0) goto L_0x01ce
            java.lang.Number r2 = r2.decimalValue(r15)     // Catch:{ all -> 0x0049 }
            r11 = 0
            goto L_0x01d3
        L_0x01ce:
            r11 = 0
            java.lang.Number r2 = r2.decimalValue(r11)     // Catch:{ all -> 0x0049 }
        L_0x01d3:
            com.alibaba.fastjson.parser.JSONLexer r12 = r1.lexer     // Catch:{ all -> 0x0049 }
            r12.nextToken(r14)     // Catch:{ all -> 0x0049 }
            goto L_0x01e7
        L_0x01d9:
            r7 = 14
            r11 = 0
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            java.lang.Number r2 = r2.integerValue()     // Catch:{ all -> 0x0049 }
            com.alibaba.fastjson.parser.JSONLexer r12 = r1.lexer     // Catch:{ all -> 0x0049 }
            r12.nextToken(r14)     // Catch:{ all -> 0x0049 }
        L_0x01e7:
            r0.add(r2)     // Catch:{ all -> 0x0049 }
            int r2 = r1.resolveStatus     // Catch:{ all -> 0x0049 }
            if (r2 != r15) goto L_0x01f1
            r16.checkListResolve(r17)     // Catch:{ all -> 0x0049 }
        L_0x01f1:
            com.alibaba.fastjson.parser.JSONLexer r2 = r1.lexer     // Catch:{ all -> 0x0049 }
            int r12 = r2.token     // Catch:{ all -> 0x0049 }
            if (r12 != r14) goto L_0x0231
            char r12 = r2.ch     // Catch:{ all -> 0x0049 }
            if (r12 != r13) goto L_0x0203
            int r12 = r2.bp     // Catch:{ all -> 0x0049 }
            r2.pos = r12     // Catch:{ all -> 0x0049 }
            r2.scanString()     // Catch:{ all -> 0x0049 }
            goto L_0x0231
        L_0x0203:
            r7 = 48
            if (r12 < r7) goto L_0x0213
            r7 = 57
            if (r12 > r7) goto L_0x0213
            int r7 = r2.bp     // Catch:{ all -> 0x0049 }
            r2.pos = r7     // Catch:{ all -> 0x0049 }
            r2.scanNumber()     // Catch:{ all -> 0x0049 }
            goto L_0x0231
        L_0x0213:
            r7 = 123(0x7b, float:1.72E-43)
            if (r12 != r7) goto L_0x022e
            r2.token = r10     // Catch:{ all -> 0x0049 }
            int r12 = r2.bp     // Catch:{ all -> 0x0049 }
            int r12 = r12 + r15
            r2.bp = r12     // Catch:{ all -> 0x0049 }
            int r7 = r2.len     // Catch:{ all -> 0x0049 }
            if (r12 < r7) goto L_0x0225
            r7 = 26
            goto L_0x022b
        L_0x0225:
            java.lang.String r7 = r2.text     // Catch:{ all -> 0x0049 }
            char r7 = r7.charAt(r12)     // Catch:{ all -> 0x0049 }
        L_0x022b:
            r2.ch = r7     // Catch:{ all -> 0x0049 }
            goto L_0x0231
        L_0x022e:
            r2.nextToken()     // Catch:{ all -> 0x0049 }
        L_0x0231:
            int r6 = r6 + 1
            r2 = 14
            r7 = 123(0x7b, float:1.72E-43)
            goto L_0x007c
        L_0x0239:
            if (r3 != 0) goto L_0x023d
            r1.contex = r4
        L_0x023d:
            throw r0
        L_0x023e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "syntax error, expect [, actual "
            r2.append(r4)
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)
            r2.append(r3)
            java.lang.String r3 = ", pos "
            r2.append(r3)
            com.alibaba.fastjson.parser.JSONLexer r3 = r1.lexer
            int r3 = r3.pos
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public <T> T parseObject(Class<T> cls) {
        return parseObject((Type) cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                Object bytesValue = jSONLexer.bytesValue();
                this.lexer.nextToken();
                return bytesValue;
            } else if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return stringVal.toCharArray();
            }
        }
        try {
            return this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i10 = this.lexer.token;
        if (i10 == 12 || i10 == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    JSONLexer jSONLexer = this.lexer;
                    int i11 = jSONLexer.token;
                    if (i11 == 13) {
                        jSONLexer.nextToken(16);
                        return;
                    } else if (i11 == 16) {
                        continue;
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer == null) {
                    JSONLexer jSONLexer2 = this.lexer;
                    if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                        jSONLexer2.nextTokenWithChar(':');
                        parse();
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 13) {
                            jSONLexer3.nextToken();
                            return;
                        }
                    } else {
                        throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                    }
                } else {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    Type type = fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = parseString();
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithChar(':');
                        obj2 = deserializer2.deserialze(this, type, (Object) null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    JSONLexer jSONLexer4 = this.lexer;
                    int i12 = jSONLexer4.token;
                    if (i12 != 16 && i12 == 13) {
                        jSONLexer4.nextToken(16);
                        return;
                    }
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i10));
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((Map) (this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject((Map<String, Object>) new LinkedHashMap()) : new JSONObject(), (Object) null);
    }
}
