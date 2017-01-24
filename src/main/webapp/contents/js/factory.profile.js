(function () {
    'use strict';

    angular.module('sales-app')
            .controller('FactoryProfile', FactoryProfile);

    FactoryProfile.$inject = ['FactoryProfile'];

    function FactoryProfile() {
        var login;
        var password;

        return {
            setLogin: setLogin
        };

        function setLogin(login) {
            this.login = login;
        }
        
        return {
            setPassword: setPassword
        };

        function setPassword(password) {
            this.password = password;
        }        
    }

})();