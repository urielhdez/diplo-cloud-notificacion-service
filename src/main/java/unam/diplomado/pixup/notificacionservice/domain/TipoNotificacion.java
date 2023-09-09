package unam.diplomado.pixup.notificacionservice.domain;

import jakarta.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="tiposNotificacion")
public class TipoNotificacion {
	
	@Id
	private String id;
	@NotBlank
	private String descripcion;
	@NotBlank
	private String rutaPlantilla;

}
