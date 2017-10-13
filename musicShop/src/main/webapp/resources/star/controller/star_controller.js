'use strict';
 
angular.module('musicShop').controller('StarController', ['$http', '$scope', '$location', 'StarService', function($http, $scope, $location, StarService) {
    var self = this;
    
    self.star = [];
    self.headers = ['Nome', 'Nome artístico', 'Género'];
    self.columnsNVP = [];
    self.columnsNVP.push({name:'Nome',value:'name_star'});
    self.columnsNVP.push({name:'Nome artístico',value:'name_star_professional'});
    self.columnsNVP.push({name:'Género',value:'gender'});
    self.criteria={};
    self.direction = ['asc', 'desc'];

    $scope.getStar = function(){
    	StarService.fetchAllStar()
    	.then(function(data){
    		self.star = data;
    	});
    }
    
    $scope.orderByField = function(criteria){
    	StarService.fetchAllStarOrdered(criteria)
    	.then(function(data){
    		self.star = data;
    	});
    }
 
    $scope.gotoalbum = function(){
    	$location.path('/');
    }
    
    $scope.gotomusic = function(){
    	$location.path('/music');
    }
}]);