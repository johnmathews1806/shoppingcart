//Module declaration
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Logout', []);

angular.module('login',[
                                  'ngRoute',
                                  'ngCookies',
                                  'Authentication',
                                  'Home',
                                  'Logout'
                                  ])

.config(function($routeProvider) {
    $routeProvider    
    .when("/login", {
        templateUrl : 'login/login.html',
        controller : "loginCtrl"
    })
    .when("/home", {
        templateUrl : 'app1.html',
        controller : "homeCtrl"
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
    .when("/aboutUs", {
        templateUrl : 'aboutUs.html'
    })
     .when("/logout", {
        templateUrl : 'aboutUs.html',
        controller : "logoutCtrl"
    }).otherwise({
        redirectTo: '/login'
    });
    
})

.run(['$rootScope', '$location', '$cookies', '$http',
    function ($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.get('globals') || {};
        //if ($rootScope.globals.currentUser) {
          //  $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        //}
  
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
        	alert('path change...1');        	
        	alert(!$rootScope.globals.currentUser?'No Cookie':'Cookie exists');
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
            	//alert('in check');
                $location.path('/login');
            }
        });
    }]);

    
    
