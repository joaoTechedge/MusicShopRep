'use strict';

angular.module('musicShop').factory('MusicService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/musicshop';

	return {
		fetchAllMusic : function () {
			return $http.get(REST_SERVICE_URI+'/rest/music/getMusic')
			.then(
					function (response) {
						return response.data;
					},
					function(errResponse){
						console.log(errResponse);
					}
			);

		},
		fetchAllMusicOrdered : function(criteria){
			return $http.post(REST_SERVICE_URI+"/rest/music/getMusicFiltered", criteria)
			.then(function (response) {
				return response.data;
			});
		}
	}


}]);