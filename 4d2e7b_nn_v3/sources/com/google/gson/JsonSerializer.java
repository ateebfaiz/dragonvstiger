package com.google.gson;

import java.lang.reflect.Type;

public interface JsonSerializer<T> {
    JsonElement serialize(T t10, Type type, JsonSerializationContext jsonSerializationContext);
}
