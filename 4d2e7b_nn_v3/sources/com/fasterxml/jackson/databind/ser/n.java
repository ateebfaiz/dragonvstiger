package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.introspect.s;
import com.fasterxml.jackson.databind.introspect.v;
import java.io.Serializable;

public abstract class n extends v implements Serializable {
    protected n(s sVar) {
        super(sVar.j());
    }

    protected n(n nVar) {
        super((v) nVar);
    }
}
