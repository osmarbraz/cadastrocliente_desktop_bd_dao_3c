
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.JUnit4TestAdapter;
import formulario.TestInclusao;
import formulario.TestExclusao;
import formulario.TestAlteracao;
import dao.TestDAOInclusao;
import dao.TestDAOExclusao;
import dao.TestClienteDAOHashMap;
import util.TestValida;

@RunWith(Suite.class)
@SuiteClasses({TestClienteDAOHashMap.class,
    TestDAOInclusao.class,
    TestDAOExclusao.class,
    TestInclusao.class,
    TestExclusao.class,
    TestAlteracao.class,
    TestValida.class})

public class TesteSuite {

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TesteSuite.class);
    }
}
