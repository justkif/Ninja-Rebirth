package dev.kyky.NR.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import jakarta.validation.constraints.NotEmpty;

public record Ninja(

    @Id 
    Integer id,

    @NotEmpty 
    String name,

    @NotEmpty 
    String skill1,

    @NotEmpty 
    String skill2,

    @NotEmpty 
    String skill3,

    @NotEmpty 
    String skill4,

    @Version 
    Integer version
    
) {

}
