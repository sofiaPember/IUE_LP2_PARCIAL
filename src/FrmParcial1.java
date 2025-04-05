import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class FrmParcial1 extends JFrame {

    private JComboBox<String> cmbFrase, cmbidioma;
    private JTextField txtfrasetraducida;
    private JButton btnReproducir;
    private Map<String, Map<String, String>> traducciones;

    public FrmParcial1() {
        inicializarTraducciones();
        setSize(500, 400);
        setTitle("Traductor");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblFrase = new JLabel("Frase");
        lblFrase.setBounds(20, 10, 100, 25);
        getContentPane().add(lblFrase);

        cmbFrase = new JComboBox<>();
        cmbFrase.setBounds(70, 10, 150, 25);
        String[] Frases = new String[] { "Hola", "Buenos dias", "Buenas tardes", "Como estas", "De donde vienes",
                "Como te llamas",
                "Buenas noches" };
        DefaultComboBoxModel<String> mdlFrases = new DefaultComboBoxModel<>(Frases);
        cmbFrase.setModel(mdlFrases);
        getContentPane().add(cmbFrase);

        JLabel lblidioma = new JLabel("Idioma");
        lblidioma.setBounds(20, 50, 100, 25);
        getContentPane().add(lblidioma);

        cmbidioma = new JComboBox<>();
        cmbidioma.setBounds(70, 50, 120, 25);
        String[] Idiomas = new String[] { "Aleman", "Frances", "Ingles", "Ruso" };
        DefaultComboBoxModel<String> mdlIdiomas = new DefaultComboBoxModel<>(Idiomas);
        cmbidioma.setModel(mdlIdiomas);
        getContentPane().add(cmbidioma);

        JButton btnTraducir = new JButton("Traducir");
        btnTraducir.setBounds(20, 90, 90, 25);
        btnTraducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traducirFrase();
            }
        });
        getContentPane().add(btnTraducir);

        txtfrasetraducida = new JTextField();
        txtfrasetraducida.setBounds(20, 130, 300, 80);
        getContentPane().add(txtfrasetraducida);

        // Botón para reproducir audio
        btnReproducir = new JButton();
        btnReproducir.setBounds(330, 130, 60, 60); // A la derecha del campo de texto

        // Intentamos cargar una imagen de altavoz (si existe)
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/audio_icon.png"));
            btnReproducir.setIcon(icono);
        } catch (Exception e) {
            // Si no se puede cargar la imagen, usamos un símbolo de altavoz como texto
            btnReproducir.setText("🔊");
        }

        // Agregamos el ActionListener para reproducir audio
        btnReproducir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproducirAudio();
            }
        });

        getContentPane().add(btnReproducir);
    }

    private void inicializarTraducciones() {
        traducciones = new HashMap<>();

        // Traducciones para "Hola"
        Map<String, String> holaTraduccion = new HashMap<>();
        holaTraduccion.put("Aleman", "Hallo");
        holaTraduccion.put("Frances", "Bonjour");
        holaTraduccion.put("Ingles", "Hello");
        holaTraduccion.put("Ruso", "Привет");
        traducciones.put("Hola", holaTraduccion);

        // Traducciones para "Buenos dias"
        Map<String, String> buenosDiasTraduccion = new HashMap<>();
        buenosDiasTraduccion.put("Aleman", "Guten Morgen");
        buenosDiasTraduccion.put("Frances", "Bonjour");
        buenosDiasTraduccion.put("Ingles", "Good morning");
        buenosDiasTraduccion.put("Ruso", "Доброе утро");
        traducciones.put("Buenos dias", buenosDiasTraduccion);

        // Traducciones para "Buenas tardes"
        Map<String, String> buenasTardesTraduccion = new HashMap<>();
        buenasTardesTraduccion.put("Aleman", "Guten Tag");
        buenasTardesTraduccion.put("Frances", "Bon après-midi");
        buenasTardesTraduccion.put("Ingles", "Good afternoon");
        buenasTardesTraduccion.put("Ruso", "Добрый день");
        traducciones.put("Buenas tardes", buenasTardesTraduccion);

        // Traducciones para "Como estas"
        Map<String, String> comoEstasTraduccion = new HashMap<>();
        comoEstasTraduccion.put("Aleman", "Wie geht es dir");
        comoEstasTraduccion.put("Frances", "Comment ça va");
        comoEstasTraduccion.put("Ingles", "How are you");
        comoEstasTraduccion.put("Ruso", "Как дела");
        traducciones.put("Como estas", comoEstasTraduccion);

        // Traducciones para "De donde vienes"
        Map<String, String> deDondeVienesTraduccion = new HashMap<>();
        deDondeVienesTraduccion.put("Aleman", "Woher kommst du");
        deDondeVienesTraduccion.put("Frances", "D'où viens-tu");
        deDondeVienesTraduccion.put("Ingles", "Where are you from");
        deDondeVienesTraduccion.put("Ruso", "Откуда ты");
        traducciones.put("De donde vienes", deDondeVienesTraduccion);

        // Traducciones para "Como te llamas"
        Map<String, String> comoTeLlamasTraduccion = new HashMap<>();
        comoTeLlamasTraduccion.put("Aleman", "Wie heißt du");
        comoTeLlamasTraduccion.put("Frances", "Comment t'appelles-tu");
        comoTeLlamasTraduccion.put("Ingles", "What is your name");
        comoTeLlamasTraduccion.put("Ruso", "Как тебя зовут");
        traducciones.put("Como te llamas", comoTeLlamasTraduccion);

        // Traducciones para "Buenas noches"
        Map<String, String> buenasNochesTraduccion = new HashMap<>();
        buenasNochesTraduccion.put("Aleman", "Gute Nacht");
        buenasNochesTraduccion.put("Frances", "Bonne nuit");
        buenasNochesTraduccion.put("Ingles", "Good night");
        buenasNochesTraduccion.put("Ruso", "Спокойной ночи");
        traducciones.put("Buenas noches", buenasNochesTraduccion);
    }

    private void traducirFrase() {
        String fraseSeleccionada = (String) cmbFrase.getSelectedItem();
        String idiomaSeleccionado = (String) cmbidioma.getSelectedItem();

        if (traducciones.containsKey(fraseSeleccionada) &&
                traducciones.get(fraseSeleccionada).containsKey(idiomaSeleccionado)) {
            String traduccion = traducciones.get(fraseSeleccionada).get(idiomaSeleccionado);
            txtfrasetraducida.setText(traduccion);
        } else {
            txtfrasetraducida.setText("Traducción no disponible");
        }
    }

    private void reproducirAudio() {
        String fraseSeleccionada = (String) cmbFrase.getSelectedItem();
        String idiomaSeleccionado = (String) cmbidioma.getSelectedItem();

        // Formatear el nombre del archivo según tu estructura de carpetas
        String nombreFrase = fraseSeleccionada.replace(" ", "");

        // Construir la ruta del archivo de audio basada en la estructura que mostraste
        String rutaAudio = "../audios/" + nombreFrase + "-" + idiomaSeleccionado + ".mp3";

        try {
            File audioFile = new File(rutaAudio);

            if (!audioFile.exists()) {
                System.out.println("Archivo no encontrado: " + rutaAudio);
                JOptionPane.showMessageDialog(this,
                        "No se encontró el archivo de audio: " + rutaAudio,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Usar el reproductor predeterminado del sistema para abrir el archivo MP3
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(audioFile);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Su sistema no soporta la reproducción automática de archivos.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Su sistema no soporta la reproducción automática de archivos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Error al reproducir el audio: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error genérico: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Error al reproducir el audio: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}