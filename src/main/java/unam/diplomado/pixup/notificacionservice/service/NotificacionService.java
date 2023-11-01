package unam.diplomado.pixup.notificacionservice.service;

import unam.diplomado.pixup.notificacionservice.domain.Notificacion;

import java.util.List;

public interface NotificacionService {
	
	Notificacion enviarNotificacion(
		String idUsuario, String email, String tipoEvento);

	List<Notificacion> getNotificaciones();

}
