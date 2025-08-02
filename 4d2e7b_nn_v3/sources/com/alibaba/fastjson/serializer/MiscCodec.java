package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    private MiscCodec() {
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        if (type == StackTraceElement.class) {
            return parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            } else if ("val".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                obj2 = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = defaultJSONParser.parse();
        }
        if (obj2 == null) {
            return null;
        }
        Class<Currency> cls = Currency.class;
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return UUID.fromString(str);
            }
            if (type == Class.class) {
                return TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader, false);
            }
            if (type == Locale.class) {
                String[] split = str.split("_");
                if (split.length == 1) {
                    return new Locale(split[0]);
                }
                if (split.length == 2) {
                    return new Locale(split[0], split[1]);
                }
                return new Locale(split[0], split[1], split[2]);
            } else if (type == URI.class) {
                return URI.create(str);
            } else {
                if (type == URL.class) {
                    try {
                        return new URL(str);
                    } catch (MalformedURLException e10) {
                        throw new JSONException("create url error", e10);
                    }
                } else if (type == Pattern.class) {
                    return Pattern.compile(str);
                } else {
                    if (type == Charset.class) {
                        return Charset.forName(str);
                    }
                    if (type == cls) {
                        return Currency.getInstance(str);
                    }
                    if (type == SimpleDateFormat.class) {
                        T simpleDateFormat = new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
                        simpleDateFormat.setTimeZone(defaultJSONParser.lexer.timeZone);
                        return simpleDateFormat;
                    } else if (type == Character.TYPE || type == Character.class) {
                        return TypeUtils.castToChar(str);
                    } else {
                        if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
                            return TimeZone.getTimeZone(str);
                        }
                        try {
                            return Class.forName("android.net.Uri").getMethod("parse", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
                        } catch (Exception e11) {
                            throw new JSONException("parse android.net.Uri error.", e11);
                        }
                    }
                }
            }
        } else {
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj2;
                if (type == cls) {
                    String string = jSONObject.getString(FirebaseAnalytics.Param.CURRENCY);
                    if (string != null) {
                        return Currency.getInstance(string);
                    }
                    String string2 = jSONObject.getString(AppsFlyerProperties.CURRENCY_CODE);
                    if (string2 != null) {
                        return Currency.getInstance(string2);
                    }
                }
                if (type == Map.Entry.class) {
                    return jSONObject.entrySet().iterator().next();
                }
            }
            throw new JSONException("except string value");
        }
    }

    /* access modifiers changed from: protected */
    public <T> T parseStackTraceElement(DefaultJSONParser defaultJSONParser) {
        DefaultJSONParser defaultJSONParser2 = defaultJSONParser;
        JSONLexer jSONLexer = defaultJSONParser2.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            int i10 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (true) {
                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser2.symbolTable);
                if (scanSymbol == null) {
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        break;
                    } else if (jSONLexer.token() == 16) {
                        continue;
                    }
                }
                jSONLexer.nextTokenWithChar(':');
                if ("className".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str = null;
                    } else if (jSONLexer.token() == 4) {
                        str = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("methodName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str2 = null;
                    } else if (jSONLexer.token() == 4) {
                        str2 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("fileName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str3 = null;
                    } else if (jSONLexer.token() == 4) {
                        str3 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("lineNumber".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        i10 = 0;
                    } else if (jSONLexer.token() == 2) {
                        i10 = jSONLexer.intValue();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("nativeMethod".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 6) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 7) {
                        jSONLexer.nextToken(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (scanSymbol != JSON.DEFAULT_TYPE_KEY) {
                    throw new JSONException("syntax error : " + scanSymbol);
                } else if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    if (!stringVal.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + stringVal);
                    }
                } else if (jSONLexer.token() != 8) {
                    throw new JSONException("syntax error");
                }
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
            return new StackTraceElement(str, str2, str3, i10);
        } else {
            throw new JSONException("syntax error: " + JSONToken.name(jSONLexer.token()));
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        Type type2;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                jSONSerializer.write("");
                return;
            }
            if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) != 0) {
                if (Enumeration.class.isAssignableFrom(TypeUtils.getClass(type))) {
                    serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                    return;
                }
            }
            serializeWriter.writeNull();
        } else if (obj instanceof Pattern) {
            jSONSerializer.write(((Pattern) obj).pattern());
        } else if (obj instanceof TimeZone) {
            jSONSerializer.write(((TimeZone) obj).getID());
        } else if (obj instanceof Currency) {
            jSONSerializer.write(((Currency) obj).getCurrencyCode());
        } else if (obj instanceof Class) {
            jSONSerializer.write(((Class) obj).getName());
        } else if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == 0) {
                jSONSerializer.write("\u0000");
            } else {
                jSONSerializer.write(ch.toString());
            }
        } else {
            int i10 = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                    serializeWriter.writeString(pattern);
                    return;
                }
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeString(pattern);
                serializeWriter.write(125);
            } else if (obj instanceof JSONStreamAware) {
                ((JSONStreamAware) obj).writeJSONString(serializeWriter);
            } else if (obj instanceof JSONAware) {
                serializeWriter.write(((JSONAware) obj).toJSONString());
            } else if (obj instanceof JSONSerializable) {
                ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
            } else if (obj instanceof Enumeration) {
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || !(type instanceof ParameterizedType)) {
                    type2 = null;
                } else {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                }
                Enumeration enumeration = (Enumeration) obj;
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                try {
                    serializeWriter.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object nextElement = enumeration.nextElement();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            serializeWriter.write(44);
                        }
                        if (nextElement == null) {
                            serializeWriter.writeNull();
                        } else {
                            jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, Integer.valueOf(i10), type2);
                        }
                        i10 = i11;
                    }
                    serializeWriter.write(93);
                    jSONSerializer.context = serialContext;
                } catch (Throwable th) {
                    jSONSerializer.context = serialContext;
                    throw th;
                }
            } else {
                jSONSerializer.write(obj.toString());
            }
        }
    }
}
