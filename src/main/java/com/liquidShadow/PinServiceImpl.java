package com.liquidShadow;

import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PinServiceImpl implements PinService {

	@Override
	public int readPinValue(int pin) {
		log.info("Reading Pin {}", pin);
		int pinValue =0;
				
		/*Gpio.wiringPiSetup();
		pinValue = SoftPwm.softPwmCreate(pin, 0, 100);*/
		GpioController gpio = GpioFactory.getInstance();
		GpioPinDigitalInput pinIn = gpio.provisionDigitalInputPin(RaspiPin.getPinByAddress(pin), "Reader");
		log.info("pin {} {} ", pin, pinIn.toString());
		pinValue =pinIn.getState() == PinState.HIGH ? 100:0;
		log.info("Read value {} pin {}", pinValue, pin);
		return pinValue;
	}

	@Override
	public void setPinValue(int pin, int value) {
		log.info("setting value {} for pin {}", value, pin);
		Gpio.wiringPiSetup();
		SoftPwm.softPwmCreate(pin, 0, 100);
		SoftPwm.softPwmWrite(pin, value);
	}

}
