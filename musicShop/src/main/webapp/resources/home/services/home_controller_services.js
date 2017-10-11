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
						console.log(response);
					}
			);

		}
	}





}]);