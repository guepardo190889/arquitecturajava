/**
 * Validaciones
 */

function validacion() {
	var isbn = document.getElementById("isbn");
	var miformulario = document.getElementById("formAltaLibro");
	if (isbn.value == "") {
		alert("ISBN no puede ser vacio");
		return false;
	} else {
		miformulario.submit();
	}
}