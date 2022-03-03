package com.liquidShadow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pin")
public class PinController {

	
	@Autowired
	PinService pinService;
	
	@RequestMapping("/read/{pinId}")
    public ResponseEntity<Integer> readPinValue (@PathVariable("pinId") Integer pinId) {
        Integer pinValue = pinService.readPinValue(pinId);
        return new ResponseEntity<>(pinValue, HttpStatus.OK);
    }
    
	@RequestMapping("/set/{pinId}/{value}")
    public ResponseEntity<String> setPinValue (@PathVariable("pinId") Integer pinId, @PathVariable("value") Integer value) {
        pinService.setPinValue(pinId, value);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
