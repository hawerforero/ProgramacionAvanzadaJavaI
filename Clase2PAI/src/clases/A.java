package clases;

class A implements Cloneable, Comparable  {
    private int x;
    private int y;
    B objetoB;
    public A(int x, int y) { 
        this.x = x; 
        this.y = y; 
        this.objetoB=new B(0,0);}
    
    @Override
    public String toString() {
        return "A{" + "x=" + x + ", y=" + y + '}' + " Referencia: " + super.toString() + " objetoB: " + this.objetoB.toString();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
       A obj=null;
        try{
            obj=(A)super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        obj.objetoB  =(B) (objetoB).clone();
        return obj;
    }

    //Comparar valores del objeto no referencias
    @Override
    public boolean equals(Object obj)  {
        if ( obj == null) 
            return false;
        if ( this == obj ) 
            return true;
        if (  obj instanceof A ) 
        {
            //Codigo correpondiente a comparar el contenido del objeto
            A tmp = (A)obj;
            if (this.x== tmp.x && this.y==tmp.y)
                return true;
            else
                return false;
        }    
        else
            return false;
        
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

    @Override
    public int compareTo(Object obj) {
        if ( obj == null) 
            return 0;
        if ( this == obj ) 
            return 1;
        if (  obj instanceof A ) 
        {
            //Codigo correpondiente a comparar el contenido del objeto
            A tmp = (A)obj;
            if (this.x== tmp.x && this.y==tmp.y)
                return 1;
            else
                return 0;
        }    
        else
            return 0;
    }
}
