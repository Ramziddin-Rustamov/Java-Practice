package String;

public class isPalindrome {

    public static boolean checkIsPalindrome(String s){
        int right = s.length() - 1;
        int left = 0;

        while(left < right)
        {
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            right -= 1;
            left += 1;
        }
        return true;
    }
}
