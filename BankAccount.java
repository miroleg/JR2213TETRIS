package com.javarush.task.task17.task1720;

import java.math.BigDecimal;


public class BankAccount {
    private BigDecimal balance; //1.Переменная для баланса
    private String owner; //2. Переменная для имени владельца

    public BankAccount(String owner) { //3. Конструтор который выдаст значение баланса = 0 и owner
        this(BigDecimal.ZERO, owner);
    }

    public BankAccount(BigDecimal balance, String owner) { //4. Конструктор
        this.balance = balance;
        this.owner = owner;
    }

    public synchronized void  deposit(BigDecimal money) { //5. Метод депозит
        BigDecimal newBalance = balance.add(money); // Добавляет деньги на счет
        System.out.println("Добавляем " + money + ", на счету " + newBalance); // Выводит сообщение
        balance = newBalance; // присваивает новое состояние баланса
    }

    public synchronized void withdraw(BigDecimal money) throws NotEnoughMoneyException { //6. Метод снятия денег
       
        BigDecimal newBalance = balance.subtract(money); // subtract - операция вычитания. Значит
        // newBalance= balance-money;

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) throw new NotEnoughMoneyException();
        // compareTo метод сравнение, значит он сравнивает newBalance полученный выше с BigDecimal.ZERO,
        // НО как происходит сравнение и что это нам даст ?
        balance = newBalance; // присваивает новое состояние баланса
      
        System.out.println("Тратим " + money + ", на счету " + balance);
    }

    public void deposit(String money) {
        deposit(new BigDecimal(money));
    }

    public void withdraw(String money) throws NotEnoughMoneyException {
        withdraw(new BigDecimal(money));
    }
} 