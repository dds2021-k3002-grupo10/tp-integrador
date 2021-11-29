function WindowLocationUtil() {
    throw new Error( "No se puede crear una instancia de esta clase" );
}

WindowLocationUtil.redirect = function( protocol, port, path ) {
    var index = window.location.pathname.indexOf( "/", 1 );
    var context = window.location.pathname.substr( 1, index - 1 );

    protocol = WindowLocationUtil.isEnvEmpty( protocol )? window.location.protocol.substr( 0, window.location.protocol.length - 1 ): protocol;
    port = WindowLocationUtil.isEnvEmpty( port )? window.location.port: port;
    var host = window.location.hostname;

    var url = protocol + "://" + host + ":" + port + "/" + context + "/" + path;
    window.location.replace( url );
}

WindowLocationUtil.isEnvEmpty = function( entry ) {
    return entry == null || entry == '' || entry == "null";
} 

