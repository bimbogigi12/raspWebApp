package com.liquidShadow;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PinServiceImpl implements PinService {

	@Override
	public int readPinValue(int pin) {
		log.info("Reading Pin {}", pin);
		int pinValue =0;
		GpioController gpio = GpioFactory.getInstance();
		GpioPinPwmOutput pinIn = gpio.provisionSoftPwmOutputPin(RaspiPin.getPinByAddress(pin), "Reader");
		pinValue =pinIn.getPwm();
		log.info("Read value {} pin {}", pinValue, pin);
		return pinValue;
	}

	@Override
	public void setPinValue(int pin, int value) {
		log.info("setting value {} for pin {}", value, pin);
		GpioController gpio = GpioFactory.getInstance();
		GpioPinPwmOutput pinOut = gpio.provisionSoftPwmOutputPin(RaspiPin.getPinByAddress(pin), "Reader");
		pinOut.setPwm(value);
	}

}
