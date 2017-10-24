'use strict';

angular.module('musicShop').factory('AlbumService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/musicshop';

	return {
		fetchAllAlbuns : function () {
			return $http.get(REST_SERVICE_URI+'/rest/album/getAlbuns')
			.then(
					function successCallback(response) {
						return response;
					},
					function errorCallback(response){
						return response;
					}
			);

		},

		fetchAllAlbunsOrdered : function(criteria){
			return $http.post(REST_SERVICE_URI+"/rest/album/getAlbunsFiltered", criteria)
			.then(function successCallback(response) {
				return response;
			},
			function errorCallback(response){
				return response;
			}
			);
		},

		createAlbum : function (album) {

			return $http({ 
				method: 'POST', 
				url: REST_SERVICE_URI+'/rest/album/createAlbum', 
//				headers: {'Content-Type': 'application/json'}, 
				data: album 
			}).then(
					function successCallback(response) { 
						return response;
					}, 
					function errorCallback(response) { 
						return response;
					}
			);			

		},

		updateAlbum : function (album) {

			return $http({ 
				method: 'POST', 
				url: REST_SERVICE_URI+'/rest/album/updateAlbum', 
//				headers: {'Content-Type': 'application/json'}, 
				data: album
			}).then(
					function successCallback(response) { 
						return response;
					}, 
					function errorCallback(response) { 
						return response;
					}
			);			

		},

		deleteAlbum : function (id) {

			return $http({ 
				method: 'POST', 
				url: REST_SERVICE_URI+'/rest/album/deleteAlbum', 
//				headers: {'Content-Type': 'application/json'}, 
				data: id 
			}).then(
					function successCallback(response) { 
						return response;
					}, 
					function errorCallback(response) { 
						return response;
					}
			);			

		}

	}
}]);