'use strict';

angular.module('musicShop').factory('StarService', ['$http', '$q', function($http, $q){

	var REST_SERVICE_URI = 'http://localhost:8080/musicshop';

	return {
		fetchAllStar : function () {
			return $http.get(REST_SERVICE_URI+'/rest/star/getStar')
			.then(
					function (response) {
						return response.data;
					},
					function(errResponse){
						console.log(errResponse);
					}
			);

		},
		fetchAllStarOrdered : function(criteria){
			return $http.post(REST_SERVICE_URI+"/rest/star/getStarFiltered", criteria)
			.then(function (response) {
				return response.data;
			});
		}
	}


}]);