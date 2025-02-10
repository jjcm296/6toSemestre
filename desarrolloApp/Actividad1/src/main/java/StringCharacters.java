import java.util.Scanner;

public class StringCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un texto: ");
        String texto = scanner.nextLine();

        int espacios = 0;
        int vocales = 0;
        int consonantes = 0;

        EsVocal vocalA = new VocalA();
        EsVocal vocalE = new VocalE();
        EsVocal vocalI = new VocalI();
        EsVocal vocalO = new VocalO();
        EsVocal vocalU = new VocalU();

        vocalA.setSiguienteVocal(vocalE);
        vocalE.setSiguienteVocal(vocalI);
        vocalI.setSiguienteVocal(vocalO);
        vocalO.setSiguienteVocal(vocalU);

        for (char c : texto.toCharArray()) {
            if (Character.isWhitespace(c)) {
                espacios++;
            } else if (Character.isLetter(c)) {
                if (vocalA.esVocal(c)) {
                    vocales++;
                } else {
                    consonantes++;
                }
            }
        }

        System.out.println("Espacios: " + espacios);
        System.out.println("Vocales: " + vocales);
        System.out.println("Consonantes: " + consonantes);
    }
}

abstract class EsVocal {
    protected EsVocal siguienteVocal;

    public void setSiguienteVocal(EsVocal siguienteVocal) {
        this.siguienteVocal = siguienteVocal;
    }

    abstract boolean esVocal(char letra);
}

class VocalA extends EsVocal {
    @Override
    public boolean esVocal(char letra) {
        if ("aAáÁ".indexOf(letra) != -1) {
            return true;
        }
        return siguienteVocal != null && siguienteVocal.esVocal(letra);
    }
}

class VocalE extends EsVocal {
    @Override
    public boolean esVocal(char letra) {
        if ("eEéÉ".indexOf(letra) != -1) {
            return true;
        }
        return siguienteVocal != null && siguienteVocal.esVocal(letra);
    }
}

class VocalI extends EsVocal {
    @Override
    public boolean esVocal(char letra) {
        if ("iIíÍ".indexOf(letra) != -1) {
            return true;
        }
        return siguienteVocal != null && siguienteVocal.esVocal(letra);
    }
}

class VocalO extends EsVocal {
    @Override
    public boolean esVocal(char letra) {
        if ("oOóÓ".indexOf(letra) != -1) {
            return true;
        }
        return siguienteVocal != null && siguienteVocal.esVocal(letra);
    }
}

class VocalU extends EsVocal {
    @Override
    public boolean esVocal(char letra) {
        if ("uUúÚ".indexOf(letra) != -1) {
            return true;
        }
        return siguienteVocal != null && siguienteVocal.esVocal(letra);
    }
}