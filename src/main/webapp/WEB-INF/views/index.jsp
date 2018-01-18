<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Semester Registration</title>
<link rel="stylesheet" href="resources/styles/coursereg.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>

	<div class="container" ng-app="coursedemoapp"
		ng-controller="LoginController">
		<div class="col-md-12">
			<div class="page-header">
				<h1 align="center">Online Course Registration portal</h1>
			</div>
		</div>
		<div class="login-body">

			<div style="text-align: justify;">
				<div class="login-main-text">
					<h3>Students login here</h3>
				</div>
			</div>

			<form class="login-form form-horizontal">

				<div class="form-group">
					<label for="username" class="col-lg-2 control-label">Username:</label>
					<div class="col-lg-3 input-group">
						<input type="text" class="form-control" id="username"
							ng-model="username" ng-change="checkForm()"> 
							<span
							class="input-group-addon icon-user"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-lg-2 control-label">Password:</label>
					<div class="col-lg-3 input-group">
						<input type="password" class="form-control" id="password"
							ng-model="password" ng-change="checkForm()"> 
							<span
							class="input-group-addon icon-key"></span>
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-2"></div>
					<div class="col-lg-10 input-group">
						<button class="btn btn-default" ng-click="signIn()"
							id="signInButton" ng-disabled="disableSignIn"">
							<b>Sign In </b><i class="glyphicon glyphicon-log-in"></i>
						</button>
					</div>
				</div>
				<div style="text-align: center;" class="alert alert-danger"
					ng-show="showAlert" id="errorMsg">
					<div style="font-weight: bold">
						<i class="fa fa-fw fa-exclamation-triangle"></i>{{alertMessage}}
					</div>
				</div>
			</form>
		</div>

	</div>

	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-route.js"></script>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0/angular-cookies.js"></script>
		
	<script src="resources/js/app.js"></script>
	<script src="resources/js/app.route.js"></script>
	
	<script src="resources/js/login/login.module.js"></script>
	<script src="resources/js/login/login.js"></script>
	<script src="resources/js/courses/courses.module.js"></script>	
	<script src="resources/js/profile/profile.module.js"></script>
	

</body>
</html>
