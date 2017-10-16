package com.prokarma.pkmst.controller;

import com.prokarma.pkmst.model.InlineResponse200;

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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.PkmstServerCodegen", date = "2017-10-16T17:44:06.614+05:30")

@Controller
public class HelloApiController implements HelloApi {
    private final ObjectMapper objectMapper;
@Autowired
    public HelloApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ResponseEntity<InlineResponse200> hello(@ApiParam(value = "The name of the person to whom to say hello")  @RequestParam(value = "name", required = false) String name,
        @RequestHeader(value = "Accept", required = false) String accept) throws Exception {
        // do some magic!
    	InlineResponse200 resp = new InlineResponse200();
    	resp.setMessage("Hello "+name);
       	return new ResponseEntity<InlineResponse200>(resp, HttpStatus.OK);
    }

}
