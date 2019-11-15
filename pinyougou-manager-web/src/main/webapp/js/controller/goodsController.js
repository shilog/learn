/*****
 * 定义一个控制层 controller
 * 发送HTTP请求从后台获取数据
 ****/
app.controller("goodsController",function($scope,$http,$controller,goodsService,itemCatService){

    //继承父控制器
    $controller("baseController",{$scope:$scope});

    //定义状态集合      0       1         2        3
    $scope.status=["未审核","审核通过","审核不通过","关闭"];

    //商品分类集合   从数据库查询，然后循环封装
    $scope.itemCatShowList={}

    //修改状态
    $scope.updateStatus=function(status){
        goodsService.updateStatus($scope.selectids,status).success(function (response) {
           if(response.success){
               $scope.reloadList();
               $scope.selectids=[];
           }else {
               alert(response.message);
           }
        });
    }

    $scope.getItemCatShowList=function(){
        itemCatService.findAllList().success(function (response) {
            //迭代集合组装数据
            for(var i=0;i<response.length;i++){
                var key=response[i].id;
                var value=response[i].name;
                $scope.itemCatShowList[key]=value;
            }
        });
    }

    //获取所有的Goods信息
    $scope.getPage=function(page,size){
        //发送请求获取数据
        goodsService.findAll(page,size,$scope.searchEntity).success(function(response){
            //集合数据
            $scope.list = response.list;
            //分页数据
            $scope.paginationConf.totalItems=response.total;
        });
    }

    //添加或者修改方法
    $scope.save = function(){
        var result = null;
        if($scope.entity.id!=null){
            //执行修改数据
            result = goodsService.update($scope.entity);
        }else{
            //增加操作
            result = goodsService.add($scope.entity);
        }
        //判断操作流程
        result.success(function(response){
            //判断执行状态
            if(response.success){
                //重新加载新的数据
                $scope.reloadList();
            }else{
                //打印错误消息
                alert(response.message);
            }
        });
    }

    //根据ID查询信息
    $scope.getById=function(id){
        goodsService.findOne(id).success(function(response){
            //将后台的数据绑定到前台
            $scope.entity=response;
        });
    }

    //批量删除
    $scope.delete=function(){
        goodsService.delete($scope.selectids).success(function(response){
            //判断删除状态
            if(response.success){
                $scope.reloadList();
                $scope.selectids=[];
            }else{
                alert(response.message);
            }
        });
    }
});
