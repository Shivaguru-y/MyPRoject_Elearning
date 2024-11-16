package com.e.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    private String languageName;

    @ManyToOne
    @JoinColumn(name = "stackId", referencedColumnName = "stackId")
    private Stack stack;
    
}
