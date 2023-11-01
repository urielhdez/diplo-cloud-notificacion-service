package unam.diplomado.pixup.notificacionservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import unam.diplomado.pixup.notificacionservice.dto.NotificacionResponse;

import java.util.Arrays;
import java.util.List;

public class MapperUtil {

    //ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    public static NotificacionResponse deserializeNotificacion(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, NotificacionResponse.class);
    }

    public static List<NotificacionResponse> deserializeNotificaciones(String json) throws JsonProcessingException {
        NotificacionResponse[] notificaciones = objectMapper.readValue(json, NotificacionResponse[].class);
        return Arrays.stream(notificaciones).toList();
    }
}
