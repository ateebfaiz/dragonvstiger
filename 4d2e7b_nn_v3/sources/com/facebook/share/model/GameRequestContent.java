package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestContent implements ShareModel {
    public static final Parcelable.Creator<GameRequestContent> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f4581a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4582b;

    /* renamed from: c  reason: collision with root package name */
    private final List f4583c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4584d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4585e;

    /* renamed from: f  reason: collision with root package name */
    private final b f4586f;

    /* renamed from: g  reason: collision with root package name */
    private final String f4587g;

    /* renamed from: h  reason: collision with root package name */
    private final c f4588h;

    /* renamed from: i  reason: collision with root package name */
    private final List f4589i;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public GameRequestContent createFromParcel(Parcel parcel) {
            return new GameRequestContent(parcel);
        }

        /* renamed from: b */
        public GameRequestContent[] newArray(int i10) {
            return new GameRequestContent[i10];
        }
    }

    public enum b {
        SEND,
        ASKFOR,
        TURN,
        INVITE
    }

    public enum c {
        APP_USERS,
        APP_NON_USERS,
        EVERYBODY
    }

    GameRequestContent(Parcel parcel) {
        this.f4581a = parcel.readString();
        this.f4582b = parcel.readString();
        this.f4583c = parcel.createStringArrayList();
        this.f4584d = parcel.readString();
        this.f4585e = parcel.readString();
        this.f4586f = (b) parcel.readSerializable();
        this.f4587g = parcel.readString();
        this.f4588h = (c) parcel.readSerializable();
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        this.f4589i = createStringArrayList;
        parcel.readStringList(createStringArrayList);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4581a);
        parcel.writeString(this.f4582b);
        parcel.writeStringList(this.f4583c);
        parcel.writeString(this.f4584d);
        parcel.writeString(this.f4585e);
        parcel.writeSerializable(this.f4586f);
        parcel.writeString(this.f4587g);
        parcel.writeSerializable(this.f4588h);
        parcel.writeStringList(this.f4589i);
    }
}
