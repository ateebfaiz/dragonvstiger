package ha;

import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public abstract class g {
    public static List a(List list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) != null) {
                X509Certificate a10 = h.a(((a) list.get(i10)).a());
                if (a10 != null) {
                    linkedList.add(a10);
                } else {
                    throw new ParseException("Invalid X.509 certificate at position " + i10, 0);
                }
            }
        }
        return linkedList;
    }

    public static List b(List list) {
        if (list == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        int i10 = 0;
        while (i10 < list.size()) {
            Object obj = list.get(i10);
            if (obj == null) {
                throw new ParseException("The X.509 certificate at position " + i10 + " must not be null", 0);
            } else if (obj instanceof String) {
                linkedList.add(new a((String) obj));
                i10++;
            } else {
                throw new ParseException("The X.509 certificate at position " + i10 + " must be encoded as a Base64 string", 0);
            }
        }
        return linkedList;
    }
}
