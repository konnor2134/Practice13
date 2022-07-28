package org.example.model;

import java.sql.Date;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredata;
    private Integer sal;
    private Integer comm;
    private Integer deptno;
    private String dname;
    private String loc;
    private Integer ets;

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredata,
               Integer sal, Integer comm, Integer deptno, String dname, String loc, Integer ets) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredata = hiredata;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
        this.ets = ets;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public Integer getMgr() {
        return mgr;
    }

    public Integer getEmpno() {
        return empno;
    }

    public String getEname() {
        return ename;
    }

    public String getJob() {
        return job;
    }

    public Date getHiredata() {
        return hiredata;
    }

    public Integer getSal() {
        return sal;
    }

    public Integer getComm() {
        return comm;
    }

    public String getDname() {
        return dname;
    }

    public String getLoc() {
        return loc;
    }

    public Integer getEts() {
        return ets;
    }


}
