app.service("uploadService",function($http){
	this.uploadFile=function(){
		var formData=new FormData();
	    formData.append("file",file.files[0]);   
		return $http({
            method:'POST',
            url:"../../upload/upload.do",
            data: formData,
            headers: {'Content-Type':undefined},	//不设置默认为json 
            transformRequest: angular.identity    //对表单进行二进制序列化
            });		
	}
    this.uploadFile1=function(){
        var formData=new FormData();
        formData.append("file",file1.files[0]);
        return $http({
            method:'POST',
            url:"../../upload/upload.do",
            data: formData,
            headers: {'Content-Type':undefined},	//不设置默认为json
            transformRequest: angular.identity    //对表单进行二进制序列化
        });
    }
});
