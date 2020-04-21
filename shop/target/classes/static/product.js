var app = angular.module("ProductManagement", []);

// Controller Part
app.controller("ProductController", function($scope, $http) {


    $scope.products = [];
    $scope.productRequest = {
        productId: 0,
        productCost: "",
        productName: ""
    };

    // Now load the data from server
    _refreshProductData();

    // HTTP POST/PUT methods for add/edit product
    // Call: http://localhost:8080/api/product
    $scope.submitProduct = function() {

        var method = "";
        var url = "";

        if ($scope.productRequest.id == -1) {
            method = "POST";
            url = '/api/product';
        } else {
            method = "PUT";
            url = '/api/product/'+$scope.productRequest.id;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.productRequest),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createProduct = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete product by Id
    // Call: http://localhost:8080/api/product/{id}
    $scope.deleteProduct = function(product) {
        $http({
            method: 'DELETE',
            url: '/product/' + product.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editProduct = function(product) {
        $scope.productRequest.id = product.id;
        $scope.productRequest.cost = product.cost;
        $scope.productRequest.productName = product.productName;
    };

    // Private Method
    // HTTP GET- get all products collection
    // Call: http://localhost:8080/employees
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
        $scope.productRequest.id = -1;
        $scope.productRequest.cost = "";
        $scope.productRequest.productName = "";
    };
});