var app = angular.module("springDemo",[]);

app.controller("AppCtrl", function($scope, $http){
    $scope.stocks = [];

   $scope.load = function(){
      $http({
            method: 'GET',
            url: 'http://localhost:8888/api/stocks'
        }).then(function (success){
            $scope.stocks = success.data;
        });
    }

     $scope.edit = function(stock) {
        $scope.selectedId = stock.id;
        $scope.selected = stock;
        $scope.selected.id = stock.id;
        $scope.selected.currentPrice = stock.currentPrice;
         $scope.stocksObject = stock;
      };

       $scope.getTemplate = function (stock) {
            if(stock.id == $scope.selectedId){
             return 'edit'
            } else {
             return 'display';
             }
          };


        $scope.update = function() {
              $scope.stocksObject.currentPrice = $scope.selected.currentPrice;
              $http.put('http://localhost:8888/api/stocks/' + $scope.stocksObject.id, $scope.stocksObject)
                 .then(
                     function(response){
                        $scope.selected = "";
                        $scope.selectedId = -1;
                     },
                     function(response){
                       // failure callback
                     }
                  );

        };

                $scope.create = function() {
                    $scope.stocksObject = {};
                      $scope.stocksObject.name = $scope.name;
                      $scope.stocksObject.currentPrice = $scope.currentPrice;
                      $http.post('http://localhost:8888/api/stocks/', $scope.stocksObject)
                         .then(
                             function(response){
                                $scope.name = "";
                                $scope.currentPrice = "";
                                $scope.selectedId = -1;

                                $scope.load();

                             },
                             function(response){
                               // failure callback
                             }
                          );

                };
});