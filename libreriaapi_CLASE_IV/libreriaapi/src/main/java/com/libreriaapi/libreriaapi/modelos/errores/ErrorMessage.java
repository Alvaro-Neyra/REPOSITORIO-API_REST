package com.libreriaapi.libreriaapi.modelos.errores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Integer statusCode;
    private String message;
}
