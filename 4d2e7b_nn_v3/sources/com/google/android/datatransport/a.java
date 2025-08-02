package com.google.android.datatransport;

final class a extends Event {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f6287a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f6288b;

    /* renamed from: c  reason: collision with root package name */
    private final Priority f6289c;

    a(Integer num, Object obj, Priority priority) {
        this.f6287a = num;
        if (obj != null) {
            this.f6288b = obj;
            if (priority != null) {
                this.f6289c = priority;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f6287a;
        if (num != null ? num.equals(event.getCode()) : event.getCode() == null) {
            if (this.f6288b.equals(event.getPayload()) && this.f6289c.equals(event.getPriority())) {
                return true;
            }
        }
        return false;
    }

    public Integer getCode() {
        return this.f6287a;
    }

    public Object getPayload() {
        return this.f6288b;
    }

    public Priority getPriority() {
        return this.f6289c;
    }

    public int hashCode() {
        int i10;
        Integer num = this.f6287a;
        if (num == null) {
            i10 = 0;
        } else {
            i10 = num.hashCode();
        }
        return ((((i10 ^ 1000003) * 1000003) ^ this.f6288b.hashCode()) * 1000003) ^ this.f6289c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f6287a + ", payload=" + this.f6288b + ", priority=" + this.f6289c + "}";
    }
}
