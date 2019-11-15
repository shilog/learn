/*
* 创建service
* */
app.service('loginService',function ($http) {

    //向后台发送请求执行登录
    this.login=function (username,password) {
        return $http.post('/login?username='+username+'&password='+password);
    }

    //获取用户登录名
    this.showName=function () {
        return $http.get('/login/name.shtml');
    }
})