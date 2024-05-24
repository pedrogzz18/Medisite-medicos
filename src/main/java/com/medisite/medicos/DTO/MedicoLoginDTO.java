package com.medisite.medicos.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicoLoginDTO {
    private String email;
    private String password;
}
