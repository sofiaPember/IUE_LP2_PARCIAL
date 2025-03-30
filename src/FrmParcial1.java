import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class FrmParcial1 extends JFrame {

    private JComboBox cmbFrase, cmbidioma;
    private JTextField txtfrasetraducida;

    public FrmParcial1() {
        setSize(500, 400);
        setTitle("Traductor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblFrase = new JLabel("Frase");
        lblFrase.setBounds(20, 10, 100, 25);
        getContentPane().add(lblFrase);

        cmbFrase = new JComboBox();
        cmbFrase.setBounds(70, 10, 150, 25);
        String[] Frases = new String[] { "Hola", "Buenos dias", "Como estas", "De donde vienes", "Como te llamas",
                "Buenas noches" };
        DefaultComboBoxModel mdlFrases = new DefaultComboBoxModel(Frases);
        cmbFrase.setModel(mdlFrases);
        getContentPane().add(cmbFrase);

        JLabel lblidioma = new JLabel("Idioma");
        lblidioma.setBounds(20, 50, 100, 25);
        getContentPane().add(lblidioma);

        cmbidioma = new JComboBox();
        cmbidioma.setBounds(70, 50, 120, 25);
        String[] Idiomas = new String[] { "Aleman", "Frances", "Ingles", "Ruso" };
        DefaultComboBoxModel mdlIdiomas = new DefaultComboBoxModel(Idiomas);
        cmbidioma.setModel(mdlIdiomas);
        getContentPane().add(cmbidioma);

        JButton btnTraducir = new JButton("Traducir");
        btnTraducir.setBounds(20, 90, 90, 25);
        getContentPane().add(btnTraducir);

        txtfrasetraducida = new JTextField();
        txtfrasetraducida.setBounds(20, 130, 300, 80);
        getContentPane().add(txtfrasetraducida);

    }

}
