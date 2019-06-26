app.controller('indexController',function($scope,indexService){
    $scope.findBy=function(){

        indexService.findByStatus(1).success(function (response) {

            $scope.user=response;
        })

    }

});