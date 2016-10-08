package com.tr.dojo;

import java.util.stream.IntStream;

/**
 * Hello world!
 *
 */
public class ProdutoEscalar {

    public int calcular(int[] a, int[] b) {
        
        if (a.length != b.length) {
            throw new VetoresTamanhosDiferentesException("Vetores devem ser do mesmo tamanho.");
        }
        
        return IntStream.range(0, a.length)
                        .map(n -> a[n] * b[n])
                        .sum();
    }
}

class VetoresTamanhosDiferentesException extends RuntimeException {

    private static final long serialVersionUID = 2928090351219347648L;

    public VetoresTamanhosDiferentesException() {
        super();
    }

    public VetoresTamanhosDiferentesException(String message) {
        super(message);
    }
}