package com.fasterxml.jackson.core;

import java.io.Closeable;

public abstract class h implements Closeable {

    public enum a {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_LEADING_DECIMAL_POINT_FOR_NUMBERS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        ALLOW_MISSING_VALUES(false),
        ALLOW_TRAILING_COMMA(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNDEFINED(false),
        INCLUDE_SOURCE_IN_LOCATION(true);
        

        /* renamed from: a  reason: collision with root package name */
        private final boolean f5116a;

        /* renamed from: b  reason: collision with root package name */
        private final int f5117b;

        private a(boolean z10) {
            this.f5117b = 1 << ordinal();
            this.f5116a = z10;
        }

        public static int a() {
            int i10 = 0;
            for (a aVar : values()) {
                if (aVar.b()) {
                    i10 |= aVar.c();
                }
            }
            return i10;
        }

        public boolean b() {
            return this.f5116a;
        }

        public int c() {
            return this.f5117b;
        }
    }

    public enum b {
        INT,
        LONG,
        BIG_INTEGER,
        FLOAT,
        DOUBLE,
        BIG_DECIMAL
    }
}
