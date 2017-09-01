//alert("authentication service started");
angular.module('login')

.factory('Authentication', ['$http',function($http) {
    return{
    
    Login : function(userid,password,callback){
    	//alert("called Login service");		
    	//alert(userid);
    	//alert(password);
    	var status={"valid":"false","message":""};
    	var validUser = false;
    	$http.get("scripts/users.js")
    	//When Response is OK
    		.then(function (response) {
    			//alert("in http");
    			//alert(response.data.users);    			
    			for(var count = 0; count < response.data.users.length; count++){    	    		
    	    		//alert("loop: "+count);
    				if(password==response.data.users[count].password && 
    						angular.lowercase(userid)==angular.lowercase(response.data.users[count].name)){    					
    					validUser = true;
    					break;					
    				}    				
    			}    			
    			
    			if(validUser){
    				//alert("valid");
    	    		status.valid=true;
    	    	}else{
    	    		//alert("not valid");
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
        	//alert(status.message);        	
        	callback(status);
		});    	

    }
    }
}]);

