'use strict';
 
angular.module('musicShop').controller('AlbumController', ['$http', '$scope', '$location','AlbumService', function($http, $scope, $location,AlbumService) {
    var self = this;
    
    self.albuns = [];
    self.headers = ['Nome', 'Editora', 'Estilo', 'Ano'];
    self.headersMus = ['Música (Nome)', 'Editora', 'Estilo', 'Ano', 'Duração'];
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
    
    $scope.gotomusic = function(){
    	$location.path('/music');
    }
    
    $scope.gotostar = function(){
    	$location.path('/star');
    }
 
}]);

angular.module('musicShop').controller('RowCtrl', function ($scope) {

    $scope.toggleRow = function () {
      $scope.selected = !$scope.selected;
    };

    $scope.isSelected = function (i) {
      return $scope.selected;
    };
});