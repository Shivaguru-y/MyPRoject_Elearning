package com.e.learning.controller;

import com.e.learning.model.Material;
import com.e.learning.service.MaterialsService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/materials")
public class MaterialController {
    @Autowired
    private MaterialsService materialService;


    @GetMapping("/getMaterialsByCourseId/{id}")
    public List<Material> getMethodName(@PathVariable(value = "id") Long stackId) {
        return materialService.loadMaterials(stackId);
    }
}
