package sky.tool;

import java.util.Random;

public class Source
{
	/**
	 * ���� 1MB �������
	 * @return
	 */
	public byte[] generateSource()
	{
		byte[] resultByteArray = new byte[1024000];
		
		long time = System.currentTimeMillis();
		//��������ĸ�����ȥȡ���� �ټ�������Ϊ����
		long seed = time % 4231 + time % 9319 + time % 28477  + time % 34651; 
		Random random = new Random(seed);
		random.nextBytes(resultByteArray);
		return resultByteArray;
	}
}
