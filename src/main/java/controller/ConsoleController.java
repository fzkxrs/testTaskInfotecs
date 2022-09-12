package controller;

import model.UserData;
import view.Console;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleController {
    Console console = new Console();
    UserData userData = new UserData();
    ConnectionController connectionController;
    public void run() throws IOException {
        String input = "0";
        while (!input.equals("5")) {
            switch (input) {
                case "0": {
                    console.write("Input Login Password IP");
                    if (!fillConnectionData(console.read())) continue;
                    connectionController.establishConnection();
                }
                case "1": {

                }
                case "2": {

                }
                case "3": {

                }
                case "4": {

                }
            }
        }
    }

    public boolean fillConnectionData(String loginData) {
        List<String> userData = Arrays.asList(loginData.split(" "));
        if (userData.size() != 3) return false;
        String linuxUsernameRegex = "[a-z_][a-z0-9_-]*";
        String ipRegex = "\\b(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:(?:2([0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9]))\\b";
        Pattern isCorrectUsername = Pattern.compile(linuxUsernameRegex);
        Pattern isCorrectIp = Pattern.compile(ipRegex);
        Matcher isCorrectUsernameMatcher = isCorrectUsername.matcher(userData.get(0));
        Matcher isCorrectIpMatcher = isCorrectIp.matcher(userData.get(2));
        if (!isCorrectUsernameMatcher.find() || !isCorrectIpMatcher.find() ) return false;
        this.userData.setLogin(isCorrectUsernameMatcher.group());
        this.userData.setPassword(userData.get(1));
        connectionController = new ConnectionController(this.userData, "students.json", isCorrectIpMatcher.group(), 21);
        return true;
    }

}
