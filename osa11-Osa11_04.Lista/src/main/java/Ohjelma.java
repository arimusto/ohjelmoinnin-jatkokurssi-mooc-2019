
public class Ohjelma {

    public static void main(String[] args) {
        // voit testata luokkaasi täällä
        Lista<String> lista = new Lista<>();
        System.out.println(lista.sisaltaa("hei"));
        lista.lisaa("hei");
        System.out.println(lista.sisaltaa("hei"));
        lista.poista("hei");
        System.out.println(lista.sisaltaa("hei"));
    }

}
