package com.example.disastrospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormsService {

    @Autowired
    private FormsRepository formsRepository;

    public FormsModel saveForm(FormsModel formsModel) {
        return formsRepository.save(formsModel);
    }

    public FormsModel getFormByName(String name) {
        return formsRepository.findByName(name);
    }

    public List<FormsModel> getAllForms() {
        return formsRepository.findAll();
    }
    public List<Good> donateGoods(FormsModel form, List<Good> donatedGoods) {
        List<Good> updatedGoods = form.getGoods().stream()
                .map(good -> {
                    donatedGoods.stream()
                            .filter(donatedGood -> donatedGood.getName().equalsIgnoreCase(good.getName()))
                            .findFirst()
                            .ifPresent(donatedGood -> good.setCount(good.getCount() - donatedGood.getCount()));
                    return good;
                })
                .filter(good -> good.getCount() > 0)
                .collect(Collectors.toList());

        form.setGoods(updatedGoods);
        formsRepository.save(form);

        return updatedGoods;
            }
}
