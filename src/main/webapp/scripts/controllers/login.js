app.controller('loginCtrl', function($scope,$http) {	

	$scope.login = function() {
		$http.get("scripts/users.js").then(function (response) {		
			//alert(response.statusText);
			//alert(response.status);
			//alert(response.data.users);
			$scope.userList = response.data.users;     
			window.location = 'views/partials/home/home.html';
		}, function(response) {
			//Second function handles error
			$scope.message = "Something went wrong";
		});
	}
});

