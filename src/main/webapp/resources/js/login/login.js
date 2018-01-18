angular.module('login.app'
  )
  .controller("LoginController", ['$scope', '$window', '$http', '$cookieStore', '$location', function($scope, $window, $http, $cookieStore, $location) {
	  //$scope.finishedLoading = true;

	  $scope.disableSignIn = true;
	  $scope.username = '';
	  $scope.password = '';
	  $scope.showAlert = false;
	  $scope.currentUser = '';

	  $scope.urlApi = '/demo/api/login';   // url of api authentication

	  //function

	  // check username and password => if length > 0 --> enable Sign In button
	  $scope.checkForm = function () {
	    $scope.showAlert = false;
	    if ($scope.username.length > 0 && $scope.password.length > 0) {
	      $scope.disableSignIn = false;
	    } else {
	      $scope.disableSignIn = true;
	    }
	  };
	  
	  $scope.getCurrentUser = function() {
		  	return $cookieStore.get('username').username;
		  }
	  
	  // a function when post success
	  var postSuccess = function (data) {
	    $scope.data = data;

	    switch (data) {
	    case 'login.success':
	       $window.location.href = 'resources/home.html';
	
	       //$cookieStore.put('AuthUser', user);
	      break;
	    case 'login.fail':

	      $scope.showAlert = true;
	      $scope.alertMessage = 'Login failed';

	      break;
	
	    default :
	      $scope.showAlert = true;
	      $scope.alertMessage = 'Login failed';
	      break;
	    }
	  };

	  // if post error, show alert
	  var postError = function () {
	    $scope.showAlert = true;
	    $scope.alertMessage = 'Oops! Can not connect to server! Please try again!';
	  };


      // when user click signIn button, we will call api authen: method POST
      $scope.signIn = function () {
        $scope.showSpinner = true;
        var reqBody = {userName: $scope.username, password: $scope.password};
        
        $http({
            method: 'POST',
            url: $scope.urlApi,
            data: JSON.stringify(reqBody),
            headers: {'Content-Type': 'application/json'}
        	}).success(function(data){
        		var authUser = {'username':  $scope.username, 'authId' : data.authId}
        		$cookieStore.put('username', authUser);
        		
        		$scope.currentUser = $scope.getCurrentUser();

        		postSuccess(data.message);
                
	      }).error(function(error){
	          console.log('login fail ! ', error);
	          postError();
	      }).finally(function () {
	          $scope.updating = false;
	        });
 	      } 
	      
	}]).directive('ngEnter', [function () {
		  return{
			    restrict: 'A',
			    link: function (scope, element) {
			      element.bind('keydown', function (e) {
			        if (e.keyCode === 13) {
			          scope.$apply(function () {
			            if (scope.username.length > 0 && scope.password.length > 0) {
			              scope.signIn();
			            }
			          });
			        }
			      });
			    }
			  };
}]);

