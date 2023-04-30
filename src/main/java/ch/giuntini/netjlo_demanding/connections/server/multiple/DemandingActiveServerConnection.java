package ch.giuntini.netjlo_demanding.connections.server.multiple;

import ch.giuntini.netjlo_base.connections.client.sockets.BaseSocket;
import ch.giuntini.netjlo_base.connections.server.sockets.CustomServerSocket;
import ch.giuntini.netjlo_base.packages.BasePackage;
import ch.giuntini.netjlo_core.interpreter.Interpretable;
import ch.giuntini.netjlo_demanding.connections.client.DemandingConnection;

import java.io.IOException;

public class DemandingActiveServerConnection
        <T extends CustomServerSocket<S>, S extends BaseSocket, P extends BasePackage, I extends Interpretable<P>>
        extends DemandingConnection<S, P, I> {

    private final DemandingMultipleServerConnection<T, S, P, I> parent;

    protected DemandingActiveServerConnection(S socket, Class<I> interpreterC, Class<P> packC, DemandingMultipleServerConnection<T, S, P, I> parent) {
        super(socket, interpreterC, packC);
        if (socket.isClosed() || !socket.isConnected()) {
            throw new IllegalStateException("The given Socket for a ActiveServerConnection must be open and connected");
        }
        this.parent = parent;
    }

    @Override
    public void disconnect() throws IOException {
        super.disconnect();
        parent.removeClosedActiveConnection(this);
    }
}
