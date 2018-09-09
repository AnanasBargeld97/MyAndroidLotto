package dozkaz.bib.de.myandroidlotto;


import java.util.Arrays;

public class AndLotto
{

	static int[] generiereLottozahlen()
	{
		int[] arr= new int[6];
		
		
		int temp; int counter = 0;
		
			while(counter<6)
			{
				temp = (int)(Math.random()*49+1);
		
				if ( !istEnthalten(arr,temp) ) 
				{
					  arr[counter]=temp;
					  counter++;
				}
				
			 }	
			
			for (int i = 0; i < arr.length; i++)
			{
				Arrays.sort(arr);
				
			}
		return arr;	
	}
	
	static boolean istEnthalten(int[] arr, int zahl)
	{
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i]==zahl)return true;
			
			
		}
		
		return false;
	}
	
	
	
	static int[][] generiereZiehungen(int ziehungen)
	{
		int[][] alle = new int[ziehungen][6];
		
		for (int i = 0; i < alle.length; i++)
		{
			alle[i] = generiereLottozahlen();
		}
		
		return alle;	
	}
	
	static int xRichtige (int[]lottozahlen, int[] ziehung)
	{
		int counter=0;
		
		for (int i = 0; i < ziehung.length; i++) 
		{
			for (int j = 0; j < ziehung.length; j++) 
			{
			 if(lottozahlen[i]==ziehung[j])counter++;	
			}
			
		}
		
		return counter;
	}
	
	
	
	
	
	

	
}
