'use strict';
 
angular.module('musicShop').controller('AlbumController', ['$http', '$scope', 'AlbumService', function($http, $scope, AlbumService) {
    var self = this;
    
    self.albuns = [];
    self.headers = ['Nome', 'Editora', 'Estilo', 'Ano'];
    self.columnsNVP = [];
    self.columnsNVP.push({name:'Nome',value:'name_album'});
    self.columnsNVP.push({name:'Editora',value:'publisher'});
    self.columnsNVP.push({name:'Estilo',value:'style'});
    self.columnsNVP.push({name:'Ano',value:'year'});
    self.criteria={};
    self.direction = ['asc', 'desc'];

    $scope.getAlbuns = function(){
    	AlbumService.fetchAllAlbuns()
    	.then(function(data){
    		self.albuns = data;
    	});
    }
    
    $scope.orderByField = function(criteria){
    	AlbumService.fetchAllAlbunsOrdered(criteria)
    	.then(function(data){
    		self.albuns = data;
    	});
    }
 
}]);