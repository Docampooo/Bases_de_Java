import java.util.Scanner;

public class Orco {

    public Posicion p = new Posicion(2, -2);

    public int energia;

    public void setEnergia(int energia) {
        if(energia < 0){
            this.energia = 0;
        }else{
            this.energia = energia;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public int nivel;

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void atacar(Guerrero g) { //arreglar ataque para que baje vida del guerrero
        if (g.p.getX() >= this.p.getX()) {
            for (int cont = 1; cont <= this.p.getX() - g.p.getX(); cont++) {
                g.setEnergia(g.getEnergia() - (150 - cont*15)- this.getNivel() * 10);
            }
        } else if (this.p.getX() < g.p.getX()) {
            for (int cont = 1; cont <= g.p.getX() - p.getX(); cont++) {
                g.setEnergia(g.getEnergia() - (150 - cont*15) - this.getNivel() * 10);
            }
        }

        if (g.p.getY() >= this.p.getY()) {
            for (int cont = 1; cont <= this.p.getY() - g.p.getY(); cont++) {
                g.setEnergia(g.getEnergia() - (150 - cont*15)- this.getNivel() * 10);
            }
        } else if (this.p.getY() < g.p.getY()) {
            for (int cont = 1; cont <= g.p.getY() - p.getY(); cont++) {
                g.setEnergia(g.getEnergia() - (150 - cont*15) - this.getNivel() * 10);
            }
        }
        System.out.printf("vida guerrero: %d \n", g.getEnergia());

    }

    public void recuperarse() {
        this.setEnergia(this.getEnergia() + 150 + this.getNivel() * 10);
        System.out.printf("vida orco: %d \n", this.getEnergia());

    }

    public void patronOrco(Guerrero g) {
        Scanner sc = new Scanner(System.in);

        double eleccion = 0;

        // 1º Atacar
        // 2º Recuperarse
        // 3º Desplazarse
        // 4º Moverse (lejos)
        eleccion = (Math.random());

        if (eleccion <= 0.5) {
            System.out.println("El orco ataca");
            this.atacar(g);
        } else if (eleccion > 0.5 && eleccion <= 0.8) {
            System.out.println("El orco se recupera");
            this.recuperarse();
        } else if (eleccion > 0.8) {
            this.p.desplazarOrco(this);
            System.out.printf("El orco se desplaza a %d %d \n", this.p.getX(), this.p.getY());
        }
    }

    public Orco() {
        this.setNivel(1);
        this.setEnergia(900 + 50*this.getNivel());
    }
}