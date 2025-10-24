
package ejercicio4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ejercicio4.proyectoEmpresa.Empleado;

@DisplayName("Application")
public class ApplicationTest {

//   public static double hacienda(double salario, double irpf){
//     return salario * irpf/100;
// }

  static Empleado p;
  @BeforeAll
  public static void iniciar(){

    Empleado p = new Empleado();
  }

  static int salario;
  static double irpf;

  @BeforeEach
  public void iniciar2(){

    salario = 1200;
    irpf = 0.25;
  }

  @Test
  public void empleado(){

    p.setSalarioAnual(salario);
    assertEquals(p.getSalarioAnual(),irpf );
  }
}
