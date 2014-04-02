	
var app = angular.module('app', ['near', 'swipe', 'ngRoute', "ui.bootstrap"]);
	
app.config(['$routeProvider', function($routeProvider, $locationProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'partials/home.html',
        controller: 'mainControl'
      }).
	   when('/places', {
        templateUrl: 'partials/venue_list.html',
        controller: 'searchControl'
      }).
	   when('/details/:placeId', {
        templateUrl: 'partials/venue_details.html',
        controller: 'detailsControl'
      }).
      when('/venues', {
        templateUrl: 'partials/favourite.html',
        controller: 'searchControl'
      }).
	  when('/maps', {
        templateUrl: 'partials/map.html',
        controller: 'searchControl'
      }).
	  when('/settings', {
        templateUrl: 'partials/settings.html',
        controller: 'MyCtrl'
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
	
	
 app.controller('MyCtrl', function($scope, $location) {
								   
	$scope.goToPage = function (page) {        
    		$location.url(page);
		};
		
					   
    $scope.isActive = function(route) {
        return route === $location.path();
    		}
			
		$scope.custom = true;

	$scope.isCollapsed = true;	
	});
	
