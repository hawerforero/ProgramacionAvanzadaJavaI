/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

/**
 *
 * @author EST_2F_MCB_PC21_
 */
public class Rectangulo {
    private int ancho, alto;
    private Punto inicio;
    
    public Rectangulo() {
        this(0,0);
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "ancho=" + ancho + ", alto=" + alto + ", inicio=" + inicio + '}';
    }
    
    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.inicio = new Punto();
    }
      
    public Rectangulo(Punto inicio, int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        this.inicio = inicio;
    }
    
}
