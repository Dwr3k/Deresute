import java.util.Comparator;

public class sortMethods 
{
	public static class vocalSort implements Comparator<buildCard>
	{
		public int compare(buildCard first, buildCard second)
		{
			return Integer.compare(second.getVocal(), first.getVocal());
		}
	}
	
	public static class danceSort implements Comparator<buildCard>
	{
		public int compare(buildCard first, buildCard second)
		{
			return Integer.compare(second.getDance(), first.getDance());
		}
	}
	
	public static class visualSort implements Comparator<buildCard>
	{
		public int compare(buildCard first, buildCard second)
		{
			return Integer.compare(second.getVisual(), first.getVisual());
		}
	}
}
