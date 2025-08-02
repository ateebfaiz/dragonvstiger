package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class JSONReader implements Closeable {
    private JSONStreamContext context;
    private final DefaultJSONParser parser;
    private Reader reader;

    public JSONReader(Reader reader2) {
        this(new JSONLexer(readAll(reader2)));
        this.reader = reader2;
    }

    private void endStructure() {
        int i10;
        JSONStreamContext jSONStreamContext = this.context.parent;
        this.context = jSONStreamContext;
        if (jSONStreamContext != null) {
            switch (jSONStreamContext.state) {
                case 1001:
                case 1003:
                    i10 = 1002;
                    break;
                case 1002:
                    i10 = 1003;
                    break;
                case 1004:
                    i10 = 1005;
                    break;
                default:
                    i10 = -1;
                    break;
            }
            if (i10 != -1) {
                jSONStreamContext.state = i10;
            }
        }
    }

    private void readAfter() {
        JSONStreamContext jSONStreamContext = this.context;
        int i10 = jSONStreamContext.state;
        int i11 = 1002;
        switch (i10) {
            case 1001:
            case 1003:
                break;
            case 1002:
                i11 = 1003;
                break;
            case 1004:
                i11 = 1005;
                break;
            case 1005:
                i11 = -1;
                break;
            default:
                throw new JSONException("illegal state : " + i10);
        }
        if (i11 != -1) {
            jSONStreamContext.state = i11;
        }
    }

    static String readAll(Reader reader2) {
        StringBuilder sb2 = new StringBuilder();
        try {
            char[] cArr = new char[2048];
            while (true) {
                int read = reader2.read(cArr, 0, 2048);
                if (read < 0) {
                    return sb2.toString();
                }
                sb2.append(cArr, 0, read);
            }
        } catch (Exception e10) {
            throw new JSONException("read string from reader error", e10);
        }
    }

    private void readBefore() {
        int i10 = this.context.state;
        switch (i10) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException("illegal state : " + i10);
        }
    }

    private void startStructure() {
        switch (this.context.state) {
            case 1001:
            case 1004:
                return;
            case 1002:
                this.parser.accept(17);
                return;
            case 1003:
            case 1005:
                this.parser.accept(16);
                return;
            default:
                throw new JSONException("illegal state : " + this.context.state);
        }
    }

    public void close() {
        this.parser.lexer.close();
        Reader reader2 = this.reader;
        if (reader2 != null) {
            try {
                reader2.close();
            } catch (IOException e10) {
                throw new JSONException("closed reader error", e10);
            }
        }
    }

    public void config(Feature feature, boolean z10) {
        this.parser.config(feature, z10);
    }

    public void endArray() {
        this.parser.accept(15);
        endStructure();
    }

    public void endObject() {
        this.parser.accept(13);
        endStructure();
    }

    public boolean hasNext() {
        if (this.context != null) {
            int i10 = this.parser.lexer.token();
            int i11 = this.context.state;
            switch (i11) {
                case 1001:
                case 1003:
                    if (i10 != 13) {
                        return true;
                    }
                    return false;
                case 1004:
                case 1005:
                    if (i10 != 15) {
                        return true;
                    }
                    return false;
                default:
                    throw new JSONException("illegal state : " + i11);
            }
        } else {
            throw new JSONException("context is null");
        }
    }

    public int peek() {
        return this.parser.lexer.token();
    }

    public Integer readInteger() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToInt(obj);
    }

    public Long readLong() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToLong(obj);
    }

    public <T> T readObject(TypeReference<T> typeReference) {
        return readObject(typeReference.type);
    }

    public String readString() {
        Object obj;
        if (this.context == null) {
            obj = this.parser.parse();
        } else {
            readBefore();
            obj = this.parser.parse();
            readAfter();
        }
        return TypeUtils.castToString(obj);
    }

    public void startArray() {
        if (this.context == null) {
            this.context = new JSONStreamContext((JSONStreamContext) null, 1004);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1004);
        }
        this.parser.accept(14);
    }

    public void startObject() {
        if (this.context == null) {
            this.context = new JSONStreamContext((JSONStreamContext) null, 1001);
        } else {
            startStructure();
            this.context = new JSONStreamContext(this.context, 1001);
        }
        this.parser.accept(12);
    }

    public <T> T readObject(Type type) {
        if (this.context == null) {
            return this.parser.parseObject(type);
        }
        readBefore();
        T parseObject = this.parser.parseObject(type);
        readAfter();
        return parseObject;
    }

    public JSONReader(JSONLexer jSONLexer) {
        this(new DefaultJSONParser(jSONLexer));
    }

    public JSONReader(DefaultJSONParser defaultJSONParser) {
        this.parser = defaultJSONParser;
    }

    public <T> T readObject(Class<T> cls) {
        if (this.context == null) {
            return this.parser.parseObject(cls);
        }
        readBefore();
        T parseObject = this.parser.parseObject(cls);
        readAfter();
        return parseObject;
    }

    public void readObject(Object obj) {
        if (this.context == null) {
            this.parser.parseObject(obj);
            return;
        }
        readBefore();
        this.parser.parseObject(obj);
        readAfter();
    }

    public Object readObject() {
        if (this.context == null) {
            return this.parser.parse();
        }
        readBefore();
        Object parse = this.parser.parse();
        readAfter();
        return parse;
    }

    public Object readObject(Map map) {
        if (this.context == null) {
            return this.parser.parseObject(map);
        }
        readBefore();
        Object parseObject = this.parser.parseObject(map);
        readAfter();
        return parseObject;
    }
}
