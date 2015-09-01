app.controller( 'MessagesController', [ '$scope', '$rootScope', '$routeParams', 'messagesService', 'messages', function( $scope, $rootScope, $routeParams, messagesService, messages ) {
    
    /*$scope.ripperForm = ripperDetails;
    $scope.ripperNameBackup = $scope.ripperForm.name;
    
    $scope.isValidXpto = function( $value ) {
        if( $value == null )
            return true;
        else
            return $value.replace( /[^0-9]/g, '' ).length === 0;
    };
    
    $scope.clearForm = function () {
        $scope.ripperForm.name = $scope.ripperNameBackup;
        $scope.updateRipperForm.$setPristine();
    };*/
    
    console.log( messages.length );
    
    $scope.messages = messages;
    
    $scope.createMessage = function() {
        var response = messagesService.createMessage( $scope.messageForm );
        
        response.$promise.then(
            function( ripper ) {
                $scope.messages = messagesService.query();
            },
            function( reason ) {
                console.error( reason );
            }
        );
        
        
        //$rootScope.$broadcast( 'success', 'The ripper was updated succefully.' );
        
        // Update variables to be able to clear
        //$scope.ripperNameBackup = $scope.ripperForm.name;
        
        // Set the form to untouched
        //$scope.updateRipperForm.$setPristine();
    };
    
} ] );