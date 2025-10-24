public class Principal {

    public static void intercambiaRadios(Pelota p , Pelota p1){
        double cambio=0;
        cambio = p.getRadio();
        p.setRadio(p1.getRadio());
        p1.setRadio(cambio);
    }
    public static void main(String[] args) {
        
        Pelota p = new Pelota();

        p.tipo="baloncesto";
        p.setRadio(20);
        p.getRadio();

        System.out.printf("la pelota es de %s y tiene %.2f cm de radio \n", p.tipo , p.getRadio());

        Pelota p1 = new Pelota();

        Pelota p2 = new Pelota("furbo", 22);

        System.out.printf("la pelota es de %s y tiene %.2f cm de radio \n", p1.tipo , p1.getRadio());
        System.out.printf("la pelota es de %s y tiene %.2f cm de radio \n", p2.tipo , p2.getRadio());

        p.inflar();

        p1.inflar(10);

        intercambiaRadios(p, p1);

        System.out.printf("pelota tiene %f de radio, y pelota 2 tiene %f de radio",p.getRadio(),p1.getRadio());
    }
}
