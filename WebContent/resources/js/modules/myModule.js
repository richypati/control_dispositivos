var cdApp = angular.module('cdApp', [ 'ngRoute', 'ngCookies', 'ngDialog', ]);

/* ********************************************************************************
 *                   				HTTP STATUS CODES                 			 *                  
 *********************************************************************************/
var HTTP_STATUS_ACCEPTED = 202;
var HTTP_STATUS_UNAUTHORIZED = 401;
var HTTP_STATUS_INTERNAL_SERVER_ERROR = 500;
var HTTP_STATUS_CREATED = 201;
var HTTP_STATUS_CONFLICT = 409;
var HTTP_STATUS_NOT_ACCEPTABLE = 406;

/* ********************************************************************************
 *                   			URL DE SERVICIOS WEB                 			 *                  
 *********************************************************************************/
var URL_PATH = "http://localhost:8080/control_dispositivos/serviciosweb";
var URL_SERVICIO_VALIDAR_USUARIO = URL_PATH + "/usuario/esUsuarioValido";
var URL_SERVICIO_REGISTRAR_USUARIO = URL_PATH + "/usuario/registrarUsuario";

/* ********************************************************************************
 *                   				FACTORY LOGIN                     			 *                  
 *********************************************************************************/
cdApp.factory('autenticacion', function($cookies, $cookieStore, $location) {
	return {

		login : function(email) {
			$cookies.control_dispositivos_email = email;
		},
		
		cerrarSession : function(){
			$cookieStore.remove("control_dispositivos_email");
		},

		validarEstado : function() {

			if (typeof ($cookies.control_dispositivos_email) == 'undefined') {
				$location.url('/');
			}
			
			if (typeof ($cookies.control_dispositivos_email) != 'undefined'
					&& $location.url() == '/') {
				$location.url('/gestionarDispositivos');
			}
		}
	};
});

/* ********************************************************************************
 *                			   CONFIGURACIÓN DE VISTAS              	         *                  
 *********************************************************************************/
cdApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'html/Login.html',
		controller : 'ctrlrLogin'
	});
	
	$routeProvider.when('/gestionarDispositivos', {
		templateUrl : 'html/GestionDispositivos.html',
		controller : 'ctrlrGestionDispositivos'
	});
} ]);


/* ********************************************************************************
 *            		       CONFIGURACIÓN DE SERVICIOS WEB			             *                  
 *********************************************************************************/
cdApp.service('UsuarioService', function($http, $location) {
	this.validar = function(email, password) {
		return $http({
			method : 'POST',
			url : URL_SERVICIO_VALIDAR_USUARIO,
			data : {
				email : email,
				password : password
			}
		});
	};
	
	this.registrar = function(usuario){
		return $http({
			method: 'POST',
			url: URL_SERVICIO_REGISTRAR_USUARIO,
			data: {
				email: usuario.email,
				nombres: usuario.nombres,
				apellidos: usuario.apellidos,
				password: usuario.password
			}
		});
	};
});

/* ********************************************************************************
 *                   					CONTROLADORES                     		 *                  
 *********************************************************************************/
cdApp.controller('ctrlrLogin', function($scope, $window, $location, autenticacion, UsuarioService) {

	$scope.error = "";
	
	$scope.login = function() {
		UsuarioService.validar($scope.email, $scope.password).then(
				function(response) {
					switch (response.status) {
					case HTTP_STATUS_ACCEPTED:
						autenticacion.login($scope.email);
						$scope.email = '';
						$scope.password = '';
						$scope.error = '';
						$location.url('/gestionarDispositivos');
						break;
					default:
						$scope.error = "Ocurrió un error inesperado: ERROR: " + response.status;
						break;
					}
				}, function (response) {
						switch (response.status) {
						case HTTP_STATUS_INTERNAL_SERVER_ERROR:
							$scope.error = "Error interno del servidor.";
							break;
						case HTTP_STATUS_UNAUTHORIZED:
							$scope.error = "El Email o la Contraseña son incorrectos.";
							break;
						default:
							$scope.error = "Ocurrió un error inesperado: ERROR: " + response.status;
							break;
						}
                    });
	};
	
	$scope.cerrarSession = function(){
		autenticacion.cerrarSession();
		$location.url('/');
	};
	
	$scope.registrar = function() {
		$window.location.href = "html/RegistrarUsuario.html";
	}

});

cdApp.controller('ctrlrRegistrarUsuario', function($scope, $window, $location, autenticacion, UsuarioService) {
	
	$scope.error = '';
	$scope.usuario = {
		email: '',
		apellidos: '',
		nombres: '',
		password: ''
	};
	
	$scope.registrarUsuario = function() {
				
		UsuarioService.registrar($scope.usuario).then(
				function(response){
					switch (response.status) {
					case HTTP_STATUS_CREATED:
						$scope.usuario = '';
						alert("El usuario fue registrado.");
						$window.location.href = "../index.html";
						break;
					default:
						$scope.error = "Ocurrió un error inesperado: ERROR: " + response.status;
						break;
					}
				},function(response){
					switch (response.status) {
					case HTTP_STATUS_CONFLICT:
						$scope.error = "El email " + $scope.usuario.email + " ya estaba registrado en el sistema.";
						break;
					case HTTP_STATUS_INTERNAL_SERVER_ERROR:
						$scope.error = "Error interno del servidor.";
						break;
					case HTTP_STATUS_NOT_ACCEPTABLE:
						$scope.error = "Datos incorrectos.";
						break;
					default:
						$scope.error = "Ocurrió un error inesperado: ERROR: " + response.status;
						break;
					}
				});
	};
	
	$scope.login = function(){
		$window.location.href = "../index.html";
	}
});

/* *******************************************************************************
 *                   		CONFIGURACIÓN DE CAMBIO DE RUTA                     *                  
 ********************************************************************************
 * Esta función se ejecuta cada vez que hay un cambio de ruta en la aplicación,	*
 * es decir, se cambia de una vista a otra.										*
 * Cuando ocurra un cambio de ruta, se ejecuta la función validarEstado()		*
 * del Factory Login que permite verificar el estado de sesión del usuario en la*
 * aplicación.																	*
 ********************************************************************************/
cdApp.run(function($rootScope, autenticacion) {
	$rootScope.$on('$routeChangeStart', function() {
		autenticacion.validarEstado();
	});
});