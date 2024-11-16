package com.e.learning.service;

import com.e.learning.model.Stack;
import com.e.learning.repository.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StackService {

    @Autowired
    private StackRepository stackRepository;

    public List<Stack> getAllStacks() {
        return stackRepository.findAll();
    }

    public Optional<Stack> getStackById(Long stackId) {
        return stackRepository.findById(stackId);
    }

    public Stack createStack(Stack stack) {
        return stackRepository.save(stack);
    }

    public Stack updateStack(Long stackId, Stack stackDetails) {
        Stack stack = stackRepository.findById(stackId)
                .orElseThrow(() -> new RuntimeException("Stack not found for this id :: " + stackId));

        stack.setStackName(stackDetails.getStackName());
        // If there are more fields, update them as well
        return stackRepository.save(stack);
    }

    public void deleteStack(Long stackId) {
        stackRepository.deleteById(stackId);
    }
}
