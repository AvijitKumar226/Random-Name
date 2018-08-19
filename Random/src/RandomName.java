import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class RandomName {
	public static  String getRandomName() throws Exception {
		File file=new File("F:/Db_name/names.txt");
		FileReader in=new FileReader(file);
		BufferedReader reader=new BufferedReader(in);
		String name="";
		ArrayList<String> names=new ArrayList<String>();
		while((name=reader.readLine())!=null) {
			names.add(name);
		}
		reader.close();
		int index=(int)(Math.random()*names.size());
		return names.get(index);
		
	}
	public static void main(String[] args) {
		try {
			System.out.println(getRandomName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
