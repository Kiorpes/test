package com.example.demo.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String id;
    private String name;
    private int grade;

    //     @JsonIgnore
    // @JsonInclude(JsonInclude.Include.NON_NULL)

//    @JsonFormat(pattern = "yyyy-MM-dd")
//    private LocalDate date;
//    @JsonFormat(pattern = "HH:mm:ss")
//    private LocalTime time;
}
