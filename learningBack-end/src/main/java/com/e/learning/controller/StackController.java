package com.e.learning.controller;

import com.e.learning.model.Stack;
import com.e.learning.service.StackService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/stacks") 
public class StackController {

    @Autowired
    private StackService stackService; 

    @GetMapping("/getallStacks")
    public List<Stack> getAllStacks() {
        return stackService.getAllStacks();
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Stack> getStackById(@PathVariable(value = "id") Long stackId) {
        Optional<Stack> stack = stackService.getStackById(stackId);
        return stack.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/CreateStack")
    public ResponseEntity<Stack> createStack(@Valid @RequestBody Stack stack) {
        Stack createdStack = stackService.createStack(stack);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStack);
    }

    @PutMapping("/UpdateStackById/{id}")
    public ResponseEntity<Stack> updateStack(@PathVariable(value = "id") Long stackId,
                                            @Valid @RequestBody Stack stackDetails) {
        Stack updatedStack = stackService.updateStack(stackId, stackDetails);
        return ResponseEntity.ok(updatedStack);
    }


}
