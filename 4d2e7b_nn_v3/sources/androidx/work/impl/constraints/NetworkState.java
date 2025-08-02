package androidx.work.impl.constraints;

import androidx.annotation.NonNull;

public class NetworkState {
    private boolean mIsConnected;
    private boolean mIsMetered;
    private boolean mIsNotRoaming;
    private boolean mIsValidated;

    public NetworkState(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.mIsConnected = z10;
        this.mIsValidated = z11;
        this.mIsMetered = z12;
        this.mIsNotRoaming = z13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.mIsConnected;
        if (this.mIsValidated) {
            i10 += 16;
        }
        if (this.mIsMetered) {
            i10 += 256;
        }
        if (this.mIsNotRoaming) {
            return i10 + 4096;
        }
        return i10;
    }

    public boolean isConnected() {
        return this.mIsConnected;
    }

    public boolean isMetered() {
        return this.mIsMetered;
    }

    public boolean isNotRoaming() {
        return this.mIsNotRoaming;
    }

    public boolean isValidated() {
        return this.mIsValidated;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.mIsConnected), Boolean.valueOf(this.mIsValidated), Boolean.valueOf(this.mIsMetered), Boolean.valueOf(this.mIsNotRoaming)});
    }
}
