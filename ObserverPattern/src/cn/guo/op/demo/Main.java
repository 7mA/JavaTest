package cn.guo.op.demo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VideoSite vs = new VideoSite();
		vs.registerObserver(new VideoFans("LiLei"));
		vs.registerObserver(new VideoFans("HanMeimei"));
		vs.registerObserver(new VideoFans("XiaoMing"));
		
		vs.addVideos("Video 1");
		vs.addVideos("Video 2");
	}

}
