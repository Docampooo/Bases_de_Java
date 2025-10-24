import java.util.Scanner;

public class Protagonista {

    public void stats(Protagonista p) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué quieres mostrar?");
        System.out.println("1º vida");
        System.out.println("2º fuerza");
        System.out.println("3º conocimiento");
        System.out.println("4º todos");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.printf("Cuentas con %d pts de vida \n", p.getVida());
                System.out.println();
                break;
            case 2:
                if(p.getFuerza()==true){
                    System.out.printf("Tu fuerza es alta, eres fuerte \n");
                } else{
                    System.out.printf("Tu fuerza es baja, eres débil \n");
                }
                System.out.println();
                break;
            case 3:
                if(p.getConocimiento()==true){
                    System.out.printf("Tu conocimineto es alto, eres sabio \n");
                }else{
                    System.out.printf("Tu conocimineto es bajo, eres analfabeto \n");
                }
                System.out.println();
                break;
            case 4:
                if(p.getFuerza() && p.getConocimiento()){
                    System.out.printf("Cuentas con %d pts de vida, eres fuerte y sabio \n", p.getVida());
                } else if(!p.getFuerza() && p.getConocimiento()){
                    System.out.printf("Cuentas con %d pts de vida, eres debil pero sabio \n", p.getVida());
                } else if(p.getFuerza() && !p.getConocimiento()){
                    System.out.printf("Cuentas con %d pts de vida, eres fuerte pero analfabeto \n", p.getVida());
                }else{
                    System.out.printf("Cuentas con %d pts de vida, eres debil y analfabeto \n", p.getVida());
                }
                System.out.println();
                break;
            default:
                System.out.println("opcion no valida");
                break;
        }
    }

    public void invent(Protagonista p){
        Scanner sc = new Scanner(System.in);
        if(p.getEspada() && (p.getArmadura() || p.getArmaduraLigera()) && (p.getmediaLlave()|| p.getLlaveOxidada())){
            System.out.printf("En tu inventario tienes una espada, armadura y una llave \n");
        }else if(p.getEspada() && (p.getArmadura() || p.getArmaduraLigera()) && (!p.getmediaLlave()|| !p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una espada y armadura");
        }else if(p.getEspada() && (!p.getArmadura() || !p.getArmaduraLigera()) && (!p.getmediaLlave()|| !p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una espada");
        }else if(p.getEspada() && (!p.getArmadura() || !p.getArmaduraLigera()) && (p.getmediaLlave()|| p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una espada y una llave");
        }else if(!p.getEspada() && (!p.getArmadura() || !p.getArmaduraLigera()) && (p.getmediaLlave()|| p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una llave");
        }else if(!p.getEspada() && (p.getArmadura() || p.getArmaduraLigera()) && (p.getmediaLlave()|| p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una armadura y una llave");
        }else if(!p.getEspada() && (p.getArmadura() || p.getArmaduraLigera()) && (!p.getmediaLlave()|| !p.getLlaveOxidada())){
            System.out.println("En tu inventario tienes una armadura");
        }else{
            System.out.println("No tienes nada en tu inventario");
        }
        System.out.println();
    }

    public void help(Protagonista p){
        System.out.printf("-Para desplazarte, escribe la direccion con los puntos cardinales(norte, sur. . .) en cada sala a la que entres te saldrán sus coodenadas.\n-Para mostrar el inventario, invent.\n-Para tus características, stats.\n");
        System.out.println();
    }

    public boolean lanzamineto(String cadena, Protagonista p){
        boolean result = false;
        int opcion=0;
        int num = (int) (Math.random()*2);
        do{
            switch (cadena) {
                case "cara":
                    if(num==1){
                        result = true;
                    }else{
                        result = false;
                    }
                    opcion = 3;
                    break;
    
                case "cruz":
                    if(num==1){
                        result = false;
                    }else{
                        result = true;
                    }
                    opcion = 3;
                    break;
                    
                default:
                    System.out.println("Solo puedes elegir \"cara\" o \"cruz\"");
                    break;
            }
        }while(opcion != 3);
        return result;
    }

    public boolean espada;

    public void setEspada(boolean espada, boolean fuerza) {
        if(fuerza){
            this.espada = espada;
        } else{
            this.espada = false;
        }
    }

    public boolean getEspada() {
        return espada;
    }

    public boolean armadura;

    public void setArmadura(boolean armadura) {
        this.armadura = armadura;
    }

    public boolean getArmadura() {
        return armadura;
    }

    public boolean armaduraLigera;

    public void setArmaduraLigera(boolean armaduraLigera) {
        this.armaduraLigera = armaduraLigera;
    }

    public boolean getArmaduraLigera() {
        return armaduraLigera;
    }

    public boolean mediaLlave;

    public void setmediaLlave(boolean mediaLlave) {
        this.mediaLlave = mediaLlave;
    }

    public boolean getmediaLlave() {
        return mediaLlave;
    }
    public boolean llaveOxidada;

    public void setLlaveOxidada(boolean llaveOxidada) {
        this.llaveOxidada = llaveOxidada;
    }

    public boolean getLlaveOxidada() {
        return llaveOxidada;
    }
    public boolean cofre;
    public void setCofre(boolean cofre){
        this.cofre = cofre;
    }
    public boolean getCofre(){
        return cofre;
    }

    public int dinero;
    public void setDinero(int dinero){
        this.dinero=dinero;
    }
    public int getDinero(){
        return dinero;
    }

    public int vida;

    public void setVida(int vida) {
        if(vida <= 0){
            this.vida = 0;
        } else{
            this.vida = vida;
        }
    }

    public int getVida() {
        return vida;
    }

    public boolean fuerza;

    public void setFuerza(boolean fuerza) {
        this.fuerza = fuerza;
    }

    public boolean getFuerza() {
        return fuerza;
    }

    public boolean conocimiento;

    public void setConocimiento(boolean conocimiento) {
        this.conocimiento = conocimiento;
    }

    public boolean getConocimiento() {
        return conocimiento;
    }

    public boolean rata;
    public void setRata(boolean rata){
        this.rata=rata;
    }
    public boolean getRata(){
        return rata;
    }

    public boolean monjes;
    public void setMonjes(boolean monjes){
        this.monjes=monjes;
    }
    public boolean getMonjes(){
        return monjes;
    }

    public boolean criaturas;
    public void setCriaturas(boolean criaturas){
    this.criaturas = criaturas;
    }
    public boolean getCriaturas(){
        return criaturas;
    }

    public boolean fin;
    public void setFin(boolean fin){
        this.fin = fin;
    }
    public boolean getFin(){
        return fin;
    }

    public Protagonista() {
        this.espada = false;
        this.armadura = false;
        this.armaduraLigera = false;
        this.mediaLlave = false;
        this.llaveOxidada = false;
        this.cofre = true;

        this.fuerza = false;
        this.conocimiento = false;
        this.vida = 10;
        this.dinero = 0;

        this.rata = true;
        this.monjes = true;
        this.criaturas = true;

        this.fin = false;
    }

    public Protagonista(boolean espada, boolean armadura,boolean armaduraLigera, boolean mediaLlave,boolean llaveOxidada, boolean cofre, boolean fuerza, boolean conocimiento, int vida, int dinero, boolean rata, boolean monjes, boolean criaturas) {
        this.espada = espada;
        this.armadura = armadura;
        this.armaduraLigera = armaduraLigera;
        this.llaveOxidada = llaveOxidada;
        this.mediaLlave = mediaLlave;
        this.cofre = cofre;

        this.fuerza = fuerza;
        this.conocimiento = conocimiento;
        this.vida = vida;
        this.dinero = dinero;

        this.rata = rata;
        this.monjes = monjes;
        this.criaturas = criaturas;
    }
}
