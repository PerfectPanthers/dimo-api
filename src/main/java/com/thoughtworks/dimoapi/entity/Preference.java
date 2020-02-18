package com.thoughtworks.dimoapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "preferences")
@NoArgsConstructor
@Data
public class Preference {

    @Id
    private String id;
    private String code;
    private String itemName;
    private String type;

}
