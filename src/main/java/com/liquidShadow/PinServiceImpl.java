package com.liquidShadow;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PinServiceImpl implements PinService {

	@Override
	public int readPinValue(int pin) {
		log.info("Reading Pin {}", pin);
		// TODO Auto-generated method stub
		int pinValue =0;
		log.info("Read value {} pin {}", pinValue, pin);
		return pinValue;
	}

	@Override
	public void setPinValue(int pin, int value) {
		// TODO Auto-generated method stub
		log.info("setting value {} for pin {}", value, pin);
	}

}
