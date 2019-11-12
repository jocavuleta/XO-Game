import java.util.Scanner;

public class MainClass {

    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        boolean decision = false;

        do {

            //Enter row
            System.out.println("Unesite lokaciju reda.");
            int row = scanner.nextInt();
            while (row > matrix.length - 1 || row < 0) {
                System.out.println("Uneli ste pogresnu lokaciju u matrici(premalu ili preveliku), pokusajte ponovo.");
                row = scanner.nextInt();
            }

            //Enter column
            System.out.println("Unesite lokaciju kolone.");
            int col = scanner.nextInt();
            while (col > matrix[0].length - 1 || col < 0) {
                System.out.println("Uneli ste pogresnu lokaciju u matrici(premalu ili preveliku), pokusajte ponovo.");
                col = scanner.nextInt();
            }

            //Checking is the wanted place in the matrix already filled
            while(matrix[row][col] != 0){
                System.out.println("Trazeno mesto je popunjeno.");
                System.out.println("Unesite novu lokaciju reda.");
                row = scanner.nextInt();
                System.out.println("Unesite novu lokaciju kolone.");
                col = scanner.nextInt();
            }

                //Entering value in the matrix
            System.out.println("Unesite vrednost koju zelite da unesete u zeljene pozicije.");
            int value = scanner.nextInt();
            while (value != 1 && value != 2) {
                System.out.println("Dozvoljene vrednosti za unos su 1 i 2, uneli ste pogresnu vrednost. Pokusajte ponovo.");
                value = scanner.nextInt();
            }

            //Checking is the value 1 and printing the current situation in the matrix
            if (value == 1) {
                matrix[row][col] = value;
                System.out.println("Stanje matrice posle odigranog poteza je: ");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(RED + matrix[i][j] + " ");
                    }
                    System.out.println("\n");
                }
            } else {
                //Checking is the value 2 and printing the current situation in the matrix
                matrix[row][col] = value;
                System.out.println("Stanje matrice posle odigranog poteza je: ");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(BLUE + matrix[i][j] + " ");
                    }
                    System.out.println("\n");
                }
            }

            //Winner is player 1
            if(matrix[0][0] == 1 && matrix[0][1] == 1 && matrix[0][2] == 1
                    || (matrix[1][0] == 1 && matrix[1][1] == 1 && matrix[1][2] == 1)
                    ||(matrix[2][0] == 1 && matrix[2][1] == 1 && matrix[2][2] == 1)
                    || (matrix[0][0] == 1 && matrix[1][0] == 1 && matrix[2][0] == 1)
                    ||(matrix[0][1] == 1 && matrix[1][1] == 1 && matrix[2][1] == 1)
                    || (matrix[0][2] == 1 && matrix[1][2] == 1 && matrix[2][2] == 1)
                    ||(matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1)
                    ||(matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1)){
                System.out.println("Pobedio je igrac sa X-iks oznakom.");

                //Restarting the matrix for the new game
                //Arrays.fill(matrix, 0);
                matrix = new int[3][3];

                //Decision variable to determine the duration of the game
                System.out.println("Da li zelite da igrate ponovo? Da - 1, Ne - 2.");
                int var = scanner.nextInt();
                while(var != 1 && var != 2){
                    System.out.println("Los unos, probajte opet. Da - 1, Ne - 2.");
                    var = scanner.nextInt();
                }
                if(var == 2){
                    System.out.println("Hvala sto ste se igrali sa nama!");
                    break;
                }else
                    decision = true;
            }

            //Winner is player 2
            if((matrix[0][0] == 2 && matrix[0][1] == 2 && matrix[0][2] == 2)
                    || (matrix[1][0] == 2 && matrix[1][1] == 2 && matrix[1][2] == 2)
                    || (matrix[2][0] == 2 && matrix[2][1] == 2 && matrix[2][2] == 2)
                    || (matrix[0][0] == 2 && matrix[1][0] == 2 && matrix[2][0] == 2)
                    || (matrix[0][1] == 2 && matrix[1][1] == 2 && matrix[2][1] == 2)
                    || (matrix[0][2] == 2 && matrix[1][2] == 2 && matrix[2][2] == 2)
                    || (matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2)
                    || (matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2)){

                System.out.println("Pobedio je igrac sa O-ks oznakom.");

                //Restarting the matrix for the new game
                //Arrays.fill(matrix, 0);
                matrix = new int[3][3];

                //Decision variable to determine the duration of the game
                System.out.println("Da li zelite da igrate ponovo? Da - 1, Ne - 2.");
                int var = scanner.nextInt();

                while(var != 1 && var != 2){
                    System.out.println("Los unos, probajte opet. Da - 1, Ne - 2.");
                    var = scanner.nextInt();
                }

                //If the value is 2 then break out of the program
                if(var == 2){
                    System.out.println("Hvala sto ste se igrali sa nama!");
                    break;
                }else
                    decision = true; //else continue the while loop
            }
                //rows for 1
        } while (!(matrix[0][0] == 1 && matrix[0][1] == 1 && matrix[0][2] == 1)
                && !(matrix[1][0] == 1 && matrix[1][1] == 1 && matrix[1][2] == 1)
                && !(matrix[2][0] == 1 && matrix[2][1] == 1 && matrix[2][2] == 1)
                //rows for 2
                && !(matrix[0][0] == 2 && matrix[0][1] == 2 && matrix[0][2] == 2)
                && !(matrix[1][0] == 2 && matrix[1][1] == 2 && matrix[1][2] == 2)
                && !(matrix[2][0] == 2 && matrix[2][1] == 2 && matrix[2][2] == 2)
                //columns for 1
                && !(matrix[0][0] == 1 && matrix[1][0] == 1 && matrix[2][0] == 1)
                && !(matrix[0][1] == 1 && matrix[1][1] == 1 && matrix[2][1] == 1)
                && !(matrix[0][2] == 1 && matrix[1][2] == 1 && matrix[2][2] == 1)
                //columns for 2
                && !(matrix[0][0] == 2 && matrix[1][0] == 2 && matrix[2][0] == 2)
                && !(matrix[0][1] == 2 && matrix[1][1] == 2 && matrix[2][1] == 2)
                && !(matrix[0][2] == 2 && matrix[1][2] == 2 && matrix[2][2] == 2)
                //main diagonal for 1
                && !(matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1)
                //main diagonal for 2
                && !(matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2)
                //other side diagonal for 1
                && !(matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1)
                //other side diagonal for 2
                && !(matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2)
                || decision);

    }
}