package unam.diplomado.pixup.notificacionservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	@Override
	public List<Notificacion> getNotificaciones() {
		List<Notificacion> notificaciones = new ArrayList<>();

		Notificacion notificacion = new Notificacion();
		TipoNotificacion tipoNotificacion = new TipoNotificacion();
		tipoNotificacion.setId("1");
		tipoNotificacion.setDescripcion("Registro de autor");

		notificacion.setEmail("somemail@xdomain.es");
		notificacion.setEnviada(true);
		notificacion.setId("1004");
		notificacion.setIdUsuario("another_user");
		notificacion.setFechaNotificacion(new Date());
		notificacion.setTipoNotificacion(tipoNotificacion);
		notificaciones.add(notificacion);


		Notificacion notificacion2 = new Notificacion();
		tipoNotificacion.setId("1");
		tipoNotificacion.setDescripcion("Registro de libro");

		notificacion2.setEmail("anothermail@xdomain.es");
		notificacion2.setEnviada(true);
		notificacion2.setId("1005");
		notificacion2.setIdUsuario("the_user");
		notificacion2.setFechaNotificacion(new Date());
		notificacion2.setTipoNotificacion(tipoNotificacion);

		notificaciones.add(notificacion2);

		return notificaciones;
	}

}
