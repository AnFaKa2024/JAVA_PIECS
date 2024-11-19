package org.piecs.Servico;

import org.piecs.Modelo.T_PIECS_BENEFICIARIOS;
import org.piecs.Modelo.T_PIECS_ENDERECO;
import org.piecs.Modelo.T_PIECS_MICRO_REGIAO;
import org.piecs.Modelo.T_PIECS_RESPONSAVEL;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidadorEntidades {

    T_PIECS_RESPONSAVEL responsavel;
    T_PIECS_ENDERECO endereco;
    T_PIECS_MICRO_REGIAO micro_regiao;
    T_PIECS_BENEFICIARIOS beneficiarios;

    public ValidadorEntidades(T_PIECS_RESPONSAVEL responsavel, T_PIECS_ENDERECO endereco, T_PIECS_MICRO_REGIAO micro_regiao, T_PIECS_BENEFICIARIOS beneficiarios) {
        this.responsavel = responsavel;
        this.endereco = endereco;
        this.micro_regiao = micro_regiao;
        this.beneficiarios = beneficiarios;
    }

    /*
    public static boolean validarLogin(Login login) {
        if (login == null) {
            System.out.println("Login inválido: objeto Login é nulo.");
            return false;
        }

        if (login.getEmail() == null || login.getEmail().isEmpty()) {
            System.out.println("Login inválido: o email não pode ser nulo ou vazio.");
            return false;
        }

        if (!EMAIL_PATTERN.matcher(login.getEmail()).matches()) {
            System.out.println("Login inválido: o formato do email é inválido.");
            return false;
        }

        if (login.getSenha() == null || login.getSenha().isEmpty()) {
            System.out.println("Login inválido: a senha não pode ser nula ou vazia.");
            return false;
        }

        if (login.getSenha().length() < 6) {
            System.out.println("Login inválido: a senha deve ter pelo menos 6 caracteres.");
            return false;
        }
        return false;
    }

    */

    public static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido. O nome não pode ser vazio.");
            return false;
        }
        return true;
    }

    public static boolean validarCpf(String cpf) {
        String cpfNumerico = cpf.replaceAll("[^\\d]", "");

        if (cpfNumerico.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
        }

        if (!isCpfValido(cpfNumerico)) {
            throw new IllegalArgumentException("CPF inválido. O CPF não é válido de acordo com o algoritmo.");
        }

        return true;
    }

    private static boolean isCpfValido(String cpf) {
        int soma = 0;
        int digito1, digito2;

        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int resto = soma % 11;
        digito1 = (resto < 2) ? 0 : 11 - resto;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        resto = soma % 11;
        digito2 = (resto < 2) ? 0 : 11 - resto;

        return (digito1 == Character.getNumericValue(cpf.charAt(9)) && digito2 == Character.getNumericValue(cpf.charAt(10)));
    }

    public static boolean validarCnpj(String cnpj) {
        String cnpjNumerico = cnpj.replaceAll("[^0-9]", "");
        if (cnpjNumerico.length() != 14) {
            System.out.println("CNPJ inválido. Deve conter 14 dígitos numéricos.");
            return false;
        }
        if (cnpjNumerico.matches("(\\d)\\1{13}")) {
            System.out.println("CNPJ inválido. Todos os dígitos não podem ser iguais.");
            return false;
        }

        try {
            int[] multiplicadores1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int soma = 0;
            for (int i = 0; i < 12; i++) {
                soma += Character.getNumericValue(cnpjNumerico.charAt(i)) * multiplicadores1[i];
            }
            int resto = soma % 11;
            int primeiroDigitoVerificador = (resto < 2) ? 0 : 11 - resto;

            int[] multiplicadores2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            soma = 0;
            for (int i = 0; i < 13; i++) {
                soma += Character.getNumericValue(cnpjNumerico.charAt(i)) * multiplicadores2[i];
            }
            resto = soma % 11;
            int segundoDigitoVerificador = (resto < 2) ? 0 : 11 - resto;

            if (primeiroDigitoVerificador != Character.getNumericValue(cnpjNumerico.charAt(12))
                    || segundoDigitoVerificador != Character.getNumericValue(cnpjNumerico.charAt(13))) {
                System.out.println("CNPJ inválido. Dígitos verificadores não correspondem.");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro ao validar CNPJ: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean validarDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            System.out.println("Data de nascimento inválida. Deve ser uma data anterior à data atual.");
            return false;
        }
        return true;
    }

    public static boolean validarEmail(String email) {
        if (!Pattern.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", email)) {
            System.out.println("Email inválido. O formato deve ser válido.");
            return false;
        }
        return true;
    }

    public static void validarSenha(String senha) {
        // Critérios de validação
        int minLength = 8; // Mínimo de 8 caracteres
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        if (senha.length() < minLength) {
            throw new IllegalArgumentException("A senha deve ter pelo menos " + minLength + " caracteres.");
        }

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        StringBuilder msgErro = new StringBuilder("A senha deve conter:");
        if (!hasUppercase) msgErro.append("\n- Pelo menos uma letra maiúscula.");
        if (!hasLowercase) msgErro.append("\n- Pelo menos uma letra minúscula.");
        if (!hasDigit) msgErro.append("\n- Pelo menos um dígito.");
        if (!hasSpecialChar) msgErro.append("\n- Pelo menos um caractere especial.");

        if (!hasUppercase || !hasLowercase || !hasDigit || !hasSpecialChar) {
            throw new IllegalArgumentException(msgErro.toString());
        }
    }

    public static boolean validarCep(String cep) {
        String cepNumerico = cep.replaceAll("[^\\d]", "");
        if (cepNumerico.length() != 8) {
            System.out.println("CEP inválido. Deve conter 8 dígitos numéricos.");
            return false;
        }
        return true;
    }

    public static boolean validarNumero(String numero) {
        if (!Pattern.matches("\\d+", numero)) {
            System.out.println("Número inválido. Deve conter apenas dígitos numéricos.");
            return false;
        }
        return true;
    }

    public static boolean validarEstado(String estado) {
        if (!Pattern.matches("[A-Z]{2}", estado.toUpperCase())) {
            System.out.println("Estado inválido. Deve conter duas letras maiúsculas.");
            return false;
        }
        return true;
    }




















}


