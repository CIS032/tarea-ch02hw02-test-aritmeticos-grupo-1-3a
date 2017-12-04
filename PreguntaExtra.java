/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aritmetica;

/**
 *
 * @grupo 1-3A
 */
public class PreguntaExtra implements Preguntas{
    private int sum1;
    private int suma2;
     
    public PreguntaExtra() {
        this.sum1 = (int)(Math.random()*50+1);
        this.suma2 = (int)(Math.random()*50);
    }

    @Override
    public String pregunta() {
        return "¿Cuanto es la suma de:" +sum1+" + "+suma2+" ?";
    }

    @Override
    public int respuesta() {
        return sum1+suma2;
    }

}
