import java.util.Scanner;

public class Validaciones {
    // ESTE METODOS SON BASTANTE VIABLES AL QUERER VALIDAR EL INPUT DE LAS COORDENADAS DE CLASE "Tableros.java"

    public int pedirNumero(){
        Scanner teclado = new Scanner(System.in);
        int numero;
        do {
            try {
                numero = teclado.nextInt();
                break;
            } catch (Exception e){
                System.out.println("Indique un número y/o carácter válido");
                teclado.nextLine();
            }
        } while (true);
        return  numero;
    }

    public int pedirNumeroLimitado(int min, int max){
        System.out.println("Indique un numero (entre: " + min + " y " + max + ")");
        int num;
        do {
            num = pedirNumero();
            if(!limitesNumero(num, min, max)){
                System.out.println("Indique un número y/o carácter válido");
            }
        } while (!limitesNumero(num, min, max));
        return num;
    }

    public boolean limitesNumero(int num, int min ,int max) {
        return (min <= num && num <= max);
    }
}
