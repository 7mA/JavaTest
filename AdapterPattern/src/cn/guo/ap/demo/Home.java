package cn.guo.ap.demo;

public class Home {
	private CnPluginInterface cnPlugin;
	
	public void setCnPlugin(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}

	public Home(){}
	
	public Home(CnPluginInterface cnPlugin){
		this.cnPlugin = cnPlugin;
	}
	
	public void charge(){
		cnPlugin.chargeWith2Pins();
	}
}
