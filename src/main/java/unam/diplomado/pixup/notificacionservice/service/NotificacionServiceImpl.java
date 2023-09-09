package unam.diplomado.pixup.notificacionservice.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unam.diplomado.pixup.notificacionservice.domain.Notificacion;
import unam.diplomado.pixup.notificacionservice.domain.TipoNotificacion;
import unam.diplomado.pixup.notificacionservice.domain.TipoNotificacionNonExistingException;
import unam.diplomado.pixup.notificacionservice.repository.NotificacionRepository;
import unam.diplomado.pixup.notificacionservice.repository.TipoNotificacionRepository;

@Service
public class NotificacionServiceImpl implements NotificacionService {
	
	@Autowired
	private NotificacionRepository notificacionRepository;
	@Autowired
	private TipoNotificacionRepository tipoNotificacionRepository;

	@Override
	public Notificacion enviarNotificacion(
			String idUsuario, String email, String tipoEvento) {
		Notificacion notificacion = new Notificacion();
		notificacion.setIdUsuario(idUsuario);
        notificacion.setEmail(email);
        notificacion.setFechaNotificacion(
        	new Date(System.currentTimeMillis()));
        notificacion.setEnviada(false);
        
		Optional<TipoNotificacion> tipoNotificacion =
                tipoNotificacionRepository.findByDescripcion(tipoEvento);
		if (tipoNotificacion.isEmpty()) {
            throw new TipoNotificacionNonExistingException(tipoEvento);
        }
        notificacion.setTipoNotificacion(tipoNotificacion.get());
        notificacionRepository.save(notificacion);
        return notificacion;
	}

}
