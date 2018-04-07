package cn.guo.ap.demo;

public class CnTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CnPluginInterface cnPlugin = new CnPlugin();
		EnPluginInterface enPlugin = new EnPlugin();
		CnPluginInterface cnPlugin = new PluginAdapter(enPlugin);
		Home home = new Home(cnPlugin);
		home.charge();	
	}

}
