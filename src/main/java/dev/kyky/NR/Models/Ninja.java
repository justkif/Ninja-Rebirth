package dev.kyky.NR.Models;

import org.springframework.data.annotation.Id;

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

    @NotEmpty
    String imageurl
    
) {

    public Ninja createOne(String imageurl) {
        return new Ninja(
            this.id,
            this.name,
            this.skill1, 
            this.skill2, 
            this.skill3, 
            this.skill4,
            imageurl
        );
        
    }

    public Ninja updateOne(Ninja ninja) {
        return new Ninja(
            this.id, 
            this.name, 
            ninja.skill1, 
            ninja.skill2, 
            ninja.skill3, 
            ninja.skill4,
            this.imageurl
        );
    }

}
