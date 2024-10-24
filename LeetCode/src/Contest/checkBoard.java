package Contest;

public class checkBoard {
    public static void main(String[] args) {
        System.out.println(checkTwoChessboards("f4","c7"));
    }

    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int row1 = coordinate1.charAt(1) + '0';
        int row2 = coordinate2.charAt(1) + '0';
        char col1 = coordinate1.charAt(0);
        char col2 = coordinate2.charAt(0);
        boolean coord1 = false; //white taken
        boolean coord2 = false; //white taken
        if(row1%2 == 0){
            if(col1=='b'||col1=='d'||col1=='f'||col1=='h'){
                coord1 = true;
            }
        } else if (row1%2==1) {
            if(col1=='a'||col1=='c'||col1=='e'||col1=='g'){
                coord1 = true;
            }
        }
        if(row2%2 == 0){
            if(col2=='b'||col2=='d'||col2=='f'||col2=='h'){
                coord2 = true;
            }
        }
        else if (row2%2==1) {
            if(col2=='a'||col2=='c'||col2=='e'||col2=='g'){
                coord2 = true;
            }
        }
        return (coord1 ==  coord2);
    }
}
