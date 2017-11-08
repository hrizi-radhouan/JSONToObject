<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html ng-app="serviceModule">
<head>
<title>Home</title>
<script src="<c:url value="/resources/app.js" />"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
</head>
<body >

<script type="text/javascript">

var serviceModule = angular.module('serviceModule', []);

serviceModule.controller("loadMassTerInsightProject",function($scope, $http) {

	// send function
	
$scope.send = function() {

		var json = {firstName : $scope.firstName,lastName : $scope.lastName};
		
		
		alert("Hola")
		var config = {
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded;charset=utf-8;'
				}
		}				
		//jsonSerialized = $.param(json);
		$http.post('send', json, config).then(
				function(response) {
					// success callback
					alert(" you success ");
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
</script>
	<h1>Hello world!</h1>
	<p data-ng-controller="loadMassTerInsightProject">
		<label>FirstName : </label><input type="text" data-ng-model="firstName" /><br>
		<label>LastName : </label><input type="text" data-ng-model="lastName" /><br>
		<input type="button" ng-click="send()" value="send" />
	</p>
</body>
</html>
