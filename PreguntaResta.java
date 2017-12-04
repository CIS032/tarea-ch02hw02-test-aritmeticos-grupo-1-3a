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
public class PreguntaResta implements Preguntas{
private int res1;
private int res2;

    public PreguntaResta() {
        this.res1 = (int)(Math.random()*50+1);
        this.res2 = (int)(Math.random()*50);
    }

    @Override
    public String pregunta() {
        return "Cual es la resta de: "+res1 +" - "+ res2+ "?" ;
    }

    @Override
    public int respuesta() {
         return res1-res2;
    }
    
}
