/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author u1845853
 */
public class Util {

    public static void habilitar(boolean valor, JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);

        }
    }

    public static void limpar(JComponent... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            JComponent comp = componentes[i];
            //intanceof
            if (comp instanceof JTextField textField) {
                textField.setText("");
            } else if (comp instanceof JCheckBox checkBox) {
                checkBox.setSelected(false);
            } else if (comp instanceof JComboBox comboBox) {
                comboBox.setSelectedIndex(-1);
            } else if (comp instanceof JFormattedTextField formattedTextField) {
                formattedTextField.setText("");
            } else if (comp instanceof JPasswordField passwordField) {
                passwordField.setText("");
            }
        }

    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);

    }

    public static boolean pergunta(String cad) {
        int resposta = JOptionPane.showConfirmDialog(
                null,
                cad,
                "Confirmação",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return resposta == JOptionPane.YES_OPTION;

    }

    public static int strToInt(String num) {
        return Integer.valueOf(num);
    }

    public static String atrToInt(String num) {
        return String.valueOf(num);
    }

    public static double strToDouble(String num) {
        return 0.0;
    }

    public static Integer doubleToStr(String num) {
        try {
            return Integer.valueOf(num);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Valor inválido: " + num);
        }
    }

    public static Date strToDate(String data) {
        return null;
    }

    public static String strToStr(Date data) {
        return "";
    }

    public static String dateToStr(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

    // Perguntar para o titio Marcos se posso fazer um metodo para verificar sé é um numero ou um texto
    
//    public static boolean validarNumero(javax.swing.JTextField campo, String msg) {
//    try {
//        Integer.parseInt(campo.getText());
//        return true;
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(null, msg, "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
//        campo.setText("");
//        campo.requestFocus();
//        return false;
//    }
//}
}
