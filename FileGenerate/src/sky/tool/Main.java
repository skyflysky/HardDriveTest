package sky.tool;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{	
		if(args.length < 1)
		{
			System.out.println("没有输入写入地址 程序关闭");
			return;
		}
		int MBCount = 1024;
		if(args.length >= 2)
		{
			try
			{
				int in = Integer.valueOf(args[1]);
				if(in > 0 && in < 10241)
					MBCount = in;
				else
					System.out.println("第二参数范围有误 将按默认大小写入");
			}
			catch (NumberFormatException e)
			{
				System.out.println("第二参数输入有误 将按默认大小写入");
			}
		}
		else
		{
			System.out.println("第二参数没有输入 将按默认大小写入");
		}
		System.out.println("将写入" + MBCount + "MB大小的数据");
		Scanner sca = new Scanner(System.in);
		byte[] byteArray = new Source().generateSource();
		System.out.println("数据源准备完毕，输入任意值开始写入");
		sca.nextLine();
		sca.close();
		double result = new OutPut().outPut(byteArray, args[0] , MBCount);
		if(result > 0)
			System.out.println("平均每秒写入" + result + "MB数据");
		else
			System.out.println("输出错误");
	}
}
