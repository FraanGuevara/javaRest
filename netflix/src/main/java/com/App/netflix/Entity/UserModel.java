package com.App.netflix.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data //genera los getters y setters
@NoArgsConstructor //genera el constructor sin atributos
@AllArgsConstructor //genera el constructor con todos los atributos
public class UserModel {


    //    @GenericGenerator(name = "uuid", strategy = "uuid2") //nos aseguramos que los id no se repitan
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //el valor del id se genera de manera automatica cuando el repo persista a la entidad
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String email;
    private Integer level;

}
