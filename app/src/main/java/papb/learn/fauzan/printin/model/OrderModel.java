package papb.learn.fauzan.printin.model;

import java.util.Date;

public class OrderModel {
    private String tanggal;
    private String invoiceId;
    private String statusOrder;

    public OrderModel() {
    }

    public OrderModel(String invoiceId, String statusOrder,String tanggal) {
        this.tanggal = tanggal;
        this.invoiceId = invoiceId;
        this.statusOrder = statusOrder;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
