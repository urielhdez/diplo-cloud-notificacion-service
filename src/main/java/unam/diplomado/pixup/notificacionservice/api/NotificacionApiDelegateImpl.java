package unam.diplomado.pixup.notificacionservice.api;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import unam.diplomado.pixup.notificacionservice.domain.Notificacion;
import unam.diplomado.pixup.notificacionservice.dto.NotificacionRequest;
import unam.diplomado.pixup.notificacionservice.dto.NotificacionResponse;
import unam.diplomado.pixup.notificacionservice.service.NotificacionService;
import unam.diplomado.pixup.notificacionservice.service.NotificacionServiceImpl;

@Component
public class NotificacionApiDelegateImpl implements NotificacionApiDelegate {
	
	@Autowired
	private NotificacionService notificacionService;
	
	private static final String NOTIFICACION_ALTA_USUARIO = "ALTA_USUARIO";
	private static final String LISTAR_NOTIFICACIONES = "LISTAR_NOTIFICACIONES";
	private static final String ZONE_OFFSET = "-06:00";



	@Override
	public ResponseEntity<NotificacionResponse>
		enviarNotificacionAltaUsuario(
			NotificacionRequest notificacionRequest)  {
		
		Notificacion notificacion = notificacionService.enviarNotificacion(
				notificacionRequest.getIdUsuario(), 
				notificacionRequest.getEmail(), 
				NOTIFICACION_ALTA_USUARIO);
		
		NotificacionResponse notificacionResponse = new NotificacionResponse();
		notificacionResponse.setId(notificacion.getId());
		notificacionResponse.setIdUsuario(notificacion.getIdUsuario());
		notificacionResponse.setEmail(notificacion.getEmail());
		ZoneOffset zoneOffset = ZoneOffset.of(ZONE_OFFSET);
		notificacionResponse.setFechaNotificacion(
			notificacion.getFechaNotificacion().toInstant().atOffset(zoneOffset));
		
		return new ResponseEntity<>(notificacionResponse, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<NotificacionResponse>> getNotificaciones(){

		NotificacionService notificacionService = new NotificacionServiceImpl();
		List<Notificacion> notificaciones = notificacionService.getNotificaciones();
		List<NotificacionResponse> notificacionesResponse = new ArrayList<>();
		notificaciones.stream().forEach((notificacion -> {
			NotificacionResponse notificacionResponse = new NotificacionResponse();
			notificacionResponse.setEmail(notificacion.getEmail());
			ZoneOffset zoneOffset = ZoneOffset.of(ZONE_OFFSET);
			notificacionResponse.setFechaNotificacion(
					notificacion.getFechaNotificacion().toInstant().atOffset(zoneOffset));
			notificacionResponse.setId(notificacion.getId());
			notificacionResponse.setIdUsuario(notificacion.getIdUsuario());
			notificacionesResponse.add(notificacionResponse);
		}));

		return new ResponseEntity<>(notificacionesResponse, HttpStatus.OK);
	}

}
