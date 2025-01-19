package dev.kyky.NR.Models;

import jakarta.validation.constraints.NotEmpty;

public record JWT(

    @NotEmpty
    String username,

    @NotEmpty
    String token

) {

}
