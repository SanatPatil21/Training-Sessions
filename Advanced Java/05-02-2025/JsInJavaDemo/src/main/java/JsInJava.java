import javax.script.*;
import java.io.*;
import java.util.List;

public class JsInJava{
	
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
			
			ScriptEngine engine = mgr.getEngineByName("Graal.js");
			engine.eval(new FileReader("demo.js"));
			
			Invocable inv = (Invocable) engine;
			//Calling a function with no return and no args
			inv.invokeFunction("abc");
			
			//Function with args
			inv.invokeFunction("add", 3,4);
			
			
			//Function with return(Explicit Type Casting) and args
			 String str = (String) inv.invokeFunction("greet", "Gautam","Adani");
			 
			 System.out.println(str);
			
			
		}catch(Exception e){
			System.out.println(e);
		}

	}



}