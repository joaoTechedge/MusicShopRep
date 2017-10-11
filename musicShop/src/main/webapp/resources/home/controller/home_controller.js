'use strict';
 
angular.module('musicShop').controller('AlbumController', ['$http', '$scope', 'AlbumService', function($http, $scope, AlbumService) {
    var self = this;
   
    self.albuns = [];

    $scope.getAlbuns = function(){
    	AlbumService.fetchAllAlbuns().then(function(data){
    		self.albuns = data;
    	});
    }
 
}]);