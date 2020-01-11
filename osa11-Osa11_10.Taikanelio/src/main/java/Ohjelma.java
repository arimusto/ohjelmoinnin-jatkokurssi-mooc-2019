
public class Ohjelma {

    public static void main(String[] args) {
        // Testaa Taikanelio-luokkaasi täällä

        Taikaneliotehdas tt = new Taikaneliotehdas();
        Taikanelio testi = tt.luoTaikanelio(13);
        
        System.out.println(testi);
        System.out.println(testi.sarakkeidenSummat());
        System.out.println(testi.rivienSummat());
        System.out.println(testi.lavistajienSummat());
    }
}
