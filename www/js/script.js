var near = angular.module('near', ['gm','rzModule', "ui.map", "ui.event"]);

near.directive('whenScrolled', function() {
  return function(scope, elm, attr) {
    var raw = elm[0];

    elm.bind('scroll', function() {
        if (raw.scrollTop + raw.offsetHeight >= raw.scrollHeight) {
            scope.$apply(attr.whenScrolled);
        }
    });
  };
});
  
near.controller("mainControl", ['$scope','$http', '$location','$routeParams', function ($scope, $http, $location,$routeParams) {
		$scope.lat = "0";
        $scope.lng = "0";
        $scope.accuracy = "0";
        $scope.error = "";
        $scope.model = { myMap: undefined };
		$scope.mapMarkers = [];
		$scope.places = [];

		$scope.rangeSlider = {min: 100, max: 500, ceil: 500, floor: 0, step: 50 }; 
		
		$scope.showError = function () {
            return $scope.error == "";
       		 }

		   $scope.mapOptions = {
            	center: new google.maps.LatLng($scope.lat, $scope.lng),
           		zoom: 12,
           		mapTypeId: google.maps.MapTypeId.ROADMAP
        	 };
			 
		$scope.serviceData = function(){
			var page = 0;
  				$scope.loadMore = function() {
    			$http.get('http://203.197.253.43/visigenix/service/venues?lat='+$scope.lat+'&lng='+$scope.lng+'&radius=1&pageNumber='+ page +'&searchTerm=').success(function(data){
        				$scope.places = $scope.places.concat(data);
						$scope.predicate = 'distance';
   						 });
    					page += 1;
        			console.log($scope.places);
  				 };
				 
 			$scope.loadMore();
			
			var latlng = new google.maps.LatLng($scope.lat, $scope.lng);
            $scope.model.myMap.setCenter(latlng);
		 }
			
  		 $scope.showPosition = function (position) {
           	 	$scope.lat = position.coords.latitude;
           	 	$scope.lng = position.coords.longitude;
            	$scope.accuracy = position.coords.accuracy;
				$scope.serviceData();
            	$scope.$apply();
			}

         $scope.getLocation = function () {
            	if (navigator.geolocation) {
               		 navigator.geolocation.getCurrentPosition($scope.showPosition, $scope.showError);
            		}
            	else {
                	$scope.error = "Geolocation is not supported by this browser.";
            	}
        	}
			
		$scope.getLocation();
		$scope.$on('gmPlacesAutocomplete::placeChanged', function(){
      			var location = $scope.autocomplete.getPlace().geometry.location;
	  					$scope.lat = location.lat();
      					$scope.lng = location.lng();
	  					$scope.serviceData();
	  					$scope.$apply();
  			});
	  
    }]);

near.controller("searchControl", ['$scope','$http','$routeParams','$location', function ($scope, $http, $routeParams, $location) {
		$scope.lat = "0";
        $scope.lng = "0";
        $scope.error = "";
        $scope.model = { myMap: undefined };
		$scope.mapMarkers = [];
		$scope.places = [];
		
		$scope.showError = function () {
            return $scope.error == "";
       		 }

		   $scope.mapOptions = {
            	center: new google.maps.LatLng($scope.lat, $scope.lng),
           		zoom: 12,
           		mapTypeId: google.maps.MapTypeId.ROADMAP
        	 };
			 
		$scope.serviceData = function(){
			var page = 0;
  				$scope.loadMore = function() {
    			$http.get('http://203.197.253.43/visigenix/service/venues?lat='+$scope.lat+'&lng='+$scope.lng+'&radius=5&pageNumber='+ page +'&searchTerm=').success(function(data){
        				$scope.places = $scope.places.concat(data);
   						 });
    					page += 1;
        			console.log($scope.places);
  				 };
				 
 			$scope.loadMore();
			var latlng = new google.maps.LatLng($scope.lat, $scope.lng);
            $scope.model.myMap.setCenter(latlng);
		 }
					
	  	$scope.$on('gmPlacesAutocomplete::placeChanged', function(){
      			var location = $scope.autocomplete.getPlace().geometry.location;
	  					$scope.lat = location.lat();
      					$scope.lng = location.lng();
	  					$scope.serviceData();
	  					$scope.$apply();
  			});
	  
    }]);

  near.controller("detailsControl", function($scope, $http, $routeParams){
						   
			var id = $routeParams.placeId
			$http.get('http://203.197.253.43/visigenix/service/venue?venueId='+ id ).success(function(data){
        				$scope.venue = data;
   						});

		});
 
