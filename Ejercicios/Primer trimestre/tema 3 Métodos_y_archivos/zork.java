import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class zork {

    public static void norte(String cadena) throws FileNotFoundException {
        Scanner W = new Scanner(new File("zorkn1.txt"));
        while (W.hasNext()) {
            cadena = W.nextLine();
            System.out.println(cadena);
        }
        W.close();
    }

    public static boolean sur(String cadena) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Scanner S = new Scanner(new File("zorks1.txt"));
        String almacen = "";
        boolean obtencion = false;

        for (int cont2 = 0; cont2 < 4; cont2++) {
            cadena = S.nextLine();
            System.out.println(cadena);
            almacen = almacen + "\n" + cadena;
        }
        int decision = 0;
        decision = sc.nextInt();
        if (decision == 1) {
            S.nextLine();
            obtencion = true;
            cadena = S.nextLine();
            System.out.println(cadena);
            almacen = almacen + "\n" + cadena;
            cadena = S.nextLine();
            System.out.println(cadena);
            almacen = almacen + "\n" + cadena;
        } else {
            for (int cont = 0; cont < 4; cont++) {
                S.nextLine();
            }
            cadena = S.nextLine();
            System.out.println(cadena);
            almacen = almacen + "\n" + cadena;
            cadena = S.nextLine();
            System.out.println(cadena);
            almacen = almacen + "\n" + cadena;
            if (decision == 2) {
                obtencion = false;
            }
            S.close();
        }
        return obtencion;
    }

    public static void este(String cadena) throws FileNotFoundException {
        Scanner D = new Scanner(new File("zorke1.txt"));
        while (D.hasNext()) {
            cadena = D.nextLine();
            System.out.println(cadena);
        }
        D.close();
    }

    public static void oeste(String cadena) throws FileNotFoundException {
        Scanner A = new Scanner(new File("zorko1.txt"));
        while (A.hasNext()) {
            cadena = A.nextLine();
            System.out.println(cadena);
        }
        A.close();
    }

    public static String eleccion() {
        Scanner sc = new Scanner(System.in);
        String accion = "";
        System.out.println("¿Qué quieres hacer?");
        System.out.println("c: coger objeto");
        System.out.println("u: usar objeto");
        System.out.println("v: volver");
        accion = sc.nextLine();

        return accion;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String sala;
        String norte;
        String sur;
        String este;
        String oeste;
        boolean cuerda = false;
        boolean hueso = false;
        boolean llave = false;
        boolean muerte = false;
        boolean victoria = false;
        String volverAlInicio = "";
        int salir = 0;

        int conts=0;

        System.out.println("");
        System.out.println("");
        System.out.println("ZZZZZZZ  OOOOO   RRRRR    K   K ");
        System.out.println("    Z    O   O   R   R    K  K  ");
        System.out.println("   Z     O   O   RRRRR    KKK   ");
        System.out.println("  Z      O   O   R  R     K  K  ");
        System.out.println("ZZZZZZZ  OOOOO   R   R    K   K ");
        System.out.println("");
        System.out.println("");

        System.out.println("Bienvenido a Zork, Un Juego de Simulación de Fantasía Computadorizada por Infocom ");
        System.out.println(
                "Para desplazarte por el juego deberás seleccionar una sala y una vez interactues con ella, podrása moverte a otras salas introduciendo el numero que les corresponde");
        System.out.println("OESTE DE LA CASA");
        System.out.println("--------------------------------------------------------------");
        System.out.println(
                "Estás en un campo abierto al lado oeste de una casa blanca con una entablada puerta delantera.");
        do {
            System.out.println("Elige una sala");
            System.out.println("n: Norte de la casa");
            System.out.println("s: sur de la casa");
            System.out.println("e: este de la casa");
            System.out.println("o: oeste de la pradera");
            sala = sc.nextLine();
            switch (sala) {
                case "n":
                    do {
                        sala = "n";
                        if(llave==false){
                            norte(sala);
                            switch (eleccion()) {
                                case "c":
                                    System.out.println("te acercas al perro para coger las llaves, lamentablemente haces mucho ruido y el perro se despierta, te asustas y comienzas a correr para librarte de sus fauces. Una pena que el perro sea mas rapido.");
                                    salir = 1;
                                    muerte = true;
                                    volverAlInicio = "v";
                                    System.out.println("------------------------------------------------------------------------");
                                break;
                                case "u":
                                    if(cuerda == true){
                                        System.out.println("tratas de usar la cuerda para coger las llaves pero no eres los suficientemente habilidoso y despiertas al perro que no duda ni un segundo en avalanzarse sobre ti");
                                        salir = 1;
                                        muerte = true;
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                    } else if(hueso == true){
                                        System.out.println("arrojas el pestilente hueso a unos metros del perro, este se despierta y se dirige rapidamente a por el hueso atraido por su aroma, aprovechas la situación para hacerte con las llaves y abandonar la sala.");
                                        llave = true;
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                    } else if ((hueso == false) && (cuerda == false)) {
                                        System.out.println("No tienes nada que puedas utilizar aquí");
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
    
                                    }
                                break;
                                case "v":
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                break;
                                default:
                                break;
                                }
                        } else{
                            System.out.println("abres la puerta y al otro lado escuchas unos rugidos, parece que algo está esperando al otro lado de la puerta, mejor no entrar aquí");
                            volverAlInicio = "v";
                            System.out.println("sales de la sala");
                            System.out.println("------------------------------------------------------------------------");
                        }
                        } while (volverAlInicio != "v");
                break;
                case "s":
                    do {
                        conts++;
                        if(conts==1){
                            sala = "s";
                            hueso = sur(sala);
                            cuerda = !hueso;
                            volverAlInicio = "v";
                            System.out.println("sales de la sala");
                            System.out.println("------------------------------------------------------------------------");
                        } else{
                            System.out.println("regresas al bosque oscuro a echar un vistazo pero nada parece haber cambiado. No hay ni rastro de aquella criatura misteriosa, no hay mucho más que se pueda hacer por aquí");
                            volverAlInicio = "v";
                            System.out.println("sales de la sala");
                            System.out.println("------------------------------------------------------------------------");
                        }
                    } while (volverAlInicio != "v");

                    break;
                case "e":
                    do {
                        sala = "e";
                        este(sala);
                        switch (eleccion()) {
                            case "c":
                                System.out.println("recoges una especie de felpudo que hay en el suelo en el que pone ZORK, no parece muy util pero te lo llevas porque te gusta.");
                                volverAlInicio = "v";
                                System.out.println("sales de la sala");
                                System.out.println("------------------------------------------------------------------------");
                            break;
                            case "u":
                                if(llave == true){
                                    System.out.println("tratas de abrir la puerta con la llave que encontraste, está oxidada la cerradura y justo cuando te ibas a dar por vencido, la puerta cede y se abre la puerta. Entras poco a poco en esa extraña casa y comienzas a explorar, en el momento en el que subes a la despensa, encuentras una pequeña maquina, pulsas el boton y todo empieza a desvanecerse a tu alrededor, cierras los ojos confundido. Cuando los vuelvese a abrir, te encuentras que estas frente al pueblo en el que te criaste. Has regresado a casa despues de tantos años, sobreviviste a Zork y te vuelves una leyenda en el pueblo");
                                    System.out.println("----------------------------------------------------- F I N -----------------------------------------------------");
                                    salir = 1;
                                    victoria=true;
                                    volverAlInicio = "v";
                                    System.out.println("sales de la sala");
                                    System.out.println("------------------------------------------------------------------------");
                                } else{
                                    System.out.println("No tienes nada que puedas usar aquí");
                                    volverAlInicio = "v";
                                    System.out.println("sales de la sala");
                                    System.out.println("------------------------------------------------------------------------");
                                }
                            break;
                            case "v":
                                    volverAlInicio = "v";
                                    System.out.println("sales de la sala");
                                    System.out.println("------------------------------------------------------------------------");
                            break;
                            default:
                            break;
                            }
                    } while (volverAlInicio != "v");

                    break;
                case "o":
                    do {
                        sala = "o";
                        if(llave==false){
                            oeste(sala);
                            switch (eleccion()) {
                                case "c":
                                    System.out.println("recoges algunas ramas secas del suelo, igual te resultan útil en algún momento");
                                    volverAlInicio = "v";
                                    System.out.println("sales de la sala");
                                    System.out.println("------------------------------------------------------------------------");
                                break;
                                case "u":
    
                                    if(cuerda == true){
                                        System.out.println("enganchas la cuerda a lo alto de la rama y comienzas a agitarla, como resultado, el objeto brillante cae al suelo y descubres que se trataba de unas llaves.");
                                        llave=true;
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                    } else if(hueso == true){
                                        System.out.println("El olor del hueso atrae a una especie de insectos gigantes, entras en panico y tratas de aplastarlos, lamentablemente son demasiados y acaban contigo");
                                        muerte = true;
                                        salir=1;
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                    } else if ((hueso == false) && (cuerda == false)) {
                                        System.out.println("no tienes nada que puedas utilizar aqui");
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                    }
                                break;
                                case "v":
                                        volverAlInicio = "v";
                                        System.out.println("sales de la sala");
                                        System.out.println("------------------------------------------------------------------------");
                                break;
                                default:
                                break;
                                }
                        } else{
                            System.out.println("Este lugar es muy tenebroso, no parece que haya mucho mas que hacer por aqui. Mejor dar media vuelta");
                            volverAlInicio = "v";
                            System.out.println("sales de la sala");
                            System.out.println("------------------------------------------------------------------------");
                    }
                    } while (volverAlInicio != "v");

                    break;

                default:
                    break;
            }
        } while (salir != 1);
        if(muerte==true){
            System.out.println("Has muerto");
            System.out.println("                     .ed\"\"\"\" \"\"\"$$$$be.\r\n" + //
                                "                   -\"           ^\"\"**$$$e.\r\n" + //
                                "                 .\"                   '$$$c\r\n" + //
                                "                /                      \"4$$b\r\n" + //
                                "               d  3                     $$$$\r\n" + //
                                "               $  *                   .$$$$$$\r\n" + //
                                "              .$  ^c           $$$$$e$$$$$$$$.\r\n" + //
                                "              d$L  4.         4$$$$$$$$$$$$$$b\r\n" + //
                                "              $$$$b ^ceeeee.  4$$ECL.F*$$$$$$$\r\n" + //
                                "  e$\"\"=.      $$$$P d$$$$F $ $$$$$$$$$- $$$$$$\r\n" + //
                                " z$$b. ^c     3$$$F \"$$$$b   $\"$$$$$$$  $$$$*\"      .=\"\"$c\r\n" + //
                                "4$$$$L   \\     $$P\"  \"$$b   .$ $$$$$...e$$        .=  e$$$.\r\n" + //
                                "^*$$$$$c  %..   *c    ..    $$ 3$$$$$$$$$$eF     zP  d$$$$$\r\n" + //
                                "  \"**$$$ec   \"\\   %ce\"\"    $$$  $$$$$$$$$$*    .r\" =$$$$P\"\"\r\n" + //
                                "        \"*$b.  \"c  *$e.    *** d$$$$$\"L$$    .d\"  e$$***\"\r\n" + //
                                "          ^*$$c ^$c $$$      4J$$$$$% $$$ .e*\".eeP\"\r\n" + //
                                "             \"$$$$$$\"'$=e....$*$$**$cz$$\" \"..d$*\"\r\n" + //
                                "               \"*$$$  *=%4.$ L L$ P3$$$F $$$P\"\r\n" + //
                                "                  \"$   \"%*ebJLzb$e$$$$$b $P\"\r\n" + //
                                "                    %..      4$$$$$$$$$$ \"\r\n" + //
                                "                     $$$e   z$$$$$$$$$$%\r\n" + //
                                "                      \"*$c  \"$$$$$$$P\"\r\n" + //
                                "                       .\"\"\"*$$$$$$$$bc\r\n" + //
                                "                    .-\"    .$***$$$\"\"\"*e.\r\n" + //
                                "                 .-\"    .e$\"     \"*$c  ^*b.\r\n" + //
                                "          .=*\"\"\"\"    .e$*\"          \"*bc  \"*$e..\r\n" + //
                                "        .$\"        .z*\"               ^*$e.   \"*****e.\r\n" + //
                                "        $$ee$c   .d\"                     \"*$.        3.\r\n" + //
                                "        ^*$E\")$..$\"                         *   .ee==d%\r\n" + //
                                "           $.d$$$*                           *  J$$$e*\r\n"
                                );
        } else{
            System.out.println("                           .-.\r\n" + //
                                "                          {{@}}\r\n" + //
                                "          <>               8@8\r\n" + //
                                "        .::::.             888\r\n" + //
                                "    @\\\\/W\\/\\/W\\//@         8@8\r\n" + //
                                "     \\\\/^\\/\\/^\\//     _    )8(    _\r\n" + //
                                "      \\_O_<>_O_/     (@)__/8@8\\__(@)\r\n" + //
                                " ____________________ `~\"-=):(=-\"~`\r\n" + //
                                "|<><><>  |  |  <><><>|     |.|\r\n" + //
                                "|<>      |  |      <>|     |S|\r\n" + //
                                "|<>      |  |      <>|     |'|\r\n" + //
                                "|<>   .--------.   <>|     |.|\r\n" + //
                                "|     |   ()   |     |     |P|\r\n" + //
                                "|_____| (O\\/O) |_____|     |'|\r\n" + //
                                "|     \\   /\\   /     |     |.|\r\n" + //
                                "|------\\  \\/  /------|     |U|\r\n" + //
                                "|       '.__.'       |     |'|\r\n" + //
                                "|        |  |        |     |.|\r\n" + //
                                ":        |  |        :     |N|\r\n" + //
                                " \\<>     |  |     <>/      |'|\r\n" + //
                                "  \\<>    |  |    <>/       |.|\r\n" + //
                                "   \\<>   |  |   <>/        |K|\r\n" + //
                                "    `\\<> |  | <>/'         |'|\r\n" + //
                                "      `-.|  |.-`           \\ /\r\n" + //
                                "         '--'               ^\r\n"
                                );
        }
    }
}