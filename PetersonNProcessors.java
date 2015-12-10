

import java.awt.Color;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class PetersonNProcessors{
	
	Random random = new Random(); 
	public static AtomicInteger ultimo = new AtomicInteger(0);
	Tela tela = new Tela();
	int numeroThreads = 5;
	boolean quer[] = new boolean[numeroThreads];
	int contador = 0, maxContador=10000;
	boolean pode = true;
	
	public static void main(String[] args){
		
		PetersonNProcessors petersonNProcessors = new PetersonNProcessors();
		
    }
	 public PetersonNProcessors(){

		 Thread []n = new Thread[numeroThreads];
	     for (int j = 0; j < numeroThreads; j++) {
	    	 n[j] = new ProcessadorN(j);
	    	 n[j].start();   	
		}
	     
	 }
	 
	 private class ProcessadorN extends Thread{ 
		 public AtomicInteger id ;
		 Color color;
		 int idINT;
		 Tela myTela = new Tela();
		 String status;
		 public ProcessadorN(int j){
			
			 switch (j) {
				case 0:
					this.idINT = 0;
					this.color = Color.YELLOW;
					this.id = new AtomicInteger(0);
					break;
				case 1:
					this.idINT = 1;
					this.color = Color.MAGENTA;		
					this.id = new AtomicInteger(1);
					break;
				case 2:
					this.idINT = 2;
					this.color = Color.CYAN;
					this.id = new AtomicInteger(2);
					break;
				case 3:
					this.idINT = 3;
					this.color = Color.GREEN;
					this.id = new AtomicInteger(3);
					break;
				default:
					this.idINT = 4;
					this.color = Color.ORANGE;
					this.id = new AtomicInteger(4);
					break;
			}
			 
		 }
		 
	     public void run(){
	             try{
	                 do{
	                	 boolean whileTrue = true;
	                	 quer[this.idINT]= true;
	                	 ultimo = this.id;
	                	 
	                     while(whileTrue){
	                    	 if(dontWant(this.idINT)||ultimo!=this.id){
	                    		 whileTrue = false;
	                    	 }else{
	                    		 int x = Math.abs(random.nextInt(10));
	                    		 status = "Aguardando - Processador ";
		                    	 myTela.setColor(status + this.id, Color.white);
	                    		 Thread.sleep(1000+x);
	                    	 }
	                     }
	                     
	                     //Regiao Critica
	                     if(pode){
	                    	 try { 
	                    		 pode = false;
		                    	 status = "Regiao Critica - Processador ";
		                    	 myTela.setColor(status + this.id, Color.red);
			                     tela.setColor(status + this.id, this.color);
			                     int x = Math.abs(random.nextInt(100));
		             			 Thread.sleep(5000+x);
		             			 pode = true;
		             		 } catch (InterruptedException e) {
		             			e.printStackTrace();
		             		 }
	                     }
	                     
	                  
	                     contador++;
	                     quer[this.idINT]= false;
	                    
	                 }while(contador<maxContador); 
	                 
	             }
	             catch(Exception ex){
	                 ex.printStackTrace();
	             }
         }

	     private boolean dontWant(int vez) {
				
				for (int j = 0; j < numeroThreads; j++) {
					if(quer[j] == true && j!=vez){
						return false;
					}
					
				}
				return true;
			}
		
	 }


     
}
