module NETJLO_demanding {
    requires NETJLO_core;
    requires NETJLO_base;

    exports ch.giuntini.netjlo_demanding.connections.client;
    exports ch.giuntini.netjlo_demanding.connections.server.multiple;
    exports ch.giuntini.netjlo_demanding.connections.server.single;
    exports ch.giuntini.netjlo_demanding.threads;
}