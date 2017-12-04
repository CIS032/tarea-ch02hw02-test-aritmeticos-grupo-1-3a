/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmetica;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @grupo 1-3A
 */
public class Almacenadas {
     public static boolean validarUsuario(ArrayList<Enunciados> preguntas, String ced) {
        boolean sol = false;

        for (Enunciados elemento : preguntas) {
            if (elemento.getCedula().equals(ced)) {
                sol = true;
            }
        }
        return sol;
    }

    public static void presentarPreguntas(ArrayList<Enunciados> preguntas) {
        String ced = JOptionPane.showInputDialog(null, "Ingrese Cedula para mostrar Examen");
        boolean act = validarUsuario(preguntas, ced);
        if (act) {
            String aux = "";
            for (Enunciados  elemento : preguntas) {
                if (elemento.getCedula().equals(ced)) {
                    aux = aux + elemento.toString() + "\n";
                }

            }
            JOptionPane.showMessageDialog(null, "Resultado Examen:" + ced + "\n" + aux);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }

    }

    public static void calificarPreguntas(ArrayList<Enunciados> listaPreguntas) {
        int calificacion = 0;
        String ced = JOptionPane.showInputDialog(null, "Ingrese Cedula ");
        boolean act = validarUsuario(listaPreguntas, ced);
        if (act) {
            for (Enunciados elemento : listaPreguntas) {
                if (elemento.getCedula().equals(ced) && elemento.isContestada() == true) {
                    calificacion++;
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario con cedula: " + ced + "\nCalificacion\n" + calificacion);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }
    }
    
}
