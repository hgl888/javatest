package pattern.behavior.template;

/// <summary>
/// �����࣬����ð������ĹǼ�
/// </summary>
public abstract class BubbleSorter
{
    private int operations = 0;
    protected int length = 0;

    /// <summary>
    /// ð�������㷨
    /// </summary>
    /// <returns></returns>
    protected int DoSort()
    {
        operations = 0;
        if (length <= 1)
        {
            return operations;
        }

        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
        {
            for (int index = 0; index <= nextToLast; index++)
            {
                if (OutOfOrder(index))
                {
                    Swap(index);
                }

                operations++;
            }
        }

        return operations;
    }

    /// <summary>
    /// ��������ʵ�ֵĽ���λ�÷���
    /// </summary>
    /// <param name="index"></param>
    protected abstract void Swap(int index);
    /// <summary>
    /// ��������ʵ�ֵıȽϷ���
    /// </summary>
    /// <param name="index"></param>
    /// <returns></returns>
    protected abstract Boolean OutOfOrder(int index);
    
}
