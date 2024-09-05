package exercises_sect1.E8_Bank_Vault;

import exercises_sect1.E8_Bank_Vault.bank.Manager;

public class Client {
    private final String NAME;
    private final String MONEY;

    Client(String NAME, String MONEY) {
        this.NAME = NAME;
        this.MONEY = MONEY;
    }

    public static void main(String[] args) {
        Client cliente = new Client("Jorge", "23.043");
        Client cliente2 = new Client("Luis", "2.033");
        Manager manager = new Manager(cliente, cliente.MONEY);

        System.out.println(manager.getClientMoney(cliente));
        System.out.println(manager.getClientMoney(cliente2));
    }
}
