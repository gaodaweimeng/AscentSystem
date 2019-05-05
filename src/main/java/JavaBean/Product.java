package JavaBean;

public class Product {
    private int id;
    private String productnumber;
    private String productname;
    private String categoryno;
    private String category;
    private String imagepath;
    private String isnewproduct;
    private float price1;
    private float price2;
    private String stock;
    private String realstock;
    private String cas;
    private String mdlint;
    private String formula;
    private String weight;
    private String note;
    private String delsoft;

    public Product() {
        super();

    }

    public Product(int id, String productnumber, String productname,
                   String categoryno, String category, String imagepath,
                   String isnewproduct, float price1, float price2, String stock,
                   String realstock, String cas, String mdlint, String formula,
                   String weight, String note, String delsoft) {
        super();
        this.id = id;
        this.productnumber = productnumber;
        this.productname = productname;
        this.categoryno = categoryno;
        this.category = category;
        this.imagepath = imagepath;
        this.isnewproduct = isnewproduct;
        this.price1 = price1;
        this.price2 = price2;
        this.stock = stock;
        this.realstock = realstock;
        this.cas = cas;
        this.mdlint = mdlint;
        this.formula = formula;
        this.weight = weight;
        this.note = note;
        this.delsoft = delsoft;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCategoryno() {
        return categoryno;
    }

    public void setCategoryno(String categoryno) {
        this.categoryno = categoryno;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getIsnewproduct() {
        return isnewproduct;
    }

    public void setIsnewproduct(String isnewproduct) {
        this.isnewproduct = isnewproduct;
    }

    public float getPrice1() {
        return price1;
    }

    public void setPrice1(float price1) {
        this.price1 = price1;
    }

    public float getPrice2() {
        return price2;
    }

    public void setPrice2(float price2) {
        this.price2 = price2;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getRealstock() {
        return realstock;
    }

    public void setRealstock(String realstock) {
        this.realstock = realstock;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getMdlint() {
        return mdlint;
    }

    public void setMdlint(String mdlint) {
        this.mdlint = mdlint;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDelsoft() {
        return delsoft;
    }

    public void setDelsoft(String delsoft) {
        this.delsoft = delsoft;
    }

}
