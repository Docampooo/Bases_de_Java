public class Guerrero {
    
    public Posicion p = new Posicion(-2,2);

    public int energia;
    public void setEnergia(int energia){
        if(energia<0){
            this.energia = 0;
        } else{
            this.energia = energia;
        }
    }
    public int getEnergia(){
        return energia;
    }

    public boolean escudo;
    public void setEscudo(boolean escudo){
        this.escudo = escudo;
    }
    public boolean getEscudo(){
        return escudo;
    }

    public char arma;
    public void setArma(char arma){
        this.arma = arma;
    }
    public char getArma(){
        return arma;
    }

    public void atacar(Orco o){
        //ESPADA
        if(this.getArma() == 'E' && o.p.getX() >= this.p.getX()){
            for(int cont = 1; cont <= o.p.getX() - this.p.getX(); cont++){
                o.setEnergia(o.getEnergia() - (100- cont*10) - (int) (Math.random()*100/cont + 1));
            }
        } else if(this.getArma() == 'E' && o.p.getX() < this.p.getX()){
            for(int cont = 1; cont <= this.p.getX() - p.getX(); cont++){
                o.setEnergia(o.getEnergia() - (100- cont*10) - (int) (Math.random()*100/cont + 1));
            }
        }

        if(this.getArma() == 'E' && o.p.getY() >= this.p.getY()){
            for(int cont = 0; cont <= o.p.getY() - this.p.getY(); cont++){
                o.setEnergia(o.getEnergia() - (100- cont*10) - (int) (Math.random()*100/cont + 1));
            }
        } else if(this.getArma() == 'E' && o.p.getY() < this.p.getY()){
            for(int cont = 1; cont <= this.p.getY() - p.getY(); cont++){
                o.setEnergia(o.getEnergia() - (100- cont*10) - (int) (Math.random()*100/cont + 1));
            }
        }
        //ARCO
        if(this.getArma() == 'A' && o.p.getX() >= this.p.getX()){
            for(int cont = 1; cont <= o.p.getX() - this.p.getX(); cont++){
                o.setEnergia(o.getEnergia() - 20*cont - (int) (Math.random()*70/cont + 1));
            }
        } else if(this.getArma() == 'A' && o.p.getX() < this.p.getX()){
            for(int cont = 1; cont <= this.p.getX() - p.getX(); cont++){
                o.setEnergia(o.getEnergia() - 20*cont - (int) (Math.random()*70/cont + 1));
            }
        }

        if(this.getArma() == 'A' && o.p.getY() >= this.p.getY()){
            for(int cont = 1; cont <= o.p.getY() - this.p.getY(); cont++){
                o.setEnergia(o.getEnergia() - 20*cont - (int) (Math.random()*70/cont + 1));
            }
        } else if(this.getArma() == 'A' && o.p.getY() < this.p.getY()){
            for(int cont = 1; cont <= this.p.getY() - p.getY(); cont++){
                o.setEnergia(o.getEnergia() - 20*cont - (int) (Math.random()*70/cont + 1));
            }
        }
        System.out.printf("Vida Orco: %d \n", o.getEnergia());
    }

    public void recuperarse(){
        this.setEnergia(this.getEnergia() + (int) Math.random() * 150 + 80);
        System.out.printf("Te has recuperado, vida: %d \n", this.getEnergia());
    }

    public Guerrero(){
        this.setEnergia(750);
    }
}
