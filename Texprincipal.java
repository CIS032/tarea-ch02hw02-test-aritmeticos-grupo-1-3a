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
public class Texprincipal {
    
      
public int posR = 0;
    public static void main(String[] args) {
        
        ArrayList<Enunciados> preguntas = new ArrayList<>();
        while (true) {            
            String menu= " 1-- Examen\n"
                        + "2-- Administarcion\n"
                        + "3--Calificacion\n"
                        + "4-- Salir";
                    int opcion=Integer.parseInt(JOptionPane.showInputDialog( menu));
            switch (opcion) {
                case 1:
                    boolean cerrar = true;
                    String cedula = "";
                    while (cerrar) {
                        cedula = JOptionPane.showInputDialog(null, "Ingrese cedula para rendir el examen");
                        if (cedula.length() < 10) {
                            JOptionPane.showMessageDialog(null, "Cedula Incorrecta");
                        } else {
                            cerrar = false;
                        }
                    }

                    int limPreguntas = 0;
                    int resultado = 0;
                    String pregunta = "";
                    int calificacion = 0;
                    int malas = 0;
                    boolean contestada = false;
                    while (limPreguntas < 10) {
                        int tipo_pregunta = (int) (Math.random() * 4 + 1);
                        switch (tipo_pregunta) {
                            case 1://Suma
                                PreguntaExtra extra = new PreguntaExtra();
                                resultado = extra.respuesta();
                                String opcionesArreglo1[] = obtenerOpciones(resultado);
                                int pregunS = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " 
                                                                           + pregunta, "Examen Aritmetico UNL", 
                                                                             JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,  
                                                                             null, opcionesArreglo1, opcionesArreglo1[0]);
                                if (opcionesArreglo1[pregunS].equals(String.valueOf(resultado))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta");
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta + " =" + resultado);
                                    malas++;
                                }
                                break;
                            case 2://RestaPregunta
                                PreguntaResta resta = new PreguntaResta();
                                resultado = resta.respuesta();
                                pregunta = resta.pregunta();
                                String opcionesArreglo2[] = obtenerOpciones(resultado);
                                int pregunR = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, 
                                                                           "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, 
                                                                            JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo2, opcionesArreglo2[0]);
                                if (opcionesArreglo2[pregunR].equals(String.valueOf(resultado))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta");
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta 
                                                                   + " =" + resultado);
                                    malas++;
                                }
                                break;
                            case 3://Multiplicacion
                                PreguntaMultiplicacion multiplicacion = new PreguntaMultiplicacion();
                                resultado = multiplicacion.respuesta();
                                pregunta = multiplicacion.pregunta();
                                String opcionesArreglo3[] = obtenerOpciones(resultado);
                                int pregunM = JOptionPane.showOptionDialog(null, "Seleccione la respuesta correcta:\n " + pregunta, "Examen Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesArreglo3, opcionesArreglo3[0]);
                                if (opcionesArreglo3[pregunM].equals(String.valueOf(resultado))) {
                                    JOptionPane.showMessageDialog(null, "Respuesta Correcta");
                                    contestada = true;
                                    calificacion++;
                                } else {
                                    contestada = false;
                                    JOptionPane.showMessageDialog(null, "Respuesta Inorrecta\nCorrecion: " + pregunta 
                                            + " =" + resultado);
                                    malas++;
                                }
                                break;
                            
                        }

                        Enunciados guardar = new Enunciados(cedula, pregunta, resultado, contestada);
                        preguntas.add(guardar);
                        limPreguntas++;
                    }
                    JOptionPane.showMessageDialog(null, "Examen terminado con exito\n Cedula " 
                                                    + cedula + "\n Correctas =" + calificacion 
                                                    + "\nIncorrectas " + malas + "\nCalificacion " + calificacion);
                    break;
                case 2:
                    Almacenadas.presentarPreguntas(preguntas);
                    break;
                case 3:
                    Almacenadas.calificarPreguntas(preguntas);
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    public static String[] obtenerOpciones(int respuesta) {
        String arregloOpciones[] = new String[4];
        int posResp = (int) (Math.random() * 6);
        for (int i = 0; i < arregloOpciones.length; i++) {
            if (i == posResp) {
                arregloOpciones[i] = String.valueOf(respuesta);
            } else {
                int opciones = (int) (Math.random() * 50 + 1);
                arregloOpciones[i] = String.valueOf(opciones);
            }
        }
        return arregloOpciones;
    }  
    
    
}
