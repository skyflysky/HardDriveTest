package sky.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class OutPut
{
	/**
	 * ����д�����
	 * @param byteArray д������� 1MB
	 * @param targetPath д���Ŀ��·��
	 * @param MBCount д�����MB������
	 * @return
	 */
	public double outPut(byte[] byteArray , String targetPath , int MBCount)
	{
		File testPath = new File(targetPath);
		if(!testPath.exists())
		{
			if(!testPath.mkdirs())
			{
				System.out.println("��������ĵ�����");
				return -1;
			}
		}
		File testFile = new File(testPath, "testFile.test");
		try
		{
			FileOutputStream fops = new FileOutputStream(testFile);
			long startTime = System.currentTimeMillis();
			for(int i = 0 ; i < MBCount ; i ++)
			{
				System.out.println("����У����������" + i + "MB����");
				fops.write(byteArray);
			}
			long timeTake = System.currentTimeMillis() - startTime;
			fops.close();
			long fileSizeByte = testFile.length();
			
			//��Ϊ����д���ʱ�� ������1024��Ϊ���� ��������һ��������
			int fileSizeMillionByte = (int) (fileSizeByte / (1024*1024));
			BigDecimal size = new BigDecimal(fileSizeMillionByte) , time = new BigDecimal(timeTake).divide(new BigDecimal(1000), 3 , RoundingMode.UNNECESSARY);
			BigDecimal result = size.divide(time, 5, BigDecimal.ROUND_HALF_UP);
			testFile.delete();
			return result.doubleValue();
		} 
		catch (IOException e)
		{
			System.out.println("io����:" + e.getMessage());
			return -1;
		}
		
	}
}
