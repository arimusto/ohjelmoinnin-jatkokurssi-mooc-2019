/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari Mustonen
 */
public class Piilo<T> {

    private T piilossa;

    public Piilo() {
        this.piilossa = null;
    }

    public void laitaPiiloon(T piilotettava) {
        this.piilossa = piilotettava;
    }

    public T otaPiilosta() {
        T palautettava = this.piilossa;
        this.piilossa = null;
        return palautettava;
    }

    public boolean onkoPiilossa() {
        return !(this.piilossa == null);
    }
}
