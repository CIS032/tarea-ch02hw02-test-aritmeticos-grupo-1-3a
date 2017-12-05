
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leonardo
 */
public class Principal_Test {
    public static void main(String[] args) {
        ArrayList<Preguntas_Rendidas> listaExamenes=new ArrayList<>();
        Pregunta_Respuesta preg_resp = null;
        while (true) {
            int command = JOptionPane.showOptionDialog(null, "CIS 2017", "UNL", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    new Object[]{"Rendir Examen",
                        "Administrar Examen",
                        "Calificar Examen",
                        "Salir"}, null);
            switch (command) {
                case 0:
                    String dat = JOptionPane.showInputDialog(null, "Ingrese nombre");
                    String nombre=ObtenerUsuario(dat);
                    if (!Consultas_Examenes.validarUsuario(listaExamenes, nombre)) {
                        
                    boolean respuestaC=false;
                    int limitePregunta = 0;
                    while (limitePregunta < 10) {
                        String opciones[];
                        int tipoPregunta = (int) (Math.random() * 3 + 1);
                        switch (tipoPregunta) {
                            case 1:
                                
                                Pregunta_Suma preguntaSuma = new Pregunta_Suma();
                                opciones = obtenerOpciones(preguntaSuma.respuesta());
                                int selecionPreguntaSuma = JOptionPane.showOptionDialog(null, preguntaSuma.pregunta(), "Test Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                                respuestaC=calificarRespuesta(opciones[selecionPreguntaSuma], preguntaSuma.respuesta());
                                preg_resp=preguntaSuma;
                                break;
                            case 2:
                                Pregunta_Resta preguntaResta = new Pregunta_Resta();
                                opciones = obtenerOpciones(preguntaResta.respuesta());
                                int selecionPreguntaResta = JOptionPane.showOptionDialog(null, preguntaResta.pregunta(), "Test Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                                respuestaC=calificarRespuesta(opciones[selecionPreguntaResta], preguntaResta.respuesta());
                                preg_resp=preguntaResta;
                                break;
                            case 3:
                                Pregunta_Multiplicacion preguntaMultiplicacion = new Pregunta_Multiplicacion();
                                opciones = obtenerOpciones(preguntaMultiplicacion.respuesta());
                                int selecionPreguntaMultiplicacion = JOptionPane.showOptionDialog(null, preguntaMultiplicacion.pregunta(), "Test Aritmetico UNL", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                                respuestaC=calificarRespuesta(opciones[selecionPreguntaMultiplicacion], preguntaMultiplicacion.respuesta());
                                preg_resp=preguntaMultiplicacion;
                                break;
                        }
                        limitePregunta++;
                        Preguntas_Rendidas preguntasT=new Preguntas_Rendidas(nombre,preg_resp , respuestaC);
                        listaExamenes.add(preguntasT);
                    }
                    }else{
                        JOptionPane.showMessageDialog(null,"Usuario ya rindio Examen","Test Aritmetico",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    Consultas_Examenes.presentarPreguntas(listaExamenes);
                    break;
                case 2:
                    Consultas_Examenes.calificarPreguntas(listaExamenes);
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    public static String ObtenerUsuario(String nombre) {
        String usuario = "";
        String siglas = String.valueOf(nombre.charAt(0));
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == ' ') {
                siglas = siglas + nombre.charAt(i + 1);
            }
        }
        return "usuario" + siglas;
    }

    public static String[] obtenerOpciones(int respuesta) {
        String arregloOpciones[] = new String[4];
        int posResp = (int) (Math.random() * 4);
        for (int i = 0; i < arregloOpciones.length; i++) {
            if (i == posResp) {
                arregloOpciones[i] = String.valueOf(respuesta);
            } else {
                int opciones = (int) (Math.random() * 100 + 1);
                arregloOpciones[i] = String.valueOf(opciones);
            }
        }
        return arregloOpciones;
    }
    public static boolean calificarRespuesta(String seleccion,int respuesta){
        boolean calificar=false;
        if (Integer.parseInt(seleccion)==respuesta) {
            calificar=true;
        }else{
            calificar=false;
            JOptionPane.showMessageDialog(null,"Respuesta Incorrecta","Test Aritmetico",JOptionPane.ERROR_MESSAGE);
        }
        return calificar;
    }
}
