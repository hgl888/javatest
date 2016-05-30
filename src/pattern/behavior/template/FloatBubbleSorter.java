package pattern.behavior.template;

/// <summary>
/// ���������͵�ð���㷨
/// </summary>
public class FloatBubbleSorter extends BubbleSorter
{
    private float[] array = null;

    /// <summary>
    /// ��ð���㷨����
    /// </summary>
    /// <param name="theArray"></param>
    /// <returns></returns>
    public int Sort(float[] theArray)
    {
        array = theArray;
        length = array.length;
        // ����ð���㷨
        return DoSort();
    }

    /// <summary>
    /// ʵ��ð���㷨�еĽ�������
    /// </summary>
    /// <param name="index"></param>
    protected void Swap(int index)
    {
        float temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    /// <summary>
    /// ʵ��ð���㷨�еıȽϲ���
    /// </summary>
    /// <param name="index"></param>
    /// <returns></returns>
    protected Boolean OutOfOrder(int index)
    {
        return (array[index] > array[index + 1]);
    }
}



