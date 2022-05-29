import java.util.regex.Pattern;

public class CodingTest3 {

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        String reg = "^[a-z\\\\d_\\-.]$";
        System.out.println(new_id);
        new_id = new_id.replaceAll(reg,"");
        return new_id;
    }
    public static void main(String[] args) {
        CodingTest3 codingTest3 = new CodingTest3();

        String id1= "...!@BaT#*..y.abcdefghijklm";
        String id2="z-+.^.";
        String id3="=.=";
        String id4="123_.def";
        String id5="abcdefghijklmn.p";

        System.out.println(codingTest3.solution(id1));
        System.out.println(codingTest3.solution(id2));
        System.out.println(codingTest3.solution(id3));
        System.out.println(codingTest3.solution(id4));
        System.out.println(codingTest3.solution(id5));

    }
}
