package umg.edu.gt.progra2.presupuesto.servicio

import umg.edu.gt.progra2.presupuesto.datos.GastoRepository
import umg.edu.gt.progra2.presupuesto.modelo.Movimiento

class PresupuestoService(
    private val repository: GastoRepository
) {

    fun registrar(movimiento: Movimiento) {
        repository.guardar(movimiento)
    }

    fun listar(): List<Movimiento> {
        return repository.listar()
    }
}