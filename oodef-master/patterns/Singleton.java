package patterns;
import geral.Menu;

public class Singleton {

    private static Menu menu;

    private Singleton(){}

    public static Menu getInstance() {
        if(menu == null){
            menu = new Menu();
        }
        return menu;
    }
}