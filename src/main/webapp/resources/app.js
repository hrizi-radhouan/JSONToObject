var serviceModule = angular.module('serviceModule', []);

serviceModule.controller("loadMassTerInsightProject",function($scope, $http) {
alert("Hola")
	// send function
	
function send() {

		var json = {firstName:"Ali",lastName:"BenSaleh"};
		
		alert("Hola")
		var config = {
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
				}
		}				
		jsonSerialized = $.param(json);
		$http.post('send', jsonSerialized, config).then(
				function(response) {
					// success callback
					alert(response.data.update);
				},
				function(response) {
					// failure callback

					alert("Exception details: "
							+ JSON.stringify({
								data : response.status
							}));

				})

	};
	
	
	
})