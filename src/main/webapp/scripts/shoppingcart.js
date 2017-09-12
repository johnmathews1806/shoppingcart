//Module declaration
angular.module('Authentication', []);
angular.module('Logout', []);
var app = angular.module('shoppingcart',[
										'ngRoute',
										'ngCookies',
										'Authentication',										
										'Logout'
										]);

app.config(function($routeProvider) {	
    $routeProvider    
    .when("/home", {
        templateUrl : 'home/home.html'
        
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
    })
    .when("/logout", {
        templateUrl : 'logout/logout.html',
        controller : "logoutCtrl"
    })    
    .otherwise({
        redirectTo: '/home'
    });
    
})
.run(['$rootScope', '$location', '$cookieStore', '$http','$window',
    function ($rootScope, $location, $cookieStore, $http, $window) {
        // keep user logged in after page refresh		
        //$rootScope.globals = $cookieStore.get('globals1') || {}; //COOKIE
        //$rootScope.globals = angular.fromJson($window.localStorage.getItem('globals1')) || {}; //LOCALSTORAGE
        $rootScope.globals = angular.fromJson($window.sessionStorage.getItem('globals1')) || {}; //SESSIONSTORAGE        
        
        //alert('called on refresh '+$rootScope.globals.currentUser.userid);
        if ($rootScope.globals.currentUser) {
        	//alert('Has valid user in cookie');
            //$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
  
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
        	//if(!$rootScope.globals)
        		//$rootScope.globals= $cookies.get('globals') || {};
        	//alert('path change...1');        	
        	//alert(!$rootScope.globals.currentUser?'No Cookie':'Cookie exists');
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
            	//alert('in check');
                //$location.path('/login');
                window.location = 'index.html';
            }
        });
    }]);
