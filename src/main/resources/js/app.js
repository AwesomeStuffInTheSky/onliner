var app = angular.module( 'OnlinerApp', [ 'ngResource', 'ngRoute' ] );

app.config( [ '$routeProvider', function( $routeProvider ) {
    $routeProvider
        .when( '/', {
            controller: 'MessagesController',
            templateUrl: '/messages/messages.html',
            resolve: {
                messages: function( $route, messagesService ) {
                    return messagesService.query().$promise;
                }
            }
        } )
        .otherwise( {
            redirectTo: '/'
        } );
} ] );