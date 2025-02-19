package dev.kyky.NR.Models;

import org.springframework.data.annotation.Id;

public record Image(

    @Id
    Integer id,

    byte[] data

) {

}
