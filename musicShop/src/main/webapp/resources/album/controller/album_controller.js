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
	self.albumCopy = {};
	self.responseAlbum;
	self.openMessage;
	$scope.message;


	$scope.getAlbuns = function(){
		AlbumService.fetchAllAlbuns()
		.then(function(response){
			self.albuns = response.data;
		});
	};

	$scope.orderByField = function(criteria){
		AlbumService.fetchAllAlbunsOrdered(criteria)
		.then(function(response){
			self.albuns = response.data;
		});
	};

	$scope.gotomusic = function(){
		$location.path('/music');
	};

	$scope.gotostar = function(){
		$location.path('/star');
	};


	$scope.createAlbum = function() {
		var modalInstance = $uibModal.open({
			templateUrl: 'resources/album/view/album_create_dialog.html',
			controller: this.ModalInstanceCtrls
		});
	};

	$scope.ModalInstanceCtrls = function($scope, $uibModalInstance) {
		$scope.ok = function(album) {
			AlbumService.createAlbum(album)
			.then(function(data){
				if(data.status != 200){
					$scope.message="Album não inserido!";
					$uibModalInstance.close();

					self.openMessage = $uibModal.open({
						templateUrl: 'resources/album/view/showMessageErr.html',
						controller: $uibModal.ModalInstanceCtrlMes,
						resolve: {
							message: function(){
								return $scope.message;
							}}
					});


				}else{	
					$scope.message="Album inserido";
					$uibModalInstance.close();

					self.openMessage = $uibModal.open({
						templateUrl: 'resources/album/view/showMessageSuc.html',
						controller: $uibModal.ModalInstanceCtrlMes,
						resolve: {
							message: function(){
								return $scope.message;
							}}
					});
				}
			});

		};

		$scope.cancel = function() {
			$uibModalInstance.close();
		};

	};



	$scope.deleteA = function(id){
		AlbumService.deleteAlbum(id)
		.then(function(data){
			if(data.status != 200){
				$scope.message="Album não apagado";
				self.openMessage = $uibModal.open({
					templateUrl: 'resources/album/view/showMessageErr.html',
					controller: $uibModal.ModalInstanceCtrlMes,
					resolve: {
						message: function(){
							return $scope.message;
						}}
				});
			}else{
				$scope.message="Album apagado";
				self.openMessage = $uibModal.open({
					templateUrl: 'resources/album/view/showMessageSuc.html',
					controller: $uibModal.ModalInstanceCtrlMes,
					resolve: {
						message: function(){
							return $scope.message;
						}}
				});
			}

		});
	}

	$scope.updateA = function(a) {		
		$scope.albumCopy = angular.copy(a);
		$scope.headerMus = self.headersMus;
		var modalInstance = $uibModal.open({
			templateUrl: 'resources/album/view/album_update_dialog.html',
			controller: this.ModalInstanceCtrl,
			resolve: {
				album: function(){
					return a;
				},
				albumCopy: function(){
					return $scope.albumCopy;
				},
				header: function(){
					return $scope.headerMus;
				}
			}
		});
	};

	$scope.ModalInstanceCtrl = function($scope, $uibModalInstance, album, albumCopy, header ) {
		$scope.album = album;
		$scope.albumCopy = albumCopy;
		$scope.header = header;
		$scope.ok = function(albumCopy) {
			AlbumService.updateAlbum($scope.albumCopy)
			.then(function(data){
				if(data.status != 200){
					$uibModalInstance.close();
					$scope.message="Album não editado";
					self.openMessage = $uibModal.open({
						templateUrl: 'resources/album/view/showMessageErr.html',
						controller: $uibModal.ModalInstanceCtrlMes,
						resolve: {
							message: function(){
								return $scope.message;
							}}
					});
				} else{
					$scope.album.id=$scope.albumCopy.id;
					$scope.album.name_album=$scope.albumCopy.name_album;
					$scope.album.year=$scope.albumCopy.year;
					$scope.album.publisher=$scope.albumCopy.publisher;
					$scope.album.style=$scope.albumCopy.style;				
					$scope.album.listOfAlbumMusic=[];

					for(var i=0; i<$scope.albumCopy.listOfAlbumMusic.length; i++) {
						$scope.album.listOfAlbumMusic[i]=$scope.albumCopy.listOfAlbumMusic[i];
					}				
					$scope.message="Album editado";
					$uibModalInstance.close();
					self.openMessage = $uibModal.open({
						templateUrl: 'resources/album/view/showMessageSuc.html',
						controller: $uibModal.ModalInstanceCtrlMes,
						resolve: {
							message: function(){
								return $scope.message;
							}}
					});
				}
			});
		};

		$scope.cancel = function() {
			$uibModalInstance.close();

		};
		// delete musics from view
		$scope.delalbmus = function (index) {
			$scope.albumCopy.listOfAlbumMusic.splice(index, 1);
		}

	};

	$uibModal.ModalInstanceCtrlMes = function($scope, $uibModalInstance, message) {
		$scope.message = message;
		$scope.cancel = function() {
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



