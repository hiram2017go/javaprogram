package com.zyy.spring;

public class Computer {
	private USB usb;

	public USB getUsb() {
		return usb;
	}

	public void setUsb(USB usb) {
		this.usb = usb;
	}
	
	public void read() {
		this.usb.read();
	}
	
	public void write() {
		this.usb.write();
	}
}
