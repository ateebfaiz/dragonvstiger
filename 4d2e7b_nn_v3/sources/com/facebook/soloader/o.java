package com.facebook.soloader;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedByInterruptException;
import okhttp3.internal.ws.WebSocketProtocol;

public abstract class o {

    protected static class a extends UnsatisfiedLinkError {
        a(String str) {
            super(str);
        }
    }

    public static String[] a(g gVar) {
        if (gVar instanceof h) {
            return c((h) gVar);
        }
        return b(gVar);
    }

    private static String[] b(g gVar) {
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        String str;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        String str2;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long d10;
        long j27;
        long j28;
        g gVar2 = gVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        long g10 = g(gVar2, allocate, 0);
        if (g10 == 1179403647) {
            boolean z10 = true;
            if (h(gVar2, allocate, 4) != 1) {
                z10 = false;
            }
            if (h(gVar2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z10) {
                j10 = g(gVar2, allocate, 28);
            } else {
                j10 = d(gVar2, allocate, 32);
            }
            if (z10) {
                j11 = (long) f(gVar2, allocate, 44);
            } else {
                j11 = (long) f(gVar2, allocate, 56);
            }
            if (z10) {
                j12 = 42;
            } else {
                j12 = 54;
            }
            int f10 = f(gVar2, allocate, j12);
            if (j11 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                if (z10) {
                    j28 = g(gVar2, allocate, 32);
                } else {
                    j28 = d(gVar2, allocate, 40);
                }
                if (z10) {
                    j11 = g(gVar2, allocate, j28 + 28);
                } else {
                    j11 = g(gVar2, allocate, j28 + 44);
                }
            }
            long j29 = j10;
            long j30 = 0;
            while (true) {
                if (j30 >= j11) {
                    j13 = 0;
                    break;
                }
                if (z10) {
                    j27 = g(gVar2, allocate, j29);
                } else {
                    j27 = g(gVar2, allocate, j29);
                }
                if (j27 != 2) {
                    j29 += (long) f10;
                    j30++;
                } else if (z10) {
                    j13 = g(gVar2, allocate, j29 + 4);
                } else {
                    j13 = d(gVar2, allocate, j29 + 8);
                }
            }
            if (j13 != 0) {
                long j31 = j13;
                int i10 = 0;
                long j32 = 0;
                while (true) {
                    if (z10) {
                        j14 = g(gVar2, allocate, j31);
                    } else {
                        j14 = d(gVar2, allocate, j31);
                    }
                    if (j14 == 1) {
                        if (i10 != Integer.MAX_VALUE) {
                            i10++;
                            str = "malformed DT_NEEDED section";
                        } else {
                            throw new a("malformed DT_NEEDED section");
                        }
                    } else if (j14 == 5) {
                        str = "malformed DT_NEEDED section";
                        if (z10) {
                            d10 = g(gVar2, allocate, j31 + 4);
                        } else {
                            d10 = d(gVar2, allocate, j31 + 8);
                        }
                        j32 = d10;
                    } else {
                        str = "malformed DT_NEEDED section";
                    }
                    if (z10) {
                        j15 = 8;
                    } else {
                        j15 = 16;
                    }
                    j31 += j15;
                    if (j14 == 0) {
                        if (j32 != 0) {
                            long j33 = j10;
                            int i11 = 0;
                            while (true) {
                                if (((long) i11) >= j11) {
                                    j16 = j13;
                                    j17 = 0;
                                    j18 = 0;
                                    break;
                                }
                                if (z10) {
                                    j22 = g(gVar2, allocate, j33);
                                } else {
                                    j22 = g(gVar2, allocate, j33);
                                }
                                if (j22 == 1) {
                                    if (z10) {
                                        j23 = j11;
                                        j24 = g(gVar2, allocate, j33 + 8);
                                    } else {
                                        j23 = j11;
                                        j24 = d(gVar2, allocate, j33 + 16);
                                    }
                                    if (z10) {
                                        j16 = j13;
                                        j25 = g(gVar2, allocate, j33 + 20);
                                    } else {
                                        j16 = j13;
                                        j25 = d(gVar2, allocate, j33 + 40);
                                    }
                                    if (j24 <= j32 && j32 < j25 + j24) {
                                        if (z10) {
                                            j26 = g(gVar2, allocate, j33 + 4);
                                        } else {
                                            j26 = d(gVar2, allocate, j33 + 8);
                                        }
                                        j18 = j26 + (j32 - j24);
                                        j17 = 0;
                                    }
                                } else {
                                    j23 = j11;
                                    j16 = j13;
                                }
                                j33 += (long) f10;
                                i11++;
                                j11 = j23;
                                j13 = j16;
                            }
                            if (j18 != j17) {
                                String[] strArr = new String[i10];
                                long j34 = j16;
                                int i12 = 0;
                                while (true) {
                                    if (z10) {
                                        j19 = g(gVar2, allocate, j34);
                                    } else {
                                        j19 = d(gVar2, allocate, j34);
                                    }
                                    if (j19 == 1) {
                                        if (z10) {
                                            j21 = g(gVar2, allocate, j34 + 4);
                                        } else {
                                            j21 = d(gVar2, allocate, j34 + 8);
                                        }
                                        strArr[i12] = e(gVar2, allocate, j21 + j18);
                                        if (i12 != Integer.MAX_VALUE) {
                                            i12++;
                                            str2 = str;
                                        } else {
                                            throw new a(str);
                                        }
                                    } else {
                                        str2 = str;
                                    }
                                    if (z10) {
                                        j20 = 8;
                                    } else {
                                        j20 = 16;
                                    }
                                    j34 += j20;
                                    if (j19 != 0) {
                                        str = str2;
                                    } else if (i12 == i10) {
                                        return strArr;
                                    } else {
                                        throw new a(str2);
                                    }
                                }
                            } else {
                                throw new a("did not find file offset of DT_STRTAB table");
                            }
                        } else {
                            throw new a("Dynamic section string-table not found");
                        }
                    }
                }
            } else {
                throw new a("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new a("file is not ELF: magic is 0x" + Long.toHexString(g10) + ", it should be " + Long.toHexString(1179403647));
        }
    }

    private static String[] c(h hVar) {
        int i10 = 0;
        while (true) {
            try {
                return b(hVar);
            } catch (ClosedByInterruptException e10) {
                i10++;
                if (i10 <= 4) {
                    Thread.interrupted();
                    m.c("MinElf", "retrying extract_DT_NEEDED due to ClosedByInterruptException", e10);
                    hVar.a();
                } else {
                    throw e10;
                }
            }
        }
    }

    private static long d(g gVar, ByteBuffer byteBuffer, long j10) {
        i(gVar, byteBuffer, 8, j10);
        return byteBuffer.getLong();
    }

    private static String e(g gVar, ByteBuffer byteBuffer, long j10) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short h10 = h(gVar, byteBuffer, j10);
            if (h10 == 0) {
                return sb2.toString();
            }
            sb2.append((char) h10);
            j10 = j11;
        }
    }

    private static int f(g gVar, ByteBuffer byteBuffer, long j10) {
        i(gVar, byteBuffer, 2, j10);
        return byteBuffer.getShort() & com.alibaba.pdns.net.f.a.f18108a;
    }

    private static long g(g gVar, ByteBuffer byteBuffer, long j10) {
        i(gVar, byteBuffer, 4, j10);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static short h(g gVar, ByteBuffer byteBuffer, long j10) {
        i(gVar, byteBuffer, 1, j10);
        return (short) (byteBuffer.get() & 255);
    }

    private static void i(g gVar, ByteBuffer byteBuffer, int i10, long j10) {
        int o10;
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        while (byteBuffer.remaining() > 0 && (o10 = gVar.o(byteBuffer, j10)) != -1) {
            j10 += (long) o10;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new a("ELF file truncated");
    }
}
