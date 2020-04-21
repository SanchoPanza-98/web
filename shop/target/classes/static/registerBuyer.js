var app = angular.module("BuyerManagement", []);

app.controller("BuyerController", function($scope, $http) {

    $scope.buyers = [];
    $scope.buyerRequest = {
        buyerId: 1,
        buyerFirstName: "",
        buyerSecondName: "",
        buyerPatronymic:"",
        buyerBirthday:"",
        buyerTelephoneNum:"",
        buyerEmail:"",
        buyerLogin:"",
        buyerPassword:""
    };

    // HTTP POST methods for add buyer
    // Call: http://localhost:8080/buyer
    $scope.submitBuyer = function() {

        $http({
            method: "POST",
            url: "/api/buyer",
            data: angular.toJson($scope.buyerRequest),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    function _success(res) {
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
         $scope.buyerRequest.id = -1;
         $scope.buyerRequest.firstName = "";
         $scope.buyerRequest.secondName = "";
         $scope.buyerRequest.patronymic = "";
         $scope.buyerRequest.birthday = "";
         $scope.buyerRequest.telephoneNum = "";
         $scope.buyerRequest.email = "";
         $scope.buyerRequest.login = "";
         $scope.buyerRequest.password = "";
    };
});