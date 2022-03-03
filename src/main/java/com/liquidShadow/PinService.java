package com.liquidShadow;

import org.springframework.stereotype.Component;

@Component
public interface PinService {
	public int readPinValue(int pin);
	public void setPinValue(int pin, int value);
}
