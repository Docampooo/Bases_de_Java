package tema6;

public class Geometria {
    
    private boolean figura;

    public boolean getFigura(){
        return figura;
    }

    private double altura;

    public void setAltura(double altura){
        if(altura > 0){
            this.altura = altura;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public double getAltura(){
        return altura;
    }

    private double base;
    public void setBase(double base){
        if(base > 0){
            this.base=base;
        }else {
            throw new IllegalArgumentException();
        }
    }
    public double getBase(){
        return base;
    }

    public Geometria(){
        this.figura = false;
        setAltura(2);
        setBase(2);
    }
    public Geometria(double base, double altura){
        this.figura = false;
        setAltura(altura);
        setBase(base);
    }
    public Geometria(boolean figura, double base, double altura){
        this.figura = figura;
        setAltura(altura);
        setBase(base);
    }

    public double area(){
        return figura ? base * altura : base * altura/2;
    }

    public double diagonal(){
        double hipotenusa = Math.sqrt((base * base)+(altura * altura));
        return hipotenusa;
    }
    public double perimetro(){
        double perimetro=0;
        if(figura == true){
             perimetro = base * altura * diagonal();
        } else{
             perimetro = (base * altura * diagonal())/2;
        }
        return perimetro;
    }
    public String tipo(){
        return figura?"Rectangulo":"Triangulo";
    }
}
