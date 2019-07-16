package com.photall.hand;

public class Handler {
	MessageQueue mQueue;
	
	public Handler(){
		Looper looper=Looper.myLooper();
		
		if(looper==null){
			throw new RuntimeException(
					"Can't create handler inside thread that has not called Looper.prepare()");
		}
		mQueue=looper.mQueue;
	}
	public void sendMessage(Message message) {
		sendMessageDelayed(message,0);
		
	}
	
	public final boolean sendMessageDelayed(Message msg,long delayMillis) {
		// TODO Auto-generated method stub
		if(delayMillis<0){
			delayMillis=0;
		}
		
		return sendMessageAtTime(msg,System.currentTimeMillis()+delayMillis);
	}

	public boolean sendMessageAtTime(Message msg, long upTimeMillis) {
		MessageQueue queue=mQueue;
		
		return enqueueMessage(queue,msg,upTimeMillis);
	}

	private boolean enqueueMessage(MessageQueue queue, Message msg, long upTimeMillis) {
		msg.target=this;
		
		return queue.enqueueMessage(msg,upTimeMillis);
	}

	public void handleMessage(Message msg){
	}

}
