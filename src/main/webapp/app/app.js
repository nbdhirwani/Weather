var app = angular.module('weatherApp', []);

app.controller('WeatherController', ['$scope', 'WeatherService', 'CityService', function ($scope, WeatherService, CityService) {

    CityService.getAllCities(
        function (data) {
            $scope.cities = data;
            $scope.currentCity = $scope.cities[0];
            WeatherService.getWeatherData($scope.currentCity,
                    function (data) {
                        $scope.forecast = data;
                    },
                    function (data) {
                        alert('Error encountered while fetching Cities. ' + data);
                    }
            )
        },
        function (data) {
            alert('Error encountered while fetching Weather data. ' + data);
        }
    )

    $scope.onCitySelected = function(){
            if($scope.currentCity != null){
                WeatherService.getWeatherData($scope.currentCity,
                        function (data) {
                            $scope.forecast = data;
                        },
                        function (data) {
                            alert('Error encountered while fetching Weather data. ' + data);
                        }
                )
            };
        }
}]);

app.factory('CityService', function ($http) {
    return {
        getAllCities: function (successcb, errorcb) {

            $http({
                method: "get",
                url: "http://localhost:8080/allcities",
                headers: { "Accept": "application/json;odata=verbose" }
            })
            .success(function (data, status, headers, config) {
                successcb(data);
            })
            .error(function (data, status, headers, config) {
                errorcb(data);
            });
        }

    }
});

app.factory('WeatherService', function ($http) {
    return {
        getWeatherData: function (cityName, successcb, errorcb) {

            $http({
                method: "get",
                url: "http://localhost:8080/weather/" + cityName,
                headers: { "Accept": "application/json;odata=verbose" }
            })
            .success(function (data, status, headers, config) {
                successcb(data);
            })
            .error(function (data, status, headers, config) {
                errorcb(data);
            });
        }
    }
});