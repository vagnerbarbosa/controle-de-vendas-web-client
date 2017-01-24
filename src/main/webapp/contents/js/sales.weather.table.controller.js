(function () {
    'use strict';

    angular.module('sales-app')
            .controller('SalesWeatherTableController', SalesWeatherTableController);

    SalesWeatherTableController.$inject = ['$scope', '$interval', '$http'];

    function SalesWeatherTableController($scope, $interval, $http) {

        var response = $http({
            method: 'GET',
            url: 'http://localhost:8080/sales-weather/webservice/sales/',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Client-Offset, Authorization',
                'Access-Control-Allow-Credentials': 'true'
            }
        });

        response.success(function (data) {
            $scope.sales = data;
            $scope.length = data.length;
            console.log("[main] # of items: " + data.length);
            angular.forEach(data, function (element) {
                console.log("[main] sale: " + element.branchNumber);
            });
        });

        $scope.calcProdSaleTotal = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.prodSaleTotal);
            });
            return total;
        };

        $scope.calcProdDevolutionTotal = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.prodDevolutionTotal);
            });
            return total / $scope.length;
        };

        $scope.calcTotalservTotalSale = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.prodBalanceTotal);
            });
            return total;
        };

        $scope.calcTotalservTotalDevolution = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.servBalanceTotal);
            });
            return total;
        };

        $scope.calcRechargeTotal = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.rechargeTotal);
            });
            return total;
        };

        $scope.calcTotalSales = function () {
            var total = 0;
            angular.forEach($scope.sales, function (element) {
                total = total + (element.balanceTotal);
            });
            return total;
        };

        $interval(function () {
            var response = $http({
                method: 'GET',
                url: 'http://localhost:8080/sales-weather/webservice/sales/',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Client-Offset, Authorization',
                'Access-Control-Allow-Credentials': 'true'
            }

            });
            response.success(function (data) {
                $scope.sales = data;
                $scope.length = data.length;
                console.log("[main] # of items: " + data.length);
                angular.forEach(data, function (element) {
                    console.log("[main] sale: " + element.branchNumber);
                });

                //Totalizadores
                $scope.calcProdSaleTotal();
                $scope.calcProdDevolutionTotal();
                $scope.calcTotalservTotalSale();
                $scope.calcTotalservTotalDevolution();
                $scope.calcRechargeTotal();
                $scope.calcTotalSales();

            });
            response.error(function (status) {
                console.log("AJAX failed to get data, status=" + status);
            });
        }, 99999);

    }
    ;

})();
