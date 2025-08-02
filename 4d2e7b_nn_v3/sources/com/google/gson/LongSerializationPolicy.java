package com.google.gson;

public enum LongSerializationPolicy {
    DEFAULT {
        public JsonElement serialize(Long l10) {
            if (l10 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive((Number) l10);
        }
    },
    STRING {
        public JsonElement serialize(Long l10) {
            if (l10 == null) {
                return JsonNull.INSTANCE;
            }
            return new JsonPrimitive(l10.toString());
        }
    };

    public abstract JsonElement serialize(Long l10);
}
