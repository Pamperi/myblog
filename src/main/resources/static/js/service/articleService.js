app.service('articleService',function ($http) {
    this.findBy=function (page,size) {
        return $http.get('/article/findBy.do?page='+page+"&size="+size);
    }
    this.findByCriteria=function (page,size,article) {
        return $http.post('/article/findByCriteria.do?page='+page+"&size="+size,article);
    }
    this.save=function (article) {
        return $http.post('/article/save.do',article);
    }
    this.del=function (id) {
        return $http.get('/article/del.do?id='+id);
    }
    this.findByOne=function (id) {
        return $http.get('/article/findByOne.do?id='+id);
    }
});