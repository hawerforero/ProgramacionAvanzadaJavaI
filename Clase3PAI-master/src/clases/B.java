package clases;
 public class B implements Cloneable, Comparable {
        private int a;
        private int b;
        
        public B(int a, int b) { this.a = a; this.b = b;}        
        @Override
        public String toString() {
            return "B{" + "a=" + a + ", b=" + b + '}'+ " Referencia: " + super.toString();
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
                Object obj=null;
                try{
                      obj=(B)super.clone();
                }catch(CloneNotSupportedException ex){
                    System.out.println(" no se puede duplicar");
                }
                return obj;
        }
        @Override
            public boolean equals(Object obj)  {
                if ( obj == null) 
                    return false;
                if ( this == obj ) 
                    return true;
                if (  obj instanceof B ) 
                    {
                        //Codigo correpondiente a comparar el contenido del objeto
                        B tmp = (B)obj;
                        if (this.a== tmp.a && this.b==tmp.b)
                            return true;
                        else
                            return false;
                    }    
                else
                            return false;
            }
    @Override
    public int compareTo(Object obj) {
        if ( obj == null) 
                    return 0;
                if ( this == obj ) 
                    return 1;
                if (  obj instanceof B ) 
                    {
                        //Codigo correpondiente a comparar el contenido del objeto
                        B tmp = (B)obj;
                        if (this.a== tmp.a && this.b==tmp.b)
                            return 1;
                        else
                            return 0;
                    }    
                else
                            return 0;
    }            

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

}
    
    
       



