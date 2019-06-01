package sky.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class OutPut
{
	/**
	 * 进行写入测试
	 * @param byteArray 写入的数据 1MB
	 * @param targetPath 写入的目标路径
	 * @param MBCount 写入多少MB的数据
	 * @return
	 */
	public double outPut(byte[] byteArray , String targetPath , int MBCount)
	{
		File testPath = new File(targetPath);
		if(!testPath.exists())
		{
			if(!testPath.mkdirs())
			{
				System.out.println("创建输出文档错误");
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
				System.out.println("输出中：正在输出第" + i + "MB数据");
				fops.write(byteArray);
			}
			long timeTake = System.currentTimeMillis() - startTime;
			fops.close();
			long fileSizeByte = testFile.length();
			
			//因为数据写入的时候 有两个1024作为因数 所以这里一定能整除
			int fileSizeMillionByte = (int) (fileSizeByte / (1024*1024));
			BigDecimal size = new BigDecimal(fileSizeMillionByte) , time = new BigDecimal(timeTake).divide(new BigDecimal(1000), 3 , RoundingMode.UNNECESSARY);
			BigDecimal result = size.divide(time, 5, BigDecimal.ROUND_HALF_UP);
			testFile.delete();
			return result.doubleValue();
		} 
		catch (IOException e)
		{
			System.out.println("io错误:" + e.getMessage());
			return -1;
		}
		
	}
}
