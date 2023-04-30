package ch.giuntini.netjlo_demanding.connections.server.single;

import ch.giuntini.netjlo_base.connections.client.sockets.BaseSocket;
import ch.giuntini.netjlo_base.connections.server.sockets.CustomServerSocket;
import ch.giuntini.netjlo_base.packages.BasePackage;
import ch.giuntini.netjlo_core.connections.server.single.ServerConnectionBuilder;
import ch.giuntini.netjlo_core.interpreter.Interpretable;

public class DemandingServerConnectionBuilder
        <T extends CustomServerSocket<S>, S extends BaseSocket, P extends BasePackage, I extends Interpretable<P>>
        extends ServerConnectionBuilder<T, S, P, I> {

    public DemandingServerConnectionBuilder() {
    }

    @Override
    public DemandingServerConnection<T, S, P, I> build() {
        checkState();
        return new DemandingServerConnection<>(serverSocket, interpreterC, packC);
    }
}
