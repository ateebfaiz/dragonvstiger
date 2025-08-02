package com.google.gson;

import com.google.gson.internal.ReflectionAccessFilterHelper;

public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = new c();
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = new b();
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = new d();
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = new a();

    public enum FilterResult {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    class a implements ReflectionAccessFilter {
        a() {
        }

        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isJavaType((Class<?>) cls)) {
                return FilterResult.BLOCK_INACCESSIBLE;
            }
            return FilterResult.INDECISIVE;
        }
    }

    class b implements ReflectionAccessFilter {
        b() {
        }

        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isJavaType((Class<?>) cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }

    class c implements ReflectionAccessFilter {
        c() {
        }

        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isAndroidType((Class<?>) cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }

    class d implements ReflectionAccessFilter {
        d() {
        }

        public FilterResult check(Class cls) {
            if (ReflectionAccessFilterHelper.isAnyPlatformType(cls)) {
                return FilterResult.BLOCK_ALL;
            }
            return FilterResult.INDECISIVE;
        }
    }

    FilterResult check(Class<?> cls);
}
