
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author goquezadag
 */
public class Consultas_Examenes {

    public static boolean validarUsuario(ArrayList<Preguntas_Rendidas> listaPreguntas, String usuario) {
        boolean res = false;

        for (Preguntas_Rendidas elemento : listaPreguntas) {
            if (elemento.getUsuario().equals(usuario)) {
                res = true;
            }
        }
        return res;
    }

    public static void presentarPreguntas(ArrayList<Preguntas_Rendidas> listaPreguntas) {
        String usuario = JOptionPane.showInputDialog(null, "Ingrese usuario para mostrar Examen", "UNL", JOptionPane.QUESTION_MESSAGE);
        boolean act = validarUsuario(listaPreguntas, usuario);
        if (act) {
            String aux = "";
            for (Preguntas_Rendidas elemento : listaPreguntas) {
                if (elemento.getUsuario().equals(usuario)) {
                    aux = aux + elemento.toString() + "\n";
                }

            }
            JOptionPane.showMessageDialog(null, "Resultado Examen:" + usuario + "\n" + aux, "UNL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe", "UNL", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void calificarPreguntas(ArrayList<Preguntas_Rendidas> listaPreguntas) {
        int calificacion = 0;
        String usuario = JOptionPane.showInputDialog(null, "Ingrese usuario para calificar Examen", "UNL", JOptionPane.QUESTION_MESSAGE);
        boolean act = validarUsuario(listaPreguntas, usuario);
        if (act) {
            for (Preguntas_Rendidas elemento : listaPreguntas) {
                if (elemento.getUsuario().equals(usuario) && elemento.isContestada() == true) {
                    calificacion++;
                }
            }
            JOptionPane.showMessageDialog(null, "Señor: " + usuario + "\nCalificacion\n" + calificacion, "UNL", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe", "UNL", JOptionPane.ERROR_MESSAGE);
        }
    }
}
