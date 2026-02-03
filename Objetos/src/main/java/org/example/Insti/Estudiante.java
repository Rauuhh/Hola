package org.example.Insti;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

public class Estudiante
{
    @NonNull
    private String nombre;
    private int edad;
    private Curso curso;


}
