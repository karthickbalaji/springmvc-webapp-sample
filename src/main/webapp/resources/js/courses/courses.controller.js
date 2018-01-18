angular
.module('courses.app')
.controller('CoursesController', ['$scope', '$http', '$cookieStore',
                                  function($scope, $http, $cookieStore) {

	vm = this;

	vm.courses = [];

	coursesdata()

	function coursesdata() {
		// Show loading spinner.
		//$scope.updating = true;
        var uid = $cookieStore.get('username').authId;

		$http({method:'GET', url: '/demo/api/courses/'+ uid }).success(function(courses){

			successCallback(courses);

		}).error(function(error){
			console.log('Error fetching courses data! ', error);
		}).finally(function () {
			// Hide loading spinner whether our call succeeded or failed.
			$scope.updating = false;
		});
	}

	var successCallback = function(courses) {
		if (angular.isDefined(courses) && courses !== null) {
			var course;
			angular.forEach(courses, function(course, key) {

				vm.courses.push( { id: course.id, name: course.name, fees: course.fee, level : course.level, registrationStatus : course.registrationStatus} );

			});
		}

	}
	
    $scope.registerbuttontext = [];
    $scope.disableregister = [];
    function registerCourse(courseid, $index) {
        $scope.registerbuttontext[$index] = 'Register';
        var uid = $cookieStore.get('username').authId;
        
        var reqBody = {userId: uid, courseId: courseid};
        
        $http({
            method: 'POST',
            url: '/demo/api/course/register',
            data: JSON.stringify(reqBody),
            headers: {'Content-Type': 'application/json'}
        	})
        	.success(function(data){
            if (angular.isDefined(data) && data !== null){
              if (data == 'success') {
                  $scope.registerbuttontext[$index] = 'Registered';
                  $scope.disableregister[$index] = true;            	  
              } else {
            	  errorCallback();
              }
            } 
            
          }).error(function(error){
              console.log('Error : Could not register ! ', error);
          });
    	
    }
    $scope.registerCourse = registerCourse;


}]);


