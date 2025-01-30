package Gestion.inmobiliaria.Persistance.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Payment extends Event {

        private Double alquiler;
        private String alquilerDescripcion;

        private Double expensas;
        private String expensasDescripcion;

        private Double tgi;
        private String tgiDescripcion;

        private Double litoralGas;
        private String litoralGasDescripcion;

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

        @Transient  // No se guarda en la base de datos
        private Double total;  // Total calculado en tiempo real

        // Getters y Setters
        public Double getTotal() {
            return (alquiler != null ? alquiler : 0) +
                    (expensas != null ? expensas : 0) +
                    (litoralGas != null ? litoralGas : 0)+
                    (tgi != null ? tgi : 0) +
                    (api != null ? api : 0) +
                    (agua != null ? agua : 0) +
                    (epe != null ? epe : 0) +
                    (seguro != null ? seguro : 0) +
                    (honorarios != null ? honorarios : 0) +
                    (sellados != null ? sellados : 0) +
                    (actualizacionDeposito != null ? actualizacionDeposito : 0) +
                    (deuda != null ? deuda : 0) +
                    (otros != null ? otros : 0) -
                    (aFavor != null ? aFavor : 0);
        }

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

        public void setEpeescripcion(String epeDescripcion) {
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

        public void setTotal(Double total) {
                this.total = total;
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

        public void setEpeDescripcion(String epeDescripcion) {
                this.epeDescripcion = epeDescripcion;
        }
}


