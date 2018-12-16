package com.example.simple.entity;

import com.yycdev.douyu.sdk.entity.ChatMsg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "danmu")
public class Danmu{


    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private int id;

    private Date time;
    private String uuid;
    private String cid;
    private String gid;
    private String rid;
    private String uid;
    private String nn;
    private String txt;
    private String level;
    private String gt;
    private String col;
    private String ct;
    private String rg;
    private String pg;
    private String cmt;
    private String ic;
    private String nl;
    private String nc;
    private String bnn;
    private String bl;
    private String brid;
    private String hc;
    private String ol;
    private String rev;
    private String hl;
    private String ifs;
    private String cst;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getBnn() {
        return bnn;
    }

    public void setBnn(String bnn) {
        this.bnn = bnn;
    }

    public String getBl() {
        return bl;
    }

    public void setBl(String bl) {
        this.bl = bl;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public String getHc() {
        return hc;
    }

    public void setHc(String hc) {
        this.hc = hc;
    }

    public String getOl() {
        return ol;
    }

    public void setOl(String ol) {
        this.ol = ol;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }

    public String getHl() {
        return hl;
    }

    public void setHl(String hl) {
        this.hl = hl;
    }

    public String getIfs() {
        return ifs;
    }

    public void setIfs(String ifs) {
        this.ifs = ifs;
    }

    public String getCst() {
        return cst;
    }

    public void setCst(String cst) {
        this.cst = cst;
    }


    public String toString() {
        return "ChatMsg{cid='" + this.cid + '\'' + ", gid='" + this.gid + '\'' + ", rid='" + this.rid + '\'' + ", uid='" + this.uid + '\'' + ", nn='" + this.nn + '\'' + ", txt='" + this.txt + '\'' + ", level='" + this.level + '\'' + ", gt='" + this.gt + '\'' + ", col='" + this.col + '\'' + ", ct='" + this.ct + '\'' + ", rg='" + this.rg + '\'' + ", pg='" + this.pg + '\'' + ", cmt='" + this.cmt + '\'' + ", ic='" + this.ic + '\'' + ", nl='" + this.nl + '\'' + ", nc='" + this.nc + '\'' + ", bnn='" + this.bnn + '\'' + ", bl='" + this.bl + '\'' + ", brid='" + this.brid + '\'' + ", hc='" + this.hc + '\'' + ", ol='" + this.ol + '\'' + ", rev='" + this.rev + '\'' + ", hl='" + this.hl + '\'' + ", ifs='" + this.ifs + '\'' + ", cst='" + this.cst + '\'' + '}';
    }

    public String toChatStr() {
        return String.format("%s: %s", this.nn, this.txt);
    }
}
