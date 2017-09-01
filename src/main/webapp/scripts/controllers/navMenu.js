app
.controller('navCtrl', function ($scope,hexafy ) {
	//alert("in controller");
	$scope.message="Home Page1";
	//alert(hexafy.myFunc(255));
	$scope.hex = hexafy.myFunc(450);
	//alert($scope.hex);

})

.service('hexafy', function() {
	//alert("in service");
    this.myFunc = function (x) {
        return x.toString(16);        
    }
});
	  