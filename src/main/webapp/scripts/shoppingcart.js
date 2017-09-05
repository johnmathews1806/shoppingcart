var app = angular.module('shoppingcart',['ngRoute']);

app.config(function($routeProvider) {	
    $routeProvider    
    .when("/home", {
        templateUrl : 'home/home.html',
        controller : "navCtrl"
    })
    .when("/menu1", {
        templateUrl : 'views/partials/menu1.html'
    })
    .when("/menu2", {
        templateUrl : 'views/partials/menu1.html'
    })
    .when("/menu3", {
        templateUrl : 'views/partials/menu1.html'
    })
    .when("/menu4", {
        templateUrl : 'views/partials/menu1.html'
    })
    .when("/menu5", {
        templateUrl : 'views/partials/menu1.html'
    })
    .when("/menu6", {
        templateUrl : 'views/partials/menu1.html'
    }).otherwise({
        redirectTo: '/home'
    });
    
});
