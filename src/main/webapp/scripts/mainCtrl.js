app.controller('mainCtrl', function($scope) {
	$scope.firstName= "John";
	$scope.lastName= "Doe";
	$scope.countries="[{name:'Jani',country:'Norway'}, {name:'Hege',country:'Sweden'}, {name:'Kai',country:'Denmark'}]";
});

app.directive("w3TestDirective", function() {
	return {
		template : "Code moved into modules!"
	};
});