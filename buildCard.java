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
	private int total;
	private String leaderSkill;
	private String skill;
	private int bonusLife;
	private int bonusVocal;
	private int bonusDance;
	private int bonusVisual;
	private int bonusTotal;
	

	private ArrayList<buildCard> idols = new ArrayList<buildCard>();

	buildCard()
	{

	}

	buildCard(String name, String cardName, int life, int vo, int da, int vi, int total, String leader, String skill, int boLife, int boVo, int boDa, int boVi, int boTo)
	{
		idol = name;
		card = cardName;
		this.life = life;
		vocal = vo;
		dance = da;
		visual = vi;
		this.total = total;
		leaderSkill = leader;
		this.skill = skill;
		bonusLife = boLife;
		bonusVocal = boVo;
		bonusDance = boDa;
		bonusVisual = boVi;
		bonusTotal = boTo;
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

	public void setTotal(String number)
	{
		total = Integer.parseInt(number);
	}
	
	public int getTotal()
	{
		return total;
	}
	
	public void setLeaderSkill(String skill)
	{
		leaderSkill = skill;
	}
	
	public String getLeaderSkill()
	{
		return leaderSkill;
	}
	
	public void setSkill(String skill)
	{
		this.skill = skill;
	}
	
	public String getSkill()
	{
		return skill;
	}
	
	public void setBonusLife(String number)
	{
		bonusLife = Integer.parseInt(number);
	}
	
	public int getBonusLife()
	{
		return bonusLife;
	}
	
	public void setBonusVocal(String number)
	{
		bonusVocal = Integer.parseInt(number);
	}
	
	public int getBonusVocal()
	{
		return bonusVocal;
	}
	
	public void setBonusDance(String number)
	{
		bonusDance = Integer.parseInt(number);
	}
	
	public int getBonusDance()
	{
		return bonusDance;
	}
	
	public void setBonusVisual(String number)
	{
		bonusVisual = Integer.parseInt(number);
	}
	
	public int getBonusVisual()
	{
		return bonusVisual;
	}
	
	public void setBonusTotal()
	{
		bonusTotal = getBonusVocal() + getBonusDance() + getBonusVisual();
	}
	
	public int getBonusTotal()
	{
		return bonusTotal;
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
					setVocal(values[2]);
					setDance(values[3]);
					setVisual(values[4]);
					setTotal(values[5]);
					setLeaderSkill(values[6]);
					setSkill(values[7]);
					setBonusLife(values[8]);
					setBonusVocal(values[9]);
					setBonusDance(values[10]);
					setBonusVisual(values[11]);
					setBonusTotal();
					
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
		int total = getTotal();
		String leader = getLeaderSkill();
		String skill = getSkill();
		int bonusLife = getBonusLife();
		int boVo = getBonusVocal();
		int boDa = getBonusDance();
		int boVi = getBonusVisual();
		int boTo = getBonusTotal();

		idols.add(new buildCard(idol, card, life, vocal, dance, visual, total, leader, skill, bonusLife, boVo, boDa, boVi, boTo));
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		buildCard test = new buildCard();
		
		test.cardMaker();
		ArrayList<buildCard> idols = test.getIdols();
		
		for(buildCard idol : idols)
		{
			
		}
	}
}
