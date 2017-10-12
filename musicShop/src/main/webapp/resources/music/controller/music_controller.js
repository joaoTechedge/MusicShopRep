'use strict';
 
angular.module('musicShop').controller('MusicController', ['$http', '$scope', 'MusicService', function($http, $scope, MusicService) {
    var self = this;
    
    self.music = [];
    self.headers = ['Nome', 'Editora', 'Estilo', 'Ano', 'Duração'];
    self.columnsNVP = [];
    self.columnsNVP.push({name:'Nome',value:'name_music'});
    self.columnsNVP.push({name:'Editora',value:'publisher'});
    self.columnsNVP.push({name:'Estilo',value:'style_music'});
    self.columnsNVP.push({name:'Ano',value:'year'});
    self.columnsNVP.push({name:'Duração',value:'duraction'});
    self.criteria={};
    self.direction = ['asc', 'desc'];

    $scope.getMusic = function(){
    	MusicService.fetchAllMusic()
    	.then(function(data){
    		self.music = data;
    	});
    }
    
    $scope.orderByField = function(criteria){
    	MusicService.fetchAllMusicOrdered(criteria)
    	.then(function(data){
    		self.music = data;
    	});
    }
 
}]);