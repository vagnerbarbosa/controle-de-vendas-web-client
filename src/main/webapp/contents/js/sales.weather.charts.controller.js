(function () {
    'use strict';

    angular.module('sales-app')
            .controller('SalesWeatherChartsController', SalesWeatherChartsController);

    SalesWeatherChartsController.$inject = ['$scope', '$http'];

    function SalesWeatherChartsController($scope, $http) {

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
                $scope.addValues(element.balanceTotal);
            });
        });

        $scope.myJson = {
            type: "hbar",
            "scale-y": {
                "values": "100:35000:4200",
                "format": "R$%v",
                "negation": "currency",
                "decimals": 2,
                "decimals-separator": ",", //To set the decimal mark type.
                "item": {
                    "font-size": 9,
                    "font-family": "Georgia",
                    "font-color": "red",
                    "border-width": 1,
                    "border-color": "red",
                    "background-color": "#ffe6e6",
                    "padding": "5%",
                    "angle": -30
                },
            },
            plot: {
                "alpha": 0.7,
                "border-width": 2,
                "border-color": "black",
                "border-radius-top-left": 5,
                "border-radius-top-right": 5,
                "aspect": "cylinder",
                hoverState: {
                    "backgroundColor": "#909090"
                },
                "animation": {
                    delay: 5,
                    effect: 4,
                    method: 0,
                    sequence: 1,
                    speed: 4000

                },

            },
            "scale-x": {
                               "item": {
                   "font-size": 9 
                },
                "label": {/* Scale Title */
                    "text": "Filiais",
                },
                "labels": ["F01", "F03", "F04", "F05", "F07", "F08", "F09", "F10", "F11", "F12", "F13", "F14", "F15", "F16", "F17", "F18", "F19", "F20", "F21", "F24"],
            },
            animation: {
                "delay": 500,
                "effect": "ANIMATION_SLIDE_BOTTOM"
            },
            title: {
                backgroundColor: "transparent",
                fontColor: "black",
                text: ""
            },
            backgroundColor: "white",
            series: [
                {
                    values: [],
                    backgroundColor: "#1E90FF"
                }
            ],
            source: {
                text: "Fonte: T.I. Lojão Rio do Peixe"
            },
            noData: {
                text: "Carregando dados...",
                backgroundColor: "#1E90FF",
                fontSize: 18,
                textAlpha: .9,
                alpha: .6,
                bold: true
            },
        };

        $scope.addValues = function (value) {
            var val = value;
            console.log(val);
            $scope.myJson.series[0].values.push(val);

        };


    }
    ;


})();