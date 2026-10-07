package umg.edu.gt.progra2.presupuesto.servicio

import umg.edu.gt.progra2.presupuesto.datos.GastoRepository
import umg.edu.gt.progra2.presupuesto.modelo.Categoria
import umg.edu.gt.progra2.presupuesto.modelo.Movimiento

class ControlGastos(
    private val repository: GastoRepository
) {

    fun registrar(movimiento: Movimiento): String? {
        if (movimiento.descripcion.isBlank()) {
            return "La descripción no puede estar vacía"
        }

        if (movimiento.monto <= 0) {
            return "El monto debe ser mayor que cero"
        }

        repository.guardar(movimiento)
        return null
    }

    fun total(): Double {
        return repository.listar().sumOf { it.monto }
    }

    fun totalPorCategoria(categoria: Categoria): Double {
        return repository.listar()
            .filter { it.categoria == categoria }
            .sumOf { it.monto }
    }

    fun resumen(): String {
        val movimientos = repository.listar()
        val total = movimientos.sumOf { it.monto }

        return "${movimientos.size} movimientos · Total: Q %.2f".format(total)
    }
}