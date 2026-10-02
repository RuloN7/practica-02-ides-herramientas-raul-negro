package com.example.init.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RespuestaDTO {
    private String nombre;
    private String url;
    private String descripcion;
}
