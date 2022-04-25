package formulario;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmClienteFake extends FrmCliente{

	public FrmClienteFake() {
		inicializar();
	}

	private void inicializar() {
		jTClienteId = new JTextField();
		jTNome = new JTextField();
		jTCpf = new JTextField();
	}
	
	public void mostrarMensagem(String mensagem){
	}


	/*protected void processWindowEvent(WindowEvent e) {
		super.processWindowEvent(e);
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			System.exit(0);
		}
	}*/

}
