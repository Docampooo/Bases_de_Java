package bol5_ejer9;

public class Aula {

    private int[][] notas;

    public void setNotas(int[][] notas) {
        this.notas = notas;
    }

    public int[][] setNotas(int fila, int columna, int valor) {
        notas[fila][columna] = valor;
        return notas;
    }

    public int[][] getNotas() {
        return notas;
    }

    public String[] alumnos;

    public String[] getAlumnos() {
        return alumnos;
    }

    public String[] materias;

    public String[] getMaterias() {
        return materias;
    }

    public String[][] listaAlumnos() {
        String[][] lista = new String[this.getAlumnos().length][2];

        for (int fila = 0; fila < this.getAlumnos().length; fila++) {
            for (int columna = 0; columna < 2; columna++) {
                if (columna == 0) {
                    lista[fila][columna] = Integer.toString(fila+1);
                } else {
                    lista[fila][columna] = this.getAlumnos()[fila];
                }
            }
        }
        return lista;
    }

    public double mediaNotas(){
        String[] alumnos = this.getAlumnos();
        String[] asignaturas = this.getMaterias();
        int[][] notas = this.getNotas();
        
        double acu=0;

        for(int fila=0;fila<notas.length;fila++){
            for(int columna=0;columna<notas[fila].length;columna++){
                acu = acu + notas[fila][columna];
            }
        }
        return acu/(alumnos.length * asignaturas.length);
    }

    public double mediaAlumnos(int n){
        String[] asignaturas = this.getMaterias();
        int[][] notas = this.getNotas();

        double acu=0;
        for(int columna=0;columna<notas[n].length;columna++){
            acu = acu + notas[n][columna];
        }
        return acu/(asignaturas.length);
    }

    public double mediaMateria(int n){
        String[] alumnos = this.getAlumnos();
        int[][] notas = this.getNotas();

        double acu=0;
        for(int fila=0;fila<notas.length;fila++){
            acu = acu + notas[fila][n-1];
        }
        return acu/(alumnos.length);
    }

    public int[] maximosMinimos(int n){
        String[] alumnos = this.getAlumnos();
        int[][] notas = this.getNotas();

        int[] acu = {0,notas[0][0],notas[0][0]};

        for(int fila=0;fila<notas.length;fila++){
            acu[0] = notas[fila][n-1];

            if(acu[0]>acu[1]){
                acu[1] = acu[0]; 
            }else if(acu[0]<acu[2]){
                acu[2] = acu[0];
            }
        }
        return acu;
    }


    public Aula(String[] alumnos, String[] materias) {
        this.alumnos = alumnos;
        this.materias = materias;
        notas = new int[alumnos.length][materias.length];

        double num;
        for (int fila = 0; fila < notas.length; fila++) {
            for (int columna = 0; columna < notas[fila].length; columna++) {
                num = Math.random();
                if (num < 0.15) { // 0,1,2
                    notas[fila][columna] = (int) (Math.random() * 3 + 0);
                } else if (num >= 0.15 && num < 0.25) { // 3
                    notas[fila][columna] = 3;
                } else if (num >= 0.25 && num < 0.70) { // 4,5,6
                    notas[fila][columna] = (int) (Math.random() * 3 + 4);
                } else if (num >= 0.70 && num < 0.90) { // 7,8
                    notas[fila][columna] = (int) (Math.random() * 2 + 7);
                } else { // 9,10
                    notas[fila][columna] = (int) (Math.random() * 2 + 9);
                }
            }
        }
    }

    public Aula(int cantAlumnos, int cantAsignaturas) {

        String[] alumnos = new String[cantAlumnos];
        for (int i = 1; i < alumnos.length; i++) {
            alumnos[i] = "Alumno " + i;
        }

        String[] asignaturas = new String[cantAsignaturas];
        for (int i = 1; i < asignaturas.length; i++) {
            asignaturas[i] = "ASIG " + i;
        }
    }
}
