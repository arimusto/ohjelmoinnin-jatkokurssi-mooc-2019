
import java.util.ArrayList;
import static java.util.Arrays.stream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiivisetLuvut {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // testaa metodia täällä

        List<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(-7);
        lista.add(4);
        lista.add(5);
        lista.add(-6);
        
        List uusiLista = new ArrayList<Integer>(positiiviset(lista));

        System.out.println(uusiLista);

    }

    public static List<Integer> positiiviset(List<Integer> luvut) {

        List<Integer> palautettava = luvut.stream()
                .filter(luku -> luku >= 0)
                .collect(Collectors.toList());

        return palautettava;
    }

}
