/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonardo
 */
public class Pregunta_Resta extends Pregunta_Respuesta{
    private int n1,n2;

    public Pregunta_Resta() {
        this.n1 = (int)(Math.random()*100+1);
        this.n2 = (int)(Math.random()*100);
    }
    
    @Override
    public String pregunta() {
        return "Identifique la respuesta a la siguiente operacion: "+ n1+" - "+n2 ;
    }

    @Override
    public int respuesta() {
        return n1-n2;
    }    
}
