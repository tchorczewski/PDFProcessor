package com.example.api;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StartRequestHeaderController {


    @PostMapping("/LoadedFile")
    public ResponseMessageHeader startProcessing(@RequestBody StartRequestHeader header){

        try {
            return new StartRequestHandler_Base().StartProcessing(header);
        } catch (Exception e) {
            return new ResponseMessageHeader(null,e.getMessage(),"100");
        }
    }
}
