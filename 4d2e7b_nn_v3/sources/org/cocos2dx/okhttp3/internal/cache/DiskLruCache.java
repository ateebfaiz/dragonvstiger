package org.cocos2dx.okhttp3.internal.cache;

import io.jsonwebtoken.JwtParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.cocos2dx.okhttp3.internal.Util;
import org.cocos2dx.okhttp3.internal.io.FileSystem;
import org.cocos2dx.okhttp3.internal.platform.Platform;
import org.cocos2dx.okio.BufferedSink;
import org.cocos2dx.okio.Okio;
import org.cocos2dx.okio.Sink;
import org.cocos2dx.okio.Source;

public final class DiskLruCache implements Closeable, Flushable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final long ANY_SEQUENCE_NUMBER = -1;
    private static final String CLEAN = "CLEAN";
    private static final String DIRTY = "DIRTY";
    static final String JOURNAL_FILE = "journal";
    static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    static final String JOURNAL_FILE_TEMP = "journal.tmp";
    static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
    static final String MAGIC = "libcore.io.DiskLruCache";
    private static final String READ = "READ";
    private static final String REMOVE = "REMOVE";
    static final String VERSION_1 = "1";
    private final int appVersion;
    private final Runnable cleanupRunnable = new a();
    boolean closed;
    final File directory;
    private final Executor executor;
    final FileSystem fileSystem;
    boolean hasJournalErrors;
    boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    BufferedSink journalWriter;
    final LinkedHashMap<String, d> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    private long maxSize;
    boolean mostRecentRebuildFailed;
    boolean mostRecentTrimFailed;
    private long nextSequenceNumber = 0;
    int redundantOpCount;
    private long size = 0;
    final int valueCount;

    public final class Editor {
        private boolean done;
        final d entry;
        final boolean[] written;

        class a extends a {
            a(Sink sink) {
                super(sink);
            }

            /* access modifiers changed from: protected */
            public void a(IOException iOException) {
                synchronized (DiskLruCache.this) {
                    Editor.this.detach();
                }
            }
        }

        Editor(d dVar) {
            boolean[] zArr;
            this.entry = dVar;
            if (dVar.f1579e) {
                zArr = null;
            } else {
                zArr = new boolean[DiskLruCache.this.valueCount];
            }
            this.written = zArr;
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        if (this.entry.f1580f == this) {
                            DiskLruCache.this.completeEdit(this, false);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|10|11) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abortUnlessCommitted() {
            /*
                r3 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0014 }
                if (r1 != 0) goto L_0x0016
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r1 = r3.entry     // Catch:{ all -> 0x0014 }
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r1 = r1.f1580f     // Catch:{ all -> 0x0014 }
                if (r1 != r3) goto L_0x0016
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0016 }
                r2 = 0
                r1.completeEdit(r3, r2)     // Catch:{ IOException -> 0x0016 }
                goto L_0x0016
            L_0x0014:
                r1 = move-exception
                goto L_0x0018
            L_0x0016:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                return
            L_0x0018:
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        if (this.entry.f1580f == this) {
                            DiskLruCache.this.completeEdit(this, true);
                        }
                        this.done = true;
                    } else {
                        throw new IllegalStateException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            if (this.entry.f1580f == this) {
                int i10 = 0;
                while (true) {
                    DiskLruCache diskLruCache = DiskLruCache.this;
                    if (i10 < diskLruCache.valueCount) {
                        try {
                            diskLruCache.fileSystem.delete(this.entry.f1578d[i10]);
                        } catch (IOException unused) {
                        }
                        i10++;
                    } else {
                        this.entry.f1580f = null;
                        return;
                    }
                }
            }
        }

        public Sink newSink(int i10) {
            synchronized (DiskLruCache.this) {
                try {
                    if (!this.done) {
                        d dVar = this.entry;
                        if (dVar.f1580f != this) {
                            Sink blackhole = Okio.blackhole();
                            return blackhole;
                        }
                        if (!dVar.f1579e) {
                            this.written[i10] = true;
                        }
                        a aVar = new a(DiskLruCache.this.fileSystem.sink(dVar.f1578d[i10]));
                        return aVar;
                    }
                    throw new IllegalStateException();
                } catch (FileNotFoundException unused) {
                    return Okio.blackhole();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.cocos2dx.okio.Source newSource(int r5) {
            /*
                r4 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x0021 }
                if (r1 != 0) goto L_0x0027
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r1 = r4.entry     // Catch:{ all -> 0x0021 }
                boolean r2 = r1.f1579e     // Catch:{ all -> 0x0021 }
                r3 = 0
                if (r2 == 0) goto L_0x0025
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r2 = r1.f1580f     // Catch:{ all -> 0x0021 }
                if (r2 == r4) goto L_0x0013
                goto L_0x0025
            L_0x0013:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r2 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0023 }
                org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r2.fileSystem     // Catch:{ FileNotFoundException -> 0x0023 }
                java.io.File[] r1 = r1.f1577c     // Catch:{ FileNotFoundException -> 0x0023 }
                r5 = r1[r5]     // Catch:{ FileNotFoundException -> 0x0023 }
                org.cocos2dx.okio.Source r5 = r2.source(r5)     // Catch:{ FileNotFoundException -> 0x0023 }
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r5
            L_0x0021:
                r5 = move-exception
                goto L_0x002d
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                return r3
            L_0x0027:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0021 }
                r5.<init>()     // Catch:{ all -> 0x0021 }
                throw r5     // Catch:{ all -> 0x0021 }
            L_0x002d:
                monitor-exit(r0)     // Catch:{ all -> 0x0021 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):org.cocos2dx.okio.Source");
        }
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j10, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j10;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                Util.closeQuietly((Closeable) closeQuietly);
            }
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.edit(this.key, this.sequenceNumber);
        }

        public long getLength(int i10) {
            return this.lengths[i10];
        }

        public Source getSource(int i10) {
            return this.sources[i10];
        }

        public String key() {
            return this.key;
        }
    }

    class a implements Runnable {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r6.f1569a;
            r1.mostRecentRebuildFailed = true;
            r1.journalWriter = org.cocos2dx.okio.Okio.buffer(org.cocos2dx.okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0017 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r0 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                boolean r2 = r1.initialized     // Catch:{ all -> 0x0011 }
                r3 = 0
                r4 = 1
                r2 = r2 ^ r4
                boolean r5 = r1.closed     // Catch:{ all -> 0x0011 }
                r2 = r2 | r5
                if (r2 == 0) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x0011:
                r1 = move-exception
                goto L_0x003d
            L_0x0013:
                r1.trimToSize()     // Catch:{ IOException -> 0x0017 }
                goto L_0x001b
            L_0x0017:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                r1.mostRecentTrimFailed = r4     // Catch:{ all -> 0x0011 }
            L_0x001b:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                boolean r1 = r1.journalRebuildRequired()     // Catch:{ IOException -> 0x002d }
                if (r1 == 0) goto L_0x003b
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r1.rebuildJournal()     // Catch:{ IOException -> 0x002d }
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x002d }
                r1.redundantOpCount = r3     // Catch:{ IOException -> 0x002d }
                goto L_0x003b
            L_0x002d:
                org.cocos2dx.okhttp3.internal.cache.DiskLruCache r1 = org.cocos2dx.okhttp3.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0011 }
                r1.mostRecentRebuildFailed = r4     // Catch:{ all -> 0x0011 }
                org.cocos2dx.okio.Sink r2 = org.cocos2dx.okio.Okio.blackhole()     // Catch:{ all -> 0x0011 }
                org.cocos2dx.okio.BufferedSink r2 = org.cocos2dx.okio.Okio.buffer((org.cocos2dx.okio.Sink) r2)     // Catch:{ all -> 0x0011 }
                r1.journalWriter = r2     // Catch:{ all -> 0x0011 }
            L_0x003b:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                return
            L_0x003d:
                monitor-exit(r0)     // Catch:{ all -> 0x0011 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.a.run():void");
        }
    }

    class b extends a {
        b(Sink sink) {
            super(sink);
        }

        /* access modifiers changed from: protected */
        public void a(IOException iOException) {
            DiskLruCache.this.hasJournalErrors = true;
        }
    }

    class c implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        final Iterator f1571a;

        /* renamed from: b  reason: collision with root package name */
        Snapshot f1572b;

        /* renamed from: c  reason: collision with root package name */
        Snapshot f1573c;

        c() {
            this.f1571a = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        }

        /* renamed from: a */
        public Snapshot next() {
            if (hasNext()) {
                Snapshot snapshot = this.f1572b;
                this.f1573c = snapshot;
                this.f1572b = null;
                return snapshot;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f1572b != null) {
                return true;
            }
            synchronized (DiskLruCache.this) {
                try {
                    if (DiskLruCache.this.closed) {
                        return false;
                    }
                    while (this.f1571a.hasNext()) {
                        d dVar = (d) this.f1571a.next();
                        if (dVar.f1579e) {
                            Snapshot c10 = dVar.c();
                            if (c10 != null) {
                                this.f1572b = c10;
                                return true;
                            }
                        }
                    }
                    return false;
                } finally {
                }
            }
        }

        public void remove() {
            Snapshot snapshot = this.f1573c;
            if (snapshot != null) {
                try {
                    DiskLruCache.this.remove(snapshot.key);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f1573c = null;
                    throw th;
                }
                this.f1573c = null;
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private final class d {

        /* renamed from: a  reason: collision with root package name */
        final String f1575a;

        /* renamed from: b  reason: collision with root package name */
        final long[] f1576b;

        /* renamed from: c  reason: collision with root package name */
        final File[] f1577c;

        /* renamed from: d  reason: collision with root package name */
        final File[] f1578d;

        /* renamed from: e  reason: collision with root package name */
        boolean f1579e;

        /* renamed from: f  reason: collision with root package name */
        Editor f1580f;

        /* renamed from: g  reason: collision with root package name */
        long f1581g;

        d(String str) {
            this.f1575a = str;
            int i10 = DiskLruCache.this.valueCount;
            this.f1576b = new long[i10];
            this.f1577c = new File[i10];
            this.f1578d = new File[i10];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append(JwtParser.SEPARATOR_CHAR);
            int length = sb2.length();
            for (int i11 = 0; i11 < DiskLruCache.this.valueCount; i11++) {
                sb2.append(i11);
                this.f1577c[i11] = new File(DiskLruCache.this.directory, sb2.toString());
                sb2.append(".tmp");
                this.f1578d[i11] = new File(DiskLruCache.this.directory, sb2.toString());
                sb2.setLength(length);
            }
        }

        private IOException a(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            if (strArr.length == DiskLruCache.this.valueCount) {
                int i10 = 0;
                while (i10 < strArr.length) {
                    try {
                        this.f1576b[i10] = Long.parseLong(strArr[i10]);
                        i10++;
                    } catch (NumberFormatException unused) {
                        throw a(strArr);
                    }
                }
                return;
            }
            throw a(strArr);
        }

        /* access modifiers changed from: package-private */
        public Snapshot c() {
            Source source;
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.valueCount];
                long[] jArr = (long[]) this.f1576b.clone();
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    try {
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        if (i11 >= diskLruCache.valueCount) {
                            return new Snapshot(this.f1575a, this.f1581g, sourceArr, jArr);
                        }
                        sourceArr[i11] = diskLruCache.fileSystem.source(this.f1577c[i11]);
                        i11++;
                    } catch (FileNotFoundException unused) {
                        while (true) {
                            DiskLruCache diskLruCache2 = DiskLruCache.this;
                            if (i10 >= diskLruCache2.valueCount || (source = sourceArr[i10]) == null) {
                                try {
                                    diskLruCache2.removeEntry(this);
                                    return null;
                                } catch (IOException unused2) {
                                    return null;
                                }
                            } else {
                                Util.closeQuietly((Closeable) source);
                                i10++;
                            }
                        }
                    }
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(BufferedSink bufferedSink) {
            for (long writeDecimalLong : this.f1576b) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }
    }

    DiskLruCache(FileSystem fileSystem2, File file, int i10, int i11, long j10, Executor executor2) {
        this.fileSystem = fileSystem2;
        this.directory = file;
        this.appVersion = i10;
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
        this.valueCount = i11;
        this.maxSize = j10;
        this.executor = executor2;
    }

    private synchronized void checkNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public static DiskLruCache create(FileSystem fileSystem2, File file, int i10, int i11, long j10) {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i11 > 0) {
            return new DiskLruCache(fileSystem2, file, i10, i11, j10, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    private BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer((Sink) new b(this.fileSystem.appendingSink(this.journalFile)));
    }

    private void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<d> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i10 = 0;
            if (next.f1580f == null) {
                while (i10 < this.valueCount) {
                    this.size += next.f1576b[i10];
                    i10++;
                }
            } else {
                next.f1580f = null;
                while (i10 < this.valueCount) {
                    this.fileSystem.delete(next.f1577c[i10]);
                    this.fileSystem.delete(next.f1578d[i10]);
                    i10++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|(1:20)(1:21)|22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r9.redundantOpCount = r0 - r9.lruEntries.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        if (r1.exhausted() == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        rebuildJournal();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r9.journalWriter = newJournalWriter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:24:0x007c=Splitter:B:24:0x007c, B:17:0x005f=Splitter:B:17:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readJournal() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            org.cocos2dx.okhttp3.internal.io.FileSystem r1 = r9.fileSystem
            java.io.File r2 = r9.journalFile
            org.cocos2dx.okio.Source r1 = r1.source(r2)
            org.cocos2dx.okio.BufferedSource r1 = org.cocos2dx.okio.Okio.buffer((org.cocos2dx.okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x005d }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x007c
            int r7 = r9.appVersion     // Catch:{ all -> 0x005d }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x005d }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            int r4 = r9.valueCount     // Catch:{ all -> 0x005d }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x005d }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x007c
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005f }
            r9.readJournalLine(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            r0 = move-exception
            goto L_0x00aa
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r2 = r9.lruEntries     // Catch:{ all -> 0x005d }
            int r2 = r2.size()     // Catch:{ all -> 0x005d }
            int r0 = r0 - r2
            r9.redundantOpCount = r0     // Catch:{ all -> 0x005d }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x005d }
            if (r0 != 0) goto L_0x0072
            r9.rebuildJournal()     // Catch:{ all -> 0x005d }
            goto L_0x0078
        L_0x0072:
            org.cocos2dx.okio.BufferedSink r0 = r9.newJournalWriter()     // Catch:{ all -> 0x005d }
            r9.journalWriter = r0     // Catch:{ all -> 0x005d }
        L_0x0078:
            org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x005d }
            r7.append(r2)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r3)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r5)     // Catch:{ all -> 0x005d }
            r7.append(r0)     // Catch:{ all -> 0x005d }
            r7.append(r6)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x005d }
            r4.<init>(r0)     // Catch:{ all -> 0x005d }
            throw r4     // Catch:{ all -> 0x005d }
        L_0x00aa:
            org.cocos2dx.okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private void readJournalLine(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith(REMOVE)) {
                    this.lruEntries.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            d dVar = this.lruEntries.get(str2);
            if (dVar == null) {
                dVar = new d(str2);
                this.lruEntries.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith(CLEAN)) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f1579e = true;
                dVar.f1580f = null;
                dVar.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith(DIRTY)) {
                dVar.f1580f = new Editor(dVar);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith(READ)) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private void validateKey(String str) {
        if (!LEGAL_KEY_PATTERN.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized void close() throws IOException {
        try {
            if (this.initialized) {
                if (!this.closed) {
                    for (d dVar : (d[]) this.lruEntries.values().toArray(new d[this.lruEntries.size()])) {
                        Editor editor = dVar.f1580f;
                        if (editor != null) {
                            editor.abort();
                        }
                    }
                    trimToSize();
                    this.journalWriter.close();
                    this.journalWriter = null;
                    this.closed = true;
                    return;
                }
            }
            this.closed = true;
        } finally {
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void completeEdit(org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = r10.entry     // Catch:{ all -> 0x002a }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r1 = r0.f1580f     // Catch:{ all -> 0x002a }
            if (r1 != r10) goto L_0x00f8
            r1 = 0
            if (r11 == 0) goto L_0x004a
            boolean r2 = r0.f1579e     // Catch:{ all -> 0x002a }
            if (r2 != 0) goto L_0x004a
            r2 = r1
        L_0x000f:
            int r3 = r9.valueCount     // Catch:{ all -> 0x002a }
            if (r2 >= r3) goto L_0x004a
            boolean[] r3 = r10.written     // Catch:{ all -> 0x002a }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x002a }
            if (r3 == 0) goto L_0x0030
            org.cocos2dx.okhttp3.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x002a }
            java.io.File[] r4 = r0.f1578d     // Catch:{ all -> 0x002a }
            r4 = r4[r2]     // Catch:{ all -> 0x002a }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x002a }
            if (r3 != 0) goto L_0x002d
            r10.abort()     // Catch:{ all -> 0x002a }
            monitor-exit(r9)
            return
        L_0x002a:
            r10 = move-exception
            goto L_0x00fe
        L_0x002d:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x0030:
            r10.abort()     // Catch:{ all -> 0x002a }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r11.<init>()     // Catch:{ all -> 0x002a }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x002a }
            r11.append(r2)     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x002a }
            r10.<init>(r11)     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x004a:
            int r10 = r9.valueCount     // Catch:{ all -> 0x002a }
            if (r1 >= r10) goto L_0x0082
            java.io.File[] r10 = r0.f1578d     // Catch:{ all -> 0x002a }
            r10 = r10[r1]     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x007a
            org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x002a }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x007f
            java.io.File[] r2 = r0.f1577c     // Catch:{ all -> 0x002a }
            r2 = r2[r1]     // Catch:{ all -> 0x002a }
            org.cocos2dx.okhttp3.internal.io.FileSystem r3 = r9.fileSystem     // Catch:{ all -> 0x002a }
            r3.rename(r10, r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f1576b     // Catch:{ all -> 0x002a }
            r3 = r10[r1]     // Catch:{ all -> 0x002a }
            org.cocos2dx.okhttp3.internal.io.FileSystem r10 = r9.fileSystem     // Catch:{ all -> 0x002a }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x002a }
            long[] r10 = r0.f1576b     // Catch:{ all -> 0x002a }
            r10[r1] = r5     // Catch:{ all -> 0x002a }
            long r7 = r9.size     // Catch:{ all -> 0x002a }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.size = r7     // Catch:{ all -> 0x002a }
            goto L_0x007f
        L_0x007a:
            org.cocos2dx.okhttp3.internal.io.FileSystem r2 = r9.fileSystem     // Catch:{ all -> 0x002a }
            r2.delete(r10)     // Catch:{ all -> 0x002a }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x004a
        L_0x0082:
            int r10 = r9.redundantOpCount     // Catch:{ all -> 0x002a }
            r1 = 1
            int r10 = r10 + r1
            r9.redundantOpCount = r10     // Catch:{ all -> 0x002a }
            r10 = 0
            r0.f1580f = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r0.f1579e     // Catch:{ all -> 0x002a }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00be
            r0.f1579e = r1     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r1 = "CLEAN"
            org.cocos2dx.okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r1 = r0.f1575a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r0.d(r10)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
            if (r11 == 0) goto L_0x00dc
            long r10 = r9.nextSequenceNumber     // Catch:{ all -> 0x002a }
            r1 = 1
            long r1 = r1 + r10
            r9.nextSequenceNumber = r1     // Catch:{ all -> 0x002a }
            r0.f1581g = r10     // Catch:{ all -> 0x002a }
            goto L_0x00dc
        L_0x00be:
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r10 = r9.lruEntries     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f1575a     // Catch:{ all -> 0x002a }
            r10.remove(r11)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r11 = "REMOVE"
            org.cocos2dx.okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            r10.writeByte(r3)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            java.lang.String r11 = r0.f1575a     // Catch:{ all -> 0x002a }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x002a }
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.writeByte(r2)     // Catch:{ all -> 0x002a }
        L_0x00dc:
            org.cocos2dx.okio.BufferedSink r10 = r9.journalWriter     // Catch:{ all -> 0x002a }
            r10.flush()     // Catch:{ all -> 0x002a }
            long r10 = r9.size     // Catch:{ all -> 0x002a }
            long r0 = r9.maxSize     // Catch:{ all -> 0x002a }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ef
            boolean r10 = r9.journalRebuildRequired()     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x00f6
        L_0x00ef:
            java.util.concurrent.Executor r10 = r9.executor     // Catch:{ all -> 0x002a }
            java.lang.Runnable r11 = r9.cleanupRunnable     // Catch:{ all -> 0x002a }
            r10.execute(r11)     // Catch:{ all -> 0x002a }
        L_0x00f6:
            monitor-exit(r9)
            return
        L_0x00f8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002a }
            r10.<init>()     // Catch:{ all -> 0x002a }
            throw r10     // Catch:{ all -> 0x002a }
        L_0x00fe:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.completeEdit(org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    public void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public Editor edit(String str) throws IOException {
        return edit(str, -1);
    }

    public synchronized void evictAll() throws IOException {
        try {
            initialize();
            for (d removeEntry : (d[]) this.lruEntries.values().toArray(new d[this.lruEntries.size()])) {
                removeEntry(removeEntry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            this.journalWriter.flush();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x004d }
            r3.checkNotClosed()     // Catch:{ all -> 0x004d }
            r3.validateKey(r4)     // Catch:{ all -> 0x004d }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r3.lruEntries     // Catch:{ all -> 0x004d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x004d }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r0     // Catch:{ all -> 0x004d }
            r1 = 0
            if (r0 == 0) goto L_0x0051
            boolean r2 = r0.f1579e     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x001a
            goto L_0x0051
        L_0x001a:
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Snapshot r0 = r0.c()     // Catch:{ all -> 0x004d }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.redundantOpCount     // Catch:{ all -> 0x004d }
            int r1 = r1 + 1
            r3.redundantOpCount = r1     // Catch:{ all -> 0x004d }
            org.cocos2dx.okio.BufferedSink r1 = r3.journalWriter     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "READ"
            org.cocos2dx.okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x004d }
            r2 = 32
            org.cocos2dx.okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x004d }
            org.cocos2dx.okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x004d }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x004d }
            boolean r4 = r3.journalRebuildRequired()     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x004f
            java.util.concurrent.Executor r4 = r3.executor     // Catch:{ all -> 0x004d }
            java.lang.Runnable r1 = r3.cleanupRunnable     // Catch:{ all -> 0x004d }
            r4.execute(r1)     // Catch:{ all -> 0x004d }
            goto L_0x004f
        L_0x004d:
            r4 = move-exception
            goto L_0x0053
        L_0x004f:
            monitor-exit(r3)
            return r0
        L_0x0051:
            monitor-exit(r3)
            return r1
        L_0x0053:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.get(java.lang.String):org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Snapshot");
    }

    public File getDirectory() {
        return this.directory;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    public synchronized void initialize() throws IOException {
        try {
            if (!this.initialized) {
                if (this.fileSystem.exists(this.journalFileBackup)) {
                    if (this.fileSystem.exists(this.journalFile)) {
                        this.fileSystem.delete(this.journalFileBackup);
                    } else {
                        this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                    }
                }
                if (this.fileSystem.exists(this.journalFile)) {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                }
                rebuildJournal();
                this.initialized = true;
            }
        } catch (IOException e10) {
            Platform platform = Platform.get();
            platform.log(5, "DiskLruCache " + this.directory + " is corrupt: " + e10.getMessage() + ", removing", e10);
            delete();
            this.closed = false;
        } catch (Throwable th) {
            this.closed = false;
            throw th;
        }
    }

    public synchronized boolean isClosed() {
        return this.closed;
    }

    /* access modifiers changed from: package-private */
    public boolean journalRebuildRequired() {
        int i10 = this.redundantOpCount;
        if (i10 < 2000 || i10 < this.lruEntries.size()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0071, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00be, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void rebuildJournal() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            org.cocos2dx.okio.BufferedSink r0 = r6.journalWriter     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x000c
            r0.close()     // Catch:{ all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r0 = move-exception
            goto L_0x00bf
        L_0x000c:
            org.cocos2dx.okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x0009 }
            org.cocos2dx.okio.Sink r0 = r0.sink(r1)     // Catch:{ all -> 0x0009 }
            org.cocos2dx.okio.BufferedSink r0 = org.cocos2dx.okio.Okio.buffer((org.cocos2dx.okio.Sink) r0)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "libcore.io.DiskLruCache"
            org.cocos2dx.okio.BufferedSink r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r2 = 10
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "1"
            org.cocos2dx.okio.BufferedSink r1 = r0.writeUtf8(r1)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.appVersion     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            org.cocos2dx.okio.BufferedSink r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            int r1 = r6.valueCount     // Catch:{ all -> 0x0071 }
            long r3 = (long) r1     // Catch:{ all -> 0x0071 }
            org.cocos2dx.okio.BufferedSink r1 = r0.writeDecimalLong(r3)     // Catch:{ all -> 0x0071 }
            r1.writeByte(r2)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r1 = r6.lruEntries     // Catch:{ all -> 0x0071 }
            java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0071 }
        L_0x004d:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0071 }
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0071 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r3 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r3     // Catch:{ all -> 0x0071 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r4 = r3.f1580f     // Catch:{ all -> 0x0071 }
            r5 = 32
            if (r4 == 0) goto L_0x0073
            java.lang.String r4 = "DIRTY"
            org.cocos2dx.okio.BufferedSink r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = r3.f1575a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0071:
            r1 = move-exception
            goto L_0x00bb
        L_0x0073:
            java.lang.String r4 = "CLEAN"
            org.cocos2dx.okio.BufferedSink r4 = r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r4.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r3.f1575a     // Catch:{ all -> 0x0071 }
            r0.writeUtf8(r4)     // Catch:{ all -> 0x0071 }
            r3.d(r0)     // Catch:{ all -> 0x0071 }
            r0.writeByte(r2)     // Catch:{ all -> 0x0071 }
            goto L_0x004d
        L_0x0088:
            r0.close()     // Catch:{ all -> 0x0009 }
            org.cocos2dx.okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x0009 }
            boolean r0 = r0.exists(r1)     // Catch:{ all -> 0x0009 }
            if (r0 == 0) goto L_0x009e
            org.cocos2dx.okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFile     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.journalFileBackup     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
        L_0x009e:
            org.cocos2dx.okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileTmp     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r6.journalFile     // Catch:{ all -> 0x0009 }
            r0.rename(r1, r2)     // Catch:{ all -> 0x0009 }
            org.cocos2dx.okhttp3.internal.io.FileSystem r0 = r6.fileSystem     // Catch:{ all -> 0x0009 }
            java.io.File r1 = r6.journalFileBackup     // Catch:{ all -> 0x0009 }
            r0.delete(r1)     // Catch:{ all -> 0x0009 }
            org.cocos2dx.okio.BufferedSink r0 = r6.newJournalWriter()     // Catch:{ all -> 0x0009 }
            r6.journalWriter = r0     // Catch:{ all -> 0x0009 }
            r0 = 0
            r6.hasJournalErrors = r0     // Catch:{ all -> 0x0009 }
            r6.mostRecentRebuildFailed = r0     // Catch:{ all -> 0x0009 }
            monitor-exit(r6)
            return
        L_0x00bb:
            r0.close()     // Catch:{ all -> 0x0009 }
            throw r1     // Catch:{ all -> 0x0009 }
        L_0x00bf:
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.rebuildJournal():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r6) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0028 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0028 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0028 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r5.lruEntries     // Catch:{ all -> 0x0028 }
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0028 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r6 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r6     // Catch:{ all -> 0x0028 }
            r0 = 0
            if (r6 != 0) goto L_0x0017
            monitor-exit(r5)
            return r0
        L_0x0017:
            boolean r6 = r5.removeEntry(r6)     // Catch:{ all -> 0x0028 }
            if (r6 == 0) goto L_0x002a
            long r1 = r5.size     // Catch:{ all -> 0x0028 }
            long r3 = r5.maxSize     // Catch:{ all -> 0x0028 }
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x002a
            r5.mostRecentTrimFailed = r0     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r6 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r5)
            return r6
        L_0x002c:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean removeEntry(d dVar) throws IOException {
        Editor editor = dVar.f1580f;
        if (editor != null) {
            editor.detach();
        }
        for (int i10 = 0; i10 < this.valueCount; i10++) {
            this.fileSystem.delete(dVar.f1577c[i10]);
            long j10 = this.size;
            long[] jArr = dVar.f1576b;
            this.size = j10 - jArr[i10];
            jArr[i10] = 0;
        }
        this.redundantOpCount++;
        this.journalWriter.writeUtf8(REMOVE).writeByte(32).writeUtf8(dVar.f1575a).writeByte(10);
        this.lruEntries.remove(dVar.f1575a);
        if (journalRebuildRequired()) {
            this.executor.execute(this.cleanupRunnable);
        }
        return true;
    }

    public synchronized void setMaxSize(long j10) {
        this.maxSize = j10;
        if (this.initialized) {
            this.executor.execute(this.cleanupRunnable);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new c();
    }

    /* access modifiers changed from: package-private */
    public void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            removeEntry(this.lruEntries.values().iterator().next());
        }
        this.mostRecentTrimFailed = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.cocos2dx.okhttp3.internal.cache.DiskLruCache.Editor edit(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0022 }
            r5.checkNotClosed()     // Catch:{ all -> 0x0022 }
            r5.validateKey(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r0 = r5.lruEntries     // Catch:{ all -> 0x0022 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0022 }
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = (org.cocos2dx.okhttp3.internal.cache.DiskLruCache.d) r0     // Catch:{ all -> 0x0022 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0026
            if (r0 == 0) goto L_0x0024
            long r3 = r0.f1581g     // Catch:{ all -> 0x0022 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0026
            goto L_0x0024
        L_0x0022:
            r6 = move-exception
            goto L_0x0077
        L_0x0024:
            monitor-exit(r5)
            return r2
        L_0x0026:
            if (r0 == 0) goto L_0x002e
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r7 = r0.f1580f     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x002e
            monitor-exit(r5)
            return r2
        L_0x002e:
            boolean r7 = r5.mostRecentTrimFailed     // Catch:{ all -> 0x0022 }
            if (r7 != 0) goto L_0x006e
            boolean r7 = r5.mostRecentRebuildFailed     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0037
            goto L_0x006e
        L_0x0037:
            org.cocos2dx.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0022 }
            java.lang.String r8 = "DIRTY"
            org.cocos2dx.okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0022 }
            r8 = 32
            org.cocos2dx.okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            org.cocos2dx.okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0022 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0022 }
            org.cocos2dx.okio.BufferedSink r7 = r5.journalWriter     // Catch:{ all -> 0x0022 }
            r7.flush()     // Catch:{ all -> 0x0022 }
            boolean r7 = r5.hasJournalErrors     // Catch:{ all -> 0x0022 }
            if (r7 == 0) goto L_0x0059
            monitor-exit(r5)
            return r2
        L_0x0059:
            if (r0 != 0) goto L_0x0065
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d r0 = new org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d     // Catch:{ all -> 0x0022 }
            r0.<init>(r6)     // Catch:{ all -> 0x0022 }
            java.util.LinkedHashMap<java.lang.String, org.cocos2dx.okhttp3.internal.cache.DiskLruCache$d> r7 = r5.lruEntries     // Catch:{ all -> 0x0022 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0022 }
        L_0x0065:
            org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor r6 = new org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0022 }
            r6.<init>(r0)     // Catch:{ all -> 0x0022 }
            r0.f1580f = r6     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r6
        L_0x006e:
            java.util.concurrent.Executor r6 = r5.executor     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r7 = r5.cleanupRunnable     // Catch:{ all -> 0x0022 }
            r6.execute(r7)     // Catch:{ all -> 0x0022 }
            monitor-exit(r5)
            return r2
        L_0x0077:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cocos2dx.okhttp3.internal.cache.DiskLruCache.edit(java.lang.String, long):org.cocos2dx.okhttp3.internal.cache.DiskLruCache$Editor");
    }
}
