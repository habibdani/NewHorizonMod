package newhorizon;

import arc.ApplicationListener;
import arc.Core;
import arc.util.Log;
import mindustry.Vars;

public class NHModCore implements ApplicationListener{
	public static NHModCore core;
	
	public NHInputListener inputListener;
	public NHRenderer renderer;
	
	public NHModCore(){
		if(NewHorizon.DEBUGGING)Log.info("NH Listener Core Constructed");
		
		if(!Core.app.isHeadless()){
			inputListener = new NHInputListener();
			renderer = new NHRenderer();
		}
		
		core = this;
	}
	
	@Override
	public void update(){
		if(Vars.state.isPlaying()){
			if(!Vars.headless && inputListener != null){
				inputListener.update();
			}
		}
	}
	
	@Override
	public void dispose(){
		if(NewHorizon.DEBUGGING)Log.info("Disposed");
	}
	
	@Override
	public void init(){
		if(NewHorizon.DEBUGGING)Log.info("Init NH Core");
	}
	
	public void initOnLoadWorld(){
		if(!Vars.headless){
			renderer.init();
		}
	}
}