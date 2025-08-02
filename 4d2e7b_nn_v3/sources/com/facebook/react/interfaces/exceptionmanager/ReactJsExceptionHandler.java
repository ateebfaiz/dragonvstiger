package com.facebook.react.interfaces.exceptionmanager;

import g0.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;

public interface ReactJsExceptionHandler {

    public interface ParsedError {

        public interface StackFrame {
            int getColumnNumber();

            String getFileName();

            int getLineNumber();

            String getMethodName();
        }

        int getExceptionId();

        List<StackFrame> getFrames();

        String getMessage();

        boolean isFatal();
    }

    private static final class ParsedErrorImpl implements ParsedError {
        private final int exceptionId;
        private final ArrayList<ParsedStackFrameImpl> frames;
        private final boolean isFatal;
        private final String message;

        public ParsedErrorImpl(ArrayList<ParsedStackFrameImpl> arrayList, String str, int i10, boolean z10) {
            m.f(arrayList, "frames");
            m.f(str, "message");
            this.frames = arrayList;
            this.message = str;
            this.exceptionId = i10;
            this.isFatal = z10;
        }

        public static /* synthetic */ ParsedErrorImpl copy$default(ParsedErrorImpl parsedErrorImpl, ArrayList<ParsedStackFrameImpl> arrayList, String str, int i10, boolean z10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                arrayList = parsedErrorImpl.frames;
            }
            if ((i11 & 2) != 0) {
                str = parsedErrorImpl.message;
            }
            if ((i11 & 4) != 0) {
                i10 = parsedErrorImpl.exceptionId;
            }
            if ((i11 & 8) != 0) {
                z10 = parsedErrorImpl.isFatal;
            }
            return parsedErrorImpl.copy(arrayList, str, i10, z10);
        }

        public final ArrayList<ParsedStackFrameImpl> component1() {
            return this.frames;
        }

        public final String component2() {
            return this.message;
        }

        public final int component3() {
            return this.exceptionId;
        }

        public final boolean component4() {
            return this.isFatal;
        }

        public final ParsedErrorImpl copy(ArrayList<ParsedStackFrameImpl> arrayList, String str, int i10, boolean z10) {
            m.f(arrayList, "frames");
            m.f(str, "message");
            return new ParsedErrorImpl(arrayList, str, i10, z10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParsedErrorImpl)) {
                return false;
            }
            ParsedErrorImpl parsedErrorImpl = (ParsedErrorImpl) obj;
            return m.b(this.frames, parsedErrorImpl.frames) && m.b(this.message, parsedErrorImpl.message) && this.exceptionId == parsedErrorImpl.exceptionId && this.isFatal == parsedErrorImpl.isFatal;
        }

        public int getExceptionId() {
            return this.exceptionId;
        }

        public String getMessage() {
            return this.message;
        }

        public int hashCode() {
            return (((((this.frames.hashCode() * 31) + this.message.hashCode()) * 31) + this.exceptionId) * 31) + a.a(this.isFatal);
        }

        public boolean isFatal() {
            return this.isFatal;
        }

        public String toString() {
            ArrayList<ParsedStackFrameImpl> arrayList = this.frames;
            String str = this.message;
            int i10 = this.exceptionId;
            boolean z10 = this.isFatal;
            return "ParsedErrorImpl(frames=" + arrayList + ", message=" + str + ", exceptionId=" + i10 + ", isFatal=" + z10 + ")";
        }

        public ArrayList<ParsedStackFrameImpl> getFrames() {
            return this.frames;
        }
    }

    private static final class ParsedStackFrameImpl implements ParsedError.StackFrame {
        private final int columnNumber;
        private final String fileName;
        private final int lineNumber;
        private final String methodName;

        public ParsedStackFrameImpl(String str, String str2, int i10, int i11) {
            m.f(str, "fileName");
            m.f(str2, "methodName");
            this.fileName = str;
            this.methodName = str2;
            this.lineNumber = i10;
            this.columnNumber = i11;
        }

        public static /* synthetic */ ParsedStackFrameImpl copy$default(ParsedStackFrameImpl parsedStackFrameImpl, String str, String str2, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = parsedStackFrameImpl.fileName;
            }
            if ((i12 & 2) != 0) {
                str2 = parsedStackFrameImpl.methodName;
            }
            if ((i12 & 4) != 0) {
                i10 = parsedStackFrameImpl.lineNumber;
            }
            if ((i12 & 8) != 0) {
                i11 = parsedStackFrameImpl.columnNumber;
            }
            return parsedStackFrameImpl.copy(str, str2, i10, i11);
        }

        public final String component1() {
            return this.fileName;
        }

        public final String component2() {
            return this.methodName;
        }

        public final int component3() {
            return this.lineNumber;
        }

        public final int component4() {
            return this.columnNumber;
        }

        public final ParsedStackFrameImpl copy(String str, String str2, int i10, int i11) {
            m.f(str, "fileName");
            m.f(str2, "methodName");
            return new ParsedStackFrameImpl(str, str2, i10, i11);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ParsedStackFrameImpl)) {
                return false;
            }
            ParsedStackFrameImpl parsedStackFrameImpl = (ParsedStackFrameImpl) obj;
            return m.b(this.fileName, parsedStackFrameImpl.fileName) && m.b(this.methodName, parsedStackFrameImpl.methodName) && this.lineNumber == parsedStackFrameImpl.lineNumber && this.columnNumber == parsedStackFrameImpl.columnNumber;
        }

        public int getColumnNumber() {
            return this.columnNumber;
        }

        public String getFileName() {
            return this.fileName;
        }

        public int getLineNumber() {
            return this.lineNumber;
        }

        public String getMethodName() {
            return this.methodName;
        }

        public int hashCode() {
            return (((((this.fileName.hashCode() * 31) + this.methodName.hashCode()) * 31) + this.lineNumber) * 31) + this.columnNumber;
        }

        public String toString() {
            String str = this.fileName;
            String str2 = this.methodName;
            int i10 = this.lineNumber;
            int i11 = this.columnNumber;
            return "ParsedStackFrameImpl(fileName=" + str + ", methodName=" + str2 + ", lineNumber=" + i10 + ", columnNumber=" + i11 + ")";
        }
    }

    void reportJsException(ParsedError parsedError);
}
