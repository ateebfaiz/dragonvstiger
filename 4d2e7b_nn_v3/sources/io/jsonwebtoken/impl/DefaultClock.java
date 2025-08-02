package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

public class DefaultClock implements Clock {
    public static final Clock INSTANCE = new DefaultClock();

    public Date now() {
        return new Date();
    }
}
