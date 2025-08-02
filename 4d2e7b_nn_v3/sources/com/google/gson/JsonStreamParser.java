package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final JsonReader parser;

    public JsonStreamParser(String str) {
        this((Reader) new StringReader(str));
    }

    public boolean hasNext() {
        boolean z10;
        synchronized (this.lock) {
            try {
                if (this.parser.peek() != JsonToken.END_DOCUMENT) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException((Throwable) e10);
            } catch (IOException e11) {
                throw new JsonIOException((Throwable) e11);
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    public JsonElement next() throws JsonParseException {
        if (hasNext()) {
            try {
                return Streams.parse(this.parser);
            } catch (StackOverflowError e10) {
                throw new JsonParseException("Failed parsing JSON source to Json", e10);
            } catch (OutOfMemoryError e11) {
                throw new JsonParseException("Failed parsing JSON source to Json", e11);
            }
        } else {
            throw new NoSuchElementException();
        }
    }
}
