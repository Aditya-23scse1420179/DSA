class Solution
{
    public int poorPigs(int buckets, int tdie, int ttest)
    {
        int test = ttest/tdie+1;
        int pig=0;
        while(Math.pow(test,pig)< buckets)
        {
            pig++;
        }
        return pig;
    }
}