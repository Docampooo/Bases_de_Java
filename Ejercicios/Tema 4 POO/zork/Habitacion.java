import java.util.Scanner;
public class Habitacion {

    public Protagonista p;

    public Habitacion(Protagonista p){
        this.p = p;
    }

    public Habitacion n;
    public void setn(Habitacion n) {
        this.n = n;
    }

    public Habitacion getn() {
        return n;
    }

    public Habitacion s;
    public void sets(Habitacion s) {
        this.s = s;
    }
    public Habitacion gets() {
        return s;
    }

    public Habitacion e;
    public void sete(Habitacion e) {
        this.e = e;
    }
    public Habitacion gete() {
        return e;
    }

    public Habitacion o;
    public void seto(Habitacion o) {
        this.o = o;
    }
    public Habitacion geto() {
        return o;
    }
//direcciones
    public int x;
    public void setX(int x, String dir) {
        if (dir.equals("este")) {
            x = x + 1;
            if(x>1){
                x = 1;
                System.out.println("Habitacion sin salida");
            }
        }
        if(dir.equals("oeste")) {
            x = x - 1;
            if(x <-1){
                x = -1;
                System.out.println("Habitacion sin salida");
            }
        }
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int y;
    public void setY(int y, String dir) {
        if (dir.equals("norte")) {
            y = y + 1;
            if(y > 1){
                y = 1;
                System.out.println("Habitacion sin salida");
            }
        }
        if(dir.equals("sur")) {
            y = y - 1;
            if(y < -1){
                y = -1;
                System.out.println("Habitacion sin salida");
            }
        }
        this.y = y;
    }

    public int getY() {
        return y;
    }
//constructor
    public Habitacion(int x, int y, Protagonista p){
        this.x=x;
        this.y=y;
        this.p=p;
    }
//habitaciones
    // Habitacion jardin = new Habitacion(1,1,p);

    // Habitacion templo = new Habitacion(1,0,p);

    // Habitacion comedor = new Habitacion(1,-1,p);

    // Habitacion almacen = new Habitacion(0,1,p);

    // Habitacion inicio = new Habitacion(0,0,p);

    // Habitacion alcantarilla = new Habitacion(0,-1,p);

    // Habitacion comercio = new Habitacion(-1,0,p);

    // Habitacion libreria = new Habitacion(-1,1,p);

    // Habitacion claustro = new Habitacion(-1,-1,p);

//Contenido
        public int conttemplo=0;
        public int contjardin=0;
        public int contcomedor=0;
        public int contalmacen=0;
        public int continicio=0;
        public int contalcantarilla=0;
        public int contcomercio=0;
        public int contlibreria=0;
        public int contclaustro=0;

        public int disculpa = 0;
        
    public void contenido(int x, int y, Protagonista p){
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("coords: " + x + " " + y);

        if (x==1&&y==1){
            contjardin++;
            System.out.println("-----------J A R D I N-----------"); 
            if(contjardin == 1){
                System.out.println("Llegas a un precioso jardin lleno de flores y frutas de todo tipo, justo cuando te acercas  a un manzano para recoger uno de sus frutos, unas pequeñas y alocadas criaturas salen de los arbustos y te miran con apetito");
            }
            if(p.getCriaturas()){
                System.out.println("Las criaturas se acercan a ti");
                int opcion = 0;
                do{
                    System.out.println("Que quieres hacer?");
                    System.out.println("1º luchar");
                    System.out.println("2º engatusar");
                    System.out.println("3º huir");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            if(p.getEspada() && p.getArmadura() || p.getArmaduraLigera()){
                                System.out.println("Te enfrentas a las criaturas, son muy escurridizas y esquivan muchos de tus ataques, aun asi, no son rivales para tu espada, aunque no caen sin antes dejarte algunas heridas de pequeño tamaño, aprovechas para saquear sus cuerpos y encuentras algo de dinero y lo que parece un fragmento de llave.");
                                p.setDinero(p.getDinero() + 6);
                                p.setVida(p.getVida() - 2);
                                p.setmediaLlave(true);
                                System.out.printf("Obtienes media llave \n");
                                System.out.printf("obtienes +6 monedas, Dinero: %d \n",p.getDinero());
                                System.out.printf("-2 pts de vida, Vida: %d",p.getVida());
                                p.setCriaturas(false);
                            } else if(p.getEspada() && !(p.getArmadura() || p.getArmaduraLigera())){
                                System.out.println("Te enfrentas a las criaturas, son muy escurridizas y esquivan muchos de tus ataques, aun asi, no son rivales para tu espada, aunque al ser tantas terminas algo dañado, aprovechas para saquear sus cuerpos y encuentras algo de dinero y lo que parece un fragmento de llave.");
                                p.setDinero(p.getDinero() + 6);
                                p.setVida(p.getVida() - 4);
                                p.setmediaLlave(true);
                                System.out.printf("Obtienes media llave \n");
                                System.out.printf("obtienes +6 monedas, Dinero: %d \n",p.getDinero());
                                System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());
                                p.setCriaturas(false);
                            } else if(!p.getEspada() && p.getArmadura() || p.getArmaduraLigera()){
                                System.out.println("Te enfrentas a las criaturas, en un principio parecian pocas pero resultaron ser bastantes mas de las que pensabas");
                                p.setVida(p.getVida() - 4);
                                System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());
                            } else{
                                System.out.println("Te enfrentas a las criaturas, en un principio parecian pocas pero resultaron ser bastantes mas de las que pensabas");
                                p.setVida(p.getVida() - 6);
                                System.out.printf("-6 pts de vida, Vida: %d \n",p.getVida());
                            }
                            opcion = 3;
                            break;
                        case 2:
                            if(p.getConocimiento()){
                                System.out.println("utilizas tu intelecto para llamar la atencion de las criaturas tirando trozos de fruta por el suelo, las criaturas parecen ser atraidas por el ruido y deduces que son una especie de seres ciegos, contando con esta ventaja y subiendote al manzano, te las ideas para acabar con ellas con poco mas que unos rasguños, aprovechas para saquear los cadaveres y te llevas unas monedas");
                                p.setDinero(p.getDinero() + 6);
                                p.setVida(p.getVida() - 2);
                                System.out.printf("obtienes +6 monedas, Dinero: %d \n",p.getDinero());
                                System.out.printf("-2 pts de vida, Vida: %d",p.getVida());
                            }else{
                                System.out.println("Tratas de comunicarte con las criaturas pidindoles que te dejen ir, lamentablemente no parecen entender tu idioma y van directamente a por ti causandote grandes heridas");
                                p.setVida(p.getVida() - 6);
                                System.out.printf("-6 pts de vida, Vida: %d",p.getVida());
                            }
                            opcion = 3;
                            break;
                        case 3:
                            System.out.println("Corres lo mas rapido posible hasta la salida y escapas de las criaturas");
                            break;
                    
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                }while(opcion != 3);
            }else{
                System.out.println("caminas por los jardines pero las plantas y frutales parecen estar marchitandose, que desperdicio");
            }
        } else if(x==1&&y==0){
            conttemplo++;
            System.out.println("-----------T E M P L O-----------");
            if(conttemplo == 1){
                System.out.println("Entras en un una sala llena de pinturas y cuadros, observas tu alrededor y ves que todos los caminos llevan a una gran estatua, te entra curiosidad y te acercas a ella");
                System.out.println("La gigantesca estatua te mira fijamente y te habla sobre una llave que abre una puerta escondida por la mazmorra capaz de conceder un deseo a quien la abra");
            }else{
                System.out.println("Vuelves al templo y te acercas a la estatua");
            }
            System.out.println("Posees la llave?");
            if(p.getLlaveOxidada() && p.getmediaLlave()){
                System.out.println("La estatua mira fijamente los 2 trozos de llave de tus manos y como por arte de magia los une y crea con ellos una brillante llave dorada");
            }else{
                if(p.getmediaLlave() && !p.getLlaveOxidada()){
                    System.out.println("mmmmm. . . Veo que tienes una parte, tendras que buscar la otra mitad");
                } else if (!p.getmediaLlave() && p.getLlaveOxidada()){
                    System.out.println("mmmmm. . . Veo que tienes una parte, tendras que buscar la otra mitad");
                } else if (!p.getLlaveOxidada() && !p.getmediaLlave()){
                    System.out.println("Ya veo, tendras que buscarla por algun lugar de esta mazmorra");
                } 
            }
        } else if(x==1&&y==-1){
            contcomedor++;
            System.out.println("-----------C O M E D O R-----------");
        if(p.getFuerza()){
            if(p.getConocimiento()){
                System.out.println("Entras en la cocina pero todo sigue igual que antes");
            } else{
                System.out.println("En la cocina todo sigue igual que antes");
                int opcion = 0;
                do{
                    System.out.println("Qué quieres hacer?");
                    System.out.println("1º Investigar");
                    System.out.println("2º irse");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println("comienzas a revisar la cocina, todo esta patas arriba, en el horno hay una nota, la recoges y lees su contenido \"orruc kroz\" no sabes muy bien que es y la dejas en su sitio, continuas revisando la cocina pero no encuentras nada util");
                            opcion = 2;
                            break;
                        case 2:
                            System.out.println("sales de la habitacion");
                            break;
                    
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                }while(opcion != 2);
            }
        }else{
            if(contcomedor == 1){
                System.out.println("Entras en el comedor atraido por el aroma de la comida recien hecha, en el medio de la sala se encuentra un humilde cocinero, parece bastante cansado");
            } else{
                System.out.println("Entras en la cocina y el cocinero sigue en el mismo sitio");
            }
            int opcion=0;
            do{
                System.out.println("Qué quieres hacer?");
                System.out.println("1º interactuar con el cocinero");
                System.out.println("2º robar");
                System.out.println("3º esconderse");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("Te acercas al cocinero, a simple vista se ve triste y desmotivado, le preguntas si puedes llevarte algo de comer contigo, el cocinero no parece muy convencido de darte nada y te propone intercambiar una pocion y algo de comida a cambio de 2 monedas");
                        int opcion2;
                        if(p.getEspada()){
                            do{
                                System.out.println("Qué quieres hacer?");
                                System.out.println("1º Aceptar propuesta");
                                System.out.println("2º Atacar");
                                System.out.println("3º irse");
                                opcion2 = sc.nextInt();
                                switch (opcion2) {
                                    case 1:
                                        if(p.getDinero() >= 2){
                                            System.out.println("Le entregas 2 monedas y el cocinero te da agradecido un trozo de pan y la misteriosa pocion, tras esto, desaparece al meterse en una trampilla");
                                            p.setDinero(p.getDinero() - 2);
                                            p.setFuerza(true);
                                            p.setVida(p.getVida() + 2);
                                            System.out.println("comes el trozo de pan y bebes ese extraño brebaje, de forma casi instantanea una fuerte energia corre por tus venas, te sientes mucho mas fuerte");
                                            System.out.printf("La comida te da fuerzas, obtienes +2 pts de vida, Vida:  %d \n", p.getVida());
                                            System.out.println("Obtienes fuerza");
                                            System.out.printf("Pierdes -2 monedas, Dinero: %d \n",p.getDinero());
                                        } else{
                                            System.out.println("Aceptas la propuesta pero no tienes dinero suficiente, el cocinero se enfada y te echa de la cocina");
                                            opcion2 = 3;
                                        }
                                        opcion = 3;
                                        break;
                                    case 2:
                                         p.setFuerza(true);
                                         p.setVida(p.getVida() + 2);
                                        System.out.println("atacas al cocinero por sorpresa y acabas con el, limpias la sangre de tu espada en el fregadero y comes hasta hartarte, buscas esa especie de brebaje y lo bebes sin dudarlo, de forma casi instantanea una fuerte energia corre por tus venas, te sientes mucho mas fuerte");
                                        System.out.printf("La comida te da fuerzas, obtienes +2 pts de vida, Vida:  %d \n", p.getVida());
                                        System.out.println("Obtienes fuerza");
                                        opcion2 = 3;
                                        opcion = 3;
                                        break;
                                    
                                    case 3:
                                        System.out.println("te acercas a la puerta");
                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            }while(opcion2 !=3);

                        }else{
                            do{
                                System.out.println("Qué quieres hacer?");
                                System.out.println("1º Aceptar propuesta");
                                System.out.println("2º irse");
                                opcion2 = sc.nextInt();
                                switch (opcion2) {
                                    case 1:
                                        if(p.getDinero() >= 2){
                                            System.out.println("Le entregas 2 monedas y el cocinero te da agradecido un trozo de pan y la misteriosa pocion, tras esto, desaparece al meterse en una trampilla");
                                            p.setDinero(p.getDinero() - 2);
                                            p.setFuerza(true);
                                            p.setVida(p.getVida() + 2);
                                            System.out.println("comes el trozo de pan y bebes ese extraño brebaje, de forma casi instantanea una fuerte energia corre por tus venas, te sientes mucho mas fuerte");
                                            System.out.println();
                                            System.out.printf("La comida te da fuerzas, obtienes +2 pts de vida, Vida:  %d \n", p.getVida());
                                            System.out.println("Obtienes fuerza");
                                            System.out.printf("Pierdes -2 monedas, Dinero: %d \n",p.getDinero());
                                        } else{
                                            System.out.println("Aceptas la propuesta pero no tienes dinero suficiente, el cocinero se enfada y te echa de la cocina");
                                            opcion = 3;
                                            opcion2 = 2;
                                        }
                                        break;
                                    case 2:
                                         System.out.println("te acercas a la puerta");
                                        break;
                                
                                    default:
                                        System.out.println("Opcion no valida");
                                        break;
                                }
                            }while(opcion2 !=2);

                        }
                        opcion = 3;
                        break;
                    case 2:
                        System.out.println("robas algo de comida sin que el cocinero se de cuenta, coges tambien la pocion misteriosa y te la bebes, de forma casi instantanea una fuerte energia corre por tus venas, te sientes mucho mas fuerte");
                        System.out.println("El cocinero se da cuenta de que faltan cosas y va a buscarlas metiendose dentro de una trampilla, no parece que vaya a volver");
                        p.setFuerza(true);
                        p.setVida(p.getVida() + 2);
                        System.out.printf("La comida te da fuerzas, obtienes +2 pts de vida, Vida:  %d \n", p.getVida());
                        System.out.println("Obtienes fuerza");
                        opcion = 3;
                        break;
                    case 3:
                        System.out.println("Sera mejor ir a otra habitacion");
                        break;
                
                    default:
                    System.out.println("opcion no valida");
                        break;
                } 

            }while(opcion !=3);
        }

        } else if(x==0&&y==1){
        contalmacen++;
        System.out.println("-----------A L M A C E N-----------");
        if(contalmacen == 1){
            System.out.println("Entras en el Almacen en busca de algo que te resulte util, remueves las cajas y te topas con algo que llama tu atencion, interactuas con el objeto y resulta ser un cofre, lo abres y te llevas la espada que contenia en su interior y unas monedas antiguas.");
        }else{
            System.out.println("vuelves al almacen lleno de cajas y misteriosos cuadros");
        }
            if(p.getFuerza() && !p.getEspada()){
                p.setEspada(true, true);
                System.out.println("Recoges la espada y la pruebas contra el aire, parece afilada, gracias a tu fuerza la puedes manipular sin problemas");
                System.out.println("Obtienes una espada");
                p.setDinero(p.getDinero() + 2);
                System.out.printf("+2 monedas, Dinero %d\n",p.getDinero());
            }else if(!p.getFuerza()){
                System.out.println("Recoges la espada y tratas de levantarla, lamentablemente aun eres demasiado debil para ello y la dejas en el suelo");
            }
        } else if(x==0&&y==0){
        continicio++;
        System.out.println("-----------B O D E G A-----------");
        if(p.getmediaLlave() && p.getLlaveOxidada()){
            System.out.println("Esta habitacion de nuevo, revisas aquella esquina misteriosa y notas algo diferente, hay una especie de aura que erradia una brillante luz calida, no sabes de que se trata pero quieres entrar a averiguarlo, la rocosa pared que lo tapaba anteriormente se ha agrietado,empiezas a empujarla y la terminas ropmpiendo, el objeto misterioso resulto ser una puerta y no lo dudas 2 veces en probar la llave en ella, de pronto todo empieza a desvanecerse a tu alrededor, cierras los ojos confundido. Cuando los vuelvese a abrir, te encuentras que estas frente al pueblo en el que te criaste. Has regresado a casa despues de tantos años, sobreviviste a Zork y te vuelves una leyenda en el pueblo");
            p.setFin(true);
        } else{
            if(continicio == 1){
                System.out.println("Entras de nuevo en esta habitacion misteriosa en la que despertaste, analizas mejor la habitacion y encuentras una esquina algo misteriosa, parece como si algo se escondiera detras aunque no encuentras la forma de llegar a ver de que se trata, puede que mas adelante te sirva de algo");
            } else{
                System.out.println("recorres de nuevo la bodega intrigado por lo que se encontrará en el interior de esa esquina");
            }
        }
        
        } else if(x==0&&y==-1){
            contalcantarilla++;
            System.out.println("-----------A L C A N T A R I L L A D O-----------");
            if(p.getRata()){
                System.out.println("bajas a las alcantarillas y unas ratas gigantes salen de las profundidades del agua turbulenta y se disponen a atacarte.");
                if(p.getEspada() && (p.getArmadura() || p.getArmaduraLigera())){
                    p.setRata(false);
                    System.out.println("Las ratas tratan de atacarte en grupo, gracias a tu armadura no consiguen dañarte y aprovechas tu espada para acabar con ellas rapidamente, compruebas sus cuerpos y encuentras unas cuantas monedas pegadasa al pelaje de una de ellas");
                    p.setDinero(p.getDinero() + 2);
                    System.out.printf("consigues +2 monedas, Dinero: %d \n",p.getDinero());

                } else if(p.getEspada() && (!p.getArmadura() || !p.getArmaduraLigera())){
                    p.setRata(false);
                    System.out.println("Las ratas se aproximan rapidamente, te defiendes con tu espada y logras acabar con ellas, por desgracia, una de ellas te mordio y te creo una herida. Compruebas sus cuerpos y encuentras unas cuantas monedas pegadas en su pelaje");
                    p.setVida(p.getVida() - 2);
                    p.setDinero(p.getDinero() + 2);
                    System.out.printf("-2 pts de vida, Vida: %d \n",p.getVida());
                    System.out.printf("consigues +2 monedas, Dinero: %d \n",p.getDinero());

                } else if(!p.getEspada() && (p.getArmadura()|| p.getArmaduraLigera())){
                    System.out.println("Las ratas van a por ti y logran asentarte varios mordiscos antes de sumergirse de nuevo en el agua. Gracias a tu armadura las heridas son menores");
                    p.setVida(p.getVida() - 2);
                    System.out.printf("-2 pts de vida, Vida: %d \n",p.getVida());

                }else{
                    System.out.println("Las ratas van a por ti y logran asentarte varios mordiscos antes de sumergirse de nuevo en el agua. Las heridas te hacen mucho daño");
                    p.setVida(p.getVida() - 4);
                    System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());

                }
            }else{
                System.out.println("Recorres las alcantarillas rodeando los cuerpos de las ratas");
            }
    
        } else if(x==-1&&y==0){
        contcomercio++;
        System.out.println("-----------C O M E R C I O-----------");
        if(contcomercio == 1){
            System.out.println("Entras en una habitacin llena luces y ruido, varias criaturas se reunen alrededor de un puesto, no parece que quieran hacerte daño. Te acercas al puesto y ves lo que vende");
        }else{
            System.out.println("Apareces de nuevo por el comercio, la gente sigue comprando como de costumbre");
        }
        System.out.println("Bienvenido a mi puesto, que deseas comprar?");
        int opcion = 0;
        do{
            System.out.println("A la venta");
            System.out.println("1º 2$  Racion de comida");
            System.out.println("2º 4$  Armadura ligera");
            System.out.println("3º 6$  Media llave oxidada");
            System.out.println("4º salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if(p.getDinero() < 2){
                        System.out.println("Tratas de comprar el objeto aun sabiendo que no tienes dinero y el vendedor se da cuenta");
                        int opcion2=0;
                        do{
                            System.out.println("Que quieres hacer?");
                            System.out.println("1º disculparse");
                            System.out.println("2º enfrentar");
                            System.out.println("3º salir corriendo");
                            opcion2 = sc.nextInt();
                            sc.nextLine();
                            switch (opcion2) {
                                case 1:
                                disculpa++;
                                if(disculpa > 1){
                                    System.out.println("Te disculpas con el mercader aunque ya no te ofrece nada");
                                } else{
                                    System.out.println("Te disculpas con el mercader y comenzais a hablar, haceis buenas migas y os terminais volviendo amigos");
                                    p.setVida(p.getVida() + 2);
                                    System.out.println("El mercader te regala una racion de comida");
                                    System.out.printf("+2 pts de vida, Vida: %d",p.getVida());
                                    opcion2 = 3;
                                }
                                    break;
                                case 2:
                                    sc.nextLine();
                                    System.out.println("Te enfrentas al mercader y terminais enzarzados en una pelea callejera, las criaturas comienzan a hacer apuestas por el ganador del combate.");
                                    System.out.println("Cara o cruz");
                                    String lanz = sc.nextLine();
                                    if(p.lanzamineto(lanz, p)){
                                        System.out.println("Ganas el combate y las criaturas empiezan a vitorearte, lleno de orgullo te acercas al puesto y te llevas tu porcion de comida, el mercader asume la derrota y no tiene rencores");
                                        p.setVida(p.getVida() + 2);
                                        System.out.printf("+2 pts de vida, Vida: %d",p.getVida());
                                    }else{
                                        System.out.println("Pierdes el combate y recibes una paliza del mercader, despiertas unos minutos mas tarde y el mercader desconfia de ti");
                                        if(p.getArmadura() || p.getArmaduraLigera()){
                                            p.setVida(p.getVida() - 2);
                                            System.out.printf("-2 pts de vida, Vida: %d \n",p.getVida());
                                        }else{
                                            p.setVida(p.getVida() - 4);
                                            System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());
                                        }
                                    }
                                    opcion = 4;
                                    opcion2 = 3;
                                    break;
                                case 3:
                                    System.out.println("Sales corriendo y escapas");
                                    opcion = 4;
                                    break;
                            
                                default:
                                    break;
                            }
                        }while(opcion2 != 3);
                        
                    }else{
                        System.out.println("Le compras al mercader honradamente");
                        p.setDinero(p.getDinero() - 2);
                        System.out.println("Obtienes una racion de comida");
                        p.setVida(p.getVida() + 2);
                        System.out.printf("+2 pts de vida, Vida: %d \n",p.getVida());
                        System.out.printf("-2 monedas, Dinero: %d \n",p.getDinero());
                    }
                    break;
                case 2:
                if(p.getArmadura() || p.getArmaduraLigera()){
                    System.out.println("Ya llevas contigo una armadura, no necesitas otra");
                }else{
                    if(p.getDinero() < 4){
                        System.out.println("Tratas de comprar el objeto aun sabiendo que no tienes dinero y el vendedor se da cuenta");
                        int opcion2=0;
                        do{
                            System.out.println("Que quieres hacer?");
                            System.out.println("1º disculparse");
                            System.out.println("2º enfrentar");
                            System.out.println("3º salir corriendo");
                            opcion2 = sc.nextInt();
                            switch (opcion2) {
                                case 1:
                                disculpa++;
                                if(disculpa > 1){
                                    System.out.println("Te disculpas con el mercader aunque ya no te ofrece nada");
                                } else{
                                    System.out.println("Te disculpas con el mercader y comenzais a hablar, haceis buenas migas y os terminais volviendo amigos");
                                    p.setVida(p.getVida() + 2);
                                    System.out.println("El mercader te regala una racion de comida");
                                    System.out.printf("+2 pts de vida, Vida: %d",p.getVida());
                                    opcion2 = 3;
                                }
                                    break;
                                case 2:
                                    sc.nextLine();
                                    System.out.println("Te enfrentas al mercader y terminais enzarzados en una pelea callejera, las criaturas comienzan a hacer apuestas por el ganador del combate.");
                                    System.out.println("Cara o cruz");
                                    String lanz = sc.nextLine();
                                    if(p.lanzamineto(lanz, p)){
                                        System.out.println("Ganas el combate y las criaturas empiezan a vitorearte, lleno de orgullo te acercas al puesto y te llevas tu armadura ligera, el mercader asume la derrota y no tiene rencores");
                                        System.out.println("Obtienes una armadura ligera");
                                        p.setArmaduraLigera(true);
                                    }else{
                                        System.out.println("Pierdes el combate y recibes una paliza del mercader, despiertas unos minutos mas tarde y el mercader desconfia de ti");
                                        if(p.getArmadura() || p.getArmaduraLigera()){
                                            p.setVida(p.getVida() - 2);
                                            System.out.printf("-2 pts de vida, Vida: %d \n",p.getVida());
                                        }else{
                                            p.setVida(p.getVida() - 4);
                                            System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());
                                        }
                                    }
                                    opcion = 4;
                                    opcion2 = 3;
                                    break;
                                case 3:
                                    System.out.println("Sales corriendo y escapas");
                                    opcion = 4;
                                    break;
                            
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                        }while(opcion2 != 3);
                        
                    }else{
                        System.out.println("Le compras al mercader honradamente");
                        p.setDinero(p.getDinero() - 4);
                        System.out.println("Obtienes una armadura ligera");
                        System.out.printf("-4 monedas, Dinero: %d \n",p.getDinero());
                        
                    }
                }
                    break;
                case 3:
                if(p.getLlaveOxidada()){
                    System.out.println("Ya te has llevado este articulo");
                }else{
                    if(p.getDinero() < 6){
                        System.out.println("Tratas de comprar el objeto aun sabiendo que no tienes dinero y el vendedor se da cuenta");
                        int opcion2=0;
                        do{
                            System.out.println("Que quieres hacer?");
                            System.out.println("1º disculparse");
                            System.out.println("2º enfrentar");
                            System.out.println("3º salir corriendo");
                            opcion2 = sc.nextInt();
                            switch (opcion2) {
                                case 1:
                                disculpa++;
                                if(disculpa > 1){
                                    System.out.println("Te disculpas con el mercader aunque ya no te ofrece nada");
                                } else{
                                    System.out.println("Te disculpas con el mercader y comenzais a hablar, haceis buenas migas y os terminais volviendo amigos");
                                    p.setVida(p.getVida() + 2);
                                    System.out.println("El mercader te regala una racion de comida");
                                    System.out.printf("+2 pts de vida, Vida: %d \n",p.getVida());
                                    opcion2 = 3;
                                }
                                    break;
                                case 2:
                                    sc.nextLine();
                                    System.out.println("Te enfrentas al mercader y terminais enzarzados en una pelea callejera, las criaturas comienzan a hacer apuestas por el ganador del combate.");
                                    System.out.println("Cara o cruz");
                                    String lanz = sc.nextLine();
                                    if(p.lanzamineto(lanz, p)){
                                        System.out.println("Ganas el combate y las criaturas empiezan a vitorearte, lleno de orgullo te acercas al puesto y te llevas tu media llave oxidada, el mercader asume la derrota y no tiene rencores");
                                        p.setLlaveOxidada(true);
                                        System.out.println("Obtienes media llave oxidada");
                                    }else{
                                        System.out.println("Pierdes el combate y recibes una paliza del mercader, despiertas unos minutos mas tarde y el mercader desconfia de ti");
                                        if(p.getArmadura() || p.getArmaduraLigera()){
                                            p.setVida(p.getVida() - 2);
                                            System.out.printf("-2 pts de vida, Vida: %d \n",p.getVida());
                                        }else{
                                            p.setVida(p.getVida() - 4);
                                            System.out.printf("-4 pts de vida, Vida: %d \n",p.getVida());
                                        }
                                        
                                    }
                                    opcion = 4;
                                    opcion2 = 3;
                                    break;
                                case 3:
                                    System.out.println("Sales corriendo y escapas");
                                    opcion = 4;
                                    break;
                            
                                default:
                                    System.out.println("opcion no valida");
                                    break;
                            }
                        }while(opcion2 != 3);
                        
                    }else{
                        System.out.println("Le compras al mercader honradamente");
                        p.setLlaveOxidada(true);
                        p.setDinero(p.getDinero() - 6);
                        System.out.println("Obtienes media llave oxidada");
                        System.out.printf("-6 monedas, Dinero: %d \n",p.getDinero());
                    }
                }
                    break;
                case 4:
                    System.out.println("Has salido");
                    break;
            
                default:
                System.out.println("opcion no valida");
                    break;
            }
        }while(opcion != 4);

        } else if(x==-1&&y==1){
            System.out.println("-----------L I B R E R I A-----------");
            if(!p.getConocimiento()){
                if(contlibreria == 0){
                    System.out.println("Entras en la biblioteca y te topas con unas gigantes estanterias repletas de libros, los objetos se mueven solos y hay libros flotando por toda la habitacion, uno de estos libros te propone un desafio");
                } else{
                    System.out.println("vuelves con el libro y este te plantea de nuevo el desafio");
                }
                int opcion2 = 0;
                do{
                System.out.println("Que vas a hacer?");
                System.out.println("1º Aceptar");
                System.out.println("2º Irse");
                opcion2 = sc.nextInt();
                sc.nextLine();
                switch (opcion2) {
                    case 1:
                    contlibreria++;
                    if(contlibreria == 1){
                        System.out.println("El libro te habla sobre un codigo oculto en la mazmorra, para obtener la recompensa primero has de encontrarlo y escribirlo en el interior del libro");
                        System.out.println("ya sabes el codigo?");
                    } else{
                        System.out.println("ya sabes el codigo?");
                        String codigo;
                        codigo = sc.nextLine();
                        if(codigo.equals("orruc kroz")){
                            System.out.println("Escribes el codigo dentro de las paginas del libro y este comienza a brillar, sientes como todo el conocimineto del libro se plamara en tu cabeza");
                            p.setConocimiento(true);
                            System.out.println("Obtienes conocimineto");
                        } else{
                            System.out.println("Codigo incorrecto");
                        }
                    }
                    opcion2 = 2;
                        break;
                    case 2:
                        System.out.println("Sales de la biblioteca");
                        break;
                
                    default:
                        System.out.println();
                        break;
                }

            }while (opcion2 != 2); 

        } else{
            System.out.println("La biblioteca es tan grande y fascinante como de costumbre");
        }
        
        } else if(x==-1&&y==-1){
        contclaustro++;
        System.out.println("-----------C L A U S T R O-----------");
        if(contclaustro == 1){
            System.out.println("LLegas a una habitacion muy silenciosa, en su interior parece estar en curso una especie de ritual. Una serie de criaturas enmascaradas hacen un circulo en el suelo y te empiezan a observar");
        } else{
            System.out.println("Entras de nuevo en la sala pero la impresion al verla es la misma que antes");
        }
        int opcion = 0;
        do{
            System.out.println("Que quieres hacer?");
            System.out.println("1º acercarse");
            System.out.println("2º salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                System.out.println("Te acercas a las criaturas, estas te rodean, te dan un libro y te indican que comiences a leer");
                if(p.getConocimiento()){
                    System.out.println("Lees sin problemas todos esos extraños signos y las criaturas te toman como su nuevo mesias, de la felicidad que sienten te dan 5 monedas y una nueva armadura");
                    if(p.getArmaduraLigera()){
                        System.out.println("como ya tienes una armadura, la dejas en el suelo y les das las gracias");
                    } else{
                        p.setArmadura(true);
                        System.out.println("Obtienes una armadura");
                    }
                    p.setDinero(p.getDinero() + 4);
                    System.out.printf("obtienes 4 monedas, dinero: %d\n", p.getDinero());
                }else{
                    System.out.println("Intentas descifrar todos esos signos pero no tienes ni idea de lo que pone en el libro, las criaturas se enfadan y te lanzan un hechizo, tratas de escapar pero este era demasiado rapido");
                    p.setVida(p.getVida() - 4);
                    System.out.printf("-4 pts de vida, Vida: %d\n",p.getVida());
                }
                opcion = 2;
                    break;
                case 2:
                    System.out.println("Sales de la habitacion");
                    break;
            
                default:
                    System.out.println("opcion no valida");
                    break;
            }
        }while(opcion != 2);
    
        }else{
            System.out.println("Habitacion sin salida");
        }
    }
}
