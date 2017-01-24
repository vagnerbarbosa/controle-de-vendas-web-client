(function() {
  'use strict';
  angular.module('sales-app', ['ngRoute', 'zingchart-angularjs', 'ui.router.title']);  

  angular.module('sales-app')
    .run(function($rootScope, $route, $routeParams, $location, $cookieStore, $http) {
        
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }        
             
      $rootScope.$on('$routeChangeStart',function(evt,next,current){
          
            // redirect to login page if not logged in
            if ($location.path() !== '/' && !$rootScope.globals.currentUser) {
                $location.path('/');
            }          
        console.log('Nome do Evento:'+evt.name);
        console.log('Próxima Rota:'+ angular.toJson(next));
        console.log('Rota Atual:'+ angular.toJson(current)); 
      });
      
      $rootScope.$route = $route;
      $rootScope.$location = $location;
      $rootScope.$routeParams = $routeParams;
    });
})();