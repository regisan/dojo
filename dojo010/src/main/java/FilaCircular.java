import java.util.NoSuchElementException;

/**
 * Evernote challenge - Question #1
 */
public class FilaCircular {

    private String[] buffer;
    int inicio = 0;
    int fim = -1;
    int quant = 0;

    public FilaCircular(int size) {
        buffer = new String[size];
    }

    public void append(String valor) {

        if (fim == buffer.length - 1) {
            fim = 0;
        } else {
            fim++;
        }

        if (fim == inicio) {
            if (inicio == buffer.length - 1) {
                inicio = 0;
            } else if (quant > 0) {
                inicio++;
            }
        }

        buffer[fim] = valor;

        if (quant != buffer.length)
            quant++;

    }

    public void remove(int qtdRemovida) {
        if (quant < qtdRemovida)
            throw new NoSuchElementException();

        for (int i = 0; i < qtdRemovida && quant >= 0; i++) {
            buffer[inicio] = null;

            if (inicio == buffer.length - 1)
                inicio = 0;
            else
                inicio++;

            quant--;
        }
    }

    public String[] list() {
        String[] resultado = new String[buffer.length];
        int copiaDoInicio = inicio;

        for (int i = 0; i < buffer.length; i++) {
            resultado[i] = buffer[copiaDoInicio];
            if (copiaDoInicio == buffer.length - 1)
                copiaDoInicio = 0;
            else
                copiaDoInicio++;
        }

        return resultado;
    }
}
