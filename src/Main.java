import java.util.Scanner;

class Matrix {
    protected int rows; // количество строк
    protected int cols; // количество столбцов
    protected int[][] data; // данные матрицы

    public Matrix() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Rows: ");
        int rows = scanner.nextInt();
        System.out.print("Columns: ");
        int cols = scanner.nextInt();

        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols];
    }

    // Функция ввода матрицы из консоли
    public void inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы матрицы размером " + rows + "x" + cols + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Элемент [" + i + "][" + j + "]: ");
                data[i][j] = scanner.nextInt();
            }
        }
    }

    // Функция вывода матрицы на консоль
    public void printToConsole() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class Matrix_plus extends Matrix {

    public float f(int x){
        return x*x*x-5;
    }

    public float f2(int x){
        return x*x*x+5;
    }

    public int Count_negative(){
        int k = 0;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (f(data[i][j]) < 0)
                    k = k + 1;

        return k;
    }

    public int Count_rows() {
        int sorted_rows = 0;
        boolean fl = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (data[i][j] > data[i][j+1])
                    fl = false;
            }
            if (fl)
                sorted_rows++;
            fl = true;
        }
        return sorted_rows;
    }
}

public class Main {

    public static void main(String[] args) {

        Matrix_plus matrix_A = new Matrix_plus(); // Матрица 3x3
        matrix_A.inputFromConsole();       // Ввод матрицы из консоли
        System.out.println("Матрица A:");
        matrix_A.printToConsole();         // Вывод матрицы на консоль

        Matrix_plus matrix_B = new Matrix_plus(); // Матрица 3x3
        matrix_B.inputFromConsole();       // Ввод матрицы из консоли
        System.out.println("Матрица B:");
        matrix_B.printToConsole();         // Вывод матрицы на консоль

        int count_A = matrix_A.Count_negative();
        int count_B = matrix_B.Count_negative();
        int sorted_rows;

        if (count_A < count_B) {
            System.out.println("В матрице B больше отрицательных значений функции");
            sorted_rows = matrix_B.Count_rows();
        }
        else {
            System.out.println("В матрице A больше отрицательных значений функции");
            sorted_rows = matrix_A.Count_rows();
        }
        System.out.println("Количество отсортированных строк: " + sorted_rows);



    }
}