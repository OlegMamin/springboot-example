var app = angular.module('conRestApp', ['ngResource']);

app.factory("usersContracts", function($resource) {
    return $resource("http://localhost:8090/api/contracts/find");
});

app.controller("ContractsCtrl", function($scope, usersContracts) {
    usersContracts.query(function(data) {
        $scope.usersContracts = data;
    }, function(err) {
        console.error("Error occured: ", err);
    });
});