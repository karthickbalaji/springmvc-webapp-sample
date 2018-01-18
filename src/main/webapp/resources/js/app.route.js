angular.module('coursedemoapp')
    .config(['$routeProvider',
                  function($routeProvider) {
                    $routeProvider.
                      when('/courses', {
                		templateUrl: 'courses.html',
                		controller: 'CoursesController',
                    	controllerAs: 'vm'
                	}).
                      when('/profile', {
                		templateUrl: 'profile.html',
                		controller: 'ProfileController',
                        controllerAs: 'vm'                			
                      }).
                      otherwise({
                		redirectTo: 'home'
                      });
                }]);