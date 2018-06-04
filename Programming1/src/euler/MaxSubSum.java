package euler;
class CombinedObj{
	int sum;
	int left;
	int right;
	CombinedObj(int sum,int left,int right)
	{
		this.sum=sum;
		this.right=right;
		this.left=left;
	}
}

public class MaxSubSum {
    public static int list[] = { 1, 2, 3, -100, 100 };
    
    public  CombinedObj max(CombinedObj obj1,CombinedObj obj2,CombinedObj obj3) {
    	if(obj1.sum >= obj2.sum && obj1.sum >= obj3.sum)
    		return obj1;
    	if(obj2.sum >= obj3.sum && obj2.sum >= obj1.sum)
    		return obj2;
    	if(obj3.sum >= obj2.sum && obj3.sum >= obj1.sum)
    		return obj3;
		return null;
    }
    public  CombinedObj maxSubSum(int left, int right,int []list) {
        int mid, sum, maxToLeft, maxToRight, maxCrossing;
        int i;

        if (left > right)
            return null;
       
        
        if (left==right)
            return new CombinedObj(list[left],left,right);

        mid = (left + right) / 2;
        
        CombinedObj maxInA = maxSubSum(left, mid, list);
        CombinedObj maxInB = maxSubSum(mid + 1, right, list);
        
        

        sum = 0;
        maxToLeft = 0;
        for (i = mid; i >= left; i--) {
            sum = sum + list[i];
            maxToLeft = (maxToLeft > sum) ? maxToLeft : sum;
        }

        sum = 0;
        maxToRight = 0;
        for (i = mid + 1; i <= right; i++) {
            sum = sum + list[i];
            maxToRight = (maxToRight > sum) ? maxToRight : sum;
        }

        maxCrossing = maxToLeft + maxToRight;
        CombinedObj obj=new CombinedObj(maxCrossing,left,right);
        return max(maxInA,maxInB,obj);
    }
    
    public static void main(String args[])
    {
    	MaxSubSum ms=new MaxSubSum();
    	CombinedObj obj=ms.maxSubSum(0, list.length-1, list);
    	System.out.println(obj.left+"  "+obj.right+"  "+obj.sum);
    }
}
