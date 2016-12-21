package day.twelve.decoder;

import day.twelve.registry.Register;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 2016-12-12.
 */
public class Decoder {
    private static final String ALPHABET = "abcdefghijklmnoprstuwvxyz";
    private static boolean swallow = false;
    private static List<String> historyOfCommands = new ArrayList<>();
    private static List<Register> registerList = new ArrayList<>();

    private enum Commands {
        cpy, inc, dec, jnz
    }

    public static void solution(List<String> lines) {
        for (String line : lines) {
            decode(line);
        }
    }

    private static void decode(String line) {
        historyOfCommands.add(line);
        String[] executionSteps = line.split(" ");
        Commands command = Commands.valueOf(executionSteps[0]);
        System.out.println("executing : " + line);

        if (!swallow) {
            switch (command) {
                case cpy:
                    int value = Integer.parseInt(executionSteps[1]);
                    String copyToRegister = executionSteps[2];

                    if (!registerList.contains(copyToRegister)) {
                        Register register = new Register(copyToRegister);
                        register.setRegistryValue(value);
                        registerList.add(register);
                    } else {
                        for (Register register : registerList) {
                            if (register.getRegistryId().equals(copyToRegister)) {
                                register.setRegistryValue(value);
                            }
                        }
                    }
                    break;
                case inc:
                    String incrementInRegister = executionSteps[1];

                    for (Register register : registerList) {
                        if (register.getRegistryId().equals(incrementInRegister)) {
                            register.setRegistryValue(register.getRegistryValue() + 1);
                        }
                    }
                    break;
                case dec:
                    String decrementInRegister = executionSteps[1];

                    for (Register register : registerList) {
                        if (register.getRegistryId().equals(decrementInRegister)) {
                            register.setRegistryValue(register.getRegistryValue() - 1);
                        }
                    }
                    break;
                case jnz:
                    String registerA = executionSteps[1];
                    int forback = Integer.parseInt(executionSteps[2]);

                    if (!registerA.equals(null)) {
                        swallow = true;
                    }
            }
        }
    }

    public static int getResultFor(String reg) {
        int returnValue = 0;
        for (Register register : registerList) {
            if (register.getRegistryId().equals(reg)) {
                returnValue = register.getRegistryValue();
            }
        }
        return returnValue;
    }

}