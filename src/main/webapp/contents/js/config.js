(function() {
  'use strict';

  angular.module('sales-app')
  
    .config('$routeProvider',function($routeProvider, $locationProvider, $httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
    $httpProvider.defaults.headers.common["Accept"] = "application/json";
    $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
            
      $routeProvider
        .when('/', {
          templateUrl: 'user/home.html',
          controller: 'LoginController'
          
        })      
        .when('/vendas-tabelas', {
          templateUrl: 'user/sales.html',
          controller: 'SalesWeatherTableController'
        })
        .when('/vendas-graficos', {         
          templateUrl: 'user/sales-chart.html',
          controller: 'SalesWeatherChartsController'
        })        
        .when('/acompanhamento-vendas', {            
          templateUrl: 'user/sales-order.html',
          controller: 'SalesOrderController'
        }).otherwise({
          redirectTo: '/'
        });
    });
})();