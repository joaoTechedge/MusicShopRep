'use strict';

angular.module('musicShop').factory('AlbumService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/musicshop';

	return {
		fetchAllAlbuns : function () {
			return $http.get(REST_SERVICE_URI+'/rest/album/getAlbuns')
			.then(
					function (response) {
						return response.data;
					},
					function(errResponse){
						console.log(errResponse);
					}
			);

		},

		fetchAllAlbunsOrdered : function(criteria){
			return $http.post(REST_SERVICE_URI+"/rest/album/getAlbunsFiltered", criteria)
			.then(function (response) {
				return response.data;
			});
		},

		createAlbum : function (album) {

			return $http({ 
				method: 'POST', 
				url: REST_SERVICE_URI+'/rest/album/createAlbum', 
//				headers: {'Content-Type': 'application/json'}, 
				data: album 
			}).then(
					function successCallback(response) { 
						if (response.data) { 
							return response.data;
						}
					}, 
					function errorCallback(response) { 
						console.log(response);
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
						if (response.data) { 
							return response.data;
						}
					}, 
					function errorCallback(response) { 
						console.log(response);
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
						if (response.data) { 
							return response.data;
						}
					}, 
					function errorCallback(response) { 
						console.log(response);
					}
			);			

		}
		
	}
}]);