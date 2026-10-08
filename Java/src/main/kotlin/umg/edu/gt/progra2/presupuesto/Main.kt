package umg.edu.gt.progra2.presupuesto

import umg.edu.gt.progra2.presupuesto.datos.GastoRepositoryEnMemoria
import umg.edu.gt.progra2.presupuesto.modelo.Categoria
import umg.edu.gt.progra2.presupuesto.modelo.Movimiento
import umg.edu.gt.progra2.presupuesto.servicio.ControlGastos
import umg.edu.gt.progra2.presupuesto.servicio.PresupuestoService

fun main() {

    println("=== SISTEMA DE CONTROL DE PRESUPUESTO ===")

    val repository = GastoRepositoryEnMemoria()

    val controlGastos = ControlGastos(repository)
    val presupuestoService = PresupuestoService(repository)

    val movimiento1 = Movimiento(
        1,
        "Compra de comida",
        150.0,
        Categoria.ALIMENTACION,
        "07/10/2026"
    )

    val movimiento2 = Movimiento(
        2,
        "Pago de transporte",
        50.0,
        Categoria.TRANSPORTE,
        "07/10/2026"
    )

    val movimiento3 = Movimiento(
        3,
        "Compra de medicamentos",
        100.0,
        Categoria.SALUD,
        "07/10/2026"
    )

    val resultado1 = controlGastos.registrar(movimiento1)
    val resultado2 = controlGastos.registrar(movimiento2)
    val resultado3 = controlGastos.registrar(movimiento3)

    println(resultado1 ?: "Movimiento 1 registrado correctamente")
    println(resultado2 ?: "Movimiento 2 registrado correctamente")
    println(resultado3 ?: "Movimiento 3 registrado correctamente")

    println()
    println("=== MOVIMIENTOS REGISTRADOS ===")

    presupuestoService.listar().forEach { movimiento ->
        println(
            "ID: ${movimiento.id} | " +
                    "Descripcion: ${movimiento.descripcion} | " +
                    "Monto: Q${movimiento.monto} | " +
                    "Categoria: ${movimiento.categoria} | " +
                    "Fecha: ${movimiento.fecha}"
        )
    }

    println()
    println("=== TOTALES ===")

    println("Total general: Q${controlGastos.total()}")

    println(
        "Total alimentacion: Q${
            controlGastos.totalPorCategoria(Categoria.ALIMENTACION)
        }"
    )

    println(
        "Total transporte: Q${
            controlGastos.totalPorCategoria(Categoria.TRANSPORTE)
        }"
    )

    println()
    println("=== RESUMEN ===")
    println(controlGastos.resumen())
}