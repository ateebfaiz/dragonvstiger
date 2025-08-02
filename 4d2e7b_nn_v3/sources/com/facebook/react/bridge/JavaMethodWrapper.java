package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import c8.b;
import com.alibaba.pdns.f;
import com.facebook.react.bridge.JavaModuleWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.jsonwebtoken.JwtParser;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k3.c;
import l3.a;

class JavaMethodWrapper implements JavaModuleWrapper.NativeMethod {
    private static final ArgumentExtractor<ReadableArray> ARGUMENT_EXTRACTOR_ARRAY = new ArgumentExtractor<ReadableArray>() {
        public ReadableArray extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return readableArray.getArray(i10);
        }
    };
    private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new ArgumentExtractor<Boolean>() {
        public Boolean extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return Boolean.valueOf(readableArray.getBoolean(i10));
        }
    };
    /* access modifiers changed from: private */
    public static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK = new ArgumentExtractor<Callback>() {
        @Nullable
        public Callback extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            if (readableArray.isNull(i10)) {
                return null;
            }
            return new CallbackImpl(jSInstance, (int) readableArray.getDouble(i10));
        }
    };
    private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new ArgumentExtractor<Double>() {
        public Double extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return Double.valueOf(readableArray.getDouble(i10));
        }
    };
    private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC = new ArgumentExtractor<Dynamic>() {
        public Dynamic extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return DynamicFromArray.create(readableArray, i10);
        }
    };
    private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new ArgumentExtractor<Float>() {
        public Float extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return Float.valueOf((float) readableArray.getDouble(i10));
        }
    };
    private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new ArgumentExtractor<Integer>() {
        public Integer extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return Integer.valueOf((int) readableArray.getDouble(i10));
        }
    };
    private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP = new ArgumentExtractor<ReadableMap>() {
        public ReadableMap extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return readableArray.getMap(i10);
        }
    };
    private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor<Promise>() {
        public int getJSArgumentsNeeded() {
            return 2;
        }

        public Promise extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return new PromiseImpl((Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i10), (Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i10 + 1));
        }
    };
    private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new ArgumentExtractor<String>() {
        public String extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10) {
            return readableArray.getString(i10);
        }
    };
    private static final boolean DEBUG = c.a().c(a.f22451d);
    @Nullable
    private ArgumentExtractor[] mArgumentExtractors;
    @Nullable
    private Object[] mArguments;
    private boolean mArgumentsProcessed = false;
    @Nullable
    private int mJSArgumentsNeeded;
    private final Method mMethod;
    private final JavaModuleWrapper mModuleWrapper;
    private final int mParamLength;
    private final Class[] mParameterTypes;
    @Nullable
    private String mSignature;
    private String mType = BaseJavaModule.METHOD_TYPE_ASYNC;

    private static abstract class ArgumentExtractor<T> {
        private ArgumentExtractor() {
        }

        @Nullable
        public abstract T extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i10);

        public int getJSArgumentsNeeded() {
            return 1;
        }
    }

    public JavaMethodWrapper(JavaModuleWrapper javaModuleWrapper, Method method, boolean z10) {
        this.mModuleWrapper = javaModuleWrapper;
        this.mMethod = method;
        method.setAccessible(true);
        Class<Promise>[] parameterTypes = method.getParameterTypes();
        this.mParameterTypes = parameterTypes;
        int length = parameterTypes.length;
        this.mParamLength = length;
        if (z10) {
            this.mType = BaseJavaModule.METHOD_TYPE_SYNC;
        } else if (length > 0 && parameterTypes[length - 1] == Promise.class) {
            this.mType = BaseJavaModule.METHOD_TYPE_PROMISE;
        }
    }

    private ArgumentExtractor[] buildArgumentExtractors(Class[] clsArr) {
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[clsArr.length];
        for (int i10 = 0; i10 < clsArr.length; i10 += argumentExtractorArr[i10].getJSArgumentsNeeded()) {
            Class<Dynamic> cls = clsArr[i10];
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_BOOLEAN;
            } else if (cls == Integer.class || cls == Integer.TYPE) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_INTEGER;
            } else if (cls == Double.class || cls == Double.TYPE) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_DOUBLE;
            } else if (cls == Float.class || cls == Float.TYPE) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_FLOAT;
            } else if (cls == String.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_STRING;
            } else if (cls == Callback.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_CALLBACK;
            } else if (cls == Promise.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_PROMISE;
                boolean z10 = true;
                if (i10 != clsArr.length - 1) {
                    z10 = false;
                }
                p5.a.b(z10, "Promise must be used as last parameter only");
            } else if (cls == ReadableMap.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_MAP;
            } else if (cls == ReadableArray.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_ARRAY;
            } else if (cls == Dynamic.class) {
                argumentExtractorArr[i10] = ARGUMENT_EXTRACTOR_DYNAMIC;
            } else {
                throw new RuntimeException("Got unknown argument class: " + cls.getSimpleName());
            }
        }
        return argumentExtractorArr;
    }

    private String buildSignature(Method method, Class[] clsArr, boolean z10) {
        StringBuilder sb2 = new StringBuilder(clsArr.length + 2);
        if (z10) {
            sb2.append(returnTypeToChar(method.getReturnType()));
            sb2.append(JwtParser.SEPARATOR_CHAR);
        } else {
            sb2.append("v.");
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            Class<Promise> cls = clsArr[i10];
            if (cls == Promise.class) {
                boolean z11 = true;
                if (i10 != clsArr.length - 1) {
                    z11 = false;
                }
                p5.a.b(z11, "Promise must be used as last parameter only");
            }
            sb2.append(paramTypeToChar(cls));
        }
        return sb2.toString();
    }

    private int calculateJSArgumentsNeeded() {
        int i10 = 0;
        for (ArgumentExtractor jSArgumentsNeeded : (ArgumentExtractor[]) p5.a.c(this.mArgumentExtractors)) {
            i10 += jSArgumentsNeeded.getJSArgumentsNeeded();
        }
        return i10;
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        if (cls == String.class) {
            return 'S';
        }
        return 0;
    }

    private static String createInvokeExceptionMessage(String str) {
        return "Could not invoke " + str;
    }

    private String getAffectedRange(int i10, int i11) {
        if (i11 > 1) {
            return "" + i10 + "-" + ((i10 + i11) - 1);
        }
        return "" + i10;
    }

    private static char paramTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        throw new RuntimeException("Got unknown param class: " + cls.getSimpleName());
    }

    private void processArguments() {
        if (!this.mArgumentsProcessed) {
            b.a a10 = b.a(0, "processArguments");
            a10.b(FirebaseAnalytics.Param.METHOD, this.mModuleWrapper.getName() + f.G + this.mMethod.getName()).c();
            try {
                this.mArgumentsProcessed = true;
                this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
                this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals(BaseJavaModule.METHOD_TYPE_SYNC));
                this.mArguments = new Object[this.mParameterTypes.length];
                this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
            } finally {
                b.b(0).c();
            }
        }
    }

    private static char returnTypeToChar(Class cls) {
        char commonTypeToChar = commonTypeToChar(cls);
        if (commonTypeToChar != 0) {
            return commonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown return class: " + cls.getSimpleName());
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        return (String) p5.a.c(this.mSignature);
    }

    public String getType() {
        return this.mType;
    }

    public void invoke(JSInstance jSInstance, ReadableArray readableArray) {
        int i10;
        int i11 = 0;
        String str = this.mModuleWrapper.getName() + f.G + this.mMethod.getName();
        b.a(0, "callJavaModuleMethod").b(FirebaseAnalytics.Param.METHOD, str).c();
        if (DEBUG) {
            c.a().b(a.f22451d, "JS->Java: %s.%s()", this.mModuleWrapper.getName(), this.mMethod.getName());
        }
        try {
            if (!this.mArgumentsProcessed) {
                processArguments();
            }
            if (this.mArguments == null || this.mArgumentExtractors == null) {
                throw new Error("processArguments failed");
            } else if (this.mJSArgumentsNeeded == readableArray.size()) {
                i10 = 0;
                while (true) {
                    ArgumentExtractor[] argumentExtractorArr = this.mArgumentExtractors;
                    if (i11 < argumentExtractorArr.length) {
                        this.mArguments[i11] = argumentExtractorArr[i11].extractArgument(jSInstance, readableArray, i10);
                        i10 += this.mArgumentExtractors[i11].getJSArgumentsNeeded();
                        i11++;
                    } else {
                        this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
                        b.b(0).c();
                        return;
                    }
                }
            } else {
                throw new NativeArgumentsParseException(str + " got " + readableArray.size() + " arguments, expected " + this.mJSArgumentsNeeded);
            }
        } catch (IllegalAccessException | IllegalArgumentException e10) {
            throw new RuntimeException(createInvokeExceptionMessage(str), e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException(createInvokeExceptionMessage(str), e11);
        } catch (UnexpectedNativeTypeException | NullPointerException e12) {
            throw new NativeArgumentsParseException(e12.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(i10, this.mArgumentExtractors[i11].getJSArgumentsNeeded()) + ")", e12);
        } catch (Throwable th) {
            b.b(0).c();
            throw th;
        }
    }
}
