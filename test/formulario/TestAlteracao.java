package formulario;

import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.CtrCliente;

public class TestAlteracao {
	private static CtrCliente controle = null;
	private static FrmClienteFake frmCliente = null; 		

	@Before
	public void setUp() throws Exception {
		frmCliente = new FrmClienteFake();
		controle = new CtrCliente();
		controle.setFrmCliente(frmCliente);				
	}
	
	@Test
	public void testAlteracao(){
		String idTeste = "1";
		String nomeTeste = "Carlos";
		String cpfTeste = "11111111111";
		
		//Grava o cliente teste
		frmCliente.jTClienteId.setText(idTeste);
		frmCliente.jTNome.setText(nomeTeste);
		frmCliente.jTCpf.setText(cpfTeste);
		controle.jBIncluir_actionPerformed(null);
		
		//Consulta o cliente teste
		controle.jBLimpar_actionPerformed(null);
		frmCliente.jTClienteId.setText(idTeste);
		controle.jBConsultar_actionPerformed(null);
		String nome1 = controle.getFrmCliente().jTNome.getText();
		
		//Altera o cliente teste
		frmCliente.jTNome.setText("Altera��o");
		controle.jBAlterar_actionPerformed(null);
		controle.jBLimpar_actionPerformed(null);
		frmCliente.jTClienteId.setText(idTeste);
		controle.jBConsultar_actionPerformed(null);
		String nome2 = controle.getFrmCliente().jTNome.getText();
		
		assertFalse(nome1.equalsIgnoreCase(nome2));				
	}

	@After
	public void tearDown() throws Exception {
		controle = null;
		frmCliente = null;			
	}

}
