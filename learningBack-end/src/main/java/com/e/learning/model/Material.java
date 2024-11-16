package com.e.learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialId;

    @ManyToOne
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;
    
    // Enum to define types of study materials
    @Enumerated(EnumType.STRING)
    private MaterialType materialType; 

    private String contentUrl; // URL for file or online resources

    @Lob
    private String description;

    private String fileName;
    private String filePath; 

    // Optional: Add fields for other types of material
    private String additionalInfo; // For any other info that might be needed

    
}

// Enum to define material types
enum MaterialType {
    FILE,   
   
    Video
}
