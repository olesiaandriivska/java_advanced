package com.javaadvanced.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor     //генерирує конструктор с одним параметром для каждого поля в класі
@Data                   //@ToString, @EqualsAndHashCode, @Getter / @Setter и @RequiredArgsConstructor
@NoArgsConstructor   //генерує конструктор без параметрів
public class Movie {

    private int id;
    private String title;
//    @JsonIgnore          //забирає одну пропертю
    private int duration;
}
