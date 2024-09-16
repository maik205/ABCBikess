package ui;

import ui.routes.MainMenu;
import utils.Utils;

public class UIController {

    private final InputBuffer input = new InputBuffer();
    private final Router router = new Router(input);

    static {
        if ((System.getProperty("sun.arch.data.model")).equals("32")) {
            System.loadLibrary("keyhelper32");
        } else {
            System.loadLibrary("keyhelper");
        }
    }

    public void start() {
        router.navigate(new MainMenu(router));
        cycle();
        while (true) {
            if (kbHit()) {
                char c = getChar();

                input.addBuffer(c);
                input.set(c);
                cycle();
            }
        }
    }

    private void cycle() {
        Utils.clearConsole();
        System.out.println(this.router.renderRoute());
    }

    private native boolean kbHit();

    private native char getChar();
}
