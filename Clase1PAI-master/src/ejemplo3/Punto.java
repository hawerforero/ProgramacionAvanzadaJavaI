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
public class Punto {
    
    private int x = 0;
    private int y = 0;
    
    public Punto(){
        this.x =0;
        this.y = 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

   /* @Override
    public String toString() {
        return "Punto{" + "x=" + x + ", y=" + y + '}';
    }*/
    
     public Punto(int x, int y){
        this.x =x;
        this.y = y;
    }
    
    
}
