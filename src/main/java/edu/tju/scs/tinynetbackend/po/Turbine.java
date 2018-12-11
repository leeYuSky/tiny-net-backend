package edu.tju.scs.tinynetbackend.po;
//水轮机
public class Turbine {
    private Integer id;

    private String name;
    //额定水头？？（原界面写的是“净水头（m）”）
    private Double edst;
    //额定功率（kW)
    private Double edgl;
    //水轮机效率（%）
    private Double sljxl;
    //发电机效率（%）
    private Double fdjxl;

    private Double life;

    private String factory;

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

    public Double getEdst() {
        return edst;
    }

    public void setEdst(Double edst) {
        this.edst = edst;
    }

    public Double getEdgl() {
        return edgl;
    }

    public void setEdgl(Double edgl) {
        this.edgl = edgl;
    }

    public Double getSljxl() {
        return sljxl;
    }

    public void setSljxl(Double sljxl) {
        this.sljxl = sljxl;
    }

    public Double getFdjxl() {
        return fdjxl;
    }

    public void setFdjxl(Double fdjxl) {
        this.fdjxl = fdjxl;
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