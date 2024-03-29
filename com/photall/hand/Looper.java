package com.photall.hand;

public class Looper {

	
	static final ThreadLocal<Looper> sThreadLocal=new ThreadLocal<Looper>();
	public static void prepare() {
		 sThreadLocal.set(new Looper());
		
	}

	MessageQueue mQueue;
	
	public Looper(){
		mQueue=new MessageQueue();
	}

	public static void loop() {
		 Looper looper= myLooper();
		 for(;;){
			 MessageQueue queue=looper.mQueue;
			 
			 Message message=queue.next();
			 
			 if(message==null){
				 return;
			 }
//			 System.out.println(message);
			 message.target.handleMessage(message);
		 }
		
	}

	static Looper myLooper() {
//		Thread currentThread=Thread.currentThread();
		
		return sThreadLocal.get();
	}

	

}
