package com.example.disastrospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/forms")
public class FormsController {

    @Autowired
    private FormsService formsService;

    @PostMapping
    public ResponseEntity<FormsModel> createForm(@RequestBody FormsModel formsModel) {
        FormsModel savedForm = formsService.saveForm(formsModel);
        return ResponseEntity.ok(savedForm);
    }

    @GetMapping("/{name}")
    public ResponseEntity<FormsModel> getFormByName(@PathVariable String name) {
        FormsModel form = formsService.getFormByName(name);
        if (form == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(form);
    }

    @GetMapping
    public ResponseEntity<List<FormsModel>> getAllForms() {
        List<FormsModel> forms = formsService.getAllForms();
        return ResponseEntity.ok(forms);
    }
    @GetMapping("/{name}/goods")
    public ResponseEntity<List<Good>> getGoodsByFormName(@PathVariable String name) {
        FormsModel form = formsService.getFormByName(name);
        if (form == null) {
            return ResponseEntity.notFound().build();
        }
        List<Good> goods = form.getGoods();
        return ResponseEntity.ok(goods);
    }
    @PutMapping("/{name}/donate")
    public ResponseEntity<List<Good>> donateGoods(@PathVariable String name, @RequestBody List<Good> donatedGoods) {
        FormsModel form = formsService.getFormByName(name);
        if (form == null) {
            return ResponseEntity.notFound().build();
        }
        List<Good> updatedGoods = formsService.donateGoods(form, donatedGoods);
        return ResponseEntity.ok(updatedGoods);
    }
}
