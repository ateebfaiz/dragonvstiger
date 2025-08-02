package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public final class JsonPrimitive extends JsonElement {
    private final Object value;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.value = bool;
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.value;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }

    public JsonPrimitive deepCopy() {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.value == null) {
            if (jsonPrimitive.value == null) {
                return true;
            }
            return false;
        } else if (!isIntegral(this) || !isIntegral(jsonPrimitive)) {
            Object obj2 = this.value;
            if (!(obj2 instanceof Number) || !(jsonPrimitive.value instanceof Number)) {
                return obj2.equals(jsonPrimitive.value);
            }
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal getAsBigDecimal() {
        Object obj = this.value;
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        return new BigDecimal(getAsString());
    }

    public BigInteger getAsBigInteger() {
        Object obj = this.value;
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        return new BigInteger(getAsString());
    }

    public boolean getAsBoolean() {
        if (isBoolean()) {
            return ((Boolean) this.value).booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public byte getAsByte() {
        if (isNumber()) {
            return getAsNumber().byteValue();
        }
        return Byte.parseByte(getAsString());
    }

    @Deprecated
    public char getAsCharacter() {
        String asString = getAsString();
        if (!asString.isEmpty()) {
            return asString.charAt(0);
        }
        throw new UnsupportedOperationException("String value is empty");
    }

    public double getAsDouble() {
        if (isNumber()) {
            return getAsNumber().doubleValue();
        }
        return Double.parseDouble(getAsString());
    }

    public float getAsFloat() {
        if (isNumber()) {
            return getAsNumber().floatValue();
        }
        return Float.parseFloat(getAsString());
    }

    public int getAsInt() {
        if (isNumber()) {
            return getAsNumber().intValue();
        }
        return Integer.parseInt(getAsString());
    }

    public long getAsLong() {
        if (isNumber()) {
            return getAsNumber().longValue();
        }
        return Long.parseLong(getAsString());
    }

    public Number getAsNumber() {
        Object obj = this.value;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public short getAsShort() {
        if (isNumber()) {
            return getAsNumber().shortValue();
        }
        return Short.parseShort(getAsString());
    }

    public String getAsString() {
        Object obj = this.value;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return ((Boolean) this.value).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.value.getClass());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.value = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.value = str;
    }

    public JsonPrimitive(Character ch) {
        Objects.requireNonNull(ch);
        this.value = ch.toString();
    }
}
