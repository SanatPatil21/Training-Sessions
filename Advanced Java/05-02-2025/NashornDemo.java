import javax.script.*;
import java.io.*;
import java.util.List;

public class NashornDemo{
	
	public static void main(String args[]){
	
		try{
			
			ScriptEngineManager mgr = new ScriptEngineManager();

			List<ScriptEngineFactory> list = mgr.getEngineFactories();

			System.out.println(list.isEmpty());

			list.forEach((sef)->{
				System.out.println(sef.getEngineName());
			});
			/*
			ScriptEngine engine = mgr.getEngineByName("JavaScript");
			engine.eval("print('Hello Everybody!')")
			*/

			/*

			ScriptEngine engine = mgr.getEngineByName("nashorn");
			engine.eval(new FileReader("demo.js"));

			Invocable inv = (Invocable) engine;
			inv.invokeFunction("abc()");

			 */
		}catch(Exception e){
			System.out.println(e);
		}

	}



}