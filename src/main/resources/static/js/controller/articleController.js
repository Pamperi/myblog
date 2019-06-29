app.controller('articleController',function ($scope,articleService) {



    //重新加载列表 数据
    $scope.reloadList=function(){
        //切换页码
        $scope.findByCriteria();
    }
//分页控件配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 3,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载
       }

    };

    $scope.art={"title":"","subTitle":""};
    $scope.findBy=function (page,size) {
        articleService.findBy(page,size).success(function (response) {
            $scope.list=response.list;
           $scope.paginationConf.totalItems=response.totalElements;//更新总记录数

        })
    }
    $scope.findByCriteria=function(){
        articleService.findByCriteria($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.art).success(function (response) {
            $scope.list=response.list;
            $scope.paginationConf.totalItems=response.totalElements;//更新总记录数
        })
    }
    $scope.save=function () {
        $scope.entity.article=editor.html();
        articleService.save($scope.entity).success(function (response) {
            if(response.success){
                alert(response.message);
                $scope.entity={};
                editor.html('');
                $scope.reloadList();
            }else{
                alert(response.message);
            }

        })
    }

    $scope.findByOne=function (id) {
        articleService.findByOne(id).success(function (response) {
            $scope.entity=response;
            editor.html($scope.entity.article);
        })
    }

    $scope.del=function (id) {
        articleService.del(id).success(function (response) {
            $scope.reloadList();
            alert(response.message);
        })
    }

})