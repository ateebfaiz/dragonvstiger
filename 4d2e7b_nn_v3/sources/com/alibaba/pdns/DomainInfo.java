package com.alibaba.pdns;

public class DomainInfo {
    public String code = null;
    public String data = null;
    public String host;

    /* renamed from: id  reason: collision with root package name */
    public String f17855id;
    public String startTime = null;
    public String stopTime = null;
    public String url;

    public DomainInfo(String str, String str2, String str3) {
        this.f17855id = str;
        this.url = str2;
        this.host = str3;
        this.startTime = String.valueOf(System.nanoTime());
    }

    public static DomainInfo domainInfoFactory(String str, String str2, String str3, String str4) {
        return new DomainInfo("", o.b(str2, str3, str, str4), str3);
    }

    public String toString() {
        return (((((("DomainInfo: \n" + "id = " + this.f17855id + "\n") + "url = " + this.url + "\n") + "host = " + this.host + "\n") + "data = " + this.data + "\n") + "startTime = " + this.startTime + "\n") + "stopTime = " + this.stopTime + "\n") + "code = " + this.code + "\n";
    }

    public static DomainInfo[] domainInfoFactory(String[] strArr, String str, String str2, String str3) {
        DomainInfo[] domainInfoArr = new DomainInfo[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            domainInfoArr[i10] = domainInfoFactory(strArr[i10], str, str2, str3);
        }
        return domainInfoArr;
    }
}
