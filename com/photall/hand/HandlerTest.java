package com.photall.hand;

public class HandlerTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Looper.prepare();
		
		ActivityThread thread= new ActivityThread();
		thread.attach(false);
		
		Looper.loop();
	}
}
