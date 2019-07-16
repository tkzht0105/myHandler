package com.photall.hand;

public class TextView {
	
	private Thread mThread;
	public TextView(){
		mThread=Thread.currentThread();
	}
	
	public void setText(CharSequence text){
		checkThread();
		System.out.println("����UI�ɹ���"+text);
	}
	
	
	void checkThread(){
		if(mThread!=Thread.currentThread())
			throw  new RuntimeException(
					"Only the original thread that created a view hierarchy can touch its views.");
	}
}
