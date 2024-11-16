package com.e.learning.service;

import java.util.List;

import com.e.learning.repository.MaterialsRepository;
import com.e.learning.model.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialsService {

    @Autowired
    private MaterialsRepository materialRepository;

    public List<Material> loadMaterials(long id) {
        return materialRepository.getMaterialsByCourseId(id);
        
    }
    
}
