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
            if (componentes[i] instanceof JTextField) {
                ((JTextField) componentes[i]).setText("");
            } else if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false);
            } else if (componentes[i] instanceof JComboBox) {
                ((JComboBox<?>) componentes[i]).setSelectedIndex(-1); // limpa seleção
            } else if (componentes[i] instanceof JFormattedTextField) {
                ((JFormattedTextField) componentes[i]).setText("");
            } else if (componentes[i] instanceof JPasswordField) {
                ((JPasswordField) componentes[i]).setText("");
            }
        }

    }

    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);

    }

     public static boolean perguntar(String cad) {
        JOptionPane.showConfirmDialog(null, cad);
        return true;
    }

    public static int strToInt(String num) {
        return Integer.parseInt(num);
    }

    public static String atrToInt(String num) {
        return String.valueOf(num);
    }

    public static String intToStr(int num) {
        return String.valueOf(num);
    }

     public static double strToDouble(String num) {
        return Double.parseDouble(num);
    }

//    public static Integer doubleToStr(String num) {
//        try {
//            return Integer.valueOf(num);
//        } catch (NumberFormatException e) {
//            throw new NumberFormatException("Valor inválido: " + num);
//        }
//    }

    public static String doubleToStr(double num) {
        return String.valueOf(num);
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

    public static boolean validarNumero(javax.swing.JTextField campo, String msg) {
        try {
            Integer.parseInt(campo.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, msg, "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
            campo.setText("");
            campo.requestFocus();
            return false;
        }
    }
}
