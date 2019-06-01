package sky.tool;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{	
		if(args.length < 1)
		{
			System.out.println("û������д���ַ ����ر�");
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
					System.out.println("�ڶ�������Χ���� ����Ĭ�ϴ�Сд��");
			}
			catch (NumberFormatException e)
			{
				System.out.println("�ڶ������������� ����Ĭ�ϴ�Сд��");
			}
		}
		else
		{
			System.out.println("�ڶ�����û������ ����Ĭ�ϴ�Сд��");
		}
		System.out.println("��д��" + MBCount + "MB��С������");
		Scanner sca = new Scanner(System.in);
		byte[] byteArray = new Source().generateSource();
		System.out.println("����Դ׼����ϣ���������ֵ��ʼд��");
		sca.nextLine();
		sca.close();
		double result = new OutPut().outPut(byteArray, args[0] , MBCount);
		if(result > 0)
			System.out.println("ƽ��ÿ��д��" + result + "MB����");
		else
			System.out.println("�������");
	}
}
