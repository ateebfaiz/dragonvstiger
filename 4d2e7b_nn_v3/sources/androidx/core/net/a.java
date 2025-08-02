package androidx.core.net;

import java.io.FileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;

class a extends Socket {

    /* renamed from: androidx.core.net.a$a  reason: collision with other inner class name */
    private static class C0188a extends SocketImpl {
        C0188a(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
            this.localport = datagramSocket.getLocalPort();
            this.fd = fileDescriptor;
        }

        /* access modifiers changed from: protected */
        public void accept(SocketImpl socketImpl) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public int available() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void bind(InetAddress inetAddress, int i10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void close() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void connect(String str, int i10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void create(boolean z10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public InputStream getInputStream() {
            throw new UnsupportedOperationException();
        }

        public Object getOption(int i10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public OutputStream getOutputStream() {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void listen(int i10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void sendUrgentData(int i10) {
            throw new UnsupportedOperationException();
        }

        public void setOption(int i10, Object obj) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void connect(InetAddress inetAddress, int i10) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public void connect(SocketAddress socketAddress, int i10) {
            throw new UnsupportedOperationException();
        }
    }

    a(DatagramSocket datagramSocket, FileDescriptor fileDescriptor) {
        super(new C0188a(datagramSocket, fileDescriptor));
    }
}
