public class EventTimesOddTimes {
    public static void main(String[] args) {
        int [] arr = new int[] {1,2,3,3,4,5,5,4};
        method(arr);
    }
    public static void method(int []arr){
        int err = 0;
        //进行第一轮全部亦或
        for (int i :arr){
            err ^= i;
        }
        // 提取出最右边的1，此时rightOne格式为：...0001000....
        // ~操作将二进制的每一位都取反（包括符号位）
        int rightOne = err & (~err + 1);
        int onlyOne = 0;
        for (int cur : arr){
            // 因为rightOne的格式，所以和它进行&操作结果是否为0仅取决于那一位上是不是1
            if ((cur & rightOne) !=0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (err^onlyOne));
    }
}
