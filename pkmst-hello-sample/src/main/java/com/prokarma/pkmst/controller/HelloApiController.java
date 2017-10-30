package com.prokarma.pkmst.controller;


import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
/**
 * Api implemention
 * @author pkmst
 *
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-30T15:54:28.693Z")

@Controller
public class HelloApiController implements HelloApi {
    private final ObjectMapper objectMapper;
@Autowired
    public HelloApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<String> greetMessage(@ApiParam(value = "Greet message",required=true ) @PathVariable("greetMessage") String greetMessage,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {

    	if (accept != null && accept.contains("application/xml")) {
            return new ResponseEntity<String>("Hello Welcome : " + greetMessage, HttpStatus.OK);
        }
    	
    	if (accept != null && accept.contains("application/json")) {
            return new ResponseEntity<String>("Hello Welcome : " + greetMessage, HttpStatus.OK);
        }

        return new ResponseEntity<String>("Hello Welcome : " + greetMessage,HttpStatus.OK);
    }

}
