var app = angular.module("MainPageManagement", []);

// Controller Part
app.controller("MainPageController", function($scope, $http) {


    $scope.products = [];
    $scope.productRequest = {
        productCost: "",
        productName: ""
    };

    // Now load the data from server
    _refreshProductData();

    // Private Method
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/api/products
    function _refreshProductData() {
        $http({
            method: 'GET',
            url: '/api/products'
        }).then(
            function(res) { // success
                $scope.products = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    $scope.buy = function(){
    }

    function _success(res) {
        _refreshProductData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.productRequest.cost = "";
        $scope.productRequest.productName = ""
    };
});