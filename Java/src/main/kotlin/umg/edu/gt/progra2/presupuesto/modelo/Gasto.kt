package umg.edu.gt.progra2.presupuesto.modelo

data class Gasto(
    val id: Int,
    val descripcion: String,
    val monto: Double,
    val categoria: Categoria,
    val fecha: String
)