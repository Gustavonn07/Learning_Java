package exercises_sect1.E8_Bank_Vault.bank;

import exercises_sect1.E8_Bank_Vault.Client;

public class Manager {
    private Client client;
    private final String MONEY;
    private final Vault VAULT;

    public Manager(Client client, String MONEY) {
        this.client = client;
        this.MONEY = MONEY;
        this.VAULT = new Vault(this.client, this.MONEY);
    }

    public String getClientMoney(Client clientKey) {
        return this.VAULT.getMoney(clientKey);
    }
}
