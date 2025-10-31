package entidades;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Empleado {
    private String nombre;
    private String departamento;
    private double salario;
    private int edad;

}
