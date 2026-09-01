# SpeedFast - Sistema de Gestión de Entregas (Semana 3)

Proyecto desarrollado en Java como parte de la actividad sumativa: **"Diseñando un sistema orientado a objetos con clases abstractas, polimorfismo e interfaces"**.

---

## 📌 Descripción del Proyecto
El sistema de **SpeedFast** gestiona de manera integral pedidos diferenciados por tipología (**Comida**, **Encomienda** y **Express**), aplicando reglas de negocio personalizadas para el cálculo de tiempos de entrega y la asignación de repartidores, desacoplando operaciones funcionales mediante interfaces estándar de POO.

---

## 🏗️ Arquitectura y Principios de POO Aplicados

### 1. Abstracción
* **`Pedido` (Clase Abstracta):** Centraliza los atributos compartidos (`id`, `cliente`, `direccion`, `repartidor`, `estado`, `historial`) y métodos comunes como `mostrarResumen()`.
* Define el contrato del método abstracto `calcularTiempoEntrega()`, delegando el cálculo a cada subclase según su modelo operativo.

### 2. Polimorfismo
* **Dinámico (Sobrescritura - `@Override`):**
    * `asignarRepartidor()`: Cada subclase implementa su propio criterio automático (e.g., mochila térmica para comida, furgón según peso para encomiendas, servicio flash para compras express).
    * `calcularTiempoEntrega()`: Retorna estimaciones ajustadas (15 min para Express, 35 min para Comida, 60/120 min para Encomiendas).
* **Estático (Sobrecarga):**
    * `asignarRepartidor(String nombre)`: Permite la asignación manual directa de un repartidor específico en cualquier tipo de pedido.

### 3. Interfaces y Desacoplamiento
Se implementaron interfaces funcionales para separar responsabilidades y favorecer la mantenibilidad:
* **`Despachable`:** Define la operación `despachar()`.
* **`Cancelable`:** Define la operación `cancelar()`.
* **`Rastreable`:** Define la operación `verHistorial()`.

---

## 📂 Estructura del Proyecto

```text
semana 3/
├── src/
│   ├── Cancelable.java          # Interfaz para cancelación de pedidos
│   ├── Despachable.java         # Interfaz para despacho de envíos
│   ├── Main.java                # Simulación y pruebas funcionales
│   ├── Pedido.java              # Clase abstracta base
│   ├── PedidoComida.java        # Subclase especializada en alimentos
│   ├── PedidoEncomienda.java    # Subclase especializada en paquetería/peso
│   ├── PedidoExpress.java       # Subclase especializada en entregas prioritarias
│   └── Rastreable.java          # Interfaz para auditoría e historial
└── README.md