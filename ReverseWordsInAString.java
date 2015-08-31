package first;

public class ReverseWordsInAString {
	public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            if (!array[i].equals("")){
                StringBuilder tmp = new StringBuilder();
                tmp.append(array[i]);
                tmp.reverse();
                sb.append(" ").append(tmp);//put space first
            }
        }
        
        sb.reverse();
        //remove last space
        return (sb.length() == 0)? "": sb.substring(0, sb.length() - 1);
    }
	
	public static void main(String[] args){
		ReverseWordsInAString rw = new ReverseWordsInAString();
		String s1 = "world";
		System.out.println(rw.reverseWords(s1));
	}

}
