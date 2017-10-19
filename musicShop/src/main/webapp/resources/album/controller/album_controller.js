'use strict';

angular.module('musicShop').controller('AlbumController', ['$http', '$scope', '$location','AlbumService' , '$uibModal', function($http, $scope, $location, AlbumService, $uibModal) {
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
	self.album={};
	self.responseAlbum;


	$scope.getAlbuns = function(){
		AlbumService.fetchAllAlbuns()
		.then(function(data){
			self.albuns = data;
		});
	};

	$scope.orderByField = function(criteria){
		AlbumService.fetchAllAlbunsOrdered(criteria)
		.then(function(data){
			self.albuns = data;
		});
	};

	$scope.gotomusic = function(){
		$location.path('/music');
	};

	$scope.gotostar = function(){
		$location.path('/star');
	};


	$scope.showDialog = function() {
		var modalInstance = $uibModal.open({
			templateUrl: 'resources/album/view/album_create_dialog.html',
			controller: this.ModalInstanceCtrls
		});
	};

	$scope.ModalInstanceCtrls = function($scope, $uibModalInstance ) {
		$scope.ok = function(album) {
			AlbumService.createAlbum(album)
			.then(function(data){
				alert(data);
				$uibModalInstance.close();
			});
		};

		$scope.cancel = function() {
			// $uibModalInstance.dismiss('cancel');
			$uibModalInstance.close();
		};
	};

	$scope.del = function(id){
		AlbumService.deleteAlbum(id)
		.then(function(data){
			alert(data);
		});
	}

	$scope.updateA = function(a) {		
			
//		self.album = a;
		
		var modalInstance = $uibModal.open({
			templateUrl: 'resources/album/view/album_update_dialog.html',
			controller: this.ModalInstanceCtrl,
			resolve: {
				album: function(){
					return a;
				}
			}
		});
	};

	$scope.ModalInstanceCtrl = function($scope, $uibModalInstance, album ) {
		$scope.album = album;
		$scope.ok = function(album) {
			AlbumService.updateAlbum(album)
			.then(function(data){
				alert(data);
				$uibModalInstance.close();
			});
		};

		$scope.cancel = function() {
			// $uibModalInstance.dismiss('cancel');
			$uibModalInstance.close();
		};
	};


}]);

angular.module('musicShop').controller('RowCtrl', function ($scope) {

	$scope.toggleRow = function () {
		$scope.selected = !$scope.selected;
	};

	$scope.isSelected = function (i) {
		return $scope.selected;
	};
});



