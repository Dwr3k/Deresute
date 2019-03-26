import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileNotFoundException;
import java.lang.Integer;

public class idolSorters extends buildCard
{
	
	public ArrayList<buildCard> sort(ArrayList<buildCard> idolArray, String heck)
	{
		if(heck.equals("Vo"))
		{
			sortMethods.vocalSort voSort = new sortMethods.vocalSort();
			Collections.sort(idolArray, voSort);
			
			for(buildCard idol : idolArray)
			{
				System.out.println(idol.getCard() + " " + idol.getVocal());
			}
		}
		else if(heck.equals("Da"))
		{
			sortMethods.danceSort daSort = new sortMethods.danceSort();
			Collections.sort(idolArray, daSort);
			
			for(buildCard idol : idolArray)
			{
				System.out.println(idol.getCard() + " " + idol.getDance());
			}
		}
		else if(heck.equals("Vi"))
		{
			sortMethods.visualSort viSort = new sortMethods.visualSort();
			Collections.sort(idolArray, viSort);
			
			for(buildCard idol : idolArray)
			{
				System.out.println(idol.getCard() + " " + idol.getVisual());
			}
		}
		
		return idolArray;
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		idolSorters test = new idolSorters();
		
		test.cardMaker();
		
		ArrayList<buildCard> testIdols = test.getIdols();
		
		String[] heck = {"Vi", "Da", "Vo"};
		
		for(int i = 0; i < 3; ++i)
		{
			test.sort(testIdols, heck[i]);
			
			System.out.println("");
			System.out.println("");
		}

	}
}
