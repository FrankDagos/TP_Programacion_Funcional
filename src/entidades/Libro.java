package entidades;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Libro {
    private String titulo;
    private String autor;
    private int paginas;
    private double precio;
}
