import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ValidateNIT extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JMenuItem miRojo, miNegro, miMorado, miSalir, miNuevo;
    private final JTextField vatNumber;
    private final JButton buttonCalculate;
    @SuppressWarnings("rawtypes")
	private JComboBox typePerson;

    public ValidateNIT() {
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Colombia - Validate NIT");
        getContentPane().setBackground(new Color(255,0,0));
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255,0,0));
        setJMenuBar(menuBar);
        JMenu menuOpciones = new JMenu("Options");
        menuOpciones.setBackground(new Color(255,0,0));
        menuOpciones.setFont(new Font("Avondale Mono",1,16));
        menuOpciones.setForeground(new Color(255,255,255));
        menuBar.add(menuOpciones);
        JMenu menuColorFondo = new JMenu("Background color");
        menuColorFondo.setFont(new Font("Avondale Mono",1,14));
        menuColorFondo.setForeground(new Color(255,0,0));
        menuOpciones.add(menuColorFondo);
        miRojo = new JMenuItem("Red");
        miRojo.setFont(new Font("Avondale Mono",1,14));
        miRojo.setForeground(new Color(255,0,0));
        menuColorFondo.add(miRojo);
        miRojo.addActionListener(this);
        miNegro = new JMenuItem("Black");
        miNegro.setFont(new Font("Avondale Mono",1,14));
        miNegro.setForeground(new Color(255,0,0));
        menuColorFondo.add(miNegro);
        miNegro.addActionListener(this);
        miMorado = new JMenuItem("Purple");
        miMorado.setFont(new Font("Avondale Mono",1,14));
        miMorado.setForeground(new Color(255,0,0));
        menuColorFondo.add(miMorado);
        miMorado.addActionListener(this);
        miNuevo = new JMenuItem("Refresh");
        miNuevo.setFont(new Font("Avondale Mono",1,14));
        miNuevo.setForeground(new Color(255,0,0));
        menuOpciones.add(miNuevo);
        miNuevo.addActionListener(this);
        miSalir = new JMenuItem("Exit");
        miSalir.setFont(new Font("Avondale Mono",1,14));
        miSalir.setForeground(new Color(255,0,0));
        menuOpciones.add(miSalir);
        miSalir.addActionListener(this);
        JLabel labelNIT = new JLabel("Vat Number:");
        labelNIT.setBounds(25,30,188,25);
        labelNIT.setFont(new Font("Avondale Mono",1,14));
        labelNIT.setForeground(new Color(255,255,255));
        add(labelNIT);
        vatNumber = new JTextField();
        vatNumber.setBounds(25,60,150,25);
        vatNumber.setBackground(new Color(224,224,224));
        vatNumber.setFont(new Font("Avondale Mono", 1, 14));
        vatNumber.setForeground(new Color(255,0,0));
        add(vatNumber);
        JLabel labelTypePerson = new JLabel("Type Person:");
        labelTypePerson.setBounds(220,30,188,25);
        labelTypePerson.setFont(new Font("Avondale Mono",1,14));
        labelTypePerson.setForeground(new Color(255,255,255));
        add(labelTypePerson);
        typePerson = new JComboBox();
        typePerson.setBounds(220,60,220,25);
        typePerson.setBackground(new Color(224,224,224));
        typePerson.setFont(new Font("Avondale Mono", 1, 14));
        typePerson.setForeground(new Color(255,0,0));
        add(typePerson);
        typePerson.addItem("");
        typePerson.addItem("Persona Jurídica");
        typePerson.addItem("Persona Física");
        buttonCalculate = new JButton("Validate");
        buttonCalculate.setBounds(190,190,100,30);
        buttonCalculate.setFont(new Font("Avondale Mono",1,14));
        buttonCalculate.addActionListener(this);
        add(buttonCalculate);
        setBounds(0,0,480,300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonCalculate) {
            String VN = vatNumber.getText();
            String typeP = typePerson.getSelectedItem().toString();
            if (VN.equals("") || typeP.equals("")) {
                JOptionPane.showMessageDialog(this,
                        "<html><font face='Calibri' size='8' color='black'>Enter Vat Number and Type Person",
                        "WARNING",JOptionPane.WARNING_MESSAGE);
            } else {
                boolean resval;
                boolean TP = false;
                NITUtil valNIT = new NITUtil();
                if (typeP.equals("Persona Jurídica")) {
                    TP = true;
                }
                resval = valNIT.validateNIT(VN, TP);
                if (resval) {
                    JOptionPane.showMessageDialog(this,
                            "<html><font face='Calibri' size='8' color='black'>Vat Number OK",
                            "OK",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "<html><font face='Calibri' size='8' color='red'>Invalid Vat Number",
                            "ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if (e.getSource() == miRojo) {
            getContentPane().setBackground(new Color(255,0,0));
        }
        if (e.getSource() == miNegro) {
            getContentPane().setBackground(new Color(0,0,0));
        }
        if (e.getSource() == miMorado) {
            getContentPane().setBackground(new Color(51,0,51));
        }
        if (e.getSource() == miNuevo) {
            vatNumber.setText("");
            typePerson.setSelectedIndex(0);
        }
        if (e.getSource() == miSalir) {
            dispose();
        }
    }

    public static void main(String[] args) { new ValidateNIT();}

}
