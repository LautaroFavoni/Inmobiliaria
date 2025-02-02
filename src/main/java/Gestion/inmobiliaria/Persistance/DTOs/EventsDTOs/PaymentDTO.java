package Gestion.inmobiliaria.Persistance.DTOs.EventsDTOs;

import java.time.LocalDateTime;

public class PaymentDTO extends EventDTO {

    private LocalDateTime date;
    private String description;
    private boolean validada;

    private Double gastoBancario;
    private String gastoBancarioDescripcion;


    private Double litoralGas;
    private String litoralGasDescripcion;


    private Double alquiler;
    private String alquilerDescripcion;

    private Double expensas;
    private String expensasDescripcion;

    private Double tgi;
    private String tgiDescripcion;

    private Double api;
    private String apiDescripcion;

    private Double agua;
    private String aguaDescripcion;

    private Double epe;
    private String epeDescripcion;

    private Double seguro;
    private String seguroDescripcion;

    private Double honorarios;
    private String honorariosDescripcion;

    private Double sellados;
    private String selladosDescripcion;


    private Double actualizacionDeposito;
    private String actualizacionDepositoDescripcion;

    private Double deuda;
    private String deudaDescripcion;

    private Double aFavor;
    private String aFavorDescripcion;

    private Double otros;
    private String otrosDescripcion;

    // Getters y Setters
    public Double getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Double alquiler) {
        this.alquiler = alquiler;
    }

    public String getAlquilerDescripcion() {
        return alquilerDescripcion;
    }

    public void setAlquilerDescripcion(String alquilerDescripcion) {
        this.alquilerDescripcion = alquilerDescripcion;
    }

    public Double getExpensas() {
        return expensas;
    }

    public void setExpensas(Double expensas) {
        this.expensas = expensas;
    }

    public String getExpensasDescripcion() {
        return expensasDescripcion;
    }

    public void setExpensasDescripcion(String expensasDescripcion) {
        this.expensasDescripcion = expensasDescripcion;
    }

    public Double getTgi() {
        return tgi;
    }

    public void setTgi(Double tgi) {
        this.tgi = tgi;
    }

    public String getTgiDescripcion() {
        return tgiDescripcion;
    }

    public void setTgiDescripcion(String tgiDescripcion) {
        this.tgiDescripcion = tgiDescripcion;
    }

    public Double getApi() {
        return api;
    }

    public void setApi(Double api) {
        this.api = api;
    }

    public String getApiDescripcion() {
        return apiDescripcion;
    }

    public void setApiDescripcion(String apiDescripcion) {
        this.apiDescripcion = apiDescripcion;
    }

    public Double getAgua() {
        return agua;
    }

    public void setAgua(Double agua) {
        this.agua = agua;
    }

    public String getAguaDescripcion() {
        return aguaDescripcion;
    }

    public void setAguaDescripcion(String aguaDescripcion) {
        this.aguaDescripcion = aguaDescripcion;
    }

    public Double getEpe() {
        return epe;
    }

    public void setEpe(Double epe) {
        this.epe = epe;
    }

    public String getEpeDescripcion() {
        return epeDescripcion;
    }

    public void setEpeDescripcion(String epeDescripcion) {
        this.epeDescripcion = epeDescripcion;
    }

    public Double getSeguro() {
        return seguro;
    }

    public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

    public String getSeguroDescripcion() {
        return seguroDescripcion;
    }

    public void setSeguroDescripcion(String seguroDescripcion) {
        this.seguroDescripcion = seguroDescripcion;
    }

    public Double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(Double honorarios) {
        this.honorarios = honorarios;
    }

    public String getHonorariosDescripcion() {
        return honorariosDescripcion;
    }

    public void setHonorariosDescripcion(String honorariosDescripcion) {
        this.honorariosDescripcion = honorariosDescripcion;
    }

    public Double getSellados() {
        return sellados;
    }

    public void setSellados(Double sellados) {
        this.sellados = sellados;
    }

    public String getSelladosDescripcion() {
        return selladosDescripcion;
    }

    public void setSelladosDescripcion(String selladosDescripcion) {
        this.selladosDescripcion = selladosDescripcion;
    }

    public Double getActualizacionDeposito() {
        return actualizacionDeposito;
    }

    public void setActualizacionDeposito(Double actualizacionDeposito) {
        this.actualizacionDeposito = actualizacionDeposito;
    }

    public String getActualizacionDepositoDescripcion() {
        return actualizacionDepositoDescripcion;
    }

    public void setActualizacionDepositoDescripcion(String actualizacionDepositoDescripcion) {
        this.actualizacionDepositoDescripcion = actualizacionDepositoDescripcion;
    }

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }

    public String getDeudaDescripcion() {
        return deudaDescripcion;
    }

    public void setDeudaDescripcion(String deudaDescripcion) {
        this.deudaDescripcion = deudaDescripcion;
    }

    public Double getaFavor() {
        return aFavor;
    }

    public void setaFavor(Double aFavor) {
        this.aFavor = aFavor;
    }

    public String getaFavorDescripcion() {
        return aFavorDescripcion;
    }

    public void setaFavorDescripcion(String aFavorDescripcion) {
        this.aFavorDescripcion = aFavorDescripcion;
    }

    public Double getOtros() {
        return otros;
    }

    public void setOtros(Double otros) {
        this.otros = otros;
    }

    public String getOtrosDescripcion() {
        return otrosDescripcion;
    }

    public void setOtrosDescripcion(String otrosDescripcion) {
        this.otrosDescripcion = otrosDescripcion;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isValidada() {
        return validada;
    }

    @Override
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

    public Double getGastoBancario() {
        return gastoBancario;
    }

    public void setGastoBancario(Double gastoBancario) {
        this.gastoBancario = gastoBancario;
    }

    public String getGastoBancarioDescripcion() {
        return gastoBancarioDescripcion;
    }

    public void setGastoBancarioDescripcion(String gastoBancarioDescripcion) {
        this.gastoBancarioDescripcion = gastoBancarioDescripcion;
    }
}

