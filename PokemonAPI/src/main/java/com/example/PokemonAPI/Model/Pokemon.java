package com.example.PokemonAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;


import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del Pokemon es requerido")
    @Size(min = 2, max = 100, message = "El nombre debe tener al menos 2 y 100 caracteres")
    private String nombre;
    @NotBlank(message = "El tipo de pokemon es obligatorio")
    private String tipo;
    @NotBlank(message = "El nivel del pokemon es requerido")
    @Min(value = 0, message = "El nivel no puede ser negativo")
    @Max(value = 0, message = "El nivel no puede ser mayor a 100")
    private Integer nivel;

    @Max(value = 0, message = "El ataque no puede ser negativo")
    private Integer ataque;

    @Min(value = 0, message = "La defensa no puede ser negativo")
    private Integer defensa;
    @Size(max = 255, message = "La descripcion no puede exceder los 255 caracteres")
    private String descripcion;
    @URL(message = "La imagen debe ser una URL")
    private String imagenUrl;
    @Email(message = "El formato del correo no es valido")
    private String correoEntrenador;
    @PastOrPresent(message = "La fecha de nacimiento no puede ser futura")
    private LocalDate fechaCaptura;

    @Positive(message = "El peso debe ser positivo")
    private Double peso;
    @Pattern(regexp = "^\\\\d{10}$", message = "El formato del telefono no es valido")
    private String telefono;

    @AssertTrue(message = "El pokemon debe estar sano")
    private Boolean estaSano;






}

