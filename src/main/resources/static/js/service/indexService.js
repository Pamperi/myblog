app.service('indexService',function($http){
    this.findByStatus=function(status){
        return $http.get('../user/findByStatus.do?status='+status);
    }

    this.findAll=function(){
        return $http.get('../../user/findAll.do');
    }
    this.findById=function (id) {
        return $http.get('../../user/findById.do?id='+id);
    }
    this.save=function (entity) {
        return $http.post('../../user/save.do',entity);
    }
    this.delete=function (id) {
        return $http.get('../../user/deleteById.do?id='+id);
    }
    this.update=function (oldPassWord,newPassWord) {
        return $http.get('../../password/save.do?oldPassWord='+oldPassWord+'&newPassWord='+newPassWord);
    }
});