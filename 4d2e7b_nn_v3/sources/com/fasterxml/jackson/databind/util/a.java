package com.fasterxml.jackson.databind.util;

import java.lang.annotation.Annotation;

public interface a {
    boolean a(Class cls);

    boolean b(Class[] clsArr);

    Annotation get(Class cls);

    int size();
}
