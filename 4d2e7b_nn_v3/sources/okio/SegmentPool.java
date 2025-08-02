package okio;

import d.a;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.m;

public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    private static final int MAX_SIZE = 65536;
    private static final AtomicReference<Segment>[] hashBuckets;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i10 = 0; i10 < highestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        Thread currentThread = Thread.currentThread();
        m.e(currentThread, "Thread.currentThread()");
        return hashBuckets[(int) (currentThread.getId() & (((long) HASH_BUCKET_COUNT) - 1))];
    }

    public static final void recycle(Segment segment) {
        boolean z10;
        AtomicReference<Segment> firstRef;
        Segment segment2;
        int i10;
        m.f(segment, "segment");
        if (segment.next == null && segment.prev == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.shared && (segment2 = firstRef.get()) != LOCK) {
            if (segment2 != null) {
                i10 = segment2.limit;
            } else {
                i10 = 0;
            }
            if (i10 < MAX_SIZE) {
                segment.next = segment2;
                segment.pos = 0;
                segment.limit = i10 + 8192;
                if (!a.a((firstRef = INSTANCE.firstRef()), segment2, segment)) {
                    segment.next = null;
                }
            }
        }
    }

    public static final Segment take() {
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment andSet = firstRef.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            firstRef.set((Object) null);
            return new Segment();
        }
        firstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getByteCount() {
        Segment segment = firstRef().get();
        if (segment != null) {
            return segment.limit;
        }
        return 0;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
