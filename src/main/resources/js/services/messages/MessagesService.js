app.factory( 'messagesService', [ '$resource', function( $resource ) {
    
    var service = $resource( '/api/messages/:messageId', { messageId: '@messageId' },
        {
            createMessage: { method: 'POST' }
        });
    return service;
} ] );