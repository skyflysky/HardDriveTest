package sky.tool;

public class Test
{
	public static void main(String[] args)
	{
		String[] result = new String[2];
		//输出文件所在的文件夹
		result[0] = "C:\\temp\\testFileOut";
		//输出的文件大小有多少MB
		result[1] = "4096";
		Main.main(result);
	}
}
