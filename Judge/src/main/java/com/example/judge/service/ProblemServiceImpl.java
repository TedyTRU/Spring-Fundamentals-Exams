package com.example.judge.service;

import com.example.judge.model.entiry.Problem;
import com.example.judge.model.service.ProblemServiceModel;
import com.example.judge.repository.ProblemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;

    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean createProblem(ProblemServiceModel problemServiceModel) {
        Problem problem = modelMapper.map(problemServiceModel, Problem.class);

        try {
            problemRepository.save(problem);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
