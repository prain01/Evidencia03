import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VendedorSopaipillasTest {

    VendedorSopaipillas miVendedor = new VendedorSopaipillas();

    @Test
    void pedirSopaipilla() {
        String tamaño = "mediana"; // 200
        String[] aderezos = {"mostaza","ketchup","mayonesa"};//50;50;100
        int totalPagadoCliente = 2000;
        int precioEsperado = totalPagadoCliente - (200 + 50 + 50 + 100);
        assertEquals(precioEsperado, miVendedor.pedirSopaipilla(tamaño,aderezos,totalPagadoCliente));
    }

    @Test
    void validarExistenciaArticulo() {
        ArrayList<String> tamaños = new ArrayList<>(Arrays.asList("chica", "mediana", "grande", "extra grande"));
        String tamaño = "mediana"; // 200
        int indiceEsperado = 1;
        assertEquals(indiceEsperado,miVendedor.validarExistenciaArticulo(tamaño,tamaños));
    }

    @Test
    void testPrecioArticulo1() {
        ArrayList<Integer> precioAderezo = new ArrayList<>(Arrays.asList(50, 50, 100, 400, 250, 600, 600, 800));
        int indice = 7;//"promo palta/jamon"--> $800
        int precioEsperado = 800;
        assertEquals(precioEsperado, miVendedor.precioArticulo(indice, precioAderezo));
    }

    @Test
    void testPrecioArticulo2() {
        ArrayList<Integer> precioAderezo = new ArrayList<>(Arrays.asList(50, 50, 100, 400, 250, 600, 600, 800));
        int indice = 9;
        int precioEsperado = 0;
        assertEquals(precioEsperado, miVendedor.precioArticulo(indice, precioAderezo));
    }

    @Test
    void testCalcularVuelto1(){
        int precioTotal = 4200;
        int totalPagadoCliente = 10000;
        int vueltoEsperado = totalPagadoCliente - precioTotal;
        assertEquals(vueltoEsperado, miVendedor.calcularVuelto(precioTotal,totalPagadoCliente));
    }

    @Test
    void testCalcularVuelto2(){
        int precioTotal = 4200;
        int totalPagadoCliente = 0;
        int vueltoEsperado = -1;
        assertEquals(vueltoEsperado, miVendedor.calcularVuelto(precioTotal,totalPagadoCliente));
    }

    @Test
    void testCalcularVuelto3(){
        int precioTotal = 0;
        int totalPagadoCliente = 0;
        int vueltoEsperado = 0;
        assertEquals(vueltoEsperado, miVendedor.calcularVuelto(precioTotal,totalPagadoCliente));
    }

}