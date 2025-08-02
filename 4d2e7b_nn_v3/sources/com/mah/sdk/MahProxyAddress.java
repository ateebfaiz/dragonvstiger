package com.mah.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;

public class MahProxyAddress implements Parcelable {
    public static final Parcelable.Creator<MahProxyAddress> CREATOR = new OooO00o();
    public final String OooO00o;
    public final int OooO0O0;
    public final boolean OooO0OO;

    public class OooO00o implements Parcelable.Creator<MahProxyAddress> {
        /* renamed from: OooO00o */
        public MahProxyAddress createFromParcel(Parcel parcel) {
            return new MahProxyAddress(parcel);
        }

        /* renamed from: OooO00o */
        public MahProxyAddress[] newArray(int i10) {
            return new MahProxyAddress[i10];
        }
    }

    public MahProxyAddress(String str, int i10, boolean z10) {
        this.OooO00o = str;
        this.OooO0O0 = i10;
        this.OooO0OO = z10;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MahProxyAddress)) {
            return false;
        }
        MahProxyAddress mahProxyAddress = (MahProxyAddress) obj;
        if (this.OooO0O0 == mahProxyAddress.OooO0O0 && this.OooO00o.equals(mahProxyAddress.OooO00o) && this.OooO0OO == mahProxyAddress.OooO0OO) {
            return true;
        }
        return false;
    }

    public String getHost() {
        return this.OooO00o;
    }

    public Proxy getHttpProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(getHost(), getPort()));
    }

    public int getPort() {
        return this.OooO0O0;
    }

    public SocketAddress getSocketAddress() {
        return new InetSocketAddress(getHost(), getPort());
    }

    public Proxy getUnresolvedHttpProxy() {
        return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(getHost(), getPort()));
    }

    public int hashCode() {
        int i10;
        int hashCode = (Integer.valueOf(this.OooO0O0).hashCode() + 1) * 37;
        String str = this.OooO00o;
        if (str == null) {
            i10 = 0;
        } else {
            i10 = str.hashCode();
        }
        return Boolean.valueOf(this.OooO0OO).hashCode() + ((hashCode + i10) * 37);
    }

    public boolean isHandshake() {
        return this.OooO0OO;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.OooO00o);
        parcel.writeInt(this.OooO0O0);
        parcel.writeByte(this.OooO0OO ? (byte) 1 : 0);
    }

    public MahProxyAddress(Parcel parcel) {
        this.OooO00o = parcel.readString();
        this.OooO0O0 = parcel.readInt();
        this.OooO0OO = parcel.readByte() != 0;
    }
}
