package edu.tju.scs.tinynetbackend.domain;
//光伏
public class Photovoltaic {
    //主键,默认自增
    private Integer id;
    //型号名称
    private String name;
    //额定容量？？实际上这个数据只有0
    private Double edrl;
    //太阳能透过率（%）
    private Double tyntgl;
    //降噪因数
    private Double jeys;
    //光伏阵列的太阳能吸收率（%）
    private Double gfzltynxsl;
    //光伏发电效率（%）
    private Double gffdxl;
    //noct条件下的环境温度（℃）
    private Double noctwd;
    //温度系数（%/℃）
    private Double wdxs;
    //noct条件下的光照强度（kWh/m2/d），这两个变量，软件里写的是notc，数据库里边存的是noct
    private Double noctgz;
    //光伏板标准温度（℃）
    private Double gfbbzwd;
    //寿命（年）
    private Double life;
    //stc条件下的PV电池温度（℃）
    private Double stcwd;
    //制造商
    private String factory;
    //地面反射率（%）
    private Double dmfsl;
    //方位角（°）
    private Double fwj;
    //倾斜角（°）
    private Double qxj;
    //类型 0交流 1直流
    private Double type;
    //个数
    private Integer capacity1;

    private Integer capacity2;

    private Integer capacity3;

    private Integer capacity4;
    //初建成本
    private Double cjcb1;

    private Double cjcb2;

    private Double cjcb3;

    private Double cjcb4;
    //更新成本
    private Double gxcb1;

    private Double gxcb2;

    private Double gxcb3;

    private Double gxcb4;
    //运行维护成本（元/年）
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

    public Double getEdrl() {
        return edrl;
    }

    public void setEdrl(Double edrl) {
        this.edrl = edrl;
    }

    public Double getTyntgl() {
        return tyntgl;
    }

    public void setTyntgl(Double tyntgl) {
        this.tyntgl = tyntgl;
    }

    public Double getJeys() {
        return jeys;
    }

    public void setJeys(Double jeys) {
        this.jeys = jeys;
    }

    public Double getGfzltynxsl() {
        return gfzltynxsl;
    }

    public void setGfzltynxsl(Double gfzltynxsl) {
        this.gfzltynxsl = gfzltynxsl;
    }

    public Double getGffdxl() {
        return gffdxl;
    }

    public void setGffdxl(Double gffdxl) {
        this.gffdxl = gffdxl;
    }

    public Double getNoctwd() {
        return noctwd;
    }

    public void setNoctwd(Double noctwd) {
        this.noctwd = noctwd;
    }

    public Double getWdxs() {
        return wdxs;
    }

    public void setWdxs(Double wdxs) {
        this.wdxs = wdxs;
    }

    public Double getNoctgz() {
        return noctgz;
    }

    public void setNoctgz(Double noctgz) {
        this.noctgz = noctgz;
    }

    public Double getGfbbzwd() {
        return gfbbzwd;
    }

    public void setGfbbzwd(Double gfbbzwd) {
        this.gfbbzwd = gfbbzwd;
    }

    public Double getLife() {
        return life;
    }

    public void setLife(Double life) {
        this.life = life;
    }

    public Double getStcwd() {
        return stcwd;
    }

    public void setStcwd(Double stcwd) {
        this.stcwd = stcwd;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public Double getDmfsl() {
        return dmfsl;
    }

    public void setDmfsl(Double dmfsl) {
        this.dmfsl = dmfsl;
    }

    public Double getFwj() {
        return fwj;
    }

    public void setFwj(Double fwj) {
        this.fwj = fwj;
    }

    public Double getQxj() {
        return qxj;
    }

    public void setQxj(Double qxj) {
        this.qxj = qxj;
    }

    public Double getType() {
        return type;
    }

    public void setType(Double type) {
        this.type = type;
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