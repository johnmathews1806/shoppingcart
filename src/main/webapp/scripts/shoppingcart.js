var app = angular.module('shoppingcart',['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider    
    .when("/login", {
        templateUrl : 'views/partials/login/login.html',
        controller : "loginCtrl"
    })
    .when("/aboutUs", {
        templateUrl : 'views/partials/login/aboutUs.html'
    }).otherwise({
        redirectTo: '/login'
    });
    
});
