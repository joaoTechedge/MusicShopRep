/**
 * 
 */

'use strict'

var app = angular.module('musicShop', ['ngRoute', 'ui.bootstrap']);

app.config(function($routeProvider) {
	$routeProvider
	// route for the home page
	.when('/', {
		templateUrl : 'resources/album/view/album.html',
		controller  : 'AlbumController'
	})
	// route for the music page
	.when('/music', {
		templateUrl : 'resources/music/view/music.html',
		controller  : 'MusicController'
	})

	// route for the star page
	.when('/star', {
		templateUrl : 'resources/star/view/star.html',
		controller  : 'StarController'
	});
	
});

