import java.util.Calendar;
public class Ventas {

    public int[] ventas = new int[12];

    private int ano;
    public void setAno(int ano){
        Calendar cal = Calendar.getInstance();
        int anoActual = cal.get(Calendar.YEAR);

        if(ano >= anoActual){
            this.ano = anoActual-1;
        }else{
            this.ano = ano;
        }
    }
    public int getAno(){
        return ano;
    }

    /**
     * Muestra la media de valores de un vector de enteros
     * @return media de valores del vector
     */
    public double medias(){
        double acu=0;
        for(int j=0;j<this.ventas.length;j++){
            acu = acu + this.ventas[j];
        }
        return (acu/this.ventas.length);
    }

    /**
     * Elabora un gráfico de barras con los 12 meses del año y sus respectivos valores enteros, cada 100 unidades añade un "#" aumentando la barra de ese mes
     */
    public void grafica(){
        System.out.println("Ano: " + this.ano);
        for(int j=1;j<=ventas.length;j++){
            System.out.printf("Mes %2d (%3d): ",j,ventas[j-1]);
            for(int i=ventas[j-1];i>0;i=i-100){
                System.out.printf("#");
            }
            System.out.println();
        }
    }

    public Ventas(int ano){
        setAno(ano);
        int[] ventas = new int[12];
        for(int j=0;j<ventas.length;j++){
            ventas[j] = (int)(Math.random()*1000);
        }
        this.ventas = ventas;
   }
   public Ventas(int ano, int[] ventas){//comprobar
        setAno(ano);
        if(ventas.length == 12){
            this.ventas = ventas;
        }else{
            for(int j=0;j<12;j++){
                ventas[j] = (int)(Math.random()*1000+0);
            }
        }
   }   
}
