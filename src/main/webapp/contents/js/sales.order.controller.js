(function () {
    'use strict';

    angular.module('sales-app')
            .controller('SalesOrderController', SalesOrderController);

    SalesOrderController.$inject = ['$scope', '$interval', '$http'];

    function SalesOrderController ($scope, $interval, $http) {

        var response = $http({
            method: 'GET',
            url: 'http://localhost:8080/sales-weather/webservice/sales-order/1',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Client-Offset, Authorization',
                'Access-Control-Allow-Credentials': 'true'
                    }
        });
        response.success(function (data) {            
            $scope.sales = data;
            console.log("[main] # of items: " + data.length);
            angular.forEach(data, function (element) {
                if (element.itemSituation === 'Fechado') {
                    element.itemSituation = 'A Faturar';
                } else if (element.itemSituation === 'Baixado') {
                    element.itemSituation = 'Faturado';
                }
                if (element.idDeliverySituation === 'Aguardando Entrega') {
                    element.idDeliverySituation = 'Entrega Pendente';
                }
                if (element.idMontageSituation === 'A Executar') {
                    element.idMontageSituation = 'Montagem Pendente';
                }                
                console.log("[main] sale: " + element.itemSituation);
            });            
        });
        
        $interval(function () {
        var response = $http({
            method: 'GET',
            url: 'http://localhost:8080/sales-weather/webservice/sales-order/1',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept, Client-Offset, Authorization',
                'Access-Control-Allow-Credentials': 'true'
                    }
        });
        response.success(function (data) {            
            $scope.sales = data;
            console.log("[main] # of items: " + data.length);
            angular.forEach(data, function (element) {
                if (element.itemSituation === 'Fechado') {
                    element.itemSituation = 'A Faturar';
                } else if (element.itemSituation === 'Baixado') {
                    element.itemSituation = 'Faturado';
                }
                if (element.idDeliverySituation === 'Aguardando Entrega') {
                    element.idDeliverySituation = 'Entrega Pendente';
                }
                if (element.idMontageSituation === 'A Executar') {
                    element.idMontageSituation = 'Montagem Pendente';
                }                
                console.log("[main] sale: " + element.itemSituation);
            });            
        });           
        }, 99999);

    };
})();
