package entidades;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
    private String nombre;
    private int nota;
    private String curso;
}
