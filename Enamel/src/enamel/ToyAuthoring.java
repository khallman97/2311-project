package enamel;

import java.io.File;

public class ToyAuthoring {

    public static void main(String[] args) { 	  	
    	    String name ="";
    		File file = null;
    		simpleGui test = new simpleGui("title");
    		test.setVisible(true);
    	
    		boolean fileSelected = true;
    		
    		
    		while(fileSelected) {
    			
    		
    			try {
    				file  = test.getFile();
    				System.out.println(file.getName());
    				fileSelected = false;
    			} catch (Exception e) {
    				
    			}
    		}
    			
    		
    		ScenarioParser s = new ScenarioParser(true);
    	    
    		 
    	    s.setScrenarioFileFile(file);
    	    VisualPlayer play = new VisualPlayer(1,1);
    	    play.refresh();
    	  

    	    
    }
}