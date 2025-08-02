package com.fasterxml.jackson.databind;

import l8.f;

public enum q implements f {
    USE_ANNOTATIONS(true),
    USE_GETTERS_AS_SETTERS(true),
    PROPAGATE_TRANSIENT_MARKER(false),
    AUTO_DETECT_CREATORS(true),
    AUTO_DETECT_FIELDS(true),
    AUTO_DETECT_GETTERS(true),
    AUTO_DETECT_IS_GETTERS(true),
    AUTO_DETECT_SETTERS(true),
    REQUIRE_SETTERS_FOR_GETTERS(false),
    ALLOW_FINAL_FIELDS_AS_MUTATORS(true),
    INFER_PROPERTY_MUTATORS(true),
    INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES(true),
    ALLOW_VOID_VALUED_PROPERTIES(false),
    CAN_OVERRIDE_ACCESS_MODIFIERS(true),
    OVERRIDE_PUBLIC_ACCESS_MODIFIERS(true),
    USE_STATIC_TYPING(false),
    USE_BASE_TYPE_AS_DEFAULT_IMPL(false),
    INFER_BUILDER_TYPE_BINDINGS(true),
    DEFAULT_VIEW_INCLUSION(true),
    SORT_PROPERTIES_ALPHABETICALLY(false),
    SORT_CREATOR_PROPERTIES_FIRST(true),
    ACCEPT_CASE_INSENSITIVE_PROPERTIES(false),
    ACCEPT_CASE_INSENSITIVE_ENUMS(false),
    ACCEPT_CASE_INSENSITIVE_VALUES(false),
    USE_WRAPPER_NAME_AS_PROPERTY_NAME(false),
    USE_STD_BEAN_NAMING(false),
    ALLOW_EXPLICIT_PROPERTY_RENAMING(false),
    ALLOW_COERCION_OF_SCALARS(true),
    IGNORE_DUPLICATE_MODULE_REGISTRATIONS(true),
    IGNORE_MERGE_FOR_UNMERGEABLE(true),
    BLOCK_UNSAFE_POLYMORPHIC_BASE_TYPES(false),
    APPLY_DEFAULT_VALUES(true);
    

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5466a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5467b;

    private q(boolean z10) {
        this.f5466a = z10;
        this.f5467b = 1 << ordinal();
    }

    public static long c() {
        long j10 = 0;
        for (q qVar : values()) {
            if (qVar.a()) {
                j10 |= qVar.e();
            }
        }
        return j10;
    }

    public boolean a() {
        return this.f5466a;
    }

    public int b() {
        return (int) this.f5467b;
    }

    public boolean d(long j10) {
        if ((j10 & this.f5467b) != 0) {
            return true;
        }
        return false;
    }

    public long e() {
        return this.f5467b;
    }
}
