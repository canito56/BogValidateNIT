public class NITUtil {

    public boolean validateNIT(String NIT, boolean isPersonaFiscal){

        boolean isValid = false;

        if (isPersonaFiscal){

            if ( NIT.matches("[0-9]{10}") ){
                long[] numerosVerificadoresNITCorto = { 41, 37, 29, 23, 19, 17, 13, 7, 3 };
                isValid = IsValidNit(NIT, numerosVerificadoresNITCorto);
            }

        } else {
            if ( NIT.matches("[0-9]+") ){
                isValid = true;
            }
        }

        return isValid;
    }

    public boolean IsValidNit(String nit, long[] numerosVerificadoresNIT) {

        long digitoVerificador = 0;
        byte[] digitos = new byte[nit.length()];

        for (int i = 0; i < nit.length(); i++) {
            Character digit = nit.charAt(i);
            digitos[i] = Byte.valueOf(digit.toString());
        }

        for (int i = 0; i < (nit.length() - 1); i++) {
            digitoVerificador = digitoVerificador + ( numerosVerificadoresNIT[i] * digitos[i] );
        }

        digitoVerificador = (digitoVerificador % 11);

        if (digitoVerificador >= 2) {
            digitoVerificador = (11 - digitoVerificador);
        }

        return digitoVerificador == digitos[nit.length()-1];
    }

}
