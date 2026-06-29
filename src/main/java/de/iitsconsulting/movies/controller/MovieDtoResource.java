package de.iitsconsulting.movies.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MovieDtoResource {

    @NotBlank(message = "Title is mandatory")
    public String title;

    @Min(value = 1900, message = "Invalid year")
    public int year;

    @NotBlank(message = "Name is mandatory")
    public String directorFirstName;

    @NotBlank(message = "Name is mandatory")
    public String directorLastName;
}
