public class Fecha {

    private int dia;

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        } else {
            this.dia = 1;
        }
    }

    public int getDia() {
        return dia;
    }

    private int mes;

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        } else {
            this.mes = 1;
        }
    }

    public int getMes(){
        return mes;
    }

    private int año;

    public void setAño(int año) {
        this.año = año;
    }

    public int getAño() {
        return año;
    }

    public Fecha() {
        this.dia = 3;
        this.mes = 2;
        this.año = 2006;
    }

    public Fecha(int dia, int mes, int año) {
        setDia(dia);
        setMes(mes);
        this.año = año;
    }

    public String fechaFormateada(boolean bandera) {
        String fecha="";
        if (bandera == true) {
            fecha = dia + "/" + mes + "/" + año;
        } else {
            switch (mes) {
                case 1:
                    fecha = dia + " de Enero de " + año;

                    break;
                case 2:
                    fecha = dia + " de Febrero de " + año;

                    break;
                case 3:
                    fecha = dia + " de Marzo de " + año;

                    break;
                case 4:
                    fecha = dia + " de Abril de " + año;

                    break;
                case 5:
                    fecha = dia + " de Mayo de " + año;

                    break;
                case 6:
                    fecha = dia + " de Junio de " + año;

                    break;
                case 7:
                    fecha = dia + " de Julio de " + año;

                    break;
                case 8:
                    fecha = dia + " de Agosto de " + año;

                    break;
                case 9:
                    fecha = dia + " de Septiembre de " + año;

                    break;
                case 10:
                    fecha = dia + " de Octubre de " + año;

                    break;
                case 11:
                    fecha = dia + " de Noviembre de " + año;

                    break;
                case 12:
                    fecha = dia + " de Diciembre de " + año;

                    break;

                default:
                    break;
            }
        }
        return fecha;
    }

    public static int diferenciaFechas(Fecha f1, Fecha f2){
        int diferencia;
        if(f1.getAño() >= f2.getAño()){
            diferencia = f1.getAño() - f2.getAño();
        } else {
            diferencia = f2.getAño() - f1.getAño();
        }
        return diferencia;
    }
}
