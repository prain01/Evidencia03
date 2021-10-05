
import java.util.ArrayList;
import java.util.Arrays;

public class VendedorSopaipillas {

    Validaciones validar = new Validaciones();

    private final ArrayList<String> tamaños = new ArrayList<>(Arrays.asList("chica", "mediana", "grande", "extra grande"));
    private final ArrayList<Integer> precioTamaño = new ArrayList<>(Arrays.asList(150, 200, 300, 450));
    private final ArrayList<String> aderezos  = new ArrayList<>(Arrays.asList("mostaza", "ketchup", "mayonesa",
            "queso", "jamon", "palta", "promo queso/jamon", "promo palta/jamon"));
    private final ArrayList<Integer> precioAderezo = new ArrayList<>(Arrays.asList(50, 50, 100, 400, 250, 600, 600, 800));
    private int precioTotal;


    //METODOS PARA JUGAR CON CONSOLA
    public void pedirSopaipilla(){
        mostrarVuelto(calcularCostoSopaipilla());
    }

    public void mostrarVuelto(int vuelto){
        System.out.println("Su vuelto es: " + vuelto);
    }

    private int calcularVuelto(int precioTotal, int totalPagadoCliente){
        int vuelto = totalPagadoCliente - precioTotal;
        if(vuelto < 0){
            return -1;
        }else {
            return vuelto;
        }
    }

    public int calcularCostoSopaipilla() {
        int tamañoElegido = elegirTamaño();
        ArrayList<Integer> aderezosElegidos = elegirAderezo();
        int cuantoPagaCliente = conCuantoPagaCliente();
        return pedirSopaipillaInput(tamañoElegido, aderezosElegidos, cuantoPagaCliente);
    }

    private int pedirSopaipillaInput(int tamañoElegido, ArrayList<Integer> aderezosElegidos, int totalPagadoCliente){
        int precioTotal = 0;
        try {
            precioTotal += precioTamaño.get(tamañoElegido);
            for (Integer aderezosElegido : aderezosElegidos) {
                precioTotal += precioAderezo.get(aderezosElegido);
            }
        }catch (IndexOutOfBoundsException e1){
            e1.printStackTrace();
            return -1;
        }catch (Exception e2){
            e2.printStackTrace();
        }

        return calcularVuelto(precioTotal, totalPagadoCliente);
    }// INPUT CONSOLA

    private void mostrarPreciosTamaños(){
        System.out.println("*********************************************");
        System.out.println("*                  TAMAÑOS                  *");
        System.out.println("* [1] chica                         $ 150   *");
        System.out.println("* [2] mediana                       $ 200   *");
        System.out.println("* [3] grande                        $ 300   *");
        System.out.println("* [4] extra grande                  $ 450   *");
        System.out.println("*********************************************");
    }

    public int elegirTamaño(){
        System.out.println("Seleccione el tamaño");
        mostrarPreciosTamaños();
        int min = 1;
        int max = tamaños.size();
        return (validar.pedirNumeroLimitado(min, max) - 1);
    }

    public void mostrarPreciosAderezos(){
        System.out.println("*********************************************");
        System.out.println("*                  ADEREZOS                 *");
        System.out.println("* [1] mostaza                       $ 50    *");
        System.out.println("* [2] ketchup                       $ 50    *");
        System.out.println("* [3] mayonesa                      $ 100   *");
        System.out.println("* [4] queso                         $ 400   *");
        System.out.println("* [5] jamon                         $ 250   *");
        System.out.println("* [6] palta                         $ 600   *");
        System.out.println("* [7] promo queso/jamon             $ 600   *");
        System.out.println("* [8] promo palta/jamon             $ 800   *");
        System.out.println("* [0] ninguno/ninguno mas                   *");
        System.out.println("*********************************************");
    }

    public ArrayList<Integer> elegirAderezo(){
        ArrayList<Integer> aderezosElegidos= new ArrayList<>();
        System.out.println("Seleccione el aderezo");
        mostrarPreciosAderezos();
        int indice;
        int min = 0;
        int max = aderezos.size();
        do {
            indice = validar.pedirNumeroLimitado(min, max);
            if(indice > 0){
                aderezosElegidos.add(indice - 1);
            }
        }while (indice != 0);
        return aderezosElegidos;
    }

    public int conCuantoPagaCliente(){
        System.out.println("¿Con cuanto paga?");
        return validar.pedirNumero();
    }



    //METODOS PARA JUGAR EN PRUEBAS UNITARIAS
    public int pedirSopaipilla(String tamañoElegido, String[] aderezosElegidos, int totalPagadoCliente){
        try {
            precioTotal += precioArticulo(validarExistenciaArticulo(tamañoElegido, tamaños),precioTamaño);
            for (String aderezosElegido : aderezosElegidos) {
                precioTotal += precioArticulo(validarExistenciaArticulo(aderezosElegido, aderezos), precioAderezo);
            }
        }catch (IndexOutOfBoundsException e1){
            e1.printStackTrace();
            return -1;
        }catch (Exception e2){
            e2.printStackTrace();
        }

        return calcularVuelto(precioTotal, totalPagadoCliente);
    }// INSTANCIADO

    public int validarExistenciaArticulo(String articulo, ArrayList<String> listaArticulos){
        int indice = -1;
        for (int i = 0; i < listaArticulos.size(); i++) {
            if(articulo.equals(listaArticulos.get(i))){
                indice = listaArticulos.indexOf(i);
                break;
            }
        }
        return indice;
    }

    public int precioArticulo(int indiceArticulo, ArrayList<Integer> listaPrecios){
        int precio;
        try {
            precio = listaPrecios.get(indiceArticulo);
            return precio;
        }catch (IndexOutOfBoundsException e1){
            e1.printStackTrace();
            return 0;
        }catch (Exception e2){
            e2.printStackTrace();
            return 0;
        }
    }



}
