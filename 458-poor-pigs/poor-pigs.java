class Solution
{
    public int poorPigs(int buckets, int tdie, int ttest)
    {
        int test = ttest/tdie+1;
        int i=0;
        while(Math.pow(test,i)< buckets)
        {
            i++;
        }
        return i;
    }
}