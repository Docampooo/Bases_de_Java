public class EjercicioValidacion {
    
    public static void main(String[] args) {
        
        String frase = "Jar-Jar is the Big Boss";
        System.out.println("Longitud "+frase.length());
        
        System.out.println("Primer y ultimo caracter " +frase.charAt(0) + " " +frase.charAt(frase.length()-1));//En la posición 100 sale una excepcion, pues no está en el rango

        String mayus = "la clase de programacion es divertida";
        mayus = mayus.toUpperCase();
        System.out.println(mayus); //ecuals compara caracteres exactos, resultando false al diferenciar de mayusculas y minusculas y ecualsIgnoresCase devuelve true independientemente de si son mayusculas o minusculas

        String minus = mayus.toLowerCase();
        System.out.println(minus);

        if(frase.endsWith("Boss") || frase.endsWith("Jar")){
            System.out.println("truers");
        }else{
            System.out.println("Falsers");
        }

        System.out.printf("Primera aparicion:%s, ultima aparicion %s: \n",frase.indexOf("Jar"), frase.lastIndexOf("Jar"));

        String cacho = frase.substring(7, 15); //no incluye el final
        System.out.println(cacho);

        frase = frase.trim();
        System.out.println(frase);

        for(String c:(frase.split("[ -]"))){
            System.out.printf("%s",c);
        }
        System.out.println();

        for(String c:(frase.split("[ -]"))){
            System.out.printf("%.3s \n",c);
        }
        System.out.println();
    }
}