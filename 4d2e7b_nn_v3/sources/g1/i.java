package g1;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.core.api.Address;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import s1.a;
import u1.n;

public class i extends h {

    /* renamed from: d  reason: collision with root package name */
    public Selector f21593d;

    /* renamed from: e  reason: collision with root package name */
    public SocketChannel f21594e;

    public String b() {
        return "TcpChannlClient";
    }

    public void g(Context context) {
        a.a("TcpChannlClient", "tcp disconnectImp");
        try {
            Selector selector = this.f21593d;
            if (selector != null && selector.isOpen()) {
                this.f21593d.close();
                this.f21593d = null;
            }
            SocketChannel socketChannel = this.f21594e;
            if (socketChannel != null && socketChannel.isConnected()) {
                this.f21594e.finishConnect();
                this.f21594e.close();
                this.f21594e = null;
            }
        } catch (Throwable th) {
            a.h("TcpChannlClient", "disconnect failed " + th.getMessage());
        }
    }

    public boolean k(Context context, String str, int i10) {
        if (!n.b(context)) {
            a.b("TcpChannlClient", "can't connect, network is disConnected");
            return false;
        }
        a.a("TcpChannlClient", "tcp connect " + str + ":" + i10);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i10);
        SocketChannel open = SocketChannel.open();
        this.f21594e = open;
        open.configureBlocking(false);
        Selector open2 = Selector.open();
        this.f21593d = open2;
        this.f21594e.register(open2, 8);
        this.f21594e.connect(inetSocketAddress);
        this.f21593d.select();
        Set<SelectionKey> selectedKeys = this.f21593d.selectedKeys();
        if (selectedKeys == null) {
            a.a("TcpChannlClient", "selectionKeys is null");
            return false;
        } else if (selectedKeys.isEmpty()) {
            a.a("TcpChannlClient", "selectionKeys is empty");
            return false;
        } else {
            SelectionKey next = selectedKeys.iterator().next();
            if (next == null || !next.isConnectable()) {
                a.a("TcpChannlClient", "selectionKey is null");
                return false;
            } else if (!next.isConnectable()) {
                a.a("TcpChannlClient", "selectionKey is disConnected");
                return false;
            } else {
                SocketChannel socketChannel = (SocketChannel) next.channel();
                if (!socketChannel.isConnectionPending()) {
                    a.a("TcpChannlClient", "finish connect");
                    return false;
                }
                socketChannel.finishConnect();
                socketChannel.register(this.f21593d, 1);
                a.a("TcpChannlClient", "tcp connect success");
                return true;
            }
        }
    }

    public boolean m(Context context, byte[] bArr) {
        SocketChannel socketChannel = this.f21594e;
        if (socketChannel == null || !socketChannel.isConnected()) {
            return false;
        }
        this.f21594e.write(ByteBuffer.wrap(bArr));
        return true;
    }

    public List n(Context context) {
        return t(context);
    }

    public byte[] o(Context context) {
        try {
            if (!j()) {
                a.a("TcpChannlClient", "tcp is not connecting");
                return null;
            }
            this.f21593d.select();
            if (!this.f21593d.isOpen()) {
                a.a("TcpChannlClient", "selector is closed");
                return null;
            }
            Set<SelectionKey> selectedKeys = this.f21593d.selectedKeys();
            if (selectedKeys == null) {
                a.h("TcpChannlClient", "selectionKeys is null");
                c(context);
                return null;
            } else if (selectedKeys.isEmpty()) {
                a.h("TcpChannlClient", "selectionKeys is empty");
                c(context);
                return null;
            } else {
                Iterator<SelectionKey> it = selectedKeys.iterator();
                if (!it.hasNext()) {
                    a.h("TcpChannlClient", "selectionKeys hasn't next");
                    c(context);
                    return null;
                }
                SelectionKey next = it.next();
                if (next == null) {
                    a.h("TcpChannlClient", "selectionKey is null");
                    c(context);
                    return null;
                } else if (!next.isReadable()) {
                    a.h("TcpChannlClient", "selectionKey is disReadable");
                    c(context);
                    return null;
                } else {
                    SocketChannel socketChannel = (SocketChannel) next.channel();
                    if (!socketChannel.isConnected()) {
                        a.h("TcpChannlClient", "socketChannel is disConnected");
                        c(context);
                        return null;
                    }
                    if (j()) {
                        ByteBuffer allocate = ByteBuffer.allocate(2);
                        int read = socketChannel.read(allocate);
                        if (read < 0) {
                            a.h("TcpChannlClient", "read ahead length = " + read);
                            c(context);
                            return null;
                        }
                        byte[] array = allocate.array();
                        int i10 = ByteBuffer.wrap(array).getShort() & 16383;
                        if (i10 == 0) {
                            a.h("TcpChannlClient", "read total length = " + i10);
                            c(context);
                            return null;
                        }
                        ByteBuffer allocate2 = ByteBuffer.allocate(i10 - 2);
                        while (allocate2.hasRemaining()) {
                            long read2 = (long) socketChannel.read(allocate2);
                            if (read2 < 0) {
                                a.h("TcpChannlClient", "read content n = " + read2);
                                a.h("TcpChannlClient", "read content position = " + allocate2.position());
                                a.h("TcpChannlClient", "read content limit = " + allocate2.limit());
                                c(context);
                                return null;
                            }
                        }
                        byte[] array2 = allocate2.array();
                        byte[] bArr = new byte[i10];
                        System.arraycopy(array, 0, bArr, 0, array.length);
                        System.arraycopy(array2, 0, bArr, array.length, array2.length);
                        return bArr;
                    }
                    return null;
                }
            }
        } catch (IOException e10) {
            a.h("TcpChannlClient", "receive IOException " + e10.getMessage());
            c(context);
        } catch (Throwable th) {
            a.h("TcpChannlClient", "receive failed " + th.getMessage());
            c(context);
        }
    }

    public final List t(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(u(context));
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public final Set u(Context context) {
        Set C = n.C(context);
        Address a10 = x1.a.a();
        int c10 = a10.c();
        if (c10 <= 0) {
            return C;
        }
        String a11 = a10.a();
        if (!TextUtils.isEmpty(a11)) {
            C.add(a11 + ":" + c10);
        }
        String b10 = a10.b();
        if (!TextUtils.isEmpty(b10)) {
            C.add(b10 + ":" + c10);
        }
        return C;
    }
}
