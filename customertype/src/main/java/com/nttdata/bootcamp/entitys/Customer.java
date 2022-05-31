package com.nttdata.bootcamp.entitys;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerType")
public class Customer {

    @Id
    private String id;
    private String name;
    private String surname;
    private String dni;
    private String customerType;
}
