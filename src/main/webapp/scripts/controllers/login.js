app.controller('loginCtrl', function($scope,$http,Authentication) {	

	$scope.login = function() {
		alert("in login");
		Authentication.Login($scope.userid, $scope.password,function(status){
			//alert("in callback2");
			//alert(status.valid);
			//alert(status.message);
			if(status.valid){
				window.location = 'app.html';
			}else{
				$scope.message = status.message;
			}
		});		
	}
});
/*
.service('Authentication', function($http) {
    this.myFunc = function (x) {
        return x.toString(16);
    }
    
    this.VerifyCall = function(){
    	return 'Log in called';
    }
    
    this.Login = function(userid,password,callback){
    	alert("called show1");		
    	alert(userid);
    	alert(password);
    	var status={"valid":"false","message":""};
    	var validUser = false;
    	$http.get("scripts/users.js")
    	//When Response is OK
    		.then(function (response) {
    			alert("in http");
    			//alert(response.data.users);    			
    			for(var count = 0; count < response.data.users.length; count++){    	    		
    	    		//alert("loop: "+count);
    				if(password==response.data.users[count].password && 
    						angular.lowercase(userid)==angular.lowercase(response.data.users[count].name)){
    					alert("validated");
    					validUser = true;
    					break;					
    				}    				
    			}    			
    			
    			if(validUser){
    				alert("valid");
    	    		status.valid=true;
    	    	}else{
    	    		alert("not valid");
    	    		status.valid=false;
    	    		status.message="Incorrect Credentials";
    	    	}	    	    	
    	    	alert(status.message);    	    	
    	    	callback(status);
    	}
        	//When Response is NOT OK
    		,function(response) {    		
    		status.valid=false;
    		status.message = "Something went wrong";       	
        	alert(status.message);        	
        	callback(status);
		});    	

    }
});
*/

