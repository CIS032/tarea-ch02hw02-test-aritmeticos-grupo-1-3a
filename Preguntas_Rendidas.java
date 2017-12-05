
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goquezadag
 */
public class Preguntas_Rendidas {
    private String usuario;
    Pregunta_Respuesta preguntaRespuesta;
    private boolean contestada;

    public Preguntas_Rendidas(String usuario, Pregunta_Respuesta preguntaRespuesta, boolean contestada) {
        this.usuario = usuario;
        setPreguntaRespuesta(preguntaRespuesta);
        this.contestada = contestada;
    }

    @Override
    public String toString() {
        return usuario + "    " +  preguntaRespuesta.pregunta()+" = "+preguntaRespuesta.respuesta() + "    " + contestada;
    }

    public Preguntas_Rendidas(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preguntas_Rendidas other = (Preguntas_Rendidas) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

    public Preguntas_Rendidas() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Pregunta_Respuesta getPreguntaRespuesta() {
        return preguntaRespuesta;
    }

    public void setPreguntaRespuesta(Pregunta_Respuesta preguntaRespuesta) {
        this.preguntaRespuesta = preguntaRespuesta;
    }

    public boolean isContestada() {
        return contestada;
    }

    public void setContestada(boolean contestada) {
        this.contestada = contestada;
    }
    
}
