package androidx.webkit.internal;

import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

public class WebMessagePayloadAdapter implements WebMessagePayloadBoundaryInterface {
    private final byte[] mArrayBuffer;
    private final String mString;
    private final int mType;

    public WebMessagePayloadAdapter(String str) {
        this.mType = 0;
        this.mString = str;
        this.mArrayBuffer = null;
    }

    private void checkType(int i10) {
        if (this.mType != i10) {
            throw new IllegalStateException("Expected " + i10 + ", but type is " + this.mType);
        }
    }

    public byte[] getAsArrayBuffer() {
        checkType(1);
        byte[] bArr = this.mArrayBuffer;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    public String getAsString() {
        checkType(0);
        return this.mString;
    }

    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public int getType() {
        return this.mType;
    }

    public WebMessagePayloadAdapter(byte[] bArr) {
        this.mType = 1;
        this.mString = null;
        this.mArrayBuffer = bArr;
    }
}
