package gui;

import modelo.Calculadora;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class VentanaCalculadora extends JFrame implements ActionListener {


    private String memoriaPrincipal = "";
    private String memoriaSecundaria = "";
    private String memoriaOperacion = "";
    private JPanel panel;
    private ArrayList<JButton> botones;
    private JTextArea areaTexto;
    private JButton botonCero;
    private JButton botonUno;
    private JButton botonDos;
    private JButton botonTres;
    private JButton botonCuatro;
    private JButton botonCinco;
    private JButton botonSeis;
    private JButton botonSiete;
    private JButton botonOcho;
    private JButton botonNueve;
    private JButton botonPunto;
    private JButton botonIgual;
    private JButton botonSuma;
    private JButton botonResta;
    private JButton botonPor;
    private JButton botonDivision;
    private JButton botonModulo;
    private JButton botonLimpiar;
    private JButton botonBorrar;

    public VentanaCalculadora() {
        this.setTitle("Calculadora");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializar();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void inicializar() {
        agregarActionCommand();
        crearBotones();
        activarListener();
        this.add(panel);
    }

    public void activarListener() {

        for (JButton boton : botones) {
            boton.addActionListener(this);
        }
    }

    public void agregarActionCommand() {
        botonCero.setActionCommand("NUMERO_0");
        botonUno.setActionCommand("NUMERO_1");
        botonDos.setActionCommand("NUMERO_2");
        botonTres.setActionCommand("NUMERO_3");
        botonCuatro.setActionCommand("NUMERO_4");
        botonCinco.setActionCommand("NUMERO_5");
        botonSeis.setActionCommand("NUMERO_6");
        botonSiete.setActionCommand("NUMERO_7");
        botonOcho.setActionCommand("NUMERO_8");
        botonNueve.setActionCommand("NUMERO_9");
        botonSuma.setActionCommand("+");
        botonResta.setActionCommand("-");
        botonPor.setActionCommand("*");
        botonDivision.setActionCommand("÷");
        botonLimpiar.setActionCommand("C");
        botonBorrar.setActionCommand("BORRAR");
    }

    public void crearBotones() {
        botones = new ArrayList<>();
        botones.add(botonCero);
        botones.add(botonUno);
        botones.add(botonDos);
        botones.add(botonTres);
        botones.add(botonCuatro);
        botones.add(botonCinco);
        botones.add(botonSeis);
        botones.add(botonSiete);
        botones.add(botonOcho);
        botones.add(botonNueve);
        botones.add(botonPunto);
        botones.add(botonSuma);
        botones.add(botonResta);
        botones.add(botonPor);
        botones.add(botonDivision);
        botones.add(botonModulo);
        botones.add(botonIgual);
        botones.add(botonBorrar);
        botones.add(botonLimpiar);
    }

    public void sumar(double numero1, double numero2, Calculadora calculadora) {
        areaTexto.setText(String.valueOf(calculadora.sumar(numero1, numero2)));
    }

    public void restar(double numero1, double numero2, Calculadora calculadora) {
        areaTexto.setText(String.valueOf(calculadora.restar(numero1, numero2)));
    }

    public void multiplicar(double numero1, double numero2, Calculadora calculadora) {
        areaTexto.setText(String.valueOf(calculadora.multiplicar(numero1, numero2)));
    }

    public void dividir(double numero1, double numero2, Calculadora calculadora) {
        if (!calculadora.validarDivisionPorCero(numero2)) {
            areaTexto.setText("");
            memoriaPrincipal = "";
            memoriaSecundaria = "";
            JOptionPane.showMessageDialog(panel, "No se puede dividir por cero");
            return;
        }
        areaTexto.setText(String.valueOf(calculadora.dividir(numero1, numero2)));
    }

    public void modulo(double numero1, double numero2, Calculadora calculadora) {
        areaTexto.setText(String.valueOf(calculadora.modulo(numero1, numero2)));
    }

    public void elegirOperacion(Calculadora calculadora, double numero1, double numero2) {

        switch (memoriaOperacion) {
            case "+" -> sumar(numero1, numero2, calculadora);
            case "-" -> restar(numero1, numero2, calculadora);
            case "*" -> multiplicar(numero1, numero2, calculadora);
            case "÷" -> dividir(numero1, numero2, calculadora);
            case "%" -> modulo(numero1, numero2, calculadora);
        }
    }

    public void presionarOperacion() {
        memoriaSecundaria = "";
        memoriaPrincipal = areaTexto.getText();
        areaTexto.setText("");
    }

    public void presionarIgual() {
        Calculadora calculadora = new Calculadora();
        double numero1 = Double.parseDouble(memoriaPrincipal);
        double numero2 = Double.parseDouble(areaTexto.getText());
        elegirOperacion(calculadora, numero1, numero2);
        memoriaSecundaria = areaTexto.getText();
    }

    public void presionarBorrar() {
        memoriaSecundaria = memoriaSecundaria.substring(0, memoriaSecundaria.length() - 1);
        areaTexto.setText(memoriaSecundaria);
    }

    public void presionarLimpiar() {
        memoriaPrincipal = "";
        memoriaSecundaria = "";
        memoriaOperacion = "";
        areaTexto.setText(" 0000000000");
    }

    public void presionarPunto() {
        memoriaSecundaria += ".";
        areaTexto.setText(memoriaSecundaria);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String eleccion = e.getActionCommand();
        String numero = "";
        if (e.getActionCommand().contains("_")) {
            numero = e.getActionCommand().split("_")[1];
            eleccion = e.getActionCommand().split("_")[0];
        }
        switch (eleccion) {
            case "NUMERO" -> {
                memoriaSecundaria += numero;
                areaTexto.setText(memoriaSecundaria);
            }
            case "+" -> {
                memoriaOperacion = "+";
                presionarOperacion();
            }
            case "-" -> {
                memoriaOperacion = "-";
                presionarOperacion();
            }
            case "*" -> {
                memoriaOperacion = "*";
                presionarOperacion();
            }
            case "÷" -> {
                memoriaOperacion = "÷";
                presionarOperacion();
            }

            case "%" -> {
                memoriaOperacion = "%";
                presionarOperacion();
            }

            case "." -> {
                if (!memoriaSecundaria.contains(".")) {
                    presionarPunto();
                }
            }
            case "=" -> {
                if (!memoriaSecundaria.equals("") && !memoriaPrincipal.equals("")) {
                    presionarIgual();
                } else {
                    areaTexto.setText(memoriaSecundaria);
                }
            }
            case "BORRAR" -> {
                if (!memoriaSecundaria.equals("")) {
                    presionarBorrar();
                }
            }
            case "C" -> {
                presionarLimpiar();
            }
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(8, 5, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        botonCero = new JButton();
        Font botonCeroFont = this.$$$getFont$$$(null, -1, 36, botonCero.getFont());
        if (botonCeroFont != null) botonCero.setFont(botonCeroFont);
        botonCero.setRequestFocusEnabled(false);
        botonCero.setText("0");
        panel.add(botonCero, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonUno = new JButton();
        Font botonUnoFont = this.$$$getFont$$$(null, -1, 36, botonUno.getFont());
        if (botonUnoFont != null) botonUno.setFont(botonUnoFont);
        botonUno.setHideActionText(false);
        botonUno.setHorizontalAlignment(0);
        botonUno.setHorizontalTextPosition(11);
        botonUno.setRequestFocusEnabled(false);
        botonUno.setText("1");
        panel.add(botonUno, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonDos = new JButton();
        Font botonDosFont = this.$$$getFont$$$(null, -1, 36, botonDos.getFont());
        if (botonDosFont != null) botonDos.setFont(botonDosFont);
        botonDos.setRequestFocusEnabled(false);
        botonDos.setText("2");
        panel.add(botonDos, new com.intellij.uiDesigner.core.GridConstraints(6, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonTres = new JButton();
        Font botonTresFont = this.$$$getFont$$$(null, -1, 36, botonTres.getFont());
        if (botonTresFont != null) botonTres.setFont(botonTresFont);
        botonTres.setRequestFocusEnabled(false);
        botonTres.setText("3");
        panel.add(botonTres, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonCuatro = new JButton();
        Font botonCuatroFont = this.$$$getFont$$$(null, -1, 36, botonCuatro.getFont());
        if (botonCuatroFont != null) botonCuatro.setFont(botonCuatroFont);
        botonCuatro.setHorizontalAlignment(0);
        botonCuatro.setRequestFocusEnabled(false);
        botonCuatro.setText("4");
        panel.add(botonCuatro, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonCinco = new JButton();
        Font botonCincoFont = this.$$$getFont$$$(null, -1, 36, botonCinco.getFont());
        if (botonCincoFont != null) botonCinco.setFont(botonCincoFont);
        botonCinco.setRequestFocusEnabled(false);
        botonCinco.setText("5");
        panel.add(botonCinco, new com.intellij.uiDesigner.core.GridConstraints(5, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonSeis = new JButton();
        Font botonSeisFont = this.$$$getFont$$$(null, -1, 36, botonSeis.getFont());
        if (botonSeisFont != null) botonSeis.setFont(botonSeisFont);
        botonSeis.setRequestFocusEnabled(false);
        botonSeis.setText("6");
        panel.add(botonSeis, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonSiete = new JButton();
        Font botonSieteFont = this.$$$getFont$$$(null, -1, 36, botonSiete.getFont());
        if (botonSieteFont != null) botonSiete.setFont(botonSieteFont);
        botonSiete.setRequestFocusEnabled(false);
        botonSiete.setText("7");
        panel.add(botonSiete, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonOcho = new JButton();
        Font botonOchoFont = this.$$$getFont$$$(null, -1, 36, botonOcho.getFont());
        if (botonOchoFont != null) botonOcho.setFont(botonOchoFont);
        botonOcho.setRequestFocusEnabled(false);
        botonOcho.setText("8");
        panel.add(botonOcho, new com.intellij.uiDesigner.core.GridConstraints(4, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonNueve = new JButton();
        Font botonNueveFont = this.$$$getFont$$$(null, -1, 36, botonNueve.getFont());
        if (botonNueveFont != null) botonNueve.setFont(botonNueveFont);
        botonNueve.setRequestFocusEnabled(false);
        botonNueve.setText("9");
        panel.add(botonNueve, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonPunto = new JButton();
        Font botonPuntoFont = this.$$$getFont$$$(null, -1, 36, botonPunto.getFont());
        if (botonPuntoFont != null) botonPunto.setFont(botonPuntoFont);
        botonPunto.setRequestFocusEnabled(false);
        botonPunto.setText(".");
        panel.add(botonPunto, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonIgual = new JButton();
        Font botonIgualFont = this.$$$getFont$$$(null, -1, 36, botonIgual.getFont());
        if (botonIgualFont != null) botonIgual.setFont(botonIgualFont);
        botonIgual.setRequestFocusEnabled(false);
        botonIgual.setText("=");
        panel.add(botonIgual, new com.intellij.uiDesigner.core.GridConstraints(7, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonResta = new JButton();
        Font botonRestaFont = this.$$$getFont$$$(null, -1, 36, botonResta.getFont());
        if (botonRestaFont != null) botonResta.setFont(botonRestaFont);
        botonResta.setRequestFocusEnabled(false);
        botonResta.setText("-");
        panel.add(botonResta, new com.intellij.uiDesigner.core.GridConstraints(5, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonPor = new JButton();
        Font botonPorFont = this.$$$getFont$$$(null, -1, 36, botonPor.getFont());
        if (botonPorFont != null) botonPor.setFont(botonPorFont);
        botonPor.setRequestFocusEnabled(false);
        botonPor.setText("x");
        panel.add(botonPor, new com.intellij.uiDesigner.core.GridConstraints(4, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonModulo = new JButton();
        Font botonModuloFont = this.$$$getFont$$$(null, -1, 36, botonModulo.getFont());
        if (botonModuloFont != null) botonModulo.setFont(botonModuloFont);
        botonModulo.setRequestFocusEnabled(false);
        botonModulo.setText("%");
        panel.add(botonModulo, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonLimpiar = new JButton();
        Font botonReiniciarFont = this.$$$getFont$$$(null, -1, 36, botonLimpiar.getFont());
        if (botonReiniciarFont != null) botonLimpiar.setFont(botonReiniciarFont);
        botonLimpiar.setRequestFocusEnabled(false);
        botonLimpiar.setText("C");
        panel.add(botonLimpiar, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonBorrar = new JButton();
        Font botonDelFont = this.$$$getFont$$$(null, -1, 36, botonBorrar.getFont());
        if (botonDelFont != null) botonBorrar.setFont(botonDelFont);
        botonBorrar.setRequestFocusEnabled(false);
        botonBorrar.setText("DEL");
        panel.add(botonBorrar, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        Font aTextAreaFont = this.$$$getFont$$$(null, -1, 72, areaTexto.getFont());
        if (aTextAreaFont != null) areaTexto.setFont(aTextAreaFont);
        areaTexto.setForeground(new Color(-8618112));
        areaTexto.setText(" 0000000000");
        panel.add(areaTexto, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 3, 4, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panel.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        botonDivision = new JButton();
        Font botonDivisionFont = this.$$$getFont$$$(null, -1, 48, botonDivision.getFont());
        if (botonDivisionFont != null) botonDivision.setFont(botonDivisionFont);
        botonDivision.setRequestFocusEnabled(false);
        botonDivision.setText("÷");
        panel.add(botonDivision, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        botonSuma = new JButton();
        Font botonSumaFont = this.$$$getFont$$$(null, -1, 72, botonSuma.getFont());
        if (botonSumaFont != null) botonSuma.setFont(botonSumaFont);
        botonSuma.setRequestFocusEnabled(false);
        botonSuma.setText("+");
        panel.add(botonSuma, new com.intellij.uiDesigner.core.GridConstraints(6, 4, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
