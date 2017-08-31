app.controller('loginCtrl', function($scope,$http) {	

	$scope.login = function() {
		$http.get("scripts/users.js").then(function (response) {		
			//alert(response.statusText);
			//alert(response.status);
			//alert(response.data.users);
			$scope.userList = response.data.users;
			//alert($scope.userList[0].name);
			//alert($scope.password);
			var validUser = false;
			$scope.message="incorrect credentials";
			for(var count = 0; count < $scope.userList.length; count++){
				//alert("response name: "+$scope.userList[count].name);
				//alert("response password: "+$scope.userList[count].password);
				//alert("entered name: "+$scope.userid);
				//alert("entered password: "+$scope.password);
				//alert($scope.password==$scope.userList[count].password);
				if($scope.password==$scope.userList[count].password && $scope.userid==$scope.userList[count].name){
					//alert("validated");
					validUser = true;
					break;					
				}		

			}
			//alert(validUser);
			if(validUser==true){
				//alert("in true");
				window.location = 'views/partials/home/home.html';
			}else{
				//alert("in false");
				window.location = 'index.html';
			}
			//
		}, function(response) {
			//Second function handles error
			$scope.message = "Something went wrong";
		});
	}
});

