app.controller('indexController',function($scope,indexService,$window,uploadService,articleService){

    $scope.findByOne=function(id){
        articleService.findByOne(id).success(function (response) {
            $scope.entity=response;

        })
    }

    //分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    }

    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByAll();
    }
    $scope.findByAll=function(){
        articleService.findBy($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage).success(function (response) {
            $scope.list=response.list;
            $scope.paginationConf.totalItems=response.totalElements;//更新总记录数
        })
    }


    $scope.findBy=function(){
        indexService.findByStatus(1).success(function (response) {
            $scope.user=response;
        })
    }
    $scope.status=['未使用','使用中'];//状态
    $scope.findAll=function(){
        indexService.findAll().success(function (response) {
            $scope.userList=response;
        })
    }
    $scope.findById=function (id) {
        indexService.findById(id).success(function (response) {
            $scope.entity=response;
        })
    }
    $scope.save=function () {
        indexService.save($scope.entity).success(function (response) {
            $scope.reloadRoute();
        })
    }

$scope.delete=function (id) {
    indexService.delete(id).success(function () {
        $scope.reloadRoute();
    })
}
//刷新页面
$scope.reloadRoute=function () {
    $window.location.reload();
}

//上传图片
    $scope.uploadFile=function(){
        uploadService.uploadFile().success(
            function(response){
                if(response.success){
                    alert(response.message);
                    $scope.entity.image= response.message;
                }else{
                    alert(response.message);
                }
            }
        );
    }
    $scope.uploadFile1=function(){
        uploadService.uploadFile1().success(
            function(response){
                if(response.success){
                    alert(response.message);
                    $scope.entity.background= response.message;
                }else{
                    alert(response.message);
                }
            }
        );
    }
$scope.update=function () {

        if($scope.newPassWord!=$scope.newPassWord1){
            $scope.oldPassWord='';
            $scope.newPassWord='';
            $scope.newPassWord1='';
            return alert("两次密码不一样");

        }
    indexService.update($scope.oldPassWord,$scope.newPassWord).success(function (response) {
       alert(response.message);
       $scope.oldPassWord='';
        $scope.newPassWord='';
        $scope.newPassWord1='';

    })
}
});