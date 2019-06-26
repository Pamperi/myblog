app.service('indexService',function($http){
    this.findByStatus=function(status){
        return $http.get('../user/findByStatus.do?status='+status);
    }


});