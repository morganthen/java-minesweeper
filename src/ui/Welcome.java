package ui;

import util.Color;

public class Welcome {

    public static void show() {
        System.out.println();
        System.out.println(Color.CYAN + "_|          _|  _|_|_|_|  _|          _|_|_|    _|_|    _|      _|  _|_|_|_|  "
                + Color.RESET);
        System.out.println(Color.CYAN + "_|          _|  _|        _|        _|        _|    _|  _|_|  _|_|  _|        "
                + Color.RESET);
        System.out.println(Color.CYAN + "_|    _|    _|  _|_|_|    _|        _|        _|    _|  _|  _|  _|  _|_|_|    "
                + Color.RESET);
        System.out.println(Color.CYAN + "  _|  _|  _|    _|        _|        _|        _|    _|  _|      _|  _|        "
                + Color.RESET);
        System.out.println(Color.CYAN + "    _|  _|      _|_|_|_|  _|_|_|_|    _|_|_|    _|_|    _|      _|  _|_|_|_|  "
                + Color.RESET);
        System.out.println("                                                                               ");
        System.out.println("                                                                               ");
        System.out.println(Color.CYAN + "                          _|_|_|_|_|    _|_|    " + Color.RESET);
        System.out.println(Color.CYAN + "                              _|      _|    _|  " + Color.RESET);
        System.out.println(Color.CYAN + "                              _|      _|    _|  " + Color.RESET);
        System.out.println(Color.CYAN + "                              _|      _|    _|  " + Color.RESET);
        System.out.println(Color.CYAN + "                              _|        _|_|    " + Color.RESET);
        System.out.println();
        System.out.println(
                Color.GREEN + "___  ________ _   _  _____ _____  _    _ _____ ___________ ___________" + Color.RESET);
        System.out.println(Color.GREEN + "|  \\/  |_   _| \\ | ||  ___/  ___|| |  | |  ___|  ___| ___ \\  ___| ___ \\"
                + Color.RESET);
        System.out.println(Color.GREEN + "| .  . | | | |  \\| || |__ \\ `--. | |  | | |__ | |__ | |_/ / |__ | |_/ /"
                + Color.RESET);
        System.out.println(Color.GREEN + "| |\\/| | | | | . ` ||  __| `--. \\| |/\\| |  __||  __||  __/|  __||    /"
                + Color.RESET);
        System.out.println(Color.GREEN + "| |  | |_| |_| |\\  || |___/\\__/ /\\  /\\  / |___| |___| |   | |___| |\\ \\"
                + Color.RESET);
        System.out.println(
                Color.GREEN + "\\_|  |_/\\___/\\_| \\_/\\____/\\____/  \\/  \\/\\____/\\____/\\_|   \\____/\\_| \\_|"
                        + Color.RESET);
        System.out.println();
        System.out.println(Color.GREEN.toString() + "LET'S PLAY!" + Color.RESET);
        System.out.println();
        System.out.println(Color.GREEN.toString() + "Select difficulty:" + Color.RESET);
        System.out.println();
        System.out.println(Color.CYAN + "Easy [1]");
        System.out.println("Medium [2]");
        System.out.println("Hard [3]" + Color.RESET);
        System.out.println();
    }

}
