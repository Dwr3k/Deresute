import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class buildCard 
{
	private String idol;
	private String card;
	private int life;
	private int vocal;
	private int dance;
	private int visual;

	protected ArrayList<buildCard> idols = new ArrayList<buildCard>();

	buildCard()
	{

	}

	buildCard(String name, String cardName, int life, int vocal, int dance, int visual)
	{
		idol = name;
		card = cardName;
		this.life = life;
		this.vocal = vocal;
		this.dance = dance;
		this.visual = visual;
	}

	public ArrayList<buildCard> getIdols()
	{
		return idols;
	}

	public void setIdol(String name)
	{
		idol = name;
	}

	public String getIdol()
	{
		return idol;
	}

	public void setCard(String name)
	{
		card = name;
	}

	public String getCard()
	{
		return card;
	}

	public void setLife(String number)
	{
		life = Integer.parseInt(number);
	}

	public int getLife()
	{
		return life;
	}

	public void setVisual(String number)
	{
		visual = Integer.parseInt(number);
	}

	public int getVisual()
	{
		return visual;
	}

	public void setDance(String number)
	{
		dance = Integer.parseInt(number);
	}

	public int getDance()
	{
		return dance;
	}

	public void setVocal(String number)
	{
		vocal = Integer.parseInt(number);
	}

	public int getVocal()
	{
		return vocal;
	}

	public void cardMaker() throws FileNotFoundException
	{
		File input = new File("SighsInJapanese.txt");	
		Scanner fileReader = new Scanner(input);
		fileReader.useDelimiter("\t");

		while(fileReader.hasNext())
		{	
			String line = fileReader.nextLine().trim();

			if(!line.equals("") && !line.contains("Card Name") && !line.contains("\t\t\t"))
			{
				if(line.contains("Idol Name"))
				{
					String idol = line.substring(line.lastIndexOf("\t"), line.length()).trim();
					setIdol(idol);
				}
				else
				{
					String[] values = line.split("\t+");

					setCard(values[0]);
					setLife(values[1]);
					setVisual(values[2]);
					setDance(values[3]);
					setVocal(values[4]);

					addCard();
				}
			}
		} 

		fileReader.close();
	}

	public void addCard()
	{
		String idol = getIdol();
		String card = getCard();
		int life = getLife();
		int vocal = getVocal();
		int dance = getDance();
		int visual = getVisual();

		idols.add(new buildCard(idol, card, life, vocal, dance, visual));

		//System.out.println("Added " + idol + " " + card + " card");
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		buildCard test = new buildCard();

		test.cardMaker();

		ArrayList<buildCard> myIdols = test.getIdols();
		
		for(buildCard idol : myIdols)
		{
			if(idol.idol.contains("Uzuki"))
			{
				System.out.println(idol.card + " " + idol.vocal);
			}

		}

	}
}
