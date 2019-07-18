package com.cleverlance.academy.airlines.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Traveler {

    @Id
    @GeneratedValue
    private Long travelerId;

    private String firstName;
    private String lastName;
    private String documentId;
    private DocumentType documentType;
}
