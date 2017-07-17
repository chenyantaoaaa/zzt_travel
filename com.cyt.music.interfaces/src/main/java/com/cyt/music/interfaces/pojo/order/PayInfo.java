package com.cyt.music.interfaces.pojo.order;

import org.apache.commons.lang.StringUtils;

/**
 * Created by chen on 2017/7/16.
 */
public class PayInfo {
    private String amt;

    private String cc;

    private String item_name;

    private String st;

    private String tx;

    private String at;

    private String cmd;

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public static void main(String[] args) {
        String s = "SUCCESS\n" +
                "mc_gross=10.00\n" +
                "protection_eligibility=Eligible\n" +
                "address_status=confirmed\n" +
                "payer_id=4U6DNH96764NA";

    }
}
