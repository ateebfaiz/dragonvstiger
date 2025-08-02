package io.jsonwebtoken.impl;

import io.jsonwebtoken.Clock;
import java.util.Date;

public class FixedClock implements Clock {
    private final Date now;

    public FixedClock() {
        this(new Date());
    }

    public Date now() {
        return this.now;
    }

    public FixedClock(Date date) {
        this.now = date;
    }
}
