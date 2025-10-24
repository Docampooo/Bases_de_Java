import java.util.Scanner;

public class Zork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Protagonista p = new Protagonista();
        Habitacion h = new Habitacion(0, 0, p);

        String eleccion = "";
        int salir = 0;
        int x = 0;
        int y = 0;

        System.out.println("");
        System.out.println("");
        System.out.println("ZZZZZZZ  OOOOO   RRRRR    K   K ");
        System.out.println("    Z    O   O   R   R    K  K  ");
        System.out.println("   Z     O   O   RRRRR    KKK   ");
        System.out.println("  Z      O   O   R  R     K  K  ");
        System.out.println("ZZZZZZZ  OOOOO   R   R    K   K ");
        System.out.println("");
        System.out.println("");

        System.out.println("Bienvenido a Zork, Un Juego de Simulación de Fantasía Computadorizada por Infocom, para saber los controles escribe: help");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Abres los ojos desorientado y con problemas para recordar dónde estás, lo único que sabes es que te encuentras dentro de una pequeña habitacion en la que no entra mucha luz, un fuerte miedo se apodera de ti y solo puedes pensar en salir de ese lugar desconocido.");

        do {
            eleccion = sc.nextLine();
            if(eleccion.equals("help")){
                p.help(p);
            } else if(eleccion.equals("invent")){
                p.invent(p);
            } else if(eleccion.equals("stats")){
                p.stats(p);
            } else{
                switch (eleccion) {
                    case ("norte"):
                    case ("sur"):
                        h.setY(h.getY(), eleccion);
                        break;
                    case ("este"):
                    case ("oeste"):
                        h.setX(h.getX(), eleccion);
                        break;
                        
                        default:
                        System.out.println("Opcion no válida");
                        break;
                }
            h.contenido(h.getX(), h.getY(), p);
            }
            if(p.getVida()<=0){
                salir = 1;
            }
            if(p.getFin()){
                salir = 1;
            }
        } while (salir != 1);
        
        if(p.getVida()<=0){
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
        }
        if(p.getFin()){
            System.out.println("---- F I N ----");
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
