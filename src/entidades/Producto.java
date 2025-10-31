package entidades;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;
}
