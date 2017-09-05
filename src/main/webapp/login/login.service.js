//alert("authentication service started");
angular.module('login')

.factory('AuthenticationService', ['$http','$rootScope','$cookies',function($http,$rootScope,$cookies) {
    return{
    
    	Login : function(userid,password,callback){
    		//alert("called Login service");		
    		//alert(userid);
    		//alert(password);
    		var status={"valid":false,"message":""};
    		//var validUser = false;    	
    		$http.get("scripts/users.js")
    		//When Response is OK
    		.then(function (response) {
    			//alert("in http");
    			//alert(response.data.users);    			
    			for(var count = 0; count < response.data.users.length; count++){    	    		
    	    		//alert("loop: "+count);
    				if(password==response.data.users[count].password && 
    						angular.lowercase(userid)==angular.lowercase(response.data.users[count].name)){    					
    					//validUser = true;
    					status.valid=true;
    					break;					
    				}    				
    			}       				    	
    			
    			if(!status.valid){
    				status.message="Incorrect Credentials";
    			}
    	    	//alert(status.message);    	    	
    	    	callback(status);
    		}
        	//When Response is NOT OK
    		,function(response) {    		
    		status.message = "Host down or Network issue!";    		
        	//alert(status.message);        	
        	callback(status);
		});    	

    },    
    	
    	SetCredentials : function (userid,password) {
    		var authdata = userid + ':' + password;

    		$rootScope.globals = {
    			currentUser: {
    				userid: userid,
    				authdata: authdata
    			}
        	};

        	//$http.defaults.headers.common['Authorization'] = 'Basic ' + authdata; // jshint ignore:line
        	$cookies.put('globals', $rootScope.globals);
    	}    
    }
}]);

