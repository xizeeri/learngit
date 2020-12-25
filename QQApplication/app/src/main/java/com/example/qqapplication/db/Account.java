package com.example.qqapplication.db;

import org.litepal.crud.LitePalSupport;

import java.util.Objects;

public class Account extends LitePalSupport {
    private String accountId;
    private String passwd;

    public String getId() {
        return accountId;
    }

    public void setId(String accountId) {
        this.accountId = accountId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) &&
                Objects.equals(passwd, account.passwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, passwd);
    }
}
