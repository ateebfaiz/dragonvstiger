package mb;

import io.jsonwebtoken.JwtParser;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

final class i implements Externalizable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f1311b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private Map f1312a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public i(Map map) {
        m.f(map, "map");
        this.f1312a = map;
    }

    private final Object readResolve() {
        return this.f1312a;
    }

    public void readExternal(ObjectInput objectInput) {
        m.f(objectInput, "input");
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                Map b10 = i0.b(readInt);
                for (int i10 = 0; i10 < readInt; i10++) {
                    b10.put(objectInput.readObject(), objectInput.readObject());
                }
                this.f1312a = i0.a(b10);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + JwtParser.SEPARATOR_CHAR);
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte);
    }

    public void writeExternal(ObjectOutput objectOutput) {
        m.f(objectOutput, "output");
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.f1312a.size());
        for (Map.Entry entry : this.f1312a.entrySet()) {
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    public i() {
        this(i0.f());
    }
}
