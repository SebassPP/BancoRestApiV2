package com.brokis.Banco;

import jakarta.persistence.EntityManager;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.brokis.Banco.modelo.Usuario;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("unitTest")
public class ModeloUsuarioTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private Usuario user;

    @Before(value = "setUp")
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void setUp() {
        user = new Usuario();
    }

    @Test
    public void fechaCreacionPrePersist() {
        user.setDocumento(123L);
        user.setNombre("nombre");
        user.setApellido("apellido");
        user.setFechaDeCreacion(null);

        doAnswer(invocation -> {
            user.setFechaDeCreacion(new Date());
            return null;
        }).when(entityManager).persist(user);
        user.prePersist();

        assertNotNull(user.getFechaDeCreacion());
        assertTrue(user.getFechaDeCreacion() instanceof Date);

    }


}
