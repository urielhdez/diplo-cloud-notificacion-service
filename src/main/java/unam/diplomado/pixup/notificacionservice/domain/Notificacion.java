package unam.diplomado.pixup.notificacionservice.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="notificaciones")
public class Notificacion {
	
	@Id
	private String id;
	private Date fechaNotificacion;
	private String idUsuario;
	private String email;
	private Boolean enviada;
	@DBRef
	private TipoNotificacion tipoNotificacion;
	
}
