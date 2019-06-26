app.controller('indexController',function($scope,indexService,$window){
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