package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import Gestion.inmobiliaria.Persistance.entities.Payment;

import java.util.Date;

public class PaymentDetailsForResponse {
    private Date date;
    private String description;
    private boolean validada;

    // Montos
    private double alquiler;
    private double expensas;
    private double tgi;
    private double api;
    private double agua;
    private double epe;
    private double seguro;
    private double honorarios;
    private double sellados;
    private double actualizacionDeposito;
    private double deuda;
    private double aFavor;
    private double otros;
    private double total; // Suma de todos menos aFavor

    private Double litoralGas;
    private String litoralGasDescripcion;

    // Descripciones
    private String alquilerDescripcion;
    private String expensasDescripcion;
    private String tgiDescripcion;
    private String apiDescripcion;
    private String aguaDescripcion;
    private String epeDescripcion;
    private String seguroDescripcion;
    private String honorariosDescripcion;
    private String selladosDescripcion;
    private String actualizacionDepositoDescripcion;
    private String deudaDescripcion;
    private String aFavorDescripcion;
    private String otrosDescripcion;

    // Constructor, getters y setters
    public PaymentDetailsForResponse(Payment payment) {
        this.litoralGas = payment.getLitoralGas();
        this.litoralGasDescripcion = payment.getLitoralGasDescripcion();
        this.date = payment.getDate();
        this.description = payment.getDescripcion();
        this.validada = payment.isValidada();
        this.alquiler = payment.getAlquiler();
        this.expensas = payment.getExpensas();
        this.tgi = payment.getTgi();
        this.api = payment.getApi();
        this.agua = payment.getAgua();
        this.epe = payment.getEpe();
        this.seguro = payment.getSeguro();
        this.honorarios = payment.getHonorarios();
        this.sellados = payment.getSellados();
        this.actualizacionDeposito = payment.getActualizacionDeposito();
        this.deuda = payment.getDeuda();
        this.aFavor = payment.getaFavor();
        this.otros = payment.getOtros();
        this.total = calcularTotal();

        this.alquilerDescripcion = payment.getAlquilerDescripcion();
        this.expensasDescripcion = payment.getExpensasDescripcion();
        this.tgiDescripcion = payment.getTgiDescripcion();
        this.apiDescripcion = payment.getApiDescripcion();
        this.aguaDescripcion = payment.getAguaDescripcion();
        this.epeDescripcion = payment.getEpeDescripcion();
        this.seguroDescripcion = payment.getSeguroDescripcion();
        this.honorariosDescripcion = payment.getHonorariosDescripcion();
        this.selladosDescripcion = payment.getSelladosDescripcion();
        this.actualizacionDepositoDescripcion = payment.getActualizacionDepositoDescripcion();
        this.deudaDescripcion = payment.getDeudaDescripcion();
        this.aFavorDescripcion = payment.getaFavorDescripcion();
        this.otrosDescripcion = payment.getOtrosDescripcion();
    }

    private double calcularTotal() {
        return alquiler + expensas + tgi + api + agua + epe + litoralGas +
                seguro + honorarios + sellados + actualizacionDeposito +
                deuda + otros - aFavor;
    }

    // Getters y Setters (Incluye montos y descripciones)
    public double getAlquiler() { return alquiler; }
    public void setAlquiler(double alquiler) { this.alquiler = alquiler; }
    public String getAlquilerDesc() { return alquilerDescripcion; }
    public void setAlquilerDesc(String alquilerDesc) { this.alquilerDescripcion = alquilerDesc; }

    public double getExpensas() { return expensas; }
    public void setExpensas(double expensas) { this.expensas = expensas; }
    public String getExpensasDesc() { return expensasDescripcion; }
    public void setExpensasDesc(String expensasDesc) { this.expensasDescripcion = expensasDesc; }

    public double getTgi() { return tgi; }
    public void setTgi(double tgi) { this.tgi = tgi; }
    public String getTgiDesc() { return tgiDescripcion; }
    public void setTgiDesc(String tgiDesc) { this.tgiDescripcion = tgiDesc; }

    public double getApi() { return api; }
    public void setApi(double api) { this.api = api; }
    public String getApiDesc() { return apiDescripcion; }
    public void setApiDesc(String apiDesc) { this.apiDescripcion = apiDesc; }

    public double getAgua() { return agua; }
    public void setAgua(double agua) { this.agua = agua; }
    public String getAguaDesc() { return aguaDescripcion; }
    public void setAguaDesc(String aguaDesc) { this.aguaDescripcion = aguaDesc; }

    public double getEpe() { return epe; }
    public void setEpe(double electricidad) { this.epe = electricidad; }
    public String getEpeDesc() { return epeDescripcion; }
    public void setEpeDesc(String electricidadDesc) { this.epeDescripcion = electricidadDesc; }

    public double getSeguro() { return seguro; }
    public void setSeguro(double seguro) { this.seguro = seguro; }
    public String getSeguroDesc() { return seguroDescripcion; }
    public void setSeguroDesc(String seguroDesc) { this.seguroDescripcion = seguroDesc; }

    public double getHonorarios() { return honorarios; }
    public void setHonorarios(double honorarios) { this.honorarios = honorarios; }
    public String getHonorariosDesc() { return honorariosDescripcion; }
    public void setHonorariosDesc(String honorariosDesc) { this.honorariosDescripcion = honorariosDesc; }

    public double getSellados() { return sellados; }
    public void setSellados(double sellados) { this.sellados = sellados; }
    public String getSelladosDesc() { return selladosDescripcion; }
    public void setSelladosDesc(String selladosDesc) { this.selladosDescripcion = selladosDesc; }

    public double getActualizacionDeposito() { return actualizacionDeposito; }
    public void setActualizacionDeposito(double actualizacionDeposito) { this.actualizacionDeposito = actualizacionDeposito; }
    public String getActualizacionDepositoDesc() { return actualizacionDepositoDescripcion; }
    public void setActualizacionDepositoDesc(String actualizacionDepositoDesc) { this.actualizacionDepositoDescripcion = actualizacionDepositoDesc; }

    public double getDeuda() { return deuda; }
    public void setDeuda(double deuda) { this.deuda = deuda; }
    public String getDeudaDesc() { return deudaDescripcion; }
    public void setDeudaDesc(String deudaDesc) { this.deudaDescripcion = deudaDesc; }

    public double getAFavor() { return aFavor; }
    public void setAFavor(double aFavor) { this.aFavor = aFavor; }
    public String getAFavorDesc() { return aFavorDescripcion; }
    public void setAFavorDesc(String aFavorDesc) { this.aFavorDescripcion = aFavorDesc; }

    public double getOtros() { return otros; }
    public void setOtros(double otros) { this.otros = otros; }
    public String getOtrosDesc() { return otrosDescripcion; }
    public void setOtrosDesc(String otrosDesc) { this.otrosDescripcion = otrosDesc; }

    public double getTotal() { return total; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public Double getLitoralGas() {
        return litoralGas;
    }

    public void setLitoralGas(Double litoralGas) {
        this.litoralGas = litoralGas;
    }

    public String getLitoralGasDescripcion() {
        return litoralGasDescripcion;
    }

    public void setLitoralGasDescripcion(String litoralGasDescripcion) {
        this.litoralGasDescripcion = litoralGasDescripcion;
    }
}
