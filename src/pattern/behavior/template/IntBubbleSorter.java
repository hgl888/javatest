package pattern.behavior.template;

/// <summary>
/// �������͵�ð���㷨ʵ��
/// </summary>
public class IntBubbleSorter extends BubbleSorter
{
    private int[] array = null;

    /// <summary>
    /// ��ð���㷨����
    /// </summary>
    /// <param name="theArray"></param>
    /// <returns></returns>
    public int Sort(int[] theArray)
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
        int temp = array[index];
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

