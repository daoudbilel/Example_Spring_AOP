package com.example.service;

import com.example.aspects.Log;
import com.example.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class MetierImpl implements IMetier {

    // si on utilise les annotation pour logger les methods
    // on a cree une annotation @log

    @Override
    @Log
    @SecuredByAspect(roles = {"USER", "ADMIN"})
    public void process() {
        System.out.println("Business Process .....");
    }

    @Override
    @Log
    @SecuredByAspect(roles = {"ADMIN"})
    public double compute() {
        double data = 78;
        System.out.println("Business Computing and returning .....");
        return data;
    }
}
