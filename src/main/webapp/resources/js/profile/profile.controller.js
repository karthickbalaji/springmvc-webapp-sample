angular
.module('profile.app')
.controller('ProfileController', ['$scope', '$http', '$cookieStore',
                                  function($scope, $http, $cookieStore) {

	vm = this;

	vm.profile = {};

	profiledata()

	function profiledata() {

        var uid = $cookieStore.get('username').authId;

		$http({method:'GET', url: '/demo/api/user/'+ uid }).success(function(user){

			successCallback(user);

		}).error(function(error){
			console.log('Error fetching user data! ', error);
		}).finally(function () {
			// Hide loading spinner whether our call succeeded or failed.
			$scope.updating = false;
		});
	}

	var successCallback = function(user) {
		if (angular.isDefined(user) && user !== null) {
			vm.profile = { name : user.name, email : user.email, coursesOpted : user.coursesOpted };
		}

	}


}]);


