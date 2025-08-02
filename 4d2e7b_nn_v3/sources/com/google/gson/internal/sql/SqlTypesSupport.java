package com.google.gson.internal.sql;

import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.sql.Timestamp;
import java.util.Date;

public final class SqlTypesSupport {
    public static final DefaultDateTypeAdapter.DateType<? extends Date> DATE_DATE_TYPE;
    public static final TypeAdapterFactory DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final DefaultDateTypeAdapter.DateType<? extends Date> TIMESTAMP_DATE_TYPE;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapterFactory TIME_FACTORY;

    class a extends DefaultDateTypeAdapter.DateType {
        a(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public java.sql.Date deserialize(Date date) {
            return new java.sql.Date(date.getTime());
        }
    }

    class b extends DefaultDateTypeAdapter.DateType {
        b(Class cls) {
            super(cls);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Timestamp deserialize(Date date) {
            return new Timestamp(date.getTime());
        }
    }

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        SUPPORTS_SQL_TYPES = z10;
        if (z10) {
            DATE_DATE_TYPE = new a(java.sql.Date.class);
            TIMESTAMP_DATE_TYPE = new b(Timestamp.class);
            DATE_FACTORY = a.f9457b;
            TIME_FACTORY = b.f9459b;
            TIMESTAMP_FACTORY = c.f9461b;
            return;
        }
        DATE_DATE_TYPE = null;
        TIMESTAMP_DATE_TYPE = null;
        DATE_FACTORY = null;
        TIME_FACTORY = null;
        TIMESTAMP_FACTORY = null;
    }

    private SqlTypesSupport() {
    }
}
