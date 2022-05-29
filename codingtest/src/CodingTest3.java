public class CodingTest3 {

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

        String reg = "[^-_.a-z0-9]";
        new_id = new_id.replaceAll(reg,"");

        reg = "[.]{2,}";
        new_id = new_id.replaceAll(reg,".");

        reg = "^[.]|[.]$";
        new_id = new_id.replaceAll(reg,"");

        new_id = new_id.equals("") ? "a": new_id;

        new_id = new_id.length() >= 16 ?  new_id.substring(0,15) : new_id;

        reg = "[.]$";
        new_id = new_id.replaceAll(reg,"");

        if(new_id.length() < 3){

            while (new_id.length() < 3){
               new_id = new_id.concat(new_id.substring(new_id.length()-1));
            }
        }

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
