package cn.guo.ap.demo;

public class PluginAdapter implements CnPluginInterface {

	private EnPluginInterface enPlugin;
	
	public PluginAdapter(EnPluginInterface enPlugin){
		this.enPlugin = enPlugin;
	}
	
	@Override
	public void chargeWith2Pins() {
		// TODO Auto-generated method stub
		enPlugin.chargeWith3Pins();
	}

}
