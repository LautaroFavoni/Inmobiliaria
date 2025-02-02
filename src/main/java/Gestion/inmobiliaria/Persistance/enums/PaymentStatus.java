package Gestion.inmobiliaria.Persistance.enums;

public enum PaymentStatus {
    PENDIENTE_DE_PAGO,      // El pago aún no se ha realizado
    PENDIENTE_DE_APROBACION, // El pago se realizó, pero el comprobante está en revisión
    RECHAZADO,              // El comprobante fue rechazado
    APROBADO                // El comprobante fue aprobado y el pago está completo
}