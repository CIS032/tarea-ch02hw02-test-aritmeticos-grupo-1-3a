
package aritmetica;

/**
 *
 * @grupo 1-3A
 */
public class PreguntaMultiplicacion implements Preguntas {

    private int mult1;
    private int mult2;

    public PreguntaMultiplicacion() {
        this.mult1 = (int) (Math.random() * 50 + 1);
        this.mult2 = (int) (Math.random() * 50);

    }

    @Override
    public String pregunta() {
        return "¿Cual es la multiplicacion de:"+ mult1 + " * " + mult2+" ?";
    }

    @Override
    public int respuesta() {
        return mult1 * mult2;

    }
}
