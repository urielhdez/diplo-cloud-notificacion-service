package unam.diplomado.pixup.notificacionservice.domain;

public class TipoNotificacionNonExistingException extends RuntimeException {
	
	public TipoNotificacionNonExistingException(String descripcion) {
        super("No se encontro el tipo de notificacion para el evento: " + descripcion);
    }

}
