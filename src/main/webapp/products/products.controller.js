angular.module('Products')
.controller('productsCtrl', function($scope,$rootScope,$http,$location) {	

	//alert("started controller");
	
	$scope.grandTotal = 0;
	$scope.dataLoading = true;
	
	//$http.get("http://localhost:3000/products")
	$http.get("http://localhost:9000/shoppingcart/secure/getProducts")
	.then(function (response) {
		//alert("in products");
		//alert(response.data);
		$scope.products = response.data;
		$scope.dataLoading = false;
	},function(response) {    		
		if(response.status=403){
			$scope.error = "Access Denied";
		}else{
			$scope.error = "Host down or Network issue!";
		}		    		
    	//alert($scope.error);    	
		$scope.dataLoading = false;
	});
	
	$scope.addToCart = function(productId,productName,price,num){
		$scope.cart = $scope.cart || [];
		//alert("called addToCart: "+productName);
		$scope.cart.push({"productId":productId,"productName":productName,"price":price,"quantity":num});
		$scope.grandTotal = $scope.grandTotal + (price*num);
		
	}
	
	$scope.Range = function(start, end) {
	    var result = [];
	    for (var i = start; i <= end; i++) {
	        result.push(i);
	    }
	    return result;
	};
	
	$scope.register = function(){		
		//alert("cart: "+$scope.cart);
		$scope.orderArray = [];		
		angular.forEach($scope.cart, function(order){			
			$scope.orderArray.push({"productId":order.productId,"productName":order.productName,"amount":order.price*order.quantity,"quantity":order.quantity});			
		});		
		//alert("array: "+$scope.orderArray);		
		//var order_id  = Math.floor(Math.random()*10000);
		//alert(order_id);		
		//var order_object = {"orderId":order_id,"loginId":$rootScope.globals.currentUser.userid,"orderDetail":$scope.orderArray};		
		var order_object = {"orderDetails":$scope.orderArray};
		//alert("order_object: "+order_object);
		var order = JSON.stringify(order_object);		
		//alert("order: "+order);		
		$http.post("http://localhost:9000/shoppingcart/secure/createOrder/"+$rootScope.globals.currentUser.userid,order)
		//$http.post("http://localhost:3000/orders",order)
		.then(function(response){
				//alert("success"+response.status);
				$location.path('/orders');			  	
			   }, 
			   function(response){
				   if(response.status=403){
						//$scope.error = "You do not have rights to perform this action !";
					   alert("You do not have rights to perform this action !");
					}else{
						$scope.error = "Host down or Network issue!";
					}				   
				   //alert("failure"+response.statusText);
			   }
		);		
		

	}

});
