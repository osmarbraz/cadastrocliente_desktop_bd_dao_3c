package util;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestValida {

    private Valida valida = null;

    @Before
    public void inicializa() {
        valida = new Valida();

    }

    @After
    public void finaliza() {
        valida = null;
    }

    @Test
    public void testValidaCPFValido() {
        assertTrue(valida.validaCPF("11111111111"));
    }

    @Test
    public void testValidaCPFInvalido() {
        assertFalse(valida.validaCPF("11111111"));
    }
}
