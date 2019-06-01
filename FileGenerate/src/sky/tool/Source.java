package sky.tool;

import java.util.Random;

public class Source
{
	/**
	 * 生成 1MB 随机数据
	 * @return
	 */
	public byte[] generateSource()
	{
		byte[] resultByteArray = new byte[1024000];
		
		long time = System.currentTimeMillis();
		//随机挑了四个质数去取余数 再加起来作为种子
		long seed = time % 4231 + time % 9319 + time % 28477  + time % 34651; 
		Random random = new Random(seed);
		random.nextBytes(resultByteArray);
		return resultByteArray;
	}
}
