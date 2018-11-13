package com.banku.loan.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "loan")
public class LoanEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "loanid")
    private int loanId;

    @Column(name = "documentclient")
    private int documentClient;

    @Column(name = "value")
    private long value;

    @Column(name = "codbank")
    private int codBank;

    @Column(name = "accounttype")
    private String accountType;

    @Column(name = "accountnumber")
    private long accountNumber;

    @Column(name = "enabled")
    private boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Bogota")
    @Column(name = "createDate")
    private Date createDate;

    public LoanEntity(int loanId, int value, int codBank, String accountType,
                      long accountNumber, boolean enabled, Date createDate) {
        super();
        this.loanId = loanId;
        this.value = value;
        this.codBank = codBank;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.enabled = enabled;
        this.createDate = createDate;
    }

    public LoanEntity() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getDocumentClient() {
        return documentClient;
    }

    public void setDocumentClient(int documentClient) {
        this.documentClient = documentClient;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getCodBank() {
        return codBank;
    }

    public void setCodBank(int codBank) {
        this.codBank = codBank;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @Override
    public String toString() {
        return "LoanEntity{" +
                "loanId=" + loanId +
                ", documentClient=" + documentClient +
                ", value=" + value +
                ", codBank=" + codBank +
                ", accountType='" + accountType + '\'' +
                ", accountNumber=" + accountNumber +
                ", enabled=" + enabled +
                ", createDate=" + createDate +
                '}';
    }
}
