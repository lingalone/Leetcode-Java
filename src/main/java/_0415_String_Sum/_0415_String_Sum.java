package _0415_String_Sum;

public class _0415_String_Sum {

    public String addStrings(String num1, String num2) {
        char[] num1s =  num1.toCharArray();
        char[] num2s =  num2.toCharArray();

        int len = num1s.length >= num2s.length ?
                num1s.length: num2s.length;

        if(len > num1s.length){
            char[] temp = new char[len];
            int j = len-num1s.length;
            for(int i = 0; i<j;i++){
                temp[i] = '0';
            }

            for(int i = j; i<len;i++){
                temp[i] = num1s[i-j];
            }

            num1s = temp;
        }

        if(len > num2s.length){
            char[] temp = new char[len];
            int j = len-num2s.length;
            for(int i = 0; i<j;i++){
                temp[i] = '0';
            }

            for(int i = j; i<len;i++){
                temp[i] = num2s[i-j];
            }
            num2s = temp;
        }

        char[] result = new char[len];

        int addone = 0;
        for(int i = len - 1; i>=0 ; i--){

            int temp = addone;



            if(i < num1s.length){
                temp += (num1s[i] - '0');
            }

            if(i < num2s.length){
                temp += (num2s[i] - '0');
            }

            if(temp > 9){
                result[i] = (char)((temp % 10) + '0');
                addone = 1;
            }else{
                result[i] = (char)(temp + '0');
                addone = 0;
            }
        }
        if(addone == 1){
            return "1" + new String(result);
        }else{
            return new String(result);
        }
    }


    public static void main(String[] args) {
        _0415_String_Sum stringSum = new _0415_String_Sum();

        System.out.println(stringSum.addStrings("11111111","11111111"));
    }
}
