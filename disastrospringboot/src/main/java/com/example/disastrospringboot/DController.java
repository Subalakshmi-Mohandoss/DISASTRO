package com.example.disastrospringboot;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/users")
public class DController {

    @Autowired
    private DService dService;
    private final String ACCOUNT_SID = "AC152a869ebbbc03e248c38d3c2c3b3b96";
    private final String AUTH_TOKEN = "bca68c7a22a1a1f75783194c62c312ad";

    @GetMapping("/{email}")
    public DModel getByEmail(@PathVariable String email) {
        return dService.findByEmail(email);
    }

    @GetMapping
    public List<DModel> getAllUsers() {
        return dService.findAll();
    }

    @PostMapping("/register")
    public DModel registerUser(@RequestBody DModel dModel) {
        return dService.save(dModel);
    }

    @PutMapping("/{firstname}")
    public DModel updateUser(@PathVariable String firstname, @RequestBody DModel updatedModel) {
        return dService.updateUser(firstname, updatedModel);
    }
    @DeleteMapping("/{firstname}")
    public void deleteUser(@PathVariable String firstname) {
        dService.deleteByFirstname(firstname);
    }
}
