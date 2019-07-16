package com.photall.hand;

public class MainActivity extends Activity {
	
	private TextView mTextView;
	private Handler mHandler=new Handler(){
		@Override
		public void handleMessage(Message msg){
			mTextView.setText((String)msg.obj);
			System.out.println("�߳�2��"+Thread.currentThread());
		}
	};
	@Override
	public void onCreate(){
		super.onCreate();
		
		System.out.println("onCreateִ����");
		
		mTextView=findViewById(R.id.text_view);
		
		new Thread(){
			public void run(){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("�߳�����1��"+Thread.currentThread());
				Message message=new Message();
				message.obj="��̨����";
//				mTextView.setText("��̨����");
				mHandler.sendMessage(message);
			}
		}.start();
	}
	
	
	@Override
	public void onResume(){
		super.onResume();
		System.out.println("OnResume ִ����");
	}
}
