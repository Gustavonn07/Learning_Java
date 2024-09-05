package exercises_sect1.E8_Bank_Vault.bank;

import exercises_sect1.E8_Bank_Vault.Client;

public class Vault {
    private Client client;
    private final String MONEY;

    protected Vault(Client client, String MONEY) {
        this.client = client;
        this.MONEY = MONEY;
    }

    protected String getMoney(Client clientKey) {
        if(this.client == clientKey) return "Valor disponivel: " + this.MONEY + " Reais";
        return "Cliente não encontrado.";
    }
}
