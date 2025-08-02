package mb;

import io.jsonwebtoken.JwtParser;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class h implements Externalizable {

    /* renamed from: c  reason: collision with root package name */
    public static final a f1308c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Collection f1309a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1310b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(Collection collection, int i10) {
        m.f(collection, "collection");
        this.f1309a = collection;
        this.f1310b = i10;
    }

    private final Object readResolve() {
        return this.f1309a;
    }

    public void readExternal(ObjectInput objectInput) {
        Collection collection;
        m.f(objectInput, "input");
        byte readByte = objectInput.readByte();
        byte b10 = readByte & 1;
        if ((readByte & -2) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i10 = 0;
                if (b10 == 0) {
                    List d10 = r.d(readInt);
                    while (i10 < readInt) {
                        d10.add(objectInput.readObject());
                        i10++;
                    }
                    collection = r.a(d10);
                } else if (b10 == 1) {
                    Set b11 = r0.b(readInt);
                    while (i10 < readInt) {
                        b11.add(objectInput.readObject());
                        i10++;
                    }
                    collection = r0.a(b11);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + b10 + JwtParser.SEPARATOR_CHAR);
                }
                this.f1309a = collection;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + JwtParser.SEPARATOR_CHAR);
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte + JwtParser.SEPARATOR_CHAR);
    }

    public void writeExternal(ObjectOutput objectOutput) {
        m.f(objectOutput, "output");
        objectOutput.writeByte(this.f1310b);
        objectOutput.writeInt(this.f1309a.size());
        for (Object writeObject : this.f1309a) {
            objectOutput.writeObject(writeObject);
        }
    }

    public h() {
        this(r.l(), 0);
    }
}
