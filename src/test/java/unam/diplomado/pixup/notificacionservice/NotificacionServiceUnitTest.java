package unam.diplomado.pixup.notificacionservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unam.diplomado.pixup.notificacionservice.domain.Notificacion;
import unam.diplomado.pixup.notificacionservice.domain.TipoNotificacion;
import unam.diplomado.pixup.notificacionservice.dto.NotificacionResponse;
import unam.diplomado.pixup.notificacionservice.service.NotificacionServiceImpl;
import unam.diplomado.pixup.notificacionservice.util.FileUtil;
import unam.diplomado.pixup.notificacionservice.util.MapperUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = NotificacionServiceApplication.class)
public class NotificacionServiceUnitTest {

    @Autowired
    private NotificacionServiceImpl notificacionService;

    // .withBasicAuth(ADMIN_TEST_LOGIN, ADMIN_TEST_PASSWORD)

    private static String BASE_URL = "http://localhost:8081/api/notificaciones";
    @Test
    public void getNotificacionesSuccessTest()  {
        try {
            String notificacionJson = FileUtil.readFromFileToString("/tests/notificaciones.json");
            NotificacionResponse notificacion = MapperUtil.deserializeNotificacion(notificacionJson);

            HttpEntity<NotificacionResponse> httpEntity = new HttpEntity<>(notificacion);
            TestRestTemplate testRestTemplate = new TestRestTemplate();
            ResponseEntity<NotificacionResponse> response = testRestTemplate.getForEntity(BASE_URL, NotificacionResponse.class);
            Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        } catch (IOException e){
            System.out.println("Some problem to load use cases for test: " + e.getMessage());
        }
    }

    @Test
    public void getNotificacionesNotEmptyList() {

        List<Notificacion> notificaciones = new ArrayList<Notificacion>();

        Notificacion notificacion = new Notificacion();
        TipoNotificacion tipoNotificacion = new TipoNotificacion();
        tipoNotificacion.setId("1");
        tipoNotificacion.setDescripcion("Registro de autor");

        notificacion.setEmail("somemail@xdomain.es");
        notificacion.setEnviada(true);
        notificacion.setId("1001");
        notificacion.setIdUsuario("some_user");
        notificacion.setFechaNotificacion(new Date());
        notificacion.setTipoNotificacion(tipoNotificacion);
        notificaciones.add(notificacion);

        Mockito.when(notificacionService.getNotificaciones()).thenReturn(notificaciones);

        boolean testName = notificacionService.getNotificaciones().isEmpty();

        Assert.assertEquals(false, testName);
    }
    @Test
    public void getNotificacionesEmptyList() {

        List<Notificacion> notificaciones = new ArrayList<Notificacion>();

        Mockito.when(notificacionService.getNotificaciones()).thenReturn(notificaciones);

        boolean testName = notificacionService.getNotificaciones().isEmpty();

        Assert.assertEquals(true, testName);
    }
}
