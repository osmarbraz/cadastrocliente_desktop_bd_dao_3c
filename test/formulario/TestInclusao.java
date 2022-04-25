package formulario;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import controle.CtrCliente;
import formulario.FrmClienteFake;

import dao.cliente.*;
import entidade.Cliente;
import java.util.*;
import static org.junit.Assert.assertNotNull;

public class TestInclusao {
	
	private static CtrCliente controle = null;
	private static FrmClienteFake clienteFake = null; 
	//private static FrmCliente clienteFake = null;

	@Before
	public void inicializa()  {
		clienteFake = new FrmClienteFake();
		//clienteFake = new FrmCliente();
		controle = new CtrCliente();
		controle.setFrmCliente(clienteFake);		
	}

	@Test
	public void testIncluir()  {
		String idTeste = "1";
		String nomeTeste = "Carlos";
		String cpfTeste = "11111111111";
		
		clienteFake.jTClienteId.setText(idTeste);
		clienteFake.jTNome.setText(nomeTeste);
		clienteFake.jTCpf.setText(cpfTeste);
		controle.jBIncluir_actionPerformed(null);
		
		controle.jBLimpar_actionPerformed(null);
		clienteFake.jTClienteId.setText(idTeste);
		controle.jBConsultar_actionPerformed(null);
		
		assertEquals(controle.getFrmCliente().jTNome.getText(),nomeTeste);
		
	
	}

	@After
	public void Finaliza()  {
		controle = null;
		clienteFake = null;
	}

}
