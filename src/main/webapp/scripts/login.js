angular.module('Authentication', []);
var app = angular.module('login',[
                                  'ngRoute',
                                  'ngCookies',
                                  'Authentication'                                  
                                  ]);

app.config(function($routeProvider) {
    $routeProvider    
    .when("/login", {
        templateUrl : 'login/login.html',
        controller : "loginCtrl"
    })
    //.when("/app", {
      //  templateUrl : 'app.html',
        //controller : "navCtrl"
    //})
    .when("/aboutUs", {
        templateUrl : 'aboutUs.html'
    }).otherwise({
        redirectTo: '/login'
    });
    
});

    
    
