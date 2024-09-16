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
                // if ((int) c == 224) {
                // switch ((int) getChar()) {
                // case 80:
                // input.set('↓');
                // break;
                // case 72:
                // input.set('↑');
                // break;
                // case 75:
                // input.set('←');
                // break;
                // case 77:
                // input.set('→');
                // break;
                // default:
                // break;
                // }
                // cycle();
                // continue;
                // }
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
