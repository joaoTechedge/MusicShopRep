/**
 * 
 */

'use strict'

var app = angular.module('musicShop', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider

    // route for the home page
    .when('/', {
        templateUrl : 'resources/album/view/album.html',
        controller  : 'AlbumController'
    })

});