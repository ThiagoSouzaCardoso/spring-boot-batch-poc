package br.com.spring.batch.demo.br.com.spring.batch.demo.config.br.com.spring.batch.demo.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;

@Data
@EqualsAndHashCode
@ToString
@JsonTypeName("person")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT ,use = JsonTypeInfo.Id.NAME)
public class Person {

    private String name;
    private Integer age;

}
