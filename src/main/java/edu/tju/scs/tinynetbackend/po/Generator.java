package edu.tju.scs.tinynetbackend.po;

public class Generator {
    private Integer id;

    private String name;
    //额定功率（kW）
    private Double edgl;
    //最低负载率（%）
    private Double zdfzl;
    //最小运营时间（小时）
    private Double zxyysj;
    //寿命（h）
    private Double life;

    private String factory;
    //二氧化碳（g/L）
    private Double co2;
    //一氧化碳（g/L）
    private Double co;
    //未燃烧碳氢化合物（g/L），这里应该是wrstqhhw，原来xml里边写错了
    private Double wrsdqhhw;
    //颗粒物（g/L）
    private Double klw;
    //二氧化硫（g/L）
    private Double so2;
    //氮氧化物（g/L）
    private Double dyhw;
    //类型 柴油 汽油
    private String type;
    //功率曲线的点的个数，默认3
    private Integer glqxnum;
    //输出功率（kW）
    private Double scgl1;

    private Double scgl2;

    private Double scgl3;
    //燃料消耗（L/kW）
    private Double rlxh1;

    private Double rlxh2;

    private Double rlxh3;

    private Integer capacity1;

    private Integer capacity2;

    private Integer capacity3;

    private Integer capacity4;

    private Double cjcb1;

    private Double cjcb2;

    private Double cjcb3;

    private Double cjcb4;

    private Double gxcb1;

    private Double gxcb2;

    private Double gxcb3;

    private Double gxcb4;
    //运行维护成本（元/h）
    private Double yxwhcb1;

    private Double yxwhcb2;

    private Double yxwhcb3;

    private Double yxwhcb4;

    private String owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Double getEdgl() {
        return edgl;
    }

    public void setEdgl(Double edgl) {
        this.edgl = edgl;
    }

    public Double getZdfzl() {
        return zdfzl;
    }

    public void setZdfzl(Double zdfzl) {
        this.zdfzl = zdfzl;
    }

    public Double getZxyysj() {
        return zxyysj;
    }

    public void setZxyysj(Double zxyysj) {
        this.zxyysj = zxyysj;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public Double getWrsdqhhw() {
        return wrsdqhhw;
    }

    public void setWrsdqhhw(Double wrsdqhhw) {
        this.wrsdqhhw = wrsdqhhw;
    }

    public Double getKlw() {
        return klw;
    }

    public void setKlw(Double klw) {
        this.klw = klw;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public Double getDyhw() {
        return dyhw;
    }

    public void setDyhw(Double dyhw) {
        this.dyhw = dyhw;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getGlqxnum() {
        return glqxnum;
    }

    public void setGlqxnum(Integer glqxnum) {
        this.glqxnum = glqxnum;
    }

    public Double getScgl1() {
        return scgl1;
    }

    public void setScgl1(Double scgl1) {
        this.scgl1 = scgl1;
    }

    public Double getScgl2() {
        return scgl2;
    }

    public void setScgl2(Double scgl2) {
        this.scgl2 = scgl2;
    }

    public Double getScgl3() {
        return scgl3;
    }

    public void setScgl3(Double scgl3) {
        this.scgl3 = scgl3;
    }

    public Double getRlxh1() {
        return rlxh1;
    }

    public void setRlxh1(Double rlxh1) {
        this.rlxh1 = rlxh1;
    }

    public Double getRlxh2() {
        return rlxh2;
    }

    public void setRlxh2(Double rlxh2) {
        this.rlxh2 = rlxh2;
    }

    public Double getRlxh3() {
        return rlxh3;
    }

    public void setRlxh3(Double rlxh3) {
        this.rlxh3 = rlxh3;
    }

    public Integer getCapacity1() {
        return capacity1;
    }

    public void setCapacity1(Integer capacity1) {
        this.capacity1 = capacity1;
    }

    public Integer getCapacity2() {
        return capacity2;
    }

    public void setCapacity2(Integer capacity2) {
        this.capacity2 = capacity2;
    }

    public Integer getCapacity3() {
        return capacity3;
    }

    public void setCapacity3(Integer capacity3) {
        this.capacity3 = capacity3;
    }

    public Integer getCapacity4() {
        return capacity4;
    }

    public void setCapacity4(Integer capacity4) {
        this.capacity4 = capacity4;
    }

    public Double getCjcb1() {
        return cjcb1;
    }

    public void setCjcb1(Double cjcb1) {
        this.cjcb1 = cjcb1;
    }

    public Double getCjcb2() {
        return cjcb2;
    }

    public void setCjcb2(Double cjcb2) {
        this.cjcb2 = cjcb2;
    }

    public Double getCjcb3() {
        return cjcb3;
    }

    public void setCjcb3(Double cjcb3) {
        this.cjcb3 = cjcb3;
    }

    public Double getCjcb4() {
        return cjcb4;
    }

    public void setCjcb4(Double cjcb4) {
        this.cjcb4 = cjcb4;
    }

    public Double getGxcb1() {
        return gxcb1;
    }

    public void setGxcb1(Double gxcb1) {
        this.gxcb1 = gxcb1;
    }

    public Double getGxcb2() {
        return gxcb2;
    }

    public void setGxcb2(Double gxcb2) {
        this.gxcb2 = gxcb2;
    }

    public Double getGxcb3() {
        return gxcb3;
    }

    public void setGxcb3(Double gxcb3) {
        this.gxcb3 = gxcb3;
    }

    public Double getGxcb4() {
        return gxcb4;
    }

    public void setGxcb4(Double gxcb4) {
        this.gxcb4 = gxcb4;
    }

    public Double getYxwhcb1() {
        return yxwhcb1;
    }

    public void setYxwhcb1(Double yxwhcb1) {
        this.yxwhcb1 = yxwhcb1;
    }

    public Double getYxwhcb2() {
        return yxwhcb2;
    }

    public void setYxwhcb2(Double yxwhcb2) {
        this.yxwhcb2 = yxwhcb2;
    }

    public Double getYxwhcb3() {
        return yxwhcb3;
    }

    public void setYxwhcb3(Double yxwhcb3) {
        this.yxwhcb3 = yxwhcb3;
    }

    public Double getYxwhcb4() {
        return yxwhcb4;
    }

    public void setYxwhcb4(Double yxwhcb4) {
        this.yxwhcb4 = yxwhcb4;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}