package unam.diplomado.pixup.notificacionservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import unam.diplomado.pixup.notificacionservice.domain.Notificacion;

public interface NotificacionRepository 
	extends MongoRepository<Notificacion, String>{
}
