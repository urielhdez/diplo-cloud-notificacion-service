package unam.diplomado.pixup.notificacionservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import unam.diplomado.pixup.notificacionservice.domain.TipoNotificacionNonExistingException;
import unam.diplomado.pixup.notificacionservice.dto.ErrorResponse;

@RestControllerAdvice
public class NotificacionApiAdvice {
	
	@ExceptionHandler(TipoNotificacionNonExistingException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	private ErrorResponse coloniaNotFoundHandler(
			TipoNotificacionNonExistingException exception) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setEstatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setTipo("BASE_DATOS");
		errorResponse.setMensaje(exception.getMessage());
		return errorResponse;
	}

}
