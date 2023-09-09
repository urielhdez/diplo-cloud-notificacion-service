package unam.diplomado.pixup.notificacionservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.notificacionservice.domain.TipoNotificacion;

public interface TipoNotificacionRepository 
	extends MongoRepository<TipoNotificacion, String>{
	
	Optional<TipoNotificacion> findByDescripcion(String descripcion);
	
}
